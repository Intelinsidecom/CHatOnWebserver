package com.sec.chaton.memo;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: WriteMemoActivity.java */
/* renamed from: com.sec.chaton.memo.e */
/* loaded from: classes.dex */
class ViewOnClickListenerC0732e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ WriteMemoActivity f2475a;

    ViewOnClickListenerC0732e(WriteMemoActivity writeMemoActivity) {
        this.f2475a = writeMemoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.header_button1 /* 2131427690 */:
                this.f2475a.f2462e.m863a(new C0734g(WriteMemoActivity.f2456g, WriteMemoActivity.f2457i, this.f2475a.f2459b.getText().toString(), String.valueOf(System.currentTimeMillis())));
                this.f2475a.f2463f.show();
                break;
        }
    }
}
