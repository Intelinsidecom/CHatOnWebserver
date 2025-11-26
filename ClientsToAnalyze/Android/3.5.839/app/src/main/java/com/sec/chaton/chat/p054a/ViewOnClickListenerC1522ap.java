package com.sec.chaton.chat.p054a;

import android.view.View;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;

/* compiled from: SystemBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.ap */
/* loaded from: classes.dex */
class ViewOnClickListenerC1522ap implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1517ak f5913a;

    ViewOnClickListenerC1522ap(C1517ak c1517ak) {
        this.f5913a = c1517ak;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C4822an.m18226c()) {
            if (C4904y.f17873c) {
                C4904y.m18641c("SMS Feature On : Call Internal SMS", getClass().getSimpleName());
            }
            this.f5913a.m8410f();
        } else {
            if (C4904y.f17873c) {
                C4904y.m18641c("SMS Feature Off : Call Native SMS", getClass().getSimpleName());
            }
            this.f5913a.m8409e();
        }
    }
}
