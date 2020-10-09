package com.thunder.common.api;

import lombok.Data;

import java.util.List;

/**
 * @description: 分页类
 * @author: liumiao
 * @create: 2020/9/8
 **/
@Data
public class PageResult<T> {

    private Integer currentPage;

    private Integer pageSize;

    private Integer totalPage;

    private long total;

    private List<T> list;




}
