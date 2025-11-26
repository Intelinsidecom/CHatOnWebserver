package com.sec.chaton.settings.downloads.p056a;

import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1326d;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p035io.entry.AmsItemDownloadEntry;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.downloads.C2642q;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import com.sec.common.util.p070a.C3332a;
import java.io.File;
import java.io.IOException;

/* compiled from: AmsItemInstallWorker.java */
/* renamed from: com.sec.chaton.settings.downloads.a.a */
/* loaded from: classes.dex */
public class C2510a extends C2521l<Void, File> {

    /* renamed from: b */
    private static final String f9611b = C2510a.class.getSimpleName();

    /* renamed from: g */
    private static final Handler f9612g = new HandlerC2511b();

    /* renamed from: c */
    private C1326d f9613c;

    /* renamed from: d */
    private EnumC1327e f9614d;

    /* renamed from: e */
    private String f9615e;

    /* renamed from: f */
    private EnumC2512c f9616f;

    public C2510a(C1326d c1326d, EnumC1327e enumC1327e, String str) {
        super(enumC1327e.m5703b(), str);
        this.f9616f = EnumC2512c.INSTALL_BY_DOWNLOADING;
        this.f9614d = enumC1327e;
        this.f9613c = c1326d;
    }

    public C2510a(String str, EnumC1327e enumC1327e, String str2) {
        super(enumC1327e.m5703b(), str2);
        this.f9616f = EnumC2512c.INSTALL_BY_EXIST_FILE;
        this.f9614d = enumC1327e;
        this.f9615e = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.settings.downloads.p056a.C2521l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public File mo9434a(Void... voidArr) throws InterruptedException, C2523n {
        File file;
        super.mo9434a((Object[]) voidArr);
        if (this.f9616f == EnumC2512c.INSTALL_BY_EXIST_FILE && !TextUtils.isEmpty(this.f9615e)) {
            return new File(this.f9615e);
        }
        C0267d c0267dB = this.f9613c.m5697a(EnumC1172b.UI, this.f9614d, m9454c()).m5491b();
        if (c0267dB.m1351b() == EnumC1587o.SUCCESS) {
            AmsItemDownloadEntry amsItemDownloadEntry = (AmsItemDownloadEntry) c0267dB.m1354e();
            try {
                file = new File(C3332a.m11751a(CommonApplication.m11493l()), String.valueOf(amsItemDownloadEntry.imageurl.hashCode()));
            } catch (IOException e) {
                e = e;
                file = null;
            } catch (InterruptedException e2) {
                e = e2;
                file = null;
            }
            try {
                C3332a.m11750a().m11758b(f9612g, amsItemDownloadEntry.imageurl, file, this);
                if (C3250y.f11734b) {
                    C3250y.m11450b("download_ams, onDownloading, 1.imageurl : " + amsItemDownloadEntry.imageurl.toString(), f9611b);
                    C3250y.m11450b("download_ams, onDownloading, 2.tmpFile: " + file.getPath(), f9611b);
                }
                return file;
            } catch (IOException e3) {
                e = e3;
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f9611b);
                }
                if (file != null && file.exists()) {
                    file.delete();
                }
                throw new C2523n(e);
            } catch (InterruptedException e4) {
                e = e4;
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f9611b);
                }
                if (file != null && file.exists()) {
                    file.delete();
                }
                throw e;
            }
        }
        if (C3250y.f11737e) {
            C3250y.m11442a(C3364o.m11849a("Http result code is error. result code: ", c0267dB.m1351b()), f9611b);
        }
        throw new C2523n(C3364o.m11849a("Http result code is error. result code: ", c0267dB.m1351b()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.settings.downloads.p056a.C2521l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Boolean mo9433a(File file, Void... voidArr) {
        super.mo9433a((C2510a) file, (Object[]) voidArr);
        try {
            try {
                C2642q.m9634a(CommonApplication.m11493l(), this.f9614d, m9454c(), file);
                return true;
            } catch (IOException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f9611b);
                }
                throw new C2523n(e);
            }
        } finally {
            if (file != null && file.exists()) {
                boolean zDelete = file.delete();
                if (C3250y.f11734b) {
                    C3250y.m11450b("download_ams, delete temp file (result/filePath) : " + zDelete + "/" + file.getPath(), f9611b);
                }
            }
        }
    }
}
