package com.coolots.chaton.call.controller;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.model.InviteViewBuddyList;
import com.coolots.chaton.common.util.BuddyImageView;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.google.android.gcm.GCMConstants;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.io.IOException;

/* loaded from: classes.dex */
public class InviteViewAdapter extends BaseAdapter implements DisposeInterface {
    private static final String CLASSNAME = "[InviteViewAdapter]";
    private Handler mActivityHandler;
    private final Context mContext;
    private LayoutInflater mInflater;
    private InviteViewBuddyList mList;
    private boolean mOutGoingHost;

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public InviteViewAdapter(Context context, Handler handler, InviteViewBuddyList list, boolean outGoingHost) {
        this.mOutGoingHost = false;
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mActivityHandler = handler;
        this.mList = list;
        this.mOutGoingHost = outGoingHost;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mList.getBuddiesCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.mList.getBuddy(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(final int position, View convertView, ViewGroup parent) throws IOException {
        ViewHolder holder;
        if (convertView == null) {
            convertView = this.mInflater.inflate(C0000R.layout.video_call_invite_buddies_item, parent, false);
            holder = new ViewHolder();
            holder.imgView = (BuddyImageView) convertView.findViewById(C0000R.id.video_invite_buddy_profile);
            holder.dimImgView = convertView.findViewById(C0000R.id.video_invite_waiting_buddy_profile);
            holder.animationImg = (ImageView) convertView.findViewById(C0000R.id.video_invite_waiting_buddy_profile_anim);
            holder.nameView = (TextView) convertView.findViewById(C0000R.id.video_invite_buddy_item_name);
            holder.cancelBtn = (ImageView) convertView.findViewById(C0000R.id.video_invite_buddy_item_end_button);
            holder.hostView = (ImageView) convertView.findViewById(C0000R.id.video_invite_buddy_item_host);
            holder.imgView.setImageViewMode(0);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.imgView.loadThumbImage(this.mList.getBuddy(position).getUserID());
        if (this.mList.getBuddy(position).getUserCallState() == 3) {
            holder.dimImgView.setVisibility(8);
        } else {
            holder.dimImgView.setVisibility(0);
        }
        if (this.mList.getBuddy(position).getUserCallState() == 3 || this.mList.getBuddy(position).getUserCallState() == 2) {
            holder.animationImg.setVisibility(8);
            holder.animationImg.setBackgroundResource(C0000R.anim.invite_waiting_buddy_effect);
            AnimationDrawable frameAnimation = (AnimationDrawable) holder.animationImg.getBackground();
            frameAnimation.stop();
        } else {
            holder.animationImg.setVisibility(0);
            holder.animationImg.setBackgroundResource(C0000R.anim.invite_waiting_buddy_effect);
            AnimationDrawable frameAnimation2 = (AnimationDrawable) holder.animationImg.getBackground();
            frameAnimation2.start();
        }
        if (holder.nameView.equals("") || holder.nameView.equals("null")) {
            holder.nameView.setText(C0000R.string.unsaved_buddy);
        } else {
            holder.nameView.setText(this.mList.getBuddy(position).getUserDiscription());
        }
        if (this.mList.getBuddy(position).getUserType().equals(SimpleUserInfo.TYPE_HOST)) {
            holder.hostView.setVisibility(0);
        } else {
            holder.hostView.setVisibility(8);
        }
        if (!this.mList.getBuddy(position).getUserType().equals(SimpleUserInfo.TYPE_HOST) && this.mList.getBuddy(position).getUserCallState() != 3 && this.mOutGoingHost) {
            holder.cancelBtn.setVisibility(0);
        } else {
            holder.cancelBtn.setVisibility(8);
        }
        holder.cancelBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.controller.InviteViewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Message msg = new Message();
                msg.what = 10;
                msg.arg1 = position;
                InviteViewAdapter.this.mActivityHandler.sendMessage(msg);
            }
        });
        return convertView;
    }

    static class ViewHolder {
        ImageView animationImg;
        ImageView cancelBtn;
        View dimImgView;
        ImageView hostView;
        BuddyImageView imgView;
        TextView nameView;

        ViewHolder() {
        }
    }

    public String getStateString(int state) {
        switch (state) {
            case 1:
                return this.mContext.getResources().getString(C0000R.string.call_info_outgoing_video_call);
            case 2:
                return this.mContext.getResources().getString(C0000R.string.call_info_callend);
            default:
                return GCMConstants.EXTRA_ERROR;
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        logI("dispose()");
        this.mInflater = null;
        if (this.mList != null) {
            this.mList.dispose();
            this.mList = null;
        }
        if (this.mActivityHandler != null) {
            this.mActivityHandler.removeMessages(10);
            this.mActivityHandler.removeMessages(11);
            this.mActivityHandler = null;
        }
    }
}
