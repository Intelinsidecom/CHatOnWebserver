package com.samsung.android.service.gesture;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.samsung.android.service.gesture.IGestureCallback;
import com.samsung.android.service.gesture.IGestureService;
import com.sec.chaton.clientapi.GraphAPI;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class GestureManager {
    public static final String AIR_MOTION_AIRBROWSE = "air_motion_turn";
    public static final String AIR_MOTION_AIRJUMP = "air_motion_scroll";
    public static final String AIR_MOTION_AIRPIN = "air_motion_clip";
    public static final String AIR_MOTION_CALL_ACCEPT = "air_motion_call_accept";
    public static final String AIR_MOTION_MOVE = "air_motion_item_move";
    public static final String CAMERA_PROVIDER = "camera_provider";
    public static final String IR_PROVIDER = "ir_provider";
    private static final String TAG = "GestureManager";
    public static final String TSP_PROVIDER = "tsp_provider";
    private ServiceConnectionListener mConnectionListener;
    private Context mContext;
    private IGestureService mService;
    private boolean mBound = false;
    private final CopyOnWriteArrayList<GestureListenerDelegate> mListenerDelegates = new CopyOnWriteArrayList<>();
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.samsung.android.service.gesture.GestureManager.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName className, IBinder service) {
            Log.v(GestureManager.TAG, "onServiceConnected");
            GestureManager.this.mService = IGestureService.Stub.asInterface(service);
            GestureManager.this.mBound = true;
            GestureManager.this.mConnectionListener.onServiceConnected();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName className) {
            Log.v(GestureManager.TAG, "onServiceDisconnected");
            GestureManager.this.mBound = false;
            GestureManager.this.mConnectionListener.onServiceDisconnected();
        }
    };

    public interface ServiceConnectionListener {
        void onServiceConnected();

        void onServiceDisconnected();
    }

    public GestureManager(Context context, ServiceConnectionListener connectionListener) {
        this.mConnectionListener = connectionListener;
        this.mContext = context;
        bindtoService();
    }

    private void bindtoService() {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.app.gestureservice", "com.samsung.android.app.gestureservice.GestureService");
        this.mContext.bindService(intent, this.mConnection, 1);
    }

    public void unbindFromService() {
        if (this.mBound) {
            this.mContext.unbindService(this.mConnection);
            this.mBound = false;
        }
    }

    public void registerListener(GestureListener listener, String provider) {
        registerListener(listener, provider, AIR_MOTION_AIRJUMP);
    }

    public void registerListener(GestureListener listener, String provider, String eventType) {
        if (!this.mBound) {
            bindtoService();
            return;
        }
        Log.d(TAG, "registerListener");
        if (listener != null) {
            GestureListenerDelegate gestureListener = null;
            Iterator<GestureListenerDelegate> i = this.mListenerDelegates.iterator();
            while (true) {
                if (!i.hasNext()) {
                    break;
                }
                GestureListenerDelegate delegate = i.next();
                if (delegate.getListener().equals(listener)) {
                    gestureListener = delegate;
                    break;
                }
            }
            if (gestureListener == null) {
                gestureListener = new GestureListenerDelegate(listener, null);
                this.mListenerDelegates.add(gestureListener);
            }
            try {
                this.mService.registerCallback(gestureListener, provider, eventType);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException in registerListener: ", e);
            }
        }
    }

    public void unregisterListener(GestureListener listener) {
        unregisterListener(listener, CAMERA_PROVIDER);
        unregisterListener(listener, IR_PROVIDER);
        unregisterListener(listener, TSP_PROVIDER);
    }

    public void unregisterListener(GestureListener listener, String provider) {
        Log.v(TAG, "unregisterListener");
        if (listener != null) {
            GestureListenerDelegate gestureListener = null;
            Iterator<GestureListenerDelegate> i = this.mListenerDelegates.iterator();
            while (true) {
                if (!i.hasNext()) {
                    break;
                }
                GestureListenerDelegate delegate = i.next();
                if (delegate.getListener().equals(listener)) {
                    gestureListener = delegate;
                    break;
                }
            }
            if (gestureListener != null) {
                try {
                    if (this.mService.unregisterCallback(gestureListener, provider)) {
                        this.mListenerDelegates.remove(gestureListener);
                    }
                } catch (RemoteException e) {
                    Log.e(TAG, "RemoteException in unregisterListener: ", e);
                }
            }
        }
    }

    public void resetGestureService(String service) {
        try {
            this.mService.resetGestureService(service);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public List<String> getProviders() {
        try {
            return this.mService.getProviders();
        } catch (RemoteException ex) {
            Log.e(TAG, "getProviders: RemoteException", ex);
            return null;
        }
    }

    public GestureProviderInfo getProvider(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name==null");
        }
        try {
            Bundle info = this.mService.getProviderInfo(name);
            if (info == null) {
                return null;
            }
            return createProvider(name, info);
        } catch (RemoteException ex) {
            Log.e(TAG, "getProvider: RemoteException", ex);
            return null;
        }
    }

    private GestureProviderInfo createProvider(String name, Bundle info) {
        GestureProviderInfo provider = new GestureProviderInfo();
        provider.setName(info.getString(GraphAPI.ME_NAME));
        provider.setSupportedGestures(info.getIntegerArrayList("supported_gesture"));
        return provider;
    }

    private class GestureListenerDelegate extends IGestureCallback.Stub {
        private Handler mHandler;
        private final GestureListener mListener;

        GestureListenerDelegate(GestureListener listener, Handler handler) {
            Looper looper;
            this.mListener = listener;
            if (handler == null) {
                looper = GestureManager.this.mContext.getMainLooper();
            } else {
                looper = handler.getLooper();
            }
            this.mHandler = new Handler(looper) { // from class: com.samsung.android.service.gesture.GestureManager.GestureListenerDelegate.1
                @Override // android.os.Handler
                public void handleMessage(Message msg) {
                    if (GestureListenerDelegate.this.mListener != null) {
                        GestureEvent gestureEvent = (GestureEvent) msg.obj;
                        if (gestureEvent != null) {
                            GestureListenerDelegate.this.mListener.onGestureEvent(gestureEvent);
                        } else {
                            Log.e(GestureManager.TAG, "gestureEvent : null");
                        }
                    }
                }
            };
        }

        public GestureListener getListener() {
            return this.mListener;
        }

        @Override // com.samsung.android.service.gesture.IGestureCallback
        @Deprecated
        public void gestureCallback(GestureEvent event) throws RemoteException {
            Message msg = Message.obtain();
            msg.what = 0;
            msg.obj = event;
            this.mHandler.sendMessage(msg);
        }

        @Override // com.samsung.android.service.gesture.IGestureCallback
        @Deprecated
        public String getListenerInfo() throws RemoteException {
            return this.mListener.toString();
        }
    }
}
