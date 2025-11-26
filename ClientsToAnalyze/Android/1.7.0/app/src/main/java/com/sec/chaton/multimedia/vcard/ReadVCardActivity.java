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
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.widget.C1619g;
import com.sec.widget.GeneralHeaderView;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ReadVCardActivity extends ListActivity {

    /* renamed from: a */
    public static final String f2824a = ReadVCardActivity.class.getSimpleName();

    /* renamed from: f */
    private static C0833j f2825f = null;

    /* renamed from: c */
    ProgressDialog f2827c;

    /* renamed from: d */
    Context f2828d;

    /* renamed from: h */
    private C0833j f2831h;

    /* renamed from: k */
    private BroadcastReceiver f2834k;

    /* renamed from: l */
    private GeneralHeaderView f2835l;

    /* renamed from: e */
    private String f2829e = null;

    /* renamed from: b */
    public C0843t f2826b = null;

    /* renamed from: g */
    private List f2830g = new ArrayList();

    /* renamed from: i */
    private final int f2832i = 0;

    /* renamed from: j */
    private boolean f2833j = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_multimedia_vcard_send);
        this.f2828d = this;
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("URI")) {
            this.f2829e = extras.getString("URI");
        }
        if (extras != null && extras.containsKey("VCARD_SAVE")) {
            this.f2833j = extras.getBoolean("VCARD_SAVE");
        }
        f2825f = new C0833j();
        this.f2835l = (GeneralHeaderView) findViewById(R.id.contact_header_view);
        this.f2835l.setButtonImageResource(R.drawable.general_btn_icon_save_xml);
        this.f2831h = new C0833j();
        try {
            m3359b();
        } catch (C0841r e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        m3361c();
        this.f2826b = new C0843t(this, this.f2830g);
        setListAdapter(this.f2826b);
        this.f2835l.setButtonClickListener(new ViewOnClickListenerC0829f(this));
    }

    @Override // android.app.Activity
    protected void onResume() {
        m3362d();
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onPause() {
        m3364f();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3357a() {
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.dir/contact");
        intent.putExtra("name", f2825f.f2895a);
        intent.putExtra("company", f2825f.f2897c);
        intent.putExtra("notes", f2825f.f2898d);
        if (f2825f.f2902h != null && f2825f.f2902h.size() > 0) {
            try {
                intent.putExtra("phone_type", ((C0825b) f2825f.f2902h.get(0)).f2863a);
                intent.putExtra("phone", ((C0825b) f2825f.f2902h.get(0)).f2864b);
            } catch (Exception e) {
            }
            try {
                intent.putExtra("secondary_phone_type", ((C0825b) f2825f.f2902h.get(1)).f2863a);
                intent.putExtra("secondary_phone", ((C0825b) f2825f.f2902h.get(1)).f2864b);
            } catch (Exception e2) {
            }
            try {
                intent.putExtra("tertiary_phone_type", ((C0825b) f2825f.f2902h.get(2)).f2863a);
                intent.putExtra("tertiary_phone", ((C0825b) f2825f.f2902h.get(2)).f2864b);
            } catch (Exception e3) {
            }
        }
        if (f2825f.f2903i != null && f2825f.f2903i.size() > 0) {
            try {
                intent.putExtra("email_type", ((C0842s) f2825f.f2903i.get(0)).f2921a);
                intent.putExtra("email", ((C0842s) f2825f.f2903i.get(0)).f2922b);
            } catch (Exception e4) {
            }
            try {
                intent.putExtra("secondary_email_type", ((C0842s) f2825f.f2903i.get(1)).f2921a);
                intent.putExtra("secondary_email", ((C0842s) f2825f.f2903i.get(1)).f2922b);
            } catch (Exception e5) {
            }
            try {
                intent.putExtra("tertiary_email_type", ((C0842s) f2825f.f2903i.get(2)).f2921a);
                intent.putExtra("tertiary_email", ((C0842s) f2825f.f2903i.get(2)).f2922b);
            } catch (Exception e6) {
            }
        }
        startActivityForResult(intent, 0);
    }

    /* renamed from: b */
    private void m3359b() throws IOException {
        C0826c c0826c = new C0826c();
        String str = null;
        if (this.f2829e != null) {
            String[] strArrSplit = this.f2829e.split("file://");
            if (strArrSplit.length == 1) {
                str = this.f2829e;
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
                C1341p.m4663f("**** READ VCARD : " + ((Object) sb), f2824a);
                f2825f = c0826c.m3399a(sb.toString());
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
            m3366a(((TextView) view.findViewById(R.id.list_vcard_sub_text)).getText());
        }
        if (strSubstring.equals(getString(R.string.vcard_type_email))) {
            m3368b(((TextView) view.findViewById(R.id.list_vcard_sub_text)).getText());
        }
    }

    /* renamed from: a */
    public void m3365a(View view, C0834k c0834k) {
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
            return;
        }
        if (c0834k.f2910d == 9) {
            ((TextView) view).setText(getString(R.string.vcard_notes_type));
        } else if (c0834k.f2909c != null) {
            ((TextView) view).setText(getString(R.string.vcard_type_other) + c0834k.f2909c);
        } else {
            ((TextView) view).setText(getString(R.string.vcard_type_other));
        }
    }

    /* renamed from: b */
    public void m3367b(View view, C0834k c0834k) {
        if (c0834k.f2908b != null) {
            if (c0834k.f2910d == 5) {
                ((TextView) view).setText(c0834k.f2908b.replace("-", ""));
            } else {
                ((TextView) view).setText(c0834k.f2908b);
            }
        }
    }

    /* renamed from: c */
    private void m3361c() {
        if (f2825f.f2895a != null) {
            this.f2831h.f2895a = f2825f.f2895a;
        }
        if (f2825f.f2896b != null) {
            this.f2831h.f2896b = f2825f.f2896b;
        }
        if (f2825f.f2897c != null) {
            this.f2831h.f2897c = f2825f.f2897c;
        }
        if (f2825f.f2898d != null) {
            this.f2831h.f2898d = f2825f.f2898d;
        }
        if (f2825f.f2902h != null) {
            int i = 0;
            while (f2825f.f2902h.size() > i) {
                this.f2830g.add(new C0834k(((C0825b) f2825f.f2902h.get(i)).f2863a, ((C0825b) f2825f.f2902h.get(i)).f2864b, ((C0825b) f2825f.f2902h.get(i)).f2865c, 5, i == 0));
                i++;
            }
        }
        if (f2825f.f2903i != null) {
            int i2 = 0;
            while (f2825f.f2903i.size() > i2) {
                this.f2830g.add(new C0834k(((C0842s) f2825f.f2903i.get(i2)).f2921a, ((C0842s) f2825f.f2903i.get(i2)).f2922b, ((C0842s) f2825f.f2903i.get(i2)).f2923c, 1, i2 == 0));
                i2++;
            }
        }
        if (f2825f.f2898d != null && f2825f.f2898d.trim().length() > 0) {
            this.f2830g.add(new C0834k(0, f2825f.f2898d, null, 9, true));
        }
        if (f2825f.f2895a != null) {
            if (f2825f.f2896b != null) {
                this.f2835l.setText(f2825f.f2895a + " " + f2825f.f2896b);
                return;
            } else {
                this.f2835l.setText(f2825f.f2895a);
                return;
            }
        }
        if (f2825f.f2896b != null) {
            this.f2835l.setText(f2825f.f2896b);
            return;
        }
        if (f2825f.f2897c != null) {
            this.f2835l.setText(f2825f.f2897c);
            return;
        }
        if (f2825f.f2902h != null) {
            this.f2835l.setText(((C0825b) f2825f.f2902h.get(0)).f2864b);
        } else if (f2825f.f2903i != null) {
            this.f2835l.setText(((C0842s) f2825f.f2903i.get(0)).f2922b);
        } else {
            this.f2835l.setText(" ");
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                this.f2827c = new ProgressDialogC1354a(this);
                this.f2827c.setProgressStyle(0);
                this.f2827c.setMessage(getString(R.string.wait_sending));
                return this.f2827c;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public void m3366a(CharSequence charSequence) {
        if (charSequence != null) {
            try {
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + ((Object) charSequence))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public void m3368b(CharSequence charSequence) {
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

    /* renamed from: d */
    private void m3362d() {
        this.f2834k = new C0828e(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f2834k, intentFilter);
        m3363e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m3363e() {
        if (!C1327bw.m4595a()) {
            C1619g.m5888a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    /* renamed from: f */
    private void m3364f() {
        unregisterReceiver(this.f2834k);
    }
}
