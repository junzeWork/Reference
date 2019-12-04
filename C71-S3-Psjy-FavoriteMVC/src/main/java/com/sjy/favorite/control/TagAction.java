package com.sjy.favorite.control;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjy.favorite.bean.Tag;
import com.sjy.favorite.dao.TagMapper;
import com.sjy.favorite.util.MyBatisHelper;

@RestController
public class TagAction {
	
	@RequestMapping("toCloud")
	public List<Tag> toCloud() {
		return doFindAll();
	}
	
	@RequestMapping("findAll")
	public List<Tag> findAll() {
		return doFindAll();
	}
	
	public List<Tag> doFindAll() {
		SqlSession sess = MyBatisHelper.getSession();
		TagMapper tm = sess.getMapper(TagMapper.class);
		try {
			List<Tag> tList = tm.selectAll();
			return tList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sess.close();
		}
		return null;
	}
}
