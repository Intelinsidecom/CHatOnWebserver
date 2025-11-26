package com.sds.coolots.call.model;

/* loaded from: classes.dex */
public class RingtoneInfo {

    /* renamed from: a */
    private static final int f2641a = 1;

    /* renamed from: b */
    private static final int f2642b = 2;

    /* renamed from: c */
    private static final int f2643c = 3;

    /* renamed from: d */
    private static final int f2644d = 4;

    /* renamed from: e */
    private int f2645e;

    /* renamed from: f */
    private int f2646f;

    /* renamed from: g */
    private String f2647g;

    public RingtoneInfo() {
    }

    public RingtoneInfo(int i, int i2, String str) {
        this.f2645e = i;
        this.f2646f = i2;
        this.f2647g = str;
    }

    public RingtoneInfo(String str) {
        this.f2645e = Integer.parseInt(str.substring(0, 1));
        switch (this.f2645e) {
            case 1:
            case 2:
                this.f2646f = 0;
                this.f2647g = "";
                break;
            case 3:
                this.f2646f = Integer.parseInt(str.substring(2, str.length()));
                this.f2647g = "";
                break;
            case 4:
                this.f2646f = 0;
                this.f2647g = str.substring(2, str.length());
                break;
        }
    }

    public int getIndex() {
        return this.f2646f;
    }

    public String getPath() {
        return this.f2647g;
    }

    public int getType() {
        return this.f2645e;
    }

    public String getValue(String str) {
        switch (this.f2645e) {
            case 1:
            case 2:
                return Integer.toString(this.f2645e);
            case 3:
                return String.valueOf(Integer.toString(this.f2645e)) + "_" + this.f2646f;
            case 4:
                return String.valueOf(Integer.toString(this.f2645e)) + "_" + this.f2647g;
            default:
                return str;
        }
    }

    public void setIndex(int i) {
        this.f2646f = i;
    }

    public void setPath(String str) {
        this.f2647g = str;
    }

    public void setType(int i) {
        this.f2645e = i;
    }
}
