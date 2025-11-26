package com.sec.chaton.push;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: IDeregistrationCallbackListener.java */
/* renamed from: com.sec.chaton.push.d */
/* loaded from: classes.dex */
class C2091d implements InterfaceC2056b {

    /* renamed from: a */
    private IBinder f7998a;

    C2091d(IBinder iBinder) {
        this.f7998a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f7998a;
    }

    @Override // com.sec.chaton.push.InterfaceC2056b
    /* renamed from: a */
    public void mo5590a(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IDeregistrationCallbackListener");
            parcelObtain.writeString(str);
            this.f7998a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC2056b
    /* renamed from: a */
    public void mo5589a(int i, String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IDeregistrationCallbackListener");
            parcelObtain.writeInt(i);
            parcelObtain.writeString(str);
            this.f7998a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
