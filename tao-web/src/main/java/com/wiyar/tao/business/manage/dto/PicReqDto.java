package com.wiyar.tao.business.manage.dto;

import java.sql.Timestamp;

/**
 * Created by fuzhenglong on 16/9/16.
 */
public class PicReqDto {

    private Long id;
    private String name;
    private String url;
    private Integer category;
    private Integer subCategory;
    private Timestamp diyTime;
    private String remark;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PicReqDto{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", category=").append(category);
        sb.append(", subCategory=").append(subCategory);
        sb.append(", diyTime=").append(diyTime);
        sb.append(", remark='").append(remark).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(Integer subCategory) {
        this.subCategory = subCategory;
    }

    public Timestamp getDiyTime() {
        return diyTime;
    }

    public void setDiyTime(Timestamp diyTime) {
        this.diyTime = diyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
