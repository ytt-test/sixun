package com.sixun.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sixun.entity.News;
import com.sixun.page.PageBean;
import com.sixun.util.StringUtils;

public class NewsServlet extends BaseServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		to = this.getServletContext().getContextPath()
				+ "/servlet/news?method=list";

		// 处理中文乱码问题
		request.setCharacterEncoding("UTF-8");

		// 获取表单提交过来的url携带的参数
		String method = request.getParameter("method");
		System.out.println(method);

		if ("add".equals(method)) {
			News news = upload(request);
			System.out.println("添加信息成功：" + news);
			// 重定向
			if (!newsService.addNews(news)) {
				throw new RuntimeException("添加信息失败");
			}
		} else if ("update".equals(method)) {
			
			News news = upload(request);
			System.out.println("修改news：" + news);
			if (!newsService.updateNews(news)) {
				
				throw new RuntimeException("修改档案信息失败");
			}
			
		} else if ("delete".equals(method)) {
			String id = request.getParameter("id");
			newsService.deleteNews(id);
		} else if ("findUser".equals(method)) {
			// 后台通过用户名查询news对象
			String userName = request.getParameter("userName");
			System.out.println("userName-----------" + userName);
			List<News> newList = newsService.getByName(userName);
			getByPage(request);
			request.setAttribute("newList", newList);
			System.out.println("有没有List" + newList);
			to = request.getRequestDispatcher("/sys/food/foodList.jsp");
		} else if ("list".equals(method)) {
			
			List<News> newList = newsService.getAllNews();
			System.out.println("在这里的servlet中的getByPage之前");
			getByPage(request);
			request.setAttribute("newList", newList);
			System.out.println("有没有List" + newList);
			to = request.getRequestDispatcher("/sys/food/foodList.jsp");
		} else if ("findById".equals(method)) {

			findById(request);

			to = request.getRequestDispatcher("/sys/food/updateFood.jsp");

		}
	}

	public void findById(HttpServletRequest request) {
		String id = request.getParameter("id");
		News news = newsService.getNewsById(id);
		request.setAttribute("news", news);
	}

	public void getByPage(HttpServletRequest request) {
		// 使用分页pageNow 使用条件typeName foodName
		String pageNow = request.getParameter("pageNow");
		String pageCount = request.getParameter("pageCount");
		// 判断typeName 和 foodName 是否需要保存到session "鸡" ""
		HttpSession session = request.getSession();
		if (pageNow == null) {
			pageNow = (String) session.getAttribute("pageNow");
			System.out.println("pageNow" + pageNow);
		}

		if (pageCount == null) {

			pageCount = (String) session.getAttribute("pageCount");
			System.out.println("pageCount" + pageCount);
		}

		PageBean<News> pb = newsService.listNews(pageNow, pageCount);

		System.out.println("----------------分页结果--------------------");
		System.out.println(pb.getPageNow() + "  " + pb.getTotalRows());
		System.out.println(pb.getDatas());
		
		request.setAttribute("pb", pb);

	}

	/**
	 * 上传图片 上传信息 目的----------得到一个News对象
	 * 
	 * @param request
	 */
	private News upload(HttpServletRequest request) {

		// 创建一个文件上传组件
		ServletFileUpload upload = new ServletFileUpload(
				new DiskFileItemFactory());

		upload.setFileSizeMax(1024 * 1024 * 3);
		upload.setSizeMax(1024 * 1024 * 8);
		upload.setHeaderEncoding("UTF-8");// 建议图片不要传中文

		// 判断是否是文件上传表单
		if (upload.isMultipartContent(request)) {
			// 创建一个无参的News对象
			News news = new News();
			try {
				List<FileItem> items = upload.parseRequest(request);
				System.out.println(items.size() + "------**********");
				for (FileItem item : items) {
					System.out.println(item + "  **************   "
							+ item.isFormField());
					// 判断是否是文件上传input
					if (item.isFormField()) {
						System.out.println("------------");
						// 普通表单项
						// 获取字段名称
						String fieldName = item.getFieldName();// foodName
						// 获取input输入框的内容
						String value = item.getString("UTF-8");
						// input输入框的name必须和news实体类的属性名一致
						System.out.println(fieldName + " " + value);
						BeanUtils.setProperty(news, fieldName, value);
					} else {
						// 文件上传项 upload/图片名称
						String imgName = item.getName();
						if (StringUtils.checkNull(imgName))
							return news;

						System.out.println("文件名称：" + imgName);

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
						System.out.println("上传成功！！");

						news.setPhoto("upload/" + imgName);
					}

				}

				return news;
			} catch (Exception e) {
				throw new RuntimeException("封装对象出错");
			}

		}
		return null;

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
