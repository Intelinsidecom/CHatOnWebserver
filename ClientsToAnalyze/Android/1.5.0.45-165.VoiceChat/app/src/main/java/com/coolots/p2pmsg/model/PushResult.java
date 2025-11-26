package com.coolots.p2pmsg.model;

import com.coolots.common.util.StringUtil;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class PushResult {
    private int ErrorCode;

    @NotNull
    @Valid
    private PushTargetInfo PushTarget = new PushTargetInfo();

    public int getErrorCode() {
        return this.ErrorCode;
    }

    public void setErrorCode(int errorCode) {
        this.ErrorCode = errorCode;
    }

    public PushTargetInfo getPushTarget() {
        return this.PushTarget;
    }

    public void setPushTarget(PushTargetInfo pushTarget) {
        this.PushTarget = pushTarget;
    }

    public String toString() {
        return StringUtil.classToString(this);
    }
}
