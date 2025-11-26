package com.sds.coolots.login.model;

/* renamed from: com.sds.coolots.login.model.c */
/* loaded from: classes.dex */
public class C1284c {

    /* renamed from: a */
    private static final int f3228a = 1000;

    /* renamed from: b */
    private int f3229b = 0;

    /* renamed from: a */
    public int m3080a() {
        int i = -1;
        switch (this.f3229b) {
            case 0:
                i = 1000;
                break;
            case 1:
                i = 2000;
                break;
            case 2:
                i = 4000;
                break;
            case 3:
                i = 8000;
                break;
            case 4:
                i = 16000;
                break;
        }
        this.f3229b++;
        return i;
    }

    /* renamed from: b */
    public void m3081b() {
        this.f3229b = 0;
    }
}
