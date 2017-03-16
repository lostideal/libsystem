package cn.powerdash.libsystem.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.powerdash.libsystem.book.domain.Bookinfo;
import cn.powerdash.libsystem.book.domain.Bookstorage;

public interface BookstorageRepository extends JpaRepository<Bookstorage, String>, JpaSpecificationExecutor<Bookstorage>{

}
