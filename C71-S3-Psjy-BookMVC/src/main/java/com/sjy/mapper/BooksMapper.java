package com.sjy.mapper;

import java.util.List;

import com.sjy.bean.Books;

public interface BooksMapper {
	/**
	 * 根据主键删除
	 * @param bookid
	 * @return
	 */
    int deleteByPrimaryKey(Integer bookid);

    /**
     * 根据条件添加
     * @param books
     * @return
     */
    int insertSelective(Books books);

    /**
     * 根据主键查找
     * @param bookid
     * @return
     */
    Books selectByPrimaryKey(Integer bookid);
    
    /**
     * 根据条件查找
     * @param books
     * @return
     */
    List<Books> selectByCondition(Books books);

    /**
     * 根据条件更新
     * @param books
     * @return
     */
    int updateByPrimaryKeySelective(Books books);

    /**
     * 根据主键更新
     * @param books
     * @return
     */
    int updateByPrimaryKey(Books books);
}