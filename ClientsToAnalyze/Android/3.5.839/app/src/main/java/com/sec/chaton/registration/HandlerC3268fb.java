package com.sec.chaton.registration;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.p137vk.sdk.VKOpenAuthActivity;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p057e.p058a.C2192f;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.SkipSMSVerifyServer;
import com.sec.chaton.p067j.C2417af;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fb */
/* loaded from: classes.dex */
class HandlerC3268fb extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentRegistPushName f12036a;

    HandlerC3268fb(FragmentRegistPushName fragmentRegistPushName) {
        this.f12036a = fragmentRegistPushName;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b;
        if (this.f12036a.getActivity() != null) {
            if (message.obj == null) {
                c0778b = null;
            } else {
                c0778b = (C0778b) message.obj;
            }
            switch (message.what) {
                case 201:
                    if (c0778b != null && c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        this.f12036a.m12975d();
                        this.f12036a.m12966a(this.f12036a.getActivity().getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12036a.getResources().getString(R.string.auto_regi_buddy_sync), this.f12036a.f11803q, true);
                        C4809aa.m18108a("msisdn", C4809aa.m18104a().m18121a("msisdn_temp", ""));
                        C4809aa.m18104a().m18123a("msisdn_temp");
                        C2192f.m9877a();
                        this.f12036a.f11799m.m9497a("append");
                        break;
                    } else if (c0778b != null && c0778b.m3111f() == 12007) {
                        this.f12036a.m12975d();
                        FragmentNonSelfSMS.m12865a(this.f12036a.f11788b, true);
                        this.f12036a.getActivity().setResult(7, new Intent());
                        break;
                    } else if (c0778b == null || c0778b.m3111f() != 12008) {
                        this.f12036a.m12975d();
                        if (this.f12036a.getActivity() != null) {
                            String strM3112g = "";
                            if (c0778b != null) {
                                strM3112g = c0778b.m3112g();
                            }
                            this.f12036a.f11808v = C4859bx.m18375a(AbstractC4932a.m18733a(this.f12036a.getActivity()).mo18740a(this.f12036a.getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(this.f12036a.getResources().getString(R.string.toast_network_unable), this.f12036a.getResources().getString(R.string.error_code_common), strM3112g)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3270fd(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3283fq(this)), this.f12036a.getActivity(), strM3112g).mo18745a();
                            this.f12036a.f11808v.show();
                            C4904y.m18634a("[Dev]Registration Failed. httpStatus: " + c0778b.m3114i() + ", FaultCode: " + c0778b.m3111f() + ", Message: " + c0778b.m3113h(), getClass().getSimpleName());
                            break;
                        }
                    } else {
                        this.f12036a.m12975d();
                        FragmentNonSelfSMS.m12865a(this.f12036a.f11788b, true);
                        this.f12036a.getActivity().setResult(7, new Intent());
                        break;
                    }
                    break;
                case 204:
                case 2001:
                    if (c0778b != null && ((c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) || c0778b.m3111f() == 50007)) {
                        if (this.f12036a.getActivity() != null) {
                            SkipSMSVerifyServer skipSMSVerifyServer = (SkipSMSVerifyServer) c0778b.m3110e();
                            if (TextUtils.isEmpty(skipSMSVerifyServer.uid) || TextUtils.isEmpty(skipSMSVerifyServer.chatonid)) {
                                if (C4904y.f17874d) {
                                    C4904y.m18645d("uid or chatonid is null " + c0778b.m3114i() + ", FaultCode: " + c0778b.m3111f() + ", Message: " + c0778b.m3113h(), getClass().getSimpleName());
                                }
                                this.f12036a.m12975d();
                                this.f12036a.f11808v = AbstractC4932a.m18733a(this.f12036a.getActivity()).mo18740a(this.f12036a.getResources().getString(R.string.toast_error)).mo18749b(this.f12036a.getResources().getString(R.string.registration_fail_pop_up)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3271fe(this)).mo18752b();
                                break;
                            } else if (message.what == 2001) {
                                this.f12036a.f11804r = 0;
                                this.f12036a.m12976e();
                                this.f12036a.f11807u = C4809aa.m18104a().m18121a("temp_account_country_code", "");
                                C4809aa.m18105a("did_samsung_account_mapping", (Boolean) true);
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("Final contact sync ISO : " + this.f12036a.f11807u, getClass().getSimpleName());
                                }
                                C4809aa.m18108a("account_country_code", this.f12036a.f11807u);
                                if (C4859bx.m18386a((Context) this.f12036a.f11788b)) {
                                    this.f12036a.m12965a(this.f12036a.getActivity().getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12036a.getResources().getString(R.string.auto_regi_initializing_voice_and_video), this.f12036a.f11803q);
                                    if (this.f12036a.f11806t != null) {
                                        if (C4859bx.m18369a(this.f12036a.f11788b, this.f12036a.f11806t) != 0) {
                                            this.f12036a.m12964a(this.f12036a.getResources().getString(R.string.auto_regi_buddy_sync));
                                            this.f12036a.f11799m.m9495a();
                                            break;
                                        }
                                    } else {
                                        this.f12036a.m12964a(this.f12036a.getResources().getString(R.string.auto_regi_buddy_sync));
                                        this.f12036a.f11799m.m9495a();
                                        break;
                                    }
                                } else {
                                    this.f12036a.m12964a(this.f12036a.getResources().getString(R.string.auto_regi_buddy_sync));
                                    this.f12036a.f11799m.m9495a();
                                    break;
                                }
                            } else if (message.what == 204) {
                                this.f12036a.m12975d();
                                this.f12036a.getActivity().setResult(-1, new Intent());
                                this.f12036a.getActivity().finish();
                                break;
                            }
                        }
                    } else if (c0778b != null && c0778b.m3111f() == 50006) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("SSO token validaion was finished", getClass().getSimpleName());
                        }
                        String strM18389b = C4859bx.m18389b(this.f12036a.f11788b);
                        if (!this.f12036a.m12979f() || TextUtils.isEmpty(strM18389b) || this.f12036a.f11804r >= 2) {
                            if (this.f12036a.f11804r >= 2) {
                                this.f12036a.f11804r = 0;
                            }
                            this.f12036a.m12975d();
                            C4809aa.m18104a().m18123a("samsung_account_email");
                            this.f12036a.f11808v = AbstractC4932a.m18733a(this.f12036a.f11788b).mo18740a(this.f12036a.getResources().getString(R.string.toast_error)).mo18749b(this.f12036a.getResources().getString(R.string.samsung_account_try_later)).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3272ff(this)).mo18752b();
                            break;
                        } else {
                            FragmentRegistPushName.m12993t(this.f12036a);
                            String packageName = this.f12036a.f11788b.getPackageName();
                            Intent intent = new Intent("com.msc.action.ACCESSTOKEN_V02_REQUEST");
                            intent.putExtra(VKOpenAuthActivity.VK_EXTRA_CLIENT_ID, "fs24s8z0hh");
                            intent.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
                            intent.putExtra("mypackage", packageName);
                            intent.putExtra("OSP_VER", "OSP_02");
                            intent.putExtra("MODE", "BACKGROUND");
                            intent.putExtra("additional", new String[]{"user_id", "email_id", "mcc", "api_server_url"});
                            intent.putExtra("expired_access_token", C4809aa.m18104a().m18121a("samsung_account_token", ""));
                            this.f12036a.f11788b.sendBroadcast(intent);
                            if (C4904y.f17872b) {
                                C4904y.m18639b("retryCount : " + this.f12036a.f11804r, getClass().getSimpleName());
                                break;
                            }
                        }
                    } else if (c0778b != null && c0778b.m3111f() == 50004) {
                        this.f12036a.m12975d();
                        C4904y.m18639b("device over max of limitation", getClass().getSimpleName());
                        this.f12036a.f11808v = AbstractC4932a.m18733a(this.f12036a.f11788b).mo18740a(this.f12036a.getResources().getString(R.string.pop_up_attention)).mo18749b(this.f12036a.getResources().getString(R.string.account_max_device_alert3, 5)).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3273fg(this)).mo18752b();
                        break;
                    } else if (c0778b != null && c0778b.m3111f() == 12007) {
                        this.f12036a.m12975d();
                        FragmentNonSelfSMS.m12865a(this.f12036a.f11788b, true);
                        this.f12036a.getActivity().setResult(7, new Intent());
                        break;
                    } else if (c0778b == null || c0778b.m3111f() != 12008) {
                        this.f12036a.m12975d();
                        if (this.f12036a.getActivity() != null) {
                            String strM3112g2 = "";
                            if (c0778b != null) {
                                strM3112g2 = c0778b.m3112g();
                            }
                            this.f12036a.f11808v = C4859bx.m18375a(AbstractC4932a.m18733a(this.f12036a.getActivity()).mo18740a(this.f12036a.getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(this.f12036a.getResources().getString(R.string.toast_network_unable), this.f12036a.getResources().getString(R.string.error_code_common), strM3112g2)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3275fi(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3274fh(this)), this.f12036a.getActivity(), strM3112g2).mo18745a();
                            this.f12036a.f11808v.show();
                            C4904y.m18634a("[Dev]Registration Failed. httpStatus: " + c0778b.m3114i() + ", FaultCode: " + c0778b.m3111f() + ", Message: " + c0778b.m3113h(), getClass().getSimpleName());
                            break;
                        }
                    } else {
                        this.f12036a.m12975d();
                        FragmentNonSelfSMS.m12873b(this.f12036a.f11788b, true);
                        this.f12036a.getActivity().setResult(7, new Intent());
                        break;
                    }
                    break;
                case 301:
                    if (c0778b == null || !c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        this.f12036a.m12975d();
                        C4904y.m18639b("fail to get all buddies", getClass().getSimpleName());
                        if (CommonApplication.m18732r() != null) {
                            String strM3112g3 = "";
                            if (c0778b != null) {
                                strM3112g3 = c0778b.m3112g();
                            }
                            this.f12036a.f11808v = C4859bx.m18375a(AbstractC4932a.m18733a(this.f12036a.f11788b).mo18740a(this.f12036a.getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(this.f12036a.getResources().getString(R.string.toast_network_unable), this.f12036a.getResources().getString(R.string.error_code_common), strM3112g3)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3278fl(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3277fk(this)), this.f12036a.getActivity(), strM3112g3).mo18745a();
                            this.f12036a.f11808v.show();
                            break;
                        }
                    } else if (this.f12036a.f11801o.equals("phone")) {
                        this.f12036a.m12975d();
                        this.f12036a.getActivity().setResult(-1, new Intent());
                        this.f12036a.getActivity().finish();
                        break;
                    } else {
                        if (this.f12036a.getActivity() != null) {
                            this.f12036a.m12964a(this.f12036a.getActivity().getResources().getString(R.string.multidevice_sync_chat_title));
                        }
                        this.f12036a.f11798l.m8728a();
                        break;
                    }
                    break;
                case 302:
                    if (c0778b != null && c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        this.f12036a.f11799m.m9495a();
                        break;
                    } else if (c0778b == null || c0778b.m3107b() != EnumC2464o.NO_REQUEST) {
                        this.f12036a.m12975d();
                        if (this.f12036a.getActivity() != null) {
                            String strM3112g4 = "";
                            if (c0778b != null) {
                                strM3112g4 = c0778b.m3112g();
                            }
                            this.f12036a.f11808v = C4859bx.m18375a(AbstractC4932a.m18733a(this.f12036a.getActivity()).mo18740a(this.f12036a.getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(this.f12036a.getResources().getString(R.string.toast_network_unable), this.f12036a.getResources().getString(R.string.error_code_common), strM3112g4)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3280fn(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3279fm(this)), this.f12036a.getActivity(), strM3112g4).mo18745a();
                            this.f12036a.f11808v.show();
                            break;
                        }
                    } else {
                        this.f12036a.f11799m.m9495a();
                        break;
                    }
                    break;
                case 305:
                    if (c0778b == null || !c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        this.f12036a.m12975d();
                        C4904y.m18639b("fail to set extra info", getClass().getSimpleName());
                        if (GlobalApplication.m18732r() != null) {
                            String strM3112g5 = "";
                            if (c0778b != null) {
                                strM3112g5 = c0778b.m3112g();
                            }
                            this.f12036a.f11808v = C4859bx.m18375a(AbstractC4932a.m18733a(this.f12036a.f11788b).mo18740a(this.f12036a.getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(this.f12036a.getResources().getString(R.string.toast_network_unable), this.f12036a.getResources().getString(R.string.toast_error), strM3112g5)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3276fj(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3269fc(this)), this.f12036a.getActivity(), strM3112g5).mo18745a();
                            this.f12036a.f11808v.show();
                            break;
                        }
                    } else {
                        this.f12036a.m12964a(this.f12036a.getResources().getString(R.string.auto_regi_buddy_sync));
                        this.f12036a.f11799m.m9495a();
                        break;
                    }
                    break;
                case 2301:
                    this.f12036a.m12975d();
                    if (c0778b != null && c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        this.f12036a.getActivity().setResult(-1, new Intent());
                        this.f12036a.getActivity().finish();
                        C2417af.m10456c();
                        C2134o.m9567a(null);
                        break;
                    } else {
                        if (C4904y.f17871a) {
                            C4904y.m18646e("Fail to sync ChatListInfo ... ", getClass().getSimpleName());
                            C4904y.m18646e("ChatListInfo Fail code : " + c0778b.m3107b() + ", message : " + c0778b.m3113h(), getClass().getSimpleName());
                            C2404a.m10430a("01000006", "1008", c0778b);
                        }
                        if (CommonApplication.m18732r() != null) {
                            String strM3112g6 = "";
                            if (c0778b != null) {
                                strM3112g6 = c0778b.m3112g();
                            }
                            this.f12036a.f11808v = C4859bx.m18375a(AbstractC4932a.m18733a(this.f12036a.f11788b).mo18740a(this.f12036a.getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(this.f12036a.getResources().getString(R.string.toast_network_unable), this.f12036a.getResources().getString(R.string.error_code_common), strM3112g6)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3282fp(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3281fo(this)), this.f12036a.getActivity(), strM3112g6).mo18745a();
                            this.f12036a.f11808v.show();
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
