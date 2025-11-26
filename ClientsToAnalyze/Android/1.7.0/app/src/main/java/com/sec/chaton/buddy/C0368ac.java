package com.sec.chaton.buddy;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p017a.C0363a;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.p025d.C0654g;
import com.sec.chaton.p025d.C0661n;
import com.sec.chaton.p025d.C0667t;
import com.sec.chaton.p025d.C0668u;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0630j;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;
import java.util.ArrayList;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ac */
/* loaded from: classes.dex */
public class C0368ac implements InterfaceC0626f {

    /* renamed from: a */
    public int f1308a = 1;

    /* renamed from: b */
    public int f1309b = 2;

    /* renamed from: c */
    public int f1310c = 3;

    /* renamed from: d */
    public int f1311d = 4;

    /* renamed from: e */
    public int f1312e = 5;

    /* renamed from: f */
    public int f1313f = 6;

    /* renamed from: g */
    public int f1314g = 7;

    /* renamed from: h */
    public int f1315h = 10;

    /* renamed from: i */
    public int f1316i = 20;

    /* renamed from: j */
    public int f1317j = 61;

    /* renamed from: k */
    C0630j f1318k;

    /* renamed from: l */
    final /* synthetic */ BuddyFragment f1319l;

    public C0368ac(BuddyFragment buddyFragment) {
        this.f1319l = buddyFragment;
        this.f1318k = null;
        this.f1318k = new C0630j(buddyFragment.getActivity().getContentResolver(), this);
    }

    /* renamed from: a */
    public void m2353a(C0363a c0363a) {
        this.f1318k.startQuery(this.f1313f, c0363a, C0668u.f2311a, null, "group_relation_group = 1 ", null, null);
    }

    /* renamed from: b */
    public void m2356b(C0363a c0363a) {
        this.f1318k.startDelete(this.f1309b, c0363a, C0668u.f2311a, "group_relation_group = 1 AND group_relation_buddy = ? ", new String[]{c0363a.m2308a()});
    }

    /* renamed from: a */
    public void m2351a() {
        this.f1318k.startQuery(this.f1312e, null, C0667t.f2310a, new String[]{"buddy_no"}, null, null, null);
    }

    /* renamed from: b */
    public void m2355b() {
        this.f1318k.startQuery(this.f1314g, null, C0654g.f2279a, new String[]{"participants_buddy_no"}, "participants_inbox_no=?", new String[]{this.f1319l.f1168z}, null);
    }

