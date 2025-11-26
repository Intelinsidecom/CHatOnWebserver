package com.sec.chaton.p013a.p014a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0478ac;
import com.sec.chaton.p018c.C0519z;
import com.sec.chaton.p018c.EnumC0511r;
import com.sec.chaton.util.C1294aq;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1348w;
import com.sec.chaton.util.EnumC1333h;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: ProfileUploadTask.java */
/* renamed from: com.sec.chaton.a.a.as */
/* loaded from: classes.dex */
public class AsyncTaskC0143as extends AsyncTask {

    /* renamed from: e */
    private static String f351e = "";

    /* renamed from: a */
    private String f352a;

    /* renamed from: d */
    private String f355d = "ProfileUploadTask";

    /* renamed from: b */
    String f353b = C1327bw.m4596b();

    /* renamed from: f */
    private File f356f = new File(this.f353b + "/profile/");

    /* renamed from: c */
    private Context f354c = GlobalApplication.m3100a();

    public AsyncTaskC0143as(String str) {
        this.f352a = str;
        f351e = C1323bs.m4575a().getString("msisdn", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(String... strArr) throws Throwable {
        byte[] bArr;
        int i;
        File file = new File(this.f352a);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            bArr = new byte[(int) file.length()];
            int i2 = 0;
            while (i2 < bArr.length && (i = fileInputStream.read(bArr, i2, bArr.length - i2)) >= 0) {
                i2 += i;
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            C1341p.m4653a(e, getClass().getSimpleName());
            bArr = null;
        } catch (IOException e2) {
            C1341p.m4653a(e2, getClass().getSimpleName());
            bArr = null;
        }
        C0519z c0519zM2584a = new C0519z(EnumC1333h.CONTACT, "/profileimage").m2581a(EnumC0511r.POST).m2583a("image/jpeg").m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a());
        try {
            C1341p.m4658b("Reuquest Upload Profile", getClass().getSimpleName());
            C1341p.m4662e("upload picture size:" + bArr.length, getClass().getSimpleName());
            C0478ac.m2467a(c0519zM2584a.m2579a(), bArr);
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(C1294aq.m4512b(this.f354c, Uri.parse(this.f352a), 600), 600, 600, true);
            Uri uriM4504a = C1294aq.m4504a(C1294aq.m4506a(bitmapCreateScaledBitmap), "myprofile.png_");
            if (uriM4504a == null) {
                C1341p.m4651a("saveByteArrayOutputStreamToFileForProfile returns null", this.f355d);
                return false;
            }
            Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapCreateScaledBitmap, 138, 138, true);
            C1348w.m4685a(GlobalApplication.m3100a()).m4701a(f351e);
            C1348w.m4685a(GlobalApplication.m3100a()).m4697a(bitmapCreateScaledBitmap2, f351e);
            C1341p.m4662e("*copied myprofile to msisdn format", "ProfileUploadTask");
            if (new File(uriM4504a.getPath()).length() > 0) {
                C1323bs.m4579a("profile_image_status", "updated");
            } else {
                C1341p.m4651a("File length is 0:" + uriM4504a.getPath(), "ProfileUploadTask");
            }
            return true;
        } catch (IOException e3) {
            C1341p.m4653a(e3, getClass().getSimpleName());
            return false;
        }
    }
}
