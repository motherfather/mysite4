package com.bit2016.mysite.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.mysite.repository.BoardDao;
import com.bit2016.mysite.vo.BoardVo;

@Service
public class BoardService {
	private static int PAGE_SIZE = 5;
	private static int LIST_SIZE = 5;
	
	@Autowired
	private BoardDao boardDao;
	
	public void insert(BoardVo vo) {
		boardDao.insert(vo);
	}
	
	public void delete(BoardVo vo) {
		boardDao.delete(vo.getNo(), vo.getUserNo());
	}
	
	public Map<String, Object> getList(String keyword, Integer page) {
		Map<String, Object> map = new HashMap<String, Object>();
		int totalCount = boardDao.getTotalCount(keyword);
		int totalPage = (int)Math.ceil((double)totalCount/PAGE_SIZE);
		int totalBlock = (int)Math.ceil((double)totalPage/LIST_SIZE);
		int currentPage = page;
		int currentBlock = totalBlock > 1 ? (int)Math.ceil((double)currentPage/5) : 1;
		int beginPage = currentBlock > 1 ? (currentBlock-1)*LIST_SIZE+1 : 1;
		int endPage = currentBlock*LIST_SIZE;
		int prevPage = currentBlock > 1 ? (currentBlock-1)*LIST_SIZE : 0;
		int nextPage = currentBlock < totalBlock ? (currentBlock*LIST_SIZE)+1 : 0 ;
		List<BoardVo> list = boardDao.getList(keyword, page, PAGE_SIZE);
		
		map.put("totalCount", totalCount);
		map.put("totalPage", totalPage);
		map.put("totalBlock", totalBlock);
		map.put("currentPage", page);
		map.put("currentBlock", currentBlock);
		map.put("listSize", LIST_SIZE);
		map.put("keyword", keyword);
		map.put("beginPage", beginPage);
		map.put("endPage", endPage);
		map.put("prevPage", prevPage);
		map.put("nextPage", nextPage);
		map.put("list", list);
		
		return map;
	}
}
