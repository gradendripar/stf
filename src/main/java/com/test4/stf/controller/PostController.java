package com.test4.stf.controller;

import com.test4.stf.common.AjaxResult;
import com.test4.stf.domain.Post;
import com.test4.stf.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * @date 2022/9/20 0:31:31
 * @author Gradendripar
 */
@RestController
@RequestMapping("/post")
public class PostController extends BaseController{
    @Autowired
    private PostService postService;

    @GetMapping("/list")
    public AjaxResult selectPostList(Post post){
        return AjaxResult.success(postService.selectPostList(post));
    }
    @GetMapping(value = "/{id}")
    public AjaxResult selectPostById(@PathVariable("id") Long id){
        return AjaxResult.success(postService.selectPostById(id));
    }
    @PutMapping
    public AjaxResult addPost(@RequestBody Post post){
        return toAjax(postService.insertPost(post));
    }
    @PostMapping
    public AjaxResult editPost(@RequestBody Post post){
        return toAjax(postService.updatePost(post));
    }
    @DeleteMapping(value = "/{id}")
    public AjaxResult remove(@PathVariable Long id){
        return toAjax(postService.deletePostById(id));
    }
}
