package com.wiyar.tao.business.manage.service;

import com.wiyar.tao.business.manage.dto.PicReqDto;
import com.wiyar.tao.dao.model.Pic;

import java.util.List;

/**
 * Created by fuzhenglong on 16/9/16.
 */
public interface ManagePicService {

    List<Pic> getAllPicList() throws Exception;

    void addPic(PicReqDto dto) throws Exception;

    void editPic(PicReqDto dto) throws Exception;

    void removePic(Long id) throws Exception;

    Pic getPicById(Long id) throws Exception;


}
