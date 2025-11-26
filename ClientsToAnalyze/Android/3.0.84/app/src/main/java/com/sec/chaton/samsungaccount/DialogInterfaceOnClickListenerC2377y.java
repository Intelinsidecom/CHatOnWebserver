package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.util.C3159aa;
import java.io.UnsupportedEncodingException;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.y */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2377y implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC2337az f8836a;

    /* renamed from: b */
    final /* synthetic */ MainActivity f8837b;

    DialogInterfaceOnClickListenerC2377y(MainActivity mainActivity, EnumC2337az enumC2337az) {
        this.f8837b = mainActivity;
        this.f8836a = enumC2337az;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws UnsupportedEncodingException {
        switch (this.f8836a) {
            case get_server_address:
                this.f8837b.m8803t();
                this.f8837b.f8717n.m5775a();
                break;
            case SA_access_token:
                this.f8837b.m8803t();
                this.f8837b.f8716m.m5616a(this.f8837b.f8724u, "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
                break;
            case auto_regi:
                this.f8837b.m8743a(this.f8837b.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8837b.f8650A, this.f8837b.f8651B);
                this.f8837b.f8716m.m5617b();
                break;
            case mapping:
                this.f8837b.m8743a(this.f8837b.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8837b.f8650A, this.f8837b.f8651B);
                this.f8837b.f8716m.m5614a();
                break;
            case SA_user_info:
                this.f8837b.m8803t();
                this.f8837b.f8716m.m5619b(this.f8837b.f8725v, "fs24s8z0hh", this.f8837b.f8692an);
                break;
            case version_for_upgrade:
                this.f8837b.m8803t();
                this.f8837b.f8720q.m5694b();
                break;
            case version_for_nation:
                this.f8837b.m8743a(this.f8837b.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8837b.f8650A, this.f8837b.f8651B);
                new C1324bj(this.f8837b.f8700av).m5694b();
                break;
            case get_chatlist:
                this.f8837b.m8743a(this.f8837b.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8837b.getResources().getString(R.string.multidevice_sync_chat_title), this.f8837b.f8651B);
                C3159aa.m10962a().m10982a("multidevice_chatlist_sync_last_call_time", Long.valueOf(System.currentTimeMillis()));
                this.f8837b.f8718o.m5375a();
                break;
            case get_buddies:
                this.f8837b.m8743a(this.f8837b.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8837b.getResources().getString(R.string.auto_regi_buddy_sync), this.f8837b.f8651B);
                this.f8837b.f8719p.m5717a();
                break;
            case extra_info:
                this.f8837b.m8743a(this.f8837b.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8837b.f8650A, this.f8837b.f8651B);
                this.f8837b.f8719p.m5723a("voip", 1, false);
                break;
            case chaton_v:
                this.f8837b.m8803t();
                this.f8837b.f8722s.m5710a(EnumC1172b.UI);
                break;
        }
    }
}
