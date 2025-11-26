package com.coolots.chaton.call.view;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class RetryCallBGActivity extends Activity implements DisposeInterface {
    private static final String CLASSNAME = "[RetryCallBGActivity]";
    private static final int DELAY_TIME = 8000;
    private static final int MESSAGE_CLOSE = 10;
    private final Handler mCloseHandler = new Handler() { // from class: com.coolots.chaton.call.view.RetryCallBGActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            RetryCallBGActivity.this.logI("finish()");
            RetryCallBGActivity.this.finish();
            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                RetryCallBGActivity.this.overridePendingTransition(0, 0);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws Resources.NotFoundException {
        Destination dest;
        logI("onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(C0000R.layout.retry_call_background);
        this.mCloseHandler.sendEmptyMessageDelayed(10, 8000L);
        Bundle extras = getIntent().getExtras();
        Destination destination = (Destination) extras.getParcelable("retry_call_destination");
        boolean isRetryVideo = extras.getBoolean("retry_call_bg_is_video_call");
        if (MainApplication.mPhoneManager.getLoginManager().isLogin()) {
            logI("[[[LHH]]] retryp mRetryCall = true");
            if (destination.getDestinationType() == 2) {
                logI("[[[LHH]]] retryp P2P Call");
                Destination dest2 = new Destination(2, destination.getPhoneNo());
                MainApplication.mPhoneManager.getPhoneStateMachine().startOutGoingCall(dest2, isRetryVideo, false, MainApplication.mConfig.getProfileUserName());
                return;
            }
            if (destination.getDestinationType() != 3) {
                if (destination.getDestinationType() == 4) {
                    logI("[[[LHH]]] retryp COF. Call");
                    ArrayList<SimpleUserInfo> memberList = new ArrayList<>();
                    ArrayList<SimpleUserInfo> oldMemberList = destination.getConferenceMember();
                    Iterator<SimpleUserInfo> it = oldMemberList.iterator();
                    while (it.hasNext()) {
                        SimpleUserInfo member = it.next();
                        SimpleUserInfo newMember = new SimpleUserInfo();
                        newMember.setUserID(member.getUserID());
                        newMember.setUserName(member.getUserName());
                        memberList.add(newMember);
                    }
                    if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                        dest = new Destination("", memberList, destination.getGroupName());
                    } else {
                        dest = new Destination("", memberList, 0L);
                    }
                    MainApplication.mPhoneManager.getPhoneStateMachine().startOutGoingCall(dest, isRetryVideo, false, MainApplication.mConfig.getProfileUserName());
                    return;
                }
                if (destination.getDestinationType() == 5) {
                    ArrayList<P2PUserInfo> memberList2 = new ArrayList<>();
                    ArrayList<P2PUserInfo> oldMemberList2 = destination.getP2PConferenceMember();
                    boolean isIncludedMyAccount = false;
                    String myAccount = MainApplication.mConfig.getProfileUserID();
                    Iterator<P2PUserInfo> it2 = oldMemberList2.iterator();
                    while (it2.hasNext()) {
                        P2PUserInfo member2 = it2.next();
                        P2PUserInfo newMember2 = new P2PUserInfo();
                        newMember2.userID = member2.userID;
                        memberList2.add(newMember2);
                        if (member2.userID.equals(myAccount)) {
                            isIncludedMyAccount = true;
                        }
                    }
                    if (!isIncludedMyAccount) {
                        P2PUserInfo myInfo = new P2PUserInfo();
                        myInfo.userID = myAccount;
                        myInfo.userName = MainApplication.mConfig.getProfileUserName();
                        myInfo.userType = 0;
                        memberList2.add(myInfo);
                    }
                    Destination dest3 = new Destination(-1, memberList2, 0L);
                    MainApplication.mPhoneManager.getPhoneStateMachine().startOutGoingCall(dest3, isRetryVideo, false, MainApplication.mConfig.getProfileUserName());
                    return;
                }
                logI("[[[LHH]]] retryp fail to retry");
                return;
            }
            return;
        }
        String strPath = "";
        if (MainApplication.mResources.getStringLogOut() != 0) {
            strPath = getResources().getString(MainApplication.mResources.getStringLogOut());
        }
        Toast.makeText(this, strPath, 0).show();
    }

    @Override // android.app.Activity
    protected void onPause() {
        logI("onPause()");
        super.onPause();
        this.mCloseHandler.removeMessages(10);
        finish();
        if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
            overridePendingTransition(0, 0);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        dispose();
        super.onDestroy();
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        ViewRecycleUtil.recurisveRecycle(getWindow().getDecorView());
        System.gc();
    }
}
