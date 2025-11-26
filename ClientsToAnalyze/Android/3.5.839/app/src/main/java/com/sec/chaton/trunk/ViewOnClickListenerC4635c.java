package com.sec.chaton.trunk;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.widget.C5179v;

/* compiled from: ContentAdapter.java */
/* renamed from: com.sec.chaton.trunk.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC4635c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4662d f16812a;

    /* renamed from: b */
    final /* synthetic */ C4602b f16813b;

    ViewOnClickListenerC4635c(C4602b c4602b, C4662d c4662d) {
        this.f16813b = c4602b;
        this.f16812a = c4662d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = this.f16812a.f16885e;
        String str2 = this.f16812a.f16886f;
        if (str == null || str.trim().equals("")) {
            C5179v.m19811a(this.f16813b.f16732j, String.format(this.f16813b.f16732j.getString(R.string.toast_deleted_account), str2), 0).show();
            return;
        }
        if (!"ME".equals(str)) {
            Intent intent = new Intent(this.f16813b.f16732j, (Class<?>) BuddyDialog.class);
            intent.putExtra("BUDDY_DIALOG_BUDDY_NO", str);
            intent.putExtra("BUDDY_DIALOG_BUDDY_NAME", str2);
            intent.setFlags(268435456);
            this.f16813b.f16732j.startActivity(intent);
        }
    }
}
