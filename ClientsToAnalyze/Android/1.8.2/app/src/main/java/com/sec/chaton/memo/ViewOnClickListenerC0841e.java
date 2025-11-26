package com.sec.chaton.memo;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: WriteMemoActivity.java */
/* renamed from: com.sec.chaton.memo.e */
/* loaded from: classes.dex */
class ViewOnClickListenerC0841e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ WriteMemoActivity f3092a;

    ViewOnClickListenerC0841e(WriteMemoActivity writeMemoActivity) {
        this.f3092a = writeMemoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnWriteMemoDone /* 2131493917 */:
                this.f3092a.f3072j.m2896a(new C0839c(WriteMemoActivity.f3064l, WriteMemoActivity.f3065m, this.f3092a.f3067b.getText().toString(), String.valueOf(System.currentTimeMillis())));
                this.f3092a.f3073k.show();
                break;
            case R.id.btnWriteMemoCancel /* 2131493918 */:
                this.f3092a.setResult(0);
                this.f3092a.finish();
                this.f3092a.f3067b.setText("");
                break;
        }
    }
}
