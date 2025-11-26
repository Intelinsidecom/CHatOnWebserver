package com.sec.chaton.sharedialog;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import com.sec.common.util.C5033j;

/* compiled from: ShareDialog.java */
/* renamed from: com.sec.chaton.sharedialog.e */
/* loaded from: classes.dex */
class C3697e implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogC3696d f13317a;

    C3697e(DialogC3696d dialogC3696d) {
        this.f13317a = dialogC3696d;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C3695c c3695c = (C3695c) adapterView.getItemAtPosition(i);
        if (c3695c != null) {
            view.getContext().startActivity(c3695c.m13961c());
            if (!this.f13317a.f13311a.contains(c3695c.m13961c().getPackage())) {
                int i2 = this.f13317a.f13315e.getInt(c3695c.m13961c().getPackage(), -1) + 1;
                this.f13317a.f13316f.putInt(c3695c.m13961c().getPackage(), i2);
                this.f13317a.f13314d.notifyDataSetChanged();
                Log.e("Pref updation: ", "Pref: " + c3695c.m13960b() + "Count: " + i2);
                C5033j.m19087a(this.f13317a.f13316f);
            }
        }
        this.f13317a.dismiss();
    }
}
