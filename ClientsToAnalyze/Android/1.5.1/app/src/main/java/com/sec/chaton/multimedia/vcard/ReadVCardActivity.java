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
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.multimedia.vcard.ContactStruct;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ReadVCardActivity extends ListActivity {

    /* renamed from: a */
    public static final String f2323a = ReadVCardActivity.class.getSimpleName();

    /* renamed from: f */
    private static ContactStruct f2324f = null;

    /* renamed from: c */
    ProgressDialog f2326c;

    /* renamed from: d */
    Context f2327d;

    /* renamed from: h */
    private ContactStruct f2330h;

    /* renamed from: e */
    private String f2328e = null;

    /* renamed from: b */
    public ReadVCardAdapter f2325b = null;

    /* renamed from: g */
    private List f2329g = new ArrayList();

    /* renamed from: i */
    private final int f2331i = 0;

    /* renamed from: j */
    private boolean f2332j = false;

    /* renamed from: a */
    public static ContactStruct m2618a() {
        return f2324f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2620b() {
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.dir/contact");
        intent.putExtra("name", f2324f.f2281a);
        intent.putExtra("company", f2324f.f2283c);
        intent.putExtra("notes", f2324f.f2284d);
        if (f2324f.f2288h != null && f2324f.f2288h.size() > 0) {
            try {
                intent.putExtra("phone_type", ((ContactStruct.PhoneData) f2324f.f2288h.get(0)).f2308a);
                intent.putExtra("phone", ((ContactStruct.PhoneData) f2324f.f2288h.get(0)).f2309b);
            } catch (Exception e) {
            }
            try {
                intent.putExtra("secondary_phone_type", ((ContactStruct.PhoneData) f2324f.f2288h.get(1)).f2308a);
                intent.putExtra("secondary_phone", ((ContactStruct.PhoneData) f2324f.f2288h.get(1)).f2309b);
            } catch (Exception e2) {
            }
            try {
                intent.putExtra("tertiary_phone_type", ((ContactStruct.PhoneData) f2324f.f2288h.get(2)).f2308a);
                intent.putExtra("tertiary_phone", ((ContactStruct.PhoneData) f2324f.f2288h.get(2)).f2309b);
            } catch (Exception e3) {
            }
        }
        if (f2324f.f2289i != null && f2324f.f2289i.size() > 0) {
            try {
                intent.putExtra("email_type", ((ContactStruct.EmailData) f2324f.f2289i.get(0)).f2299a);
                intent.putExtra("email", ((ContactStruct.EmailData) f2324f.f2289i.get(0)).f2300b);
            } catch (Exception e4) {
            }
            try {
                intent.putExtra("secondary_email_type", ((ContactStruct.EmailData) f2324f.f2289i.get(1)).f2299a);
                intent.putExtra("secondary_email", ((ContactStruct.EmailData) f2324f.f2289i.get(1)).f2300b);
            } catch (Exception e5) {
            }
            try {
                intent.putExtra("tertiary_email_type", ((ContactStruct.EmailData) f2324f.f2289i.get(2)).f2299a);
                intent.putExtra("tertiary_email", ((ContactStruct.EmailData) f2324f.f2289i.get(2)).f2300b);
            } catch (Exception e6) {
            }
        }
        startActivityForResult(intent, 0);
    }

    /* renamed from: c */
    private void m2621c() throws IOException {
        VCardParser vCardParser = new VCardParser();
        String str = null;
        if (this.f2328e != null) {
            String[] strArrSplit = this.f2328e.split("file://");
            if (strArrSplit.length == 1) {
                str = this.f2328e;
            } else if (strArrSplit.length == 2) {
                str = strArrSplit[1];
            } else {
                finish();
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
        String str2 = "";
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                ChatONLogWriter.m3512f("**** READ VCARD : " + str2, f2323a);
                f2324f = vCardParser.m2643a(str2);
                return;
            }
            str2 = str2 + line + "\n";
        }
    }

    /* renamed from: d */
    private void m2622d() {
        if (f2324f.f2281a != null) {
            this.f2330h.f2281a = f2324f.f2281a;
        }
        if (f2324f.f2282b != null) {
            this.f2330h.f2282b = f2324f.f2282b;
        }
        if (f2324f.f2283c != null) {
            this.f2330h.f2283c = f2324f.f2283c;
        }
        if (f2324f.f2284d != null) {
            this.f2330h.f2284d = f2324f.f2284d;
        }
        if (f2324f.f2288h != null) {
            int i = 0;
            while (f2324f.f2288h.size() > i) {
                this.f2329g.add(new ContactStruct.ContactMethod(((ContactStruct.PhoneData) f2324f.f2288h.get(i)).f2308a, ((ContactStruct.PhoneData) f2324f.f2288h.get(i)).f2309b, ((ContactStruct.PhoneData) f2324f.f2288h.get(i)).f2310c, 5, i == 0));
                i++;
            }
        }
        if (f2324f.f2289i != null) {
            int i2 = 0;
            while (f2324f.f2289i.size() > i2) {
                this.f2329g.add(new ContactStruct.ContactMethod(((ContactStruct.EmailData) f2324f.f2289i.get(i2)).f2299a, ((ContactStruct.EmailData) f2324f.f2289i.get(i2)).f2300b, ((ContactStruct.EmailData) f2324f.f2289i.get(i2)).f2301c, 1, i2 == 0));
                i2++;
            }
        }
        if (f2324f.f2284d != null && f2324f.f2284d.trim().length() > 0) {
            this.f2329g.add(new ContactStruct.ContactMethod(0, f2324f.f2284d, null, 9, true));
        }
        TextView textView = (TextView) findViewById(C0062R.id.vcard_name_text);
        if (f2324f.f2281a != null) {
            if (f2324f.f2282b != null) {
                textView.setText(f2324f.f2281a + " " + f2324f.f2282b);
            } else {
                textView.setText(f2324f.f2281a);
            }
        } else if (f2324f.f2282b != null) {
            textView.setText(f2324f.f2282b);
        } else if (f2324f.f2283c != null) {
            textView.setText(f2324f.f2283c);
        } else if (f2324f.f2288h != null) {
            textView.setText(((ContactStruct.PhoneData) f2324f.f2288h.get(0)).f2309b);
        } else if (f2324f.f2289i != null) {
            textView.setText(((ContactStruct.EmailData) f2324f.f2289i.get(0)).f2300b);
        } else {
            textView.setText(" ");
        }
        ((ImageView) findViewById(C0062R.id.vcard_image_icon)).setScaleType(ImageView.ScaleType.FIT_XY);
    }

    /* renamed from: a */
    public void m2623a(View view, ContactStruct.ContactMethod contactMethod) {
        if (contactMethod.f2296d != 5) {
            if (contactMethod.f2296d == 1) {
                ((TextView) view).setText(getString(C0062R.string.vcard_email_type_01));
                return;
            }
            if (contactMethod.f2296d == 9) {
                ((TextView) view).setText(getString(C0062R.string.vcard_notes_type));
                return;
            } else if (contactMethod.f2295c != null) {
                ((TextView) view).setText(getString(C0062R.string.vcard_type_other) + contactMethod.f2295c);
                return;
            } else {
                ((TextView) view).setText(getString(C0062R.string.vcard_type_other));
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

    /* renamed from: a */
    public void m2624a(CharSequence charSequence) {
        if (charSequence != null) {
            try {
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + ((Object) charSequence))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public void m2625b(View view, ContactStruct.ContactMethod contactMethod) {
        if (contactMethod.f2294b != null) {
            if (contactMethod.f2296d == 5) {
                ((TextView) view).setText(contactMethod.f2294b.replace("-", ""));
            } else {
                ((TextView) view).setText(contactMethod.f2294b);
            }
        }
    }

    /* renamed from: b */
    public void m2626b(CharSequence charSequence) {
        if (charSequence != null) {
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("message/rfc82");
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"" + ((Object) charSequence)});
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.layout_multimedia_vcard_send);
        this.f2327d = this;
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("URI")) {
            this.f2328e = extras.getString("URI");
        }
        if (extras != null && extras.containsKey("VCARD_SAVE")) {
            this.f2332j = extras.getBoolean("VCARD_SAVE");
        }
        f2324f = new ContactStruct();
        Button button = (Button) findViewById(C0062R.id.vcard_save_btn);
        button.setEnabled(true);
        ((Button) findViewById(C0062R.id.vcard_cancel_btn)).setOnClickListener(new ViewOnClickListenerC0320d(this));
        ((Button) findViewById(C0062R.id.vcard_send_btn)).setVisibility(8);
        this.f2330h = new ContactStruct();
        try {
            m2621c();
        } catch (VCardException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        m2622d();
        this.f2325b = new ReadVCardAdapter(this, this.f2329g);
        setListAdapter(this.f2325b);
        button.setOnClickListener(new ViewOnClickListenerC0319c(this));
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                this.f2326c = new ProgressDialog(this);
                this.f2326c.setProgressStyle(0);
                this.f2326c.setMessage(getString(C0062R.string.wait_sending));
                return this.f2326c;
            default:
                return null;
        }
    }

    @Override // android.app.ListActivity
    protected void onListItemClick(ListView listView, View view, int i, long j) {
        super.onListItemClick(listView, view, i, j);
        String str = ((Object) ((TextView) view.findViewById(C0062R.id.list_vcard_main_text)).getText()) + "";
        String strSubstring = str.substring(0, str.indexOf(":") + 1);
        if (strSubstring.equals(getString(C0062R.string.vcard_type_phone))) {
            m2624a(((TextView) view.findViewById(C0062R.id.list_vcard_sub_text)).getText());
        }
        if (strSubstring.equals(getString(C0062R.string.vcard_type_email))) {
            m2626b(((TextView) view.findViewById(C0062R.id.list_vcard_sub_text)).getText());
        }
    }
}
