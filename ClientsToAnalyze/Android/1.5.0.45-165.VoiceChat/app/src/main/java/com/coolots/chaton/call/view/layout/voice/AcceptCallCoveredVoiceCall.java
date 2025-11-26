package com.coolots.chaton.call.view.layout.voice;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class AcceptCallCoveredVoiceCall extends AcceptCallCoveredWidget implements View.OnClickListener, DisposeInterface, View.OnTouchListener {
    public static final String CLASSNAME = "[AcceptCallCoveredVoiceCall]";

    public AcceptCallCoveredVoiceCall(Context context, ChatOnCallActivity parent, Destination destination, ViewGroup r) {
        super(context, parent, destination, r);
        int childViewCount = r.getChildCount();
        LayoutInflater inflater = LayoutInflater.from(this.mContext);
        this.mRootGroupView = (ViewGroup) inflater.inflate(C0000R.layout.accept_voice_call_cover, r, true);
        this.mClearCoverEndCall = (ImageView) this.mRootGroupView.findViewById(C0000R.id.clear_end_call);
        this.mClearCoverEndCallCircle = (ImageView) this.mRootGroupView.findViewById(C0000R.id.clear_end_circle);
        this.mClearCoverEndCallCircle.setVisibility(4);
        this.mClearCoverEndCall.setOnTouchListener(this);
        this.mClearCoverUserName = (TextView) this.mRootGroupView.findViewById(C0000R.id.accept_cover_user_name);
        this.mClearCoverUserMessage = (TextView) this.mRootGroupView.findViewById(C0000R.id.accept_cover_user_message);
        this.mElapsedTime = (Chronometer) this.mRootGroupView.findViewById(C0000R.id.voice_status_time);
        this.mClearCoverAccept_user_info = (RelativeLayout) this.mRootGroupView.findViewById(C0000R.id.accept_user_info);
        this.mClearCoverAccept_user_info.setOnTouchListener(this);
        this.mRedArrowCover = (ImageView) this.mRootGroupView.findViewById(C0000R.id.accept_red_arrow_cover);
        this.mClearEndCallLayout = (FrameLayout) this.mRootGroupView.findViewById(C0000R.id.clear_end_layout);
        this.mRedArrowCover.setBackgroundResource(C0000R.anim.red_arrow_effect);
        AnimationDrawable redAnimation = (AnimationDrawable) this.mRedArrowCover.getBackground();
        redAnimation.start();
        this.mDestination = destination;
        this.mParentActivity = parent;
        this.mRootGroupView.getChildAt(childViewCount).setTag(String.valueOf(getClass().toString()) + getConfiguration());
        setMoveImage(C0000R.drawable.clear_accept_circle_big_02_j, C0000R.drawable.clear_reject_circle_big_02_j);
        setTouchImage(C0000R.drawable.clear_accept_circle_big_01_j, C0000R.drawable.clear_reject_circle_big_01_j);
        setTouchId(C0000R.id.clear_end_call);
    }

    @Override // com.coolots.chaton.call.view.layout.voice.AcceptCallCoveredWidget, com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        removeAllViewsInLayout();
    }
}
