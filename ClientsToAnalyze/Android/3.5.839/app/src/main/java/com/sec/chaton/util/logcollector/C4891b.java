package com.sec.chaton.util.logcollector;

import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* compiled from: LogcatDump.java */
/* renamed from: com.sec.chaton.util.logcollector.b */
/* loaded from: classes.dex */
public class C4891b {
    /* renamed from: a */
    public static void m18561a(Context context, String str, String str2, boolean z) throws IOException {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (!m18563a(context, str, str2, true, z)) {
            m18563a(context, str, str2, false, z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b7 A[Catch: IOException -> 0x00cc, TryCatch #5 {IOException -> 0x00cc, blocks: (B:28:0x00b2, B:30:0x00b7, B:32:0x00bc, B:34:0x00c1), top: B:61:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bc A[Catch: IOException -> 0x00cc, TryCatch #5 {IOException -> 0x00cc, blocks: (B:28:0x00b2, B:30:0x00b7, B:32:0x00bc, B:34:0x00c1), top: B:61:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c1 A[Catch: IOException -> 0x00cc, TRY_LEAVE, TryCatch #5 {IOException -> 0x00cc, blocks: (B:28:0x00b2, B:30:0x00b7, B:32:0x00bc, B:34:0x00c1), top: B:61:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m18563a(android.content.Context r10, java.lang.String r11, java.lang.String r12, boolean r13, boolean r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.logcollector.C4891b.m18563a(android.content.Context, java.lang.String, java.lang.String, boolean, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m18560a(android.content.Context r10) throws java.io.IOException {
        /*
            r7 = 1
            r0 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.io.FileNotFoundException -> L41 java.io.IOException -> L43
            java.lang.String r1 = "chaton_log_dump.txt"
            java.io.File r1 = r10.getFileStreamPath(r1)     // Catch: java.io.FileNotFoundException -> L41 java.io.IOException -> L43
            java.lang.String r3 = "r"
            r2.<init>(r1, r3)     // Catch: java.io.FileNotFoundException -> L41 java.io.IOException -> L43
            long r3 = r2.length()     // Catch: java.io.FileNotFoundException -> L41 java.io.IOException -> L53
            long r3 = r3 - r7
            r2.seek(r3)     // Catch: java.io.FileNotFoundException -> L41 java.io.IOException -> L53
            long r3 = r2.getFilePointer()     // Catch: java.io.FileNotFoundException -> L41 java.io.IOException -> L53
        L1e:
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L36
            int r1 = r2.read()     // Catch: java.io.FileNotFoundException -> L41 java.io.IOException -> L59
            r5 = 13
            if (r1 == r5) goto L30
            r5 = 10
            if (r1 != r5) goto L3c
        L30:
            java.lang.String r0 = r2.readLine()     // Catch: java.io.FileNotFoundException -> L41 java.io.IOException -> L59
            if (r0 == 0) goto L3c
        L36:
            if (r2 == 0) goto L3b
            r2.close()     // Catch: java.io.IOException -> L4e
        L3b:
            return r0
        L3c:
            long r3 = r3 - r7
            r2.seek(r3)     // Catch: java.io.FileNotFoundException -> L41 java.io.IOException -> L59
            goto L1e
        L41:
            r1 = move-exception
            goto L3b
        L43:
            r1 = move-exception
            r2 = r0
            r9 = r0
            r0 = r1
            r1 = r9
        L48:
            r0.printStackTrace()
            r0 = r2
            r2 = r1
            goto L36
        L4e:
            r1 = move-exception
            r1.printStackTrace()
            goto L3b
        L53:
            r1 = move-exception
            r9 = r1
            r1 = r2
            r2 = r0
            r0 = r9
            goto L48
        L59:
            r1 = move-exception
            r9 = r1
            r1 = r2
            r2 = r0
            r0 = r9
            goto L48
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.logcollector.C4891b.m18560a(android.content.Context):java.lang.String");
    }

    /* renamed from: a */
    public static boolean m18562a(Context context, File file) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(context.getFileStreamPath("chaton_log_dump.txt")));
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            bufferedWriter.append((CharSequence) line);
                            bufferedWriter.newLine();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        bufferedReader.close();
                        try {
                            bufferedWriter.close();
                            return true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return false;
                    }
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                return false;
            }
        } catch (FileNotFoundException e5) {
            e5.printStackTrace();
            return false;
        }
    }
}
