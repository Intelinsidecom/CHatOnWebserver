package com.sec.chaton.chat.p054a;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.sec.chaton.hugefiletransfer.HugeFileUploadService;
import com.sec.common.CommonApplication;

/* compiled from: HugeFileBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.ab */
/* loaded from: classes.dex */
class ViewOnClickListenerC1508ab implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1507aa f5881a;

    ViewOnClickListenerC1508ab(C1507aa c1507aa) {
        this.f5881a = c1507aa;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(CommonApplication.m18732r(), (Class<?>) HugeFileUploadService.class);
        intent.putExtra("huge_file_request_id", this.f5881a.f5868o);
        intent.putExtra("huge_file_from_chat", true);
        intent.putExtra("huge_file_cancel", true);
        intent.setData(Uri.parse(this.f5881a.f5876w));
        this.f5881a.f5856c.startService(intent);
    }
}
