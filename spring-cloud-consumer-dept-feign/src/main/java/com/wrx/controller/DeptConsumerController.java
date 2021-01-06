package com.wrx.controller;

import com.wrx.pojo.Dept;
import com.wrx.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/consumer")
public class DeptConsumerController {

    @Autowired
    DeptClientService deptClientService;

    @PostMapping("/addDept")
    public boolean addDept(@RequestBody Map<String, Object> requestBody){
        return deptClientService.addDept(requestBody);
    }


    @PostMapping("/getDeptVo")
    public Dept getDeptVo(@RequestBody Map<String, Object> requestBody){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("deptId",Long.parseLong(requestBody.get("deptId").toString()));
        Dept dept = deptClientService.queryById(paramMap);
        return dept;
    }

    @PostMapping("/getDeptVoList")
    public List<Dept> getDeptVoList(){
        List list = deptClientService.queryAll();
        return list;
    }
}
