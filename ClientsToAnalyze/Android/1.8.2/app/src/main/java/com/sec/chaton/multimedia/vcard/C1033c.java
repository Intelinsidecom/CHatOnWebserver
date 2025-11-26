package com.sec.chaton.multimedia.vcard;

import android.content.ContentUris;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;

/* compiled from: ContactPicker.java */
/* renamed from: com.sec.chaton.multimedia.vcard.c */
/* loaded from: classes.dex */
class C1033c implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1032b f3831a;

    C1033c(HandlerC1032b handlerC1032b) {
        this.f3831a = handlerC1032b;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Intent intent = new Intent();
        intent.setData(ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, ((C1035e) this.f3831a.f3830a.f3787b.get(i)).f3833a));
        this.f3831a.f3830a.setResult(-1, intent);
        this.f3831a.f3830a.finish();
    }
}
