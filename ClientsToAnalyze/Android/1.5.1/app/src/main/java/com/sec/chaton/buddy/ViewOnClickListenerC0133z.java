package com.sec.chaton.buddy;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.control.BlockControl;
import com.sec.chaton.control.ContactControl;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.memo.WriteMemoActivity;
import com.sec.chaton.network.NetState;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.buddy.z */
/* loaded from: classes.dex */
class ViewOnClickListenerC0133z implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f719a;

    ViewOnClickListenerC0133z(BuddyProfileActivity buddyProfileActivity) {
        this.f719a = buddyProfileActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.profile_chat /* 2131427549 */:
                view.setClickable(false);
                view.setEnabled(false);
                Intent intent = new Intent(this.f719a.f584i, (Class<?>) HomeActivity.class);
                intent.setFlags(67108864);
                intent.putExtra("callChatList", true);
                intent.putExtra("chatType", ChatONContract.InBoxTable.ChatType.ONETOONE.m2189a());
                intent.putExtra("receivers", new String[]{this.f719a.f585j.m668a()});
                this.f719a.startActivity(intent);
                break;
            case C0062R.id.profile_call /* 2131427550 */:
                ChatONLogWriter.m3512f("************ BUDDY NO : " + this.f719a.f585j.m668a(), BuddyProfileActivity.f553a);
                ChatONLogWriter.m3512f("************ BUDDY ORG NO : " + this.f719a.f585j.m680e(), BuddyProfileActivity.f553a);
                Intent intent2 = new Intent("android.intent.action.CALL", (this.f719a.f585j.m680e() == null || this.f719a.f585j.m680e().length() <= 0) ? Uri.parse("tel:+" + this.f719a.f585j.m668a()) : Uri.parse("tel:" + this.f719a.f585j.m680e()));
                intent2.setFlags(268435456);
                this.f719a.startActivityForResult(intent2, 0);
                break;
            case C0062R.id.profile_msg /* 2131427551 */:
                ChatONLogWriter.m3512f("************ BUDDY NO : " + this.f719a.f585j.m668a(), BuddyProfileActivity.f553a);
                ChatONLogWriter.m3512f("************ BUDDY ORG NO : " + this.f719a.f585j.m680e(), BuddyProfileActivity.f553a);
                String strM680e = (this.f719a.f585j.m680e() == null || this.f719a.f585j.m680e().length() <= 0) ? "+" + this.f719a.f585j.m668a() : this.f719a.f585j.m680e();
                ChatONLogWriter.m3512f("************ PHONE NO : " + strM680e, BuddyProfileActivity.f553a);
                Intent intent3 = new Intent("android.intent.action.VIEW");
                intent3.putExtra("address", strM680e);
                intent3.setType("vnd.android-dir/mms-sms");
                intent3.setFlags(268435456);
                this.f719a.startActivityForResult(intent3, 0);
                break;
            case C0062R.id.profile_calendar /* 2131427556 */:
                String strM681f = this.f719a.f585j.m681f();
                if (strM681f != null && strM681f.length() >= 5) {
                    if (strM681f.length() == 5) {
                        strM681f = String.valueOf(1905) + "-" + strM681f;
                    } else if (strM681f.length() == 10) {
                        strM681f = String.valueOf(1905) + "-" + strM681f.substring(5);
                    }
                    new AsyncTaskC0084ah(this.f719a).execute(strM681f);
                    break;
                }
                break;
            case C0062R.id.memo_btn_write /* 2131427567 */:
                int iM2753a = NetState.m2753a(GlobalApplication.m2387e());
                if (-3 != iM2753a && -2 != iM2753a) {
                    Intent intent4 = new Intent(this.f719a.f584i, (Class<?>) WriteMemoActivity.class);
                    intent4.putExtra("buddyid", this.f719a.f586k);
                    this.f719a.startActivityForResult(intent4, 9);
                    break;
                } else {
                    Toast.makeText(this.f719a.f584i, C0062R.string.dev_network_error, 0).show();
                    break;
                }
                break;
            case C0062R.id.profile_image /* 2131427569 */:
                Intent intent5 = new Intent(this.f719a.f584i, (Class<?>) ViewProfileImage.class);
                intent5.putExtra("PROFILE_BUDDY_NO", this.f719a.f585j.m668a());
                intent5.putExtra("PROFILE_BUDDY_BIGIMAGE_STATUS", this.f719a.f585j.m693r());
                this.f719a.startActivityForResult(intent5, 0);
                break;
            case C0062R.id.profile_is_favorite /* 2131427572 */:
                if (!this.f719a.f592q.isChecked()) {
                    this.f719a.f583h.startDelete(2, this.f719a.f585j, ChatONContract.GroupRelationTable.f1715a, "group_relation_group = 1 AND group_relation_buddy = ? ", new String[]{this.f719a.f585j.m668a()});
                    break;
                } else {
                    this.f719a.f583h.startQuery(4, this.f719a.f585j, ChatONContract.GroupRelationTable.f1715a, null, "group_relation_group = 1 ", null, null);
                    break;
                }
            case C0062R.id.new_buddy_add /* 2131428058 */:
                view.setEnabled(false);
                this.f719a.f556C.setEnabled(false);
                this.f719a.f561H.show();
                new ContactControl(this.f719a.f578c).m1996b(this.f719a.f586k);
                break;
            case C0062R.id.new_buddy_block /* 2131428059 */:
                view.setEnabled(false);
                this.f719a.f558E.setEnabled(false);
                new BlockControl(this.f719a.f578c).m1991a(this.f719a.f585j.m668a(), 1);
                break;
            case C0062R.id.new_buddy_unblock /* 2131428060 */:
                new BlockControl(this.f719a.f578c).m1990a(this.f719a.f586k);
                break;
            case C0062R.id.new_buddy_cancel /* 2131428061 */:
                this.f719a.finish();
                break;
        }
    }
}
