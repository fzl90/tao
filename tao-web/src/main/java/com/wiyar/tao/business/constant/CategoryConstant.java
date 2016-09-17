package com.wiyar.tao.business.constant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fuzhenglong on 16/9/17.
 */
public class CategoryConstant {

    private static List<Category> categories = new ArrayList<>();

    private static List<SubCategory> subCategories = new ArrayList<>();

    static {
        categories.add(new Category(1, "平面"));
        categories.add(new Category(2, "UI"));
        categories.add(new Category(3, "网页"));
        categories.add(new Category(4, "手绘/插画"));
        categories.add(new Category(5, "婚庆"));
        categories.add(new Category(6, "二维码"));

        subCategories.add(new SubCategory(1, 1, "LOGO"));
        subCategories.add(new SubCategory(1, 2, "VI"));
        subCategories.add(new SubCategory(1, 3, "字体设计"));
        subCategories.add(new SubCategory(1, 4, "海报"));
        subCategories.add(new SubCategory(1, 5, "活动"));
        subCategories.add(new SubCategory(1, 6, "画册"));
        subCategories.add(new SubCategory(1, 7, "其他"));

        subCategories.add(new SubCategory(2, 1, "APP"));
        subCategories.add(new SubCategory(2, 2, "LOGO/ICON"));
        subCategories.add(new SubCategory(2, 3, "H5"));
        subCategories.add(new SubCategory(2, 4, "引导活动页"));
    }

    public static List<Category> getCategories() {
        return categories;
    }

    public static List<SubCategory> getSubCategories(Integer category) {
        return subCategories.stream().filter((subCategory) -> {
            return subCategory.getParentId().equals(category);
        }).collect(Collectors.toList());
    }

}
