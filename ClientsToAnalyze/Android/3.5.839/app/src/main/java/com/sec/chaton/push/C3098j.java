package com.sec.chaton.push;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: IRegistrationCallbackListener.java */
/* renamed from: com.sec.chaton.push.j */
/* loaded from: classes.dex */
class C3098j implements InterfaceC3095h {

    /* renamed from: a */
    private IBinder f11422a;

    C3098j(IBinder iBinder) {
        this.f11422a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f11422a;
    }

    @Override // com.sec.chaton.push.InterfaceC3095h
    /* renamed from: a */
    public void mo9336a(String str, String str2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IRegistrationCallbackListener");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            this.f11422a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC3095h
    /* renamed from: a */
    public void mo9335a(int i, String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IRegistrationCallbackListener");
            parcelObtain.writeInt(i);
            parcelObtain.writeString(str);
            this.f11422a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
