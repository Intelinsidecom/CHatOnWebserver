package com.sec.chaton.settings.downloads.p056a;

import android.os.Handler;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p020c.C0823h;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p035io.entry.DownloadSkinEntry;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.downloads.C2591cd;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import com.sec.common.util.p070a.C3332a;
import java.io.File;
import java.io.IOException;

/* compiled from: SkinInstallWorker.java */
/* renamed from: com.sec.chaton.settings.downloads.a.r */
/* loaded from: classes.dex */
public class C2527r extends C2521l<Void, File[]> {

    /* renamed from: b */
    private static final String f9651b = C2527r.class.getSimpleName();

    /* renamed from: e */
    private static final Handler f9652e = new HandlerC2528s();

    /* renamed from: c */
    private C0823h f9653c;

    /* renamed from: d */
    private String f9654d;

    public C2527r(C0823h c0823h, String str, String str2) {
        super(EnumC1399aq.Skin, str);
        this.f9653c = c0823h;
        this.f9654d = str2;
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
        C0267d c0267dB = this.f9653c.m4377a(EnumC1172b.UI, m9454c(), C2591cd.m9564a(), C2591cd.m9564a(), this.f9654d).m5491b();
        if (c0267dB.m1351b() == EnumC1587o.SUCCESS) {
            DownloadSkinEntry downloadSkinEntry = (DownloadSkinEntry) c0267dB.m1354e();
            String str = downloadSkinEntry.skinview.settingview.zipfileurl;
            String str2 = downloadSkinEntry.skinview.chatview.zipfileurl;
            try {
                File fileM11751a = C3332a.m11751a(CommonApplication.m11493l());
                file2 = new File(fileM11751a, String.valueOf(str.hashCode()));
                try {
                    file = new File(fileM11751a, String.valueOf(str2.hashCode()));
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
                            C3250y.m11450b("download_skin, onDownloading, 1.[delete exist? : " + z + "], tmpSettingViewZipFile : " + file2.getPath(), f9651b);
                            C3250y.m11450b("download_skin, onDownloading, 2.[delete exist? : " + z2 + "], tmpChatViewZipFile : " + file.getPath(), f9651b);
                        }
                        C3332a.m11750a().m11758b(f9652e, str, file2, new C2529t(true, this));
                        C3332a.m11750a().m11758b(f9652e, str2, file, new C2529t(false, this));
                        return new File[]{file2, file};
                    } catch (IOException e) {
                        e = e;
                        file3 = file2;
                        if (C3250y.f11737e) {
                            C3250y.m11443a(e, f9651b);
                        }
                        if (file3 != null && file3.exists()) {
                            file3.delete();
                        }
                        if (file != null && file.exists()) {
                            file.delete();
                        }
                        throw new C2523n(e);
                    } catch (InterruptedException e2) {
                        e = e2;
                        if (C3250y.f11736d) {
                            C3250y.m11455d(e.getMessage(), f9651b);
                        }
                        if (file2 != null && file2.exists()) {
                            file2.delete();
                        }
                        if (file != null && file.exists()) {
                            file.delete();
                        }
                        throw e;
                    }
                } catch (IOException e3) {
                    e = e3;
                    file = null;
                    file3 = file2;
                } catch (InterruptedException e4) {
                    e = e4;
                    file = null;
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
                C3250y.m11442a(C3364o.m11849a("Http result code is error. result code: ", c0267dB.m1351b()), f9651b);
            }
            throw new C2523n(C3364o.m11849a("Http result code is error. result code: ", c0267dB.m1351b()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.settings.downloads.p056a.C2521l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Boolean mo9433a(File[] fileArr, Void... voidArr) {
        super.mo9433a((C2527r) fileArr, (Object[]) voidArr);
        File file = fileArr[0];
        File file2 = fileArr[1];
        try {
            try {
                C2591cd.m9568a(CommonApplication.m11493l(), m9454c(), file2, file);
                return true;
            } catch (IOException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f9651b);
                }
                throw new C2523n(e);
            }
        } finally {
            if (C3250y.f11734b) {
                C3250y.m11450b("download_skin, onDownloading, install procedure done, delete temp", f9651b);
            }
            if (file != null && file.exists()) {
                file.delete();
            }
            if (file2 != null && file2.exists()) {
                file2.delete();
            }
        }
    }
}
