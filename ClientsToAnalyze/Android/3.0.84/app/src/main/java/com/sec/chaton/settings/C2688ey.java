package com.sec.chaton.settings;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import com.coolots.sso.p006a.C0045a;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p020c.C0817b;
import com.sec.chaton.plugin.C1948a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* compiled from: SendEmailLog.java */
/* renamed from: com.sec.chaton.settings.ey */
/* loaded from: classes.dex */
public class C2688ey {

    /* renamed from: a */
    private static final String[] f9981a = {"chatondev@samsung.com"};

    /* renamed from: b */
    private static boolean f9982b;

    /* renamed from: a */
    public static void m9691a(Context context, boolean z) {
        f9982b = z;
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", "VOC:");
        Uri uriM9690a = m9690a(context);
        if (uriM9690a != null) {
            intent.putExtra("android.intent.extra.STREAM", uriM9690a);
            intent.putExtra("android.intent.extra.EMAIL", f9981a);
            intent.putExtra("android.intent.extra.TEXT", m9693c(context));
            intent.setType("plain/text");
            intent.setFlags(268435456);
            context.startActivity(intent);
            return;
        }
        C3641ai.m13211a(context, "[DEV] file uri null", 0).show();
    }

    /* renamed from: a */
    public static Uri m9690a(Context context) throws IOException {
        File[] fileArr = {m9692b(context), new File(Environment.getExternalStorageDirectory() + File.separator + "push" + File.separator + "log.txt")};
        File file = new File(Environment.getExternalStorageDirectory(), "ChatON");
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, "log.zip");
        C3250y.m11450b("zipFile start " + file2, "SendEmailLog");
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
            byte[] bArr = new byte[1024];
            for (File file3 : fileArr) {
                C3250y.m11450b("--zip start " + file3, "SendEmailLog");
                if (!file3.exists()) {
                    C3250y.m11450b("--zip not exist " + file3, "SendEmailLog");
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
                            C3250y.m11450b("--zip end " + file3 + ", size=" + file3.length(), "SendEmailLog");
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
            C3250y.m11450b("zipFile end " + file2 + ", size=" + file2.length(), "SendEmailLog");
            if (file2.exists()) {
                return Uri.fromFile(file2);
            }
            return null;
        } catch (FileNotFoundException e7) {
            e7.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static File m9692b(Context context) throws IOException {
        File file;
        String str = "log(" + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Long.valueOf(System.currentTimeMillis())) + ").txt";
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(str, 0);
            fileOutputStreamOpenFileOutput.write(C3250y.m11434a(context).getBytes());
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

    /* renamed from: c */
    public static String m9693c(Context context) {
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
        sb.append("UID : " + C3159aa.m10962a().m10979a("uid", "")).append("\n");
        sb.append("ChatON ID : " + C3159aa.m10962a().m10979a("chaton_id", "")).append("\n");
        sb.append("MSISDN : " + C3159aa.m10962a().m10979a("msisdn", "")).append("\n");
        sb.append("Samsung account : " + C3171am.m11079q()).append("\n");
        sb.append("Version : " + C0816a.f3112a).append("\n");
        sb.append("Manufacturer : " + Build.MANUFACTURER).append("\n");
        sb.append("MODEL : " + Build.MODEL).append("\n");
        sb.append("IMEI : " + C3171am.m11045a()).append("\n");
        sb.append("Connection : " + (connectivityManager.getActiveNetworkInfo() != null ? connectivityManager.getActiveNetworkInfo().getTypeName() : connectivityManager.getActiveNetworkInfo())).append("\n");
        sb.append("Device : " + Build.DEVICE).append("\n");
        sb.append("SDK : " + Build.VERSION.SDK_INT).append("\n");
        sb.append("DISPLAY : " + Build.DISPLAY).append("\n");
        sb.append("BOOTLOADER : " + Build.BOOTLOADER).append("\n");
        sb.append("BUILD_IDENTIFIER : " + Build.FINGERPRINT).append("\n");
        sb.append("BRAND : " + Build.BRAND).append("\n");
        sb.append("MCC : " + C3171am.m11068h()).append("\n");
        sb.append("MNC : " + C3171am.m11070i()).append("\n");
        sb.append("Net MCC : " + C3171am.m11064f()).append("\n");
        sb.append("Net MNC : " + C3171am.m11066g()).append("\n\n");
        sb.append("GLD Server : " + C0817b.f3129a[0]).append("\n");
        sb.append("Primaary Contact Server : " + C3159aa.m10962a().m10979a("primary_contact_addrss", "")).append("\n");
        sb.append("Primaary Message Server : " + C3159aa.m10962a().m10979a("primary_message_addrss", "")).append("\n");
        sb.append("Primaary File Server : " + C3159aa.m10962a().m10979a("primary_file_addrss", "")).append("\n");
        sb.append("Primaary SMS Server : " + C3159aa.m10962a().m10979a("primary_sms_address", "")).append("\n");
        sb.append("Primaary Admin Web Server : " + C3159aa.m10962a().m10979a("primary_admin_mobileweb_address", "")).append("\n");
        sb.append("Primaary Live Web Server : " + C3159aa.m10962a().m10979a("primary_live_mobileweb_address", "")).append("\n");
        sb.append("Primaary ChatONV Server : " + C3159aa.m10962a().m10979a("primary_chaton_v_address", "")).append("\n\n");
        sb.append("Secondary Contact Server : " + C3159aa.m10962a().m10979a("secondary_contact_addrss", "")).append("\n");
        sb.append("Secondary Message Server : " + C3159aa.m10962a().m10979a("secondary_message_addrss", "")).append("\n");
        sb.append("Secondary File Server : " + C3159aa.m10962a().m10979a("secondary_file_addrss", "")).append("\n");
        sb.append("Secondary SMS Server : " + C3159aa.m10962a().m10979a("secondary_sms_addrss", "")).append("\n");
        sb.append("Secondary Admin Web Server : " + C3159aa.m10962a().m10979a("secondary_admin_mobileweb_addrss", "")).append("\n");
        sb.append("Secondary Live Web Server : " + C3159aa.m10962a().m10979a("secondary_live_mobileweb_addrss", "")).append("\n");
        sb.append("Secondary ChatONV Server : " + C3159aa.m10962a().m10979a("secondary_chaton_v_address", "")).append("\n\n");
        sb.append("Push Info : " + C3171am.m11063e(context)).append("\n");
        sb.append("Push Available : " + f9982b).append("\n");
        sb.append("SSO Info : " + C3171am.m11065f(context)).append("\n");
        sb.append("Multi Device Mapped : " + C3171am.m11080r()).append("\n");
        sb.append("Country Info : " + C3171am.m11082t()).append("\n");
        sb.append("Samsung Apps Installed : " + C3171am.m11075m()).append("\n");
        sb.append("ChatONV support : " + C1948a.m7903a(context)).append("\n");
        sb.append(C3171am.m11067g(context)).append("\n");
        C0045a c0045a = new C0045a();
        sb.append("ChatONV signed : " + c0045a.m55d(context)).append("\n");
        sb.append("ChatONV max video call : " + c0045a.m53b(context, true)).append("\n");
        sb.append("ChatONV max voice call : " + c0045a.m53b(context, false)).append("\n");
        sb.append("ChatONV log enable : " + C0045a.m31a()).append("\n");
        return sb.toString();
    }
}
