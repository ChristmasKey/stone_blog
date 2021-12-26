package com.djn;

import com.djn.pojo.Blog;
import com.djn.pojo.Tag;
import com.djn.pojo.Type;
import com.djn.service.BlogService;
import com.djn.service.TagService;
import com.djn.service.TypeService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
class StoneBlogApplicationTests {

    @Resource
    private TypeService typeService;

    @Resource
    private TagService tagService;

    @Test
    void contextLoads() {

        PageInfo<Type> allTypesByPage = typeService.findAllTypesByPage(2, 3);
        System.out.println(allTypesByPage);
    }

    @Test
    void testTagService() {
        for (int i = 0; i < 15; i++) {
            Tag tag = new Tag();
            tag.setName("tag"+(i+1));
            tagService.addTag(tag);
        }
    }

    @Resource
    private BlogService blogService;

    @Test
    void testBlog() {
        Blog blog = new Blog();
        System.out.println(blog.getRecommend());
        // System.out.println(blogService.countBlogByTitle("博客"));
        // for (int i = 3; i < 16; i++) {
        //     Blog blog = new Blog();
        //     blog.setTitle("博客"+i);
        //     blog.setContent("博客内容"+i);
        //     blog.setFirstImg("firstImg"+i);
        //     blog.setFlag("0");
        //     blog.setViews(0);
        //     blog.setAppreciation(true);
        //     blog.setShareStatement(true);
        //     blog.setCommentable(true);
        //     blog.setPublished(true);
        //     blog.setRecommend(true);
        //     blog.setCreateTime(new Date());
        //     blog.setUpdateTime(new Date());
        //     blog.setTypeId(1);
        //     blog.setUserId(1);
        //
        //     int res = blogService.addBlog(blog);
        //     System.out.println(res + "===" + blog.getId());
        // }
    }
}
