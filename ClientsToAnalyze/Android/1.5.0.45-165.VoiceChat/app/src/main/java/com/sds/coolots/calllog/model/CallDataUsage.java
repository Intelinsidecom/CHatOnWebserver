package com.sds.coolots.calllog.model;

import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class CallDataUsage {

    /* renamed from: a */
    private static final String f2892a = "[CallDataUsage]";

    /* renamed from: b */
    private long f2893b;

    /* renamed from: c */
    private long f2894c;

    /* renamed from: d */
    private long f2895d;

    /* renamed from: e */
    private long f2896e;

    /* renamed from: f */
    private long f2897f;

    /* renamed from: g */
    private long f2898g;

    /* renamed from: a */
    private void m2832a(String str) {
        Log.m2958e(f2892a + str);
    }

    public long getDialledVideoDU() {
        return this.f2894c;
    }

    public long getDialledVoiceDU() {
        return this.f2893b;
    }

    public long getLastVideoDU() {
        return this.f2898g;
    }

    public long getLastVoiceDU() {
        return this.f2897f;
    }

    public long getRecvVideoDU() {
        return this.f2896e;
    }

    public long getRecvVoiceDU() {
        return this.f2895d;
    }

    public void setDataUsage(long j, long j2, long j3, long j4, long j5, long j6) {
        this.f2893b = j;
        this.f2894c = j2;
        this.f2895d = j3;
        this.f2896e = j4;
        this.f2897f = j5;
        this.f2898g = j6;
    }

    public void setDialledVideoDU(long j) {
        this.f2894c = j;
    }

    public void setDialledVoiceDU(long j) {
        this.f2893b = j;
    }

    public void setLastVideoDU(long j) {
        this.f2898g = j;
    }

    public void setLastVoiceDU(long j) {
        this.f2897f = j;
    }

    public void setRecvVideoDU(long j) {
        this.f2896e = j;
    }

    public void setRecvVoiceDU(long j) {
        this.f2895d = j;
    }
}
