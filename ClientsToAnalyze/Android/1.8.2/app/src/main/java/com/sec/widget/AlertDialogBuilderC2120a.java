package com.sec.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.ContextThemeWrapper;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;

/* compiled from: AlertDialogBuilder2.java */
/* renamed from: com.sec.widget.a */
/* loaded from: classes.dex */
public class AlertDialogBuilderC2120a extends AlertDialog.Builder {

    /* renamed from: a */
    private boolean f7761a;

    public AlertDialogBuilderC2120a(Context context) {
        super(new ContextThemeWrapper(context, R.style.CustomAlertDialogtheme));
    }

    public AlertDialogBuilderC2120a(Context context, String str) {
        super(new ContextThemeWrapper(context, R.style.CustomAlertDialogthemeWithList));
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog create() {
        AlertDialog alertDialogCreate = super.create();
        alertDialogCreate.setOnShowListener(new DialogInterfaceOnShowListenerC2130b(this, alertDialogCreate));
        ListView listView = alertDialogCreate.getListView();
        if (listView != null && listView.getChoiceMode() != 0 && !this.f7761a) {
            listView.setOnHierarchyChangeListener(new ViewGroupOnHierarchyChangeListenerC2131c(this, listView));
        }
        return alertDialogCreate;
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog.Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        this.f7761a = true;
        return super.setAdapter(listAdapter, onClickListener);
    }

    /* renamed from: a */
    public static CharSequence m7478a(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(new ForegroundColorSpan(-1), 0, spannableString.length(), 33);
            return spannableString;
        }
        return charSequence;
    }

    /* renamed from: a */
    public static void m7479a(AlertDialog alertDialog) {
        alertDialog.getButton(-1).setBackgroundResource(R.drawable.popup_btn_default);
        alertDialog.getButton(-2).setBackgroundResource(R.drawable.popup_btn_default);
        alertDialog.getButton(-3).setBackgroundResource(R.drawable.popup_btn_default);
        ColorStateList colorStateList = alertDialog.getContext().getResources().getColorStateList(R.color.alert_dialog_2_default_button_text);
        alertDialog.getButton(-1).setTextColor(colorStateList);
        alertDialog.getButton(-2).setTextColor(colorStateList);
        alertDialog.getButton(-3).setTextColor(colorStateList);
    }
}
