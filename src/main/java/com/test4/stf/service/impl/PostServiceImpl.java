package com.test4.stf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test4.stf.domain.Post;
import com.test4.stf.service.PostService;
import com.test4.stf.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService{
    @Autowired
    private PostMapper postMapper;

    @Override
    public List<Post> selectPostList(Post post) {
        return postMapper.selectPostList(post);
    }
}




