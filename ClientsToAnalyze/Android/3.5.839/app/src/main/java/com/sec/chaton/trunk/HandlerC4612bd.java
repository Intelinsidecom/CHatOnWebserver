package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.trunk.database.p122a.C4664a;
import com.sec.chaton.trunk.entry.GetItemEntry;
import com.sec.chaton.util.C4904y;
import com.sec.common.p126d.p127a.EnumC4988d;
import org.apache.http.NameValuePair;

/* compiled from: TrunkItemPresenter.java */
/* renamed from: com.sec.chaton.trunk.bd */
/* loaded from: classes.dex */
class HandlerC4612bd extends Handler {

    /* renamed from: a */
    final /* synthetic */ C4611bc f16787a;

    HandlerC4612bd(C4611bc c4611bc) {
        this.f16787a = c4611bc;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f16787a.m17512e()) {
            switch (message.what) {
                case 2:
                    if (this.f16787a.f16779s != null) {
                        this.f16787a.f16779s.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 3:
                    if (this.f16787a.f16779s != null) {
                        this.f16787a.f16779s.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 4:
                    if (this.f16787a.f16779s != null) {
                        this.f16787a.f16779s.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 901:
                    C0778b c0778b = (C0778b) message.obj;
                    if (this.f16787a.f16779s != null) {
                        this.f16787a.f16779s.handleMessage(Message.obtain(message));
                    }
                    if (c0778b.m3107b() == EnumC2464o.ERROR && c0778b.m3111f() == 86411) {
                        try {
                            C4664a.m17659a(this.f16787a.f16765e, C4664a.m17661b(this.f16787a.f16768h));
                            break;
                        } catch (Exception e) {
                            if (C4904y.f17875e) {
                                C4904y.m18635a(e, C4611bc.f16761c);
                                return;
                            }
                            return;
                        }
                    } else {
                        GetItemEntry getItemEntry = (GetItemEntry) c0778b.m3110e();
                        if (TextUtils.isEmpty(this.f16787a.f16768h)) {
                            if (c0778b.m18951k().m18942i() != EnumC4988d.POST) {
                                for (NameValuePair nameValuePair : c0778b.m3109d().m10633d()) {
                                    if (nameValuePair.getName().equals("itemid")) {
                                        this.f16787a.f16768h = nameValuePair.getValue();
                                    }
                                    if (nameValuePair.getName().equals("sessionid")) {
                                        this.f16787a.f16767g = nameValuePair.getValue();
                                    }
                                }
                            } else if (getItemEntry != null) {
                                this.f16787a.f16768h = getItemEntry.item.itemid;
                            }
                        }
                        if (!TextUtils.isEmpty(this.f16787a.f16768h)) {
                            this.f16787a.m17594q();
                            break;
                        }
                    }
                    break;
                case 903:
                    if (this.f16787a.f16779s != null) {
                        this.f16787a.f16779s.handleMessage(Message.obtain(message));
                    }
                    this.f16787a.m17594q();
                    break;
                case 905:
                    if (this.f16787a.f16779s != null) {
                        this.f16787a.f16779s.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 906:
                    if (this.f16787a.f16779s != null) {
                        this.f16787a.f16779s.handleMessage(Message.obtain(message));
                    }
                    this.f16787a.m17596j();
                    break;
                case 907:
                    if (this.f16787a.f16779s != null) {
                        this.f16787a.f16779s.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
            }
        }
    }
}
