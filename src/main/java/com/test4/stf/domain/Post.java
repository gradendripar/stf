package com.test4.stf.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName post
 */
@Data
public class Post implements Serializable {
    /**
     * 帖子id
     */
    private Long id;

    /**
     * 帖子标题
     */
    private String title;

    /**
     * 帖子作者
     */
    private String author;

    /**
     * 帖子内容
     */
    private String content;

    /**
     * 帖子所属栏目
     */
    private String slug;

    /**
     * 帖子标签
     */
    private String tag;

    /**
     * 帖子发表时间
     */
    private Date created;

    /**
     * 帖子关闭状态（0为关闭，1为打开）
     */
    private String openStatus;

    /**
     * 帖子审核状态（0为未通过，1为通过）
     */
    private String verifyStatus;

    private static final long serialVersionUID = 1L;
}