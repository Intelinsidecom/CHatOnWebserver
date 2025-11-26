package com.samsung.android.sdk.cover;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.util.Slog;
import com.samsung.android.cover.CoverState;
import com.samsung.android.cover.ICoverManager;
import com.samsung.android.cover.ICoverManagerCallback;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class ScoverManager {
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

    public interface ScoverStateListener {
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

    boolean isSupportTypeOfCover(int type) {
        switch (type) {
            case 0:
                return sIsFilpCoverSystemFeatureEnabled;
            case 1:
            case 3:
                return sIsSViewCoverSystemFeatureEnabled;
            case 2:
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

    /* JADX WARN: Multi-variable type inference failed */
    public void registerListener(ScoverStateListener listener) throws Throwable {
        ICoverManagerCallback.Stub coverListener;
        ICoverManagerCallback.Stub coverListenerDelegate;
        Log.d(TAG, "registerListener");
        if (!isSupportCover()) {
            Log.w(TAG, "registerListener : This device is not supported cover");
            return;
        }
        if (listener == null) {
            Log.w(TAG, "registerListener : listener is null");
            return;
        }
        synchronized (this.mListenerDelegates) {
            try {
                Iterator<CoverListenerDelegate> i = this.mListenerDelegates.iterator();
                while (true) {
                    if (!i.hasNext()) {
                        coverListener = null;
                        break;
                    }
                    CoverListenerDelegate delegate = i.next();
                    if (delegate.getListener().equals(listener)) {
                        coverListener = delegate;
                        break;
                    }
                }
                if (coverListener == null) {
                    try {
                        coverListenerDelegate = new CoverListenerDelegate(listener, null);
                        this.mListenerDelegates.add(coverListenerDelegate);
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } else {
                    coverListenerDelegate = coverListener;
                }
                try {
                    ICoverManager svc = getService();
                    if (svc != null) {
                        svc.registerCallback(coverListenerDelegate, new ComponentName(this.mContext.getPackageName(), getClass().getCanonicalName()));
                    }
                } catch (RemoteException e) {
                    Log.e(TAG, "RemoteException in registerListener: ", e);
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void unregisterListener(ScoverStateListener listener) {
        Log.d(TAG, "unregisterListener");
        if (!isSupportCover()) {
            Log.w(TAG, "unregisterListener : This device is not supported cover");
            return;
        }
        if (listener == null) {
            Log.w(TAG, "unregisterListener : listener is null");
            return;
        }
        synchronized (this.mListenerDelegates) {
            IBinder iBinder = null;
            Iterator<CoverListenerDelegate> i = this.mListenerDelegates.iterator();
            while (true) {
                if (!i.hasNext()) {
                    break;
                }
                CoverListenerDelegate next = i.next();
                if (next.getListener().equals(listener)) {
                    iBinder = next;
                    break;
                }
            }
            if (iBinder != null) {
                try {
                    ICoverManager svc = getService();
                    if (svc != null && svc.unregisterCallback(iBinder)) {
                        this.mListenerDelegates.remove(iBinder);
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
            ICoverManager svc = getService();
            if (svc != null) {
                CoverState coverState = svc.getCoverState();
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

    private class CoverListenerDelegate extends ICoverManagerCallback.Stub {
        private Handler mHandler;
        private final ScoverStateListener mListener;

        CoverListenerDelegate(ScoverStateListener listener, Handler handler) {
            Looper looper;
            this.mListener = listener;
            if (handler == null) {
                looper = ScoverManager.this.mContext.getMainLooper();
            } else {
                looper = handler.getLooper();
            }
            this.mHandler = new Handler(looper) { // from class: com.samsung.android.sdk.cover.ScoverManager.CoverListenerDelegate.1
                @Override // android.os.Handler
                public void handleMessage(Message msg) {
                    if (CoverListenerDelegate.this.mListener != null) {
                        CoverState coverState = (CoverState) msg.obj;
                        if (coverState != null) {
                            ScoverState scoverState = new ScoverState(coverState.switchState, coverState.type, coverState.color, coverState.widthPixel, coverState.heightPixel);
                            CoverListenerDelegate.this.mListener.onCoverStateChanged(scoverState);
                        } else {
                            Log.e(ScoverManager.TAG, "coverState : null");
                        }
                    }
                }
            };
        }

        public ScoverStateListener getListener() {
            return this.mListener;
        }

        public void coverCallback(CoverState state) throws RemoteException {
            Message msg = Message.obtain();
            msg.what = 0;
            msg.obj = state;
            this.mHandler.sendMessage(msg);
        }

        public String getListenerInfo() throws RemoteException {
            return this.mListener.toString();
        }
    }
}
