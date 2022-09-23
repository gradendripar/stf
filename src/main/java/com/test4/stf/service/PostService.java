package com.test4.stf.service;

import com.test4.stf.domain.Post;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface PostService extends IService<Post> {
    public List<Post> selectPostList(Post post);

    public Post selectPostById(Long id);

    public int insertPost(Post post);

    public int updatePost(Post post);

    public int deletePostById(Long id);
}
