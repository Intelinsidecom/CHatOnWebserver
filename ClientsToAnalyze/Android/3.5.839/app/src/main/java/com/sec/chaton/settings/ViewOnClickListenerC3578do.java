package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.do */
/* loaded from: classes.dex */
class ViewOnClickListenerC3578do implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC3576dm f13095a;

    ViewOnClickListenerC3578do(AlertDialogC3576dm alertDialogC3576dm) {
        this.f13095a = alertDialogC3576dm;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_up /* 2131165268 */:
                this.f13095a.m13879f();
                break;
            case R.id.btn_start_down /* 2131165270 */:
                this.f13095a.m13877e();
                break;
            case R.id.btn_start_min_up /* 2131165271 */:
                this.f13095a.m13886j();
                break;
            case R.id.btn_start_min_down /* 2131165273 */:
                this.f13095a.m13885i();
                break;
            case R.id.btn_end_up /* 2131165274 */:
                this.f13095a.m13875d();
                break;
            case R.id.btn_end_down /* 2131165276 */:
                this.f13095a.m13872c();
                break;
            case R.id.btn_end_min_up /* 2131165277 */:
                this.f13095a.m13883h();
                break;
            case R.id.btn_end_min_down /* 2131165279 */:
                this.f13095a.m13881g();
                break;
        }
        if (this.f13095a.f13075c == this.f13095a.f13076d && this.f13095a.f13090r.getText().toString().equals(this.f13095a.f13089q.getText().toString())) {
            this.f13095a.getButton(-2).setEnabled(false);
        } else {
            this.f13095a.getButton(-2).setEnabled(true);
        }
    }
}
