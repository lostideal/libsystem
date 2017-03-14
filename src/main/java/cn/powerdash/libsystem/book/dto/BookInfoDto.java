package cn.powerdash.libsystem.book.dto;

import java.io.Serializable;
import java.util.Date;

public class BookInfoDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String isbn13;
    private String isbn10;
    private String barcode;
    private String name;
    private String publish;
    private String publishDate;
    private String author;
    private String translator;
    private String classify;
    private String contentIntro;
    private String authorIntro;
    private double price;
    private int bindingType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getContentIntro() {
        return contentIntro;
    }

    public void setContentIntro(String contentIntro) {
        this.contentIntro = contentIntro;
    }

    public String getAuthorIntro() {
        return authorIntro;
    }

    public void setAuthorIntro(String authorIntro) {
        this.authorIntro = authorIntro;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBindingType() {
        return bindingType;
    }

    public void setBindingType(int bindingType) {
        this.bindingType = bindingType;
    }

    public interface CreateBookInfo {

    }
}
