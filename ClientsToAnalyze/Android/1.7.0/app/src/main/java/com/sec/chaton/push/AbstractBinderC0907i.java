package com.sec.chaton.push;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IDeregistrationCallbackListener.java */
/* renamed from: com.sec.chaton.push.i */
/* loaded from: classes.dex */
public abstract class AbstractBinderC0907i extends Binder implements InterfaceC0880c {
    public AbstractBinderC0907i() {
        attachInterface(this, "com.sec.chaton.push.IDeregistrationCallbackListener");
    }

    /* renamed from: a */
    public static InterfaceC0880c m3595a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.sec.chaton.push.IDeregistrationCallbackListener");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof InterfaceC0880c)) {
            return (InterfaceC0880c) iInterfaceQueryLocalInterface;
        }
        return new C0911m(iBinder);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.sec.chaton.push.IDeregistrationCallbackListener");
                mo805a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.sec.chaton.push.IDeregistrationCallbackListener");
                mo804a(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.sec.chaton.push.IDeregistrationCallbackListener");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
