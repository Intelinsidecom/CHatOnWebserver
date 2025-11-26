package com.sec.chaton.registration;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.event.C1464f;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.p035io.entry.GetSMSAuthToken;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.cr */
/* loaded from: classes.dex */
class HandlerC2194cr extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f8486a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2194cr(FragmentNonSelfSMS fragmentNonSelfSMS, Looper looper) {
        super(looper);
        this.f8486a = fragmentNonSelfSMS;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        if (this.f8486a.getActivity() != null) {
            C0267d c0267d = (C0267d) message.obj;
            if (message.what == 1301) {
                if (c0267d != null && c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                    this.f8486a.f8233a = (GetSMSAuthToken) c0267d.m1354e();
                    if (this.f8486a.f8233a != null) {
                        C3250y.m11450b("mToken=" + this.f8486a.f8233a.token, getClass().getSimpleName());
                        this.f8486a.f8256x = this.f8486a.f8233a.token;
                        C3159aa.m10966a("token", this.f8486a.f8233a.token);
                        C3159aa.m10962a().m10981a("SMSSaveCountInterval");
                        this.f8486a.m8551g();
                    } else if (this.f8486a.getActivity() != null) {
                        this.f8486a.f8226G = AbstractC3271a.m11494a(this.f8486a.getActivity()).mo11500a(this.f8486a.getResources().getString(R.string.toast_error)).mo11509b(this.f8486a.getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2195cs(this)).mo11505a();
                        this.f8486a.f8226G.show();
                        if (this.f8486a.getActivity() != null && this.f8486a.f8246n != null && this.f8486a.f8246n.isShowing()) {
                            this.f8486a.f8246n.dismiss();
                        }
                    }
                    if (this.f8486a.getActivity() != null && this.f8486a.f8246n != null && this.f8486a.f8246n.isShowing()) {
                        this.f8486a.f8246n.dismiss();
                    }
                } else if (c0267d != null && c0267d.m1355f() == 30002) {
                    C3250y.m11455d("server sent error cause by GET_SMS_AUTHTOKEN_GENERATED_RIGHT_BEFORE", getClass().getSimpleName());
                    FragmentNonSelfSMS.m8533a(this.f8486a.getActivity());
                    this.f8486a.m8568a("SMS");
                    if (this.f8486a.getActivity() != null && this.f8486a.f8246n != null && this.f8486a.f8246n.isShowing()) {
                        this.f8486a.f8246n.dismiss();
                    }
                } else if (c0267d != null && c0267d.m1355f() == 30001) {
                    C3250y.m11455d("server sent error cause by GET_SMS_AUTHTOKEN_INVALID", getClass().getSimpleName());
                    this.f8486a.f8226G = AbstractC3271a.m11494a(this.f8486a.getActivity()).mo11500a(this.f8486a.getResources().getString(R.string.toast_error)).mo11509b(this.f8486a.getResources().getString(R.string.registration_check_phone_number)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2196ct(this)).mo11505a();
                    if (this.f8486a.getActivity() != null) {
                        this.f8486a.f8226G.show();
                    }
                    this.f8486a.m8547e();
                    if (this.f8486a.getActivity() != null && this.f8486a.f8246n != null && this.f8486a.f8246n.isShowing()) {
                        this.f8486a.f8246n.dismiss();
                    }
                } else {
                    this.f8486a.f8226G = AbstractC3271a.m11494a(this.f8486a.getActivity()).mo11500a(this.f8486a.getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(this.f8486a.getResources().getString(R.string.toast_network_unable), this.f8486a.getResources().getString(R.string.toast_error), c0267d.m1356g())).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2197cu(this)).mo11505a();
                    this.f8486a.f8226G.show();
                    C3250y.m11442a("SELF SMS failed becuase netwrok error", getClass().getSimpleName());
                    this.f8486a.m8547e();
                    if (this.f8486a.getActivity() != null && this.f8486a.f8246n != null && this.f8486a.f8246n.isShowing()) {
                        this.f8486a.f8246n.dismiss();
                    }
                }
            }
            if (message.what == 1302) {
                if (c0267d != null && c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                    this.f8486a.m8568a("SMS");
                    C3159aa.m10963a("over_sms_request", (Boolean) false);
                } else if (c0267d != null && c0267d.m1355f() == 40003) {
                    C3250y.m11455d("server sent error cause by SEND_SMS_REQUEST_LIMIT", getClass().getSimpleName());
                } else if (c0267d != null && c0267d.m1355f() == 40005) {
                    this.f8486a.m8542c();
                    C3159aa.m10963a("over_sms_request", (Boolean) true);
                } else if (this.f8486a.getActivity() != null) {
                    this.f8486a.f8226G = AbstractC3271a.m11494a(this.f8486a.getActivity()).mo11500a(this.f8486a.getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(this.f8486a.getResources().getString(R.string.toast_network_unable), this.f8486a.getResources().getString(R.string.toast_error), c0267d.m1356g())).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2198cv(this)).mo11505a();
                    this.f8486a.f8226G.show();
                    this.f8486a.m8547e();
                    C3250y.m11442a("SELF SMS failed becuase netwrok error", getClass().getSimpleName());
                }
                if (this.f8486a.getActivity() != null && this.f8486a.f8246n != null && this.f8486a.f8246n.isShowing()) {
                    this.f8486a.f8246n.dismiss();
                }
            }
            if (message.what == 2004) {
                this.f8486a.f8228I.setEnabled(true);
                if (this.f8486a.getActivity() != null && this.f8486a.f8246n != null && this.f8486a.f8246n.isShowing()) {
                    this.f8486a.f8246n.dismiss();
                }
                if (c0267d != null && c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR && this.f8486a.getActivity() != null) {
                    C3159aa.m10966a("authnum", this.f8486a.f8255w);
                    String strM10979a = C3159aa.m10962a().m10979a("temp_country_ISO", "");
                    C3159aa.m10966a("msisdn", C3159aa.m10962a().m10979a("msisdn_temp", ""));
                    C3159aa.m10962a().m10981a("msisdn_temp");
                    C3159aa.m10962a().m10981a("phonenumber");
                    this.f8486a.m8554i();
                    if (TextUtils.isEmpty(C3159aa.m10962a().m10979a("account_country_code", "")) && !C3171am.m11052a(strM10979a)) {
                        if (this.f8486a.getActivity() != null) {
                            this.f8486a.f8246n = ProgressDialogC3265l.m11490a(this.f8486a.getActivity(), null, this.f8486a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
                        }
                        C1464f.m6387a();
                        C3159aa.m10966a("country_ISO", strM10979a);
                        new C1324bj(this.f8486a.f8237e).m5694b();
                    } else {
                        C3159aa.m10966a("country_ISO", strM10979a);
                        this.f8486a.m8549f();
                    }
                } else if (c0267d != null && (c0267d.m1355f() == 12007 || c0267d.m1355f() == 12000)) {
                    C3250y.m11455d("[UpdateMSISN] verification code was wrong", getClass().getSimpleName());
                    this.f8486a.f8239g.setText("");
                    FragmentNonSelfSMS.m8534a((Activity) this.f8486a.getActivity(), false);
                } else if (c0267d != null && c0267d.m1355f() == 12008) {
                    this.f8486a.f8239g.setText("");
                    FragmentNonSelfSMS.m8540b((Activity) this.f8486a.getActivity(), false);
                } else if (this.f8486a.getActivity() != null) {
                    this.f8486a.f8226G = AbstractC3271a.m11494a(this.f8486a.getActivity()).mo11500a(this.f8486a.getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(this.f8486a.getResources().getString(R.string.toast_network_unable), this.f8486a.getResources().getString(R.string.toast_error), c0267d.m1356g())).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2199cw(this)).mo11505a();
                    this.f8486a.f8226G.show();
                    C3250y.m11442a("UpdateMSISDN failed becuase netwrok error", getClass().getSimpleName());
                }
            } else if (message.what == 1104) {
                if (this.f8486a.getActivity() != null && this.f8486a.f8246n != null && this.f8486a.f8246n.isShowing()) {
                    this.f8486a.f8246n.dismiss();
                }
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR && this.f8486a.getActivity() != null) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("GET_VERSION_NOTICE success", getClass().getSimpleName());
                    }
                    this.f8486a.m8549f();
                } else if (this.f8486a.getActivity() != null) {
                    this.f8486a.f8226G = AbstractC3271a.m11494a(this.f8486a.getActivity()).mo11500a(this.f8486a.getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(this.f8486a.getResources().getString(R.string.toast_network_unable), this.f8486a.getResources().getString(R.string.toast_error), c0267d.m1356g())).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2201cy(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2200cx(this)).mo11505a();
                    this.f8486a.f8226G.show();
                    C3250y.m11442a("GET_VERSION_NOTICE failed becuase netwrok error", getClass().getSimpleName());
                }
            }
            if (message.what == 203) {
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR && this.f8486a.getActivity() != null) {
                    C3159aa.m10966a("country_ISO", C3159aa.m10962a().m10979a("temp_country_ISO", ""));
                    C3159aa.m10966a("authnum", this.f8486a.f8255w);
                    C3159aa.m10966a("msisdn", C3159aa.m10962a().m10979a("msisdn_temp", ""));
                    C3159aa.m10962a().m10981a("msisdn_temp");
                    C3159aa.m10962a().m10981a("phonenumber");
                    this.f8486a.f8231L = false;
                    this.f8486a.m8549f();
                    return;
                }
                if (c0267d.m1355f() == 12007 || c0267d.m1355f() == 12000) {
                    C3250y.m11455d("verification code was wrong", getClass().getSimpleName());
                    this.f8486a.f8239g.setText("");
                    if (this.f8486a.getActivity() != null && this.f8486a.f8246n != null && this.f8486a.f8246n.isShowing()) {
                        this.f8486a.f8246n.dismiss();
                    }
                    FragmentNonSelfSMS.m8534a((Activity) this.f8486a.getActivity(), false);
                    return;
                }
                if (c0267d.m1355f() == 12008) {
                    this.f8486a.f8239g.setText("");
                    if (this.f8486a.getActivity() != null && this.f8486a.f8246n != null && this.f8486a.f8246n.isShowing()) {
                        this.f8486a.f8246n.dismiss();
                    }
                    FragmentNonSelfSMS.m8540b((Activity) this.f8486a.getActivity(), false);
                    return;
                }
                if (this.f8486a.getActivity() != null) {
                    if (this.f8486a.getActivity() != null && this.f8486a.f8246n != null && this.f8486a.f8246n.isShowing()) {
                        this.f8486a.f8246n.dismiss();
                    }
                    this.f8486a.f8226G = AbstractC3271a.m11494a(this.f8486a.getActivity()).mo11500a(this.f8486a.getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(this.f8486a.getResources().getString(R.string.toast_network_unable), this.f8486a.getResources().getString(R.string.toast_error), c0267d.m1356g())).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2202cz(this)).mo11505a();
                    this.f8486a.f8226G.show();
                    C3250y.m11442a("SELF SMS failed becuase netwrok error", getClass().getSimpleName());
                }
            }
        }
    }
}
