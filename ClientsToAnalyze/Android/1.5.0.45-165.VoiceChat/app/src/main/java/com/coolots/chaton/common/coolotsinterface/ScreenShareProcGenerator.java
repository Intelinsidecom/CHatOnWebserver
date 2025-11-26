package com.coolots.chaton.common.coolotsinterface;

import com.coolots.chaton.SECConfig;
import com.coolots.chaton.call.screenshare.ScreenShareProc;
import com.sds.coolots.call.screenshare.ScreenShareProcInterface;
import com.sds.coolots.common.coolotsinterface.ScreenShareProcGeneratorInterface;

/* loaded from: classes.dex */
public class ScreenShareProcGenerator implements ScreenShareProcGeneratorInterface {
    private static final int REMOTEVIEW = 1;
    private static final int SURFACEVIEW = 0;

    @Override // com.sds.coolots.common.coolotsinterface.ScreenShareProcGeneratorInterface
    public ScreenShareProcInterface createScreenShareProc() {
        return ScreenShareProc.getInstance();
    }

    @Override // com.sds.coolots.common.coolotsinterface.ScreenShareProcGeneratorInterface
    public void resetShareScreenSurface() {
        SECConfig.setVideoSurfaceData(0, null);
        SECConfig.setVideoSurfaceData(1, null);
    }
}
