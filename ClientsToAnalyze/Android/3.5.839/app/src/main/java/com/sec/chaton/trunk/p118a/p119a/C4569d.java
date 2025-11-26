package com.sec.chaton.trunk.p118a.p119a;

import android.content.ContentProviderOperation;
import android.database.Cursor;
import android.text.TextUtils;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.p056a.AbstractC1900a;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.trunk.database.C4670f;
import com.sec.chaton.trunk.database.p122a.C4664a;
import com.sec.chaton.trunk.database.p122a.C4665b;
import com.sec.chaton.trunk.entry.GetItemListEntry;
import com.sec.chaton.trunk.entry.inner.TrunkItem;
import com.sec.chaton.trunk.p118a.EnumC4575b;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import org.apache.http.NameValuePair;

/* compiled from: GetItemListTask.java */
/* renamed from: com.sec.chaton.trunk.a.a.d */
/* loaded from: classes.dex */
public class C4569d extends AbstractC1900a {

    /* renamed from: b */
    private static final String f16664b = C4569d.class.getSimpleName();

    /* renamed from: c */
    private boolean f16665c;

    /* renamed from: d */
    private String f16666d;

    public C4569d(C2454e c2454e, boolean z) {
        super(c2454e);
        this.f16666d = null;
        this.f16665c = z;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws NumberFormatException {
        boolean z;
        boolean z2;
        int i;
        EnumC4575b enumC4575bM17529a;
        String value;
        String value2;
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            GetItemListEntry getItemListEntry = (GetItemListEntry) c0778b.m3110e();
            if (getItemListEntry == null) {
                C4904y.m18634a("Http result object is null", f16664b);
                return;
            }
            String str = "";
            String str2 = "";
            EnumC4575b enumC4575b = null;
            int i2 = 0;
            ArrayList arrayList = new ArrayList();
            for (NameValuePair nameValuePair : c0778b.m3109d().m10633d()) {
                if (nameValuePair.getName().equals("sessionid")) {
                    int i3 = i2;
                    enumC4575bM17529a = enumC4575b;
                    value = str2;
                    value2 = nameValuePair.getValue();
                    i = i3;
                } else if (nameValuePair.getName().equals("type")) {
                    value = str2;
                    value2 = str;
                    int i4 = i2;
                    enumC4575bM17529a = EnumC4575b.m17529a(nameValuePair.getValue());
                    i = i4;
                } else if (nameValuePair.getName().equals(VKApiConst.COUNT)) {
                    i = Integer.parseInt(nameValuePair.getValue());
                    enumC4575bM17529a = enumC4575b;
                    value = str2;
                    value2 = str;
                } else if (nameValuePair.getName().equals("startitemid")) {
                    value2 = str;
                    EnumC4575b enumC4575b2 = enumC4575b;
                    value = nameValuePair.getValue();
                    i = i2;
                    enumC4575bM17529a = enumC4575b2;
                } else {
                    i = i2;
                    enumC4575bM17529a = enumC4575b;
                    value = str2;
                    value2 = str;
                }
                str = value2;
                str2 = value;
                enumC4575b = enumC4575bM17529a;
                i2 = i;
            }
            if (TextUtils.isEmpty(str2) || Spam.ACTIVITY_CANCEL.equals(str2)) {
                z = false;
            } else {
                z = true;
            }
            if (enumC4575b == null) {
                C4904y.m18634a("The ordering type is null.", f16664b);
                return;
            }
            if (this.f16665c) {
                C4904y.m18639b("Truncate trunk item cache.", f16664b);
                arrayList.add(C4664a.m17662c(str));
            }
            if (c0778b.m3110e() == null) {
                z2 = false;
            } else {
                C4904y.m18639b("Save trunk item to database.", f16664b);
                int size = getItemListEntry.items.size();
                if (z) {
                    i2--;
                    size--;
                }
                C4904y.m18639b("Request count: " + i2 + ", Response count: " + size, f16664b);
                boolean z3 = i2 - size <= 0;
                if (z3) {
                    Cursor cursorM17670a = new C4670f().m17671a("trunk_item").m17670a(C4665b.m17665a().getWritableDatabase(), null, null, "registration_time DESC");
                    if (cursorM17670a != null && cursorM17670a.getCount() > 0) {
                        cursorM17670a.moveToFirst();
                        this.f16666d = cursorM17670a.getString(cursorM17670a.getColumnIndex("registration_time"));
                    } else {
                        this.f16666d = null;
                    }
                } else {
                    this.f16666d = null;
                }
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= getItemListEntry.items.size()) {
                        break;
                    }
                    TrunkItem trunkItem = getItemListEntry.items.get(i6);
                    trunkItem.sessionid = str;
                    C4904y.m18639b("Item id: " + trunkItem.itemid + ", HasMore: " + z3 + ", IsLastItem: " + (i6 == getItemListEntry.items.size() + (-1)), f16664b);
                    if (i6 == getItemListEntry.items.size() - 1) {
                        if (z3) {
                            arrayList.add(C4664a.m17653a(trunkItem, true));
                            C4904y.m18639b("Item id: " + trunkItem.itemid, f16664b);
                        } else {
                            arrayList.add(C4664a.m17653a(trunkItem, false));
                            C4904y.m18639b("Item id: " + trunkItem.itemid, f16664b);
                        }
                    } else {
                        arrayList.add(C4664a.m17653a(trunkItem, false));
                        C4904y.m18639b("Item id: " + trunkItem.itemid, f16664b);
                    }
                    i5 = i6 + 1;
                }
                z2 = z3;
            }
            C4664a.m17660a(CommonApplication.m18732r(), (ArrayList<ContentProviderOperation>) arrayList);
            if (this.f16666d != null) {
                Cursor cursorM17670a2 = new C4670f().m17671a("trunk_item").m17670a(C4665b.m17665a().getWritableDatabase(), null, null, "registration_time DESC");
                if (cursorM17670a2 != null && cursorM17670a2.getCount() > 0) {
                    cursorM17670a2.moveToPosition(29);
                    if (cursorM17670a2.getInt(cursorM17670a2.getColumnIndex("item_type")) == 2 && Long.parseLong(this.f16666d) < getItemListEntry.items.get(29).regdttm.longValue()) {
                        arrayList.add(C4664a.m17662c(str));
                        int i7 = 0;
                        while (true) {
                            int i8 = i7;
                            if (i8 >= getItemListEntry.items.size()) {
                                break;
                            }
                            TrunkItem trunkItem2 = getItemListEntry.items.get(i8);
                            trunkItem2.sessionid = str;
                            C4904y.m18639b("Item id: " + trunkItem2.itemid + ", HasMore: " + z2 + ", IsLastItem: " + (i8 == getItemListEntry.items.size() + (-1)), f16664b);
                            if (i8 == getItemListEntry.items.size() - 1) {
                                if (z2) {
                                    arrayList.add(C4664a.m17653a(trunkItem2, true));
                                    C4904y.m18639b("Item id: " + trunkItem2.itemid, f16664b);
                                } else {
                                    arrayList.add(C4664a.m17653a(trunkItem2, false));
                                    C4904y.m18639b("Item id: " + trunkItem2.itemid, f16664b);
                                }
                            } else {
                                arrayList.add(C4664a.m17653a(trunkItem2, false));
                                C4904y.m18639b("Item id: " + trunkItem2.itemid, f16664b);
                            }
                            i7 = i8 + 1;
                        }
                        C4664a.m17660a(CommonApplication.m18732r(), (ArrayList<ContentProviderOperation>) arrayList);
                    }
                    cursorM17670a2.close();
                    return;
                }
                return;
            }
            return;
        }
        C2404a.m10430a("01000016", "0102", c0778b);
    }
}
