package com.wiyar.tao.business.index.service;

import com.wiyar.tao.dao.mapping.PicMapper;
import com.wiyar.tao.dao.model.Pic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fzl on 16/10/1.
 */
@Service
public class IndexPicServiceImpl implements IndexPicService {

    @Autowired
    private PicMapper picMapper;


    @Override
    public List<Pic> queryPicPage(Integer pageIndex, Integer pageNum) {
        Integer start = pageIndex * pageNum;
        List<Pic> pics = picMapper.selectPicPage(start, pageNum);
        return pics;
    }
}
