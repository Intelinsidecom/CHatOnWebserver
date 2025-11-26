package com.sec.chaton.push;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: IPushClientService.java */
/* renamed from: com.sec.chaton.push.g */
/* loaded from: classes.dex */
class C3094g implements InterfaceC3092e {

    /* renamed from: a */
    private IBinder f11409a;

    C3094g(IBinder iBinder) {
        this.f11409a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f11409a;
    }

    @Override // com.sec.chaton.push.InterfaceC3092e
    /* renamed from: a */
    public void mo12597a(String str, InterfaceC3095h interfaceC3095h) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            parcelObtain.writeStrongBinder(interfaceC3095h != null ? interfaceC3095h.asBinder() : null);
            this.f11409a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC3092e
    /* renamed from: a */
    public void mo12596a(String str, InterfaceC3056b interfaceC3056b) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            parcelObtain.writeStrongBinder(interfaceC3056b != null ? interfaceC3056b.asBinder() : null);
            this.f11409a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC3092e
    /* renamed from: a */
    public void mo12595a(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            this.f11409a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC3092e
    /* renamed from: b */
    public String mo12599b(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            this.f11409a.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC3092e
    /* renamed from: a */
    public boolean mo12598a() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            this.f11409a.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC3092e
    /* renamed from: c */
    public int mo12600c(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            this.f11409a.transact(6, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
