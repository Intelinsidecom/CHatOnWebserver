package com.sec.chaton.registration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.dz */
/* loaded from: classes.dex */
class C3238dz extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f12004a;

    C3238dz(FragmentRegist fragmentRegist) {
        this.f12004a = fragmentRegist;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.getBoolean("isCritical")) {
                this.f12004a.getActivity().finish();
                return;
            }
            int i = extras.getInt("which_service");
            if (this.f12004a.getActivity() != null) {
                this.f12004a.f11729R = ProgressDialogC4926s.m18728a(this.f12004a.f11731T, null, this.f12004a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            }
            if (i == 0) {
                this.f12004a.f11737Z.m9470a("FIRST");
                return;
            } else {
                if (i == 2) {
                    this.f12004a.f11737Z.m9470a("FIRST");
                    return;
                }
                return;
            }
        }
        this.f12004a.getActivity().finish();
    }
}
