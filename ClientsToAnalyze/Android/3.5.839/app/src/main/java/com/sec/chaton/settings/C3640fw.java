package com.sec.chaton.settings;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p051c.C1428b;
import com.sec.chaton.plugin.C2923b;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* compiled from: SendEmailLog.java */
/* renamed from: com.sec.chaton.settings.fw */
/* loaded from: classes.dex */
public class C3640fw {

    /* renamed from: a */
    private static final String[] f13201a = {"chatondev@samsung.com"};

    /* renamed from: b */
    private static boolean f13202b;

    /* renamed from: a */
    public static void m13919a(Context context, boolean z) {
        f13202b = z;
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", "[" + C1427a.f5064b + "_VOC]");
        Uri uriM13915a = m13915a(context);
        if (uriM13915a != null) {
            intent.putExtra("android.intent.extra.STREAM", uriM13915a);
            intent.putExtra("android.intent.extra.EMAIL", f13201a);
            intent.putExtra("android.intent.extra.TEXT", m13922c(context));
            intent.setType("plain/text");
            intent.setFlags(268435456);
            try {
                context.startActivity(intent);
                return;
            } catch (ActivityNotFoundException e) {
                C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, "SendEmailLog");
                    return;
                }
                return;
            }
        }
        C5179v.m19811a(context, "[DEV] file uri null", 0).show();
    }

    /* renamed from: b */
    public static void m13921b(Context context, boolean z) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", "[" + C1427a.f5064b + "_ChatON_log_files]");
        Uri uriM13916a = m13916a(z);
        if (uriM13916a != null) {
            intent.putExtra("android.intent.extra.STREAM", uriM13916a);
            intent.putExtra("android.intent.extra.TEXT", m13922c(context));
            intent.putExtra("android.intent.extra.EMAIL", f13201a);
            intent.setType("plain/text");
            intent.setFlags(268435456);
            try {
                context.startActivity(intent);
                return;
            } catch (ActivityNotFoundException e) {
                C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, "SendEmailLog");
                    return;
                }
                return;
            }
        }
        C5179v.m19811a(context, "There is no file to send", 0).show();
    }

    /* renamed from: a */
    public static Uri m13916a(boolean z) throws IOException {
        C3641fx c3641fx;
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "chatonlog");
        if ((file.exists() || file.mkdirs()) && (c3641fx = new C3641fx()) != null) {
            File[] fileArrListFiles = file.listFiles(c3641fx);
            if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                return null;
            }
            File file2 = new File(file, "log_" + new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(Long.valueOf(System.currentTimeMillis())) + ".zip");
            C4904y.m18639b("zipFile start " + file2, "SendEmailLog");
            try {
                ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
                byte[] bArr = new byte[1024];
                for (File file3 : fileArrListFiles) {
                    C4904y.m18639b("--zip start " + file3, "SendEmailLog");
                    if (!file3.exists()) {
                        C4904y.m18639b("--zip not exist " + file3, "SendEmailLog");
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
                                        C4904y.m18639b("getLogCollectorLogZipFile IOException : " + e.toString(), "SendEmailLog");
                                    }
                                    try {
                                        break;
                                    } catch (IOException e2) {
                                        C4904y.m18639b("getLogCollectorLogZipFile IOException : " + e2.toString(), "SendEmailLog");
                                    }
                                }
                                fileInputStream.close();
                                try {
                                    zipOutputStream.closeEntry();
                                } catch (IOException e3) {
                                    C4904y.m18639b("getLogCollectorLogZipFile IOException : " + e3.toString(), "SendEmailLog");
                                }
                                C4904y.m18639b("--zip end " + file3 + ", size=" + file3.length(), "SendEmailLog");
                            } catch (FileNotFoundException e4) {
                                C4904y.m18639b("getLogCollectorLogZipFile FileNotFoundException : " + e4.toString(), "SendEmailLog");
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
                m13918a();
                C4904y.m18639b("zipFile end " + file2 + ", size=" + file2.length(), "SendEmailLog");
                if (file2.exists()) {
                    return Uri.fromFile(file2);
                }
                return null;
            } catch (FileNotFoundException e7) {
                e7.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m13918a() {
        File[] fileArrListFiles;
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "chatonlog");
        File file2 = new File(Environment.getExternalStorageDirectory() + File.separator + "chatonlog" + File.separator + "backup");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        C3642fy c3642fy = new C3642fy();
        if (c3642fy != null && (fileArrListFiles = file.listFiles(c3642fy)) != null && fileArrListFiles.length > 0) {
            for (int i = 0; i < fileArrListFiles.length; i++) {
                fileArrListFiles[i].renameTo(new File(file2.getAbsoluteFile() + File.separator + fileArrListFiles[i].getName()));
                C4904y.m18639b("[" + i + "] move previous log file", "SendEmailLog");
            }
        }
    }

    /* renamed from: a */
    public static Uri m13915a(Context context) throws IOException {
        File[] fileArr = {m13920b(context), new File(Environment.getExternalStorageDirectory() + File.separator + "push" + File.separator + "log.txt")};
        File file = new File(Environment.getExternalStorageDirectory(), "ChatON");
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, "log.zip");
        C4904y.m18639b("zipFile start " + file2, "SendEmailLog");
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
            byte[] bArr = new byte[1024];
            for (File file3 : fileArr) {
                C4904y.m18639b("--zip start " + file3, "SendEmailLog");
                if (!file3.exists()) {
                    C4904y.m18639b("--zip not exist " + file3, "SendEmailLog");
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
                            C4904y.m18639b("--zip end " + file3 + ", size=" + file3.length(), "SendEmailLog");
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
            C4904y.m18639b("zipFile end " + file2 + ", size=" + file2.length(), "SendEmailLog");
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
    public static File m13920b(Context context) throws IOException {
        File file;
        String str = "log(" + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Long.valueOf(System.currentTimeMillis())) + ").txt";
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(str, 0);
            fileOutputStreamOpenFileOutput.write(m13923d(context).getBytes());
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
    public static String m13922c(Context context) {
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
        sb.append("UID : " + C4809aa.m18104a().m18121a("uid", "")).append("\n");
        sb.append("ChatON ID : " + C4809aa.m18104a().m18121a("chaton_id", "")).append("\n");
        sb.append("MSISDN : " + C4809aa.m18104a().m18121a("msisdn", "")).append("\n");
        sb.append("Samsung account : " + C4822an.m18254v()).append("\n");
        sb.append("Version : " + C1427a.f5064b).append("\n");
        sb.append("Manufacturer : " + Build.MANUFACTURER).append("\n");
        sb.append("MODEL : " + Build.MODEL).append("\n");
        sb.append("IMEI : " + C4822an.m18228d()).append("\n");
        sb.append("Connection : " + (connectivityManager.getActiveNetworkInfo() != null ? connectivityManager.getActiveNetworkInfo().getTypeName() : connectivityManager.getActiveNetworkInfo())).append("\n");
        sb.append("Device : " + Build.DEVICE).append("\n");
        sb.append("SDK : " + Build.VERSION.SDK_INT).append("\n");
        sb.append("DISPLAY : " + Build.DISPLAY).append("\n");
        sb.append("BOOTLOADER : " + Build.BOOTLOADER).append("\n");
        sb.append("BUILD_IDENTIFIER : " + Build.FINGERPRINT).append("\n");
        sb.append("BRAND : " + Build.BRAND).append("\n");
        sb.append("MCC : " + C4822an.m18243k()).append("\n");
        sb.append("MNC : " + C4822an.m18244l()).append("\n");
        sb.append("Net MCC : " + C4822an.m18241i()).append("\n");
        sb.append("Net MNC : " + C4822an.m18242j()).append("\n\n");
        sb.append("GLD Server : " + C1428b.f5095a[0]).append("\n");
        sb.append("Primary Contact Server : " + C4809aa.m18104a().m18121a("primary_contact_addrss", "")).append("\n");
        sb.append("Primary Message Server : " + C4809aa.m18104a().m18121a("primary_message_addrss", "")).append("\n");
        sb.append("Primary File Server : " + C4809aa.m18104a().m18121a("primary_file_addrss", "")).append("\n");
        sb.append("Primary SMS Server : " + C4809aa.m18104a().m18121a("primary_sms_address", "")).append("\n");
        sb.append("Primary Admin Web Server : " + C4809aa.m18104a().m18121a("primary_admin_mobileweb_address", "")).append("\n");
        sb.append("Primary Live Web Server : " + C4809aa.m18104a().m18121a("primary_live_mobileweb_address", "")).append("\n");
        sb.append("Primary ChatONV Server : " + C4809aa.m18104a().m18121a("primary_chaton_v_address", "")).append("\n");
        sb.append("Primary Shop Server : " + C4809aa.m18104a().m18121a("primary_shop_address", "")).append("\n");
        sb.append("Primary Game Server : " + C4809aa.m18104a().m18121a("primary_game_address", "")).append("\n\n");
        sb.append("Secondary Contact Server : " + C4809aa.m18104a().m18121a("secondary_contact_addrss", "")).append("\n");
        sb.append("Secondary Message Server : " + C4809aa.m18104a().m18121a("secondary_message_addrss", "")).append("\n");
        sb.append("Secondary File Server : " + C4809aa.m18104a().m18121a("secondary_file_addrss", "")).append("\n");
        sb.append("Secondary SMS Server : " + C4809aa.m18104a().m18121a("secondary_sms_addrss", "")).append("\n");
        sb.append("Secondary Admin Web Server : " + C4809aa.m18104a().m18121a("secondary_admin_mobileweb_addrss", "")).append("\n");
        sb.append("Secondary Live Web Server : " + C4809aa.m18104a().m18121a("secondary_live_mobileweb_addrss", "")).append("\n");
        sb.append("Secondary ChatONV Server : " + C4809aa.m18104a().m18121a("secondary_chaton_v_address", "")).append("\n");
        sb.append("Secondary Shop Server : " + C4809aa.m18104a().m18121a("secondary_shop_addrss", "")).append("\n");
        sb.append("Secondary Game Server : " + C4809aa.m18104a().m18121a("secondary_game_addrss", "")).append("\n\n");
        sb.append("Push Info : " + C4822an.m18229d(context)).append("\n");
        sb.append("Push Available : " + f13202b).append("\n");
        sb.append("SSO Info : " + C4822an.m18232e(context)).append("\n");
        sb.append("Multi Device Mapped : " + C4822an.m18255w()).append("\n");
        sb.append("Country Info : " + C4822an.m18257y()).append("\n");
        sb.append("Samsung Apps Installed : " + C4822an.m18249q()).append("\n");
        sb.append("ChatONV support : " + C2923b.m12153h(context)).append("\n");
        sb.append(C4822an.m18235f(context)).append("\n");
        C0416a c0416a = new C0416a();
        sb.append("ChatONV signed : " + c0416a.m1495d(context)).append("\n");
        sb.append("ChatONV max video call : " + c0416a.m1493b(context, true)).append("\n");
        sb.append("ChatONV max voice call : " + c0416a.m1493b(context, false)).append("\n");
        sb.append("ChatONV log enable : " + C0416a.m1471a()).append("\n");
        sb.append("Full Feature user : " + C4822an.m18218a()).append("\n");
        sb.append("Support SMS feature : " + C2349a.m10301a("sms_feature")).append("\n");
        sb.append("Accepted Disclaimer : " + C4822an.m18201K()).append("\n");
        return sb.toString();
    }

    /* renamed from: d */
    public static final String m13923d(Context context) {
        return m13917a(context, (String) null);
    }

    /* renamed from: a */
    public static final String m13917a(Context context, String str) throws IOException {
        int i;
        String[] strArr;
        String str2 = Build.BRAND;
        String str3 = Build.MANUFACTURER;
        String str4 = Build.MODEL;
        String str5 = Build.VERSION.SDK;
        String str6 = "";
        PackageManager packageManager = context.getPackageManager();
        try {
            str6 = packageManager.getPackageInfo(context.getPackageName(), 64).versionName;
            i = packageManager.getPackageInfo(context.getPackageName(), 64).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            str6 = str6;
            i = 0;
        }
        String str7 = "Brand: " + str2 + "\nManufacturer: " + str3 + "\nModel: " + str4 + "\nAPI Version: " + str5 + "\nApplication Version Name: " + str6 + "\nApplication Version Code: " + i + "\n";
        if (str == null) {
            strArr = new String[]{"logcat", "-d", "-v", "time"};
        } else {
            strArr = new String[]{"logcat", "-d", "-v", "time", str + ":V", "*:S"};
        }
        try {
            Process processExec = Runtime.getRuntime().exec(strArr);
            String property = System.getProperty("line.separator");
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
                sb.append("---------------------------------------------------------------\n");
                sb.append(str7);
                sb.append("---------------------------------------------------------------\n");
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append(property);
                }
                bufferedReader.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return sb.toString();
        } catch (IOException e3) {
            e3.printStackTrace();
            return "";
        }
    }
}
