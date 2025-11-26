package com.csli.eztalky.p001sp;

import com.csli.eztalky.SampleRate;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class VRecognizer {
    static final int FE_FEAT_DIM = 13;
    static final int FE_FRAME_MAX = 2000;
    private static final int MAX_RECORD_FRAME_N = 2000;
    private static final short PCM_SEND_BLOCK_BYTE_N = 8000;
    private static final int max_sample_n = 4000;
    int blockFrameN;
    private SampleRate currentSampleRate;
    int frameByteN;
    int frameSampleN;
    private VRListener listener;
    private Thread recordThread;
    private volatile boolean recording;
    private float wavPrevEnergy;
    public boolean DEBUG = false;
    public boolean PDEBUG = false;
    short[] exp_lut = {0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
    final short BIAS = 132;
    final short CLIP = 32635;
    private boolean initialized = false;
    private volatile boolean halted = false;
    private float wavPREAMP = 0.97f;
    int frameX = 0;
    short sendBlockX = 0;
    short sendByteN = 0;
    int totalBufferByteN = 0;
    int audioDataIdx = 0;
    private boolean finishing = false;
    private ByteBuffer writeBuf = ByteBuffer.allocate(8000);
    private ByteBuffer dataBuf = ByteBuffer.allocate(8000);
    private float[] wavBuf = new float[4000];
    private float[] wavAmp = new float[4000];
    private ByteBuffer tmpBuffer = ByteBuffer.allocate(2);
    private boolean epdEndSpeech = false;
    private boolean processVD = false;
    private Epd m_epd = new Epd();

    public VRecognizer() {
        this.dataBuf.order(ByteOrder.LITTLE_ENDIAN);
        this.tmpBuffer.order(ByteOrder.LITTLE_ENDIAN);
        init();
    }

    public boolean isPrivateD() {
        return this.DEBUG && this.PDEBUG;
    }

    public boolean isRecording() {
        return this.recording;
    }

    private boolean init() {
        if (this.initialized) {
            return false;
        }
        this.recording = false;
        this.initialized = true;
        if (this.DEBUG) {
            Logger.getLogger("global").info("[CSLI_VR][ASR][INITED]");
        }
        return true;
    }

    public void setListener(VRListener listener) {
        this.listener = listener;
    }

    public void initialize() {
        this.halted = false;
        this.finishing = false;
    }

    public boolean startVoiceRecognition(SampleRate sampleRate, final InputStream pcmStream, final OutputStream out) {
        if ((this.halted && !isReady()) || this.recording) {
            return false;
        }
        this.listener.onPreparedRecording(this);
        if (!this.initialized && !init()) {
            this.listener.onError(this, 0);
            return false;
        }
        this.halted = false;
        this.currentSampleRate = sampleRate;
        if (SampleRate.F_8k.equals(this.currentSampleRate)) {
            this.frameSampleN = 80;
            this.frameByteN = 160;
            this.blockFrameN = 50;
        } else {
            this.frameSampleN = 160;
            this.frameByteN = VLSpotterContext.DEFAULT_PHRASESPOT_PARAMB;
            this.blockFrameN = 25;
        }
        this.audioDataIdx = 0;
        this.m_epd.newUtterance();
        this.wavPrevEnergy = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.totalBufferByteN = 0;
        this.sendBlockX = (short) 0;
        this.sendByteN = (short) 0;
        this.frameX = 0;
        this.dataBuf.clear();
        if (this.DEBUG) {
            Logger.getLogger("global").info("[CSLI_VR][ASR][START_READY]");
        }
        this.recordThread = new Thread(new Runnable() { // from class: com.csli.eztalky.sp.VRecognizer.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    VRecognizer.this.recording = true;
                    VRecognizer.this.listener.onStartRecording(VRecognizer.this);
                    VRecognizer.this.processVoiceData(pcmStream, out);
                } finally {
                    VRecognizer.this.recording = false;
                }
            }
        });
        this.recordThread.setName("CLSI RecordThread");
        this.recordThread.start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processVoiceData(InputStream pcmStream, OutputStream out) {
        this.epdEndSpeech = false;
        this.dataBuf.clear();
        int readCount = -1;
        int dataIdx = 0;
        int totalRead = 0;
        while (isRecording()) {
            try {
                try {
                    try {
                        readCount = pcmStream.read(this.dataBuf.array(), dataIdx, this.dataBuf.remaining());
                        if (readCount == -1) {
                            this.recording = false;
                        } else if (readCount != 0) {
                            this.processVD = true;
                            totalRead += readCount;
                            dataIdx += readCount;
                            this.dataBuf.position(dataIdx);
                            if (this.dataBuf.remaining() == 0) {
                                dataIdx = 0;
                                this.dataBuf.flip();
                                for (int i_s = 0; i_s < 4000; i_s++) {
                                    this.wavBuf[i_s] = this.dataBuf.getShort();
                                }
                                for (int i_s2 = 1; i_s2 < 4000; i_s2++) {
                                    this.wavAmp[i_s2] = this.wavBuf[i_s2] - (this.wavPREAMP * this.wavBuf[i_s2 - 1]);
                                }
                                this.wavAmp[0] = this.wavBuf[0] * (1.0f - this.wavPREAMP);
                                short block_send_byte_n = 0;
                                for (int i_f = 0; i_f < this.blockFrameN; i_f++) {
                                    float curEnergy = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                                    for (int i_s3 = 0; i_s3 < this.frameSampleN; i_s3++) {
                                        int cur_sample = (this.frameSampleN * i_f) + i_s3;
                                        curEnergy += this.wavAmp[cur_sample] * this.wavAmp[cur_sample];
                                    }
                                    float curEnergy2 = (float) Math.sqrt(curEnergy / this.frameSampleN);
                                    float energy = (this.wavPrevEnergy + curEnergy2) / 2.0f;
                                    this.wavPrevEnergy = curEnergy2;
                                    if (SampleRate.F_8k.equals(this.currentSampleRate)) {
                                        energy *= 2.0f;
                                    }
                                    this.m_epd.oneFrame(energy);
                                    if (this.m_epd.m_state == 3 || this.frameX > 1990) {
                                        this.recording = false;
                                        this.epdEndSpeech = true;
                                        break;
                                    } else {
                                        block_send_byte_n = (short) (((short) this.frameByteN) + block_send_byte_n);
                                        this.frameX++;
                                    }
                                }
                                if (block_send_byte_n > 0) {
                                    try {
                                        sendPCM(out, block_send_byte_n);
                                        this.sendBlockX = (short) (this.sendBlockX + 1);
                                    } catch (IOException e) {
                                        Logger.getLogger("global").log(Level.WARNING, "[CSLI_VR][NET][ERROR]disconnected connector server", (Throwable) e);
                                        this.listener.onError(this, 15);
                                        finishASR();
                                        if (this.DEBUG) {
                                            Logger.getLogger("global").info("[CSLI_VR][ASR][PRV]end");
                                        }
                                        this.processVD = false;
                                        finishASR();
                                        return;
                                    }
                                }
                                this.dataBuf.clear();
                                this.totalBufferByteN += block_send_byte_n;
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } catch (Exception e2) {
                        if (!this.halted) {
                            Logger.getLogger("global").log(Level.WARNING, "[CSLI_VR][ERROR]unkown", (Throwable) e2);
                            this.listener.onError(this, 9999);
                        } else if (this.finishing) {
                            try {
                                try {
                                    sendEnd(out);
                                } catch (Exception e3) {
                                    Logger.getLogger("global").log(Level.WARNING, "[CSLI_VR][ERROR]unkown", (Throwable) e2);
                                    this.listener.onError(this, 9999);
                                }
                            } catch (IOException e4) {
                                Logger.getLogger("global").log(Level.WARNING, "[CSLI_VR][NET][ERROR]connector server disconnected", (Throwable) e2);
                                this.listener.onError(this, 15);
                            }
                        } else if (this.DEBUG) {
                            Logger.getLogger("global").log(Level.FINE, "[CSLI_VR][ASR][PRV]TRACE", (Throwable) e2);
                        }
                        if (this.DEBUG) {
                            Logger.getLogger("global").info("[CSLI_VR][ASR][PRV]end");
                        }
                        this.processVD = false;
                        finishASR();
                        return;
                    }
                } catch (IOException e5) {
                    if (!this.halted) {
                        Logger.getLogger("global").log(Level.WARNING, "[CSLI_VR][ERROR]PCM stream disconnected", (Throwable) e5);
                        this.listener.onError(this, 4);
                    } else if (this.DEBUG) {
                        Logger.getLogger("global").log(Level.FINE, "[CSLI_VR][ASR][PRV]TRACE", (Throwable) e5);
                    }
                    if (this.DEBUG) {
                        Logger.getLogger("global").info("[CSLI_VR][ASR][PRV]end");
                    }
                    this.processVD = false;
                    finishASR();
                    return;
                }
            } catch (Throwable th) {
                if (this.DEBUG) {
                    Logger.getLogger("global").info("[CSLI_VR][ASR][PRV]end");
                }
                this.processVD = false;
                finishASR();
                throw th;
            }
        }
        try {
            if (this.epdEndSpeech || (totalRead > 0 && readCount == -1)) {
                sendEnd(out);
            } else if (this.DEBUG) {
                Logger.getLogger("global").info("[CSLI_VR][ASR][PRV]epdEndSpeech:" + this.epdEndSpeech + " totalRead:" + totalRead + " readCount:" + readCount);
            }
        } catch (IOException e6) {
            if (!this.halted) {
                Logger.getLogger("global").log(Level.WARNING, "[CSLI_VR][NET][ERROR]connector server disconnected", (Throwable) e6);
                this.listener.onError(this, 15);
                if (this.DEBUG) {
                    Logger.getLogger("global").info("[CSLI_VR][ASR][PRV]end");
                }
                this.processVD = false;
                finishASR();
                return;
            }
        }
        if (this.DEBUG) {
            Logger.getLogger("global").info("[CSLI_VR][ASR][PRV]end");
        }
        this.processVD = false;
        finishASR();
    }

    private void sendEnd(OutputStream out) throws IOException {
        this.sendBlockX = (short) -1;
        sendPCM(out, (short) this.frameByteN);
        this.totalBufferByteN += this.frameByteN;
        this.listener.onEndRecording(this);
    }

    private void sendPCM(OutputStream out, short block_send_byte_n) throws IOException {
        short sendbyte = (short) (block_send_byte_n / 2);
        out.write(String.format("%05d", Integer.valueOf(sendbyte + 4)).getBytes());
        this.tmpBuffer.clear();
        this.tmpBuffer.putShort(this.sendBlockX);
        out.write(this.tmpBuffer.array());
        this.tmpBuffer.clear();
        this.tmpBuffer.putShort(sendbyte);
        out.write(this.tmpBuffer.array());
        this.writeBuf.clear();
        this.dataBuf.position(0);
        for (int i = 0; i < sendbyte; i++) {
            this.writeBuf.put(linear2ulaw((short) ((this.dataBuf.get() & 255) | (this.dataBuf.get() << 8))));
        }
        this.writeBuf.flip();
        out.write(this.writeBuf.array(), 0, this.writeBuf.limit());
        out.flush();
        this.listener.onSent(this);
    }

    public void haltVoiceRecognition() throws InterruptedException {
        if (this.DEBUG) {
            Logger.getLogger("global").info("[CSLI_VR][CALL]haltVoiceRecognition");
        }
        boolean waitFlag = false;
        synchronized (this) {
            if (this.initialized && this.recording) {
                if (this.DEBUG) {
                    Logger.getLogger("global").info("[CSLI_VR][ASR][HALT]");
                }
                this.recording = false;
                this.halted = true;
                waitFlag = true;
                if (isPrivateD()) {
                    Logger.getLogger("global").info("[CSLI_VR]haltVoiceRecognition:isRecording:" + this.recording);
                }
            }
        }
        if (waitFlag) {
            while (this.processVD) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                }
            }
            if (this.DEBUG) {
                Logger.getLogger("global").info("[CSLI_VR][ASR][HALTED]");
            }
        }
    }

    public boolean isReady() {
        return (!this.initialized || this.processVD || isRecording()) ? false : true;
    }

    private short swapShort(short value) {
        int b1 = value & 255;
        int b2 = (value >> 8) & 255;
        return (short) ((b1 << 8) | (b2 << 0));
    }

    private byte linear2ulaw(short sample) {
        short sign = (short) ((sample >> 8) & 128);
        if (sign != 0) {
            sample = (short) (-sample);
        }
        if (sample > 32635) {
            sample = 32635;
        }
        short sample2 = (short) (sample + 132);
        short exponent = this.exp_lut[(sample2 >> 7) & 255];
        short mantissa = (short) ((sample2 >> (exponent + 3)) & 15);
        byte ulawbyte = (byte) ((((exponent << 4) | sign) | mantissa) ^ (-1));
        return (byte) (ulawbyte & 255);
    }

    private void finishASR() {
        if (this.recording) {
            this.recording = false;
        }
    }

    public void finishVR() throws InterruptedException {
        synchronized (this) {
            if (!this.finishing) {
                this.finishing = true;
                long curr = System.currentTimeMillis();
                while (System.currentTimeMillis() - curr < 500) {
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e) {
                    }
                }
                this.m_epd.stop();
                this.epdEndSpeech = true;
                if (this.DEBUG) {
                    Logger.getLogger("global").info("[CSLI_VR][ASR][FINISHING_WAIT]");
                }
                while (isRecording()) {
                    if (!this.processVD && System.currentTimeMillis() - curr > 500) {
                        this.recordThread.interrupt();
                    } else {
                        try {
                            Thread.sleep(50L);
                        } catch (InterruptedException e2) {
                        }
                    }
                }
                if (this.DEBUG) {
                    Logger.getLogger("global").info("[CSLI_VR][ASR][FINISHED]");
                }
                finishASR();
            }
        }
    }

    public void close() {
    }

    public boolean isHalted() {
        return this.halted;
    }
}
