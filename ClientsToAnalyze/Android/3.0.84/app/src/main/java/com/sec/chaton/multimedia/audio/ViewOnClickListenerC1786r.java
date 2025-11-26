package com.sec.chaton.multimedia.audio;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3171am;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.io.IOException;

/* compiled from: VoiceListAdapter.java */
/* renamed from: com.sec.chaton.multimedia.audio.r */
/* loaded from: classes.dex */
class ViewOnClickListenerC1786r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1785q f6622a;

    ViewOnClickListenerC1786r(C1785q c1785q) {
        this.f6622a = c1785q;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        String str = (String) view.getTag();
        if (!TextUtils.isEmpty(str)) {
            if (this.f6622a.f6620h == null) {
                this.f6622a.f6620h = new C1791w(this.f6622a.f6621i);
            }
            if (str.equals(this.f6622a.f6619g)) {
                this.f6622a.f6620h.m7380a();
                return;
            }
            if (C3171am.m11072j() && C3171am.m11073k()) {
                if (this.f6622a.f6618f != null) {
                    ((ImageView) this.f6622a.f6618f).setImageResource(R.drawable.chat_attach_btn_play);
                }
                this.f6622a.f6620h.m7381a(str);
                this.f6622a.f6618f = view;
                this.f6622a.f6619g = str;
                return;
            }
            C3641ai.m13210a(CommonApplication.m11493l(), R.string.chatroom_unable_to_record_during_call, 0).show();
        }
    }
}
