package com.wiyar.tao.business.image.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fzl on 16/9/8.
 */
@Controller
@RequestMapping("/image")
public class ImageController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getImages() {
        return "image";
    }

}
