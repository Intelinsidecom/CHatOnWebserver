package com.sec.chaton.smsplugin.spam;

import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;

/* compiled from: ManageSpamMessages.java */
/* renamed from: com.sec.chaton.smsplugin.spam.f */
/* loaded from: classes.dex */
class ViewOnCreateContextMenuListenerC4028f implements View.OnCreateContextMenuListener {

    /* renamed from: a */
    final /* synthetic */ ManageSpamMessages f14529a;

    ViewOnCreateContextMenuListenerC4028f(ManageSpamMessages manageSpamMessages) {
        this.f14529a = manageSpamMessages;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
        if (contextMenuInfo != null && this.f14529a.f14290h == 0 && this.f14529a.f14286d != null) {
            contextMenu.setHeaderTitle(R.string.message_options);
            contextMenu.add(0, 0, 0, R.string.spam_restore_menu);
            contextMenu.add(0, 1, 0, R.string.sim_delete);
            this.f14529a.f14295m = adapterContextMenuInfo.position;
        }
    }
}
