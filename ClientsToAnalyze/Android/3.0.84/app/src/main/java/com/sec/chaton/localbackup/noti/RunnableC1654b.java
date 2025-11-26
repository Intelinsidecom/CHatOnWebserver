package com.sec.chaton.localbackup.noti;

import android.os.Message;
import com.sec.chaton.localbackup.C1658q;
import com.sec.chaton.localbackup.EnumC1660s;
import com.sec.chaton.localbackup.EnumC1661t;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* compiled from: AutoBackupReceiver.java */
/* renamed from: com.sec.chaton.localbackup.noti.b */
/* loaded from: classes.dex */
class RunnableC1654b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AutoBackupReceiver f6125a;

    RunnableC1654b(AutoBackupReceiver autoBackupReceiver) {
        this.f6125a = autoBackupReceiver;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1658q c1658q = new C1658q();
        try {
            if (this.f6125a.f6121a != null && this.f6125a.f6121a.getAction().equals("auto_alaram_backup")) {
                c1658q.m6942a(EnumC1661t.FILE_ENCRYPT, c1658q.m6938a(EnumC1660s.DECRYPT, (String) null), c1658q.m6940a("local-backup.db.crypt"));
                C3250y.m11450b("autobackup complete : ", AutoBackupReceiver.class.getSimpleName());
                Message message = new Message();
                message.what = 1;
                if (this.f6125a.f6123c != null) {
                    this.f6125a.f6123c.sendMessage(message);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            C3159aa.m10962a().m10982a("auto_backup_start", Long.valueOf(System.currentTimeMillis()));
            C1653a.m6926a(this.f6125a.f6122b, false);
            C3250y.m11450b("autobackup error : " + e, AutoBackupReceiver.class.getSimpleName());
        }
    }
}
