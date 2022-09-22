package com.test4.stf.service;

import com.test4.stf.domain.Post;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface PostService extends IService<Post> {
    List<Post> selectPostList(Post post);

}
