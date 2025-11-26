package com.sec.chaton.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.ChatONFileHttpClient;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.push.util.PushLog;
import com.sec.chaton.util.ServerAddressMgr;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class ChatONLogWriter {

    /* renamed from: b */
    private static boolean f3624b = false;

    /* renamed from: c */
    private static boolean f3625c = false;

    /* renamed from: d */
    private static boolean f3626d = false;

    /* renamed from: e */
    private static boolean f3627e = false;

    /* renamed from: f */
    private static boolean f3628f = false;

    /* renamed from: a */
    public static String f3623a = "pref_log_on_off";

    public class LogUploadTask extends AsyncTask {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            String strM3465a;
            SharedPreferences.Editor editorRemove;
            int i;
            Context contextM2387e = GlobalApplication.m2387e();
            String string = ChatONPref.m3519a().getString("CrashLog", "");
            try {
                strM3465a = AesCipher.m3465a(new AesCipher(AesCipher.m3466a(), AesCipher.m3468b()).m3471b(("imei=" + DeviceInfoUtil.m3564a() + "&filename=" + string).getBytes()));
            } catch (Exception e) {
                ChatONLogWriter.m3501a(e, getClass().getSimpleName());
                strM3465a = "";
            }
            HttpEnvelope.Builder builderM2741a = new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.FILE, "/file").m2738a(HttpEnvelope.RequestMethod.POST).m2740a("text/log").m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("param", strM3465a);
            try {
                try {
                    File file = new File(contextM2387e.getFilesDir(), string);
                    if (file.exists()) {
                        FileInputStream fileInputStreamOpenFileInput = contextM2387e.openFileInput(string);
                        byte[] bArr = new byte[(int) file.length()];
                        int i2 = 0;
                        while (i2 < bArr.length && (i = fileInputStreamOpenFileInput.read(bArr, i2, bArr.length - i2)) >= 0) {
                            i2 += i;
                        }
                        fileInputStreamOpenFileInput.close();
                        ChatONFileHttpClient.m2700a(builderM2741a.m2742a(), bArr);
                        file.delete();
                    }
                    editorRemove = ChatONPref.m3519a().edit().remove("CrashLog");
                } catch (Exception e2) {
                    ChatONLogWriter.m3501a(e2, getClass().getSimpleName());
                    editorRemove = ChatONPref.m3519a().edit().remove("CrashLog");
                }
                editorRemove.commit();
                return null;
            } catch (Throwable th) {
                ChatONPref.m3519a().edit().remove("CrashLog").commit();
                throw th;
            }
        }
    }

    private ChatONLogWriter() {
    }

    /* renamed from: a */
    public static String m3494a(List list) {
        StringBuilder sb = new StringBuilder();
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            sb.append(str).append("" + list.get(i));
            str = ",";
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static void m3495a() {
        m3496a(-1);
    }

    /* renamed from: a */
    public static void m3496a(int i) {
        if (i == -1) {
            ChatONPref.m3519a().getInt(f3623a, 0);
        } else {
            ChatONPref.m3521a(f3623a, Integer.valueOf(i));
        }
        if ("stg.contact.samsungchaton.com".equalsIgnoreCase(ChatONPref.m3519a().getString("primary_contact_addrss", "")) || ChatONPref.m3519a().getInt(f3623a, 0) > 0) {
            m3502a(true, true, true, true, true);
            PushLog.m3027a(true, true, true, true);
        } else {
            m3502a(false, false, false, false, true);
            PushLog.m3027a(false, false, false, true);
        }
    }

    /* renamed from: a */
    private static synchronized void m3497a(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("[" + Thread.currentThread().getId() + "]");
        if (!"NoClassName!@#".equals(str3)) {
            sb.append("[" + str3 + "] ");
        }
        sb.append(str2);
        switch (i) {
            case 2:
                Log.v(str, sb.toString());
                break;
            case 3:
                Log.d(str, sb.toString());
                break;
            case 4:
                Log.i(str, sb.toString());
                break;
            case 5:
                Log.w(str, sb.toString());
                break;
            case 6:
                Log.e(str, sb.toString());
                break;
        }
    }

    /* renamed from: a */
    public static void m3498a(Object obj) {
        m3506b(obj != null ? obj.toString() : "null", "System_out");
    }

    /* renamed from: a */
    public static void m3499a(String str, String str2) {
        if (f3628f) {
            m3497a(6, "ChatON", str, str2);
        }
    }

    @Deprecated
    /* renamed from: a */
    public static void m3500a(Throwable th) {
        m3507c(m3504b(th));
    }

    /* renamed from: a */
    public static void m3501a(Throwable th, String str) {
        if (f3628f) {
            m3497a(6, "ChatON", m3504b(th), str);
        }
    }

    /* renamed from: a */
    private static void m3502a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        f3624b = z;
        f3625c = z2;
        f3626d = z3;
        f3627e = z4;
        f3628f = z5;
    }

    /* renamed from: a */
    public static boolean m3503a(String str) throws NoSuchAlgorithmException {
        String string = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            string = new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "f0e86378bd078e9e0357a6e13f914c83".equals(string);
    }

    /* renamed from: b */
    private static String m3504b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @Deprecated
    /* renamed from: b */
    public static void m3505b(String str) {
        if (f3625c) {
            Log.d("ChatON", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\t[" + Thread.currentThread().getId() + "] " + str);
        }
    }

    /* renamed from: b */
    public static void m3506b(String str, String str2) {
        if (f3625c) {
            m3497a(3, "ChatON", str, str2);
        }
    }

    @Deprecated
    /* renamed from: c */
    public static void m3507c(String str) {
        if (f3628f) {
            Log.e("ChatON", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\t[" + Thread.currentThread().getId() + "] " + str);
        }
    }

    /* renamed from: c */
    public static void m3508c(String str, String str2) {
        if (f3626d) {
            m3497a(4, "ChatON", str, str2);
        }
    }

    /* renamed from: d */
    public static void m3509d(String str) {
        m3506b(str, "System_out");
    }

    /* renamed from: d */
    public static void m3510d(String str, String str2) {
        if (f3627e) {
            m3497a(5, "ChatON", str, str2);
        }
    }

    /* renamed from: e */
    public static void m3511e(String str, String str2) {
        if (f3624b) {
            m3497a(2, "ChatON", str, str2);
        }
    }

    /* renamed from: f */
    public static void m3512f(String str, String str2) {
        if (f3625c) {
            m3497a(3, str2, str, str2);
        }
    }

    @Deprecated
    /* renamed from: g */
    public static void m3513g(String str, String str2) {
        if (f3625c) {
            Log.d("ChatON-" + str, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\t[" + Thread.currentThread().getId() + "][" + str + "] " + str2);
        }
    }
}
