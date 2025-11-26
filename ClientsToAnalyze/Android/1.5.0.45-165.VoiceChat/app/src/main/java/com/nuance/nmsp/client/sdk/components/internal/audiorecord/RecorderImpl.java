package com.nuance.nmsp.client.sdk.components.internal.audiorecord;

import com.nuance.nmsp.client.sdk.common.defines.NMSPDefines;
import com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem;
import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem;
import com.nuance.nmsp.client.sdk.common.oem.api.TimerSystem;
import com.nuance.nmsp.client.sdk.common.util.Util;
import com.nuance.nmsp.client.sdk.components.audiorecord.NMSPAudioRecordListener;
import com.nuance.nmsp.client.sdk.components.audiorecord.Recorder;
import com.nuance.nmsp.client.sdk.components.general.NMSPAudioSink;
import com.nuance.nmsp.client.sdk.components.general.Parameter;
import com.nuance.nmsp.client.sdk.components.general.TransactionProcessingException;
import com.nuance.nmsp.client.sdk.components.resource.common.Manager;
import com.nuance.nmsp.client.sdk.components.resource.common.ResourceException;
import com.nuance.nmsp.client.sdk.components.resource.internal.common.ManagerImpl;
import com.nuance.nmsp.client.sdk.oem.AudioSystemOEM;
import com.nuance.nmsp.client.sdk.oem.BluetoothSystemOEM;
import java.util.Enumeration;
import java.util.Vector;

/* loaded from: classes.dex */
public class RecorderImpl implements AudioSystem.AudioCallback, AudioSystem.EndOfSpeechCallback, AudioSystem.EndPointerStartedCallback, AudioSystem.EndPointerStoppedCallback, AudioSystem.ErrorCallback, AudioSystem.NoSpeechCallback, AudioSystem.StartOfSpeechCallback, AudioSystem.StopCallback, MessageSystem.MessageHandler, Recorder {

    /* renamed from: a */
    private static final LogFactory.Log f103a = LogFactory.getLog(RecorderImpl.class);

    /* renamed from: b */
    private NMSPDefines.Codec f104b;

    /* renamed from: c */
    private AudioSystem f105c;

    /* renamed from: d */
    private NMSPAudioRecordListener f106d;

    /* renamed from: e */
    private MessageSystem f107e;

    /* renamed from: f */
    private NMSPAudioSink f108f;

    /* renamed from: g */
    private int f109g;

    /* renamed from: h */
    private TimerSystem.TimerSystemTask f110h;

    /* renamed from: i */
    private boolean f111i;

    /* renamed from: j */
    private boolean f112j;

    /* renamed from: k */
    private boolean f113k;

    /* renamed from: l */
    private AudioSystem.InputDevice f114l;

    /* renamed from: m */
    private Vector f115m;

    /* renamed from: n */
    private int f116n;

    public RecorderImpl(NMSPAudioRecordListener nMSPAudioRecordListener, Manager manager, Vector vector, NMSPDefines.AudioSystem.InputDevice inputDevice) {
        this.f107e = null;
        this.f111i = false;
        this.f112j = false;
        this.f113k = false;
        this.f116n = -1;
        m24a(vector);
        this.f106d = nMSPAudioRecordListener;
        this.f104b = ((ManagerImpl) manager).getInputCodec();
        this.f110h = null;
        this.f107e = ((ManagerImpl) manager).getMsgSys();
        this.f115m = vector;
        this.f111i = m27a(vector, NMSPDefines.NMSP_DEFINES_ENDPOINTER);
        this.f112j = m27a(vector, NMSPDefines.NMSP_DEFINES_RECORDER_CONTINUES_ON_ENDPOINTER_AND_TIMER_STOPPING);
        this.f113k = m27a(vector, NMSPDefines.NMSP_DEFINES_CAPTURING_CONTINUES_ON_ENDPOINTER);
        this.f105c = new AudioSystemOEM(this.f107e, this.f104b, vector);
        if (inputDevice.equals(NMSPDefines.AudioSystem.InputDevice.BLUETOOTH_HEADSET)) {
            this.f114l = AudioSystem.InputDevice.BLUETOOTH_HEADSET;
        } else if (inputDevice.equals(NMSPDefines.AudioSystem.InputDevice.MICROPHONE)) {
            this.f114l = AudioSystem.InputDevice.MICROPHONE;
        } else if (inputDevice.equals(NMSPDefines.AudioSystem.InputDevice.NETWORK)) {
            this.f114l = AudioSystem.InputDevice.NETWORK;
        } else if (inputDevice.equals(NMSPDefines.AudioSystem.InputDevice.WIRED_HEADSET)) {
            this.f114l = AudioSystem.InputDevice.WIRED_HEADSET;
        }
        this.f116n = 0;
    }

