package com.sec.chaton.settings;

import android.content.ContentValues;
import android.view.View;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.p017e.C0688c;

/* compiled from: RelationHideAdapter.java */
/* renamed from: com.sec.chaton.settings.cy */
/* loaded from: classes.dex */
class ViewOnClickListenerC1300cy implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1301cz f4862a;

    /* renamed from: b */
    final /* synthetic */ int f4863b;

    /* renamed from: c */
    final /* synthetic */ C1298cw f4864c;

    ViewOnClickListenerC1300cy(C1298cw c1298cw, C1301cz c1301cz, int i) {
        this.f4864c = c1298cw;
        this.f4862a = c1301cz;
        this.f4863b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4862a.f4868d.setEnabled(false);
        this.f4864c.f4857e = ((C0257c) this.f4864c.f4853a.get(this.f4863b)).m2318a();
        this.f4864c.f4856d = ((C0257c) this.f4864c.f4853a.get(this.f4863b)).m2324b();
        C0257c c0257c = (C0257c) this.f4864c.f4853a.get(this.f4863b);
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_relation_hide", "N");
        this.f4864c.f4859g.startUpdate(0, null, C0688c.f2606a, contentValues, "buddy_no = ? ", new String[]{c0257c.m2318a()});
        RelationHideFragment.f4705b = true;
    }
}
