package com.sec.chaton.push;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: IPushClientService.java */
/* renamed from: com.sec.chaton.push.f */
/* loaded from: classes.dex */
class C1120f implements InterfaceC1118d {

    /* renamed from: a */
    private IBinder f4094a;

    C1120f(IBinder iBinder) {
        this.f4094a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f4094a;
    }

    @Override // com.sec.chaton.push.InterfaceC1118d
    /* renamed from: a */
    public void mo4209a(String str, InterfaceC1121g interfaceC1121g) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            parcelObtain.writeStrongBinder(interfaceC1121g != null ? interfaceC1121g.asBinder() : null);
            this.f4094a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC1118d
    /* renamed from: a */
    public void mo4208a(String str, InterfaceC1070a interfaceC1070a) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            parcelObtain.writeStrongBinder(interfaceC1070a != null ? interfaceC1070a.asBinder() : null);
            this.f4094a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC1118d
    /* renamed from: a */
    public void mo4207a(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            this.f4094a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC1118d
    /* renamed from: b */
    public String mo4211b(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            this.f4094a.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC1118d
    /* renamed from: a */
    public boolean mo4210a() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            this.f4094a.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
