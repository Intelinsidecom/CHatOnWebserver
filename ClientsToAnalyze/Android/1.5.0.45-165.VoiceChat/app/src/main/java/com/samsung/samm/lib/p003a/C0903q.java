package com.samsung.samm.lib.p003a;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/* renamed from: com.samsung.samm.lib.a.q */
/* loaded from: classes.dex */
public class C0903q {
    /* renamed from: a */
    public static String m585a(String str) {
        int iLastIndexOf = str.lastIndexOf(".");
        if (iLastIndexOf <= 0) {
            return null;
        }
        return str.substring(iLastIndexOf + 1);
    }

    /* renamed from: b */
    public static String m594b(String str) {
        return new File(str).getName();
    }

    /* renamed from: c */
    public static boolean m598c(String str) {
        File file = new File(str);
        return m588a(file) && file.delete();
    }

    /* renamed from: a */
    public static boolean m588a(File file) {
        if (!file.exists()) {
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        int length = fileArrListFiles.length;
        if (length <= 0) {
            return true;
        }
        boolean zDelete = false;
        for (int i = 0; i < length; i++) {
            if (fileArrListFiles[i].isFile()) {
                zDelete = fileArrListFiles[i].delete();
            } else {
                m588a(fileArrListFiles[i]);
            }
        }
        return zDelete;
    }

    /* renamed from: d */
    public static void m599d(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.isFile() && !file.delete()) {
                Log.e("Tool_FileManage_Utils", "Delete File Error");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* renamed from: a */
    public static boolean m590a(String str, String str2, boolean z) throws Throwable {
        FileChannel fileChannel;
        FileChannel fileChannel2;
        boolean z2;
        FileChannel channel;
        FileChannel channel2 = null;
        if (str == null || str2 == null) {
            return false;
        }
        File file = new File(str);
        File file2 = new File(str2.substring(0, str2.lastIndexOf("/")));
        if (!file2.exists()) {
            if (!z) {
                return false;
            }
            if (!file2.mkdirs()) {
                Log.e("Tool_FileManage_Utils", "FileCopy Error : Can't make outpath directory");
                return false;
            }
        }
        FileChannel fileChannelExists = file.exists();
        if (fileChannelExists != 0) {
            try {
                if (file.canRead()) {
                    try {
                        channel = new FileInputStream(str).getChannel();
                    } catch (FileNotFoundException e) {
                        e = e;
                        fileChannel2 = null;
                    } catch (IOException e2) {
                        e = e2;
                        fileChannel = null;
                    } catch (Throwable th) {
                        th = th;
                        fileChannelExists = 0;
                    }
                    try {
                        channel2 = new FileOutputStream(str2).getChannel();
                        channel.transferTo(0L, channel.size(), channel2);
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (channel2 != null) {
                            try {
                                channel2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        return true;
                    } catch (FileNotFoundException e5) {
                        fileChannel2 = channel;
                        e = e5;
                        e.printStackTrace();
                        Log.e("Tool_FileManage_Utils", "FileCopy Error : " + e.toString());
                        if (fileChannel2 != null) {
                            try {
                                fileChannel2.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (channel2 != null) {
                            try {
                                channel2.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        z2 = false;
                        fileChannelExists = fileChannel2;
                        return z2;
                    } catch (IOException e8) {
                        fileChannel = channel;
                        e = e8;
                        e.printStackTrace();
                        Log.e("Tool_FileManage_Utils", "FileCopy Error : " + e.toString());
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        if (channel2 != null) {
                            try {
                                channel2.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        z2 = false;
                        fileChannelExists = fileChannel;
                        return z2;
                    } catch (Throwable th2) {
                        fileChannelExists = channel;
                        th = th2;
                        if (fileChannelExists != 0) {
                            try {
                                fileChannelExists.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                        if (channel2 != null) {
                            try {
                                channel2.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m589a(java.io.RandomAccessFile r8, java.lang.String r9, int r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.samm.lib.p003a.C0903q.m589a(java.io.RandomAccessFile, java.lang.String, int):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m596b(java.io.RandomAccessFile r6, java.lang.String r7, int r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.samm.lib.p003a.C0903q.m596b(java.io.RandomAccessFile, java.lang.String, int):boolean");
    }

    /* renamed from: a */
    public static long m583a(RandomAccessFile randomAccessFile) {
        long j = 0;
        int i = 0;
        while (i < 8) {
            try {
                long unsignedByte = (randomAccessFile.readUnsignedByte() << (i * 8)) + j;
                i++;
                j = unsignedByte;
            } catch (IOException e) {
                Log.e("Tool_FileManage_Utils", "readIntData IOException : " + e);
                e.printStackTrace();
                return -1L;
            }
        }
        return j;
    }

    /* renamed from: b */
    public static int m591b(RandomAccessFile randomAccessFile) {
        int i = 0;
        int i2 = 0;
        while (i2 < 4) {
            try {
                int unsignedByte = (randomAccessFile.readUnsignedByte() << (i2 * 8)) + i;
                i2++;
                i = unsignedByte;
            } catch (IOException e) {
                Log.e("Tool_FileManage_Utils", "readIntData IOException : " + e);
                e.printStackTrace();
                return -1;
            }
        }
        return i;
    }

    /* renamed from: c */
    public static int m597c(RandomAccessFile randomAccessFile) throws IOException {
        try {
            return randomAccessFile.readUnsignedByte() + (randomAccessFile.readUnsignedByte() << 8);
        } catch (IOException e) {
            Log.e("Tool_FileManage_Utils", "readIntData IOException : " + e);
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    public static void m587a(RandomAccessFile randomAccessFile, long j) throws IOException {
        for (int i = 0; i < 8; i++) {
            try {
                randomAccessFile.writeByte((byte) (j >> (i * 8)));
            } catch (IOException e) {
                Log.e("Tool_FileManage_Utils", "writeIntData IOException : " + e);
                e.printStackTrace();
                return;
            }
        }
    }

    /* renamed from: a */
    public static void m586a(RandomAccessFile randomAccessFile, int i) throws IOException {
        for (int i2 = 0; i2 < 4; i2++) {
            try {
                randomAccessFile.writeByte((byte) (i >> (i2 * 8)));
            } catch (IOException e) {
                Log.e("Tool_FileManage_Utils", "writeIntData IOException : " + e);
                e.printStackTrace();
                return;
            }
        }
    }

    /* renamed from: b */
    public static void m595b(RandomAccessFile randomAccessFile, int i) throws IOException {
        try {
            randomAccessFile.writeByte(i & 255);
            randomAccessFile.writeByte((i >> 8) & 255);
        } catch (IOException e) {
            Log.e("Tool_FileManage_Utils", "writeShortData IOException : " + e);
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.RandomAccessFile] */
    /* renamed from: e */
    public static int m600e(String str) throws Throwable {
        ?? CanRead;
        RandomAccessFile randomAccessFile;
        int length = -1;
        if (str != null) {
            File file = new File(str);
            if (file.exists() && (CanRead = file.canRead()) != 0) {
                ?? r3 = 0;
                r3 = 0;
                r3 = 0;
                r3 = 0;
                try {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    try {
                        randomAccessFile = new RandomAccessFile(file, "r");
                        try {
                            length = (int) randomAccessFile.length();
                            CanRead = randomAccessFile;
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                    CanRead = randomAccessFile;
                                } catch (IOException e) {
                                    String str2 = "getFileSize IOException : " + e;
                                    Log.e("Tool_FileManage_Utils", str2);
                                    e.printStackTrace();
                                    CanRead = "Tool_FileManage_Utils";
                                    r3 = str2;
                                }
                            }
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            String str3 = "Tool_FileManage_Utils";
                            Log.e("Tool_FileManage_Utils", "getFileSize FileNotFoundException : " + e);
                            e.printStackTrace();
                            CanRead = randomAccessFile;
                            r3 = str3;
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                    CanRead = randomAccessFile;
                                    r3 = str3;
                                } catch (IOException e3) {
                                    String str4 = "getFileSize IOException : " + e3;
                                    Log.e("Tool_FileManage_Utils", str4);
                                    e3.printStackTrace();
                                    CanRead = "Tool_FileManage_Utils";
                                    r3 = str4;
                                }
                            }
                            return length;
                        } catch (IOException e4) {
                            e = e4;
                            r3 = randomAccessFile;
                            Log.e("Tool_FileManage_Utils", "getFileSize IOException : " + e);
                            e.printStackTrace();
                            if (r3 != 0) {
                                try {
                                    r3.close();
                                } catch (IOException e5) {
                                    r3 = "getFileSize IOException : " + e5;
                                    Log.e("Tool_FileManage_Utils", r3);
                                    e5.printStackTrace();
                                }
                            }
                            return length;
                        }
                    } catch (FileNotFoundException e6) {
                        e = e6;
                        randomAccessFile = null;
                    } catch (IOException e7) {
                        e = e7;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r3 = CanRead;
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (IOException e8) {
                            Log.e("Tool_FileManage_Utils", "getFileSize IOException : " + e8);
                            e8.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        }
        return length;
    }

    /* renamed from: a */
    public static String m584a() {
        return Long.toString(System.currentTimeMillis());
    }

    /* renamed from: a */
    public static int m580a(byte[] bArr, int i, byte[] bArr2) {
        int i2 = 0;
        int i3 = i;
        while (i2 < bArr2.length && i < bArr.length) {
            bArr[i3] = bArr2[i2];
            i2++;
            i3++;
        }
        return i3;
    }

    /* renamed from: a */
    public static int m579a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < 4) {
            bArr[i] = (byte) (i2 >> (i3 * 8));
            i3++;
            i++;
        }
        return i;
    }

    /* renamed from: b */
    public static int m592b(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < 2) {
            bArr[i] = (byte) (i2 >> (i3 * 8));
            i3++;
            i++;
        }
        return i;
    }

    /* renamed from: a */
    public static int m582a(byte[] bArr, int i, byte[][] bArr2) {
        int i2 = 0;
        while (i2 < bArr2[0].length && i < bArr.length) {
            bArr2[0][i2] = bArr[i];
            i2++;
            i++;
        }
        return i;
    }

    /* renamed from: a */
    public static int m581a(byte[] bArr, int i, int[] iArr) {
        iArr[0] = 0;
        int i2 = 0;
        while (i2 < 4) {
            iArr[0] = iArr[0] + ((bArr[i] & 255) << (i2 * 8));
            i2++;
            i++;
        }
        return i;
    }

    /* renamed from: b */
    public static int m593b(byte[] bArr, int i, int[] iArr) {
        iArr[0] = 0;
        int i2 = 0;
        while (i2 < 2) {
            iArr[0] = iArr[0] + ((bArr[i] & 255) << (i2 * 8));
            i2++;
            i++;
        }
        return i;
    }

    /* renamed from: f */
    public static boolean m601f(String str) {
        if (str == null) {
            return false;
        }
        return new File(str).isFile();
    }
}
