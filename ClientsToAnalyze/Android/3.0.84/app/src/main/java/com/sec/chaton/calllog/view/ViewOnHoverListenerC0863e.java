package com.sec.chaton.calllog.view;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.calllog.common.view.C0827a;

/* compiled from: CallLogDetailFragment.java */
/* renamed from: com.sec.chaton.calllog.view.e */
/* loaded from: classes.dex */
class ViewOnHoverListenerC0863e implements View.OnHoverListener {

    /* renamed from: a */
    final /* synthetic */ View f3382a;

    /* renamed from: b */
    final /* synthetic */ View f3383b;

    /* renamed from: c */
    final /* synthetic */ CallLogDetailFragment f3384c;

    ViewOnHoverListenerC0863e(CallLogDetailFragment callLogDetailFragment, View view, View view2) {
        this.f3384c = callLogDetailFragment;
        this.f3382a = view;
        this.f3383b = view2;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (!view.isHovered()) {
            if (C0827a.m4380a(this.f3382a) == null || C0827a.m4380a(this.f3382a).equals(true)) {
                this.f3383b.setBackgroundDrawable(this.f3384c.getResources().getDrawable(R.drawable.chatonv_list_bg_hover_popup));
            } else {
                this.f3383b.setBackgroundDrawable(this.f3384c.getResources().getDrawable(R.drawable.chatonv_list_bg_hover_nonpopup));
            }
        }
        if (motionEvent.getActionMasked() == 10) {
            this.f3383b.setBackgroundColor(this.f3384c.getResources().getColor(R.color.transparent));
            return false;
        }
        return false;
    }
}
