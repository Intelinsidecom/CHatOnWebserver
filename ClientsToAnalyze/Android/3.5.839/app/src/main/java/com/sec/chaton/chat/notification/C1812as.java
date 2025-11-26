package com.sec.chaton.chat.notification;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4904y;

/* compiled from: SensorChangeListenerOnCall.java */
/* renamed from: com.sec.chaton.chat.notification.as */
/* loaded from: classes.dex */
public class C1812as implements SensorEventListener {

    /* renamed from: a */
    private boolean f6830a;

    /* renamed from: b */
    private boolean f6831b;

    /* renamed from: c */
    private String f6832c;

    public C1812as(boolean z) {
        this.f6831b = z;
        this.f6830a = false;
        this.f6832c = "";
    }

    public C1812as(String str) {
        this.f6831b = false;
        this.f6832c = str;
        this.f6830a = true;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 8) {
            if (sensorEvent.values[0] == 0.0f) {
                C4904y.m18641c("do not show popup", "sensorListener");
            } else {
                C1813b.m8906b().m8929a(this.f6832c, this.f6830a, this.f6831b);
            }
        }
        ((SensorManager) GlobalApplication.m18732r().getSystemService("sensor")).unregisterListener(this);
    }
}
