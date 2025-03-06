package com.lzy12.controller;

import com.lzy12.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class TestController {
    @RequestMapping("/myThymeleaf")
    public String myThymeleaf(Map<String, Object> model) {
        /**
         * 里面的map对象将会被一起带到html中，所以可以在html访问这个map的对象
         *
         */
        model.put("user",new UserEntity("lzy12",22));
        ArrayList<UserEntity> entities = new ArrayList<>();
        entities.add(new UserEntity("lzy12A",18));
        entities.add(new UserEntity("lzy12B",16));
        model.put("usersList",entities);
        return "myThymeleaf";
    }
}
