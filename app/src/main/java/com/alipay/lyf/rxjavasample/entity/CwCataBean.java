package com.alipay.lyf.rxjavasample.entity;

import com.jiang.common.widget.pickerview.model.IPickerViewData;

/**
 * Created by CJ on 2017/1/13.
 */

public class CwCataBean implements IPickerViewData{

    /**
     * cpid : 1
     * name : 4555559999
     * pid : 0
     * id : 33
     */

    private Integer cpid;
    private String name;
    private Integer pid;
    private Integer id;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    private boolean checked;

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getPickerViewText() {
        return name;
    }
}
