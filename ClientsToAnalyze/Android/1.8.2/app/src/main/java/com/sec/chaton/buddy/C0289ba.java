package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C1786r;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ba */
/* loaded from: classes.dex */
class C0289ba implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1385a;

    C0289ba(BuddyFragment buddyFragment) {
        this.f1385a = buddyFragment;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        C1786r.m6067f("mOptionButtonSelectedForGroupProfile" + i, "BuddyFragment");
        if (i == 0) {
            Intent intent = new Intent(this.f1385a.f1018t, (Class<?>) BuddySelectActivity.class);
            intent.putExtra("ACTIVITY_PURPOSE", 11);
            intent.putExtra("ACTIVITY_PURPOSE_ARG", this.f1385a.f966ac.getString("ACTIVITY_PURPOSE_ARG"));
            intent.putExtra("BUDDY_SORT_STYLE", 11);
            C1786r.m6067f("" + this.f1385a.f935W, "BuddyFragment");
            intent.putExtra("ACTION_PURPOSE", 3);
            intent.putExtra("ACTION_PURPOSE_ARG1", this.f1385a.f966ac.getString("ACTION_PURPOSE_ARG1"));
            intent.putExtra("ACTION_PURPOSE_ARG2", this.f1385a.f966ac.getStringArray("ACTION_PURPOSE_ARG2"));
            this.f1385a.startActivityForResult(intent, 11);
            return;
        }
        if (i == 1) {
            this.f1385a.m2035a(this.f1385a.f966ac.getString("ACTIVITY_PURPOSE_ARG"), this.f1385a.f966ac.getString("ACTION_PURPOSE_ARG1"));
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
    }
}
