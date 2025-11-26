package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.msgsend.C1756p;
import com.sec.chaton.multimedia.audio.C1770b;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.util.C3159aa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bp */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0993bp implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4063a;

    DialogInterfaceOnClickListenerC0993bp(ChatFragment chatFragment) {
        this.f4063a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        if (this.f4063a.f3527aC.m5291d() != EnumC1071em.SELECT_ALL) {
            HashMap<Long, Boolean> mapM5282a = this.f4063a.f3527aC.m5282a();
            HashMap<Long, Boolean> mapM5288b = this.f4063a.f3527aC.m5288b();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(-1);
            arrayList2.add(1);
            arrayList2.add(6);
            if (mapM5282a != null && !mapM5282a.isEmpty()) {
                for (Map.Entry<Long, Boolean> entry : mapM5282a.entrySet()) {
                    if (entry.getValue().booleanValue()) {
                        Long key = entry.getKey();
                        sb.append(key.toString()).append(",");
                        arrayList.add(key);
                    }
                }
            }
            if (mapM5288b != null && !mapM5288b.isEmpty()) {
                for (Map.Entry<Long, Boolean> entry2 : mapM5288b.entrySet()) {
                    if (entry2.getValue().booleanValue()) {
                        sb2.append(entry2.getKey().toString()).append(",");
                    }
                }
            }
            Uri uri = C1454v.f5393a;
            String str2 = null;
            String[] strArr4 = null;
            if (this.f4063a.f3527aC.m5291d() != EnumC1071em.SELECT_PART) {
                if (this.f4063a.f3527aC.m5291d() != EnumC1071em.SELECT_PART_AFTER_ALL) {
                    str = null;
                    strArr = null;
                    strArr2 = null;
                } else {
                    if (sb.length() > 0) {
                        sb.setLength(sb.length() - 1);
                        str2 = "message_inbox_no = ? AND _id NOT IN (" + sb.toString() + ") AND ( message_type = ? OR message_type = ? OR message_type = ? )";
                        strArr3 = new String[]{this.f4063a.f3703r, Integer.toString(-1), Integer.toString(1), Integer.toString(6)};
                        C1756p.m7224a(this.f4063a.f3703r, (ArrayList<Long>) arrayList, (ArrayList<Integer>) arrayList2);
                    } else {
                        str2 = "message_inbox_no = ? AND message_sender = ? AND ( message_type = ? OR message_type = ? OR message_type = ? )";
                        strArr3 = new String[]{this.f4063a.f3703r, C3159aa.m10962a().m10979a("chaton_id", ""), Integer.toString(-1), Integer.toString(1), Integer.toString(6)};
                        C1756p.m7239a(this.f4063a.f3703r, (ArrayList<Integer>) arrayList2);
                    }
                    if (sb2.length() > 0) {
                        sb2.setLength(sb2.length() - 1);
                        str = "message_inbox_no = ? AND message_sever_id NOT IN (" + sb2.toString() + ") AND message_type != ? AND message_type != ? AND message_type != ?";
                        strArr = new String[]{this.f4063a.f3703r, Integer.toString(1), Integer.toString(0), Integer.toString(3)};
                        strArr2 = strArr3;
                    } else {
                        str = "message_inbox_no = ? AND message_sender != ? AND message_type != ? AND message_type != ? AND message_type != ?";
                        strArr = new String[]{this.f4063a.f3703r, C3159aa.m10962a().m10979a("chaton_id", ""), Integer.toString(1), Integer.toString(0), Integer.toString(3)};
                        strArr2 = strArr3;
                    }
                }
            } else {
                if (sb.length() > 0) {
                    sb.setLength(sb.length() - 1);
                    str2 = "message_inbox_no = ? AND _id IN (" + sb.toString() + ") AND ( message_type = ? OR message_type = ? OR message_type = ? )";
                    strArr4 = new String[]{this.f4063a.f3703r, Integer.toString(-1), Integer.toString(1), Integer.toString(6)};
                    C1756p.m7241b(this.f4063a.f3703r, (ArrayList<Long>) arrayList, (ArrayList<Integer>) arrayList2);
                }
                if (sb2.length() <= 0) {
                    str = null;
                    strArr = null;
                    strArr2 = strArr4;
                } else {
                    sb2.setLength(sb2.length() - 1);
                    str = "message_inbox_no = ? AND message_sever_id IN (" + sb2.toString() + ") AND message_type != ? AND message_type != ? AND message_type != ?";
                    strArr = new String[]{this.f4063a.f3703r, Integer.toString(1), Integer.toString(0), Integer.toString(3)};
                    strArr2 = strArr4;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                this.f4063a.f3551aa.startDelete(3, null, uri, str2, strArr2);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f4063a.f3551aa.startDelete(3, null, uri, str, strArr);
            }
        } else {
            C1770b.m7289a().m7302b();
            C1770b.m7289a().m7307d();
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(0);
            arrayList3.add(3);
            C1756p.m7240b(this.f4063a.f3703r, arrayList3);
            this.f4063a.f3551aa.startDelete(3, null, C1454v.f5393a, "message_inbox_no = ? AND message_type != ? AND message_type != ?", new String[]{this.f4063a.f3703r, Integer.toString(0), Integer.toString(3)});
        }
        this.f4063a.m5016q();
    }
}
