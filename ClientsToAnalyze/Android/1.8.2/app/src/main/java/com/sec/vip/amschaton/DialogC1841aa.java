package com.sec.vip.amschaton;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: AMSSendDialog.java */
/* renamed from: com.sec.vip.amschaton.aa */
/* loaded from: classes.dex */
public class DialogC1841aa extends Dialog {

    /* renamed from: a */
    private LinearLayout f6766a;

    /* renamed from: b */
    private Button f6767b;

    /* renamed from: c */
    private CheckBox f6768c;

    /* renamed from: d */
    private TextView f6769d;

    /* renamed from: e */
    private boolean f6770e;

    /* renamed from: f */
    private InterfaceC1848ah f6771f;

    public DialogC1841aa(Context context) {
        super(context, R.style.AMSIcsDialogTheme);
        this.f6766a = null;
        this.f6767b = null;
        this.f6768c = null;
        this.f6769d = null;
        this.f6770e = false;
        this.f6771f = null;
        requestWindowFeature(1);
        setContentView(R.layout.ams_ics_layout_send_popup);
        this.f6766a = (LinearLayout) findViewById(R.id.layout_send_method_list);
        this.f6767b = (Button) findViewById(R.id.btn_cancel);
        this.f6768c = (CheckBox) findViewById(R.id.checkbox_with_text);
        this.f6769d = (TextView) findViewById(R.id.text_with_text);
        m6386a();
        this.f6768c.setChecked(this.f6770e);
        this.f6767b.setOnClickListener(new ViewOnClickListenerC1842ab(this));
        this.f6768c.setOnClickListener(new ViewOnClickListenerC1843ac(this));
        this.f6768c.setOnCheckedChangeListener(new C1844ad(this));
        this.f6769d.setOnClickListener(new ViewOnClickListenerC1845ae(this));
        this.f6769d.setOnTouchListener(new ViewOnTouchListenerC1846af(this));
    }

    /* renamed from: a */
    public void m6392a(InterfaceC1848ah interfaceC1848ah) {
        this.f6771f = interfaceC1848ah;
    }

    /* renamed from: a */
    public boolean m6393a(int i, int i2, boolean z) {
        if (this.f6766a == null) {
            return false;
        }
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.ams_ics_layout_send_popup_item, (ViewGroup) this.f6766a, false);
        ((TextView) viewInflate.findViewById(R.id.text_send_method_item)).setText(i2);
        viewInflate.setId(i);
        viewInflate.setBackgroundResource(R.drawable.context_menu_selector);
        viewInflate.setOnClickListener(new ViewOnClickListenerC1847ag(this));
        this.f6766a.addView(viewInflate);
        if (z) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(layoutParams);
            imageView.setBackgroundResource(R.drawable.list_divider_h);
            this.f6766a.addView(imageView);
        }
        return true;
    }

    /* renamed from: a */
    private void m6386a() {
        this.f6770e = getContext().getSharedPreferences("AMSPref", 1).getBoolean("AMS_SEND_DIALOG_WITH_MESSAGE", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6388b() {
        getContext().getSharedPreferences("AMSPref", 3).edit().putBoolean("AMS_SEND_DIALOG_WITH_MESSAGE", this.f6770e).commit();
    }
}
