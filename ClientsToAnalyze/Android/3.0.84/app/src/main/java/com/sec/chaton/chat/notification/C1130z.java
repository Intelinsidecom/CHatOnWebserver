package com.sec.chaton.chat.notification;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.multimedia.emoticon.C1835j;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: ScreenNotificationToast.java */
/* renamed from: com.sec.chaton.chat.notification.z */
/* loaded from: classes.dex */
public class C1130z extends Toast {

    /* renamed from: a */
    private TextView f4544a;

    /* renamed from: b */
    private TextView f4545b;

    /* renamed from: c */
    private C1103a f4546c;

    public C1130z(Context context) {
        super(context);
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_toast_popup, (ViewGroup) null);
        this.f4544a = (TextView) viewInflate.findViewById(R.id.textSenderName);
        this.f4545b = (TextView) viewInflate.findViewById(R.id.textMessage);
        setView(viewInflate);
        setDuration(0);
        setGravity(17, 0, 0);
    }

    /* renamed from: a */
    public static Toast m5476a(Context context) {
        return new C1130z(context);
    }

    /* renamed from: a */
    private String m5477a() {
        String strM10979a = C3159aa.m10962a().m10979a("OFF", "OFF");
        if (Build.VERSION.SDK_INT >= 16 && strM10979a.equals("OFF")) {
            KeyguardManager keyguardManager = (KeyguardManager) CommonApplication.m11493l().getSystemService("keyguard");
            if (C3250y.f11735c) {
                C3250y.m11453c("isLocked:" + keyguardManager.isKeyguardLocked() + ", isSecure:" + keyguardManager.isKeyguardSecure(), getClass().getSimpleName());
            }
            if (keyguardManager.isKeyguardLocked() && keyguardManager.isKeyguardSecure()) {
                return "ON";
            }
        }
        return strM10979a;
    }

    /* renamed from: a */
    public void m5478a(String str, String str2, int i, boolean z) {
        String string;
        if (this.f4546c == null) {
            this.f4546c = C1103a.m5432a(CommonApplication.m11493l());
        }
        if ("ON".equals(m5477a()) || !C3159aa.m10962a().m10977a("Setting show receive message", (Boolean) true).booleanValue()) {
            this.f4544a.setText(CommonApplication.m11493l().getString(R.string.app_name));
            if (this.f4546c.f4463m > 1) {
                string = CommonApplication.m11493l().getString(R.string.new_chaton_messages, Integer.valueOf(this.f4546c.f4463m));
            } else {
                string = CommonApplication.m11493l().getString(R.string.new_1_message_dont_preview);
            }
            this.f4545b.setText(string);
        } else {
            if (EnumC1455w.m6358a(i) == EnumC1455w.TEXT) {
                if (C1075eq.m5326c(str2)) {
                    str2 = str2.substring(1);
                }
                this.f4545b.setText(C1835j.m7508a(CommonApplication.m11493l(), C1075eq.m5327d(str2), (int) C3172an.m11085a(30.0f)));
            } else {
                this.f4545b.setText(EnumC1455w.m6361a(EnumC1455w.m6358a(i), str2, str, z));
            }
            this.f4544a.setText(str);
        }
        show();
    }
}
