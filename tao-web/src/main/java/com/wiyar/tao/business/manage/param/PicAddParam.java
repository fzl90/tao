package com.wiyar.tao.business.manage.param;

import java.sql.Timestamp;

/**
 * Created by fuzhenglong on 16/9/16.
 */
public class PicAddParam {

    private String name;
    private String url;
    private Integer category;
    private Integer subCategory;
    private String diyTimeStr;
    private String remark;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PicAddParam{");
        sb.append("name='").append(name).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", category=").append(category);
        sb.append(", subCategory=").append(subCategory);
        sb.append(", diyTimeStr='").append(diyTimeStr).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append('}');
        return sb.toString();
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

    public String getDiyTimeStr() {
        return diyTimeStr;
    }

    public void setDiyTimeStr(String diyTimeStr) {
        this.diyTimeStr = diyTimeStr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
