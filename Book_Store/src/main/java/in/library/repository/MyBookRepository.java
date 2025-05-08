package in.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.library.entity.MyBooks;

@Repository
public interface MyBookRepository extends JpaRepository<MyBooks, Long>{

}
