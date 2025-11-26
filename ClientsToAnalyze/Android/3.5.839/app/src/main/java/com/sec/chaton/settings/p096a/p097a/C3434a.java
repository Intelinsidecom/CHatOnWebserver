package com.sec.chaton.settings.p096a.p097a;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.qmlog.C3122d;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.p133a.C5017a;
import java.io.File;
import java.io.IOException;

/* compiled from: AniconInstallWorker.java */
/* renamed from: com.sec.chaton.settings.a.a.a */
/* loaded from: classes.dex */
public class C3434a extends C3441h<Void, File[]> {

    /* renamed from: b */
    private static final String f12847b = C3434a.class.getSimpleName();

    /* renamed from: f */
    private static final Handler f12848f = new HandlerC3435b();

    /* renamed from: a */
    public DownloadRequestEntry f12849a;

    /* renamed from: c */
    private String f12850c;

    /* renamed from: d */
    private String f12851d;

    public C3434a(DownloadRequestEntry downloadRequestEntry, EnumC2258bd enumC2258bd) {
        super(enumC2258bd, Long.toString(downloadRequestEntry.itemId));
        this.f12851d = downloadRequestEntry.aniconPackage.downloadUrl;
        this.f12850c = downloadRequestEntry.aniconPackage.panelUrl;
        this.f12849a = downloadRequestEntry;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.settings.p096a.p097a.C3441h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public File[] mo13705b(Void... voidArr) {
        File file;
        File file2;
        boolean z;
        File file3 = null;
        boolean z2 = true;
        super.mo13705b((Object[]) voidArr);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                File fileM19065a = C5017a.m19065a(CommonApplication.m18732r());
                file2 = new File(fileM19065a, String.valueOf(this.f12850c.hashCode()));
                try {
                    file = new File(fileM19065a, String.valueOf(this.f12851d.hashCode()));
                } catch (IOException e) {
                    e = e;
                    file = null;
                    file3 = file2;
                } catch (InterruptedException e2) {
                    e = e2;
                    file = null;
                }
                try {
                    if (file2.exists()) {
                        file2.delete();
                        z = true;
                    } else {
                        z = false;
                    }
                    if (file.exists()) {
                        file.delete();
                    } else {
                        z2 = false;
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("download_anicon, onDownloading, 1.[delete exist?: " + z + "], tmpPackagePanelFile : " + file2.getPath(), f12847b);
                        C4904y.m18639b("download_anicon, onDownloading, 2.[delete exist?: " + z2 + "], tmpPackageZipFile : " + file.getPath(), f12847b);
                    }
                    C5017a.m19064a().m19072b(f12848f, this.f12850c, file2, new C3436c(true, this));
                    C5017a.m19064a().m19072b(f12848f, this.f12851d, file, new C3436c(false, this));
                    long length = file2.length() + file.length();
                    File[] fileArr = {file2, file};
                    if (C2349a.m10301a("chaton_qmlog_sending")) {
                        C3122d.m12732a().m12746a(this.f12849a.itemId, length, jCurrentTimeMillis, System.currentTimeMillis());
                    }
                    return fileArr;
                } catch (IOException e3) {
                    e = e3;
                    file3 = file2;
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, f12847b);
                    }
                    if (file3 != null && file3.exists()) {
                        file3.delete();
                    }
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    throw C3443j.m13722a(e);
                } catch (InterruptedException e4) {
                    e = e4;
                    if (C4904y.f17874d) {
                        C4904y.m18645d(e.getMessage(), f12847b);
                    }
                    if (file2 != null && file2.exists()) {
                        file2.delete();
                    }
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    throw e;
                }
            } catch (IOException e5) {
                e = e5;
                file = null;
            } catch (InterruptedException e6) {
                e = e6;
                file = null;
                file2 = null;
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.settings.p096a.p097a.C3441h
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Boolean mo13703a(File[] fileArr, Void... voidArr) {
        super.mo13703a((C3434a) fileArr, (Object[]) voidArr);
        File file = fileArr[0];
        File file2 = fileArr[1];
        try {
            try {
                Context contextM18732r = CommonApplication.m18732r();
                C3460d.m13770a(contextM18732r, m13720d(), EnumC2258bd.Anicon);
                C3460d.m13766a(contextM18732r, m13720d(), file2, file);
                return true;
            } catch (IOException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f12847b);
                }
                throw C3443j.m13722a(e);
            }
        } finally {
            if (C4904y.f17872b) {
                C4904y.m18639b("download_anicon, onDownloading, install procedure done, delete temp", f12847b);
            }
            if (file != null && file.exists()) {
                boolean zDelete = file.delete();
                if (C4904y.f17872b) {
                    C4904y.m18639b("download_anicon, (panel) delete temp file (result/filePath) : " + zDelete + "/" + file.getPath(), f12847b);
                }
            }
            if (file2 != null && file2.exists()) {
                boolean zDelete2 = file2.delete();
                if (C4904y.f17872b) {
                    C4904y.m18639b("download_anicon, (zipped) delete temp file (result/filePath) : " + zDelete2 + "/" + file2.getPath(), f12847b);
                }
            }
        }
    }
}
