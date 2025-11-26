package com.sec.chaton.block;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: BlockListBuddyAdapter.java */
/* renamed from: com.sec.chaton.block.l */
/* loaded from: classes.dex */
class HandlerC1084l extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1083k f3473a;

    HandlerC1084l(C1083k c1083k) {
        this.f3473a = c1083k;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 604:
                if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                    C5179v.m19810a(this.f3473a.f3467e, R.string.dev_network_error, 0).show();
                    if (this.f3473a.f3470h != null && this.f3473a.f3470h.isShowing()) {
                        this.f3473a.f3470h.dismiss();
                    }
                    this.f3473a.f3472j.mo6231a();
                    this.f3473a.f3472j.mo6232b();
                    break;
                } else if (c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
                    C5179v.m19811a(this.f3473a.f3467e, this.f3473a.f3467e.getResources().getString(R.string.contact_unblocked_toast), 0).show();
                    this.f3473a.f3472j.mo6233c();
                    break;
                } else if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    String str2 = "";
                    int i = 0;
                    while (i < this.f3473a.f3464b.size()) {
                        try {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= this.f3473a.f3463a.size()) {
                                    str = str2;
                                } else if (!this.f3473a.f3464b.get(i).f3484a.equals(this.f3473a.f3463a.get(i2).f3484a)) {
                                    i2++;
                                } else {
                                    str = str2 + this.f3473a.f3464b.get(i).f3485b;
                                    if (i2 != str.length()) {
                                        str = str + ", ";
                                    }
                                    this.f3473a.f3463a.remove(i2);
                                }
                            }
                            i++;
                            str2 = str;
                        } catch (IndexOutOfBoundsException e) {
                            C4904y.m18634a("index out of bounds exception occured", getClass().getSimpleName());
                        }
                    }
                    C5179v.m19811a(this.f3473a.f3467e, this.f3473a.f3467e.getResources().getString(R.string.contact_unblocked_toast), 0).show();
                    this.f3473a.notifyDataSetChanged();
                    if (this.f3473a.f3470h != null && this.f3473a.f3470h.isShowing()) {
                        this.f3473a.f3470h.dismiss();
                    }
                    this.f3473a.f3465c = new boolean[this.f3473a.f3463a.size()];
                    this.f3473a.f3472j.mo6231a();
                    this.f3473a.f3472j.mo6232b();
                    if (this.f3473a.f3463a.size() == 0) {
                    }
                }
                break;
        }
    }
}
