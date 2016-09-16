package com.wiyar.tao.dao.model;

import java.sql.Timestamp;

/**
 * Created by fuzhenglong on 16/9/16.
 */
public class Pic {

    private Long id;
    private String name;
    private String url;
    private Integer category;
    private Integer subCategory;
    private Long width;
    private Long height;
    private Timestamp diyTime;
    private String remark;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer is_active;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pic{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", category=").append(category);
        sb.append(", subCategory=").append(subCategory);
        sb.append(", width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", diyTime=").append(diyTime);
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", is_active=").append(is_active);
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

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIs_active() {
        return is_active;
    }

    public void setIs_active(Integer is_active) {
        this.is_active = is_active;
    }
}
