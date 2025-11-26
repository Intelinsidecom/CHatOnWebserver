package com.sec.spp.push;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface IPushClientService extends IInterface {

    public abstract class Stub extends Binder implements IPushClientService {
        public Stub() {
            attachInterface(this, "com.sec.spp.push.IPushClientService");
        }

        /* renamed from: a */
        public static IPushClientService m3704a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.sec.spp.push.IPushClientService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPushClientService)) ? new C0625a(iBinder) : (IPushClientService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.sec.spp.push.IPushClientService");
                    mo3699a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.sec.spp.push.IPushClientService");
                    mo3698a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.sec.spp.push.IPushClientService");
                    String strB = mo3701b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strB);
                    return true;
                case 4:
                    parcel.enforceInterface("com.sec.spp.push.IPushClientService");
                    boolean zA = mo3700a();
                    parcel2.writeNoException();
                    parcel2.writeInt(zA ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface("com.sec.spp.push.IPushClientService");
                    String[] strArrB = mo3702b();
                    parcel2.writeNoException();
                    parcel2.writeStringArray(strArrB);
                    return true;
                case 6:
                    parcel.enforceInterface("com.sec.spp.push.IPushClientService");
                    mo3703c(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.sec.spp.push.IPushClientService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    void mo3698a(String str);

    /* renamed from: a */
    void mo3699a(String str, String str2);

    /* renamed from: a */
    boolean mo3700a();

    /* renamed from: b */
    String mo3701b(String str);

    /* renamed from: b */
    String[] mo3702b();

    /* renamed from: c */
    void mo3703c(String str);
}
