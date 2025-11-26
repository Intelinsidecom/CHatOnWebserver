package com.sec.chaton.push;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: IPushClientService.java */
/* renamed from: com.sec.chaton.push.g */
/* loaded from: classes.dex */
class C2094g implements InterfaceC2092e {

    /* renamed from: a */
    private IBinder f7999a;

    C2094g(IBinder iBinder) {
        this.f7999a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f7999a;
    }

    @Override // com.sec.chaton.push.InterfaceC2092e
    /* renamed from: a */
    public void mo8254a(String str, InterfaceC2095h interfaceC2095h) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            parcelObtain.writeStrongBinder(interfaceC2095h != null ? interfaceC2095h.asBinder() : null);
            this.f7999a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC2092e
    /* renamed from: a */
    public void mo8253a(String str, InterfaceC2056b interfaceC2056b) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            parcelObtain.writeStrongBinder(interfaceC2056b != null ? interfaceC2056b.asBinder() : null);
            this.f7999a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC2092e
    /* renamed from: a */
    public void mo8252a(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            this.f7999a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC2092e
    /* renamed from: b */
    public String mo8256b(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            this.f7999a.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC2092e
    /* renamed from: a */
    public boolean mo8255a() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            this.f7999a.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC2092e
    /* renamed from: c */
    public int mo8257c(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            this.f7999a.transact(6, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
