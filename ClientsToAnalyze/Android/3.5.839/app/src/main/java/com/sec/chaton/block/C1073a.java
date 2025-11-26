package com.sec.chaton.block;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2126g;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.widget.C4923p;
import java.util.ArrayList;

/* compiled from: BlockBuddyAdapter.java */
/* renamed from: com.sec.chaton.block.a */
/* loaded from: classes.dex */
class C1073a extends ArrayAdapter<C1093u> {

    /* renamed from: a */
    public ArrayList<C1093u> f3442a;

    /* renamed from: b */
    public Handler f3443b;

    /* renamed from: c */
    private Context f3444c;

    /* renamed from: d */
    private C2126g f3445d;

    /* renamed from: e */
    private String f3446e;

    /* renamed from: f */
    private String f3447f;

    /* renamed from: g */
    private LayoutInflater f3448g;

    /* renamed from: h */
    private ProgressDialog f3449h;

    /* renamed from: i */
    private ViewGroup f3450i;

    /* renamed from: j */
    private InterfaceC1076d f3451j;

    /* renamed from: k */
    private View.OnClickListener f3452k;

    /* renamed from: a */
    public void m6221a(InterfaceC1076d interfaceC1076d) {
        this.f3451j = interfaceC1076d;
    }

    public C1073a(Context context, int i, ArrayList<C1093u> arrayList) {
        super(context, 0, arrayList);
        this.f3452k = new ViewOnClickListenerC1074b(this);
        this.f3443b = new HandlerC1075c(this);
        this.f3444c = context;
        this.f3442a = arrayList;
        this.f3448g = (LayoutInflater) this.f3444c.getSystemService("layout_inflater");
        this.f3450i = (ViewGroup) this.f3448g.inflate(i, (ViewGroup) null);
        this.f3449h = (ProgressDialog) new C4923p(this.f3444c).m18724a(R.string.dialog_userprofile_updating);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1077e c1077e;
        if (view == null) {
            view = this.f3448g.inflate(R.layout.list_item_common_5, (ViewGroup) null);
            c1077e = new C1077e();
            c1077e.f3455a = (TextView) view.findViewById(R.id.text1);
            c1077e.f3456b = (ImageView) view.findViewById(R.id.image1);
            c1077e.f3457c = (Button) view.findViewById(R.id.button1);
            view.setTag(c1077e);
        } else {
            c1077e = (C1077e) view.getTag();
        }
        c1077e.f3456b.setBackgroundResource(R.drawable.circle_background);
        c1077e.f3455a.setSingleLine(true);
        c1077e.f3455a.setEllipsize(TextUtils.TruncateAt.END);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f3444c).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        c1077e.f3457c.setMaxWidth((int) (displayMetrics.density * 2.1313618E9f));
        c1077e.f3457c.setSingleLine(false);
        c1077e.f3457c.setMaxLines(2);
        c1077e.f3457c.setEllipsize(TextUtils.TruncateAt.END);
        c1077e.f3457c.setText(R.string.setting_block_unblock);
        c1077e.f3457c.setTag(Integer.valueOf(i));
        c1077e.f3457c.setOnClickListener(this.f3452k);
        C1093u item = getItem(i);
        c1077e.f3455a.setText(item.f3485b);
        C2496n.m10765a(c1077e.f3456b, item.f3484a, EnumC2498p.ROUND);
        return view;
    }
}
