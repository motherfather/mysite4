package com.bit2016.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.mysite.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;

	public GuestbookVo get(Long no) {
		return sqlSession.selectOne("guestbook.getByNo", no);
	}

	public Long delete(GuestbookVo vo) {
		sqlSession.delete("guestbook.delete", vo);
		return vo.getNo();
	}
	
	public Long insert(GuestbookVo vo) {
		sqlSession.insert("guestbook.insert", vo);
		return vo.getNo();
	}
	
	public List<GuestbookVo> getList() {
		List<GuestbookVo> list = sqlSession.selectList("guestbook.getList");
		return list;
	}
	
	public List<GuestbookVo> getList(Integer page) {
		return sqlSession.selectList("guestbook.getListByPage", page);
	}
	
}