package com.suyash.deubank.services;

import com.suyash.deubank.pojo.Blog;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    Blog saveBlog(Blog blog);
//    Optional<Blog> findByTitle(String blogName);
    List<Blog> getBlog();
//    List<Blog> getListOfBlogSortedByDateTime();
    List<Blog> getListOfBlogByCreator(String user);
}
