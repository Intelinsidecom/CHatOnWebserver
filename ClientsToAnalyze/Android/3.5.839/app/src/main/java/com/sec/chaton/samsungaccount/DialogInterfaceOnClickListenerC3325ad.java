package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2122ca;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.util.C4809aa;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.ad */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3325ad implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC3328ag f12244a;

    /* renamed from: b */
    final /* synthetic */ AbstractMultiDeviceActivity f12245b;

    DialogInterfaceOnClickListenerC3325ad(AbstractMultiDeviceActivity abstractMultiDeviceActivity, EnumC3328ag enumC3328ag) {
        this.f12245b = abstractMultiDeviceActivity;
        this.f12244a = enumC3328ag;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Throwable {
        switch (this.f12244a) {
            case get_server_address:
                this.f12245b.m13147p();
                this.f12245b.f12120L.m9552a();
                break;
            case SA_access_token:
                this.f12245b.m13147p();
                this.f12245b.f12119K.m9389a(this.f12245b.f12127S, "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
                break;
            case auto_regi:
                this.f12245b.m13086a(this.f12245b.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12245b.f12130V, this.f12245b.f12131W);
                this.f12245b.f12119K.m9390b();
                break;
            case mapping:
                this.f12245b.m13086a(this.f12245b.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12245b.f12130V, this.f12245b.f12131W);
                this.f12245b.f12119K.m9387a();
                break;
            case SA_user_info:
                this.f12245b.m13147p();
                this.f12245b.f12119K.m9392b(this.f12245b.f12128T, "fs24s8z0hh", this.f12245b.f12144aj);
                break;
            case version_for_upgrade:
                this.f12245b.m13147p();
                this.f12245b.f12123O.m9471b();
                break;
            case version_for_nation:
                this.f12245b.m13086a(this.f12245b.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12245b.f12130V, this.f12245b.f12131W);
                new C2122ca(this.f12245b.f12153as).m9471b();
                break;
            case get_chatlist:
                this.f12245b.m13086a(this.f12245b.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12245b.getResources().getString(R.string.multidevice_sync_chat_title), this.f12245b.f12131W);
                C4809aa.m18104a().m18124a("multidevice_chatlist_sync_last_call_time", Long.valueOf(System.currentTimeMillis()));
                this.f12245b.f12121M.m8728a();
                break;
            case get_buddies:
                this.f12245b.m13086a(this.f12245b.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12245b.getResources().getString(R.string.auto_regi_buddy_sync), this.f12245b.f12131W);
                this.f12245b.f12122N.m9495a();
                break;
            case extra_info:
                this.f12245b.m13086a(this.f12245b.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12245b.f12130V, this.f12245b.f12131W);
                this.f12245b.f12122N.m9499a("voip", 1, false);
                break;
            case chaton_v:
                this.f12245b.m13147p();
                this.f12245b.f12125Q.m9483a(EnumC2463n.UI);
                break;
            case get_profile_all:
                this.f12245b.m13086a(this.f12245b.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12245b.f12130V, this.f12245b.f12131W);
                this.f12245b.f12148an.m9312c(null);
                break;
            case check_notification:
                this.f12245b.m13086a(this.f12245b.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12245b.getResources().getString(R.string.auto_regi_buddy_sync), this.f12245b.f12131W);
                this.f12245b.f12126R.m9283a();
                break;
        }
    }
}
