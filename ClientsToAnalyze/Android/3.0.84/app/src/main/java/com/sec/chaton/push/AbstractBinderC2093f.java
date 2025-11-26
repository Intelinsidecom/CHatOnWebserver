package com.sec.chaton.push;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IPushClientService.java */
/* renamed from: com.sec.chaton.push.f */
/* loaded from: classes.dex */
public abstract class AbstractBinderC2093f extends Binder implements InterfaceC2092e {
    public AbstractBinderC2093f() {
        attachInterface(this, "com.sec.chaton.push.IPushClientService");
    }

    /* renamed from: a */
    public static InterfaceC2092e m8258a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.sec.chaton.push.IPushClientService");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof InterfaceC2092e)) {
            return (InterfaceC2092e) iInterfaceQueryLocalInterface;
        }
        return new C2094g(iBinder);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.sec.chaton.push.IPushClientService");
                mo8254a(parcel.readString(), AbstractBinderC2097i.m8282a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.sec.chaton.push.IPushClientService");
                mo8253a(parcel.readString(), AbstractBinderC2071c.m8190a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.sec.chaton.push.IPushClientService");
                mo8252a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.sec.chaton.push.IPushClientService");
                String strB = mo8256b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strB);
                return true;
            case 5:
                parcel.enforceInterface("com.sec.chaton.push.IPushClientService");
                boolean zA = mo8255a();
                parcel2.writeNoException();
                parcel2.writeInt(zA ? 1 : 0);
                return true;
            case 6:
                parcel.enforceInterface("com.sec.chaton.push.IPushClientService");
                int iC = mo8257c(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iC);
                return true;
            case 1598968902:
                parcel2.writeString("com.sec.chaton.push.IPushClientService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
