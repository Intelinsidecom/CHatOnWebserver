package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.util.C3159aa;
import java.io.UnsupportedEncodingException;

/* compiled from: ActivitySyncSignInPopup.java */
/* renamed from: com.sec.chaton.registration.o */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2298o implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC2124ab f8604a;

    /* renamed from: b */
    final /* synthetic */ ActivitySyncSignInPopup f8605b;

    DialogInterfaceOnClickListenerC2298o(ActivitySyncSignInPopup activitySyncSignInPopup, EnumC2124ab enumC2124ab) {
        this.f8605b = activitySyncSignInPopup;
        this.f8604a = enumC2124ab;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws UnsupportedEncodingException {
        switch (this.f8604a) {
            case SA_access_token:
                this.f8605b.m8412d();
                this.f8605b.f8127p.m5616a(this.f8605b.f8096A, "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
                break;
            case mapping:
                this.f8605b.m8400a(this.f8605b.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8605b.f8136y, this.f8605b.f8137z);
                this.f8605b.f8127p.m5614a();
                break;
            case SA_user_info:
                this.f8605b.m8412d();
                this.f8605b.f8127p.m5619b(this.f8605b.f8097B, "fs24s8z0hh", this.f8605b.f8098C);
                break;
            case version_for_nation:
                this.f8605b.m8400a(this.f8605b.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8605b.f8136y, this.f8605b.f8137z);
                new C1324bj(this.f8605b.f8108M).m5694b();
                break;
            case get_chatlist:
                this.f8605b.m8400a(this.f8605b.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8605b.getResources().getString(R.string.multidevice_sync_chat_title), this.f8605b.f8137z);
                C3159aa.m10962a().m10982a("multidevice_chatlist_sync_last_call_time", Long.valueOf(System.currentTimeMillis()));
                this.f8605b.f8129r.m5375a();
                break;
            case get_buddies:
                this.f8605b.m8400a(this.f8605b.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8605b.getResources().getString(R.string.auto_regi_buddy_sync), this.f8605b.f8137z);
                this.f8605b.f8128q.m5717a();
                break;
            case extra_info:
                this.f8605b.m8400a(this.f8605b.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8605b.f8136y, this.f8605b.f8137z);
                this.f8605b.f8128q.m5723a("voip", 1, false);
                break;
            case upload_all_group:
                this.f8605b.m8412d();
                this.f8605b.m8407b(false);
                break;
        }
    }
}
