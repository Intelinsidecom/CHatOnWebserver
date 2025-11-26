package com.sec.chaton.settings;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.AvaliableApps;
import com.sec.chaton.p028io.entry.GetVersion;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: AboutFragment.java */
/* renamed from: com.sec.chaton.settings.c */
/* loaded from: classes.dex */
class HandlerC1275c extends Handler {

    /* renamed from: a */
    final /* synthetic */ AboutFragment f4822a;

    HandlerC1275c(AboutFragment aboutFragment) {
        this.f4822a = aboutFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f4822a.getActivity() != null) {
            this.f4822a.f4453k.dismiss();
        }
        C0101b c0101b = (C0101b) message.obj;
        switch (message.what) {
            case 1101:
                if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                    GetVersion getVersion = (GetVersion) c0101b.m671d();
                    this.f4822a.f4444b = getVersion.newversion;
                    this.f4822a.f4445c = getVersion.critical;
                    this.f4822a.f4446d = getVersion.uptodate;
                    this.f4822a.f4447e = getVersion.downloadurl;
                    C1786r.m6066e("str_current_version : " + this.f4822a.f4443a + ",   :str_upgrade_version : " + this.f4822a.f4444b + "  :critical :" + this.f4822a.f4445c + "  :update :" + this.f4822a.f4446d + "  :downloadurl :" + this.f4822a.f4447e, getClass().getSimpleName());
                    this.f4822a.f4451i.setOnClickListener(new ViewOnClickListenerC1302d(this));
                    if (this.f4822a.f4444b != null && !this.f4822a.f4443a.equals(this.f4822a.f4444b)) {
                        this.f4822a.f4450h.setVisibility(0);
                        this.f4822a.f4451i.setVisibility(0);
                        if (this.f4822a.f4445c.booleanValue()) {
                            this.f4822a.f4450h.setTextColor(-65536);
                            this.f4822a.f4450h.setText(this.f4822a.getString(R.string.setting_about_latest_ver) + " " + this.f4822a.f4444b + " (Critical)");
                            break;
                        } else {
                            this.f4822a.f4450h.setTextColor(-1);
                            this.f4822a.f4450h.setText(this.f4822a.getString(R.string.setting_about_latest_ver) + " " + this.f4822a.f4444b);
                            break;
                        }
                    }
                } else {
                    Toast.makeText(this.f4822a.getActivity(), "[Dev]Get  Version Failed", 0).show();
                    break;
                }
                break;
            case 1107:
                AvaliableApps avaliableApps = (AvaliableApps) c0101b.m671d();
                if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR && avaliableApps.resultCode.equals("2")) {
                    String string = C1789u.m6075a().getString("SamsungappsUrl", "");
                    if (this.f4822a.getActivity() != null && string != null) {
                        string = string.replace("com.sec.chaton", this.f4822a.getActivity().getPackageName());
                    }
                    Intent intent = new Intent("android.intent.action.VIEW");
                    Uri uri = Uri.parse(string);
                    intent.addFlags(335544352);
                    intent.setData(uri);
                    try {
                        this.f4822a.startActivity(intent);
                        C1786r.m6061b("apps market was installed in the device", "ActivityAbout");
                        break;
                    } catch (ActivityNotFoundException e) {
                        e.printStackTrace();
                        return;
                    } catch (Exception e2) {
                        return;
                    }
                } else if (!AboutFragment.m4476a((Context) this.f4822a.getActivity(), false)) {
                    this.f4822a.getActivity().finish();
                    break;
                }
                break;
        }
    }
}
