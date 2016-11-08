package com.bit2016.mysite.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2016.mysite.service.GuestbookService;
import com.bit2016.mysite.vo.GuestbookVo;

@Controller("guestbookAPIController")
@RequestMapping("/guestbook/api")
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	@ResponseBody
	@RequestMapping("/list")
	// Integer는 null로 받을 수 있기 때문에...!
	public Object list(@RequestParam(value="p", required=true, defaultValue="1") Integer page) {
		List<GuestbookVo> list = guestbookService.list(page);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("data", list);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/add")
	public Object insert(@ModelAttribute GuestbookVo vo) {
		GuestbookVo vo2 = guestbookService.insert2(vo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("data", vo2);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public Map<String, Object> delete(@ModelAttribute GuestbookVo vo) {
		boolean result = guestbookService.delete(vo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("data", result? vo.getNo():-1);
		return map;
	}
}