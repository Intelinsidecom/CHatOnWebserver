package com.sec.chaton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.view.View;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C2716x;
import com.sec.chaton.msgsend.C2717y;
import com.sec.chaton.msgsend.EnumC2689ag;
import com.sec.chaton.p051c.C1428b;
import com.sec.chaton.p051c.C1433g;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p067j.C2417af;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.spp.push.Config;
import com.sec.widget.C5179v;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.j */
/* loaded from: classes.dex */
class ViewOnClickListenerC2409j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f8586a;

    ViewOnClickListenerC2409j(AdminMenu adminMenu) {
        this.f8586a = adminMenu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        switch (view.getId()) {
            case R.id.btn_log_on_off /* 2131165235 */:
                this.f8586a.f1892ac = C4904y.m18630a();
                if (this.f8586a.f1892ac > 0) {
                    C4904y.m18646e("Chat ON Log was disenabled...", getClass().getSimpleName());
                    C4904y.m18632a(0);
                    C5179v.m19811a(CommonApplication.m18732r(), "Log Off", 1).show();
                    this.f8586a.f1865B.setText("Log On");
                    break;
                } else {
                    C4904y.m18632a(1);
                    C5179v.m19811a(CommonApplication.m18732r(), "Log On", 1).show();
                    C4904y.m18646e("Chat ON Log was enabled...", getClass().getSimpleName());
                    this.f8586a.f1865B.setText("Log Off");
                    break;
                }
            case R.id.btn_push_status /* 2131165236 */:
                AbstractC4932a.m18733a(this.f8586a).mo18749b(C1428b.m7525a(this.f8586a)).mo18756d(android.R.string.ok, null).mo18752b();
                break;
            case R.id.btn_autoresend_turn_on_off /* 2131165237 */:
                if (C2717y.m11398b()) {
                    C2717y.m11401d();
                    this.f8586a.f1878O.setText("A-Resend:DISABLED");
                    C5179v.m19811a(this.f8586a.f1884U, "disable : AutoResend", 0).show();
                    break;
                } else {
                    C2717y.m11399c();
                    this.f8586a.f1878O.setText("A-Resend:ENABLED");
                    C5179v.m19811a(this.f8586a.f1884U, "enable : AutoResend", 0).show();
                    break;
                }
            case R.id.dump_database /* 2131165239 */:
                this.f8586a.f1885V = new ProgressDialog(this.f8586a.f1884U);
                this.f8586a.f1885V.setMessage("Backup chaton database");
                this.f8586a.f1885V.setCancelable(false);
                this.f8586a.f1885V.show();
                C3320s c3320s = new C3320s(this.f8586a);
                this.f8586a.f1886W = true;
                c3320s.start();
                break;
            case R.id.timeOutValueSet /* 2131165246 */:
                C1433g.m7527a(this.f8586a.f1914y.getText().toString(), Integer.valueOf(Integer.parseInt(this.f8586a.f1906q.getText().toString())), Integer.valueOf(Integer.parseInt(this.f8586a.f1907r.getText().toString())), Integer.valueOf(Integer.parseInt(this.f8586a.f1908s.getText().toString())), Integer.valueOf(Integer.parseInt(this.f8586a.f1909t.getText().toString())));
                C2417af.m10456c();
                break;
            case R.id.timeOutValueReset /* 2131165247 */:
                this.f8586a.f1906q.setText(Spam.ACTIVITY_CANCEL);
                this.f8586a.f1907r.setText(Spam.ACTIVITY_CANCEL);
                this.f8586a.f1908s.setText(Spam.ACTIVITY_CANCEL);
                this.f8586a.f1909t.setText(Spam.ACTIVITY_CANCEL);
                C1433g.m7526a();
                break;
            case R.id.applyhanzitopinyin /* 2131165248 */:
                try {
                    C2190d.m9834d(GlobalApplication.m18732r().getContentResolver());
                } catch (OperationApplicationException e) {
                    e.printStackTrace();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    C2190d.m9834d(GlobalApplication.m18732r().getContentResolver());
                } catch (OperationApplicationException e3) {
                    e3.printStackTrace();
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
                C4904y.m18641c("hanzitopinyin hidden mode interval : " + (System.currentTimeMillis() - jCurrentTimeMillis), Config.CHATON_PACKAGE_NAME);
                break;
            case R.id.resethanzitopinyin /* 2131165249 */:
                new C2128i(null).m9513b(false);
                break;
            case R.id.btn_make_dummy_groupchatroom100 /* 2131165250 */:
                if (this.f8586a.f1894ae.size() > 0) {
                    this.f8586a.f1894ae.clear();
                }
                this.f8586a.f1896ag = 0;
                this.f8586a.m2855k();
                this.f8586a.m2859m();
                this.f8586a.f1897ah = 100;
                this.f8586a.f1885V = new ProgressDialog(this.f8586a.f1884U);
                this.f8586a.f1885V.setMessage("Make Dummy ChatRoom ...");
                this.f8586a.f1885V.setCancelable(false);
                this.f8586a.f1885V.show();
                C3129r c3129r = new C3129r(this.f8586a);
                this.f8586a.f1886W = true;
                c3129r.start();
                break;
            case R.id.btn_make_dummy_groupchatroom200 /* 2131165251 */:
                if (this.f8586a.f1894ae.size() > 0) {
                    this.f8586a.f1894ae.clear();
                }
                this.f8586a.f1896ag = 0;
                this.f8586a.m2855k();
                this.f8586a.m2859m();
                this.f8586a.f1897ah = 200;
                this.f8586a.f1885V = new ProgressDialog(this.f8586a.f1884U);
                this.f8586a.f1885V.setMessage("Make Dummy ChatRoom ...");
                this.f8586a.f1885V.setCancelable(false);
                this.f8586a.f1885V.show();
                C3129r c3129r2 = new C3129r(this.f8586a);
                this.f8586a.f1886W = true;
                c3129r2.start();
                break;
            case R.id.btn_autoresend_enable_notification /* 2131165252 */:
                if (C2717y.m11406i()) {
                    C2717y.m11397b(false);
                    this.f8586a.f1879P.setText("A-Resend:Noti disabled");
                    C5179v.m19811a(this.f8586a.f1884U, "disable : Noti ", 0).show();
                    break;
                } else {
                    C2717y.m11397b(true);
                    this.f8586a.f1879P.setText("A-Resend:Noti enabled");
                    C5179v.m19811a(this.f8586a.f1884U, "enable : Noti", 0).show();
                    break;
                }
            case R.id.btn_autoresend_dump_log_current /* 2131165253 */:
                C2716x.m11387b();
                break;
            case R.id.btn_autoresend_loaddb /* 2131165254 */:
                C2716x.m11369a();
                break;
            case R.id.btn_autoresend_do_send /* 2131165255 */:
                C2716x.m11375a(EnumC2689ag.REASON_MANUAL_REQUESTED);
                break;
            case R.id.btn_autoresend_clearmsg /* 2131165256 */:
                C2716x.m11389c();
                break;
            case R.id.btn_random_imei /* 2131165257 */:
                C4822an.m18211a(this.f8586a.f1884U);
                C5179v.m19811a(this.f8586a.f1884U, "Random device id is generated.", 1).show();
                break;
            case R.id.btn_change_GLD /* 2131165258 */:
                C4809aa.m18105a("admin_dev_gld", (Boolean) true);
                C5179v.m19811a(this.f8586a.f1884U, "GLD server change to DEV sever", 0).show();
                break;
            case R.id.btn_skip /* 2131165259 */:
                this.f8586a.setResult(3, new Intent());
                C4809aa.m18104a().m18125b("hidden_skip_mode", (Boolean) true);
                this.f8586a.finish();
                break;
            case R.id.chaton_upgrade /* 2131165260 */:
                int iIntValue = C4809aa.m18104a().m18120a("admin_upgrade", (Integer) 0).intValue();
                int i = iIntValue != 2 ? iIntValue + 1 : 0;
                if (C4904y.f17872b) {
                    C4904y.m18639b("Current upgrade : " + iIntValue + " to " + i, "AdminMenu");
                }
                switch (i) {
                    case 0:
                        this.f8586a.f1871H.setText("upgrade : disable");
                        break;
                    case 1:
                        this.f8586a.f1871H.setText("upgrade : normal");
                        break;
                    case 2:
                        this.f8586a.f1871H.setText("upgrade : critical");
                        break;
                }
                C4809aa.m18106a("admin_upgrade", Integer.valueOf(i));
                break;
            case R.id.chaton_notice /* 2131165261 */:
                if (C4809aa.m18104a().m18119a("admin_notice", (Boolean) false).booleanValue()) {
                    C4809aa.m18105a("admin_notice", (Boolean) false);
                    this.f8586a.f1872I.setText("notice : disable");
                    break;
                } else {
                    C4809aa.m18105a("admin_notice", (Boolean) true);
                    this.f8586a.f1872I.setText("notice : enable");
                    break;
                }
            case R.id.chaton_disclaimer /* 2131165262 */:
                if (C4809aa.m18104a().m18119a("admin_disclaimer", (Boolean) false).booleanValue()) {
                    C4809aa.m18105a("admin_disclaimer", (Boolean) false);
                    this.f8586a.f1873J.setText("disclaimer : disable");
                    break;
                } else {
                    C4809aa.m18105a("admin_disclaimer", (Boolean) true);
                    this.f8586a.f1873J.setText("disclaimer : enable");
                    break;
                }
            case R.id.deregiSPP /* 2131165263 */:
                this.f8586a.f1900ak = ProgressDialogC4926s.m18727a(this.f8586a, null, this.f8586a.getResources().getString(R.string.wait_sending));
                this.f8586a.f1900ak.setCancelable(false);
                this.f8586a.f1899aj.mo9079b(this.f8586a.f1905o);
                this.f8586a.f1905o.m18262a(30000);
                break;
            case R.id.changeSAid /* 2131165264 */:
                this.f8586a.m2861n();
                break;
            case R.id.changeSMSFeature /* 2131165265 */:
                if (this.f8586a.f1901al) {
                    C2349a.m10303b();
                    this.f8586a.f1877N.setText("Change SMS feature : false");
                    break;
                } else {
                    C2349a.m10305c();
                    this.f8586a.f1877N.setText("Change SMS feature : true");
                    break;
                }
            case R.id.set_mcc /* 2131165266 */:
                this.f8586a.m2863o();
                break;
        }
    }
}
