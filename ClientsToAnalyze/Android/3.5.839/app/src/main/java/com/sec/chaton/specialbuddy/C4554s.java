package com.sec.chaton.specialbuddy;

import android.database.ContentObserver;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.util.C4904y;

/* compiled from: SpecialBuddyChatFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.s */
/* loaded from: classes.dex */
class C4554s extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyChatFragment f16426a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4554s(SpecialBuddyChatFragment specialBuddyChatFragment, Handler handler) {
        super(handler);
        this.f16426a = specialBuddyChatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        String str;
        C4904y.m18639b("[MSGBOX] mChatlistObserver ", SpecialBuddyChatFragment.f16299l);
        if (this.f16426a.f16374s) {
            this.f16426a.f16336ab = true;
            return;
        }
        if (this.f16426a.f16337ac) {
            if (!TextUtils.isEmpty(this.f16426a.f16376u)) {
                str = this.f16426a.f16376u;
            } else {
                str = "";
            }
            this.f16426a.f16372q.startQuery(99, null, C2299s.m10190c(), null, null, new String[]{str}, null);
            return;
        }
        this.f16426a.f16372q.startQuery(99, null, C2299s.m10188b(), null, null, null, null);
    }
}
