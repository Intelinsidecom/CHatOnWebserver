package com.sec.chaton.util;

import android.media.MediaScannerConnection;
import android.os.Environment;
import android.text.TextUtils;
import com.sec.chaton.constant.ChatONConst;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.ChatONFileHttpClient;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.util.ServerAddressMgr;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class ChatONFileUtil {

    /* renamed from: b */
    private static MediaScannerConnection f3619b;

    /* renamed from: c */
    private static String f3620c;

    /* renamed from: a */
    private static String f3618a = "ChatONFileUtil";

    /* renamed from: d */
    private static MediaScannerConnection.MediaScannerConnectionClient f3621d = new C0605c();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0145 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0136 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0140 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m3479a(java.lang.String r10, java.lang.String r11, java.lang.String r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 533
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.ChatONFileUtil.m3479a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static String m3480a(String str, String str2, String str3, boolean z, String str4, long j, ChatONContract.InBoxTable.ChatType chatType, String str5) throws IOException {
        String strM2701a;
        f3619b = new MediaScannerConnection(GlobalApplication.m2387e(), f3621d);
        HttpEnvelope.Builder builderM2741a = new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.FILE, "/file").m2738a(HttpEnvelope.RequestMethod.GET).m2741a("uid", ChatONPref.m3519a().getString("uid", ""));
        String str6 = "imei=" + DeviceInfoUtil.m3564a() + "&buddyid=" + str2 + "&filename=" + str3;
        String str7 = str6 + "&size=239";
        ChatONLogWriter.m3506b("filedownLoadUrl:" + str6, f3618a);
        try {
            String strM3477a = GlobalApplication.m2390h().m3477a();
            if (TextUtils.isEmpty(strM3477a)) {
                ChatONLogWriter.m3499a("Fail in getting a key", f3618a);
                MessageDatabaseHelper.m2288a(GlobalApplication.m2387e().getContentResolver(), str5, str4, Long.valueOf(j), ChatONConst.f1339c, chatType, StorageStateInfoUtil.m3677a(), z);
                return ChatONConst.f1339c;
            }
            AesCipher aesCipher = new AesCipher(AesCipher.m3469b(strM3477a), AesCipher.m3470c(strM3477a));
            String strM3465a = z ? AesCipher.m3465a(aesCipher.m3471b(str7.getBytes())) : AesCipher.m3465a(aesCipher.m3471b(str6.getBytes()));
            builderM2741a.m2741a("param", strM3465a);
            boolean zM3677a = StorageStateInfoUtil.m3677a();
            String absolutePath = zM3677a ? GlobalApplication.m2387e().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m2387e().getFilesDir().getAbsolutePath();
            try {
                String str8 = str + "?uid=" + ChatONPref.m3519a().getString("uid", "") + "&param=" + strM3465a;
                ChatONLogWriter.m3506b("Donwload Url : " + str8, f3618a);
                strM2701a = ChatONFileHttpClient.m2701a(str8, absolutePath + "//" + str4 + "//", str3, z);
            } catch (Exception e) {
                ChatONLogWriter.m3501a(e, f3618a);
                strM2701a = ChatONConst.f1339c;
            }
            MessageDatabaseHelper.m2288a(GlobalApplication.m2387e().getContentResolver(), str5, str4, Long.valueOf(j), strM2701a, chatType, zM3677a, z);
            return strM2701a;
        } catch (Exception e2) {
            ChatONLogWriter.m3501a(e2, f3618a);
            MessageDatabaseHelper.m2288a(GlobalApplication.m2387e().getContentResolver(), str5, str4, Long.valueOf(j), ChatONConst.f1339c, chatType, StorageStateInfoUtil.m3677a(), z);
            return ChatONConst.f1339c;
        }
    }

    /* renamed from: a */
    public static void m3481a() {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "ChatON");
        if (file.exists()) {
            m3482a(file);
            if (file.delete()) {
                return;
            }
            file.delete();
        }
    }

    /* renamed from: a */
    public static void m3482a(File file) {
        int length;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || (length = fileArrListFiles.length) <= 0) {
            return;
        }
        for (int i = 0; i < length; i++) {
            if (fileArrListFiles[i].isFile()) {
                fileArrListFiles[i].delete();
            } else {
                m3482a(fileArrListFiles[i]);
                if (!fileArrListFiles[i].delete()) {
                    fileArrListFiles[i].delete();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m3483a(String str) {
        ChatONLogWriter.m3506b("deleteDirectory path: " + str, f3618a);
        File file = new File(str);
        if (file.exists()) {
            m3482a(file);
            if (file.delete()) {
                return;
            }
            file.delete();
        }
    }

    /* renamed from: b */
    public static void m3484b() {
        File[] fileArrListFiles;
        File file = new File(GlobalApplication.m2387e().getFilesDir().getAbsolutePath());
        if (!file.exists() || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                m3482a(file2);
                if (!file2.delete()) {
                    file2.delete();
                }
            }
        }
    }

    /* renamed from: b */
    public static boolean m3485b(File file) {
        return file != null && file.exists();
    }

    /* renamed from: b */
    public static boolean m3486b(String str) {
        return new File(str).exists();
    }
}
