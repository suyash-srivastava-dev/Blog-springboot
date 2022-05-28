package com.suyash.deubank.controller;

import com.suyash.deubank.pojo.Blog;
import com.suyash.deubank.pojo.Employee;
import com.suyash.deubank.services.BlogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/api/blog")
public class BlogController {
    @Autowired
    private BlogServiceImpl blogService;

    @GetMapping("/list")
    public ResponseEntity<List<Blog>> getEmployee()
    {
        return ResponseEntity.ok().body(blogService.getBlog());
    }
    @PostMapping("/create")
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/v1/api/blog/create").toUriString());
        return ResponseEntity.created(uri).body(blogService.saveBlog(blog));
    }
    @PostMapping("/update")
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog)
    {
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/v1/api/blog/update").toUriString());
        return ResponseEntity.ok().body(blogService.saveBlog(blog));
    }
    @GetMapping("/listby")
    public ResponseEntity<List<Blog>> getBlogsByCreator(@RequestParam String creator)
    {
        return ResponseEntity.ok().body(blogService.getListOfBlogByCreator(creator));
    }
//    @GetMapping("/sortby")
//    public ResponseEntity<List<Blog>> getBlogSortedAsDateTime()
//    {
//        return ResponseEntity.ok().body(blogService.getListOfBlogSortedByDateTime());
//    }

}
