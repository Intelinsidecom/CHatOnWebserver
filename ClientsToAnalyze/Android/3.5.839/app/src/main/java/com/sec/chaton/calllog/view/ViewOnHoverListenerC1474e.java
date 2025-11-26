package com.sec.chaton.calllog.view;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.calllog.common.view.C1438a;

/* compiled from: CallLogDetailFragment.java */
/* renamed from: com.sec.chaton.calllog.view.e */
/* loaded from: classes.dex */
class ViewOnHoverListenerC1474e implements View.OnHoverListener {

    /* renamed from: a */
    final /* synthetic */ View f5355a;

    /* renamed from: b */
    final /* synthetic */ View f5356b;

    /* renamed from: c */
    final /* synthetic */ CallLogDetailFragment f5357c;

    ViewOnHoverListenerC1474e(CallLogDetailFragment callLogDetailFragment, View view, View view2) {
        this.f5357c = callLogDetailFragment;
        this.f5355a = view;
        this.f5356b = view2;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (!view.isHovered()) {
            if (C1438a.m7533a(this.f5355a) == null || C1438a.m7533a(this.f5355a).equals(true)) {
                this.f5356b.setBackgroundDrawable(this.f5357c.getResources().getDrawable(R.drawable.chatonv_list_bg_hover_popup));
            } else {
                this.f5356b.setBackgroundDrawable(this.f5357c.getResources().getDrawable(R.drawable.chatonv_list_bg_hover_nonpopup));
            }
        }
        if (motionEvent.getActionMasked() == 10) {
            this.f5356b.setBackgroundColor(this.f5357c.getResources().getColor(R.color.transparent));
            return false;
        }
        return false;
    }
}
