package com.sec.chaton.memo;

import android.view.View;
import com.sec.chaton.C0062R;
import com.sec.chaton.memo.MemoAdapter;

/* renamed from: com.sec.chaton.memo.d */
/* loaded from: classes.dex */
class ViewOnClickListenerC0249d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ WriteMemoActivity f1951a;

    ViewOnClickListenerC0249d(WriteMemoActivity writeMemoActivity) {
        this.f1951a = writeMemoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.btnWriteMemoDone /* 2131428012 */:
                this.f1951a.f1944g.m2005a(new MemoAdapter.MemoItem(WriteMemoActivity.f1936i, WriteMemoActivity.f1937j, this.f1951a.f1939b.getText().toString(), String.valueOf(System.currentTimeMillis())));
                this.f1951a.f1945h.show();
                break;
            case C0062R.id.btnWriteMemoCancel /* 2131428013 */:
                this.f1951a.setResult(0);
                this.f1951a.finish();
                this.f1951a.f1939b.setText("");
                break;
        }
    }
}
