package com.sec.chaton.buddy;

import android.view.DragEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1106c;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.ag */
/* loaded from: classes.dex */
class ViewOnDragListenerC1116ag implements View.OnDragListener {

    /* renamed from: a */
    final /* synthetic */ C1106c f4324a;

    /* renamed from: b */
    final /* synthetic */ C1113ad f4325b;

    ViewOnDragListenerC1116ag(C1113ad c1113ad, C1106c c1106c) {
        this.f4325b = c1113ad;
        this.f4324a = c1106c;
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent dragEvent) {
        switch (dragEvent.getAction()) {
            case 3:
                if (!this.f4324a.m7046a().equals(this.f4325b.f4300g.getResources().getString(R.string.setting_interaction_me)) && !this.f4324a.m7046a().startsWith("0999")) {
                    if (this.f4324a.m7074w()) {
                        BuddyFragment.m6346a(dragEvent.getClipData(), this.f4324a, this.f4325b.f4300g);
                    } else {
                        new String[1][0] = this.f4324a.m7046a();
                        BuddyFragment.m6346a(dragEvent.getClipData(), this.f4324a, this.f4325b.f4300g);
                    }
                }
                break;
            default:
                return true;
        }
    }
}
