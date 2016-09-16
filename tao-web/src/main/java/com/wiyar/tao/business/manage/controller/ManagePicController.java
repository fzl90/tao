package com.wiyar.tao.business.manage.controller;

import com.wiyar.tao.business.manage.dto.PicAddReqDto;
import com.wiyar.tao.business.manage.param.PicAddParam;
import com.wiyar.tao.business.manage.service.ManagePicService;
import com.wiyar.tao.framework.ResponseEntity;
import com.wiyar.tao.framework.WebApiBaseController;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by fuzhenglong on 16/9/16.
 */
@Controller
@RequestMapping(value = "/manage")
public class ManagePicController extends WebApiBaseController {

    @Autowired
    private ManagePicService managePicService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String gotoManage() {
        return "manage";
    }


    @RequestMapping(value = "/upload")
    public String upload(@RequestParam(value = "pic", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {

        System.out.println("开始");
        String path = request.getSession().getServletContext().getRealPath("pic");
        String fileName = file.getOriginalFilename();
//        String fileName = new Date().getTime()+".jpg";
        System.out.println(path);
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("fileUrl", request.getContextPath()+"/pic/"+fileName);

        return "result";
    }



    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addPic(PicAddParam param) throws Exception {

        PicAddReqDto dto = new PicAddReqDto();
        BeanUtils.copyProperties(param, dto);

        managePicService.addPic(dto);

        return ResponseEntity.success("图片添加成功");
    }


}
