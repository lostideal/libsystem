package cn.powerdash.libsystem.book.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.powerdash.libsystem.book.domain.Bookinfo;
import cn.powerdash.libsystem.book.dto.BookSearchDto;
import cn.powerdash.libsystem.book.service.BookService;
import cn.powerdash.libsystem.common.dto.widget.DataTablesResponseDto;

@Transactional(value = "jpaTransactionManager")
@Service
public class BookServiceImpl implements BookService {

    @Override
    public DataTablesResponseDto<Bookinfo> searchBook(BookSearchDto request) {
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