    /* renamed from: a */
    static /* synthetic */ TimerSystem.TimerSystemTask m19a(RecorderImpl recorderImpl, TimerSystem.TimerSystemTask timerSystemTask) {
        recorderImpl.f110h = null;
        return null;
    }

    /* renamed from: a */
    private void m20a() {
        if (this.f109g > 0) {
            this.f110h = new TimerSystem.TimerSystemTask() { // from class: com.nuance.nmsp.client.sdk.components.internal.audiorecord.RecorderImpl.1
                @Override // java.lang.Runnable
                public final void run() {
                    RecorderImpl.m19a(RecorderImpl.this, (TimerSystem.TimerSystemTask) null);
                    if (RecorderImpl.this.f112j) {
                        RecorderImpl.this.handleStopCapturing(true);
                    } else {
                        RecorderImpl.this.m25a(true);
                    }
                }
            };
            this.f107e.scheduleTask(this.f110h, this.f109g);
        }
    }

    /* renamed from: a */
    private void m21a(NMSPAudioSink nMSPAudioSink, int i) {
        if (f103a.isDebugEnabled()) {
            f103a.debug("RecorderImpl.handleStartRecording(" + nMSPAudioSink + ") _state:" + this.f116n);
        }
        if (new BluetoothSystemOEM(this.f115m).isBluetoothHeadsetConnected()) {
            this.f104b = Util.adjustCodecForBluetooth(this.f104b);
        }
        this.f109g = i;
        if (this.f116n == 0) {
            this.f108f = nMSPAudioSink;
            if (!this.f105c.startRecording(this.f114l, this.f111i && nMSPAudioSink != null, this, this, this, this, this, this, this, this, null)) {
                if (f103a.isErrorEnabled()) {
                    f103a.error("RecorderImpl.handleStartRecording() startRecording() failed!!!");
                }
                this.f116n = 8;
                m23a(Recorder.RECORD_ERROR, (Object) null);
                return;
            }
            if (this.f111i) {
                if (nMSPAudioSink == null) {
                    this.f116n = 1;
                } else {
                    this.f116n = 2;
                }
            } else if (nMSPAudioSink == null) {
                this.f116n = 1;
            } else {
                m20a();
                this.f116n = 4;
            }
            m23a(Recorder.STARTED, (Object) null);
        }
    }

    /* renamed from: a */
    private void m23a(String str, Object obj) {
        if (this.f106d != null) {
            try {
                this.f106d.recorderUpdate(this, str, obj);
            } catch (Throwable th) {
                if (f103a.isErrorEnabled()) {
                    f103a.error("Got an exp while calling NMSPAudioRecordListener.recorderUpdate(" + str + ", " + obj + ")[" + th.getClass().getName() + "] msg [" + th.getMessage() + "]");
                }
            }
        }
    }

