package com.sec.chaton.localbackup;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.localbackup.chatlist.ChatListActivity;
import com.sec.chaton.util.C4809aa;

/* compiled from: BackupListView.java */
/* renamed from: com.sec.chaton.localbackup.k */
/* loaded from: classes.dex */
class C2551k implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ BackupListView f9158a;

    C2551k(BackupListView backupListView) {
        this.f9158a = backupListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    @SuppressLint({"NewApi"})
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int checkedItemCount;
        C2559r c2559r = (C2559r) view.getTag();
        if (this.f9158a.f9002g == EnumC2557p.DELETE) {
            if (Build.VERSION.SDK_INT >= 11) {
                checkedItemCount = this.f9158a.f9000d.getCheckedItemCount();
            } else {
                checkedItemCount = 0;
                for (int i2 = 0; i2 < this.f9158a.f9000d.getCount(); i2++) {
                    if (this.f9158a.f9000d.getCheckedItemPositions().valueAt(i2)) {
                        checkedItemCount++;
                    }
                }
            }
            if (checkedItemCount == this.f9158a.f8998b.size()) {
                this.f9158a.f9003h.setChecked(true);
            } else {
                this.f9158a.f9003h.setChecked(false);
            }
            if (checkedItemCount > 0) {
                this.f9158a.f9004i.findItem(R.id.btnDeleteComplete).setEnabled(true);
                return;
            } else {
                this.f9158a.f9004i.findItem(R.id.btnDeleteComplete).setEnabled(false);
                return;
            }
        }
        if (!c2559r.f9178f.equals(C4809aa.m18104a().m18121a("backup_checkkey", ""))) {
            Intent intent = new Intent(this.f9158a.getActivity(), (Class<?>) ActivitySecretKey.class);
            intent.putExtra("password_mode", false);
            intent.putExtra("target_filepath", c2559r.f9176d);
            intent.putExtra(BackupListView.f8996a, c2559r.f9179g);
            this.f9158a.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this.f9158a.getActivity(), (Class<?>) ChatListActivity.class);
        intent2.putExtra(BackupListView.f8996a, c2559r.f9179g);
        this.f9158a.startActivity(intent2);
    }
}
