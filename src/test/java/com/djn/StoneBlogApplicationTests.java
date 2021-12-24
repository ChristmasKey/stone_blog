package com.djn;

import com.djn.pojo.Type;
import com.djn.service.TypeService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class StoneBlogApplicationTests {

    @Resource
    private TypeService typeService;

    @Test
    void contextLoads() {

        PageInfo<Type> allTypesByPage = typeService.findAllTypesByPage(2, 3);
        System.out.println(allTypesByPage);
    }

}
