package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.spp.push.dlc.api.IDlcApi;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ec */
/* loaded from: classes.dex */
class RunnableC4202ec implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f15535a;

    /* renamed from: b */
    final /* synthetic */ PluginComposeMessageActivity f15536b;

    RunnableC4202ec(PluginComposeMessageActivity pluginComposeMessageActivity, int i) {
        this.f15536b = pluginComposeMessageActivity;
        this.f15535a = i;
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        String string;
        String string2;
        Resources resources = this.f15536b.getResources();
        switch (this.f15535a) {
            case -9:
                Toast.makeText(this.f15536b, resources.getString(R.string.hugefile_file_size_error) + (C3847e.m14653aD() / 1073741824), 1).show();
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
                if (C3847e.m14652aC()) {
                    if (!C4822an.m18218a()) {
                        if (!C4809aa.m18104a().m18119a("pref_key_do_not_show_register_chaton_to_send_large_file", (Boolean) false).booleanValue()) {
                            this.f15536b.m15968a(resources.getString(R.string.exceed_message_size_limitation), resources.getString(R.string.large_file_please_register, Integer.valueOf(C3847e.m14653aD() / 1073741824)), resources.getString(R.string.large_file_do_not_show_again), 7001);
                            return;
                        } else {
                            string = resources.getString(R.string.exceed_message_size_limitation);
                            string2 = resources.getString(R.string.large_file_exceed_size);
                            break;
                        }
                    } else {
                        return;
                    }
                } else {
                    string = resources.getString(R.string.exceed_message_size_limitation);
                    string2 = resources.getString(R.string.msg_unable_to_attach_file_size_too_large);
                    break;
                }
            case -1:
                Toast.makeText(this.f15536b, resources.getString(R.string.failed_to_add_all_media), 0).show();
                return;
        }
        C4149cd.m16410a((Context) this.f15536b, string, string2);
    }
}
