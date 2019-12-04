package com.sjy.favorite.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sjy.favorite.bean.Tag;

public interface TagMapper {

	@Insert("insert into tag values(null,#{tName},#{tCount})")
	@Options(useGeneratedKeys=true,keyColumn="t_id",keyProperty="tId")//返回主键序列值
	int insert(Tag tag);
	
	//数据库中t_Name应该是唯一索引
	//返回的int 值就是成功修改的数据库的记录的行数
	@Update("update tag set t_count=t_count + 1 where t_name=#{tName} ")
	int update(String tag);
	
	@Results(id="baseMap",value={
		@Result(column="t_name",property="tName"),
		@Result(column="t_name",property="fList"
				,many=@Many(select="com.sjy.favorite.dao.FavoriteMapper.selectByTagName"))
	})
	@Select("select * from tag")
	List<Tag> selectAll();
}
