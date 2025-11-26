package com.sec.chaton.localbackup;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: BackupListView.java */
/* renamed from: com.sec.chaton.localbackup.l */
/* loaded from: classes.dex */
class ViewOnClickListenerC2552l implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BackupListView f9159a;

    ViewOnClickListenerC2552l(BackupListView backupListView) {
        this.f9159a = backupListView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f9159a.f9003h.isChecked()) {
            this.f9159a.f9003h.setChecked(false);
            this.f9159a.f9004i.findItem(R.id.btnDeleteComplete).setEnabled(false);
            this.f9159a.m10842a(false);
        } else {
            this.f9159a.f9003h.setChecked(true);
            this.f9159a.m10842a(true);
            this.f9159a.f9004i.findItem(R.id.btnDeleteComplete).setEnabled(true);
        }
        this.f9159a.f8999c.notifyDataSetChanged();
    }
}
