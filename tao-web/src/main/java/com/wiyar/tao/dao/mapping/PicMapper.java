package com.wiyar.tao.dao.mapping;

import com.wiyar.tao.dao.model.Pic;

/**
 * Created by fuzhenglong on 16/9/16.
 */
public interface PicMapper {

    Pic selectByPrimaryKey(Long id);

    void insertSelective(Pic pic);

}
