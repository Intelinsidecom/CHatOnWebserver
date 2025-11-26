package com.sec.chaton.multimedia.vcard;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.ProgressDialogC1806j;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ReadVCardActivity extends ListActivity {

    /* renamed from: a */
    public static final String f3794a = ReadVCardActivity.class.getSimpleName();

    /* renamed from: h */
    private static C1038h f3795h = null;

    /* renamed from: c */
    ProgressDialog f3797c;

    /* renamed from: d */
    LinearLayout f3798d;

    /* renamed from: e */
    ImageView f3799e;

    /* renamed from: f */
    Context f3800f;

    /* renamed from: j */
    private C1038h f3803j;

    /* renamed from: g */
    private String f3801g = null;

    /* renamed from: b */
    public C1044n f3796b = null;

    /* renamed from: i */
    private List f3802i = new ArrayList();

    /* renamed from: k */
    private final int f3804k = 0;

    /* renamed from: l */
    private boolean f3805l = false;

    /* renamed from: m */
    private boolean f3806m = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_multimedia_vcard_send);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
            setTitle(R.string.media_contact);
        }
        this.f3800f = this;
        this.f3798d = (LinearLayout) findViewById(R.id.vcard_selectall_with_checkbox_layout);
        if (this.f3798d != null) {
            this.f3798d.setVisibility(8);
        }
        this.f3799e = (ImageView) findViewById(R.id.vcard_line);
        if (this.f3799e != null) {
            this.f3799e.setVisibility(8);
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("URI")) {
            this.f3801g = extras.getString("URI");
        }
        if (extras != null && extras.containsKey("VCARD_SAVE")) {
            this.f3805l = extras.getBoolean("VCARD_SAVE");
        }
        f3795h = new C1038h();
        this.f3803j = new C1038h();
        try {
            m4000b();
        } catch (C1047q e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (this.f3806m) {
            Toast.makeText(this, getString(R.string.toast_supported_format), 0).show();
            finish();
        }
        m4001c();
        this.f3796b = new C1044n(this, this.f3802i);
        setListAdapter(this.f3796b);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu_save_cancel, menu);
        menu.removeItem(R.id.menu_cancel);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.menu_save /* 2131494126 */:
                m3999a();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: a */
    private void m3999a() {
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.dir/contact");
        intent.putExtra("name", f3795h.f3843a);
        intent.putExtra("company", f3795h.f3845c);
        intent.putExtra("notes", f3795h.f3846d);
        if (f3795h.f3850h != null && f3795h.f3850h.size() > 0) {
            try {
                intent.putExtra("phone_type", ((C1042l) f3795h.f3850h.get(0)).f3870a);
                intent.putExtra("phone", ((C1042l) f3795h.f3850h.get(0)).f3871b);
            } catch (Exception e) {
            }
            try {
                intent.putExtra("secondary_phone_type", ((C1042l) f3795h.f3850h.get(1)).f3870a);
                intent.putExtra("secondary_phone", ((C1042l) f3795h.f3850h.get(1)).f3871b);
            } catch (Exception e2) {
            }
            try {
                intent.putExtra("tertiary_phone_type", ((C1042l) f3795h.f3850h.get(2)).f3870a);
                intent.putExtra("tertiary_phone", ((C1042l) f3795h.f3850h.get(2)).f3871b);
            } catch (Exception e3) {
            }
        }
        if (f3795h.f3851i != null && f3795h.f3851i.size() > 0) {
            try {
                intent.putExtra("email_type", ((C1040j) f3795h.f3851i.get(0)).f3861a);
                intent.putExtra("email", ((C1040j) f3795h.f3851i.get(0)).f3862b);
            } catch (Exception e4) {
            }
            try {
                intent.putExtra("secondary_email_type", ((C1040j) f3795h.f3851i.get(1)).f3861a);
                intent.putExtra("secondary_email", ((C1040j) f3795h.f3851i.get(1)).f3862b);
            } catch (Exception e5) {
            }
            try {
                intent.putExtra("tertiary_email_type", ((C1040j) f3795h.f3851i.get(2)).f3861a);
                intent.putExtra("tertiary_email", ((C1040j) f3795h.f3851i.get(2)).f3862b);
            } catch (Exception e6) {
            }
        }
        if (getPackageManager().queryIntentActivities(intent, 65536).size() >= 1) {
            startActivityForResult(intent, 0);
        } else {
            Toast.makeText(this, R.string.toast_contact_not_saved, 0).show();
        }
    }

    /* renamed from: b */
    private void m4000b() throws IOException {
        C1048r c1048r = new C1048r();
        String str = null;
        if (this.f3801g != null) {
            String[] strArrSplit = this.f3801g.split("file://");
            if (strArrSplit.length == 1) {
                str = this.f3801g;
            } else if (strArrSplit.length == 2) {
                str = strArrSplit[1];
            } else {
                finish();
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line + "\n");
            } else {
                bufferedReader.close();
                C1786r.m6067f("**** READ VCARD : " + ((Object) sb), f3794a);
                f3795h = c1048r.m4044a(sb.toString());
                this.f3806m = c1048r.m4046a();
                return;
            }
        }
    }

    @Override // android.app.ListActivity
    protected void onListItemClick(ListView listView, View view, int i, long j) {
        super.onListItemClick(listView, view, i, j);
        String str = ((Object) ((TextView) view.findViewById(R.id.list_vcard_main_text)).getText()) + "";
        String strSubstring = str.substring(0, str.indexOf(":") + 1);
        if (strSubstring.equals(getString(R.string.vcard_type_phone))) {
            m4003a(((TextView) view.findViewById(R.id.list_vcard_sub_text)).getText());
        }
        if (strSubstring.equals(getString(R.string.vcard_type_email))) {
            m4005b(((TextView) view.findViewById(R.id.list_vcard_sub_text)).getText());
        }
    }

    /* renamed from: a */
    public void m4002a(View view, C1039i c1039i) {
        if (c1039i.f3858d == 5) {
            String string = "";
            switch (c1039i.f3855a) {
                case 1:
                    string = getString(R.string.vcard_phone_type_01);
                    break;
                case 2:
                    string = getString(R.string.vcard_phone_type_02);
                    break;
                case 3:
                    string = getString(R.string.vcard_phone_type_03);
                    break;
                case 4:
                    string = getString(R.string.vcard_phone_type_04);
                    break;
            }
            ((TextView) view).setText(string);
            return;
        }
        if (c1039i.f3858d == 1) {
            ((TextView) view).setText(getString(R.string.vcard_type_email));
            return;
        }
        if (c1039i.f3858d == 9) {
            ((TextView) view).setText(getString(R.string.vcard_notes_type));
        } else if (c1039i.f3857c != null) {
            ((TextView) view).setText(getString(R.string.vcard_type_other) + c1039i.f3857c);
        } else {
            ((TextView) view).setText(getString(R.string.vcard_type_other));
        }
    }

    /* renamed from: b */
    public void m4004b(View view, C1039i c1039i) {
        if (c1039i.f3856b != null) {
            if (c1039i.f3858d == 5) {
                ((TextView) view).setText(c1039i.f3856b.replace("-", ""));
            } else {
                ((TextView) view).setText(c1039i.f3856b);
            }
        }
    }

    /* renamed from: c */
    public void m4006c(View view, C1039i c1039i) {
        if (c1039i.f3858d == 5) {
            ((TextView) view).setText(getString(R.string.vcard_type_phone));
            return;
        }
        if (c1039i.f3858d == 1) {
            ((TextView) view).setText(getString(R.string.vcard_type_email));
            return;
        }
        if (c1039i.f3858d == 2) {
            ((TextView) view).setText(getString(R.string.vcard_type_postal));
        } else if (c1039i.f3858d == 3) {
            ((TextView) view).setText(getString(R.string.vcard_type_im));
        } else {
            ((TextView) view).setText(getString(R.string.vcard_type_other));
        }
    }

    /* renamed from: c */
    private void m4001c() {
        if (f3795h.f3843a != null) {
            this.f3803j.f3843a = f3795h.f3843a;
        }
        if (f3795h.f3844b != null) {
            this.f3803j.f3844b = f3795h.f3844b;
        }
        if (f3795h.f3845c != null) {
            this.f3803j.f3845c = f3795h.f3845c;
        }
        if (f3795h.f3846d != null) {
            this.f3803j.f3846d = f3795h.f3846d;
        }
        if (f3795h.f3850h != null) {
            int i = 0;
            while (f3795h.f3850h.size() > i) {
                this.f3802i.add(new C1039i(((C1042l) f3795h.f3850h.get(i)).f3870a, ((C1042l) f3795h.f3850h.get(i)).f3871b, ((C1042l) f3795h.f3850h.get(i)).f3872c, 5, i == 0));
                i++;
            }
        }
        if (f3795h.f3851i != null) {
            int i2 = 0;
            while (f3795h.f3851i.size() > i2) {
                this.f3802i.add(new C1039i(((C1040j) f3795h.f3851i.get(i2)).f3861a, ((C1040j) f3795h.f3851i.get(i2)).f3862b, ((C1040j) f3795h.f3851i.get(i2)).f3863c, 1, i2 == 0));
                i2++;
            }
        }
        if (f3795h.f3846d != null && f3795h.f3846d.trim().length() > 0) {
            this.f3802i.add(new C1039i(0, f3795h.f3846d, null, 9, true));
        }
        TextView textView = (TextView) findViewById(R.id.vcard_name_text);
        if (f3795h.f3843a != null) {
            if (f3795h.f3844b != null) {
                String str = f3795h.f3843a + " " + f3795h.f3844b;
                textView.setText(str);
                setTitle(str);
            } else {
                textView.setText(f3795h.f3843a);
                setTitle(f3795h.f3843a);
            }
        } else if (f3795h.f3844b != null) {
            textView.setText(f3795h.f3844b);
            setTitle(f3795h.f3843a);
        } else if (f3795h.f3845c != null) {
            textView.setText(f3795h.f3845c);
        } else if (f3795h.f3850h != null) {
            textView.setText(((C1042l) f3795h.f3850h.get(0)).f3871b);
        } else if (f3795h.f3851i != null) {
            textView.setText(((C1040j) f3795h.f3851i.get(0)).f3862b);
        } else {
            textView.setText(" ");
            setTitle("");
        }
        ((ImageView) findViewById(R.id.vcard_image_icon)).setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                this.f3797c = new ProgressDialogC1806j(this);
                this.f3797c.setProgressStyle(0);
                this.f3797c.setMessage(getString(R.string.wait_sending));
                return this.f3797c;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public void m4003a(CharSequence charSequence) {
        if (charSequence != null) {
            try {
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + ((Object) charSequence))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public void m4005b(CharSequence charSequence) {
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
}
