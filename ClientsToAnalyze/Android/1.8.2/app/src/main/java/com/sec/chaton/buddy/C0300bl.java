package com.sec.chaton.buddy;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.p017e.C0688c;
import com.sec.chaton.p017e.C0691f;
import com.sec.chaton.p017e.C0692g;
import com.sec.chaton.p017e.C0702q;
import com.sec.chaton.p017e.C0704s;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bl */
/* loaded from: classes.dex */
public class C0300bl implements InterfaceC0667k {

    /* renamed from: a */
    public int f1395a = 1;

    /* renamed from: b */
    public int f1396b = 2;

    /* renamed from: c */
    public int f1397c = 3;

    /* renamed from: d */
    public int f1398d = 4;

    /* renamed from: e */
    public int f1399e = 5;

    /* renamed from: f */
    public int f1400f = 6;

    /* renamed from: g */
    public int f1401g = 8;

    /* renamed from: h */
    public int f1402h = 9;

    /* renamed from: i */
    public int f1403i = 50;

    /* renamed from: j */
    public int f1404j = 51;

    /* renamed from: k */
    public int f1405k = 10;

    /* renamed from: l */
    public int f1406l = 20;

    /* renamed from: m */
    public int f1407m = 61;

    /* renamed from: n */
    public int f1408n = 62;

    /* renamed from: o */
    C0666j f1409o;

    /* renamed from: p */
    final /* synthetic */ BuddyFragment f1410p;

    public C0300bl(BuddyFragment buddyFragment) {
        this.f1410p = buddyFragment;
        this.f1409o = null;
        this.f1409o = new C0666j(buddyFragment.getActivity().getContentResolver(), this);
    }

    /* renamed from: a */
    public void m2372a(C0257c c0257c) {
        this.f1409o.startQuery(this.f1400f, c0257c, C0691f.f2613a, null, "group_relation_group = 1 ", null, null);
    }

    /* renamed from: b */
    public void m2375b(C0257c c0257c) {
        this.f1409o.startDelete(this.f1396b, c0257c, C0691f.f2613a, "group_relation_group = 1 AND group_relation_buddy = ? ", new String[]{c0257c.m2318a()});
    }

    /* renamed from: c */
    public void m2378c(C0257c c0257c) {
        this.f1409o.startQuery(this.f1403i, c0257c, C0704s.f2647a, null, "buddy_no=?", new String[]{c0257c.m2318a()}, null);
    }

    /* renamed from: d */
    public void m2380d(C0257c c0257c) {
        this.f1409o.startQuery(this.f1404j, c0257c, C0704s.f2647a, null, "buddy_no=?", new String[]{c0257c.m2318a()}, null);
    }

    /* renamed from: a */
    public void m2370a() {
        this.f1409o.startQuery(this.f1399e, null, C0688c.f2606a, new String[]{"buddy_no"}, null, null, null);
    }

    /* renamed from: b */
    public void m2374b() {
        this.f1409o.startQuery(this.f1402h, null, C0704s.f2647a, new String[]{"buddy_no"}, null, null, null);
    }

    /* renamed from: c */
    public void m2377c() {
        this.f1409o.startQuery(this.f1401g, null, C0702q.f2645a, new String[]{"buddy_no"}, "type='200'", null, null);
    }

