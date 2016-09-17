package com.wiyar.tao.business.manage.controller;

import com.wiyar.tao.business.manage.dto.PicAddReqDto;
import com.wiyar.tao.business.manage.param.PicAddParam;
import com.wiyar.tao.business.manage.service.ManagePicService;
import com.wiyar.tao.dao.model.Pic;
import com.wiyar.tao.framework.ResponseEntity;
import com.wiyar.tao.framework.WebApiBaseController;
import com.wiyar.tao.util.CollectionUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public String gotoAdd() {
        return "mAdd";
    }

    @RequestMapping(value = "/goto/edit", method = RequestMethod.GET)
    public ModelAndView gotoEdit(@RequestParam(value = "id") Long id) throws Exception {

        Map<String, Object> params = new HashMap<String, Object>();
        Pic pic = this.managePicService.getPicById(id);
        params.put("pic",pic);

        return new ModelAndView("mEdit", params);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<?> fileUpload(@RequestParam(value = "pic", required = false) MultipartFile file, HttpServletRequest request) throws Exception {

        String path = request.getSession().getServletContext().getRealPath("pic");
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String targetFileName = uuid + suffix;

        File targetFile = new File(path, targetFileName);
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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<?> addPic(PicAddParam param) throws Exception {

        PicAddReqDto dto = new PicAddReqDto();
        BeanUtils.copyProperties(param, dto);

        Date date = DateUtils.parseDate(param.getDiyTimeStr(), "yyyy/MM/dd HH:mm");
        dto.setDiyTime(new Timestamp(date.getTime()));

        managePicService.addPic(dto);

        return null;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<?> removePic(@RequestParam(value = "id") Long id) throws Exception {

        managePicService.removePic(id);

        return null;
    }


}
