package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class CallMediaSettingRep extends MsgBody {
    private short AecMode;
    private int AudioDelay;
    private int AudioRecordBuf;
    private int AudioSampleRate;
    private int AudioTrackBuf;
    private short BackFrameSize;
    private int BandWidth;
    private short Fec;
    private int FrameRate;
    private short FrontFrameSize;
    private short NoiseSuppression;
    private int NormalModeAgc;
    private float NormalModeAudioVolume;
    private float NormalModeMicGain;
    private float NormalModeMicGainAfterAec;
    private int NormalModeMicVolume;
    private short PlaceCallCam;
    private int Qfactor;
    private short ReceiveCallCam;
    private int SpeakerModeAgc;
    private float SpeakerModeAudioVolume;
    private float SpeakerModeMicGain;
    private float SpeakerModeMicGainAfterAec;
    private int SpeakerModeMicVolume;
    private short Vad;
    private short VoiceCodec;

    public short getVoiceCodec() {
        return this.VoiceCodec;
    }

    public void setVoiceCodec(short voiceCodec) {
        this.VoiceCodec = voiceCodec;
    }

    public void setVoiceCodec(int voiceCodec) {
        this.VoiceCodec = (short) voiceCodec;
    }

    public short getPlaceCallCam() {
        return this.PlaceCallCam;
    }

    public void setPlaceCallCam(short placeCallCam) {
        this.PlaceCallCam = placeCallCam;
    }

    public void setPlaceCallCam(int placeCallCam) {
        this.PlaceCallCam = (short) placeCallCam;
    }

    public short getReceiveCallCam() {
        return this.ReceiveCallCam;
    }

    public void setReceiveCallCam(short receiveCallCam) {
        this.ReceiveCallCam = receiveCallCam;
    }

    public void setReceiveCallCam(int receiveCallCam) {
        this.ReceiveCallCam = (short) receiveCallCam;
    }

    public short getFrontFrameSize() {
        return this.FrontFrameSize;
    }

    public void setFrontFrameSize(short frontFrameSize) {
        this.FrontFrameSize = frontFrameSize;
    }

    public void setFrontFrameSize(int frontFrameSize) {
        this.FrontFrameSize = (short) frontFrameSize;
    }

    public short getBackFrameSize() {
        return this.BackFrameSize;
    }

    public void setBackFrameSize(short backFrameSize) {
        this.BackFrameSize = backFrameSize;
    }

    public void setBackFrameSize(int backFrameSize) {
        this.BackFrameSize = (short) backFrameSize;
    }

    public int getFrameRate() {
        return this.FrameRate;
    }

    public void setFrameRate(int frameRate) {
        this.FrameRate = frameRate;
    }

    public int getBandWidth() {
        return this.BandWidth;
    }

    public void setBandWidth(int bandWidth) {
        this.BandWidth = bandWidth;
    }

    public int getQfactor() {
        return this.Qfactor;
    }

    public void setQfactor(int qfactor) {
        this.Qfactor = qfactor;
    }

    public short getNoiseSuppression() {
        return this.NoiseSuppression;
    }

    public void setNoiseSuppression(short noiseSuppression) {
        this.NoiseSuppression = noiseSuppression;
    }

    public void setNoiseSuppression(int noiseSuppression) {
        this.NoiseSuppression = (short) noiseSuppression;
    }

    public short getAecMode() {
        return this.AecMode;
    }

    public void setAecMode(short aecMode) {
        this.AecMode = aecMode;
    }

    public void setAecMode(int aecMode) {
        this.AecMode = (short) aecMode;
    }

    public short getVad() {
        return this.Vad;
    }

    public void setVad(short vad) {
        this.Vad = vad;
    }

    public void setVad(int vad) {
        this.Vad = (short) vad;
    }

    public short getFec() {
        return this.Fec;
    }

    public void setFec(short fec) {
        this.Fec = fec;
    }

    public void setFec(int fec) {
        this.Fec = (short) fec;
    }

    public int getAudioRecordBuf() {
        return this.AudioRecordBuf;
    }

    public void setAudioRecordBuf(int audioRecordBuf) {
        this.AudioRecordBuf = audioRecordBuf;
    }

    public int getAudioTrackBuf() {
        return this.AudioTrackBuf;
    }

    public void setAudioTrackBuf(int audioTrackBuf) {
        this.AudioTrackBuf = audioTrackBuf;
    }

    public int getAudioSampleRate() {
        return this.AudioSampleRate;
    }

    public void setAudioSampleRate(int audioSampleRate) {
        this.AudioSampleRate = audioSampleRate;
    }

    public int getAudioDelay() {
        return this.AudioDelay;
    }

    public void setAudioDelay(int audioDelay) {
        this.AudioDelay = audioDelay;
    }

    public float getSpeakerModeMicGain() {
        return this.SpeakerModeMicGain;
    }

    public void setSpeakerModeMicGain(float speakerModeMicGain) {
        this.SpeakerModeMicGain = speakerModeMicGain;
    }

    public int getSpeakerModeAgc() {
        return this.SpeakerModeAgc;
    }

    public void setSpeakerModeAgc(int speakerModeAgc) {
        this.SpeakerModeAgc = speakerModeAgc;
    }

    public float getSpeakerModeMicGainAfterAec() {
        return this.SpeakerModeMicGainAfterAec;
    }

    public void setSpeakerModeMicGainAfterAec(float speakerModeMicGainAfterAec) {
        this.SpeakerModeMicGainAfterAec = speakerModeMicGainAfterAec;
    }

    public int getSpeakerModeMicVolume() {
        return this.SpeakerModeMicVolume;
    }

    public void setSpeakerModeMicVolume(int speakerModeMicVolume) {
        this.SpeakerModeMicVolume = speakerModeMicVolume;
    }

    public float getSpeakerModeAudioVolume() {
        return this.SpeakerModeAudioVolume;
    }

    public void setSpeakerModeAudioVolume(float speakerModeAudioVolume) {
        this.SpeakerModeAudioVolume = speakerModeAudioVolume;
    }

    public float getNormalModeMicGain() {
        return this.NormalModeMicGain;
    }

    public void setNormalModeMicGain(float normalModeMicGain) {
        this.NormalModeMicGain = normalModeMicGain;
    }

    public int getNormalModeAgc() {
        return this.NormalModeAgc;
    }

    public void setNormalModeAgc(int normalModeAgc) {
        this.NormalModeAgc = normalModeAgc;
    }

    public float getNormalModeMicGainAfterAec() {
        return this.NormalModeMicGainAfterAec;
    }

    public void setNormalModeMicGainAfterAec(float normalModeMicGainAfterAec) {
        this.NormalModeMicGainAfterAec = normalModeMicGainAfterAec;
    }

    public int getNormalModeMicVolume() {
        return this.NormalModeMicVolume;
    }

    public void setNormalModeMicVolume(int normalModeMicVolume) {
        this.NormalModeMicVolume = normalModeMicVolume;
    }

    public float getNormalModeAudioVolume() {
        return this.NormalModeAudioVolume;
    }

    public void setNormalModeAudioVolume(float normalModeAudioVolume) {
        this.NormalModeAudioVolume = normalModeAudioVolume;
    }
}
