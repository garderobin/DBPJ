package com.action.pin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;







//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;

public class FileAction extends ActionSupport{

	private static final long serialVersionUID = 1799354892803595092L;
	private File file; 
	private String filePath;
	private String fileFileName;

	@Transactional
	public String fileUpload() {
		//String path = ServletActionContext.getServletContext().getRealPath("/images/");
		String path = "/Users/jasmineliu/Development/Data/pinterest/";		
		File ff = new File(path); // ���������������������������,���������������������������������
		if (!ff.exists()) {
			ff.mkdir();
		}
		try {
			if (this.file != null) {
				File f = this.getFile();
				String fileName = java.util.UUID.randomUUID().toString(); // ������������+UUID���������������������
				String fileType = fileFileName.substring(fileFileName.lastIndexOf("."));
				String name = fileName + fileType;		
				BufferedImage image = ImageIO.read(f);				
				filePath = path + name;
//				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> fileType = " + fileType  +  "<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> filepath = " + filePath  +  "<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				ImageIO.write(image, fileType.substring(1), new File(filePath));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	

}
