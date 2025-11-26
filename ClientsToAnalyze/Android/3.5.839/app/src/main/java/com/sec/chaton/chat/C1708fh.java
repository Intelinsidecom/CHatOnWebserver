package com.sec.chaton.chat;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.buddy.p050a.EnumC1109f;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.common.p123a.AbstractC4932a;
import java.util.ArrayList;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.fh */
/* loaded from: classes.dex */
class C1708fh implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ ChatInfoFragment f6313a;

    C1708fh(ChatInfoFragment chatInfoFragment) {
        this.f6313a = chatInfoFragment;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        if (this.f6313a.getActivity() == null || this.f6313a.getActivity().isFinishing()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        if (i == 70) {
            if (cursor != null && cursor.getCount() > 0) {
                Intent intent = new Intent(this.f6313a.f5797h, (Class<?>) BuddyActivity2.class);
                intent.putExtra("ACTIVITY_PURPOSE", 5);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f6313a.f5801l);
                if (this.f6313a.f5802m != null && this.f6313a.f5802m.size() > 0) {
                    arrayList.addAll(this.f6313a.f5802m);
                }
                intent.putExtra(ChatFragment.f5465d, (String[]) arrayList.toArray(new String[arrayList.size()]));
                intent.putExtra("chatType", this.f6313a.f5800k);
                this.f6313a.startActivityForResult(intent, 5);
            } else {
                AbstractC4932a.m18733a(this.f6313a.f5797h).mo18734a(R.string.chat_view_menu_invite).mo18746b(R.string.buddy_list_invite_toast_failed_nomore).mo18756d(R.string.alert_dialog_ok, new DialogInterfaceOnClickListenerC1709fi(this)).mo18751b(true).mo18752b();
            }
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        if (i == 1) {
            if (cursor == null || cursor.getCount() <= 0) {
                this.f6313a.f5808s.setVisibility(0);
                if (this.f6313a.f5801l.size() >= 0 || this.f6313a.f5802m.size() >= 0) {
                    this.f6313a.f5808s.setEnabled(true);
                } else {
                    this.f6313a.f5808s.setEnabled(false);
                }
            } else {
                this.f6313a.f5808s.setVisibility(8);
            }
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        if (i == 2) {
            ArrayList<C1692es> arrayList2 = new ArrayList<>();
            ArrayList<C1692es> arrayList3 = new ArrayList<>();
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("buddy_no");
                int columnIndex2 = cursor.getColumnIndex("buddy_name");
                int columnIndex3 = cursor.getColumnIndex("buddy_status_message");
                int columnIndex4 = cursor.getColumnIndex("is_buddy");
                int columnIndex5 = cursor.getColumnIndex("participants_user_type");
                int columnIndex6 = cursor.getColumnIndex("buddy_original_name");
                int columnIndex7 = cursor.getColumnIndex("blocked");
                int columnIndex8 = cursor.getColumnIndex("hided");
                EnumC1109f.NONE.m7095a();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                String string = "";
                boolean z = false;
                boolean z2 = false;
                cursor.moveToFirst();
                do {
                    String string2 = cursor.getString(columnIndex);
                    String string3 = cursor.getString(columnIndex2);
                    String string4 = cursor.getString(columnIndex3);
                    boolean zEquals = "Y".equals(cursor.getString(columnIndex4));
                    String string5 = cursor.getString(columnIndex5);
                    if (columnIndex6 != -1) {
                        string = cursor.getString(columnIndex6);
                    }
                    if (columnIndex7 != -1) {
                        z = cursor.getInt(columnIndex7) == 1;
                    }
                    if (columnIndex8 != -1) {
                        z2 = cursor.getInt(columnIndex8) == 1;
                        if (!zEquals && z2) {
                            zEquals = true;
                        }
                    }
                    if (string5.equals(EnumC1109f.INVITED.m7095a()) || string5.equals(EnumC1109f.INVITING.m7095a())) {
                        arrayList5.add(cursor.getString(columnIndex));
                        arrayList3.add(new C1692es(string2, string3, string4, zEquals));
                    } else {
                        arrayList4.add(cursor.getString(columnIndex));
                        arrayList2.add(new C1692es(string2, string3, string4, zEquals, string, z, z2));
                    }
                } while (cursor.moveToNext());
                this.f6313a.f5801l = arrayList4;
                this.f6313a.f5802m = arrayList5;
                if (this.f6313a.f5801l.size() < 0 && this.f6313a.f5802m.size() < 0) {
                    this.f6313a.f5808s.setEnabled(false);
                }
            }
            this.f6313a.f5815z.m8524a(arrayList2, arrayList3);
            this.f6313a.f5815z.notifyDataSetChanged();
            this.f6313a.f5813x.expandGroup(0);
            if (arrayList3 != null && arrayList3.size() > 0) {
                this.f6313a.f5813x.expandGroup(1);
                return;
            }
            return;
        }
        if (i == 3) {
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                this.f6313a.f5795f = cursor.getString(cursor.getColumnIndex("inbox_title"));
                this.f6313a.f5794e.setText(this.f6313a.f5795f);
            }
            if (cursor != null) {
                this.f6313a.m8285a(cursor);
            }
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
