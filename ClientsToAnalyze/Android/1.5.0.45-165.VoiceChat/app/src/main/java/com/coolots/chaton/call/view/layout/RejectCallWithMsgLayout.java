package com.coolots.chaton.call.view.layout;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.common.controller.ChatOnResourceInterface;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.coolots.chaton.common.util.ChatOnService;
import com.coolots.chaton.setting.data.ChatONRejectMsgData;
import com.coolots.chaton.setting.data.ChatONRejectMsgList;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.call.view.CallActivity;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import com.sec.chaton.clientapi.MessageAPI;
import com.sec.chaton.clientapi.exception.IllegalArgumentClientAPIException;
import com.sec.chaton.clientapi.exception.NotActivatedClientAPIException;
import com.sec.chaton.clientapi.exception.NotAvailableClientAPIException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class RejectCallWithMsgLayout extends LinearLayout implements View.OnClickListener, DisposeInterface {
    private static final String CLASSNAME = "[RejectCallWithMsgLayout]";
    private static final int REJECTMSG_MAX_CNT = 6;
    private static final int UPDATE_BUTTON = 100;
    private ArrayList<LinearLayout> mBtnList;
    private CallDisplayUserInfo mCalluserInfo;
    private ChatONRejectMsgData mChatONRejectMsgData;
    private RelativeLayout mCreateButton;
    private Destination mDest;
    private rejectCallWithHandler mHandler;
    private final Object mMutex;
    private CallActivity mParentActivity;
    private String mPhoneNumber;
    private int mRejectMsgIndex;
    private ArrayList<View> mViewList;
    private SendMsgRunnable sendMSGHandler;

    /* JADX INFO: Access modifiers changed from: private */
    public static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private class rejectCallWithHandler extends Handler implements DisposeInterface {
        private boolean bDisposed;

        private rejectCallWithHandler() {
            this.bDisposed = false;
        }

        /* synthetic */ rejectCallWithHandler(RejectCallWithMsgLayout rejectCallWithMsgLayout, rejectCallWithHandler rejectcallwithhandler) {
            this();
        }

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            this.bDisposed = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (!this.bDisposed) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 100:
                        if (RejectCallWithMsgLayout.this.mBtnList != null) {
                            int index = msg.arg1;
                            String text = (String) msg.obj;
                            LinearLayout item = (LinearLayout) RejectCallWithMsgLayout.this.mBtnList.get(index);
                            ((TextView) item.findViewById(C0000R.id.reject_call_with_msg_item_text)).setText(text);
                            Button btn = (Button) item.findViewById(C0000R.id.reject_call_with_msg_item_button);
                            btn.setTag(Integer.valueOf(index));
                            btn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.RejectCallWithMsgLayout.rejectCallWithHandler.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (RejectCallWithMsgLayout.this.mPhoneNumber != null) {
                                        LinearLayout parentView = (LinearLayout) view.getParent();
                                        TextView textView = (TextView) parentView.findViewById(C0000R.id.reject_call_with_msg_item_text);
                                        RejectCallWithMsgLayout.this.mRejectMsgIndex = Integer.parseInt(view.getTag().toString());
                                        if (RejectCallWithMsgLayout.this.sendMSGHandler == null) {
                                            RejectCallWithMsgLayout.this.sendMSGHandler = RejectCallWithMsgLayout.this.new SendMsgRunnable((String) textView.getText());
                                        }
                                        new Handler().postDelayed(RejectCallWithMsgLayout.this.sendMSGHandler, 1000L);
                                        RejectCallWithMsgLayout.this.disableSendMsgButton();
                                    }
                                }
                            });
                            if (RejectCallWithMsgLayout.this.mViewList != null) {
                                View view = (View) RejectCallWithMsgLayout.this.mViewList.get(index);
                                view.setVisibility(0);
                            }
                            item.setVisibility(0);
                            break;
                        }
                        break;
                }
            }
        }
    }

    public RejectCallWithMsgLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mCreateButton = null;
        this.mBtnList = null;
        this.mViewList = null;
        this.mPhoneNumber = null;
        this.mMutex = new Object();
        this.sendMSGHandler = null;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.reject_call_with_msg_content, (ViewGroup) this, true);
        this.mHandler = new rejectCallWithHandler(this, null);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0000. Please report as an issue. */
    public void setVisibiltyLine(int index) {
        switch (index) {
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mCreateButton = (RelativeLayout) findViewById(C0000R.id.reject_call_with_msg_create);
        this.mCreateButton.setOnClickListener(this);
        if (this.mBtnList == null) {
            this.mBtnList = new ArrayList<>();
            this.mBtnList.add((LinearLayout) findViewById(C0000R.id.reject_call_with_msg_item1));
            this.mBtnList.add((LinearLayout) findViewById(C0000R.id.reject_call_with_msg_item2));
            this.mBtnList.add((LinearLayout) findViewById(C0000R.id.reject_call_with_msg_item3));
            this.mBtnList.add((LinearLayout) findViewById(C0000R.id.reject_call_with_msg_item4));
            this.mBtnList.add((LinearLayout) findViewById(C0000R.id.reject_call_with_msg_item5));
            this.mBtnList.add((LinearLayout) findViewById(C0000R.id.reject_call_with_msg_item6));
        }
        if (this.mViewList == null) {
            this.mViewList = new ArrayList<>();
            this.mViewList.add(findViewById(C0000R.id.reject_call_with_msg_item_view_1));
            this.mViewList.add(findViewById(C0000R.id.reject_call_with_msg_item_view_2));
            this.mViewList.add(findViewById(C0000R.id.reject_call_with_msg_item_view_3));
            this.mViewList.add(findViewById(C0000R.id.reject_call_with_msg_item_view_4));
            this.mViewList.add(findViewById(C0000R.id.reject_call_with_msg_item_view_5));
            this.mViewList.add(findViewById(C0000R.id.reject_call_with_msg_item_view_6));
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        logI("onWindowVisibilityChanged : " + visibility);
        if (visibility == 0) {
            updateRejectMsgList();
        }
    }

    public void updateRejectMsgList() {
        if (this.mBtnList != null) {
            List<String> rejectMsgs = new ArrayList<>();
            rejectMsgs.add(MainApplication.mContext.getString(C0000R.string.reject_msg_default1));
            rejectMsgs.add(MainApplication.mContext.getString(C0000R.string.reject_msg_default2));
            rejectMsgs.add(MainApplication.mContext.getString(C0000R.string.reject_msg_default3));
            rejectMsgs.add(MainApplication.mContext.getString(C0000R.string.reject_msg_default4));
            rejectMsgs.add(MainApplication.mContext.getString(C0000R.string.reject_msg_default5));
            this.mChatONRejectMsgData = ChatONRejectMsgList.loadData(rejectMsgs, 6);
            for (int i = 0; i < 6; i++) {
                this.mBtnList.get(i).setVisibility(4);
            }
            new updateRejectMsgListThread().start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedRejectMsg(ChatONRejectMsgData msg, int index) {
        List<String> defaultString = ((ChatOnResourceInterface) MainApplication.mResources).getDefaultRejectMsg();
        return msg.getType(index) == 0 ? msg.getMessage(index) : defaultString.get(msg.getType(index) - 1);
    }

    class updateRejectMsgListThread extends Thread {
        updateRejectMsgListThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (RejectCallWithMsgLayout.this.mMutex) {
                if (RejectCallWithMsgLayout.this.mHandler != null) {
                    for (int i = 0; i < RejectCallWithMsgLayout.this.mChatONRejectMsgData.getCount(); i++) {
                        Message msg = RejectCallWithMsgLayout.this.mHandler.obtainMessage(100, i, -1, RejectCallWithMsgLayout.this.getSelectedRejectMsg(RejectCallWithMsgLayout.this.mChatONRejectMsgData, i));
                        RejectCallWithMsgLayout.this.mHandler.sendMessage(msg);
                    }
                }
            }
        }
    }

    public void setCallInfo(CallActivity parent, String phoneNumber, Destination destination, CallDisplayUserInfo info) {
        this.mParentActivity = parent;
        this.mDest = new Destination(2, MainApplication.mConfig.getProfileUserID());
        this.mDest.copyDestination(this.mParentActivity.getDestination());
        if (phoneNumber != null) {
            this.mPhoneNumber = phoneNumber;
        }
        this.mCalluserInfo = info;
    }

    public void disableSendMsgButton() {
        LinearLayout item;
        Button btn;
        for (int i = 0; i < 6; i++) {
            try {
                if (this.mBtnList != null && (item = this.mBtnList.get(i)) != null && (btn = (Button) item.findViewById(C0000R.id.reject_call_with_msg_item_button)) != null) {
                    btn.setOnClickListener(null);
                    btn.setEnabled(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class SendMsgRunnable implements Runnable, DisposeInterface {
        private boolean bDisposed = false;
        private final String mMsg;

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            this.bDisposed = true;
        }

        public SendMsgRunnable(String msg) {
            this.mMsg = msg;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.bDisposed && this.mMsg != null) {
                denyCall();
            }
        }

        public void denyCall() {
            if (RejectCallWithMsgLayout.this.mRejectMsgIndex != -1) {
                String rejectMsg = RejectCallWithMsgLayout.this.getSelectedRejectMsg(RejectCallWithMsgLayout.this.mChatONRejectMsgData, RejectCallWithMsgLayout.this.mRejectMsgIndex);
                if (rejectMsg == null || rejectMsg.isEmpty()) {
                    rejectMsg = "";
                }
                RejectCallWithMsgLayout.logI("denyCall: rejectMsg: " + rejectMsg);
                if (MainApplication.mPhoneManager.IsLinkagewithChatON() && RejectCallWithMsgLayout.this.mDest != null) {
                    ArrayList<String> recipients = new ArrayList<>();
                    if (RejectCallWithMsgLayout.this.mDest.getDestinationType() != 2) {
                        if (RejectCallWithMsgLayout.this.mDest.getDestinationType() == 4) {
                            Iterator it = RejectCallWithMsgLayout.this.mDest.getConferenceMember().iterator();
                            while (it.hasNext()) {
                                SimpleUserInfo userinfo = (SimpleUserInfo) it.next();
                                if (userinfo.getUserType().equals(SimpleUserInfo.TYPE_HOST)) {
                                    String accoutID = ChatONStringConvert.getInstance().removeFooter(userinfo.getUserID());
                                    recipients.add(accoutID);
                                }
                            }
                        } else if (RejectCallWithMsgLayout.this.mDest.getDestinationType() == 5) {
                            Iterator it2 = RejectCallWithMsgLayout.this.mDest.getP2PConferenceMember().iterator();
                            while (it2.hasNext()) {
                                P2PUserInfo userinfo2 = (P2PUserInfo) it2.next();
                                if (userinfo2.userType == 0) {
                                    String accoutID2 = ChatONStringConvert.getInstance().removeFooter(userinfo2.userID);
                                    recipients.add(accoutID2);
                                }
                            }
                        }
                    } else {
                        String unknownBuddyNames = RejectCallWithMsgLayout.this.getUnKnownBuddyNames();
                        if (unknownBuddyNames != null) {
                            Toast.makeText(RejectCallWithMsgLayout.this.mParentActivity, RejectCallWithMsgLayout.this.getResources().getString(C0000R.string.cannot_send_sms_no_friend, unknownBuddyNames), 0).show();
                            RejectCallWithMsgLayout.this.mParentActivity.denyCall();
                            return;
                        } else {
                            String AccountId = ChatONStringConvert.getInstance().removeFooter(RejectCallWithMsgLayout.this.mDest.getString());
                            recipients.add(AccountId);
                        }
                    }
                    RejectCallWithMsgLayout.logI("recipients: " + recipients.toString());
                    try {
                        MessageAPI.sendTextMessageBG(RejectCallWithMsgLayout.this.getContext(), MainApplication.mConfig.getProfileUserNo(), (String[]) recipients.toArray(new String[0]), String.valueOf(MainApplication.mContext.getString(C0000R.string.call_swipe_left_message)) + " :\n" + rejectMsg, false);
                    } catch (IllegalArgumentClientAPIException e) {
                        e.printStackTrace();
                    } catch (NotActivatedClientAPIException e2) {
                        e2.printStackTrace();
                    } catch (NotAvailableClientAPIException e3) {
                        e3.printStackTrace();
                    }
                }
                RejectCallWithMsgLayout.this.mParentActivity.denyCallwithRejectMsg(RejectCallWithMsgLayout.this.mRejectMsgIndex + 101, rejectMsg);
            }
            RejectCallWithMsgLayout.this.mRejectMsgIndex = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getUnKnownBuddyNames() {
        ChatOnService chatonservice = ChatOnService.createService(getContext());
        ArrayList<String> UnKnownBuddyNameList = new ArrayList<>();
        if (this.mDest.getDestinationType() == 4) {
            ArrayList<SimpleUserInfo> simpleuserinfoList = this.mDest.getConferenceMember();
            Iterator<SimpleUserInfo> it = simpleuserinfoList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SimpleUserInfo simpleuserinfo = it.next();
                if (chatonservice.isChatOnBuddy(simpleuserinfo.getUserID()) != 4) {
                    logI("getUnKnownBuddyList Name = " + simpleuserinfo.getUserName());
                    UnKnownBuddyNameList.add(simpleuserinfo.getUserName());
                    break;
                }
            }
        } else if (this.mDest.getDestinationType() == 5) {
            ArrayList<P2PUserInfo> simpleuserinfoList2 = this.mDest.getP2PConferenceMember();
            Iterator<P2PUserInfo> it2 = simpleuserinfoList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                P2PUserInfo simpleuserinfo2 = it2.next();
                if (chatonservice.isChatOnBuddy(simpleuserinfo2.userID) != 4) {
                    logI("getUnKnownBuddyList Name = " + simpleuserinfo2.userName);
                    UnKnownBuddyNameList.add(simpleuserinfo2.userName);
                    break;
                }
            }
        } else if (chatonservice.isChatOnBuddy(this.mDest.getString()) != 4) {
            logI("getUnKnownBuddyList Account  = " + this.mDest.getString());
            logI("getUnKnownBuddyList Name  = " + this.mCalluserInfo.userName);
            UnKnownBuddyNameList.add(this.mCalluserInfo.userName);
        }
        if (UnKnownBuddyNameList.size() == 0) {
            return null;
        }
        String needToAddBuddyName = new String();
        Iterator<String> it3 = UnKnownBuddyNameList.iterator();
        while (it3.hasNext()) {
            String buddyname = it3.next();
            needToAddBuddyName = String.valueOf(needToAddBuddyName) + addStringToTailWithComma(needToAddBuddyName, buddyname);
        }
        return needToAddBuddyName;
    }

    private String addStringToTailWithComma(String destStr, String addStr) {
        return destStr.isEmpty() ? addStr : ", " + addStr;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mBtnList != null) {
            this.mBtnList = null;
        }
        if (this.mViewList != null) {
            this.mViewList = null;
        }
        if (this.mDest != null) {
            this.mDest = null;
        }
        if (this.sendMSGHandler != null) {
            this.sendMSGHandler.dispose();
            this.sendMSGHandler = null;
        }
        synchronized (this.mMutex) {
            if (this.mHandler != null) {
                this.mHandler.dispose();
                this.mHandler = null;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.mCreateButton.getId()) {
            if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                ChatOnService chatonservice = ChatOnService.createService(getContext());
                if (this.mDest.getDestinationType() == 2) {
                    String unknownBuddyNames = getUnKnownBuddyNames();
                    if (unknownBuddyNames != null) {
                        Toast.makeText(this.mParentActivity, getResources().getString(C0000R.string.cannot_send_sms_no_friend, unknownBuddyNames), 0).show();
                        this.mParentActivity.denyCall();
                        return;
                    } else {
                        String AccountId = ChatONStringConvert.getInstance().removeFooter(this.mDest.getString());
                        chatonservice.openChatService(AccountId);
                    }
                } else if (this.mDest.getDestinationType() == 4) {
                    ArrayList<String> recipients = new ArrayList<>();
                    Iterator it = this.mDest.getConferenceMember().iterator();
                    while (it.hasNext()) {
                        SimpleUserInfo userinfo = (SimpleUserInfo) it.next();
                        if (userinfo.getUserType().equals(SimpleUserInfo.TYPE_HOST)) {
                            String accoutID = ChatONStringConvert.getInstance().removeFooter(userinfo.getUserID());
                            recipients.add(accoutID);
                        }
                    }
                    if (recipients.size() > 0) {
                        chatonservice.openChatService(recipients);
                    }
                } else if (this.mDest.getDestinationType() == 5) {
                    ArrayList<String> recipients2 = new ArrayList<>();
                    Iterator it2 = this.mDest.getP2PConferenceMember().iterator();
                    while (it2.hasNext()) {
                        P2PUserInfo userinfo2 = (P2PUserInfo) it2.next();
                        if (userinfo2.userType == 0) {
                            String accoutID2 = ChatONStringConvert.getInstance().removeFooter(userinfo2.userID);
                            recipients2.add(accoutID2);
                        }
                    }
                    if (recipients2.size() > 0) {
                        chatonservice.openChatService(recipients2);
                    }
                }
            } else {
                this.mParentActivity.showCreateRejectMsgDialog();
            }
            this.mParentActivity.denyCall();
        }
    }
}
