package com.android.p025a.p026a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IInAppBillingService.java */
/* renamed from: com.android.a.a.b */
/* loaded from: classes.dex */
public abstract class AbstractBinderC0355b extends Binder implements InterfaceC0354a {
    /* renamed from: a */
    public static InterfaceC0354a m1251a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof InterfaceC0354a)) {
            return (InterfaceC0354a) iInterfaceQueryLocalInterface;
        }
        return new C0356c(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        Bundle bundle;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                int iA = mo1246a(parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iA);
                return true;
            case 2:
                parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                int i3 = parcel.readInt();
                String string = parcel.readString();
                String string2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                Bundle bundleA = mo1247a(i3, string, string2, bundle);
                parcel2.writeNoException();
                if (bundleA != null) {
                    parcel2.writeInt(1);
                    bundleA.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 3:
                parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                Bundle bundleA2 = mo1249a(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (bundleA2 != null) {
                    parcel2.writeInt(1);
                    bundleA2.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 4:
                parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                Bundle bundleA3 = mo1248a(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (bundleA3 != null) {
                    parcel2.writeInt(1);
                    bundleA3.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 5:
                parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                int iB = mo1250b(parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iB);
                return true;
            case 1598968902:
                parcel2.writeString("com.android.vending.billing.IInAppBillingService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
