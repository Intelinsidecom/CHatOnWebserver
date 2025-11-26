package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.util.C1346u;

/* compiled from: BuddyGroupMemberEditActivity.java */
/* renamed from: com.sec.chaton.buddy.as */
/* loaded from: classes.dex */
class ViewOnClickListenerC0384as implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupMemberEditActivity f1353a;

    ViewOnClickListenerC0384as(BuddyGroupMemberEditActivity buddyGroupMemberEditActivity) {
        this.f1353a = buddyGroupMemberEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1346u.m4676a()) {
            switch (this.f1353a.f1173e) {
                case 19:
                    this.f1353a.m2211a(this.f1353a.m2209a().m2201c());
                    break;
            }
        }
    }
}
