package com.sec.chaton.shop.p099a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.database.Cursor;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.p056a.AbstractC1900a;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p057e.p058a.C2188b;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.shop.C3733f;
import com.sec.chaton.shop.entrys.Character;
import com.sec.chaton.shop.entrys.ItemCharacterEntry;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetCharacterTask.java */
/* renamed from: com.sec.chaton.shop.a.a */
/* loaded from: classes.dex */
public class C3703a extends AbstractC1900a {

    /* renamed from: b */
    private static final String f13344b = C3703a.class.getSimpleName();

    public C3703a(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    protected String mo9086c() {
        ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        Cursor cursorQuery = contentResolver.query(C2257bc.m10120a(), null, "item_type = ? AND install != ? AND item_id > ?", new String[]{EnumC2258bd.Anicon.m10123a(), String.valueOf(0), String.valueOf(0)}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            int i = 0;
            do {
                try {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("itemId", cursorQuery.getString(cursorQuery.getColumnIndex("item_id")));
                        jSONObject2.put("categoryId", Long.toString(C3733f.m14068a(EnumC2258bd.m10122a(cursorQuery.getString(cursorQuery.getColumnIndex("item_type"))))));
                        jSONArray.put(i, jSONObject2);
                        i++;
                    } catch (JSONException e) {
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e, f13344b);
                        }
                        if (cursorQuery != null) {
                        }
                    }
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } while (cursorQuery.moveToNext());
            jSONObject.put("packages", jSONArray);
            if (C4904y.f17872b) {
                C4904y.m18639b(jSONObject.toString(), f13344b);
            }
            return jSONObject.toString();
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("There is no data.", f13344b);
        }
        return "";
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            ItemCharacterEntry itemCharacterEntry = (ItemCharacterEntry) c0778b.m3110e();
            if (itemCharacterEntry == null) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Http result object is null", f13344b);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < itemCharacterEntry.packages.size(); i++) {
                Character character = itemCharacterEntry.packages.get(i);
                arrayList.add(C2188b.m9788a(character.itemId, character.characterName));
            }
            try {
                C4821am.m18190a(CommonApplication.m18732r(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
                return;
            } catch (Exception e) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Http result is NO Contents. There is no stamp items for updating.", f13344b);
                }
                C4809aa.m18104a().m18125b("get_characterlist", (Boolean) false);
                return;
            }
        }
        if (c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
            if (C4904y.f17875e) {
                C4904y.m18634a("Http result is NO Contents. There is no stamp items for updating.", f13344b);
            }
        } else if (C4904y.f17875e) {
            C4904y.m18634a("Http result is failed", f13344b);
        }
    }
}
