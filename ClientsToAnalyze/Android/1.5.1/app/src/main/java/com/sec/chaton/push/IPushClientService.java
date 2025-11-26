package com.sec.chaton.push;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.sec.chaton.push.IDeregistrationCallbackListener;
import com.sec.chaton.push.IRegistrationCallbackListener;

/* loaded from: classes.dex */
public interface IPushClientService extends IInterface {

    public abstract class Stub extends Binder implements IPushClientService {
        public Stub() {
            attachInterface(this, "com.sec.chaton.push.IPushClientService");
        }

        /* renamed from: a */
        public static IPushClientService m2854a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.sec.chaton.push.IPushClientService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPushClientService)) ? new C0354b(iBinder) : (IPushClientService) iInterfaceQueryLocalInterface;
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
                    mo2851a(parcel.readString(), IRegistrationCallbackListener.Stub.m2855a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.sec.chaton.push.IPushClientService");
                    mo2850a(parcel.readString(), IDeregistrationCallbackListener.Stub.m2848a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.sec.chaton.push.IPushClientService");
                    mo2849a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.sec.chaton.push.IPushClientService");
                    String strB = mo2853b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strB);
                    return true;
                case 5:
                    parcel.enforceInterface("com.sec.chaton.push.IPushClientService");
                    boolean zA = mo2852a();
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

    /* renamed from: a */
    void mo2849a(String str);

    /* renamed from: a */
    void mo2850a(String str, IDeregistrationCallbackListener iDeregistrationCallbackListener);

    /* renamed from: a */
    void mo2851a(String str, IRegistrationCallbackListener iRegistrationCallbackListener);

    /* renamed from: a */
    boolean mo2852a();

    /* renamed from: b */
    String mo2853b(String str);
}
