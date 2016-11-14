package com.bit2016.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String index(Model model) {
		model.addAttribute("list", galleryService.getList());
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
	public String upload(@RequestParam(value="no", required=true, defaultValue="") Long no, 
			@ModelAttribute GalleryVo vo,
			@RequestParam(value="file") MultipartFile file) {
		if (file.isEmpty() == true) {
			return "/gallery";
		}
		galleryService.insert(no, vo, file);
		return "redirect:/gallery";
	}

}
