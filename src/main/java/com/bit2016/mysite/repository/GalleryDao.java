package com.bit2016.mysite.repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GalleryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insert(Map map) {
		sqlSession.insert("gallery.insert", map);
	}

}
