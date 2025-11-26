package com.vlingo.sdk.internal.recognizer.reader;

import com.nuance.nmsp.client.sdk.components.audiorecord.Recorder;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.recognizer.SRContext;
import com.vlingo.sdk.internal.recognizer.TimingRepository;
import com.vlingo.sdk.internal.recognizer.reader.DataReaderListener;
import com.vlingo.sdk.internal.util.AutoCloseFileInputStream;
import com.vlingo.sdk.recognition.AudioSourceInfo;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class DataReader {
    private static Logger log = Logger.getLogger(DataReader.class);
    private String mGuttId;
    private InputStream mInputStream;
    private boolean mIsStopped;
    private DataReaderListener mListener;
    private ReaderThread mReaderThread;
    private SRContext mSrContext;
    private TimingRepository mTimings;
    private int mTotalDuration;

    abstract boolean isSpeechDetected();

    protected abstract void onDeinit();

    protected abstract boolean onInit();

    protected abstract void onProcessData();

    public static DataReader getDataReader(SRContext srContext, DataReaderListener listener) {
        AudioSourceInfo asi = srContext.getAudioSourceInfo();
        return asi.isAMR() ? new AMRDataReader(srContext, listener) : new SpeexDataReader(srContext, listener);
    }

    public DataReader(SRContext srContext, DataReaderListener listener) {
        this.mSrContext = srContext;
        this.mListener = listener;
    }

    public final void SetTimings(TimingRepository timings) {
        this.mTimings = timings;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean init() {
        /*
            r7 = this;
            r3 = 0
            com.vlingo.sdk.internal.logging.Logger r4 = com.vlingo.sdk.internal.recognizer.reader.DataReader.log
            java.lang.String r5 = "init()"
            r4.debug(r5)
            com.vlingo.sdk.internal.recognizer.TimingRepository r4 = r7.mTimings
            if (r4 == 0) goto L13
            com.vlingo.sdk.internal.recognizer.TimingRepository r4 = r7.mTimings
            java.lang.String r5 = "PPRS"
            r4.recordAndTimeStampEvent(r5)
        L13:
            com.vlingo.sdk.internal.recognizer.SRContext r4 = r7.mSrContext
            com.vlingo.sdk.recognition.AudioSourceInfo r0 = r4.getAudioSourceInfo()
            boolean r4 = r0.isFile()
            if (r4 == 0) goto L6d
            com.vlingo.sdk.internal.util.AutoCloseFileInputStream r4 = new com.vlingo.sdk.internal.util.AutoCloseFileInputStream     // Catch: java.io.FileNotFoundException -> L53
            java.lang.String r5 = r0.getFilename()     // Catch: java.io.FileNotFoundException -> L53
            r4.<init>(r5)     // Catch: java.io.FileNotFoundException -> L53
            r7.mInputStream = r4     // Catch: java.io.FileNotFoundException -> L53
        L2a:
            com.vlingo.sdk.VLSdk r4 = com.vlingo.sdk.VLSdk.getInstance()
            com.vlingo.sdk.util.SDKDebugSettings r1 = r4.getDebugSettings()
            if (r1 == 0) goto L43
            boolean r4 = r1.isLogRecoWaveform()
            if (r4 == 0) goto L43
            com.vlingo.sdk.internal.recognizer.reader.InputStreamLogger r4 = new com.vlingo.sdk.internal.recognizer.reader.InputStreamLogger
            java.io.InputStream r5 = r7.mInputStream
            r4.<init>(r5)
            r7.mInputStream = r4
        L43:
            boolean r3 = r7.onInit()
            com.vlingo.sdk.internal.recognizer.TimingRepository r4 = r7.mTimings
            if (r4 == 0) goto L52
            com.vlingo.sdk.internal.recognizer.TimingRepository r4 = r7.mTimings
            java.lang.String r5 = "PPRE"
            r4.recordAndTimeStampEvent(r5)
        L52:
            return r3
        L53:
            r2 = move-exception
            com.vlingo.sdk.internal.logging.Logger r4 = com.vlingo.sdk.internal.recognizer.reader.DataReader.log
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Unable to create inputstream from file: "
            r5.<init>(r6)
            java.lang.String r6 = r2.toString()
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.error(r5)
            goto L52
        L6d:
            boolean r4 = r0.isStream()
            if (r4 == 0) goto L7a
            java.io.InputStream r4 = r0.getInputStream()
            r7.mInputStream = r4
            goto L2a
        L7a:
            com.vlingo.sdk.internal.logging.Logger r4 = com.vlingo.sdk.internal.recognizer.reader.DataReader.log
            java.lang.String r5 = "Unknown audio source"
            r4.error(r5)
            goto L52
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlingo.sdk.internal.recognizer.reader.DataReader.init():boolean");
    }

    public final void start() {
        log.debug("start()");
        this.mReaderThread = new ReaderThread();
        this.mReaderThread.start();
    }

    public final void stop() {
        log.debug("stop()");
        this.mIsStopped = true;
    }

    public final void setGuttId(String guttId) {
        this.mGuttId = guttId;
    }

    public final void writeLog() {
        if (this.mInputStream instanceof InputStreamLogger) {
            ((InputStreamLogger) this.mInputStream).writeLog(this.mGuttId);
        }
    }

    protected SRContext getSRContext() {
        return this.mSrContext;
    }

    protected InputStream getInputStream() {
        return this.mInputStream;
    }

    protected int getMaxDuration() {
        return this.mSrContext.getMaxAudioTime();
    }

    protected void onError(DataReaderListener.ErrorCode code, String msg) {
        stop();
        this.mListener.onError(code, msg);
    }

    protected void onDataAvailable(byte[] buffer, int energy, int totalDuration) {
        this.mTotalDuration = totalDuration;
        this.mListener.onDataAvailable(buffer, energy);
    }

    private class ReaderThread extends Thread {
        ReaderThread() {
            super("ReaderThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws InterruptedException, IOException {
            if (DataReader.this.mTimings != null) {
                DataReader.this.mTimings.recordAndTimeStampEvent(Recorder.STARTED);
            }
            DataReader.this.mListener.onStarted();
            while (!DataReader.this.mIsStopped) {
                try {
                    DataReader.this.onProcessData();
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                } catch (Exception e2) {
                    DataReader.log.error("ReaderThread exception: " + e2.toString());
                    DataReader.this.onError(DataReaderListener.ErrorCode.READ_ERROR, e2.toString());
                }
            }
            DataReader.log.debug("Exited read data processing loop");
            DataReader.this.mListener.onStopped(DataReader.this.mTotalDuration, DataReader.this.isSpeechDetected());
            DataReader.this.onDeinit();
            if (DataReader.this.mInputStream instanceof AutoCloseFileInputStream) {
                try {
                    DataReader.this.mInputStream.close();
                } catch (Exception e3) {
                }
            }
        }
    }
}
