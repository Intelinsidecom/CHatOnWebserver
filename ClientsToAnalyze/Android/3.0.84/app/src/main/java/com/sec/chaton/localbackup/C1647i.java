package com.sec.chaton.localbackup;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.localbackup.chatlist.ChatListActivity;
import com.sec.chaton.util.C3159aa;

/* compiled from: BackupListView.java */
/* renamed from: com.sec.chaton.localbackup.i */
/* loaded from: classes.dex */
class C1647i implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ BackupListView f6110a;

    C1647i(BackupListView backupListView) {
        this.f6110a = backupListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int checkedItemCount;
        C1657p c1657p = (C1657p) view.getTag();
        if (this.f6110a.f5961g == EnumC1652n.DELETE) {
            if (Build.VERSION.SDK_INT >= 11) {
                checkedItemCount = this.f6110a.f5959d.getCheckedItemCount();
            } else {
                checkedItemCount = 0;
                for (int i2 = 0; i2 < this.f6110a.f5959d.getCount(); i2++) {
                    if (this.f6110a.f5959d.getCheckedItemPositions().valueAt(i2)) {
                        checkedItemCount++;
                    }
                }
            }
            if (checkedItemCount == this.f6110a.f5957b.size()) {
                this.f6110a.f5962h.setChecked(true);
            } else {
                this.f6110a.f5962h.setChecked(false);
            }
            if (checkedItemCount > 0) {
                this.f6110a.f5963i.findItem(R.id.btnDeleteComplete).setEnabled(true);
                return;
            } else {
                this.f6110a.f5963i.findItem(R.id.btnDeleteComplete).setEnabled(false);
                return;
            }
        }
        if (!c1657p.f6134f.equals(C3159aa.m10962a().m10979a("backup_checkkey", ""))) {
            Intent intent = new Intent(this.f6110a.getActivity(), (Class<?>) ActivitySecretKey.class);
            intent.putExtra("password_mode", false);
            intent.putExtra("target_filepath", c1657p.f6132d);
            intent.putExtra(BackupListView.f5955a, c1657p.f6135g);
            this.f6110a.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this.f6110a.getActivity(), (Class<?>) ChatListActivity.class);
        intent2.putExtra(BackupListView.f5955a, c1657p.f6135g);
        this.f6110a.startActivity(intent2);
    }
}