    /* renamed from: a */
    private static void m24a(Vector vector) {
        if (vector != null) {
            Enumeration enumerationElements = vector.elements();
            while (enumerationElements.hasMoreElements()) {
                Parameter parameter = (Parameter) enumerationElements.nextElement();
                if (parameter.getType() != Parameter.Type.SDK) {
                    throw new IllegalArgumentException("Parameter type: " + parameter.getType() + " not allowed. ");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m25a(boolean z) {
        if (f103a.isDebugEnabled()) {
            f103a.debug("RecorderImpl.handleStopRecording() _state:" + this.f116n);
        }
        if (this.f116n == 2 || this.f116n == 4 || this.f116n == 5) {
            if (z) {
                m23a(Recorder.CAPTURE_TIMEOUT, (Object) null);
            }
            if (this.f116n == 4) {
                m28b();
            }
            this.f105c.stopRecording(this, null);
            this.f116n = 9;
            return;
        }
        if (this.f116n == 1 || this.f116n == 3 || this.f116n == 6) {
            this.f105c.stopRecording(this, null);
            this.f116n = 7;
        }
    }

    /* renamed from: a */
    private static boolean m27a(Vector vector, String str) {
        if (vector != null) {
            Enumeration enumerationElements = vector.elements();
            while (enumerationElements.hasMoreElements()) {
                Parameter parameter = (Parameter) enumerationElements.nextElement();
                if (parameter.getType() == Parameter.Type.SDK && parameter.getName().equals(str)) {
                    return new String(parameter.getValue()).equals("TRUE");
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m28b() {
        if (this.f110h != null) {
            this.f107e.cancelTask(this.f110h);
            this.f110h = null;
        }
    }

    /* renamed from: c */
    private void m29c() {
        try {
            this.f108f.addAudioBuf(null, 0, 0, true);
        } catch (TransactionProcessingException e) {
            if (f103a.isWarnEnabled()) {
                f103a.error("RecorderImpl.finishAudioSink() TransactionProcessingException:" + e);
            }
        }
        if (f103a.isDebugEnabled()) {
            f103a.debug("RecorderImpl::finishAudioSink send the last audio buffer from recorder");
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem.AudioCallback
    public void audioCallback(Vector vector, Vector vector2, AudioSystem.IntegerMutable integerMutable, AudioSystem.IntegerMutable integerMutable2, Float f, Object obj) {
        if (f103a.isErrorEnabled()) {
            f103a.error("RecorderImpl.audioCallback() not implemented!!!");
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem.AudioCallback
    public void audioCallback(byte[] bArr, Object obj, AudioSystem.IntegerMutable integerMutable, AudioSystem.IntegerMutable integerMutable2, Float f, Object obj2) {
        int i = 0;
        if (f103a.isDebugEnabled()) {
            f103a.debug("RecorderImpl.audioCallback() _state:" + this.f116n);
        }
        if (this.f116n == 4) {
            if (Util.isAMRCodec(this.f104b) || Util.isSpeexCodec(this.f104b)) {
                i = integerMutable2.f62i;
                bArr = (byte[]) obj;
            } else if (Util.isPCMCodec(this.f104b)) {
                i = integerMutable.f62i;
            } else {
                bArr = null;
            }
            if (f103a.isDebugEnabled()) {
                f103a.debug("========================= Recorder::audioCallback len[" + i + "] ======================");
            }
            try {
                this.f108f.addAudioBuf(bArr, 0, i, false);
                m23a(Recorder.BUFFER_RECORDED, f);
            } catch (TransactionProcessingException e) {
                if (f103a.isWarnEnabled()) {
                    f103a.warn("RecorderImpl.audioCallback() TransactionProcessingException:" + e);
                }
                m23a(Recorder.RECORD_ERROR, (Object) null);
                if (this.f116n == 4) {
                    m28b();
                }
                this.f105c.stopRecording(this, null);
                this.f116n = 7;
            }
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem.EndOfSpeechCallback
    public void endOfSpeechCallback(Object obj) {
        if (f103a.isDebugEnabled()) {
            f103a.debug("RecorderImpl::endOfSpeechCallback() _state:" + this.f116n);
        }
        if (this.f116n == 4) {
            m23a(Recorder.END_OF_SPEECH, (Object) null);
            if (this.f113k) {
                return;
            }
            handleStopCapturing(false);
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem.EndPointerStartedCallback
    public void endPointerStartedCallback(Object obj) {
        if (f103a.isDebugEnabled()) {
            f103a.debug("RecorderImpl::endPointerStartedCallback() _state:" + this.f116n);
        }
        if (this.f116n == 2) {
            m20a();
            this.f116n = 4;
        } else if (this.f116n == 3) {
            this.f105c.turnOffEndPointer(this, null);
            this.f116n = 6;
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem.EndPointerStoppedCallback
    public void endPointerStoppedCallback(Object obj) {
        if (f103a.isDebugEnabled()) {
            f103a.debug("RecorderImpl::endPointerStoppedCallback() _state:" + this.f116n);
        }
        if (this.f116n == 5) {
            this.f105c.turnOnEndPointer(this, null);
            this.f116n = 2;
        } else if (this.f116n == 6) {
            this.f116n = 1;
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem.ErrorCallback
    public void errorCallback(Object obj) {
        if (f103a.isDebugEnabled()) {
            f103a.debug("RecorderImpl.errorCallback() _state:" + this.f116n);
        }
        if (this.f116n == 1 || this.f116n == 2 || this.f116n == 3 || this.f116n == 4 || this.f116n == 5 || this.f116n == 6) {
            if (this.f116n == 4) {
                m28b();
            }
            m23a(Recorder.RECORD_ERROR, (Object) null);
            this.f116n = 7;
        }
    }

    @Override // com.nuance.nmsp.client.sdk.components.audiorecord.Recorder
    public Vector getParams(Vector vector) throws ResourceException {
        if (vector == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= vector.size()) {
                return this.f105c.getParams(vector);
            }
            Parameter parameter = (Parameter) vector.elementAt(i2);
            if (parameter.getType() != Parameter.Type.SDK) {
                if (f103a.isErrorEnabled()) {
                    f103a.error("IllegalArgumentException Parameter type: " + parameter.getType() + " not allowed. ");
                }
                throw new IllegalArgumentException("Parameter type: " + parameter.getType() + " not allowed. ");
            }
            i = i2 + 1;
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem.MessageHandler
    public void handleMessage(Object obj, Object obj2) {
        MessageSystem.MessageData messageData = (MessageSystem.MessageData) obj;
        switch (messageData.command) {
            case 1:
                m21a((NMSPAudioSink) null, 0);
                break;
            case 2:
                Object[] objArr = (Object[]) messageData.data;
                m21a((NMSPAudioSink) objArr[0], ((Integer) objArr[1]).intValue());
                break;
            case 3:
                m25a(false);
                break;
            case 4:
                Object[] objArr2 = (Object[]) messageData.data;
                handleStartCapturing((NMSPAudioSink) objArr2[0], ((Integer) objArr2[1]).intValue());
                break;
            case 5:
                handleStopCapturing(false);
                break;
        }
    }

    public void handleStartCapturing(NMSPAudioSink nMSPAudioSink, int i) {
        if (f103a.isDebugEnabled()) {
            f103a.debug("RecorderImpl.handleStartCapturing(" + nMSPAudioSink + ") _state:" + this.f116n);
        }
        this.f109g = i;
        this.f108f = nMSPAudioSink;
        if (this.f116n == 1) {
            if (this.f111i) {
                this.f105c.turnOnEndPointer(this, null);
                this.f116n = 2;
                return;
            } else {
                m20a();
                this.f116n = 4;
                return;
            }
        }
        if (this.f116n == 3) {
            this.f116n = 2;
        } else if (this.f116n == 6) {
            this.f116n = 5;
        }
    }

    public void handleStopCapturing(boolean z) {
        if (f103a.isDebugEnabled()) {
            f103a.debug("RecorderImpl.handleStopCapturing() _state:" + this.f116n);
        }
        if (this.f116n == 2) {
            m29c();
            if (z) {
                m23a(Recorder.CAPTURE_TIMEOUT, (Object) null);
            }
            this.f116n = 3;
            return;
        }
        if (this.f116n != 4) {
            if (this.f116n == 5) {
                m29c();
                this.f116n = 6;
                return;
            }
            return;
        }
        m29c();
        if (z) {
            m23a(Recorder.CAPTURE_TIMEOUT, (Object) null);
        }
        if (this.f116n == 4) {
            m28b();
        }
        if (!this.f111i) {
            this.f116n = 1;
        } else {
            this.f105c.turnOffEndPointer(this, null);
            this.f116n = 6;
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem.NoSpeechCallback
    public void noSpeechCallback(Object obj) {
    }

    @Override // com.nuance.nmsp.client.sdk.components.audiorecord.Recorder
    public void startCapturing(NMSPAudioSink nMSPAudioSink, int i) {
        if (f103a.isDebugEnabled()) {
            f103a.debug("RecorderImpl.startCapturing(" + nMSPAudioSink + ")");
        }
        if (nMSPAudioSink == null) {
            throw new IllegalArgumentException("audioSink cannot be null.");
        }
        if (i < 0) {
            throw new IllegalArgumentException("audioCaptureTime is invalid.");
        }
        this.f107e.send(new MessageSystem.MessageData((byte) 4, new Object[]{nMSPAudioSink, new Integer(i)}), this, Thread.currentThread(), this.f107e.getVRAddr()[0]);
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem.StartOfSpeechCallback
    public void startOfSpeechCallback(Object obj) {
        if (f103a.isDebugEnabled()) {
            f103a.debug("RecorderImpl::startOfSpeechCallback() _state:" + this.f116n);
        }
        if (this.f116n == 4) {
            m23a(Recorder.START_OF_SPEECH, (Object) null);
        }
    }

    @Override // com.nuance.nmsp.client.sdk.components.audiorecord.Recorder
    public void startRecording() {
        if (f103a.isDebugEnabled()) {
            f103a.debug("RecorderImpl.startRecording()");
        }
        this.f107e.send(new MessageSystem.MessageData((byte) 1, null), this, Thread.currentThread(), this.f107e.getVRAddr()[0]);
    }

    @Override // com.nuance.nmsp.client.sdk.components.audiorecord.Recorder
    public void startRecording(NMSPAudioSink nMSPAudioSink, int i) {
        if (f103a.isDebugEnabled()) {
            f103a.debug("RecorderImpl.startRecording(" + nMSPAudioSink + ")");
        }
        if (nMSPAudioSink == null) {
            throw new IllegalArgumentException("audioSink cannot be null.");
        }
        if (i < 0) {
            throw new IllegalArgumentException("audioCaptureTime is invalid.");
        }
        this.f107e.send(new MessageSystem.MessageData((byte) 2, new Object[]{nMSPAudioSink, new Integer(i)}), this, Thread.currentThread(), this.f107e.getVRAddr()[0]);
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.AudioSystem.StopCallback
    public void stopCallback(AudioSystem.AudioStatus audioStatus, Object obj) {
        if (f103a.isDebugEnabled()) {
            f103a.debug("RecorderImpl.stopCallback() _state:" + this.f116n);
        }
        if (this.f116n == 1 || this.f116n == 3 || this.f116n == 6 || this.f116n == 7) {
            m23a(Recorder.STOPPED, (Object) null);
            this.f116n = 8;
        } else if (this.f116n == 2 || this.f116n == 4 || this.f116n == 5 || this.f116n == 9) {
            if (this.f116n == 4) {
                m28b();
            }
            m29c();
            m23a(Recorder.STOPPED, (Object) null);
            this.f116n = 8;
        }
    }

    @Override // com.nuance.nmsp.client.sdk.components.audiorecord.Recorder
    public void stopCapturing() {
        if (f103a.isDebugEnabled()) {
            f103a.debug("RecorderImpl.startCapturing(" + this.f108f + ")");
        }
        this.f107e.send(new MessageSystem.MessageData((byte) 5, null), this, Thread.currentThread(), this.f107e.getVRAddr()[0]);
    }

    @Override // com.nuance.nmsp.client.sdk.components.audiorecord.Recorder
    public void stopRecording() {
        if (f103a.isDebugEnabled()) {
            f103a.debug("RecorderImpl.stop()");
        }
        this.f107e.send(new MessageSystem.MessageData((byte) 3, null), this, Thread.currentThread(), this.f107e.getVRAddr()[0]);
    }
}
