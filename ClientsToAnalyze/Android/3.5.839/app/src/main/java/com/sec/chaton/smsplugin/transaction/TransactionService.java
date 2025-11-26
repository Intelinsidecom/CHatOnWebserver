package com.sec.chaton.smsplugin.transaction;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3898u;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class TransactionService extends Service implements InterfaceC4084t {

    /* renamed from: b */
    private HandlerC4063an f14598b;

    /* renamed from: c */
    private Looper f14599c;

    /* renamed from: f */
    private ConnectivityManager f14602f;

    /* renamed from: g */
    private C4062am f14603g;

    /* renamed from: h */
    private PowerManager.WakeLock f14604h;

    /* renamed from: d */
    private final ArrayList<AbstractC4059aj> f14600d = new ArrayList<>();

    /* renamed from: e */
    private final ArrayList<AbstractC4059aj> f14601e = new ArrayList<>();

    /* renamed from: a */
    public Handler f14597a = new HandlerC4061al(this);

    @Override // android.app.Service
    public void onCreate() {
        if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
            C3890m.m14994a("TransactionService", "Creating TransactionService");
        }
        HandlerThread handlerThread = new HandlerThread("TransactionService");
        handlerThread.start();
        this.f14599c = handlerThread.getLooper();
        this.f14598b = new HandlerC4063an(this, this.f14599c);
        this.f14603g = new C4062am(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.f14603g, intentFilter);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0177 A[Catch: all -> 0x0140, TryCatch #0 {all -> 0x0140, blocks: (B:19:0x00b1, B:21:0x00c0, B:23:0x00dc, B:25:0x00e7, B:26:0x00f0, B:30:0x0101, B:32:0x0111, B:34:0x011c, B:35:0x0125, B:36:0x012c, B:38:0x0132, B:40:0x013c, B:45:0x0145, B:46:0x015f, B:47:0x0162, B:49:0x0177, B:50:0x017d, B:51:0x0182), top: B:62:0x00b1 }] */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int onStartCommand(android.content.Intent r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.transaction.TransactionService.onStartCommand(android.content.Intent, int, int):int");
    }

    /* renamed from: a */
    private void m15581a(int i) {
        synchronized (this.f14600d) {
            if (this.f14600d.isEmpty() && this.f14601e.isEmpty()) {
                if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                    C3890m.m14994a("TransactionService", "stopSelfIfIdle: STOP!");
                }
                if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                    C3890m.m14994a("TransactionService", "stopSelfIfIdle: unRegisterForConnectionStateChanges");
                }
                MmsSystemEventReceiver.m15533b(getApplicationContext());
                stopSelf(i);
            }
        }
    }

    /* renamed from: b */
    private static boolean m15585b(int i) {
        return i < 10 && i > 0;
    }

    /* renamed from: c */
    private boolean m15588c() {
        NetworkInfo networkInfo = this.f14602f.getNetworkInfo(2);
        if (C3847e.m14657aH() && C3847e.m14620D()) {
            NetworkInfo networkInfo2 = this.f14602f.getNetworkInfo(1);
            if (networkInfo2 != null && networkInfo2.isAvailable()) {
                C3890m.m14994a("TransactionService", "[TransactionService] wifi network available!");
            }
            if (networkInfo == null || !networkInfo.isAvailable()) {
                return networkInfo2 != null && networkInfo2.isAvailable();
            }
            return true;
        }
        return networkInfo != null ? networkInfo.isAvailable() : false;
    }

    /* renamed from: c */
    private int m15586c(int i) {
        switch (i) {
            case 128:
                return 2;
            case 130:
                return 1;
            case 135:
                return 3;
            default:
                C3890m.m14997c("TransactionService", "Unrecognized MESSAGE_TYPE: " + i);
                return -1;
        }
    }

    /* renamed from: a */
    private void m15583a(int i, C4060ak c4060ak, boolean z) {
        if (z) {
            C3890m.m14997c("TransactionService", "launchTransaction: no network error!");
            m15582a(i, c4060ak.m15622a());
            return;
        }
        Message messageObtainMessage = this.f14598b.obtainMessage(1);
        messageObtainMessage.arg1 = i;
        messageObtainMessage.obj = c4060ak;
        if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
            C3890m.m14994a("TransactionService", "launchTransaction: sending message " + messageObtainMessage);
        }
        this.f14598b.sendMessage(messageObtainMessage);
    }

    /* renamed from: a */
    private void m15582a(int i, int i2) {
        int i3 = 2;
        if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
            C3890m.m14994a("TransactionService", "onNetworkUnavailable: sid=" + i + ", type=" + i2);
        }
        if (i2 != 1) {
            i3 = i2 == 2 ? 1 : -1;
        }
        if (i3 != -1) {
            this.f14597a.sendEmptyMessage(i3);
        }
        stopSelf(i);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
            C3890m.m14994a("TransactionService", "Destroying TransactionService");
        }
        if (!this.f14601e.isEmpty()) {
            C3890m.m14997c("TransactionService", "TransactionService exiting with transaction still pending");
        }
        m15592f();
        if (C3847e.m14657aH() && C3847e.m14621E()) {
            try {
                C4090z.m15708a(GlobalApplication.m18732r()).m15715a();
            } catch (NullPointerException e) {
                C3890m.m14997c("TransactionService", "RetryScheduler.getInstance() = null");
            }
        }
        unregisterReceiver(this.f14603g);
        this.f14598b.sendEmptyMessage(100);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.sec.chaton.smsplugin.transaction.InterfaceC4084t
    /* renamed from: a */
    public void mo15595a(AbstractC4083s abstractC4083s) {
        AbstractC4059aj abstractC4059aj = (AbstractC4059aj) abstractC4083s;
        int iM15620f = abstractC4059aj.m15620f();
        if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
            C3890m.m14994a("TransactionService", "update transaction " + iM15620f);
        }
        try {
            synchronized (this.f14600d) {
                this.f14600d.remove(abstractC4059aj);
                if (this.f14601e.size() > 0) {
                    if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                        C3890m.m14994a("TransactionService", "update: handle next pending transaction...");
                    }
                    this.f14598b.sendMessage(this.f14598b.obtainMessage(4, abstractC4059aj.m15621g()));
                } else {
                    if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                        C3890m.m14994a("TransactionService", "update: endMmsConnectivity");
                    }
                    m15596b();
                }
            }
            Intent intent = new Intent("android.intent.action.TRANSACTION_COMPLETED_ACTION");
            C4065ap c4065apM15619e = abstractC4059aj.m15619e();
            int iM15641a = c4065apM15619e.m15641a();
            intent.putExtra("state", iM15641a);
            switch (iM15641a) {
                case 1:
                    if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                        C3890m.m14994a("TransactionService", "Transaction complete: " + iM15620f);
                    }
                    intent.putExtra("uri", c4065apM15619e.m15644b());
                    switch (abstractC4059aj.mo15598b()) {
                        case 2:
                            C3898u.m15059a().m15062b();
                            break;
                    }
                case 2:
                    if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                        C3890m.m14994a("TransactionService", "Transaction failed: " + iM15620f);
                        break;
                    }
                    break;
                default:
                    if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                        C3890m.m14994a("TransactionService", "Transaction state unknown: " + iM15620f + " " + iM15641a);
                        break;
                    }
                    break;
            }
            if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                C3890m.m14994a("TransactionService", "update: broadcast transaction result " + iM15641a);
            }
            sendBroadcast(intent);
        } finally {
            abstractC4059aj.m15696b(this);
            MmsSystemEventReceiver.m15533b(getApplicationContext());
            stopSelf(iM15620f);
        }
    }

    /* renamed from: d */
    private synchronized void m15590d() {
        if (this.f14604h == null) {
            this.f14604h = ((PowerManager) getSystemService("power")).newWakeLock(1, "MMS Connectivity");
            this.f14604h.setReferenceCounted(false);
        }
    }

    /* renamed from: e */
    private void m15591e() {
        this.f14604h.acquire();
    }

    /* renamed from: f */
    private void m15592f() {
        if (this.f14604h != null && this.f14604h.isHeld()) {
            this.f14604h.release();
        }
    }

    /* renamed from: a */
    protected int m15594a() throws IOException {
        int iStartUsingNetworkFeature = 0;
        m15590d();
        if ((!C3847e.m14657aH() || !C3847e.m14621E() || ((this.f14602f.getNetworkInfo(2).isAvailable() && this.f14602f.getMobileDataEnabled()) || !this.f14602f.getNetworkInfo(1).isConnected())) && (!C3847e.m14657aH() || !C3847e.m14622F() || !C3847e.m14623G())) {
            iStartUsingNetworkFeature = this.f14602f.startUsingNetworkFeature(0, "enableMMS");
            if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                C3890m.m14994a("TransactionService", "beginMmsConnectivity: result=" + iStartUsingNetworkFeature);
            }
            switch (iStartUsingNetworkFeature) {
                case 0:
                case 1:
                    m15591e();
                    break;
                default:
                    throw new IOException("Cannot establish MMS connectivity");
            }
        }
        return iStartUsingNetworkFeature;
    }

    /* renamed from: b */
    protected void m15596b() {
        try {
            if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                C3890m.m14994a("TransactionService", "endMmsConnectivity");
            }
            this.f14598b.removeMessages(3);
            if (this.f14602f != null) {
                this.f14602f.stopUsingNetworkFeature(0, "enableMMS");
            }
        } finally {
            m15592f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m15593g() {
        this.f14598b.sendMessageDelayed(this.f14598b.obtainMessage(3), 30000L);
    }
}
