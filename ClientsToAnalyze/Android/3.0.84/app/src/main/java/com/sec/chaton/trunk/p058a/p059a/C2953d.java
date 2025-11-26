package com.sec.chaton.trunk.p058a.p059a;

import android.content.ContentProviderOperation;
import android.database.Cursor;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.p026a.AbstractC1145a;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.chaton.trunk.database.C3050f;
import com.sec.chaton.trunk.database.p062a.C3044a;
import com.sec.chaton.trunk.database.p062a.C3045b;
import com.sec.chaton.trunk.entry.GetItemListEntry;
import com.sec.chaton.trunk.entry.inner.TrunkItem;
import com.sec.chaton.trunk.p058a.EnumC2959b;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import org.apache.http.NameValuePair;

/* compiled from: GetItemListTask.java */
/* renamed from: com.sec.chaton.trunk.a.a.d */
/* loaded from: classes.dex */
public class C2953d extends AbstractC1145a {

    /* renamed from: b */
    private static final String f10719b = C2953d.class.getSimpleName();

    /* renamed from: c */
    private boolean f10720c;

    /* renamed from: e */
    private String f10721e;

    public C2953d(Handler handler, C1580h c1580h, boolean z) {
        super(handler, c1580h);
        this.f10721e = null;
        this.f10720c = z;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws NumberFormatException {
        boolean z;
        boolean z2;
        int i;
        EnumC2959b enumC2959bM10433a;
        String value;
        String value2;
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            GetItemListEntry getItemListEntry = (GetItemListEntry) c0267d.m1354e();
            if (getItemListEntry == null) {
                C3250y.m11442a("Http result object is null", f10719b);
                return;
            }
            String str = "";
            String str2 = "";
            EnumC2959b enumC2959b = null;
            int i2 = 0;
            ArrayList arrayList = new ArrayList();
            for (NameValuePair nameValuePair : c0267d.m1353d().m6706f()) {
                if (nameValuePair.getName().equals("sessionid")) {
                    int i3 = i2;
                    enumC2959bM10433a = enumC2959b;
                    value = str2;
                    value2 = nameValuePair.getValue();
                    i = i3;
                } else if (nameValuePair.getName().equals(PrefFragmentChats.TYPE)) {
                    value = str2;
                    value2 = str;
                    int i4 = i2;
                    enumC2959bM10433a = EnumC2959b.m10433a(nameValuePair.getValue());
                    i = i4;
                } else if (nameValuePair.getName().equals("count")) {
                    i = Integer.parseInt(nameValuePair.getValue());
                    enumC2959bM10433a = enumC2959b;
                    value = str2;
                    value2 = str;
                } else if (nameValuePair.getName().equals("startitemid")) {
                    value2 = str;
                    EnumC2959b enumC2959b2 = enumC2959b;
                    value = nameValuePair.getValue();
                    i = i2;
                    enumC2959bM10433a = enumC2959b2;
                } else {
                    i = i2;
                    enumC2959bM10433a = enumC2959b;
                    value = str2;
                    value2 = str;
                }
                str = value2;
                str2 = value;
                enumC2959b = enumC2959bM10433a;
                i2 = i;
            }
            if (TextUtils.isEmpty(str2) || "0".equals(str2)) {
                z = false;
            } else {
                z = true;
            }
            if (enumC2959b == null) {
                C3250y.m11442a("The ordering type is null.", f10719b);
                return;
            }
            if (this.f10720c) {
                C3250y.m11450b("Truncate trunk item cache.", f10719b);
                arrayList.add(C3044a.m10567c(str));
            }
            if (c0267d.m1354e() == null) {
                z2 = false;
            } else {
                C3250y.m11450b("Save trunk item to database.", f10719b);
                int size = getItemListEntry.items.size();
                if (z) {
                    i2--;
                    size--;
                }
                C3250y.m11450b("Request count: " + i2 + ", Response count: " + size, f10719b);
                boolean z3 = i2 - size <= 0;
                if (z3) {
                    Cursor cursorM10576a = new C3050f().m10577a("trunk_item").m10576a(C3045b.m10571a().getWritableDatabase(), null, null, "registration_time DESC");
                    if (cursorM10576a != null && cursorM10576a.getCount() > 0) {
                        cursorM10576a.moveToFirst();
                        this.f10721e = cursorM10576a.getString(cursorM10576a.getColumnIndex("registration_time"));
                    } else {
                        this.f10721e = null;
                    }
                } else {
                    this.f10721e = null;
                }
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= getItemListEntry.items.size()) {
                        break;
                    }
                    TrunkItem trunkItem = getItemListEntry.items.get(i6);
                    trunkItem.sessionid = str;
                    C3250y.m11450b("Item id: " + trunkItem.itemid + ", HasMore: " + z3 + ", IsLastItem: " + (i6 == getItemListEntry.items.size() + (-1)), f10719b);
                    if (i6 == getItemListEntry.items.size() - 1) {
                        if (z3) {
                            arrayList.add(C3044a.m10559a(trunkItem, true));
                            C3250y.m11450b("Item id: " + trunkItem.itemid, f10719b);
                        } else {
                            arrayList.add(C3044a.m10559a(trunkItem, false));
                            C3250y.m11450b("Item id: " + trunkItem.itemid, f10719b);
                        }
                    } else {
                        arrayList.add(C3044a.m10559a(trunkItem, false));
                        C3250y.m11450b("Item id: " + trunkItem.itemid, f10719b);
                    }
                    i5 = i6 + 1;
                }
                z2 = z3;
            }
            C3044a.m10565a(CommonApplication.m11493l(), (ArrayList<ContentProviderOperation>) arrayList);
            if (this.f10721e != null) {
                Cursor cursorM10576a2 = new C3050f().m10577a("trunk_item").m10576a(C3045b.m10571a().getWritableDatabase(), null, null, "registration_time DESC");
                cursorM10576a2.moveToPosition(29);
                if (cursorM10576a2.getInt(cursorM10576a2.getColumnIndex("item_type")) == 2 && Long.parseLong(this.f10721e) < getItemListEntry.items.get(29).regdttm.longValue()) {
                    arrayList.add(C3044a.m10567c(str));
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        if (i8 < getItemListEntry.items.size()) {
                            TrunkItem trunkItem2 = getItemListEntry.items.get(i8);
                            trunkItem2.sessionid = str;
                            C3250y.m11450b("Item id: " + trunkItem2.itemid + ", HasMore: " + z2 + ", IsLastItem: " + (i8 == getItemListEntry.items.size() + (-1)), f10719b);
                            if (i8 == getItemListEntry.items.size() - 1) {
                                if (z2) {
                                    arrayList.add(C3044a.m10559a(trunkItem2, true));
                                    C3250y.m11450b("Item id: " + trunkItem2.itemid, f10719b);
                                } else {
                                    arrayList.add(C3044a.m10559a(trunkItem2, false));
                                    C3250y.m11450b("Item id: " + trunkItem2.itemid, f10719b);
                                }
                            } else {
                                arrayList.add(C3044a.m10559a(trunkItem2, false));
                                C3250y.m11450b("Item id: " + trunkItem2.itemid, f10719b);
                            }
                            i7 = i8 + 1;
                        } else {
                            C3044a.m10565a(CommonApplication.m11493l(), (ArrayList<ContentProviderOperation>) arrayList);
                            return;
                        }
                    }
                }
            }
        } else if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000016", "0102", c0267d);
        }
    }
}
