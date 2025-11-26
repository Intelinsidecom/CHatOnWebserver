package com.sec.chaton.trunk.p043c.p044a;

import android.database.Cursor;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.trunk.database.C1174b;
import com.sec.chaton.trunk.database.p046a.C1172a;
import com.sec.chaton.trunk.database.p046a.C1173b;
import com.sec.chaton.trunk.entry.GetItemListEntry;
import com.sec.chaton.trunk.entry.inner.TrunkItem;
import com.sec.chaton.trunk.p043c.EnumC1152a;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;
import org.apache.http.NameValuePair;

/* compiled from: GetItemListTask.java */
/* renamed from: com.sec.chaton.trunk.c.a.c */
/* loaded from: classes.dex */
public class C1155c extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private static final String f4000a = C1155c.class.getSimpleName();

    /* renamed from: b */
    private boolean f4001b;

    /* renamed from: f */
    private String f4002f;

    public C1155c(Handler handler, C0503j c0503j, boolean z) {
        super(handler, c0503j);
        this.f4002f = null;
        this.f4001b = z;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        return null;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) throws NumberFormatException {
        boolean z;
        boolean z2;
        int i;
        EnumC1152a enumC1152aM4191a;
        String value;
        String value2;
        if (c0259g.m928b() == EnumC0518y.SUCCESS) {
            GetItemListEntry getItemListEntry = (GetItemListEntry) c0259g.m932d();
            if (getItemListEntry == null) {
                C1341p.m4651a("Http result object is null", f4000a);
                return;
            }
            String str = "";
            String str2 = "";
            EnumC1152a enumC1152a = null;
            int i2 = 0;
            ArrayList arrayList = new ArrayList();
            for (NameValuePair nameValuePair : c0259g.m931c().m2531d()) {
                if (nameValuePair.getName().equals("sessionid")) {
                    int i3 = i2;
                    enumC1152aM4191a = enumC1152a;
                    value = str2;
                    value2 = nameValuePair.getValue();
                    i = i3;
                } else if (nameValuePair.getName().equals("type")) {
                    value = str2;
                    value2 = str;
                    int i4 = i2;
                    enumC1152aM4191a = EnumC1152a.m4191a(nameValuePair.getValue());
                    i = i4;
                } else if (nameValuePair.getName().equals("count")) {
                    i = Integer.parseInt(nameValuePair.getValue());
                    enumC1152aM4191a = enumC1152a;
                    value = str2;
                    value2 = str;
                } else if (nameValuePair.getName().equals("startitemid")) {
                    value2 = str;
                    EnumC1152a enumC1152a2 = enumC1152a;
                    value = nameValuePair.getValue();
                    i = i2;
                    enumC1152aM4191a = enumC1152a2;
                } else {
                    i = i2;
                    enumC1152aM4191a = enumC1152a;
                    value = str2;
                    value2 = str;
                }
                str = value2;
                str2 = value;
                enumC1152a = enumC1152aM4191a;
                i2 = i;
            }
            if (TextUtils.isEmpty(str2) || "0".equals(str2)) {
                z = false;
            } else {
                z = true;
            }
            if (enumC1152a == null) {
                C1341p.m4651a("The ordering type is null.", f4000a);
                return;
            }
            if (this.f4001b) {
                C1341p.m4658b("Truncate trunk item cache.", f4000a);
                arrayList.add(C1173b.m4240c(str));
            }
            if (c0259g.m932d() == null) {
                z2 = false;
            } else {
                C1341p.m4658b("Save trunk item to database.", f4000a);
                int size = getItemListEntry.items.size();
                if (z) {
                    i2--;
                    size--;
                }
                C1341p.m4658b("Request count: " + i2 + ", Response count: " + size, f4000a);
                boolean z3 = i2 - size <= 0;
                if (z3) {
                    Cursor cursorM4246a = new C1174b().m4247a("trunk_item").m4246a(C1172a.m4229a().getWritableDatabase(), null, null, "registration_time DESC");
                    if (cursorM4246a != null && cursorM4246a.getCount() > 0) {
                        cursorM4246a.moveToFirst();
                        this.f4002f = cursorM4246a.getString(cursorM4246a.getColumnIndex("registration_time"));
                    } else {
                        this.f4002f = null;
                    }
                } else {
                    this.f4002f = null;
                }
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= getItemListEntry.items.size()) {
                        break;
                    }
                    TrunkItem trunkItem = (TrunkItem) getItemListEntry.items.get(i6);
                    trunkItem.sessionid = str;
                    C1341p.m4658b("Item id: " + trunkItem.itemid + ", HasMore: " + z3 + ", IsLastItem: " + (i6 == getItemListEntry.items.size() + (-1)), f4000a);
                    if (i6 == getItemListEntry.items.size() - 1) {
                        if (z3) {
                            arrayList.add(C1173b.m4234a(trunkItem, true));
                            C1341p.m4658b("Item id: " + trunkItem.itemid, f4000a);
                        } else {
                            arrayList.add(C1173b.m4234a(trunkItem, false));
                            C1341p.m4658b("Item id: " + trunkItem.itemid, f4000a);
                        }
                    } else {
                        arrayList.add(C1173b.m4234a(trunkItem, false));
                        C1341p.m4658b("Item id: " + trunkItem.itemid, f4000a);
                    }
                    i5 = i6 + 1;
                }
                z2 = z3;
            }
            C1173b.m4238a(GlobalApplication.m3100a(), arrayList);
            if (this.f4002f != null) {
                Cursor cursorM4246a2 = new C1174b().m4247a("trunk_item").m4246a(C1172a.m4229a().getWritableDatabase(), null, null, "registration_time DESC");
                cursorM4246a2.moveToPosition(29);
                if (cursorM4246a2.getInt(cursorM4246a2.getColumnIndex("item_type")) == 2 && Long.parseLong(this.f4002f) < ((TrunkItem) getItemListEntry.items.get(29)).regdttm) {
                    arrayList.add(C1173b.m4240c(str));
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        if (i8 < getItemListEntry.items.size()) {
                            TrunkItem trunkItem2 = (TrunkItem) getItemListEntry.items.get(i8);
                            trunkItem2.sessionid = str;
                            C1341p.m4658b("Item id: " + trunkItem2.itemid + ", HasMore: " + z2 + ", IsLastItem: " + (i8 == getItemListEntry.items.size() + (-1)), f4000a);
                            if (i8 == getItemListEntry.items.size() - 1) {
                                if (z2) {
                                    arrayList.add(C1173b.m4234a(trunkItem2, true));
                                    C1341p.m4658b("Item id: " + trunkItem2.itemid, f4000a);
                                } else {
                                    arrayList.add(C1173b.m4234a(trunkItem2, false));
                                    C1341p.m4658b("Item id: " + trunkItem2.itemid, f4000a);
                                }
                            } else {
                                arrayList.add(C1173b.m4234a(trunkItem2, false));
                                C1341p.m4658b("Item id: " + trunkItem2.itemid, f4000a);
                            }
                            i7 = i8 + 1;
                        } else {
                            C1173b.m4238a(GlobalApplication.m3100a(), arrayList);
                            return;
                        }
                    }
                }
            }
        }
    }
}
