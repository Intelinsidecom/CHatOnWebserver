package com.sec.chaton.smsplugin.spam;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: SetupSpamNumberList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.av */
/* loaded from: classes.dex */
class C3991av implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ SetupSpamNumberList f14432a;

    C3991av(SetupSpamNumberList setupSpamNumberList) {
        this.f14432a = setupSpamNumberList;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f14432a.f14370u == 1) {
            this.f14432a.m15393l();
        } else if (i == 0) {
            boolean zM15457b = ((C4017bu) this.f14432a.f14366p.get(0)).m15457b();
            ((C4017bu) this.f14432a.f14366p.get(0)).m15456a(zM15457b ? false : true);
            this.f14432a.f14350G.m18125b("pref_key_spam_option_unknown_num", Boolean.valueOf(zM15457b));
            this.f14432a.f14367q.notifyDataSetInvalidated();
        }
    }
}
