package com.sec.chaton.trunk;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.global.GlobalApplication;
import com.sec.widget.C3641ai;

/* compiled from: ContentAdapter.java */
/* renamed from: com.sec.chaton.trunk.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC3019c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3042d f10895a;

    /* renamed from: b */
    final /* synthetic */ C2986b f10896b;

    ViewOnClickListenerC3019c(C2986b c2986b, C3042d c3042d) {
        this.f10896b = c2986b;
        this.f10895a = c3042d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = this.f10895a.f10935f;
        String str2 = this.f10895a.f10936g;
        if (str == null || str.trim().equals("")) {
            C3641ai.m13211a(this.f10896b.f10811a, String.format(this.f10896b.f10811a.getString(R.string.toast_deleted_account), str2), 0).show();
            return;
        }
        if (!"ME".equals(str)) {
            if (GlobalApplication.m6456e()) {
                Intent intent = new Intent(this.f10896b.f10811a, (Class<?>) BuddyProfileActivity.class);
                intent.putExtra("PROFILE_BUDDY_NO", str);
                intent.putExtra("PROFILE_BUDDY_NAME", str2);
                intent.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
                this.f10896b.f10811a.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(this.f10896b.f10811a, (Class<?>) BuddyDialog.class);
            intent2.putExtra("BUDDY_DIALOG_BUDDY_NO", str);
            intent2.putExtra("BUDDY_DIALOG_BUDDY_NAME", str2);
            intent2.setFlags(268435456);
            this.f10896b.f10811a.startActivity(intent2);
        }
    }
}
