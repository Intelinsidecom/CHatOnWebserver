package com.sec.chaton.push;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IDeregistrationCallbackListener.java */
/* renamed from: com.sec.chaton.push.b */
/* loaded from: classes.dex */
public abstract class AbstractBinderC1083b extends Binder implements InterfaceC1070a {
    public AbstractBinderC1083b() {
        attachInterface(this, "com.sec.chaton.push.IDeregistrationCallbackListener");
    }

    /* renamed from: a */
    public static InterfaceC1070a m4135a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.sec.chaton.push.IDeregistrationCallbackListener");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof InterfaceC1070a)) {
            return (InterfaceC1070a) iInterfaceQueryLocalInterface;
        }
        return new C1098c(iBinder);
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
                mo2800a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.sec.chaton.push.IDeregistrationCallbackListener");
                mo2799a(parcel.readInt(), parcel.readString());
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
