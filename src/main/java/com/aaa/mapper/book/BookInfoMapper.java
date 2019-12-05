package com.aaa.mapper.book;

import com.aaa.model.BookInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.decorators.FifoCache;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qy105小仙女
 * @version 1.0
 * @Date 2019/10/30
 */
@Mapper
@Repository
@CacheNamespace(implementation = com.aaa.redis.RedisCache.class ,eviction = FifoCache.class)
public interface BookInfoMapper {

    /**
     * 查询图书信息
     * @return
     */
    @Select("select * from book_info")
    List<BookInfo> queryBookInfo();

    /**
     * 添加图书信息
     * @param bookInfo
     */
    @Insert("insert into book_info(book_name,book_store,book_price) value (#{bookName},#{bookStore},#{bookPrice})")
    void addBookInfo(BookInfo bookInfo);

    /**
     * 修改图书信息
     * @param bookInfo
     */
    @Update("update book_info set book_name = #{bookName},book_store = #{bookStore},book_price = #{bookPrice} where book_id = #{bookId}")
    void editBookInfo(BookInfo bookInfo);

    /**
     * 删除图书信息
     * @param bookId
     */
    @Delete("delete from book_info where book_id = #{bookId}")
    void deleteBookInfo(Long bookId);

    /**
     * 根据编号查询图书信息
     * @param bookId
     * @return
     */
    @Select("select * from book_info where book_id = #{bookId}")
    BookInfo queryBookInfoOne(Long bookId);

}
