package com.sec.chaton.registration;

import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;

/* compiled from: FirstLauncherDialog.java */
/* renamed from: com.sec.chaton.registration.ac */
/* loaded from: classes.dex */
public class C3134ac {

    /* renamed from: a */
    private final int f11865a;

    /* renamed from: b */
    private final int f11866b;

    /* renamed from: c */
    private final int f11867c;

    /* renamed from: d */
    private final int f11868d;

    /* renamed from: e */
    private final int f11869e;

    /* renamed from: f */
    private final int f11870f;

    /* renamed from: g */
    private final int f11871g;

    /* renamed from: h */
    private final int f11872h;

    /* renamed from: i */
    private final int f11873i;

    /* renamed from: j */
    private final int f11874j;

    /* renamed from: k */
    private final int f11875k;

    /* renamed from: l */
    private Context f11876l;

    /* renamed from: m */
    private Bundle f11877m;

    /* renamed from: n */
    private InterfaceC3162bd f11878n;

    /* renamed from: o */
    private int f11879o;

    /* renamed from: p */
    private InterfaceC4936e f11880p;

    /* renamed from: q */
    private boolean f11881q;

    /* renamed from: r */
    private View f11882r;

    /* renamed from: s */
    private InterfaceC4936e f11883s;

    /* renamed from: t */
    private View f11884t;

    /* renamed from: u */
    private EditText f11885u;

    /* renamed from: v */
    private final String f11886v;

    /* renamed from: a */
    static /* synthetic */ int m13019a(C3134ac c3134ac) {
        int i = c3134ac.f11879o;
        c3134ac.f11879o = i + 1;
        return i;
    }

    public C3134ac() {
        this.f11865a = 0;
        this.f11866b = 1;
        this.f11867c = 2;
        this.f11868d = 3;
        this.f11869e = 4;
        this.f11870f = 5;
        this.f11871g = 6;
        this.f11872h = 7;
        this.f11873i = 8;
        this.f11874j = 9;
        this.f11875k = 10;
        this.f11876l = null;
        this.f11886v = C3134ac.class.getSimpleName();
    }

    public C3134ac(Context context, Bundle bundle, InterfaceC3162bd interfaceC3162bd) {
        this.f11865a = 0;
        this.f11866b = 1;
        this.f11867c = 2;
        this.f11868d = 3;
        this.f11869e = 4;
        this.f11870f = 5;
        this.f11871g = 6;
        this.f11872h = 7;
        this.f11873i = 8;
        this.f11874j = 9;
        this.f11875k = 10;
        this.f11876l = null;
        this.f11886v = C3134ac.class.getSimpleName();
        this.f11879o = 0;
        this.f11876l = context;
        this.f11877m = bundle;
        this.f11878n = interfaceC3162bd;
    }

    /* renamed from: a */
    public void m13036a() {
        if (this.f11876l == null) {
            throw new NullPointerException();
        }
        m13021a(this.f11877m);
    }

