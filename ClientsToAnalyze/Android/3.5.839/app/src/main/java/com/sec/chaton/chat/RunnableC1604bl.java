package com.sec.chaton.chat;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.spp.push.dlc.api.IDlcApi;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bl */
/* loaded from: classes.dex */
class RunnableC1604bl implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f6119a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f6120b;

    RunnableC1604bl(ChatFragment chatFragment, int i) {
        this.f6120b = chatFragment;
        this.f6119a = i;
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        String string;
        String string2;
        Resources resources = this.f6120b.getResources();
        switch (this.f6119a) {
            case -9:
                Toast.makeText(this.f6120b.getActivity(), resources.getString(R.string.hugefile_file_size_error) + (C3847e.m14653aD() / 1073741824), 1).show();
                return;
            case -8:
            case -7:
            case IDlcApi.RC_NOT_REGISTERED /* -6 */:
            case IDlcApi.RC_URGENT_NOT_ALLOWED /* -5 */:
            default:
                string = resources.getString(R.string.unsupported_media_all_format);
                string2 = resources.getString(R.string.failed_to_add_all_media);
                break;
            case IDlcApi.RC_NOT_PERMITTED /* -4 */:
                string = resources.getString(R.string.failed_to_resize_image);
                string2 = resources.getString(R.string.resize_image_error_information);
                break;
            case IDlcApi.RC_APPLICATION_BLOCKED /* -3 */:
                string = resources.getString(R.string.unsupported_media_all_format);
                string2 = resources.getString(R.string.select_different_all_media);
                break;
            case IDlcApi.RC_SVC_UNAVAILABLE /* -2 */:
                string = resources.getString(R.string.exceed_message_size_limitation);
                string2 = resources.getString(R.string.msg_unable_to_attach_file_size_too_large);
                break;
            case -1:
                Toast.makeText(this.f6120b.getActivity(), resources.getString(R.string.failed_to_add_all_media), 0).show();
                return;
        }
        C4149cd.m16410a((Context) this.f6120b.getActivity(), string, string2);
    }
}
