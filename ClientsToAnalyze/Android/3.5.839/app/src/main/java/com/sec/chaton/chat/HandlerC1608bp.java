package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3897t;
import com.sec.chaton.smsplugin.p112ui.C4108aq;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bp */
/* loaded from: classes.dex */
class HandlerC1608bp extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6124a;

    HandlerC1608bp(ChatFragment chatFragment) {
        this.f6124a = chatFragment;
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
                if (!str2.startsWith("geo:")) {
                    C4149cd.m16398a(this.f6124a.f5624cN, str2, str3);
                    return;
                } else {
                    C3897t.m15050a(GlobalApplication.m18732r(), C3897t.m15048a(str2));
                    return;
                }
            default:
                C3890m.m14997c(ChatFragment.f5461a, "Unknown message: " + message.what);
                return;
        }
        C4108aq c4108aqM8557a = this.f6124a.f5528aU.m8557a(str, ((Long) message.obj).longValue(), this.f6124a.f5528aU.mo871a());
        if (c4108aqM8557a == null) {
            C4904y.m18639b("MessageItem null in mMessageListItemHandler", ChatFragment.f5461a);
            return;
        }
        C4904y.m18639b("Checking SMS menu", ChatFragment.f5461a);
        CharSequence[] charSequenceArr = {GlobalApplication.m10283b().getString(R.string.view_resend), GlobalApplication.m10283b().getString(R.string.menu_chat_delete)};
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f6124a.f5624cN);
        if (c4108aqM8557a.m16299b() == EnumC2214ab.TEXT) {
            abstractC4932aM18733a.mo18734a(R.string.media_text);
        } else if (c4108aqM8557a.m16299b() == EnumC2214ab.VIDEO) {
            abstractC4932aM18733a.mo18734a(R.string.media_video);
        } else if (c4108aqM8557a.m16299b() == EnumC2214ab.IMAGE) {
            abstractC4932aM18733a.mo18734a(R.string.media_photo);
        } else if (c4108aqM8557a.m16299b() == EnumC2214ab.CALENDAR) {
            abstractC4932aM18733a.mo18734a(R.string.media_calendar);
        } else if (c4108aqM8557a.m16299b() == EnumC2214ab.AUDIO) {
            abstractC4932aM18733a.mo18734a(R.string.media_voice);
        } else if (c4108aqM8557a.m16299b() == EnumC2214ab.CONTACT) {
            abstractC4932aM18733a.mo18734a(R.string.media_contact);
        } else if (c4108aqM8557a.m16299b() == EnumC2214ab.GEO) {
            abstractC4932aM18733a.mo18734a(R.string.layout_calendar_location);
        } else if (c4108aqM8557a.m16299b() == EnumC2214ab.ANICON) {
            abstractC4932aM18733a.mo18734a(R.string.media_anicon);
        } else {
            abstractC4932aM18733a.mo18734a(R.string.pref_sms_settings_title);
        }
        abstractC4932aM18733a.mo18744a(charSequenceArr, new DialogInterfaceOnClickListenerC1609bq(this, c4108aqM8557a));
        abstractC4932aM18733a.mo18751b(true);
        abstractC4932aM18733a.mo18752b();
    }
}
