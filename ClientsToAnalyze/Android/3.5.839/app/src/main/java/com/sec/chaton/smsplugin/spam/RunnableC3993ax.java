package com.sec.chaton.smsplugin.spam;

import com.android.i18n.phonenumbers.NumberParseException;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.sec.chaton.R;
import com.sec.chaton.privateplugin.data.SetSpamReq;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.privateplugin.p088a.C3033b;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4865cc;
import com.sec.chaton.util.EnumC4868cf;

/* compiled from: SetupSpamNumberList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.ax */
/* loaded from: classes.dex */
class RunnableC3993ax implements Runnable {

    /* renamed from: a */
    final /* synthetic */ DialogInterfaceOnClickListenerC3992aw f14434a;

    RunnableC3993ax(DialogInterfaceOnClickListenerC3992aw dialogInterfaceOnClickListenerC3992aw) {
        this.f14434a = dialogInterfaceOnClickListenerC3992aw;
    }

    @Override // java.lang.Runnable
    public void run() {
        C4017bu c4017bu;
        int count = this.f14434a.f14433a.f14373x.getCount() - this.f14434a.f14433a.f14344A;
        boolean z = false;
        while (count > 0) {
            if (this.f14434a.f14433a.f14373x.isItemChecked(count) && (c4017bu = (C4017bu) this.f14434a.f14433a.f14366p.get(count - this.f14434a.f14433a.f14344A)) != null) {
                this.f14434a.f14433a.m15364a(c4017bu.m15454a());
                this.f14434a.f14433a.f14366p.remove(count - this.f14434a.f14433a.f14344A);
                z = true;
                if (C3847e.m14651aB()) {
                    Spam spam = new Spam();
                    spam.setCat(Spam.CATEGORY_DEFAULT).setAct(Spam.ACTIVITY_REPORT);
                    spam.setNum(c4017bu.m15458c());
                    spam.setMsg("");
                    SetSpamReq setSpamReq = new SetSpamReq();
                    try {
                        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
                        setSpamReq.setMsisdn(phoneNumberUtil.format(phoneNumberUtil.parse(C4822an.m18234f(), C4822an.m18236g().toUpperCase()), PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL)).setImei(C4822an.m18228d()).setImsi(C4822an.m18238h());
                        setSpamReq.setSpam(spam);
                        new Thread(new C3033b(C4865cc.m18450b(EnumC4868cf.CONTACT), 34013184, setSpamReq, this.f14434a.f14433a.f14365o)).start();
                        this.f14434a.f14433a.m15377c(R.string.wait_sending);
                    } catch (NumberParseException e) {
                        e.printStackTrace();
                    }
                }
            }
            count--;
            z = z;
        }
        if (z) {
            this.f14434a.f14433a.f14370u = 0;
            this.f14434a.f14433a.m15374b(this.f14434a.f14433a.getString(R.string.delete_complete));
            this.f14434a.f14433a.m15390j();
            return;
        }
        C3890m.m14999e("Mms/SetupSpamNumberList", "softkeyLeftRun - no item");
    }
}
