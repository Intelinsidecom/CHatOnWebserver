package com.vlingo.sdk.internal.util;

import com.vlingo.sdk.internal.logging.Logger;
import java.io.ByteArrayOutputStream;
import java.util.zip.DeflaterOutputStream;

/* loaded from: classes.dex */
public class CompressUtils {
    private static final Logger log = Logger.getLogger(CompressUtils.class);

    public static byte[] deflate(byte[] dataToCompress) throws Throwable {
        DeflaterOutputStream zlos = null;
        byte[] result = (byte[]) null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream(dataToCompress.length);
        try {
            try {
                log.debug("Compressing data...");
                DeflaterOutputStream zlos2 = new DeflaterOutputStream(baos);
                try {
                    zlos2.write(dataToCompress);
                    zlos2.close();
                    zlos = null;
                    result = baos.toByteArray();
                    log.debug("Compress complete.  Before: " + dataToCompress.length + " After: " + result.length);
                    log.debug("Compression ratio: " + (100 - ((result.length * 100) / dataToCompress.length)) + "% reduction");
                    if (0 != 0) {
                        try {
                            zlos.close();
                        } catch (Exception e) {
                        }
                    }
                    if (baos != null) {
                        try {
                            baos.close();
                        } catch (Exception e2) {
                        }
                    }
                } catch (Exception e3) {
                    ex = e3;
                    zlos = zlos2;
                    log.error("GZIP1", "Error compressing: " + ex.toString());
                    if (zlos != null) {
                        try {
                            zlos.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (baos != null) {
                        try {
                            baos.close();
                        } catch (Exception e5) {
                        }
                    }
                    return result;
                } catch (Throwable th) {
                    th = th;
                    zlos = zlos2;
                    if (zlos != null) {
                        try {
                            zlos.close();
                        } catch (Exception e6) {
                        }
                    }
                    if (baos == null) {
                        throw th;
                    }
                    try {
                        baos.close();
                        throw th;
                    } catch (Exception e7) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e8) {
            ex = e8;
        }
        return result;
    }
}
