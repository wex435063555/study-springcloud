package com.wrx.service;

import com.wrx.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept queryById(Map<String, Object> requestBody) {
                return new Dept().setId(Long.parseLong(requestBody.get("deptId").toString())).setDname("服务降级，已被关闭").setDb_source("稍后重试");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Map<String, Object> requestBody) {
                return false;
            }
        };
    }
}
