package com.sec.chaton.chat;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.api.p048a.AbstractC1019a;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.ex */
/* loaded from: classes.dex */
class ViewOnClickListenerC1697ex implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatInfoFragment f6299a;

    ViewOnClickListenerC1697ex(ChatInfoFragment chatInfoFragment) {
        this.f6299a = chatInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C4904y.m18641c("go to this topic", ChatInfoFragment.f5755a);
        if (!C4847bl.m18333a()) {
            if (TextUtils.isEmpty(this.f6299a.f5785ad)) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("buddy id is null", ChatInfoFragment.f5755a);
                    return;
                }
                return;
            }
            try {
                StringBuilder sb = new StringBuilder("chaton://");
                sb.append("live/livecontents?");
                sb.append("buddyid=").append(URLEncoder.encode(this.f6299a.f5785ad, AbstractC1019a.f3317b)).append("&");
                if (!TextUtils.isEmpty(this.f6299a.f5784ac)) {
                    sb.append("buddyname=").append(URLEncoder.encode(this.f6299a.f5784ac, AbstractC1019a.f3317b)).append("&");
                }
                if (!TextUtils.isEmpty(this.f6299a.f5783ab)) {
                    sb.append("ctid=").append(URLEncoder.encode(this.f6299a.f5783ab, AbstractC1019a.f3317b));
                }
                Uri uri = Uri.parse(sb.toString());
                Intent intentM2921a = IntentControllerActivity.m2921a(CommonApplication.m18732r(), 1);
                intentM2921a.setData(uri);
                this.f6299a.startActivity(intentM2921a);
                ((InterfaceC1710fj) this.f6299a.getActivity()).mo8281h();
            } catch (UnsupportedEncodingException e) {
                if (C4904y.f17872b) {
                    C4904y.m18635a(e, ChatInfoFragment.f5755a);
                }
            }
        }
    }
}
