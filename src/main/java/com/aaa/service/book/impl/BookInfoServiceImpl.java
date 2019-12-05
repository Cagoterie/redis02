package com.aaa.service.book.impl;

import com.aaa.mapper.book.BookInfoMapper;
import com.aaa.model.BookInfo;
import com.aaa.service.book.BookInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qy105小仙女
 * @version 1.0
 * @Date 2019/10/30
 */

@Service
public class BookInfoServiceImpl implements BookInfoService {

    private static Logger logger = LoggerFactory.getLogger(BookInfoServiceImpl.class);
    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Override
    public List<BookInfo> queryBookInfo() {
        List<BookInfo> bookInfoList = bookInfoMapper.queryBookInfo();
        /*return bookInfoList;*/
        if (bookInfoList.size() > 0){
            logger.info("成功获取到图书信息");
            return bookInfoList;
        }else {
            logger.info("未获取到图书数据");
            return null;
        }
    }

    @Override
    public void addBookInfo(BookInfo bookInfo) {
        bookInfoMapper.addBookInfo(bookInfo);
    }

    @Override
    public void editBookInfo(BookInfo bookInfo) {
        bookInfoMapper.editBookInfo(bookInfo);
    }

    @Override
    public void deleteBookInfo(Long bookId) {
        bookInfoMapper.deleteBookInfo(bookId);
    }

    @Override
    public BookInfo queryBookInfoOne(Long bookId) {
        BookInfo bookInfo = bookInfoMapper.queryBookInfoOne(bookId);
        return bookInfo;
    }
}
