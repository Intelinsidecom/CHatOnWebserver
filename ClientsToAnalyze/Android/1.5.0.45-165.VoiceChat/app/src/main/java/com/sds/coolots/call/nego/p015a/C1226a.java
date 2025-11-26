package com.sds.coolots.call.nego.p015a;

import com.coolots.p2pmsg.model.FeatureInfoAsk;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.nego.NegoFeatureControllerInterface;
import com.sds.coolots.common.util.C1260a;
import com.sds.coolots.common.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.sds.coolots.call.nego.a.a */
/* loaded from: classes.dex */
public class C1226a implements NegoFeatureControllerInterface {

    /* renamed from: u */
    private static final String f2794u = "[NegoFeatureController]";

    /* renamed from: a */
    private Destination f2795a;

    /* renamed from: b */
    private int f2796b;

    /* renamed from: c */
    private boolean f2797c = false;

    /* renamed from: d */
    private boolean f2798d = false;

    /* renamed from: e */
    private boolean f2799e = false;

    /* renamed from: f */
    private boolean f2800f = false;

    /* renamed from: g */
    private boolean f2801g = false;

    /* renamed from: h */
    private boolean f2802h = false;

    /* renamed from: i */
    private boolean f2803i = false;

    /* renamed from: j */
    private boolean f2804j = false;

    /* renamed from: k */
    private boolean f2805k = false;

    /* renamed from: l */
    private boolean f2806l = false;

    /* renamed from: m */
    private boolean f2807m = false;

    /* renamed from: n */
    private boolean f2808n = false;

    /* renamed from: o */
    private boolean f2809o = false;

    /* renamed from: p */
    private boolean f2810p = false;

    /* renamed from: q */
    private boolean f2811q = false;

    /* renamed from: r */
    private boolean f2812r = false;

    /* renamed from: s */
    private boolean f2813s = false;

    /* renamed from: t */
    private boolean f2814t = false;

    public C1226a(Destination destination, int i) {
        m2754b("<CIH> NegoFeatureController()");
        this.f2795a = destination;
        this.f2796b = i;
    }

    /* renamed from: a */
    private void m2753a(String str) {
        Log.m2958e(f2794u + str);
    }

