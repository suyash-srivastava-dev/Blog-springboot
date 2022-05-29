package com.suyash.deubank.services;

import com.suyash.deubank.pojo.Blog;
import com.suyash.deubank.repo.BlogRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BlogServiceImpl implements BlogService {
    @Autowired
    private final BlogRepo blogRepo;
    @Override
    public Blog saveBlog(Blog blog) {
        log.info("Saving new user {}",blog);
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
//        blog.setId(uuidAsString);
        blog.setDateTime(LocalDateTime.now());
        return blogRepo.save(blog);
    }

    @Override
    public Blog updateBlog(Blog blog, String title) {
        log.info("Updating Blog{}",blog);

        blogRepo.delete(blogRepo.findByTitle(title));
        blogRepo.save(blog);
        blog.setDateTime(LocalDateTime.now());
        return blogRepo.save(blog);
    }

    @Override
    public Blog findByTitle(String blogName) {
        return blogRepo.findByTitle(blogName);
    }
    @Override
    public Blog removeByTitle(String blogName) {
        Blog blog=blogRepo.findByTitle(blogName);
        blogRepo.delete(blog);
        log.info("Removed Blog Success:{}",blogName);
        return blog;
    }

    @Override
    public List<Blog> getBlog() {
        return (List<Blog>) blogRepo.findAll();
    }
 @Override
    public List<Blog> getListOfBlogByCreator(String user) {
        List<Blog> listOfBlogs= (List<Blog>) blogRepo.findAll();
        List<Blog> listOfBlogByUser=new ArrayList<>();
        listOfBlogs.stream().forEach(blog -> {
           if(blog.getCreatedBy().equalsIgnoreCase(user))
            {
                listOfBlogByUser.add(blog);
            }
        });
           return listOfBlogByUser;
    }
    public List<Blog> getListOfBlogByTime(boolean order) {
        List<Blog> listOfBlogs= (List<Blog>) blogRepo.findAll();
                if(order) {
                 return listOfBlogs.stream()
                            .sorted(Comparator.comparing(Blog::getDateTime))
                            .collect(Collectors.toList());
                }
                else {
                  return   listOfBlogs.stream()
                            .sorted(Comparator.comparing(Blog::getDateTime).reversed())
                            .collect(Collectors.toList());
                }

    }
    public List<String> getListOfUser() {
        ArrayList<String> arrayList=new ArrayList<>();
        blogRepo.findAll().forEach(blog -> {
           if(! arrayList.contains(blog.getCreatedBy()))
            arrayList.add(blog.getCreatedBy());
        });
        return arrayList;
    }
}
