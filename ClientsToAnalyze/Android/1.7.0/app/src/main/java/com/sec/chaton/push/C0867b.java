package com.sec.chaton.push;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: IRegistrationCallbackListener.java */
/* renamed from: com.sec.chaton.push.b */
/* loaded from: classes.dex */
class C0867b implements InterfaceC0902f {

    /* renamed from: a */
    private IBinder f2995a;

    C0867b(IBinder iBinder) {
        this.f2995a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f2995a;
    }

    @Override // com.sec.chaton.push.InterfaceC0902f
    /* renamed from: a */
    public void mo728a(String str, String str2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IRegistrationCallbackListener");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            this.f2995a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC0902f
    /* renamed from: a */
    public void mo727a(int i, String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IRegistrationCallbackListener");
            parcelObtain.writeInt(i);
            parcelObtain.writeString(str);
            this.f2995a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
