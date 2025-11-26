package com.sec.chaton;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.g */
/* loaded from: classes.dex */
class C2341g implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f8324a;

    C2341g(AdminMenu adminMenu) {
        this.f8324a = adminMenu;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) throws Resources.NotFoundException {
        String[] stringArray = this.f8324a.f1884U.getResources().getStringArray(R.array.operation_area_array);
        this.f8324a.f1902am = stringArray[i];
        if (this.f8324a.f1902am.equals("EU")) {
            this.f8324a.f1902am = "IE";
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
