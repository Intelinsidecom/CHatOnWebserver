package com.sec.chaton.push;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: IPushClientService.java */
/* renamed from: com.sec.chaton.push.a */
/* loaded from: classes.dex */
class C0852a implements InterfaceC0903g {

    /* renamed from: a */
    private IBinder f2962a;

    C0852a(IBinder iBinder) {
        this.f2962a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f2962a;
    }

    @Override // com.sec.chaton.push.InterfaceC0903g
    /* renamed from: a */
    public void mo3445a(String str, InterfaceC0902f interfaceC0902f) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            parcelObtain.writeStrongBinder(interfaceC0902f != null ? interfaceC0902f.asBinder() : null);
            this.f2962a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC0903g
    /* renamed from: a */
    public void mo3444a(String str, InterfaceC0880c interfaceC0880c) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            parcelObtain.writeStrongBinder(interfaceC0880c != null ? interfaceC0880c.asBinder() : null);
            this.f2962a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC0903g
    /* renamed from: a */
    public void mo3443a(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            this.f2962a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC0903g
    /* renamed from: b */
    public String mo3447b(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            parcelObtain.writeString(str);
            this.f2962a.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.chaton.push.InterfaceC0903g
    /* renamed from: a */
    public boolean mo3446a() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.chaton.push.IPushClientService");
            this.f2962a.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
