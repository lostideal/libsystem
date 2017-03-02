package cn.powerdash.libsystem.book.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.powerdash.libsystem.book.domain.Bookinfo;
import cn.powerdash.libsystem.book.dto.BookSearchDto;
import cn.powerdash.libsystem.book.service.BookService;
import cn.powerdash.libsystem.common.dto.widget.DataTablesResponseDto;
import cn.powerdash.libsystem.common.util.EnumHelper;

@Transactional(value = "jpaTransactionManager")
@Service
public class BookServiceImpl implements BookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnumHelper.class);

    @Override
    public DataTablesResponseDto<Bookinfo> searchBook(BookSearchDto request) {
        LOGGER.info("BookService.searchBook");
        LOGGER.info("", this.toString());
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveBook(Bookinfo entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public Bookinfo findBookById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteBook(String id) {
        // TODO Auto-generated method stub

    }

}
