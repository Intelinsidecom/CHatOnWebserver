package com.coolots.p2pmsg.model;

import com.coolots.common.util.StringUtil;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class UsageInfo {

    @NotNull
    private String TypeCode;

    @NotNull
    private int UsageCount;

    public UsageInfo() {
    }

    public UsageInfo(String TypeCode, int UsageCount) {
        this.TypeCode = TypeCode;
        this.UsageCount = UsageCount;
    }

    public String getTypeCode() {
        return this.TypeCode;
    }

    public void setTypeCode(String TypeCode) {
        this.TypeCode = TypeCode;
    }

    public int getUsageCount() {
        return this.UsageCount;
    }

    public void setUsageCount(int UsageCount) {
        this.UsageCount = UsageCount;
    }

    public String toString() {
        return StringUtil.classToString(this);
    }
}
