package com.sec.chaton;

import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.util.HandlerC4826ar;
import com.sec.common.CommonApplication;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.b */
/* loaded from: classes.dex */
class HandlerC1055b extends HandlerC4826ar {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f3344a;

    HandlerC1055b(AdminMenu adminMenu) {
        this.f3344a = adminMenu;
    }

    @Override // com.sec.chaton.util.HandlerC4826ar
    /* renamed from: a */
    public void mo6050a(Message message) {
        if (this.f3344a.f1900ak != null && this.f3344a.f1900ak.isShowing()) {
            this.f3344a.f1900ak.dismiss();
        }
        if (((Boolean) message.obj).booleanValue()) {
            Toast.makeText(CommonApplication.m18732r(), "Push deregistration is SUCCESS.", 0).show();
        } else {
            Toast.makeText(CommonApplication.m18732r(), "Push deregistration is FAIL.", 0).show();
        }
    }
}
