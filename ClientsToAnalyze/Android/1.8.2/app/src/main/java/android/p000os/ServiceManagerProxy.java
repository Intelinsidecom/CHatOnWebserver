package android.p000os;

/* compiled from: ServiceManagerNative.java */
/* loaded from: classes.dex */
class ServiceManagerProxy implements IServiceManager {
    private IBinder mRemote;

    public ServiceManagerProxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    @Override // android.p000os.IServiceManager
    public IBinder getService(String str) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeInterfaceToken(IServiceManager.descriptor);
        parcelObtain.writeString(str);
        this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
        IBinder strongBinder = parcelObtain2.readStrongBinder();
        parcelObtain2.recycle();
        parcelObtain.recycle();
        return strongBinder;
    }

    @Override // android.p000os.IServiceManager
    public IBinder checkService(String str) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeInterfaceToken(IServiceManager.descriptor);
        parcelObtain.writeString(str);
        this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
        IBinder strongBinder = parcelObtain2.readStrongBinder();
        parcelObtain2.recycle();
        parcelObtain.recycle();
        return strongBinder;
    }

    @Override // android.p000os.IServiceManager
    public void addService(String str, IBinder iBinder) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeInterfaceToken(IServiceManager.descriptor);
        parcelObtain.writeString(str);
        parcelObtain.writeStrongBinder(iBinder);
        this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
        parcelObtain2.recycle();
        parcelObtain.recycle();
    }

    @Override // android.p000os.IServiceManager
    public String[] listServices() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeInterfaceToken(IServiceManager.descriptor);
        this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
        String[] stringArray = parcelObtain2.readStringArray();
        parcelObtain2.recycle();
        parcelObtain.recycle();
        return stringArray;
    }

    @Override // android.p000os.IServiceManager
    public void setPermissionController(IPermissionController iPermissionController) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeInterfaceToken(IServiceManager.descriptor);
        parcelObtain.writeStrongBinder(iPermissionController.asBinder());
        this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
        parcelObtain2.recycle();
        parcelObtain.recycle();
    }
}
