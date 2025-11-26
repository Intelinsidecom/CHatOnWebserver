package com.sec.chaton.buddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.InterfaceC0028an;
import android.support.v4.content.C0091c;
import android.support.v4.content.C0094f;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.dialog.SpamConfirmDialog;
import com.sec.chaton.p049b.ContextMenuC1056a;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p055d.C2135p;
import com.sec.chaton.p057e.C2228ap;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.sns.p115ui.facebook.FacebookFriendsPickerActivity;
import com.sec.chaton.sns.p115ui.weibo.WeiboFriendsPickerActivity;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BuddyRecommendFragment extends Fragment implements InterfaceC0028an<Cursor>, View.OnClickListener {

    /* renamed from: a */
    public static final String f4065a = BuddyRecommendFragment.class.getSimpleName();

    /* renamed from: A */
    private Activity f4066A;

    /* renamed from: B */
    private LinearLayout f4067B;

    /* renamed from: C */
    private LinearLayout f4068C;

    /* renamed from: D */
    private Button f4069D;

    /* renamed from: E */
    private Button f4070E;

    /* renamed from: e */
    private C1358hk f4077e;

    /* renamed from: f */
    private ListView f4078f;

    /* renamed from: g */
    private ImageView f4079g;

    /* renamed from: h */
    private ProgressDialog f4080h;

    /* renamed from: i */
    private C2128i f4081i;

    /* renamed from: j */
    private C2135p f4082j;

    /* renamed from: k */
    private String f4083k;

    /* renamed from: l */
    private int f4084l;

    /* renamed from: m */
    private String f4085m;

    /* renamed from: o */
    private long f4087o;

    /* renamed from: s */
    private C2210x f4091s;

    /* renamed from: u */
    private ViewGroup f4093u;

    /* renamed from: v */
    private ViewStub f4094v;

    /* renamed from: w */
    private View f4095w;

    /* renamed from: x */
    private ImageView f4096x;

    /* renamed from: y */
    private TextView f4097y;

    /* renamed from: z */
    private TextView f4098z;

    /* renamed from: n */
    private int f4086n = 0;

    /* renamed from: p */
    private boolean f4088p = true;

    /* renamed from: q */
    private boolean f4089q = false;

    /* renamed from: r */
    private ArrayList<String> f4090r = new ArrayList<>();

    /* renamed from: t */
    private boolean f4092t = false;

    /* renamed from: b */
    ContentObserver f4074b = new C1350hc(this, new Handler());

    /* renamed from: c */
    InterfaceC2211y f4075c = new C1351hd(this);

    /* renamed from: d */
    String f4076d = "type = 200 OR type = 201 OR type = 203 OR type = 202";

    /* renamed from: F */
    private View.OnClickListener f4071F = new ViewOnClickListenerC1352he(this);

    /* renamed from: G */
    private Handler f4072G = new HandlerC1353hf(this);

    /* renamed from: H */
    private Handler f4073H = new HandlerC1356hi(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f4066A = activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f4066A = null;
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_buddy_recommend, viewGroup, false);
        this.f4067B = (LinearLayout) viewInflate.findViewById(R.id.suggestions_header);
        this.f4093u = (ViewGroup) viewInflate.findViewById(R.id.suggestion_ignore_add_all_button);
        this.f4069D = (Button) this.f4093u.findViewById(R.id.button2);
        this.f4069D.setText(getResources().getString(R.string.buddy_suggestion_ignore_all));
        this.f4070E = (Button) this.f4093u.findViewById(R.id.button3);
        this.f4070E.setText(getResources().getString(R.string.buddy_suggestion_add_all));
        this.f4078f = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f4079g = (ImageView) viewInflate.findViewById(R.id.suggetions_divider);
        this.f4068C = (LinearLayout) layoutInflater.inflate(R.layout.layout_buddy_recommend_footer, (ViewGroup) null);
        this.f4095w = viewInflate.findViewById(R.id.no_recommendations_layout);
        this.f4096x = (ImageView) this.f4095w.findViewById(R.id.image1);
        this.f4096x.setImageResource(R.drawable.no_contents_buddies);
        this.f4097y = (TextView) this.f4095w.findViewById(R.id.text1);
        this.f4097y.setVisibility(8);
        this.f4098z = (TextView) this.f4095w.findViewById(R.id.text2);
        this.f4098z.setText(getResources().getString(R.string.contact_suggestions_informations, 24));
        m6907a((CharSequence) getResources().getString(R.string.add_buddy_suggestion_people_may_know));
        this.f4069D.setOnClickListener(new ViewOnClickListenerC1344gx(this));
        this.f4070E.setOnClickListener(new ViewOnClickListenerC1346gz(this));
        this.f4078f.setEmptyView(this.f4095w);
        this.f4091s = new C2210x(this.f4066A.getContentResolver(), this.f4075c);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (C4809aa.m18104a().m18119a("recomned_receive", (Boolean) true).booleanValue() || C4809aa.m18104a().m18119a("recomned_special", (Boolean) true).booleanValue()) {
            this.f4077e = new C1358hk(this, this.f4066A, R.layout.list_item_common_11, null);
            this.f4078f.setItemsCanFocus(true);
            this.f4078f.setAdapter((ListAdapter) this.f4077e);
            this.f4078f.setOnItemClickListener(new C1349hb(this));
            registerForContextMenu(this.f4078f);
            getLoaderManager().mo108a(0, null, this);
            this.f4077e.notifyDataSetChanged();
            this.f4081i = new C2128i(this.f4072G);
            this.f4082j = C2135p.m9578a(this.f4073H);
            this.f4080h = new ProgressDialogC4926s(this.f4066A, false);
            this.f4080h.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f4092t = false;
        this.f4066A.getContentResolver().registerContentObserver(C2228ap.f7956a, true, this.f4074b);
        this.f4091s.startQuery(1, null, C2228ap.f7956a, null, null, null, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sns_account_layout /* 2131166261 */:
                Intent intent = new Intent();
                String strM18121a = C4809aa.m18104a().m18121a("register_sns_type", (String) null);
                if (C4368e.f15815a.equals(strM18121a)) {
                    intent = intent.setClass(this.f4066A, FacebookFriendsPickerActivity.class);
                } else if (C4368e.f15817c.equals(strM18121a)) {
                    intent = intent.setClass(this.f4066A, WeiboFriendsPickerActivity.class);
                }
                startActivity(intent);
                break;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f4092t = true;
        this.f4066A.getContentResolver().unregisterContentObserver(this.f4074b);
        if (this.f4088p && this.f4087o > 0) {
            C4809aa.m18107a("recommend_timestamp", Long.valueOf(this.f4087o));
        }
        this.f4088p = true;
    }

    /* renamed from: b */
    private void m6915b(int i) {
        m6907a((CharSequence) (getResources().getString(R.string.add_buddy_suggestion_people_may_know) + " (" + Integer.toString(i) + ")"));
    }

    /* renamed from: a */
    private void m6907a(CharSequence charSequence) {
        if (this.f4067B != null) {
            ((TextView) this.f4067B.findViewById(R.id.text1)).setText(charSequence);
        }
    }

    /* renamed from: a */
    public void m6929a(int i) {
        if (this.f4093u != null) {
            if (i > 0) {
                this.f4093u.setVisibility(0);
            } else {
                this.f4093u.setVisibility(8);
            }
        }
    }

    /* renamed from: a */
    public void m6928a() {
        Cursor cursorA = this.f4077e.mo871a();
        m6931c();
        List<String> listM6927a = m6927a(cursorA);
        if (listM6927a.size() > 0) {
            this.f4081i.m9512b((ArrayList<String>) listM6927a, true);
        } else {
            m6932d();
        }
    }

    /* renamed from: b */
    public void m6930b() {
        Cursor cursorA = this.f4077e.mo871a();
        m6931c();
        List<String> listM6927a = m6927a(cursorA);
        if (listM6927a.size() > 0) {
            this.f4082j.m9580a((ArrayList<String>) listM6927a);
        } else {
            m6932d();
        }
    }

    /* renamed from: a */
    public List<String> m6927a(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    do {
                        arrayList.add(cursor.getString(cursor.getColumnIndex("buddy_no")));
                    } while (cursor.moveToNext());
                }
            } catch (Exception e) {
                if (C4904y.f17875e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public void m6931c() {
        if (this.f4080h == null) {
            this.f4080h = new ProgressDialogC4926s(this.f4066A, false);
            this.f4080h.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        }
        if (this.f4080h != null && !this.f4080h.isShowing()) {
            this.f4080h.show();
        }
    }

    /* renamed from: d */
    public void m6932d() {
        if (this.f4080h != null && this.f4080h.isShowing()) {
            this.f4080h.dismiss();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m6903a(android.content.ContentResolver r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r6 = 0
            java.lang.String r7 = ""
            android.net.Uri r1 = com.sec.chaton.p057e.C2228ap.f7956a     // Catch: java.lang.Throwable -> L3c
            r2 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c
            r0.<init>()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = "buddy_no='"
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.StringBuilder r0 = r0.append(r9)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = "'"
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = r0.toString()     // Catch: java.lang.Throwable -> L3c
            r4 = 0
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L3c
            if (r1 == 0) goto L46
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto L46
            r0 = 2
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L44
        L36:
            if (r1 == 0) goto L3b
            r1.close()
        L3b:
            return r0
        L3c:
            r0 = move-exception
            r1 = r6
        L3e:
            if (r1 == 0) goto L43
            r1.close()
        L43:
            throw r0
        L44:
            r0 = move-exception
            goto L3e
        L46:
            r0 = r7
            goto L36
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyRecommendFragment.m6903a(android.content.ContentResolver, java.lang.String):java.lang.String");
    }

    @Override // android.support.v4.app.InterfaceC0028an
    /* renamed from: a */
    public C0094f<Cursor> mo112a(int i, Bundle bundle) {
        return new C0091c(this.f4066A, C2228ap.f7956a, null, this.f4076d, null, "timestamp DESC");
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        Cursor cursorA;
        if (this.f4089q) {
            new C2128i(null).m9495a();
        }
        super.onDestroy();
        if (this.f4077e != null && (cursorA = this.f4077e.mo871a()) != null && !cursorA.isClosed()) {
            cursorA.close();
            if (C4904y.f17872b) {
                C4904y.m18639b("The Cursor of Adapter was closed", getClass().getSimpleName());
            }
        }
    }

    @Override // android.support.v4.app.InterfaceC0028an
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo114a(C0094f<Cursor> c0094f, Cursor cursor) {
        if (cursor != null) {
            int count = cursor.getCount();
            if (count == 0) {
                m6919e();
            }
            m6929a(count);
            m6915b(count);
        }
        Cursor cursorMo877b = this.f4077e.mo877b(cursor);
        if (cursorMo877b != null) {
            cursorMo877b.close();
        }
        this.f4077e.notifyDataSetChanged();
    }

    @Override // android.support.v4.app.InterfaceC0028an
    /* renamed from: a */
    public void mo113a(C0094f<Cursor> c0094f) {
        Cursor cursorMo877b = this.f4077e.mo877b(null);
        if (cursorMo877b != null) {
            cursorMo877b.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6909a(String str, int i) throws UnsupportedEncodingException {
        if (str == null) {
            str = this.f4083k;
        }
        m6931c();
        this.f4089q = true;
        this.f4081i.m9507b(str, true, EnumC2463n.UI);
        this.f4077e.notifyDataSetChanged();
        this.f4083k = str;
    }

    /* renamed from: a */
    private void m6908a(String str) {
        if (str == null) {
            str = this.f4083k;
        }
        m6931c();
        this.f4090r.add(str);
        this.f4082j.m9579a("true", this.f4090r);
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        ContextMenuC1056a contextMenuC1056a = new ContextMenuC1056a(this.f4066A, contextMenu);
        C1359hl c1359hl = new C1359hl(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).targetView);
        this.f4083k = c1359hl.f4947d.getTag(R.id.TAG_FOR_BUDDYNO).toString();
        this.f4084l = Integer.parseInt(c1359hl.f4947d.getTag(R.id.TAG_FOR_TYPE).toString());
        this.f4085m = c1359hl.f4946c.getText().toString();
        contextMenuC1056a.setHeaderTitle(this.f4085m);
        contextMenuC1056a.add(0, 100, 1, getResources().getString(R.string.buddy_add_contact));
        contextMenuC1056a.add(0, 101, 2, getResources().getString(R.string.buddy_suggestion_ignore));
        contextMenuC1056a.add(0, 102, 3, getResources().getString(R.string.spammer_report_title));
    }

    @Override // android.support.v4.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) throws UnsupportedEncodingException {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f4066A, R.string.popup_no_network_connection, 0).show();
            return true;
        }
        switch (menuItem.getItemId()) {
            case 100:
                m6909a(this.f4083k, this.f4084l);
                break;
            case 101:
                m6908a(this.f4083k);
                break;
            case 102:
                Intent intent = new Intent(getActivity(), (Class<?>) SpamConfirmDialog.class);
                if (TextUtils.isEmpty(this.f4085m)) {
                    intent.putExtra("SCD_DIALOG_BUDDY_NAME", this.f4083k);
                } else {
                    intent.putExtra("SCD_DIALOG_BUDDY_NAME", this.f4085m);
                }
                intent.putExtra("SCD_DIALOG_BUDDY_NO", this.f4083k);
                startActivity(intent);
                break;
        }
        return true;
    }

    /* renamed from: e */
    private void m6919e() {
        if (this.f4095w == null) {
            this.f4095w = this.f4094v.inflate();
            this.f4096x = (ImageView) this.f4095w.findViewById(R.id.image1);
            this.f4096x.setImageResource(R.drawable.no_contents_buddies);
            this.f4097y = (TextView) this.f4095w.findViewById(R.id.text1);
            this.f4097y.setVisibility(8);
            this.f4098z = (TextView) this.f4095w.findViewById(R.id.text2);
            this.f4098z.setText(getResources().getString(R.string.contact_suggestions_informations, 24));
            return;
        }
        this.f4096x = (ImageView) this.f4095w.findViewById(R.id.image1);
        this.f4096x.setImageResource(R.drawable.no_contents_buddies);
        this.f4097y = (TextView) this.f4095w.findViewById(R.id.text1);
        this.f4097y.setVisibility(8);
        this.f4098z = (TextView) this.f4095w.findViewById(R.id.text2);
        this.f4098z.setText(getResources().getString(R.string.contact_suggestions_informations, 24));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6910a(String str, String str2) {
        if (this.f4066A != null) {
            AbstractC4932a.m18733a(this.f4066A).mo18740a(str).mo18749b(str2).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1357hj(this)).mo18752b();
        }
    }
}
