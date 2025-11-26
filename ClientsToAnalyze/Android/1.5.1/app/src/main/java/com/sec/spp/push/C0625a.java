package com.sec.spp.push;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.sec.spp.push.a */
/* loaded from: classes.dex */
class C0625a implements IPushClientService {

    /* renamed from: a */
    private IBinder f3807a;

    C0625a(IBinder iBinder) {
        this.f3807a = iBinder;
    }

    @Override // com.sec.spp.push.IPushClientService
    /* renamed from: a */
    public void mo3698a(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.spp.push.IPushClientService");
            parcelObtain.writeString(str);
            this.f3807a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.spp.push.IPushClientService
    /* renamed from: a */
    public void mo3699a(String str, String str2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.spp.push.IPushClientService");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            this.f3807a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.spp.push.IPushClientService
    /* renamed from: a */
    public boolean mo3700a() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.spp.push.IPushClientService");
            this.f3807a.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f3807a;
    }

    @Override // com.sec.spp.push.IPushClientService
    /* renamed from: b */
    public String mo3701b(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.spp.push.IPushClientService");
            parcelObtain.writeString(str);
            this.f3807a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.spp.push.IPushClientService
    /* renamed from: b */
    public String[] mo3702b() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.spp.push.IPushClientService");
            this.f3807a.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.createStringArray();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.sec.spp.push.IPushClientService
    /* renamed from: c */
    public void mo3703c(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.sec.spp.push.IPushClientService");
            parcelObtain.writeString(str);
            this.f3807a.transact(6, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
