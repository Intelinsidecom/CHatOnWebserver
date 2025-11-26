package com.sec.chaton.smsplugin.multimedia.geotag;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: MmsGeotagActivity.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.geotag.c */
/* loaded from: classes.dex */
class HandlerC3925c extends Handler {

    /* renamed from: a */
    final /* synthetic */ MmsGeotagActivity f14153a;

    HandlerC3925c(MmsGeotagActivity mmsGeotagActivity) {
        this.f14153a = mmsGeotagActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f14153a.f14116B != null) {
            C3890m.m14996b(MmsGeotagActivity.f14114b, "mark with networkLocation ");
            this.f14153a.m15144a(this.f14153a.f14116B);
            return;
        }
        if (this.f14153a.f14148z == null) {
            this.f14153a.f14148z = AbstractC4932a.m18733a(this.f14153a.f14125c).mo18740a(this.f14153a.getResources().getString(R.string.geotag_dialog_findgsp_title_failed_find_location)).mo18749b(this.f14153a.getResources().getString(R.string.geotag_dialog_findgsp_message_failed_find_location)).mo18755c(this.f14153a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC3927e(this)).mo18741a(this.f14153a.getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC3926d(this)).mo18751b(false).mo18745a();
            this.f14153a.f14148z.mo18758a().setCanceledOnTouchOutside(false);
        }
        this.f14153a.f14148z.show();
        this.f14153a.f14145w = true;
    }
}
