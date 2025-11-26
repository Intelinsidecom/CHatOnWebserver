package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;
import com.sec.chaton.privateplugin.data.SetSpamReq;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.privateplugin.p088a.C3033b;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4865cc;
import com.sec.chaton.util.EnumC4868cf;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fp */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4242fp implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f15596a;

    /* renamed from: b */
    final /* synthetic */ PluginComposeMessageActivity f15597b;

    DialogInterfaceOnClickListenerC4242fp(PluginComposeMessageActivity pluginComposeMessageActivity, String str) {
        this.f15597b = pluginComposeMessageActivity;
        this.f15596a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C4149cd.m16434e(this.f15597b, this.f15596a);
        Spam spam = new Spam();
        spam.setCat(Spam.CATEGORY_DEFAULT).setAct(Spam.ACTIVITY_REPORT);
        spam.setNum(this.f15596a);
        spam.setMsg("");
        SetSpamReq setSpamReq = new SetSpamReq();
        setSpamReq.setMsisdn(this.f15597b.m16023az()).setImei(C4822an.m18228d()).setImsi(C4822an.m18238h());
        setSpamReq.setSpam(spam);
        new Thread(new C3033b(C4865cc.m18450b(EnumC4868cf.CONTACT), 33947648, setSpamReq, this.f15597b.f14930B)).start();
        this.f15597b.m16018au();
        this.f15597b.m16020aw();
    }
}
