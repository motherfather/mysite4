package com.bit2016.mysite.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.mysite.repository.GalleryDao;

@Service
public class GalleryService {

	@Autowired
	private GalleryDao galleryDao;
	
	public void insert(Map map){
		MultipartFile multipartFile = null;
		String originalFileName = map.mf.getOriginalFilename();
//		String originalFileName = map.multipart
		galleryDao.insert(map);
	}
}
