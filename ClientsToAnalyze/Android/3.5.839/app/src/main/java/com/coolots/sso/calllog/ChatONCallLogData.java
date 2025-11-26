package com.coolots.sso.calllog;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ChatONCallLogData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new C0423a();

    /* renamed from: a */
    private String f1012a = "";

    /* renamed from: b */
    private int f1013b = 0;

    /* renamed from: c */
    private int f1014c = -1;

    /* renamed from: d */
    private int f1015d = -1;

    /* renamed from: e */
    private String f1016e = "";

    /* renamed from: f */
    private String f1017f = "";

    /* renamed from: g */
    private int f1018g = -1;

    /* renamed from: h */
    private String f1019h = "";

    public ChatONCallLogData() {
    }

    public ChatONCallLogData(Parcel parcel) {
        m1511a(parcel);
    }

    /* renamed from: a */
    private void m1511a(Parcel parcel) {
        if (parcel.readInt() == 0) {
            this.f1012a = null;
        } else {
            this.f1012a = parcel.readString();
        }
        this.f1013b = parcel.readInt();
        this.f1014c = parcel.readInt();
        this.f1015d = parcel.readInt();
        if (parcel.readInt() == 0) {
            this.f1016e = null;
        } else {
            this.f1016e = parcel.readString();
        }
        if (parcel.readInt() == 0) {
            this.f1017f = null;
        } else {
            this.f1017f = parcel.readString();
        }
        this.f1018g = parcel.readInt();
        if (parcel.readInt() == 0) {
            this.f1019h = null;
        } else {
            this.f1019h = parcel.readString();
        }
    }

    /* renamed from: a */
    public String m1512a() {
        return this.f1012a;
    }

    /* renamed from: a */
    public void m1513a(int i) {
        this.f1018g = i;
    }

    /* renamed from: b */
    public int m1514b() {
        return this.f1013b;
    }

    /* renamed from: c */
    public int m1515c() {
        return this.f1014c;
    }

    /* renamed from: d */
    public int m1516d() {
        return this.f1015d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public String m1517e() {
        return this.f1016e;
    }

    /* renamed from: f */
    public String m1518f() {
        return this.f1017f;
    }

    /* renamed from: g */
    public int m1519g() {
        return this.f1018g;
    }

    /* renamed from: h */
    public String m1520h() {
        return this.f1019h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.f1012a == null || this.f1012a.isEmpty()) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.f1012a.length());
            parcel.writeString(this.f1012a);
        }
        parcel.writeInt(this.f1013b);
        parcel.writeInt(this.f1014c);
        parcel.writeInt(this.f1015d);
        if (this.f1016e == null || this.f1016e.isEmpty()) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.f1016e.length());
            parcel.writeString(this.f1016e);
        }
        if (this.f1017f == null || this.f1017f.isEmpty()) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.f1017f.length());
            parcel.writeString(this.f1017f);
        }
        parcel.writeInt(this.f1018g);
        if (this.f1019h == null || this.f1019h.isEmpty()) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.f1019h.length());
            parcel.writeString(this.f1019h);
        }
    }
}
