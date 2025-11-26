package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.util.C3197bl;
import java.util.HashSet;

/* compiled from: BuddyGroupMemberEditFragment.java */
/* renamed from: com.sec.chaton.buddy.dl */
/* loaded from: classes.dex */
class ViewOnClickListenerC0647dl implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupMemberEditFragment f2867a;

    ViewOnClickListenerC0647dl(BuddyGroupMemberEditFragment buddyGroupMemberEditFragment) {
        this.f2867a = buddyGroupMemberEditFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C3197bl.m11159a()) {
            switch (this.f2867a.f1899d) {
                case 19:
                    this.f2867a.f1901f = this.f2867a.m3455a().m3442g();
                    this.f2867a.m3458a((HashSet<String>) this.f2867a.f1901f);
                    break;
            }
        }
    }
}
