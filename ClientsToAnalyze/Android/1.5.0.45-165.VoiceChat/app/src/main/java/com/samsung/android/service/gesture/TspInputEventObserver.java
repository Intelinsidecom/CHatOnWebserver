package com.samsung.android.service.gesture;

import android.content.Context;
import com.samsung.android.service.gesture.GestureManager;

/* loaded from: classes.dex */
public class TspInputEventObserver {
    public static final String NAME = "tsp_inputevent_observer";
    private boolean mConnected = false;
    private GestureManager mGestureManager;

    public TspInputEventObserver(Context context) {
        this.mGestureManager = new GestureManager(context, new GestureManager.ServiceConnectionListener() { // from class: com.samsung.android.service.gesture.TspInputEventObserver.1
            @Override // com.samsung.android.service.gesture.GestureManager.ServiceConnectionListener
            public void onServiceDisconnected() {
                TspInputEventObserver.this.mConnected = false;
            }

            @Override // com.samsung.android.service.gesture.GestureManager.ServiceConnectionListener
            public void onServiceConnected() {
                TspInputEventObserver.this.mConnected = true;
            }
        });
    }
}
