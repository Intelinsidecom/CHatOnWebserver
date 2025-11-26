package com.sec.chaton.settings.p096a.p097a;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.settings.p096a.C3471o;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.EnumC5050p;
import com.sec.common.util.p133a.C5017a;
import java.io.File;
import java.io.IOException;

/* compiled from: FontInstallWorker.java */
/* renamed from: com.sec.chaton.settings.a.a.e */
/* loaded from: classes.dex */
public class C3438e extends C3441h<Void, File[]> {

    /* renamed from: b */
    private static final String f12861b = C3438e.class.getSimpleName();

    /* renamed from: d */
    private static final Handler f12862d = new HandlerC3439f();

    /* renamed from: a */
    public DownloadRequestEntry f12863a;

    /* renamed from: c */
    private String f12864c;

    public C3438e(DownloadRequestEntry downloadRequestEntry) {
        super(EnumC2258bd.Font, Long.toString(downloadRequestEntry.itemId));
        this.f12864c = downloadRequestEntry.font.downloadUrl;
        this.f12863a = downloadRequestEntry;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.settings.p096a.p097a.C3441h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public File[] mo13705b(Void... voidArr) throws InterruptedException, C3443j {
        File file;
        super.mo13705b((Object[]) voidArr);
        if (C4904y.f17872b) {
            C4904y.m18639b("download_font, onDownloading(), request download url(itemid) : " + m13720d(), f12861b);
        }
        try {
            file = new File(C5017a.m19066a(CommonApplication.m18732r(), EnumC5050p.INTERNAL_ONLY), String.valueOf(this.f12864c.hashCode()));
        } catch (IOException e) {
            e = e;
            file = null;
        } catch (InterruptedException e2) {
            e = e2;
            file = null;
        }
        try {
            if (file.exists()) {
                file.delete();
            }
            C5017a.m19064a().m19072b(f12862d, this.f12864c, file, this);
            if (C4904y.f17872b) {
                C4904y.m18639b("download_font, onDownloading(), download font done  - url : " + this.f12864c + " ///  - temp : " + file.getPath(), f12861b);
            }
            return new File[]{file};
        } catch (IOException e3) {
            e = e3;
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f12861b);
            }
            if (file != null && file.exists()) {
                file.delete();
            }
            throw C3443j.m13722a(e);
        } catch (InterruptedException e4) {
            e = e4;
            if (C4904y.f17874d) {
                C4904y.m18645d(e.getMessage(), f12861b);
            }
            if (file != null && file.exists()) {
                file.delete();
            }
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.settings.p096a.p097a.C3441h
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Boolean mo13703a(File[] fileArr, Void... voidArr) {
        super.mo13703a((C3438e) fileArr, (Object[]) voidArr);
        File file = fileArr[0];
        if (C4904y.f17872b) {
            C4904y.m18639b("download_font, onInstalling(), temp file : " + file.toString(), f12861b);
        }
        try {
            try {
                Thread.sleep(1000L);
                Context contextM18732r = CommonApplication.m18732r();
                C3471o.m13801a(contextM18732r, m13720d());
                C3471o.m13802a(contextM18732r, m13720d(), file);
                return true;
            } catch (IOException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f12861b);
                }
                throw C3443j.m13722a(e);
            }
        } finally {
            if (file != null && file.exists()) {
                boolean zDelete = file.delete();
                if (C4904y.f17872b) {
                    C4904y.m18639b("download_font, delete temp file (result/filePath) : " + zDelete + "/" + file.getPath(), f12861b);
                }
            }
        }
    }
}
