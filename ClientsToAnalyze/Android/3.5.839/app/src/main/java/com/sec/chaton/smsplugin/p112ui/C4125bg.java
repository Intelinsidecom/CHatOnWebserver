package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

/* compiled from: MessageListItem.java */
/* renamed from: com.sec.chaton.smsplugin.ui.bg */
/* loaded from: classes.dex */
class C4125bg extends ArrayAdapter<String> {

    /* renamed from: a */
    final /* synthetic */ MessageListItem f15364a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4125bg(MessageListItem messageListItem, Context context, int i, List list) {
        super(context, i, list);
        this.f15364a = messageListItem;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) throws PackageManager.NameNotFoundException {
        View view2 = super.getView(i, view, viewGroup);
        try {
            String string = getItem(i).toString();
            TextView textView = (TextView) view2;
            Drawable activityIcon = this.f15364a.mContext.getPackageManager().getActivityIcon(new Intent("android.intent.action.VIEW", Uri.parse(string)));
            if (activityIcon != null) {
                activityIcon.setBounds(0, 0, activityIcon.getIntrinsicHeight(), activityIcon.getIntrinsicHeight());
                textView.setCompoundDrawablePadding(10);
                textView.setCompoundDrawables(activityIcon, null, null, null);
            }
            if (string.startsWith("tel:")) {
                string = PhoneNumberUtils.formatNumber(string.substring("tel:".length()), this.f15364a.f14843u);
            }
            textView.setText(string);
        } catch (PackageManager.NameNotFoundException e) {
        }
        return view2;
    }
}
