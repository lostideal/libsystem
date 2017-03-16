package cn.powerdash.libsystem.book.controller;

import javax.validation.groups.Default;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.powerdash.libsystem.book.domain.Bookinfo;
import cn.powerdash.libsystem.book.domain.Bookstorage;
import cn.powerdash.libsystem.book.dto.BookInfoDto;
import cn.powerdash.libsystem.book.dto.BookInfoDto.CreateBookInfo;
import cn.powerdash.libsystem.book.dto.BookSearchDto;
import cn.powerdash.libsystem.book.dto.BookstoraegeDto;
import cn.powerdash.libsystem.book.enums.EBookCagetory;
import cn.powerdash.libsystem.book.service.BookService;
import cn.powerdash.libsystem.common.constant.ApplicationConstant;
import cn.powerdash.libsystem.common.converter.ConverterService;
import cn.powerdash.libsystem.common.dto.ResultDto;
import cn.powerdash.libsystem.common.dto.ResultDtoFactory;
import cn.powerdash.libsystem.common.dto.annotation.OnValid;
import cn.powerdash.libsystem.common.dto.widget.DataTablesResponseDto;
import cn.powerdash.libsystem.common.enums.EErrorCode;
import cn.powerdash.libsystem.common.exception.BizServiceException;
import cn.powerdash.libsystem.common.util.EnumHelper;
import cn.powerdash.libsystem.common.util.web.WebUtil;

@Controller
public class BookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private transient BookService bookService;

    /**
     * Description: render home page
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String home(Model model) {
        LOGGER.info("BookController.home");
        model.addAttribute("categoryList", EnumHelper.inspectConstants(EBookCagetory.class));
        return "book/book_list";
    }

    /**
     * Description: search book list on the home page
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<DataTablesResponseDto<Bookinfo>> search(@RequestBody BookSearchDto request) {
        LOGGER.info("BookController.search");
        DataTablesResponseDto<Bookinfo> resp = bookService.searchBook(request);
        resp.setEcho(request.getEcho());
        return ResultDtoFactory.toAck(StringUtils.EMPTY, resp);
    }

    /**
     * Description: render add-book page
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String getAddPage(Model model) {
        LOGGER.info("BookController.getAddPage");
        model.addAttribute("categoryList", EnumHelper.inspectConstants(EBookCagetory.class));
        return "book/book_add";
    }

    /**
     * Description: add a book
     *
     * @param dto
     * @return
     */
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<String> add(
            @RequestBody @OnValid(value = { CreateBookInfo.class, Default.class }) BookstoraegeDto dto) {
        LOGGER.info("BookController.add");
        Bookstorage entity = ConverterService.convert(dto, Bookstorage.class);
        bookService.addBook(entity);
        return ResultDtoFactory.toRedirect(WebUtil.getFullUrlBasedOn(ApplicationConstant.GLOBAL_CONTEXT + "/books"));
    }

    /**
     * Description: render the detail page of a book
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/book/{isbn13}", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "isbn13") String isbn13, Model model) {
        LOGGER.info("BookController.detail");
        Bookinfo detail = bookService.findBookByIsbn13(isbn13);
        if (detail == null) {
            throw new BizServiceException(EErrorCode.PRODUCT_NOT_FOUND);
        }
        model.addAttribute("detail", detail);
        model.addAttribute("categoryList", EnumHelper.inspectConstants(EBookCagetory.class));
        return "book/book_detail";
    }

    /**
     * Description: update a book
     *
     * @param id
     * @param dto
     * @return
     */
    @RequestMapping(value = "/book/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<String> update(@PathVariable(value = "id") String id, @RequestBody @OnValid BookstoraegeDto dto) {
        LOGGER.info("BookController.update");
        Bookstorage entity = ConverterService.convert(dto, Bookstorage.class);
        entity.setId(Integer.getInteger(id));
        bookService.updateBook(entity);
        return ResultDtoFactory.toAck("successfully updated!");
    }

    /**
     * Description: delete a book
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResultDto<String> delete(@PathVariable("id") String id) {
        LOGGER.info("BookController.delete");
        bookService.deleteBook(id);
        return ResultDtoFactory.toAck("successfully deleted!");
    }
}
