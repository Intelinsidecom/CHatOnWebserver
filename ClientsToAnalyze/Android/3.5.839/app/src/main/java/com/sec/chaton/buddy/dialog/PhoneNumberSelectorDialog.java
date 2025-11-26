package com.sec.chaton.buddy.dialog;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.sec.chaton.R;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.passwordlock.PasswordLockActivity;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.smsplugin.p102b.C3789h;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class PhoneNumberSelectorDialog extends PasswordLockActivity {

    /* renamed from: b */
    public static final String f4640b = PhoneNumberSelectorDialog.class.getSimpleName();

    /* renamed from: a */
    Context f4641a;

    /* renamed from: c */
    List<CharSequence> f4642c;

    /* renamed from: d */
    private int f4643d;

    /* renamed from: e */
    private String f4644e;

    /* renamed from: f */
    private String f4645f;

    /* renamed from: g */
    private String f4646g;

    /* renamed from: h */
    private String f4647h;

    /* renamed from: i */
    private ArrayList<String> f4648i;

    /* renamed from: j */
    private HashMap<String, String> f4649j;

    /* renamed from: k */
    private boolean f4650k = false;

    /* renamed from: l */
    private String f4651l;

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        this.f4641a = getApplicationContext();
        getWindow().setLayout(-1, -2);
        this.f4643d = getIntent().getExtras().getInt("PN_DIALOG_BUDDY_TYPE");
        this.f4644e = getIntent().getExtras().getString("PN_DIALOG_BUDDY_NAME");
        this.f4645f = getIntent().getExtras().getString("PN_DIALOG_BUDDY_MSISDNS");
        this.f4647h = getIntent().getExtras().getString("PN_DIALOG_BUDDY_PHONE_NUMBERS");
        this.f4646g = getIntent().getExtras().getString("PN_DIALOG_BUDDY_SAMSUNGEMAIL");
        if (getIntent().getExtras().getStringArrayList("PN_DIALOG_BUDDY_PHONE_NUMBERS_EXTERNAL") instanceof List) {
            this.f4648i = getIntent().getExtras().getStringArrayList("PN_DIALOG_BUDDY_PHONE_NUMBERS_EXTERNAL");
        } else if (getIntent().getExtras().getSerializable("PN_DIALOG_BUDDY_PHONE_NUMBERS_EXTERNAL") instanceof Map) {
            this.f4649j = (HashMap) getIntent().getExtras().getSerializable("PN_DIALOG_BUDDY_PHONE_NUMBERS_EXTERNAL");
        }
        this.f4650k = getIntent().getExtras().getBoolean("PN_DIALOG_BUDDY_HAS_EXTERNAL_PHONENUMBER_USE");
        if (this.f4643d == 1) {
            this.f4651l = GlobalApplication.m10283b().getString(R.string.menu_call);
        } else if (this.f4643d == 2) {
            this.f4651l = GlobalApplication.m10283b().getString(R.string.media_contact);
        } else if (this.f4643d == 3 || this.f4643d == 4) {
            this.f4651l = this.f4644e;
        }
        m7341a();
    }

    /* renamed from: a */
    public void m7341a() {
        List<String> listM7335b;
        int i = 0;
        this.f4642c = new ArrayList();
        if (this.f4645f != null) {
            List<String> listM7339d = m7339d();
            while (true) {
                int i2 = i;
                if (i2 >= listM7339d.size()) {
                    break;
                }
                this.f4642c.add("+" + listM7339d.get(i2));
                i = i2 + 1;
            }
        } else {
            if (this.f4650k) {
                listM7335b = m7338c();
            } else {
                listM7335b = m7335b();
            }
            while (true) {
                int i3 = i;
                if (i3 >= listM7335b.size()) {
                    break;
                }
                this.f4642c.add(listM7335b.get(i3));
                i = i3 + 1;
            }
        }
        CharSequence[] charSequenceArr = (CharSequence[]) this.f4642c.toArray(new CharSequence[this.f4642c.size()]);
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this);
        abstractC4932aM18733a.mo18740a(this.f4651l);
        abstractC4932aM18733a.mo18744a(charSequenceArr, new DialogInterfaceOnClickListenerC1206af(this));
        InterfaceC4936e interfaceC4936eMo18745a = abstractC4932aM18733a.mo18745a();
        interfaceC4936eMo18745a.setOnDismissListener(new DialogInterfaceOnDismissListenerC1207ag(this));
        interfaceC4936eMo18745a.setCanceledOnTouchOutside(true);
        interfaceC4936eMo18745a.show();
    }

    /* renamed from: b */
    private List<String> m7335b() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.f4647h)) {
            StringTokenizer stringTokenizer = new StringTokenizer(this.f4647h, ",");
            while (stringTokenizer.hasMoreTokens()) {
                new String();
                arrayList.add(stringTokenizer.nextToken().trim());
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    private List<String> m7338c() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.f4647h)) {
            StringTokenizer stringTokenizer = new StringTokenizer(this.f4647h, " ");
            while (stringTokenizer.hasMoreTokens()) {
                new String();
                arrayList.add(stringTokenizer.nextToken());
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    private List<String> m7339d() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.f4645f)) {
            StringTokenizer stringTokenizer = new StringTokenizer(this.f4645f, "|");
            while (stringTokenizer.hasMoreTokens()) {
                new String();
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.length() >= 19 && strNextToken.startsWith("10")) {
                    C4904y.m18639b("chaton id : " + strNextToken, f4640b);
                } else if (strNextToken.startsWith(Spam.ACTIVITY_CANCEL)) {
                    C4904y.m18639b("pin number : " + strNextToken, f4640b);
                } else {
                    C4904y.m18639b("msisdn: " + strNextToken, f4640b);
                    arrayList.add(strNextToken);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    private String m7337c(String str) {
        return str.replaceAll("\\D+", "");
    }

    /* renamed from: a */
    private boolean m7333a(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        C4904y.m18639b("[isMatchNumber] matching for original Number", f4640b);
        if (length > 8 && length2 > 8) {
            String strSubstring = str.substring(length - 8);
            String strSubstring2 = str2.substring(length2 - 8);
            C4904y.m18639b("[isMatchNumber] matching for contact Number : " + strSubstring2, f4640b);
            if (strSubstring.equals(strSubstring2)) {
                C4904y.m18639b("[isMatchNumber] found match number : " + str2, f4640b);
                return true;
            }
            C4904y.m18639b("[isMatchNumber] phone number not matched", f4640b);
            return false;
        }
        C4904y.m18639b("[isMatchNumber] phone number length is less than 8", f4640b);
        return false;
    }

    /* renamed from: a */
    public void m7342a(String str) {
        Uri uri = null;
        if (0 == 0) {
            uri = Uri.parse("tel:" + C3789h.m14307c(str));
        }
        Intent intent = new Intent("android.intent.action.CALL", uri);
        finish();
        try {
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
        } finally {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m7340d(String str) throws Throwable {
        Cursor cursorQuery;
        int i;
        boolean z = false;
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        try {
            cursorQuery = this.f4641a.getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode("+" + str)), new String[]{SlookAirButtonFrequentContactAdapter.DISPLAY_NAME, "number", "_id"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() <= 0 || !cursorQuery.moveToNext()) {
                        i = 0;
                    } else {
                        i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                        C4904y.m18639b("ContactSaved id : " + i, f4640b);
                        z = true;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            } else {
                i = 0;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (z) {
                long j = i;
                C4904y.m18639b("id: " + j, f4640b);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(uri + "/" + j));
                finish();
                try {
                    try {
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        C4904y.m18635a(e, getClass().getSimpleName());
                        C5179v.m19810a(this.f4641a, R.string.toast_contact_not_found, 0).show();
                    }
                    return;
                } finally {
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString("phone", str);
            bundle.putString("name", this.f4644e);
            bundle.putString("email", this.f4646g);
            C4904y.m18639b("phoneNum: " + str, f4640b);
            C4904y.m18639b("NAME: " + this.f4644e, f4640b);
            Intent intent2 = new Intent("android.intent.action.INSERT", uri);
            intent2.putExtras(bundle);
            intent2.putExtra("return-data", true);
            finish();
            try {
                try {
                    startActivity(intent2);
                } finally {
                }
            } catch (ActivityNotFoundException e2) {
                C4904y.m18635a(e2, getClass().getSimpleName());
                C5179v.m19810a(this.f4641a, R.string.toast_contact_not_found, 0).show();
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:0|2|85|3|(3:82|5|(11:9|(0)(3:(3:80|13|(2:15|(2:91|89)(1:78))(1:88))|(1:22)|23)|(2:75|25)|(1:29)|30|(1:32)|33|73|34|35|36))|72|(0)|(2:27|29)|30|(0)|33|73|34|35|36|(2:(0)|(1:77))) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00e8, code lost:
    
        r7 = android.net.Uri.parse("tel:" + com.sec.chaton.smsplugin.p102b.C3789h.m14307c(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0104, code lost:
    
        r11 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0194, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0195, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r0, getClass().getSimpleName());
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m7343b(java.lang.String r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.dialog.PhoneNumberSelectorDialog.m7343b(java.lang.String):void");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Rect rect = new Rect();
        getWindow().getDecorView().getHitRect(rect);
        if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY()) && motionEvent.getAction() == 0) {
            finish();
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
