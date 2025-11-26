package com.sec.chaton.util;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: ImageFileUtils.java */
/* renamed from: com.sec.chaton.util.bc */
/* loaded from: classes.dex */
public class C3188bc {
    /* renamed from: a */
    public static boolean m11135a(File file) {
        C3250y.m11450b("[ShouldBeResized]: " + file.getName(), CommonApplication.m11493l().getClass().getName());
        if (file.length() > C0816a.f3123l) {
            return true;
        }
        String strSubstring = null;
        try {
            strSubstring = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        } catch (Exception e) {
        }
        if (!C3243r.m11421a(EnumC1455w.IMAGE, strSubstring)) {
            return true;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            if (options.outWidth >= options.outHeight) {
                if (options.outWidth > C0816a.f3121j || options.outHeight > C0816a.f3122k) {
                    return true;
                }
            } else if (options.outHeight > C0816a.f3121j || options.outWidth > C0816a.f3122k) {
                return true;
            }
        } catch (Exception e2) {
            C3250y.m11442a("Exception", CommonApplication.m11493l().getClass().getName());
        }
        return false;
    }

    /* renamed from: a */
    public static File m11134a(Context context, File file, String str, Uri uri, boolean z) {
        File fileM11136b;
        try {
            if (z) {
                fileM11136b = m11136b(context, file, str, uri, true);
            } else {
                fileM11136b = m11136b(context, file, str, uri, false);
            }
            return fileM11136b;
        } catch (FileNotFoundException e) {
            C3250y.m11443a(e, context.getClass().getName());
            return null;
        } catch (IOException e2) {
            C3250y.m11443a(e2, context.getClass().getName());
            return null;
        } catch (Exception e3) {
            C3250y.m11443a(e3, context.getClass().getName());
            return null;
        } catch (OutOfMemoryError e4) {
            C3641ai.m13210a(context, R.string.chat_view_memory_error, 1).show();
            C3250y.m11443a(e4, context.getClass().getName());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x021c A[Catch: OutOfMemoryError -> 0x024a, all -> 0x0255, Exception -> 0x0348, FileNotFoundException -> 0x0354, TRY_ENTER, TryCatch #1 {OutOfMemoryError -> 0x024a, blocks: (B:71:0x012e, B:72:0x0133, B:74:0x0139, B:75:0x0158, B:77:0x015e, B:78:0x0161, B:79:0x0181, B:81:0x0185, B:82:0x0189, B:83:0x0192, B:117:0x0242, B:120:0x0249, B:115:0x0223, B:114:0x021c), top: B:190:0x012c }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0223 A[Catch: OutOfMemoryError -> 0x024a, all -> 0x0255, Exception -> 0x0348, FileNotFoundException -> 0x0354, TRY_LEAVE, TryCatch #1 {OutOfMemoryError -> 0x024a, blocks: (B:71:0x012e, B:72:0x0133, B:74:0x0139, B:75:0x0158, B:77:0x015e, B:78:0x0161, B:79:0x0181, B:81:0x0185, B:82:0x0189, B:83:0x0192, B:117:0x0242, B:120:0x0249, B:115:0x0223, B:114:0x021c), top: B:190:0x012c }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0242 A[Catch: IOException -> 0x0248, OutOfMemoryError -> 0x024a, all -> 0x0255, Exception -> 0x0348, FileNotFoundException -> 0x0354, TRY_ENTER, TRY_LEAVE, TryCatch #1 {OutOfMemoryError -> 0x024a, blocks: (B:71:0x012e, B:72:0x0133, B:74:0x0139, B:75:0x0158, B:77:0x015e, B:78:0x0161, B:79:0x0181, B:81:0x0185, B:82:0x0189, B:83:0x0192, B:117:0x0242, B:120:0x0249, B:115:0x0223, B:114:0x021c), top: B:190:0x012c }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0274 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0279 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0199 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x012e A[Catch: OutOfMemoryError -> 0x024a, all -> 0x0255, Exception -> 0x0348, FileNotFoundException -> 0x0354, TRY_ENTER, TryCatch #1 {OutOfMemoryError -> 0x024a, blocks: (B:71:0x012e, B:72:0x0133, B:74:0x0139, B:75:0x0158, B:77:0x015e, B:78:0x0161, B:79:0x0181, B:81:0x0185, B:82:0x0189, B:83:0x0192, B:117:0x0242, B:120:0x0249, B:115:0x0223, B:114:0x021c), top: B:190:0x012c }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0139 A[Catch: OutOfMemoryError -> 0x024a, all -> 0x0255, Exception -> 0x0348, FileNotFoundException -> 0x0354, TryCatch #1 {OutOfMemoryError -> 0x024a, blocks: (B:71:0x012e, B:72:0x0133, B:74:0x0139, B:75:0x0158, B:77:0x015e, B:78:0x0161, B:79:0x0181, B:81:0x0185, B:82:0x0189, B:83:0x0192, B:117:0x0242, B:120:0x0249, B:115:0x0223, B:114:0x021c), top: B:190:0x012c }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x015e A[Catch: OutOfMemoryError -> 0x024a, all -> 0x0255, Exception -> 0x0348, FileNotFoundException -> 0x0354, TryCatch #1 {OutOfMemoryError -> 0x024a, blocks: (B:71:0x012e, B:72:0x0133, B:74:0x0139, B:75:0x0158, B:77:0x015e, B:78:0x0161, B:79:0x0181, B:81:0x0185, B:82:0x0189, B:83:0x0192, B:117:0x0242, B:120:0x0249, B:115:0x0223, B:114:0x021c), top: B:190:0x012c }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0185 A[Catch: IOException -> 0x0248, OutOfMemoryError -> 0x024a, all -> 0x0255, Exception -> 0x0348, FileNotFoundException -> 0x0354, TryCatch #1 {OutOfMemoryError -> 0x024a, blocks: (B:71:0x012e, B:72:0x0133, B:74:0x0139, B:75:0x0158, B:77:0x015e, B:78:0x0161, B:79:0x0181, B:81:0x0185, B:82:0x0189, B:83:0x0192, B:117:0x0242, B:120:0x0249, B:115:0x0223, B:114:0x021c), top: B:190:0x012c }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File m11136b(android.content.Context r12, java.io.File r13, java.lang.String r14, android.net.Uri r15, boolean r16) {
        /*
            Method dump skipped, instructions count: 883
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3188bc.m11136b(android.content.Context, java.io.File, java.lang.String, android.net.Uri, boolean):java.io.File");
    }
}
