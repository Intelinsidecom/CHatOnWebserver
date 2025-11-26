package com.sec.chaton;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C3171am;
import com.sec.common.util.C3347i;

/* compiled from: PlusFragment.java */
/* renamed from: com.sec.chaton.z */
/* loaded from: classes.dex */
class C3269z implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ PlusFragment f11794a;

    C3269z(PlusFragment plusFragment) {
        this.f11794a = plusFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = ((C0429ag) this.f11794a.f715m.get(i)).f1486b;
        String str = ((C0429ag) this.f11794a.f715m.get(i)).f1489e;
        String str2 = ((C0429ag) this.f11794a.f715m.get(i)).f1491g;
        if (i2 == 2) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(((C0429ag) this.f11794a.f715m.get(i)).f1490f));
            this.f11794a.startActivity(intent);
        } else {
            if (str != null && !C3347i.m11778a(this.f11794a.getActivity(), str)) {
                if (str2 != null) {
                    C3171am.m11058c(str);
                    return;
                } else {
                    C3171am.m11056b(str);
                    return;
                }
            }
            C3171am.m11048a(this.f11794a.getActivity(), str);
        }
    }
}
