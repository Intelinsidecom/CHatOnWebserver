package com.sec.chaton.memo;

import android.content.DialogInterface;
import com.sec.chaton.memo.MemoAdapter;

/* renamed from: com.sec.chaton.memo.a */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0246a implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0248c f1947a;

    DialogInterfaceOnClickListenerC0246a(HandlerC0248c handlerC0248c) {
        this.f1947a = handlerC0248c;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1947a.f1950a.f1944g.m2005a(new MemoAdapter.MemoItem(WriteMemoActivity.f1936i, WriteMemoActivity.f1937j, this.f1947a.f1950a.f1939b.getText().toString(), String.valueOf(System.currentTimeMillis())));
        this.f1947a.f1950a.f1945h.show();
    }
}
