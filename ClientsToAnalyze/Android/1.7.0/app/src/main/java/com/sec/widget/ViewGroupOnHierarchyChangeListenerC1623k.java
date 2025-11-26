package com.sec.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ListView;
import com.sec.chaton.R;

/* compiled from: AlertDialogBuilder2.java */
/* renamed from: com.sec.widget.k */
/* loaded from: classes.dex */
class ViewGroupOnHierarchyChangeListenerC1623k implements ViewGroup.OnHierarchyChangeListener {

    /* renamed from: a */
    final /* synthetic */ ListView f5739a;

    /* renamed from: b */
    final /* synthetic */ AlertDialogBuilderC1625m f5740b;

    ViewGroupOnHierarchyChangeListenerC1623k(AlertDialogBuilderC1625m alertDialogBuilderC1625m, ListView listView) {
        this.f5740b = alertDialogBuilderC1625m;
        this.f5739a = listView;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        if (view2 instanceof CheckedTextView) {
            ((CheckedTextView) view2).setCheckMarkDrawable(this.f5739a.getChoiceMode() == 2 ? R.drawable.checkbox_background_xml : R.drawable.ams_btn_radio);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
    }
}
