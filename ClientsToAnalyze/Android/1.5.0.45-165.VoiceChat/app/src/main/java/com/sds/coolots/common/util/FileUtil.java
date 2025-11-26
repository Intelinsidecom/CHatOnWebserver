package com.sds.coolots.common.util;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public final class FileUtil {
    public static final int AUDIO_FILE = 2;
    public static final int IMAGE_FILE = 1;
    public static final String NOMEDIA_NAME = ".nomedia";
    public static final String RECORDING_EXT = "3gp";
    public static final String RECORDING_PREFIX = "REC";
    public static final String RECORDING_SHARE_SCREEN_PREFIX = "SHARE_SCREEN";
    public static final String RECORDING_VIDEO_PRIFIX = "REC_VIDEO";
    public static final String RECORDING_VOICE_PREFIX = "REC_VOICE";
    public static final int REC_VIDEO_FILE = 4;
    public static final int REC_VOICE_FILE = 3;
    public static final int TRANSPORT_FILE_SIZE_LIMIT = 51200;
    public static final int VIDEO_FILE = 0;
    public static final String SDCARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String VIDEO_SAVE_PATH = String.valueOf(SDCARD_ROOT) + File.separator + "DCIM" + File.separator + "ChatON";
    public static final String SCREENSHARE_SAVE_PATH = String.valueOf(VIDEO_SAVE_PATH) + File.separator + "ChatONV";
    public static final String SAVE_PATH = String.valueOf(SDCARD_ROOT) + File.separator + "My files" + File.separator + "Sounds";
    public static final String[] IMAGE_FILE_EXT = {".png", ".gif", ".jpg", ".jpeg", ".bmp"};
    public static final String[] VIDEO_FILE_EXT = {".wmv", ".avi", ".mpg", ".mpeg", ".mp4"};
    public static final String[] AUDIO_FILE_EXT = {".amr", ".mp3", ".wav", ".ogg", ".midi"};
    public static final String[] ALL_FILE_EXT = {".amr", ".mp3", ".wav", ".ogg", ".midi", ".wmv", ".avi", ".mpg", ".mpeg", ".mp4", ".png", ".gif", ".jpg", ".jpeg", ".bmp"};

    private FileUtil() {
    }

    /* renamed from: a */
    private static boolean m2951a() {
        String str = String.valueOf(Environment.getExternalStorageDirectory().toString()) + "/DCIM";
        File file = new File(str);
        if (!file.isDirectory() && !file.mkdirs()) {
            return false;
        }
        File file2 = new File(str, ".probe");
        try {
            if (file2.exists()) {
                file2.delete();
            }
            if (!file2.createNewFile()) {
                return false;
            }
            file2.delete();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean checkSDCardStatus(boolean z) {
        String externalStorageState = Environment.getExternalStorageState();
        if (!"mounted".equals(externalStorageState)) {
            return !z && "mounted_ro".equals(externalStorageState);
        }
        if (z) {
            return m2951a();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean fileCopy(java.lang.String r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            r3 = 0
            r0 = 0
            java.io.File r5 = new java.io.File
            r5.<init>(r7)
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L91
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L91
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L94
            r2.<init>(r8)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L94
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L8c
        L15:
            r3 = 0
            r6 = 1024(0x400, float:1.435E-42)
            int r3 = r4.read(r1, r3, r6)     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L8c
            r6 = -1
            if (r3 != r6) goto L48
            if (r2 == 0) goto L24
            r2.close()     // Catch: java.io.IOException -> L7f
        L24:
            if (r4 == 0) goto L29
            r4.close()     // Catch: java.io.IOException -> L84
        L29:
            java.io.File r1 = new java.io.File
            r1.<init>(r8)
            boolean r2 = r1.exists()
            if (r2 == 0) goto L47
            boolean r2 = r1.isFile()
            if (r2 == 0) goto L47
            long r2 = r5.length()
            long r4 = r1.length()
            int r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r1 != 0) goto L47
            r0 = 1
        L47:
            return r0
        L48:
            r6 = 0
            r2.write(r1, r6, r3)     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L8c
            goto L15
        L4d:
            r1 = move-exception
            r3 = r4
        L4f:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L8e
            if (r2 == 0) goto L57
            r2.close()     // Catch: java.io.IOException -> L62
        L57:
            if (r3 == 0) goto L29
            r3.close()     // Catch: java.io.IOException -> L5d
            goto L29
        L5d:
            r1 = move-exception
            r1.printStackTrace()
            goto L29
        L62:
            r1 = move-exception
            r1.printStackTrace()
            goto L57
        L67:
            r0 = move-exception
            r2 = r3
            r4 = r3
        L6a:
            if (r2 == 0) goto L6f
            r2.close()     // Catch: java.io.IOException -> L75
        L6f:
            if (r4 == 0) goto L74
            r4.close()     // Catch: java.io.IOException -> L7a
        L74:
            throw r0
        L75:
            r1 = move-exception
            r1.printStackTrace()
            goto L6f
        L7a:
            r1 = move-exception
            r1.printStackTrace()
            goto L74
        L7f:
            r1 = move-exception
            r1.printStackTrace()
            goto L24
        L84:
            r1 = move-exception
            r1.printStackTrace()
            goto L29
        L89:
            r0 = move-exception
            r2 = r3
            goto L6a
        L8c:
            r0 = move-exception
            goto L6a
        L8e:
            r0 = move-exception
            r4 = r3
            goto L6a
        L91:
            r1 = move-exception
            r2 = r3
            goto L4f
        L94:
            r1 = move-exception
            r2 = r3
            r3 = r4
            goto L4f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sds.coolots.common.util.FileUtil.fileCopy(java.lang.String, java.lang.String):boolean");
    }

    public static String getContents(String str) {
        return String.valueOf(parsingFilePath(str)) + "," + new File(str).length();
    }

    public static String getFileExt(String str) {
        String str2 = "";
        for (int i = 0; i < ALL_FILE_EXT.length; i++) {
            if (str.endsWith(ALL_FILE_EXT[i])) {
                str2 = ALL_FILE_EXT[i];
            }
        }
        return str2;
    }

    public static String getFilePath(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        String[] strArr = new String[2];
        while (stringTokenizer.hasMoreTokens()) {
            strArr[0] = stringTokenizer.nextToken();
            strArr[1] = stringTokenizer.nextToken();
        }
        return strArr[0];
    }

    public static String getFileSize(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        String[] strArr = new String[2];
        while (stringTokenizer.hasMoreTokens()) {
            strArr[0] = stringTokenizer.nextToken();
            strArr[1] = stringTokenizer.nextToken();
        }
        return strArr[1];
    }

    public static String[] getFileTransportInfo(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        String[] strArr = new String[2];
        while (stringTokenizer.hasMoreTokens()) {
            strArr[0] = stringTokenizer.nextToken();
            strArr[1] = stringTokenizer.nextToken();
        }
        return strArr;
    }

    public static int getFileType(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        String[] strArr = new String[2];
        while (stringTokenizer.hasMoreTokens()) {
            strArr[0] = stringTokenizer.nextToken();
            strArr[1] = stringTokenizer.nextToken();
        }
        if (strArr[0].endsWith("avi") || strArr[0].endsWith("mpg") || strArr[0].endsWith("mpeg") || strArr[0].endsWith("wmv") || strArr[0].endsWith("mp4")) {
            return 0;
        }
        if (strArr[0].endsWith("jpg") || strArr[0].endsWith("jpeg") || strArr[0].endsWith("png") || strArr[0].endsWith("bmp") || strArr[0].endsWith("gif")) {
            return 1;
        }
        return (strArr[0].endsWith("amr") || strArr[0].endsWith("mp3")) ? 2 : -1;
    }

    public static boolean isBytesAvailableofSDCard() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        Log.m2954d("stat.getAvailableBlocks() : " + statFs.getAvailableBlocks());
        Log.m2954d("stat.getBlockSize() : " + statFs.getBlockSize());
        Log.m2963i("minBlockCount: 3000");
        return statFs.getAvailableBlocks() >= 3000;
    }

    public static boolean makeNoMediaFile(String str) {
        if (!new File(str).exists()) {
            Log.m2963i("the path doesn't exist !!!");
            return false;
        }
        File file = new File(String.valueOf(str) + NOMEDIA_NAME);
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    return false;
                }
                if (!file.exists()) {
                    return false;
                }
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    public static String parsingFilePath(String str) {
        return str.replaceAll(SDCARD_ROOT, "");
    }

    public static boolean statusOfSDCard() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
