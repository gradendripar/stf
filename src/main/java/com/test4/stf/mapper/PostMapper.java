package com.test4.stf.mapper;

import java.util.List;

import com.test4.stf.domain.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Entity com.test4.stf.domain.Post
 */
public interface PostMapper extends BaseMapper<Post> {

    public List<Post> selectPostList(Post post);

    List<Post> searchAllById(@Param("id") Long id);
}




