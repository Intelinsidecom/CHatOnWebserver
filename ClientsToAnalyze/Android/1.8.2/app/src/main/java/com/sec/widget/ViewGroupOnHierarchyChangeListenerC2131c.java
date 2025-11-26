package com.sec.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: AlertDialogBuilder2.java */
/* renamed from: com.sec.widget.c */
/* loaded from: classes.dex */
class ViewGroupOnHierarchyChangeListenerC2131c implements ViewGroup.OnHierarchyChangeListener {

    /* renamed from: a */
    final /* synthetic */ ListView f7776a;

    /* renamed from: b */
    final /* synthetic */ AlertDialogBuilderC2120a f7777b;

    ViewGroupOnHierarchyChangeListenerC2131c(AlertDialogBuilderC2120a alertDialogBuilderC2120a, ListView listView) {
        this.f7777b = alertDialogBuilderC2120a;
        this.f7776a = listView;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        if (view2 instanceof CheckedTextView) {
            ((CheckedTextView) view2).setCheckMarkDrawable(this.f7776a.getChoiceMode() == 2 ? R.drawable.checkbox_background_xml : R.drawable.ams_btn_radio);
            ((CheckedTextView) view2).setTextColor(GlobalApplication.m3260b().getResources().getColor(R.color.ics_main_font_color_2));
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
    }
}
