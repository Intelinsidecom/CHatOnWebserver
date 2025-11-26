package com.sec.chaton.for3rd;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

/* compiled from: IDataAccessService.java */
/* renamed from: com.sec.chaton.for3rd.d */
/* loaded from: classes.dex */
public abstract class AbstractBinderC0747d extends Binder implements InterfaceC0746c {
    public AbstractBinderC0747d() {
        attachInterface(this, "com.sec.chaton.for3rd.IDataAccessService");
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.sec.chaton.for3rd.IDataAccessService");
                Bitmap bitmapA = mo3239a(parcel.readString());
                parcel2.writeNoException();
                if (bitmapA != null) {
                    parcel2.writeInt(1);
                    bitmapA.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 2:
                parcel.enforceInterface("com.sec.chaton.for3rd.IDataAccessService");
                boolean zB = mo3240b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zB ? 1 : 0);
                return true;
            case 1598968902:
                parcel2.writeString("com.sec.chaton.for3rd.IDataAccessService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
