package com.coolots.chaton.call.screenshare;

import android.app.ProgressDialog;
import android.app.Service;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.screenshare.core.OverlayView;
import com.coolots.chaton.call.screenshare.util.AlertView;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.PhoneStateMachine;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class QuickShareView extends OverlayView implements DisposeInterface {
    private static final String CLASSNAME = "[QuickShareView]";
    protected ProgressDialog mConsentRemoteControlDialog;
    private Destination mDestination;
    private Button mEndBtn;
    private Button mMenuBtn;
    private Service mParentService;
    private PhoneStateMachine mPhoneStateMachine;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public QuickShareView(Service service) {
        super(service, C0000R.layout.screenshare_quick_view);
        this.mConsentRemoteControlDialog = null;
        this.mParentService = service;
        this.mPhoneStateMachine = MainApplication.mPhoneManager.getPhoneStateMachine();
        this.mDestination = MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination();
        load();
    }

    public Button getMenuButton() {
        return this.mMenuBtn;
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void onInflateView() {
        this.mEndBtn = (Button) findViewById(C0000R.id.share_live_end_btn);
        this.mEndBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.QuickShareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) throws Resources.NotFoundException {
                QuickShareView.this.logI("mEndBtn Click");
                AlertView alertView = new AlertView(QuickShareView.this.mParentService);
                alertView.setTitle(C0000R.string.call_btn_share_screen);
                alertView.setMessage(C0000R.string.screenshare_end_popup);
                alertView.setPositiveButton(C0000R.string.ok, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.QuickShareView.1.1
                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                    public void onClick(AlertView dialog, int which) {
                        if (ScreenShareProc.getInstance().getShareMode() == 0) {
                            MainApplication.mPhoneManager.getShareScreenManager().stopShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination());
                            ScreenShareProc.stopScreenShare();
                        } else if (ScreenShareProc.getInstance().getShareMode() == 2) {
                            QuickShareView.this.logI("SHARE_SCREEN_MODE_LIVE_SHARE localHangupCall");
                            QuickShareView.this.mPhoneStateMachine.localHangupCall(QuickShareView.this.mDestination, 10);
                            ScreenShareProc.stopScreenShare();
                        }
                    }
                });
                alertView.setNegativeButton(C0000R.string.cancel, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.QuickShareView.1.2
                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                    public void onClick(AlertView dialog, int which) {
                    }
                });
                alertView.setCancelable(true);
                alertView.show();
            }
        });
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mMenuBtn != null) {
            this.mMenuBtn.removeCallbacks(null);
            this.mMenuBtn = null;
        }
        if (this.mEndBtn != null) {
            this.mEndBtn.removeCallbacks(null);
            this.mEndBtn = null;
        }
    }
}
