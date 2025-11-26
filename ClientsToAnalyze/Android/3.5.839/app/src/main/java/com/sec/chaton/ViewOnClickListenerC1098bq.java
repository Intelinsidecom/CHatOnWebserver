package com.sec.chaton;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.settings.moreapps.EventActivity;
import com.sec.chaton.util.C4904y;

/* compiled from: PlusFragment.java */
/* renamed from: com.sec.chaton.bq */
/* loaded from: classes.dex */
class ViewOnClickListenerC1098bq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PlusFragment f3497a;

    ViewOnClickListenerC1098bq(PlusFragment plusFragment) {
        this.f3497a = plusFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1498cb c1498cb = (C1498cb) view.getTag();
        if (this.f3497a.f1964H.size() - 1 >= c1498cb.f5426c) {
            C1502cf c1502cf = (C1502cf) this.f3497a.f1964H.get(c1498cb.f5426c);
            String strM7818d = c1502cf.m7818d();
            String strM7815a = c1502cf.m7815a();
            if (C4904y.f17872b) {
                C4904y.m18639b("eventId : " + strM7815a + " webUrl : " + strM7818d, PlusFragment.f1956a);
            }
            Intent intent = new Intent(this.f3497a.f1990q, (Class<?>) EventActivity.class);
            if (!TextUtils.isEmpty(strM7818d)) {
                intent.putExtra("event_url", strM7818d);
            }
            if (!TextUtils.isEmpty(strM7815a)) {
                intent.putExtra("event_id", strM7815a);
            }
            this.f3497a.startActivity(intent);
            return;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("banner size is incorrect.", PlusFragment.f1956a);
        }
    }
}
