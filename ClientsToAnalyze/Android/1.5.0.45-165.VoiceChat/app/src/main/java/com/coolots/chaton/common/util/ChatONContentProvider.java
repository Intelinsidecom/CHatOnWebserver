package com.coolots.chaton.common.util;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.view.layout.InCallQuickPanel;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.chaton.setting.update.ChatONVApkUpdate;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.coolots.sso.util.ChatONVAPII;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.controller.DatabaseHelper;
import com.sds.coolots.common.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class ChatONContentProvider extends ContentProvider {
    private static final int ACCOUNT_AVAILABLE = 3;
    private static final String ACCOUNT_AVAILABLE_URI_STR = "content://com.coolots.chaton/account";
    private static final int BUDDY_INFO = 1;
    private static final String BUDDY_URI_STR = "content://com.coolots.chaton/buddy";
    private static final int CALL_DURATION = 12;
    private static final String CALL_DURATION_URI_STR = "content://com.coolots.chaton/callduration";
    private static final int CALL_STATE = 14;
    private static final String CALL_STATE_URI_STR = "content://com.coolots.chaton/callstate";
    private static final int CONFERENCECALL = 9;
    private static final String CONFERENCECALL_AVAILABLE_URI_STR = "content://com.coolots.chaton/outgoingconferencecall";
    private static final String CONFERENCECALL_MAX_MEMBER_URI_STR = "content://com.coolots.chaton/maxconferencecallnum";
    private static final int CONFERENCECALL_MAX_NUM = 10;
    private static final int CREATE_ACCOUNT = 6;
    private static final String CREATE_ACCOUNT_AVAILABLE_URI_STR = "content://com.coolots.chaton/create_account";
    private static final String DATABASE_NAME = "vappbuddy.db";
    private static final int GET_CALL_MEMBER = 16;
    private static final String GET_CALL_MEMBER_URI_STR = "content://com.coolots.chaton/get_call_member";
    private static final int GET_CALL_TYPE = 17;
    private static final String GET_CALL_TYPE_URI_STR = "content://com.coolots.chaton/get_call_type";
    private static final int GET_LATEST_VERSION = 18;
    private static final String GET_LATEST_VERSION_URI_STR = "content://com.coolots.chaton/get_latest_version";
    private static final int IS_CALLING = 13;
    private static final String IS_CALLING_URI_STR = "content://com.coolots.chaton/iscalling";
    private static final int KEY_INFO = 5;
    private static final String KEY_INIT_URI_STR = "content://com.coolots.chaton/key_init";
    private static final String KEY_URI_STR = "content://com.coolots.chaton/key";
    private static final int NORMAL_BUDDY_INFO = 4;
    private static final String NORMAL_BUDDY_URI_STR = "content://com.coolots.chaton/normalbuddy";
    private static final int P2PCALL = 8;
    private static final String P2PCALL_AVAILABLE_URI_STR = "content://com.coolots.chaton/outgoingcall";
    private static final int PROFILE_IMAGE = 2;
    private static final String PROFILE_IMAGE_URI_STR = "file:///data/data/com.coolots.chaton/files/images/buddy/";
    public static final String QUICKPANNEL_END_CALL = "1";
    public static final String QUICKPANNEL_SHOW_CALL = "0";
    private static final int REMOTE_CALL_ACTIVITY = 11;
    private static final String REMOTE_CALL_ACTIVITY_URI_STR = "content://com.coolots.chaton/remotecallactivity";
    private static final int REMOVE_ACCOUNT = 7;
    private static final String REMOVE_ACCOUNT_AVAILABLE_URI_STR = "content://com.coolots.chaton/remove_account";
    private static final int SET_LOG_DISPLAY = 19;
    private static final String SET_LOG_DISPLAY_URI_STR = "content://com.coolots.chaton/set_log_display";
    private static final Set<String> allowedPackages;
    private static boolean mAccessAuthority;
    private static final ReentrantLock mDatabaseLock;
    private static final List<String> uriList = new ArrayList();
    private static final UriMatcher uriMatcher = new UriMatcher(-1);
    private ChatONDatabaseHelper mDbHelper = null;
    private Handler mUpdateHandler = new Handler() { // from class: com.coolots.chaton.common.util.ChatONContentProvider.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == MessageInfo.VersionInfoAsk.getDispatchCode()) {
                int retV = ChatONVApkUpdate.getInstance().isLatestVersionNSaveVersionInfo(msg);
                String lastVersionString = ChatONSettingData.getInstance().getLastVersionName();
                MainApplication.mChatONInterface.sendBroadcastUgradeNewApk(lastVersionString, retV, ChatONVApkUpdate.getInstance().getDownloadURL());
            }
            super.handleMessage(msg);
        }
    };
    private int retryCount = 0;
    private final int RETRY_COUNT = 5;

    private void logE(String message) {
        Log.m2958e("[ChatONContentProvider]" + message);
    }

    private void logI(String message) {
        Log.m2963i("[ChatONContentProvider]" + message);
    }

    public ChatONContentProvider() {
        logI("ChatONContentProvider new instance");
    }

    static {
        uriMatcher.addURI("com.coolots.chaton", "buddy", 1);
        uriMatcher.addURI("com.coolots.chaton", "profileImage/#", 2);
        uriMatcher.addURI("com.coolots.chaton", "account", 3);
        uriMatcher.addURI("com.coolots.chaton", "normalbuddy", 4);
        uriMatcher.addURI("com.coolots.chaton", "key", 5);
        uriMatcher.addURI("com.coolots.chaton", "create_account", 6);
        uriMatcher.addURI("com.coolots.chaton", "remove_account", 7);
        uriMatcher.addURI("com.coolots.chaton", "outgoingcall", 8);
        uriMatcher.addURI("com.coolots.chaton", "outgoingconferencecall", 9);
        uriMatcher.addURI("com.coolots.chaton", "maxconferencecallnum", 10);
        uriMatcher.addURI("com.coolots.chaton", "remotecallactivity", 11);
        uriMatcher.addURI("com.coolots.chaton", "callduration", 12);
        uriMatcher.addURI("com.coolots.chaton", "iscalling", 13);
        uriMatcher.addURI("com.coolots.chaton", "callstate", 14);
        uriMatcher.addURI("com.coolots.chaton", "get_call_member", 16);
        uriMatcher.addURI("com.coolots.chaton", "get_call_type", 17);
        uriMatcher.addURI("com.coolots.chaton", "get_latest_version", 18);
        uriMatcher.addURI("com.coolots.chaton", "set_log_display", 19);
        uriList.add(BUDDY_URI_STR);
        uriList.add(NORMAL_BUDDY_URI_STR);
        uriList.add(KEY_URI_STR);
        uriList.add(KEY_INIT_URI_STR);
        uriList.add(PROFILE_IMAGE_URI_STR);
        uriList.add(ACCOUNT_AVAILABLE_URI_STR);
        uriList.add(CREATE_ACCOUNT_AVAILABLE_URI_STR);
        uriList.add(REMOVE_ACCOUNT_AVAILABLE_URI_STR);
        uriList.add(P2PCALL_AVAILABLE_URI_STR);
        uriList.add(CONFERENCECALL_AVAILABLE_URI_STR);
        uriList.add(CONFERENCECALL_MAX_MEMBER_URI_STR);
        uriList.add(REMOTE_CALL_ACTIVITY_URI_STR);
        uriList.add(CALL_DURATION_URI_STR);
        uriList.add(IS_CALLING_URI_STR);
        uriList.add(CALL_STATE_URI_STR);
        uriList.add(GET_CALL_MEMBER_URI_STR);
        uriList.add(GET_CALL_TYPE_URI_STR);
        uriList.add(GET_LATEST_VERSION_URI_STR);
        uriList.add(SET_LOG_DISPLAY_URI_STR);
        allowedPackages = new HashSet();
        allowedPackages.add("com.sec.chaton");
        allowedPackages.add("com.sec.chatonforcanada");
        mDatabaseLock = new ReentrantLock();
        mAccessAuthority = false;
    }

    static class ChatONDatabaseHelper extends SQLiteOpenHelper {
        private static final String CLASSNAME = "[ChatONContentProvider - ChatONDatabaseHelper]";

        private void logE(String message) {
            Log.m2958e(CLASSNAME + message);
        }

        ChatONDatabaseHelper(Context context) {
            super(context, ChatONContentProvider.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 24);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase database) {
            logE("onCreate()");
            DatabaseHelper.onCreateTable(database, ChatONContentProvider.mDatabaseLock);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
            logE("onUpgrade()");
            DatabaseHelper.isNeedDBUpgrade = true;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri arg0, String arg1, String[] arg2) {
        mAccessAuthority = false;
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        if (!mAccessAuthority) {
            logE("invalid access path");
            return null;
        }
        mAccessAuthority = false;
        if (!checkChatONVState()) {
            logE("getType() ChatONV is not enable!! uri : " + uriMatcher.match(uri));
            return null;
        }
        if (uriMatcher.match(uri) == 12) {
            logI("CALL_DURATION");
            if (isCallConnectedState()) {
                Date cTime = MainApplication.mPhoneManager.getPhoneStateMachine().getCallConnectedTime();
                logI("CALL_DURATION call connect time: " + cTime.toString());
                Date nowTime = new Date();
                long duration = nowTime.getTime() - cTime.getTime();
                logI("CALL_DURATION duration: " + duration);
                return Integer.toString((int) (duration / 1000));
            }
            return null;
        }
        if (uriMatcher.match(uri) == 13) {
            logI("IS_CALLING");
            if (!isCallActiveState()) {
                return null;
            }
            logI("IS_CALLING success");
            return "success";
        }
        if (uriMatcher.match(uri) == 14) {
            logI("CALL_STATE");
            CallStatusData callInfo = new CallStatusData();
            MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
            int callState = callInfo.getCallState();
            if (!callInfo.isValidity()) {
                logE("CALL_STATE call info is not validation");
                return null;
            }
            int translatedCallState = ((VAppPhoneManager) MainApplication.mPhoneManager).getSSOManager().translateCallState(callState);
            logI("CALL_STATE callState: " + ChatONVAPII.toCallStateString(callState) + "translatedCallState: " + ChatONVAPII.toCallStateString(translatedCallState));
            return Integer.toString(translatedCallState);
        }
        if (uriMatcher.match(uri) == 16) {
            logI("GET_CALL_MEMBER");
            CallStatusData callInfo2 = new CallStatusData();
            MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo2);
            int callState2 = callInfo2.getCallState();
            if (!callInfo2.isValidity()) {
                logE("GET_CALL_MEMBER call info is not validation");
                return null;
            }
            logI("GET_CALL_MEMBER call state: " + callState2);
            String membersID = "";
            Destination destination = callInfo2.getDestination();
            if (destination.getDestinationType() == 4) {
                ArrayList<SimpleUserInfo> confMembers = callInfo2.getDestination().getConferenceMember();
                Iterator<SimpleUserInfo> it = confMembers.iterator();
                while (it.hasNext()) {
                    SimpleUserInfo confMember = it.next();
                    if ("1".equals(confMember.getStatus()) || "0".equals(confMember.getStatus())) {
                        logI("- connected member: " + confMember.getUserID());
                        logI("- connected member name: " + confMember.getUserName());
                        membersID = String.valueOf(membersID) + confMember.getUserName() + ChatONVAPII.USERID_DELEMETER;
                    }
                }
                logI("1:N connected member: " + destination.getString());
                return membersID;
            }
            logI("1:1 connected member: " + destination.getString());
            if (callInfo2.isOutGoingCall()) {
                logI("<outgoing> 1:1 connected member name: " + ChatOnService.createService(MainApplication.mContext).getChatOnBuddyName(ChatONStringConvert.getInstance().removeFooter(destination.getString())));
                String membersID2 = String.valueOf(ChatOnService.createService(MainApplication.mContext).getChatOnBuddyName(ChatONStringConvert.getInstance().removeFooter(destination.getString()))) + ChatONVAPII.USERID_DELEMETER;
                return membersID2;
            }
            logI("<incoming> 1:1 connected member name: " + callInfo2.getHostDisplayName());
            String membersID3 = String.valueOf(callInfo2.getHostDisplayName()) + ChatONVAPII.USERID_DELEMETER;
            return membersID3;
        }
        if (uriMatcher.match(uri) == 18) {
            logI("LATEST_VERSION");
            ChatONVApkUpdate.getInstance().checkVersion(this.mUpdateHandler);
            return null;
        }
        return null;
    }

    private boolean isCallActiveState() {
        logI("isCallActiveState()");
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        int callState = callInfo.getCallState();
        if (!callInfo.isValidity()) {
            logE("call info is not validation");
            return false;
        }
        if (callState != 0 && callState != 1 && callState != 2 && callState != 4 && callState != 5) {
            logE("current state is not active");
            return false;
        }
        logI("call state: " + callState);
        return true;
    }

    private boolean isCallConnectedState() {
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        int callState = callInfo.getCallState();
        if (!callInfo.isValidity()) {
            logE("call info is not validation");
            return false;
        }
        if (callState != 2 && callState != 4 && callState != 5) {
            logE("current state is not calling");
            return false;
        }
        logI("call state: " + callState);
        return true;
    }

    private boolean checkCallingPackageFromUID(Context context, String key) {
        if (!allowedPackages.contains(key)) {
            logE("It`s not ChatON package!!");
            return false;
        }
        boolean result = false;
        int callingUID = Binder.getCallingUid();
        logI("callingUID = " + callingUID);
        if (callingUID >= 10000 && callingUID <= 19999) {
            if (allowedPackages.contains(context.getPackageManager().getNameForUid(callingUID))) {
                result = true;
            }
        } else {
            List<String> packageList = Arrays.asList(context.getPackageManager().getPackagesForUid(callingUID));
            Iterator<String> it = packageList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String name = it.next();
                if (allowedPackages.contains(name)) {
                    result = true;
                    break;
                }
            }
        }
        if (!result) {
            logE("It`s not allowed package!!");
            return result;
        }
        return result;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues cv) {
        mAccessAuthority = false;
        if (!checkChatONVState()) {
            logE("insert() ChatONV is not enable!! uri : " + uriMatcher.match(uri));
            return null;
        }
        if (uriMatcher.match(uri) == 5) {
            logI("KEY_INFO");
            String key = cv.getAsString("key");
            String sFunction = cv.getAsString("function");
            if (key == null || key.isEmpty() || !checkCallingPackageFromUID(getContext(), key)) {
                return null;
            }
            ChatONVRestrictAccess check = new ChatONVRestrictAccess(getContext());
            if (check.check(key)) {
                if (sFunction != null && !sFunction.isEmpty() && !uriList.contains(sFunction)) {
                    logE("not supported function");
                    return Uri.parse("content://com.coolots.chaton/not_supported_function");
                }
                mAccessAuthority = true;
                String myUserID = MainApplication.mConfig.getProfileUserID();
                if (myUserID == null || myUserID.isEmpty()) {
                    logE("account is null");
                    return Uri.parse("content://com.coolots.chaton/no_account");
                }
                return uri;
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        mAccessAuthority = false;
        try {
            this.mDbHelper = new ChatONDatabaseHelper(getContext());
            this.mDbHelper.getReadableDatabase();
            return true;
        } catch (SQLiteException e) {
            logE("<openDatabase> open error!!!! " + e.getMessage());
            return false;
        }
    }

    private void waitForFillVariables() throws InterruptedException {
        logE("waitForFillVariables()++");
        if (!MainApplication.mIsFinishInit) {
            try {
                logI("wait ...");
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.retryCount < 5) {
                this.retryCount++;
                waitForFillVariables();
            }
        }
        logI("waitForFillVariables()--");
    }

    private boolean checkChatONVState() throws InterruptedException {
        boolean isEnable = true;
        waitForFillVariables();
        logI("retryCount = " + this.retryCount);
        if (this.retryCount >= 5) {
            isEnable = false;
        }
        this.retryCount = 0;
        return isEnable;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) throws NumberFormatException {
        String sql;
        if (!mAccessAuthority) {
            logE("invalid access path");
            return null;
        }
        mAccessAuthority = false;
        if (!checkChatONVState()) {
            logE("query() ChatONV is not enable!! uri : " + uriMatcher.match(uri));
            return null;
        }
        if (uriMatcher.match(uri) == 8) {
            logI("P2PCALL");
            logI("P2PCALL, " + selectionArgs);
            if ("1".equals(selectionArgs[0])) {
                ((VAppPhoneManager) MainApplication.mPhoneManager).getSSOManager().videoDCallWithCaller(selectionArgs[2], null, selectionArgs[1], selectionArgs[3], false);
            } else {
                ((VAppPhoneManager) MainApplication.mPhoneManager).getSSOManager().voiceDCallWithCaller(selectionArgs[2], null, selectionArgs[1], selectionArgs[3], false);
            }
            return null;
        }
        if (uriMatcher.match(uri) == 9) {
            logI("CONFERENCECALL");
            for (int i = 0; i < selectionArgs.length; i++) {
                logI("selectionArgs [" + i + "] : " + selectionArgs[i]);
            }
            String groupName = selectionArgs[3];
            if (groupName.equals("null")) {
                groupName = null;
            }
            int memberCount = Integer.parseInt(selectionArgs[4]);
            List<String> ids = new ArrayList<>();
            for (int i2 = 5; i2 < memberCount + 5; i2++) {
                ids.add(selectionArgs[i2]);
            }
            if ("1".equals(selectionArgs[0])) {
                ((VAppPhoneManager) MainApplication.mPhoneManager).getSSOManager().groupVideoDCallWithCaller(ids, null, selectionArgs[1], selectionArgs[2], false, groupName);
            } else {
                ((VAppPhoneManager) MainApplication.mPhoneManager).getSSOManager().groupVoiceDCallWithCaller(ids, null, selectionArgs[1], selectionArgs[2], false, groupName);
            }
            return null;
        }
        if (uriMatcher.match(uri) == 6) {
            logI("CREATE_ACCOUNT");
            String birthday = selectionArgs[7];
            if (birthday.equals("null")) {
                birthday = null;
            }
            ((VAppPhoneManager) MainApplication.mPhoneManager).getSSOManager().createAccount(selectionArgs[0], selectionArgs[1], selectionArgs[2], selectionArgs[3], selectionArgs[4], selectionArgs[5], selectionArgs[6], birthday);
            return null;
        }
        if (uriMatcher.match(uri) == 7) {
            logI("REMOVE_ACCOUNT");
            ChatOnService chatonService = ChatOnService.createService(MainApplication.mContext);
            chatonService.clearBuddyData();
            logE("remove all data");
            ((VAppPhoneManager) MainApplication.mPhoneManager).getSSOManager().deleteAccount();
            return null;
        }
        if (uriMatcher.match(uri) == 1) {
            logI("BUDDY_INFO");
            if (selectionArgs == null) {
                sql = "SELECT " + makeProjectionString(projection) + " from buddy";
            } else {
                String userNoList = makeUserListString(selectionArgs);
                if (userNoList == null) {
                    logE("userNo is null");
                    return null;
                }
                sql = "SELECT " + makeProjectionString(projection) + " from buddy where userno IN (" + userNoList + ")";
            }
        } else if (uriMatcher.match(uri) == 4) {
            logI("NORMAL_BUDDY_INFO");
            if (selectionArgs == null || selectionArgs.length == 0) {
                logE("samsung account is null");
                return null;
            }
            sql = "SELECT " + makeProjectionString(projection) + " from buddy where accountid = '" + selectionArgs[0] + "'";
        } else {
            logI("WRONG URL");
            return null;
        }
        SQLiteDatabase database = this.mDbHelper.getReadableDatabase();
        try {
            Cursor cursor = database.rawQuery(sql, null);
            return cursor;
        } catch (Exception e) {
            logE("predicted exception " + e.toString());
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues arg1, String arg2, String[] arg3) {
        if (!mAccessAuthority) {
            logE("invalid access path");
            return 0;
        }
        mAccessAuthority = false;
        if (!checkChatONVState()) {
            logE("update() ChatONV is not enable!! uri : " + uriMatcher.match(uri));
            return 0;
        }
        if (uriMatcher.match(uri) == 10) {
            logI("CONFERENCECALL_MAX_NUM");
            int max = ((ChatOnConfigInterface) MainApplication.mConfig).getConferenceCallMaxPeopleNum("0".equals(arg2) ? false : true);
            logI("CONFERENCECALL_MAX_NUM: " + max);
            return max;
        }
        if (uriMatcher.match(uri) == 11) {
            logI("SHOW_CALL_ACTIVITY");
            if (!isCallActiveState()) {
                return 0;
            }
            if ("0".equals(arg2)) {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.setAction(InCallQuickPanel.ACTION_CALL_SHOW_SCREEN);
                getContext().sendBroadcast(intent);
            } else if ("1".equals(arg2)) {
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.setAction(InCallQuickPanel.ACTION_CALL_END);
                getContext().sendBroadcast(intent2);
            }
            return 1;
        }
        if (uriMatcher.match(uri) == 3) {
            logI("ACCOUNT_AVAILABLE");
            String myUserID = MainApplication.mConfig.getProfileUserID();
            if (myUserID != null && !myUserID.isEmpty()) {
                return 1;
            }
            logE("account is null");
            return 0;
        }
        if (uriMatcher.match(uri) == 17) {
            logI("GET_CALL_TYPE");
            CallStatusData callInfo = new CallStatusData();
            MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
            int callState = callInfo.getCallState();
            if (!callInfo.isValidity()) {
                logE("call info is not validation");
                return 0;
            }
            logI("call state: " + callState);
            int retV = MainApplication.mPhoneManager.getPhoneStateMachine().getCallType();
            logI("call type: " + retV);
            switch (retV) {
            }
            return 0;
        }
        if (uriMatcher.match(uri) != 19) {
            return 0;
        }
        logI("SET_LOG_DISPLAY");
        ChatONSettingData.getInstance().setIsLogON(getContext(), "0".equals(arg2) ? false : true);
        return 0;
    }

    private String makeProjectionString(String[] projection) {
        if (projection != null && projection.length > 0) {
            StringBuilder builder = new StringBuilder();
            for (String str : projection) {
                builder.append(str);
                builder.append(", ");
            }
            builder.delete(builder.length() - 2, builder.length());
            return builder.toString();
        }
        return "*";
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        mAccessAuthority = false;
        logE(uri.getPath());
        if (uriMatcher.match(uri) != 2) {
            return null;
        }
        URI fileURI = URI.create(PROFILE_IMAGE_URI_STR + uri.getPathSegments().get(1) + ".png");
        File file = new File(fileURI);
        ParcelFileDescriptor parcel = ParcelFileDescriptor.open(file, 268435456);
        if (parcel == null) {
            logE("openFile() parcel is null!!!");
            Uri path = Uri.parse("android.resource://com.coolots.com/drawble-xhdpi/contacts_default_image_small");
            URI fileURI2 = URI.create(path.getPath());
            File file2 = new File(fileURI2);
            return ParcelFileDescriptor.open(file2, 268435456);
        }
        return parcel;
    }

    private String makeUserListString(String[] selectionArgs) {
        mAccessAuthority = false;
        if (selectionArgs.length > 0) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < selectionArgs.length; i++) {
                if (selectionArgs[i] != null) {
                    builder.append(selectionArgs[i]);
                    builder.append(", ");
                }
            }
            if (builder.length() > 0) {
                builder.delete(builder.length() - 2, builder.length());
                return builder.toString();
            }
            return "";
        }
        return "";
    }
}
