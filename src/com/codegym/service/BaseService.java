package com.codegym.service;

import com.codegym.serializer.CacheSerializer;

import java.util.UUID;

public class BaseService {
    private CacheSerializer cacheSerializer = CacheSerializer.getInstanceCacheUserLogin();
    public String getEmployeeId(){
        return cacheSerializer.getDataToCache("employeeId");
    }

    public String getRole(){
        return cacheSerializer.getDataToCache("role");
    }


    public String genId(){
        return  UUID.randomUUID().toString();

    }
}
