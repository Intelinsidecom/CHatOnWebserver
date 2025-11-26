package com.sec.chaton.hide;

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
import com.sec.chaton.block.C1093u;
import com.sec.chaton.p055d.C2133n;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.widget.C4923p;
import java.util.ArrayList;

/* compiled from: HideBuddyAdapter.java */
/* renamed from: com.sec.chaton.hide.a */
/* loaded from: classes.dex */
class C2366a extends ArrayAdapter<C1093u> {

    /* renamed from: a */
    public ArrayList<C1093u> f8432a;

    /* renamed from: b */
    public Handler f8433b;

    /* renamed from: c */
    private Context f8434c;

    /* renamed from: d */
    private C2133n f8435d;

    /* renamed from: e */
    private String f8436e;

    /* renamed from: f */
    private LayoutInflater f8437f;

    /* renamed from: g */
    private ProgressDialog f8438g;

    /* renamed from: h */
    private InterfaceC2370e f8439h;

    /* renamed from: i */
    private View.OnClickListener f8440i;

    /* renamed from: j */
    private View.OnClickListener f8441j;

    /* renamed from: a */
    public void m10354a(InterfaceC2370e interfaceC2370e) {
        this.f8439h = interfaceC2370e;
    }

    public C2366a(Context context, int i, ArrayList<C1093u> arrayList) {
        super(context, 0, arrayList);
        this.f8440i = new ViewOnClickListenerC2367b(this);
        this.f8441j = new ViewOnClickListenerC2368c(this);
        this.f8433b = new HandlerC2369d(this);
        this.f8434c = context;
        this.f8432a = arrayList;
        this.f8437f = (LayoutInflater) this.f8434c.getSystemService("layout_inflater");
        this.f8438g = (ProgressDialog) new C4923p(this.f8434c).m18724a(R.string.dialog_userprofile_updating);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2371f c2371f;
        if (view == null) {
            view = this.f8437f.inflate(R.layout.list_item_common_5, (ViewGroup) null);
            c2371f = new C2371f();
            c2371f.f8445a = (TextView) view.findViewById(R.id.text1);
            c2371f.f8446b = (ImageView) view.findViewById(R.id.image1);
            c2371f.f8447c = (Button) view.findViewById(R.id.button1);
            view.setTag(c2371f);
        } else {
            c2371f = (C2371f) view.getTag();
        }
        c2371f.f8446b.setBackgroundResource(R.drawable.circle_background);
        c2371f.f8445a.setSingleLine(true);
        c2371f.f8445a.setEllipsize(TextUtils.TruncateAt.END);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f8434c).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        c2371f.f8447c.setMaxWidth((int) (displayMetrics.density * 100.0f));
        c2371f.f8447c.setSingleLine(false);
        c2371f.f8447c.setMaxLines(2);
        c2371f.f8447c.setEllipsize(TextUtils.TruncateAt.END);
        c2371f.f8447c.setText(R.string.hide_list_button_show);
        c2371f.f8447c.setTag(Integer.valueOf(i));
        c2371f.f8447c.setOnClickListener(this.f8441j);
        C1093u item = getItem(i);
        c2371f.f8445a.setText(item.f3485b);
        C2496n.m10765a(c2371f.f8446b, item.f3484a, EnumC2498p.ROUND);
        return view;
    }
}
