package com.sec.chaton.util;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import com.sec.chaton.R;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import com.sec.widget.C5179v;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: ImageFileUtils.java */
/* renamed from: com.sec.chaton.util.bc */
/* loaded from: classes.dex */
public class C4838bc {
    /* renamed from: a */
    public static boolean m18308a(File file) {
        C4904y.m18639b("[ShouldBeResized]: " + file.getName(), CommonApplication.m18732r().getClass().getName());
        String strSubstring = null;
        try {
            strSubstring = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        } catch (Exception e) {
        }
        if ("gif".equalsIgnoreCase(strSubstring)) {
            return false;
        }
        if (file.length() <= C1427a.f5079q && C4894o.m18609a(EnumC2214ab.IMAGE, strSubstring)) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                if (options.outWidth >= options.outHeight) {
                    if (options.outWidth > C1427a.f5077o || options.outHeight > C1427a.f5078p) {
                        return true;
                    }
                } else if (options.outHeight > C1427a.f5077o || options.outWidth > C1427a.f5078p) {
                    return true;
                }
            } catch (Exception e2) {
                C4904y.m18634a("Exception", CommonApplication.m18732r().getClass().getName());
            }
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static File m18307a(Context context, File file, String str, Uri uri, boolean z) {
        File fileM18310b;
        try {
            if (z) {
                fileM18310b = m18310b(context, file, str, uri, true);
            } else {
                fileM18310b = m18310b(context, file, str, uri, false);
            }
            return fileM18310b;
        } catch (FileNotFoundException e) {
            C4904y.m18635a(e, context.getClass().getName());
            return null;
        } catch (IOException e2) {
            C4904y.m18635a(e2, context.getClass().getName());
            return null;
        } catch (Exception e3) {
            C4904y.m18635a(e3, context.getClass().getName());
            return null;
        } catch (OutOfMemoryError e4) {
            C5179v.m19810a(context, R.string.chat_view_memory_error, 1).show();
            C4904y.m18635a(e4, context.getClass().getName());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0229 A[Catch: OutOfMemoryError -> 0x0258, all -> 0x0263, Exception -> 0x035d, FileNotFoundException -> 0x0369, TRY_ENTER, TryCatch #1 {all -> 0x0263, blocks: (B:62:0x011a, B:69:0x0130, B:71:0x0137, B:72:0x013c, B:74:0x0142, B:75:0x0163, B:77:0x0169, B:78:0x016c, B:79:0x0189, B:81:0x018d, B:82:0x0191, B:83:0x019b, B:130:0x0269, B:125:0x0262, B:117:0x0250, B:120:0x0257, B:115:0x0230, B:114:0x0229, B:66:0x0128, B:68:0x012e, B:106:0x020f, B:109:0x0217, B:111:0x021d, B:112:0x0222), top: B:190:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0230 A[Catch: OutOfMemoryError -> 0x0258, all -> 0x0263, Exception -> 0x035d, FileNotFoundException -> 0x0369, TRY_LEAVE, TryCatch #1 {all -> 0x0263, blocks: (B:62:0x011a, B:69:0x0130, B:71:0x0137, B:72:0x013c, B:74:0x0142, B:75:0x0163, B:77:0x0169, B:78:0x016c, B:79:0x0189, B:81:0x018d, B:82:0x0191, B:83:0x019b, B:130:0x0269, B:125:0x0262, B:117:0x0250, B:120:0x0257, B:115:0x0230, B:114:0x0229, B:66:0x0128, B:68:0x012e, B:106:0x020f, B:109:0x0217, B:111:0x021d, B:112:0x0222), top: B:190:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0250 A[Catch: IOException -> 0x0256, OutOfMemoryError -> 0x0258, all -> 0x0263, Exception -> 0x035d, FileNotFoundException -> 0x0369, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0263, blocks: (B:62:0x011a, B:69:0x0130, B:71:0x0137, B:72:0x013c, B:74:0x0142, B:75:0x0163, B:77:0x0169, B:78:0x016c, B:79:0x0189, B:81:0x018d, B:82:0x0191, B:83:0x019b, B:130:0x0269, B:125:0x0262, B:117:0x0250, B:120:0x0257, B:115:0x0230, B:114:0x0229, B:66:0x0128, B:68:0x012e, B:106:0x020f, B:109:0x0217, B:111:0x021d, B:112:0x0222), top: B:190:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0287 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0282 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0137 A[Catch: OutOfMemoryError -> 0x0258, all -> 0x0263, Exception -> 0x035d, FileNotFoundException -> 0x0369, TRY_ENTER, TryCatch #1 {all -> 0x0263, blocks: (B:62:0x011a, B:69:0x0130, B:71:0x0137, B:72:0x013c, B:74:0x0142, B:75:0x0163, B:77:0x0169, B:78:0x016c, B:79:0x0189, B:81:0x018d, B:82:0x0191, B:83:0x019b, B:130:0x0269, B:125:0x0262, B:117:0x0250, B:120:0x0257, B:115:0x0230, B:114:0x0229, B:66:0x0128, B:68:0x012e, B:106:0x020f, B:109:0x0217, B:111:0x021d, B:112:0x0222), top: B:190:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0142 A[Catch: OutOfMemoryError -> 0x0258, all -> 0x0263, Exception -> 0x035d, FileNotFoundException -> 0x0369, TryCatch #1 {all -> 0x0263, blocks: (B:62:0x011a, B:69:0x0130, B:71:0x0137, B:72:0x013c, B:74:0x0142, B:75:0x0163, B:77:0x0169, B:78:0x016c, B:79:0x0189, B:81:0x018d, B:82:0x0191, B:83:0x019b, B:130:0x0269, B:125:0x0262, B:117:0x0250, B:120:0x0257, B:115:0x0230, B:114:0x0229, B:66:0x0128, B:68:0x012e, B:106:0x020f, B:109:0x0217, B:111:0x021d, B:112:0x0222), top: B:190:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0169 A[Catch: OutOfMemoryError -> 0x0258, all -> 0x0263, Exception -> 0x035d, FileNotFoundException -> 0x0369, TryCatch #1 {all -> 0x0263, blocks: (B:62:0x011a, B:69:0x0130, B:71:0x0137, B:72:0x013c, B:74:0x0142, B:75:0x0163, B:77:0x0169, B:78:0x016c, B:79:0x0189, B:81:0x018d, B:82:0x0191, B:83:0x019b, B:130:0x0269, B:125:0x0262, B:117:0x0250, B:120:0x0257, B:115:0x0230, B:114:0x0229, B:66:0x0128, B:68:0x012e, B:106:0x020f, B:109:0x0217, B:111:0x021d, B:112:0x0222), top: B:190:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x018d A[Catch: IOException -> 0x0256, OutOfMemoryError -> 0x0258, all -> 0x0263, Exception -> 0x035d, FileNotFoundException -> 0x0369, TryCatch #1 {all -> 0x0263, blocks: (B:62:0x011a, B:69:0x0130, B:71:0x0137, B:72:0x013c, B:74:0x0142, B:75:0x0163, B:77:0x0169, B:78:0x016c, B:79:0x0189, B:81:0x018d, B:82:0x0191, B:83:0x019b, B:130:0x0269, B:125:0x0262, B:117:0x0250, B:120:0x0257, B:115:0x0230, B:114:0x0229, B:66:0x0128, B:68:0x012e, B:106:0x020f, B:109:0x0217, B:111:0x021d, B:112:0x0222), top: B:190:0x0037 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File m18310b(android.content.Context r12, java.io.File r13, java.lang.String r14, android.net.Uri r15, boolean r16) {
        /*
            Method dump skipped, instructions count: 904
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C4838bc.m18310b(android.content.Context, java.io.File, java.lang.String, android.net.Uri, boolean):java.io.File");
    }

    /* renamed from: a */
    public static boolean m18309a(String str) {
        return C5034k.m19099d() && str != null && !str.contains("thumbnail") && str.toLowerCase().endsWith("gif") && Build.VERSION.SDK_INT >= 14;
    }
}
