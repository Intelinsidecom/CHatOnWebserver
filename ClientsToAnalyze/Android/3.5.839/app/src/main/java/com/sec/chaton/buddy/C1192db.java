package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.buddy.p050a.C1105b;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.C2268bn;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.db */
/* loaded from: classes.dex */
class C1192db implements SlookAirButton.ItemSelectListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4420a;

    C1192db(BuddyFragment buddyFragment) {
        this.f4420a = buddyFragment;
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButton.ItemSelectListener
    public void onItemSelected(View view, int i, Object obj) {
        if (obj != null) {
            if (((C1106c) obj).m7046a().equals(GlobalApplication.m18732r().getResources().getString(R.string.setting_interaction_me))) {
                if (i == 0) {
                    Intent intentM3014a = TabActivity.m3014a(GlobalApplication.m18732r());
                    intentM3014a.putExtra("callMyPageTab", true);
                    this.f4420a.startActivity(intentM3014a);
                    return;
                }
                return;
            }
            if (((C1106c) obj).m7046a().startsWith("0999")) {
                if (i == 0) {
                    Intent intent = new Intent(GlobalApplication.m18732r(), (Class<?>) SpecialBuddyActivity.class);
                    intent.putExtra("specialuserid", ((C1106c) obj).m7046a());
                    intent.putExtra("speicalusername", ((C1106c) obj).m7051b());
                    intent.putExtra("specialBuddyAdded", C2186al.m9774c(GlobalApplication.m18732r().getContentResolver(), ((C1106c) obj).m7046a()));
                    this.f4420a.startActivity(intent);
                    return;
                }
                if (i == 1) {
                    if (this.f4420a.m6591a(((C1106c) obj).m7046a())) {
                        if (this.f4420a.f3620aA != null) {
                            C1113ad unused = this.f4420a.f3620aA;
                            C1113ad.m7114g(((C1106c) obj).m7046a());
                            SQLiteDatabase readableDatabase = C2268bn.m10126a(this.f4420a.getActivity()).getReadableDatabase();
                            C2186al.m9771b(readableDatabase, ((C1106c) obj).m7046a());
                            readableDatabase.close();
                        }
                        this.f4420a.f3621aB.m7409d((C1106c) obj);
                        return;
                    }
                    if (this.f4420a.f3620aA != null) {
                        C1113ad unused2 = this.f4420a.f3620aA;
                        C1113ad.m7113f(((C1106c) obj).m7046a());
                        SQLiteDatabase readableDatabase2 = C2268bn.m10126a(this.f4420a.getActivity()).getReadableDatabase();
                        C2186al.m9764a(readableDatabase2, ((C1106c) obj).m7046a());
                        readableDatabase2.close();
                    }
                    this.f4420a.f3621aB.m7407c((C1106c) obj);
                    return;
                }
                if (i == 2) {
                    this.f4420a.m6366a((C1106c) obj, 106);
                    return;
                } else {
                    if (i == 3) {
                        new C2128i(this.f4420a.f3769v).m9516c(((C1106c) obj).m7046a());
                        return;
                    }
                    return;
                }
            }
            if (((C1106c) obj).m7063l()) {
                if (i == 0) {
                    Intent intent2 = new Intent(GlobalApplication.m18732r(), (Class<?>) BuddyProfileActivity.class);
                    intent2.putExtra("PROFILE_BUDDY_NO", ((C1106c) obj).m7046a());
                    intent2.putExtra("PROFILE_BUDDY_NAME", ((C1106c) obj).m7051b());
                    intent2.putExtra("PROFILE_BUDDY_PROFILE_LOAD_DONE", true);
                    intent2.putExtra("PROFILE_BUDDY_PROFILE_IMAGE_LOAD_DONE", true);
                    intent2.setFlags(335544320);
                    this.f4420a.startActivity(intent2);
                    return;
                }
                if (i == 1) {
                    this.f4420a.f3621aB.m7401a((C1106c) obj);
                    return;
                } else {
                    if (i == 2) {
                        this.f4420a.m6366a((C1106c) obj, 106);
                        return;
                    }
                    return;
                }
            }
            if (this.f4420a.m6600c(((C1106c) obj).m7046a())) {
                if (i == 0) {
                    Intent intent3 = new Intent(GlobalApplication.m18732r(), (Class<?>) BuddyProfileActivity.class);
                    intent3.putExtra("PROFILE_BUDDY_NO", ((C1106c) obj).m7046a());
                    intent3.putExtra("PROFILE_BUDDY_NAME", ((C1106c) obj).m7051b());
                    intent3.putExtra("PROFILE_BUDDY_PROFILE_LOAD_DONE", true);
                    intent3.putExtra("PROFILE_BUDDY_PROFILE_IMAGE_LOAD_DONE", true);
                    intent3.setFlags(335544320);
                    this.f4420a.startActivity(intent3);
                    return;
                }
                if (i == 1) {
                    this.f4420a.f3621aB.m7404b((C1106c) obj);
                    return;
                } else if (i == 2) {
                    this.f4420a.m6366a((C1106c) obj, 106);
                    return;
                } else {
                    if (i == 3) {
                        this.f4420a.f3621aB.m7411e((C1106c) obj);
                        return;
                    }
                    return;
                }
            }
            if (((C1106c) obj).m7074w()) {
                if (i == 0) {
                    C1105b c1105b = new C1105b(Integer.parseInt(((C1106c) obj).m7046a()), ((C1106c) obj).m7051b(), ((C1106c) obj).m7076y().keySet().toArray(new String[0]) == null ? 0 : ((String[]) ((C1106c) obj).m7076y().keySet().toArray(new String[0])).length, 18);
                    Intent intent4 = new Intent(GlobalApplication.m18732r(), (Class<?>) BuddyGroupProfileActivity.class);
                    intent4.putExtra("ACTIVITY_PURPOSE", 18);
                    intent4.putExtra("groupInfo", c1105b);
                    intent4.putExtra("GROUP_PROFILE_NAME", ((C1106c) obj).m7051b());
                    intent4.putExtra("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST", (String[]) ((C1106c) obj).m7076y().keySet().toArray(new String[0]));
                    this.f4420a.startActivity(intent4);
                    return;
                }
                if (i == 1) {
                    this.f4420a.m6366a((C1106c) obj, 115);
                    return;
                } else {
                    if (i == 2) {
                        AbstractC4932a.m18733a(this.f4420a.getActivity()).mo18740a(this.f4420a.getResources().getString(R.string.buddy_group_list_dialog_removegroup_title)).mo18749b(this.f4420a.getResources().getString(R.string.buddy_group_list_dialog_removegroup_message)).mo18755c(this.f4420a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1193dc(this, obj)).mo18741a(this.f4420a.getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).mo18752b();
                        return;
                    }
                    return;
                }
            }
            if (i == 0) {
                Intent intent5 = new Intent(GlobalApplication.m18732r(), (Class<?>) BuddyProfileActivity.class);
                intent5.putExtra("PROFILE_BUDDY_NO", ((C1106c) obj).m7046a());
                intent5.putExtra("PROFILE_BUDDY_NAME", ((C1106c) obj).m7051b());
                intent5.putExtra("PROFILE_BUDDY_PROFILE_LOAD_DONE", true);
                intent5.putExtra("PROFILE_BUDDY_PROFILE_IMAGE_LOAD_DONE", true);
                intent5.setFlags(335544320);
                this.f4420a.startActivity(intent5);
                return;
            }
            if (i == 1) {
                this.f4420a.f3621aB.m7401a((C1106c) obj);
            } else if (i == 2) {
                this.f4420a.m6366a((C1106c) obj, 106);
            } else if (i == 3) {
                this.f4420a.f3621aB.m7411e((C1106c) obj);
            }
        }
    }
}
