package com.sec.chaton.chat.translate;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.sec.chaton.util.C4904y;

/* compiled from: TranslatorFragment.java */
/* renamed from: com.sec.chaton.chat.translate.t */
/* loaded from: classes.dex */
class C1867t implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ TranslatorFragment f7085a;

    C1867t(TranslatorFragment translatorFragment) {
        this.f7085a = translatorFragment;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        String strM9034b = this.f7085a.f6970c.m9034b((String) ((ArrayAdapter) this.f7085a.f6972e.getAdapter()).getItem(i));
        String string = this.f7085a.f6974g.getText().toString();
        if (strM9034b.equals(this.f7085a.f6979l)) {
            if (!this.f7085a.f6984q.equals(string)) {
                this.f7085a.m8984a(this.f7085a.f6974g, this.f7085a.f6975h, this.f7085a.f6979l, this.f7085a.f6980m);
                return;
            } else {
                C4904y.m18639b("Same Lang : " + strM9034b + " Same Msg : " + string, TranslatorFragment.f6968a);
                return;
            }
        }
        this.f7085a.f6979l = strM9034b;
        if (this.f7085a.f6970c.m9039e().m9008a(this.f7085a.f6973f, this.f7085a.f6979l, this.f7085a.f6980m)) {
            this.f7085a.f6980m = this.f7085a.f6970c.m9034b((String) ((ArrayAdapter) this.f7085a.f6973f.getAdapter()).getItem(0));
        }
        this.f7085a.m8984a(this.f7085a.f6974g, this.f7085a.f6975h, this.f7085a.f6979l, this.f7085a.f6980m);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
