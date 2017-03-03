package cn.powerdash.libsystem.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import cn.powerdash.libsystem.book.domain.Bookinfo;

public interface BookRepository extends JpaRepository<Bookinfo, String>, JpaSpecificationExecutor<Bookinfo> {

    @Query("select b from Bookinfo b where b.isbn13 = ?1")
    public Bookinfo findBookByIsbn(String isbn13);

}
