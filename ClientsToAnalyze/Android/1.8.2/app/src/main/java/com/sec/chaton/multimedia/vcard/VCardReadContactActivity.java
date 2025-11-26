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
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.ProgressDialogC1806j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class VCardReadContactActivity extends ListActivity {

    /* renamed from: a */
    public static final String f3807a = VCardReadContactActivity.class.getSimpleName();

    /* renamed from: c */
    public static String f3808c = "extra vard name";

    /* renamed from: d */
    public static String f3809d = "extra filekey";

    /* renamed from: e */
    public static String f3810e = "extra fileuri";

    /* renamed from: f */
    ProgressDialog f3812f;

    /* renamed from: i */
    Context f3815i;

    /* renamed from: j */
    Uri f3816j;

    /* renamed from: k */
    private AbstractC1031a f3817k;

    /* renamed from: m */
    private C1038h f3819m;

    /* renamed from: o */
    private String f3821o;

    /* renamed from: q */
    private String f3823q;

    /* renamed from: r */
    private LinearLayout f3824r;

    /* renamed from: s */
    private LinearLayout f3825s;

    /* renamed from: t */
    private MenuItem f3826t;

    /* renamed from: u */
    private ImageView f3827u;

    /* renamed from: b */
    public C1052v f3811b = null;

    /* renamed from: l */
    private List f3818l = new ArrayList();

    /* renamed from: n */
    private int f3820n = 0;

    /* renamed from: p */
    private final int f3822p = 0;

    /* renamed from: g */
    String f3813g = null;

    /* renamed from: h */
    int f3814h = -1;

    /* renamed from: v */
    private Runnable f3828v = new RunnableC1051u(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.f3823q = intent.getStringExtra("inbox_NO");
        this.f3816j = Uri.parse(intent.getStringExtra("contactUri"));
        m4011a(this.f3816j);
        this.f3817k = AbstractC1031a.m4023a(this);
        setContentView(R.layout.layout_multimedia_vcard_send);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
        }
        setTitle(R.string.media_contact);
        this.f3825s = (LinearLayout) findViewById(R.id.vcard_selectall_with_checkbox_layout);
        this.f3825s.setOnClickListener(new ViewOnClickListenerC1049s(this));
        this.f3815i = this;
        this.f3819m = new C1038h();
        this.f3827u = (ImageView) findViewById(R.id.vcard_selectall_chckbtn);
        this.f3824r = (LinearLayout) findViewById(R.id.vcard_nocontact_layout);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu_done_cancel, menu);
        menu.removeItem(R.id.actionbar_menu_delete_group);
        this.f3826t = menu.findItem(R.id.actionbar_menu_done).setVisible(true).setEnabled(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
            case R.id.actionbar_menu_cancel /* 2131494122 */:
                finish();
                break;
            case R.id.actionbar_menu_done /* 2131494123 */:
                int i = 0;
                for (int i2 = 0; this.f3818l.size() > i2; i2++) {
                    if (((C1039i) this.f3818l.get(i2)).f3858d == 9 && !((C1039i) this.f3818l.get(i2)).f3860f) {
                        this.f3819m.f3846d = null;
                    }
                    if (((C1039i) this.f3818l.get(i2)).f3860f) {
                        i++;
                        if (((C1039i) this.f3818l.get(i2)).f3858d == 5) {
                            this.f3819m.m4027a(((C1039i) this.f3818l.get(i2)).f3855a, ((C1039i) this.f3818l.get(i2)).f3856b, ((C1039i) this.f3818l.get(i2)).f3857c, true);
                        } else if (((C1039i) this.f3818l.get(i2)).f3858d == 1) {
                            this.f3819m.m4028b(((C1039i) this.f3818l.get(i2)).f3855a, ((C1039i) this.f3818l.get(i2)).f3856b, ((C1039i) this.f3818l.get(i2)).f3857c, true);
                        }
                    }
                }
                if (i <= 0) {
                    finish();
                    break;
                } else {
                    showDialog(0);
                    new Thread((ThreadGroup) null, this.f3828v).start();
                    break;
                }
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.ListActivity
    protected void onListItemClick(ListView listView, View view, int i, long j) {
        super.onListItemClick(listView, view, i, j);
        C1786r.m6067f("POSITION : " + i, "VCardReadContactActivity");
        C1786r.m6067f("CONTACT KIND : " + ((C1039i) this.f3818l.get(i)).f3858d, "VCardReadContactActivity");
        C1786r.m6067f("CONTACT TYPE : " + ((C1039i) this.f3818l.get(i)).f3855a, "VCardReadContactActivity");
        C1786r.m6067f("CONTACT DATA : " + ((C1039i) this.f3818l.get(i)).f3856b, "VCardReadContactActivity");
        if (this.f3818l.get(i) != null) {
            ((C1039i) this.f3818l.get(i)).f3860f = !((C1039i) this.f3818l.get(i)).f3860f;
            if (((C1039i) this.f3818l.get(i)).f3860f) {
                this.f3820n++;
                if (m4007a(((C1039i) this.f3818l.get(i)).f3858d) > 3) {
                    if (((C1039i) this.f3818l.get(i)).f3858d == 5) {
                        Toast.makeText(this, getString(R.string.vcard_list_checked_over_phone, new Object[]{3}), 0).show();
                    } else if (((C1039i) this.f3818l.get(i)).f3858d == 1) {
                        Toast.makeText(this, getString(R.string.vcard_list_checked_over_email, new Object[]{3}), 0).show();
                    }
                    ((C1039i) this.f3818l.get(i)).f3860f = false;
                    this.f3820n--;
                }
            } else {
                this.f3820n--;
            }
            if (this.f3820n > 0) {
                this.f3826t.setEnabled(true);
            } else {
                this.f3826t.setEnabled(false);
            }
            if (this.f3820n == this.f3818l.size()) {
                this.f3827u.setTag("selected");
                this.f3827u.setImageResource(R.drawable.check_select);
            } else {
                this.f3827u.setImageResource(R.drawable.check_normal);
                this.f3827u.setTag("unselected");
            }
            m4017a(view.findViewById(R.id.vcard_checkbtn), (C1039i) this.f3818l.get(i));
        }
    }

    /* renamed from: a */
    private int m4007a(int i) {
        int i2 = 0;
        Iterator it = this.f3818l.iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                C1039i c1039i = (C1039i) it.next();
                if (c1039i.f3858d == i && c1039i.f3860f) {
                    i3++;
                }
                i2 = i3;
            } else {
                return i3;
            }
        }
    }

    @Deprecated
    /* renamed from: a */
    public void m4017a(View view, C1039i c1039i) {
        if (c1039i.f3860f) {
            ((ImageView) view).setImageResource(R.drawable.check_select);
        } else {
            ((ImageView) view).setImageResource(R.drawable.check_normal);
        }
    }

    /* renamed from: b */
    public void m4020b(View view, C1039i c1039i) {
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
            String string2 = "";
            switch (c1039i.f3855a) {
                case 1:
                    string2 = getString(R.string.vcard_email_type_01);
                    break;
                case 2:
                    string2 = getString(R.string.vcard_email_type_02);
                    break;
                case 3:
                    string2 = getString(R.string.vcard_email_type_03);
                    break;
                case 4:
                    string2 = getString(R.string.vcard_email_type_04);
                    break;
            }
            ((TextView) view).setText(string2);
            return;
        }
        if (c1039i.f3858d == 9) {
            ((TextView) view).setText(getString(R.string.vcard_notes_type));
        }
    }

    /* renamed from: c */
    public void m4021c(View view, C1039i c1039i) {
        if (c1039i.f3856b != null) {
            ((TextView) view).setText(c1039i.f3856b);
        }
    }

    /* renamed from: d */
    public void m4022d(View view, C1039i c1039i) {
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

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            m4011a(intent.getData());
        } else {
            finish();
        }
    }

    /* renamed from: a */
    private void m4011a(Uri uri) {
        new AsyncTaskC1050t(this).execute(uri);
    }

    /* renamed from: a */
    protected void m4018a(C1038h c1038h) {
        ArrayList arrayList = new ArrayList();
        if (c1038h != null) {
            if (c1038h.f3843a != null) {
                this.f3819m.f3843a = c1038h.f3843a;
            }
            if (c1038h.f3844b != null) {
                this.f3819m.f3844b = c1038h.f3844b;
            }
            if (c1038h.f3845c != null) {
                this.f3819m.f3845c = c1038h.f3845c;
            }
            if (c1038h.f3846d != null && c1038h.f3846d.length() > 0) {
                this.f3819m.f3846d = c1038h.f3846d;
            }
        }
        if (c1038h.f3850h != null) {
            boolean z = false;
            for (int i = 0; c1038h.f3850h.size() > i; i++) {
                String str = ((C1042l) c1038h.f3850h.get(i)).f3872c;
                if (((C1042l) c1038h.f3850h.get(i)).f3870a == 1 || ((C1042l) c1038h.f3850h.get(i)).f3870a == 2 || ((C1042l) c1038h.f3850h.get(i)).f3870a == 3 || ((C1042l) c1038h.f3850h.get(i)).f3870a == 4) {
                    String strReplace = ((C1042l) c1038h.f3850h.get(i)).f3871b.replace("-", "");
                    C1786r.m6067f("ORIGINAL PHONE NUMBER : " + ((C1042l) c1038h.f3850h.get(i)).f3871b, f3807a);
                    C1786r.m6067f("EDITED PHONE NUMBER : " + strReplace, f3807a);
                    arrayList.add(new C1039i(((C1042l) c1038h.f3850h.get(i)).f3870a, strReplace, str, 5, !z));
                    z = true;
                }
            }
        }
        if (c1038h.f3851i != null && c1038h.f3851i.size() > 0) {
            arrayList.add(new C1039i(((C1040j) c1038h.f3851i.get(0)).f3861a, ((C1040j) c1038h.f3851i.get(0)).f3862b, ((C1040j) c1038h.f3851i.get(0)).f3863c, 1, true));
        }
        if (c1038h.f3846d != null && !c1038h.f3846d.equals("")) {
            arrayList.add(new C1039i(0, c1038h.f3846d, null, 9, true));
        }
        TextView textView = (TextView) findViewById(R.id.vcard_name_text);
        if (c1038h.f3843a != null) {
            if (c1038h.f3844b != null) {
                String str2 = c1038h.f3843a + " " + c1038h.f3844b;
                textView.setText(str2);
                setTitle(str2);
            } else {
                textView.setText(c1038h.f3843a);
                setTitle(c1038h.f3843a);
            }
        } else if (c1038h.f3844b != null) {
            textView.setText(c1038h.f3844b);
            setTitle(c1038h.f3844b);
        } else if (c1038h.f3845c != null) {
            textView.setText(c1038h.f3845c);
        } else if (c1038h.f3850h != null) {
            textView.setText(((C1042l) c1038h.f3850h.get(0)).f3871b);
        } else if (c1038h.f3851i != null) {
            textView.setText(((C1040j) c1038h.f3851i.get(0)).f3862b);
        } else {
            textView.setText(" ");
            setTitle("");
        }
        ((ImageView) findViewById(R.id.vcard_image_icon)).setScaleType(ImageView.ScaleType.FIT_XY);
        this.f3818l = arrayList;
        if (arrayList.size() > 0) {
            this.f3811b = new C1052v(this, this.f3818l);
            getListView().setDivider(getResources().getDrawable(R.drawable.list_2line));
            setListAdapter(this.f3811b);
        } else {
            getListView().setVisibility(8);
            this.f3824r.setVisibility(0);
            this.f3825s.setVisibility(8);
            findViewById(R.id.divider).setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011b  */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m4019a(java.lang.String r6) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.vcard.VCardReadContactActivity.m4019a(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4010a() throws Throwable {
        try {
            this.f3813g = new C1046p().m4043a(this.f3819m, 1);
            C1786r.m6067f("*** VCARD CONTENTS : " + this.f3813g, f3807a);
        } catch (C1047q e) {
            e.printStackTrace();
        }
        if (this.f3813g != null) {
            m4019a(this.f3813g);
        } else {
            this.f3814h = R.string.toast_make_failed;
            finish();
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                this.f3812f = new ProgressDialogC1806j(this);
                this.f3812f.setProgressStyle(0);
                this.f3812f.setMessage(getString(R.string.wait_sending));
                return this.f3812f;
            default:
                return null;
        }
    }

    @Override // android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        if (this.f3814h != -1) {
            Toast.makeText(this.f3815i, this.f3814h, 0).show();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m4013b();
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C1786r.m6061b("onUserLeaveHint", getClass().getSimpleName());
        C1781m.m6022b(getApplicationContext());
    }

    /* renamed from: b */
    private void m4013b() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }
}
