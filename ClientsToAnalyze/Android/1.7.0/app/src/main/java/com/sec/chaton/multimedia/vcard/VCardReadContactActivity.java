package com.sec.chaton.multimedia.vcard;

import android.app.Dialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.widget.C1619g;
import com.sec.widget.GeneralHeaderView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class VCardReadContactActivity extends ListActivity {

    /* renamed from: a */
    public static final String f2836a = VCardReadContactActivity.class.getSimpleName();

    /* renamed from: c */
    public static String f2837c = "extra vard name";

    /* renamed from: d */
    public static String f2838d = "extra filekey";

    /* renamed from: e */
    public static String f2839e = "extra fileuri";

    /* renamed from: f */
    ProgressDialog f2841f;

    /* renamed from: i */
    Context f2844i;

    /* renamed from: j */
    private AbstractC0840q f2845j;

    /* renamed from: l */
    private C0833j f2847l;

    /* renamed from: n */
    private String f2849n;

    /* renamed from: p */
    private String f2851p;

    /* renamed from: q */
    private LinearLayout f2852q;

    /* renamed from: r */
    private BroadcastReceiver f2853r;

    /* renamed from: s */
    private GeneralHeaderView f2854s;

    /* renamed from: b */
    public C0835l f2840b = null;

    /* renamed from: k */
    private List f2846k = new ArrayList();

    /* renamed from: m */
    private int f2848m = 0;

    /* renamed from: o */
    private final int f2850o = 0;

    /* renamed from: g */
    String f2842g = null;

    /* renamed from: h */
    int f2843h = -1;

    /* renamed from: t */
    private Runnable f2855t = new RunnableC0837n(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            C1619g.m5888a(getBaseContext(), R.string.chat_send_recordvodeo_toast_failed, 0).show();
            finish();
            return;
        }
        this.f2851p = getIntent().getStringExtra("inbox_NO");
        this.f2845j = AbstractC0840q.m3411a(this);
        setContentView(R.layout.layout_multimedia_vcard_send);
        this.f2844i = this;
        this.f2847l = new C0833j();
        this.f2854s = (GeneralHeaderView) findViewById(R.id.contact_header_view);
        this.f2854s.setButtonEnabled(false);
        this.f2854s.setButtonClickListener(new ViewOnClickListenerC0838o(this));
        this.f2852q = (LinearLayout) findViewById(R.id.vcard_nocontact_layout);
        startActivityForResult(this.f2845j.mo3355a(), 1);
    }

    @Override // android.app.Activity
    protected void onResume() {
        m3374b();
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onPause() {
        m3378d();
        super.onPause();
    }

    @Override // android.app.ListActivity
    protected void onListItemClick(ListView listView, View view, int i, long j) {
        super.onListItemClick(listView, view, i, j);
        C1341p.m4663f("POSITION : " + i, "VCardReadContactActivity");
        C1341p.m4663f("CONTACT KIND : " + ((C0834k) this.f2846k.get(i)).f2910d, "VCardReadContactActivity");
        C1341p.m4663f("CONTACT TYPE : " + ((C0834k) this.f2846k.get(i)).f2907a, "VCardReadContactActivity");
        C1341p.m4663f("CONTACT DATA : " + ((C0834k) this.f2846k.get(i)).f2908b, "VCardReadContactActivity");
        if (this.f2846k.get(i) != null) {
            ((C0834k) this.f2846k.get(i)).f2912f = !((C0834k) this.f2846k.get(i)).f2912f;
            if (((C0834k) this.f2846k.get(i)).f2912f) {
                this.f2848m++;
                if (m3369a(((C0834k) this.f2846k.get(i)).f2910d) > 3) {
                    if (((C0834k) this.f2846k.get(i)).f2910d == 5) {
                        C1619g.m5889a(this, getString(R.string.vcard_list_checked_over_phone, new Object[]{3}), 0).show();
                    } else if (((C0834k) this.f2846k.get(i)).f2910d == 1) {
                        C1619g.m5889a(this, getString(R.string.vcard_list_checked_over_email, new Object[]{3}), 0).show();
                    }
                    ((C0834k) this.f2846k.get(i)).f2912f = false;
                    this.f2848m--;
                }
            } else {
                this.f2848m--;
            }
            if (this.f2848m > 0) {
                this.f2854s.setButtonEnabled(true);
            } else {
                this.f2854s.setButtonEnabled(false);
            }
            ((CheckBox) view.findViewById(R.id.vcard_checkbtn)).setChecked(((C0834k) this.f2846k.get(i)).f2912f);
        }
    }

    /* renamed from: a */
    private int m3369a(int i) {
        int i2 = 0;
        Iterator it = this.f2846k.iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                C0834k c0834k = (C0834k) it.next();
                if (c0834k.f2910d == i && c0834k.f2912f) {
                    i3++;
                }
                i2 = i3;
            } else {
                return i3;
            }
        }
    }

    /* renamed from: a */
    public void m3381a(View view, C0834k c0834k) {
        if (c0834k.f2910d == 5) {
            String string = "";
            switch (c0834k.f2907a) {
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
        if (c0834k.f2910d == 1) {
            ((TextView) view).setText(getString(R.string.vcard_type_email));
        } else if (c0834k.f2910d == 9) {
            ((TextView) view).setText(getString(R.string.vcard_notes_type));
        }
    }

    /* renamed from: b */
    public void m3384b(View view, C0834k c0834k) {
        if (c0834k.f2908b != null) {
            ((TextView) view).setText(c0834k.f2908b);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            m3372a(intent.getData());
        } else {
            finish();
        }
    }

    /* renamed from: a */
    private void m3372a(Uri uri) {
        new AsyncTaskC0836m(this).execute(uri);
    }

    /* renamed from: a */
    protected void m3382a(C0833j c0833j) {
        ArrayList arrayList = new ArrayList();
        if (c0833j.f2895a != null) {
            this.f2847l.f2895a = c0833j.f2895a;
        }
        if (c0833j.f2896b != null) {
            this.f2847l.f2896b = c0833j.f2896b;
        }
        if (c0833j.f2897c != null) {
            this.f2847l.f2897c = c0833j.f2897c;
        }
        if (c0833j.f2898d != null && c0833j.f2898d.length() > 0) {
            this.f2847l.f2898d = c0833j.f2898d;
        }
        if (c0833j.f2902h != null) {
            int i = 0;
            while (c0833j.f2902h.size() > i) {
                String str = ((C0825b) c0833j.f2902h.get(i)).f2865c;
                if (((C0825b) c0833j.f2902h.get(i)).f2863a == 1 || ((C0825b) c0833j.f2902h.get(i)).f2863a == 2 || ((C0825b) c0833j.f2902h.get(i)).f2863a == 3 || ((C0825b) c0833j.f2902h.get(i)).f2863a == 4) {
                    String strReplace = ((C0825b) c0833j.f2902h.get(i)).f2864b.replace("-", "");
                    C1341p.m4663f("ORIGINAL PHONE NUMBER : " + ((C0825b) c0833j.f2902h.get(i)).f2864b, f2836a);
                    C1341p.m4663f("EDITED PHONE NUMBER : " + strReplace, f2836a);
                    arrayList.add(new C0834k(((C0825b) c0833j.f2902h.get(i)).f2863a, strReplace, str, 5, i == 0));
                }
                i++;
            }
        }
        if (c0833j.f2903i != null && c0833j.f2903i.size() > 0) {
            arrayList.add(new C0834k(((C0842s) c0833j.f2903i.get(0)).f2921a, ((C0842s) c0833j.f2903i.get(0)).f2922b, ((C0842s) c0833j.f2903i.get(0)).f2923c, 1, true));
        }
        if (c0833j.f2898d != null && !c0833j.f2898d.equals("")) {
            arrayList.add(new C0834k(0, c0833j.f2898d, null, 9, true));
        }
        if (c0833j.f2895a != null) {
            if (c0833j.f2896b != null) {
                this.f2854s.setText(c0833j.f2895a + " " + c0833j.f2896b);
            } else {
                this.f2854s.setText(c0833j.f2895a);
            }
        } else if (c0833j.f2896b != null) {
            this.f2854s.setText(c0833j.f2896b);
        } else if (c0833j.f2897c != null) {
            this.f2854s.setText(c0833j.f2897c);
        } else if (c0833j.f2902h != null) {
            this.f2854s.setText(((C0825b) c0833j.f2902h.get(0)).f2864b);
        } else if (c0833j.f2903i != null) {
            this.f2854s.setText(((C0842s) c0833j.f2903i.get(0)).f2922b);
        } else {
            this.f2854s.setText(" ");
        }
        this.f2846k = arrayList;
        if (arrayList.size() > 0) {
            this.f2840b = new C0835l(this, this.f2846k);
            setListAdapter(this.f2840b);
        } else {
            getListView().setVisibility(8);
            this.f2852q.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012a  */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3383a(java.lang.String r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.vcard.VCardReadContactActivity.m3383a(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3371a() throws Throwable {
        try {
            this.f2842g = new C0824a().m3398a(this.f2847l, 1);
            C1341p.m4663f("*** VCARD CONTENTS : " + this.f2842g, f2836a);
        } catch (C0841r e) {
            e.printStackTrace();
        }
        if (this.f2842g != null) {
            m3383a(this.f2842g);
        } else {
            this.f2843h = R.string.toast_make_failed;
            finish();
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                this.f2841f = new ProgressDialogC1354a(this);
                this.f2841f.setProgressStyle(0);
                this.f2841f.setMessage(getString(R.string.wait_sending));
                return this.f2841f;
            default:
                return null;
        }
    }

    @Override // android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        if (this.f2843h != -1) {
            C1619g.m5888a(this.f2844i, this.f2843h, 0).show();
        }
        super.onDestroy();
    }

    /* renamed from: b */
    private void m3374b() {
        this.f2853r = new C0839p(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f2853r, intentFilter);
        m3376c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3376c() {
        if (!C1327bw.m4595a()) {
            C1619g.m5888a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    /* renamed from: d */
    private void m3378d() {
        unregisterReceiver(this.f2853r);
    }
}
