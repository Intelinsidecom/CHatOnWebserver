package com.coolots.sso.p003a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.sec.chaton.C0229at;

/* compiled from: ISSOServiceFunction.java */
/* renamed from: com.coolots.sso.a.b */
/* loaded from: classes.dex */
public abstract class AbstractBinderC0039b extends Binder implements InterfaceC0038a {
    /* renamed from: a */
    public static InterfaceC0038a m60a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coolots.sso.service.ISSOServiceFunction");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof InterfaceC0038a)) {
            return (InterfaceC0038a) iInterfaceQueryLocalInterface;
        }
        return new C0040c(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.coolots.sso.service.ISSOServiceFunction");
                boolean zA = mo49a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zA ? 1 : 0);
                return true;
            case 2:
                parcel.enforceInterface("com.coolots.sso.service.ISSOServiceFunction");
                mo45a();
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.coolots.sso.service.ISSOServiceFunction");
                String strB = mo52b();
                parcel2.writeNoException();
                parcel2.writeString(strB);
                return true;
            case 4:
                parcel.enforceInterface("com.coolots.sso.service.ISSOServiceFunction");
                boolean zA2 = mo46a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zA2 ? 1 : 0);
                return true;
            case 5:
                parcel.enforceInterface("com.coolots.sso.service.ISSOServiceFunction");
                boolean zA3 = mo47a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zA3 ? 1 : 0);
                return true;
            case 6:
                parcel.enforceInterface("com.coolots.sso.service.ISSOServiceFunction");
                boolean zB = mo54b(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zB ? 1 : 0);
                return true;
            case 7:
                parcel.enforceInterface("com.coolots.sso.service.ISSOServiceFunction");
                boolean zA4 = mo48a(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zA4 ? 1 : 0);
                return true;
            case 8:
                parcel.enforceInterface("com.coolots.sso.service.ISSOServiceFunction");
                boolean zC = mo59c(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zC ? 1 : 0);
                return true;
            case 9:
                parcel.enforceInterface("com.coolots.sso.service.ISSOServiceFunction");
                boolean zB2 = mo55b(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zB2 ? 1 : 0);
                return true;
            case 10:
                parcel.enforceInterface("com.coolots.sso.service.ISSOServiceFunction");
                boolean zA5 = mo50a(parcel.createStringArrayList(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zA5 ? 1 : 0);
                return true;
            case 11:
                parcel.enforceInterface("com.coolots.sso.service.ISSOServiceFunction");
                boolean zA6 = mo51a(parcel.createStringArrayList(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zA6 ? 1 : 0);
                return true;
            case C0229at.HorizontalSrollView_android_background /* 12 */:
                parcel.enforceInterface("com.coolots.sso.service.ISSOServiceFunction");
                boolean zB3 = mo56b(parcel.createStringArrayList(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zB3 ? 1 : 0);
                return true;
            case C0229at.HorizontalSrollView_android_padding /* 13 */:
                parcel.enforceInterface("com.coolots.sso.service.ISSOServiceFunction");
                boolean zB4 = mo57b(parcel.createStringArrayList(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zB4 ? 1 : 0);
                return true;
            case C0229at.HorizontalSrollView_android_paddingLeft /* 14 */:
                parcel.enforceInterface("com.coolots.sso.service.ISSOServiceFunction");
                String strC = mo58c();
                parcel2.writeNoException();
                parcel2.writeString(strC);
                return true;
            case C0229at.HorizontalSrollView_android_paddingTop /* 15 */:
                parcel.enforceInterface("com.coolots.sso.service.ISSOServiceFunction");
                mo53b(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.coolots.sso.service.ISSOServiceFunction");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
