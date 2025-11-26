package com.sec.chaton.registration;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2122ca;
import com.sec.chaton.p065io.entry.GetSMSAuthToken;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.util.log.collector.C5043h;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.cs */
/* loaded from: classes.dex */
class HandlerC3204cs extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f11968a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC3204cs(FragmentNonSelfSMS fragmentNonSelfSMS, Looper looper) {
        super(looper);
        this.f11968a = fragmentNonSelfSMS;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        if (this.f11968a.getActivity() != null) {
            C0778b c0778b = (C0778b) message.obj;
            if (message.what == 1301) {
                if (c0778b != null && c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    this.f11968a.f11679a = (GetSMSAuthToken) c0778b.m3110e();
                    if (this.f11968a.f11679a != null) {
                        C4904y.m18639b("mToken=" + this.f11968a.f11679a.token, getClass().getSimpleName());
                        this.f11968a.f11703y = this.f11968a.f11679a.token;
                        C4809aa.m18108a("token", this.f11968a.f11679a.token);
                        C4809aa.m18104a().m18123a("SMSSaveCountInterval");
                        this.f11968a.m12884g();
                    } else if (this.f11968a.getActivity() != null) {
                        this.f11968a.f11671H = AbstractC4932a.m18733a(this.f11968a.getActivity()).mo18740a(this.f11968a.getResources().getString(R.string.toast_error)).mo18749b(this.f11968a.getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3205ct(this)).mo18745a();
                        this.f11968a.f11671H.show();
                        if (this.f11968a.getActivity() != null && this.f11968a.f11692n != null && this.f11968a.f11692n.isShowing()) {
                            this.f11968a.f11692n.dismiss();
                        }
                    }
                    if (this.f11968a.getActivity() != null && this.f11968a.f11692n != null && this.f11968a.f11692n.isShowing()) {
                        this.f11968a.f11692n.dismiss();
                    }
                } else if (c0778b != null && c0778b.m3111f() == 30002) {
                    C4904y.m18645d("server sent error cause by GET_SMS_AUTHTOKEN_GENERATED_RIGHT_BEFORE", getClass().getSimpleName());
                    FragmentNonSelfSMS.m12864a(this.f11968a.getActivity());
                    this.f11968a.m12905a("SMS");
                    if (this.f11968a.getActivity() != null && this.f11968a.f11692n != null && this.f11968a.f11692n.isShowing()) {
                        this.f11968a.f11692n.dismiss();
                    }
                } else if (c0778b != null && c0778b.m3111f() == 30001) {
                    C4904y.m18645d("server sent error cause by GET_SMS_AUTHTOKEN_INVALID", getClass().getSimpleName());
                    this.f11968a.f11671H = AbstractC4932a.m18733a(this.f11968a.getActivity()).mo18740a(this.f11968a.getResources().getString(R.string.pop_up_attention)).mo18749b(this.f11968a.getResources().getString(R.string.error_code_common) + " " + this.f11968a.getResources().getString(R.string.registration_check_phone_number)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3206cu(this)).mo18745a();
                    if (this.f11968a.getActivity() != null) {
                        this.f11968a.f11671H.setCancelable(false);
                        this.f11968a.f11671H.show();
                    }
                    this.f11968a.m12879e();
                    if (this.f11968a.getActivity() != null && this.f11968a.f11692n != null && this.f11968a.f11692n.isShowing()) {
                        this.f11968a.f11692n.dismiss();
                    }
                } else {
                    String strM3112g = "";
                    if (c0778b != null) {
                        strM3112g = c0778b.m3112g();
                    }
                    this.f11968a.f11671H = C4859bx.m18375a(AbstractC4932a.m18733a(this.f11968a.getActivity()).mo18740a(this.f11968a.getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(this.f11968a.getResources().getString(R.string.toast_network_unable), this.f11968a.getResources().getString(R.string.error_code_common), strM3112g)).mo18747b(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3207cv(this)), this.f11968a.getActivity(), strM3112g).mo18745a();
                    this.f11968a.f11671H.show();
                    C4904y.m18634a("SELF SMS failed becuase netwrok error", getClass().getSimpleName());
                    this.f11968a.m12879e();
                    if (this.f11968a.getActivity() != null && this.f11968a.f11692n != null && this.f11968a.f11692n.isShowing()) {
                        this.f11968a.f11692n.dismiss();
                    }
                }
            }
            if (message.what == 1302) {
                if (c0778b != null && c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    this.f11968a.m12905a("SMS");
                    C4809aa.m18105a("over_sms_request", (Boolean) false);
                } else if (c0778b != null && c0778b.m3111f() == 40003) {
                    C4904y.m18645d("server sent error cause by SEND_SMS_REQUEST_LIMIT", getClass().getSimpleName());
                } else if (c0778b != null && c0778b.m3111f() == 40005) {
                    this.f11968a.m12875c();
                    C4809aa.m18105a("over_sms_request", (Boolean) true);
                    this.f11968a.f11675L.setEnabled(true);
                    this.f11968a.m12879e();
                } else if (this.f11968a.getActivity() != null) {
                    this.f11968a.m12866a(c0778b);
                    this.f11968a.m12879e();
                    C4904y.m18634a("SELF SMS failed becuase netwrok error", getClass().getSimpleName());
                }
                if (this.f11968a.getActivity() != null && this.f11968a.f11692n != null && this.f11968a.f11692n.isShowing()) {
                    this.f11968a.f11692n.dismiss();
                }
            }
            if (message.what == 2004) {
                this.f11968a.f11673J.setEnabled(true);
                if (this.f11968a.getActivity() != null && this.f11968a.f11692n != null && this.f11968a.f11692n.isShowing()) {
                    this.f11968a.f11692n.dismiss();
                }
                if (c0778b != null && c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR && this.f11968a.getActivity() != null) {
                    if (C4822an.m18255w()) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("SA user did contact sync", getClass().getSimpleName());
                        }
                        C5043h.m19179a().m19185a("0001", "2126", false);
                    }
                    C4809aa.m18108a("authnum", this.f11968a.f11702x);
                    String strM18121a = C4809aa.m18104a().m18121a("temp_country_ISO", "");
                    C4809aa.m18108a("msisdn", C4809aa.m18104a().m18121a("msisdn_temp", ""));
                    this.f11968a.m12888i();
                    if (TextUtils.isEmpty(C4809aa.m18104a().m18121a("account_country_code", "")) && !C4822an.m18224b(strM18121a)) {
                        if (this.f11968a.getActivity() != null) {
                            this.f11968a.f11692n = ProgressDialogC4926s.m18728a(this.f11968a.getActivity(), null, this.f11968a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
                        }
                        C4809aa.m18108a("country_ISO", strM18121a);
                        new C2122ca(this.f11968a.f11683e).m9471b();
                    } else {
                        C4809aa.m18108a("country_ISO", strM18121a);
                        this.f11968a.m12881f();
                    }
                } else if (c0778b != null && (c0778b.m3111f() == 12007 || c0778b.m3111f() == 12000)) {
                    C4904y.m18645d("[UpdateMSISN] verification code was wrong", getClass().getSimpleName());
                    this.f11968a.f11685g.setText("");
                    FragmentNonSelfSMS.m12865a((Activity) this.f11968a.getActivity(), false);
                } else if (c0778b != null && c0778b.m3111f() == 12008) {
                    this.f11968a.f11685g.setText("");
                    FragmentNonSelfSMS.m12865a((Activity) this.f11968a.getActivity(), false);
                } else if (this.f11968a.getActivity() != null) {
                    this.f11968a.m12866a(c0778b);
                    C4904y.m18634a("UpdateMSISDN failed becuase netwrok error", getClass().getSimpleName());
                }
            } else if (message.what == 1104) {
                if (this.f11968a.getActivity() != null && this.f11968a.f11692n != null && this.f11968a.f11692n.isShowing()) {
                    this.f11968a.f11692n.dismiss();
                }
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR && this.f11968a.getActivity() != null) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("GET_VERSION_NOTICE success", getClass().getSimpleName());
                    }
                    this.f11968a.m12881f();
                } else if (this.f11968a.getActivity() != null) {
                    String strM3112g2 = c0778b.m3112g();
                    this.f11968a.f11671H = C4859bx.m18375a(AbstractC4932a.m18733a(this.f11968a.getActivity()).mo18740a(this.f11968a.getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(this.f11968a.getResources().getString(R.string.toast_network_unable), this.f11968a.getResources().getString(R.string.error_code_common), strM3112g2)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3209cx(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3208cw(this)), this.f11968a.getActivity(), strM3112g2).mo18745a();
                    this.f11968a.f11671H.show();
                    C4904y.m18634a("GET_VERSION_NOTICE failed becuase netwrok error", getClass().getSimpleName());
                }
            }
            if (message.what == 203) {
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR && this.f11968a.getActivity() != null) {
                    C4809aa.m18108a("country_ISO", C4809aa.m18104a().m18121a("temp_country_ISO", ""));
                    C4809aa.m18108a("authnum", this.f11968a.f11702x);
                    this.f11968a.f11676M = false;
                    this.f11968a.m12881f();
                    return;
                }
                if (c0778b.m3111f() == 12007 || c0778b.m3111f() == 12000) {
                    C4904y.m18645d("verification code was wrong", getClass().getSimpleName());
                    this.f11968a.f11685g.setText("");
                    if (this.f11968a.getActivity() != null && this.f11968a.f11692n != null && this.f11968a.f11692n.isShowing()) {
                        this.f11968a.f11692n.dismiss();
                    }
                    FragmentNonSelfSMS.m12865a((Activity) this.f11968a.getActivity(), false);
                    return;
                }
                if (c0778b.m3111f() == 12008) {
                    this.f11968a.f11685g.setText("");
                    if (this.f11968a.getActivity() != null && this.f11968a.f11692n != null && this.f11968a.f11692n.isShowing()) {
                        this.f11968a.f11692n.dismiss();
                    }
                    FragmentNonSelfSMS.m12873b((Activity) this.f11968a.getActivity(), false);
                    return;
                }
                if (this.f11968a.getActivity() != null) {
                    if (this.f11968a.getActivity() != null && this.f11968a.f11692n != null && this.f11968a.f11692n.isShowing()) {
                        this.f11968a.f11692n.dismiss();
                    }
                    String strM3112g3 = c0778b.m3112g();
                    this.f11968a.f11671H = C4859bx.m18375a(AbstractC4932a.m18733a(this.f11968a.getActivity()).mo18740a(this.f11968a.getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(this.f11968a.getResources().getString(R.string.toast_network_unable), this.f11968a.getResources().getString(R.string.error_code_common), strM3112g3)).mo18747b(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3210cy(this)), this.f11968a.getActivity(), strM3112g3).mo18745a();
                    this.f11968a.f11671H.show();
                    C4904y.m18634a("SELF SMS failed becuase netwrok error", getClass().getSimpleName());
                }
            }
        }
    }
}
