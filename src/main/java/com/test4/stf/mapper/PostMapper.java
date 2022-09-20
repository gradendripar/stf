package com.test4.stf.mapper;
import java.util.List;

import com.test4.stf.domain.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity com.test4.stf.domain.Post
 */
public interface PostMapper extends BaseMapper<Post> {

    List<Post> selectPostList();
}




