package com.sec.vip.amschaton.ics;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import com.sec.vip.amschaton.AMSDrawManager;
import com.sec.vip.amschaton.C1364aa;
import com.sec.widget.AlertDialogBuilderC1625m;

/* compiled from: AMSSamplesActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.p */
/* loaded from: classes.dex */
class C1534p implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSSamplesActivity f5362a;

    C1534p(AMSSamplesActivity aMSSamplesActivity) {
        this.f5362a = aMSSamplesActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String strM4877a = C1364aa.m4865a().m4877a(i);
        if (strM4877a == null) {
            C1341p.m4651a("amsFile is NULL!", getClass().getSimpleName());
        } else if (new AMSDrawManager(this.f5362a.m5541a()).m4789c(strM4877a)) {
            this.f5362a.f5256b.setOnItemClickListener(null);
            this.f5362a.m5546a(strM4877a, false);
        } else {
            new AlertDialogBuilderC1625m(this.f5362a.m5541a()).setTitle(R.string.ams_attention_title).setMessage(R.string.ams_attention_non_editable).setPositiveButton(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC1479aj(this, strM4877a)).setNegativeButton(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC1478ai(this)).create().show();
        }
    }
}
