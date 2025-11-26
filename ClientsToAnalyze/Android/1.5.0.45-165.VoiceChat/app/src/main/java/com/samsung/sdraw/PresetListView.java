package com.samsung.sdraw;

import android.content.Context;
import android.widget.ListView;

/* loaded from: classes.dex */
public class PresetListView extends ListView {
    public PresetListView(Context context) {
        super(context);
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public void setSelection(int position) {
        super.setSelection(position);
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int position, int y) {
    }
}
