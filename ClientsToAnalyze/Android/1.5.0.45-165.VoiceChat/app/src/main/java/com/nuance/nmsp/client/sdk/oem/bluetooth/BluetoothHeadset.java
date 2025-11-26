package com.nuance.nmsp.client.sdk.oem.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
public class BluetoothHeadset {
    public static final String ACTION_AUDIO_STATE_CHANGED;
    public static final String ACTION_STATE_CHANGED;
    public static final int AUDIO_STATE_CONNECTED;
    public static final int AUDIO_STATE_DISCONNECTED;
    public static final String EXTRA_AUDIO_STATE;
    public static final String EXTRA_STATE;
    public static final int PRIORITY_OFF;
    public static final int PRIORITY_UNDEFINED;
    public static final int STATE_CONNECTED;
    public static final int STATE_CONNECTING;
    public static final int STATE_DISCONNECTED;
    public static final int STATE_ERROR;

    /* renamed from: a */
    private static final Constructor<?> f355a;

    /* renamed from: b */
    private static final Method f356b;

    /* renamed from: c */
    private static final Method f357c;

    /* renamed from: d */
    private static final Method f358d;

    /* renamed from: e */
    private static final Method f359e;

    /* renamed from: f */
    private static final Method f360f;

    /* renamed from: g */
    private static final Method f361g;

    /* renamed from: h */
    private static final Method f362h;

    /* renamed from: i */
    private static final Class<?> f363i;

    /* renamed from: j */
    private static final boolean f364j;

    /* renamed from: k */
    private static final Method f365k;

    /* renamed from: l */
    private static final Method f366l;

    /* renamed from: m */
    private Object f367m;

    /* renamed from: n */
    private ServiceListener f368n;

    public interface ServiceListener {
        void onServiceConnected();

        void onServiceDisconnected();
    }

    static {
        Method method;
        boolean z;
        Reflection reflection = new Reflection();
        Class<?> classForName = reflection.getClassForName("android.bluetooth.BluetoothHeadset");
        Class<?> classForName2 = reflection.getClassForName("android.bluetooth.BluetoothHeadset$ServiceListener");
        f355a = reflection.getConstructor(classForName, Context.class, classForName2);
        Method methodOrNull = reflection.getMethodOrNull(classForName, "getState", new Class[0]);
        if (methodOrNull == null) {
            method = reflection.getMethod(classForName, "getState", BluetoothDevice.class);
            z = true;
        } else {
            method = methodOrNull;
            z = false;
        }
        f356b = method;
        f364j = z;
        f359e = reflection.getMethod(classForName, "getCurrentHeadset", new Class[0]);
        f361g = reflection.getMethod(classForName, "connectHeadset", BluetoothDevice.class);
        Method methodOrNull2 = reflection.getMethodOrNull(classForName, "disconnectHeadset", new Class[0]);
        if (methodOrNull2 == null) {
            methodOrNull2 = reflection.getMethod(classForName, "disconnectHeadset", BluetoothDevice.class);
        }
        f360f = methodOrNull2;
        f357c = reflection.getMethod(classForName, "startVoiceRecognition", new Class[0]);
        f358d = reflection.getMethod(classForName, "stopVoiceRecognition", new Class[0]);
        f362h = reflection.getMethod(classForName, "close", new Class[0]);
        f365k = reflection.getMethod(classForName, "getPriority", BluetoothDevice.class);
        f366l = reflection.getMethod(classForName, "setPriority", BluetoothDevice.class, Integer.TYPE);
        f363i = classForName2;
        ACTION_STATE_CHANGED = (String) reflection.getFieldValue(classForName, "ACTION_STATE_CHANGED");
        ACTION_AUDIO_STATE_CHANGED = (String) reflection.getFieldValue(classForName, "ACTION_AUDIO_STATE_CHANGED");
        EXTRA_STATE = (String) reflection.getFieldValue(classForName, "EXTRA_STATE");
        EXTRA_AUDIO_STATE = (String) reflection.getFieldValue(classForName, "EXTRA_AUDIO_STATE");
        STATE_ERROR = ((Integer) reflection.getFieldValue(classForName, "STATE_ERROR")).intValue();
        STATE_DISCONNECTED = ((Integer) reflection.getFieldValue(classForName, "STATE_DISCONNECTED")).intValue();
        STATE_CONNECTING = ((Integer) reflection.getFieldValue(classForName, "STATE_CONNECTING")).intValue();
        STATE_CONNECTED = ((Integer) reflection.getFieldValue(classForName, "STATE_CONNECTED")).intValue();
        AUDIO_STATE_DISCONNECTED = ((Integer) reflection.getFieldValue(classForName, "AUDIO_STATE_DISCONNECTED")).intValue();
        AUDIO_STATE_CONNECTED = ((Integer) reflection.getFieldValue(classForName, "AUDIO_STATE_CONNECTED")).intValue();
        PRIORITY_OFF = ((Integer) reflection.getFieldValue(classForName, "PRIORITY_OFF")).intValue();
        PRIORITY_UNDEFINED = ((Integer) reflection.getFieldValue(classForName, "PRIORITY_UNDEFINED", -1)).intValue();
    }

    public BluetoothHeadset(Context context, ServiceListener serviceListener) throws IllegalArgumentException {
        this.f368n = serviceListener;
        try {
            this.f367m = f355a.newInstance(context, Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{f363i}, new InvocationHandler() { // from class: com.nuance.nmsp.client.sdk.oem.bluetooth.BluetoothHeadset.1
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    if (method.getName().equals("onServiceConnected")) {
                        if (BluetoothHeadset.this.f368n == null) {
                            return null;
                        }
                        BluetoothHeadset.this.f368n.onServiceConnected();
                        return null;
                    }
                    if (!method.getName().equals("onServiceDisconnected") || BluetoothHeadset.this.f368n == null) {
                        return null;
                    }
                    BluetoothHeadset.this.f368n.onServiceDisconnected();
                    return null;
                }
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            f362h.invoke(this.f367m, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean connectHeadset(BluetoothDevice bluetoothDevice) {
        try {
            if (f361g != null) {
                return ((Boolean) f361g.invoke(this.f367m, bluetoothDevice)).booleanValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void disconnectHeadset() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (f360f != null) {
                f360f.invoke(this.f367m, new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnectHeadset(BluetoothDevice bluetoothDevice) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (f360f != null) {
                f360f.invoke(this.f367m, bluetoothDevice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BluetoothDevice getConnectedDevice() {
        try {
            if (f359e != null) {
                return (BluetoothDevice) f359e.invoke(this.f367m, new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getPriority(BluetoothDevice bluetoothDevice) {
        int i = PRIORITY_UNDEFINED;
        try {
            if (f365k != null) {
                return ((Integer) f365k.invoke(this.f367m, bluetoothDevice)).intValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public int getState() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int iIntValue;
        try {
            if (f364j) {
                iIntValue = ((Integer) f356b.invoke(this.f367m, f359e.invoke(this.f367m, new Object[0]))).intValue();
            } else {
                iIntValue = ((Integer) f356b.invoke(this.f367m, new Object[0])).intValue();
            }
            return iIntValue;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean setPriority(BluetoothDevice bluetoothDevice, int i) {
        try {
            if (f366l != null) {
                return ((Boolean) f366l.invoke(this.f367m, bluetoothDevice, Integer.valueOf(i))).booleanValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean startVoiceRecognition() {
        try {
            return ((Boolean) f357c.invoke(this.f367m, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean stopVoiceRecognition() {
        try {
            return ((Boolean) f358d.invoke(this.f367m, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
