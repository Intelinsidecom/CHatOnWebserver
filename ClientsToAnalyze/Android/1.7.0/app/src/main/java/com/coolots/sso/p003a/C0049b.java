package com.coolots.sso.p003a;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

/* compiled from: ISSOServiceFunction.java */
/* renamed from: com.coolots.sso.a.b */
/* loaded from: classes.dex */
class C0049b implements InterfaceC0048a {

    /* renamed from: a */
    private IBinder f30a;

    C0049b(IBinder iBinder) {
        this.f30a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f30a;
    }

    @Override // com.coolots.sso.p003a.InterfaceC0048a
    /* renamed from: a */
    public boolean mo49a(String str, String str2, String str3, String str4, String str5) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolots.sso.service.ISSOServiceFunction");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            parcelObtain.writeString(str3);
            parcelObtain.writeString(str4);
            parcelObtain.writeString(str5);
            this.f30a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.coolots.sso.p003a.InterfaceC0048a
    /* renamed from: a */
    public void mo45a() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolots.sso.service.ISSOServiceFunction");
            this.f30a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.coolots.sso.p003a.InterfaceC0048a
    /* renamed from: b */
    public String mo52b() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolots.sso.service.ISSOServiceFunction");
            this.f30a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.coolots.sso.p003a.InterfaceC0048a
    /* renamed from: a */
    public boolean mo46a(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolots.sso.service.ISSOServiceFunction");
            parcelObtain.writeString(str);
            this.f30a.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.coolots.sso.p003a.InterfaceC0048a
    /* renamed from: a */
    public boolean mo47a(String str, String str2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolots.sso.service.ISSOServiceFunction");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            this.f30a.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.coolots.sso.p003a.InterfaceC0048a
    /* renamed from: b */
    public boolean mo54b(String str, String str2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolots.sso.service.ISSOServiceFunction");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            this.f30a.transact(6, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.coolots.sso.p003a.InterfaceC0048a
    /* renamed from: a */
    public boolean mo48a(String str, String str2, String str3) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolots.sso.service.ISSOServiceFunction");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            parcelObtain.writeString(str3);
            this.f30a.transact(7, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.coolots.sso.p003a.InterfaceC0048a
    /* renamed from: c */
    public boolean mo59c(String str, String str2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolots.sso.service.ISSOServiceFunction");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            this.f30a.transact(8, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.coolots.sso.p003a.InterfaceC0048a
    /* renamed from: b */
    public boolean mo55b(String str, String str2, String str3) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolots.sso.service.ISSOServiceFunction");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            parcelObtain.writeString(str3);
            this.f30a.transact(9, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.coolots.sso.p003a.InterfaceC0048a
    /* renamed from: a */
    public boolean mo50a(List list, String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolots.sso.service.ISSOServiceFunction");
            parcelObtain.writeStringList(list);
            parcelObtain.writeString(str);
            this.f30a.transact(10, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.coolots.sso.p003a.InterfaceC0048a
    /* renamed from: a */
    public boolean mo51a(List list, String str, String str2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolots.sso.service.ISSOServiceFunction");
            parcelObtain.writeStringList(list);
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            this.f30a.transact(11, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.coolots.sso.p003a.InterfaceC0048a
    /* renamed from: b */
    public boolean mo56b(List list, String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolots.sso.service.ISSOServiceFunction");
            parcelObtain.writeStringList(list);
            parcelObtain.writeString(str);
            this.f30a.transact(12, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.coolots.sso.p003a.InterfaceC0048a
    /* renamed from: b */
    public boolean mo57b(List list, String str, String str2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolots.sso.service.ISSOServiceFunction");
            parcelObtain.writeStringList(list);
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            this.f30a.transact(13, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.coolots.sso.p003a.InterfaceC0048a
    /* renamed from: c */
    public String mo58c() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolots.sso.service.ISSOServiceFunction");
            this.f30a.transact(14, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.coolots.sso.p003a.InterfaceC0048a
    /* renamed from: b */
    public void mo53b(String str, String str2, String str3, String str4, String str5) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolots.sso.service.ISSOServiceFunction");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            parcelObtain.writeString(str3);
            parcelObtain.writeString(str4);
            parcelObtain.writeString(str5);
            this.f30a.transact(15, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
