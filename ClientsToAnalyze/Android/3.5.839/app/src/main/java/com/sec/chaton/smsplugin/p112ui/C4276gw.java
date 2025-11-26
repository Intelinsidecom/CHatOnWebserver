package com.sec.chaton.smsplugin.p112ui;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p102b.C3790i;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.util.Collection;

/* compiled from: PluginConversationList.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gw */
/* loaded from: classes.dex */
final class C4276gw extends AsyncQueryHandler {

    /* renamed from: a */
    final /* synthetic */ PluginConversationList f15655a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4276gw(PluginConversationList pluginConversationList, ContentResolver contentResolver) {
        super(contentResolver);
        this.f15655a = pluginConversationList;
    }

    @Override // android.content.AsyncQueryHandler
    protected void onQueryComplete(int i, Object obj, Cursor cursor) {
        boolean z = false;
        switch (i) {
            case 1701:
                this.f15655a.f15059c.changeCursor(cursor);
                this.f15655a.setTitle(this.f15655a.f15060d);
                this.f15655a.setProgressBarIndeterminateVisibility(false);
                if (this.f15655a.f15063g) {
                    this.f15655a.f15063g = false;
                    C3790i.m14335c(this.f15655a.getApplicationContext());
                    this.f15655a.f15062f.post(this.f15655a.f15072p);
                    break;
                }
                break;
            case 1702:
                int count = cursor.getCount();
                this.f15655a.f15064h.setText(count > 0 ? Integer.toString(count) : null);
                break;
            case 1802:
                Collection collection = (Collection) obj;
                DialogInterfaceOnClickListenerC4273gt dialogInterfaceOnClickListenerC4273gt = new DialogInterfaceOnClickListenerC4273gt(collection, this.f15655a.f15058b, this.f15655a);
                if (cursor != null && cursor.getCount() > 0) {
                    z = true;
                }
                PluginConversationList.m16140a(dialogInterfaceOnClickListenerC4273gt, collection, z, this.f15655a);
                break;
            default:
                C3890m.m14999e("PluginConversationList", "onQueryComplete called with unknown token " + i);
                break;
        }
    }

    @Override // android.content.AsyncQueryHandler
    protected void onDeleteComplete(int i, Object obj, int i2) {
        switch (i) {
            case 1801:
                C3782a.m14211a(this.f15655a);
                C3790i.m14333b(this.f15655a);
                this.f15655a.m16147c();
                break;
        }
    }
}
