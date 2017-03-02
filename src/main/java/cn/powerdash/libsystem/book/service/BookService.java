package cn.powerdash.libsystem.book.service;

import cn.powerdash.libsystem.book.domain.Bookinfo;
import cn.powerdash.libsystem.book.dto.BookSearchDto;
import cn.powerdash.libsystem.common.dto.widget.DataTablesResponseDto;

public interface BookService {

    DataTablesResponseDto<Bookinfo> searchBook(BookSearchDto request);

    void saveBook(Bookinfo entity);

    Bookinfo findBookById(String id);

    void deleteBook(String id);

}
