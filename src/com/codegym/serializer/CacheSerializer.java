package com.codegym.serializer;

import java.util.HashMap;
import java.util.Map;

public class CacheSerializer {
    private static CacheSerializer cacheUserLogin;

    public static CacheSerializer getInstanceCacheUserLogin() {
        if (cacheUserLogin == null) {
            cacheUserLogin = new CacheSerializer();
        }
        return cacheUserLogin;
    }


    private CacheSerializer() {
        cache = new HashMap<>();
    }

    private static Map<String, String> cache;

    public void addDataToCache(String key, String data) {
        cache.put(key, data);
    }
    public String getDataToCache(String key) {
       return cache.get(key);
    }

    public void removeDataToCache(String key) {
        try {
            cache.remove(key);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
