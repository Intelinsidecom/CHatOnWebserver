package com.sec.chaton.settings;

import android.content.Intent;
import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.util.C4892m;
import com.sec.chaton.util.C4904y;

/* compiled from: ActivityPasswordLockView.java */
/* renamed from: com.sec.chaton.settings.cn */
/* loaded from: classes.dex */
class C3550cn implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockView f13039a;

    C3550cn(ActivityPasswordLockView activityPasswordLockView) {
        this.f13039a = activityPasswordLockView;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        C4904y.m18639b("passwordLock select ok", this.f13039a.f12614a);
        C4904y.m18639b("now password state : " + this.f13039a.f12620g[this.f13039a.f12619f], this.f13039a.f12614a);
        this.f13039a.f12620g = this.f13039a.m13506a("GET", "", "");
        if (!this.f13039a.f12620g[this.f13039a.f12619f].equals(C4892m.m18588h())) {
            C4904y.m18639b("LOCK_STATE : " + this.f13039a.f12615b, this.f13039a.f12614a);
            this.f13039a.m13505a(C4892m.m18588h());
            this.f13039a.m13506a("SET", "OFF", "0000");
            this.f13039a.f12618e.setSummary(R.string.description_for_passlock_hint);
            return false;
        }
        this.f13039a.m13505a(C4892m.m18588h());
        C4904y.m18639b("LOCK_STATE : " + this.f13039a.f12615b, this.f13039a.f12614a);
        Intent intent = new Intent(this.f13039a, (Class<?>) ActivityPasswordLockSet.class);
        intent.putExtra("MODE", "SET");
        this.f13039a.startActivity(intent);
        return false;
    }
}
