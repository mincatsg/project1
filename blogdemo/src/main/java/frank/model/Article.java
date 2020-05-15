package frank.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class Article {

    private Long id;

    private Long userId;

    private String coverImage;

    private Integer categoryId;

    private Byte status;

    private String title;

    private String content;

    private Long viewCount;

    private Date createdAt;

    private Date updatedAt;

    /**
     * 页面需要使用的属性,自行添加.
     */
    private User author; //文章的作者

    private int commentCount;//文章的评论数

    private List<Comment> commentList;//评论列表
}