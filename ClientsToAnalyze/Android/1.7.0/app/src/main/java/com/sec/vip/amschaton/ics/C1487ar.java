package com.sec.vip.amschaton.ics;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import com.sec.vip.amschaton.AMSDrawManager;
import com.sec.vip.amschaton.C1364aa;
import com.sec.widget.AlertDialogBuilderC1625m;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ar */
/* loaded from: classes.dex */
class C1487ar implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSMyWorksActivity f5302a;

    C1487ar(AMSMyWorksActivity aMSMyWorksActivity) {
        this.f5302a = aMSMyWorksActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (!this.f5302a.f5227n) {
            String strM4881b = C1364aa.m4865a().m4881b(i);
            if (strM4881b == null) {
                C1341p.m4651a("amsFile is NULL!", getClass().getSimpleName());
            } else if (new AMSDrawManager(this.f5302a.m5438a()).m4789c(strM4881b)) {
                this.f5302a.f5225b.setOnItemClickListener(null);
                this.f5302a.m5444a(strM4881b, false);
            } else {
                new AlertDialogBuilderC1625m(this.f5302a.m5438a()).setTitle(R.string.ams_attention_title).setMessage(R.string.ams_attention_non_editable).setPositiveButton(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC1499bc(this, strM4881b)).setNegativeButton(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC1498bb(this)).create().show();
            }
        }
    }
}
