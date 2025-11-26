package com.sec.chaton.p055d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p067j.p070c.C2438e;
import com.sec.chaton.p067j.p070c.C2442i;
import com.sec.chaton.p067j.p070c.RunnableC2440g;
import com.sec.chaton.util.C4904y;

/* compiled from: LiveChatMessageControl.java */
/* renamed from: com.sec.chaton.d.s */
/* loaded from: classes.dex */
final class HandlerC2138s extends Handler {
    HandlerC2138s(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C2442i c2442i;
        String str;
        if (message != null && message.what == 1 && (c2442i = (C2442i) message.obj) != null) {
            long jM10609b = c2442i.m10609b();
            C4904y.m18646e("mFileUploadHandler/ nResultCode: " + message.arg1 + " /nFaultCode: " + message.arg2 + " /result.getResult(): " + c2442i.m10608a(), getClass().getSimpleName());
            if (c2442i.m10608a()) {
                C4904y.m18646e("mFileUploadHandler / result.getResultUrl() : " + c2442i.m10610c(), getClass().getSimpleName());
                RunnableC2440g runnableC2440gM10573a = C2438e.m10572a().m10573a(jM10609b);
                if (runnableC2440gM10573a != null) {
                    EnumC2214ab enumC2214abM10598c = runnableC2440gM10573a.m10598c();
                    switch (C2139t.f7745a[enumC2214abM10598c.ordinal()]) {
                        case 1:
                            str = SlookAirButtonRecentMediaAdapter.IMAGE_TYPE;
                            break;
                        case 2:
                            str = "audio";
                            break;
                        case 3:
                            str = "calendar";
                            break;
                        case 4:
                            str = "contact";
                            break;
                        case 5:
                            str = "geo";
                            break;
                        case 6:
                            str = "video";
                            break;
                        case 7:
                            str = "doc";
                            break;
                        case 8:
                            str = "file";
                            break;
                        case 9:
                            str = "ams";
                            break;
                        default:
                            if (C4904y.f17873c) {
                                C4904y.m18641c("[FileHandler] not supported content type, " + runnableC2440gM10573a.m10598c(), "HttpMessageControl");
                                return;
                            }
                            return;
                    }
                    StringBuilder sb = new StringBuilder();
                    String strM10603h = runnableC2440gM10573a.m10603h();
                    String strM10599d = runnableC2440gM10573a.m10599d();
                    if (!TextUtils.isEmpty(strM10603h)) {
                        sb.append("mixed\n");
                    }
                    sb.append(str).append("\n");
                    if (TextUtils.isEmpty(strM10603h) && !TextUtils.isEmpty(strM10599d)) {
                        sb.append(strM10599d + "\n");
                    }
                    sb.append(runnableC2440gM10573a.m10606k() + "\n");
                    if (!TextUtils.isEmpty(strM10603h)) {
                        sb.append("\n" + strM10603h);
                    }
                    String strM10592a = runnableC2440gM10573a.m10592a();
                    EnumC2300t enumC2300tM10597b = runnableC2440gM10573a.m10597b();
                    String[] strArrM10600e = runnableC2440gM10573a.m10600e();
                    if (strArrM10600e != null && strArrM10600e.length > 0) {
                        C2136q.m9582a(strM10592a, enumC2300tM10597b).m9585a(jM10609b, enumC2214abM10598c, strArrM10600e[0], sb.toString(), strM10592a);
                    }
                    C2438e.m10572a().m10582c(jM10609b);
                }
            }
        }
    }
}
