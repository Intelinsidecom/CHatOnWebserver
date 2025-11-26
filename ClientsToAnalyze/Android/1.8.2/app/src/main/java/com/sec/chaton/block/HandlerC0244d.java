package com.sec.chaton.block;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import java.util.Iterator;

/* compiled from: BlockActivity.java */
/* renamed from: com.sec.chaton.block.d */
/* loaded from: classes.dex */
class HandlerC0244d extends Handler {

    /* renamed from: a */
    final /* synthetic */ BlockActivity f813a;

    HandlerC0244d(BlockActivity blockActivity) {
        this.f813a = blockActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        switch (message.what) {
            case 604:
                if (BlockActivity.f781b != null && BlockActivity.f781b.isShowing()) {
                    BlockActivity.f781b.dismiss();
                }
                if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                    Iterator it = this.f813a.f783d.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        for (int i = 0; i < this.f813a.f788l.size(); i++) {
                            if (str.equals(((C0253m) this.f813a.f788l.get(i)).f837b)) {
                                this.f813a.f788l.remove(i);
                            }
                        }
                    }
                    Toast.makeText(this.f813a, this.f813a.getResources().getString(R.string.setting_buddylist_unblocked, this.f813a.f783d.size() + ""), 0).show();
                    break;
                } else {
                    Toast.makeText(this.f813a, R.string.dev_network_error, 0).show();
                    break;
                }
                break;
        }
        this.f813a.f783d.clear();
        this.f813a.f790n.notifyDataSetChanged();
        this.f813a.finish();
    }
}
