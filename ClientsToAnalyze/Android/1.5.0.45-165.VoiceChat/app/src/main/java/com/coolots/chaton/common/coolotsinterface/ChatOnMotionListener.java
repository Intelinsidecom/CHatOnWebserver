package com.coolots.chaton.common.coolotsinterface;

import android.hardware.motion.MREvent;
import android.hardware.motion.MRListener;
import android.hardware.motion.MotionRecognitionManager;
import android.os.Handler;
import android.os.Message;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.common.coolotsinterface.MotionListener;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class ChatOnMotionListener implements MotionListener {
    public static final int MOTION_EVENT_DIRECT_CALL = 0;
    private static MotionRecognitionManager mMotionSensorManager = null;
    private Handler mHandler = null;
    private final MRListener mMotionListener = new MRListener() { // from class: com.coolots.chaton.common.coolotsinterface.ChatOnMotionListener.1
        public void onMotionListener(MREvent motionEvent) {
            switch (motionEvent.getMotion()) {
                case 10:
                    Log.m2958e("<<YHT10>> onMotionListener!!!! FLIP_TOP_TO_BOTTOM!!!!");
                    CallStatusData callInfo = new CallStatusData();
                    MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
                    if (CallState.isCalling(callInfo.getCallState()) && !MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall()) {
                        MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopRingStream();
                        MainApplication.mPhoneManager.getPhoneStateMachine().notifyStopRingtone();
                        break;
                    }
                    break;
                case 68:
                    Log.m2958e("<<YHT10>> onMotionListener!!!! DirectCall!!!!");
                    if (ChatOnMotionListener.this.mHandler != null) {
                        Message msg = ChatOnMotionListener.this.mHandler.obtainMessage(0);
                        ChatOnMotionListener.this.mHandler.sendMessage(msg);
                        break;
                    }
                    break;
            }
        }
    };

    @Override // com.sds.coolots.common.coolotsinterface.MotionListener
    public void startMotionCatch() {
        if (mMotionSensorManager == null) {
            mMotionSensorManager = (MotionRecognitionManager) MainApplication.mContext.getSystemService("motion_recognition");
        }
        Log.m2958e("<<YHT10>> startMotionCatch!!!!");
        mMotionSensorManager.registerListenerEvent(this.mMotionListener, 1);
    }

    @Override // com.sds.coolots.common.coolotsinterface.MotionListener
    public void stopMotionCatch() {
        if (mMotionSensorManager != null) {
            Log.m2958e("<<YHT10>> stopMotionCatch!!!!");
            mMotionSensorManager.unregisterListener(this.mMotionListener);
            mMotionSensorManager = null;
        }
        if (this.mHandler != null) {
            this.mHandler = null;
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.MotionListener
    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }
}
