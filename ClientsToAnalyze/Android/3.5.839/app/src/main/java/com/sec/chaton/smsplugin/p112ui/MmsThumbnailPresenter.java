package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.graphics.BitmapFactory;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p110g.C3855a;
import com.sec.chaton.smsplugin.p110g.C3856b;
import com.sec.chaton.smsplugin.p110g.C3861g;
import com.sec.chaton.smsplugin.p110g.C3866l;
import com.sec.chaton.smsplugin.p110g.C3869o;
import com.sec.chaton.smsplugin.p110g.C3870p;
import com.sec.chaton.smsplugin.p110g.C3873s;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* loaded from: classes.dex */
public class MmsThumbnailPresenter extends AbstractC4277gx {
    private static final String TAG = "MmsThumbnailPresenter";

    public MmsThumbnailPresenter(Context context, InterfaceC4343ji interfaceC4343ji, C3866l c3866l) {
        super(context, interfaceC4343ji, c3866l);
    }

    @Override // com.sec.chaton.smsplugin.p112ui.AbstractC4277gx
    public void present() {
        C3869o c3869o = ((C3870p) this.mModel).get(0);
        if (((C3870p) this.mModel).m14923l().size() == 0 && !c3869o.m14869i()) {
            c3869o = ((C3870p) this.mModel).get(1);
        }
        if (c3869o != null) {
            presentSlide((InterfaceC4315ih) this.mView, c3869o);
        }
    }

    private void presentSlide(InterfaceC4315ih interfaceC4315ih, C3869o c3869o) {
        interfaceC4315ih.mo15734e();
        if (c3869o.m14863e()) {
            presentImageThumbnail(interfaceC4315ih, c3869o.m14875o());
            return;
        }
        if (c3869o.m14867g()) {
            presentVideoThumbnail(interfaceC4315ih, c3869o.m14877q());
        } else if (c3869o.m14865f()) {
            presentAudioThumbnail(interfaceC4315ih, c3869o.m14876p());
        } else if (((C3870p) this.mModel).m14921j()) {
            presentRawAttachmentThumbnail(interfaceC4315ih, ((C3870p) this.mModel).m14923l().get(0));
        }
    }

    private void presentVideoThumbnail(InterfaceC4315ih interfaceC4315ih, C3873s c3873s) {
        if (c3873s.m14823x()) {
            showDrmIcon(interfaceC4315ih, c3873s.m14816q());
        } else {
            interfaceC4315ih.setVideo(c3873s.m14816q(), c3873s.m14813n());
        }
    }

    private void presentImageThumbnail(InterfaceC4315ih interfaceC4315ih, C3861g c3861g) {
        if (c3861g.m14823x()) {
            showDrmIcon(interfaceC4315ih, c3861g.m14816q());
        } else {
            interfaceC4315ih.setImage(c3861g.m14816q(), c3861g.m14776e());
        }
    }

    protected void presentAudioThumbnail(InterfaceC4315ih interfaceC4315ih, C3856b c3856b) {
        if (c3856b.m14823x()) {
            showDrmIcon(interfaceC4315ih, c3856b.m14816q());
        } else {
            interfaceC4315ih.setAudio(c3856b.m14813n(), c3856b.m14816q(), c3856b.m14751a());
        }
    }

    protected void presentRawAttachmentThumbnail(InterfaceC4315ih interfaceC4315ih, C3855a c3855a) {
        interfaceC4315ih.setRawAttachment(c3855a.m14748d());
    }

    private void showDrmIcon(InterfaceC4315ih interfaceC4315ih, String str) {
        try {
            interfaceC4315ih.setImage(str, BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ic_mms_drm_protected));
        } catch (OutOfMemoryError e) {
            C3890m.m14995a(TAG, "showDrmIcon: out of memory: ", e);
        }
    }

    @Override // com.sec.chaton.smsplugin.p110g.InterfaceC3860f
    public void onModelChanged(C3866l c3866l, boolean z) {
    }
}
