package com.sec.chaton.settings.p096a.p097a;

import android.os.Handler;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.settings.p096a.C3455ab;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.p133a.C5017a;
import java.io.File;
import java.io.IOException;

/* compiled from: SoundInstallWorker.java */
/* renamed from: com.sec.chaton.settings.a.a.r */
/* loaded from: classes.dex */
public class C3451r extends C3441h<Void, File[]> {

    /* renamed from: b */
    private static final String f12897b = C3451r.class.getSimpleName();

    /* renamed from: d */
    private static final Handler f12898d = new HandlerC3452s();

    /* renamed from: a */
    public DownloadRequestEntry f12899a;

    /* renamed from: c */
    private String f12900c;

    public C3451r(DownloadRequestEntry downloadRequestEntry) {
        super(EnumC2258bd.Sound, Long.toString(downloadRequestEntry.itemId));
        this.f12899a = downloadRequestEntry;
        this.f12900c = downloadRequestEntry.sound.downloadUrl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.settings.p096a.p097a.C3441h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public File[] mo13705b(Void... voidArr) throws InterruptedException, C3443j {
        File file;
        super.mo13705b((Object[]) voidArr);
        String str = this.f12900c;
        try {
            file = new File(C5017a.m19065a(CommonApplication.m18732r()), String.valueOf(str.hashCode()));
            try {
                if (file.exists()) {
                    file.delete();
                }
                C5017a.m19064a().m19072b(f12898d, str, file, this);
                if (C4904y.f17872b) {
                    C4904y.m18639b("download_sound, onDownloading(), download sound done ", f12897b);
                    C4904y.m18639b(" - url : " + str, f12897b);
                    C4904y.m18639b(" - temp : " + file.getPath(), f12897b);
                }
                return new File[]{file};
            } catch (IOException e) {
                e = e;
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f12897b);
                }
                if (file != null && file.exists()) {
                    file.delete();
                }
                throw C3443j.m13722a(e);
            } catch (InterruptedException e2) {
                e = e2;
                if (C4904y.f17874d) {
                    C4904y.m18645d(e.getMessage(), f12897b);
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
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.settings.p096a.p097a.C3441h
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Boolean mo13703a(File[] fileArr, Void... voidArr) {
        super.mo13703a((C3451r) fileArr, (Object[]) voidArr);
        File file = fileArr[0];
        if (C4904y.f17872b) {
            C4904y.m18639b("download_sound, onInstalling(), temp file : " + file.toString(), f12897b);
        }
        try {
            try {
                C3455ab.m13745a(CommonApplication.m18732r(), m13720d());
                C3455ab.m13746a(CommonApplication.m18732r(), m13720d(), file);
                return true;
            } catch (IOException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f12897b);
                }
                throw C3443j.m13722a(e);
            }
        } finally {
            if (file != null && file.exists()) {
                boolean zDelete = file.delete();
                if (C4904y.f17872b) {
                    C4904y.m18639b("download_sound, delete temp file (result/filePath) : " + zDelete + "/" + file.getPath(), f12897b);
                }
            }
        }
    }
}
