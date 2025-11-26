package com.sec.chaton.registration;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p022h.C0809s;
import com.sec.chaton.registration.ActivityNonSelfSMS;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: ActivityNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.u */
/* loaded from: classes.dex */
class ViewOnClickListenerC1208u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS.NonSelfSMSFragment f4424a;

    ViewOnClickListenerC1208u(ActivityNonSelfSMS.NonSelfSMSFragment nonSelfSMSFragment) {
        this.f4424a = nonSelfSMSFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llayoutid_01 /* 2131493674 */:
                C1789u.m6079a("authnum", (String) null);
                this.f4424a.getActivity().setResult(2, new Intent());
                C1789u.m6076a("over_sms_request", (Boolean) false);
                this.f4424a.getActivity().finish();
                break;
            case R.id.reSend /* 2131493679 */:
                C1789u.m6076a("isSMS", (Boolean) true);
                this.f4424a.f4189i.setEnabled(false);
                this.f4424a.f4188h.setText("");
                if (this.f4424a.getActivity() != null) {
                    this.f4424a.f4196q = ProgressDialogC1806j.m6141a(this.f4424a.getActivity(), null, this.f4424a.getResources().getString(R.string.dialog_connecting_server), true);
                }
                this.f4424a.f4205z = null;
                C1789u.m6079a("authnum", (String) null);
                this.f4424a.f4176D = false;
                if (TextUtils.isEmpty(this.f4424a.f4173A)) {
                    this.f4424a.m4352f();
                    break;
                } else {
                    int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
                    if (-3 == iM3420a || -2 == iM3420a) {
                        this.f4424a.f4196q.dismiss();
                        new AlertDialogBuilderC2120a(this.f4424a.getActivity()).setTitle(this.f4424a.getResources().getString(R.string.toast_error)).setMessage(this.f4424a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC1209v(this)).create().show();
                        this.f4424a.f4189i.setEnabled(true);
                        break;
                    }
                }
                break;
            case R.id.btnDone /* 2131493682 */:
                this.f4424a.m4348d();
                break;
            case R.id.btnRegiACS /* 2131493683 */:
                this.f4424a.f4188h.setText("");
                this.f4424a.f4205z = null;
                C1789u.m6079a("authnum", (String) null);
                C1789u.m6076a("isSMS", (Boolean) false);
                this.f4424a.startActivityForResult(new Intent(this.f4424a.getActivity(), (Class<?>) ActivitySelectLanguage.class), 0);
                break;
            case R.id.contact_us /* 2131493688 */:
                Intent intent = new Intent(this.f4424a.getActivity(), (Class<?>) ActivityWebView.class);
                intent.putExtra(FragmentWebView.PARAM_MENU, "VOC");
                intent.putExtra(FragmentWebView.REGI_VOC, true);
                this.f4424a.startActivity(intent);
                break;
        }
    }
}
