package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v4.widget.C0266z;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: MessagingInfoAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.ui.cs */
/* loaded from: classes.dex */
public class C4164cs extends C0266z {

    /* renamed from: m */
    public static final String[] f15468m = {"buddy_no", "buddy_status_message", "buddy_contact_buddy", "participants_sms_address", "buddy_name"};

    /* renamed from: n */
    private final LayoutInflater f15469n;

    /* renamed from: o */
    private final Context f15470o;

    public C4164cs(Context context, Cursor cursor) {
        super(context, R.layout.list_item_common_7_non_checkable, cursor, f15468m, null, -1);
        this.f15470o = context;
        this.f15469n = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.support.v4.widget.C0266z, android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public void mo876a(View view, Context context, Cursor cursor) {
        C4168cw c4168cw = (C4168cw) view.getTag();
        String string = cursor.getString(cursor.getColumnIndex("buddy_no"));
        String string2 = cursor.getString(cursor.getColumnIndex("buddy_status_message"));
        int i = cursor.getInt(cursor.getColumnIndex("buddy_contact_buddy"));
        String string3 = cursor.getString(cursor.getColumnIndex("participants_sms_address"));
        String string4 = cursor.getString(cursor.getColumnIndex("buddy_name"));
        if (i == 2) {
            if (TextUtils.isEmpty(string3)) {
                string4 = this.f15470o.getString(R.string.unknown);
            } else {
                string4 = PhoneNumberUtils.formatNumber(string3);
            }
        }
        c4168cw.f15477b.setText(string4);
        c4168cw.f15478c.setText(string2);
        if (i == 0) {
            c4168cw.f15476a.setBackgroundResource(R.drawable.circle_background);
            C2496n.m10765a(c4168cw.f15476a, string, EnumC2498p.ROUND);
        } else if (i == 1) {
            c4168cw.f15476a.setBackgroundResource(R.drawable.frame_background);
            C2496n.m10784c(c4168cw.f15476a, string, EnumC2498p.SQUARE);
        } else {
            C2496n.m10762a(c4168cw.f15476a);
            c4168cw.f15476a.setBackgroundResource(R.drawable.frame_background);
            c4168cw.f15476a.setImageDrawable(C2496n.m10754a(EnumC2498p.SQUARE));
        }
        if (i == 2 && m16451a(string3) && !TextUtils.isEmpty(string3)) {
            ImageView imageView = new ImageView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(R.drawable.list_ic_add);
            imageView.setBackgroundResource(R.drawable.actionbar_item_background);
            imageView.setOnTouchListener(new ViewOnTouchListenerC4165ct(this));
            imageView.setOnClickListener(new ViewOnClickListenerC4166cu(this, string3, string4));
            c4168cw.f15479d.addView(imageView);
            imageView.setVisibility(0);
            c4168cw.f15479d.setVisibility(0);
        } else {
            c4168cw.f15479d.setVisibility(8);
        }
        c4168cw.f15480e = string;
        c4168cw.f15481f = string4;
        c4168cw.f15482g = i;
        c4168cw.f15483h = string3;
    }

    @Override // android.support.v4.widget.AbstractC0259s, android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public View mo873a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f15469n.inflate(R.layout.list_item_common_7_non_checkable, viewGroup, false);
        C4168cw c4168cw = new C4168cw();
        c4168cw.f15476a = (ImageView) viewInflate.findViewById(R.id.image1);
        c4168cw.f15477b = (TextView) viewInflate.findViewById(R.id.text1);
        c4168cw.f15478c = (TextView) viewInflate.findViewById(R.id.text2);
        c4168cw.f15479d = (FrameLayout) viewInflate.findViewById(R.id.space2);
        viewInflate.setTag(c4168cw);
        return viewInflate;
    }

    /* renamed from: a */
    private boolean m16451a(String str) {
        if (str == null) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!PhoneNumberUtils.isDialable(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m16452b(String str) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f15470o);
        abstractC4932aM18733a.mo18734a(R.string.alert_inform).mo18749b(this.f15470o.getString(R.string.messaging_info_sync_contact, str)).mo18756d(R.string.alert_dialog_ok, new DialogInterfaceOnClickListenerC4167cv(this)).mo18747b(R.string.alert_dialog_cancel, (DialogInterface.OnClickListener) null);
        abstractC4932aM18733a.mo18745a().show();
    }
}
