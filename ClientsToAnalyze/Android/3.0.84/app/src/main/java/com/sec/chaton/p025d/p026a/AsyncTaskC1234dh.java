package com.sec.chaton.p025d.p026a;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.p037j.C1540a;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3219cg;
import com.sec.common.CommonApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

/* compiled from: ProfileUploadTask.java */
/* renamed from: com.sec.chaton.d.a.dh */
/* loaded from: classes.dex */
public class AsyncTaskC1234dh extends AsyncTask<String, Integer, Boolean> {

    /* renamed from: e */
    private static String f4776e = "";

    /* renamed from: a */
    private String f4777a;

    /* renamed from: c */
    private String f4779c;

    /* renamed from: d */
    private String f4780d = "ProfileUploadTask";

    /* renamed from: b */
    String f4778b = C3223ck.m11328b();

    public AsyncTaskC1234dh(String str) {
        this.f4777a = str;
        String strValueOf = String.valueOf(Calendar.getInstance().getTimeInMillis());
        C3159aa.m10966a("profile_image_timestamp", strValueOf);
        f4776e = C3159aa.m10962a().m10979a("chaton_id", "");
        this.f4779c = strValueOf + "_profileImage.jpg";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(String... strArr) throws Throwable {
        byte[] bArr;
        int i;
        File file = new File(this.f4777a);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            bArr = new byte[(int) file.length()];
            int i2 = 0;
            while (i2 < bArr.length && (i = fileInputStream.read(bArr, i2, bArr.length - i2)) >= 0) {
                i2 += i;
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            C3250y.m11443a(e, getClass().getSimpleName());
            bArr = null;
        } catch (IOException e2) {
            C3250y.m11443a(e2, getClass().getSimpleName());
            bArr = null;
        }
        C1582j c1582jM6714a = new C1582j(EnumC3219cg.FILE, "/file").m6710a(EnumC1583k.POST).m6713a("image/jpeg").m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("filename", this.f4779c);
        try {
            C3250y.m11450b("Reuquest Upload Profile", getClass().getSimpleName());
            if (bArr != null) {
                C3250y.m11456e("upload picture size:" + bArr.length, getClass().getSimpleName());
            }
            C1540a.m6537a(c1582jM6714a.m6708a(), bArr);
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(C3162ad.m11012b(CommonApplication.m11493l(), Uri.parse(this.f4777a), 600), 600, 600, true);
            Uri uriM11004a = C3162ad.m11004a(C3162ad.m11006a(bitmapCreateScaledBitmap), "myprofile.png_");
            if (uriM11004a == null) {
                C3250y.m11442a("saveByteArrayOutputStreamToFileForProfile returns null", this.f4780d);
                return false;
            }
            Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapCreateScaledBitmap, 288, 288, true);
            C3205bt.m11182a(CommonApplication.m11493l()).m11227b(f4776e);
            C3205bt.m11182a(CommonApplication.m11493l()).m11224b(bitmapCreateScaledBitmap2, f4776e);
            C3250y.m11456e("*copied myprofile to msisdn format", "ProfileUploadTask");
            if (new File(uriM11004a.getPath()).length() > 0) {
                C3159aa.m10966a("profile_image_status", "updated");
                C3159aa.m10963a("profile_image_update_client", (Boolean) true);
            } else {
                C3250y.m11442a("File length is 0:" + uriM11004a.getPath(), "ProfileUploadTask");
            }
            return true;
        } catch (IOException e3) {
            C3250y.m11443a(e3, getClass().getSimpleName());
            return false;
        }
    }
}
