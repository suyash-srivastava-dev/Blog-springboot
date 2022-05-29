package com.suyash.deubank.services;

import com.suyash.deubank.pojo.Blog;

import java.util.List;

public interface BlogService {
    Blog saveBlog(Blog blog);

    Blog updateBlog(Blog blog, String title);

    Blog findByTitle(String blogName);

    Blog removeByTitle(String blogName);

    List<Blog> getBlog();
//    List<Blog> getListOfBlogSortedByDateTime();
    List<Blog> getListOfBlogByCreator(String user);
}
