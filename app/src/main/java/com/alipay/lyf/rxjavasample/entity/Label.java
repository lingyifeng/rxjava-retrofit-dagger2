package com.alipay.lyf.rxjavasample.entity;

import java.io.Serializable;

/**
 * Created by CJ on 2017/1/17.
 */
public class Label implements Serializable {

    /**
     * name : IT精英
     * usrid : 1
     * id : 148
     * refid : 23
     */

    private String name;
    private int usrid;
    private int id;
    private int refid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUsrid() {
        return usrid;
    }

    public void setUsrid(int usrid) {
        this.usrid = usrid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRefid() {
        return refid;
    }

    public void setRefid(int refid) {
        this.refid = refid;
    }
}
