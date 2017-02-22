package com.sixun.web.userServlet;

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

public class UserRecordServlet extends UserBaseServlet {

	String path;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		path = this.getServletContext().getContextPath();
		// ����������������
		request.setCharacterEncoding("UTF-8");
			
		// ��ȡ���ύ������urlЯ���Ĳ���
		String method = request.getParameter("method");
		System.out.println(method);

		if ("add".equals(method)) {
			UserRecord userRecord = upload(request);
			System.out.println("�����Ϣ�ɹ���" + userRecord);
			// �ض���
			if (!userRecordService.add(userRecord)) {
				throw new RuntimeException("�����Ϣʧ��");
			}

			response.sendRedirect(path + "/App/dangan.jsp");
		} 
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
