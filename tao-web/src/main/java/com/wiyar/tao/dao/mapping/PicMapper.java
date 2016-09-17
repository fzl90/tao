package com.wiyar.tao.dao.mapping;

import com.wiyar.tao.dao.model.Pic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fuzhenglong on 16/9/16.
 */
public interface PicMapper {

    Pic selectByPrimaryKey(Long id);

    void insertSelective(Pic pic);

    List<Pic> selectAll();

    void deleteByPrimaryKey(Long id);

}
