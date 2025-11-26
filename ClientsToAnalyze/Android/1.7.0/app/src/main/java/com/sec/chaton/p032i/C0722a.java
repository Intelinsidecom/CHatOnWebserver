package com.sec.chaton.p032i;

import android.content.Context;
import android.hardware.motion.MREvent;
import android.hardware.motion.MRListener;
import android.hardware.motion.MotionRecognitionManager;
import android.provider.Settings;
import com.sec.chaton.coolots.AbstractC0617h;
import com.sec.chaton.p013a.p014a.C0159bh;
import com.sec.chaton.util.C1341p;
import com.sec.p007b.p008a.C0111b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: MotionManager.java */
/* renamed from: com.sec.chaton.i.a */
/* loaded from: classes.dex */
public class C0722a implements MRListener {

    /* renamed from: a */
    private static final String f2443a = C0722a.class.getSimpleName();

    /* renamed from: b */
    private static C0722a f2444b;

    /* renamed from: c */
    private boolean f2445c;

    /* renamed from: d */
    private List f2446d = new ArrayList();

    /* renamed from: a */
    public static synchronized C0722a m3116a(Context context) {
        if (f2444b == null) {
            f2444b = new C0722a(context);
        }
        return f2444b;
    }

    private C0722a(Context context) {
        this.f2445c = m3117c(context);
        if (C0111b.f208a.f210b) {
            if (this.f2445c) {
                C0111b.f208a.m585c(f2443a, "Motion framework is avaliable.");
            } else {
                C0111b.f208a.m585c(f2443a, "Motion framework is unavaliable.");
            }
        }
    }

    /* renamed from: c */
    private boolean m3117c(Context context) throws NoSuchMethodException, SecurityException {
        if (((MotionRecognitionManager) context.getSystemService("motion_recognition")) == null) {
            return false;
        }
        try {
            MotionRecognitionManager.class.getMethod("registerListenerEvent", MRListener.class, Integer.TYPE);
            return MotionRecognitionManager.getMotionVersion() >= 1;
        } catch (NoSuchMethodError e) {
            return false;
        } catch (NoSuchMethodException e2) {
            return false;
        } catch (SecurityException e3) {
            return false;
        }
    }

    @Override // android.hardware.motion.MRListener
    public void onMotionListener(MREvent mREvent) {
        if (mREvent.getMotion() == 68) {
            C1341p.m4658b("onMotionListener event: " + mREvent.getMotion(), getClass().getSimpleName());
            synchronized (this) {
                Iterator it = this.f2446d.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0723b) it.next()).mo2293f();
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized boolean m3120a(Context context, InterfaceC0723b interfaceC0723b) {
        boolean z;
        if (!this.f2445c) {
            if (C0111b.f208a.f212d) {
                C0111b.f208a.m586d(f2443a, "Direct call motion isn't supported.");
            }
            z = false;
        } else {
            if (!this.f2446d.contains(interfaceC0723b)) {
                if (this.f2446d.isEmpty()) {
                    if (C0111b.f208a.f210b) {
                        C0111b.f208a.m585c(f2443a, "Attach direct call motion listener.");
                    }
                    ((MotionRecognitionManager) context.getSystemService("motion_recognition")).registerListenerEvent(this, 1024);
                }
                this.f2446d.add(interfaceC0723b);
            }
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public synchronized boolean m3122b(Context context, InterfaceC0723b interfaceC0723b) {
        boolean z = false;
        synchronized (this) {
            if (!this.f2445c) {
                if (C0111b.f208a.f212d) {
                    C0111b.f208a.m586d(f2443a, "Direct call motion isn't supported.");
                }
            } else if (this.f2446d.remove(interfaceC0723b)) {
                if (this.f2446d.isEmpty()) {
                    if (C0111b.f208a.f210b) {
                        C0111b.f208a.m585c(f2443a, "Detach direct call motion listener.");
                    }
                    ((MotionRecognitionManager) context.getSystemService("motion_recognition")).unregisterListener(this);
                }
                z = true;
            }
        }
        return z;
    }

    /* renamed from: b */
    public boolean m3121b(Context context) {
        boolean z = Settings.System.getInt(context.getContentResolver(), "motion_engine", 0) == 1 && Settings.System.getInt(context.getContentResolver(), "motion_pick_up_to_call_out", 0) == 1;
        if (C0111b.f208a.f210b) {
            C0111b.f208a.m585c(f2443a, "getPickupToCallOut() = " + z);
        }
        return z;
    }

    /* renamed from: a */
    public void m3119a(Context context, int i) {
        Settings.System.putInt(context.getContentResolver(), "motion_engine", i);
        Settings.System.putInt(context.getContentResolver(), "motion_pick_up_to_call_out", i);
        if (C0111b.f208a.f210b) {
            C0111b.f208a.m585c(f2443a, "setPickupToCallOut() = " + i);
        }
    }

    /* renamed from: a */
    public int m3118a(Context context, String str, int i) {
        if (AbstractC0617h.m2831a(context) && C0159bh.m689a(str)) {
            return 2;
        }
        if (i == 2) {
            return 1;
        }
        return 0;
    }
}