    /* renamed from: b */
    private void m2754b(String str) {
        Log.m2963i(f2794u + str);
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public boolean isConfHandwritingInDocView() {
        return this.f2811q;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public boolean isConfHandwritingInShareScreen() {
        return this.f2810p;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public boolean isConfShareCamera() {
        return this.f2809o;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public boolean isConfShareDocView() {
        return this.f2813s;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public boolean isConfShareRemoteControl() {
        return this.f2812r;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public boolean isConfShareScreen() {
        return this.f2808n;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public boolean isConfTranslation() {
        return this.f2814t;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public boolean isConfVideoToVoiceCallSwitching() {
        return this.f2807m;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public boolean isConfVoiceToVideoCallSwitching() {
        return this.f2806l;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public boolean isP2pHandwritingInDocView() {
        return this.f2802h;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public boolean isP2pHandwritingInShareScreen() {
        return this.f2801g;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public boolean isP2pShareCamera() {
        return this.f2800f;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public boolean isP2pShareDocView() {
        return this.f2804j;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public boolean isP2pShareRemoteControl() {
        return this.f2803i;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public boolean isP2pShareScreen() {
        return this.f2799e;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public boolean isP2pTranslation() {
        return this.f2805k;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public boolean isP2pVideoToVoiceCallSwitching() {
        return this.f2798d;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public boolean isP2pVoiceToVideoCallSwitching() {
        return this.f2797c;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void printResultOnLog() {
        StringBuilder sb = new StringBuilder(1024);
        Field[] declaredFields = getClass().getDeclaredFields();
        sb.append("\n<CIH> Feature Nego Result\n").append("<CIH> ===========================================\n");
        try {
            for (Field field : declaredFields) {
                int modifiers = field.getModifiers();
                if (field.get(this).getClass() == Boolean.class) {
                    if (Modifier.isPrivate(modifiers)) {
                        field.setAccessible(true);
                    }
                    sb.append(String.format("<CIH> %35s = %s\n", field.getName(), field.get(this)));
                    if (Modifier.isPrivate(modifiers)) {
                        field.setAccessible(false);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        m2754b(sb.toString());
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void setConfHandwritingInDocView(boolean z) {
        this.f2811q = z;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void setConfHandwritingInShareScreen(boolean z) {
        this.f2810p = z;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void setConfShareCamera(boolean z) {
        this.f2809o = z;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void setConfShareDocView(boolean z) {
        this.f2813s = z;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void setConfShareRemoteControl(boolean z) {
        this.f2812r = z;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void setConfShareScreen(boolean z) {
        this.f2808n = z;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void setConfTranslation(boolean z) {
        this.f2814t = z;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void setConfVideoToVoiceCallSwitching(boolean z) {
        this.f2807m = z;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void setConfVoiceToVideoCallSwitching(boolean z) {
        this.f2806l = z;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void setP2pHandwritingInDocView(boolean z) {
        this.f2802h = z;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void setP2pHandwritingInShareScreen(boolean z) {
        this.f2801g = z;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void setP2pShareCamera(boolean z) {
        this.f2800f = z;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void setP2pShareDocView(boolean z) {
        this.f2804j = z;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void setP2pShareRemoteControl(boolean z) {
        this.f2803i = z;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void setP2pShareScreen(boolean z) {
        this.f2799e = z;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void setP2pTranslation(boolean z) {
        this.f2805k = z;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void setP2pVideoToVoiceCallSwitching(boolean z) {
        this.f2798d = z;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void setP2pVoiceToVideoCallSwitching(boolean z) {
        this.f2797c = z;
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void setResult(List list) {
        boolean z;
        m2754b("<CIH> setResult()");
        if (list == null || list.size() == 0) {
            m2753a("<CIH> featureInfoList should be not null and size of the list over zero.");
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m2754b("<CIH>" + ((FeatureInfoAsk) it.next()).toString());
        }
        boolean z2 = true;
        Iterator it2 = list.iterator();
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = true;
        boolean z6 = true;
        boolean z7 = true;
        boolean z8 = true;
        boolean z9 = true;
        boolean z10 = true;
        boolean z11 = true;
        boolean z12 = true;
        boolean z13 = true;
        boolean z14 = true;
        boolean z15 = true;
        boolean z16 = true;
        boolean z17 = true;
        boolean z18 = true;
        boolean z19 = true;
        while (true) {
            z = z2;
            if (!it2.hasNext()) {
                break;
            }
            FeatureInfoAsk featureInfoAsk = (FeatureInfoAsk) it2.next();
            z3 = z3 && featureInfoAsk.isP2pVoiceToVideoCallSwitching();
            z4 = z4 && featureInfoAsk.isP2pVideoToVoiceCallSwitching();
            z5 = z5 && featureInfoAsk.isP2pShareScreen();
            z6 = z6 && featureInfoAsk.isP2pShareCamera();
            z7 = z7 && featureInfoAsk.isP2pHandwritingInShareScreen();
            z8 = z8 && featureInfoAsk.isP2pHandwritingInDocView();
            z9 = z9 && featureInfoAsk.isP2pShareRemoteControl();
            z10 = z10 && featureInfoAsk.isP2pShareDocView();
            z11 = z11 && featureInfoAsk.isP2pTranslation();
            z12 = z12 && featureInfoAsk.isConfVoiceToVideoCallSwitching();
            z13 = z13 && featureInfoAsk.isConfVideoToVoiceCallSwitching();
            z14 = z14 && featureInfoAsk.isConfShareScreen();
            z15 = z15 && featureInfoAsk.isConfShareCamera();
            z16 = z16 && featureInfoAsk.isConfHandwritingInShareScreen();
            z17 = z17 && featureInfoAsk.isConfHandwritingInDocView();
            z18 = z18 && featureInfoAsk.isConfShareRemoteControl();
            z19 = z19 && featureInfoAsk.isConfShareDocView();
            z2 = z && featureInfoAsk.isConfTranslation();
        }
        FeatureInfoAsk featureInfoAskM2985a = C1260a.m2985a();
        if (z3 && featureInfoAskM2985a.isP2pVoiceToVideoCallSwitching()) {
            this.f2797c = true;
        } else {
            this.f2797c = false;
        }
        if (z4 && featureInfoAskM2985a.isP2pVideoToVoiceCallSwitching()) {
            this.f2798d = true;
        } else {
            this.f2798d = false;
        }
        if (z5 && featureInfoAskM2985a.isP2pShareScreen()) {
            this.f2799e = true;
        } else {
            this.f2799e = false;
        }
        if (z6 && featureInfoAskM2985a.isP2pShareCamera()) {
            this.f2800f = true;
        } else {
            this.f2800f = false;
        }
        if (z7 && featureInfoAskM2985a.isP2pHandwritingInShareScreen()) {
            this.f2801g = true;
        } else {
            this.f2801g = false;
        }
        if (z8 && featureInfoAskM2985a.isP2pHandwritingInDocView()) {
            this.f2802h = true;
        } else {
            this.f2802h = false;
        }
        if (z9 && featureInfoAskM2985a.isP2pShareRemoteControl()) {
            this.f2803i = true;
        } else {
            this.f2803i = false;
        }
        if (z10 && featureInfoAskM2985a.isP2pShareDocView()) {
            this.f2804j = true;
        } else {
            this.f2804j = false;
        }
        if (z11 && featureInfoAskM2985a.isP2pTranslation()) {
            this.f2805k = true;
        } else {
            this.f2805k = false;
        }
        if (z12 && featureInfoAskM2985a.isConfVoiceToVideoCallSwitching()) {
            this.f2806l = true;
        } else {
            this.f2806l = false;
        }
        if (z13 && featureInfoAskM2985a.isConfVideoToVoiceCallSwitching()) {
            this.f2807m = true;
        } else {
            this.f2807m = false;
        }
        if (z14 && featureInfoAskM2985a.isConfShareScreen()) {
            this.f2808n = true;
        } else {
            this.f2808n = false;
        }
        if (z15 && featureInfoAskM2985a.isConfShareCamera()) {
            this.f2809o = true;
        } else {
            this.f2809o = false;
        }
        if (z16 && featureInfoAskM2985a.isConfHandwritingInShareScreen()) {
            this.f2810p = true;
        } else {
            this.f2810p = false;
        }
        if (z17 && featureInfoAskM2985a.isConfHandwritingInDocView()) {
            this.f2811q = true;
        } else {
            this.f2811q = false;
        }
        if (z18 && featureInfoAskM2985a.isConfShareRemoteControl()) {
            this.f2812r = true;
        } else {
            this.f2812r = false;
        }
        if (z19 && featureInfoAskM2985a.isConfShareDocView()) {
            this.f2813s = true;
        } else {
            this.f2813s = false;
        }
        if (z && featureInfoAskM2985a.isConfTranslation()) {
            this.f2814t = true;
        } else {
            this.f2814t = false;
        }
        printResultOnLog();
    }

    @Override // com.sds.coolots.call.nego.NegoFeatureControllerInterface
    public void updateDestination(Destination destination) {
        this.f2795a = destination;
    }
}
