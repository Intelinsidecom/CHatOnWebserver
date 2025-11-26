package com.sec.chaton.localbackup.noti;

import android.app.IntentService;
import android.content.Intent;
import android.os.PowerManager;
import com.sec.chaton.localbackup.C2560s;
import com.sec.chaton.localbackup.EnumC2562u;
import com.sec.chaton.localbackup.EnumC2563v;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class AutoBackupService extends IntentService {

    /* renamed from: a */
    private PowerManager.WakeLock f9162a;

    public AutoBackupService() {
        super("AutoBackupService");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        PowerManager.WakeLock wakeLock;
        C2560s c2560s = new C2560s();
        try {
            try {
                this.f9162a = ((PowerManager) getSystemService("power")).newWakeLock(1, "ChatON");
                if (this.f9162a != null) {
                    this.f9162a.acquire();
                }
                if (C4904y.f17875e) {
                    C4904y.m18634a("wake lock is acquired " + System.currentTimeMillis(), getClass().getSimpleName());
                }
                c2560s.m10973a(EnumC2563v.FILE_ENCRYPT, c2560s.m10969a(EnumC2562u.DECRYPT, (String) null), c2560s.m10971a("local-backup.db.crypt"));
                if (C4904y.f17875e) {
                    C4904y.m18634a("autobackup complete : " + System.currentTimeMillis(), getClass().getSimpleName());
                }
                C4809aa.m18104a().m18124a("auto_backup_start", Long.valueOf(System.currentTimeMillis()));
                C2555a.m10957a(this, false);
                if (C4904y.f17875e) {
                    C4904y.m18634a("wake lock relesed " + System.currentTimeMillis(), getClass().getSimpleName());
                }
            } catch (Exception e) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("autobackup error : " + e + " time : " + System.currentTimeMillis(), getClass().getSimpleName());
                }
                C4809aa.m18104a().m18124a("auto_backup_start", Long.valueOf(System.currentTimeMillis()));
                C2555a.m10957a(this, false);
                if (C4904y.f17875e) {
                    C4904y.m18634a("wake lock relesed " + System.currentTimeMillis(), getClass().getSimpleName());
                }
                if (this.f9162a == null) {
                    return;
                } else {
                    wakeLock = this.f9162a;
                }
            }
            if (this.f9162a != null) {
                wakeLock = this.f9162a;
                wakeLock.release();
            }
        } catch (Throwable th) {
            C4809aa.m18104a().m18124a("auto_backup_start", Long.valueOf(System.currentTimeMillis()));
            C2555a.m10957a(this, false);
            if (C4904y.f17875e) {
                C4904y.m18634a("wake lock relesed " + System.currentTimeMillis(), getClass().getSimpleName());
            }
            if (this.f9162a != null) {
                this.f9162a.release();
            }
            throw th;
        }
    }
}
