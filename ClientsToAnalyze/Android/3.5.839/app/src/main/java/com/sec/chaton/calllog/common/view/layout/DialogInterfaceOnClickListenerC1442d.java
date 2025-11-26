package com.sec.chaton.calllog.common.view.layout;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.calllog.view.CallLogFragment;
import com.sec.chaton.global.GlobalApplication;
import java.util.List;

/* compiled from: RadioButtonListDialog.java */
/* renamed from: com.sec.chaton.calllog.common.view.layout.d */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1442d implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ List f5143a;

    /* renamed from: b */
    final /* synthetic */ RadioButtonListDialog f5144b;

    DialogInterfaceOnClickListenerC1442d(RadioButtonListDialog radioButtonListDialog, List list) {
        this.f5144b = radioButtonListDialog;
        this.f5143a = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Fragment fragmentMo180a = this.f5144b.getFragmentManager().mo180a(R.id.fragment_controller);
        if (fragmentMo180a instanceof CallLogFragment) {
            if (((CharSequence) this.f5143a.get(i)).equals(GlobalApplication.m10283b().getString(R.string.calllog_all_logs))) {
                int unused = RadioButtonListDialog.f5133j = 0;
            } else if (((CharSequence) this.f5143a.get(i)).equals(GlobalApplication.m10283b().getString(R.string.calllog_all_voice_calls))) {
                int unused2 = RadioButtonListDialog.f5133j = 1;
            } else if (((CharSequence) this.f5143a.get(i)).equals(GlobalApplication.m10283b().getString(R.string.calllog_all_video_calls))) {
                int unused3 = RadioButtonListDialog.f5133j = 2;
            } else if (((CharSequence) this.f5143a.get(i)).equals(GlobalApplication.m10283b().getString(R.string.calllog_all_single_calls))) {
                int unused4 = RadioButtonListDialog.f5133j = 3;
            } else if (((CharSequence) this.f5143a.get(i)).equals(GlobalApplication.m10283b().getString(R.string.calllog_all_group_calls))) {
                int unused5 = RadioButtonListDialog.f5133j = 4;
            } else if (((CharSequence) this.f5143a.get(i)).equals(GlobalApplication.m10283b().getString(R.string.calllog_missed_calls))) {
                int unused6 = RadioButtonListDialog.f5133j = 5;
            } else if (((CharSequence) this.f5143a.get(i)).equals(GlobalApplication.m10283b().getString(R.string.calllog_dialed_calls))) {
                int unused7 = RadioButtonListDialog.f5133j = 6;
            } else if (((CharSequence) this.f5143a.get(i)).equals(GlobalApplication.m10283b().getString(R.string.calllog_received_calls))) {
                int unused8 = RadioButtonListDialog.f5133j = 7;
            } else if (((CharSequence) this.f5143a.get(i)).equals(GlobalApplication.m10283b().getString(R.string.calllog_rejected_calls))) {
                int unused9 = RadioButtonListDialog.f5133j = 8;
            }
            ((CallLogFragment) fragmentMo180a).m7739c(RadioButtonListDialog.f5133j);
            this.f5144b.m34a();
        }
    }
}
