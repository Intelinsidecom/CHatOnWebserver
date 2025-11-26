package com.sec.chaton.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.trunk.p121c.C4641f;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/* compiled from: ChatONFileUtil.java */
/* renamed from: com.sec.chaton.util.o */
/* loaded from: classes.dex */
public class C4894o {

    /* renamed from: b */
    private static MediaScannerConnection f17853b;

    /* renamed from: c */
    private static String f17854c;

    /* renamed from: a */
    private static String f17852a = "ChatONFileUtil";

    /* renamed from: d */
    private static MediaScannerConnection.MediaScannerConnectionClient f17855d = new C4895p();

    /* renamed from: a */
    public static void m18604a() {
        File[] fileArrListFiles;
        try {
            File file = new File(CommonApplication.m18732r().getFilesDir().getAbsolutePath());
            if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        m18605a(file2);
                        if (!file2.delete()) {
                            file2.delete();
                        }
                    }
                }
            }
        } catch (Exception e) {
            C4904y.m18635a(e, f17852a);
        }
    }

    /* renamed from: a */
    public static void m18606a(String str) {
        C4904y.m18639b("deleteDirectory path: " + str, f17852a);
        try {
            File file = new File(str);
            if (file.exists()) {
                m18605a(file);
                if (!file.delete()) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            C4904y.m18635a(e, f17852a);
        }
    }

    /* renamed from: a */
    public static void m18605a(File file) {
        int length;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && (length = fileArrListFiles.length) > 0) {
            for (int i = 0; i < length; i++) {
                if (fileArrListFiles[i].isFile()) {
                    fileArrListFiles[i].delete();
                } else {
                    m18605a(fileArrListFiles[i]);
                    if (!fileArrListFiles[i].delete()) {
                        fileArrListFiles[i].delete();
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static boolean m18614b(File file) {
        return file != null && file.exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0180 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0185 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x013a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0149 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0176 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0144 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m18603a(java.lang.String r9, java.lang.String r10, java.lang.String r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 591
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C4894o.m18603a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m18607a(java.lang.String r9, java.lang.String r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 176
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C4894o.m18607a(java.lang.String, java.lang.String):void");
    }

    /* renamed from: b */
    public static String m18611b() {
        String strValueOf;
        synchronized (f17852a) {
            strValueOf = String.valueOf(System.currentTimeMillis());
            try {
                Thread.sleep(2L);
            } catch (InterruptedException e) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("getDifferentFNameByUsingSysTime() - InterruptedException", f17852a);
                }
            }
        }
        return strValueOf;
    }

    /* renamed from: a */
    public static Bitmap m18598a(Context context, File file, boolean z, boolean z2, boolean z3) {
        return m18599a(context, file, z, z2, z3, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ea A[PHI: r1 r2
  0x00ea: PHI (r1v10 java.io.FileOutputStream) = 
  (r1v15 java.io.FileOutputStream)
  (r1v5 java.io.FileOutputStream)
  (r1v20 java.io.FileOutputStream)
  (r1v21 java.io.FileOutputStream)
 binds: [B:17:0x006d, B:43:0x00e9, B:21:0x0079, B:23:0x0083] A[DONT_GENERATE, DONT_INLINE]
  0x00ea: PHI (r2v25 ??) = (r2v31 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), (r2v21 ??), (r2v22 ??), (r2v23 ??) binds: [B:17:0x006d, B:43:0x00e9, B:21:0x0079, B:23:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v21, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v22, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r3v11, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap m18599a(android.content.Context r8, java.io.File r9, boolean r10, boolean r11, boolean r12, boolean r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C4894o.m18599a(android.content.Context, java.io.File, boolean, boolean, boolean, boolean):android.graphics.Bitmap");
    }

    /* renamed from: b */
    public static String m18613b(String str) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            if (mediaPlayer != null) {
                try {
                    try {
                        mediaPlayer.reset();
                        if (!TextUtils.isEmpty(str) && str.startsWith("file:")) {
                            str = Uri.parse(str).getPath();
                        }
                        mediaPlayer.setDataSource(str);
                        mediaPlayer.prepare();
                        String strValueOf = String.valueOf(mediaPlayer.getDuration());
                        if (mediaPlayer == null) {
                            return strValueOf;
                        }
                        mediaPlayer.release();
                        return strValueOf;
                    } catch (IOException e) {
                        C4904y.m18635a(e, f17852a);
                        if (mediaPlayer != null) {
                        }
                    } catch (IllegalStateException e2) {
                        C4904y.m18635a(e2, f17852a);
                        if (mediaPlayer != null) {
                        }
                    }
                } catch (IllegalArgumentException e3) {
                    C4904y.m18635a(e3, f17852a);
                    if (mediaPlayer != null) {
                    }
                } catch (SecurityException e4) {
                    C4904y.m18635a(e4, f17852a);
                    if (mediaPlayer != null) {
                    }
                }
            } else if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            return null;
        } catch (Throwable th) {
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0031 A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m18609a(com.sec.chaton.p057e.EnumC2214ab r3, java.lang.String r4) {
        /*
            r0 = 1
            int[] r1 = com.sec.chaton.util.C4898s.f17858a
            int r2 = r3.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto Ld;
                case 2: goto L33;
                case 3: goto L4f;
                case 4: goto L4f;
                case 5: goto L58;
                default: goto Lc;
            }
        Lc:
            return r0
        Ld:
            java.lang.String r1 = "JPEG"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto Lc
            java.lang.String r1 = "JPG"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto Lc
            java.lang.String r1 = "PNG"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto Lc
            java.lang.String r1 = "GIF"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto Lc
        L31:
            r0 = 0
            goto Lc
        L33:
            java.lang.String r1 = "MP4"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto Lc
            java.lang.String r1 = "3GP"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto Lc
            java.lang.String r1 = "WMV"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 == 0) goto L31
            goto Lc
        L4f:
            com.sec.chaton.multimedia.doc.b r1 = com.sec.chaton.multimedia.doc.FileExplorerActivity.m11580c(r4)
            com.sec.chaton.multimedia.doc.b r2 = com.sec.chaton.multimedia.doc.EnumC2758b.UNKNOWN
            if (r1 == r2) goto L31
            goto Lc
        L58:
            java.lang.String r1 = "3GP"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto Lc
            java.lang.String r1 = "3GA"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto Lc
            java.lang.String r1 = "M4A"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto Lc
            java.lang.String r1 = "AMR"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 == 0) goto L31
            goto Lc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C4894o.m18609a(com.sec.chaton.e.ab, java.lang.String):boolean");
    }

    /* renamed from: a */
    public static EnumC4900u m18601a(File file, EnumC2214ab enumC2214ab, Context context) {
        if (file == null) {
            return EnumC4900u.ERROR;
        }
        if (!C4822an.m18219a(file) && file.length() > 31457280) {
            if (context != null) {
                C5179v.m19811a(context, CommonApplication.m18732r().getString(R.string.maximum_file_size_exceeded, 30L), 0).show();
            }
            return EnumC4900u.ERROR_SIZE;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(file.getName(), ".");
        String strNextToken = null;
        while (stringTokenizer.hasMoreTokens()) {
            strNextToken = stringTokenizer.nextToken();
        }
        if (enumC2214ab == EnumC2214ab.AMS) {
            strNextToken = "jpg";
        }
        if (!m18609a(enumC2214ab, strNextToken)) {
            if (context != null) {
                AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(context);
                abstractC4932aM18733a.mo18734a(R.string.pop_up_attention).mo18746b(R.string.toast_supported_format).mo18756d(R.string.alert_dialog_ok, null);
                abstractC4932aM18733a.mo18745a().show();
            }
            return EnumC4900u.ERROR_EXTENSION;
        }
        return EnumC4900u.NORMAL;
    }

    /* renamed from: c */
    public static C4899t m18615c(String str) {
        return m18600a(Uri.parse(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* renamed from: a */
    public static C4899t m18600a(Uri uri) throws Throwable {
        String str;
        String string;
        BufferedOutputStream bufferedOutputStream;
        Cursor cursor = null;
         = 0;
         = 0;
        ?? r6 = 0;
        try {
            ?? Query = GlobalApplication.m18732r().getContentResolver().query(uri, null, null, null, null);
            if (Query != 0) {
                String string2 = null;
                string = null;
                while (Query.moveToNext()) {
                    try {
                        int columnIndex = Query.getColumnIndex("_data");
                        int columnIndex2 = Query.getColumnIndex("mime_type");
                        if (columnIndex != -1) {
                            string = Query.getString(columnIndex);
                        }
                        if (columnIndex2 != -1) {
                            string2 = Query.getString(columnIndex2);
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = Query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                str = string2;
            } else {
                str = null;
                string = null;
            }
            if (Query != 0) {
                Query.close();
            }
            if (!TextUtils.isEmpty(string) && string.startsWith("/")) {
                return new C4899t(new File(string), str);
            }
            ContentResolver contentResolver = GlobalApplication.m18732r().getContentResolver();
            BufferedInputStream bufferedInputStream = null;
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    try {
                        Query = contentResolver.openInputStream(uri);
                        try {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeStream(Query, null, options);
                            if (!TextUtils.isEmpty(options.outMimeType)) {
                                StringTokenizer stringTokenizer = new StringTokenizer(options.outMimeType, "/");
                                String strNextToken = null;
                                while (stringTokenizer.hasMoreTokens()) {
                                    strNextToken = stringTokenizer.nextToken();
                                }
                                if (strNextToken != null) {
                                    File file = new File(GlobalApplication.m18732r().getExternalCacheDir().getAbsolutePath() + "/tempImage." + strNextToken);
                                    bufferedInputStream = new BufferedInputStream(contentResolver.openInputStream(uri));
                                    try {
                                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                                    } catch (FileNotFoundException e) {
                                        e = e;
                                        bufferedOutputStream = null;
                                    } catch (IOException e2) {
                                        e = e2;
                                        bufferedOutputStream = null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (r6 != 0) {
                                            try {
                                                r6.close();
                                            } catch (IOException e3) {
                                                throw th;
                                            }
                                        }
                                        if (bufferedInputStream != null) {
                                            bufferedInputStream.close();
                                        }
                                        if (Query != 0) {
                                            Query.close();
                                        }
                                        throw th;
                                    }
                                    try {
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int i = bufferedInputStream.read(bArr, 0, 1024);
                                            if (i == -1) {
                                                break;
                                            }
                                            bufferedOutputStream.write(bArr, 0, i);
                                        }
                                        C4899t c4899t = new C4899t(file, str);
                                        if (bufferedOutputStream != null) {
                                            try {
                                                bufferedOutputStream.close();
                                            } catch (IOException e4) {
                                                return c4899t;
                                            }
                                        }
                                        if (bufferedInputStream != null) {
                                            bufferedInputStream.close();
                                        }
                                        if (Query == 0) {
                                            return c4899t;
                                        }
                                        Query.close();
                                        return c4899t;
                                    } catch (FileNotFoundException e5) {
                                        e = e5;
                                        if (C4904y.f17875e) {
                                            C4904y.m18635a(e, f17852a);
                                        }
                                        if (bufferedOutputStream != null) {
                                            bufferedOutputStream.close();
                                        }
                                        if (bufferedInputStream != null) {
                                            bufferedInputStream.close();
                                        }
                                        if (Query != 0) {
                                            Query.close();
                                        }
                                        return null;
                                    } catch (IOException e6) {
                                        e = e6;
                                        if (C4904y.f17875e) {
                                            C4904y.m18635a(e, f17852a);
                                        }
                                        if (bufferedOutputStream != null) {
                                            bufferedOutputStream.close();
                                        }
                                        if (bufferedInputStream != null) {
                                            bufferedInputStream.close();
                                        }
                                        if (Query != 0) {
                                            Query.close();
                                        }
                                        return null;
                                    }
                                }
                            }
                            if (0 != 0) {
                                bufferedOutputStream2.close();
                            }
                            if (0 != 0) {
                                bufferedInputStream.close();
                            }
                            if (Query != 0) {
                                Query.close();
                            }
                        } catch (FileNotFoundException e7) {
                            e = e7;
                            bufferedOutputStream = null;
                            bufferedInputStream = null;
                        } catch (IOException e8) {
                            e = e8;
                            bufferedOutputStream = null;
                            bufferedInputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedInputStream = null;
                        }
                    } catch (FileNotFoundException e9) {
                        e = e9;
                        Query = 0;
                        bufferedOutputStream = null;
                        bufferedInputStream = null;
                    } catch (IOException e10) {
                        e = e10;
                        Query = 0;
                        bufferedOutputStream = null;
                        bufferedInputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        Query = 0;
                        bufferedInputStream = null;
                    }
                } catch (IOException e11) {
                }
                return null;
            } catch (Throwable th5) {
                th = th5;
                r6 = contentResolver;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0102: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:77:0x0102 */
    /* renamed from: b */
    public static File m18610b(Uri uri) throws Throwable {
        InputStream inputStreamOpenInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        BufferedOutputStream bufferedOutputStream3 = null;
        ContentResolver contentResolver = GlobalApplication.m18732r().getContentResolver();
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream4 = null;
        try {
            try {
                inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                    if (!TextUtils.isEmpty(options.outMimeType)) {
                        StringTokenizer stringTokenizer = new StringTokenizer(options.outMimeType, "/");
                        String strNextToken = null;
                        while (stringTokenizer.hasMoreTokens()) {
                            strNextToken = stringTokenizer.nextToken();
                        }
                        if (strNextToken != null) {
                            File file = new File(GlobalApplication.m18732r().getExternalCacheDir().getAbsolutePath() + "/tempImage." + strNextToken);
                            bufferedInputStream = new BufferedInputStream(contentResolver.openInputStream(uri));
                            try {
                                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                            } catch (FileNotFoundException e) {
                                e = e;
                                bufferedOutputStream = null;
                            } catch (IOException e2) {
                                e = e2;
                                bufferedOutputStream = null;
                            } catch (Throwable th) {
                                th = th;
                                if (bufferedOutputStream3 != null) {
                                    try {
                                        bufferedOutputStream3.close();
                                    } catch (IOException e3) {
                                        throw th;
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (inputStreamOpenInputStream != null) {
                                    inputStreamOpenInputStream.close();
                                }
                                throw th;
                            }
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i = bufferedInputStream.read(bArr, 0, 1024);
                                    if (i == -1) {
                                        break;
                                    }
                                    bufferedOutputStream.write(bArr, 0, i);
                                }
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (IOException e4) {
                                        return file;
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (inputStreamOpenInputStream == null) {
                                    return file;
                                }
                                inputStreamOpenInputStream.close();
                                return file;
                            } catch (FileNotFoundException e5) {
                                e = e5;
                                if (C4904y.f17875e) {
                                    C4904y.m18635a(e, f17852a);
                                }
                                if (bufferedOutputStream != null) {
                                    bufferedOutputStream.close();
                                }
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (inputStreamOpenInputStream != null) {
                                    inputStreamOpenInputStream.close();
                                }
                                return null;
                            } catch (IOException e6) {
                                e = e6;
                                if (C4904y.f17875e) {
                                    C4904y.m18635a(e, f17852a);
                                }
                                if (bufferedOutputStream != null) {
                                    bufferedOutputStream.close();
                                }
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (inputStreamOpenInputStream != null) {
                                    inputStreamOpenInputStream.close();
                                }
                                return null;
                            }
                        }
                    }
                    if (0 != 0) {
                        bufferedOutputStream4.close();
                    }
                    if (0 != 0) {
                        bufferedInputStream.close();
                    }
                    if (inputStreamOpenInputStream != null) {
                        inputStreamOpenInputStream.close();
                    }
                } catch (FileNotFoundException e7) {
                    e = e7;
                    bufferedOutputStream = null;
                    bufferedInputStream = null;
                } catch (IOException e8) {
                    e = e8;
                    bufferedOutputStream = null;
                    bufferedInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = null;
                }
            } catch (FileNotFoundException e9) {
                e = e9;
                inputStreamOpenInputStream = null;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            } catch (IOException e10) {
                e = e10;
                inputStreamOpenInputStream = null;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                inputStreamOpenInputStream = null;
                bufferedInputStream = null;
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream3 = bufferedOutputStream2;
        }
    }

    /* renamed from: b */
    public static String m18612b(EnumC2214ab enumC2214ab, String str) {
        String strNextToken;
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            strNextToken = null;
            while (stringTokenizer.hasMoreTokens()) {
                strNextToken = stringTokenizer.nextToken();
            }
            if (enumC2214ab == EnumC2214ab.AMS) {
                strNextToken = "jpg";
            }
        } else {
            strNextToken = null;
        }
        switch (C4898s.f17858a[enumC2214ab.ordinal()]) {
            case 1:
            case 2:
            case 6:
                if (strNextToken != null) {
                    break;
                }
                break;
            case 3:
            case 4:
                if (strNextToken != null) {
                    break;
                }
                break;
            case 5:
                if (!"3GP".equalsIgnoreCase(strNextToken) && !"3GA".equalsIgnoreCase(strNextToken) && !"M4A".equalsIgnoreCase(strNextToken)) {
                    if ("AMR".equalsIgnoreCase(strNextToken)) {
                    }
                }
                break;
        }
        return null;
    }

    /* renamed from: a */
    public static AbstractC4932a m18602a(Context context, DialogInterface.OnClickListener onClickListener) {
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_share_noti, (ViewGroup) null);
        C4809aa.m18104a().m18125b("file_upload_warning_check", (Boolean) true);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.checkbox_never_show_again);
        checkBox.setChecked(true);
        checkBox.setOnClickListener(new ViewOnClickListenerC4896q(checkBox));
        ((TextView) viewInflate.findViewById(R.id.notice_contents)).setText(R.string.hugefile_waring_message);
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(context);
        abstractC4932aM18733a.mo18742a(true);
        abstractC4932aM18733a.mo18748b(viewInflate);
        abstractC4932aM18733a.mo18734a(R.string.hugefile_sending_file);
        abstractC4932aM18733a.mo18756d(R.string.dialog_ok, onClickListener);
        abstractC4932aM18733a.mo18747b(R.string.dialog_cancel, (DialogInterface.OnClickListener) null);
        abstractC4932aM18733a.mo18751b(false);
        return abstractC4932aM18733a;
    }

    /* renamed from: c */
    public static String m18616c() {
        return (C4873ck.m18500a() ? CommonApplication.m18732r().getExternalFilesDir(null).getAbsolutePath() : CommonApplication.m18732r().getFilesDir().getAbsolutePath()) + "/AMS/amsuserfiles/";
    }

    /* renamed from: d */
    public static ArrayList<String> m18618d() {
        String[] list;
        String strM18616c = m18616c();
        File file = new File(strM18616c);
        if (file.exists() && (list = file.list()) != null) {
            m18608a(strM18616c, list);
            ArrayList<String> arrayList = new ArrayList<>();
            if (list != null && list.length > 0) {
                for (String str : list) {
                    String str2 = strM18616c + str;
                    if (new File(str2).exists() && C4641f.m17617b(str2)) {
                        arrayList.add(str2);
                    }
                }
                if (arrayList.size() > 0) {
                    return arrayList;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m18608a(String str, String[] strArr) {
        Arrays.sort(strArr, new C4897r(str));
    }

    /* renamed from: d */
    public static File m18617d(String str) {
        String strM18616c = m18616c();
        if (strM18616c != null) {
            return new File(strM18616c, str);
        }
        return null;
    }
}
