package com.bit2016.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.mysite.repository.GuestbookDao;
import com.bit2016.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDao guestbookDao;
	
	public List<GuestbookVo> list() {
		return guestbookDao.getList();
	}
	
	public List<GuestbookVo> list(int page) {
		return guestbookDao.getList(page);
	}
	
	public void insert(GuestbookVo vo) {
		guestbookDao.insert(vo);
	}
	
	public GuestbookVo insert2(GuestbookVo vo) {
		Long no = guestbookDao.insert(vo);
		return guestbookDao.get(no);
	}
	
	public Long delete(GuestbookVo vo) {
		return guestbookDao.delete(vo);
	}
}
