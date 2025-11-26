package com.sec.chaton.buddy.dialog;

import android.app.Activity;
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
import com.sec.chaton.base.C0456a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class PhoneNumberSelectorDialog extends Activity {

    /* renamed from: b */
    public static final String f2772b = PhoneNumberSelectorDialog.class.getSimpleName();

    /* renamed from: a */
    Context f2773a;

    /* renamed from: c */
    String f2774c;

    /* renamed from: d */
    String f2775d;

    /* renamed from: e */
    String f2776e;

    /* renamed from: f */
    String f2777f;

    /* renamed from: g */
    private int f2778g;

    /* renamed from: h */
    private String f2779h;

    /* renamed from: i */
    private String f2780i;

    /* renamed from: j */
    private String f2781j;

    /* renamed from: k */
    private String f2782k;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.f2773a = getApplicationContext();
        getWindow().setLayout(-1, -2);
        this.f2778g = getIntent().getExtras().getInt("PN_DIALOG_BUDDY_TYPE");
        this.f2779h = getIntent().getExtras().getString("PN_DIALOG_BUDDY_NAME");
        this.f2780i = getIntent().getExtras().getString("PN_DIALOG_BUDDY_MSISDNS");
        this.f2781j = getIntent().getExtras().getString("PN_DIALOG_BUDDY_SAMSUNGEMAIL");
        if (this.f2778g == 1) {
            this.f2782k = GlobalApplication.m6451b().getString(R.string.menu_call);
        } else {
            this.f2782k = GlobalApplication.m6451b().getString(R.string.media_contact);
        }
        m4276a();
    }

    /* renamed from: a */
    public void m4276a() {
        List<String> listM4273b = m4273b();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < listM4273b.size()) {
                if (i2 == 0) {
                    this.f2774c = "+" + listM4273b.get(i2);
                    arrayList.add(this.f2774c);
                } else if (i2 == 1) {
                    this.f2775d = "+" + listM4273b.get(i2);
                    arrayList.add(this.f2775d);
                } else if (i2 == 2) {
                    this.f2776e = "+" + listM4273b.get(i2);
                    arrayList.add(this.f2776e);
                } else if (i2 == 3) {
                    this.f2777f = "+" + listM4273b.get(i2);
                    arrayList.add(this.f2777f);
                }
                i = i2 + 1;
            } else {
                CharSequence[] charSequenceArr = (CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]);
                AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this);
                abstractC3271aM11494a.mo11500a(this.f2782k);
                abstractC3271aM11494a.mo11504a(charSequenceArr, new DialogInterfaceOnClickListenerC0640v(this));
                InterfaceC3274d interfaceC3274dMo11505a = abstractC3271aM11494a.mo11505a();
                interfaceC3274dMo11505a.setOnDismissListener(new DialogInterfaceOnDismissListenerC0641w(this));
                interfaceC3274dMo11505a.setCanceledOnTouchOutside(true);
                interfaceC3274dMo11505a.show();
                return;
            }
        }
    }

    /* renamed from: b */
    private List<String> m4273b() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.f2780i)) {
            StringTokenizer stringTokenizer = new StringTokenizer(this.f2780i, "|");
            while (stringTokenizer.hasMoreTokens()) {
                new String();
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.length() >= 19 && strNextToken.startsWith("10")) {
                    C3250y.m11450b("chaton id : " + strNextToken, f2772b);
                } else if (strNextToken.startsWith("0")) {
                    C3250y.m11450b("pin number : " + strNextToken, f2772b);
                } else {
                    C3250y.m11450b("msisdn: " + strNextToken, f2772b);
                    arrayList.add(strNextToken);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private String m4272b(String str) {
        return str.replaceAll("\\D+", "");
    }

    /* renamed from: a */
    private boolean m4271a(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        C3250y.m11450b("[isMatchNumber] matching for original Number : " + ((String) null), f2772b);
        if (length > 8 && length2 > 8) {
            String strSubstring = str.substring(length - 8);
            String strSubstring2 = str2.substring(length2 - 8);
            C3250y.m11450b("[isMatchNumber] matching for contact Number : " + strSubstring2, f2772b);
            if (strSubstring.equals(strSubstring2)) {
                C3250y.m11450b("[isMatchNumber] found match number : " + str2, f2772b);
                return true;
            }
            C3250y.m11450b("[isMatchNumber] phone number not matched", f2772b);
            return false;
        }
        C3250y.m11450b("[isMatchNumber] phone number length is less than 8", f2772b);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00dd, code lost:
    
        r7 = android.net.Uri.parse("tel:" + r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x012b  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m4277a(java.lang.String r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.dialog.PhoneNumberSelectorDialog.m4277a(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4275c(String str) {
        int i;
        boolean z = false;
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        Cursor cursorQuery = this.f2773a.getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode("+" + str)), new String[]{SlookAirButtonFrequentContactAdapter.DISPLAY_NAME, "number", "_id"}, null, null, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0 || !cursorQuery.moveToNext()) {
            i = 0;
        } else {
            i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
            C3250y.m11450b("ContactSaved id : " + i, f2772b);
            z = true;
        }
        if (!z) {
            Bundle bundle = new Bundle();
            bundle.putString("phone", str);
            bundle.putString("name", this.f2779h);
            bundle.putString("email", this.f2781j);
            C3250y.m11450b("phoneNum: " + str, f2772b);
            C3250y.m11450b("NAME: " + this.f2779h, f2772b);
            Intent intent = new Intent("android.intent.action.INSERT", uri);
            intent.putExtras(bundle);
            intent.putExtra("return-data", true);
            finish();
            try {
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    C3250y.m11443a(e, getClass().getSimpleName());
                    C3641ai.m13210a(this.f2773a, R.string.toast_contact_not_found, 0).show();
                }
                return;
            } finally {
            }
        }
        long j = i;
        C3250y.m11450b("id: " + j, f2772b);
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse(uri + "/" + j));
        finish();
        try {
            try {
                startActivity(intent2);
            } catch (ActivityNotFoundException e2) {
                C3250y.m11443a(e2, getClass().getSimpleName());
                C3641ai.m13210a(this.f2773a, R.string.toast_contact_not_found, 0).show();
            }
        } finally {
        }
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

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C3250y.m11450b("onUserLeaveHint", getClass().getSimpleName());
        C3241p.m11402b(getApplicationContext());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m4274c();
    }

    /* renamed from: c */
    private void m4274c() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }
}
