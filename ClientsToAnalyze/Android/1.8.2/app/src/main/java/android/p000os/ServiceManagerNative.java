package android.p000os;

import android.os.IPermissionController;

/* loaded from: classes.dex */
public abstract class ServiceManagerNative extends Binder implements IServiceManager {
    public static IServiceManager asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IServiceManager iServiceManager = (IServiceManager) iBinder.queryLocalInterface(IServiceManager.descriptor);
        return iServiceManager == null ? new ServiceManagerProxy(iBinder) : iServiceManager;
    }

    public ServiceManagerNative() {
        attachInterface(this, IServiceManager.descriptor);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface(IServiceManager.descriptor);
                parcel2.writeStrongBinder(getService(parcel.readString()));
                break;
            case 2:
                parcel.enforceInterface(IServiceManager.descriptor);
                parcel2.writeStrongBinder(checkService(parcel.readString()));
                break;
            case 3:
                parcel.enforceInterface(IServiceManager.descriptor);
                addService(parcel.readString(), parcel.readStrongBinder());
                break;
            case 4:
                parcel.enforceInterface(IServiceManager.descriptor);
                parcel2.writeStringArray(listServices());
                break;
            case 5:
            default:
                return false;
            case 6:
                parcel.enforceInterface(IServiceManager.descriptor);
                setPermissionController(IPermissionController.Stub.asInterface(parcel.readStrongBinder()));
                break;
        }
        return true;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
