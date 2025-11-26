package com.vlingo.sdk.internal.audio;

import com.vlingo.sdk.internal.logging.Logger;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class AMRUtil {
    private static final int FRAME_HEADER = 4;
    private static final int FRAME_SIZE = 13;
    private static final int FRAME_TIME = 20;
    private static final short[] frameSizes;
    private static final byte[] magicNum;
    private static Logger log = Logger.getLogger(AMRUtil.class);
    private static final byte[] AMR_HEADER = new byte[6];

    static {
        AMR_HEADER[0] = 35;
        AMR_HEADER[1] = 33;
        AMR_HEADER[2] = 65;
        AMR_HEADER[3] = 77;
        AMR_HEADER[4] = 82;
        AMR_HEADER[5] = 10;
        magicNum = new byte[]{35, 33, 65, 77, 82, 10};
        frameSizes = new short[]{12, 13, 15, 17, 19, 20, 26, 31, 5, 0, 0, 0, 0, 0, 0, 0};
    }

    public static boolean isAMRAudioOK(byte[] data, int off, int len) {
        if (data == null || len < 10) {
            return false;
        }
        for (int i = 0; i < AMR_HEADER.length; i++) {
            if (AMR_HEADER[i] != data[i + off]) {
                return false;
            }
        }
        return true;
    }

    public static byte[] addPaddingToAMR(byte[] data, int off, int len, int paddingMillis) {
        boolean amrAudioOK = isAMRAudioOK(data, off, len);
        if (amrAudioOK) {
            int iPaddedFrames = (paddingMillis * 13) / 20;
            byte[] paddedAMR = new byte[(iPaddedFrames * 2) + len];
            System.arraycopy(AMR_HEADER, 0, paddedAMR, 0, AMR_HEADER.length);
            for (int i = AMR_HEADER.length; i < iPaddedFrames; i += 13) {
                paddedAMR[i] = 4;
            }
            System.arraycopy(data, AMR_HEADER.length + off, paddedAMR, AMR_HEADER.length + iPaddedFrames, len - AMR_HEADER.length);
            for (int i2 = AMR_HEADER.length + iPaddedFrames + len; i2 < paddedAMR.length; i2 += 13) {
                paddedAMR[i2] = 4;
            }
            return paddedAMR;
        }
        return data;
    }

    public static byte[] readInAMRMaxFrames(InputStream inputStream, int fakeAMRMilliseconds) {
        if (fakeAMRMilliseconds < 1) {
            return null;
        }
        int maxFrames = fakeAMRMilliseconds / 20;
        byte[] data = (byte[]) null;
        DataInputStream amrFile = new DataInputStream(inputStream);
        log.debug("got new DataInputStream");
        ByteArrayOutputStream baos = new ByteArrayOutputStream(500);
        byte[] buf = new byte[500];
        try {
            int fakeAMRLen = 0 + amrFile.read(buf, 0, 6);
            for (int i = 0; i < 6; i++) {
                if (buf[i] != magicNum[i]) {
                    log.warn("AMR does not have the correct magic number");
                    return null;
                }
            }
            baos.write(buf, 0, 6);
            int readInFrames = 0;
            try {
                int header = amrFile.read();
                int frameLen = 0;
                while (readInFrames < maxFrames && header != -1) {
                    log.info(" AMR raw header is: " + header);
                    buf[frameLen] = (byte) header;
                    int frameLen2 = frameLen + 1;
                    int header2 = (header >> 3) & 15;
                    log.info(" AMR header is: " + header2);
                    short size = frameSizes[header2];
                    log.info(" AMR frame size is: " + ((int) size));
                    if (size != 0) {
                        frameLen2 = amrFile.read(buf, frameLen2, size) + 1;
                        readInFrames++;
                        log.info(" AMR read in frame " + readInFrames + ", frame length is " + frameLen2 + ", file length is " + fakeAMRLen);
                    } else {
                        log.warn(" AMR size is 0!!");
                    }
                    baos.write(buf, 0, size + 1);
                    fakeAMRLen += frameLen2;
                    frameLen = 0;
                    header = amrFile.read();
                    if (header == -1) {
                        log.info("At end of AMR stream");
                    }
                    if (readInFrames >= maxFrames) {
                        log.info("At max frames");
                    }
                }
            } catch (IOException e) {
                log.error("AMR FILE READ EXCEPTION", "IO exception while reading in AMR file");
                e.printStackTrace();
            }
            try {
                amrFile.close();
                baos.flush();
                data = baos.toByteArray();
            } catch (IOException e2) {
                log.error("AMR FILE CLOSE OR WRITE EXCEPTION", "AMR file: IO exception while closing or writing to internal buffer");
                e2.printStackTrace();
            }
            log.info("Len = " + fakeAMRLen + ", frames = " + readInFrames + ", max frames = " + maxFrames);
            return data;
        } catch (IOException e1) {
            e1.printStackTrace();
            return null;
        }
    }
}
