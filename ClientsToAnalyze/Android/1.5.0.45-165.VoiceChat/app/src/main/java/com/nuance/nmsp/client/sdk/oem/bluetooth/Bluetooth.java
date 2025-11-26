package com.nuance.nmsp.client.sdk.oem.bluetooth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;

/* loaded from: classes.dex */
public abstract class Bluetooth {

    /* renamed from: a */
    private static final LogFactory.Log f352a = LogFactory.getLog(Bluetooth.class);

    /* renamed from: b */
    private Object f353b = new Object();
    protected Context mContext;
    protected BluetoothHeadsetOEM mHeadset;

    protected Bluetooth(Context context) {
        this.mContext = context;
        this.mHeadset = new BluetoothHeadsetOEM(this.mContext);
    }

    public static Bluetooth createInstance(Context context) {
        int i = AndroidVersion.SDK;
        return (i < 8 || AndroidVersion.IS_BROKEN_HTC) ? new C0532b(context) : i < 9 ? new C0533c(context) : new C0531a(context);
    }

    public void close() {
        if (this.mHeadset != null) {
            try {
                this.mHeadset.close();
            } catch (Throwable th) {
            }
            this.mHeadset = null;
        }
    }

    public abstract int getPlaybackStream();

    public abstract int getRecordingSource();

    public boolean isHeadsetConnected() {
        return this.mHeadset.getConnectedDevice() != null;
    }

    public void startBluetoothSco() {
        IntentFilter intentFilter = new IntentFilter(BluetoothHeadsetOEM.ACTION_AUDIO_STATE_CHANGED);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.nuance.nmsp.client.sdk.oem.bluetooth.Bluetooth.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra(BluetoothHeadsetOEM.EXTRA_AUDIO_STATE, -1);
                if (Bluetooth.f352a.isInfoEnabled()) {
                    Bluetooth.f352a.info("BluetoothHeadset BroadcastReceiver " + intExtra);
                }
                synchronized (Bluetooth.this.f353b) {
                    if (intExtra == BluetoothHeadsetOEM.AUDIO_STATE_CONNECTED) {
                        if (Bluetooth.f352a.isInfoEnabled()) {
                            Bluetooth.f352a.info("BluetoothHeadset SCO connected. Notify wait lock.");
                        }
                        Bluetooth.this.f353b.notify();
                    }
                }
            }
        };
        synchronized (this.f353b) {
            this.mContext.registerReceiver(broadcastReceiver, intentFilter);
            long jCurrentTimeMillis = System.currentTimeMillis();
            startBluetoothScoInternal();
            try {
                this.f353b.wait(1500L);
            } catch (InterruptedException e) {
                if (f352a.isErrorEnabled()) {
                    f352a.error("BluetoothHeadset mHeadsetScoSyncObj.wait() threw exception:" + e);
                }
            }
            if (f352a.isInfoEnabled()) {
                f352a.info("BluetoothHeadset " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms to wait for SCO");
            }
        }
        this.mContext.unregisterReceiver(broadcastReceiver);
    }

    public abstract void startBluetoothScoInternal();

    public abstract void stopBluetoothSco();
}
