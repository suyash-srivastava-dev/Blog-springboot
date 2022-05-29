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

import javax.websocket.server.PathParam;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/v1/api/blog")
public class BlogController {
    @Autowired
    private BlogServiceImpl blogService;

    @GetMapping("/list")
    public ResponseEntity<List<Blog>> getBlogs()
    {
        return ResponseEntity.ok().body(blogService.getBlog());
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/create")
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/v1/api/blog/create").toUriString());
        return ResponseEntity.created(uri).body(blogService.saveBlog(blog));
    }
    @PostMapping("/update/{title}")
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog, @PathVariable String title)
    {
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/v1/api/blog/update").toUriString());
        return ResponseEntity.ok().body(blogService.updateBlog(blog,title));
    }
    @GetMapping("/listby/{creator}")
    public ResponseEntity<List<Blog>> getBlogsByCreator(@PathVariable String creator)
    {
        return ResponseEntity.ok().body(blogService.getListOfBlogByCreator(creator));
    }
    @GetMapping("/listby-time/{value}")
    public ResponseEntity<List<Blog>> getBlogsByTime(@PathVariable boolean value)
    {
        return ResponseEntity.ok().body(blogService.getListOfBlogByTime(value));
    }
    @GetMapping("/findByTitle/{title}")
    public ResponseEntity<Blog> getBlogByTitle(@PathVariable String title)
    {
        return ResponseEntity.ok().body(blogService.findByTitle(title));
    }
    @GetMapping("/removeByTitle/{title}")
    public ResponseEntity<Blog> removeBlogByTitle(@PathVariable String title)
    {
        return ResponseEntity.ok().body(blogService.removeByTitle(title));
    }
    @GetMapping("/allCreator")
    public ResponseEntity<List<String>> getListOfCreator()
    {
        return ResponseEntity.ok().body(blogService.getListOfUser());
    }

}
