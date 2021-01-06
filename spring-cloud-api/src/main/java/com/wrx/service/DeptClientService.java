package com.wrx.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wrx.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;


@FeignClient(name = "SPRING-CLOUD-PROVIDE-DEPT",fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {

    @PostMapping("/dept/getDeptVo")
    Dept queryById(@RequestBody Map<String,Object> requestBody);

    @PostMapping("/dept/getDeptList")
    List<Dept> queryAll();

    @PostMapping("/dept/add")
    boolean addDept(@RequestBody Map<String, Object> requestBody);

}
