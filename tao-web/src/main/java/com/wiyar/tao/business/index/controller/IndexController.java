package com.wiyar.tao.business.index.controller;

import com.wiyar.tao.business.constant.CategoryConstant;
import com.wiyar.tao.business.constant.SubCategory;
import com.wiyar.tao.business.index.service.IndexPicService;
import com.wiyar.tao.dao.model.Pic;
import com.wiyar.tao.framework.ResponseEntity;
import com.wiyar.tao.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fuzhenglong on 16/9/11.
 */
@Controller
@RequestMapping("")
public class IndexController {

    @Autowired
    private IndexPicService indexPicService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getImages() {

        Map<String, Object> params = new HashMap<String, Object>();
        List<Pic> list = this.indexPicService.queryPicPage(0,10);
        params.put("picList", list);
        return new ModelAndView("index",params);
    }

    @RequestMapping(value = "/pics", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<?> getPicPage(@RequestParam(value = "pageIndex") Integer pageIndex, @RequestParam("pageNum") Integer pageNum) throws Exception {
        List<Pic> pics = indexPicService.queryPicPage(pageIndex, pageNum);
        return ResponseEntity.success(pics);
    }

}
