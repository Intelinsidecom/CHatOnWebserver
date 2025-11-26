package com.sec.chaton.settings.downloads.p056a;

import android.os.Handler;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1332j;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p035io.entry.InstallPackageEntry;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.downloads.C2646u;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import com.sec.common.util.p070a.C3332a;
import java.io.File;
import java.io.IOException;

/* compiled from: AniconInstallWorker.java */
/* renamed from: com.sec.chaton.settings.downloads.a.e */
/* loaded from: classes.dex */
public class C2514e extends C2521l<Void, File[]> {

    /* renamed from: b */
    private static final String f9624b = C2514e.class.getSimpleName();

    /* renamed from: d */
    private static final Handler f9625d = new HandlerC2515f();

    /* renamed from: c */
    private C1332j f9626c;

    public C2514e(C1332j c1332j, String str) {
        super(EnumC1399aq.Anicon, str);
        this.f9626c = c1332j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.settings.downloads.p056a.C2521l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public File[] mo9434a(Void... voidArr) throws InterruptedException, C2523n {
        File file;
        File file2;
        boolean z;
        boolean z2;
        File file3 = null;
        super.mo9434a((Object[]) voidArr);
        C0267d c0267dB = this.f9626c.m5770b(EnumC1172b.UI, m9454c(), "png", 240).m5491b();
        if (c0267dB.m1351b() == EnumC1587o.SUCCESS) {
            InstallPackageEntry installPackageEntry = (InstallPackageEntry) c0267dB.m1354e();
            String str = installPackageEntry._package.panelurl;
            String str2 = installPackageEntry._package.packagezipurl;
            try {
                File fileM11751a = C3332a.m11751a(CommonApplication.m11493l());
                file2 = new File(fileM11751a, String.valueOf(str.hashCode()));
                try {
                    file = new File(fileM11751a, String.valueOf(str2.hashCode()));
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
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (C3250y.f11734b) {
                        C3250y.m11450b("download_anicon, onDownloading, 1.[delete exist?: " + z + "], tmpPackagePanelFile : " + file2.getPath(), f9624b);
                        C3250y.m11450b("download_anicon, onDownloading, 2.[delete exist?: " + z2 + "], tmpPackageZipFile : " + file.getPath(), f9624b);
                    }
                    C3332a.m11750a().m11758b(f9625d, str, file2, new C2516g(true, this));
                    C3332a.m11750a().m11758b(f9625d, str2, file, new C2516g(false, this));
                    return new File[]{file2, file};
                } catch (IOException e3) {
                    e = e3;
                    file3 = file2;
                    if (C3250y.f11737e) {
                        C3250y.m11443a(e, f9624b);
                    }
                    if (file3 != null && file3.exists()) {
                        file3.delete();
                    }
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    throw new C2523n(e);
                } catch (InterruptedException e4) {
                    e = e4;
                    if (C3250y.f11736d) {
                        C3250y.m11455d(e.getMessage(), f9624b);
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
        } else {
            if (C3250y.f11737e) {
                C3250y.m11442a(C3364o.m11849a("Http result code is error. result code: ", c0267dB.m1351b()), f9624b);
            }
            throw new C2523n(C3364o.m11849a("Http result code is error. result code: ", c0267dB.m1351b()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.settings.downloads.p056a.C2521l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Boolean mo9433a(File[] fileArr, Void... voidArr) {
        super.mo9433a((C2514e) fileArr, (Object[]) voidArr);
        File file = fileArr[0];
        File file2 = fileArr[1];
        try {
            try {
                C2646u.m9648a(CommonApplication.m11493l(), m9454c(), file2, file);
                return true;
            } catch (IOException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f9624b);
                }
                throw new C2523n(e);
            }
        } finally {
            if (C3250y.f11734b) {
                C3250y.m11450b("download_anicon, onDownloading, install procedure done, delete temp", f9624b);
            }
            if (file != null && file.exists()) {
                boolean zDelete = file.delete();
                if (C3250y.f11734b) {
                    C3250y.m11450b("download_anicon, (panel) delete temp file (result/filePath) : " + zDelete + "/" + file.getPath(), f9624b);
                }
            }
            if (file2 != null && file2.exists()) {
                boolean zDelete2 = file2.delete();
                if (C3250y.f11734b) {
                    C3250y.m11450b("download_anicon, (zipped) delete temp file (result/filePath) : " + zDelete2 + "/" + file2.getPath(), f9624b);
                }
            }
        }
    }
}
