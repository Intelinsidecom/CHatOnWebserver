package com.coolots.chaton.call.view.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.coolots.chaton.C0000R;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class ShowCallMemberViewlayout extends RelativeLayout implements DisposeInterface {
    private static final String CLASSNAME = "[ShowCallMemberViewlayout]";
    private ViewGroup mRootGroupView;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public ShowCallMemberViewlayout(Context context) {
        super(context);
        this.mContext = context;
        LayoutInflater inflater = LayoutInflater.from(this.mContext);
        inflater.inflate(C0000R.layout.video_call_member, (ViewGroup) this, true);
    }

    public ShowCallMemberViewlayout(Context context, ViewGroup r) {
        super(context);
        this.mContext = context;
        int childViewCount = r.getChildCount();
        LayoutInflater inflater = LayoutInflater.from(this.mContext);
        this.mRootGroupView = (ViewGroup) inflater.inflate(C0000R.layout.video_call_member, r, true);
        this.mRootGroupView.getChildAt(childViewCount).setTag(String.valueOf(getClass().toString()) + getConfiguration());
    }

    public ViewGroup getLayoutreference() {
        if (this.mRootGroupView != null) {
            return this.mRootGroupView;
        }
        return null;
    }

    public ShowCallMemberViewlayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public ShowCallMemberViewlayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
    }

    public void initialize() {
        LayoutInflater inflater = LayoutInflater.from(this.mContext);
        inflater.inflate(C0000R.layout.ended_call_clear_cover, (ViewGroup) this, true);
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mContext != null) {
            this.mContext = null;
        }
        removeAllViewsInLayout();
    }

    private int getConfiguration() {
        return getResources().getConfiguration().orientation;
    }
}
