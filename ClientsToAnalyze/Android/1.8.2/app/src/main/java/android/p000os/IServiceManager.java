package android.p000os;

/* loaded from: classes.dex */
public interface IServiceManager extends IInterface {
    public static final int ADD_SERVICE_TRANSACTION = 3;
    public static final int CHECK_SERVICES_TRANSACTION = 5;
    public static final int CHECK_SERVICE_TRANSACTION = 2;
    public static final int GET_SERVICE_TRANSACTION = 1;
    public static final int LIST_SERVICES_TRANSACTION = 4;
    public static final int SET_PERMISSION_CONTROLLER_TRANSACTION = 6;
    public static final String descriptor = "android.os.IServiceManager";

    void addService(String str, IBinder iBinder);

    IBinder checkService(String str);

    IBinder getService(String str);

    String[] listServices();

    void setPermissionController(IPermissionController iPermissionController);
}
