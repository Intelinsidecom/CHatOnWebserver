package com.samsung.sdraw;

import com.sds.coolots.common.util.FileUtil;
import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.samsung.sdraw.bq */
/* loaded from: classes.dex */
class C1031bq extends Thread {

    /* renamed from: a */
    protected LinkedBlockingQueue<C1025bk> f1582a = new LinkedBlockingQueue<>();

    /* renamed from: b */
    protected Setting f1583b;

    public C1031bq(Setting setting) {
        this.f1583b = setting;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sdraw.C1031bq.run():void");
    }

    /* renamed from: a */
    public void m1423a() {
    }

    /* renamed from: a */
    public void m1424a(C1025bk c1025bk) throws InterruptedException {
        try {
            this.f1582a.put(c1025bk);
        } catch (InterruptedException e) {
        }
    }

    /* renamed from: b */
    public void m1425b() {
        if (this.f1583b.m1116g() != null) {
            File[] fileArrListFiles = new File(this.f1583b.m1116g()).listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    boolean zDelete = true;
                    if (!file.getName().equalsIgnoreCase(FileUtil.NOMEDIA_NAME)) {
                        zDelete = file.delete();
                    }
                    if (!zDelete) {
                        C0993af.m1275a("SPen", "cache file delete failed");
                    }
                }
            }
            interrupt();
        }
    }
}
