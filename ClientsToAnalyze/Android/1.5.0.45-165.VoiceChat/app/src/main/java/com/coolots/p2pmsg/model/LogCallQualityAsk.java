package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class LogCallQualityAsk extends MsgBody {
    private short AudioDelayAvg;
    private short AudioDelayMax;
    private short AudioDelayMin;
    private short AudioJitterAvg;
    private short AudioJitterMax;
    private short AudioJitterMin;
    private short AudioPacketLossAvg;
    private short AudioPacketLossMax;
    private short AudioPacketLossMin;
    private byte AudioVideo;
    private short BitRateAvg;
    private short BitRateMax;
    private short BitRateMin;
    private String CDRID;
    private short DeviceID;
    private byte FPSAvg;
    private byte FPSMax;
    private byte FPSMin;
    private String MCC;
    private String MNC;
    private float MOS;
    private byte NetworkType;
    private byte OSType;
    private short ResolutionHeight;
    private short ResolutionWidth;
    private byte SendReceive;
    private int UseRelay;
    private long UserNo;
    private short VideoDelayAvg;
    private short VideoDelayMax;
    private short VideoDelayMin;
    private short VideoJitterAvg;
    private short VideoJitterMax;
    private short VideoJitterMin;
    private short VideoPacketLossAvg;
    private short VideoPacketLossMax;
    private short VideoPacketLossMin;

    public int getUseRelay() {
        return this.UseRelay;
    }

    public void setUseRelay(int useRelay) {
        this.UseRelay = useRelay;
    }

    public String getCDRID() {
        return this.CDRID;
    }

    public void setCDRID(String cDRID) {
        this.CDRID = cDRID;
    }

    public long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(long userNo) {
        this.UserNo = userNo;
    }

    public short getDeviceID() {
        return this.DeviceID;
    }

    public void setDeviceID(int deviceID) {
        this.DeviceID = (short) deviceID;
    }

    public String getMCC() {
        return this.MCC;
    }

    public void setMCC(String mCC) {
        this.MCC = mCC;
    }

    public String getMNC() {
        return this.MNC;
    }

    public void setMNC(String mNC) {
        this.MNC = mNC;
    }

    public byte getOSType() {
        return this.OSType;
    }

    public void setOSType(int oSType) {
        this.OSType = (byte) oSType;
    }

    public byte getNetworkType() {
        return this.NetworkType;
    }

    public void setNetworkType(int networkType) {
        this.NetworkType = (byte) networkType;
    }

    public byte getSendReceive() {
        return this.SendReceive;
    }

    public void setSendReceive(int sendReceive) {
        this.SendReceive = (byte) sendReceive;
    }

    public byte getAudioVideo() {
        return this.AudioVideo;
    }

    public void setAudioVideo(int audioVideo) {
        this.AudioVideo = (byte) audioVideo;
    }

    public short getAudioPacketLossMin() {
        return this.AudioPacketLossMin;
    }

    public void setAudioPacketLossMin(int audioPacketLossMin) {
        this.AudioPacketLossMin = (short) audioPacketLossMin;
    }

    public short getAudioPacketLossAvg() {
        return this.AudioPacketLossAvg;
    }

    public void setAudioPacketLossAvg(int audioPacketLossAvg) {
        this.AudioPacketLossAvg = (short) audioPacketLossAvg;
    }

    public short getAudioPacketLossMax() {
        return this.AudioPacketLossMax;
    }

    public void setAudioPacketLossMax(int audioPacketLossMax) {
        this.AudioPacketLossMax = (short) audioPacketLossMax;
    }

    public short getAudioJitterMin() {
        return this.AudioJitterMin;
    }

    public void setAudioJitterMin(int audioJitterMin) {
        this.AudioJitterMin = (short) audioJitterMin;
    }

    public short getAudioJitterAvg() {
        return this.AudioJitterAvg;
    }

    public void setAudioJitterAvg(int audioJitterAvg) {
        this.AudioJitterAvg = (short) audioJitterAvg;
    }

    public short getAudioJitterMax() {
        return this.AudioJitterMax;
    }

    public void setAudioJitterMax(int audioJitterMax) {
        this.AudioJitterMax = (short) audioJitterMax;
    }

    public short getAudioDelayMin() {
        return this.AudioDelayMin;
    }

    public void setAudioDelayMin(int audioDelayMin) {
        this.AudioDelayMin = (short) audioDelayMin;
    }

    public short getAudioDelayAvg() {
        return this.AudioDelayAvg;
    }

    public void setAudioDelayAvg(int audioDelayAvg) {
        this.AudioDelayAvg = (short) audioDelayAvg;
    }

    public short getAudioDelayMax() {
        return this.AudioDelayMax;
    }

    public void setAudioDelayMax(int audioDelayMax) {
        this.AudioDelayMax = (short) audioDelayMax;
    }

    public short getVideoPacketLossMin() {
        return this.VideoPacketLossMin;
    }

    public void setVideoPacketLossMin(int videoPacketLossMin) {
        this.VideoPacketLossMin = (short) videoPacketLossMin;
    }

    public short getVideoPacketLossAvg() {
        return this.VideoPacketLossAvg;
    }

    public void setVideoPacketLossAvg(int videoPacketLossAvg) {
        this.VideoPacketLossAvg = (short) videoPacketLossAvg;
    }

    public short getVideoPacketLossMax() {
        return this.VideoPacketLossMax;
    }

    public void setVideoPacketLossMax(int videoPacketLossMax) {
        this.VideoPacketLossMax = (short) videoPacketLossMax;
    }

    public short getVideoJitterMin() {
        return this.VideoJitterMin;
    }

    public void setVideoJitterMin(int videoJitterMin) {
        this.VideoJitterMin = (short) videoJitterMin;
    }

    public short getVideoJitterAvg() {
        return this.VideoJitterAvg;
    }

    public void setVideoJitterAvg(int videoJitterAvg) {
        this.VideoJitterAvg = (short) videoJitterAvg;
    }

    public short getVideoJitterMax() {
        return this.VideoJitterMax;
    }

    public void setVideoJitterMax(int videoJitterMax) {
        this.VideoJitterMax = (short) videoJitterMax;
    }

    public short getVideoDelayMin() {
        return this.VideoDelayMin;
    }

    public void setVideoDelayMin(int videoDelayMin) {
        this.VideoDelayMin = (short) videoDelayMin;
    }

    public short getVideoDelayAvg() {
        return this.VideoDelayAvg;
    }

    public void setVideoDelayAvg(int videoDelayAvg) {
        this.VideoDelayAvg = (short) videoDelayAvg;
    }

    public short getVideoDelayMax() {
        return this.VideoDelayMax;
    }

    public void setVideoDelayMax(int videoDelayMax) {
        this.VideoDelayMax = (short) videoDelayMax;
    }

    public short getResolutionWidth() {
        return this.ResolutionWidth;
    }

    public void setResolutionWidth(int resolutionWidth) {
        this.ResolutionWidth = (short) resolutionWidth;
    }

    public short getResolutionHeight() {
        return this.ResolutionHeight;
    }

    public void setResolutionHeight(int resolutionHeight) {
        this.ResolutionHeight = (short) resolutionHeight;
    }

    public byte getFPSMin() {
        return this.FPSMin;
    }

    public void setFPSMin(int fPSMin) {
        this.FPSMin = (byte) fPSMin;
    }

    public byte getFPSAvg() {
        return this.FPSAvg;
    }

    public void setFPSAvg(int fPSAvg) {
        this.FPSAvg = (byte) fPSAvg;
    }

    public byte getFPSMax() {
        return this.FPSMax;
    }

    public void setFPSMax(int fPSMax) {
        this.FPSMax = (byte) fPSMax;
    }

    public short getBitRateMin() {
        return this.BitRateMin;
    }

    public void setBitRateMin(int bitRateMin) {
        this.BitRateMin = (short) bitRateMin;
    }

    public short getBitRateAvg() {
        return this.BitRateAvg;
    }

    public void setBitRateAvg(int bitRateAvg) {
        this.BitRateAvg = (short) bitRateAvg;
    }

    public short getBitRateMax() {
        return this.BitRateMax;
    }

    public void setBitRateMax(int bitRateMax) {
        this.BitRateMax = (short) bitRateMax;
    }

    public float getMOS() {
        return this.MOS;
    }

    public void setMOS(float mOS) {
        this.MOS = mOS;
    }
}
