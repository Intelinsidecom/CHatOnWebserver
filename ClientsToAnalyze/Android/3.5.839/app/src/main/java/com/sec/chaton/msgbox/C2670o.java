package com.sec.chaton.msgbox;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: MsgboxClose.java */
/* renamed from: com.sec.chaton.msgbox.o */
/* loaded from: classes.dex */
class C2670o implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ C2660e f9581a;

    C2670o(C2660e c2660e) {
        this.f9581a = c2660e;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
        if (i == 1) {
            if (C4904y.f17872b) {
                C4904y.m18639b("onDeleteComplete [QUERY_DELETE_INBOX]", C2660e.f9537b);
            }
            C1813b.m8906b().m8922a(this.f9581a.f9544h, C1813b.f6839h);
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        switch (i) {
            case 3:
                if (C4904y.f17872b) {
                    C4904y.m18639b("onQueryComplete [QUERY_MSGBOX]", C2660e.f9537b);
                }
                if (cursor == null || cursor.getCount() == 0) {
                    this.f9581a.m11209a(new RunnableC2671p(this), this.f9581a.f9546j == 3);
                    break;
                } else {
                    this.f9581a.m11243d();
                    break;
                }
                break;
            case 4:
                if (C4904y.f17872b) {
                    C4904y.m18639b("onQueryComplete [QUERY_OLD_MSGBOX]", C2660e.f9537b);
                }
                if (cursor == null || cursor.getCount() == 0) {
                    if (this.f9581a.f9546j != 4) {
                        this.f9581a.m11209a(new RunnableC2672q(this), this.f9581a.f9546j == 3);
                        break;
                    }
                } else {
                    this.f9581a.m11195a(cursor);
                    break;
                }
                break;
            case 5:
                if (C4904y.f17872b) {
                    C4904y.m18639b("onQueryComplete [QUERY_SMS_MSGBOX]", C2660e.f9537b);
                }
                if (cursor == null || cursor.getCount() == 0) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[SMS] no sms in the list", C2660e.f9537b);
                    }
                    this.f9581a.m11216a(true, (C0788l) null);
                    break;
                } else if (!cursor.moveToFirst()) {
                    if (C4904y.f17875e) {
                        C4904y.m18634a("[SMS][QUERY_SMS_MSGBOX] failed to moveToFirst()", C2660e.f9537b);
                    }
                    this.f9581a.m11216a(true, (C0788l) null);
                    break;
                } else {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[SMS]request to SMS to delete VIA setting", C2660e.f9537b);
                    }
                    ArrayList arrayList = new ArrayList();
                    int columnIndex = cursor.getColumnIndex("inbox_no");
                    do {
                        arrayList.add(cursor.getString(columnIndex));
                    } while (cursor.moveToNext());
                    if (this.f9581a.f9543g != null) {
                        new C2681z(this.f9581a, this.f9581a.f9543g).m19059d(null, EnumC2300t.UNKNOWN, arrayList, null, null, false);
                        break;
                    } else if (C4904y.f17872b) {
                        C4904y.m18639b("[SMS] failed to delete", C2660e.f9537b);
                        break;
                    }
                }
                break;
            case 6:
            case 7:
                ArrayList arrayList2 = new ArrayList();
                if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                    int columnIndex2 = cursor.getColumnIndex("inboxsms_mapping_sms_no");
                    do {
                        arrayList2.add(cursor.getString(columnIndex2));
                    } while (cursor.moveToNext());
                }
                if (i == 6) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("onQueryComplete [QUERY_MAPPED_SMS_SINGLE]", C2660e.f9537b);
                    }
                    this.f9581a.m11208a((C2679x) obj, (ArrayList<String>) arrayList2);
                    break;
                } else {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("onQueryComplete [QUERY_MAPPED_SMS_MULTIPLE]", C2660e.f9537b);
                    }
                    this.f9581a.m11222b((C2678w) obj, (ArrayList<String>) arrayList2);
                    break;
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
}
