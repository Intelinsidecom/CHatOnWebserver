package com.coolots.chaton.call.view.layout;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.coolots.chaton.call.view.RejectMsgSlidingdrawer;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.BuddyImageView;
import com.coolots.common.CoolotsCode;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.PhoneNumberUtil;
import com.sds.coolots.common.view.DisposeInterface;
import java.io.IOException;

/* loaded from: classes.dex */
public class IncomingSlidingWidgetCoverBig extends SlidingWidgetCover implements DisposeInterface {
    public static final String CLASSNAME = "[IncomingSlidingWidgetCoverBig]";
    private BuddyManagerInterface mBuddyManager;
    private String mPhoneNumber;
    private RejectMsgSlidingdrawer mRejectCallWithMsgContainer;
    private LinearLayout mRejectCallWithMsgHandle;
    private RejectMsgLayoutForCover mRejectCallWithMsgLayout;
    private BuddyImageView mUserImage;

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public IncomingSlidingWidgetCoverBig(Context context, ChatOnCallActivity parent, Destination destination, ViewGroup r) {
        super(context, parent, destination, r);
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        logI("IncomingSlidingWidgetCoverBig()");
        int childViewCount = r.getChildCount();
        LayoutInflater inflater = LayoutInflater.from(this.mContext);
        this.mRootGroupView = (ViewGroup) inflater.inflate(C0000R.layout.incomming_call_widget_covered_big, r, true);
        this.mClearCoverAccept = (ImageView) this.mRootGroupView.findViewById(C0000R.id.clear_accept_big_call);
        this.mClearCoverAcceptCircle = (ImageView) this.mRootGroupView.findViewById(C0000R.id.clear_accept_big_circle);
        this.mClearCoverAcceptCircle.setVisibility(4);
        this.mClearCoverAccept.setOnTouchListener(this);
        this.mClearCoverReject = (ImageView) this.mRootGroupView.findViewById(C0000R.id.clear_reject_big_call);
        this.mClearCoverRejectCircle = (ImageView) this.mRootGroupView.findViewById(C0000R.id.clear_reject_big_circle);
        this.mClearCoverRejectCircle.setVisibility(4);
        this.mClearCoverReject.setOnTouchListener(this);
        this.mClearCoverUserName = (TextView) this.mRootGroupView.findViewById(C0000R.id.clear_big_cover_ui_name);
        this.mClearCoverUserMessage = (TextView) this.mRootGroupView.findViewById(C0000R.id.clear_big_cover_ui_message);
        this.mClearCoverCallKind = (TextView) this.mRootGroupView.findViewById(C0000R.id.clear_big_cover_ui_call_kind);
        this.mClearCoverTextLayout = (LinearLayout) this.mRootGroupView.findViewById(C0000R.id.clear_cover_big_text_layout);
        this.mUserImage = (BuddyImageView) this.mRootGroupView.findViewById(C0000R.id.voice_in_call_memberimage_covered);
        this.mClearAcceptLayout = (FrameLayout) this.mRootGroupView.findViewById(C0000R.id.clear_accept_circle_big_layout);
        this.mClearRejectLayout = (FrameLayout) this.mRootGroupView.findViewById(C0000R.id.clear_reject_circle_big_layout);
        this.mRedArrowCover = (ImageView) this.mRootGroupView.findViewById(C0000R.id.red_arrow_big_cover);
        this.mGreenArrowCover = (ImageView) this.mRootGroupView.findViewById(C0000R.id.green_arrow_big_cover);
        this.mRedArrowCover.setBackgroundResource(C0000R.anim.red_arrow_big_effect);
        this.mGreenArrowCover.setBackgroundResource(C0000R.anim.green_arrow_big_effect);
        AnimationDrawable redAnimation = (AnimationDrawable) this.mRedArrowCover.getBackground();
        AnimationDrawable greenAnimation = (AnimationDrawable) this.mGreenArrowCover.getBackground();
        redAnimation.start();
        greenAnimation.start();
        this.mRootGroupView.getChildAt(childViewCount).setTag(String.valueOf(getClass().toString()) + getConfiguration());
        setMoveImage(C0000R.drawable.clear_accept_circle_big_01, C0000R.drawable.clear_reject_circle_big_01);
        setTouchImage(C0000R.drawable.clear_accept_circle_drag, C0000R.drawable.clear_reject_circle_drag);
        this.mRejectCallWithMsgLayout = (RejectMsgLayoutForCover) this.mRootGroupView.findViewById(C0000R.id.reject_call_with_msg_content);
        this.mRejectCallWithMsgContainer = (RejectMsgSlidingdrawer) this.mRootGroupView.findViewById(C0000R.id.reject_call_with_msg_container);
        this.mRejectCallWithMsgHandle = (LinearLayout) this.mRootGroupView.findViewById(C0000R.id.reject_call_with_msg_handle);
        this.mRejectCallWithMsgContainer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() { // from class: com.coolots.chaton.call.view.layout.IncomingSlidingWidgetCoverBig.1
            @Override // android.widget.SlidingDrawer.OnDrawerOpenListener
            public void onDrawerOpened() {
                IncomingSlidingWidgetCoverBig.this.logI("DrawerOpen!!");
                IncomingSlidingWidgetCoverBig.this.mRejectCallWithMsgContainer.setIsOpened(true);
                IncomingSlidingWidgetCoverBig.this.mRejectCallWithMsgHandle.setBackgroundResource(C0000R.drawable.call_incoming_reject_handle02);
            }
        });
        this.mRejectCallWithMsgContainer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() { // from class: com.coolots.chaton.call.view.layout.IncomingSlidingWidgetCoverBig.2
            @Override // android.widget.SlidingDrawer.OnDrawerCloseListener
            public void onDrawerClosed() {
                IncomingSlidingWidgetCoverBig.this.logI("DrawerClose!!");
                IncomingSlidingWidgetCoverBig.this.mRejectCallWithMsgContainer.setIsOpened(false);
                IncomingSlidingWidgetCoverBig.this.mRejectCallWithMsgHandle.setBackgroundResource(C0000R.drawable.call_incoming_reject_handle01);
            }
        });
    }

    public IncomingSlidingWidgetCoverBig(Context context) {
        super(context);
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
    }

    public IncomingSlidingWidgetCoverBig(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
    }

    public IncomingSlidingWidgetCoverBig(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
    }

    @Override // com.coolots.chaton.call.view.layout.SlidingWidgetCover
    public void setClearCoverActive(CallDisplayUserInfo calluserInfo, String callKind) throws IOException {
        logI("setClearCoverActive()");
        super.setClearCoverActive(calluserInfo, callKind);
        this.mClearCoverUserMessage.setText(calluserInfo.userStateMsg);
        setCallerImage();
        getPhoneNumber(this.mDestination);
        this.mRejectCallWithMsgLayout.setCallInfo(this.mParentActivity, this.mDestination, calluserInfo);
    }

    private void setCallerImage() throws IOException {
        if (this.mDestination != null && this.mUserImage.getDrawable() == null) {
            String buddyID = this.mDestination.getString();
            logI("setCallerImage buddyID = " + buddyID);
            if (this.mParentActivity.isConference()) {
                this.mUserImage.setImageViewMode(4);
            } else {
                this.mUserImage.setImageViewMode(0);
            }
            if (this.mBuddyManager.getKindOfBuddy(buddyID) == 0) {
                this.mUserImage.loadImageForCover(buddyID, true);
            } else {
                this.mUserImage.setBuddyGroupDefaultImageForCover(true);
            }
        }
    }

    @Override // com.coolots.chaton.call.view.layout.SlidingWidgetCover, com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mUserImage != null) {
            this.mUserImage.dispose();
            this.mUserImage = null;
        }
        removeAllViewsInLayout();
    }

    private void getPhoneNumber(Destination destination) {
        if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            this.mPhoneNumber = null;
            return;
        }
        String phoneNum = null;
        if (destination != null) {
            try {
                try {
                    String pNum = destination.getPhoneNo();
                    PhoneNumberUtil phoneUtil = new PhoneNumberUtil(pNum.replace("@chaton", "").replace(CoolotsCode.ID_DOMAIN_COOLOTS, ""));
                    phoneNum = PhoneNumberUtil.formatNumber(phoneUtil.getPhoneNumber());
                } catch (Exception e) {
                    e.printStackTrace();
                    if (0 != 0) {
                        this.mPhoneNumber = null;
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    this.mPhoneNumber = null;
                }
                throw th;
            }
        }
        if (phoneNum != null) {
            this.mPhoneNumber = phoneNum;
        }
    }
}
