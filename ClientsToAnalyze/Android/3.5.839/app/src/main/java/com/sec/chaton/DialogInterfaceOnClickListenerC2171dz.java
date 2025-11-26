package com.sec.chaton;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.dialog.ChatONVInstallDialog;
import com.sec.chaton.buddy.dialog.ChatONVRedirectDialog;
import com.sec.chaton.global.GlobalApplication;
import java.util.List;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.dz */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2171dz implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ List f7800a;

    /* renamed from: b */
    final /* synthetic */ TabActivity f7801b;

    DialogInterfaceOnClickListenerC2171dz(TabActivity tabActivity, List list) {
        this.f7801b = tabActivity;
        this.f7800a = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        BuddyFragment.f3586l = true;
        if (((CharSequence) this.f7800a.get(i)).equals(GlobalApplication.m10283b().getString(R.string.menu_send_to_freechat))) {
            this.f7801b.m3089g();
            return;
        }
        if (((CharSequence) this.f7800a.get(i)).equals(GlobalApplication.m10283b().getString(R.string.menu_inbox_broadcast))) {
            Intent intent = new Intent(this.f7801b.getApplicationContext(), (Class<?>) BuddyActivity2.class);
            intent.putExtra("ACTIVITY_PURPOSE", 3);
            intent.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
            this.f7801b.startActivity(intent);
            return;
        }
        if (((CharSequence) this.f7800a.get(i)).equals(GlobalApplication.m10283b().getString(R.string.menu_send_to_message))) {
            this.f7801b.m3090h();
            return;
        }
        if (((CharSequence) this.f7800a.get(i)).equals(GlobalApplication.m10283b().getString(R.string.menu_voice_call))) {
            if (this.f7801b.m3009M()) {
                if (this.f7801b.m3008L()) {
                    Intent intent2 = new Intent(this.f7801b.getApplicationContext(), (Class<?>) BuddyActivity2.class);
                    intent2.putExtra("ACTIVITY_PURPOSE", 14);
                    this.f7801b.startActivity(intent2);
                    return;
                } else {
                    this.f7801b.startActivity(new Intent(this.f7801b.getApplicationContext(), (Class<?>) ChatONVInstallDialog.class));
                    return;
                }
            }
            if (!this.f7801b.m3010N()) {
                this.f7801b.startActivity(new Intent(this.f7801b.getApplicationContext(), (Class<?>) ChatONVRedirectDialog.class));
                return;
            }
            return;
        }
        if (((CharSequence) this.f7800a.get(i)).equals(GlobalApplication.m10283b().getString(R.string.menu_video_call))) {
            if (this.f7801b.m3009M()) {
                if (this.f7801b.m3008L()) {
                    Intent intent3 = new Intent(this.f7801b.getApplicationContext(), (Class<?>) BuddyActivity2.class);
                    intent3.putExtra("ACTIVITY_PURPOSE", 15);
                    this.f7801b.startActivity(intent3);
                    return;
                } else {
                    this.f7801b.startActivity(new Intent(this.f7801b.getApplicationContext(), (Class<?>) ChatONVInstallDialog.class));
                    return;
                }
            }
            if (!this.f7801b.m3010N()) {
                this.f7801b.startActivity(new Intent(this.f7801b.getApplicationContext(), (Class<?>) ChatONVRedirectDialog.class));
            }
        }
    }
}
