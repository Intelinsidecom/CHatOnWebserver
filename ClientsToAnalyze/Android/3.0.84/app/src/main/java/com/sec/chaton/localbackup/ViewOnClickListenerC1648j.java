package com.sec.chaton.localbackup;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: BackupListView.java */
/* renamed from: com.sec.chaton.localbackup.j */
/* loaded from: classes.dex */
class ViewOnClickListenerC1648j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BackupListView f6111a;

    ViewOnClickListenerC1648j(BackupListView backupListView) {
        this.f6111a = backupListView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f6111a.f5962h.isChecked()) {
            this.f6111a.f5962h.setChecked(false);
            this.f6111a.f5963i.findItem(R.id.btnDeleteComplete).setEnabled(false);
            this.f6111a.m6814a(false);
        } else {
            this.f6111a.f5962h.setChecked(true);
            this.f6111a.m6814a(true);
            this.f6111a.f5963i.findItem(R.id.btnDeleteComplete).setEnabled(true);
        }
        this.f6111a.f5958c.notifyDataSetChanged();
    }
}
