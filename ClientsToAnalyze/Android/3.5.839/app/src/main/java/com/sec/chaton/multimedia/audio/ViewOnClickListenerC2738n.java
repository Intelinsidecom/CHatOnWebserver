package com.sec.chaton.multimedia.audio;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4822an;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.io.IOException;

/* compiled from: VoiceListAdapter.java */
/* renamed from: com.sec.chaton.multimedia.audio.n */
/* loaded from: classes.dex */
class ViewOnClickListenerC2738n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C2737m f9830a;

    ViewOnClickListenerC2738n(C2737m c2737m) {
        this.f9830a = c2737m;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        String str = (String) view.getTag();
        if (!TextUtils.isEmpty(str)) {
            if (this.f9830a.f9828t == null) {
                this.f9830a.f9828t = new C2743s(this.f9830a.f9829u, true);
            }
            if (!TextUtils.isEmpty(this.f9830a.f9827s)) {
                this.f9830a.f9828t.m11507a();
                if (this.f9830a.f9826r != null) {
                    ((ImageView) this.f9830a.f9826r).setImageResource(R.drawable.chat_attach_btn_play);
                }
                this.f9830a.f9826r = null;
                if (str.equals(this.f9830a.f9827s)) {
                    this.f9830a.f9827s = null;
                    return;
                }
            }
            if (C4822an.m18245m() && C4822an.m18246n()) {
                this.f9830a.f9826r = view;
                boolean zM11508a = this.f9830a.f9828t.m11508a(str);
                this.f9830a.f9827s = str;
                if (this.f9830a.f9826r != null && zM11508a) {
                    ((ImageView) this.f9830a.f9826r).setImageResource(R.drawable.chat_attach_btn_pause);
                    return;
                }
                return;
            }
            C5179v.m19810a(CommonApplication.m18732r(), R.string.chatroom_unable_to_record_during_call, 0).show();
        }
    }
}
