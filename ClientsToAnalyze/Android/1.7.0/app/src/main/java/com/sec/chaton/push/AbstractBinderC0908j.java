package com.sec.chaton.push;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IPushClientService.java */
/* renamed from: com.sec.chaton.push.j */
/* loaded from: classes.dex */
public abstract class AbstractBinderC0908j extends Binder implements InterfaceC0903g {
    public AbstractBinderC0908j() {
        attachInterface(this, "com.sec.chaton.push.IPushClientService");
    }

    /* renamed from: a */
    public static InterfaceC0903g m3596a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.sec.chaton.push.IPushClientService");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof InterfaceC0903g)) {
            return (InterfaceC0903g) iInterfaceQueryLocalInterface;
        }
        return new C0852a(iBinder);
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
                mo3445a(parcel.readString(), AbstractBinderC0901e.m3536a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.sec.chaton.push.IPushClientService");
                mo3444a(parcel.readString(), AbstractBinderC0907i.m3595a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.sec.chaton.push.IPushClientService");
                mo3443a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.sec.chaton.push.IPushClientService");
                String strB = mo3447b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strB);
                return true;
            case 5:
                parcel.enforceInterface("com.sec.chaton.push.IPushClientService");
                boolean zA = mo3446a();
                parcel2.writeNoException();
                parcel2.writeInt(zA ? 1 : 0);
                return true;
            case 1598968902:
                parcel2.writeString("com.sec.chaton.push.IPushClientService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
