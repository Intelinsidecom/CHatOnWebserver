package com.sec.chaton.qmlog;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4868cf;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class QMLogSendingService extends IntentService {

    /* renamed from: a */
    private static final String f11466a = QMLogSendingService.class.getSimpleName();

    public QMLogSendingService() {
        super(f11466a);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) throws ExecutionException, InterruptedException {
        try {
            C0778b c0778b = m12715a(C3122d.m12732a().m12750d()).get();
            if (C4904y.f17872b) {
                C4904y.m18639b(Integer.toString(c0778b.m18953m()), f11466a);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    private static Future<C0778b> m12715a(String str) {
        String strM18258z = C4822an.m18258z();
        if (TextUtils.isEmpty(strM18258z)) {
            strM18258z = Spam.ACTIVITY_CANCEL;
        }
        return C2472w.m10687a().m10693e().m10661a(new C3127i(new C2456g(EnumC4868cf.QMLOG, C3122d.m12736c()).m10637a(EnumC2457h.POST).m10640a("text/plain;charset=UTF-8").m10641a("mcc", strM18258z).m10641a("ver", C1427a.f5064b).m10635a(), str));
    }
}
