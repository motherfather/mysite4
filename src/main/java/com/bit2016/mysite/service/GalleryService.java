package com.bit2016.mysite.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.mysite.repository.GalleryDao;
import com.bit2016.mysite.vo.GalleryVo;

@Service
public class GalleryService {
	private static final String SAVE_PATH = "/upload";
	
	@Autowired
	private GalleryDao galleryDao;
	
	public List<String> getList() {
		return galleryDao.getList();
	}
	
	public void insert(Long no, GalleryVo vo, MultipartFile multipartFile){
		String url = null;
		try {
		String orgFileName = multipartFile.getOriginalFilename();
		String fileExtName = orgFileName.substring(orgFileName.lastIndexOf('.')+1, orgFileName.length());
		String saveFileName = generateFileName(fileExtName);
		Long fileSize = multipartFile.getSize();

		writeFile(multipartFile, saveFileName);
		
		vo.setNo(no);
		vo.setOrgFileName(orgFileName);
		vo.setFileExtName(fileExtName);
		vo.setSaveFileName(saveFileName);
		vo.setFileSize(fileSize);

		galleryDao.insert(vo);
		
		} catch (IOException ex) {
			throw new RuntimeException();
		}
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
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		fileName += format.format(calendar.getTime());
		fileName += ('.' + fileExtName);
		return fileName;
	}
}
