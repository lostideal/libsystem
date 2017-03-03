package cn.powerdash.libsystem.book.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.powerdash.libsystem.book.domain.Bookinfo;
import cn.powerdash.libsystem.book.dto.BookSearchDto;
import cn.powerdash.libsystem.book.repository.BookRepository;
import cn.powerdash.libsystem.book.service.BookService;
import cn.powerdash.libsystem.common.dto.widget.DataTablesResponseDto;
import cn.powerdash.libsystem.common.util.EnumHelper;
import cn.powerdash.libsystem.common.util.HttpRequest;

@Transactional(value = "jpaTransactionManager")
@Service
public class BookServiceImpl implements BookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnumHelper.class);

    @Autowired
    BookRepository bookRepository;

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
    public Bookinfo findBookByIsbn13(String isbn13) {
        Bookinfo bookinfo = bookRepository.findBookByIsbn(isbn13);
        if (bookinfo == null) {
            bookinfo = getBookInfoFromDouban(isbn13);
        }
        bookinfo.toString();
        return bookinfo;
    }

    @Override
    public void deleteBook(String id) {
        // TODO Auto-generated method stub

    }

    private Bookinfo getBookInfoFromDouban(String isbn13) {
        String result = HttpRequest.sendHttpsGet("https://api.douban.com/v2/book/isbn", isbn13);
        LOGGER.info(result);

        Bookinfo bi = null;
        return bi;
    }
}
