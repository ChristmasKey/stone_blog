package com.djn;

import com.djn.pojo.Tag;
import com.djn.pojo.Type;
import com.djn.service.TagService;
import com.djn.service.TypeService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

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
}
