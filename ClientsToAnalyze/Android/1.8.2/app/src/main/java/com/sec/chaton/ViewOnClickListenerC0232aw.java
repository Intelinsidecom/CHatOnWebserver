package com.sec.chaton;

import android.view.View;
import com.sec.chaton.p015d.C0629as;
import com.sec.chaton.settings.AboutFragment;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.ProgressDialogC1806j;

/* compiled from: UpgradeDialog.java */
/* renamed from: com.sec.chaton.aw */
/* loaded from: classes.dex */
class ViewOnClickListenerC0232aw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UpgradeDialog f764a;

    ViewOnClickListenerC0232aw(UpgradeDialog upgradeDialog) {
        this.f764a = upgradeDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1789u.m6075a().getString("UpdateUrl", "");
        boolean zM4476a = AboutFragment.m4476a(this.f764a.f302d, true);
        C1786r.m6066e("isApps :" + zM4476a, getClass().getSimpleName());
        if (zM4476a) {
            if (this.f764a.f302d != null) {
                this.f764a.f303e = ProgressDialogC1806j.m6141a(this.f764a.f302d, null, this.f764a.getString(R.string.buddy_list_progress_dialog_message), true);
            }
            new C0629as(this.f764a.f299a).m2833b();
            return;
        }
        this.f764a.finish();
    }
}
