package com.sds.coolots.call.model;

import com.sds.coolots.call.CallTypeChangeCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.sds.coolots.call.model.l */
/* loaded from: classes.dex */
public class C1210l {

    /* renamed from: a */
    private final List f2721a = new ArrayList();

    /* renamed from: c */
    private boolean m2644c(CallTypeChangeCallback callTypeChangeCallback) {
        Iterator it = this.f2721a.iterator();
        while (it.hasNext()) {
            if (((CallTypeChangeCallback) it.next()) == callTypeChangeCallback) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void m2645a() {
        Iterator it = this.f2721a.iterator();
        while (it.hasNext()) {
            ((CallTypeChangeCallback) it.next()).onChangeToConference();
        }
    }

    /* renamed from: a */
    public void m2646a(CallTypeChangeCallback callTypeChangeCallback) {
        if (m2644c(callTypeChangeCallback)) {
            return;
        }
        this.f2721a.add(callTypeChangeCallback);
    }

    /* renamed from: b */
    public void m2647b() {
        Iterator it = this.f2721a.iterator();
        while (it.hasNext()) {
            ((CallTypeChangeCallback) it.next()).onChangeToP2P();
        }
    }

    /* renamed from: b */
    public void m2648b(CallTypeChangeCallback callTypeChangeCallback) {
        this.f2721a.remove(callTypeChangeCallback);
    }
}
