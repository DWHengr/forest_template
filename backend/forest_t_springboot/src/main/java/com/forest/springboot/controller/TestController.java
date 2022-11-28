package com.forest.springboot.controller;


import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;

import com.forest.springboot.service.TestService;
import com.forest.springboot.entity.Test;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 测试表 控制器
 * </p>
 *
 * @author forest
 * @since 2022-11-28
 */
@Api(tags = "测试表")
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Resource
    private TestService testService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public Object create(@RequestBody Test test) {
        log.info("测试表创建，Test:{}" , test);
        boolean flag = testService.save(test);
        return flag;
    }

    @ApiOperation("更新")
    @PostMapping("/update")
    public Object update(Test test) {
        log.info("测试表更新，Test:{}" , test);
        boolean flag = testService.updateById(test);
        return flag;
    }

    @ApiOperation("删除")
    @PostMapping("/deletes")
    public Object deletes(@RequestBody List<String> ids) {
        log.info("测试表删除，ids:{}" , ids);
        boolean flag = testService.removeByIds(ids);
        return flag;
    }

    @ApiOperation("查询全部")
    @GetMapping("/list")
    public Object List() {
        List<Test> result = testService.list();
        return result;
    }

    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    public Object findOne(@PathVariable Integer id) {
        Test result = testService.getById(id);
        return result;
    }
}

