package com.wiyar.tao.business.index.service;

import com.wiyar.tao.dao.model.Pic;

import java.util.List;

/**
 * Created by fzl on 16/10/1.
 */
public interface IndexPicService {

    List<Pic> queryPicPage(Integer pageIndex, Integer pageNum);

}
