package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.registration.ActivityNonSelfSMS;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.widget.ProgressDialogC1354a;

/* compiled from: ActivityNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.az */
/* loaded from: classes.dex */
class ViewOnClickListenerC0954az implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS.NonSelfSMSFragment f3345a;

    ViewOnClickListenerC0954az(ActivityNonSelfSMS.NonSelfSMSFragment nonSelfSMSFragment) {
        this.f3345a = nonSelfSMSFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDone /* 2131427889 */:
                this.f3345a.m3659a();
                break;
            case R.id.changePho /* 2131427946 */:
                C1323bs.m4579a("authnum", (String) null);
                C1323bs.m4579a("token", (String) null);
                this.f3345a.getActivity().setResult(2, new Intent());
                this.f3345a.getActivity().finish();
                break;
            case R.id.reSend /* 2131427950 */:
                C1323bs.m4576a("isSMS", (Boolean) true);
                this.f3345a.f3161g.setEnabled(false);
                this.f3345a.f3160f.setText("");
                if (this.f3345a.getActivity() != null) {
                    this.f3345a.f3168n = ProgressDialogC1354a.m4724a(this.f3345a.getActivity(), null, this.f3345a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
                }
                this.f3345a.f3178x = null;
                C1323bs.m4579a("authnum", (String) null);
                this.f3345a.f3153B = false;
                if (this.f3345a.f3179y == null) {
                    this.f3345a.m3670d();
                    break;
                } else {
                    this.f3345a.m3671e();
                    break;
                }
            case R.id.btnRegiACS /* 2131427951 */:
                this.f3345a.f3160f.setText("");
                this.f3345a.f3178x = null;
                C1323bs.m4579a("authnum", (String) null);
                C1323bs.m4576a("isSMS", (Boolean) false);
                this.f3345a.startActivityForResult(new Intent(this.f3345a.getActivity(), (Class<?>) ActivitySelectLanguage.class), 0);
                break;
            case R.id.btnVOC /* 2131427952 */:
                Intent intent = new Intent(this.f3345a.getActivity(), (Class<?>) ActivityWebView.class);
                intent.putExtra(FragmentWebView.PARAM_MENU, "VOC");
                intent.putExtra(FragmentWebView.REGI_VOC, true);
                this.f3345a.startActivity(intent);
                break;
        }
    }
}
