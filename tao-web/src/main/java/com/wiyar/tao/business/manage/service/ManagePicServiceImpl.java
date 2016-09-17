package com.wiyar.tao.business.manage.service;

import com.wiyar.tao.business.manage.dto.PicReqDto;
import com.wiyar.tao.dao.mapping.PicMapper;
import com.wiyar.tao.dao.model.Pic;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fuzhenglong on 16/9/16.
 */
@Service
public class ManagePicServiceImpl implements ManagePicService {

    @Autowired
    private PicMapper picMapper;

    @Override
    public List<Pic> getAllPicList() throws Exception {
        return picMapper.selectAll();
    }

    @Override
    public void addPic(PicReqDto dto) throws Exception {
        Pic pic = new Pic();
        BeanUtils.copyProperties(dto, pic);
        picMapper.insertSelective(pic);
    }

    @Override
    public void editPic(PicReqDto dto) throws Exception {
        Pic pic = new Pic();
        BeanUtils.copyProperties(dto, pic);
        picMapper.updateByPrimaryKeySelective(pic);
    }

    @Override
    public void removePic(Long id) throws Exception {
        picMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Pic getPicById(Long id) throws Exception {
        return picMapper.selectByPrimaryKey(id);
    }
}
