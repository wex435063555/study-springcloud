package com.wrx.controller;

import com.wrx.pojo.Dept;
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
    RestTemplate restTemplate;

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRING-CLOUD-PROVIDE-DEPT";

    @PostMapping("/addDept")
    public boolean addDept(@RequestBody Map<String, Object> requestBody){
        Dept dept = new Dept();
        dept.setDname(requestBody.get("dname").toString());
        /*Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("dname",requestBody.get("dname").toString());*/
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add",dept,Boolean.class);
    }


    @PostMapping("/getDeptVo")
    public Dept getDeptVo(@RequestBody Map<String, Object> requestBody){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("deptId",Long.parseLong(requestBody.get("deptId").toString()));
        Dept dept = restTemplate.postForObject(REST_URL_PREFIX + "/dept/getDeptVo",paramMap,Dept.class);
        return dept;
    }

    @PostMapping("/getDeptVoList")
    public List<Dept> getDeptVoList(){
        List list = restTemplate.postForObject(REST_URL_PREFIX + "/dept/getDeptList", null, List.class);
        return list;
    }
}