    /* renamed from: a */
    public void m13037a(int i) {
        if (this.f11876l == null) {
            throw new NullPointerException();
        }
        this.f11879o = i;
        m13028c();
        this.f11880p.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13021a(Bundle bundle) {
        boolean z;
        boolean z2;
        boolean z3 = !this.f11876l.getPackageManager().hasSystemFeature("android.hardware.telephony");
        int iM10677a = C2471v.m10677a(GlobalApplication.m18732r());
        if (C4904y.f17872b) {
            C4904y.m18639b("netState : " + iM10677a, this.f11886v);
        }
        if (z3) {
            if (-3 != iM10677a && -2 != iM10677a) {
                this.f11878n.mo9076a(true, this.f11877m, true);
            } else {
                m13025b(8);
            }
        } else {
            TelephonyManager telephonyManager = (TelephonyManager) this.f11876l.getSystemService("phone");
            if (telephonyManager != null && telephonyManager.getSimState() == 1) {
                z3 = true;
            }
        }
        if (z3) {
            if (-3 != iM10677a && -2 != iM10677a) {
                this.f11878n.mo9076a(true, this.f11877m, true);
                return;
            } else if (m13026b()) {
                this.f11878n.mo9076a(true, this.f11877m, true);
                return;
            } else {
                m13025b(8);
                return;
            }
        }
        boolean z4 = C2471v.m10679b(GlobalApplication.m18732r());
        if (!C2471v.m10680c(GlobalApplication.m18732r())) {
            z = false;
            z2 = false;
        } else if (iM10677a != 0 || -3 == iM10677a || -2 == iM10677a) {
            z = false;
            z2 = true;
        } else {
            z = true;
            z2 = true;
        }
        boolean z5 = C2471v.m10682e(GlobalApplication.m18732r()) || C2471v.m10683f(GlobalApplication.m18732r());
        boolean z6 = z4 && z2;
        boolean z7 = C2471v.m10681d(GlobalApplication.m18732r());
        boolean z8 = C2471v.m10684g(GlobalApplication.m18732r());
        boolean z9 = C2471v.m10685h(GlobalApplication.m18732r());
        boolean z10 = C2471v.m10686i(GlobalApplication.m18732r());
        if (z6) {
            if (z || m13026b()) {
                this.f11878n.mo9076a(true, this.f11877m, true);
                return;
            } else {
                m13025b(3);
                return;
            }
        }
        if (!z && !z10) {
            if (z4) {
                if (!m13026b()) {
                    m13025b(3);
                    return;
                } else {
                    this.f11878n.mo9076a(true, this.f11877m, true);
                    return;
                }
            }
            if (!z5) {
                if (!m13026b()) {
                    m13025b(4);
                    return;
                } else {
                    this.f11878n.mo9076a(true, this.f11877m, true);
                    return;
                }
            }
            if (z8) {
                if (!z7) {
                    if (!m13026b()) {
                        m13025b(5);
                        return;
                    } else {
                        this.f11878n.mo9076a(true, this.f11877m, true);
                        return;
                    }
                }
                if (C4809aa.m18104a().m18119a("DoNotShowRoamingNetwork", (Boolean) false).booleanValue()) {
                    this.f11878n.mo9076a(true, this.f11877m, true);
                    return;
                } else {
                    m13025b(2);
                    return;
                }
            }
            if (!z9) {
                if (!m13026b()) {
                    m13025b(7);
                    return;
                } else {
                    this.f11878n.mo9076a(true, this.f11877m, true);
                    return;
                }
            }
            if (C4809aa.m18104a().m18119a("PacketDataDialg", (Boolean) false).booleanValue()) {
                this.f11878n.mo9076a(true, this.f11877m, true);
                return;
            } else {
                m13025b(1);
                return;
            }
        }
        if (z && "460".equals(C4822an.m18243k())) {
            if (C4904y.f17872b) {
                C4904y.m18639b("Sim is china, so show connecte via WLAN", this.f11886v);
            }
            if (C4809aa.m18104a().m18119a("DoNotShowWlanDialog", (Boolean) false).booleanValue()) {
                this.f11878n.mo9076a(true, this.f11877m, true);
                return;
            } else {
                m13025b(10);
                return;
            }
        }
        this.f11878n.mo9076a(true, this.f11877m, true);
    }

    /* renamed from: b */
    private boolean m13026b() {
        return C4809aa.m18104a().m18129b("uid") || C4809aa.m18104a().m18129b("skip_sms_register_now");
    }

    /* renamed from: b */
    private void m13025b(int i) {
        this.f11882r = ((LayoutInflater) this.f11876l.getSystemService("layout_inflater")).inflate(R.layout.layout_text_checkbox, (ViewGroup) null);
        TextView textView = (TextView) this.f11882r.findViewById(R.id.commenttextview);
        textView.setSoundEffectsEnabled(false);
        textView.setOnClickListener(new ViewOnClickListenerC3135ad(this));
        TextView textView2 = (TextView) this.f11882r.findViewById(R.id.commenttextview);
        CheckBox checkBox = (CheckBox) this.f11882r.findViewById(R.id.data_packet_chekcbox);
        LinearLayout linearLayout = (LinearLayout) this.f11882r.findViewById(R.id.linear_packet_chekcbox);
        if (i == 2) {
            checkBox.setChecked(false);
            checkBox.setText(R.string.ams_never_show_again);
            checkBox.setSoundEffectsEnabled(true);
            checkBox.setOnCheckedChangeListener(new C3146ao(this));
            textView2.setText(R.string.provision_using_mobile_data);
        } else if (i == 5) {
            checkBox.setVisibility(8);
            textView2.setText(R.string.provision_data_roaming);
        } else if (i == 4) {
            checkBox.setVisibility(8);
            textView2.setText(R.string.provision_mobile_data_is_disabled);
        } else if (i == 8) {
            linearLayout.setVisibility(8);
            textView2.setText(R.string.provision_wifi_not_available_turn_on);
        } else if (i == 3) {
            checkBox.setVisibility(8);
            textView2.setText(R.string.provision_unable_to_connect);
        } else if (i == 7) {
            checkBox.setVisibility(8);
            textView2.setText(R.string.provision_no_signal);
        } else if (i == 1) {
            checkBox.setChecked(false);
            checkBox.setText(R.string.ams_never_show_again);
            checkBox.setSoundEffectsEnabled(true);
            checkBox.setOnCheckedChangeListener(new C3154aw(this));
            textView2.setText(R.string.provision_wifi_network_not_available_atnt);
        } else if (i == 10) {
            checkBox.setChecked(false);
            checkBox.setText(R.string.ams_never_show_again);
            checkBox.setSoundEffectsEnabled(true);
            checkBox.setOnCheckedChangeListener(new C3155ax(this));
            textView2.setText(R.string.provision_connect_to_wlan_continue);
        }
        m13029c(i);
        m13028c();
    }

    /* renamed from: c */
    private void m13029c(int i) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f11876l);
        if (i == 8) {
            abstractC4932aM18733a.mo18734a(R.string.provision_wifi_not_available).mo18742a(true).mo18748b(this.f11882r).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3156ay(this));
            this.f11883s = abstractC4932aM18733a.mo18745a();
            this.f11883s.setOnCancelListener(new DialogInterfaceOnCancelListenerC3157az(this));
        } else if (i == 4) {
            abstractC4932aM18733a.mo18734a(R.string.popup_no_network_connection).mo18742a(true).mo18748b(this.f11882r).mo18754c(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3159ba(this));
            this.f11883s = abstractC4932aM18733a.mo18745a();
            this.f11883s.setOnCancelListener(new DialogInterfaceOnCancelListenerC3160bb(this));
        } else if (i == 2) {
            abstractC4932aM18733a.mo18734a(R.string.provision_connect_via_roaming_nework).mo18742a(true).mo18748b(this.f11882r).mo18756d(R.string.provision_connect, new DialogInterfaceOnClickListenerC3136ae(this)).mo18747b(R.string.cancel, new DialogInterfaceOnClickListenerC3161bc(this));
            this.f11883s = abstractC4932aM18733a.mo18745a();
            this.f11883s.setOnCancelListener(new DialogInterfaceOnCancelListenerC3137af(this));
        } else if (i == 3) {
            abstractC4932aM18733a.mo18734a(R.string.popup_no_network_connection).mo18742a(true).mo18748b(this.f11882r).mo18754c(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3138ag(this));
            this.f11883s = abstractC4932aM18733a.mo18745a();
            this.f11883s.setOnCancelListener(new DialogInterfaceOnCancelListenerC3139ah(this));
        } else if (i == 5) {
            abstractC4932aM18733a.mo18734a(R.string.popup_no_network_connection).mo18742a(true).mo18748b(this.f11882r).mo18754c(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3140ai(this));
            this.f11883s = abstractC4932aM18733a.mo18745a();
            this.f11883s.setOnCancelListener(new DialogInterfaceOnCancelListenerC3141aj(this));
        } else if (i == 7) {
            abstractC4932aM18733a.mo18734a(R.string.popup_no_network_connection).mo18742a(true).mo18748b(this.f11882r).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3143al(this)).mo18747b(R.string.provision_later, new DialogInterfaceOnClickListenerC3142ak(this));
            this.f11883s = abstractC4932aM18733a.mo18745a();
            this.f11883s.setOnCancelListener(new DialogInterfaceOnCancelListenerC3144am(this));
        } else if (i == 1) {
            abstractC4932aM18733a.mo18734a(R.string.provision_connect_via_mobile_nework).mo18742a(true).mo18748b(this.f11882r).mo18756d(R.string.provision_connect, new DialogInterfaceOnClickListenerC3147ap(this)).mo18747b(R.string.cancel, new DialogInterfaceOnClickListenerC3145an(this));
            this.f11883s = abstractC4932aM18733a.mo18745a();
            this.f11883s.setOnCancelListener(new DialogInterfaceOnCancelListenerC3148aq(this));
        } else if (i == 10) {
            abstractC4932aM18733a.mo18734a(R.string.provision_connect_via_wlan).mo18742a(true).mo18748b(this.f11882r).mo18756d(R.string.provision_connect, new DialogInterfaceOnClickListenerC3150as(this)).mo18747b(R.string.cancel, new DialogInterfaceOnClickListenerC3149ar(this));
            this.f11883s = abstractC4932aM18733a.mo18745a();
            this.f11883s.setOnCancelListener(new DialogInterfaceOnCancelListenerC3151at(this));
        }
        this.f11883s.show();
    }

    /* renamed from: c */
    private void m13028c() {
        this.f11884t = ((LayoutInflater) this.f11876l.getSystemService("layout_inflater")).inflate(R.layout.layout_eidit_text, (ViewGroup) null);
        this.f11885u = (EditText) this.f11884t.findViewById(R.id.editBox);
        this.f11885u.setInputType(1);
        this.f11880p = AbstractC4932a.m18733a(this.f11876l).mo18742a(true).mo18748b(this.f11884t).mo18756d(R.string.done, new DialogInterfaceOnClickListenerC3153av(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3152au(this)).mo18745a();
    }
}
