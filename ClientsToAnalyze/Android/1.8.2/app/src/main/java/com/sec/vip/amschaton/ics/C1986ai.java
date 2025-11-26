package com.sec.vip.amschaton.ics;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.vip.amschaton.AMSDrawManager;
import com.sec.vip.amschaton.C2064n;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ai */
/* loaded from: classes.dex */
class C1986ai implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSMyWorksActivity f7259a;

    C1986ai(AMSMyWorksActivity aMSMyWorksActivity) {
        this.f7259a = aMSMyWorksActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (!this.f7259a.f7197o) {
            String strM7189b = C2064n.m7173a().m7189b(i);
            if (strM7189b == null) {
                C1786r.m6054a("amsFile is NULL!", getClass().getSimpleName());
            } else if (new AMSDrawManager(this.f7259a.m7016g()).m6310c(strM7189b)) {
                this.f7259a.f7195m.setOnItemClickListener(null);
                this.f7259a.m7006a(strM7189b, false);
            } else {
                new AlertDialogBuilderC2120a(this.f7259a.m7016g()).setTitle(R.string.ams_attention_title).setMessage(R.string.ams_attention_non_editable).setNegativeButton(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC1988ak(this, strM7189b)).setPositiveButton(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC1987aj(this)).create().show();
            }
        }
    }
}
