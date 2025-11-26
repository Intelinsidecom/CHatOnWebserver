package com.sec.chaton.msgsend;

import android.app.Service;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.EnumC1450r;

/* loaded from: classes.dex */
public class ChatONMessageService extends Service {

    /* renamed from: a */
    private static final String f6413a = ChatONMessageService.class.getSimpleName();

    /* renamed from: b */
    private final String f6414b = "Messaging Service";

    /* renamed from: c */
    private volatile Looper f6415c;

    /* renamed from: d */
    private volatile HandlerC1746f f6416d;

    /* renamed from: a */
    void m7132a(Intent intent) {
        boolean z;
        Integer numValueOf;
        EnumC1741aa enumC1741aaM7156a;
        EnumC1755o enumC1755oM7222a = EnumC1755o.m7222a(intent.getIntExtra("cmd", -1));
        C1759s.m7260a(f6413a, "Handler Intent [START] : CMD(%s)", enumC1755oM7222a);
        C1749i c1749iM7196b = C1749i.m7195a().m7196b();
        switch (enumC1755oM7222a) {
            case CMD_ADD_MSG:
                C1752l.m7203b().m7208a(intent.getStringExtra("inbox_no"), EnumC1450r.m6339a(intent.getIntExtra("chat_type", -1)), intent.getStringArrayExtra("participants"), (String) null, (ChatONMsgEntity) intent.getParcelableExtra(SlookAirButtonFrequentContactAdapter.DATA));
                C1766z.m7268a(GlobalApplication.m11493l(), EnumC1764x.REASON_NEW_MSG_REQUESTED);
                z = true;
                break;
            case CMD_TRY_TO_SEND_MSG:
                C1752l.m7203b().m7210a(EnumC1764x.m7264a(intent.getIntExtra("send_retry_reason", -1)));
                z = true;
                break;
            case CMD_UPDATE_MSG:
                String stringExtra = intent.getStringExtra("inbox_no");
                long longExtra = intent.getLongExtra("msg_id", -1L);
                EnumC1741aa enumC1741aa = (!intent.hasExtra("send_status") || (enumC1741aaM7156a = EnumC1741aa.m7156a(intent.getIntExtra("send_status", EnumC1741aa.UNKNOWN_STATUS.m7157a()))) == EnumC1741aa.UNKNOWN_STATUS) ? null : enumC1741aaM7156a;
                String stringExtra2 = intent.hasExtra("formatted_msg") ? intent.getStringExtra("formatted_msg") : null;
                if (intent.hasExtra("is_file_uploaded")) {
                    numValueOf = Integer.valueOf(intent.getIntExtra("is_file_uploaded", -9999));
                    if (numValueOf.intValue() == -9999) {
                        numValueOf = null;
                    }
                } else {
                    numValueOf = null;
                }
                C1752l.m7203b().m7215a(stringExtra, longExtra, enumC1741aa, stringExtra2, numValueOf);
                z = true;
                break;
            case CMD_LOAD_MSG:
                C1752l.m7203b().m7221e();
                z = true;
                break;
            case CMD_REMOVE_MSG:
                C1752l.m7203b().m7214a(intent.getStringExtra("inbox_no"), intent.getLongExtra("msg_id", -1L));
                z = true;
                break;
            case CMD_REMOVE_INBOX:
                C1752l.m7203b().m7213a(intent.getStringExtra("inbox_no"));
                z = true;
                break;
            case CMD_REMOVE_ALL_MSG:
                C1752l.m7203b().m7220d();
                z = true;
                break;
            case CMD_PRINT_DEBUG:
                C1752l c1752lM7203b = C1752l.m7203b();
                if (C1757q.m7257g()) {
                    String strM7200a = C1752l.m7200a();
                    C1760t.m7263a("Debug Print", strM7200a, strM7200a);
                }
                c1752lM7203b.m7219c();
                z = true;
                break;
            default:
                z = false;
                break;
        }
        c1749iM7196b.m7197c();
        C1759s.m7260a(f6413a, "Handler Intent [END] : CMD(%s), (%s), (processed? %s)", enumC1755oM7222a, c1749iM7196b, Boolean.valueOf(z));
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        HandlerThread handlerThread = new HandlerThread("Messaging Service");
        handlerThread.start();
        this.f6415c = handlerThread.getLooper();
        this.f6416d = new HandlerC1746f(this, this.f6415c);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("cmd_priority", -1);
            C1759s.m7260a(f6413a, "requested : startId(%d), priority(%d), Command(%s)", Integer.valueOf(i2), Integer.valueOf(intExtra), EnumC1755o.m7222a(intent.getIntExtra("cmd", -1)));
            Message messageObtainMessage = this.f6416d.obtainMessage();
            messageObtainMessage.arg1 = i2;
            messageObtainMessage.obj = intent;
            if (intExtra == 1) {
                this.f6416d.sendMessageAtFrontOfQueue(messageObtainMessage);
            } else {
                this.f6416d.sendMessage(messageObtainMessage);
            }
        }
        return 1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f6415c.quit();
        C1759s.m7260a(f6413a, " ---------------- Service DESTROYED --------------------", new Object[0]);
        super.onDestroy();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
