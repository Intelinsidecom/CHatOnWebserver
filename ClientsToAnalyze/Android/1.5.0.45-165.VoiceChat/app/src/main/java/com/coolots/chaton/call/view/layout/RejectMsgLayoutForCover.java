package com.coolots.chaton.call.view.layout;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.coolots.chaton.common.util.ChatOnService;
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
public class RejectMsgLayoutForCover extends LinearLayout implements View.OnClickListener, DisposeInterface {
    private static final String CLASSNAME = "[RejectCallWithMsgLayout]";
    private static final int REJECTMSG_MAX_CNT = 6;
    private RejectMsgForCoverAdapter mAdapter;
    private CallDisplayUserInfo mCalluserInfo;
    private Destination mDest;
    private CallActivity mParentActivity;
    private int mRejectMsgIndex;
    private ArrayList<String> mRejectMsgList;
    private ListView mRejectMsgListView;
    private SendMsgRunnable sendMSGHandler;

    /* JADX INFO: Access modifiers changed from: private */
    public static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public RejectMsgLayoutForCover(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mRejectMsgList = null;
        this.mRejectMsgListView = null;
        this.sendMSGHandler = null;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.reject_call_with_msg_content_for_cover, (ViewGroup) this, true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mRejectMsgListView = (ListView) findViewById(C0000R.id.reject_msg_for_cover_list);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) throws Throwable {
        super.onWindowVisibilityChanged(visibility);
        logI("onWindowVisibilityChanged : " + visibility);
        if (visibility == 0) {
            updateRejectMsgList();
        }
    }

    public void updateRejectMsgList() throws Throwable {
        if (this.mRejectMsgListView != null) {
            new ArrayList();
            this.mRejectMsgList = new ArrayList<>();
            this.mRejectMsgList.add(MainApplication.mContext.getString(C0000R.string.reject_msg_default1));
            this.mRejectMsgList.add(MainApplication.mContext.getString(C0000R.string.reject_msg_default2));
            this.mRejectMsgList.add(MainApplication.mContext.getString(C0000R.string.reject_msg_default3));
            this.mRejectMsgList.add(MainApplication.mContext.getString(C0000R.string.reject_msg_default4));
            this.mRejectMsgList.add(MainApplication.mContext.getString(C0000R.string.reject_msg_default5));
            List<String> rejectMsgs = this.mRejectMsgList;
            ChatONRejectMsgList.loadData(rejectMsgs, 6);
            this.mAdapter = new RejectMsgForCoverAdapter(MainApplication.mContext, C0000R.layout.reject_call_with_msg_item_for_cover, this.mRejectMsgList, this);
            this.mRejectMsgListView.addFooterView(makeBottomView());
            this.mRejectMsgListView.setAdapter((ListAdapter) this.mAdapter);
            this.mRejectMsgListView.setDividerHeight(0);
        }
    }

    private View makeBottomView() {
        View bottomView = new View(this.mContext);
        float density = getResources().getDisplayMetrics().density;
        AbsListView.LayoutParams bottomParams = new AbsListView.LayoutParams(-1, ((int) density) * 28);
        bottomView.setLayoutParams(bottomParams);
        return bottomView;
    }

    public void setCallInfo(CallActivity parent, Destination destination, CallDisplayUserInfo info) {
        this.mParentActivity = parent;
        this.mDest = new Destination(2, MainApplication.mConfig.getProfileUserID());
        this.mDest.copyDestination(this.mParentActivity.getDestination());
        this.mCalluserInfo = info;
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
            if (RejectMsgLayoutForCover.this.mRejectMsgIndex != -1) {
                String rejectMsg = this.mMsg;
                if (rejectMsg == null || rejectMsg.isEmpty()) {
                    rejectMsg = "";
                }
                RejectMsgLayoutForCover.logI("denyCall: rejectMsg: " + rejectMsg);
                if (MainApplication.mPhoneManager.IsLinkagewithChatON() && RejectMsgLayoutForCover.this.mDest != null) {
                    ArrayList<String> recipients = new ArrayList<>();
                    if (RejectMsgLayoutForCover.this.mDest.getDestinationType() != 2) {
                        if (RejectMsgLayoutForCover.this.mDest.getDestinationType() == 4) {
                            Iterator it = RejectMsgLayoutForCover.this.mDest.getConferenceMember().iterator();
                            while (it.hasNext()) {
                                SimpleUserInfo userinfo = (SimpleUserInfo) it.next();
                                if (userinfo.getUserType().equals(SimpleUserInfo.TYPE_HOST)) {
                                    String accoutID = ChatONStringConvert.getInstance().removeFooter(userinfo.getUserID());
                                    recipients.add(accoutID);
                                }
                            }
                        } else if (RejectMsgLayoutForCover.this.mDest.getDestinationType() == 5) {
                            Iterator it2 = RejectMsgLayoutForCover.this.mDest.getP2PConferenceMember().iterator();
                            while (it2.hasNext()) {
                                P2PUserInfo userinfo2 = (P2PUserInfo) it2.next();
                                if (userinfo2.userType == 0) {
                                    String accoutID2 = ChatONStringConvert.getInstance().removeFooter(userinfo2.userID);
                                    recipients.add(accoutID2);
                                }
                            }
                        }
                    } else {
                        String unknownBuddyNames = RejectMsgLayoutForCover.this.getUnKnownBuddyNames();
                        if (unknownBuddyNames != null) {
                            RejectMsgLayoutForCover.this.mParentActivity.denyCall();
                            return;
                        } else {
                            String AccountId = ChatONStringConvert.getInstance().removeFooter(RejectMsgLayoutForCover.this.mDest.getString());
                            recipients.add(AccountId);
                        }
                    }
                    RejectMsgLayoutForCover.logI("recipients: " + recipients.toString());
                    try {
                        MessageAPI.sendTextMessageBG(RejectMsgLayoutForCover.this.getContext(), MainApplication.mConfig.getProfileUserNo(), (String[]) recipients.toArray(new String[0]), String.valueOf(MainApplication.mContext.getString(C0000R.string.call_swipe_left_message)) + " :\n" + rejectMsg, false);
                    } catch (IllegalArgumentClientAPIException e) {
                        e.printStackTrace();
                    } catch (NotActivatedClientAPIException e2) {
                        e2.printStackTrace();
                    } catch (NotAvailableClientAPIException e3) {
                        e3.printStackTrace();
                    }
                }
                RejectMsgLayoutForCover.this.mParentActivity.denyCallwithRejectMsg(RejectMsgLayoutForCover.this.mRejectMsgIndex + 101, rejectMsg);
            }
            RejectMsgLayoutForCover.this.mRejectMsgIndex = -1;
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

    public void sendMSGforRejectCover(String rjctMsg) {
        if (this.sendMSGHandler == null) {
            this.sendMSGHandler = new SendMsgRunnable(rjctMsg);
        }
        new Handler().postDelayed(this.sendMSGHandler, 1000L);
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mAdapter != null) {
            this.mAdapter.dispose();
            this.mAdapter = null;
        }
        if (this.mRejectMsgListView != null) {
            this.mRejectMsgListView = null;
        }
        if (this.mRejectMsgList != null) {
            this.mRejectMsgList = null;
        }
        if (this.mDest != null) {
            this.mDest = null;
        }
        if (this.sendMSGHandler != null) {
            this.sendMSGHandler.dispose();
            this.sendMSGHandler = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.mParentActivity.showCreateRejectMsgDialog();
        this.mParentActivity.denyCall();
    }
}
