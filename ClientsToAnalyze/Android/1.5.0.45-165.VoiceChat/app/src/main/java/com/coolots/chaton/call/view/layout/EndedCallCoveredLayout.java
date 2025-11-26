package com.coolots.chaton.call.view.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class EndedCallCoveredLayout extends EndedCallCoveredWidget implements DisposeInterface {
    private static final String CLASSNAME = "[EndCallCoveredLayout]";

    public EndedCallCoveredLayout(Context context, ViewGroup r, Destination destination, ChatOnCallActivity parentActivity) {
        super(context, r, destination, parentActivity);
        int childViewCount = r.getChildCount();
        LayoutInflater inflater = LayoutInflater.from(this.mContext);
        this.mRootGroupView = (ViewGroup) inflater.inflate(C0000R.layout.ended_call_clear_cover, r, true);
        this.mClearCoverUserName = (TextView) this.mRootGroupView.findViewById(C0000R.id.end_call_cover_ui_name);
        this.mClearCoverUserMessage = (TextView) this.mRootGroupView.findViewById(C0000R.id.end_call_cover_ui_message);
        this.mRootGroupView.getChildAt(childViewCount).setTag(String.valueOf(getClass().toString()) + getConfiguration());
    }

    public EndedCallCoveredLayout(Context context) {
        super(context);
        this.mContext = context;
    }

    public EndedCallCoveredLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public EndedCallCoveredLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
    }

    @Override // com.coolots.chaton.call.view.layout.EndedCallCoveredWidget
    public void setClearCoverActive(CallDisplayUserInfo calluserInfo) {
        this.mClearCoverUserName.setText(calluserInfo.userName);
        this.mClearCoverUserMessage.setText(calluserInfo.userStateMsg);
    }

    @Override // com.coolots.chaton.call.view.layout.EndedCallCoveredWidget
    public void initialize(Destination destination, ChatOnCallActivity parentActivity) {
        LayoutInflater inflater = LayoutInflater.from(this.mContext);
        this.mDestination = destination;
        this.mParentActivity = parentActivity;
        inflater.inflate(C0000R.layout.ended_call_clear_cover, (ViewGroup) this, true);
        this.mClearCoverUserName = (TextView) findViewById(C0000R.id.end_call_cover_ui_name);
        this.mClearCoverUserMessage = (TextView) findViewById(C0000R.id.end_call_cover_ui_message);
    }

    @Override // com.coolots.chaton.call.view.layout.EndedCallCoveredWidget, com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        removeAllViewsInLayout();
    }
}
