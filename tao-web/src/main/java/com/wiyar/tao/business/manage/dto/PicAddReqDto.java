package com.wiyar.tao.business.manage.dto;

/**
 * Created by fuzhenglong on 16/9/16.
 */
public class PicAddReqDto {

    private String name;
    private String url;
    private Integer category;
    private Integer subCategory;
    private Long diyTime;
    private String remark;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PicAddReqDto{");
        sb.append("name='").append(name).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", category=").append(category);
        sb.append(", subCategory=").append(subCategory);
        sb.append(", diyTime=").append(diyTime);
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

    public Long getDiyTime() {
        return diyTime;
    }

    public void setDiyTime(Long diyTime) {
        this.diyTime = diyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
