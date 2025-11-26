package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p029b.C1416g;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bz */
/* loaded from: classes.dex */
class HandlerC0568bz extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2530a;

    HandlerC0568bz(BuddyFragment buddyFragment) {
        this.f2530a = buddyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        String str;
        C0267d c0267d = (C0267d) message.obj;
        if (message.what == 602) {
            if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                C1416g c1416g = new C1416g(this.f2530a.f1887r, this.f2530a.f1802an, 2, false);
                this.f2530a.f1805aq.m13054a(this.f2530a.f1802an.m3975b());
                this.f2530a.m3427a(this.f2530a.f1802an.m3975b(), this.f2530a.f1802an.m3976c());
                this.f2530a.m3428a(this.f2530a.f1802an.m3975b(), false, this.f2530a.f1802an.m3976c());
                if (this.f2530a.m3444i() > 0) {
                    if (this.f2530a.f1843bd != null && this.f2530a.f1845bf != null) {
                        this.f2530a.f1843bd.setVisibility(8);
                        this.f2530a.f1845bf.setVisibility(8);
                    }
                } else {
                    this.f2530a.m3447l();
                }
                C1379w.m6203a(new C1379w(), 2, c1416g);
                this.f2530a.m3216B();
                if (GlobalApplication.m6456e()) {
                    Intent intent = new Intent();
                    intent.putExtra(EmptyFragment.f2243c, EmptyFragment.f2241a);
                    ((TabActivity) this.f2530a.getActivity()).m1312a(R.id.fragment_buddy, intent, EmptyFragment.class);
                    this.f2530a.f1803ao.m4032a(-1, -1);
                }
            } else if (this.f2530a.getActivity() != null) {
                this.f2530a.m3264Z();
                C3641ai.m13211a(this.f2530a.getActivity(), this.f2530a.getResources().getString(R.string.buddy_list_block_toast_failed), 0).show();
            } else {
                return;
            }
        } else if (message.what == 303) {
            if (this.f2530a.getActivity() != null) {
                this.f2530a.m3240N();
                this.f2530a.m3264Z();
                if (c0267d.m11704n()) {
                    if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                        if (TextUtils.isEmpty(this.f2530a.f1850bk)) {
                            this.f2530a.m3283a((CharSequence) this.f2530a.getResources().getString(R.string.tellfriends_added));
                        } else {
                            this.f2530a.m3283a((CharSequence) this.f2530a.getResources().getString(R.string.add_buddy_added, this.f2530a.f1850bk));
                            this.f2530a.f1850bk = "";
                        }
                        this.f2530a.m3216B();
                    } else if (c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
                        if (TextUtils.isEmpty(this.f2530a.f1850bk)) {
                            str = String.format(this.f2530a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f2530a.f1802an.m3975b());
                        } else {
                            str = String.format(this.f2530a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f2530a.f1850bk);
                            this.f2530a.f1850bk = "";
                        }
                        AbstractC3271a.m11494a(this.f2530a.getActivity()).mo11500a(str).mo11510b(this.f2530a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).mo11512b();
                    } else {
                        C3250y.m11458g("ADD BUDDY RESULT : " + c0267d.m1355f(), BuddyFragment.f1724a);
                        if (c0267d.m1355f() == 16003) {
                            string = this.f2530a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                        } else if (c0267d.m1355f() == 16004) {
                            string = this.f2530a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                        } else if (c0267d.m1355f() == 16005) {
                            string = this.f2530a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                        } else {
                            string = this.f2530a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                        }
                        AbstractC3271a.m11494a(this.f2530a.getActivity()).mo11500a(string).mo11510b(this.f2530a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).mo11512b();
                    }
                } else {
                    AbstractC3271a.m11494a(this.f2530a.getActivity()).mo11500a(this.f2530a.getResources().getString(R.string.buddy_list_dialog_addbuddy_title)).mo11509b(this.f2530a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed)).mo11510b(this.f2530a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0570ca(this)).mo11501a(this.f2530a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                }
            } else {
                return;
            }
        } else if (message.what == 904) {
            if (this.f2530a.getActivity() != null) {
                C0267d c0267d2 = (C0267d) message.obj;
                if (c0267d2.m11704n() && c0267d2.m1351b() != EnumC1587o.ERROR) {
                    C3641ai.m13211a(this.f2530a.getActivity(), this.f2530a.getResources().getString(R.string.toast_save_media), 0).show();
                } else {
                    C3641ai.m13211a(this.f2530a.getActivity(), this.f2530a.getResources().getString(R.string.dev_network_error), 0).show();
                }
                this.f2530a.m3264Z();
            } else {
                return;
            }
        } else if (message.what == 318) {
            String strM3976c = this.f2530a.f1802an != null ? this.f2530a.f1802an.m3976c() : null;
            if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                C3641ai.m13211a(this.f2530a.getActivity(), this.f2530a.getResources().getString(R.string.livepartner_failed_to_unfollow, strM3976c), 0).show();
            } else {
                C3641ai.m13211a(this.f2530a.getActivity(), this.f2530a.getResources().getString(R.string.livepartner_no_longer_following, strM3976c), 0).show();
                C1357af.m6000d(CommonApplication.m11493l().getContentResolver(), this.f2530a.f1802an.m3975b());
                if (GlobalApplication.m6456e() && this.f2530a.f1829bP != null && this.f2530a.f1802an.m3975b().equals(this.f2530a.f1829bP)) {
                    ((TabActivity) this.f2530a.getActivity()).m1312a(R.id.fragment_buddy, new Intent(), Fragment.class);
                }
                this.f2530a.m3216B();
            }
            if (this.f2530a.getActivity() != null) {
                this.f2530a.m3264Z();
            } else {
                return;
            }
        }
        if (GlobalApplication.m6456e() && this.f2530a.f1791ac == 1) {
            if (this.f2530a.f1843bd.getVisibility() == 0 || this.f2530a.f1845bf.getVisibility() == 0) {
                this.f2530a.f1820bF.setVisibility(0);
            } else {
                this.f2530a.f1820bF.setVisibility(8);
            }
        }
    }
}
