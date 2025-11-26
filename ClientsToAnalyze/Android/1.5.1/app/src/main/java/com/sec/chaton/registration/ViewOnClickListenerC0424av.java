package com.sec.chaton.registration;

import android.view.View;
import android.widget.Toast;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.registration.av */
/* loaded from: classes.dex */
class ViewOnClickListenerC0424av implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.RegisteFragment f2935a;

    ViewOnClickListenerC0424av(ActivityRegist.RegisteFragment registeFragment) {
        this.f2935a = registeFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = view.getTag() == null ? 0 : Integer.parseInt((String) view.getTag());
        ChatONLogWriter.m3506b("Click Title " + i, getClass().getSimpleName());
        if (i != 9) {
            view.setTag(Integer.toString(i + 1));
            return;
        }
        view.setTag(null);
        if (ChatONLogWriter.m3503a(this.f2935a.f2867l.getText().toString())) {
            this.f2935a.f2867l.setText("");
            this.f2935a.f2872q.setVisibility(0);
            this.f2935a.f2873r.setVisibility(0);
            ChatONLogWriter.m3496a(1);
            Toast.makeText(this.f2935a.f2875t, "Log On", 1).show();
            return;
        }
        if (this.f2935a.f2873r.getVisibility() == 0) {
            this.f2935a.f2872q.setVisibility(8);
            this.f2935a.f2873r.setVisibility(8);
            ChatONLogWriter.m3496a(0);
        }
    }
}
