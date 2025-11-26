package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.registration.g */
/* loaded from: classes.dex */
class ViewOnClickListenerC0431g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityRegistPushName f2944a;

    ViewOnClickListenerC0431g(ActivityRegistPushName activityRegistPushName) {
        this.f2944a = activityRegistPushName;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0062R.id.btnDone == view.getId()) {
            Intent intent = new Intent();
            intent.putExtra("PUSH_NAME", this.f2944a.f2879a.getText().toString());
            this.f2944a.setResult(-1, intent);
            this.f2944a.finish();
            return;
        }
        if (C0062R.id.btnCancel == view.getId()) {
            this.f2944a.setResult(0);
            this.f2944a.f2879a.setText("");
        }
    }
}
