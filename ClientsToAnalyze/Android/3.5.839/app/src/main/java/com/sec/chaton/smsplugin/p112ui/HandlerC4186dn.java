package com.sec.chaton.smsplugin.p112ui;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3897t;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.dn */
/* loaded from: classes.dex */
class HandlerC4186dn extends Handler {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15511a;

    HandlerC4186dn(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15511a = pluginComposeMessageActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        switch (message.what) {
            case 1:
                str = "mms";
                break;
            case 2:
                str = "sms";
                break;
            case 3:
                String[] strArr = (String[]) message.obj;
                String str2 = strArr[0];
                String str3 = strArr[1];
                if (str2.startsWith("geo:")) {
                    C3897t.m15050a(GlobalApplication.m18732r(), C3897t.m15048a(str2));
                    return;
                } else {
                    C4149cd.m16398a((Activity) this.f15511a, str2, str3);
                    return;
                }
            default:
                C3890m.m14997c("Mms/compose", "Unknown message: " + message.what);
                return;
        }
        C4108aq c4108aqM15929a = this.f15511a.m15929a(str, ((Long) message.obj).longValue(), false);
        if (c4108aqM15929a != null) {
            if (c4108aqM15929a.m16309l() && C3847e.m14679ak()) {
                if (new C4132bn(this.f15511a.getApplicationContext(), this.f15511a, c4108aqM15929a, c4108aqM15929a.m16307j(), c4108aqM15929a.f15267b).m16386a(c4108aqM15929a, this.f15511a.f14935G, false)) {
                    this.f15511a.m15965a(new RunnableC4187do(this));
                }
            } else {
                CharSequence[] charSequenceArr = {GlobalApplication.m10283b().getString(R.string.view_resend), GlobalApplication.m10283b().getString(R.string.menu_chat_delete)};
                AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f15511a);
                if (c4108aqM15929a.m16299b() == EnumC2214ab.TEXT) {
                    abstractC4932aM18733a.mo18734a(R.string.media_text);
                } else if (c4108aqM15929a.m16299b() == EnumC2214ab.VIDEO) {
                    abstractC4932aM18733a.mo18734a(R.string.media_video);
                } else if (c4108aqM15929a.m16299b() == EnumC2214ab.IMAGE) {
                    abstractC4932aM18733a.mo18734a(R.string.media_photo);
                } else if (c4108aqM15929a.m16299b() == EnumC2214ab.CALENDAR) {
                    abstractC4932aM18733a.mo18734a(R.string.media_calendar);
                } else if (c4108aqM15929a.m16299b() == EnumC2214ab.AUDIO) {
                    abstractC4932aM18733a.mo18734a(R.string.media_voice);
                } else if (c4108aqM15929a.m16299b() == EnumC2214ab.CONTACT) {
                    abstractC4932aM18733a.mo18734a(R.string.media_contact);
                } else if (c4108aqM15929a.m16299b() == EnumC2214ab.GEO) {
                    abstractC4932aM18733a.mo18734a(R.string.layout_calendar_location);
                } else if (c4108aqM15929a.m16299b() == EnumC2214ab.ANICON) {
                    abstractC4932aM18733a.mo18734a(R.string.media_anicon);
                } else {
                    abstractC4932aM18733a.mo18734a(R.string.pref_sms_settings_title);
                }
                abstractC4932aM18733a.mo18744a(charSequenceArr, new DialogInterfaceOnClickListenerC4188dp(this, c4108aqM15929a));
                abstractC4932aM18733a.mo18751b(true);
                abstractC4932aM18733a.mo18752b();
            }
            this.f15511a.m15988ac();
            this.f15511a.m15903R();
        }
    }
}
