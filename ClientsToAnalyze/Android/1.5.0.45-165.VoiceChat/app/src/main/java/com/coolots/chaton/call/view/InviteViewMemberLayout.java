package com.coolots.chaton.call.view;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.coolots.chaton.C0000R;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
public class InviteViewMemberLayout extends FrameLayout implements DisposeInterface {
    private static final int ANIMATION_CYCLE_TIME = 400;
    private static final String CLASSNAME = "[InviteViewMemberLayout]";
    public static final int STATE_INCOMMING = 1;
    public static final int STATE_OUTGOING = 2;
    private LinearLayout mInviteBuddiesMainLayout;
    protected GridView mInviteBuddyListView;
    private Animation.AnimationListener mInviteViewAnimationListener;
    protected ViewGroup mInviteViewLayout;
    private TranslateAnimation mInviteViewTrans;
    private ViewGroup mInviteViewWaitPopupLayout;
    private boolean mIsShowing;
    private boolean mIsUsingAnimation;
    private ViewGroup mRootGroupView;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private void logE(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public InviteViewMemberLayout(Context context, ViewGroup r, int state) {
        super(context);
        this.mInviteViewLayout = null;
        this.mInviteViewWaitPopupLayout = null;
        this.mInviteBuddiesMainLayout = null;
        this.mInviteViewAnimationListener = new Animation.AnimationListener() { // from class: com.coolots.chaton.call.view.InviteViewMemberLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation arg0) {
                InviteViewMemberLayout.this.mIsUsingAnimation = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation arg0) {
                InviteViewMemberLayout.this.mIsUsingAnimation = false;
            }
        };
        int childViewCount = r.getChildCount();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mRootGroupView = (ViewGroup) inflater.inflate(C0000R.layout.video_call_invite_buddies_layout, r, true);
        this.mInviteBuddiesMainLayout = (LinearLayout) this.mRootGroupView.findViewById(C0000R.id.video_invite_buddies_main_layout);
        this.mInviteViewLayout = (ViewGroup) this.mRootGroupView.findViewById(C0000R.id.video_invite_buddies_layout);
        this.mInviteViewWaitPopupLayout = (ViewGroup) this.mRootGroupView.findViewById(C0000R.id.call_invite_buddy_wait_bar_layout);
        this.mInviteBuddyListView = (GridView) this.mInviteViewLayout.findViewById(C0000R.id.video_invite_buddies_list);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mInviteBuddiesMainLayout.getLayoutParams();
        layoutParams.topMargin = 144;
        if (getConfiguration() == 2 && state == 2) {
            layoutParams.width = 1005;
            layoutParams.topMargin = 0;
        }
        this.mInviteBuddiesMainLayout.setLayoutParams(layoutParams);
        this.mRootGroupView.getChildAt(childViewCount).setTag(String.valueOf(getClass().toString()) + getConfiguration());
    }

    public ViewGroup getLayoutreference() {
        if (this.mRootGroupView != null) {
            return this.mRootGroupView;
        }
        return null;
    }

