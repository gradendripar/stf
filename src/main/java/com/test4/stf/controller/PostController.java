package com.test4.stf.controller;

import com.test4.stf.common.AjaxResult;
import com.test4.stf.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public AjaxResult selectPostList(){
        return AjaxResult.success(postService.selectPostList());
    }
}
