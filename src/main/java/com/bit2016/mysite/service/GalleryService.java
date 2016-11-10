package com.bit2016.mysite.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.mysite.repository.GalleryDao;
import com.bit2016.mysite.vo.GalleryVo;

@Service
public class GalleryService {
	private static final String SAVE_PATH = "/upload";
	private static final String URL = "/gallery/assets/";
	@Autowired
	private GalleryDao galleryDao;
	
	public void insert(Long no, GalleryVo vo, MultipartFile multipartFile){
		String orgFileName = multipartFile.getOriginalFilename();
		String fileExtName = orgFileName.substring(orgFileName.lastIndexOf('.'), orgFileName.length());
		String saveFileName = generateFileName(fileExtName);
		Long fileSize = multipartFile.getSize();
		
		galleryDao.insert(map);
	}
	
	public void writeFile(MultipartFile multipartFile, String saveFileName) throws IOException {
		byte[] fileData = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
		fos.write(fileData);
		fos.close();
	}
	
	public String generateFileName(String fileExtName) {
		String fileName ="";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		fileName += format.format(calendar);
		fileName += ('.' + fileExtName);
		return fileName;
	}
}
