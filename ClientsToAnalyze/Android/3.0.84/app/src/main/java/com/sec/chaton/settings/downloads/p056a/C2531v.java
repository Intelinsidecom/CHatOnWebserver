package com.sec.chaton.settings.downloads.p056a;

import android.os.Handler;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1317bc;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p035io.entry.InstallSoundEntry;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.downloads.C2620df;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import com.sec.common.util.p070a.C3332a;
import java.io.File;
import java.io.IOException;

/* compiled from: SoundInstallWorker.java */
/* renamed from: com.sec.chaton.settings.downloads.a.v */
/* loaded from: classes.dex */
public class C2531v extends C2521l<Void, File[]> {

    /* renamed from: b */
    private static final String f9661b = C2531v.class.getSimpleName();

    /* renamed from: d */
    private static final Handler f9662d = new HandlerC2532w();

    /* renamed from: c */
    private C1317bc f9663c;

    public C2531v(C1317bc c1317bc, String str) {
        super(EnumC1399aq.Sound, str);
        this.f9663c = c1317bc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.settings.downloads.p056a.C2521l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public File[] mo9434a(Void... voidArr) throws InterruptedException, C2523n {
        File file;
        super.mo9434a((Object[]) voidArr);
        if (C3250y.f11734b) {
            C3250y.m11450b("download_sound, onDownloading(), request download url(itemid) : " + m9454c(), f9661b);
        }
        C0267d c0267dB = this.f9663c.m5672a(EnumC1172b.UI, m9454c(), "mp3").m5491b();
        if (C3250y.f11734b) {
            C3250y.m11450b("download_sound, onDownloading(), request downloading sound (result) : " + c0267dB.m1351b(), f9661b);
        }
        if (c0267dB.m1351b() == EnumC1587o.SUCCESS) {
            String str = ((InstallSoundEntry) c0267dB.m1354e()).fileurl;
            try {
                file = new File(C3332a.m11751a(CommonApplication.m11493l()), String.valueOf(str.hashCode()));
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    C3332a.m11750a().m11758b(f9662d, str, file, this);
                    if (C3250y.f11734b) {
                        C3250y.m11450b("download_sound, onDownloading(), download sound done ", f9661b);
                        C3250y.m11450b(" - url : " + str, f9661b);
                        C3250y.m11450b(" - temp : " + file.getPath(), f9661b);
                    }
                    return new File[]{file};
                } catch (IOException e) {
                    e = e;
                    if (C3250y.f11737e) {
                        C3250y.m11443a(e, f9661b);
                    }
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    throw new C2523n(e);
                } catch (InterruptedException e2) {
                    e = e2;
                    if (C3250y.f11736d) {
                        C3250y.m11455d(e.getMessage(), f9661b);
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
                C3250y.m11442a(C3364o.m11849a("Http result code is error. result code: ", c0267dB.m1351b()), f9661b);
            }
            throw new C2523n(C3364o.m11849a("Http result code is error. result code: ", c0267dB.m1351b()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.settings.downloads.p056a.C2521l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Boolean mo9433a(File[] fileArr, Void... voidArr) {
        super.mo9433a((C2531v) fileArr, (Object[]) voidArr);
        File file = fileArr[0];
        if (C3250y.f11734b) {
            C3250y.m11450b("download_sound, onInstalling(), temp file : " + file.toString(), f9661b);
        }
        try {
            try {
                C2620df.m9596a(CommonApplication.m11493l(), m9454c(), file);
                return true;
            } catch (IOException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f9661b);
                }
                throw new C2523n(e);
            }
        } finally {
            if (file != null && file.exists()) {
                boolean zDelete = file.delete();
                if (C3250y.f11734b) {
                    C3250y.m11450b("download_sound, delete temp file (result/filePath) : " + zDelete + "/" + file.getPath(), f9661b);
                }
            }
        }
    }
}
