package com.wiyar.tao.business.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fuzhenglong on 16/9/11.
 */
@Controller
@RequestMapping("")
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getImages() {
        return "index";
    }

}
