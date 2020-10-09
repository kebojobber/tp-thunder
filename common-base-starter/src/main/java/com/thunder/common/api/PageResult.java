package com.thunder.common.api;

import com.github.pagehelper.Page;
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

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    private long total;

    private List<T> list;

    private PageResult(Integer currentPage, Integer pageSize, Integer totalPage, long total, List<T> list) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.total = total;
        this.list = list;
    }

    private PageResult() {

    }

    public static <T> PageResult<T> page(Page<T> page) {
        PageResult<T> result = new PageResult<T>();
        result.setTotalPage(page.getPages());
        result.setPageSize(page.getPageNum());
        result.setPageSize(page.getPageSize());
        result.setTotal(page.getTotal());
        result.setList(page.getResult());
        return result;
    }





}
