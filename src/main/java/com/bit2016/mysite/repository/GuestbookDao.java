package com.bit2016.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StopWatch;

import com.bit2016.mysite.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;

	public GuestbookVo get(Long no) {
		return sqlSession.selectOne("guestbook.getByNo", no);
	}

	public boolean delete(GuestbookVo vo) {
		int result = 0;
		result = sqlSession.delete("guestbook.delete", vo);
		return result == 1;
	}
	
	public Long insert(GuestbookVo vo) {
		sqlSession.insert("guestbook.insert", vo);
		return vo.getNo();
	}
	
	public List<GuestbookVo> getList() {
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		List<GuestbookVo> list = sqlSession.selectList("guestbook.getList");
		stopWatch.stop();
		
		System.out.println("[executionTime][GuestbookDao.getList]:" + stopWatch.getTotalTimeMillis() + " millis");
		return list;
	}
	
	public List<GuestbookVo> getList(Integer page) {
		return sqlSession.selectList("guestbook.getListByPage", page);
	}
	
}