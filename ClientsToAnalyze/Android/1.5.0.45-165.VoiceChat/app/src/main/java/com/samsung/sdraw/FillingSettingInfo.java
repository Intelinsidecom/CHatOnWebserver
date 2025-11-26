package com.samsung.sdraw;

import android.content.Context;
import android.graphics.Color;

/* loaded from: classes.dex */
public class FillingSettingInfo {

    /* renamed from: b */
    private static final int f1048b = Color.argb(254, 19, 19, 19);

    /* renamed from: a */
    int f1049a;

    /* renamed from: c */
    private int f1050c;

    /* renamed from: d */
    private int f1051d;

    /* renamed from: e */
    private int f1052e;

    /* renamed from: f */
    private InterfaceC0973a f1053f;

    /* renamed from: g */
    private InterfaceC0974b f1054g;

    /* renamed from: com.samsung.sdraw.FillingSettingInfo$a */
    interface InterfaceC0973a {
        /* renamed from: a */
        void mo986a(int i);
    }

    /* renamed from: com.samsung.sdraw.FillingSettingInfo$b */
    interface InterfaceC0974b {
        /* renamed from: a */
        void mo799a(int i);
    }

    public FillingSettingInfo(Context context) {
        m999a((String) null);
    }

    public FillingSettingInfo() {
        m999a((String) null);
    }

    public FillingSettingInfo(int filling_color) {
        this.f1050c = filling_color;
    }

    public int getFillingColor() {
        return (-16777216) | (16777215 & this.f1050c);
    }

    public void setFillingColor(int color) {
        this.f1050c = 16777215 & color;
        if ((this.f1049a & 16777215) != this.f1050c) {
            this.f1049a = this.f1050c | (-16777216);
        }
        if (this.f1053f != null) {
            this.f1053f.mo986a(color);
        }
        if (this.f1054g != null) {
            if ((color & (-16777216)) == -16777216) {
                color = (-33554432) | (16777215 & color);
            } else if ((color & (-16777216)) == -33554432) {
                color = (-16777216) | (16777215 & color);
            }
            this.f1054g.mo799a(color);
        }
    }

    /* renamed from: a */
    void m996a(int i, int i2) {
        this.f1051d = i;
        this.f1052e = i2;
    }

    /* renamed from: a */
    void m999a(String str) {
        if (str != null) {
            this.f1050c = Integer.parseInt(str);
        } else {
            this.f1050c = f1048b;
            this.f1049a = (-16777216) | (16777215 & this.f1050c);
        }
    }

    /* renamed from: a */
    void m997a(InterfaceC0973a interfaceC0973a) {
        this.f1053f = interfaceC0973a;
    }

    /* renamed from: a */
    void m998a(InterfaceC0974b interfaceC0974b) {
        this.f1054g = interfaceC0974b;
    }

    /* renamed from: a */
    void m995a(int i) {
        this.f1049a = i;
    }

    /* renamed from: a */
    int m994a() {
        return this.f1049a;
    }
}
