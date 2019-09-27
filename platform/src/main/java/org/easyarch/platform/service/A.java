package org.easyarch.platform.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName A
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/26 下午11:22
 * @Version 1.0
 */
@RestController
public class A {
    @RequestMapping(value = "light")
    public String a(){
        System.out.println("222222");
        return "light";
    }
}
