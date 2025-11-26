package com.sec.chaton.p074l;

import android.content.Context;
import android.os.Environment;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5048n;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.Callable;

/* compiled from: RenameGroupProfileWorker.java */
/* renamed from: com.sec.chaton.l.aa */
/* loaded from: classes.dex */
public class CallableC2480aa implements InterfaceC2493k, Callable<Void> {

    /* renamed from: a */
    private static final String f8890a = CallableC2480aa.class.getSimpleName();

    /* renamed from: b */
    private Context f8891b;

    /* renamed from: c */
    private String f8892c;

    /* renamed from: d */
    private String f8893d;

    public CallableC2480aa(Context context, String str, String str2) {
        this.f8891b = context;
        this.f8892c = str;
        this.f8893d = str2;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        if (C4904y.f17872b) {
            C4904y.m18639b("ProfileImageManager.RenameGroupProfileWorker", f8890a);
        }
        try {
            this.f8892c = URLEncoder.encode(this.f8892c, "UTF-8");
            this.f8893d = URLEncoder.encode(this.f8893d, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f8890a);
            }
        }
        File file = new File(C2496n.m10755a(this.f8891b), this.f8892c + "_group_profile.png_");
        File file2 = new File(C2496n.m10755a(this.f8891b), this.f8893d + "_group_profile.png_");
        if (file.exists()) {
            file.renameTo(file2);
        }
        File file3 = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "//profile");
        if (file3.exists()) {
            File file4 = new File(file3, String.format("%s_big.jpeg_", this.f8892c));
            if (file4.exists()) {
                file4.renameTo(file2);
            }
        }
        File file5 = new File(CommonApplication.m18732r().getExternalFilesDir(null) + "/profile/", String.format("%s_big.jpeg_", this.f8892c));
        if (file5.exists()) {
            file5.renameTo(file2);
        }
        File file6 = new File(C4873ck.m18502c() + "/" + this.f8892c + "/");
        if (file6.exists()) {
            C5048n.m19193a(file6);
        }
        return null;
    }

    @Override // com.sec.chaton.p074l.InterfaceC2493k
    /* renamed from: b */
    public int mo10714b() {
        return EnumC2508z.DELETE.m10808a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(InterfaceC2493k interfaceC2493k) {
        long jMo10714b = mo10714b() - interfaceC2493k.mo10714b();
        if (jMo10714b < 0) {
            return -1;
        }
        if (jMo10714b == 0) {
            return 0;
        }
        return 1;
    }
}
