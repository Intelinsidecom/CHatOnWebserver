package com.sec.chaton.smsplugin.p112ui;

import android.database.Cursor;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* compiled from: MessageListAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.ui.aw */
/* loaded from: classes.dex */
public class C4114aw {

    /* renamed from: a */
    public int f15335a;

    /* renamed from: b */
    public int f15336b;

    /* renamed from: c */
    public int f15337c;

    /* renamed from: d */
    public int f15338d;

    /* renamed from: e */
    public int f15339e;

    /* renamed from: f */
    public int f15340f;

    /* renamed from: g */
    public int f15341g;

    /* renamed from: h */
    public int f15342h;

    /* renamed from: i */
    public int f15343i;

    /* renamed from: j */
    public int f15344j;

    /* renamed from: k */
    public int f15345k;

    /* renamed from: l */
    public int f15346l;

    /* renamed from: m */
    public int f15347m;

    /* renamed from: n */
    public int f15348n;

    /* renamed from: o */
    public int f15349o;

    /* renamed from: p */
    public int f15350p;

    /* renamed from: q */
    public int f15351q;

    /* renamed from: r */
    public int f15352r;

    /* renamed from: s */
    public int f15353s;

    /* renamed from: t */
    public int f15354t;

    public C4114aw() {
        this.f15335a = 0;
        this.f15336b = 1;
        this.f15337c = 2;
        this.f15338d = 3;
        this.f15339e = 4;
        this.f15340f = 5;
        this.f15341g = 7;
        this.f15342h = 8;
        this.f15343i = 9;
        this.f15344j = 10;
        this.f15345k = 11;
        this.f15346l = 12;
        this.f15347m = 15;
        this.f15348n = 16;
        this.f15349o = 17;
        this.f15350p = 18;
        this.f15351q = 19;
        this.f15352r = 20;
        this.f15353s = 21;
        this.f15354t = 22;
    }

    public C4114aw(Cursor cursor) {
        try {
            this.f15335a = cursor.getColumnIndexOrThrow("transport_type");
        } catch (IllegalArgumentException e) {
            C3890m.m14997c("colsMap", e.getMessage());
        }
        try {
            this.f15336b = cursor.getColumnIndexOrThrow("_id");
        } catch (IllegalArgumentException e2) {
            C3890m.m14997c("colsMap", e2.getMessage());
        }
        try {
            this.f15337c = cursor.getColumnIndexOrThrow("thread_id");
        } catch (IllegalArgumentException e3) {
            C3890m.m14998d("colsMap", e3.getMessage());
        }
        try {
            this.f15338d = cursor.getColumnIndexOrThrow("address");
        } catch (IllegalArgumentException e4) {
            C3890m.m14997c("colsMap", e4.getMessage());
        }
        try {
            this.f15339e = cursor.getColumnIndexOrThrow("body");
        } catch (IllegalArgumentException e5) {
            C3890m.m14997c("colsMap", e5.getMessage());
        }
        try {
            this.f15340f = cursor.getColumnIndexOrThrow("date");
        } catch (IllegalArgumentException e6) {
            C3890m.m14997c("colsMap", e6.getMessage());
        }
        try {
            this.f15341g = cursor.getColumnIndexOrThrow("type");
        } catch (IllegalArgumentException e7) {
            C3890m.m14997c("colsMap", e7.getMessage());
        }
        try {
            this.f15342h = cursor.getColumnIndexOrThrow("status");
        } catch (IllegalArgumentException e8) {
            C3890m.m14997c("colsMap", e8.getMessage());
        }
        try {
            this.f15343i = cursor.getColumnIndexOrThrow("locked");
        } catch (IllegalArgumentException e9) {
            C3890m.m14997c("colsMap", e9.getMessage());
        }
        try {
            this.f15344j = cursor.getColumnIndexOrThrow(VKApiConst.ERROR_CODE);
        } catch (IllegalArgumentException e10) {
            C3890m.m14997c("colsMap", e10.getMessage());
        }
        try {
            this.f15345k = cursor.getColumnIndexOrThrow("sub");
        } catch (IllegalArgumentException e11) {
            C3890m.m14997c("colsMap", e11.getMessage());
        }
        try {
            this.f15346l = cursor.getColumnIndexOrThrow("sub_cs");
        } catch (IllegalArgumentException e12) {
            C3890m.m14997c("colsMap", e12.getMessage());
        }
        try {
            this.f15347m = cursor.getColumnIndexOrThrow("m_type");
        } catch (IllegalArgumentException e13) {
            C3890m.m14997c("colsMap", e13.getMessage());
        }
        try {
            this.f15348n = cursor.getColumnIndexOrThrow("msg_box");
        } catch (IllegalArgumentException e14) {
            C3890m.m14997c("colsMap", e14.getMessage());
        }
        try {
            this.f15349o = cursor.getColumnIndexOrThrow("d_rpt");
        } catch (IllegalArgumentException e15) {
            C3890m.m14997c("colsMap", e15.getMessage());
        }
        try {
            this.f15350p = cursor.getColumnIndexOrThrow("rr");
        } catch (IllegalArgumentException e16) {
            C3890m.m14997c("colsMap", e16.getMessage());
        }
        try {
            this.f15351q = cursor.getColumnIndexOrThrow("err_type");
        } catch (IllegalArgumentException e17) {
            C3890m.m14997c("colsMap", e17.getMessage());
        }
        try {
            this.f15352r = cursor.getColumnIndexOrThrow("locked");
        } catch (IllegalArgumentException e18) {
            C3890m.m14997c("colsMap", e18.getMessage());
        }
    }
}
