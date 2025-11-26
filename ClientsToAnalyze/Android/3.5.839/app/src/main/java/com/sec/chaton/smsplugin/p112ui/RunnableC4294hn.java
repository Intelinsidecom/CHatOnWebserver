package com.sec.chaton.smsplugin.p112ui;

import android.content.Intent;
import android.net.Uri;

/* compiled from: SearchActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.hn */
/* loaded from: classes.dex */
class RunnableC4294hn implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Uri f15678a;

    /* renamed from: b */
    final /* synthetic */ String f15679b;

    /* renamed from: c */
    final /* synthetic */ SearchActivity f15680c;

    RunnableC4294hn(SearchActivity searchActivity, Uri uri, String str) {
        this.f15680c = searchActivity;
        this.f15678a = uri;
        this.f15679b = str;
    }

    @Override // java.lang.Runnable
    public void run() throws NumberFormatException {
        try {
            long j = Long.parseLong(this.f15678a.getQueryParameter("source_id"));
            long jM16180a = this.f15680c.m16180a(j, Long.parseLong(this.f15678a.getQueryParameter("which_table")));
            Intent intent = new Intent(this.f15680c, (Class<?>) PluginComposeMessageActivity.class);
            intent.putExtra("highlight", this.f15679b);
            intent.putExtra("select_id", j);
            intent.putExtra("thread_id", jM16180a);
            this.f15680c.startActivity(intent);
            this.f15680c.finish();
        } catch (NumberFormatException e) {
        }
    }
}
