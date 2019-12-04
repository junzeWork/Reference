package com.yc.favorite.dao;

import org.junit.Assert;
import org.junit.Test;

import com.sjy.favorite.bean.Favorite;
import com.sjy.favorite.biz.FavoriteBiz;

public class FavoriteBizTest {
	
	@Test
	public void testInsert() {
		FavoriteBiz biz=new FavoriteBiz();
		Favorite f=new Favorite();
		f.setfLabel("淘宝");
		f.setfUrl("www.taobao.com");
		f.setfTags("购物,剁手，娱乐");
		f.setfDesc("好网站");
		biz.addFavorite(f);
		Assert.assertNotNull(f.getfId());
	}
}
