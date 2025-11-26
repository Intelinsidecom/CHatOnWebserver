package com.sec.chaton.push;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: IDeregistrationCallbackListener.java */
/* renamed from: com.sec.chaton.push.c */
/* loaded from: classes.dex */
class C1098c implements InterfaceC1070a {

    /* renamed from: a */
    private IBinder f4039a;

    C1098c(IBinder iBinder) {
        this.f4039a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f4039a;
    }

    @Override // com.sec.chaton.push.InterfaceC1070a
    /* renamed from: a */
    public void mo2800a(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IDeregistrationCallbackListener");
            parcelObtain.writeString(str);
            this.f4039a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC1070a
    /* renamed from: a */
    public void mo2799a(int i, String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IDeregistrationCallbackListener");
            parcelObtain.writeInt(i);
            parcelObtain.writeString(str);
            this.f4039a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
