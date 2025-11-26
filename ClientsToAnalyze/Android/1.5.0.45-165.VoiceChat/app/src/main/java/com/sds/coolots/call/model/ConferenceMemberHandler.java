package com.sds.coolots.call.model;

import android.os.Handler;
import android.os.Message;
import com.sds.coolots.call.p013a.C1139e;
import com.sds.coolots.common.model.ErrorCode;
import java.util.List;

/* loaded from: classes.dex */
public class ConferenceMemberHandler {

    /* renamed from: a */
    private C1211m f2594a;

    /* renamed from: b */
    private ConferenceMemberListener f2595b;

    /* renamed from: c */
    private final Handler f2596c = new HandlerC1188C(this);

    public interface ConferenceMemberListener {
        void onConferenceMember(C1211m c1211m, List list, String str);
    }

    /* renamed from: a */
    private void m2395a(C1224z c1224z) {
        if (this.f2595b != null) {
            this.f2595b.onConferenceMember(this.f2594a, c1224z.m2747a().getSimpleUserInfoList(), c1224z.m2751b());
        }
    }

    /* renamed from: a */
    public void m2396a(Message message) {
        switch (message.arg1) {
            case -1:
            case ErrorCode.ERR_CENTER_DATA_NOT_FOUND /* 10016 */:
            case ErrorCode.ERR_CENTER_INVALID_CONFNO /* 10092 */:
            default:
                if (this.f2595b != null) {
                    this.f2595b.onConferenceMember(this.f2594a, null, null);
                    break;
                }
                break;
            case 0:
                m2395a((C1224z) message.obj);
                break;
        }
    }

    /* renamed from: a */
    public void m2397a(String str, C1211m c1211m, ConferenceMemberListener conferenceMemberListener) {
        this.f2594a = c1211m;
        this.f2595b = conferenceMemberListener;
        new C1139e(str, false, this.f2596c, false).start();
    }
}
