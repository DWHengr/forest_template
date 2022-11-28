package com.forest.springboot.service.impl;

import com.forest.springboot.entity.Test;
import com.forest.springboot.mapper.TestMapper;
import com.forest.springboot.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试表 服务实现类
 * </p>
 *
 * @author forest
 * @since 2022-11-28
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

}
