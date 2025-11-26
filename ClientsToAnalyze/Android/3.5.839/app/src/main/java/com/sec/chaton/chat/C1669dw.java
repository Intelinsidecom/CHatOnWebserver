package com.sec.chaton.chat;

import android.text.TextUtils;
import com.sec.chaton.C0993ac;
import com.sec.chaton.C1007af;
import com.sec.chaton.C1011aj;
import com.sec.chaton.C1015an;
import com.sec.chaton.C1065be;
import com.sec.chaton.C1066bf;
import com.sec.chaton.EnumC1008ag;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.smsplugin.p102b.C3789h;
import com.sec.chaton.util.C4904y;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p130e.InterfaceC4995d;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.dw */
/* loaded from: classes.dex */
class C1669dw {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6217a;

    private C1669dw(ChatFragment chatFragment) {
        this.f6217a = chatFragment;
    }

    /* synthetic */ C1669dw(ChatFragment chatFragment, C1646d c1646d) {
        this(chatFragment);
    }

    @InterfaceC4995d
    public void onUnknownBuddyReported(C1065be c1065be) {
        if (C4904y.f17873c) {
            C4904y.m18641c("ClickReport - " + c1065be.f3359a, ChatFragment.f5461a);
        }
        this.f6217a.m8251d(c1065be.f3359a);
    }

    @InterfaceC4995d
    public void onUnreadMessageChanged(C1066bf c1066bf) {
        if (this.f6217a.f5637ca == EnumC2301u.LIVE && !TextUtils.isEmpty(this.f6217a.f5750v) && this.f6217a.f5750v.equals(c1066bf.f3360a)) {
            if (C4904y.f17873c) {
                C4904y.m18641c("UnreadMessageCountChanged, inboxNo:" + c1066bf.f3360a + ", unreadCount:" + c1066bf.f3361b, ChatFragment.f5461a);
            }
            this.f6217a.f5606bv = c1066bf.f3361b;
            if (this.f6217a.f5606bv > 0) {
                ((ActionBarFragmentActivity) this.f6217a.getActivity()).mo51u_();
            }
        }
    }

    @InterfaceC4995d
    public void onDraftMessageChanged(C1011aj c1011aj) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onDraftMessageChanged.", ChatFragment.f5461a);
        }
        if (this.f6217a.f5731ej != null) {
            C3789h c3789hM14362g = this.f6217a.f5731ej.m14362g();
            if (c3789hM14362g.size() == 1 && c3789hM14362g.get(0).m14262d() != null && c3789hM14362g.get(0).m14262d().equals(c1011aj.m6084a())) {
                this.f6217a.f5564bF.setText(c1011aj.m6085b());
            }
        }
    }

    @InterfaceC4995d
    public void onBuddyStatusChanged(C0993ac c0993ac) {
        if (C4904y.f17873c) {
            C4904y.m18641c("onChatRoomResChanged - " + c0993ac.f3248b + "(" + c0993ac.f3247a + ")", ChatFragment.f5461a);
        }
        this.f6217a.m7977aL();
    }

    @InterfaceC4995d
    public void onChatRoomResChanged(C1007af c1007af) {
        if (C4904y.f17873c) {
            C4904y.m18641c("onChatRoomResChanged - " + c1007af.f3279a, ChatFragment.f5461a);
        }
        this.f6217a.m8044as();
        if (c1007af.f3279a == EnumC1008ag.BACKGROUND) {
            this.f6217a.m8034an();
        } else {
            this.f6217a.m8031am();
        }
    }

    @InterfaceC4995d
    public void onInboxTableChanged(C1015an c1015an) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onInboxTableChanged - ChatFragment", ChatFragment.f5461a);
        }
        if (!this.f6217a.f5654cr) {
            if (c1015an.m6091a(this.f6217a.f5750v)) {
                this.f6217a.f5546ao.startQuery(10, null, C2299s.f8209a, new String[]{"inbox_valid", "inbox_session_id", "inbox_last_timestamp", "inbox_title", "inbox_last_tid", "inbox_chat_type", "inbox_room_type", "inbox_last_chat_type", "inbox_participants", "inbox_title_fixed"}, "inbox_no=?", new String[]{this.f6217a.f5750v}, null);
            } else if (C4904y.f17872b) {
                C4904y.m18639b("A data of another room is changed", ChatFragment.f5461a);
            }
        }
    }
}
