package com.bit2016.mysite.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2016.mysite.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("")
	public String list(@RequestParam(value="kwd", required=true, defaultValue="") String keyword, 
			@RequestParam(value="p", required=true, defaultValue="1") Integer page, Model model) {
		Map<String, Object> map = boardService.getList(keyword, page);
		model.addAttribute("map", map);
		return "board/list";
	}
	
//	
//	@RequestMapping("/writeform")
//	public String insertform() {
//		return "board/write";
//	}
//	
//	@RequestMapping("/write")
//	public String insert(@ModelAttribute BoardVo vo) {
//		boardService.insert(vo);
//		return "redirect:/board";
//	}
//	
//	@RequestMapping("/delete")
//	public String delete(@ModelAttribute BoardVo vo) {
//		boardService.delete(vo);
//		return "redirect:board";
//	}
	
}
