package com.sec.chaton.push;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.sec.chaton.push.b */
/* loaded from: classes.dex */
class C0354b implements IPushClientService {

    /* renamed from: a */
    private IBinder f2600a;

    C0354b(IBinder iBinder) {
        this.f2600a = iBinder;
    }

    @Override // com.sec.chaton.push.IPushClientService
    /* renamed from: a */
    public void mo2849a(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            this.f2600a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.IPushClientService
    /* renamed from: a */
    public void mo2850a(String str, IDeregistrationCallbackListener iDeregistrationCallbackListener) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            parcelObtain.writeStrongBinder(iDeregistrationCallbackListener != null ? iDeregistrationCallbackListener.asBinder() : null);
            this.f2600a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.IPushClientService
    /* renamed from: a */
    public void mo2851a(String str, IRegistrationCallbackListener iRegistrationCallbackListener) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            parcelObtain.writeStrongBinder(iRegistrationCallbackListener != null ? iRegistrationCallbackListener.asBinder() : null);
            this.f2600a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.IPushClientService
    /* renamed from: a */
    public boolean mo2852a() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            this.f2600a.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f2600a;
    }

    @Override // com.sec.chaton.push.IPushClientService
    /* renamed from: b */
    public String mo2853b(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            this.f2600a.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
