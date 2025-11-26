package com.sec.chaton.push;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface IRegistrationCallbackListener extends IInterface {

    public abstract class Stub extends Binder implements IRegistrationCallbackListener {
        public Stub() {
            attachInterface(this, "com.sec.chaton.push.IRegistrationCallbackListener");
        }

        /* renamed from: a */
        public static IRegistrationCallbackListener m2855a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.sec.chaton.push.IRegistrationCallbackListener");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRegistrationCallbackListener)) ? new C0355c(iBinder) : (IRegistrationCallbackListener) iInterfaceQueryLocalInterface;
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
                    mo2106a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.sec.chaton.push.IRegistrationCallbackListener");
                    mo2105a(parcel.readInt(), parcel.readString());
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

    /* renamed from: a */
    void mo2105a(int i, String str);

    /* renamed from: a */
    void mo2106a(String str, String str2);
}
