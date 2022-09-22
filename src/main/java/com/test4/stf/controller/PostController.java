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
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/list")
    public AjaxResult selectPostList(Post post){
        System.out.println(post);
        return AjaxResult.success(postService.selectPostList(post));
    }
}
