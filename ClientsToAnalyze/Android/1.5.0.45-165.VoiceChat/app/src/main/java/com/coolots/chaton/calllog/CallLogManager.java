package com.coolots.chaton.calllog;

import android.content.ContentValues;
import android.os.Handler;
import android.os.Message;
import com.coolots.chaton.buddy.model.BuddyTable;
import com.coolots.chaton.calllog.model.CallLogDBData;
import com.coolots.chaton.calllog.model.CallLogData;
import com.coolots.chaton.calllog.model.CallLogList;
import com.coolots.chaton.calllog.noti.ChatONNotificationManager;
import com.coolots.chaton.common.controller.ChatOnResourceInterface;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.coolots.sso.calllog.ChatONCallLogData;
import com.coolots.sso.util.ChatONInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.calllog.CallLogManagerInterface;
import com.sds.coolots.calllog.model.CallLogUser;
import com.sds.coolots.calllog.model.ConfUser;
import com.sds.coolots.common.controller.DatabaseHelper;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.StrUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class CallLogManager extends Handler implements CallLogManagerInterface {
    private static final String CLASSNAME = "[CallLogManager]";
    private Handler mActivityHandler = null;
    private CallLogList mCallLogList = new CallLogList();
    private ArrayList<String> mDisconnectedUserList = new ArrayList<>();
    private ArrayList<String> mSuggestedUserList = new ArrayList<>();
    private ArrayList<CallLogDBData> mTotalMemberList = new ArrayList<>();
    private int mTotalDuration = 0;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public ArrayList<CallLogData> findCallLog(boolean isAddSeperator) {
        return this.mCallLogList.selectCallLog(new CallLogDBData(), isAddSeperator);
    }

    public ArrayList<CallLogData> findCallLog(CallLogDBData option, boolean isAddSeperator) {
        return this.mCallLogList.selectCallLog(option, isAddSeperator);
    }

    public ArrayList<CallLogData> findCallLog(long userNo, boolean isAddSeperator) {
        return this.mCallLogList.selectCallLog(userNo, isAddSeperator);
    }

    public ArrayList<CallLogData> findViewByCallLog(int searchtype, boolean isAddSeperator) {
        return this.mCallLogList.selectViewByCallLog(searchtype, isAddSeperator);
    }

    public ArrayList<CallLogData> findCallLog(ArrayList<Integer> idList, boolean isAddSeperator) {
        return this.mCallLogList.selectCallLog(idList, isAddSeperator);
    }

    public boolean createCallLogDB(CallLogDBData value) {
        if (value == null) {
            return false;
        }
        boolean zCreateCallLogDB = this.mCallLogList.createCallLogDB(value);
        if (this.mActivityHandler != null) {
            Message msg = new Message();
            msg.what = EventCode.EVENT_CALLLOG_ADD;
            msg.obj = value;
            this.mActivityHandler.sendMessage(msg);
            return zCreateCallLogDB;
        }
        return zCreateCallLogDB;
    }

    public int createCallLogDB(ArrayList<CallLogDBData> value) {
        if (value == null) {
            return ErrorCode.CALLLOG_ERR_UNSUITABLE_PARAM;
        }
        int iCreateCallLogDB = this.mCallLogList.createCallLogDB(value);
        if (this.mActivityHandler != null) {
            Message msg = new Message();
            msg.what = EventCode.EVENT_CALLLOG_ADD;
            msg.obj = value;
            this.mActivityHandler.sendMessage(msg);
            return iCreateCallLogDB;
        }
        return iCreateCallLogDB;
    }

    public int deleteCallLog(CallLogData option) {
        if (option == null) {
            option = new CallLogData();
        }
        int ret = this.mCallLogList.deleteCallLog(option);
        if (this.mActivityHandler != null) {
            this.mActivityHandler.sendEmptyMessage(8000);
        }
        return ret;
    }

    public int deleteCallLog(ArrayList<CallLogData> option) {
        if (option == null) {
            return ErrorCode.CALLLOG_ERR_UNSUITABLE_PARAM;
        }
        int iDeleteCallLog = this.mCallLogList.deleteCallLog(option);
        if (this.mActivityHandler != null) {
            this.mActivityHandler.sendEmptyMessage(8000);
            return iDeleteCallLog;
        }
        return iDeleteCallLog;
    }

    public int deleteOldestCallLog(boolean isGroupCallLog) {
        int ret = this.mCallLogList.deleteOldestCallLog(isGroupCallLog);
        if (this.mActivityHandler != null) {
            this.mActivityHandler.sendEmptyMessage(8000);
        }
        return ret;
    }

    public void setCallLogActivityHandler(Handler handler) {
        this.mActivityHandler = handler;
    }

    @Override // com.sds.coolots.calllog.CallLogManagerInterface
    public boolean addCallLogP2P(int type, boolean isVideo, String calldate, int duration, String countrycode, String userid, String username, String phoneno, int hangupCode, String rejectMsg, boolean isSwitchCall, boolean isCallEnd) {
        logI("<<RDJ>> addCallLogP2P() called!! isSwitchCall : " + isSwitchCall + " isCallEnd : " + isCallEnd);
        if (hangupCode == 301) {
            return false;
        }
        CallLogDBData cl = new CallLogDBData();
        ContentValues cv = new ContentValues();
        long userno = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getUserNoByUserIDWithNoException(userid);
        int mBuddyType = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getKindOfBuddy(userid);
        if (mBuddyType == 4 && !MainApplication.mConfig.getProfileUserID().equals(userid)) {
            this.mSuggestedUserList.add(userid);
        }
        this.mTotalDuration = duration;
        logE("calldate = " + calldate);
        cv.put(DatabaseHelper.KEY_CALLDATE, (calldate == null || calldate.equals("")) ? getCurrentLocalDate() : calldate);
        cv.put(DatabaseHelper.KEY_DURATION, Integer.valueOf(duration));
        cv.put(DatabaseHelper.KEY_CALLLOGTYPE, Integer.valueOf(type));
        cv.put(DatabaseHelper.KEY_CALLMETHOD, Integer.valueOf(!isVideo ? 6 : 7));
        cv.put(DatabaseHelper.KEY_USERNO, Long.valueOf(userno));
        cv.put(DatabaseHelper.KEY_USERID, userid != null ? userid : "");
        cv.put(DatabaseHelper.KEY_USERNAME, username != null ? username : "");
        cv.put(DatabaseHelper.KEY_PHONENO, phoneno != null ? phoneno : "");
        if (countrycode == null) {
            countrycode = "";
        }
        cv.put("countrycode", countrycode);
        cv.put(DatabaseHelper.KEY_GROUPCALLKEY, (Integer) 0);
        cv.put(DatabaseHelper.KEY_HANGUPCODE, Integer.valueOf(hangupCode));
        if (rejectMsg == null) {
            rejectMsg = "";
        }
        cv.put(DatabaseHelper.KEY_REJECTMSG, rejectMsg);
        cv.put(DatabaseHelper.KEY_GROUPID, (Long) 0L);
        cl.setContentValue(cv);
        if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            if (!isSwitchCall) {
                this.mTotalMemberList.add(cl);
            } else {
                boolean isExist = false;
                Iterator<CallLogDBData> it = this.mTotalMemberList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CallLogDBData cd = it.next();
                    if (cd.userid.equals(cl.userid)) {
                        cd.duration = cl.duration;
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    this.mTotalMemberList.add(cl);
                }
            }
            logE("<<kyj>>p2p mTotalMemberList size : " + this.mTotalMemberList.size());
        }
        if (!MainApplication.mPhoneManager.IsLinkagewithChatON() && !isSwitchCall && createCallLogDB(cl)) {
            MainApplication.mNativeInterfaceCreator.createNativeCallLogInterface().saveCallLog(cl);
            if (type == 2) {
                BuddyTable buddyTable = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getBuddyInfoForCallLogDetail(userid);
                String userDisplayName = null;
                if (buddyTable != null) {
                    userDisplayName = buddyTable.getDisplayName();
                }
                if (userDisplayName == null || userDisplayName.isEmpty()) {
                    userDisplayName = username;
                }
                if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                    showNotification(ChatONStringConvert.getInstance().convertGMT2LocalTime(calldate), userDisplayName, phoneno);
                }
            }
        }
        if (isCallEnd) {
            if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                ArrayList<ChatONCallLogData> dataList = new ArrayList<>();
                Iterator<CallLogDBData> it2 = this.mTotalMemberList.iterator();
                while (it2.hasNext()) {
                    CallLogDBData chatonVData = it2.next();
                    ChatONCallLogData data = new ChatONCallLogData();
                    chatonVData.setChatONCallLogData(data);
                    if (data.getUserid().equals(ChatONStringConvert.getInstance().removeFooter(MainApplication.mConfig.getProfileUserID()))) {
                        data.setDuration(this.mTotalDuration);
                    }
                    dataList.add(data);
                }
                logE("<<kyj>> sendCallLogData org size = " + this.mTotalMemberList.size() + " size = " + dataList.size());
                if (this.mTotalMemberList.size() > 1 && isSwitchCall) {
                    ((ChatONInterface) MainApplication.mChatONInterface).sendBroadcastCallLogData(dataList, true);
                } else {
                    ((ChatONInterface) MainApplication.mChatONInterface).sendBroadcastCallLogData(dataList, false);
                }
                this.mTotalMemberList.clear();
                this.mTotalDuration = 0;
                this.mDisconnectedUserList.clear();
            } else if (this.mSuggestedUserList != null && !this.mSuggestedUserList.isEmpty()) {
                Iterator<String> it3 = this.mSuggestedUserList.iterator();
                while (it3.hasNext()) {
                    String list = it3.next();
                    logI("<<RDJ>> Suggested User : " + list);
                }
                ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().addBuddySuggestion(this.mSuggestedUserList);
                this.mSuggestedUserList.clear();
            }
        }
        return false;
    }

    @Override // com.sds.coolots.calllog.CallLogManagerInterface
    public boolean addCallLogSIP(int type, boolean isVideo, String calldate, int duration, String countrycode, String userid, String username, String phoneno, int hangupCode, boolean isSwitchCall) {
        return false;
    }

    @Override // com.sds.coolots.calllog.CallLogManagerInterface
    public int addCallLogCONFERENCE(int type, boolean isVideo, String calldate, int duration, ConfUser users, int hangupCode, long groupid, boolean isSwitchCall, boolean isCallEnd, int prevGroupCallKey) {
        String username;
        String username2;
        CallLogData prevCalllog;
        logI("<<RDJ>> addCallLogCONFERENCE() called!! isCallEnd = " + isCallEnd + " prevGroupCallKey = " + prevGroupCallKey);
        int groupcallkey = 0;
        if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            if (isSwitchCall && prevGroupCallKey > 0) {
                groupcallkey = prevGroupCallKey;
            } else {
                groupcallkey = getIndexOfCallLog() + 1;
            }
        }
        String prevCalldate = null;
        int totalDuration = 0;
        ArrayList<CallLogDBData> clList = new ArrayList<>();
        ArrayList<String> disconnUser = new ArrayList<>();
        this.mTotalDuration = duration;
        if (users != null && !users.getConfUser().isEmpty()) {
            for (int i = 0; i < users.getConfUser().size(); i++) {
                boolean isCreateLog = true;
                CallLogDBData cl = new CallLogDBData();
                ContentValues cv = new ContentValues();
                CallLogUser user = (CallLogUser) users.getConfUser().get(i);
                int userState = (user.state == null || user.state.equals("")) ? 0 : Integer.parseInt(user.state);
                if (user.state == null || user.state.isEmpty() || user.state.equals("2") || user.state.equals(SimpleUserInfo.STATE_DENY) || user.state.equals("3")) {
                    disconnUser.add(user.userid);
                }
                int mBuddyType = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getKindOfBuddy(user.userid);
                if (mBuddyType == 4 && !MainApplication.mConfig.getProfileUserID().equals(user.userid)) {
                    this.mSuggestedUserList.add(user.userid);
                }
                if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                    logE("<<kyj>>1 mTotalMemberList size : " + this.mTotalMemberList.size());
                    CallLogDBData prevCallLogData = null;
                    if (isSwitchCall) {
                        if (user.isNewInvitedUser) {
                            prevCallLogData = null;
                        } else {
                            Iterator<CallLogDBData> it = this.mTotalMemberList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                CallLogDBData data = it.next();
                                if (data.userid.equals(user.userid)) {
                                    prevCallLogData = data;
                                    break;
                                }
                            }
                        }
                        if (prevCallLogData != null) {
                            boolean isDisconnectedUser = false;
                            if (this.mDisconnectedUserList.contains(prevCallLogData.userid)) {
                                isDisconnectedUser = true;
                            }
                            if (isDisconnectedUser) {
                                if (user.callStartTime != 0) {
                                    Date date = new Date(user.callStartTime);
                                    String connectedTime = StrUtil.convertDateToyyyyMMddHHmmss(date);
                                    if (connectedTime == null || connectedTime.isEmpty() || connectedTime.equals("0")) {
                                        connectedTime = StrUtil.convertDateToyyyyMMddHHmmss(new Date());
                                    }
                                    prevCalldate = connectedTime;
                                } else {
                                    prevCalldate = getCurrentLocalDate();
                                }
                                totalDuration = user.callDuration;
                            } else {
                                prevCallLogData.duration += user.callDuration;
                                prevCallLogData.callmethod = isVideo ? 11 : 10;
                            }
                        } else {
                            if (user.callStartTime != 0) {
                                Date date2 = new Date(user.callStartTime);
                                String connectedTime2 = StrUtil.convertDateToyyyyMMddHHmmss(date2);
                                if (connectedTime2 == null || connectedTime2.isEmpty() || connectedTime2.equals("0")) {
                                    connectedTime2 = StrUtil.convertDateToyyyyMMddHHmmss(new Date());
                                }
                                prevCalldate = connectedTime2;
                            } else {
                                prevCalldate = getCurrentLocalDate();
                            }
                            totalDuration = user.callDuration;
                        }
                    } else {
                        prevCalldate = (calldate == null || calldate.equals("")) ? getCurrentLocalDate() : calldate;
                        totalDuration = user.callDuration;
                    }
                } else if (isSwitchCall) {
                    if (prevGroupCallKey < 1 && user.isNewInvitedUser) {
                        prevCalllog = null;
                    } else if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                        prevCalllog = getPrevCalllogByUserID(user.userid, prevGroupCallKey);
                    } else {
                        prevCalllog = getPrevCalllogByUserNo(((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getUserNoByUserID(user.userid), prevGroupCallKey);
                    }
                    if (prevCalllog != null) {
                        if (prevCalllog.groupcallkey != null) {
                            boolean isDisconnectedUser2 = false;
                            Iterator<String> it2 = this.mDisconnectedUserList.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                String userid = it2.next();
                                if (prevCalllog.userInfo.get(0).userID.equals(userid)) {
                                    isDisconnectedUser2 = true;
                                    break;
                                }
                            }
                            if (isDisconnectedUser2) {
                                prevCalldate = (calldate == null || calldate.equals("")) ? getCurrentLocalDate() : calldate;
                                totalDuration = user.callDuration;
                            } else {
                                cv.put(DatabaseHelper.KEY_DURATION, Integer.valueOf(prevCalllog.userInfo.get(0).duration + user.callDuration));
                                this.mCallLogList.updateCallLogDB(cv, prevCalllog._id);
                                isCreateLog = false;
                            }
                        } else {
                            this.mCallLogList.deleteCallLog(prevCalllog);
                            prevCalldate = prevCalllog.userInfo.get(0).calldate;
                            totalDuration = user.callDuration + prevCalllog.userInfo.get(0).duration;
                        }
                    } else {
                        prevCalldate = (calldate == null || calldate.equals("")) ? getCurrentLocalDate() : calldate;
                        totalDuration = user.callDuration;
                    }
                } else {
                    prevCalldate = (calldate == null || calldate.equals("")) ? getCurrentLocalDate() : calldate;
                    totalDuration = user.callDuration;
                }
                if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                    if (MainApplication.mConfig.getProfileUserID().equals(user.userid)) {
                        isCreateLog = !isSwitchCall || this.mTotalMemberList.size() == 1;
                    }
                } else if (MainApplication.mConfig.getProfileUserID().equals(user.userid)) {
                    isCreateLog = !isSwitchCall || prevGroupCallKey == 0;
                }
                if (isCreateLog) {
                    logE("prevCalldate = " + prevCalldate + " totalDuration = " + totalDuration);
                    cv.put(DatabaseHelper.KEY_CALLDATE, prevCalldate);
                    cv.put(DatabaseHelper.KEY_DURATION, Integer.valueOf(totalDuration));
                    cv.put(DatabaseHelper.KEY_CALLLOGTYPE, Integer.valueOf(user.calllogtype));
                    cv.put(DatabaseHelper.KEY_CALLMETHOD, Integer.valueOf(!isVideo ? 10 : 11));
                    cv.put(DatabaseHelper.KEY_USERNO, Long.valueOf(((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getUserNoByUserIDWithNoException(user.userid)));
                    cv.put(DatabaseHelper.KEY_USERID, user.userid != null ? user.userid : "");
                    cv.put(DatabaseHelper.KEY_USERNAME, user.username != null ? user.username : "");
                    cv.put(DatabaseHelper.KEY_PHONENO, user.phoneno != null ? user.phoneno : "");
                    cv.put("countrycode", user.countrycode != null ? user.countrycode : "");
                    cv.put(DatabaseHelper.KEY_GROUPCALLKEY, Integer.valueOf(groupcallkey));
                    if (userState <= 10) {
                        userState = hangupCode;
                    }
                    cv.put(DatabaseHelper.KEY_HANGUPCODE, Integer.valueOf(userState));
                    cv.put(DatabaseHelper.KEY_REJECTMSG, user.rejectMsg != null ? user.rejectMsg : "");
                    cv.put(DatabaseHelper.KEY_GROUPID, Long.valueOf(groupid));
                    cl.setContentValue(cv);
                    clList.add(cl);
                    if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                        MainApplication.mNativeInterfaceCreator.createNativeCallLogInterface().saveCallLog(cl);
                    }
                }
            }
            if (clList != null && !clList.isEmpty()) {
                logI("<<RDJ>> createCallLogDB() list size=" + clList.size());
                if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                    logE("<<kyj>>2 mTotalMemberList size : " + this.mTotalMemberList.size());
                    if (!isSwitchCall) {
                        this.mTotalMemberList.addAll(clList);
                    } else {
                        ArrayList<CallLogDBData> addedUserList = new ArrayList<>();
                        Iterator<CallLogDBData> it3 = clList.iterator();
                        while (it3.hasNext()) {
                            CallLogDBData oldData = it3.next();
                            boolean isExist = false;
                            boolean isDisconnected = false;
                            Iterator<CallLogDBData> it4 = this.mTotalMemberList.iterator();
                            while (it4.hasNext()) {
                                CallLogDBData newData = it4.next();
                                if (oldData.userid.equals(newData.userid)) {
                                    isExist = true;
                                    if (this.mDisconnectedUserList.contains(oldData.userid)) {
                                        isDisconnected = true;
                                    }
                                    if (!isDisconnected) {
                                        newData.groupcallkey = oldData.groupcallkey;
                                    }
                                }
                            }
                            if (!isExist) {
                                addedUserList.add(oldData);
                            } else if (isDisconnected) {
                                addedUserList.add(oldData);
                                if (!disconnUser.contains(oldData.userid) && this.mDisconnectedUserList.contains(oldData.userid)) {
                                    this.mDisconnectedUserList.remove(oldData.userid);
                                }
                            }
                        }
                        if (!addedUserList.isEmpty()) {
                            this.mTotalMemberList.addAll(addedUserList);
                        }
                    }
                }
            }
            if (type == 2) {
                CallLogUser caller = null;
                boolean isIncludeProfileID = false;
                Iterator it5 = users.getConfUser().iterator();
                while (it5.hasNext()) {
                    CallLogUser user2 = (CallLogUser) it5.next();
                    if (user2.calllogtype == 2 && !user2.userid.equals(MainApplication.mConfig.getProfileUserID())) {
                        caller = user2;
                    }
                    if (user2.userid.equals(MainApplication.mConfig.getProfileUserID())) {
                        isIncludeProfileID = true;
                    }
                }
                if (caller == null) {
                    logI("There is not Missed User!!!!");
                    caller = (CallLogUser) users.getConfUser().get(0);
                }
                BuddyTable buddyTable = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getBuddyInfoForCallLogDetail(caller.userid);
                if (buddyTable == null || (username = buddyTable.getDisplayName()) == null || username.isEmpty()) {
                    username = caller.username;
                }
                if (isIncludeProfileID) {
                    username2 = String.valueOf(username) + " (" + (users.getConfUser().size() - 1) + ")";
                } else {
                    username2 = String.valueOf(username) + " (" + users.getConfUser().size() + ")";
                }
                if (!MainApplication.mPhoneManager.IsLinkagewithChatON() && calldate != null) {
                    showNotification(ChatONStringConvert.getInstance().convertGMT2LocalTime(calldate), username2, "");
                }
            }
            Iterator<String> it6 = disconnUser.iterator();
            while (it6.hasNext()) {
                String newuser = it6.next();
                if (this.mDisconnectedUserList.contains(newuser)) {
                    this.mDisconnectedUserList.remove(newuser);
                }
            }
            this.mDisconnectedUserList.addAll(disconnUser);
        }
        if (isCallEnd) {
            if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                ArrayList<ChatONCallLogData> dataList = new ArrayList<>();
                Iterator<CallLogDBData> it7 = this.mTotalMemberList.iterator();
                while (it7.hasNext()) {
                    CallLogDBData chatonVData = it7.next();
                    ChatONCallLogData data2 = new ChatONCallLogData();
                    chatonVData.setChatONCallLogData(data2);
                    if (data2.getUserid().equals(ChatONStringConvert.getInstance().removeFooter(MainApplication.mConfig.getProfileUserID()))) {
                        data2.setDuration(this.mTotalDuration);
                    }
                    dataList.add(data2);
                }
                logE("<<kyj>> sendCallLogData org size = " + this.mTotalMemberList.size() + " size = " + dataList.size());
                ((ChatONInterface) MainApplication.mChatONInterface).sendBroadcastCallLogData(dataList, true);
                this.mTotalMemberList.clear();
                this.mTotalDuration = 0;
            } else if (this.mSuggestedUserList != null && !this.mSuggestedUserList.isEmpty()) {
                Iterator<String> it8 = this.mSuggestedUserList.iterator();
                while (it8.hasNext()) {
                    String list = it8.next();
                    logI("<<RDJ>> Suggested User : " + list);
                }
                ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().addBuddySuggestion(this.mSuggestedUserList);
                this.mSuggestedUserList.clear();
            }
            this.mDisconnectedUserList.clear();
        }
        return groupcallkey;
    }

    @Override // com.sds.coolots.calllog.CallLogManagerInterface
    public boolean addRejectMessage(String userID, String rejectMsg, boolean isOutgoing, String userName) {
        logI("addRejectMessage()!!");
        boolean result = false;
        CallLogDBData cl = new CallLogDBData();
        ContentValues cv = new ContentValues();
        long userno = 0;
        if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            userno = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getUserNoByUserID(userID);
        }
        if (userName == null || userName.equals("")) {
            userName = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getDisplayNameByUserID(userID);
        }
        cv.put(DatabaseHelper.KEY_CALLDATE, getCurrentLocalDate());
        cv.put(DatabaseHelper.KEY_DURATION, (Integer) 0);
        cv.put(DatabaseHelper.KEY_CALLLOGTYPE, Integer.valueOf(isOutgoing ? 1 : 0));
        cv.put(DatabaseHelper.KEY_CALLMETHOD, (Integer) 12);
        cv.put(DatabaseHelper.KEY_USERNO, Long.valueOf(userno));
        cv.put(DatabaseHelper.KEY_USERID, userID);
        cv.put(DatabaseHelper.KEY_USERNAME, userName);
        cv.put(DatabaseHelper.KEY_PHONENO, "");
        cv.put("countrycode", "");
        cv.put(DatabaseHelper.KEY_GROUPCALLKEY, (Integer) 0);
        cv.put(DatabaseHelper.KEY_HANGUPCODE, (Integer) 0);
        cv.put(DatabaseHelper.KEY_REJECTMSG, rejectMsg);
        cv.put(DatabaseHelper.KEY_GROUPID, (Long) 0L);
        cl.setContentValue(cv);
        if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            result = createCallLogDB(cl);
            if (!isOutgoing) {
                MainApplication.mCallNotification.showRejectMessageNotification(userID, rejectMsg);
            }
        } else {
            this.mTotalMemberList.add(cl);
            ArrayList<ChatONCallLogData> dataList = new ArrayList<>();
            Iterator<CallLogDBData> it = this.mTotalMemberList.iterator();
            while (it.hasNext()) {
                CallLogDBData chatonVData = it.next();
                ChatONCallLogData data = new ChatONCallLogData();
                chatonVData.setChatONCallLogData(data);
                dataList.add(data);
            }
            logE("<<kyj>> sendCallLogData org size = " + this.mTotalMemberList.size() + " size = " + dataList.size());
            ((ChatONInterface) MainApplication.mChatONInterface).sendBroadcastCallLogData(dataList, false);
            this.mTotalMemberList.clear();
            this.mTotalDuration = 0;
        }
        return result;
    }

    @Override // com.sds.coolots.calllog.CallLogManagerInterface
    public boolean updateCallLog(String userID, String calldate, int duration) {
        logI("updateCallLog() called!!");
        ContentValues cv = new ContentValues();
        CallLogData calllog = getCallLogConferenceToP2P(userID);
        if (calllog != null) {
            int totalDuration = calllog.userInfo.get(0).duration + duration;
            logI("<<RDJ>> calllog.duration = " + calllog.userInfo.get(0).duration);
            logI("<<RDJ>> " + duration + " millsec more P2P called with " + userID);
            logI("<<RDJ>> total duration = " + totalDuration);
            cv.put(DatabaseHelper.KEY_DURATION, Integer.valueOf(totalDuration));
            this.mCallLogList.updateCallLogDB(cv, calllog._id);
        }
        return false;
    }

    @Override // com.sds.coolots.calllog.CallLogManagerInterface
    public void sendCallLogData(boolean isConference, int totalDuration) {
        logI("sendCallLogData() isChangeToConferece  : " + isConference + " totalDuration : " + totalDuration);
        ArrayList<ChatONCallLogData> dataList = new ArrayList<>();
        Iterator<CallLogDBData> it = this.mTotalMemberList.iterator();
        while (it.hasNext()) {
            CallLogDBData chatonVData = it.next();
            ChatONCallLogData data = new ChatONCallLogData();
            chatonVData.setChatONCallLogData(data);
            if (data.getUserid().equals(ChatONStringConvert.getInstance().removeFooter(MainApplication.mConfig.getProfileUserID()))) {
                data.setDuration(totalDuration);
            }
            dataList.add(data);
        }
        logE("<<kyj>> sendCallLogData org size = " + this.mTotalMemberList.size() + " size = " + dataList.size());
        if (!isConference && this.mTotalMemberList.size() == 1) {
            ((ChatONInterface) MainApplication.mChatONInterface).sendBroadcastCallLogData(dataList, false);
        } else if (this.mTotalMemberList.size() > 1) {
            ((ChatONInterface) MainApplication.mChatONInterface).sendBroadcastCallLogData(dataList, true);
        }
        this.mTotalMemberList.clear();
        this.mTotalDuration = 0;
        this.mDisconnectedUserList.clear();
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
        String callDate = formatter.format(currentLocalDate);
        return callDate;
    }

    private String getCurrentLocalDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        long currentDateLong = System.currentTimeMillis();
        long localDateLong = ChatONStringConvert.getInstance().convertGMT2LocalTime(currentDateLong);
        String localDate = formatter.format(Long.valueOf(ChatONStringConvert.getInstance().convertLocalTime2GMT(localDateLong)));
        return localDate;
    }

    public HashMap<Set<Long>, String> getGroupInfoMap() {
        return this.mCallLogList.selectGroupInfo();
    }

    public int getIndexOfCallLog() {
        return this.mCallLogList.selectIndexOfCallLog();
    }

    public int getCountCallLog() {
        return this.mCallLogList.selectCountCallLog();
    }

    public ArrayList<CallLogData> getRejectedCalllog(boolean isAddSeperator) {
        return this.mCallLogList.selectRejectedCalllog(isAddSeperator);
    }

    public ArrayList<CallLogData> getMissedCalllog(boolean isAddSeperator) {
        return this.mCallLogList.selectMissedCalllog(isAddSeperator);
    }

    private CallLogData getPrevCalllogByUserNo(long userNo, int groupcallKey) {
        return this.mCallLogList.getLatestCalllogByUserNo(userNo, groupcallKey);
    }

    private CallLogData getPrevCalllogByUserID(String userID, int groupcallKey) {
        return this.mCallLogList.getLatestCalllogByUserID(userID, groupcallKey);
    }

    private CallLogData getCallLogConferenceToP2P(String userID) {
        return this.mCallLogList.getCalllogConferenceToP2P(userID);
    }

    protected void showNotification(long callSeconds, String username, String phoneNumber) {
        ChatONNotificationManager.getInstance().notifyMissedCall(callSeconds, username, phoneNumber, ((ChatOnResourceInterface) MainApplication.mResources).getMissedCallIcon(), ((ChatOnResourceInterface) MainApplication.mResources).getMissedCallTicker(), ((ChatOnResourceInterface) MainApplication.mResources).getMissedCallTitle(), ((ChatOnResourceInterface) MainApplication.mResources).getMissedCallsTitle(), ((ChatOnResourceInterface) MainApplication.mResources).getMissedCallsMsg());
    }
}
