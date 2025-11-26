package com.sec.chaton.multimedia.vcard;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.vcalendar.VCalendarListFragment;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.widget.EditTextWithClearButton;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ContactPicker extends Activity {

    /* renamed from: a */
    public static final String f3786a = VCalendarListFragment.class.getSimpleName();

    /* renamed from: b */
    ArrayList f3787b;

    /* renamed from: c */
    ListView f3788c;

    /* renamed from: d */
    Context f3789d;

    /* renamed from: g */
    private Dialog f3792g;

    /* renamed from: e */
    String f3790e = "";

    /* renamed from: f */
    Handler f3791f = new HandlerC1032b(this);

    /* renamed from: h */
    private TextWatcher f3793h = new C1034d(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3789d = this;
        setContentView(R.layout.layout_contact_pick);
        setTitle(R.string.menu_multimedia_contact);
        getWindow().setLayout(798, 738);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        EditTextWithClearButton editTextWithClearButton = (EditTextWithClearButton) findViewById(R.id.searchText);
        editTextWithClearButton.setShowSearch(true);
        editTextWithClearButton.addTextChangedListener(this.f3793h);
        this.f3788c = (ListView) findViewById(R.id.contactList);
        this.f3788c.setDivider(getResources().getDrawable(R.drawable.list_2line));
        this.f3792g = ProgressDialogC1806j.m6142a(this, null, getResources().getString(R.string.dialog_provision_ing), true, false);
        this.f3792g.show();
        Thread thread = new Thread(new RunnableC1037g(this));
        thread.setDaemon(true);
        thread.start();
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
        setTitle(R.string.media_contact);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ed  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList m3998a(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            r4 = 0
            r6 = 0
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r0 = "android.intent.action.PICK"
            android.net.Uri r2 = android.provider.ContactsContract.Contacts.CONTENT_URI
            r1.<init>(r0, r2)
            java.lang.String r0 = "Query - start"
            java.lang.Class r2 = r7.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C1786r.m6054a(r0, r2)
            android.content.ContentResolver r0 = r7.getContentResolver()
            android.net.Uri r1 = r1.getData()
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.String r3 = "_id"
            r2[r6] = r3
            r3 = 1
            java.lang.String r5 = "display_name"
            r2[r3] = r5
            r3 = r8
            r5 = r4
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)
            java.lang.String r1 = "Query - end"
            java.lang.Class r2 = r7.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C1786r.m6054a(r1, r2)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L44:
            boolean r1 = r0.moveToNext()
            if (r1 == 0) goto L70
            com.sec.chaton.multimedia.vcard.e r1 = new com.sec.chaton.multimedia.vcard.e
            r1.<init>(r7)
            long r2 = r0.getLong(r6)
            r1.f3833a = r2
            java.lang.String r5 = "display_name"
            int r5 = r0.getColumnIndexOrThrow(r5)
            java.lang.String r5 = r0.getString(r5)
            r1.f3835c = r5
            android.net.Uri r5 = android.provider.ContactsContract.Contacts.CONTENT_VCARD_URI
            android.net.Uri r5 = android.content.ContentUris.withAppendedId(r5, r2)
            r1.f3837e = r5
            r1.m4025a(r2)
            r4.add(r1)
            goto L44
        L70:
            java.lang.String r1 = "while - end"
            java.lang.Class r2 = r7.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C1786r.m6054a(r1, r2)
            if (r0 == 0) goto L8b
            boolean r1 = r0.isClosed()
            if (r1 != 0) goto L8b
            r7.stopManagingCursor(r0)
            r0.close()
        L8b:
            com.sec.chaton.multimedia.vcard.e r0 = new com.sec.chaton.multimedia.vcard.e
            r0.<init>(r7)
            java.util.Collections.sort(r4, r0)
            java.lang.String r0 = "Collections.sort - end"
            java.lang.Class r1 = r7.getClass()
            java.lang.String r1 = r1.getSimpleName()
            com.sec.chaton.util.C1786r.m6054a(r0, r1)
            r0 = 32
            r1 = r6
            r2 = r0
        La4:
            int r0 = r4.size()
            if (r1 >= r0) goto Ldf
            java.lang.Object r0 = r4.get(r1)
            com.sec.chaton.multimedia.vcard.e r0 = (com.sec.chaton.multimedia.vcard.C1035e) r0
            java.lang.String r3 = r0.f3835c
            if (r3 == 0) goto Led
            java.lang.String r3 = r0.f3835c
            java.lang.String r3 = r3.toLowerCase()
            char r3 = r3.charAt(r6)
            r5 = 97
            if (r3 < r5) goto Lc6
            r5 = 122(0x7a, float:1.71E-43)
            if (r3 <= r5) goto Lc8
        Lc6:
            r3 = 35
        Lc8:
            java.lang.String r0 = r0.f3835c
            if (r0 == 0) goto Led
            if (r2 == r3) goto Led
            com.sec.chaton.multimedia.vcard.e r0 = new com.sec.chaton.multimedia.vcard.e
            r0.<init>(r7, r3)
            r4.add(r1, r0)
            int r1 = r1 + 1
            r0 = r1
            r1 = r3
        Lda:
            int r0 = r0 + 1
            r2 = r1
            r1 = r0
            goto La4
        Ldf:
            java.lang.String r0 = "for.sort - end"
            java.lang.Class r1 = r7.getClass()
            java.lang.String r1 = r1.getSimpleName()
            com.sec.chaton.util.C1786r.m6054a(r0, r1)
            return r4
        Led:
            r0 = r1
            r1 = r2
            goto Lda
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.vcard.ContactPicker.m3998a(java.lang.String):java.util.ArrayList");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m3997a();
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C1786r.m6061b("onUserLeaveHint", getClass().getSimpleName());
        C1781m.m6022b(getApplicationContext());
    }

    /* renamed from: a */
    private void m3997a() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.f3792g != null && this.f3792g.getWindow() != null) {
            this.f3792g.dismiss();
        }
    }
}
