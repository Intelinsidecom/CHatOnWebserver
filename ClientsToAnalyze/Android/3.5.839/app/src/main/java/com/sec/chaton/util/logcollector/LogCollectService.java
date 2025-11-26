package com.sec.chaton.util.logcollector;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.logcollector.scheduler.GatheringScheduler;
import com.sec.spp.push.Config;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class LogCollectService extends IntentService {

    /* renamed from: a */
    private static final String f17829a = LogCollectService.class.getSimpleName();

    /* renamed from: b */
    private static final String f17830b = f17829a + "Thread";

    /* renamed from: c */
    private static Handler f17831c = null;

    /* renamed from: a */
    public static final void m18551a(Handler handler) {
        f17831c = handler;
    }

    /* renamed from: a */
    public static final void m18548a(Context context) {
        m18549a(context, false, false);
    }

    /* renamed from: a */
    public static final void m18549a(Context context, boolean z, boolean z2) {
        m18550a(context, z, z2, false);
    }

    /* renamed from: a */
    public static final void m18550a(Context context, boolean z, boolean z2, boolean z3) {
        if (C4904y.f17873c) {
            C4904y.m18641c("Send gathering task to queue.", f17829a);
        }
        Intent intent = new Intent(context, (Class<?>) LogCollectService.class);
        intent.setAction("gathering");
        intent.putExtra("forceSave", z);
        intent.putExtra("withCallback", z2);
        intent.putExtra("stopGathering", z3);
        context.startService(intent);
    }

    public LogCollectService() {
        super(f17830b);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) throws IOException {
        if (intent.getAction().equals("gathering")) {
            m18552a(intent.getBooleanExtra("forceSave", false), intent.getBooleanExtra("withCallback", false), intent.getBooleanExtra("stopGathering", false));
        }
    }

    /* renamed from: a */
    private void m18552a(boolean z, boolean z2, boolean z3) throws IOException {
        String strM18555b = m18555b(this);
        if (TextUtils.isEmpty(strM18555b)) {
            strM18555b = "null";
        }
        String str = String.format("Version: %s / ChatON account: %s", "2.6.1", strM18555b);
        boolean z4 = false;
        if (C4904y.f17873c) {
            C4904y.m18641c(String.format("Start logcat gathering...(Extra: %s)", str), f17829a);
        }
        C4891b.m18561a(this, "ChatON:d ActivityManager:e *:s", str, true);
        if (C4904y.f17873c) {
            C4904y.m18641c(String.format("End logcat gathering... Rescheduling gathering after %d seconds.", 60000L), f17829a);
        }
        boolean z5 = false;
        if (z) {
            if (C4904y.f17873c) {
                C4904y.m18641c("Force save flag is true.", f17829a);
            }
            z5 = true;
        } else {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jM18556a = C4890a.m18556a(0L);
            if (C4904y.f17873c) {
                C4904y.m18641c(String.format("Current time(%s) - Last upload time(%s) = %s", new Date(jCurrentTimeMillis), new Date(jM18556a), Long.valueOf(jCurrentTimeMillis - jM18556a)), f17829a);
            }
            if (jCurrentTimeMillis - jM18556a >= 3600000) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("Current time - Last upload time is bigger than upload interval.", f17829a);
                }
                z5 = true;
            }
        }
        if (z5) {
            if (C4904y.f17873c) {
                C4904y.m18641c("Copy internal log file to sdcard.", f17829a);
            }
            if (m18553a()) {
                C4891b.m18561a(this, "ChatON:d ActivityManager:e *:s", str, false);
                C4890a.m18558b(System.currentTimeMillis());
                z4 = true;
            }
        }
        if (z3) {
            GatheringScheduler.m18564a(this);
        } else {
            GatheringScheduler.m18565a(this, 60000L);
        }
        if (z2 && f17831c != null) {
            Message messageObtain = Message.obtain(f17831c, 1);
            messageObtain.obj = Boolean.valueOf(z4);
            f17831c.sendMessage(messageObtain);
        }
    }

    /* renamed from: a */
    private boolean m18553a() {
        if (C4904y.f17873c) {
            C4904y.m18641c("Start save log to sdcard...", f17829a);
        }
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            if (!C4904y.f17875e) {
                return false;
            }
            C4904y.m18634a("Couldn't find sdcard.", f17829a);
            return false;
        }
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "chatonlog");
        if (file.mkdirs() && C4904y.f17873c) {
            C4904y.m18641c("Log directory is created.", f17829a);
        }
        if (!file.exists()) {
            if (!C4904y.f17875e) {
                return false;
            }
            C4904y.m18634a("Can't access log directory.", f17829a);
            return false;
        }
        File file2 = new File(file, m18554b());
        if (C4904y.f17873c) {
            C4904y.m18641c(String.format("Log file path: %s", file2.getAbsoluteFile()), f17829a);
        }
        return C4891b.m18562a(this, file2);
    }

    /* renamed from: b */
    private String m18555b(Context context) {
        Account[] accountsByType = AccountManager.get(context).getAccountsByType(Config.CHATON_PACKAGE_NAME);
        String str = 0 < accountsByType.length ? accountsByType[0].name : null;
        String strM18557a = C4890a.m18557a((String) null);
        if (str == null || str.length() == 0) {
            if (TextUtils.isEmpty(strM18557a)) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("Couldn't find ChatON account.", f17829a);
                }
                return null;
            }
            if (C4904y.f17873c) {
                C4904y.m18641c(String.format("Couldn't find ChatON account. Using ChatON account(%s) in preference.", strM18557a), f17829a);
            }
            return strM18557a;
        }
        if (!str.equals(strM18557a)) {
            C4890a.m18559b(str);
            return str;
        }
        return str;
    }

    /* renamed from: b */
    private String m18554b() {
        return String.format("chaton_%s_%s.txt", new SimpleDateFormat("yyyyMMdd").format(new Date()), DateFormat.format("kkmmss", System.currentTimeMillis()));
    }
}
