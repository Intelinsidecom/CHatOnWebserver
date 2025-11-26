package com.sec.chaton.for3rd;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

/* compiled from: IDataAccessService.java */
/* renamed from: com.sec.chaton.for3rd.b */
/* loaded from: classes.dex */
public abstract class AbstractBinderC0705b extends Binder implements InterfaceC0704a {
    public AbstractBinderC0705b() {
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
                Bitmap bitmapA = mo3093a(parcel.readString());
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
                boolean zB = mo3094b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zB ? 1 : 0);
                return true;
            case 3:
                parcel.enforceInterface("com.sec.chaton.for3rd.IDataAccessService");
                int iA = mo3092a(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(iA);
                return true;
            case 1598968902:
                parcel2.writeString("com.sec.chaton.for3rd.IDataAccessService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
