package cn.powerdash.libsystem.book.service;

import cn.powerdash.libsystem.book.domain.Bookinfo;
import cn.powerdash.libsystem.book.domain.Bookstorage;
import cn.powerdash.libsystem.book.dto.BookSearchDto;
import cn.powerdash.libsystem.common.dto.widget.DataTablesResponseDto;

public interface BookService {

    DataTablesResponseDto<Bookinfo> searchBook(BookSearchDto request);

    Bookinfo saveBook(Bookinfo entity);

    Bookinfo findBookByIsbn13(String isbn13);

    void deleteBook(String id);

    Bookstorage addBook(Bookstorage entity);

	Bookstorage updateBook(Bookstorage entity);

}
