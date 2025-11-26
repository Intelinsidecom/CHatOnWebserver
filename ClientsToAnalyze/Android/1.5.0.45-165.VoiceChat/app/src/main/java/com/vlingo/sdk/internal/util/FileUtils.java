package com.vlingo.sdk.internal.util;

import com.vlingo.sdk.internal.logging.Logger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class FileUtils {
    private static final Logger log = Logger.getLogger(FileUtils.class);

    /* JADX WARN: Code restructure failed: missing block: B:19:0x007e, code lost:
    
        throw new java.io.IOException("Unable to create folder " + r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void extractAssetZip(java.lang.String r14, java.io.File r15) throws java.lang.Throwable {
        /*
            r13 = -1
            com.vlingo.sdk.internal.core.ApplicationAdapter r11 = com.vlingo.sdk.internal.core.ApplicationAdapter.getInstance()
            android.content.Context r2 = r11.getApplicationContext()
            r5 = 0
            r9 = 0
            android.content.res.AssetManager r11 = r2.getAssets()     // Catch: java.lang.Throwable -> Ldc java.io.IOException -> Lde
            java.io.InputStream r5 = r11.open(r14)     // Catch: java.lang.Throwable -> Ldc java.io.IOException -> Lde
            java.util.zip.ZipInputStream r10 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> Ldc java.io.IOException -> Lde
            r10.<init>(r5)     // Catch: java.lang.Throwable -> Ldc java.io.IOException -> Lde
        L18:
            java.util.zip.ZipEntry r8 = r10.getNextEntry()     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            if (r8 != 0) goto L2a
            if (r10 == 0) goto L23
            r10.close()     // Catch: java.io.IOException -> Ld9
        L23:
            if (r5 == 0) goto Le0
            r5.close()     // Catch: java.io.IOException -> Lcf
            r9 = r10
        L29:
            return
        L2a:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            java.lang.String r12 = r15.getAbsolutePath()     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            r11.<init>(r12)     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            java.lang.String r12 = java.io.File.separator     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            java.lang.String r12 = r8.getName()     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            java.lang.String r7 = r11.toString()     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            java.lang.String r11 = r8.getName()     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            java.lang.String r12 = "/"
            int r11 = r11.indexOf(r12)     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            if (r11 == r13) goto La2
            java.io.File r11 = new java.io.File     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            r11.<init>(r7)     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            java.io.File r6 = r11.getParentFile()     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            boolean r11 = r6.exists()     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            if (r11 != 0) goto La2
            boolean r11 = r6.mkdirs()     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            if (r11 != 0) goto La2
            java.io.IOException r11 = new java.io.IOException     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            java.lang.String r13 = "Unable to create folder "
            r12.<init>(r13)     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            java.lang.StringBuilder r12 = r12.append(r6)     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            java.lang.String r12 = r12.toString()     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            r11.<init>(r12)     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            throw r11     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
        L7f:
            r3 = move-exception
            r9 = r10
        L81:
            com.vlingo.sdk.internal.logging.Logger r11 = com.vlingo.sdk.internal.util.FileUtils.log     // Catch: java.lang.Throwable -> Ldc
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ldc
            java.lang.String r13 = "Unable to extract asset zipfile: "
            r12.<init>(r13)     // Catch: java.lang.Throwable -> Ldc
            java.lang.StringBuilder r12 = r12.append(r14)     // Catch: java.lang.Throwable -> Ldc
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> Ldc
            r11.debug(r12)     // Catch: java.lang.Throwable -> Ldc
            if (r9 == 0) goto L9a
            r9.close()     // Catch: java.io.IOException -> Ld3
        L9a:
            if (r5 == 0) goto L29
            r5.close()     // Catch: java.io.IOException -> La0
            goto L29
        La0:
            r11 = move-exception
            goto L29
        La2:
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            r4.<init>(r7)     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            r11 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r11]     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            int r1 = r10.read(r0)     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
        Laf:
            if (r1 != r13) goto Lc6
            r10.closeEntry()     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            r4.close()     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            goto L18
        Lb9:
            r11 = move-exception
            r9 = r10
        Lbb:
            if (r9 == 0) goto Lc0
            r9.close()     // Catch: java.io.IOException -> Ld5
        Lc0:
            if (r5 == 0) goto Lc5
            r5.close()     // Catch: java.io.IOException -> Ld7
        Lc5:
            throw r11
        Lc6:
            r11 = 0
            r4.write(r0, r11, r1)     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            int r1 = r10.read(r0)     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb9
            goto Laf
        Lcf:
            r11 = move-exception
            r9 = r10
            goto L29
        Ld3:
            r11 = move-exception
            goto L9a
        Ld5:
            r12 = move-exception
            goto Lc0
        Ld7:
            r12 = move-exception
            goto Lc5
        Ld9:
            r11 = move-exception
            goto L23
        Ldc:
            r11 = move-exception
            goto Lbb
        Lde:
            r3 = move-exception
            goto L81
        Le0:
            r9 = r10
            goto L29
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlingo.sdk.internal.util.FileUtils.extractAssetZip(java.lang.String, java.io.File):void");
    }

    public static boolean copyFile(File srcFile, File dstFile) throws IOException {
        boolean z = false;
        try {
            InputStream in = new FileInputStream(srcFile);
            OutputStream out = new FileOutputStream(dstFile);
            byte[] buf = new byte[1024];
            while (true) {
                int len = in.read(buf);
                if (len > 0) {
                    out.write(buf, 0, len);
                } else {
                    out.flush();
                    out.close();
                    in.close();
                    z = true;
                    return true;
                }
            }
        } catch (FileNotFoundException ex) {
            log.error("FileUtils", "FileNotFound: " + ex.getMessage());
            ex.printStackTrace();
            return z;
        } catch (IOException e) {
            log.error("FileUtils", "IOException: " + e.getMessage());
            e.printStackTrace();
            return z;
        }
    }

    public static final byte[] readResource(String resource) throws IOException {
        InputStream is;
        log.debug("loading resource: " + resource);
        InputStream is2 = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream(500);
        byte[] data = (byte[]) null;
        byte[] buf = new byte[500];
        try {
            try {
                is = Class.class.getResourceAsStream(resource);
            } catch (IOException ex) {
                log.debug("err reading resource: " + ex);
                ex.printStackTrace();
                if (0 != 0) {
                    try {
                        is2.close();
                    } catch (IOException e) {
                    }
                }
                if (baos != null) {
                    try {
                        baos.close();
                    } catch (IOException e2) {
                    }
                }
            }
            if (is == null) {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e3) {
                    }
                }
                if (baos != null) {
                    try {
                        baos.close();
                    } catch (IOException e4) {
                    }
                }
                return null;
            }
            while (true) {
                int bytesRead = is.read(buf);
                if (bytesRead == -1) {
                    break;
                }
                baos.write(buf, 0, bytesRead);
            }
            baos.flush();
            data = baos.toByteArray();
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e5) {
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e6) {
                }
            }
            return data;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    is2.close();
                } catch (IOException e7) {
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e8) {
                }
            }
            throw th;
        }
    }
}
