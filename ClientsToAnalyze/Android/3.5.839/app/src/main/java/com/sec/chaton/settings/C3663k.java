package com.sec.chaton.settings;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.p055d.C2105bk;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.samsungaccount.DirectCallSAActivity;
import com.sec.chaton.sns.p114b.C4380af;
import com.sec.chaton.sns.p114b.C4382ah;
import com.sec.chaton.sns.p114b.C4388an;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;

/* compiled from: AccountFragment.java */
/* renamed from: com.sec.chaton.settings.k */
/* loaded from: classes.dex */
class C3663k implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AccountFragment f13239a;

    C3663k(AccountFragment accountFragment) {
        this.f13239a = accountFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (i) {
            case 0:
                if (!C4822an.m18255w()) {
                    Intent intent = new Intent(this.f13239a.f12487n, (Class<?>) DirectCallSAActivity.class);
                    intent.putExtra("is_mapping_mode", true);
                    this.f13239a.startActivityForResult(intent, 0);
                    break;
                }
                break;
            case 1:
                if (TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
                    this.f13239a.startActivityForResult(new Intent(this.f13239a.getActivity(), (Class<?>) ActivityRegist.class), 1);
                    break;
                }
                break;
            case 3:
                this.f13239a.m13345f();
                if (this.f13239a.f12490q != null) {
                    this.f13239a.f12490q = null;
                }
                if (this.f13239a.f12469D) {
                    this.f13239a.f12486m = 3;
                    this.f13239a.f12490q = new C2105bk(this.f13239a.getActivity(), C4380af.class, true);
                } else if (this.f13239a.f12471F) {
                    this.f13239a.f12486m = 4;
                    this.f13239a.f12490q = new C2105bk(this.f13239a.getActivity(), C4382ah.class, true);
                } else {
                    this.f13239a.f12486m = 5;
                    this.f13239a.f12490q = new C2105bk(this.f13239a.getActivity(), C4388an.class, true);
                }
                if (this.f13239a.f12490q != null) {
                    this.f13239a.f12490q.m9426a(this.f13239a.f12475a);
                    this.f13239a.f12490q.m9430e();
                    break;
                }
                break;
            case 4:
                this.f13239a.m13345f();
                if (this.f13239a.f12490q != null) {
                    this.f13239a.f12490q = null;
                }
                if (this.f13239a.f12469D) {
                    if (this.f13239a.f12471F) {
                        this.f13239a.f12486m = 4;
                        this.f13239a.f12490q = new C2105bk(this.f13239a.getActivity(), C4382ah.class, true);
                    } else {
                        this.f13239a.f12486m = 5;
                        this.f13239a.f12490q = new C2105bk(this.f13239a.getActivity(), C4388an.class, true);
                    }
                } else if (this.f13239a.f12470E) {
                    this.f13239a.f12486m = 5;
                    this.f13239a.f12490q = new C2105bk(this.f13239a.getActivity(), C4388an.class, true);
                }
                if (this.f13239a.f12490q != null) {
                    this.f13239a.f12490q.m9426a(this.f13239a.f12475a);
                    this.f13239a.f12490q.m9430e();
                    break;
                }
                break;
            case 5:
                this.f13239a.m13345f();
                this.f13239a.f12486m = 5;
                if (this.f13239a.f12490q != null) {
                    this.f13239a.f12490q = null;
                }
                this.f13239a.f12490q = new C2105bk(this.f13239a.getActivity(), C4388an.class, true);
                if (this.f13239a.f12490q != null) {
                    this.f13239a.f12490q.m9426a(this.f13239a.f12475a);
                    this.f13239a.f12490q.m9430e();
                    break;
                }
                break;
        }
    }
}
