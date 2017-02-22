package com.sixun.web.managerServlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sixun.entity.UserRecord;
import com.sixun.page.PageBean;
import com.sixun.util.StringUtils;

public class ManagerUserRecordServlet extends ManagerBaseServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		to = this.getServletContext().getContextPath()
				+ "/servlet/managerUserRecord?method=list";
		// ����������������
		request.setCharacterEncoding("UTF-8");

		// ��ȡ���ύ������urlЯ���Ĳ���
		String method = request.getParameter("method");
		System.out.println(method);

		if ("add".equals(method)) {
			UserRecord news = upload(request);
			System.out.println("�����Ϣ�ɹ���" + news);
			// �ض���
			if (!userRecordService.add(news)) {
				throw new RuntimeException("�����Ϣʧ��");
			}

			response.sendRedirect("/App/dangan.jsp");
		} else if ("update".equals(method)) {
			
			UserRecord userRecord = upload(request);
			System.out.println("�޸�userRecord��" + userRecord);
			if (!userRecordService.update(userRecord)) {
					
				throw new RuntimeException("�޸ĵ�����Ϣʧ��");
			}
			
		} else if ("delete".equals(method)) {
			String id = request.getParameter("id");

			if (!userRecordService.delete(id)) {
				throw new RuntimeException("ɾ��������Ϣʧ��");
			}
			;
			System.out.println("--ɾ���ɹ�------------");
		} else if ("list".equals(method)) {

			getUserRecord();
			getByPage(request);
			to = request
					.getRequestDispatcher("/sys/userRecord/userRecordList.jsp");
		} else if ("findById".equals(method)) {

			findById(request);

			to = request
					.getRequestDispatcher("/sys/userRecord/updateUserRecord.jsp");
		}
	}

	public void getUserRecord() {
		// ��ѯ��ϵ��Ϣ-----��Ҫ���浽context������У���Ϊ�õĵط��Ƚ϶࣬���Ҳ�ϵ��Ϣ�Ƚ���
		// �ȴ�������л�ȡ
		List<UserRecord> userRecord = (List<UserRecord>) this
				.getServletContext().getAttribute("userRecord");
		if (userRecord == null) {
			// �����ȡ������ȥ��ѯ
			userRecord = userRecordService.getByName(null);
			this.getServletContext().setAttribute("userRecord", userRecord);
		}
	}

	public void findById(HttpServletRequest request) {
		String id = request.getParameter("id");
		UserRecord userRecord = userRecordService.getById(id);
		request.setAttribute("userRecord", userRecord);
	}

	public void getByPage(HttpServletRequest request) {

		// ʹ�÷�ҳpageNow ʹ������realName userName
		String pageNow = request.getParameter("pageNow");
		String pageCount = request.getParameter("pageCount");
		String userName = request.getParameter("userName");
		// �ж�realName �� userName �Ƿ���Ҫ���浽session "name" ""
		HttpSession session = request.getSession();

		if (pageNow == null) {
			pageNow = (String) session.getAttribute("pageNow");
			System.out.println("pageNow" + pageNow);
		}

		if (pageCount == null) {
			pageCount = (String) session.getAttribute("pageCount");
			System.out.println("pageCount" + pageCount);
		}

		if (userName == null) {

			userName = (String) session.getAttribute("userName");
			System.out.println("userName" + userName);
		} else {
			session.setAttribute("userName", userName);
		}

		PageBean<UserRecord> pb = userRecordService.list(pageNow, userName);
		request.setAttribute("pb", pb);

		System.out.println("----------------��ҳ���--------------------");
		System.out.println(pb.getPageNow() + "  " + pb.getTotalRows());
		System.out.println(pb.getDatas());

	}

	/**
	 * �ϴ�ͼƬ �ϴ���Ϣ Ŀ��----------�õ�һ��News����
	 * 
	 * @param request
	 */
	private UserRecord upload(HttpServletRequest request) {

		// ����һ���ļ��ϴ����
		ServletFileUpload upload = new ServletFileUpload(
				new DiskFileItemFactory());

		upload.setFileSizeMax(1024 * 1024 * 3);
		upload.setSizeMax(1024 * 1024 * 8);
		upload.setHeaderEncoding("UTF-8");// ����ͼƬ��Ҫ������

		// �ж��Ƿ����ļ��ϴ���
		if (upload.isMultipartContent(request)) {
			// ����һ���޲ε�News����
			UserRecord userRecord = new UserRecord();
			try {
				List<FileItem> items = upload.parseRequest(request);
				System.out.println(items.size() + "------**********");
				for (FileItem item : items) {
					System.out.println(item + "  **************   "
							+ item.isFormField());
					// �ж��Ƿ����ļ��ϴ�input
					if (item.isFormField()) {
						System.out.println("------------");
						// ��ͨ����
						// ��ȡ�ֶ�����
						String fieldName = item.getFieldName();// foodName
						// ��ȡinput����������
						String value = item.getString("UTF-8");
						// input������name�����newsʵ�����������һ��
						System.out.println(fieldName + " " + value);
						BeanUtils.setProperty(userRecord, fieldName, value);
					} else {
						// �ļ��ϴ��� upload/ͼƬ����
						String imgName = item.getName();
						if (StringUtils.checkNull(imgName))
							return userRecord;

						System.out.println("�ļ����ƣ�" + imgName);

						InputStream is = item.getInputStream();

						File toFile = new File(this.getServletContext()
								.getRealPath("/upload"), imgName);

						if (!toFile.getParentFile().exists()) {
							toFile.getParentFile().mkdirs();
						}
						FileOutputStream os = new FileOutputStream(toFile);

						byte[] buffer = new byte[1024];
						int len = 0;
						while ((len = is.read(buffer)) != -1) {
							os.write(buffer, 0, len);
							os.flush();
						}

						os.close();
						is.close();
						System.out.println("�ϴ��ɹ�����");

						userRecord.setPhoto("upload/" + imgName);
					}

				}

				return userRecord;
			} catch (Exception e) {
				throw new RuntimeException("��װ�������");
			}

		}
		return null;

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
