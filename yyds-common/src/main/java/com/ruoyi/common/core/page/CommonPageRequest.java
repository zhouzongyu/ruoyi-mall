package com.ruoyi.common.core.page;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.utils.ServletUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CommonPageRequest {
    private static final String PAGE_SIZE_PARAM_NAME = "pageSize";

    private static final String PAGE_PARAM_NAME = "pageNum";

    private static final Integer PAGE_SIZE_MAX_VALUE = 10;

    public static <T> Page<T> defaultPage( int page, int size) {
        Page<T> objectPage = new Page<>(page, size);
        return objectPage;
    }

    public static <T> Page<T> defaultPage() {

        int size = 20;

        int page = 1;

        //每页条数
        String pageSizeString = ServletUtils.getParameter(PAGE_SIZE_PARAM_NAME);
        if (ObjectUtil.isNotEmpty(pageSizeString)) {
            try {
                size = Convert.toInt(pageSizeString);
                if(size > PAGE_SIZE_MAX_VALUE) {
                    size = PAGE_SIZE_MAX_VALUE;
                }
            } catch (Exception e) {
                log.error(">>> 分页条数转换异常：", e);
                size = 20;
            }
        }

        //第几页
        String pageString = ServletUtils.getParameter(PAGE_PARAM_NAME);
        if (ObjectUtil.isNotEmpty(pageString)) {
            try {
                page = Convert.toInt(pageString);
            } catch (Exception e) {
                log.error(">>> 分页页数转换异常：", e);
                page = 1;
            }
        }
        Page<T> objectPage = new Page<>(page, size);
        return objectPage;
    }
}
