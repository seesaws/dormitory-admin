package com.dormitory.util;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @ClassName PageUtils
 * @Description TODO
 * @Author CoderL
 * @Date 2020/3/3 15:54
 **/
public class PageUtils {
    /**
     * 获取分页参数
     *
     * @param json
     * @return
     */
    public static Page getPageParam(JSONObject json) {
        int current = json.getIntValue("current");
        int size = json.getIntValue("size");
        if (current == 0) current = 1;
        if (size == 0) size = 10;
        return new Page(current, size);
    }
}
