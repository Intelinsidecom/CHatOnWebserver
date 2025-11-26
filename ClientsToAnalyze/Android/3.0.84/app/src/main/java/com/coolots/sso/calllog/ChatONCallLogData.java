package com.coolots.sso.calllog;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ChatONCallLogData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new C0052a();

    /* renamed from: a */
    private String f43a = "";

    /* renamed from: b */
    private int f44b = 0;

    /* renamed from: c */
    private int f45c = -1;

    /* renamed from: d */
    private int f46d = -1;

    /* renamed from: e */
    private String f47e = "";

    /* renamed from: f */
    private String f48f = "";

    /* renamed from: g */
    private int f49g = -1;

    /* renamed from: h */
    private String f50h = "";

    public ChatONCallLogData() {
    }

    public ChatONCallLogData(Parcel parcel) {
        m68a(parcel);
    }

    /* renamed from: a */
    private void m68a(Parcel parcel) {
        if (parcel.readInt() == 0) {
            this.f43a = null;
        } else {
            this.f43a = parcel.readString();
        }
        this.f44b = parcel.readInt();
        this.f45c = parcel.readInt();
        this.f46d = parcel.readInt();
        if (parcel.readInt() == 0) {
            this.f47e = null;
        } else {
            this.f47e = parcel.readString();
        }
        if (parcel.readInt() == 0) {
            this.f48f = null;
        } else {
            this.f48f = parcel.readString();
        }
        this.f49g = parcel.readInt();
        if (parcel.readInt() == 0) {
            this.f50h = null;
        } else {
            this.f50h = parcel.readString();
        }
    }

    /* renamed from: a */
    public String m69a() {
        return this.f43a;
    }

    /* renamed from: a */
    public void m70a(int i) {
        this.f49g = i;
    }

    /* renamed from: b */
    public int m71b() {
        return this.f44b;
    }

    /* renamed from: c */
    public int m72c() {
        return this.f45c;
    }

    /* renamed from: d */
    public int m73d() {
        return this.f46d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public String m74e() {
        return this.f47e;
    }

    /* renamed from: f */
    public String m75f() {
        return this.f48f;
    }

    /* renamed from: g */
    public int m76g() {
        return this.f49g;
    }

    /* renamed from: h */
    public String m77h() {
        return this.f50h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.f43a == null || this.f43a.isEmpty()) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.f43a.length());
            parcel.writeString(this.f43a);
        }
        parcel.writeInt(this.f44b);
        parcel.writeInt(this.f45c);
        parcel.writeInt(this.f46d);
        if (this.f47e == null || this.f47e.isEmpty()) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.f47e.length());
            parcel.writeString(this.f47e);
        }
        if (this.f48f == null || this.f48f.isEmpty()) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.f48f.length());
            parcel.writeString(this.f48f);
        }
        parcel.writeInt(this.f49g);
        if (this.f50h == null || this.f50h.isEmpty()) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.f50h.length());
            parcel.writeString(this.f50h);
        }
    }
}
