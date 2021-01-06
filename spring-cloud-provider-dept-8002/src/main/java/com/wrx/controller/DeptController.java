package com.wrx.controller;

import com.wrx.pojo.Dept;
import com.wrx.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("dept")
public class DeptController {

    @Autowired
    DeptService deptService;

    @PostMapping("/add")
    public boolean addDept(@RequestBody Map<String, Object> requestBody){
        Dept dept = new Dept();
        dept.setDname(requestBody.get("dname").toString());
        return deptService.addDept(dept);
    }

    @PostMapping("/getDeptVo")
    public Dept getDeptVo(@RequestBody Map<String, Object> requestBody){
        Dept dept = deptService.queryById(Long.parseLong(requestBody.get("deptId").toString()));
        if (dept == null){
            throw new RuntimeException("id不存在");
        }
        return dept;
    }


    @PostMapping("/getDeptList")
    public List<Dept> getDeptList(){
        return deptService.queryAll();
    }

}
