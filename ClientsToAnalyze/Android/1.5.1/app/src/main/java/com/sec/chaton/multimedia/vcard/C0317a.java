package com.sec.chaton.multimedia.vcard;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.account.AccountData;
import java.util.ArrayList;

/* renamed from: com.sec.chaton.multimedia.vcard.a */
/* loaded from: classes.dex */
class C0317a extends ArrayAdapter {

    /* renamed from: a */
    final /* synthetic */ AddVCardDialog f2370a;

    /* renamed from: b */
    private LayoutInflater f2371b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0317a(AddVCardDialog addVCardDialog, Context context, ArrayList arrayList) {
        super(context, R.layout.simple_spinner_item, arrayList);
        this.f2370a = addVCardDialog;
        AddVCardDialog.f2274a = context;
        this.f2371b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        View view2 = view == null ? (RelativeLayout) this.f2371b.inflate(C0062R.layout.item_account_entry, viewGroup, false) : view;
        TextView textView = (TextView) view2.findViewById(C0062R.id.firstAccountLine);
        TextView textView2 = (TextView) view2.findViewById(C0062R.id.secondAccountLine);
        ImageView imageView = (ImageView) view2.findViewById(C0062R.id.accountIcon);
        AccountData accountData = (AccountData) getItem(i);
        textView.setText(accountData.m3684a());
        textView2.setText(accountData.m3686c());
        Drawable drawableM3687d = accountData.m3687d();
        if (drawableM3687d == null) {
            drawableM3687d = AddVCardDialog.f2274a.getResources().getDrawable(R.drawable.ic_menu_search);
        }
        imageView.setImageDrawable(drawableM3687d);
        return view2;
    }
}
