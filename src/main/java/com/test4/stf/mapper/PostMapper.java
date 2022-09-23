package com.test4.stf.mapper;

import java.util.List;

import com.test4.stf.domain.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity com.test4.stf.domain.Post
 */
public interface PostMapper extends BaseMapper<Post> {

    public List<Post> selectPostList(Post post);

    public Post selectPostById(Long id);

    public int insertPost(Post post);

    public int updatePost(Post post);

    public int deletePostById(Long id);
}