    /* renamed from: d */
    public void m2379d() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_is_new", "N");
        contentValues.put("buddy_is_profile_updated", "N");
        contentValues.put("buddy_is_status_updated", "N");
        this.f1409o.startUpdate(this.f1405k, null, C0688c.f2606a, contentValues, null, null);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("isNew", "N");
        this.f1409o.startUpdate(this.f1405k, null, C0704s.f2647a, contentValues2, null, null);
    }

    /* renamed from: e */
    public void m2381e() {
        C1786r.m6067f("setNewGroupClear() : ", BuddyFragment.f908a);
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_is_new", "N");
        this.f1409o.startUpdate(this.f1406l, null, C0692g.f2614a, contentValues, null, null);
    }

    /* renamed from: a */
    public void m2371a(int i) {
        String str;
        String str2;
        Uri uriM3129g;
        String str3;
        int i2 = 0;
        if (i == 11) {
            if (this.f1410p.f969af != 6) {
                if (this.f1410p.f969af == 5) {
                    uriM3129g = C0688c.m3123b();
                    String[] stringArray = this.f1410p.f966ac.getStringArray(ChatFragment.f1749e);
                    StringBuffer stringBuffer = new StringBuffer();
                    if (stringArray.length <= 0) {
                        str3 = "";
                    } else {
                        String str4 = "buddy_no NOT IN ( ";
                        while (i2 < stringArray.length) {
                            stringBuffer.append(", '" + stringArray[i2] + "'");
                            i2++;
                        }
                        str3 = str4 + stringBuffer.toString().substring(1) + " )";
                    }
                    str = "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name, buddy_name COLLATE LOCALIZED ASC";
                    str2 = str3;
                } else {
                    uriM3129g = C0688c.m3123b();
                    str = "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name, buddy_name COLLATE LOCALIZED ASC";
                    str2 = "";
                }
            } else {
                uriM3129g = C0688c.m3127e();
                String[] stringArray2 = this.f1410p.f966ac.getStringArray(ChatFragment.f1749e);
                StringBuffer stringBuffer2 = new StringBuffer();
                if (stringArray2.length > 0) {
                    String str5 = "buddy_no IN ( ";
                    while (i2 < stringArray2.length) {
                        stringBuffer2.append(", '" + stringArray2[i2] + "'");
                        i2++;
                    }
                    str = "group_type, buddy_name COLLATE LOCALIZED ASC";
                    str2 = str5 + stringBuffer2.toString().substring(1) + " )";
                } else {
                    return;
                }
            }
        } else if (i == 12) {
            if (this.f1410p.f996bi == 3) {
                uriM3129g = C0688c.m3127e();
                String[] strArr = this.f1410p.f938Z;
                StringBuffer stringBuffer3 = new StringBuffer();
                if (strArr.length > 0) {
                    String str6 = "buddy_no IN ( ";
                    while (i2 < strArr.length) {
                        stringBuffer3.append(", '" + strArr[i2] + "'");
                        i2++;
                    }
                    String str7 = str6 + stringBuffer3.toString().substring(1) + " )";
                    String str8 = "group_type, relation_point DESC, buddy_name COLLATE LOCALIZED ASC";
                    if (this.f1410p.f969af == 6 && this.f1410p.f966ac.containsKey("ACTIVITY_PURPOSE_ARG") && this.f1410p.f966ac.getBoolean("ACTIVITY_PURPOSE_ARG")) {
                        str8 = "group_type, relation_point DESC, buddy_name COLLATE LOCALIZED ASC LIMIT 10";
                    }
                    str = str8;
                    str2 = str7;
                } else {
                    return;
                }
            } else {
                uriM3129g = C0688c.m3125c();
                str = "group_type, relation_point DESC, buddy_name COLLATE LOCALIZED ASC";
                str2 = "";
            }
        } else if (i != 21) {
            str = null;
            str2 = "";
            uriM3129g = null;
        } else {
            uriM3129g = C0688c.m3129g();
            str = "group_type, buddy_name COLLATE LOCALIZED ASC";
            str2 = "";
        }
        if (uriM3129g != null) {
            C1786r.m6067f("URI : " + uriM3129g.toString(), BuddyFragment.f908a);
            C1786r.m6067f("WHERE : " + str2, BuddyFragment.f908a);
            C1786r.m6067f("WHERE ARGS : " + ((Object) null), BuddyFragment.f908a);
            C1786r.m6067f("ORDER BY : " + str, BuddyFragment.f908a);
        }
        if (this.f1410p.f989az != null && this.f1410p.f989az.isShowing()) {
            this.f1410p.f989az.dismiss();
        }
        this.f1409o.startQuery(i, null, uriM3129g, null, str2, null, str);
    }

    /* renamed from: a */
    public void m2373a(String str) {
        this.f1409o.startQuery(this.f1407m, str, C0688c.m3126d(), null, "buddy_no = ? ", new String[]{str}, null);
    }

    /* renamed from: b */
    public void m2376b(String str) {
        this.f1409o.startQuery(this.f1408n, str, C0704s.f2647a, null, "buddy_no = ? ", new String[]{str}, null);
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onQueryComplete(int i, Object obj, Cursor cursor) throws NumberFormatException {
        if (this.f1410p.getActivity() != null && cursor != null) {
            this.f1410p.f941aC = false;
            if (this.f1410p.f989az != null && this.f1410p.f989az.isShowing()) {
                this.f1410p.f989az.dismiss();
            }
            if (i == this.f1399e) {
                int count = cursor.getCount();
                cursor.close();
                this.f1410p.f994bg = count;
                if (this.f1410p.f969af == 5 || this.f1410p.f969af == 8) {
                    this.f1410p.f1024z.setHint(R.string.buddy_list_search_hint);
                } else {
                    this.f1410p.f1024z.setHint(this.f1410p.getResources().getString(R.string.buddy_all_count, Integer.valueOf(this.f1410p.f994bg + this.f1410p.f995bh)));
                    this.f1410p.f1024z.setText("");
                }
                if (count > 0) {
                    this.f1410p.m1898A();
                } else if (this.f1410p.f969af == 1) {
                    if (!this.f1410p.f942aD) {
                        this.f1410p.f1024z.setVisibility(0);
                        this.f1410p.m2031z();
                    }
                } else if (this.f1410p.f969af == 5) {
                    Toast.makeText(this.f1410p.f1018t, this.f1410p.getResources().getString(R.string.buddy_list_invite_toast_failed_nomore), 0).show();
                    Intent intent = new Intent();
                    intent.putExtra("receivers", new String[0]);
                    this.f1410p.getActivity().setResult(0, intent);
                    this.f1410p.getActivity().finish();
                } else if (this.f1410p.f969af == 6) {
                    this.f1410p.m1898A();
                } else if (this.f1410p.f969af != 9) {
                    if (this.f1410p.f969af == 19 && GlobalApplication.m3265f()) {
                        this.f1410p.m2051h().findItem(R.id.actionbar_title_done).setEnabled(false);
                    }
                } else if (GlobalApplication.m3265f()) {
                    this.f1410p.m2051h().findItem(R.id.actionbar_menu_done).setEnabled(false);
                }
            } else if (i == this.f1402h) {
                int count2 = cursor.getCount();
                cursor.close();
                this.f1410p.f995bh = count2;
                if (this.f1410p.f969af == 5 || this.f1410p.f969af == 8) {
                    this.f1410p.f1024z.setHint(R.string.buddy_list_search_hint);
                } else {
                    this.f1410p.f1024z.setHint(this.f1410p.getResources().getString(R.string.buddy_all_count, Integer.valueOf(this.f1410p.f994bg + this.f1410p.f995bh)));
                }
                if (count2 > 0) {
                    this.f1410p.f942aD = true;
                    this.f1410p.m1898A();
                } else {
                    this.f1410p.f942aD = false;
                }
            } else if (i == this.f1400f) {
                int count3 = cursor.getCount();
                cursor.close();
                if (count3 >= 50) {
                    Toast.makeText(this.f1410p.getActivity(), String.format(this.f1410p.getResources().getString(R.string.buddy_list_addfavorites_toast_failed_50), 50), 0).show();
                } else {
                    C0257c c0257c = (C0257c) obj;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("group_relation_group", (Integer) 1);
                    contentValues.put("group_relation_buddy", c0257c.m2318a());
                    this.f1409o.startInsert(this.f1410p.f981ar.f1395a, c0257c, C0691f.f2613a, contentValues);
                }
            } else if (i == this.f1403i) {
                cursor.moveToFirst();
                boolean zEquals = cursor.getString(cursor.getColumnIndex("islike")).equals("Y");
                int i2 = Integer.parseInt(cursor.getString(cursor.getColumnIndex("likecount")));
                String string = cursor.getString(cursor.getColumnIndex("buddy_no"));
                cursor.close();
                if (!zEquals) {
                    new C0633e(null).m2876d(string);
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("islike", "Y");
                    contentValues2.put("likecount", Integer.valueOf(i2 + 1));
                    this.f1409o.startUpdate(this.f1403i, obj, C0704s.f2647a, contentValues2, "buddy_no='" + string + "'", null);
                }
            } else if (i == this.f1404j) {
                cursor.moveToFirst();
                boolean zEquals2 = cursor.getString(cursor.getColumnIndex("islike")).equals("Y");
                int i3 = Integer.parseInt(cursor.getString(cursor.getColumnIndex("likecount")));
                String string2 = cursor.getString(cursor.getColumnIndex("buddy_no"));
                cursor.close();
                if (zEquals2) {
                    new C0633e(null).m2880e(string2);
                    ContentValues contentValues3 = new ContentValues();
                    contentValues3.put("islike", "N");
                    if (i3 > 0) {
                        contentValues3.put("likecount", Integer.valueOf(i3 - 1));
                    }
                    this.f1409o.startUpdate(this.f1404j, obj, C0704s.f2647a, contentValues3, "buddy_no='" + string2 + "'", null);
                }
            } else if (i == this.f1408n) {
                if (cursor == null || cursor.getCount() <= 0) {
                    this.f1410p.m1947a(obj.toString(), this.f1410p.f973aj);
                } else {
                    String strValueOf = String.valueOf(obj);
                    Intent intent2 = new Intent();
                    intent2.putExtra("specialuserid", strValueOf);
                    intent2.putExtra("specialBuddyAdded", true);
                    SpecialBuddyProfileFragment specialBuddyProfileFragment = new SpecialBuddyProfileFragment();
                    specialBuddyProfileFragment.setArguments(intent2.getExtras());
                    this.f1410p.getFragmentManager().beginTransaction().replace(R.id.fragment_container, specialBuddyProfileFragment, "container").commit();
                }
            } else if (i == this.f1407m) {
                if (!this.f1410p.f943aE) {
                    if (this.f1410p.f969af != 6 || this.f1410p.f963aY != 101) {
                        if (this.f1410p.f969af == 6) {
                            Intent intent3 = new Intent(this.f1410p.f1018t, (Class<?>) BuddyProfileActivity.class);
                            intent3.putExtra("PROFILE_BUDDY_NO", String.valueOf(obj));
                            intent3.putExtra("PROFILE_BUDDY_NAME", "");
                            intent3.setFlags(268435456);
                            this.f1410p.f1018t.startActivity(intent3);
                        } else if (cursor != null && cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            String string3 = cursor.getString(cursor.getColumnIndex("buddy_name"));
                            Intent intent4 = new Intent();
                            intent4.putExtra("ACTIVITY_PURPOSE", 16);
                            intent4.putExtra("PROFILE_BUDDY_NO", String.valueOf(obj));
                            intent4.putExtra("PROFILE_BUDDY_NAME", string3);
                            intent4.putExtra("BUDDY_PROFILE_UI_TYPE", 1);
                            BuddyProfileFragment buddyProfileFragment = new BuddyProfileFragment();
                            buddyProfileFragment.setArguments(intent4.getExtras());
                            this.f1410p.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, buddyProfileFragment, "container").commit();
                        }
                    } else {
                        Intent intentM585a = HomeActivity.m585a((Context) this.f1410p.getActivity(), true);
                        intentM585a.putExtra("chatType", EnumC0695j.ONETOONE.m3146a());
                        intentM585a.putExtra("receivers", new String[]{String.valueOf(obj)});
                        this.f1410p.startActivity(intentM585a);
                    }
                } else if (cursor != null && cursor.getCount() > 0) {
                    Intent intentM585a2 = HomeActivity.m585a((Context) this.f1410p.getActivity(), true);
                    intentM585a2.putExtra("chatType", EnumC0695j.ONETOONE.m3146a());
                    intentM585a2.putExtra("receivers", new String[]{String.valueOf(obj)});
                    if (this.f1410p.f943aE) {
                        intentM585a2.putExtra("content_type", this.f1410p.f944aF);
                        intentM585a2.putExtra("download_uri", this.f1410p.f945aG);
                        intentM585a2.putExtra("sub_content", this.f1410p.f946aH);
                        intentM585a2.putExtra("forward_sender_name", this.f1410p.f1011m);
                    }
                    this.f1410p.startActivity(intentM585a2);
                }
            } else if (i == 11) {
                if (this.f1410p.f969af == 6) {
                    this.f1410p.m1999g(cursor);
                } else if (this.f1410p.f969af == 8) {
                    this.f1410p.m1994f(cursor);
                } else {
                    this.f1410p.m1994f(cursor);
                    if (GlobalApplication.m3265f() && this.f1410p.f969af == 11 && this.f1410p.f950aL != null && this.f1410p.f950aL.size() > 0) {
                        Iterator it = this.f1410p.f950aL.iterator();
                        while (it.hasNext()) {
                            ArrayList arrayListM1998g = this.f1410p.m1998g((String) it.next());
                            if (arrayListM1998g != null && arrayListM1998g.size() > 0) {
                                Iterator it2 = arrayListM1998g.iterator();
                                while (it2.hasNext()) {
                                    C0257c c0257c2 = (C0257c) it2.next();
                                    c0257c2.m2322a(true);
                                    this.f1410p.f997bj.mo2367a(c0257c2);
                                }
                            }
                        }
                    }
                }
                this.f1410p.m1975b(this.f1410p.f972ai, this.f1410p.f973aj);
                if (this.f1410p.f969af == 9) {
                    HashSet hashSetM1927O = this.f1410p.m1927O();
                    C1786r.m6061b("MJ checkedBuddy size : " + hashSetM1927O.size(), "MJ");
                    if (hashSetM1927O != null && hashSetM1927O.size() > 0) {
                        Iterator it3 = hashSetM1927O.iterator();
                        while (it3.hasNext()) {
                            ArrayList arrayListM1998g2 = this.f1410p.m1998g((String) it3.next());
                            if (arrayListM1998g2 != null && arrayListM1998g2.size() > 0) {
                                Iterator it4 = arrayListM1998g2.iterator();
                                while (it4.hasNext()) {
                                    C0257c c0257c3 = (C0257c) it4.next();
                                    c0257c3.m2322a(true);
                                    this.f1410p.f997bj.mo2367a(c0257c3);
                                }
                            }
                        }
                    }
                }
            } else if (i == 12) {
                this.f1410p.m2001h(cursor);
                this.f1410p.m1975b(this.f1410p.f972ai, this.f1410p.f973aj);
            } else if (i == 21) {
                if (this.f1410p.f1024z == null || !TextUtils.isEmpty(this.f1410p.f1024z.getText().toString())) {
                    this.f1410p.m2003i(cursor);
                    this.f1410p.f980aq.m2451a(21);
                    if (this.f1410p.f976am.size() > 0) {
                        this.f1410p.f1021w.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
                        this.f1410p.f916D.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
                    } else {
                        this.f1410p.f1021w.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
                        this.f1410p.f916D.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
                    }
                    this.f1410p.m1975b(this.f1410p.f976am, this.f1410p.f977an);
                } else {
                    cursor.close();
                    this.f1410p.m1903C();
                    return;
                }
            } else if (i == this.f1401g) {
                boolean z = C1789u.m6075a().getBoolean("recomned_receive", true);
                this.f1410p.f957aS = 0;
                if (cursor != null) {
                    this.f1410p.f957aS = cursor.getCount();
                    cursor.close();
                }
                if (!z) {
                    if (z) {
                        this.f1410p.m2040b(this.f1410p.f957aS);
                    } else {
                        this.f1410p.m2040b(0);
                    }
                }
            } else if (i == 200) {
                if (cursor.getCount() > 0) {
                    Intent intent5 = new Intent(this.f1410p.getActivity(), (Class<?>) BuddySelectActivity.class);
                    intent5.putExtra("inboxNO", this.f1410p.f934V);
                    intent5.putExtra(ChatFragment.f1753i, this.f1410p.f921I);
                    intent5.putExtra(ChatFragment.f1749e, this.f1410p.f938Z);
                    intent5.putExtra("chatType", this.f1410p.f937Y);
                    intent5.putExtra("chatType", this.f1410p.f937Y);
                    intent5.putExtra("ACTIVITY_PURPOSE", 5);
                    intent5.putExtra("ACTION_PURPOSE", 6);
                    this.f1410p.startActivityForResult(intent5, 5);
                } else {
                    Toast.makeText(this.f1410p.getActivity(), R.string.all_buddies_already_included_toast, 0).show();
                }
            }
            if (i == 11 || i == 12 || i == 21) {
                this.f1410p.m1915I();
                if (i == 11) {
                    this.f1410p.f1021w.setFastScrollEnabled(false);
                    this.f1410p.f980aq.m2450a();
                    this.f1410p.f1021w.setFastScrollEnabled(true);
                } else {
                    this.f1410p.f1021w.setFastScrollEnabled(false);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            if (GlobalApplication.m3265f()) {
                if (this.f1410p.f969af == 11) {
                    this.f1410p.f980aq.m2454a(this.f1410p.f983at);
                    ArrayList arrayListM2049f = this.f1410p.m2049f();
                    String[] strArr = (String[]) arrayListM2049f.toArray(new String[arrayListM2049f.size()]);
                    C1786r.m6067f("PARUL: mExistSelectedMember count:" + arrayListM2049f.size(), BuddyFragment.f908a);
                    this.f1410p.f980aq.m2458a(strArr, true);
                    this.f1410p.f984au.setVisibility(0);
                    this.f1410p.f985av.setText(String.format("%d/%d", Integer.valueOf(arrayListM2049f.size()), Integer.valueOf(this.f1410p.f994bg)));
                }
                if (this.f1410p.f969af == 10) {
                    this.f1410p.f984au.setVisibility(0);
                    this.f1410p.f985av.setText(String.format("0/%d", Integer.valueOf(this.f1410p.f994bg)));
                }
            }
            this.f1410p.getActivity().invalidateOptionsMenu();
        }
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onInsertComplete(int i, Object obj, Uri uri) {
        if (this.f1410p.getActivity() != null && i == this.f1395a) {
            C0257c c0257c = (C0257c) obj;
            if (Integer.parseInt(uri.getLastPathSegment()) != -1) {
                Toast.makeText(this.f1410p.getActivity(), this.f1410p.getString(R.string.buddy_list_addfavorites_toast_success, c0257c.m2324b()), 0).show();
                this.f1410p.m1901B();
            } else {
                Toast.makeText(this.f1410p.getActivity(), this.f1410p.getResources().getString(R.string.buddy_list_addfavorites_toast_failed), 0).show();
            }
        }
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onUpdateComplete(int i, Object obj, int i2) {
        if (this.f1410p.getActivity() != null) {
            if (i == this.f1403i) {
                if (i2 != -1) {
                }
            } else if (i == this.f1404j) {
                if (i2 != -1) {
                }
            }
        }
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onDeleteComplete(int i, Object obj, int i2) throws Resources.NotFoundException {
        if (this.f1410p.getActivity() != null && i == this.f1396b) {
            if (i2 != -1) {
                Toast.makeText(this.f1410p.getActivity(), R.string.buddy_list_removefavorites_toast_success, 0).show();
                this.f1410p.m1901B();
            } else {
                Toast.makeText(this.f1410p.getActivity(), this.f1410p.getResources().getString(R.string.buddy_list_removefavorites_toast_failed), 0).show();
            }
        }
    }
}
