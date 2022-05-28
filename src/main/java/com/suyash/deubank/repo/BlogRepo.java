package com.suyash.deubank.repo;

import com.suyash.deubank.pojo.Blog;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BlogRepo extends CrudRepository<Blog,String> {
//    Optional<Blog> findByIdTitle(String blogName);

//    List<Blog> findAllByDateTimeByAsc();
}
