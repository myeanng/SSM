package org.springmvc_demo.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


public class FileUploadController {

	private ServletContext servletContext;
	
	public void setServletContext(ServletContext context) {
		this.servletContext  = context;
	}
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public String handleUploadData(String name,@RequestParam("file") CommonsMultipartFile file) {

		if (!file.isEmpty()) {

			String path = this.servletContext.getRealPath("/tmp/"); // 获取本地存储路径
			String fileName = file.getName();
			String fileType = fileName.substring(fileName.lastIndexOf("."));
			File uploadFile = new File(path, new Date().getTime() + fileType); // 新建一个文件
			try {
				file.getFileItem().write(uploadFile); // 将上传的文件写入新建的文件中
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:upload_ok.jsp";
		} else {
			return "redirect:upload_error.jsp";
		}
	}
}
