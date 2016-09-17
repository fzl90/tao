package com.wiyar.tao.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by fzl on 16/8/23.
 */
public class CollectionUtil {

    /**
     * 拆分一个list为多个子list,每个子list的数量为count
     *
     * @param resList
     * @param count
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> split(List<T> resList, int count) {
        if (resList == null || count < 1)
            return null;
        List<List<T>> ret = new ArrayList<List<T>>();
        int size = resList.size();
        if (size <= count) { //数据量不足count指定的大小
            ret.add(resList);
        } else {
            int pre = size / count;
            int last = size % count;
            //前面pre个集合，每个大小都是count个元素
            for (int i = 0; i < pre; i++) {
                List<T> itemList = new ArrayList<T>();
                for (int j = 0; j < count; j++) {
                    itemList.add(resList.get(i * count + j));
                }
                ret.add(itemList);
            }
            //last的进行处理
            if (last > 0) {
                List<T> itemList = new ArrayList<T>();
                for (int i = 0; i < last; i++) {
                    itemList.add(resList.get(pre * count + i));
                }
                ret.add(itemList);
            }
        }
        return ret;
    }


    public static <T> List<T> distinct(List<T> list) {
        if (list == null)
            return null;
        HashSet hashSet = new HashSet<>();
        List newList = new ArrayList<>();
        list.forEach(item -> {
            hashSet.add(item);
        });
        hashSet.forEach(item -> {
            newList.add(item);
        });
        return newList;
    }

}
