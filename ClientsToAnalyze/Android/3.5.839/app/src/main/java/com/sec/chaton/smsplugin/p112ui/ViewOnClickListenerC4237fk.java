package com.sec.chaton.smsplugin.p112ui;

import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.privateplugin.data.SetSpamReq;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.privateplugin.p088a.C3033b;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4865cc;
import com.sec.chaton.util.EnumC4868cf;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fk */
/* loaded from: classes.dex */
class ViewOnClickListenerC4237fk implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15591a;

    ViewOnClickListenerC4237fk(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15591a = pluginComposeMessageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String strM16022ay = this.f15591a.m16022ay();
        if (TextUtils.isEmpty(strM16022ay)) {
            C3890m.m14996b("Mms/compose", "[SpamWarning] showUnknownTab. Invalid unknownNumber.");
            return;
        }
        C4149cd.m16435f(this.f15591a, strM16022ay);
        Spam spam = new Spam();
        spam.setCat(Spam.CATEGORY_DEFAULT).setAct(Spam.ACTIVITY_CANCEL);
        spam.setNum(strM16022ay);
        spam.setMsg("");
        SetSpamReq setSpamReq = new SetSpamReq();
        setSpamReq.setMsisdn(this.f15591a.m16023az()).setImei(C4822an.m18228d()).setImsi(C4822an.m18238h());
        setSpamReq.setSpam(spam);
        new Thread(new C3033b(C4865cc.m18450b(EnumC4868cf.CONTACT), 34013184, setSpamReq, this.f15591a.f14930B)).start();
        this.f15591a.m16020aw();
    }
}
