package com.sec.chaton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.view.View;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C1756p;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.msgsend.EnumC1764x;
import com.sec.chaton.p020c.C0817b;
import com.sec.chaton.p020c.C0822g;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p037j.C1596x;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC0452b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f1520a;

    ViewOnClickListenerC0452b(AdminMenu adminMenu) {
        this.f1520a = adminMenu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        switch (view.getId()) {
            case R.id.btn_log_on_off /* 2131165235 */:
                this.f1520a.f637J = C3250y.m11447b();
                if (this.f1520a.f637J > 0) {
                    C3250y.m11456e("Chat ON Log was disenabled...", getClass().getSimpleName());
                    C3250y.m11448b(0);
                    C3641ai.m13211a(CommonApplication.m11493l(), "Log Off", 1).show();
                    this.f1520a.f657n.setText("Log On");
                    break;
                } else {
                    C3250y.m11448b(1);
                    C3641ai.m13211a(CommonApplication.m11493l(), "Log On", 1).show();
                    C3250y.m11456e("Chat ON Log was enabled...", getClass().getSimpleName());
                    this.f1520a.f657n.setText("Log Off");
                    break;
                }
            case R.id.btn_push_status /* 2131165236 */:
                AbstractC3271a.m11494a(this.f1520a).mo11509b(C0817b.m4370a(this.f1520a)).mo11515d(android.R.string.ok, null).mo11512b();
                break;
            case R.id.btn_autoresend_turn_on_off /* 2131165237 */:
                if (C1757q.m7251b()) {
                    C1757q.m7254d();
                    this.f1520a.f666w.setText("A-Resend:DISABLED");
                    C3641ai.m13211a(this.f1520a.f630C, "disable : AutoResend", 0).show();
                    break;
                } else {
                    C1757q.m7253c();
                    this.f1520a.f666w.setText("A-Resend:ENABLED");
                    C3641ai.m13211a(this.f1520a.f630C, "enable : AutoResend", 0).show();
                    break;
                }
            case R.id.dump_database /* 2131165239 */:
                this.f1520a.f631D = new ProgressDialog(this.f1520a.f630C);
                this.f1520a.f631D.setMessage("Backup chaton database");
                this.f1520a.f631D.setCancelable(false);
                this.f1520a.f631D.show();
                C1539j c1539j = new C1539j(this.f1520a);
                this.f1520a.f632E = true;
                c1539j.start();
                break;
            case R.id.timeOutValueSet /* 2131165246 */:
                C0822g.m4372a(this.f1520a.f654k.getText().toString(), Integer.valueOf(Integer.parseInt(this.f1520a.f646c.getText().toString())), Integer.valueOf(Integer.parseInt(this.f1520a.f647d.getText().toString())), Integer.valueOf(Integer.parseInt(this.f1520a.f648e.getText().toString())), Integer.valueOf(Integer.parseInt(this.f1520a.f649f.getText().toString())));
                C1596x.m6758c();
                break;
            case R.id.timeOutValueReset /* 2131165247 */:
                this.f1520a.f646c.setText("0");
                this.f1520a.f647d.setText("0");
                this.f1520a.f648e.setText("0");
                this.f1520a.f649f.setText("0");
                C0822g.m4371a();
                break;
            case R.id.applyhanzitopinyin /* 2131165248 */:
                try {
                    C1360d.m6048d(GlobalApplication.m11493l().getContentResolver());
                } catch (OperationApplicationException e) {
                    e.printStackTrace();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    C1360d.m6048d(GlobalApplication.m11493l().getContentResolver());
                } catch (OperationApplicationException e3) {
                    e3.printStackTrace();
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
                C3250y.m11453c("hanzitopinyin hidden mode interval : " + (System.currentTimeMillis() - jCurrentTimeMillis), "com.sec.chaton");
                break;
            case R.id.resethanzitopinyin /* 2131165249 */:
                new C1330h(null).m5735b(false);
                break;
            case R.id.btn_make_dummy_groupchatroom100 /* 2131165250 */:
                if (this.f1520a.f639L.size() > 0) {
                    this.f1520a.f639L.clear();
                }
                this.f1520a.f641N = 0;
                this.f1520a.m1108f();
                this.f1520a.m1112h();
                this.f1520a.f642O = 100;
                this.f1520a.f631D = new ProgressDialog(this.f1520a.f630C);
                this.f1520a.f631D.setMessage("Make Dummy ChatRoom ...");
                this.f1520a.f631D.setCancelable(false);
                this.f1520a.f631D.show();
                C1531i c1531i = new C1531i(this.f1520a);
                this.f1520a.f632E = true;
                c1531i.start();
                break;
            case R.id.btn_make_dummy_groupchatroom200 /* 2131165251 */:
                if (this.f1520a.f639L.size() > 0) {
                    this.f1520a.f639L.clear();
                }
                this.f1520a.f641N = 0;
                this.f1520a.m1108f();
                this.f1520a.m1112h();
                this.f1520a.f642O = HttpResponseCode.f13733OK;
                this.f1520a.f631D = new ProgressDialog(this.f1520a.f630C);
                this.f1520a.f631D.setMessage("Make Dummy ChatRoom ...");
                this.f1520a.f631D.setCancelable(false);
                this.f1520a.f631D.show();
                C1531i c1531i2 = new C1531i(this.f1520a);
                this.f1520a.f632E = true;
                c1531i2.start();
                break;
            case R.id.btn_autoresend_enable_notification /* 2131165252 */:
                if (C1757q.m7257g()) {
                    C1757q.m7250a(false);
                    this.f1520a.f667x.setText("A-Resend:Noti disabled");
                    C3641ai.m13211a(this.f1520a.f630C, "disable : Noti ", 0).show();
                    break;
                } else {
                    C1757q.m7250a(true);
                    this.f1520a.f667x.setText("A-Resend:Noti enabled");
                    C3641ai.m13211a(this.f1520a.f630C, "enable : Noti", 0).show();
                    break;
                }
            case R.id.btn_autoresend_dump_log_current /* 2131165253 */:
                C1756p.m7242b();
                break;
            case R.id.btn_autoresend_loaddb /* 2131165254 */:
                C1756p.m7225a();
                break;
            case R.id.btn_autoresend_do_send /* 2131165255 */:
                C1756p.m7229a(EnumC1764x.REASON_MANUAL_REQUESTED);
                break;
            case R.id.btn_autoresend_clearmsg /* 2131165256 */:
                C1756p.m7244c();
                break;
            case R.id.btn_random_imei /* 2131165257 */:
                C3171am.m11047a(this.f1520a.f630C);
                C3641ai.m13211a(this.f1520a.f630C, "Random device id is generated.", 1).show();
                break;
            case R.id.btn_change_GLD /* 2131165258 */:
                C3159aa.m10963a("admin_dev_gld", (Boolean) true);
                C3641ai.m13211a(this.f1520a.f630C, "GLD server change to DEV sever", 0).show();
                break;
            case R.id.btn_skip /* 2131165259 */:
                this.f1520a.setResult(3, new Intent());
                C3159aa.m10962a().m10983b("hidden_skip_mode", (Boolean) true);
                this.f1520a.finish();
                break;
            case R.id.chaton_upgrade /* 2131165260 */:
                int iIntValue = C3159aa.m10962a().m10978a("admin_upgrade", (Integer) 0).intValue();
                int i = iIntValue != 2 ? iIntValue + 1 : 0;
                if (C3250y.f11734b) {
                    C3250y.m11450b("Current upgrade : " + iIntValue + " to " + i, "AdminMenu");
                }
                switch (i) {
                    case 0:
                        this.f1520a.f663t.setText("upgrade : disable");
                        break;
                    case 1:
                        this.f1520a.f663t.setText("upgrade : normal");
                        break;
                    case 2:
                        this.f1520a.f663t.setText("upgrade : critical");
                        break;
                }
                C3159aa.m10964a("admin_upgrade", Integer.valueOf(i));
                break;
            case R.id.chaton_notice /* 2131165261 */:
                if (C3159aa.m10962a().m10977a("admin_notice", (Boolean) false).booleanValue()) {
                    C3159aa.m10963a("admin_notice", (Boolean) false);
                    this.f1520a.f664u.setText("notice : disable");
                    break;
                } else {
                    C3159aa.m10963a("admin_notice", (Boolean) true);
                    this.f1520a.f664u.setText("notice : enable");
                    break;
                }
            case R.id.chaton_disclaimer /* 2131165262 */:
                if (C3159aa.m10962a().m10977a("admin_disclaimer", (Boolean) false).booleanValue()) {
                    C3159aa.m10963a("admin_disclaimer", (Boolean) false);
                    this.f1520a.f665v.setText("disclaimer : disable");
                    break;
                } else {
                    C3159aa.m10963a("admin_disclaimer", (Boolean) true);
                    this.f1520a.f665v.setText("disclaimer : enable");
                    break;
                }
        }
    }
}
