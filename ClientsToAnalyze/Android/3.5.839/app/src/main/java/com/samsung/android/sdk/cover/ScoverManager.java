package com.samsung.android.sdk.cover;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.p004os.ServiceManager;
import android.util.Log;
import android.util.Slog;
import android.view.Window;
import android.view.WindowManager;
import com.samsung.android.cover.CoverState;
import com.samsung.android.cover.ICoverManager;
import com.samsung.android.cover.ICoverManagerCallback;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class ScoverManager {
    public static final int COVER_MODE_HIDE_SVIEW_ONCE = 2;
    public static final int COVER_MODE_NONE = 0;
    public static final int COVER_MODE_SVIEW = 1;
    private static final String FEATURE_COVER_FLIP = "com.sec.feature.cover.flip";
    private static final String FEATURE_COVER_SVIEW = "com.sec.feature.cover.sview";
    static final int SDK_VERSION = 16777216;
    private static final String TAG = "CoverManager";
    private Context mContext;
    private final CopyOnWriteArrayList<CoverListenerDelegate> mListenerDelegates = new CopyOnWriteArrayList<>();
    private ICoverManager mService;
    private static boolean sIsSystemFeatureQueried = false;
    private static boolean sIsFilpCoverSystemFeatureEnabled = false;
    private static boolean sIsSViewCoverSystemFeatureEnabled = false;

    @Deprecated
    public interface ScoverStateListener {
        void onCoverStateChanged(ScoverState scoverState);
    }

    public interface StateListener {
        void onCoverStateChanged(ScoverState scoverState);
    }

    public ScoverManager(Context context) {
        this.mContext = context;
        initSystemFeature();
    }

    private void initSystemFeature() {
        if (!sIsSystemFeatureQueried) {
            sIsFilpCoverSystemFeatureEnabled = this.mContext.getPackageManager().hasSystemFeature(FEATURE_COVER_FLIP);
            sIsSViewCoverSystemFeatureEnabled = this.mContext.getPackageManager().hasSystemFeature(FEATURE_COVER_SVIEW);
            sIsSystemFeatureQueried = true;
        }
    }

    boolean isSupportCover() {
        return sIsFilpCoverSystemFeatureEnabled || sIsSViewCoverSystemFeatureEnabled;
    }

    boolean isSupportSViewCover() {
        return sIsSViewCoverSystemFeatureEnabled;
    }

    boolean isSupportTypeOfCover(int i) {
        switch (i) {
            case 0:
                return sIsFilpCoverSystemFeatureEnabled;
            case 1:
            case 3:
            case 5:
                return sIsSViewCoverSystemFeatureEnabled;
            case 2:
            case 4:
            default:
                return false;
        }
    }

    private synchronized ICoverManager getService() {
        if (this.mService == null) {
            this.mService = ICoverManager.Stub.asInterface(ServiceManager.getService("cover"));
            if (this.mService == null) {
                Slog.w(TAG, "warning: no COVER_MANAGER_SERVICE");
            }
        }
        return this.mService;
    }

    public void setCoverModeToWindow(Window window, int i) {
        if (!isSupportSViewCover()) {
            Log.w(TAG, "setSViewCoverModeToWindow : This device is not supported s view cover");
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes != null) {
            attributes.coverMode = i;
            window.setAttributes(attributes);
        }
    }

    @Deprecated
    public void registerListener(ScoverStateListener scoverStateListener) {
        Log.d(TAG, "registerListener : Use deprecated API!! Change ScoverStateListener to StateListener");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072 A[Catch: all -> 0x0074, DONT_GENERATE, TRY_ENTER, TryCatch #0 {, blocks: (B:10:0x0029, B:11:0x002f, B:13:0x0035, B:16:0x0047, B:17:0x0052, B:19:0x0058, B:22:0x006f, B:23:0x0072, B:29:0x0078), top: B:32:0x0029, inners: #1 }] */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.samsung.android.sdk.cover.ScoverManager$CoverListenerDelegate] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.samsung.android.sdk.cover.ScoverManager$CoverListenerDelegate, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void registerListener(com.samsung.android.sdk.cover.ScoverManager.StateListener r7) {
        /*
            r6 = this;
            r1 = 0
            java.lang.String r0 = "CoverManager"
            java.lang.String r2 = "registerListener"
            android.util.Log.d(r0, r2)
            boolean r0 = r6.isSupportCover()
            if (r0 != 0) goto L1a
            java.lang.String r0 = "CoverManager"
            java.lang.String r1 = "registerListener : This device is not supported cover"
            android.util.Log.w(r0, r1)
        L19:
            return
        L1a:
            if (r7 != 0) goto L26
            java.lang.String r0 = "CoverManager"
            java.lang.String r1 = "registerListener : listener is null"
            android.util.Log.w(r0, r1)
            goto L19
        L26:
            java.util.concurrent.CopyOnWriteArrayList<com.samsung.android.sdk.cover.ScoverManager$CoverListenerDelegate> r2 = r6.mListenerDelegates
            monitor-enter(r2)
            java.util.concurrent.CopyOnWriteArrayList<com.samsung.android.sdk.cover.ScoverManager$CoverListenerDelegate> r0 = r6.mListenerDelegates     // Catch: java.lang.Throwable -> L74
            java.util.Iterator r3 = r0.iterator()     // Catch: java.lang.Throwable -> L74
        L2f:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L74
            if (r0 == 0) goto L82
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L74
            com.samsung.android.sdk.cover.ScoverManager$CoverListenerDelegate r0 = (com.samsung.android.sdk.cover.ScoverManager.CoverListenerDelegate) r0     // Catch: java.lang.Throwable -> L74
            com.samsung.android.sdk.cover.ScoverManager$StateListener r4 = r0.getListener()     // Catch: java.lang.Throwable -> L74
            boolean r4 = r4.equals(r7)     // Catch: java.lang.Throwable -> L74
            if (r4 == 0) goto L2f
        L45:
            if (r0 != 0) goto L52
            com.samsung.android.sdk.cover.ScoverManager$CoverListenerDelegate r0 = new com.samsung.android.sdk.cover.ScoverManager$CoverListenerDelegate     // Catch: java.lang.Throwable -> L74
            r1 = 0
            r0.<init>(r7, r1)     // Catch: java.lang.Throwable -> L74
            java.util.concurrent.CopyOnWriteArrayList<com.samsung.android.sdk.cover.ScoverManager$CoverListenerDelegate> r1 = r6.mListenerDelegates     // Catch: java.lang.Throwable -> L74
            r1.add(r0)     // Catch: java.lang.Throwable -> L74
        L52:
            com.samsung.android.cover.ICoverManager r1 = r6.getService()     // Catch: java.lang.Throwable -> L74 android.os.RemoteException -> L77
            if (r1 == 0) goto L72
            android.content.ComponentName r3 = new android.content.ComponentName     // Catch: java.lang.Throwable -> L74 android.os.RemoteException -> L77
            android.content.Context r4 = r6.mContext     // Catch: java.lang.Throwable -> L74 android.os.RemoteException -> L77
            java.lang.String r4 = r4.getPackageName()     // Catch: java.lang.Throwable -> L74 android.os.RemoteException -> L77
            java.lang.Class r5 = r6.getClass()     // Catch: java.lang.Throwable -> L74 android.os.RemoteException -> L77
            java.lang.String r5 = r5.getCanonicalName()     // Catch: java.lang.Throwable -> L74 android.os.RemoteException -> L77
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L74 android.os.RemoteException -> L77
            if (r0 == 0) goto L72
            if (r3 == 0) goto L72
            r1.registerCallback(r0, r3)     // Catch: java.lang.Throwable -> L74 android.os.RemoteException -> L77
        L72:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L74
            goto L19
        L74:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L74
            throw r0
        L77:
            r0 = move-exception
            java.lang.String r1 = "CoverManager"
            java.lang.String r3 = "RemoteException in registerListener: "
            android.util.Log.e(r1, r3, r0)     // Catch: java.lang.Throwable -> L74
            goto L72
        L82:
            r0 = r1
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.sdk.cover.ScoverManager.registerListener(com.samsung.android.sdk.cover.ScoverManager$StateListener):void");
    }

    @Deprecated
    public void unregisterListener(ScoverStateListener scoverStateListener) {
        Log.d(TAG, "unregisterListener : Use deprecated API!! Change ScoverStateListener to StateListener");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.os.IBinder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.samsung.android.sdk.cover.ScoverManager$CoverListenerDelegate] */
    public void unregisterListener(StateListener stateListener) {
        CoverListenerDelegate next;
        Log.d(TAG, "unregisterListener");
        if (!isSupportCover()) {
            Log.w(TAG, "unregisterListener : This device is not supported cover");
            return;
        }
        if (stateListener == null) {
            Log.w(TAG, "unregisterListener : listener is null");
            return;
        }
        synchronized (this.mListenerDelegates) {
            Iterator<CoverListenerDelegate> it = this.mListenerDelegates.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = 0;
                    break;
                } else {
                    next = it.next();
                    if (next.getListener().equals(stateListener)) {
                        break;
                    }
                }
            }
            if (next != 0) {
                try {
                    ICoverManager service = getService();
                    if (service != null && service.unregisterCallback((IBinder) next)) {
                        this.mListenerDelegates.remove((Object) next);
                    }
                } catch (RemoteException e) {
                    Log.e(TAG, "RemoteException in unregisterListener: ", e);
                }
            }
        }
    }

    public ScoverState getCoverState() {
        if (!isSupportCover()) {
            Log.w(TAG, "getCoverState : This device is not supported cover");
            return null;
        }
        try {
            ICoverManager service = getService();
            if (service != null) {
                CoverState coverState = service.getCoverState();
                if (coverState != null) {
                    return new ScoverState(coverState.switchState, coverState.type, coverState.color, coverState.widthPixel, coverState.heightPixel);
                }
                Log.e(TAG, "getCoverState : coverState is null");
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in getCoverState: ", e);
        }
        return null;
    }

    class CoverListenerDelegate extends ICoverManagerCallback.Stub {
        private Handler mHandler;
        private final StateListener mListener;

        CoverListenerDelegate(StateListener stateListener, Handler handler) {
            Looper looper;
            this.mListener = stateListener;
            if (handler == null) {
                looper = ScoverManager.this.mContext.getMainLooper();
            } else {
                looper = handler.getLooper();
            }
            this.mHandler = new Handler(looper) { // from class: com.samsung.android.sdk.cover.ScoverManager.CoverListenerDelegate.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (CoverListenerDelegate.this.mListener != null) {
                        CoverState coverState = (CoverState) message.obj;
                        if (coverState != null) {
                            CoverListenerDelegate.this.mListener.onCoverStateChanged(new ScoverState(coverState.switchState, coverState.type, coverState.color, coverState.widthPixel, coverState.heightPixel));
                        } else {
                            Log.e(ScoverManager.TAG, "coverState : null");
                        }
                    }
                }
            };
        }

        public StateListener getListener() {
            return this.mListener;
        }

        public void coverCallback(CoverState coverState) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 0;
            messageObtain.obj = coverState;
            this.mHandler.sendMessage(messageObtain);
        }

        public String getListenerInfo() {
            return this.mListener.toString();
        }
    }
}
