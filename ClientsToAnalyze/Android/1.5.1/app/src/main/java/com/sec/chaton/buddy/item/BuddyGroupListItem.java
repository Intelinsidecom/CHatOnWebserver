package com.sec.chaton.buddy.item;

import java.io.Serializable;

/* loaded from: classes.dex */
public class BuddyGroupListItem implements Serializable {

    /* renamed from: a */
    private int f669a;

    /* renamed from: b */
    private String f670b;

    /* renamed from: c */
    private int f671c;

    /* renamed from: d */
    private int f672d;

    public BuddyGroupListItem() {
    }

    public BuddyGroupListItem(int i, String str, int i2, int i3) {
        this.f669a = i;
        this.f670b = str;
        this.f671c = i2;
        this.f672d = i3;
    }

    /* renamed from: a */
    public int m663a() {
        return this.f669a;
    }

    /* renamed from: a */
    public void m664a(int i) {
        this.f671c = i;
    }

    /* renamed from: a */
    public void m665a(String str) {
        this.f670b = str;
    }

    /* renamed from: b */
    public String m666b() {
        return this.f670b;
    }

    /* renamed from: c */
    public int m667c() {
        return this.f671c;
    }
}
