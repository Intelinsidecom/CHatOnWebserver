package com.sec.chaton.push;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IPushClientService.java */
/* renamed from: com.sec.chaton.push.e */
/* loaded from: classes.dex */
public abstract class AbstractBinderC1119e extends Binder implements InterfaceC1118d {
    public AbstractBinderC1119e() {
        attachInterface(this, "com.sec.chaton.push.IPushClientService");
    }

    /* renamed from: a */
    public static InterfaceC1118d m4212a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.sec.chaton.push.IPushClientService");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof InterfaceC1118d)) {
            return (InterfaceC1118d) iInterfaceQueryLocalInterface;
        }
        return new C1120f(iBinder);
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
                mo4209a(parcel.readString(), AbstractBinderC1122h.m4213a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.sec.chaton.push.IPushClientService");
                mo4208a(parcel.readString(), AbstractBinderC1083b.m4135a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.sec.chaton.push.IPushClientService");
                mo4207a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.sec.chaton.push.IPushClientService");
                String strB = mo4211b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strB);
                return true;
            case 5:
                parcel.enforceInterface("com.sec.chaton.push.IPushClientService");
                boolean zA = mo4210a();
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
