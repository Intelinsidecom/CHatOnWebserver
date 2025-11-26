package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.settings.ac */
/* loaded from: classes.dex */
class ViewOnClickListenerC0454ac implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkinChange f3145a;

    ViewOnClickListenerC0454ac(ActivitySkinChange activitySkinChange) {
        this.f3145a = activitySkinChange;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3145a.f3065w.setBackgroundResource(C0062R.drawable.bubble_receive_04);
        this.f3145a.f3028L.setBackgroundResource(C0062R.drawable.bubble_send_04);
        this.f3145a.f3067y = "bubble_04";
        this.f3145a.f3057o.setSelected(false);
        this.f3145a.f3058p.setSelected(false);
        this.f3145a.f3059q.setSelected(false);
        this.f3145a.f3060r.setSelected(true);
        this.f3145a.f3061s.setSelected(false);
        this.f3145a.f3062t.setSelected(false);
    }
}
