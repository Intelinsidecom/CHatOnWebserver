package com.vlingo.sdk.internal.recognizer.reader;

import com.vlingo.sdk.internal.audio.AMRUtil;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.recognizer.SRContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class AMRDataReader extends DataReader {
    private Logger log;

    AMRDataReader(SRContext srContext, DataReaderListener listener) {
        super(srContext, listener);
        this.log = Logger.getLogger(AMRDataReader.class);
    }

    @Override // com.vlingo.sdk.internal.recognizer.reader.DataReader
    protected boolean onInit() {
        return true;
    }

    @Override // com.vlingo.sdk.internal.recognizer.reader.DataReader
    protected void onDeinit() {
    }

    @Override // com.vlingo.sdk.internal.recognizer.reader.DataReader
    protected void onProcessData() throws IOException {
        byte[] data = getAMRData(getInputStream(), getMaxDuration());
        onDataAvailable(data, -1, -1);
        stop();
    }

    @Override // com.vlingo.sdk.internal.recognizer.reader.DataReader
    protected boolean isSpeechDetected() {
        return true;
    }

    private byte[] getAMRData(InputStream is, int duration) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(500);
        byte[] data = (byte[]) null;
        byte[] buf = new byte[500];
        try {
            try {
                if (duration == -1) {
                    while (true) {
                        int bytesRead = is.read(buf);
                        if (bytesRead == -1) {
                            break;
                        }
                        baos.write(buf, 0, bytesRead);
                    }
                    baos.flush();
                    data = baos.toByteArray();
                } else {
                    data = AMRUtil.readInAMRMaxFrames(is, duration);
                }
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                    }
                }
                if (baos != null) {
                    try {
                        baos.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (IOException ex) {
                this.log.debug("err reading file: " + ex);
                ex.printStackTrace();
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
            }
            return data;
        } catch (Throwable th) {
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
            throw th;
        }
    }
}
