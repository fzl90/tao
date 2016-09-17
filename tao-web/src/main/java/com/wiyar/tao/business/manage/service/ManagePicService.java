package com.wiyar.tao.business.manage.service;

import com.wiyar.tao.business.manage.dto.PicAddReqDto;
import com.wiyar.tao.dao.model.Pic;

import java.util.List;

/**
 * Created by fuzhenglong on 16/9/16.
 */
public interface ManagePicService {

    List<Pic> getAllPicList() throws Exception;

    void addPic(PicAddReqDto dto) throws Exception;


}
