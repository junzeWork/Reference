package com.sjy.favorite.control;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjy.favorite.bean.Favorite;
import com.sjy.favorite.biz.FavoriteBiz;
import com.sjy.favorite.dao.FavoriteMapper;
import com.sjy.favorite.util.MyBatisHelper;

@RestController
public class FavoriteAction {

	@RequestMapping("add")
	public int add(String fLabel,String fUrl,String fTags,String fDesc) {
		Favorite f = new Favorite();
		f.setfLabel(fLabel);
		f.setfTags(fTags);
		f.setfUrl(fUrl);
		f.setfDesc(fDesc);
		FavoriteBiz fbiz = new FavoriteBiz();
		int result = fbiz.addFavorite(f);

		return result;
	}
	
	@RequestMapping("findBynotTagName")
	public List<Favorite> findBynotTagName() {
		SqlSession sess = MyBatisHelper.getSession();
		FavoriteMapper fm = sess.getMapper(FavoriteMapper.class);
		try {
			List<Favorite> fList = fm.selectBynotTagName();
			return fList;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sess.close();
		}
		return null;
	}
	
	@RequestMapping("findByName")
	public List<Favorite> findByName(String fTags) {
		SqlSession sess = MyBatisHelper.getSession();
		FavoriteMapper fm = sess.getMapper(FavoriteMapper.class);
		try {
			List<Favorite> fList = fm.selectByTagName(fTags);
			return fList;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sess.close();
		}
		return null;
	}
	
	@RequestMapping("favFindAll")
	public List<Favorite> findAll(){
		SqlSession sess = MyBatisHelper.getSession();
		FavoriteMapper fm = sess.getMapper(FavoriteMapper.class);
		try {
			List<Favorite> fList = fm.selectAll();
			return fList;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sess.close();
		}
		return null;
	}
}
