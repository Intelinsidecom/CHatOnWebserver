package com.sec.chaton.push;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface IDeregistrationCallbackListener extends IInterface {

    public abstract class Stub extends Binder implements IDeregistrationCallbackListener {
        public Stub() {
            attachInterface(this, "com.sec.chaton.push.IDeregistrationCallbackListener");
        }

        /* renamed from: a */
        public static IDeregistrationCallbackListener m2848a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.sec.chaton.push.IDeregistrationCallbackListener");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDeregistrationCallbackListener)) ? new C0362i(iBinder) : (IDeregistrationCallbackListener) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.sec.chaton.push.IDeregistrationCallbackListener");
                    mo2100a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.sec.chaton.push.IDeregistrationCallbackListener");
                    mo2099a(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.sec.chaton.push.IDeregistrationCallbackListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    void mo2099a(int i, String str);

    /* renamed from: a */
    void mo2100a(String str);
}
