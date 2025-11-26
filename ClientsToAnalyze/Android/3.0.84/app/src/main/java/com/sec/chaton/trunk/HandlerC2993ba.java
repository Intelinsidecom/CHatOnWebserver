package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.trunk.database.p062a.C3044a;
import com.sec.chaton.util.C3250y;

/* compiled from: TrunkItemPresenter.java */
/* renamed from: com.sec.chaton.trunk.ba */
/* loaded from: classes.dex */
class HandlerC2993ba extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2985az f10839a;

    HandlerC2993ba(C2985az c2985az) {
        this.f10839a = c2985az;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f10839a.m10415e()) {
            switch (message.what) {
                case 2:
                    if (this.f10839a.f10804t != null) {
                        this.f10839a.f10804t.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 3:
                    if (this.f10839a.f10804t != null) {
                        this.f10839a.f10804t.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 4:
                    if (this.f10839a.f10804t != null) {
                        this.f10839a.f10804t.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 901:
                    C0267d c0267d = (C0267d) message.obj;
                    if (this.f10839a.f10804t != null) {
                        this.f10839a.f10804t.handleMessage(Message.obtain(message));
                    }
                    if (c0267d.m1351b() != EnumC1587o.ERROR || c0267d.m1355f() != 86411) {
                        if (TextUtils.isEmpty(this.f10839a.f10792h)) {
                            this.f10839a.f10792h = this.f10839a.f10805u.m10431i();
                        }
                        if (!TextUtils.isEmpty(this.f10839a.f10792h)) {
                            this.f10839a.m10478p();
                            break;
                        }
                    } else {
                        try {
                            C3044a.m10564a(this.f10839a.f10789e, C3044a.m10566b(this.f10839a.f10792h));
                            break;
                        } catch (Exception e) {
                            if (C3250y.f11737e) {
                                C3250y.m11443a(e, C2985az.f10784c);
                                return;
                            }
                            return;
                        }
                    }
                    break;
                case 903:
                    if (this.f10839a.f10804t != null) {
                        this.f10839a.f10804t.handleMessage(Message.obtain(message));
                    }
                    this.f10839a.m10478p();
                    break;
                case 905:
                    if (this.f10839a.f10804t != null) {
                        this.f10839a.f10804t.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
                case 906:
                    if (this.f10839a.f10804t != null) {
                        this.f10839a.f10804t.handleMessage(Message.obtain(message));
                    }
                    this.f10839a.m10478p();
                    break;
                case 907:
                    if (this.f10839a.f10804t != null) {
                        this.f10839a.f10804t.handleMessage(Message.obtain(message));
                        break;
                    }
                    break;
            }
        }
    }
}
