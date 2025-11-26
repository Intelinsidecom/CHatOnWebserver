package com.sec.chaton.samsungaccount;

import android.content.res.Resources;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.global.C1493a;
import java.io.UnsupportedEncodingException;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.au */
/* loaded from: classes.dex */
class ViewOnClickListenerC2332au implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MainActivity f8754a;

    ViewOnClickListenerC2332au(MainActivity mainActivity) {
        this.f8754a = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException, UnsupportedEncodingException {
        switch (view.getId()) {
            case R.id.btn_phone_number /* 2131166041 */:
                this.f8754a.f8728y = true;
                this.f8754a.m8797q();
                break;
            case R.id.btn_samsung_account /* 2131166043 */:
            case R.id.btn_next /* 2131166047 */:
                if (!C1493a.m6463a("mum_enable_feature")) {
                    this.f8754a.m8777f();
                    break;
                } else {
                    this.f8754a.m8744a(true);
                    break;
                }
            case R.id.sns_or_skip /* 2131166044 */:
                this.f8754a.m8794o();
                break;
        }
    }
}
