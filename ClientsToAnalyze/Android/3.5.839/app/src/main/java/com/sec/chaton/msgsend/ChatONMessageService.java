package com.sec.chaton.msgsend;

import android.app.Service;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;

/* loaded from: classes.dex */
public class ChatONMessageService extends Service {

    /* renamed from: a */
    private static final String f9616a = ChatONMessageService.class.getSimpleName();

    /* renamed from: b */
    private final String f9617b = "Messaging Service";

    /* renamed from: c */
    private volatile Looper f9618c;

    /* renamed from: d */
    private volatile HandlerC2699g f9619d;

    /* renamed from: a */
    void m11249a(Intent intent) {
        boolean z;
        EnumC2692aj enumC2692ajM11301a;
        Integer numValueOf;
        EnumC2710r enumC2710rM11350a = EnumC2710r.m11350a(intent.getIntExtra("cmd", -1));
        C2684ab.m11290a(f9616a, "Handler Intent [START] : CMD(%s)", enumC2710rM11350a);
        C2704l c2704lM11323b = C2704l.m11322a().m11323b();
        switch (enumC2710rM11350a) {
            case CMD_ADD_MSG:
                C2707o.m11331b().m11335a(EnumC2301u.m10211a(intent.getIntExtra("roomtype", -1)), intent.getStringExtra("inbox_no"), EnumC2300t.m10207a(intent.getIntExtra("chat_type", -1)), intent.getStringArrayExtra("participants"), null, (ChatONMsgEntity) intent.getParcelableExtra(SlookAirButtonFrequentContactAdapter.DATA));
                C2691ai.m11298a(GlobalApplication.m18732r(), EnumC2689ag.REASON_NEW_MSG_REQUESTED);
                z = true;
                break;
            case CMD_TRY_TO_SEND_MSG:
                C2707o.m11331b().m11337a(EnumC2689ag.m11294a(intent.getIntExtra("send_retry_reason", -1)));
                z = true;
                break;
            case CMD_UPDATE_MSG:
                String stringExtra = intent.getStringExtra("inbox_no");
                long longExtra = intent.getLongExtra("msg_id", -1L);
                if (!intent.hasExtra("send_status") || (enumC2692ajM11301a = EnumC2692aj.m11301a(intent.getIntExtra("send_status", EnumC2692aj.UNKNOWN_STATUS.m11302a()))) == EnumC2692aj.UNKNOWN_STATUS) {
                    enumC2692ajM11301a = null;
                }
                String stringExtra2 = intent.hasExtra("formatted_msg") ? intent.getStringExtra("formatted_msg") : null;
                if (intent.hasExtra("is_file_uploaded")) {
                    numValueOf = Integer.valueOf(intent.getIntExtra("is_file_uploaded", -9999));
                    if (numValueOf.intValue() == -9999) {
                        numValueOf = null;
                    }
                } else {
                    numValueOf = null;
                }
                C2707o.m11331b().m11342a(stringExtra, longExtra, enumC2692ajM11301a, stringExtra2, numValueOf);
                z = true;
                break;
            case CMD_LOAD_MSG:
                C2707o.m11331b().m11349e();
                z = true;
                break;
            case CMD_REMOVE_MSG:
                C2707o.m11331b().m11341a(intent.getStringExtra("inbox_no"), intent.getLongExtra("msg_id", -1L));
                z = true;
                break;
            case CMD_REMOVE_INBOX:
                C2707o.m11331b().m11340a(intent.getStringExtra("inbox_no"));
                z = true;
                break;
            case CMD_REMOVE_ALL_MSG:
                C2707o.m11331b().m11348d();
                z = true;
                break;
            case CMD_PRINT_DEBUG:
                C2707o c2707oM11331b = C2707o.m11331b();
                if (C2717y.m11406i()) {
                    String strM11328a = C2707o.m11328a();
                    C2685ac.m11293a("Debug Print", strM11328a, strM11328a);
                }
                c2707oM11331b.m11347c();
                z = true;
                break;
            default:
                z = false;
                break;
        }
        c2704lM11323b.m11324c();
        C2684ab.m11290a(f9616a, "Handler Intent [END] : CMD(%s), (%s), (processed? %s)", enumC2710rM11350a, c2704lM11323b, Boolean.valueOf(z));
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        HandlerThread handlerThread = new HandlerThread("Messaging Service");
        handlerThread.start();
        this.f9618c = handlerThread.getLooper();
        this.f9619d = new HandlerC2699g(this, this.f9618c);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("cmd_priority", -1);
            C2684ab.m11290a(f9616a, "requested : startId(%d), priority(%d), Command(%s)", Integer.valueOf(i2), Integer.valueOf(intExtra), EnumC2710r.m11350a(intent.getIntExtra("cmd", -1)));
            Message messageObtainMessage = this.f9619d.obtainMessage();
            messageObtainMessage.arg1 = i2;
            messageObtainMessage.obj = intent;
            if (intExtra == 1) {
                this.f9619d.sendMessageAtFrontOfQueue(messageObtainMessage);
            } else {
                this.f9619d.sendMessage(messageObtainMessage);
            }
        }
        return 1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f9618c.quit();
        C2684ab.m11290a(f9616a, " ---------------- Service DESTROYED --------------------", new Object[0]);
        super.onDestroy();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
