package com.sec.chaton.chat.notification;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3250y;

/* compiled from: sensorChangeListenerOnCall.java */
/* renamed from: com.sec.chaton.chat.notification.ab */
/* loaded from: classes.dex */
public class C1105ab implements SensorEventListener {

    /* renamed from: a */
    private boolean f4477a;

    /* renamed from: b */
    private boolean f4478b;

    /* renamed from: c */
    private String f4479c;

    public C1105ab(boolean z) {
        this.f4478b = z;
        this.f4477a = false;
        this.f4479c = "";
    }

    public C1105ab(String str) {
        this.f4478b = false;
        this.f4479c = str;
        this.f4477a = true;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 8) {
            if (sensorEvent.values[0] == 0.0f) {
                C3250y.m11453c("do not show popup", "sensorListener");
            } else {
                C1103a.m5432a(GlobalApplication.m11493l()).m5456a(this.f4479c, this.f4477a, this.f4478b);
            }
        }
        ((SensorManager) GlobalApplication.m11493l().getSystemService("sensor")).unregisterListener(this);
    }
}
