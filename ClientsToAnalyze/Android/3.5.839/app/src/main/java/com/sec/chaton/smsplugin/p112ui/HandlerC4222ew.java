package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p102b.C3790i;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.provider.AsyncTaskC3949g;
import com.sec.chaton.smsplugin.provider.C3945c;
import java.util.ArrayList;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ew */
/* loaded from: classes.dex */
class HandlerC4222ew extends Handler {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15573a;

    HandlerC4222ew(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15573a = pluginComposeMessageActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        C3945c c3945c = (C3945c) message.obj;
        Object obj = c3945c.f14222g;
        switch (i) {
            case 1804:
                if ((c3945c.f14223h != null ? ((Integer) c3945c.f14223h).intValue() : 0) > 0) {
                    C1813b.m8906b().m8922a(String.valueOf(this.f15573a.f14935G.m14359d()), C1813b.f6840i);
                    break;
                }
                break;
            case 1805:
                ArrayList arrayList = (ArrayList) obj;
                PluginComposeMessageActivity.m15963a(new DialogInterfaceOnClickListenerC4254ga(arrayList, this.f15573a, this.f15573a.f15019bQ), arrayList, c3945c.f14223h != null ? ((Boolean) c3945c.f14223h).booleanValue() : false, this.f15573a);
                break;
            case 1806:
                this.f15573a.f14996ap.m14465o();
                C3782a.m14211a((Context) this.f15573a);
                C3790i.m14333b(this.f15573a);
                C3890m.m14997c("Mms/compose", "delete conversation token finish");
                this.f15573a.finish();
                break;
            case 9527:
                long jLongValue = ((Long) obj).longValue();
                Cursor cursor = (Cursor) c3945c.f14223h;
                PluginComposeMessageActivity.m16048c("##### onQueryComplete: msg history result for threadId " + jLongValue);
                if (jLongValue != this.f15573a.f14935G.m14359d()) {
                    PluginComposeMessageActivity.m16048c("onQueryComplete: msg history query result is for threadId " + jLongValue + ", but mConversation has threadId " + this.f15573a.f14935G.m14359d() + " starting a new query");
                    this.f15573a.m15913W();
                    break;
                } else {
                    this.f15573a.m15874C();
                    if (cursor != null) {
                        this.f15573a.m16117a(this.f15573a.f15050p.getCount(), cursor.getCount(), cursor);
                    }
                    this.f15573a.f15050p.changeCursor(cursor);
                    this.f15573a.f14935G.m14351a(this.f15573a.f15050p.getCount());
                    if (cursor != null && cursor.getCount() == 0 && !this.f15573a.m15878E() && this.f15573a.f14966aL == null) {
                        long jM14359d = this.f15573a.f14935G.m14359d();
                        if (!this.f15573a.f14935G.m14363h()) {
                            new AsyncTaskC3949g().execute(Long.valueOf(jM14359d));
                            C3890m.m14997c("Mms/compose", "msg list query token finish");
                            this.f15573a.finish();
                        }
                    }
                    this.f15573a.f14943O.requestFocus();
                    this.f15573a.f14935G.m14353a(false);
                    this.f15573a.invalidateOptionsMenu();
                    this.f15573a.f14953Y.setSelection(this.f15573a.f14953Y.getCount());
                    this.f15573a.f14953Y.setTranscriptMode(2);
                    break;
                }
                break;
            case 9700:
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    this.f15573a.f14955aA = 0L;
                    break;
                }
                break;
        }
    }
}
