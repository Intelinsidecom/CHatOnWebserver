package com.sec.vip.amschaton.honeycomb;

import android.os.Build;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.vip.amschaton.AMSDrawManager;
import com.sec.vip.amschaton.C2064n;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.ae */
/* loaded from: classes.dex */
class C1897ae implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSMyWorksActivity f7023a;

    C1897ae(AMSMyWorksActivity aMSMyWorksActivity) {
        this.f7023a = aMSMyWorksActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.f7023a.f6966p == 2001) {
            String strM7189b = C2064n.m7173a().m7189b(i);
            if (strM7189b == null) {
                C1786r.m6054a("amsFile is NULL!", getClass().getSimpleName());
                return;
            }
            if (new AMSDrawManager(this.f7023a.m6687g()).m6310c(strM7189b)) {
                this.f7023a.f6964n.setOnItemClickListener(null);
                this.f7023a.m6675a(strM7189b, false);
            } else if (Build.VERSION.SDK_INT > 11) {
                new AlertDialogBuilderC2120a(this.f7023a.m6687g()).setTitle(R.string.ams_attention_title).setMessage(R.string.ams_attention_non_editable).setPositiveButton(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC1899ag(this)).setNegativeButton(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC1898af(this, strM7189b)).create().show();
            } else {
                new AlertDialogBuilderC2120a(this.f7023a.m6687g()).setTitle(R.string.ams_attention_title).setMessage(R.string.ams_attention_non_editable).setPositiveButton(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC1901ai(this, strM7189b)).setNegativeButton(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC1900ah(this)).create().show();
            }
        }
    }
}
