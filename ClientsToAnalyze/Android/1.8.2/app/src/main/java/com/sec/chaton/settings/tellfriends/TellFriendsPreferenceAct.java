package com.sec.chaton.settings.tellfriends;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.provider.ContactsContract;
import com.sec.chaton.R;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.settings.C1306dd;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.PreferenceListFragment;
import com.sec.common.p056b.C1816b;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import twitter4j.Twitter;
import weibo4android.Weibo;

/* loaded from: classes.dex */
public class TellFriendsPreferenceAct extends PreferenceListFragment {

    /* renamed from: g */
    private C1306dd f5046g;

    /* renamed from: b */
    private final int f5041b = 1;

    /* renamed from: c */
    private Twitter f5042c = null;

    /* renamed from: d */
    private Weibo f5043d = null;

    /* renamed from: e */
    private Context f5044e = null;

    /* renamed from: f */
    private SharedPreferences f5045f = null;

    /* renamed from: a */
    SharedPreferences.Editor f5040a = null;

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws NoSuchMethodException, SecurityException {
        super.onCreate(bundle);
        m6122a(R.xml.preference_setting_tellfriends);
        this.f5044e = getActivity();
        this.f5045f = C1789u.m6075a();
        this.f5040a = this.f5045f.edit();
        this.f5046g = new C1306dd(this.f5045f);
        this.f5040a.putBoolean("Lock Check", false);
        try {
            m4932a();
        } catch (Exception e) {
            e.printStackTrace();
            C1786r.m6056a(e, getClass().getSimpleName());
        }
    }

    @Override // com.sec.chaton.widget.PreferenceListFragment, android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws IllegalAccessException, NoSuchMethodException, Resources.NotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        String string = null;
        super.onActivityResult(i, i2, intent);
        String string2 = getResources().getString(R.string.tellfriends_post_message);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    Cursor cursorManagedQuery = getActivity().managedQuery(intent.getData(), null, null, null, null);
                    if (cursorManagedQuery.moveToFirst()) {
                        String string3 = cursorManagedQuery.getString(cursorManagedQuery.getColumnIndex("display_name"));
                        String string4 = cursorManagedQuery.getString(cursorManagedQuery.getColumnIndex("_id"));
                        if (cursorManagedQuery.getString(cursorManagedQuery.getColumnIndex("has_phone_number")).equals("1")) {
                            Cursor cursorQuery = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = " + string4, null, null);
                            ArrayList arrayList = new ArrayList();
                            while (cursorQuery.moveToNext()) {
                                string = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                                arrayList.add(string);
                            }
                            if (arrayList.size() == 1) {
                                m4934a(string, string2);
                                break;
                            } else {
                                new AlertDialogBuilderC2120a(this.f5044e).setTitle(string3).setItems((CharSequence[]) arrayList.toArray(new String[arrayList.size()]), new DialogInterfaceOnClickListenerC1398bz(this, arrayList, string2)).show();
                                break;
                            }
                        } else {
                            new AlertDialogBuilderC2120a(this.f5044e).setMessage(R.string.vcard_nocontact_message).setCancelable(false).setPositiveButton(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1400ca(this)).show();
                            break;
                        }
                    }
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4934a(String str, String str2) {
        try {
            startActivity(C1816b.m6157a(str, str2));
        } catch (ActivityNotFoundException e) {
        }
    }

    /* renamed from: a */
    private void m4932a() {
        Preference preferenceA = m6121a("pref_item_viamessage");
        preferenceA.setOnPreferenceClickListener(new C1401cb(this));
        if (getActivity().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("smsto:9000000000")), 65536).size() < 1) {
            m6125f().removePreference(preferenceA);
        }
        Preference preferenceA2 = m6121a("pref_item_viafacebook");
        preferenceA2.setOnPreferenceClickListener(new C1402cc(this));
        Preference preferenceA3 = m6121a("pref_item_viatwitter");
        preferenceA3.setOnPreferenceClickListener(new C1403cd(this));
        m6121a("pref_item_viaweibo").setOnPreferenceClickListener(new C1404ce(this));
        C0452a.m2470c();
        if (!C0452a.m2471d()) {
            m6125f().removePreference(preferenceA2);
            m6125f().removePreference(preferenceA3);
        }
    }
}
