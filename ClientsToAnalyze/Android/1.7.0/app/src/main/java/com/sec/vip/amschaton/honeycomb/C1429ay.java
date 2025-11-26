package com.sec.vip.amschaton.honeycomb;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import com.sec.vip.amschaton.AMSDrawManager;
import com.sec.vip.amschaton.C1364aa;
import com.sec.widget.AlertDialogBuilderC1625m;

/* compiled from: AMSSamplesActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.ay */
/* loaded from: classes.dex */
class C1429ay implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSSamplesActivity f5062a;

    C1429ay(AMSSamplesActivity aMSSamplesActivity) {
        this.f5062a = aMSSamplesActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String strM4877a = C1364aa.m4865a().m4877a(i);
        if (strM4877a == null) {
            C1341p.m4651a("amsFile is NULL!", getClass().getSimpleName());
        } else if (new AMSDrawManager(this.f5062a.m5214a()).m4789c(strM4877a)) {
            this.f5062a.f5012b.setOnItemClickListener(null);
            this.f5062a.m5219a(strM4877a, false);
        } else {
            new AlertDialogBuilderC1625m(this.f5062a.m5214a()).setTitle(R.string.ams_attention_title).setMessage(R.string.ams_attention_non_editable).setPositiveButton(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC1416al(this, strM4877a)).setNegativeButton(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC1415ak(this)).create().show();
        }
    }
}
