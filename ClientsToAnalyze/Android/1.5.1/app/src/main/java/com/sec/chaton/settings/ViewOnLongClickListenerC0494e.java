package com.sec.chaton.settings;

import android.view.View;
import java.io.File;

/* renamed from: com.sec.chaton.settings.e */
/* loaded from: classes.dex */
class ViewOnLongClickListenerC0494e implements View.OnLongClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkinChange f3186a;

    ViewOnLongClickListenerC0494e(ActivitySkinChange activitySkinChange) {
        this.f3186a = activitySkinChange;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        new File(this.f3186a.f3018B + "/" + view.getTag().toString()).delete();
        return false;
    }
}
