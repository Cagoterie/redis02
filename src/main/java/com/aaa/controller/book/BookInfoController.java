package com.aaa.controller.book;

import com.aaa.model.BookInfo;
import com.aaa.service.book.BookInfoService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author qy105小仙女
 * @version 1.0
 * @Date 2019/11/8
 */

@Controller
@RequestMapping("/book")
public class BookInfoController {

    private static Logger logger = LoggerFactory.getLogger(BookInfoController.class);
    @Autowired
    private BookInfoService bookInfoService;

    /**
     * 查询所有书籍信息
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/bookInfo")
    public String queryBookInfo(ModelMap modelMap)  {
        List<BookInfo> bookInfoList = bookInfoService.queryBookInfo();

        if (bookInfoList !=null && bookInfoList.size() > 0) {
            modelMap.addAttribute("bookList",bookInfoList);
        }else {
            modelMap.addAttribute("msg","目前没有书籍");
        }
        return "bookInfo";
    }

    /**
     * 添加图书信息
     * @param bookInfo
     * @throws IOException
     */
    @RequestMapping(value = "/bookInfoAdd")
    public String addBookInfo(BookInfo bookInfo,ModelMap modelMap) {
        bookInfoService.addBookInfo(bookInfo);
        List<BookInfo> bookInfoList = bookInfoService.queryBookInfo();
        modelMap.addAttribute("bookList",bookInfoList);
        return "bookInfo";
    }

    /**
     * 修改图书信息
     * @param httpServletResponse
     * @throws IOException
     */
    @RequestMapping(value = "/bookInfoEdit")
    @ResponseBody
    public void editBookInfo(BookInfo bookInfo, HttpServletResponse httpServletResponse) throws IOException {
        bookInfoService.editBookInfo(bookInfo);
        List<BookInfo> bookInfoList = bookInfoService.queryBookInfo();
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.getWriter().write(new Gson().toJson(bookInfoList));
    }

    /**
     * 删除图书信息
     * @throws IOException
     */
    @RequestMapping(value = "/bookInfoDelete")
    @ResponseBody
    public String deleteBookInfo() throws IOException {
        //Long bookId, HttpServletResponse httpServletResponse
        /*bookInfoService.deleteBookInfo(bookId);

        List<BookInfo> bookInfoList = bookInfoService.queryBookInfo();
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.getWriter().write(new Gson().toJson(bookInfoList));*/
        return "删除成功";
    }

    /**
     * 根据编号查找图书信息
     * @param bookId
     * @param httpServletResponse
     * @throws IOException
     */
    @RequestMapping(value = "/bookInfoQueryOne")
    @ResponseBody
    public void queryBookInfoOne(Long bookId, HttpServletResponse httpServletResponse) throws IOException {
        BookInfo bookInfo = bookInfoService.queryBookInfoOne(bookId);
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.getWriter().write(new Gson().toJson(bookInfo));
    }
}
