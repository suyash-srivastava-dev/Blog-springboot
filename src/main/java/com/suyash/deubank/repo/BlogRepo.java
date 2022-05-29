package com.suyash.deubank.repo;

import com.suyash.deubank.pojo.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepo extends CrudRepository<Blog,String> {
    Blog findByTitle(String blogName);

//    List<Blog> findAllByDateTimeByAsc();
}
