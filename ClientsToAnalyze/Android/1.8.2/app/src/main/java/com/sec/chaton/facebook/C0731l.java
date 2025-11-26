package com.sec.chaton.facebook;

import android.content.DialogInterface;
import android.os.Bundle;
import com.coolots.sso.model.ChatONCallStartInfo;
import com.p001a.p002a.C0026a;
import com.p001a.p002a.C0030e;
import com.p001a.p002a.C0036k;
import com.p001a.p002a.InterfaceC0029d;
import com.sec.chaton.R;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.l */
/* loaded from: classes.dex */
class C0731l implements InterfaceC0029d {

    /* renamed from: a */
    final /* synthetic */ C0725f f2718a;

    /* renamed from: b */
    private int f2719b;

    /* renamed from: c */
    private AbstractC0728i f2720c;

    /* synthetic */ C0731l(C0725f c0725f, int i, AbstractC0728i abstractC0728i, HandlerC0726g handlerC0726g) {
        this(c0725f, i, abstractC0728i);
    }

    private C0731l(C0725f c0725f, int i, AbstractC0728i abstractC0728i) {
        this.f2718a = c0725f;
        this.f2719b = i;
        this.f2720c = abstractC0728i;
    }

    @Override // com.p001a.p002a.InterfaceC0029d
    /* renamed from: a */
    public void mo20a(Bundle bundle) {
        HandlerC0726g handlerC0726g = null;
        C0725f.m3213c("Login Request:" + this.f2719b + " Done.");
        C0036k.m31a(C0725f.f2701b, this.f2718a.f2703c);
        AsyncTaskC0729j asyncTaskC0729j = new AsyncTaskC0729j(this.f2718a, this.f2719b, null);
        AsyncTaskC0729j asyncTaskC0729j2 = new AsyncTaskC0729j(this.f2718a, this.f2719b, null);
        C0734o c0734o = new C0734o(this.f2718a, handlerC0726g);
        C0727h c0727h = new C0727h(this.f2718a, handlerC0726g);
        this.f2718a.f2704d.mo3204a(this.f2719b, true);
        asyncTaskC0729j.execute(c0734o);
        if (this.f2720c == null) {
            AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(this.f2718a.f2703c);
            alertDialogBuilderC2120a.setTitle(R.string.user_facebook_account);
            alertDialogBuilderC2120a.setMessage(R.string.facebook_share_invitation_card_q);
            alertDialogBuilderC2120a.setCancelable(false);
            alertDialogBuilderC2120a.setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0732m(this, asyncTaskC0729j2, c0734o, c0727h));
            alertDialogBuilderC2120a.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
            alertDialogBuilderC2120a.show();
            return;
        }
        asyncTaskC0729j2.execute(c0734o, c0727h, this.f2720c);
    }

    @Override // com.p001a.p002a.InterfaceC0029d
    /* renamed from: a */
    public void mo19a() {
        C0725f.m3213c("Login Request:" + this.f2719b + " Canceled.");
        this.f2718a.f2704d.mo3203a(this.f2719b, 0, null);
    }

    @Override // com.p001a.p002a.InterfaceC0029d
    /* renamed from: a */
    public void mo22a(C0030e c0030e) {
        C0725f.m3214d("Login Request:" + this.f2719b + " Facebook Error. " + c0030e.getMessage());
        this.f2718a.f2704d.mo3203a(this.f2719b, ChatONCallStartInfo.ERROR_NOT_INITIALIZED_ENGINE, c0030e.getMessage());
    }

    @Override // com.p001a.p002a.InterfaceC0029d
    /* renamed from: a */
    public void mo21a(C0026a c0026a) {
        C0725f.m3214d("Login Request:" + this.f2719b + " Webview Error. " + c0026a.getMessage());
        this.f2718a.f2704d.mo3203a(this.f2719b, ChatONCallStartInfo.ERROR_UNKNOWN, c0026a.getMessage());
    }
}
