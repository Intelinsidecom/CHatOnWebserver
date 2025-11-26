package com.sec.chaton.settings.downloads.p056a;

import android.os.Handler;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1333k;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p035io.entry.InstallFontEntry;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.downloads.C2570bj;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import com.sec.common.util.EnumC3363n;
import com.sec.common.util.p070a.C3332a;
import java.io.File;
import java.io.IOException;

/* compiled from: FontInstallWorker.java */
/* renamed from: com.sec.chaton.settings.downloads.a.i */
/* loaded from: classes.dex */
public class C2518i extends C2521l<Void, File[]> {

    /* renamed from: b */
    private static final String f9633b = C2518i.class.getSimpleName();

    /* renamed from: d */
    private static final Handler f9634d = new HandlerC2519j();

    /* renamed from: c */
    private C1333k f9635c;

    public C2518i(C1333k c1333k, String str) {
        super(EnumC1399aq.Font, str);
        this.f9635c = c1333k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.settings.downloads.p056a.C2521l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public File[] mo9434a(Void... voidArr) throws InterruptedException, C2523n {
        File file;
        super.mo9434a((Object[]) voidArr);
        if (C3250y.f11734b) {
            C3250y.m11450b("download_font, onDownloading(), request download url(itemid) : " + m9454c(), f9633b);
        }
        C0267d c0267dB = this.f9635c.m5773a(EnumC1172b.UI, m9454c()).m5491b();
        if (C3250y.f11734b) {
            C3250y.m11450b("download_font, onDownloading(), request downloading font (result) : " + c0267dB.m1351b(), f9633b);
        }
        if (c0267dB.m1351b() == EnumC1587o.SUCCESS) {
            String str = ((InstallFontEntry) c0267dB.m1354e()).fileurl;
            try {
                file = new File(C3332a.m11752a(CommonApplication.m11493l(), EnumC3363n.INTERNAL_ONLY), String.valueOf(str.hashCode()));
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    C3332a.m11750a().m11758b(f9634d, str, file, this);
                    if (C3250y.f11734b) {
                        C3250y.m11450b("download_font, onDownloading(), download font done  - url : " + str + " ///  - temp : " + file.getPath(), f9633b);
                    }
                    return new File[]{file};
                } catch (IOException e) {
                    e = e;
                    if (C3250y.f11737e) {
                        C3250y.m11443a(e, f9633b);
                    }
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    throw new C2523n(e);
                } catch (InterruptedException e2) {
                    e = e2;
                    if (C3250y.f11736d) {
                        C3250y.m11455d(e.getMessage(), f9633b);
                    }
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    throw e;
                }
            } catch (IOException e3) {
                e = e3;
                file = null;
            } catch (InterruptedException e4) {
                e = e4;
                file = null;
            }
        } else {
            if (C3250y.f11737e) {
                C3250y.m11442a(C3364o.m11849a("Http result code is error. result code: ", c0267dB.m1351b()), f9633b);
            }
            throw new C2523n(C3364o.m11849a("Http result code is error. result code: ", c0267dB.m1351b()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.settings.downloads.p056a.C2521l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Boolean mo9433a(File[] fileArr, Void... voidArr) {
        super.mo9433a((C2518i) fileArr, (Object[]) voidArr);
        File file = fileArr[0];
        if (C3250y.f11734b) {
            C3250y.m11450b("download_font, onInstalling(), temp file : " + file.toString(), f9633b);
        }
        try {
            try {
                Thread.sleep(1000L);
                C2570bj.m9512a(CommonApplication.m11493l(), m9454c(), file);
                return true;
            } catch (IOException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f9633b);
                }
                throw new C2523n(e);
            }
        } finally {
            if (file != null && file.exists()) {
                boolean zDelete = file.delete();
                if (C3250y.f11734b) {
                    C3250y.m11450b("download_font, delete temp file (result/filePath) : " + zDelete + "/" + file.getPath(), f9633b);
                }
            }
        }
    }
}
