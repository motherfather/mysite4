package com.bit2016.mysite.service;

import java.util.List;

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
	
	public List<BoardVo> getList(String keyword, Integer page) {
		return boardDao.getList(keyword, page, LIST_SIZE);
	}
}
