package com.aaa.service.book;

import com.aaa.model.BookInfo;

import java.util.List;

/**
 * @author qy105小仙女
 * @version 1.0
 * @Date 2019/10/30
 */
public interface BookInfoService {

    /**
     * 查询图书信息
     * @return
     */
    List<BookInfo> queryBookInfo();

    /**
     * 添加图书信息
     * @param bookInfo
     */
    void addBookInfo(BookInfo bookInfo);

    /**
     * 修改图书信息
     * @param bookInfo
     */
    void editBookInfo(BookInfo bookInfo);

    /**
     * 删除图书信息
     * @param bookId
     */
    void deleteBookInfo(Long bookId);

    /**
     * 根据编号查询图书信息
     * @param bookId
     * @return
     */
    BookInfo queryBookInfoOne(Long bookId);
}
