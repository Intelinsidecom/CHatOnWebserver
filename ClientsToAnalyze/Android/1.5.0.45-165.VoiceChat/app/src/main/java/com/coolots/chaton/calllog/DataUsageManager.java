package com.coolots.chaton.calllog;

import android.os.Handler;
import android.os.Message;
import com.coolots.chaton.calllog.adaptor.DataUsageDBAdaptor;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.calllog.DataUsageManagerInterface;
import com.sds.coolots.calllog.model.CallDataUsage;
import com.sds.coolots.calllog.model.TotalDataUsage;
import com.sds.coolots.common.util.Log;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class DataUsageManager extends Handler implements DataUsageManagerInterface {
    private static final int BIT_PER_BYTE = 8;
    private static final int BYTE_PER_KBYTE = 1000;
    private static final int CALL_TYPE_DEFAULT = 0;
    private static final int CALL_TYPE_VIDEO = 2;
    private static final int CALL_TYPE_VOICE = 1;
    private static final String CLASSNAME = "[DataUsageManager]";
    private static final int DU_EVENT_CHANGE_DAY = 1003;
    private static final int DU_EVENT_END_CALL = 1001;
    private static final int DU_EVENT_START_CALL = 1000;
    private static final int DU_EVENT_SWITCH_CALL = 1002;
    private static final int ENGINE_WIFI = 1;
    private static final int MILLSEC_PER_SEC = 1000;
    boolean mIsConference;
    boolean mIsOutGoingCall;
    boolean mIsStarted;
    boolean mIsUseVideo;
    boolean mIsWifi;
    long mVideoBaseTime;
    int mVideoBps;
    int mVideoUsage;
    long mVoiceBaseTime;
    int mVoiceBps;
    int mVoiceUsage;
    private final Object mDataUsageDBMutex = new Object();
    private int mInitialCallType = 0;
    private final DataUsageDBAdaptor dataUsageDBAdaptor = new DataUsageDBAdaptor();
    private final DUHandler mHandler = new DUHandler();

    /* JADX INFO: Access modifiers changed from: private */
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private class StartArg {
        boolean _isConference;
        boolean _isOutgoing;
        boolean _isVideo;

        StartArg(boolean isOutgoing, boolean isVideo, boolean isConference) {
            this._isConference = isConference;
            this._isOutgoing = isOutgoing;
            this._isVideo = isVideo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isConference() {
            return this._isConference;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isOutoing() {
            return this._isOutgoing;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isVideo() {
            return this._isVideo;
        }

        private void setIsConference(boolean isConference) {
            this._isConference = isConference;
        }

        private void setIsOutgoing(boolean isOutgoing) {
            this._isOutgoing = isOutgoing;
        }

        private void setIsVideo(boolean isVideo) {
            this._isVideo = isVideo;
        }
    }

    public boolean isStarted() {
        return this.mIsStarted;
    }

    public void setIsStarted(boolean isStarted) {
        this.mIsStarted = isStarted;
    }

    public int getVoiceUsage() {
        return this.mVoiceUsage;
    }

    public void setVoiceUsage(int VoiceUsage) {
        this.mVoiceUsage = VoiceUsage;
    }

    public int getVideoUsage() {
        return this.mVideoUsage;
    }

    public void setVideoUsage(int VideoUsage) {
        this.mVideoUsage = VideoUsage;
    }

    public int getVoiceBps() {
        return this.mVoiceBps;
    }

    public void setVoiceBps(int VoiceBps) {
        this.mVoiceBps = VoiceBps;
    }

    public int getVideoBps() {
        return this.mVideoBps;
    }

    public void setVideoBps(int VideoBps) {
        this.mVideoBps = VideoBps;
    }

    public long getVoiceBaseTime() {
        return this.mVoiceBaseTime;
    }

    public void setVoiceBaseTime(long VoiceBaseTime) {
        this.mVoiceBaseTime = VoiceBaseTime;
    }

    public long getVideoBaseTime() {
        return this.mVideoBaseTime;
    }

    public void setVideoBaseTime(long VideoBaseTime) {
        this.mVideoBaseTime = VideoBaseTime;
    }

    public boolean isOutGoingCall() {
        return this.mIsOutGoingCall;
    }

    public void setIsOutGoingCall(boolean IsOutGoingCall) {
        this.mIsOutGoingCall = IsOutGoingCall;
    }

    public boolean isUseVideo() {
        return this.mIsUseVideo;
    }

    public void setIsUseVideo(boolean IsUseVideo) {
        this.mIsUseVideo = IsUseVideo;
    }

    public void setIsConference(boolean IsConference) {
        this.mIsConference = IsConference;
    }

    public boolean isWifi() {
        return this.mIsWifi;
    }

    public void setIsWifi(boolean isWifi) {
        this.mIsWifi = isWifi;
    }

    public long getCurrMillTime() {
        return System.currentTimeMillis();
    }

    public int getVoiceDataUsage(long Time) {
        int DiffSec = (int) ((Time - getVoiceBaseTime()) / 1000);
        double DataUsage = ((getVoiceBps() * DiffSec) / 1000) / 8;
        logI("getVoiceDataUsage : " + DataUsage + "VoiceBps" + getVoiceBps() + " BaseTime :" + getVoiceBaseTime() + " inputTime : " + Time + " DiffSec : " + DiffSec);
        return (int) DataUsage;
    }

    public int getVideoDataUsage(long Time) {
        int DiffSec = (int) ((Time - getVideoBaseTime()) / 1000);
        double DataUsage = ((getVideoBps() * DiffSec) / 1000) / 8;
        logI("getVideoDataUsage : " + DataUsage + "VideoBps" + getVideoBps() + " BaseTime :" + getVideoBaseTime() + " inputTime : " + Time + " DiffSec : " + DiffSec);
        return (int) DataUsage;
    }

    @Override // com.sds.coolots.calllog.DataUsageManagerInterface
    public void notifyEndCall(boolean isOurGoingCall, boolean isVideoCall, boolean isConferenceCall) {
        if (this.mHandler != null) {
            Message msg = this.mHandler.obtainMessage();
            StartArg arg = new StartArg(isOurGoingCall, isVideoCall, isConferenceCall);
            msg.what = 1001;
            msg.obj = arg;
            this.mHandler.sendMessage(msg);
        }
    }

    @Override // com.sds.coolots.calllog.DataUsageManagerInterface
    public void notifySwitchCall(int ToWhatCall) {
        if (this.mHandler != null) {
            Message msg = this.mHandler.obtainMessage();
            msg.what = 1002;
            msg.arg1 = ToWhatCall;
            this.mHandler.sendMessage(msg);
        }
    }

    @Override // com.sds.coolots.calllog.DataUsageManagerInterface
    public void notifyChangeDay() {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1003);
        }
    }

    public void procStartCall() {
        this.mIsStarted = true;
    }

    public long getCuttedTimeByDay(long time) {
        logI("getCuttedTimeByDay Input Time : " + time);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String strCuttedDateByday = df.format(Long.valueOf(time));
        try {
            logI("strCuttedDateByday Time : " + strCuttedDateByday);
            Date date = df.parse(strCuttedDateByday);
            long cuttedTimeByDay = date.getTime();
            logI("cuttedTimeByDay Time : " + cuttedTimeByDay);
            return cuttedTimeByDay;
        } catch (ParseException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public void procEndCall(boolean isOutGoingCall, boolean isVideoCall, boolean isConferenceCall) {
        if (!isStarted()) {
            logE("is not started befroe..");
            return;
        }
        if (!this.dataUsageDBAdaptor.isEnableSaveTotalUsage()) {
            logE("there is no Data_Usage Table In DB");
            return;
        }
        long[] trafficData = EngineInterface.getInstance().getCallDataTraffic();
        synchronized (this.mDataUsageDBMutex) {
            long curTime = getCurrMillTime();
            long cuttedTimeByDay = getCuttedTimeByDay(curTime);
            CallDataUsage calldatausage = this.dataUsageDBAdaptor.getCallDataUsageByDate(cuttedTimeByDay, trafficData[0] == 1);
            if (calldatausage != null) {
                logE("Network Type\t\t\t: " + trafficData[0]);
                logE("Audio Send Data\t\t: " + trafficData[1]);
                logE("Audio Receive Data\t: " + trafficData[2]);
                logE("Video Send Data\t\t: " + trafficData[3]);
                logE("Video Receive Data\t: " + trafficData[4]);
                logE("isOutgoing\t\t\t: " + isOutGoingCall);
                logE("isVideoCall\t\t\t: " + isVideoCall);
                logE("mInitialCallType    : " + this.mInitialCallType);
                logE("isConferenceCall\t\t: " + isConferenceCall);
                if (this.mInitialCallType == 0) {
                    if (isVideoCall) {
                        this.mInitialCallType = 2;
                    } else {
                        this.mInitialCallType = 1;
                    }
                }
                if (isOutGoingCall) {
                    if (this.mInitialCallType == 2) {
                        this.dataUsageDBAdaptor.saveCallDataUsage(cuttedTimeByDay, calldatausage.getDialledVoiceDU(), calldatausage.getDialledVideoDU() + trafficData[1] + trafficData[2] + trafficData[3] + trafficData[4], calldatausage.getRecvVoiceDU(), calldatausage.getRecvVideoDU(), calldatausage.getLastVoiceDU(), trafficData[1] + trafficData[2] + trafficData[3] + trafficData[4], trafficData[0] == 1);
                    } else if (this.mInitialCallType == 1) {
                        this.dataUsageDBAdaptor.saveCallDataUsage(cuttedTimeByDay, calldatausage.getDialledVoiceDU() + trafficData[1] + trafficData[2] + trafficData[3] + trafficData[4], calldatausage.getDialledVideoDU(), calldatausage.getRecvVoiceDU(), calldatausage.getRecvVideoDU(), trafficData[1] + trafficData[2] + trafficData[3] + trafficData[4], calldatausage.getLastVideoDU(), trafficData[0] == 1);
                    }
                } else if (this.mInitialCallType == 2) {
                    this.dataUsageDBAdaptor.saveCallDataUsage(cuttedTimeByDay, calldatausage.getDialledVoiceDU(), calldatausage.getDialledVideoDU(), calldatausage.getRecvVoiceDU(), calldatausage.getRecvVideoDU() + trafficData[1] + trafficData[2] + trafficData[3] + trafficData[4], calldatausage.getLastVoiceDU(), trafficData[1] + trafficData[2] + trafficData[3] + trafficData[4], trafficData[0] == 1);
                } else if (this.mInitialCallType == 1) {
                    this.dataUsageDBAdaptor.saveCallDataUsage(cuttedTimeByDay, calldatausage.getDialledVoiceDU(), calldatausage.getDialledVideoDU(), calldatausage.getRecvVoiceDU() + trafficData[1] + trafficData[2] + trafficData[3] + trafficData[4], calldatausage.getRecvVideoDU(), trafficData[1] + trafficData[2] + trafficData[3] + trafficData[4], calldatausage.getLastVideoDU(), trafficData[0] == 1);
                }
                if (trafficData[0] != 1) {
                    saveTotalDU(trafficData[1] + trafficData[2] + trafficData[3] + trafficData[4], true, false);
                } else {
                    saveTotalDU(trafficData[1] + trafficData[2] + trafficData[3] + trafficData[4], true, true);
                }
                setIsStarted(false);
                this.mInitialCallType = 0;
            }
        }
    }

    public void procSwitchCall(int ToWhatCall) {
        logI("switchCallProcess started.. ToWhatCall : " + ToWhatCall);
        if (!isStarted()) {
            logE("is not started befroe..");
            return;
        }
        long curTime = getCurrMillTime();
        if (ToWhatCall == 1) {
            if (!isUseVideo()) {
                logE(" is already voice call");
                return;
            } else {
                this.mVideoUsage += getVideoDataUsage(curTime);
                setIsUseVideo(false);
            }
        } else if (ToWhatCall == 2) {
            if (isUseVideo()) {
                logE(" is already video call");
                return;
            } else {
                setVideoBaseTime(curTime);
                setIsUseVideo(true);
            }
        } else {
            logE("Invalid ToWhatCall : " + ToWhatCall);
            return;
        }
        logI("switchCallProcess stopped..");
    }

    public void procChangeDay() {
    }

    @Override // com.sds.coolots.calllog.DataUsageManagerInterface
    public CallDataUsage getCallDataUsageByPeriod(long startDate, long endDate, boolean isWifi) {
        logI("getCallDataUsageByPeriod started..");
        long cuttedStartTimeByDay = getCuttedTimeByDay(startDate);
        long cuttedEndTimeByDay = getCuttedTimeByDay(endDate);
        logI("getCallDataUsageByPeriod stopped..");
        return this.dataUsageDBAdaptor.getCallDataUsageByPeriod(cuttedStartTimeByDay, cuttedEndTimeByDay, isWifi);
    }

    @Override // com.sds.coolots.calllog.DataUsageManagerInterface
    public void resetDU() {
        logI("resetDU started..");
        this.dataUsageDBAdaptor.resetDataUsage();
        logI("resetDU stopped..");
    }

    public class DUHandler extends Handler {
        public DUHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1000:
                    DataUsageManager.this.procStartCall();
                    break;
                case 1001:
                    StartArg argEndCall = (StartArg) msg.obj;
                    DataUsageManager.this.procEndCall(argEndCall.isOutoing(), argEndCall.isVideo(), argEndCall.isConference());
                    break;
                case 1002:
                    DataUsageManager.this.procSwitchCall(msg.arg1);
                    break;
                case 1003:
                    DataUsageManager.this.procChangeDay();
                    break;
                default:
                    DataUsageManager.this.logE("DUHandler Invalid Event : " + msg.what);
                    break;
            }
        }
    }

    @Override // com.sds.coolots.calllog.DataUsageManagerInterface
    public void initDataUsageManager() {
    }

    @Override // com.sds.coolots.calllog.DataUsageManagerInterface
    public void saveTotalDU(long dataAmount, boolean isFromEngine, boolean engineWIFI) {
        synchronized (this.mDataUsageDBMutex) {
            if (this.dataUsageDBAdaptor.isEnableSaveTotalUsage()) {
                long curTime = getCurrMillTime();
                long cuttedTimeByDay = getCuttedTimeByDay(curTime);
                TotalDataUsage totalDataUsage = this.dataUsageDBAdaptor.getTotalDataUsageByDate(cuttedTimeByDay);
                if (totalDataUsage != null) {
                    if (engineWIFI) {
                        long totalWifiUsageAmount = totalDataUsage.getWifiTotalDU() + dataAmount;
                        long total3GUsageAmount = totalDataUsage.get3GTotalDU();
                        this.dataUsageDBAdaptor.saveTotalDataUsage(cuttedTimeByDay, total3GUsageAmount, totalWifiUsageAmount);
                        logE("[DATA_USAGE] total data - 3g :  " + total3GUsageAmount + " wifi : " + totalWifiUsageAmount + " added data : " + dataAmount + " wifi : " + engineWIFI);
                    } else {
                        long totalWifiUsageAmount2 = totalDataUsage.getWifiTotalDU();
                        long total3GUsageAmount2 = totalDataUsage.get3GTotalDU() + dataAmount;
                        this.dataUsageDBAdaptor.saveTotalDataUsage(cuttedTimeByDay, total3GUsageAmount2, totalWifiUsageAmount2);
                        logE("[DATA_USAGE] total data - 3g :  " + total3GUsageAmount2 + " wifi : " + totalWifiUsageAmount2 + " added data : " + dataAmount + " wifi : " + engineWIFI);
                    }
                }
            }
        }
    }

    @Override // com.sds.coolots.calllog.DataUsageManagerInterface
    public long getWifiTotalDU() {
        return this.dataUsageDBAdaptor.getWifiTotalDU();
    }

    @Override // com.sds.coolots.calllog.DataUsageManagerInterface
    public long get3GTotalDU() {
        return this.dataUsageDBAdaptor.get3GTotalDU();
    }

    @Override // com.sds.coolots.calllog.DataUsageManagerInterface
    public long getTotalDU() {
        return this.dataUsageDBAdaptor.getTotalDU();
    }

    @Override // com.sds.coolots.calllog.DataUsageManagerInterface
    public boolean isProcessingDataReset() {
        return this.dataUsageDBAdaptor.isProcessingDataReset();
    }

    @Override // com.sds.coolots.calllog.DataUsageManagerInterface
    public void setProcessingDataReset(boolean dataReset) {
        this.dataUsageDBAdaptor.setProcessingDataReset(dataReset);
    }

    @Override // com.sds.coolots.calllog.DataUsageManagerInterface
    public void notifyStartCall(int initialCallType) {
        this.mInitialCallType = initialCallType;
        Message msg = this.mHandler.obtainMessage();
        msg.what = 1000;
        this.mHandler.sendMessage(msg);
    }
}
