package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.settings.ag */
/* loaded from: classes.dex */
class ViewOnClickListenerC0458ag implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkinChange f3149a;

    ViewOnClickListenerC0458ag(ActivitySkinChange activitySkinChange) {
        this.f3149a = activitySkinChange;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3149a.f3065w.setBackgroundResource(C0062R.drawable.bubble_receive_06);
        this.f3149a.f3028L.setBackgroundResource(C0062R.drawable.bubble_send_06);
        this.f3149a.f3067y = "bubble_06";
        this.f3149a.f3057o.setSelected(false);
        this.f3149a.f3058p.setSelected(false);
        this.f3149a.f3059q.setSelected(false);
        this.f3149a.f3060r.setSelected(false);
        this.f3149a.f3061s.setSelected(false);
        this.f3149a.f3062t.setSelected(true);
    }
}
