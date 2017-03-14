package cn.powerdash.libsystem.book.service.impl;

import java.io.IOException;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    public Bookinfo saveBook(Bookinfo newBook) {
        // TODO Auto-generated method stub
        return bookRepository.save(newBook);

    }

    @Override
    public Bookinfo findBookByIsbn13(String isbn13) {
        Bookinfo bookinfo = bookRepository.findBookByIsbn(isbn13);
        if (bookinfo == null) {
            bookinfo = getBookInfoFromDouban(isbn13);
            saveBook(bookinfo);
        }

        return bookinfo;
    }

    @Override
    public void deleteBook(String id) {
        // TODO Auto-generated method stub

    }

    private Bookinfo getBookInfoFromDouban(String isbn13) {
        String result = HttpRequest.sendHttpsGet("https://api.douban.com/v2/book/isbn", isbn13);
        LOGGER.info(result);

        Bookinfo bi = JsonToBean(result);
        return bi;
    }

    private Bookinfo JsonToBean(String json) {
        // 解析json结果
        ObjectMapper mapper = new ObjectMapper();
        Bookinfo bi = new Bookinfo();
        JsonNode node = null;
        try {
            node = mapper.readTree(json);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        bi.setAuthor(hasSubNodes(node, "author"));
        bi.setAuthorIntro(node.path("author_intro").asText());
        bi.setBarcode(node.path("isbn13").asText());
        bi.setBindingType(node.path("binding").asText());
        bi.setClassify(hasSubNodes(node, "tags"));
        bi.setContentIntro(node.path("summary").asText());
        bi.setIsbn10(node.path("isbn10").asText());
        bi.setIsbn13(node.path("isbn13").asText());
        bi.setName(node.path("title").asText());
        String price = node.path("price").asText();
        price = price.substring(0, price.length() - 1);
        bi.setPrice(Double.valueOf(price));
        bi.setPublish(node.path("publisher").asText());
        bi.setPublishDate(node.path("pubdate").asText());
        bi.setTranslator(hasSubNodes(node, "translator"));
        // System.out.println("country_id:"+node.path("country_id").asText());
        //
        // JsonNode provinces = node.path("provinces");
        // for (JsonNode provinceElements : provinces) {
        // Iterator<String> provincesFields = provinceElements.fieldNames();
        // while (provincesFields.hasNext()) {
        // String fieldName = (String) provincesFields.next();
        // String province;
        // if ("name".equals(fieldName)) {
        // province = fieldName + ":" + provinceElements.path(fieldName).asText();
        // } else {
        // province = fieldName + ":" + provinceElements.path(fieldName).asInt();
        // }
        // System.out.println(province);
        // }
        // }
        return bi;

    }

    private String hasSubNodes(JsonNode node, String nodeName) {
        JsonNode nodes = node.path(nodeName);
        String str = "";
        int i = 0;
        for (JsonNode Elements : nodes) {
            if (i == 0) {
                str = Elements.asText();
            }

            Iterator<String> Fields = Elements.fieldNames();
            while (Fields.hasNext()) {
                String fieldName = (String) Fields.next();
                if ("name".equals(fieldName)) {
                    str = str + "," + Elements.path(fieldName).asText();
                }
            }

            i++;
        }
        if ("".equals(str)) {

        } else {
            if (",".equals(str.subSequence(0, 1))) {
                str = str.substring(1, str.length());
            }
        }

        return str;
    }

}
