package com.facebook.android;

/* loaded from: classes.dex */
public class FacebookError extends Throwable {

    /* renamed from: a */
    private int f202a;

    /* renamed from: b */
    private String f203b;

    public FacebookError(String str) {
        super(str);
        this.f202a = 0;
    }

    public FacebookError(String str, String str2, int i) {
        super(str);
        this.f202a = 0;
        this.f203b = str2;
        this.f202a = i;
    }
}
