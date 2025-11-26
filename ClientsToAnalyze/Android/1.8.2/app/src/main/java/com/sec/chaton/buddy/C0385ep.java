package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C1786r;

/* compiled from: GroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.ep */
/* loaded from: classes.dex */
class C0385ep implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ GroupProfileFragment f1543a;

    C0385ep(GroupProfileFragment groupProfileFragment) {
        this.f1543a = groupProfileFragment;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        C1786r.m6067f("GroupProfileActivity mOptionButtonSeleteListener" + i, "BuddyFragment");
        if (i == 0) {
            Intent intent = new Intent(this.f1543a.f1217f, (Class<?>) BuddySelectActivity.class);
            intent.putExtra("ACTIVITY_PURPOSE", 11);
            intent.putExtra("ACTIVITY_PURPOSE_ARG", this.f1543a.f1229r);
            intent.putExtra("BUDDY_SORT_STYLE", 11);
            C1786r.m6067f("" + this.f1543a.f1229r, "BuddyFragment");
            intent.putExtra("ACTION_PURPOSE", 3);
            intent.putExtra("ACTION_PURPOSE_ARG1", this.f1543a.f1221j.getText().toString().trim());
            intent.putExtra("ACTION_PURPOSE_ARG2", this.f1543a.f1220i);
            this.f1543a.f1226o.startActivityForResult(intent, 11);
            return;
        }
        if (i == 1) {
            this.f1543a.f1226o.m2035a(this.f1543a.f1229r, this.f1543a.f1230s);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
    }
}
