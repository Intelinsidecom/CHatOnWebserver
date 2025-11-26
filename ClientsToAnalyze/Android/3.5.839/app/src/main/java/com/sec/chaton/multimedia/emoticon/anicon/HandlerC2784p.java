package com.sec.chaton.multimedia.emoticon.anicon;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: AniconSortListFragment.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.p */
/* loaded from: classes.dex */
class HandlerC2784p extends Handler {

    /* renamed from: a */
    final /* synthetic */ AniconSortListFragment f10078a;

    HandlerC2784p(AniconSortListFragment aniconSortListFragment) {
        this.f10078a = aniconSortListFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        if (this.f10078a.f10045a != null) {
            if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("GetCharacterTask is succeed", AniconSortListFragment.f10044d);
                }
                C4809aa.m18104a().m18125b("get_characterlist", (Boolean) true);
                this.f10078a.m11671c();
                return;
            }
            C4809aa.m18104a().m18125b("get_characterlist", (Boolean) false);
            this.f10078a.m11671c();
        }
    }
}
