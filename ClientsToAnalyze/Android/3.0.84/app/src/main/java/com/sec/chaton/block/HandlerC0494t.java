package com.sec.chaton.block;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: BlockListBuddyAdapter.java */
/* renamed from: com.sec.chaton.block.t */
/* loaded from: classes.dex */
class HandlerC0494t extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0493s f1630a;

    HandlerC0494t(C0493s c0493s) {
        this.f1630a = c0493s;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 604:
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    C3641ai.m13210a(this.f1630a.f1624e, R.string.dev_network_error, 0).show();
                    if (this.f1630a.f1627h != null && this.f1630a.f1627h.isShowing()) {
                        this.f1630a.f1627h.dismiss();
                    }
                    this.f1630a.f1629j.mo3160a();
                    this.f1630a.f1629j.mo3162c();
                    break;
                } else if (c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
                    C3641ai.m13211a(this.f1630a.f1624e, this.f1630a.f1624e.getResources().getString(R.string.block_list_removed_toast), 0).show();
                    this.f1630a.f1629j.mo3163d();
                    break;
                } else if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    String str2 = "";
                    for (int i = 0; i < this.f1630a.f1620a.size(); i++) {
                        try {
                            int i2 = 0;
                            while (i2 < this.f1630a.f1621b.size()) {
                                if (this.f1630a.f1620a.get(i).f1584a.equals(this.f1630a.f1621b.get(i2).f1584a)) {
                                    str = str2 + this.f1630a.f1621b.get(i2).f1585b;
                                    if (i2 != str.length()) {
                                        str = str + ", ";
                                    }
                                    this.f1630a.f1620a.remove(i);
                                } else {
                                    str = str2;
                                }
                                i2++;
                                str2 = str;
                            }
                        } catch (IndexOutOfBoundsException e) {
                            C3250y.m11442a("index out of bounds exception occured", getClass().getSimpleName());
                        }
                    }
                    C3641ai.m13211a(this.f1630a.f1624e, this.f1630a.f1624e.getResources().getString(R.string.block_list_removed_toast), 0).show();
                    this.f1630a.notifyDataSetChanged();
                    if (this.f1630a.f1627h != null && this.f1630a.f1627h.isShowing()) {
                        this.f1630a.f1627h.dismiss();
                    }
                    this.f1630a.f1622c = new boolean[this.f1630a.f1620a.size()];
                    this.f1630a.f1629j.mo3160a();
                    this.f1630a.f1629j.mo3162c();
                    if (this.f1630a.f1620a.size() == 0) {
                    }
                }
                break;
        }
    }
}
