package com.wiyar.tao.business.constant;

/**
 * Created by fuzhenglong on 16/9/17.
 */
public class SubCategory{

    private Integer parentId;

    private Integer id;

    private  String name;

    public SubCategory() {
    }

    public SubCategory(Integer parentId, Integer id, String name) {
        this.parentId = parentId;
        this.id = id;
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SubCategory{");
        sb.append("parentId=").append(parentId);
        sb.append(", id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
