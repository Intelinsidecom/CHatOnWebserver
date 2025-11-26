package com.sec.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;

/* compiled from: AlertDialogBuilder2.java */
/* renamed from: com.sec.widget.m */
/* loaded from: classes.dex */
public class AlertDialogBuilderC1625m extends AlertDialog.Builder {

    /* renamed from: a */
    private boolean f5744a;

    public AlertDialogBuilderC1625m(Context context) {
        super(context);
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog create() {
        AlertDialog alertDialogCreate = super.create();
        alertDialogCreate.setOnShowListener(new DialogInterfaceOnShowListenerC1622j(this, alertDialogCreate));
        ListView listView = alertDialogCreate.getListView();
        if (listView != null && listView.getChoiceMode() != 0 && !this.f5744a) {
            listView.setOnHierarchyChangeListener(new ViewGroupOnHierarchyChangeListenerC1623k(this, listView));
        }
        return alertDialogCreate;
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog.Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        this.f5744a = true;
        return super.setAdapter(listAdapter, onClickListener);
    }

    /* renamed from: a */
    public static void m5911a(AlertDialog alertDialog) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT < 11) {
            alertDialog.getButton(-1).setBackgroundResource(R.drawable.btn_alert_dialog_xml);
            alertDialog.getButton(-2).setBackgroundResource(R.drawable.btn_alert_dialog_xml);
            alertDialog.getButton(-3).setBackgroundResource(R.drawable.btn_alert_dialog_xml);
            ColorStateList colorStateList = alertDialog.getContext().getResources().getColorStateList(R.color.main_custome_default_button_text);
            alertDialog.getButton(-1).setTextColor(colorStateList);
            alertDialog.getButton(-2).setTextColor(colorStateList);
            alertDialog.getButton(-3).setTextColor(colorStateList);
        }
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog.Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
        return Build.VERSION.SDK_INT < 11 ? super.setPositiveButton(i, onClickListener) : super.setNegativeButton(i, onClickListener);
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog.Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return Build.VERSION.SDK_INT < 11 ? super.setPositiveButton(charSequence, onClickListener) : super.setNegativeButton(charSequence, onClickListener);
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog.Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
        return Build.VERSION.SDK_INT < 11 ? super.setNegativeButton(i, onClickListener) : super.setPositiveButton(i, onClickListener);
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog.Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return Build.VERSION.SDK_INT < 11 ? super.setNegativeButton(charSequence, onClickListener) : super.setPositiveButton(charSequence, onClickListener);
    }
}
