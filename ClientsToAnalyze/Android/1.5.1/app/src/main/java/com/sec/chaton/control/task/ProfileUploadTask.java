package com.sec.chaton.control.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.ChatONFileHttpClient;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.ChatOnGraphics;
import com.sec.chaton.util.DeviceInfoUtil;
import com.sec.chaton.util.ProfileImageLoader;
import com.sec.chaton.util.ServerAddressMgr;
import com.sec.chaton.util.StorageStateInfoUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public class ProfileUploadTask extends AsyncTask {

    /* renamed from: d */
    private static String f1639d = "";

    /* renamed from: a */
    private String f1640a;

    /* renamed from: b */
    String f1641b;

    /* renamed from: c */
    private Context f1642c;

    /* renamed from: e */
    private File f1643e;

    public ProfileUploadTask(String str) {
        this.f1641b = StorageStateInfoUtil.m3677a() ? GlobalApplication.m2386d().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m2387e().getFilesDir().getAbsolutePath();
        this.f1643e = new File(this.f1641b + "/profile/");
        this.f1640a = str;
        this.f1642c = GlobalApplication.m2387e();
        f1639d = ChatONPref.m3519a().getString("msisdn", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(String... strArr) throws Throwable {
        byte[] bArr;
        int i;
        File file = new File(this.f1640a);
        if (file == null || !file.exists() || file.length() <= 0) {
            ChatONLogWriter.m3499a("File not exists or lenght less than 0", "ProfileUploadTask");
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            bArr = new byte[(int) file.length()];
            int i2 = 0;
            while (i2 < bArr.length && (i = fileInputStream.read(bArr, i2, bArr.length - i2)) >= 0) {
                i2 += i;
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            ChatONLogWriter.m3501a(e, getClass().getSimpleName());
            bArr = null;
        } catch (IOException e2) {
            ChatONLogWriter.m3501a(e2, getClass().getSimpleName());
            bArr = null;
        }
        HttpEnvelope.Builder builderM2741a = new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/profileimage").m2738a(HttpEnvelope.RequestMethod.POST).m2740a("image/jpeg").m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a());
        try {
            ChatONLogWriter.m3506b("Reuquest Upload Profile", getClass().getSimpleName());
            ChatONLogWriter.m3511e("upload picture size:" + bArr.length, getClass().getSimpleName());
            ChatONFileHttpClient.m2700a(builderM2741a.m2742a(), bArr);
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(ChatOnGraphics.m3541b(this.f1642c, Uri.parse(this.f1640a), 600), 600, 600, true);
            Uri uriM3533a = ChatOnGraphics.m3533a(ChatOnGraphics.m3535a(bitmapCreateScaledBitmap), "myprofile.png_");
            ProfileImageLoader.m3610a(GlobalApplication.m2387e()).m3621a(bitmapCreateScaledBitmap, f1639d);
            ChatONLogWriter.m3511e("*copied myprofile to msisdn format", "ProfileUploadTask");
            if (new File(uriM3533a.getPath()).length() > 0) {
                ChatONPref.m3523a("profile_image_status", "updated");
            } else {
                ChatONLogWriter.m3499a("File length is 0:" + uriM3533a.getPath(), "ProfileUploadTask");
            }
            return true;
        } catch (IOException e3) {
            ChatONLogWriter.m3501a(e3, getClass().getSimpleName());
            return false;
        }
    }
}
