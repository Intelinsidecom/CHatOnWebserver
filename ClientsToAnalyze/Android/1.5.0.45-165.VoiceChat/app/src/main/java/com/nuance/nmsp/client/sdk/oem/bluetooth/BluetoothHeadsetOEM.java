package com.nuance.nmsp.client.sdk.oem.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Looper;
import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.oem.bluetooth.BluetoothHeadset;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/* loaded from: classes.dex */
public class BluetoothHeadsetOEM {
    public static String ACTION_AUDIO_STATE_CHANGED;
    public static int AUDIO_STATE_CONNECTED;
    public static String EXTRA_AUDIO_STATE;

    /* renamed from: a */
    private static final LogFactory.Log f370a = LogFactory.getLog(Bluetooth.class);

    /* renamed from: b */
    private Context f371b;

    /* renamed from: c */
    private boolean f372c;

    /* renamed from: d */
    private BluetoothHeadset f373d;

    /* renamed from: e */
    private boolean f374e;

    /* renamed from: f */
    private boolean f375f = false;

    /* renamed from: g */
    private Object f376g = null;

    /* renamed from: i */
    private Object f378i = new Object();

    /* renamed from: h */
    private final Reflection f377h = new Reflection();

    public BluetoothHeadsetOEM(Context context) throws InterruptedException, IllegalArgumentException {
        BluetoothAdapter defaultAdapter;
        this.f373d = null;
        this.f374e = false;
        this.f371b = context;
        if (AndroidVersion.SDK <= 10) {
            this.f372c = true;
            ACTION_AUDIO_STATE_CHANGED = BluetoothHeadset.ACTION_AUDIO_STATE_CHANGED;
            EXTRA_AUDIO_STATE = BluetoothHeadset.EXTRA_AUDIO_STATE;
            AUDIO_STATE_CONNECTED = BluetoothHeadset.AUDIO_STATE_CONNECTED;
            BluetoothHeadset.ServiceListener serviceListener = new BluetoothHeadset.ServiceListener() { // from class: com.nuance.nmsp.client.sdk.oem.bluetooth.BluetoothHeadsetOEM.1
                @Override // com.nuance.nmsp.client.sdk.oem.bluetooth.BluetoothHeadset.ServiceListener
                public final void onServiceConnected() {
                    if (BluetoothHeadsetOEM.f370a.isInfoEnabled()) {
                        BluetoothHeadsetOEM.f370a.info("BluetoothHeadsetOEM reflected onServiceConnected()");
                    }
                    synchronized (BluetoothHeadsetOEM.this.f378i) {
                        if (BluetoothHeadsetOEM.this.f374e) {
                            BluetoothHeadsetOEM.this.m128b();
                        } else {
                            BluetoothHeadsetOEM.m127a(BluetoothHeadsetOEM.this, true);
                            BluetoothHeadsetOEM.this.f378i.notify();
                        }
                    }
                }

                @Override // com.nuance.nmsp.client.sdk.oem.bluetooth.BluetoothHeadset.ServiceListener
                public final void onServiceDisconnected() {
                    if (BluetoothHeadsetOEM.f370a.isInfoEnabled()) {
                        BluetoothHeadsetOEM.f370a.info("BluetoothHeadsetOEM reflected onServiceDisconnected()");
                    }
                    synchronized (BluetoothHeadsetOEM.this.f378i) {
                        BluetoothHeadsetOEM.this.m128b();
                        if (!BluetoothHeadsetOEM.this.f374e) {
                            BluetoothHeadsetOEM.m127a(BluetoothHeadsetOEM.this, true);
                            BluetoothHeadsetOEM.this.f378i.notify();
                        }
                    }
                }
            };
            synchronized (this.f378i) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.f373d = new BluetoothHeadset(this.f371b, serviceListener);
                try {
                    this.f378i.wait(1000L);
                } catch (InterruptedException e) {
                    if (f370a.isErrorEnabled()) {
                        f370a.error("BluetoothHeadsetOEM reflected mHeadsetSyncObj.wait() threw exception:" + e);
                    }
                }
                if (!this.f375f) {
                    if (f370a.isErrorEnabled()) {
                        f370a.error("BluetoothHeadsetOEM reflected service NOT connected in time. Gave up!!!");
                    }
                    this.f374e = true;
                    m128b();
                } else if (f370a.isInfoEnabled()) {
                    f370a.info("BluetoothHeadsetOEM reflected service connection took " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
                }
            }
            return;
        }
        this.f372c = false;
        Class<?> classForName = this.f377h.getClassForName("android.bluetooth.BluetoothHeadset");
        ACTION_AUDIO_STATE_CHANGED = (String) this.f377h.getFieldValue(classForName, "ACTION_AUDIO_STATE_CHANGED");
        EXTRA_AUDIO_STATE = (String) this.f377h.getFieldValue(classForName, "EXTRA_STATE");
        AUDIO_STATE_CONNECTED = ((Integer) this.f377h.getFieldValue(classForName, "STATE_AUDIO_CONNECTED")).intValue();
        if (AndroidVersion.SDK == 11 || AndroidVersion.SDK == 12 || AndroidVersion.SDK == 13 || AndroidVersion.SDK == 14 || AndroidVersion.SDK == 15) {
            final Object[] objArr = new Object[2];
            new Thread(new Runnable(this) { // from class: com.nuance.nmsp.client.sdk.oem.bluetooth.BluetoothHeadsetOEM.2
                @Override // java.lang.Runnable
                public final void run() {
                    Looper.prepare();
                    objArr[1] = BluetoothAdapter.getDefaultAdapter();
                    objArr[0] = new Boolean(true);
                    Looper.loop();
                }
            }).start();
            while (objArr[0] == null) {
                try {
                    Thread.sleep(10L);
                } catch (Exception e2) {
                }
            }
            defaultAdapter = (BluetoothAdapter) objArr[1];
        } else {
            defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        Class<?> classForName2 = this.f377h.getClassForName("android.bluetooth.BluetoothProfile$ServiceListener");
        Object objNewProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{classForName2}, new InvocationHandler() { // from class: com.nuance.nmsp.client.sdk.oem.bluetooth.BluetoothHeadsetOEM.3
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr2) throws Throwable {
                if (!method.getName().equals("onServiceConnected")) {
                    if (!method.getName().equals("onServiceDisconnected")) {
                        return null;
                    }
                    if (BluetoothHeadsetOEM.f370a.isInfoEnabled()) {
                        BluetoothHeadsetOEM.f370a.info("BluetoothHeadsetOEM native onServiceDisconnected()");
                    }
                    synchronized (BluetoothHeadsetOEM.this.f378i) {
                        if (!BluetoothHeadsetOEM.this.f374e) {
                            BluetoothHeadsetOEM.m127a(BluetoothHeadsetOEM.this, true);
                            BluetoothHeadsetOEM.this.f378i.notify();
                        }
                    }
                    return null;
                }
                if (BluetoothHeadsetOEM.f370a.isInfoEnabled()) {
                    BluetoothHeadsetOEM.f370a.info("BluetoothHeadsetOEM native onServiceConnected()");
                }
                synchronized (BluetoothHeadsetOEM.this.f378i) {
                    if (BluetoothHeadsetOEM.this.f374e) {
                        BluetoothHeadsetOEM.this.m126a(objArr2[1]);
                    } else {
                        BluetoothHeadsetOEM.m127a(BluetoothHeadsetOEM.this, true);
                        BluetoothHeadsetOEM.this.f376g = objArr2[1];
                        BluetoothHeadsetOEM.this.f378i.notify();
                    }
                }
                return null;
            }
        });
        synchronized (this.f378i) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            try {
                this.f377h.getMethod(this.f377h.getClassForName("android.bluetooth.BluetoothAdapter"), "getProfileProxy", Context.class, classForName2, Integer.TYPE).invoke(defaultAdapter, context, objNewProxyInstance, this.f377h.getFieldValue(this.f377h.getClassForName("android.bluetooth.BluetoothProfile"), "HEADSET"));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                this.f378i.wait(1000L);
            } catch (InterruptedException e4) {
                if (f370a.isErrorEnabled()) {
                    f370a.error("BluetoothHeadsetOEM native mHeadsetSyncObj.wait() threw exception:" + e4);
                }
            }
            if (!this.f375f) {
                if (f370a.isErrorEnabled()) {
                    f370a.error("BluetoothHeadsetOEM native service NOT connected in time. Gave up!!!");
                }
                this.f374e = true;
            } else if (f370a.isInfoEnabled()) {
                f370a.info("BluetoothHeadsetOEM native service connection took " + (System.currentTimeMillis() - jCurrentTimeMillis2) + "ms");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m126a(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> classForName = this.f377h.getClassForName("android.bluetooth.BluetoothProfile");
        try {
            this.f377h.getMethodOrNull(this.f377h.getClassForName("android.bluetooth.BluetoothAdapter"), "closeProfileProxy", Integer.TYPE, classForName).invoke(BluetoothAdapter.getDefaultAdapter(), (Integer) this.f377h.getFieldValue(classForName, "HEADSET"), obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m127a(BluetoothHeadsetOEM bluetoothHeadsetOEM, boolean z) {
        bluetoothHeadsetOEM.f375f = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m128b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f373d != null) {
            this.f373d.close();
            this.f373d = null;
        }
    }

    public void close() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f372c) {
            m128b();
        } else if (this.f376g != null) {
            m126a(this.f376g);
            this.f376g = null;
        }
    }

    public BluetoothDevice getConnectedDevice() {
        List list;
        if (this.f372c && this.f373d != null) {
            return this.f373d.getConnectedDevice();
        }
        if (this.f372c || this.f376g == null) {
            return null;
        }
        try {
            list = (List) this.f377h.getMethodOrNull(this.f377h.getClassForName("android.bluetooth.BluetoothProfile"), "getConnectedDevices", new Class[0]).invoke(this.f376g, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            list = null;
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (BluetoothDevice) list.get(0);
    }

    public boolean startVoiceRecognition() {
        if (this.f372c) {
            if (this.f373d == null) {
                return false;
            }
            return this.f373d.startVoiceRecognition();
        }
        if (!f370a.isErrorEnabled()) {
            return false;
        }
        f370a.error("BluetoothHeadsetOEM startVoiceRecognition() called on native headset!!!");
        return false;
    }

    public boolean stopVoiceRecognition() {
        if (this.f372c) {
            if (this.f373d == null) {
                return false;
            }
            return this.f373d.stopVoiceRecognition();
        }
        if (!f370a.isErrorEnabled()) {
            return false;
        }
        f370a.error("BluetoothHeadsetOEM stopVoiceRecognition() called on native headset!!!");
        return false;
    }
}
