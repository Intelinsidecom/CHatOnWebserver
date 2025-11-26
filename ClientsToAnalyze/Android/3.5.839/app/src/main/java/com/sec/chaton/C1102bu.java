package com.sec.chaton;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C4822an;
import com.sec.common.util.C5034k;

/* compiled from: PlusFragment.java */
/* renamed from: com.sec.chaton.bu */
/* loaded from: classes.dex */
class C1102bu implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ PlusFragment f3503a;

    C1102bu(PlusFragment plusFragment) {
        this.f3503a = plusFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = ((C1501ce) this.f3503a.f1985l.get(i)).f5434b;
        String str = ((C1501ce) this.f3503a.f1985l.get(i)).f5437e;
        String str2 = ((C1501ce) this.f3503a.f1985l.get(i)).f5439g;
        if (i2 == 2) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(((C1501ce) this.f3503a.f1985l.get(i)).f5438f));
            this.f3503a.startActivity(intent);
        } else if (str == null || C5034k.m19095a(this.f3503a.f1990q, str)) {
            C4822an.m18212a(this.f3503a.f1990q, str);
        } else if (str2 != null) {
            C4822an.m18230d(str);
        } else {
            C4822an.m18225c(str);
        }
    }
}
