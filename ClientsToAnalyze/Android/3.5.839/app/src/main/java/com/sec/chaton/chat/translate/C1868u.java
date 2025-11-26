package com.sec.chaton.chat.translate;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

/* compiled from: TranslatorFragment.java */
/* renamed from: com.sec.chaton.chat.translate.u */
/* loaded from: classes.dex */
class C1868u implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ TranslatorFragment f7086a;

    C1868u(TranslatorFragment translatorFragment) {
        this.f7086a = translatorFragment;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        String strM9034b = this.f7086a.f6970c.m9034b((String) ((ArrayAdapter) this.f7086a.f6973f.getAdapter()).getItem(i));
        String string = this.f7086a.f6974g.getText().toString();
        if (strM9034b.equals(this.f7086a.f6980m)) {
            if (!this.f7086a.f6984q.equals(string)) {
                this.f7086a.m8984a(this.f7086a.f6974g, this.f7086a.f6975h, this.f7086a.f6979l, this.f7086a.f6980m);
            }
        } else {
            this.f7086a.f6980m = strM9034b;
            this.f7086a.m8984a(this.f7086a.f6974g, this.f7086a.f6975h, this.f7086a.f6979l, this.f7086a.f6980m);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
