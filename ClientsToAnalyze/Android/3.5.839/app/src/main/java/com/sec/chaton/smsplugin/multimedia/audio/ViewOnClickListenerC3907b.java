package com.sec.chaton.smsplugin.multimedia.audio;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.audio.C2743s;
import com.sec.chaton.util.C4822an;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.io.IOException;

/* compiled from: MmsVoiceListAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.audio.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC3907b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3906a f14044a;

    ViewOnClickListenerC3907b(C3906a c3906a) {
        this.f14044a = c3906a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        String str = (String) view.getTag();
        if (!TextUtils.isEmpty(str)) {
            if (this.f14044a.f14042t == null) {
                this.f14044a.f14042t = new C2743s(this.f14044a.f14043u);
            }
            if (str.equals(this.f14044a.f14041s)) {
                this.f14044a.f14042t.m11507a();
                return;
            }
            if (C4822an.m18245m() && C4822an.m18246n()) {
                if (this.f14044a.f14040r != null) {
                    ((ImageView) this.f14044a.f14040r).setImageResource(R.drawable.chat_attach_btn_play);
                }
                this.f14044a.f14042t.m11508a(str);
                this.f14044a.f14040r = view;
                this.f14044a.f14041s = str;
                return;
            }
            C5179v.m19810a(CommonApplication.m18732r(), R.string.chatroom_unable_to_record_during_call, 0).show();
        }
    }
}
