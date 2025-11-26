package com.sec.chaton.multimedia.image;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3223ck;
import com.sec.common.CommonApplication;
import com.sec.vip.amschaton.AMSPlayerActivity;
import com.sec.widget.C3641ai;

/* compiled from: ImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.u */
/* loaded from: classes.dex */
class ViewOnClickListenerC1892u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ImagePagerFragment f7183a;

    ViewOnClickListenerC1892u(ImagePagerFragment imagePagerFragment) {
        this.f7183a = imagePagerFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C3197bl.m11159a()) {
            if (C3223ck.m11327a()) {
                if (this.f7183a.f6953s != EnumC1455w.IMAGE && this.f7183a.f6953s != EnumC1455w.AMS) {
                    if (this.f7183a.f6953s == EnumC1455w.VIDEO) {
                        if (TextUtils.isEmpty(this.f7183a.f6952r)) {
                            this.f7183a.mo6866c();
                            return;
                        }
                        if (!C3171am.m11072j() || !C3171am.m11073k()) {
                            C3641ai.m13210a(this.f7183a.getActivity(), R.string.chatroom_unable_to_record_during_call, 0).show();
                            return;
                        }
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setDataAndType(Uri.parse("file://" + this.f7183a.f6952r), "video/*");
                        intent.putExtra("android.intent.extra.finishOnCompletion", false);
                        this.f7183a.startActivity(intent);
                        return;
                    }
                    return;
                }
                Intent intent2 = new Intent(this.f7183a.getActivity(), (Class<?>) AMSPlayerActivity.class);
                intent2.putExtra("AMS_FILE_PATH", this.f7183a.f6952r);
                intent2.putExtra("VIEWER_MODE", 1002);
                this.f7183a.startActivity(intent2);
                return;
            }
            C3641ai.m13210a(CommonApplication.m11493l(), R.string.sdcard_not_found, 0).show();
        }
    }
}
