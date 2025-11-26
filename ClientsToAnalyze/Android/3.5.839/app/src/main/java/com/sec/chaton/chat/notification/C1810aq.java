package com.sec.chaton.chat.notification;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.multimedia.emoticon.C2799k;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;

/* compiled from: ScreenNotificationToast.java */
/* renamed from: com.sec.chaton.chat.notification.aq */
/* loaded from: classes.dex */
public class C1810aq extends Toast {

    /* renamed from: a */
    private TextView f6825a;

    /* renamed from: b */
    private TextView f6826b;

    /* renamed from: c */
    private ImageView f6827c;

    /* renamed from: d */
    private C1828q f6828d;

    public C1810aq(Context context) {
        super(context);
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_toast_popup, (ViewGroup) null);
        this.f6825a = (TextView) viewInflate.findViewById(R.id.textSenderName);
        this.f6826b = (TextView) viewInflate.findViewById(R.id.textMessage);
        this.f6827c = (ImageView) viewInflate.findViewById(R.id.imageTitle);
        setView(viewInflate);
        setDuration(0);
        setGravity(48, 0, C5034k.m19097b(85.0f));
    }

    /* renamed from: a */
    public static Toast m8897a(Context context) {
        return new C1810aq(context);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private String m8898a() {
        String strM18121a = C4809aa.m18104a().m18121a("OFF", "OFF");
        if (Build.VERSION.SDK_INT >= 16 && strM18121a.equals("OFF")) {
            KeyguardManager keyguardManager = (KeyguardManager) CommonApplication.m18732r().getSystemService("keyguard");
            if (C4904y.f17873c) {
                C4904y.m18641c("isLocked:" + keyguardManager.isKeyguardLocked() + ", isSecure:" + keyguardManager.isKeyguardSecure(), getClass().getSimpleName());
            }
            if (keyguardManager.isKeyguardLocked() && keyguardManager.isKeyguardSecure()) {
                return "ON";
            }
        }
        return strM18121a;
    }

    /* renamed from: a */
    public void m8899a(String str, String str2, int i, boolean z, EnumC2301u enumC2301u) {
        if (this.f6828d == null) {
            this.f6828d = C1828q.m8956a();
        }
        if ("ON".equals(m8898a()) || !C4809aa.m18104a().m18119a("Setting show receive message", (Boolean) true).booleanValue()) {
            this.f6825a.setText(str);
            this.f6826b.setText(CommonApplication.m18732r().getResources().getString(R.string.new_chaton_message_preview_off, str));
        } else {
            if (EnumC2214ab.m10070a(i) == EnumC2214ab.TEXT) {
                if (C1736gi.m8652d(str2)) {
                    str2 = str2.substring(1);
                }
                this.f6826b.setText(C2799k.m11709a(CommonApplication.m18732r(), C1736gi.m8653e(str2), (int) C5034k.m19088a(30.0f)));
            } else {
                this.f6826b.setText(EnumC2214ab.m10073a(EnumC2214ab.m10070a(i), str2, str, z));
            }
            this.f6825a.setText(str);
        }
        if (enumC2301u == EnumC2301u.SMS) {
            this.f6827c.setBackgroundResource(R.drawable.actionbar_ic_chaton_sns_lite);
        } else {
            this.f6827c.setBackgroundResource(R.drawable.actionbar_ic_chaton);
        }
        show();
    }
}
