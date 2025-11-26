package com.coolots.chaton.call.view.layout;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class IncomingSlidingWidgetCover extends SlidingWidgetCover implements DisposeInterface {
    public static final String CLASSNAME = "[IncomingSlidingWidgetCover]";

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public IncomingSlidingWidgetCover(Context context, ChatOnCallActivity parent, Destination destination, ViewGroup r) {
        super(context, parent, destination, r);
        logI("IncomingSlidingWidgetCover()");
        int childViewCount = r.getChildCount();
        LayoutInflater inflater = LayoutInflater.from(this.mContext);
        this.mRootGroupView = (ViewGroup) inflater.inflate(C0000R.layout.incomming_call_widget_covered, r, true);
        this.mClearCoverAccept = (ImageView) this.mRootGroupView.findViewById(C0000R.id.clear_accept_call);
        this.mClearCoverAcceptCircle = (ImageView) this.mRootGroupView.findViewById(C0000R.id.clear_accept_circle);
        this.mClearCoverAcceptCircle.setVisibility(4);
        this.mClearCoverAccept.setOnTouchListener(this);
        this.mClearCoverReject = (ImageView) this.mRootGroupView.findViewById(C0000R.id.clear_reject_call);
        this.mClearCoverRejectCircle = (ImageView) this.mRootGroupView.findViewById(C0000R.id.clear_reject_circle);
        this.mClearCoverRejectCircle.setVisibility(4);
        this.mClearCoverReject.setOnTouchListener(this);
        this.mClearCoverUserName = (TextView) this.mRootGroupView.findViewById(C0000R.id.clear_cover_ui_name);
        this.mClearCoverUserMessage = (TextView) this.mRootGroupView.findViewById(C0000R.id.clear_cover_ui_message);
        this.mClearCoverCallKind = (TextView) this.mRootGroupView.findViewById(C0000R.id.clear_cover_ui_call_kind);
        this.mClearCoverTextLayout = (LinearLayout) this.mRootGroupView.findViewById(C0000R.id.clear_cover_text_layout);
        this.mClearAcceptLayout = (FrameLayout) this.mRootGroupView.findViewById(C0000R.id.clear_accept_circle_layout);
        this.mClearRejectLayout = (FrameLayout) this.mRootGroupView.findViewById(C0000R.id.clear_reject_circle_layout);
        this.mRedArrowCover = (ImageView) this.mRootGroupView.findViewById(C0000R.id.red_arrow_cover);
        this.mGreenArrowCover = (ImageView) this.mRootGroupView.findViewById(C0000R.id.green_arrow_cover);
        this.mRedArrowCover.setBackgroundResource(C0000R.anim.red_arrow_effect);
        this.mGreenArrowCover.setBackgroundResource(C0000R.anim.green_arrow_effect);
        AnimationDrawable redAnimation = (AnimationDrawable) this.mRedArrowCover.getBackground();
        AnimationDrawable greenAnimation = (AnimationDrawable) this.mGreenArrowCover.getBackground();
        redAnimation.start();
        greenAnimation.start();
        this.mRootGroupView.getChildAt(childViewCount).setTag(String.valueOf(getClass().toString()) + getConfiguration());
        setMoveImage(C0000R.drawable.clear_accept_circle_big_02_j, C0000R.drawable.clear_reject_circle_big_02_j);
        setTouchImage(C0000R.drawable.clear_accept_circle_big_01_j, C0000R.drawable.clear_reject_circle_big_01_j);
    }

    public IncomingSlidingWidgetCover(Context context) {
        super(context);
    }

    public IncomingSlidingWidgetCover(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IncomingSlidingWidgetCover(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override // com.coolots.chaton.call.view.layout.SlidingWidgetCover, com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        removeAllViewsInLayout();
    }
}
