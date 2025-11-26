package com.sec.chaton.multimedia.audio;

import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C4822an;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.io.IOException;

/* compiled from: VoiceRecordDialog.java */
/* renamed from: com.sec.chaton.multimedia.audio.z */
/* loaded from: classes.dex */
class ViewOnClickListenerC2750z implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogC2747w f9879a;

    ViewOnClickListenerC2750z(DialogC2747w dialogC2747w) {
        this.f9879a = dialogC2747w;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (!TextUtils.isEmpty(this.f9879a.f9871t)) {
            if (this.f9879a.f9856e == null) {
                this.f9879a.f9856e = new C2743s(this.f9879a.f9875x);
            }
            if (this.f9879a.f9856e.m11511d()) {
                this.f9879a.f9856e.m11507a();
            } else if (C4822an.m18245m() && C4822an.m18246n()) {
                this.f9879a.f9856e.m11508a(this.f9879a.f9871t);
            } else {
                C5179v.m19810a(CommonApplication.m18732r(), R.string.chatroom_unable_to_record_during_call, 0).show();
            }
        }
    }
}
