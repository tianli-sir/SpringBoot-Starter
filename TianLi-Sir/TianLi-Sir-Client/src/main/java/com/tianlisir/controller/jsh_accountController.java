package com.tianlisir.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tianlisir.controller.vo.Result;
import com.tianlisir.entity.jsh_log;
import com.tianlisir.service.Ijsh_log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Component
@RestController
public class jsh_accountController {

    @Autowired
    Ijsh_log log;
    @GetMapping("/{id}")
    //@PathVariable 获取路径值
    public Result<?> GetAll(@PathVariable Integer id, @RequestParam(name="pageNo", defaultValue="2") Integer pageNo,
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
        System.out.println(list);
        return Result.OK(maps);
    }
}
