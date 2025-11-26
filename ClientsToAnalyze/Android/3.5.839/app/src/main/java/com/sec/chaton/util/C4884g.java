package com.sec.chaton.util;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;

/* compiled from: BuddyCommonUtil.java */
/* renamed from: com.sec.chaton.util.g */
/* loaded from: classes.dex */
public final class C4884g {

    /* renamed from: a */
    private static final String f17813a = C4884g.class.getSimpleName();

    /* renamed from: a */
    public static InterfaceC4936e m18541a(Context context, DialogInterface.OnClickListener onClickListener) {
        return AbstractC4932a.m18733a(context).mo18740a(context.getResources().getString(R.string.pop_up_attention)).mo18749b(context.getResources().getString(R.string.sms_function_alert_notice)).mo18755c(context.getResources().getString(R.string.popup_button_enable), onClickListener).mo18750b(context.getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC4885h()).mo18745a();
    }

    /* renamed from: b */
    public static InterfaceC4936e m18545b(Context context, DialogInterface.OnClickListener onClickListener) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(context);
        abstractC4932aM18733a.mo18740a(context.getResources().getString(R.string.send_invite_message));
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_freesms_invitation_send_popup, (ViewGroup) null);
        m18543a((TextView) viewInflate.findViewById(R.id.popupContent02), GlobalApplication.m10283b().getString(R.string.invite_message_lite, "\nwww.chaton.com/invite.html"), "www.chaton.com/invite.html", -16776961);
        abstractC4932aM18733a.mo18748b(viewInflate);
        abstractC4932aM18733a.mo18755c(context.getResources().getString(R.string.dialog_ok), onClickListener);
        abstractC4932aM18733a.mo18741a(context.getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC4886i()).mo18745a();
        return abstractC4932aM18733a.mo18745a();
    }

    /* renamed from: a */
    private static void m18543a(TextView textView, String str, String str2, int i) {
        textView.setText(str, TextView.BufferType.SPANNABLE);
        Spannable spannable = (Spannable) textView.getText();
        int iIndexOf = str.indexOf(str2);
        spannable.setSpan(new ForegroundColorSpan(i), iIndexOf, str2.length() + iIndexOf, 33);
    }

    /* renamed from: a */
    public static void m18544a(String str) {
        String str2;
        String strM18121a = C4809aa.m18104a().m18121a("birthday", "");
        String strM18121a2 = C4809aa.m18104a().m18121a("birthday_type", "");
        if ("0000-12-31".equals(str)) {
            C4809aa.m18105a("birthday_show", (Boolean) false);
            if ("FULL".equals(strM18121a2) || "FULL_HIDE".equals(strM18121a2)) {
                C4809aa.m18104a().m18128b("birthday_type", "FULL_HIDE");
                return;
            } else {
                C4809aa.m18104a().m18128b("birthday_type", "SHORT_HIDE");
                return;
            }
        }
        C4809aa.m18105a("birthday_show", (Boolean) true);
        if (str.length() == 10) {
            C4809aa.m18104a().m18128b("birthday", str);
            C4809aa.m18104a().m18128b("birthday_type", "FULL");
            return;
        }
        String[] strArrSplit = strM18121a.split("-");
        String[] strArrSplit2 = str.split("-");
        if (strArrSplit[0].equals("") || strArrSplit.length == 2) {
            str2 = "2000-" + strArrSplit2[0] + "-" + strArrSplit2[1];
        } else {
            str2 = strArrSplit[0] + "-" + strArrSplit2[0] + "-" + strArrSplit2[1];
        }
        C4809aa.m18104a().m18128b("birthday", str2);
        C4809aa.m18104a().m18128b("birthday_type", "SHORT");
    }
}
