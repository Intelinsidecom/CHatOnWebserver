package com.sec.chaton.settings;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.p029f.C0685b;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* compiled from: SendEmailLog.java */
/* renamed from: com.sec.chaton.settings.ao */
/* loaded from: classes.dex */
public class C1017ao {
    /* renamed from: a */
    public static void m3917a(Context context) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", "VOC:");
        Uri uriM3918b = m3918b(context);
        if (uriM3918b != null) {
            intent.putExtra("android.intent.extra.STREAM", uriM3918b);
            intent.putExtra("android.intent.extra.TEXT", m3920d(context));
            intent.setType("plain/text");
            intent.setFlags(268435456);
            context.startActivity(intent);
            return;
        }
        C1619g.m5889a(context, "[DEV] file uri null", 0).show();
    }

    /* renamed from: b */
    public static Uri m3918b(Context context) throws IOException {
        File[] fileArr = {m3919c(context), new File(Environment.getExternalStorageDirectory() + File.separator + "push" + File.separator + "log.txt")};
        File file = new File(Environment.getExternalStorageDirectory(), "ChatON");
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, "log.zip");
        C1341p.m4658b("zipFile start " + file2, "SendEmailLog");
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
            byte[] bArr = new byte[1024];
            for (File file3 : fileArr) {
                C1341p.m4658b("--zip start " + file3, "SendEmailLog");
                if (!file3.exists()) {
                    C1341p.m4658b("--zip not exist " + file3, "SendEmailLog");
                } else {
                    try {
                        zipOutputStream.putNextEntry(new ZipEntry(file3.getName()));
                        try {
                            FileInputStream fileInputStream = new FileInputStream(file3);
                            while (true) {
                                try {
                                    int i = fileInputStream.read(bArr);
                                    if (i > 0) {
                                        zipOutputStream.write(bArr, 0, i);
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    break;
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            fileInputStream.close();
                            try {
                                zipOutputStream.closeEntry();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            C1341p.m4658b("--zip end " + file3 + ", size=" + file3.length(), "SendEmailLog");
                        } catch (FileNotFoundException e4) {
                            e4.printStackTrace();
                        }
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
            }
            try {
                zipOutputStream.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
            C1341p.m4658b("zipFile end " + file2 + ", size=" + file2.length(), "SendEmailLog");
            if (file2.exists()) {
                return Uri.fromFile(file2);
            }
            return null;
        } catch (FileNotFoundException e7) {
            e7.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static File m3919c(Context context) throws IOException {
        File file;
        String str = "log(" + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Long.valueOf(System.currentTimeMillis())) + ").txt";
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(str, 0);
            fileOutputStreamOpenFileOutput.write(C1341p.m4644a(context).getBytes());
            fileOutputStreamOpenFileOutput.close();
            file = new File(context.getFilesDir(), str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (file.exists()) {
            return file;
        }
        return null;
    }

    /* renamed from: d */
    public static String m3920d(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        StringBuilder sb = new StringBuilder();
        sb.append("*아래의 내용을 반드시 채워주시기 바랍니다.").append("\n");
        sb.append("검출자(Detector) : ").append("\n");
        sb.append("싱글아이디(Single ID) : ").append("\n");
        sb.append("수행절차(Setp to reproduce) : ").append("\n");
        sb.append("발생결과(Occurance) : ").append("\n");
        sb.append("기대결과(Expected Result) : ").append("\n");
        sb.append("재현빈도(Occurance rate) : ").append("\n");
        sb.append("\n");
        sb.append("MSISDN : " + C1323bs.m4575a().getString("msisdn", "")).append("\n");
        sb.append("Version : " + C0684a.f2331b).append("\n");
        sb.append("Manufacturer : " + Build.MANUFACTURER).append("\n");
        sb.append("MODEL : " + Build.MODEL).append("\n");
        sb.append("Connection : " + (connectivityManager.getActiveNetworkInfo() != null ? connectivityManager.getActiveNetworkInfo().getTypeName() : connectivityManager.getActiveNetworkInfo())).append("\n");
        sb.append("Device : " + Build.DEVICE).append("\n");
        sb.append("SDK : " + Build.VERSION.SDK_INT).append("\n");
        sb.append("DISPLAY : " + Build.DISPLAY).append("\n");
        sb.append("BOOTLOADER : " + Build.BOOTLOADER).append("\n");
        sb.append("BUILD_IDENTIFIER : " + Build.FINGERPRINT).append("\n");
        sb.append("BRAND : " + Build.BRAND).append("\n");
        sb.append("Server : " + C1323bs.m4575a().getString("pref_choose_server_test", C0685b.f2343a[0])).append("\n");
        return sb.toString();
    }
}
