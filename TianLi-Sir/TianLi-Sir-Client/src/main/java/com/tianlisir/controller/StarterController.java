package com.tianlisir.controller;

import com.tianlisir.entity.Starter;
import com.tianlisir.service.impl.StarterServiceImpl;
import com.tianlisir.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Another
 * @since 2022/08/14
 */
@Api(value = "用户接口",tags="启动页Api")
@RestController
@RequestMapping("/starter")
@Slf4j
public class StarterController {

    @Autowired
    StarterServiceImpl starterService;

    @ApiOperation(value = "添加测试数据value",notes = "添加测试数据notes")
    @GetMapping("testInster")
    private Result<?> testInster(Starter starter){
        starterService.save(starter);
        return Result.OK(starter);
    }

    @ApiOperation(value = "更改测试数据value",notes = "更改测试数据notes")
    @GetMapping("testUpdate")
    private Result<?> testUpdate(Starter starter){
        Starter byId = starterService.getById(starter.getId());
        starter.setVersion(byId.getVersion());
        starterService.updateById(starter);
        return Result.OK(starter);
    }

    @ApiOperation(value = "删除测试数据value",notes = "删除测试数据notes")
    @GetMapping("testRemove")
    private Result<?> testRemove(Long id){
        System.out.println(id);
        starterService.removeById(id);
        return Result.OK();
    }

    @ApiOperation(value = "获取测试数据value",notes = "获取删除测试数据notes")
    @GetMapping("testGet")
    private Result<?> testGet(Long id){
        Starter byId = starterService.getById(id);
        return Result.OK(byId);
    }

    @ApiOperation(value = "获取以删除测试数据value",notes = "获取删除测试数据notes")
    @GetMapping("testGetDelete")
    private Result<?> testGetDelete(){
        List<Starter> delete = starterService.getBaseMapper().getDelete();
        return Result.OK(delete);
    }

}
