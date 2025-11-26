package com.sec.chaton.p015d.p016a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p022h.C0764a;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.EnumC0801k;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.C1791w;
import com.sec.chaton.util.EnumC1765bu;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: ProfileUploadTask.java */
/* renamed from: com.sec.chaton.d.a.bm */
/* loaded from: classes.dex */
public class AsyncTaskC0572bm extends AsyncTask {

    /* renamed from: e */
    private static String f2288e = "";

    /* renamed from: a */
    private String f2289a;

    /* renamed from: d */
    private String f2292d = "ProfileUploadTask";

    /* renamed from: b */
    String f2290b = C1767bw.m6003b();

    /* renamed from: f */
    private File f2293f = new File(this.f2290b + "/profile/");

    /* renamed from: c */
    private Context f2291c = GlobalApplication.m3260b();

    public AsyncTaskC0572bm(String str) {
        this.f2289a = str;
        f2288e = C1789u.m6075a().getString("msisdn", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(String... strArr) throws Throwable {
        byte[] bArr;
        int i;
        File file = new File(this.f2289a);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            bArr = new byte[(int) file.length()];
            int i2 = 0;
            while (i2 < bArr.length && (i = fileInputStream.read(bArr, i2, bArr.length - i2)) >= 0) {
                i2 += i;
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            C1786r.m6056a(e, getClass().getSimpleName());
            bArr = null;
        } catch (IOException e2) {
            C1786r.m6056a(e2, getClass().getSimpleName());
            bArr = null;
        }
        C0800j c0800jM3409a = new C0800j(EnumC1765bu.CONTACT, "/profileimage").m3406a(EnumC0801k.POST).m3408a("image/jpeg").m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a());
        try {
            C1786r.m6061b("Reuquest Upload Profile", getClass().getSimpleName());
            C1786r.m6066e("upload picture size:" + bArr.length, getClass().getSimpleName());
            C0764a.m3269a(c0800jM3409a.m3404a(), bArr);
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(C1791w.m6100b(this.f2291c, Uri.parse(this.f2289a), 600), 600, 600, true);
            Uri uriM6091a = C1791w.m6091a(C1791w.m6093a(bitmapCreateScaledBitmap), "myprofile.png_");
            if (uriM6091a == null) {
                C1786r.m6054a("saveByteArrayOutputStreamToFileForProfile returns null", this.f2292d);
                return false;
            }
            Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapCreateScaledBitmap, 208, 208, true);
            C1746bb.m5945a(GlobalApplication.m3260b()).m5961a(f2288e);
            C1746bb.m5945a(GlobalApplication.m3260b()).m5957a(bitmapCreateScaledBitmap2, f2288e);
            C1786r.m6066e("*copied myprofile to msisdn format", "ProfileUploadTask");
            if (new File(uriM6091a.getPath()).length() > 0) {
                C1789u.m6079a("profile_image_status", "updated");
            } else {
                C1786r.m6054a("File length is 0:" + uriM6091a.getPath(), "ProfileUploadTask");
            }
            return true;
        } catch (IOException e3) {
            C1786r.m6056a(e3, getClass().getSimpleName());
            return false;
        }
    }
}
