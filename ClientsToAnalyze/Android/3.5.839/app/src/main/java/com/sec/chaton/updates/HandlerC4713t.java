package com.sec.chaton.updates;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p065io.entry.NewUpdateListEntry;
import com.sec.chaton.p065io.entry.inner.NewUpdateBuddyEntry;
import com.sec.chaton.p065io.entry.inner.NewUpdateEntry;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.util.Iterator;

/* compiled from: UpdatesSelectionFragment.java */
/* renamed from: com.sec.chaton.updates.t */
/* loaded from: classes.dex */
class HandlerC4713t extends Handler {

    /* renamed from: a */
    final /* synthetic */ UpdatesSelectionFragment f17073a;

    HandlerC4713t(UpdatesSelectionFragment updatesSelectionFragment) {
        this.f17073a = updatesSelectionFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        if (this.f17073a.getActivity() != null) {
            C0778b c0778b = (C0778b) message.obj;
            switch (message.what) {
                case 8002:
                    if (this.f17073a.f16999t != null) {
                        this.f17073a.f16999t.dismiss();
                    }
                    if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        NewUpdateListEntry newUpdateListEntry = (NewUpdateListEntry) c0778b.m3110e();
                        if (newUpdateListEntry != null) {
                            String str = newUpdateListEntry.hasmore;
                            this.f17073a.f16993n.clear();
                            Iterator<NewUpdateEntry> it = newUpdateListEntry.newupdate.iterator();
                            while (it.hasNext()) {
                                NewUpdateEntry next = it.next();
                                Iterator<NewUpdateBuddyEntry> it2 = next.sender.buddy.iterator();
                                while (it2.hasNext()) {
                                    NewUpdateBuddyEntry next2 = it2.next();
                                    String strM9833d = C2190d.m9833d(CommonApplication.m18732r().getContentResolver(), next2.f8575id);
                                    if (strM9833d != null) {
                                        next2.name = strM9833d;
                                    }
                                }
                                this.f17073a.f16993n.add(new C4709p(next.sender, next.service, next.action, next.status, next.url_scheme, next.created, next.unread, next.additional));
                                String str2 = next.created;
                            }
                        }
                        C5179v.m19810a(this.f17073a.getActivity(), R.string.trunk_toast_deleted, 0).show();
                        this.f17073a.getActivity().setResult(-1, new Intent(this.f17073a.getActivity(), (Class<?>) UpdatesFragment.class));
                        this.f17073a.getActivity().finish();
                        break;
                    } else {
                        C5179v.m19810a(this.f17073a.getActivity(), R.string.dev_network_error, 0).show();
                        break;
                    }
                    break;
            }
        }
    }
}
