package com.sec.chaton.push;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: IRegistrationCallbackListener.java */
/* renamed from: com.sec.chaton.push.i */
/* loaded from: classes.dex */
class C1125i implements InterfaceC1121g {

    /* renamed from: a */
    private IBinder f4104a;

    C1125i(IBinder iBinder) {
        this.f4104a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f4104a;
    }

    @Override // com.sec.chaton.push.InterfaceC1121g
    /* renamed from: a */
    public void mo2803a(String str, String str2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IRegistrationCallbackListener");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            this.f4104a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC1121g
    /* renamed from: a */
    public void mo2802a(int i, String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IRegistrationCallbackListener");
            parcelObtain.writeInt(i);
            parcelObtain.writeString(str);
            this.f4104a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
