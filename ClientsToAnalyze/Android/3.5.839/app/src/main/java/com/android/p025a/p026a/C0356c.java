package com.android.p025a.p026a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* compiled from: IInAppBillingService.java */
/* renamed from: com.android.a.a.c */
/* loaded from: classes.dex */
class C0356c implements InterfaceC0354a {

    /* renamed from: a */
    private IBinder f861a;

    C0356c(IBinder iBinder) {
        this.f861a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f861a;
    }

    @Override // com.android.p025a.p026a.InterfaceC0354a
    /* renamed from: a */
    public int mo1246a(int i, String str, String str2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
            parcelObtain.writeInt(i);
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            this.f861a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.android.p025a.p026a.InterfaceC0354a
    /* renamed from: a */
    public Bundle mo1247a(int i, String str, String str2, Bundle bundle) {
        Bundle bundle2;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
            parcelObtain.writeInt(i);
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            if (bundle != null) {
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.f861a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            if (parcelObtain2.readInt() != 0) {
                bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2);
            } else {
                bundle2 = null;
            }
            return bundle2;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.android.p025a.p026a.InterfaceC0354a
    /* renamed from: a */
    public Bundle mo1249a(int i, String str, String str2, String str3, String str4) {
        Bundle bundle;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
            parcelObtain.writeInt(i);
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            parcelObtain.writeString(str3);
            parcelObtain.writeString(str4);
            this.f861a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            if (parcelObtain2.readInt() != 0) {
                bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2);
            } else {
                bundle = null;
            }
            return bundle;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.android.p025a.p026a.InterfaceC0354a
    /* renamed from: a */
    public Bundle mo1248a(int i, String str, String str2, String str3) {
        Bundle bundle;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
            parcelObtain.writeInt(i);
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            parcelObtain.writeString(str3);
            this.f861a.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            if (parcelObtain2.readInt() != 0) {
                bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2);
            } else {
                bundle = null;
            }
            return bundle;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.android.p025a.p026a.InterfaceC0354a
    /* renamed from: b */
    public int mo1250b(int i, String str, String str2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
            parcelObtain.writeInt(i);
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            this.f861a.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
