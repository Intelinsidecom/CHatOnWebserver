package com.samsung.samm.lib.p003a;

import android.util.Log;
import com.samsung.samm.lib.engine.p004a.C0908a;
import com.sds.coolots.common.util.FileUtil;
import java.io.File;
import java.io.RandomAccessFile;

/* renamed from: com.samsung.samm.lib.a.b */
/* loaded from: classes.dex */
public class C0888b {

    /* renamed from: a */
    private int f452a;

    /* renamed from: b */
    private int f453b;

    /* renamed from: c */
    private String f454c;

    /* renamed from: d */
    private String f455d;

    /* renamed from: e */
    private String f456e;

    /* renamed from: f */
    private String f457f;

    /* renamed from: g */
    private String f458g;

    /* renamed from: h */
    private String f459h;

    /* renamed from: i */
    private String f460i;

    /* renamed from: j */
    private String f461j;

    /* renamed from: k */
    private String f462k;

    /* renamed from: l */
    private String f463l;

    /* renamed from: m */
    private String f464m;

    /* renamed from: n */
    private String f465n;

    /* renamed from: o */
    private String f466o;

    public C0888b(String str, String str2) {
        this.f465n = str;
        this.f466o = str2;
        m252f();
    }

    /* renamed from: f */
    private void m252f() {
        this.f452a = 0;
        this.f453b = 0;
        this.f454c = String.valueOf(this.f465n) + "TempAMSBGVoiceMemo.3gp";
        this.f455d = String.valueOf(this.f466o) + "EmbedAMSBGVoiceMemo.3gp";
        this.f456e = String.valueOf(this.f466o) + "EmbedAMSBGMp3.mp3";
        this.f457f = String.valueOf(this.f466o) + "EmbedAMSBGMp3.wav";
        this.f458g = String.valueOf(this.f466o) + "EmbedAMSBGMp3.amr";
        this.f459h = String.valueOf(this.f466o) + "EmbedAMSBGMp3.wma";
        this.f460i = String.valueOf(this.f466o) + "EmbedAMSBGMp3.m4a";
        this.f461j = String.valueOf(this.f466o) + "EmbedAMSBGMp3.aac";
        this.f462k = String.valueOf(this.f466o) + "EmbedAMSBGMp3.ogg";
        this.f463l = String.valueOf(this.f466o) + "EmbedAMSBGMp3.mid";
        this.f464m = String.valueOf(this.f466o) + "EmbedAMSBGMp3.3ga";
    }

    /* renamed from: a */
    public void m254a(int i) {
        this.f452a = i;
    }

    /* renamed from: a */
    public int m253a() {
        return this.f452a;
    }

    /* renamed from: a */
    public boolean m257a(String str) {
        this.f452a = m250b(str);
        if (this.f452a != 0) {
            return C0903q.m590a(str, m258b(), true);
        }
        return false;
    }

    /* renamed from: b */
    public static int m250b(String str) {
        if (!m251c(str)) {
            Log.e("SAMMLibraryCore", "Invalid Audio File Path");
            return 0;
        }
        String strSubstring = str.substring(str.lastIndexOf(".") + 1);
        if (strSubstring.compareToIgnoreCase(FileUtil.RECORDING_EXT) == 0) {
            return 3;
        }
        if (strSubstring.compareToIgnoreCase("mp3") == 0) {
            return 2;
        }
        if (strSubstring.compareToIgnoreCase("wav") == 0) {
            return 4;
        }
        if (strSubstring.compareToIgnoreCase("amr") == 0) {
            return 5;
        }
        if (strSubstring.compareToIgnoreCase("wma") == 0) {
            return 6;
        }
        if (strSubstring.compareToIgnoreCase("m4a") == 0) {
            return 7;
        }
        if (strSubstring.compareToIgnoreCase("aac") == 0) {
            return 8;
        }
        if (strSubstring.compareToIgnoreCase("ogg") == 0) {
            return 9;
        }
        if (strSubstring.compareToIgnoreCase("mid") == 0) {
            return 10;
        }
        if (strSubstring.compareToIgnoreCase("3ga") == 0) {
            return 11;
        }
        Log.e("SAMMLibraryCore", "Unsupported audio file format");
        return 0;
    }

    /* renamed from: c */
    private static boolean m251c(String str) {
        if (str == null) {
            return false;
        }
        return C0908a.m640a(str);
    }

    /* renamed from: b */
    public String m258b() {
        if (this.f452a == 2) {
            return this.f456e;
        }
        if (this.f452a == 3) {
            return this.f455d;
        }
        if (this.f452a == 4) {
            return this.f457f;
        }
        if (this.f452a == 5) {
            return this.f458g;
        }
        if (this.f452a == 6) {
            return this.f459h;
        }
        if (this.f452a == 7) {
            return this.f460i;
        }
        if (this.f452a == 8) {
            return this.f461j;
        }
        if (this.f452a == 9) {
            return this.f462k;
        }
        if (this.f452a == 10) {
            return this.f463l;
        }
        if (this.f452a == 11) {
            return this.f464m;
        }
        return null;
    }

    /* renamed from: b */
    public void m259b(int i) {
        this.f452a = 1;
        this.f453b = i;
    }

    /* renamed from: c */
    public int m260c() {
        return this.f453b;
    }

    /* renamed from: d */
    public String m261d() {
        return this.f454c;
    }

    /* renamed from: e */
    public int m262e() {
        if (this.f452a < 2 || this.f452a > 11) {
            return 0;
        }
        File file = new File(m258b());
        if (file.exists() && file.canRead()) {
            return (int) file.length();
        }
        return 0;
    }

    /* renamed from: a */
    public boolean m256a(RandomAccessFile randomAccessFile, int i, int i2, int i3) {
        this.f452a = i;
        this.f453b = i2;
        return this.f452a < 2 || this.f452a > 11 || C0903q.m589a(randomAccessFile, m258b(), i3);
    }

    /* renamed from: a */
    public boolean m255a(RandomAccessFile randomAccessFile, int i, int i2) {
        return i < 2 || i > 11 || C0903q.m596b(randomAccessFile, m258b(), i2);
    }
}
