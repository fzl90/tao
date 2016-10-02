package com.wiyar.tao.dao.mapping;

import com.wiyar.tao.dao.model.Pic;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by fuzhenglong on 16/9/16.
 */
public interface PicMapper {

    Pic selectByPrimaryKey(Long id);

    void insertSelective(Pic pic);

    void updateByPrimaryKeySelective(Pic pic);

    List<Pic> selectAll();

    void deleteByPrimaryKey(Long id);

    List<Pic> selectPicPage(@Param("start") Integer start, @Param("pageNum") Integer pageNum);

}
