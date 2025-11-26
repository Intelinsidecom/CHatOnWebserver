package com.sec.chaton.trunk.p048b.p049a;

import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p015d.p016a.AbstractRunnableC0532a;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.trunk.database.p052a.C1584a;
import com.sec.chaton.trunk.entry.GetItemListEntry;
import com.sec.chaton.trunk.entry.inner.TrunkItem;
import com.sec.chaton.trunk.p048b.EnumC1551b;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import org.apache.http.NameValuePair;

/* compiled from: GetItemListTask.java */
/* renamed from: com.sec.chaton.trunk.b.a.d */
/* loaded from: classes.dex */
public class C1546d extends AbstractRunnableC0532a {

    /* renamed from: d */
    private static final String f5604d = C1546d.class.getSimpleName();

    /* renamed from: e */
    private boolean f5605e;

    public C1546d(Handler handler, C0798h c0798h, boolean z) {
        super(handler, c0798h);
        this.f5605e = z;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) throws NumberFormatException {
        int i;
        EnumC1551b enumC1551bM5405a;
        String value;
        String value2;
        if (c0101b.m665b() == EnumC0803m.SUCCESS) {
            GetItemListEntry getItemListEntry = (GetItemListEntry) c0101b.m671d();
            if (getItemListEntry == null) {
                C1786r.m6054a("Http result object is null", f5604d);
                return;
            }
            String str = "";
            String str2 = "";
            EnumC1551b enumC1551b = null;
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (NameValuePair nameValuePair : c0101b.m669c().m3396d()) {
                if (nameValuePair.getName().equals("sessionid")) {
                    int i3 = i2;
                    enumC1551bM5405a = enumC1551b;
                    value = str2;
                    value2 = nameValuePair.getValue();
                    i = i3;
                } else if (nameValuePair.getName().equals("type")) {
                    value = str2;
                    value2 = str;
                    int i4 = i2;
                    enumC1551bM5405a = EnumC1551b.m5405a(nameValuePair.getValue());
                    i = i4;
                } else if (nameValuePair.getName().equals("count")) {
                    i = Integer.parseInt(nameValuePair.getValue());
                    enumC1551bM5405a = enumC1551b;
                    value = str2;
                    value2 = str;
                } else if (nameValuePair.getName().equals("startitemid")) {
                    value2 = str;
                    EnumC1551b enumC1551b2 = enumC1551b;
                    value = nameValuePair.getValue();
                    i = i2;
                    enumC1551bM5405a = enumC1551b2;
                } else {
                    i = i2;
                    enumC1551bM5405a = enumC1551b;
                    value = str2;
                    value2 = str;
                }
                str = value2;
                str2 = value;
                enumC1551b = enumC1551bM5405a;
                i2 = i;
            }
            boolean z = (TextUtils.isEmpty(str2) || "0".equals(str2)) ? false : true;
            if (enumC1551b == null) {
                C1786r.m6054a("The ordering type is null.", f5604d);
                return;
            }
            if (this.f5605e) {
                C1786r.m6061b("Truncate trunk item cache.", f5604d);
                arrayList.add(C1584a.m5475d(str));
            }
            if (z) {
                C1786r.m6061b("Remove load more trunk item.", f5604d);
                arrayList.add(C1584a.m5474c(str2));
            }
            if (c0101b.m671d() != null) {
                C1786r.m6061b("Save trunk item to database.", f5604d);
                int size = getItemListEntry.items.size();
                if (z) {
                    i2--;
                    size--;
                }
                C1786r.m6061b("Request count: " + i2 + ", Response count: " + size, f5604d);
                boolean z2 = i2 - size <= 0;
                int i5 = 0;
                while (i5 < getItemListEntry.items.size()) {
                    TrunkItem trunkItem = (TrunkItem) getItemListEntry.items.get(i5);
                    trunkItem.sessionid = str;
                    C1786r.m6061b("Item id: " + trunkItem.itemid + ", HasMore: " + z2 + ", IsLastItem: " + (i5 == getItemListEntry.items.size() + (-1)), f5604d);
                    if (i5 == getItemListEntry.items.size() - 1) {
                        if (z2) {
                            arrayList.add(C1584a.m5468a(trunkItem, true));
                        } else {
                            arrayList.add(C1584a.m5468a(trunkItem, false));
                        }
                    } else {
                        arrayList.add(C1584a.m5468a(trunkItem, false));
                        arrayList.add(C1584a.m5474c(trunkItem.itemid));
                    }
                    i5++;
                }
            }
            C1584a.m5472a(GlobalApplication.m3260b(), arrayList);
        }
    }
}
