package com.sec.chaton.chat;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p065io.entry.InviteBuddyEntry;
import com.sec.chaton.p065io.entry.inner.InviteBuddy;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.util.ArrayList;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.j */
/* loaded from: classes.dex */
class HandlerC1788j extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6699a;

    HandlerC1788j(ChatFragment chatFragment) {
        this.f6699a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        C0778b c0778b = (C0778b) message.obj;
        if (message.what == 1201) {
            EnumC2464o enumC2464oM3107b = c0778b.m3107b();
            if (c0778b.m18954n()) {
                if (enumC2464oM3107b == EnumC2464o.SUCCESS) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    InviteBuddyEntry inviteBuddyEntry = (InviteBuddyEntry) c0778b.m3110e();
                    arrayList2.addAll(this.f6699a.f5590bf);
                    int size = inviteBuddyEntry.buddy.size();
                    for (int i = 0; i < size; i++) {
                        InviteBuddy inviteBuddy = inviteBuddyEntry.buddy.get(i);
                        arrayList.add(inviteBuddy.value);
                        if (arrayList2.contains(inviteBuddy.value)) {
                            arrayList2.remove(inviteBuddy.value);
                        }
                        switch (inviteBuddy.result.intValue()) {
                            case 0:
                                if (C1427a.f5063a.split("[.]").length == 3) {
                                    arrayList3.add(GlobalApplication.m10283b().getString(R.string.invite_message, "\nm.chaton.com/r/") + inviteBuddy.token);
                                    break;
                                } else {
                                    arrayList3.add(GlobalApplication.m10283b().getString(R.string.invite_message, "\nstg.m.chaton.com/r/") + inviteBuddy.token);
                                    break;
                                }
                            case 1:
                            case 2:
                            case 3:
                                arrayList3.add(GlobalApplication.m10283b().getString(R.string.invite_message, "\nwww.chaton.com/invite.html"));
                                break;
                        }
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("mSMSMessageControlHandler[METHOD_INVITE_BUDDY] successed", ChatFragment.f5461a);
                    }
                    this.f6699a.m8275t();
                    this.f6699a.m7946a((ArrayList<String>) arrayList, (ArrayList<String>) arrayList2, (ArrayList<String>) arrayList3);
                    return;
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("mSMSMessageControlHandler[METHOD_INVITE_BUDDY] failed", ChatFragment.f5461a);
                }
                this.f6699a.m8275t();
                C5179v.m19810a(CommonApplication.m18732r(), R.string.download_failed, 0).show();
                return;
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("mSMSMessageControlHandler[METHOD_INVITE_BUDDY] network err", ChatFragment.f5461a);
            }
            this.f6699a.m8275t();
            C5179v.m19810a(CommonApplication.m18732r(), R.string.toast_network_unable, 0).show();
        }
    }
}
