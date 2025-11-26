package com.sec.chaton.msgbox;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.qmlog.C3119a;
import com.sec.chaton.qmlog.EnumC3126h;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4874cl;
import com.sec.chaton.util.C4904y;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.ar */
/* loaded from: classes.dex */
class C2626ar implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f9475a;

    C2626ar(MsgboxFragment msgboxFragment) {
        this.f9475a = msgboxFragment;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
        C4904y.m18644d("result:" + i2);
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        if (this.f9475a.f9338Q || this.f9475a.isDetached()) {
            C4904y.m18646e("[MSGBOX] onQueryComplete() mIsPause start close cursor", MsgboxFragment.f9318i);
            if (cursor != null) {
                this.f9475a.m11032a(cursor);
            }
            C4904y.m18646e("[MSGBOX] onQueryComplete() mIsPause end close cursor", MsgboxFragment.f9318i);
            if (i == 1) {
                this.f9475a.f9341T = true;
                return;
            }
            return;
        }
        if (this.f9475a.getActivity() == null) {
            this.f9475a.f9341T = true;
            return;
        }
        switch (i) {
            case 1:
                if (C2349a.m10301a("chaton_qmlog_sending")) {
                    C3119a.m12716a().m12724b(EnumC3126h.CHATS, System.currentTimeMillis());
                }
                this.f9475a.f9370y.setVisibility(8);
                C4904y.m18646e("[MSGBOX] onQueryComplete() QUERY_MSGBOX", MsgboxFragment.f9318i);
                this.f9475a.f9360o = 0;
                if (cursor != null) {
                    this.f9475a.f9360o = cursor.getCount();
                }
                if (this.f9475a.f9360o != 0) {
                    if (this.f9475a.f9368w != null) {
                        this.f9475a.f9368w.setVisibility(8);
                    }
                    this.f9475a.f9364s.setVisibility(0);
                    this.f9475a.m11057e();
                    if (this.f9475a.f9348aa != null && !this.f9475a.f9348aa.isEnabled()) {
                        this.f9475a.f9348aa.setEnabled(true);
                    }
                } else {
                    if (C2349a.m10301a("sms_feature") && !C4822an.m18218a()) {
                        this.f9475a.f9368w.setVisibility(0);
                    }
                    this.f9475a.f9364s.setVisibility(8);
                    this.f9475a.m11055d();
                    if (this.f9475a.f9348aa != null) {
                        this.f9475a.f9348aa.setEnabled(false);
                    }
                }
                this.f9475a.m11063h();
                Cursor cursorB = this.f9475a.f9324C.mo877b(cursor);
                if (cursorB != null) {
                    this.f9475a.m11032a(cursorB);
                }
                if (this.f9475a.f9367v != null) {
                    this.f9475a.f9367v.setVisibility(0);
                }
                if (this.f9475a.f9353ag && cursor != null && cursor.getCount() > 0) {
                    this.f9475a.m11061g();
                    break;
                }
                break;
            case 2:
                this.f9475a.f9346Y = true;
                this.f9475a.f9324C.m11159b(C4874cl.m18505a((String) obj));
                if (cursor == null || cursor.getCount() == 0) {
                    this.f9475a.f9345X.setVisibility(0);
                    this.f9475a.f9364s.setVisibility(8);
                    break;
                } else {
                    this.f9475a.f9345X.setVisibility(8);
                    this.f9475a.f9364s.setVisibility(0);
                    this.f9475a.f9324C.mo875a(cursor);
                    break;
                }
                break;
            default:
                if ((cursor == null || cursor.getCount() == 0) && cursor != null) {
                    this.f9475a.m11032a(cursor);
                    break;
                }
                break;
        }
        if (this.f9475a.f9342U) {
            this.f9475a.f9342U = false;
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
