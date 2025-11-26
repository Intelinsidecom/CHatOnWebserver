package com.sec.chaton.settings.tellfriends;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

/* compiled from: InviteFacebookActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.r */
/* loaded from: classes.dex */
class ViewOnClickListenerC1469r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1468q f5380a;

    ViewOnClickListenerC1469r(C1468q c1468q) {
        this.f5380a = c1468q;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        Intent intent = new Intent(this.f5380a.f5378c.f4950f, (Class<?>) FacebookMessageActivity.class);
        Bitmap bitmap = null;
        try {
            bitmap = ((BitmapDrawable) ((C1373ba) this.f5380a.f5377b.get(iIntValue)).f5205d).getBitmap();
        } catch (Exception e) {
            e.printStackTrace();
        }
        intent.putExtra(FacebookMessageActivity.f4919b, ((C1373ba) this.f5380a.f5377b.get(iIntValue)).f5202a);
        intent.putExtra(FacebookMessageActivity.f4920c, ((C1373ba) this.f5380a.f5377b.get(iIntValue)).f5203b);
        intent.putExtra(FacebookMessageActivity.f4921d, bitmap);
        this.f5380a.f5378c.startActivity(intent);
    }
}
