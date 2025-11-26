package com.sec.chaton.smsplugin.p110g;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p108e.C3848a;
import com.sec.chaton.smsplugin.p108e.C3849b;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.google.android.p134a.C5111c;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import org.p146b.p147a.p148a.InterfaceC5239d;

/* compiled from: MediaModel.java */
@TargetApi(14)
/* renamed from: com.sec.chaton.smsplugin.g.i */
/* loaded from: classes.dex */
public abstract class AbstractC3863i extends C3866l implements InterfaceC5239d {

    /* renamed from: a */
    protected Context f13879a;

    /* renamed from: b */
    protected int f13880b;

    /* renamed from: c */
    protected int f13881c;

    /* renamed from: d */
    protected String f13882d;

    /* renamed from: e */
    protected String f13883e;

    /* renamed from: f */
    protected String f13884f;

    /* renamed from: g */
    protected short f13885g;

    /* renamed from: h */
    protected int f13886h;

    /* renamed from: i */
    protected int f13887i;

    /* renamed from: j */
    protected C3849b f13888j;

    /* renamed from: k */
    protected boolean f13889k;

    /* renamed from: m */
    private Uri f13890m;

    /* renamed from: n */
    private byte[] f13891n;

    /* renamed from: o */
    private final ArrayList<EnumC3864j> f13892o;

    public AbstractC3863i(Context context, String str, String str2, String str3, Uri uri) throws IOException {
        this.f13879a = context;
        this.f13882d = str;
        this.f13884f = str2;
        this.f13883e = str3;
        this.f13890m = uri;
        m14798a();
        this.f13892o = new ArrayList<>();
    }

