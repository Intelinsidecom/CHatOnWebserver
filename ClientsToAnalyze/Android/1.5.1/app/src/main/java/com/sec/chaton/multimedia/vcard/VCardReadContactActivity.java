package com.sec.chaton.multimedia.vcard;

import android.app.Dialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.multimedia.vcard.ContactStruct;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class VCardReadContactActivity extends ListActivity {

    /* renamed from: a */
    public static final String f2346a = VCardReadContactActivity.class.getSimpleName();

    /* renamed from: c */
    public static String f2347c = "extra vard name";

    /* renamed from: d */
    public static String f2348d = "extra filekey";

    /* renamed from: e */
    public static String f2349e = "extra fileuri";

    /* renamed from: f */
    ProgressDialog f2351f;

    /* renamed from: i */
    Context f2354i;

    /* renamed from: j */
    private ContactAccessor f2355j;

    /* renamed from: l */
    private ContactStruct f2357l;

    /* renamed from: n */
    private Button f2359n;

    /* renamed from: o */
    private Button f2360o;

    /* renamed from: p */
    private String f2361p;

    /* renamed from: r */
    private String f2363r;

    /* renamed from: s */
    private LinearLayout f2364s;

    /* renamed from: t */
    private LinearLayout f2365t;

    /* renamed from: b */
    public VCardReadContactAdapter f2350b = null;

    /* renamed from: k */
    private List f2356k = new ArrayList();

    /* renamed from: m */
    private int f2358m = 0;

    /* renamed from: q */
    private final int f2362q = 0;

    /* renamed from: g */
    String f2352g = null;

    /* renamed from: h */
    int f2353h = -1;

    /* renamed from: u */
    private Runnable f2366u = new RunnableC0326j(this);

    /* renamed from: a */
    private int m2649a(int i) {
        int i2 = 0;
        for (ContactStruct.ContactMethod contactMethod : this.f2356k) {
            if (contactMethod.f2296d == i && contactMethod.f2298f) {
                i2++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2651a() throws Throwable {
        try {
            this.f2352g = new VCardComposer().m2642a(this.f2357l, 1);
            ChatONLogWriter.m3512f("*** VCARD CONTENTS : " + this.f2352g, f2346a);
        } catch (VCardException e) {
            e.printStackTrace();
        }
        if (this.f2352g != null) {
            m2659a(this.f2352g);
        } else {
            this.f2353h = C0062R.string.toast_make_failed;
            finish();
        }
    }

    /* renamed from: a */
    private void m2652a(Uri uri) {
        new AsyncTaskC0324h(this).execute(uri);
    }

    @Deprecated
    /* renamed from: a */
    public void m2657a(View view, ContactStruct.ContactMethod contactMethod) {
        if (contactMethod.f2298f) {
            ((ImageView) view).setImageResource(C0062R.drawable.co_btn_check_on);
        } else {
            ((ImageView) view).setImageResource(C0062R.drawable.co_btn_check_off);
        }
    }

    /* renamed from: a */
    protected void m2658a(ContactStruct contactStruct) {
        ArrayList arrayList = new ArrayList();
        if (contactStruct.f2281a != null) {
            this.f2357l.f2281a = contactStruct.f2281a;
        }
        if (contactStruct.f2282b != null) {
            this.f2357l.f2282b = contactStruct.f2282b;
        }
        if (contactStruct.f2283c != null) {
            this.f2357l.f2283c = contactStruct.f2283c;
        }
        if (contactStruct.f2284d != null && !contactStruct.f2284d.equals("")) {
            this.f2357l.f2284d = contactStruct.f2284d;
        }
        if (contactStruct.f2288h != null) {
            int i = 0;
            while (contactStruct.f2288h.size() > i) {
                String str = ((ContactStruct.PhoneData) contactStruct.f2288h.get(i)).f2310c;
                if (((ContactStruct.PhoneData) contactStruct.f2288h.get(i)).f2308a == 1 || ((ContactStruct.PhoneData) contactStruct.f2288h.get(i)).f2308a == 2 || ((ContactStruct.PhoneData) contactStruct.f2288h.get(i)).f2308a == 3 || ((ContactStruct.PhoneData) contactStruct.f2288h.get(i)).f2308a == 4) {
                    String strReplace = ((ContactStruct.PhoneData) contactStruct.f2288h.get(i)).f2309b.replace("-", "");
                    ChatONLogWriter.m3512f("ORIGINAL PHONE NUMBER : " + ((ContactStruct.PhoneData) contactStruct.f2288h.get(i)).f2309b, f2346a);
                    ChatONLogWriter.m3512f("EDITED PHONE NUMBER : " + strReplace, f2346a);
                    arrayList.add(new ContactStruct.ContactMethod(((ContactStruct.PhoneData) contactStruct.f2288h.get(i)).f2308a, strReplace, str, 5, i == 0));
                }
                i++;
            }
        }
        if (contactStruct.f2289i != null && contactStruct.f2289i.size() > 0) {
            arrayList.add(new ContactStruct.ContactMethod(((ContactStruct.EmailData) contactStruct.f2289i.get(0)).f2299a, ((ContactStruct.EmailData) contactStruct.f2289i.get(0)).f2300b, ((ContactStruct.EmailData) contactStruct.f2289i.get(0)).f2301c, 1, 0 == 0));
        }
        if (contactStruct.f2284d != null && !contactStruct.f2284d.equals("")) {
            arrayList.add(new ContactStruct.ContactMethod(0, contactStruct.f2284d, null, 9, true));
        }
        TextView textView = (TextView) findViewById(C0062R.id.vcard_name_text);
        if (contactStruct.f2281a != null) {
            if (contactStruct.f2282b != null) {
                textView.setText(contactStruct.f2281a + " " + contactStruct.f2282b);
            } else {
                textView.setText(contactStruct.f2281a);
            }
        } else if (contactStruct.f2282b != null) {
            textView.setText(contactStruct.f2282b);
        } else if (contactStruct.f2283c != null) {
            textView.setText(contactStruct.f2283c);
        } else if (contactStruct.f2288h != null) {
            textView.setText(((ContactStruct.PhoneData) contactStruct.f2288h.get(0)).f2309b);
        } else if (contactStruct.f2289i != null) {
            textView.setText(((ContactStruct.EmailData) contactStruct.f2289i.get(0)).f2300b);
        } else {
            textView.setText(" ");
        }
        ((ImageView) findViewById(C0062R.id.vcard_image_icon)).setScaleType(ImageView.ScaleType.FIT_XY);
        this.f2356k = arrayList;
        if (arrayList.size() > 0) {
            this.f2350b = new VCardReadContactAdapter(this, this.f2356k);
            setListAdapter(this.f2350b);
        } else {
            getListView().setVisibility(8);
            this.f2364s.setVisibility(8);
            this.f2365t.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011d  */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2659a(java.lang.String r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.vcard.VCardReadContactActivity.m2659a(java.lang.String):void");
    }

    /* renamed from: b */
    public void m2660b(View view, ContactStruct.ContactMethod contactMethod) {
        if (contactMethod.f2296d != 5) {
            if (contactMethod.f2296d == 1) {
                ((TextView) view).setText(getString(C0062R.string.vcard_email_type_01));
                return;
            } else {
                if (contactMethod.f2296d == 9) {
                    ((TextView) view).setText(getString(C0062R.string.vcard_notes_type));
                    return;
                }
                return;
            }
        }
        String string = "";
        switch (contactMethod.f2293a) {
            case 1:
                string = getString(C0062R.string.vcard_phone_type_01);
                break;
            case 2:
                string = getString(C0062R.string.vcard_phone_type_02);
                break;
            case 3:
                string = getString(C0062R.string.vcard_phone_type_03);
                break;
            case 4:
                string = getString(C0062R.string.vcard_phone_type_04);
                break;
        }
        ((TextView) view).setText(string);
    }

    /* renamed from: c */
    public void m2661c(View view, ContactStruct.ContactMethod contactMethod) {
        if (contactMethod.f2294b != null) {
            ((TextView) view).setText(contactMethod.f2294b);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            m2652a(intent.getData());
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2363r = getIntent().getStringExtra("inbox_NO");
        this.f2355j = ContactAccessor.m2612a(this);
        setContentView(C0062R.layout.layout_multimedia_vcard_send);
        this.f2354i = this;
        this.f2357l = new ContactStruct();
        this.f2359n = (Button) findViewById(C0062R.id.vcard_send_btn);
        this.f2359n.setOnClickListener(new ViewOnClickListenerC0325i(this));
        this.f2360o = (Button) findViewById(C0062R.id.vcard_cancel_btn);
        this.f2360o.setOnClickListener(new ViewOnClickListenerC0323g(this));
        ((Button) findViewById(C0062R.id.vcard_save_btn)).setVisibility(8);
        this.f2364s = (LinearLayout) findViewById(C0062R.id.vcard_menubar);
        this.f2365t = (LinearLayout) findViewById(C0062R.id.vcard_nocontact_layout);
        startActivityForResult(this.f2355j.mo2613a(), 1);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                this.f2351f = new ProgressDialog(this);
                this.f2351f.setProgressStyle(0);
                this.f2351f.setMessage(getString(C0062R.string.wait_sending));
                return this.f2351f;
            default:
                return null;
        }
    }

    @Override // android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        if (this.f2353h != -1) {
            Toast.makeText(this.f2354i, this.f2353h, 0).show();
        }
        super.onDestroy();
    }

    @Override // android.app.ListActivity
    protected void onListItemClick(ListView listView, View view, int i, long j) {
        super.onListItemClick(listView, view, i, j);
        ChatONLogWriter.m3512f("POSITION : " + i, "VCardReadContactActivity");
        ChatONLogWriter.m3512f("CONTACT KIND : " + ((ContactStruct.ContactMethod) this.f2356k.get(i)).f2296d, "VCardReadContactActivity");
        ChatONLogWriter.m3512f("CONTACT TYPE : " + ((ContactStruct.ContactMethod) this.f2356k.get(i)).f2293a, "VCardReadContactActivity");
        ChatONLogWriter.m3512f("CONTACT DATA : " + ((ContactStruct.ContactMethod) this.f2356k.get(i)).f2294b, "VCardReadContactActivity");
        if (this.f2356k.get(i) != null) {
            ((ContactStruct.ContactMethod) this.f2356k.get(i)).f2298f = !((ContactStruct.ContactMethod) this.f2356k.get(i)).f2298f;
            if (((ContactStruct.ContactMethod) this.f2356k.get(i)).f2298f) {
                this.f2358m++;
                if (m2649a(((ContactStruct.ContactMethod) this.f2356k.get(i)).f2296d) > 3) {
                    if (((ContactStruct.ContactMethod) this.f2356k.get(i)).f2296d == 5) {
                        Toast.makeText(this, getString(C0062R.string.vcard_list_checked_over_phone, new Object[]{3}), 0).show();
                    } else if (((ContactStruct.ContactMethod) this.f2356k.get(i)).f2296d == 1) {
                        Toast.makeText(this, getString(C0062R.string.vcard_list_checked_over_email, new Object[]{3}), 0).show();
                    }
                    ((ContactStruct.ContactMethod) this.f2356k.get(i)).f2298f = false;
                    this.f2358m--;
                }
            } else {
                this.f2358m--;
            }
            if (this.f2358m > 0) {
                this.f2359n.setEnabled(true);
            } else {
                this.f2359n.setEnabled(false);
            }
            m2657a(view.findViewById(C0062R.id.vcard_checkbtn), (ContactStruct.ContactMethod) this.f2356k.get(i));
        }
    }
}
