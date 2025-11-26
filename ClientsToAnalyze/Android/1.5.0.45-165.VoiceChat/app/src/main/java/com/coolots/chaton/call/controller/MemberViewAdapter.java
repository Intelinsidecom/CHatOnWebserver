package com.coolots.chaton.call.controller;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.model.CallUserAddedInfo;
import com.coolots.chaton.common.util.BuddyImageView;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class MemberViewAdapter extends BaseAdapter implements DisposeInterface {
    private static final String CLASSNAME = "[MemberViewAdapter]";
    private static final boolean SUPPORT_CANCEL_BUTTON = false;
    private Handler mActivityHandler;
    private Context mContext;
    private final int mEndBtnID;
    private int mImgViewID;
    private LayoutInflater mInflater;
    private final boolean mIsHost;
    private int mItemLayout;
    private int mTextViewID;
    private List<String> mUserNameList = null;
    private List<String> mUserIDList = null;
    private List<String> mUserStatusList = null;

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private static void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public MemberViewAdapter(Context context, Handler handler, Destination memberList, CallUserAddedInfo userAddedInfo, int itemLayout, int imgViewID, int textViewID, int endBtnID, boolean isHost) {
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mActivityHandler = handler;
        memberCopy(memberList, userAddedInfo);
        this.mItemLayout = itemLayout;
        this.mImgViewID = imgViewID;
        this.mTextViewID = textViewID;
        this.mEndBtnID = endBtnID;
        this.mIsHost = isHost;
    }

    public final void memberCopy(Destination memberList, CallUserAddedInfo userAddedInfo) {
        initData();
        if (memberList.getDestinationType() == 5) {
            Iterator<P2PUserInfo> iter = memberList.getP2PConferenceMember().iterator();
            while (iter.hasNext()) {
                P2PUserInfo member = iter.next();
                logE("memberCopy " + member.userID + " " + member.userState);
                if (member.userState == 1) {
                    this.mUserIDList.add(member.userID);
                    this.mUserStatusList.add(toStatusString(member.userState));
                    this.mUserNameList.add(userAddedInfo.getUserDisplayNameByUserID(member.userID));
                }
            }
            return;
        }
        Iterator<SimpleUserInfo> iter2 = memberList.getConferenceMember().iterator();
        while (iter2.hasNext()) {
            SimpleUserInfo member2 = iter2.next();
            logE("memberCopy " + member2.getUserID() + " " + member2.getStatus());
            if (member2.getStatus().equals("1") || member2.getStatus().equals(SimpleUserInfo.STATE_MOVETO_CONFERENCE)) {
                this.mUserIDList.add(member2.getUserID());
                this.mUserStatusList.add(toStatusString(member2.getStatus()));
                this.mUserNameList.add(userAddedInfo.getUserDisplayNameByUserID(member2.getUserID()));
            }
        }
    }

    public static int getMemberListCount(Destination memberList) {
        int memberCnt = 0;
        if (memberList.getDestinationType() == 5) {
            Iterator it = memberList.getP2PConferenceMember().iterator();
            while (it.hasNext()) {
                if (((P2PUserInfo) it.next()).userState == 1) {
                    memberCnt++;
                }
            }
        } else {
            Iterator it2 = memberList.getConferenceMember().iterator();
            while (it2.hasNext()) {
                SimpleUserInfo userInfo = (SimpleUserInfo) it2.next();
                if (userInfo.getStatus().equals("1") || userInfo.getStatus().equals(SimpleUserInfo.STATE_MOVETO_CONFERENCE)) {
                    memberCnt++;
                }
            }
        }
        return memberCnt;
    }

    private String toStatusString(String status) {
        if (!"1".equals(status) && !SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(status) && "0".equals(status)) {
            return this.mContext.getString(C0000R.string.video_call_member_info_view_waiting);
        }
        return "";
    }

    private String toStatusString(int status) {
        if (1 != status && status == 0) {
            return this.mContext.getString(C0000R.string.video_call_member_info_view_waiting);
        }
        return "";
    }

    private void initData() {
        if (this.mUserNameList != null) {
            this.mUserNameList.clear();
            this.mUserNameList = null;
        }
        if (this.mUserIDList != null) {
            this.mUserIDList.clear();
            this.mUserIDList = null;
        }
        if (this.mUserStatusList != null) {
            this.mUserStatusList.clear();
            this.mUserStatusList = null;
        }
        this.mUserNameList = new ArrayList();
        this.mUserIDList = new ArrayList();
        this.mUserStatusList = new ArrayList();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mUserIDList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.mUserIDList.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) throws IOException {
        logI("getView(" + position + ")");
        if (convertView == null) {
            logI("convertView reload..... ");
            convertView = this.mInflater.inflate(this.mItemLayout, parent, false);
        }
        BuddyImageView imgView = (BuddyImageView) convertView.findViewById(this.mImgViewID);
        logI("mUserIDList = " + this.mUserIDList.get(position));
        logI("mUserIDList size() = " + this.mUserIDList.size());
        if (this.mUserIDList.get(position) != null && !this.mUserIDList.get(position).isEmpty()) {
            imgView.setImageViewMode(0);
            imgView.loadThumbImage(this.mUserIDList.get(position));
        }
        TextView nameView = (TextView) convertView.findViewById(this.mTextViewID);
        if (nameView.equals("") || nameView.equals("null")) {
            nameView.setText(C0000R.string.unsaved_buddy);
        } else {
            nameView.setText(String.valueOf(this.mUserNameList.get(position)) + " " + this.mUserStatusList.get(position));
        }
        setCancelButton(position, convertView);
        return convertView;
    }

    private void setCancelButton(int position, View convertView) {
        Button cancelBtn = (Button) convertView.findViewById(this.mEndBtnID);
        cancelBtn.setVisibility(8);
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        this.mInflater = null;
        if (this.mUserNameList != null) {
            this.mUserNameList.clear();
            this.mUserNameList = null;
        }
        if (this.mUserIDList != null) {
            this.mUserIDList.clear();
            this.mUserIDList = null;
        }
        if (this.mUserStatusList != null) {
            this.mUserStatusList.clear();
            this.mUserStatusList = null;
        }
        this.mContext = null;
        if (this.mActivityHandler != null) {
            this.mActivityHandler.removeMessages(10);
            this.mActivityHandler = null;
        }
    }
}
