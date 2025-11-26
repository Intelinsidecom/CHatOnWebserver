package com.coolots.chaton.common.view.layout;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.widget.RemoteViews;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.buddy.model.BuddyTable;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public final class InCallQuickPanel extends RemoteViews implements DisposeInterface {
    public static final String ACTION_CALL_END = "com.sec.android.voip.end";
    private static final String ACTION_CALL_MUTE = "com.sec.android.voip.mute";
    public static final String ACTION_CALL_SHOW_SCREEN = "com.sec.android.voip.showscreen";
    private static final String ACTION_CALL_SPEAKER = "com.sec.android.voip.speaker";
    private static final String ACTION_CALL_UNHOLD = "switchHoldingAndActive_voip";
    private static final BroadcastReceiver QUICKPANNELRECEIVER = new BroadcastReceiver() { // from class: com.coolots.chaton.common.view.layout.InCallQuickPanel.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (InCallQuickPanel.ACTION_CALL_SHOW_SCREEN.equals(action)) {
                Log.m2958e("VOIP_INTERFACE QUICKPANNELRECEIVER  ACTION_CALL_SHOW_SCREEN");
                Intent movetotopIntent = new Intent("com.sds.coolots.broadcast.VOIPACTION");
                movetotopIntent.putExtra(InCallQuickPanel.VOIP_ACTION_TYPE, InCallQuickPanel.VOIP_ACTION_MOVETOTOP);
                context.sendBroadcast(movetotopIntent);
                return;
            }
            if (InCallQuickPanel.ACTION_CALL_MUTE.equals(action)) {
                Log.m2958e("VOIP_INTERFACE QUICKPANNELRECEIVER  ACTION_CALL_MUTE");
                Intent muteIntent = new Intent("com.sds.coolots.broadcast.VOIPACTION");
                muteIntent.putExtra(InCallQuickPanel.VOIP_ACTION_TYPE, InCallQuickPanel.VOIP_ACTION_SETMUTE);
                context.sendBroadcast(muteIntent);
                return;
            }
            if (InCallQuickPanel.ACTION_CALL_SPEAKER.equals(action)) {
                Log.m2958e("VOIP_INTERFACE QUICKPANNELRECEIVER  ACTION_CALL_SPEAKER");
                Intent speakerIntent = new Intent("com.sds.coolots.broadcast.VOIPACTION");
                speakerIntent.putExtra(InCallQuickPanel.VOIP_ACTION_TYPE, InCallQuickPanel.VOIP_ACTION_TURNONSPEAKER);
                context.sendBroadcast(speakerIntent);
                return;
            }
            if (InCallQuickPanel.ACTION_CALL_END.equals(action)) {
                Log.m2958e("VOIP_INTERFACE QUICKPANNELRECEIVER  ACTION_CALL_END");
                Intent callEndIntent = new Intent("com.sds.coolots.broadcast.VOIPACTION");
                callEndIntent.putExtra(InCallQuickPanel.VOIP_ACTION_TYPE, InCallQuickPanel.VOIP_ACTION_HANGUPCALL);
                context.sendBroadcast(callEndIntent);
                return;
            }
            if (InCallQuickPanel.ACTION_CALL_UNHOLD.equals(action)) {
                Log.m2958e("VOIP_INTERFACE QUICKPANNELRECEIVER  ACTION_CALL_UNHOLD");
                Intent callEndIntent2 = new Intent("com.sds.coolots.broadcast.VOIPACTION");
                callEndIntent2.putExtra(InCallQuickPanel.VOIP_ACTION_TYPE, InCallQuickPanel.ACTION_CALL_UNHOLD);
                context.sendBroadcast(callEndIntent2);
            }
        }
    };
    private static final String VOIP_ACTION_HANGUPCALL = "hangup_voip";
    private static final String VOIP_ACTION_MOVETOTOP = "movetotop_voip";
    private static final String VOIP_ACTION_SETMUTE = "setMute_voip";
    private static final String VOIP_ACTION_TURNONSPEAKER = "turnOnSpeaker_voip";
    private static final String VOIP_ACTION_TYPE = "VOIP_ACTION";
    public static long callBaseTime;
    private final Context mContext;

    public InCallQuickPanel(Context context, int layoutId) throws Resources.NotFoundException {
        super(context.getPackageName(), layoutId);
        Log.m2963i("InCallQuickPanel() create");
        this.mContext = context;
        initInCallQuickPanel();
    }

    private void initInCallQuickPanel() throws Resources.NotFoundException {
        Log.m2963i("InCallQuickPanel() initInCallQuickPanel");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_CALL_SHOW_SCREEN);
        intentFilter.addAction(ACTION_CALL_MUTE);
        intentFilter.addAction(ACTION_CALL_SPEAKER);
        intentFilter.addAction(ACTION_CALL_END);
        intentFilter.addAction(ACTION_CALL_UNHOLD);
        this.mContext.registerReceiver(QUICKPANNELRECEIVER, intentFilter);
        PendingIntent PI1 = PendingIntent.getBroadcast(this.mContext, 0, new Intent(ACTION_CALL_SHOW_SCREEN), 0);
        setLaunchPendingIntent(C0000R.id.quickpanel_call_type_btn, PI1);
        setLaunchPendingIntent(C0000R.id.quickpanel_vcall_type_btn, PI1);
        PendingIntent PI2 = PendingIntent.getBroadcast(this.mContext, 0, new Intent(ACTION_CALL_MUTE), 0);
        setOnClickPendingIntent(C0000R.id.quickpanel_call_mute, PI2);
        setOnClickPendingIntent(C0000R.id.quickpanel_call_muteon, PI2);
        PendingIntent PI3 = PendingIntent.getBroadcast(this.mContext, 0, new Intent(ACTION_CALL_SPEAKER), 0);
        setOnClickPendingIntent(C0000R.id.quickpanel_call_speaker, PI3);
        setOnClickPendingIntent(C0000R.id.quickpanel_call_speakeron, PI3);
        PendingIntent PI4 = PendingIntent.getBroadcast(this.mContext, 0, new Intent(ACTION_CALL_END), 0);
        setLaunchPendingIntent(C0000R.id.quickpanel_call_end, PI4);
        PendingIntent PI5 = PendingIntent.getBroadcast(this.mContext, 0, new Intent(ACTION_CALL_UNHOLD), 0);
        setOnClickPendingIntent(C0000R.id.quickpanel_call_unhold, PI5);
        updateInCallQuickPanel();
    }

    private void updateInCallQuickPanel() throws Resources.NotFoundException {
        Log.m2963i("InCallQuickPanel() updateInCallQuickPanel");
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        int mCallState = callInfo.getCallState();
        if (!callInfo.isValidity()) {
            MainApplication.mCallNotification.deleteCallNotification();
        }
        if (callInfo.isUseVideo()) {
            setViewVisibility(C0000R.id.quickpanel_vcall_type_layout, 0);
            setViewVisibility(C0000R.id.quickpanel_call_type_layout, 8);
        } else {
            setViewVisibility(C0000R.id.quickpanel_vcall_type_layout, 8);
            setViewVisibility(C0000R.id.quickpanel_call_type_layout, 0);
        }
        boolean speakerMode = false;
        if (callInfo.getAudioPathController() != null) {
            speakerMode = callInfo.getAudioPathController().isSpeakerON();
        }
        if (speakerMode) {
            setViewVisibility(C0000R.id.quickpanel_call_speakeron, 0);
            setViewVisibility(C0000R.id.quickpanel_call_speaker, 8);
        } else {
            setViewVisibility(C0000R.id.quickpanel_call_speakeron, 8);
            setViewVisibility(C0000R.id.quickpanel_call_speaker, 0);
        }
        if (mCallState == 4) {
            setViewVisibility(C0000R.id.quickpanel_call_unhold, 0);
            setViewVisibility(C0000R.id.quickpanel_call_muteon, 8);
            setViewVisibility(C0000R.id.quickpanel_call_mute, 8);
            setViewVisibility(C0000R.id.quickpanel_call_mutedisable, 8);
            setViewVisibility(C0000R.id.quickpanel_call_speakeron, 8);
            setViewVisibility(C0000R.id.quickpanel_call_speaker, 8);
        } else if (mCallState == 5) {
            setViewVisibility(C0000R.id.quickpanel_call_unhold, 8);
            setViewVisibility(C0000R.id.quickpanel_call_muteon, 0);
            setViewVisibility(C0000R.id.quickpanel_call_mute, 8);
            setViewVisibility(C0000R.id.quickpanel_call_mutedisable, 8);
        } else if (mCallState == 1) {
            setViewVisibility(C0000R.id.quickpanel_call_unhold, 8);
            setViewVisibility(C0000R.id.quickpanel_call_muteon, 8);
            setViewVisibility(C0000R.id.quickpanel_call_mute, 8);
            setViewVisibility(C0000R.id.quickpanel_call_mutedisable, 0);
        } else {
            setViewVisibility(C0000R.id.quickpanel_call_unhold, 8);
            setViewVisibility(C0000R.id.quickpanel_call_mutedisable, 8);
            setViewVisibility(C0000R.id.quickpanel_call_muteon, 8);
            setViewVisibility(C0000R.id.quickpanel_call_mute, 0);
        }
        if (CallState.isNotConnected(mCallState)) {
            Log.m2958e("^_______________^ reset time!!");
            setViewVisibility(C0000R.id.quickpanel_elapsedTime, 4);
        } else if (CallState.isConnected(mCallState)) {
            long callDurationBaseTime = callBaseTime;
            if (mCallState == 4) {
                setViewVisibility(C0000R.id.quickpanel_call_unhold_text, 0);
                setViewVisibility(C0000R.id.quickpanel_elapsedTime, 8);
            } else if (mCallState == 0) {
                setViewVisibility(C0000R.id.quickpanel_call_unhold_text, 8);
                setViewVisibility(C0000R.id.quickpanel_elapsedTime, 0);
                setChronometer(C0000R.id.quickpanel_elapsedTime, callDurationBaseTime, null, true);
            } else if (mCallState == 2 || mCallState == 4 || mCallState == 5) {
                setViewVisibility(C0000R.id.quickpanel_call_unhold_text, 8);
                setViewVisibility(C0000R.id.quickpanel_elapsedTime, 0);
                setChronometer(C0000R.id.quickpanel_elapsedTime, callBaseTime, null, true);
            } else {
                setViewVisibility(C0000R.id.quickpanel_call_unhold_text, 8);
                setViewVisibility(C0000R.id.quickpanel_elapsedTime, 0);
                setChronometer(C0000R.id.quickpanel_elapsedTime, callDurationBaseTime, null, true);
            }
        } else if (CallState.isDisconnected(callInfo.getCallState())) {
            setChronometer(C0000R.id.quickpanel_elapsedTime, 0L, null, false);
        }
        if (callInfo.getDestination() == null) {
            Log.m2963i("QuickPanel - delete notification when destination is null!!!!!!!");
            MainApplication.mCallNotification.deleteCallNotification();
            return;
        }
        switch (callInfo.getDestination().getDestinationType()) {
            case 2:
                BuddyManagerInterface buddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
                BuddyTable table = buddyManager.getBuddyInfoForCallLogDetail(callInfo.getDestination().getString());
                String userName = null;
                if (table != null) {
                    userName = table.getDisplayName();
                }
                Log.m2963i("haeri username??" + userName);
                if (userName == null) {
                    userName = callInfo.getHostDisplayName();
                }
                setTextViewText(C0000R.id.quickpanel_call_usernumber, userName);
                break;
            case 4:
            case 5:
                int GroupUserNumber = callInfo.getDestination().getConferenceMemberCountWithMe();
                String groupString = MainApplication.mContext.getResources().getString(C0000R.string.quick_panel_group);
                setTextViewText(C0000R.id.quickpanel_call_usernumber, String.valueOf(groupString) + "(" + GroupUserNumber + ")");
                break;
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
    }
}
