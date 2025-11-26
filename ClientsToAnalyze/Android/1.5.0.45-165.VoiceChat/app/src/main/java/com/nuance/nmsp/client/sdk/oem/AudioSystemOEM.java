package com.nuance.nmsp.client.sdk.oem;

import android.content.Context;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.nuance.nmsp.client.sdk.common.defines.NMSPDefines;
import com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem;
import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem;
import com.nuance.nmsp.client.sdk.components.general.Parameter;
import com.nuance.nmsp.client.sdk.oem.EndPointerOEM;
import com.nuance.nmsp.client.sdk.oem.bluetooth.Bluetooth;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.Vector;

/* loaded from: classes.dex */
public class AudioSystemOEM implements AudioSystem, MessageSystem.MessageHandler {

    /* renamed from: L */
    private static final Integer f211L;

    /* renamed from: M */
    private static final Integer f212M;

    /* renamed from: N */
    private static final Integer f213N;
    public static int bufferOffset;
    public static int maxOffset;
    public static Object speexDecodeLock;
    public static Object speexEncodeLock;

    /* renamed from: x */
    private static Object f214x = new Object();

    /* renamed from: y */
    private static Object f215y = new Object();

    /* renamed from: z */
    private static Object f216z = new Object();

    /* renamed from: A */
    private EndPointerOEM f217A;

    /* renamed from: B */
    private short[] f218B;

    /* renamed from: C */
    private byte[] f219C;

    /* renamed from: D */
    private int f220D;

    /* renamed from: E */
    private int f221E;

    /* renamed from: F */
    private int f222F;

    /* renamed from: G */
    private CodecType f223G;

    /* renamed from: H */
    private boolean f224H;

    /* renamed from: I */
    private MessageSystem f225I;

    /* renamed from: J */
    private boolean f226J;

    /* renamed from: K */
    private boolean f227K;

    /* renamed from: O */
    private Context f228O;

    /* renamed from: Q */
    private NMSPDefines.Codec f230Q;

    /* renamed from: b */
    private int f232b;

    /* renamed from: c */
    private int f233c;

    /* renamed from: d */
    private int f234d;

    /* renamed from: e */
    private int f235e;

    /* renamed from: f */
    private int f236f;

    /* renamed from: g */
    private int f237g;

    /* renamed from: h */
    private int f238h;

    /* renamed from: i */
    private int f239i;

    /* renamed from: j */
    private int f240j;

    /* renamed from: k */
    private int f241k;

    /* renamed from: l */
    private int f242l;

    /* renamed from: m */
    private int f243m;

    /* renamed from: n */
    private int f244n;

    /* renamed from: o */
    private int f245o;

    /* renamed from: p */
    private int f246p;

    /* renamed from: q */
    private int f247q;

    /* renamed from: r */
    private int f248r;

    /* renamed from: s */
    private int f249s;

    /* renamed from: t */
    private int f250t;

    /* renamed from: u */
    private int f251u;

    /* renamed from: v */
    private C0519a f252v;

    /* renamed from: w */
    private C0520b f253w;

    /* renamed from: a */
    private LogFactory.Log f231a = LogFactory.getLog(getClass());

    /* renamed from: P */
    private Bluetooth f229P = null;

    /* renamed from: com.nuance.nmsp.client.sdk.oem.AudioSystemOEM$1 */
    static /* synthetic */ class C05181 {

        /* renamed from: a */
        int f254a;

        /* renamed from: b */
        int f255b;

        /* renamed from: c */
        int f256c;

        /* renamed from: d */
        int f257d;

        /* renamed from: e */
        int f258e;

        /* renamed from: f */
        int f259f;

        /* renamed from: g */
        int f260g;

        /* renamed from: h */
        int f261h;

        /* renamed from: i */
        int f262i;

        private C05181(EndPointerOEM endPointerOEM) {
        }

        /* synthetic */ C05181(EndPointerOEM endPointerOEM, byte b) {
            this(endPointerOEM);
        }
    }

    public static class AudioSystemException extends Exception {
        public AudioSystemException(String str) {
            super(str);
        }
    }

    public static class CodecType {
        public static CodecType SPEEX = new CodecType();
        public static CodecType PCM = new CodecType();

        private CodecType() {
        }
    }

    /* renamed from: com.nuance.nmsp.client.sdk.oem.AudioSystemOEM$a */
    class C0519a extends Thread implements AudioTrack.OnPlaybackPositionUpdateListener {

        /* renamed from: b */
        private LogFactory.Log f264b;

        /* renamed from: c */
        private Handler f265c;

        /* renamed from: d */
        private AudioTrack f266d;

        /* renamed from: e */
        private byte[] f267e;

        /* renamed from: f */
        private short[] f268f;

        /* renamed from: g */
        private boolean f269g;

        /* renamed from: h */
        private int f270h;

        /* renamed from: i */
        private int f271i;

        /* renamed from: j */
        private boolean f272j;

        /* renamed from: k */
        private int f273k;

        /* renamed from: l */
        private boolean f274l;

        /* renamed from: m */
        private AudioSystem.AudioCallback f275m;

        /* renamed from: n */
        private AudioSystem.DoneCallback f276n;

        /* renamed from: o */
        private AudioSystem.StopCallback f277o;

        /* renamed from: p */
        private Object f278p;

        /* renamed from: q */
        private Object f279q;

        /* renamed from: r */
        private int f280r;

        private C0519a() {
            this.f264b = LogFactory.getLog(getClass());
            this.f272j = true;
            this.f274l = false;
            this.f275m = null;
            this.f276n = null;
            this.f277o = null;
            this.f278p = null;
            this.f279q = null;
            this.f280r = 0;
        }

