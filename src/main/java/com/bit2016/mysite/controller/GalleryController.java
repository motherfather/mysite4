package com.bit2016.mysite.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.mysite.service.GalleryService;
import com.bit2016.mysite.vo.GalleryVo;
import com.bit2016.mysite.vo.UserVo;
import com.bit2016.security.Auth;
import com.bit2016.security.AuthUser;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
	
	@RequestMapping("")
	public String index() {
		return "gallery/index";
	}
	
	@Auth
	@RequestMapping("/form")
	public String form(@AuthUser UserVo authUser, Model model) {
		model.addAttribute("no", authUser.getNo());
		return "gallery/form";
	}
	
	@Auth
	@RequestMapping("/upload")
	public String upload(@RequestParam(value="no", required=true, defaultValue="") Long no, GalleryVo vo,
			@RequestParam(value="file") MultipartFile multipartFile) {
		galleryService.insert(no, vo, multipartFile);
		
		return "/gallery";
	}

}
