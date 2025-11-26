package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.widget.ProgressDialogC3265l;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.dc */
/* loaded from: classes.dex */
class ViewOnClickListenerC2206dc implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f8499a;

    ViewOnClickListenerC2206dc(FragmentNonSelfSMS fragmentNonSelfSMS) {
        this.f8499a = fragmentNonSelfSMS;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.changePho /* 2131166101 */:
                C3159aa.m10966a("authnum", (String) null);
                this.f8499a.getActivity().setResult(2, new Intent());
                this.f8499a.getActivity().finish();
                break;
            case R.id.reSend /* 2131166107 */:
                this.f8499a.f8240h.setEnabled(false);
                this.f8499a.f8258z.setEnabled(false);
                this.f8499a.f8230K.setEnabled(false);
                C3159aa.m10963a("isSMS", (Boolean) true);
                this.f8499a.f8239g.setText("");
                if (this.f8499a.getActivity() != null) {
                    this.f8499a.f8246n = ProgressDialogC3265l.m11490a(this.f8499a.getActivity(), null, this.f8499a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
                }
                this.f8499a.f8255w = null;
                C3159aa.m10966a("authnum", (String) null);
                this.f8499a.m8544d();
                break;
            case R.id.btnRegiACS /* 2131166108 */:
                this.f8499a.f8239g.setText("");
                this.f8499a.f8255w = null;
                C3159aa.m10966a("authnum", (String) null);
                C3159aa.m10963a("isSMS", (Boolean) false);
                Intent intent = new Intent(this.f8499a.getActivity(), (Class<?>) ActivitySelectLanguage.class);
                if (this.f8499a.f8229J) {
                    intent.putExtra(FragmentRegist.f8259a, true);
                }
                this.f8499a.startActivityForResult(intent, 0);
                break;
            case R.id.btnRegiskip /* 2131166109 */:
                this.f8499a.startActivity(new Intent(this.f8499a.getActivity(), (Class<?>) TabActivity.class));
                this.f8499a.getActivity().finish();
                break;
            case R.id.btnVOC /* 2131166110 */:
                Intent intent2 = new Intent(this.f8499a.getActivity(), (Class<?>) ActivityWebView.class);
                intent2.putExtra("PARAM_MENU", "VOC");
                intent2.putExtra("REGI_VOC", true);
                this.f8499a.startActivity(intent2);
                break;
        }
    }
}