        /* synthetic */ C0519a(AudioSystemOEM audioSystemOEM, byte b) {
            this();
        }

        /* renamed from: a */
        private int m88a(short[] sArr, int i, AudioSystem.IntegerMutable integerMutable, Object obj) throws AudioSystemException {
            int iDecodeSpeex;
            if (i == 0) {
                return 0;
            }
            if (AudioSystemOEM.this.f223G == CodecType.SPEEX) {
                int i2 = AudioSystemOEM.maxOffset - AudioSystemOEM.bufferOffset;
                if (i2 >= i) {
                    System.arraycopy(AudioSystemOEM.this.f218B, AudioSystemOEM.bufferOffset, sArr, 0, i);
                    AudioSystemOEM.bufferOffset += i;
                    return i;
                }
                if (i2 > 0) {
                    System.arraycopy(AudioSystemOEM.this.f218B, AudioSystemOEM.bufferOffset, sArr, 0, i2);
                }
                AudioSystemOEM.bufferOffset = 0;
                this.f275m.audioCallback((byte[]) null, AudioSystemOEM.this.f219C, new AudioSystem.IntegerMutable(0), integerMutable, (Float) null, obj);
                if (integerMutable.f62i > 0) {
                    synchronized (AudioSystemOEM.speexDecodeLock) {
                        iDecodeSpeex = AudioSystemOEM.decodeSpeex(AudioSystemOEM.this.f219C, integerMutable.f62i, AudioSystemOEM.this.f218B, AudioSystemOEM.this.f218B.length);
                        AudioSystemOEM.maxOffset = iDecodeSpeex;
                        if (iDecodeSpeex > AudioSystemOEM.this.f218B.length) {
                            AudioSystemOEM.maxOffset = AudioSystemOEM.this.f218B.length;
                        }
                    }
                    if (iDecodeSpeex < 0) {
                        throw new AudioSystemException("Call to decodeSpeex() failed with code: " + AudioSystemOEM.speexCodeToString(iDecodeSpeex));
                    }
                    if (this.f264b.isDebugEnabled()) {
                        this.f264b.debug("Obtained " + iDecodeSpeex + " shorts of PCM data after decoding SPEEX.");
                    }
                }
                if (i2 > 0) {
                    return i2;
                }
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
        
            r12.f272j = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
        
            r0 = 0;
         */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m89a() throws com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.AudioSystemException {
            /*
                Method dump skipped, instructions count: 770
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.C0519a.m89a():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m90a(AudioSystemException audioSystemException) {
            synchronized (AudioSystemOEM.f215y) {
                if (this.f264b.isErrorEnabled()) {
                    this.f264b.error(audioSystemException.getMessage());
                }
                if (this.f266d != null) {
                    this.f266d.stop();
                    this.f266d.release();
                    Looper looperMyLooper = Looper.myLooper();
                    if (looperMyLooper != null) {
                        looperMyLooper.quit();
                    }
                    this.f272j = false;
                }
                if (AudioSystemOEM.this.f229P != null) {
                    AudioSystemOEM.this.f229P.stopBluetoothSco();
                    AudioSystemOEM.this.m67g();
                }
                this.f276n.doneCallback(AudioSystem.AudioStatus.AUDIO_ERROR, this.f278p);
            }
        }

        /* renamed from: a */
        static /* synthetic */ boolean m93a(C0519a c0519a, boolean z) {
            c0519a.f272j = false;
            return false;
        }

        /* renamed from: b */
        static /* synthetic */ void m94b(C0519a c0519a) throws IllegalStateException {
            try {
                c0519a.f266d.stop();
            } catch (IllegalStateException e) {
                if (c0519a.f264b.isDebugEnabled()) {
                    c0519a.f264b.debug("Could not stop audioTrack.");
                }
            }
            synchronized (AudioSystemOEM.f215y) {
                c0519a.f272j = false;
                c0519a.f266d.flush();
                c0519a.f266d.release();
            }
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper != null) {
                looperMyLooper.quit();
            }
            if (AudioSystemOEM.this.f223G == CodecType.SPEEX) {
                synchronized (AudioSystemOEM.speexDecodeLock) {
                    AudioSystemOEM.decodeCleanupSpeex();
                    AudioSystemOEM.this.f218B = null;
                    AudioSystemOEM.this.f219C = null;
                }
            }
            if (AudioSystemOEM.this.f229P != null) {
                AudioSystemOEM.this.f229P.stopBluetoothSco();
                AudioSystemOEM.this.m67g();
            }
            c0519a.f277o.stopCallback(AudioSystem.AudioStatus.AUDIO_OK, c0519a.f279q);
        }

        /* renamed from: a */
        public final void m98a(AudioSystem.AudioCallback audioCallback, AudioSystem.DoneCallback doneCallback, Object obj) throws AudioSystemException {
            if (AudioSystemOEM.this.f229P != null) {
                AudioSystemOEM.this.f229P.startBluetoothSco();
            }
            synchronized (this) {
                this.f280r = 0;
                this.f275m = audioCallback;
                this.f276n = doneCallback;
                this.f278p = obj;
                if (AudioSystemOEM.this.f223G == CodecType.SPEEX) {
                    synchronized (AudioSystemOEM.speexDecodeLock) {
                        int iDecodeInitSpeex = AudioSystemOEM.decodeInitSpeex(AudioSystemOEM.this.f220D, 0, AudioSystemOEM.this.f222F);
                        if (iDecodeInitSpeex < 0) {
                            throw new AudioSystemException("decodeInitSpeex failed with code: " + AudioSystemOEM.speexCodeToString(iDecodeInitSpeex));
                        }
                        AudioSystemOEM.this.f218B = new short[524288];
                        AudioSystemOEM.this.f219C = new byte[524288];
                    }
                    AudioSystemOEM.bufferOffset = 0;
                    AudioSystemOEM.maxOffset = 0;
                }
                start();
                while (isAlive() && this.f265c == null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                }
                if (isAlive()) {
                    if (this.f265c != null) {
                        this.f265c.sendMessage(this.f265c.obtainMessage(1));
                    }
                }
            }
        }

        /* renamed from: a */
        public final void m99a(AudioSystem.StopCallback stopCallback, Object obj) {
            synchronized (AudioSystemOEM.f216z) {
                this.f274l = true;
            }
            synchronized (AudioSystemOEM.f215y) {
                this.f272j = false;
            }
            synchronized (this) {
                this.f279q = obj;
                this.f277o = stopCallback;
                if (!isAlive() || this.f269g) {
                    return;
                }
                if (this.f265c != null) {
                    this.f265c.sendMessage(this.f265c.obtainMessage(2));
                }
                while (isAlive() && !this.f269g) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }

        @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
        public final void onMarkerReached(AudioTrack audioTrack) {
            if (this.f264b.isDebugEnabled()) {
                this.f264b.debug("++++++++++++========== onMarkerReached(). PlaybackHeadPosition:" + this.f266d.getPlaybackHeadPosition());
            }
            try {
                m89a();
            } catch (AudioSystemException e) {
                m90a(e);
            }
        }

        @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
        public final void onPeriodicNotification(AudioTrack audioTrack) {
            if (this.f264b.isDebugEnabled()) {
                this.f264b.debug("++++++++++++========== onPeriodicNotification(). PlaybackHeadPosition" + this.f266d.getPlaybackHeadPosition());
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            Looper.prepare();
            synchronized (this) {
                this.f265c = new Handler() { // from class: com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.a.1
                    @Override // android.os.Handler
                    public final void handleMessage(Message message) throws IllegalStateException {
                        switch (message.what) {
                            case 1:
                                try {
                                    C0519a.this.m89a();
                                    break;
                                } catch (AudioSystemException e) {
                                    C0519a.this.m90a(e);
                                    return;
                                }
                            case 2:
                                C0519a.m94b(C0519a.this);
                                break;
                        }
                    }
                };
                try {
                    synchronized (AudioSystemOEM.f215y) {
                        if (this.f264b.isDebugEnabled()) {
                            this.f264b.debug("Creating Audio Track");
                        }
                        this.f267e = new byte[AudioSystemOEM.this.f237g];
                        this.f268f = new short[AudioSystemOEM.this.f241k];
                        try {
                            this.f273k = 0;
                            this.f266d = new AudioTrack(AudioSystemOEM.this.f232b, AudioSystemOEM.this.f234d, 2, 2, AudioSystemOEM.this.f238h, AudioSystemOEM.this.f233c);
                            if (this.f266d == null || this.f266d.getState() != 1) {
                                throw new AudioSystemException("AudioTrack object has not been initialized correctly. One or several parameters used to create it must be wrong.");
                            }
                            this.f266d.setPlaybackPositionUpdateListener(this);
                            this.f266d.play();
                        } catch (IllegalArgumentException e) {
                            throw new AudioSystemException("Could not instanciate AudioTrack object.");
                        }
                    }
                    notifyAll();
                } catch (AudioSystemException e2) {
                    m90a(e2);
                    return;
                }
            }
            Looper.loop();
            synchronized (this) {
                this.f269g = true;
                notifyAll();
            }
        }
    }

    /* renamed from: com.nuance.nmsp.client.sdk.oem.AudioSystemOEM$b */
    class C0520b implements AudioRecord.OnRecordPositionUpdateListener, MessageSystem.MessageHandler {

        /* renamed from: a */
        private LogFactory.Log f284a;

        /* renamed from: b */
        private AudioRecord f285b;

        /* renamed from: c */
        private boolean f286c;

        /* renamed from: d */
        private AudioSystem.AudioCallback f287d;

        /* renamed from: e */
        private AudioSystem.EndOfSpeechCallback f288e;

        /* renamed from: f */
        private AudioSystem.StartOfSpeechCallback f289f;

        /* renamed from: g */
        private AudioSystem.EndPointerStartedCallback f290g;

        /* renamed from: h */
        private AudioSystem.EndPointerStoppedCallback f291h;

        /* renamed from: i */
        private AudioSystem.StopCallback f292i;

        /* renamed from: j */
        private AudioSystem.ErrorCallback f293j;

        /* renamed from: k */
        private boolean f294k;

        /* renamed from: l */
        private boolean f295l;

        /* renamed from: m */
        private Object f296m;

        /* renamed from: n */
        private int f297n;

        private C0520b() {
            this.f284a = LogFactory.getLog(getClass());
            this.f287d = null;
            this.f288e = null;
            this.f289f = null;
            this.f290g = null;
            this.f291h = null;
            this.f292i = null;
            this.f293j = null;
            this.f294k = false;
            this.f295l = false;
            this.f296m = null;
            this.f297n = 0;
        }

        /* synthetic */ C0520b(AudioSystemOEM audioSystemOEM, byte b) {
            this();
        }

        /* renamed from: a */
        private static float m100a(short[] sArr) {
            double dLog10;
            long j = 0;
            for (long j2 : sArr) {
                j += (j2 * j2) >> 9;
            }
            double d = j / 1.073741824E9d;
            if (d < 1.0E-9d) {
                dLog10 = -90.0d;
            } else {
                dLog10 = Math.log10(d) * 10.0d;
                if (dLog10 > 0.0d) {
                    dLog10 = 0.0d;
                }
            }
            return (float) dLog10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m101a(AudioSystemException audioSystemException) throws IllegalStateException {
            if (this.f284a.isErrorEnabled()) {
                this.f284a.error(audioSystemException.getMessage());
            }
            if (this.f286c) {
                this.f285b.stop();
                synchronized (AudioSystemOEM.f214x) {
                    this.f286c = false;
                    this.f285b.release();
                    this.f285b = null;
                }
                this.f293j.errorCallback(this.f296m);
                if (AudioSystemOEM.this.f223G == CodecType.SPEEX) {
                    synchronized (AudioSystemOEM.speexEncodeLock) {
                        AudioSystemOEM.encodeCleanupSpeex();
                    }
                }
                if (AudioSystemOEM.this.f229P != null) {
                    AudioSystemOEM.this.f229P.stopBluetoothSco();
                    AudioSystemOEM.this.m67g();
                }
                if (this.f292i != null) {
                    this.f292i.stopCallback(AudioSystem.AudioStatus.AUDIO_ERROR, this.f296m);
                }
            }
        }

        /* renamed from: a */
        public final void m103a(AudioSystem.EndPointerStartedCallback endPointerStartedCallback) {
            this.f290g = endPointerStartedCallback;
            AudioSystemOEM.this.f225I.send(new Object[]{AudioSystemOEM.f211L}, this, AudioSystemOEM.this.f225I.getMyAddr(), AudioSystemOEM.this.f225I.getVRAddr()[0]);
        }

        /* renamed from: a */
        public final void m104a(AudioSystem.EndPointerStoppedCallback endPointerStoppedCallback) {
            this.f291h = endPointerStoppedCallback;
            AudioSystemOEM.this.f225I.send(new Object[]{AudioSystemOEM.f212M}, this, AudioSystemOEM.this.f225I.getMyAddr(), AudioSystemOEM.this.f225I.getVRAddr()[0]);
        }

        /* renamed from: a */
        public final void m105a(AudioSystem.StopCallback stopCallback, AudioSystem.EndOfSpeechCallback endOfSpeechCallback, Object obj) throws IllegalStateException, InterruptedException {
            boolean z = false;
            if (this.f286c) {
                try {
                    Thread.sleep(AudioSystemOEM.this.f247q);
                    if (this.f286c) {
                        this.f285b.stop();
                        z = true;
                    }
                    synchronized (AudioSystemOEM.f214x) {
                        this.f286c = false;
                        if (z) {
                            this.f285b.release();
                            this.f285b = null;
                        }
                    }
                    if (z && AudioSystemOEM.this.f223G == CodecType.SPEEX) {
                        synchronized (AudioSystemOEM.speexEncodeLock) {
                            AudioSystemOEM.encodeCleanupSpeex();
                        }
                    }
                } catch (IllegalStateException e) {
                    if (this.f284a.isDebugEnabled()) {
                        this.f284a.debug("Could not stop audioRecord.");
                    }
                } catch (Exception e2) {
                }
            }
            if (AudioSystemOEM.this.f229P != null) {
                AudioSystemOEM.this.f229P.stopBluetoothSco();
                AudioSystemOEM.this.m67g();
            }
            if (endOfSpeechCallback != null) {
                endOfSpeechCallback.endOfSpeechCallback(obj);
            }
            if (stopCallback != null) {
                stopCallback.stopCallback(AudioSystem.AudioStatus.AUDIO_OK, obj);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00a5 A[Catch: all -> 0x0077, IllegalArgumentException -> 0x00ad, TryCatch #3 {IllegalArgumentException -> 0x00ad, blocks: (B:26:0x007d, B:28:0x009c, B:30:0x00a5, B:31:0x00ac), top: B:61:0x007d, outer: #0 }] */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m106a(boolean r9, com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem.AudioCallback r10, com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem.StopCallback r11, com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem.ErrorCallback r12, com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem.StartOfSpeechCallback r13, com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem.EndOfSpeechCallback r14, com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem.EndPointerStartedCallback r15, com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem.EndPointerStoppedCallback r16, java.lang.Object r17) throws com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.AudioSystemException {
            /*
                Method dump skipped, instructions count: 301
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.C0520b.m106a(boolean, com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem$AudioCallback, com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem$StopCallback, com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem$ErrorCallback, com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem$StartOfSpeechCallback, com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem$EndOfSpeechCallback, com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem$EndPointerStartedCallback, com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem$EndPointerStoppedCallback, java.lang.Object):void");
        }

        @Override // com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem.MessageHandler
        public final void handleMessage(Object obj, Object obj2) throws IllegalStateException, InterruptedException {
            Object[] objArr = (Object[]) obj;
            if (((Integer) objArr[0]).intValue() == AudioSystemOEM.f211L.intValue()) {
                if (this.f294k) {
                    return;
                }
                this.f294k = true;
                AudioSystemOEM.this.f217A.resetEndpointingDetection();
                this.f295l = false;
                if (this.f290g != null) {
                    this.f290g.endPointerStartedCallback(null);
                    return;
                }
                return;
            }
            if (((Integer) objArr[0]).intValue() == AudioSystemOEM.f212M.intValue()) {
                if (this.f294k) {
                    this.f294k = false;
                    if (this.f291h != null) {
                        this.f291h.endPointerStoppedCallback(null);
                        return;
                    }
                    return;
                }
                return;
            }
            if (((Integer) objArr[0]).intValue() == AudioSystemOEM.f213N.intValue()) {
                int iIntValue = ((Integer) objArr[1]).intValue();
                Object obj3 = objArr[2];
                if (this.f286c) {
                    if (AudioSystemOEM.this.f223G != CodecType.SPEEX) {
                        if (this.f286c) {
                            byte[] bArr = (byte[]) obj3;
                            if (iIntValue < 0) {
                                m101a(new AudioSystemException("Call to AudioRecord.read() failed with code: " + iIntValue));
                                return;
                            }
                            if (iIntValue == 0) {
                                if (this.f284a.isDebugEnabled()) {
                                    this.f284a.debug("AudioRecorder has no audio.");
                                    return;
                                }
                                return;
                            }
                            if (this.f284a.isDebugEnabled()) {
                                LogFactory.Log log = this.f284a;
                                StringBuilder sb = new StringBuilder("RECORDING: Sample #");
                                int i = this.f297n;
                                this.f297n = i + 1;
                                log.debug(sb.append(i).append(". Sending ").append(iIntValue).append(" bytes from recorder.").toString());
                            }
                            this.f287d.audioCallback(bArr, (Object) null, new AudioSystem.IntegerMutable(iIntValue), new AudioSystem.IntegerMutable(0), (Float) null, this.f296m);
                            return;
                        }
                        return;
                    }
                    byte[] bArr2 = new byte[AudioSystemOEM.this.f251u];
                    if (this.f286c) {
                        short[] sArr = (short[]) obj3;
                        if (iIntValue < 0) {
                            m101a(new AudioSystemException("Call to AudioRecord.read() failed with code: " + iIntValue));
                            return;
                        }
                        if (iIntValue == 0) {
                            if (this.f284a.isDebugEnabled()) {
                                this.f284a.debug("AudioRecorder has no audio.");
                                return;
                            }
                            return;
                        }
                        EndPointerOEM.EpType epType = EndPointerOEM.EpType.DETECT_NOTHING;
                        synchronized (AudioSystemOEM.speexEncodeLock) {
                            if (this.f286c) {
                                int iEncodeSpeex = AudioSystemOEM.encodeSpeex(sArr, bArr2, AudioSystemOEM.this.f251u);
                                EndPointerOEM.EpType epTypeDetectEndPointing = (!this.f294k || this.f295l) ? epType : AudioSystemOEM.this.f217A.detectEndPointing();
                                if (iEncodeSpeex < 0) {
                                    m101a(new AudioSystemException("Call to encodeSpeex() failed with code: " + AudioSystemOEM.speexCodeToString(iEncodeSpeex)));
                                    return;
                                }
                                if (this.f284a.isDebugEnabled()) {
                                    LogFactory.Log log2 = this.f284a;
                                    StringBuilder sb2 = new StringBuilder("RECORDING: Sample #");
                                    int i2 = this.f297n;
                                    this.f297n = i2 + 1;
                                    log2.debug(sb2.append(i2).append(". Got ").append(iIntValue).append(" shorts from recorder, sending ").append(iEncodeSpeex).append(" SPEEX vocoded bytes. ").toString());
                                }
                                if (this.f284a.isDebugEnabled()) {
                                    if (epTypeDetectEndPointing == EndPointerOEM.EpType.SPEECH_END) {
                                        this.f284a.debug("ENDPOINTING SPEECH_END");
                                    } else if (epTypeDetectEndPointing == EndPointerOEM.EpType.SPEECH_START) {
                                        this.f284a.debug("ENDPOINTING SPEECH_START");
                                    }
                                }
                                float fM100a = AudioSystemOEM.this.f224H ? (long) (m100a(sArr) + 90.0f) : -1.0f;
                                this.f287d.audioCallback((byte[]) null, bArr2, new AudioSystem.IntegerMutable(0), new AudioSystem.IntegerMutable(iEncodeSpeex), fM100a < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET ? null : Float.valueOf(fM100a), this.f296m);
                                if (epTypeDetectEndPointing == EndPointerOEM.EpType.SPEECH_END) {
                                    this.f295l = true;
                                    if (!AudioSystemOEM.this.f226J) {
                                        m105a(this.f292i, this.f288e, this.f296m);
                                    } else if (this.f288e != null) {
                                        this.f288e.endOfSpeechCallback(this.f296m);
                                    }
                                }
                                if (epTypeDetectEndPointing == EndPointerOEM.EpType.SPEECH_START) {
                                    this.f289f.startOfSpeechCallback(this.f296m);
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // android.media.AudioRecord.OnRecordPositionUpdateListener
        public final void onMarkerReached(AudioRecord audioRecord) {
        }

        @Override // android.media.AudioRecord.OnRecordPositionUpdateListener
        public final void onPeriodicNotification(AudioRecord audioRecord) {
            int i = 0;
            if (AudioSystemOEM.this.f223G == CodecType.SPEEX) {
                synchronized (AudioSystemOEM.f214x) {
                    if (this.f286c) {
                        short[] sArr = new short[AudioSystemOEM.this.f248r];
                        do {
                            int i2 = audioRecord.read(sArr, i, AudioSystemOEM.this.f248r - i);
                            if (i2 == -3 || i2 == -2 || i2 <= 0) {
                                break;
                            } else {
                                i += i2;
                            }
                        } while (i < AudioSystemOEM.this.f248r);
                        AudioSystemOEM.this.f225I.send(new Object[]{AudioSystemOEM.f213N, new Integer(i), sArr}, this, AudioSystemOEM.this.f225I.getMyAddr(), AudioSystemOEM.this.f225I.getVRAddr()[0]);
                    }
                }
                return;
            }
            synchronized (AudioSystemOEM.f214x) {
                if (this.f286c) {
                    byte[] bArr = new byte[AudioSystemOEM.this.f249s];
                    do {
                        int i3 = audioRecord.read(bArr, i, AudioSystemOEM.this.f249s - i);
                        if (i3 == -3 || i3 == -2 || i3 <= 0) {
                            break;
                        } else {
                            i += i3;
                        }
                    } while (i < AudioSystemOEM.this.f249s);
                    AudioSystemOEM.this.f225I.send(new Object[]{AudioSystemOEM.f213N, new Integer(i), bArr}, this, AudioSystemOEM.this.f225I.getMyAddr(), AudioSystemOEM.this.f225I.getVRAddr()[0]);
                }
            }
        }
    }

    static {
        System.loadLibrary("nmsp_speex");
        speexEncodeLock = new Object();
        speexDecodeLock = new Object();
        bufferOffset = 0;
        maxOffset = 0;
        f211L = new Integer(1);
        f212M = new Integer(2);
        f213N = new Integer(3);
    }

    public AudioSystemOEM(MessageSystem messageSystem, NMSPDefines.Codec codec, Vector vector) {
        int i = 0;
        this.f217A = null;
        this.f224H = false;
        this.f226J = false;
        this.f227K = false;
        this.f228O = null;
        this.f230Q = codec;
        m53a(codec);
        this.f225I = messageSystem;
        this.f217A = new EndPointerOEM();
        this.f217A.initialize(vector);
        if (vector == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 >= vector.size()) {
                return;
            }
            Parameter parameter = (Parameter) vector.get(i2);
            String name = parameter.getName();
            if (parameter.getType() == Parameter.Type.SDK) {
                if (name.equals(NMSPDefines.NMSP_DEFINES_USE_ENERGY_LEVEL)) {
                    if (new String(parameter.getValue()).equalsIgnoreCase("TRUE")) {
                        if (this.f231a.isDebugEnabled()) {
                            this.f231a.debug("Use energy level is activated.");
                        }
                        this.f224H = true;
                    }
                } else if (name.equals(NMSPDefines.NMSP_DEFINES_RECORDER_CONTINUES_ON_ENDPOINTER_AND_TIMER_STOPPING)) {
                    if (new String(parameter.getValue()).equalsIgnoreCase("TRUE")) {
                        if (this.f231a.isDebugEnabled()) {
                            this.f231a.debug("_continuesOnEndPointerAndTimerStopping is activated.");
                        }
                        this.f226J = true;
                    }
                } else if (name.equals(NMSPDefines.NMSP_DEFINES_CAPTURING_CONTINUES_ON_ENDPOINTER)) {
                    if (new String(parameter.getValue()).equalsIgnoreCase("TRUE")) {
                        if (this.f231a.isDebugEnabled()) {
                            this.f231a.debug("_capturingContinuesOnEndPointer is activated.");
                        }
                        this.f227K = true;
                    }
                } else if (name.equals(NMSPDefines.NMSP_DEFINES_ANDROID_CONTEXT)) {
                    this.f228O = (Context) parameter.getValueRaw();
                    if (this.f231a.isDebugEnabled()) {
                        this.f231a.debug("NMSP_DEFINES_ANDROID_CONTEXT is passed in as" + this.f228O);
                    }
                }
            }
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    private void m53a(NMSPDefines.Codec codec) {
        if (codec == NMSPDefines.Codec.PCM_16_8K) {
            this.f223G = CodecType.PCM;
            this.f222F = 8000;
            this.f220D = -1;
            this.f221E = -1;
        } else if (codec == NMSPDefines.Codec.PCM_16_11K) {
            this.f223G = CodecType.PCM;
            this.f222F = 11000;
            this.f220D = -1;
            this.f221E = -1;
        } else if (codec == NMSPDefines.Codec.PCM_16_16K) {
            this.f223G = CodecType.PCM;
            this.f222F = 16000;
            this.f220D = -1;
            this.f221E = -1;
        } else if (codec == NMSPDefines.Codec.PCM_16_32K) {
            this.f223G = CodecType.PCM;
            this.f222F = 32000;
            this.f220D = -1;
            this.f221E = -1;
        } else if (codec == NMSPDefines.Codec.SPEEX_8K) {
            this.f223G = CodecType.SPEEX;
            this.f222F = 8000;
            this.f221E = 6;
            this.f220D = 0;
        } else if (codec == NMSPDefines.Codec.SPEEX_16K || codec == NMSPDefines.Codec.SPEEX_11K) {
            this.f223G = CodecType.SPEEX;
            this.f222F = 16000;
            this.f221E = 8;
            this.f220D = 1;
        } else {
            if (this.f231a.isErrorEnabled()) {
                this.f231a.error("Codec " + codec + " is not handled, using PCM_16_8K by default.");
            }
            this.f223G = CodecType.PCM;
            this.f222F = 8000;
            this.f220D = -1;
            this.f221E = -1;
        }
        this.f233c = 1;
        this.f234d = this.f222F;
        this.f242l = 750;
        this.f243m = (this.f242l * this.f234d) / 1000;
        this.f244n = this.f243m << 1;
        this.f235e = 300;
        this.f236f = (this.f234d * this.f235e) / 1000;
        this.f237g = this.f236f << 1;
        int i = this.f237g * 5;
        int minBufferSize = AudioTrack.getMinBufferSize(this.f234d, 2, 2);
        if (minBufferSize == -2 || minBufferSize == -1 || minBufferSize <= i) {
            this.f239i = i;
        } else {
            this.f239i = minBufferSize;
        }
        this.f238h = this.f239i / 2;
        this.f240j = 500;
        this.f241k = (this.f234d * this.f240j) / 1000;
        this.f246p = this.f222F;
        this.f247q = 100;
        this.f248r = (this.f246p * this.f247q) / 1000;
        this.f249s = this.f248r << 1;
        int i2 = this.f249s * 3;
        int minBufferSize2 = AudioRecord.getMinBufferSize(this.f246p, 2, 2);
        if (minBufferSize2 == -2 || minBufferSize2 == -1 || minBufferSize2 <= i2) {
            this.f250t = i2;
        } else {
            this.f250t = minBufferSize2;
        }
        this.f251u = this.f249s;
    }

    public static native void decodeCleanupSpeex();

    public static native int decodeInitSpeex(int i, int i2, int i3);

    public static native int decodeSpeex(byte[] bArr, int i, short[] sArr, int i2);

    public static native void encodeCleanupSpeex();

    public static native int encodeInitSpeex(int i, int i2, int i3, int i4, int i5);

    public static native int encodeSpeex(short[] sArr, byte[] bArr, int i);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m67g() {
        if (this.f229P != null) {
            this.f229P.close();
            this.f229P = null;
        }
    }

    /* renamed from: h */
    private void m69h() {
        if (this.f230Q == NMSPDefines.Codec.SPEEX_16K || this.f230Q == NMSPDefines.Codec.SPEEX_11K) {
            this.f230Q = NMSPDefines.Codec.SPEEX_8K;
            m53a(this.f230Q);
        } else if (this.f230Q == NMSPDefines.Codec.PCM_16_11K || this.f230Q == NMSPDefines.Codec.PCM_16_16K || this.f230Q == NMSPDefines.Codec.PCM_16_22K || this.f230Q == NMSPDefines.Codec.PCM_16_32K) {
            this.f230Q = NMSPDefines.Codec.PCM_16_8K;
            m53a(this.f230Q);
        }
    }

    public static native String speexCodeToString(int i);

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem
    public AudioSystem.InputDevice getInputDevice() {
        return AudioSystem.InputDevice.MICROPHONE;
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem
    public AudioSystem.OutputDevice getOutputDevice() {
        return AudioSystem.OutputDevice.SPEAKER;
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem
    public Vector getParams(Vector vector) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= vector.size()) {
                return vector;
            }
            Parameter parameter = (Parameter) vector.elementAt(i2);
            if (parameter.getType() == Parameter.Type.SDK) {
                if (parameter.getName().equals(NMSPDefines.NMSP_DEFINES_AUDIO_INPUTSOURCE)) {
                    switch (this.f245o) {
                        case 0:
                            vector.set(i2, new Parameter(NMSPDefines.NMSP_DEFINES_AUDIO_INPUTSOURCE, "Default audio source".getBytes(), Parameter.Type.SDK));
                            break;
                        case 1:
                            vector.set(i2, new Parameter(NMSPDefines.NMSP_DEFINES_AUDIO_INPUTSOURCE, "Microphone audio source".getBytes(), Parameter.Type.SDK));
                            break;
                        default:
                            vector.set(i2, new Parameter(NMSPDefines.NMSP_DEFINES_AUDIO_INPUTSOURCE, "Unkown audio source".getBytes(), Parameter.Type.SDK));
                            break;
                    }
                }
                if (parameter.getName().equals(NMSPDefines.NMSP_DEFINES_ENDPOINTER)) {
                    vector.setElementAt(new Parameter(NMSPDefines.NMSP_DEFINES_ENDPOINTER, new Boolean(this.f217A.isEndPointingActive()).toString().getBytes(), Parameter.Type.SDK), i2);
                } else if (parameter.getName().equals(NMSPDefines.NMSP_DEFINES_RECORDER_CONTINUES_ON_ENDPOINTER_AND_TIMER_STOPPING)) {
                    vector.setElementAt(new Parameter(NMSPDefines.NMSP_DEFINES_RECORDER_CONTINUES_ON_ENDPOINTER_AND_TIMER_STOPPING, new Boolean(this.f226J).toString().getBytes(), Parameter.Type.SDK), i2);
                } else if (parameter.getName().equals(NMSPDefines.NMSP_DEFINES_CAPTURING_CONTINUES_ON_ENDPOINTER)) {
                    vector.setElementAt(new Parameter(NMSPDefines.NMSP_DEFINES_CAPTURING_CONTINUES_ON_ENDPOINTER, new Boolean(this.f227K).toString().getBytes(), Parameter.Type.SDK), i2);
                } else if (parameter.getName().equals(NMSPDefines.NMSP_DEFINES_USE_ENERGY_LEVEL)) {
                    vector.set(i2, new Parameter(NMSPDefines.NMSP_DEFINES_USE_ENERGY_LEVEL, new Boolean(this.f224H).toString().getBytes(), Parameter.Type.SDK));
                } else {
                    vector.set(i2, new Parameter(parameter.getName(), "unsupported parameter".getBytes(), parameter.getType()));
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem.MessageHandler
    public void handleMessage(Object obj, Object obj2) {
        if (this.f231a.isDebugEnabled()) {
            this.f231a.debug("---------------------- AudioSystemAndroid +++++ handleMessage() Thread:" + Thread.currentThread());
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem
    public boolean nextPlayback() {
        this.f231a.info("++++++++++++========== nextPlayback() is not implemented");
        return false;
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem
    public boolean pausePlayback(int i) {
        this.f231a.info("++++++++++++========== pausePlayback() is not implemented");
        return false;
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem
    public void pauseRecording(int i) {
        this.f231a.debug("++++++++++++========== pauseRecording() is not implemented");
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem
    public boolean previousPlayback() {
        this.f231a.info("++++++++++++========== previousPlayback() is not implemented");
        return false;
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem
    public boolean startPlayback(AudioSystem.OutputDevice outputDevice, AudioSystem.AudioCallback audioCallback, AudioSystem.DoneCallback doneCallback, Object obj) {
        byte b = 0;
        if (this.f231a.isDebugEnabled()) {
            this.f231a.debug("++++++++++++========== startPlayback()");
        }
        if (audioCallback == null) {
            if (!this.f231a.isErrorEnabled()) {
                return false;
            }
            this.f231a.error("audioCallback cannot be null.");
            return false;
        }
        if (this.f228O == null) {
            if (!this.f231a.isErrorEnabled()) {
                return false;
            }
            this.f231a.error("inputDevice is BLUETOOTH_HEADSET, but ANDROID_CONTEXT parameter is not passed in!!!");
            return false;
        }
        this.f229P = Bluetooth.createInstance(this.f228O);
        if (this.f229P.isHeadsetConnected()) {
            m69h();
        }
        if (outputDevice == AudioSystem.OutputDevice.SPEAKER) {
            this.f232b = 3;
            m67g();
        } else {
            if (outputDevice != AudioSystem.OutputDevice.BLUETOOTH_HEADSET) {
                if (this.f231a.isErrorEnabled()) {
                    this.f231a.error("Unexpected outputDevice.");
                }
                m67g();
                return false;
            }
            this.f232b = this.f229P.getPlaybackStream();
            if (!this.f229P.isHeadsetConnected()) {
                m67g();
            }
        }
        this.f252v = new C0519a(this, b);
        try {
            this.f252v.m98a(audioCallback, doneCallback, obj);
            return true;
        } catch (AudioSystemException e) {
            this.f252v.m90a(e);
            this.f252v = null;
            return false;
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem
    public boolean startRecording(AudioSystem.InputDevice inputDevice, boolean z, AudioSystem.AudioCallback audioCallback, AudioSystem.StopCallback stopCallback, AudioSystem.ErrorCallback errorCallback, AudioSystem.StartOfSpeechCallback startOfSpeechCallback, AudioSystem.NoSpeechCallback noSpeechCallback, AudioSystem.EndOfSpeechCallback endOfSpeechCallback, AudioSystem.EndPointerStartedCallback endPointerStartedCallback, AudioSystem.EndPointerStoppedCallback endPointerStoppedCallback, Object obj) throws IllegalStateException {
        if (this.f231a.isDebugEnabled()) {
            this.f231a.debug("++++++++++++========== startRecording()");
        }
        if (this.f253w != null) {
            if (this.f231a.isDebugEnabled()) {
                this.f231a.debug("previous recording still running!");
            }
            return false;
        }
        if (audioCallback == null) {
            if (this.f231a.isErrorEnabled()) {
                this.f231a.error("audioCallback cannot be null.");
            }
            return false;
        }
        if (this.f228O == null) {
            if (this.f231a.isErrorEnabled()) {
                this.f231a.error("inputDevice is BLUETOOTH_HEADSET, but ANDROID_CONTEXT parameter is not passed in!!!");
            }
            return false;
        }
        this.f229P = Bluetooth.createInstance(this.f228O);
        if (this.f229P.isHeadsetConnected()) {
            m69h();
        }
        if (inputDevice == AudioSystem.InputDevice.MICROPHONE) {
            this.f245o = 1;
            m67g();
        } else {
            if (inputDevice != AudioSystem.InputDevice.BLUETOOTH_HEADSET) {
                if (this.f231a.isErrorEnabled()) {
                    this.f231a.error("Unexpected inputDevice.");
                }
                m67g();
                return false;
            }
            this.f245o = this.f229P.getRecordingSource();
            if (!this.f229P.isHeadsetConnected()) {
                m67g();
            }
        }
        this.f253w = new C0520b(this, (byte) 0);
        try {
            this.f253w.m106a(z, audioCallback, stopCallback, errorCallback, startOfSpeechCallback, endOfSpeechCallback, endPointerStartedCallback, endPointerStoppedCallback, obj);
            return true;
        } catch (AudioSystemException e) {
            this.f253w.m101a(e);
            this.f253w = null;
            return false;
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem
    public void stopPlayback(AudioSystem.StopCallback stopCallback, Object obj) {
        if (this.f231a.isDebugEnabled()) {
            this.f231a.debug("++++++++++++========== stopPlayback()");
        }
        if (this.f252v != null) {
            this.f252v.m99a(stopCallback, obj);
        }
        this.f252v = null;
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem
    public void stopRecording(AudioSystem.StopCallback stopCallback, Object obj) throws IllegalStateException, InterruptedException {
        if (this.f231a.isDebugEnabled()) {
            this.f231a.debug("++++++++++++========== stopRecording()");
        }
        if (stopCallback == null) {
            return;
        }
        if (this.f253w == null) {
            stopCallback.stopCallback(AudioSystem.AudioStatus.AUDIO_OK, obj);
        } else {
            this.f253w.m105a(stopCallback, null, obj);
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem
    public void turnOffEndPointer(AudioSystem.EndPointerStoppedCallback endPointerStoppedCallback, Object obj) {
        if (this.f231a.isDebugEnabled()) {
            this.f231a.debug("++++++++++++========== turnOnEndPointer()");
        }
        if (endPointerStoppedCallback == null || this.f253w == null) {
            return;
        }
        this.f253w.m104a(endPointerStoppedCallback);
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem
    public void turnOnEndPointer(AudioSystem.EndPointerStartedCallback endPointerStartedCallback, Object obj) {
        if (this.f231a.isDebugEnabled()) {
            this.f231a.debug("++++++++++++========== turnOnEndPointer()");
        }
        if (endPointerStartedCallback == null || this.f253w == null) {
            return;
        }
        this.f253w.m103a(endPointerStartedCallback);
    }
}