    public InviteViewMemberLayout(Context context) {
        super(context);
        this.mInviteViewLayout = null;
        this.mInviteViewWaitPopupLayout = null;
        this.mInviteBuddiesMainLayout = null;
        this.mInviteViewAnimationListener = new Animation.AnimationListener() { // from class: com.coolots.chaton.call.view.InviteViewMemberLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation arg0) {
                InviteViewMemberLayout.this.mIsUsingAnimation = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation arg0) {
                InviteViewMemberLayout.this.mIsUsingAnimation = false;
            }
        };
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.video_call_invite_buddies_layout, (ViewGroup) this, true);
    }

    public InviteViewMemberLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mInviteViewLayout = null;
        this.mInviteViewWaitPopupLayout = null;
        this.mInviteBuddiesMainLayout = null;
        this.mInviteViewAnimationListener = new Animation.AnimationListener() { // from class: com.coolots.chaton.call.view.InviteViewMemberLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation arg0) {
                InviteViewMemberLayout.this.mIsUsingAnimation = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation arg0) {
                InviteViewMemberLayout.this.mIsUsingAnimation = false;
            }
        };
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.video_call_invite_buddies_layout, (ViewGroup) this, true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mInviteBuddiesMainLayout = (LinearLayout) findViewById(C0000R.id.video_invite_buddies_main_layout);
        this.mInviteViewLayout = (ViewGroup) findViewById(C0000R.id.video_invite_buddies_layout);
        this.mInviteViewWaitPopupLayout = (ViewGroup) findViewById(C0000R.id.call_invite_buddy_wait_bar_layout);
        this.mInviteBuddyListView = (GridView) findViewById(C0000R.id.video_invite_buddies_list);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mInviteBuddiesMainLayout.getLayoutParams();
        layoutParams.topMargin = 144;
        this.mInviteBuddiesMainLayout.setLayoutParams(layoutParams);
    }

    public ViewGroup getInviteBuddiesMainLayout() {
        return this.mInviteBuddiesMainLayout;
    }

    public ViewGroup getInviteViewLayout() {
        if (this.mInviteViewLayout == null) {
            this.mInviteViewLayout = (ViewGroup) findViewById(C0000R.id.video_invite_buddies_layout);
        }
        return this.mInviteViewLayout;
    }

    public ViewGroup getInviteWaitViewLayout() {
        if (this.mInviteViewWaitPopupLayout == null) {
            this.mInviteViewWaitPopupLayout = (ViewGroup) findViewById(C0000R.id.call_invite_buddy_wait_bar_layout);
        }
        return this.mInviteViewWaitPopupLayout;
    }

    public GridView getInviteListView() {
        if (this.mInviteBuddyListView == null) {
            this.mInviteBuddyListView = (GridView) findViewById(C0000R.id.video_invite_buddies_list);
        }
        return this.mInviteBuddyListView;
    }

    public void showInviteViewByAnimation(boolean showFlag) {
        if (!this.mIsUsingAnimation && this.mIsShowing != showFlag) {
            showInviteView();
            this.mIsShowing = showFlag;
            if (showFlag) {
                this.mInviteViewTrans = new TranslateAnimation(1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, -1.0f, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            } else {
                this.mInviteViewTrans = new TranslateAnimation(1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, -1.0f);
            }
            this.mInviteViewTrans.setInterpolator(AnimationUtils.loadInterpolator(MainApplication.mContext, R.anim.accelerate_decelerate_interpolator));
            this.mInviteViewTrans.setFillAfter(true);
            this.mInviteViewTrans.setDuration(400L);
            this.mInviteViewTrans.setAnimationListener(this.mInviteViewAnimationListener);
            this.mInviteViewLayout.startAnimation(this.mInviteViewTrans);
        }
    }

    public boolean isUsingAnimation() {
        return this.mIsUsingAnimation;
    }

    public void setShowing() {
        this.mIsShowing = true;
    }

    public boolean isShowing() {
        return this.mIsShowing;
    }

    public void showInviteView() {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
    }

    public void hideInviteView() {
        if (getVisibility() != 8) {
            setVisibility(8);
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mInviteViewLayout != null) {
            this.mInviteViewLayout.removeAllViewsInLayout();
            this.mInviteViewLayout = null;
        }
        if (this.mInviteBuddyListView != null) {
            this.mInviteBuddyListView.setAdapter((ListAdapter) null);
            this.mInviteBuddyListView.removeAllViewsInLayout();
            this.mInviteBuddyListView = null;
        }
        if (this.mInviteViewWaitPopupLayout != null) {
            this.mInviteViewWaitPopupLayout.removeAllViewsInLayout();
            this.mInviteViewWaitPopupLayout = null;
        }
    }

    private int getConfiguration() {
        return getResources().getConfiguration().orientation;
    }
}
