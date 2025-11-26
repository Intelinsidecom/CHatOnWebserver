package com.sec.chaton.push;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IRegistrationCallbackListener.java */
/* renamed from: com.sec.chaton.push.i */
/* loaded from: classes.dex */
public abstract class AbstractBinderC2097i extends Binder implements InterfaceC2095h {
    public AbstractBinderC2097i() {
        attachInterface(this, "com.sec.chaton.push.IRegistrationCallbackListener");
    }

    /* renamed from: a */
    public static InterfaceC2095h m8282a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.sec.chaton.push.IRegistrationCallbackListener");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof InterfaceC2095h)) {
            return (InterfaceC2095h) iInterfaceQueryLocalInterface;
        }
        return new C2098j(iBinder);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.sec.chaton.push.IRegistrationCallbackListener");
                mo5593a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.sec.chaton.push.IRegistrationCallbackListener");
                mo5592a(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.sec.chaton.push.IRegistrationCallbackListener");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
