package com.tianlisir.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tianlisir.vo.Result;
import com.tianlisir.entity.jsh_log;
import com.tianlisir.service.Ijsh_log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
@Api(value = "用户接口", tags = {"用户接口"})
public class jsh_accountController {

    @Autowired
    Ijsh_log log;

    @ApiOperation("根据条件查询用户")
    @GetMapping("/{path}")
    //@PathVariable 获取路径值
    public Result<?> GetAll(@PathVariable String path, @RequestParam(name="pageNo", defaultValue="2") Integer pageNo,
                              @RequestParam(name="pageSize", defaultValue="5") Integer pageSize,
                              HttpServletRequest req){
        //分页
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("tenant_id",63);
        Page<jsh_log> page = new Page<>(pageNo,pageSize);
        IPage<jsh_log> pageList = log.page(page);
        System.out.println(pageList.getRecords());
        //统计/分组
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("count(*),client_ip");
        queryWrapper.groupBy("client_ip");
        //通过逻辑层.getBaseMapper可以获取数据层

        List list = log.getBaseMapper().selectMaps(queryWrapper);
        //通过返回map 获取key value
        List<Map<String,Object>> maps = log.getBaseMapper().selectMaps(queryWrapper);
        System.out.println("-----------");
        System.out.println(maps);
        System.out.println("-----------");
        System.out.println(path);
        return Result.OK(new Date().toString(),list);
    }
}
