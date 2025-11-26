package com.sec.chaton.push;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.sec.chaton.push.c */
/* loaded from: classes.dex */
class C0355c implements IRegistrationCallbackListener {

    /* renamed from: a */
    private IBinder f2601a;

    C0355c(IBinder iBinder) {
        this.f2601a = iBinder;
    }

    @Override // com.sec.chaton.push.IRegistrationCallbackListener
    /* renamed from: a */
    public void mo2105a(int i, String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IRegistrationCallbackListener");
            parcelObtain.writeInt(i);
            parcelObtain.writeString(str);
            this.f2601a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.IRegistrationCallbackListener
    /* renamed from: a */
    public void mo2106a(String str, String str2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IRegistrationCallbackListener");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            this.f2601a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f2601a;
    }
}
