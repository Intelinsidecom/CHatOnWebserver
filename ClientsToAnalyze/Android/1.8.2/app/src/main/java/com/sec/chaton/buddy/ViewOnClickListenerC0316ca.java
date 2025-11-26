package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p019b.C0679f;
import com.sec.chaton.p017e.p019b.C0680g;
import com.sec.chaton.p017e.p019b.C0682i;
import java.util.ArrayList;
import java.util.Iterator;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: BuddyGroupEditActivity.java */
/* renamed from: com.sec.chaton.buddy.ca */
/* loaded from: classes.dex */
class ViewOnClickListenerC0316ca implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupEditActivity f1435a;

    ViewOnClickListenerC0316ca(BuddyGroupEditActivity buddyGroupEditActivity) {
        this.f1435a = buddyGroupEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1435a.m2102b();
        switch (view.getId()) {
            case R.id.buddy_group_profile_rename_groupname /* 2131493067 */:
                view.setEnabled(false);
                this.f1435a.m2069a(this.f1435a.f1063p);
                String strReplace = this.f1435a.f1063p.getText().toString().trim().replace(",", "");
                this.f1435a.f1063p.setText(strReplace);
                this.f1435a.f1048P = strReplace;
                if (strReplace.length() > 0) {
                    C0668l.m3077a(new C0668l(), 3, new C0680g(this.f1435a.f1060m, strReplace, 3));
                    break;
                }
                break;
            case R.id.buddy_group_profile_addmember /* 2131493070 */:
            case R.id.buddy_group_profile_addmember_info /* 2131493071 */:
                this.f1435a.m2085d();
                Intent intent = new Intent(this.f1435a.f1062o, (Class<?>) BuddyGroupEditActivity.class);
                intent.putExtra("ACTIVITY_PURPOSE", 2);
                intent.putExtra("ACTIVITY_PURPOSE_ARG1", this.f1435a.f1057j);
                intent.putExtra("ACTIVITY_PURPOSE_ARG2", this.f1435a.f1044L);
                this.f1435a.startActivityForResult(intent, 1);
                break;
            case R.id.buddy_group_profile_remove_member /* 2131493072 */:
            case R.id.buddy_group_profile_remove_member_info /* 2131493073 */:
                this.f1435a.m2085d();
                this.f1435a.f1038F.setVisibility(0);
                this.f1435a.f1040H.setVisibility(8);
                this.f1435a.f1063p.setText("");
                this.f1435a.m2069a(this.f1435a.f1063p);
                this.f1435a.f1036D.setText(this.f1435a.getString(R.string.buddy_group_profile_title_remove_member));
                this.f1435a.f1037E.setVisibility(8);
                this.f1435a.f1041I.setVisibility(8);
                this.f1435a.f1066s.setVisibility(0);
                this.f1435a.f1056i.m2405b(true);
                this.f1435a.f1056i.m2398a(1);
                this.f1435a.f1072y.invalidateViews();
                break;
            case R.id.buddy_add_to_group /* 2131493081 */:
                ArrayList arrayListM2101a = this.f1435a.m2101a();
                if (arrayListM2101a.size() > 0) {
                    C0668l.m3077a(new C0668l(), 1, new C0679f(this.f1435a.f1060m, this.f1435a.f1057j.m2313a(), arrayListM2101a));
                    break;
                }
                break;
            case R.id.buddy_remove_to_group /* 2131493082 */:
                ArrayList arrayListM2101a2 = this.f1435a.m2101a();
                if (arrayListM2101a2.size() > 0) {
                    Iterator it = arrayListM2101a2.iterator();
                    while (it.hasNext()) {
                        this.f1435a.f1056i.m2400a((String) it.next());
                    }
                    C0668l.m3077a(new C0668l(), 2, new C0682i(this.f1435a.f1060m, this.f1435a.f1057j.m2313a(), arrayListM2101a2));
                    break;
                }
                break;
            case R.id.buddy_menu_cancel /* 2131493083 */:
                if (this.f1435a.f1047O != 2) {
                    if (this.f1435a.f1047O == 1) {
                        this.f1435a.m2085d();
                        break;
                    }
                } else {
                    this.f1435a.setResult(-1);
                    this.f1435a.finish();
                    break;
                }
                break;
            case R.id.buddy_menu_groupchat /* 2131493084 */:
                ArrayList arrayListM2101a3 = this.f1435a.m2101a();
                if (arrayListM2101a3.size() > 0) {
                    if (arrayListM2101a3.size() <= 199) {
                        Intent intent2 = new Intent(this.f1435a.f1062o, (Class<?>) ChatActivity.class);
                        intent2.putExtra("groupnmae", this.f1435a.f1057j.m2316b() + " (" + (arrayListM2101a3.size() + 1) + ")");
                        if (arrayListM2101a3.size() == 1) {
                            intent2.putExtra("chatType", EnumC0695j.ONETOONE.m3146a());
                        } else {
                            intent2.putExtra("chatType", EnumC0695j.GROUPCHAT.m3146a());
                        }
                        intent2.putExtra("receivers", (String[]) arrayListM2101a3.toArray(new String[0]));
                        this.f1435a.startActivity(intent2);
                        this.f1435a.finish();
                        break;
                    } else {
                        Toast.makeText(this.f1435a.f1062o, String.format(this.f1435a.getResources().getString(R.string.buddy_list_removefavorites_toast_failed), 199), 0).show();
                        break;
                    }
                }
                break;
            case R.id.buddy_menu_broadcast /* 2131493085 */:
                ArrayList arrayListM2101a4 = this.f1435a.m2101a();
                if (arrayListM2101a4.size() > 0) {
                    if (arrayListM2101a4.size() > 200) {
                        Toast.makeText(this.f1435a.f1062o, String.format(this.f1435a.getResources().getString(R.string.buddy_list_broadcast_toast_failed_exceed), Integer.valueOf(HttpResponseCode.f7897OK)), 0).show();
                        break;
                    } else {
                        Intent intent3 = new Intent(this.f1435a.f1062o, (Class<?>) ChatActivity.class);
                        intent3.putExtra("groupnmae", this.f1435a.f1057j.m2316b() + " (" + arrayListM2101a4.size() + ")");
                        intent3.putExtra("chatType", EnumC0695j.BROADCAST.m3146a());
                        intent3.putExtra("receivers", (String[]) arrayListM2101a4.toArray(new String[0]));
                        this.f1435a.startActivity(intent3);
                        this.f1435a.finish();
                    }
                }
                this.f1435a.finish();
                break;
        }
    }
}
