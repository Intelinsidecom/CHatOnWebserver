package com.sec.chaton.push;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.sec.chaton.push.i */
/* loaded from: classes.dex */
class C0362i implements IDeregistrationCallbackListener {

    /* renamed from: a */
    private IBinder f2620a;

    C0362i(IBinder iBinder) {
        this.f2620a = iBinder;
    }

    @Override // com.sec.chaton.push.IDeregistrationCallbackListener
    /* renamed from: a */
    public void mo2099a(int i, String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IDeregistrationCallbackListener");
            parcelObtain.writeInt(i);
            parcelObtain.writeString(str);
            this.f2620a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.IDeregistrationCallbackListener
    /* renamed from: a */
    public void mo2100a(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IDeregistrationCallbackListener");
            parcelObtain.writeString(str);
            this.f2620a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f2620a;
    }
}
