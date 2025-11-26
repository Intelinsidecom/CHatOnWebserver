package com.sec.chaton.registration;

import android.app.ProgressDialog;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.registration.j */
/* loaded from: classes.dex */
class ViewOnClickListenerC0434j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS f2947a;

    ViewOnClickListenerC0434j(ActivityNonSelfSMS activityNonSelfSMS) {
        this.f2947a = activityNonSelfSMS;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.changePho /* 2131427887 */:
                this.f2947a.finish();
                break;
            case C0062R.id.reSend /* 2131427890 */:
                this.f2947a.f2816i.setText("");
                this.f2947a.f2824q = ProgressDialog.show(this.f2947a.f2810c, null, this.f2947a.getResources().getString(C0062R.string.dialog_connecting_server), true);
                if (this.f2947a.f2808a != null) {
                    this.f2947a.m3054e();
                    break;
                } else {
                    this.f2947a.m3051d();
                    break;
                }
            case C0062R.id.btnDone /* 2131427895 */:
                this.f2947a.f2811d = this.f2947a.f2816i.getText().toString();
                if (!TextUtils.isEmpty(this.f2947a.f2811d) && this.f2947a.f2829v.length() >= 1) {
                    this.f2947a.f2824q = ProgressDialog.show(this.f2947a.f2810c, null, this.f2947a.getResources().getString(C0062R.string.please_wait), true);
                    this.f2947a.m3056f();
                    break;
                }
                break;
        }
    }
}
