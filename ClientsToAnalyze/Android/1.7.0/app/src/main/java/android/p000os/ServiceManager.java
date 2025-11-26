package android.p000os;

import android.util.Log;
import com.android.internal.os.BinderInternal;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class ServiceManager {
    private static final String TAG = "ServiceManager";
    private static HashMap sCache = new HashMap();
    private static IServiceManager sServiceManager;

    private static IServiceManager getIServiceManager() {
        if (sServiceManager != null) {
            return sServiceManager;
        }
        sServiceManager = ServiceManagerNative.asInterface(BinderInternal.getContextObject());
        return sServiceManager;
    }

    public static IBinder getService(String str) {
        try {
            IBinder iBinder = (IBinder) sCache.get(str);
            if (iBinder == null) {
                return getIServiceManager().getService(str);
            }
            return iBinder;
        } catch (RemoteException e) {
            Log.e(TAG, "error in getService", e);
            return null;
        }
    }

    public static void addService(String str, IBinder iBinder) {
        try {
            getIServiceManager().addService(str, iBinder);
        } catch (RemoteException e) {
            Log.e(TAG, "error in addService", e);
        }
    }

    public static IBinder checkService(String str) {
        try {
            IBinder iBinder = (IBinder) sCache.get(str);
            if (iBinder == null) {
                return getIServiceManager().checkService(str);
            }
            return iBinder;
        } catch (RemoteException e) {
            Log.e(TAG, "error in checkService", e);
            return null;
        }
    }

    public static String[] listServices() {
        try {
            return getIServiceManager().listServices();
        } catch (RemoteException e) {
            Log.e(TAG, "error in listServices", e);
            return null;
        }
    }

    public static void initServiceCache(Map map) {
        if (sCache.size() != 0 && Process.supportsProcesses()) {
            throw new IllegalStateException("setServiceCache may only be called once");
        }
        sCache.putAll(map);
    }
}
