package com.sec.chaton.settings.p096a.p097a;

import android.os.Handler;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.settings.p096a.C3474r;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.p133a.C5017a;
import java.io.File;
import java.io.IOException;

/* compiled from: SkinInstallWorker.java */
/* renamed from: com.sec.chaton.settings.a.a.n */
/* loaded from: classes.dex */
public class C3447n extends C3441h<Void, File[]> {

    /* renamed from: b */
    private static final String f12883b = C3447n.class.getSimpleName();

    /* renamed from: f */
    private static final Handler f12884f = new HandlerC3448o();

    /* renamed from: a */
    public DownloadRequestEntry f12885a;

    /* renamed from: c */
    private String f12886c;

    /* renamed from: d */
    private String f12887d;

    public C3447n(DownloadRequestEntry downloadRequestEntry) {
        super(EnumC2258bd.Skin, Long.toString(downloadRequestEntry.itemId));
        this.f12886c = downloadRequestEntry.bgBubble.setting.downloadUrl;
        this.f12887d = downloadRequestEntry.bgBubble.chatview.downloadUrl;
        this.f12885a = downloadRequestEntry;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.settings.p096a.p097a.C3441h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public File[] mo13705b(Void... voidArr) throws InterruptedException, C3443j {
        File file;
        File file2;
        boolean z;
        File file3 = null;
        boolean z2 = true;
        super.mo13705b((Object[]) voidArr);
        try {
            File fileM19065a = C5017a.m19065a(CommonApplication.m18732r());
            file2 = new File(fileM19065a, String.valueOf(this.f12886c.hashCode()));
            try {
                file = new File(fileM19065a, String.valueOf(this.f12887d.hashCode()));
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
                    C4904y.m18639b("download_skin, onDownloading, 1.[delete exist? : " + z + "], tmpSettingViewZipFile : " + file2.getPath(), f12883b);
                    C4904y.m18639b("download_skin, onDownloading, 2.[delete exist? : " + z2 + "], tmpChatViewZipFile : " + file.getPath(), f12883b);
                }
                C5017a.m19064a().m19072b(f12884f, this.f12886c, file2, new C3449p(true, this));
                C5017a.m19064a().m19072b(f12884f, this.f12887d, file, new C3449p(false, this));
                return new File[]{file2, file};
            } catch (IOException e3) {
                e = e3;
                file3 = file2;
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f12883b);
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
                    C4904y.m18645d(e.getMessage(), f12883b);
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
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.settings.p096a.p097a.C3441h
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Boolean mo13703a(File[] fileArr, Void... voidArr) {
        super.mo13703a((C3447n) fileArr, (Object[]) voidArr);
        File file = fileArr[0];
        File file2 = fileArr[1];
        try {
            try {
                C3474r.m13842k(CommonApplication.m18732r(), m13720d());
                C3474r.m13817a(CommonApplication.m18732r(), m13720d(), file2, file);
                return true;
            } catch (IOException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f12883b);
                }
                throw C3443j.m13722a(e);
            }
        } finally {
            if (C4904y.f17872b) {
                C4904y.m18639b("download_skin, onDownloading, install procedure done, delete temp", f12883b);
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
