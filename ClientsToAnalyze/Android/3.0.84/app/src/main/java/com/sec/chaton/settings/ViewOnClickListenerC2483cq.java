package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.cq */
/* loaded from: classes.dex */
class ViewOnClickListenerC2483cq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC2481co f9369a;

    ViewOnClickListenerC2483cq(AlertDialogC2481co alertDialogC2481co) {
        this.f9369a = alertDialogC2481co;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_up /* 2131165264 */:
                this.f9369a.m9240f();
                break;
            case R.id.btn_start_down /* 2131165266 */:
                this.f9369a.m9238e();
                break;
            case R.id.btn_start_min_up /* 2131165267 */:
                this.f9369a.m9247j();
                break;
            case R.id.btn_start_min_down /* 2131165269 */:
                this.f9369a.m9245i();
                break;
            case R.id.btn_end_up /* 2131165270 */:
                this.f9369a.m9236d();
                break;
            case R.id.btn_end_down /* 2131165272 */:
                this.f9369a.m9233c();
                break;
            case R.id.btn_end_min_up /* 2131165273 */:
                this.f9369a.m9244h();
                break;
            case R.id.btn_end_min_down /* 2131165275 */:
                this.f9369a.m9242g();
                break;
        }
        if (this.f9369a.f9350c == this.f9369a.f9351d && this.f9369a.f9365r.getText().toString().equals(this.f9369a.f9364q.getText().toString())) {
            this.f9369a.getButton(-2).setEnabled(false);
        } else {
            this.f9369a.getButton(-2).setEnabled(true);
        }
    }
}
