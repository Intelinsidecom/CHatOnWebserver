package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.settings.ae */
/* loaded from: classes.dex */
class ViewOnClickListenerC0456ae implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkinChange f3147a;

    ViewOnClickListenerC0456ae(ActivitySkinChange activitySkinChange) {
        this.f3147a = activitySkinChange;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3147a.f3065w.setBackgroundResource(C0062R.drawable.bubble_receive_02);
        this.f3147a.f3028L.setBackgroundResource(C0062R.drawable.bubble_send_02);
        this.f3147a.f3067y = "bubble_02";
        this.f3147a.f3057o.setSelected(false);
        this.f3147a.f3058p.setSelected(true);
        this.f3147a.f3059q.setSelected(false);
        this.f3147a.f3060r.setSelected(false);
        this.f3147a.f3061s.setSelected(false);
        this.f3147a.f3062t.setSelected(false);
    }
}
