package com.sec.chaton;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.dialog.ChatONVInstallDialog;
import com.sec.chaton.buddy.dialog.ChatONVRedirectDialog;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.bm */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0501bm implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1639a;

    DialogInterfaceOnClickListenerC0501bm(TabActivity tabActivity) {
        this.f1639a = tabActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        BuddyFragment.f1734m = true;
        switch (i) {
            case 0:
                Intent intent = new Intent(this.f1639a.getApplicationContext(), (Class<?>) BuddyActivity2.class);
                intent.putExtra("ACTIVITY_PURPOSE", 2);
                intent.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
                this.f1639a.startActivity(intent);
                break;
            case 1:
                Intent intent2 = new Intent(this.f1639a.getApplicationContext(), (Class<?>) BuddyActivity2.class);
                intent2.putExtra("ACTIVITY_PURPOSE", 3);
                intent2.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
                this.f1639a.startActivity(intent2);
                break;
            case 2:
                if (this.f1639a.m1212J()) {
                    if (this.f1639a.m1210I()) {
                        Intent intent3 = new Intent(this.f1639a.getApplicationContext(), (Class<?>) BuddyActivity2.class);
                        intent3.putExtra("ACTIVITY_PURPOSE", 14);
                        this.f1639a.startActivity(intent3);
                        break;
                    } else {
                        this.f1639a.startActivity(new Intent(this.f1639a.getApplicationContext(), (Class<?>) ChatONVInstallDialog.class));
                        break;
                    }
                } else if (!this.f1639a.m1214K()) {
                    this.f1639a.startActivity(new Intent(this.f1639a.getApplicationContext(), (Class<?>) ChatONVRedirectDialog.class));
                    break;
                }
                break;
            case 3:
                if (this.f1639a.m1212J()) {
                    if (this.f1639a.m1210I()) {
                        Intent intent4 = new Intent(this.f1639a.getApplicationContext(), (Class<?>) BuddyActivity2.class);
                        intent4.putExtra("ACTIVITY_PURPOSE", 15);
                        this.f1639a.startActivity(intent4);
                        break;
                    } else {
                        this.f1639a.startActivity(new Intent(this.f1639a.getApplicationContext(), (Class<?>) ChatONVInstallDialog.class));
                        break;
                    }
                } else if (!this.f1639a.m1214K()) {
                    this.f1639a.startActivity(new Intent(this.f1639a.getApplicationContext(), (Class<?>) ChatONVRedirectDialog.class));
                    break;
                }
                break;
        }
    }
}
