package com.sec.chaton.trunk;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C4847bl;

/* compiled from: TrunkPageActivity.java */
/* renamed from: com.sec.chaton.trunk.bw */
/* loaded from: classes.dex */
class ViewOnClickListenerC4631bw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkPageActivity f16808a;

    ViewOnClickListenerC4631bw(TrunkPageActivity trunkPageActivity) {
        this.f16808a = trunkPageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a() && this.f16808a.f16603p.size() > this.f16808a.f16581D) {
            C4645cc c4645cc = this.f16808a.f16603p.get(this.f16808a.f16581D);
            Intent intent = new Intent(this.f16808a.f16586I, (Class<?>) TrunkDetailActivity.class);
            intent.putExtra("sessionId", this.f16808a.f16609w);
            intent.putExtra("inboxNo", this.f16808a.f16608v);
            intent.putExtra("itemId", c4645cc.f16833f);
            intent.putExtra("downloadUrl", c4645cc.f16835h);
            intent.putExtra("contentType", c4645cc.f16836i);
            intent.putExtra("totalcomment", c4645cc.f16837j);
            intent.putExtra("isvalid", this.f16808a.f16604q);
            this.f16808a.startActivityForResult(intent, 1);
        }
    }
}
