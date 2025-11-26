package com.sec.chaton.push;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: IDeregistrationCallbackListener.java */
/* renamed from: com.sec.chaton.push.m */
/* loaded from: classes.dex */
class C0911m implements InterfaceC0880c {

    /* renamed from: a */
    private IBinder f3092a;

    C0911m(IBinder iBinder) {
        this.f3092a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f3092a;
    }

    @Override // com.sec.chaton.push.InterfaceC0880c
    /* renamed from: a */
    public void mo805a(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IDeregistrationCallbackListener");
            parcelObtain.writeString(str);
            this.f3092a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC0880c
    /* renamed from: a */
    public void mo804a(int i, String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IDeregistrationCallbackListener");
            parcelObtain.writeInt(i);
            parcelObtain.writeString(str);
            this.f3092a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
