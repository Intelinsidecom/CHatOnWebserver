package com.sec.chaton.registration;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1335m;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.SkipSMSVerifyServer;
import com.sec.chaton.p037j.C1596x;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import java.io.UnsupportedEncodingException;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.es */
/* loaded from: classes.dex */
class HandlerC2249es extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentRegistPushName f8544a;

    HandlerC2249es(FragmentRegistPushName fragmentRegistPushName) {
        this.f8544a = fragmentRegistPushName;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws UnsupportedEncodingException {
        if (this.f8544a.getActivity() != null) {
            C0267d c0267d = (C0267d) message.obj;
            switch (message.what) {
                case 201:
                    if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                        this.f8544a.f8325m.m5721a(RtspHeaders.Values.APPEND);
                        break;
                    } else if (c0267d.m1355f() == 12007) {
                        this.f8544a.m8622d();
                        FragmentNonSelfSMS.m8534a(this.f8544a.f8314b, true);
                        this.f8544a.getActivity().setResult(6, new Intent());
                        break;
                    } else if (c0267d.m1355f() == 12008) {
                        this.f8544a.m8622d();
                        FragmentNonSelfSMS.m8540b(this.f8544a.f8314b, true);
                        this.f8544a.getActivity().setResult(6, new Intent());
                        break;
                    } else {
                        this.f8544a.m8622d();
                        if (this.f8544a.getActivity() != null) {
                            this.f8544a.f8334v = AbstractC3271a.m11494a(this.f8544a.getActivity()).mo11500a(this.f8544a.getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(this.f8544a.getResources().getString(R.string.toast_network_unable), this.f8544a.getResources().getString(R.string.toast_error), c0267d.m1356g())).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2251eu(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2265fh(this)).mo11512b();
                            C3250y.m11442a("[Dev]Registration Failed. httpStatus: " + c0267d.m1358i() + ", FaultCode: " + c0267d.m1355f() + ", Message: " + c0267d.m1357h(), getClass().getSimpleName());
                            break;
                        }
                    }
                    break;
                case 204:
                case 2001:
                    if ((c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) || c0267d.m1355f() == 50007) {
                        if (this.f8544a.getActivity() != null) {
                            SkipSMSVerifyServer skipSMSVerifyServer = (SkipSMSVerifyServer) c0267d.m1354e();
                            if (TextUtils.isEmpty(skipSMSVerifyServer.uid) || TextUtils.isEmpty(skipSMSVerifyServer.chatonid)) {
                                if (C3250y.f11736d) {
                                    C3250y.m11455d("uid or chatonid is null " + c0267d.m1358i() + ", FaultCode: " + c0267d.m1355f() + ", Message: " + c0267d.m1357h(), getClass().getSimpleName());
                                }
                                this.f8544a.m8622d();
                                this.f8544a.f8334v = AbstractC3271a.m11494a(this.f8544a.getActivity()).mo11500a(this.f8544a.getResources().getString(R.string.toast_error)).mo11509b(this.f8544a.getResources().getString(R.string.registration_fail_pop_up)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2252ev(this)).mo11512b();
                                break;
                            } else if (message.what == 2001) {
                                this.f8544a.f8330r = 0;
                                this.f8544a.m8623e();
                                this.f8544a.f8333u = C3159aa.m10962a().m10979a("temp_account_country_code", "");
                                C3159aa.m10963a("did_samsung_account_mapping", (Boolean) true);
                                if (C3250y.f11734b) {
                                    C3250y.m11450b("Final contact sync ISO : " + this.f8544a.f8333u, getClass().getSimpleName());
                                }
                                C3159aa.m10966a("account_country_code", this.f8544a.f8333u);
                                if (C3214cb.m11256a(this.f8544a.f8314b)) {
                                    this.f8544a.m8613a(this.f8544a.getActivity().getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8544a.getResources().getString(R.string.auto_regi_initializing_voice_and_video), this.f8544a.f8329q);
                                    if (this.f8544a.f8332t != null) {
                                        if (C3214cb.m11245a(this.f8544a.f8314b, this.f8544a.f8332t) != 0) {
                                            this.f8544a.m8612a(this.f8544a.getResources().getString(R.string.auto_regi_buddy_sync));
                                            this.f8544a.f8325m.m5717a();
                                            break;
                                        }
                                    } else {
                                        this.f8544a.m8612a(this.f8544a.getResources().getString(R.string.auto_regi_buddy_sync));
                                        this.f8544a.f8325m.m5717a();
                                        break;
                                    }
                                } else {
                                    this.f8544a.m8612a(this.f8544a.getResources().getString(R.string.auto_regi_buddy_sync));
                                    this.f8544a.f8325m.m5717a();
                                    break;
                                }
                            } else if (message.what == 204) {
                                this.f8544a.m8622d();
                                this.f8544a.getActivity().setResult(-1, new Intent());
                                this.f8544a.getActivity().finish();
                                break;
                            }
                        }
                    } else if (c0267d.m1355f() == 50006) {
                        if (C3250y.f11734b) {
                            C3250y.m11450b("SSO token validaion was finished", getClass().getSimpleName());
                        }
                        String strM11257b = C3214cb.m11257b(this.f8544a.f8314b);
                        if (!this.f8544a.m8626f() || TextUtils.isEmpty(strM11257b) || this.f8544a.f8330r >= 2) {
                            if (this.f8544a.f8330r >= 2) {
                                this.f8544a.f8330r = 0;
                            }
                            this.f8544a.m8622d();
                            C3159aa.m10962a().m10981a("samsung_account_email");
                            this.f8544a.f8334v = AbstractC3271a.m11494a(this.f8544a.f8314b).mo11500a(this.f8544a.getResources().getString(R.string.toast_error)).mo11509b(this.f8544a.getResources().getString(R.string.samsung_account_try_later)).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2253ew(this)).mo11512b();
                            break;
                        } else {
                            FragmentRegistPushName.m8640t(this.f8544a);
                            String packageName = this.f8544a.f8314b.getPackageName();
                            Intent intent = new Intent("com.msc.action.ACCESSTOKEN_V02_REQUEST");
                            intent.putExtra("client_id", "fs24s8z0hh");
                            intent.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
                            intent.putExtra("mypackage", packageName);
                            intent.putExtra("OSP_VER", "OSP_02");
                            intent.putExtra("MODE", "BACKGROUND");
                            intent.putExtra("additional", new String[]{"user_id", "email_id", "mcc", "api_server_url"});
                            intent.putExtra("expired_access_token", C3159aa.m10962a().m10979a("samsung_account_token", ""));
                            this.f8544a.f8314b.sendBroadcast(intent);
                            if (C3250y.f11734b) {
                                C3250y.m11450b("retryCount : " + this.f8544a.f8330r, getClass().getSimpleName());
                                break;
                            }
                        }
                    } else if (c0267d.m1355f() == 50004) {
                        this.f8544a.m8622d();
                        C3250y.m11450b("device over max of limitation", getClass().getSimpleName());
                        this.f8544a.f8334v = AbstractC3271a.m11494a(this.f8544a.f8314b).mo11500a(this.f8544a.getResources().getString(R.string.toast_error)).mo11509b(this.f8544a.getActivity().getResources().getString(R.string.account_max_device_alert3, 5)).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2254ex(this)).mo11512b();
                        break;
                    } else if (c0267d.m1355f() == 12007) {
                        this.f8544a.m8622d();
                        FragmentNonSelfSMS.m8534a(this.f8544a.f8314b, true);
                        this.f8544a.getActivity().setResult(6, new Intent());
                        break;
                    } else if (c0267d.m1355f() == 12008) {
                        this.f8544a.m8622d();
                        FragmentNonSelfSMS.m8540b(this.f8544a.f8314b, true);
                        this.f8544a.getActivity().setResult(6, new Intent());
                        break;
                    } else {
                        this.f8544a.m8622d();
                        if (this.f8544a.getActivity() != null) {
                            this.f8544a.f8334v = AbstractC3271a.m11494a(this.f8544a.getActivity()).mo11500a(this.f8544a.getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(this.f8544a.getResources().getString(R.string.toast_network_unable), this.f8544a.getResources().getString(R.string.toast_error), c0267d.m1356g())).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2256ez(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2255ey(this)).mo11512b();
                            C3250y.m11442a("[Dev]Registration Failed. httpStatus: " + c0267d.m1358i() + ", FaultCode: " + c0267d.m1355f() + ", Message: " + c0267d.m1357h(), getClass().getSimpleName());
                            break;
                        }
                    }
                    break;
                case 301:
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        this.f8544a.m8622d();
                        C3250y.m11450b("fail to get all buddies", getClass().getSimpleName());
                        if (CommonApplication.m11493l() != null) {
                            this.f8544a.f8334v = AbstractC3271a.m11494a(this.f8544a.f8314b).mo11500a(this.f8544a.getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(this.f8544a.getResources().getString(R.string.toast_network_unable), this.f8544a.getResources().getString(R.string.toast_error), c0267d.m1356g())).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2260fc(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2259fb(this)).mo11512b();
                            break;
                        }
                    } else if (this.f8544a.f8327o.equals("phone")) {
                        this.f8544a.m8622d();
                        this.f8544a.getActivity().setResult(-1, new Intent());
                        this.f8544a.getActivity().finish();
                        break;
                    } else {
                        if (this.f8544a.getActivity() != null) {
                            this.f8544a.m8612a(this.f8544a.getActivity().getResources().getString(R.string.multidevice_sync_chat_title));
                        }
                        this.f8544a.f8324l.m5375a();
                        break;
                    }
                    break;
                case HttpResponseCode.FOUND /* 302 */:
                    if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                        this.f8544a.f8325m.m5717a();
                        break;
                    } else if (c0267d.m1351b() == EnumC1587o.NO_REQUEST) {
                        this.f8544a.f8325m.m5717a();
                        break;
                    } else {
                        this.f8544a.m8622d();
                        if (this.f8544a.getActivity() != null) {
                            this.f8544a.f8334v = AbstractC3271a.m11494a(this.f8544a.getActivity()).mo11500a(this.f8544a.getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(this.f8544a.getResources().getString(R.string.toast_network_unable), this.f8544a.getResources().getString(R.string.toast_error), c0267d.m1356g())).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2262fe(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2261fd(this)).mo11512b();
                            break;
                        }
                    }
                    break;
                case 305:
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        this.f8544a.m8622d();
                        C3250y.m11450b("fail to set extra info", getClass().getSimpleName());
                        if (GlobalApplication.m11493l() != null) {
                            this.f8544a.f8334v = AbstractC3271a.m11494a(this.f8544a.f8314b).mo11500a(this.f8544a.getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(this.f8544a.getResources().getString(R.string.toast_network_unable), this.f8544a.getResources().getString(R.string.toast_error), c0267d.m1356g())).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2258fa(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2250et(this)).mo11512b();
                            break;
                        }
                    } else {
                        this.f8544a.m8612a(this.f8544a.getResources().getString(R.string.auto_regi_buddy_sync));
                        this.f8544a.f8325m.m5717a();
                        break;
                    }
                    break;
                case 2301:
                    this.f8544a.m8622d();
                    if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                        this.f8544a.getActivity().setResult(-1, new Intent());
                        this.f8544a.getActivity().finish();
                        C1596x.m6758c();
                        C1335m.m5781a((Handler) null);
                        break;
                    } else {
                        if (C3250y.f11733a) {
                            C3250y.m11456e("Fail to sync ChatListInfo ... ", getClass().getSimpleName());
                            C3250y.m11456e("ChatListInfo Fail code : " + c0267d.m1351b() + ", message : " + c0267d.m1357h(), getClass().getSimpleName());
                            if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                                C1533b.m6522a("01000006", "1008", c0267d);
                            }
                        }
                        if (CommonApplication.m11493l() != null) {
                            this.f8544a.f8334v = AbstractC3271a.m11494a(this.f8544a.f8314b).mo11500a(this.f8544a.getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(this.f8544a.getResources().getString(R.string.toast_network_unable), this.f8544a.getResources().getString(R.string.toast_error), c0267d.m1356g())).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2264fg(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2263ff(this)).mo11512b();
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
