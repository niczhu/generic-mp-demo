package com.md.mp.framwork.base.model;

import java.util.HashMap;
import java.util.Map;

/**
 * QueryParams
 *
 * @author zhuhaipeng6 in 2020/7/10 17:52
 * @version 1.0
 **/
public class QueryParams {

    private Map<String, Object> values = new HashMap<>();

    public QueryParams() {
    }

    public static QueryParams builder() {
        return new QueryParams();
    }

    public QueryParams start(int start) {
        this.values.put("start", start);
        return this;
    }

    public QueryParams limit(int limit) {
        this.values.put("limit", limit);
        return this;
    }

    public Map<String, Object> build() {
        return this.values;
    }

    public QueryParams clear() {
        this.values.clear();
        return this;
    }

    public String toString(){
        return this.values.toString();
    }


}
