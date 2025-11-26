package com.sec.chaton.common.entry;

/* loaded from: classes.dex */
public class ResultEntry {

    /* renamed from: a */
    public boolean f1325a;

    /* renamed from: b */
    public Result f1326b;

    /* renamed from: c */
    public String f1327c;

    public enum Result {
        SUCCESS,
        FAIL,
        NETWORKFAIL
    }

    public ResultEntry(boolean z) {
        this.f1325a = z;
    }

    public ResultEntry(boolean z, Result result) {
        this.f1325a = z;
        this.f1326b = result;
    }

    public ResultEntry(boolean z, Result result, String str) {
        this.f1325a = z;
        this.f1326b = result;
        this.f1327c = str;
    }

    public ResultEntry(boolean z, String str) {
        this.f1325a = z;
        this.f1327c = str;
    }
}
