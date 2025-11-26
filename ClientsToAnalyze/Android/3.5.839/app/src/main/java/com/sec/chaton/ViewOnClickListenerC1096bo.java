package com.sec.chaton;

import android.view.View;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyTopicChatEntry;

/* compiled from: PlusFragment.java */
/* renamed from: com.sec.chaton.bo */
/* loaded from: classes.dex */
class ViewOnClickListenerC1096bo implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PlusFragment f3495a;

    ViewOnClickListenerC1096bo(PlusFragment plusFragment) {
        this.f3495a = plusFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1503cg c1503cg = (C1503cg) view.getTag();
        if (this.f3495a.f1994u != null) {
            this.f3495a.f1994u.moveToPosition(c1503cg.f5450d);
            String string = this.f3495a.f1994u.getString(this.f3495a.f1994u.getColumnIndex("sessionid"));
            String string2 = this.f3495a.f1994u.getString(this.f3495a.f1994u.getColumnIndex("id"));
            String string3 = this.f3495a.f1994u.getString(this.f3495a.f1994u.getColumnIndex("title"));
            int i = this.f3495a.f1994u.getInt(this.f3495a.f1994u.getColumnIndex("usertype"));
            this.f3495a.f1967K = new SpecialBuddyTopicChatEntry(string, string2, string2, string3, String.valueOf(i));
            C1736gi.m8640a(this.f3495a.f1969M, this.f3495a.f1967K);
        }
    }
}
