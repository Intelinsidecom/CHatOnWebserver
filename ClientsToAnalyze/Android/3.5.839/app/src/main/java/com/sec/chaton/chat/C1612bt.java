package com.sec.chaton.chat;

import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.chat.notification.C1828q;
import com.sec.chaton.p057e.C2220ah;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4904y;
import com.sec.common.actionbar.ActionBarFragmentActivity;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bt */
/* loaded from: classes.dex */
class C1612bt implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6129a;

    C1612bt(ChatFragment chatFragment) {
        this.f6129a = chatFragment;
    }

    /* JADX WARN: Removed duplicated region for block: B:383:0x0f45 A[Catch: all -> 0x0f3a, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0f3a, blocks: (B:365:0x0ef0, B:367:0x0ef6, B:369:0x0f02, B:371:0x0f0a, B:373:0x0f1a, B:377:0x0f2f, B:383:0x0f45), top: B:415:0x0ef0 }] */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0f9f A[Catch: all -> 0x0fae, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x0fae, blocks: (B:387:0x0f5d, B:389:0x0f63, B:391:0x0f6f, B:393:0x0f77, B:395:0x0f86, B:399:0x0f9f), top: B:421:0x0f5d }] */
    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo7100a(int r15, java.lang.Object r16, android.database.Cursor r17) throws android.content.res.Resources.NotFoundException, java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instructions count: 4094
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.C1612bt.mo7100a(int, java.lang.Object, android.database.Cursor):void");
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
        if (i == 22) {
            if (this.f6129a.f5590bf != null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("QUERY_PARTICIPANTS_INVITED_CONTACT_BUDDY - buddies with phonenumber is added.[" + this.f6129a.f5590bf + "]", ChatFragment.f5461a);
                }
                this.f6129a.f5590bf.clear();
            } else if (C4904y.f17875e) {
                C4904y.m18634a("QUERY_PARTICIPANTS_INVITED_CONTACT_BUDDY - is finished but the mInvitedPhones is null.", ChatFragment.f5461a);
            }
            this.f6129a.f5546ao.startQuery(5, null, C2220ah.m10090b(this.f6129a.f5750v), null, null, null, null);
            return;
        }
        if (i == 23) {
            boolean z = false;
            if (TextUtils.isEmpty(this.f6129a.f5488E) || "null".equals(this.f6129a.f5488E)) {
                z = true;
            }
            String str = (String) obj;
            if (C4904y.f17872b) {
                C4904y.m18639b("QUERY_INSERT_ANICON_ITEM_FOR_SHOP_FORWARD - is finished. [" + str + "]", ChatFragment.f5461a);
            }
            this.f6129a.f5531aX.m9233a(this.f6129a.f5487D, this.f6129a.f5488E, (String[]) this.f6129a.f5588bd.toArray(new String[this.f6129a.f5588bd.size()]), z, this.f6129a.f5609by, -1L, str.trim(), (String) null, (String) null, (String) null);
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
        if (i == 24) {
            C4904y.m18639b("QUERY_UPDATE_UNREAD_COUNT_INBOX - completed. result:" + i2, ChatFragment.f5461a);
            if (this.f6129a.f5637ca == EnumC2301u.LIVE) {
                if (i2 >= 0) {
                    C1813b.m8906b().m8923a(this.f6129a.f5750v, C1813b.f6838g, false, false);
                    this.f6129a.f5606bv = i2;
                    if (this.f6129a.f5624cN != null) {
                        ((ActionBarFragmentActivity) this.f6129a.f5624cN).mo51u_();
                    }
                } else if (C1828q.m8956a().m8967a(this.f6129a.f5750v)) {
                    C1813b.m8906b().m8923a(this.f6129a.f5750v, C1813b.f6838g, false, false);
                }
            } else if (i2 > 0 || C1828q.m8956a().m8967a(this.f6129a.f5750v)) {
                C1813b.m8906b().m8922a(this.f6129a.f5750v, C1813b.f6838g);
            }
            C0991aa.m6037a().m18962d(new C1015an(new String[]{this.f6129a.f5750v}));
            return;
        }
        if (i == 4) {
            C0991aa.m6037a().m18962d(new C1015an(new String[]{this.f6129a.f5750v}));
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
        if (i == 3) {
            this.f6129a.m8016ae();
            this.f6129a.m8017af();
            return;
        }
        if (i == 1) {
            C1813b.m8906b().m8922a(this.f6129a.f5750v, C1813b.f6839h);
            return;
        }
        if (i == 875) {
            String str = (String) obj;
            if (C4904y.f17872b) {
                C4904y.m18639b("onDeleteComplete() QUERY_REMOVE_THREAD_ID thread id is " + str, ChatFragment.f5461a);
            }
            this.f6129a.f5731ej.m14361f();
            if (this.f6129a.f5528aU != null) {
                this.f6129a.f5528aU.m8574e((Cursor) null);
            }
        }
    }
}