    /* renamed from: c */
    public void m2357c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_is_new", "N");
        contentValues.put("buddy_is_profile_updated", "N");
        contentValues.put("buddy_is_status_updated", "N");
        this.f1318k.startUpdate(this.f1315h, null, C0667t.f2310a, contentValues, null, null);
    }

    /* renamed from: d */
    public void m2358d() {
        C1341p.m4663f("setNewGroupClear() : ", BuddyFragment.f1090a);
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_is_new", "N");
        this.f1318k.startUpdate(this.f1316i, null, C0661n.f2288a, contentValues, null, null);
    }

    /* renamed from: a */
    public void m2352a(int i) {
        String str;
        String str2;
        Uri uriM3023a;
        String str3;
        int i2 = 0;
        C1341p.m4663f("getBuddyList() : sortStyle=" + i + ", range=" + this.f1319l.f1117aA, BuddyFragment.f1090a);
        String str4 = "";
        if (i == 11) {
            if (this.f1319l.f1117aA != 3) {
                if (this.f1319l.f1117aA != 1) {
                    if (this.f1319l.f1117aA == 2) {
                        uriM3023a = C0668u.m3032a();
                        str = "buddy_name COLLATE LOCALIZED ASC ";
                        str2 = "group_relation_group = " + this.f1319l.f1144b.m2347a();
                    } else {
                        uriM3023a = C0667t.m3026b();
                        if (this.f1319l.f1143az) {
                            if (this.f1319l.f1094D != null) {
                                String[] strArr = this.f1319l.f1094D;
                                StringBuffer stringBuffer = new StringBuffer();
                                if (strArr.length > 0) {
                                    String str5 = "buddy_no NOT IN ( ";
                                    while (i2 < strArr.length) {
                                        stringBuffer.append(", '" + strArr[i2] + "'");
                                        i2++;
                                    }
                                    str4 = str5 + stringBuffer.toString().substring(1) + " )";
                                }
                            } else if (this.f1319l.f1100J.getString("inboxNO") != null) {
                                str4 = "buddy_no NOT IN (SELECT participants_buddy_no FROM participant WHERE participants_inbox_no = '" + this.f1319l.f1100J.getString("inboxNO") + "')";
                            }
                        }
                        str = "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name, buddy_name COLLATE LOCALIZED ASC";
                        str2 = str4;
                    }
                } else {
                    uriM3023a = C0667t.m3023a();
                    if (this.f1319l.f1143az) {
                        if (this.f1319l.f1094D != null) {
                            String[] strArr2 = this.f1319l.f1094D;
                            StringBuffer stringBuffer2 = new StringBuffer();
                            if (strArr2.length <= 0) {
                                str3 = "";
                            } else {
                                String str6 = "buddy_no NOT IN ( ";
                                while (i2 < strArr2.length) {
                                    stringBuffer2.append(", '" + strArr2[i2] + "'");
                                    i2++;
                                }
                                str3 = str6 + stringBuffer2.toString().substring(1) + " )";
                            }
                            str4 = str3;
                        } else if (this.f1319l.f1100J.getString("inboxNO") != null) {
                            str4 = "buddy_no NOT IN (SELECT participants_buddy_no FROM participant WHERE participants_inbox_no = '" + this.f1319l.f1100J.getString("inboxNO") + "')";
                        }
                    }
                    str = "group_type, buddy_name COLLATE LOCALIZED ASC";
                    str2 = str4;
                }
            } else {
                uriM3023a = C0667t.m3030e();
                String[] strArr3 = this.f1319l.f1094D;
                StringBuffer stringBuffer3 = new StringBuffer();
                if (strArr3.length > 0) {
                    String str7 = "buddy_no IN ( ";
                    while (i2 < strArr3.length) {
                        stringBuffer3.append(", '" + strArr3[i2] + "'");
                        i2++;
                    }
                    str = "group_type, buddy_name COLLATE LOCALIZED ASC";
                    str2 = str7 + stringBuffer3.toString().substring(1) + " )";
                } else {
                    return;
                }
            }
        } else if (i == 12) {
            uriM3023a = C0667t.m3028c();
            str = "group_type, relation_icon DESC, buddy_name COLLATE LOCALIZED ASC";
            str2 = "";
        } else if (i != 21) {
            str = null;
            str2 = "";
            uriM3023a = null;
        } else {
            uriM3023a = C0667t.m3023a();
            str = "group_type, buddy_name COLLATE LOCALIZED ASC";
            str2 = "";
        }
        if (uriM3023a != null) {
            C1341p.m4663f("URI : " + uriM3023a.toString(), BuddyFragment.f1090a);
            C1341p.m4663f("WHERE : " + str2, BuddyFragment.f1090a);
            C1341p.m4663f("WHERE ARGS : " + ((Object) null), BuddyFragment.f1090a);
            C1341p.m4663f("ORDER BY : " + str, BuddyFragment.f1090a);
        }
        this.f1318k.startQuery(i, null, uriM3023a, null, str2, null, str);
    }

    /* renamed from: a */
    public void m2354a(String str) {
        this.f1318k.startQuery(this.f1317j, str, C0667t.m3029d(), null, "buddy_no = ? ", new String[]{str}, null);
    }

    /* renamed from: e */
    public void m2359e() {
        Uri uriM3026b = C0667t.m3026b();
        String str = "";
        String[] stringArray = this.f1319l.f1100J.getStringArray(ChatFragment.f1730c);
        StringBuffer stringBuffer = new StringBuffer();
        if (stringArray.length > 0) {
            String str2 = "buddy_no NOT IN ( ";
            for (String str3 : stringArray) {
                stringBuffer.append(", '" + str3 + "'");
            }
            str = str2 + stringBuffer.toString().substring(1) + " )";
        }
        this.f1318k.startQuery(70, null, uriM3026b, null, str, null, "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name, buddy_name COLLATE LOCALIZED ASC");
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo880a(int i, Object obj, Cursor cursor) {
        C1341p.m4663f("onQueryComplete() : " + i + ", range=" + this.f1319l.f1117aA, BuddyFragment.f1090a);
        if (this.f1319l.getActivity() != null && cursor != null) {
            this.f1319l.f1121ad = false;
            this.f1319l.m2088E();
            if (i == this.f1312e) {
                int count = cursor.getCount();
                cursor.close();
                this.f1319l.f1138au = count;
                if (!this.f1319l.f1143az) {
                    this.f1319l.f1158p.setHint(this.f1319l.getResources().getString(R.string.buddy_all_count, Integer.valueOf(this.f1319l.f1138au)));
                } else {
                    this.f1319l.f1158p.setHint(R.string.buddy_list_search_hint);
                }
                C1341p.m4663f("BUDDY COUNT : " + count + ", " + this.f1319l.f1103M, BuddyFragment.f1090a);
                if (count > 0) {
                    this.f1319l.m2167n();
                } else {
                    if (this.f1319l.f1103M == 1) {
                        this.f1319l.m2164m();
                    } else if (this.f1319l.f1103M == 5) {
                        C1619g.m5889a(this.f1319l.f1153k, this.f1319l.getResources().getString(R.string.buddy_list_invite_toast_failed_nomore), 0).show();
                        Intent intent = new Intent();
                        intent.putExtra("receivers", new String[0]);
                        this.f1319l.getActivity().setResult(0, intent);
                        this.f1319l.getActivity().finish();
                    } else if (this.f1319l.f1103M == 6) {
                        this.f1319l.m2167n();
                    }
                    if (this.f1319l.f1133ap != null) {
                        this.f1319l.f1133ap.mo2219b(0);
                    }
                }
            } else if (i == this.f1314g) {
                if (cursor != null && cursor.getCount() != 0) {
                    ArrayList arrayList = new ArrayList(cursor.getCount());
                    int columnIndex = cursor.getColumnIndex("participants_buddy_no");
                    while (cursor.moveToNext()) {
                        if (!cursor.isNull(columnIndex)) {
                            arrayList.add(cursor.getString(columnIndex));
                        }
                    }
                    cursor.close();
                    this.f1319l.f1094D = (String[]) arrayList.toArray(new String[arrayList.size()]);
                    this.f1319l.f1114X.m2351a();
                } else {
                    return;
                }
            } else if (i == this.f1313f) {
                int count2 = cursor.getCount();
                cursor.close();
                if (count2 >= 50) {
                    C1619g.m5889a(this.f1319l.getActivity(), String.format(this.f1319l.getResources().getString(R.string.buddy_list_addfavorites_toast_failed_50), 50), 0).show();
                } else {
                    C0363a c0363a = (C0363a) obj;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("group_relation_group", (Integer) 1);
                    contentValues.put("group_relation_buddy", c0363a.m2308a());
                    this.f1318k.startInsert(this.f1319l.f1114X.f1308a, c0363a, C0668u.f2311a, contentValues);
                }
            } else if (i == this.f1317j) {
                if (cursor == null || cursor.getCount() <= 0) {
                    C0363a c0363aM2117a = this.f1319l.m2117a(obj.toString(), this.f1319l.f1107Q);
                    Intent intent2 = new Intent(this.f1319l.f1153k, (Class<?>) BuddyProfileActivity.class);
                    intent2.putExtra("PROFILE_BUDDY_NO", String.valueOf(obj.toString()));
                    intent2.putExtra("PROFILE_BUDDY_NAME", c0363aM2117a.m2314b());
                    this.f1319l.f1153k.startActivity(intent2);
                } else {
                    Intent intentM630a = HomeActivity.m630a((Context) this.f1319l.getActivity(), true);
                    intentM630a.putExtra("chatType", EnumC0665r.ONETOONE.m3012a());
                    intentM630a.putExtra("receivers", new String[]{String.valueOf(obj)});
                    if (this.f1319l.f1122ae) {
                        intentM630a.putExtra("content_type", this.f1319l.f1123af);
                        intentM630a.putExtra("download_uri", this.f1319l.f1124ag);
                        intentM630a.putExtra("sub_content", this.f1319l.f1125ah);
                    }
                    this.f1319l.startActivity(intentM630a);
                }
            } else if (i == 11) {
                if (this.f1319l.f1117aA == 3) {
                    this.f1319l.m2150f(cursor);
                } else if (this.f1319l.f1117aA == 2) {
                    this.f1319l.m2153g(cursor);
                } else if (this.f1319l.f1117aA == 1) {
                    this.f1319l.m2147e(cursor);
                } else {
                    this.f1319l.m2143d(cursor);
                }
                this.f1319l.m2197a(this.f1319l.f1107Q);
                if (this.f1319l.f1106P.size() < 1) {
                    this.f1319l.f1096F.setVisibility(8);
                    this.f1319l.f1156n.setVisibility(8);
                    this.f1319l.f1161s.setVisibility(0);
                }
                this.f1319l.m2125a(this.f1319l.f1106P, this.f1319l.f1107Q);
            } else if (i == 12) {
                this.f1319l.m2155h(cursor);
                this.f1319l.m2125a(this.f1319l.f1106P, this.f1319l.f1107Q);
            } else if (i == 21) {
                this.f1319l.m2156i(cursor);
                if (this.f1319l.f1110T.size() > 0) {
                    this.f1319l.f1156n.setVisibility(0);
                    this.f1319l.f1160r.setVisibility(8);
                } else {
                    this.f1319l.f1156n.setVisibility(8);
                    this.f1319l.f1160r.setVisibility(0);
                }
                this.f1319l.m2125a(this.f1319l.f1110T, this.f1319l.f1111U);
            } else if (i == 70) {
                if (cursor.getCount() <= 0) {
                    this.f1319l.f1129al.setText(this.f1319l.getResources().getString(R.string.buddy_list_invite_toast_failed_nomore));
                    this.f1319l.f1129al.setDuration(0);
                    this.f1319l.f1129al.show();
                } else {
                    Intent intent3 = new Intent(this.f1319l.getActivity(), (Class<?>) BuddyActivity2.class);
                    intent3.putExtra("ACTIVITY_PURPOSE", 5);
                    intent3.putExtra(ChatFragment.f1730c, this.f1319l.f1094D);
                    intent3.putExtra("chatType", this.f1319l.f1093C);
                    this.f1319l.startActivityForResult(intent3, 5);
                }
            }
            if (i == 11 || i == 12 || i == 21) {
                this.f1319l.m2178t();
                if (i == 11) {
                    this.f1319l.f1156n.setFastScrollEnabled(false);
                    this.f1319l.f1113W.m2361a();
                    this.f1319l.f1156n.setFastScrollEnabled(true);
                } else {
                    this.f1319l.f1156n.setFastScrollEnabled(false);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo881a(int i, Object obj, Uri uri) {
        if (this.f1319l.getActivity() != null && i == this.f1308a) {
            C0363a c0363a = (C0363a) obj;
            if (Integer.parseInt(uri.getLastPathSegment()) != -1) {
                this.f1319l.f1129al.setText(this.f1319l.getString(R.string.buddy_list_addfavorites_toast_success, c0363a.m2314b()));
                this.f1319l.f1129al.setDuration(0);
                this.f1319l.f1129al.show();
                this.f1319l.m2169o();
                return;
            }
            C1619g.m5889a(this.f1319l.getActivity(), this.f1319l.getResources().getString(R.string.buddy_list_addfavorites_toast_failed), 0).show();
        }
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo879a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: b */
    public void mo882b(int i, Object obj, int i2) throws Resources.NotFoundException {
        if (this.f1319l.getActivity() != null && i == this.f1309b) {
            if (i2 != -1) {
                this.f1319l.f1129al.setText(R.string.buddy_list_removefavorites_toast_success);
                this.f1319l.f1129al.setDuration(0);
                this.f1319l.f1129al.show();
                this.f1319l.m2169o();
                return;
            }
            C1619g.m5889a(this.f1319l.getActivity(), this.f1319l.getResources().getString(R.string.buddy_list_removefavorites_toast_failed), 0).show();
        }
    }
}
