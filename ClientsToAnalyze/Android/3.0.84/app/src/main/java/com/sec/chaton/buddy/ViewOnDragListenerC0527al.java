package com.sec.chaton.buddy;

import android.view.DragEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p019a.C0513c;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.al */
/* loaded from: classes.dex */
class ViewOnDragListenerC0527al implements View.OnDragListener {

    /* renamed from: a */
    final /* synthetic */ C0513c f2471a;

    /* renamed from: b */
    final /* synthetic */ C0522ag f2472b;

    ViewOnDragListenerC0527al(C0522ag c0522ag, C0513c c0513c) {
        this.f2472b = c0522ag;
        this.f2471a = c0513c;
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent dragEvent) {
        switch (dragEvent.getAction()) {
            case 3:
                if (!this.f2471a.m3975b().equals(this.f2472b.f2443f.getResources().getString(R.string.setting_interaction_me)) && !this.f2471a.m3975b().startsWith("0999")) {
                    if (this.f2471a.m3997x()) {
                        BuddyFragment.m3273a(dragEvent.getClipData(), this.f2471a, this.f2472b.f2443f);
                    } else {
                        new String[1][0] = this.f2471a.m3975b();
                        BuddyFragment.m3273a(dragEvent.getClipData(), this.f2471a, this.f2472b.f2443f);
                    }
                }
                break;
            default:
                return true;
        }
    }
}
