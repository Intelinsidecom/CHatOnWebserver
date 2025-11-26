package com.sec.chaton.smsplugin.p112ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import com.sec.chaton.R;

/* compiled from: MessageOptions.java */
/* renamed from: com.sec.chaton.smsplugin.ui.bq */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC4135bq implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ C4132bn f15407a;

    DialogInterfaceOnKeyListenerC4135bq(C4132bn c4132bn) {
        this.f15407a = c4132bn;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        CheckBox checkBox;
        ListView listView = ((AlertDialog) dialogInterface).getListView();
        if (listView == null || keyEvent.getAction() != 0 || ((keyEvent.getKeyCode() != 66 && keyEvent.getKeyCode() != 23) || !listView.isFocused())) {
            return false;
        }
        View selectedView = listView.getSelectedView();
        if (selectedView == null || (checkBox = (CheckBox) selectedView.findViewById(R.id.selected)) == null) {
            return true;
        }
        checkBox.setChecked(checkBox.isChecked() ? false : true);
        return true;
    }
}
