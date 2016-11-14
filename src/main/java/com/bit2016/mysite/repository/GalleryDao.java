package com.bit2016.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.mysite.vo.GalleryVo;

@Repository
public class GalleryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insert(GalleryVo vo) {
		sqlSession.insert("gallery.insert", vo);
	}
	
	public List<String> getList() {
		return sqlSession.selectList("gallery.select");
	}

}
