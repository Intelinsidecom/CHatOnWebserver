package com.sec.chaton.push;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IRegistrationCallbackListener.java */
/* renamed from: com.sec.chaton.push.i */
/* loaded from: classes.dex */
public abstract class AbstractBinderC3097i extends Binder implements InterfaceC3095h {
    public AbstractBinderC3097i() {
        attachInterface(this, "com.sec.chaton.push.IRegistrationCallbackListener");
    }

    /* renamed from: a */
    public static InterfaceC3095h m12625a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.sec.chaton.push.IRegistrationCallbackListener");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof InterfaceC3095h)) {
            return (InterfaceC3095h) iInterfaceQueryLocalInterface;
        }
        return new C3098j(iBinder);
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
                mo9336a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.sec.chaton.push.IRegistrationCallbackListener");
                mo9335a(parcel.readInt(), parcel.readString());
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
