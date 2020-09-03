package com.thunder.base.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.thunder.base.domain.BusProduct;
import com.thunder.base.service.IBusProductService;
import com.thunder.base.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: llm
 * @create: 2020/9/3
 **/
@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    IBusProductService iBusProductService;

    @Override
    public BusProduct findById() {
        List<BusProduct> byId = iBusProductService.list(Wrappers.<BusProduct>lambdaQuery().eq(BusProduct::getId,"000001"));
        return new BusProduct();
    }
}