    public AbstractC3863i(Context context, String str, String str2, String str3, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data may not be null.");
        }
        this.f13879a = context;
        this.f13882d = str;
        this.f13884f = str2;
        this.f13883e = str3;
        this.f13891n = bArr;
        this.f13886h = bArr.length;
        this.f13892o = new ArrayList<>();
    }

    public AbstractC3863i(Context context, String str, String str2, String str3, C3849b c3849b) {
        this.f13879a = context;
        this.f13882d = str;
        this.f13884f = str2;
        this.f13883e = str3;
        this.f13888j = c3849b;
        this.f13890m = C3848a.m14721a(context, c3849b);
        this.f13886h = c3849b.m14731g().length;
        this.f13892o = new ArrayList<>();
    }

    /* renamed from: k */
    public int m14810k() {
        return this.f13880b;
    }

    /* renamed from: a */
    public void m14804a(int i) {
        this.f13880b = i;
        m14833a(true);
    }

    /* renamed from: l */
    public int m14811l() {
        return this.f13881c;
    }

    /* renamed from: b */
    public void m14809b(int i) {
        if (mo14753c() && i < 0) {
            try {
                m14825z();
            } catch (C5111c e) {
                C3890m.m14995a("Mms/media", e.getMessage(), e);
                return;
            }
        } else {
            this.f13881c = i;
        }
        m14833a(true);
    }

    /* renamed from: m */
    public String m14812m() {
        return this.f13884f;
    }

    /* renamed from: n */
    public Uri m14813n() {
        return this.f13890m;
    }

    /* renamed from: o */
    public Uri m14814o() throws IOException {
        if (this.f13890m != null && m14823x() && !this.f13888j.m14726b()) {
            throw new IOException("Insufficient DRM rights.");
        }
        return this.f13890m;
    }

    /* renamed from: p */
    public byte[] m14815p() throws IOException {
        if (this.f13891n == null) {
            return null;
        }
        if (m14823x() && !this.f13888j.m14726b()) {
            throw new IOException(this.f13879a.getString(R.string.insufficient_drm_rights));
        }
        byte[] bArr = new byte[this.f13891n.length];
        System.arraycopy(this.f13891n, 0, bArr, 0, this.f13891n.length);
        return bArr;
    }

    /* renamed from: a */
    void m14805a(Uri uri) {
        this.f13890m = uri;
    }

    /* renamed from: q */
    public String m14816q() {
        return this.f13883e;
    }

    /* renamed from: a */
    public void m14808a(short s) {
        this.f13885g = s;
        m14833a(true);
    }

    /* renamed from: g */
    public boolean mo14778g() {
        return this.f13889k;
    }

    /* renamed from: r */
    public int m14817r() {
        return this.f13886h;
    }

    /* renamed from: s */
    public boolean m14818s() {
        return this.f13882d.equals("text");
    }

    /* renamed from: t */
    public boolean m14819t() {
        return this.f13882d.equals("img");
    }

    /* renamed from: u */
    public boolean m14820u() {
        return this.f13882d.equals("video");
    }

    /* renamed from: v */
    public boolean m14821v() {
        return this.f13882d.equals("audio");
    }

    /* renamed from: w */
    public boolean m14822w() {
        return false;
    }

    /* renamed from: x */
    public boolean m14823x() {
        return this.f13888j != null;
    }

    /* renamed from: y */
    public boolean m14824y() {
        return this.f13888j.m14728d();
    }

    /* renamed from: z */
    protected void m14825z() throws IOException {
        if (this.f13890m == null) {
            throw new IllegalArgumentException("Uri may not be null.");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        int i = 0;
        try {
            try {
                mediaMetadataRetriever.setDataSource(this.f13879a, this.f13890m);
                String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                if (strExtractMetadata != null) {
                    i = Integer.parseInt(strExtractMetadata);
                }
                this.f13881c = i;
            } catch (Exception e) {
                C3890m.m14995a("Mms/media", "MediaMetadataRetriever failed to get duration for " + this.f13890m.getPath(), e);
                throw new C5111c(e);
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    /* renamed from: a */
    private void m14798a() throws IOException {
        String str;
        String str2;
        ContentResolver contentResolver = this.f13879a.getContentResolver();
        InputStream inputStreamOpenInputStream = null;
        if (this.f13890m == null) {
            C3890m.m14996b("Mms/media", "failed to initMediaSize. mUri may not be null.");
            return;
        }
        String scheme = this.f13890m.getScheme();
        try {
            try {
                if ("content".equals(scheme)) {
                    inputStreamOpenInputStream = contentResolver.openInputStream(this.f13890m);
                    if (inputStreamOpenInputStream instanceof FileInputStream) {
                        this.f13886h = (int) ((FileInputStream) inputStreamOpenInputStream).getChannel().size();
                    } else {
                        while (-1 != inputStreamOpenInputStream.read()) {
                            this.f13886h++;
                        }
                    }
                } else if ("file".equals(scheme)) {
                    FileChannel channel = new FileInputStream(this.f13890m.getPath()).getChannel();
                    this.f13886h = (int) channel.size();
                    channel.close();
                }
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException e) {
                        e = e;
                        str = "Mms/media";
                        str2 = "IOException caught while closing stream";
                        C3890m.m14995a(str, str2, e);
                    }
                }
            } catch (IOException e2) {
                C3890m.m14995a("Mms/media", "IOException caught while opening or reading stream", e2);
                if (e2 instanceof FileNotFoundException) {
                    throw new C5111c(e2.getMessage());
                }
                if (0 != 0) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException e3) {
                        e = e3;
                        str = "Mms/media";
                        str2 = "IOException caught while closing stream";
                        C3890m.m14995a(str, str2, e);
                    }
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e4) {
                    C3890m.m14995a("Mms/media", "IOException caught while closing stream", e4);
                }
            }
            throw th;
        }
    }

    /* renamed from: b */
    public static boolean m14799b(Uri uri) {
        return uri.getAuthority().startsWith("mms");
    }

    /* renamed from: A */
    public int m14800A() {
        return this.f13887i;
    }

    /* renamed from: a */
    public void m14806a(EnumC3864j enumC3864j) {
        this.f13892o.add(enumC3864j);
    }

    /* renamed from: B */
    public EnumC3864j m14801B() {
        return this.f13892o.size() == 0 ? EnumC3864j.NO_ACTIVE_ACTION : this.f13892o.remove(0);
    }

    /* renamed from: c */
    protected boolean mo14753c() {
        return false;
    }

    /* renamed from: C */
    public C3849b m14802C() {
        return this.f13888j;
    }

    /* renamed from: D */
    protected void m14803D() {
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3890m.m14996b("Mms/media", "pauseMusicPlayer");
        }
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        this.f13879a.sendBroadcast(intent);
    }

    /* renamed from: a */
    public void m14807a(String str) {
        this.f13883e = str;
    }

    /* renamed from: a */
    protected void mo14773a(int i, long j) {
    }
}
