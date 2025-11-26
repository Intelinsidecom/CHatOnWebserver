package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.settings.FragmentWebView;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.db */
/* loaded from: classes.dex */
class ViewOnClickListenerC3214db implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f11979a;

    ViewOnClickListenerC3214db(FragmentNonSelfSMS fragmentNonSelfSMS) {
        this.f11979a = fragmentNonSelfSMS;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.changePho /* 2131166038 */:
                C4809aa.m18108a("authnum", (String) null);
                this.f11979a.getActivity().setResult(2, new Intent());
                this.f11979a.getActivity().finish();
                break;
            case R.id.reSend /* 2131166044 */:
                this.f11979a.f11686h.setEnabled(false);
                this.f11979a.f11664A.setEnabled(false);
                this.f11979a.f11675L.setEnabled(false);
                C4809aa.m18105a("isSMS", (Boolean) true);
                this.f11979a.f11685g.setText("");
                if (this.f11979a.getActivity() != null) {
                    this.f11979a.f11692n = ProgressDialogC4926s.m18728a(this.f11979a.getActivity(), null, this.f11979a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
                }
                this.f11979a.f11702x = null;
                C4809aa.m18108a("authnum", (String) null);
                this.f11979a.m12877d();
                break;
            case R.id.btnRegiACS /* 2131166045 */:
                this.f11979a.f11685g.setText("");
                this.f11979a.f11702x = null;
                C4809aa.m18108a("authnum", (String) null);
                C4809aa.m18105a("isSMS", (Boolean) false);
                Intent intent = new Intent(this.f11979a.getActivity(), (Class<?>) ActivitySelectLanguage.class);
                if (this.f11979a.f11674K) {
                    intent.putExtra(FragmentRegist.f11705a, true);
                }
                this.f11979a.startActivityForResult(intent, 0);
                break;
            case R.id.btnRegiskip /* 2131166046 */:
                this.f11979a.getActivity().setResult(3);
                this.f11979a.getActivity().finish();
                break;
            case R.id.btnVOC /* 2131166047 */:
                this.f11979a.startActivity(C4859bx.m18371a(this.f11979a.getActivity(), FragmentWebView.mode.voc, (String) null));
                break;
        }
    }
}
