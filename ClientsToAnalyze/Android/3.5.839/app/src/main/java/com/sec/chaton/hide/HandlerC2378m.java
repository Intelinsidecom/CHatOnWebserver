package com.sec.chaton.hide;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: HideListBuddyAdapter.java */
/* renamed from: com.sec.chaton.hide.m */
/* loaded from: classes.dex */
class HandlerC2378m extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2377l f8463a;

    HandlerC2378m(C2377l c2377l) {
        this.f8463a = c2377l;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 705:
                if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                    C5179v.m19810a(this.f8463a.f8457e, R.string.dev_network_error, 0).show();
                    if (this.f8463a.f8460h != null && this.f8463a.f8460h.isShowing()) {
                        this.f8463a.f8460h.dismiss();
                    }
                    this.f8463a.f8462j.mo10364a();
                    this.f8463a.f8462j.mo10365b();
                    break;
                } else if (c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
                    C5179v.m19811a(this.f8463a.f8457e, this.f8463a.f8457e.getResources().getString(R.string.hide_contacts_button_shown), 0).show();
                    this.f8463a.f8462j.mo10366c();
                    break;
                } else if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    if (this.f8463a.f8454b.size() == this.f8463a.f8453a.size()) {
                        C5179v.m19811a(this.f8463a.f8457e, this.f8463a.f8457e.getResources().getString(R.string.hide_contacts_button_shown), 0).show();
                        this.f8463a.f8462j.mo10366c();
                        break;
                    } else {
                        String str2 = "";
                        int i = 0;
                        while (i < this.f8463a.f8454b.size()) {
                            try {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= this.f8463a.f8453a.size()) {
                                        str = str2;
                                    } else if (!this.f8463a.f8454b.get(i).f3484a.equals(this.f8463a.f8453a.get(i2).f3484a)) {
                                        i2++;
                                    } else {
                                        str = str2 + this.f8463a.f8454b.get(i).f3485b;
                                        if (i2 != str.length()) {
                                            str = str + ", ";
                                        }
                                        this.f8463a.f8453a.remove(i2);
                                    }
                                }
                                i++;
                                str2 = str;
                            } catch (IndexOutOfBoundsException e) {
                                C4904y.m18634a("index out of bounds exception occured", getClass().getSimpleName());
                            }
                        }
                        C5179v.m19811a(this.f8463a.f8457e, this.f8463a.f8457e.getResources().getString(R.string.hide_contacts_button_shown), 0).show();
                        this.f8463a.notifyDataSetChanged();
                        if (this.f8463a.f8460h != null && this.f8463a.f8460h.isShowing()) {
                            this.f8463a.f8460h.dismiss();
                        }
                        this.f8463a.f8455c = new boolean[this.f8463a.f8453a.size()];
                        this.f8463a.f8462j.mo10364a();
                        this.f8463a.f8462j.mo10365b();
                        if (this.f8463a.f8453a.size() == 0) {
                        }
                    }
                }
                break;
        }
    }
}
