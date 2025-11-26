package com.sec.chaton.p055d.p056a;

import android.os.AsyncTask;
import com.sec.chaton.p067j.C2410a;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4868cf;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

/* compiled from: ProfileUploadTask.java */
/* renamed from: com.sec.chaton.d.a.dx */
/* loaded from: classes.dex */
public class AsyncTaskC2005dx extends AsyncTask<String, Integer, Boolean> {

    /* renamed from: e */
    private static String f7366e = "";

    /* renamed from: a */
    private String f7367a;

    /* renamed from: c */
    private String f7369c;

    /* renamed from: d */
    private String f7370d = "ProfileUploadTask";

    /* renamed from: b */
    String f7368b = C4873ck.m18501b();

    public AsyncTaskC2005dx(String str) {
        this.f7367a = str;
        String strValueOf = String.valueOf(Calendar.getInstance().getTimeInMillis());
        C4809aa.m18108a("profile_image_timestamp", strValueOf);
        f7366e = C4809aa.m18104a().m18121a("chaton_id", "");
        this.f7369c = strValueOf + "_profileImage.jpg";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(String... strArr) throws IOException {
        byte[] bArr;
        int i;
        File file = new File(this.f7367a);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            bArr = new byte[(int) file.length()];
            int i2 = 0;
            while (i2 < bArr.length && (i = fileInputStream.read(bArr, i2, bArr.length - i2)) >= 0) {
                i2 += i;
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            C4904y.m18635a(e, getClass().getSimpleName());
            bArr = null;
        } catch (IOException e2) {
            C4904y.m18635a(e2, getClass().getSimpleName());
            bArr = null;
        }
        C2456g c2456gM10641a = new C2456g(EnumC4868cf.FILE, "/file").m10637a(EnumC2457h.POST).m10640a("image/jpeg").m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("filename", this.f7369c);
        try {
            C4904y.m18639b("Reuquest Upload Profile", getClass().getSimpleName());
            if (bArr != null) {
                C4904y.m18646e("upload picture size:" + bArr.length, getClass().getSimpleName());
            }
            C2410a.m10441a(c2456gM10641a.m10635a(), bArr);
            C4904y.m18646e("*copied myprofile to msisdn format", "ProfileUploadTask");
            C4809aa.m18105a("profile_image_update_client", (Boolean) true);
            return true;
        } catch (IOException e3) {
            C4904y.m18635a(e3, getClass().getSimpleName());
            return false;
        }
    }
}
