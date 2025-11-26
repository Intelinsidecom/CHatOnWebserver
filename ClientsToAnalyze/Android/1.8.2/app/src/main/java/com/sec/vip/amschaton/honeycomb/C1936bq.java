package com.sec.vip.amschaton.honeycomb;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.vip.amschaton.AMSDrawManager;
import com.sec.vip.amschaton.C2064n;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: AMSSamplesActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.bq */
/* loaded from: classes.dex */
class C1936bq implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSSamplesActivity f7076a;

    C1936bq(AMSSamplesActivity aMSSamplesActivity) {
        this.f7076a = aMSSamplesActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String strM7185a = C2064n.m7173a().m7185a(i);
        if (strM7185a == null) {
            C1786r.m6054a("amsFile is NULL!", getClass().getSimpleName());
        } else if (new AMSDrawManager(this.f7076a.m6790g()).m6310c(strM7185a)) {
            this.f7076a.f6997n.setOnItemClickListener(null);
            this.f7076a.m6783a(strM7185a, false);
        } else {
            new AlertDialogBuilderC2120a(this.f7076a.m6790g()).setTitle(R.string.ams_attention_title).setMessage(R.string.ams_attention_non_editable).setNegativeButton(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC1938bs(this, strM7185a)).setPositiveButton(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC1937br(this)).create().show();
        }
    }
}
