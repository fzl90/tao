package com.wiyar.tao.business.manage.controller;

import com.wiyar.tao.business.constant.Category;
import com.wiyar.tao.business.constant.CategoryConstant;
import com.wiyar.tao.business.constant.SubCategory;
import com.wiyar.tao.business.manage.dto.PicReqDto;
import com.wiyar.tao.business.manage.param.ManagePicParam;
import com.wiyar.tao.business.manage.service.ManagePicService;
import com.wiyar.tao.dao.model.Pic;
import com.wiyar.tao.framework.ResponseEntity;
import com.wiyar.tao.framework.WebApiBaseController;
import com.wiyar.tao.util.CollectionUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by fuzhenglong on 16/9/16.
 */
@Controller
@RequestMapping(value = "/manage")
public class ManagePicController extends WebApiBaseController {

    @Autowired
    private ManagePicService managePicService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView gotoManage() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        List<Pic> list = this.managePicService.getAllPicList();
        List<List<Pic>> picList = CollectionUtil.split(list, 3);
        params.put("picList", picList);
        return new ModelAndView("mIndex", params);
    }

    @RequestMapping(value = "/goto/add", method = RequestMethod.GET)
    public ModelAndView gotoAdd() {

        Map<String, Object> params = new HashMap<String, Object>();

        //获取类别和子类别
        List<Category> categories = CategoryConstant.getCategories();
        List<SubCategory> subCategories = CategoryConstant.getSubCategories(1);
        params.put("categories", categories);
        params.put("subCategories", subCategories);

        return new ModelAndView("mAdd", params);
    }

    @RequestMapping(value = "/goto/edit", method = RequestMethod.GET)
    public ModelAndView gotoEdit(@RequestParam(value = "id") Long id) throws Exception {

        Map<String, Object> params = new HashMap<String, Object>();
        Pic pic = this.managePicService.getPicById(id);

        ManagePicParam managePicParam = new ManagePicParam();
        BeanUtils.copyProperties(pic, managePicParam);

        managePicParam.setDiyTimeStr(DateFormatUtils.format(new Timestamp(pic.getDiyTime().getTime()), "yyyy/MM/dd HH:mm"));

        //获取类别和子类别
        List<Category> categories = CategoryConstant.getCategories();
        List<SubCategory> subCategories = CategoryConstant.getSubCategories(pic.getCategory());
        params.put("categories", categories);
        params.put("subCategories", subCategories);

        params.put("pic", managePicParam);

        return new ModelAndView("mEdit", params);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<?> addPic(ManagePicParam param) throws Exception {

        PicReqDto dto = new PicReqDto();
        BeanUtils.copyProperties(param, dto);

        Assert.hasLength(param.getDiyTimeStr(),"先填写创作时间吧");

        Date date = DateUtils.parseDate(param.getDiyTimeStr(), "yyyy/MM/dd HH:mm");
        dto.setDiyTime(new Timestamp(date.getTime()));

        managePicService.addPic(dto);

        return ResponseEntity.success("");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<?> editPic(ManagePicParam param) throws Exception {

        PicReqDto dto = new PicReqDto();
        BeanUtils.copyProperties(param, dto);

        Date date = DateUtils.parseDate(param.getDiyTimeStr(), "yyyy/MM/dd HH:mm");
        dto.setDiyTime(new Timestamp(date.getTime()));

        managePicService.editPic(dto);

        return ResponseEntity.success("");
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<?> removePic(@RequestParam(value = "id") Long id) throws Exception {
        managePicService.removePic(id);
        return ResponseEntity.success("");
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<?> fileUpload(@RequestParam(value = "pic", required = false) MultipartFile file, HttpServletRequest request) throws Exception {


        String picPath = request.getServletContext().getRealPath("/pic");
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String targetFileName = uuid + suffix;

        File targetFile = new File(picPath, targetFileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.success(targetFileName);
    }

    @RequestMapping(value = "/subCategories", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<?> getSubCategories(@RequestParam(value = "category") Integer category) throws Exception {
        List<SubCategory> subCategories = CategoryConstant.getSubCategories(category);
        return ResponseEntity.success(subCategories);
    }

}
