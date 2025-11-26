package com.coolots.sse.calllog;

import android.os.Handler;
import com.coolots.chaton.calllog.model.CallLogDBData;
import com.coolots.chaton.calllog.model.CallLogData;
import com.coolots.chaton.calllog.model.CallLogList;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.sds.coolots.calllog.CallLogManagerInterface;
import com.sds.coolots.calllog.model.ConfUser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public class SSECallLogManager extends Handler implements CallLogManagerInterface {
    private Handler mActivityHandler = null;
    private CallLogList mCallLogList = new CallLogList();

    public ArrayList<CallLogData> findCallLog(CallLogDBData option, boolean isAddSeperator) {
        if (option == null) {
            option = new CallLogDBData();
        }
        return this.mCallLogList.selectCallLog(option, isAddSeperator);
    }

    public ArrayList<CallLogData> findCallLog(ArrayList<Integer> idList, boolean isAddSeperator) {
        return this.mCallLogList.selectCallLog(idList, isAddSeperator);
    }

    public int createCallLog(CallLogData value) {
        return 0;
    }

    public int createCallLog(ArrayList<CallLogData> value) {
        return 0;
    }

    public int deleteCallLog(CallLogData option) {
        return 0;
    }

    public void setCallLogActivityHandler(Handler handler) {
        this.mActivityHandler = handler;
    }

    @Override // com.sds.coolots.calllog.CallLogManagerInterface
    public boolean addCallLogP2P(int type, boolean isVideo, String calldate, int duration, String countrycode, String userid, String username, String phoneno, int hangupCode, String rejectMsg, boolean isSwitchCall, boolean isCallEnd) {
        return false;
    }

    @Override // com.sds.coolots.calllog.CallLogManagerInterface
    public boolean addCallLogSIP(int type, boolean isVideo, String calldate, int duration, String countrycode, String userid, String username, String phoneno, int hangupCode, boolean isSwitchCall) {
        return false;
    }

    @Override // com.sds.coolots.calllog.CallLogManagerInterface
    public int addCallLogCONFERENCE(int type, boolean isVideo, String calldate, int duration, ConfUser users, int hangupCode, long groupid, boolean isSwitchCall, boolean isCallEnd, int groupcallKey) {
        return 0;
    }

    @Override // com.sds.coolots.calllog.CallLogManagerInterface
    public boolean addRejectMessage(String userID, String rejectMsg, boolean isOutgoing, String userName) {
        return false;
    }

    @Override // com.sds.coolots.calllog.CallLogManagerInterface
    public boolean updateCallLog(String userID, String calldate, int duration) {
        return false;
    }

    @Override // com.sds.coolots.calllog.CallLogManagerInterface
    public void sendCallLogData(boolean isConference, int totalDuration) {
    }

    protected String calculateCurrentTimeInFormatyyyyMMddHHmmss() {
        long currentTimeMills = System.currentTimeMillis();
        Date currentDate = new Date(currentTimeMills);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        return formatter.format(currentDate);
    }

    protected String getLocalDate(String calldateGMT) {
        long currentLocalTimeMills = ChatONStringConvert.getInstance().convertGMT2LocalTime(calldateGMT);
        Date currentLocalDate = new Date(currentLocalTimeMills);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        return formatter.format(currentLocalDate);
    }

    public HashMap<Set<Long>, String> getGroupInfoMap() {
        return this.mCallLogList.selectGroupInfo();
    }
}
