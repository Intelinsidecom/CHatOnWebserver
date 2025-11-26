package com.sec.chaton.multimedia.vcard;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class VCardReadContactFragment extends ListFragment implements InterfaceC1940n {

    /* renamed from: a */
    public static final String f7375a = VCardReadContactFragment.class.getSimpleName();

    /* renamed from: b */
    private AbstractC1927a f7376b;

    /* renamed from: e */
    private C1928b f7379e;

    /* renamed from: g */
    private String f7381g;

    /* renamed from: h */
    private ProgressDialog f7382h;

    /* renamed from: j */
    private Context f7384j;

    /* renamed from: k */
    private String f7385k;

    /* renamed from: l */
    private LinearLayout f7386l;

    /* renamed from: m */
    private String f7387m;

    /* renamed from: n */
    private MenuItem f7388n;

    /* renamed from: c */
    private C1941o f7377c = null;

    /* renamed from: d */
    private List<C1929c> f7378d = new ArrayList();

    /* renamed from: f */
    private int f7380f = 0;

    /* renamed from: i */
    private String f7383i = null;

    /* renamed from: o */
    private Runnable f7389o = new RunnableC1944r(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7385k = getArguments().getString("inbox_NO");
        this.f7376b = AbstractC1927a.m7863a(getActivity());
        this.f7384j = getActivity();
        setHasOptionsMenu(true);
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_multimedia_vcard_send, viewGroup, false);
        this.f7386l = (LinearLayout) viewInflate.findViewById(R.id.vcard_nocontact_layout);
        this.f7382h = new ProgressDialogC3265l(this.f7384j);
        this.f7382h.setProgressStyle(0);
        this.f7382h.setMessage(getString(R.string.wait_sending));
        if (bundle == null) {
            m7858c();
        } else if (bundle.containsKey("dataUriString")) {
            this.f7387m = bundle.getString("dataUriString");
            if (!TextUtils.isEmpty(this.f7387m)) {
                m7854a(Uri.parse(this.f7387m));
            }
        }
        return viewInflate;
    }

    /* renamed from: b */
    private void m7855b() {
        int i = 0;
        for (int i2 = 0; this.f7378d.size() > i2; i2++) {
            if (this.f7378d.get(i2).f7404d == 9 && !this.f7378d.get(i2).f7406f) {
                this.f7379e.f7394d = null;
            }
            if (this.f7378d.get(i2).f7406f) {
                i++;
                if (this.f7378d.get(i2).f7404d == 5) {
                    this.f7379e.m7864a(this.f7378d.get(i2).f7401a, this.f7378d.get(i2).f7402b, this.f7378d.get(i2).f7403c, true);
                } else if (this.f7378d.get(i2).f7404d == 1) {
                    this.f7379e.m7865b(this.f7378d.get(i2).f7401a, this.f7378d.get(i2).f7402b, this.f7378d.get(i2).f7403c, true);
                }
            }
        }
        if (i <= 0) {
            getActivity().finish();
        } else {
            this.f7382h.show();
            new Thread((ThreadGroup) null, this.f7389o).start();
        }
    }

    /* renamed from: c */
    private void m7858c() {
        try {
            startActivityForResult(this.f7376b.mo7831a(), 1);
        } catch (ActivityNotFoundException e) {
            C3250y.m11443a(e, getClass().getSimpleName());
            C3641ai.m13210a(this.f7384j, R.string.toast_contact_not_found, 0).show();
            getActivity().finish();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("dataUriString", this.f7387m);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.ListFragment
    public void onListItemClick(ListView listView, View view, int i, long j) {
        super.onListItemClick(listView, view, i, j);
        C3250y.m11458g("POSITION : " + i, "VCardReadContactActivity");
        C3250y.m11458g("CONTACT KIND : " + this.f7378d.get(i).f7404d, "VCardReadContactActivity");
        C3250y.m11458g("CONTACT TYPE : " + this.f7378d.get(i).f7401a, "VCardReadContactActivity");
        C3250y.m11458g("CONTACT DATA : " + this.f7378d.get(i).f7402b, "VCardReadContactActivity");
        if (this.f7378d.get(i) != null) {
            this.f7378d.get(i).f7406f = !this.f7378d.get(i).f7406f;
            if (this.f7378d.get(i).f7406f) {
                this.f7380f++;
                if (m7852a(this.f7378d.get(i).f7404d) > 3) {
                    if (this.f7378d.get(i).f7404d == 5) {
                        C3641ai.m13211a(this.f7384j, getString(R.string.vcard_list_checked_over_phone, 3), 0).show();
                    } else if (this.f7378d.get(i).f7404d == 1) {
                        C3641ai.m13211a(this.f7384j, getString(R.string.vcard_list_checked_over_email, 3), 0).show();
                    }
                    this.f7378d.get(i).f7406f = false;
                    this.f7380f--;
                }
            } else {
                this.f7380f--;
            }
            if (this.f7380f > 0) {
                this.f7388n.setEnabled(true);
            } else {
                this.f7388n.setEnabled(false);
            }
            ((C1942p) view.getTag()).f7455c.setChecked(this.f7378d.get(i).f7406f);
        }
    }

    /* renamed from: a */
    private int m7852a(int i) {
        int i2 = 0;
        Iterator<C1929c> it = this.f7378d.iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                C1929c next = it.next();
                if (next.f7404d == i && next.f7406f) {
                    i3++;
                }
                i2 = i3;
            } else {
                return i3;
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            m7854a(intent.getData());
            this.f7387m = intent.getDataString();
        } else {
            getActivity().finish();
        }
    }

    /* renamed from: a */
    private void m7854a(Uri uri) {
        new AsyncTaskC1943q(this).execute(uri);
    }

    /* renamed from: a */
    protected void m7861a(C1928b c1928b) {
        ArrayList arrayList = new ArrayList();
        this.f7379e = new C1928b();
        if (c1928b.f7391a != null) {
            this.f7379e.f7391a = c1928b.f7391a;
        }
        if (c1928b.f7392b != null) {
            this.f7379e.f7392b = c1928b.f7392b;
        }
        if (c1928b.f7393c != null) {
            this.f7379e.f7393c = c1928b.f7393c;
        }
        if (c1928b.f7394d != null && c1928b.f7394d.length() > 0) {
            this.f7379e.f7394d = c1928b.f7394d;
        }
        if (c1928b.f7396f != null) {
            int i = 0;
            while (c1928b.f7396f.size() > i) {
                String str = c1928b.f7396f.get(i).f7418c;
                if (c1928b.f7396f.get(i).f7416a == 1 || c1928b.f7396f.get(i).f7416a == 2 || c1928b.f7396f.get(i).f7416a == 3 || c1928b.f7396f.get(i).f7416a == 4) {
                    String str2 = c1928b.f7396f.get(i).f7417b;
                    C3250y.m11458g("ORIGINAL PHONE NUMBER : " + c1928b.f7396f.get(i).f7417b, f7375a);
                    C3250y.m11458g("EDITED PHONE NUMBER : " + str2, f7375a);
                    arrayList.add(new C1929c(c1928b.f7396f.get(i).f7416a, str2, str, 5, i == 0));
                }
                i++;
            }
        }
        if (c1928b.f7397g != null && c1928b.f7397g.size() > 0) {
            arrayList.add(new C1929c(c1928b.f7397g.get(0).f7407a, c1928b.f7397g.get(0).f7408b, c1928b.f7397g.get(0).f7409c, 1, true));
        }
        if (c1928b.f7394d != null && !c1928b.f7394d.equals("")) {
            arrayList.add(new C1929c(0, c1928b.f7394d, null, 9, true));
        }
        String str3 = "";
        if (c1928b.f7391a != null) {
            if (c1928b.f7392b != null) {
                str3 = c1928b.f7391a + " " + c1928b.f7392b;
            } else {
                str3 = c1928b.f7391a;
            }
        } else if (c1928b.f7392b != null) {
            str3 = c1928b.f7392b;
        } else if (c1928b.f7393c != null) {
            str3 = c1928b.f7393c;
        } else if (c1928b.f7396f != null) {
            str3 = c1928b.f7396f.get(0).f7417b;
        } else if (c1928b.f7397g != null) {
            str3 = c1928b.f7397g.get(0).f7408b;
        }
        m7857b(str3);
        this.f7378d = arrayList;
        if (arrayList.size() > 0) {
            this.f7377c = new C1941o(getActivity(), this.f7378d);
            setListAdapter(this.f7377c);
            getListView().setVisibility(0);
            this.f7386l.setVisibility(8);
            return;
        }
        getListView().setVisibility(8);
        this.f7386l.setVisibility(0);
    }

    /* renamed from: b */
    private void m7857b(String str) {
        if (getActivity() != null) {
            ((VCardReadContactActivity) getActivity()).m7851c().mo11583a(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013c  */
    /* JADX WARN: Type inference failed for: r1v25, types: [android.support.v4.app.FragmentActivity] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m7862a(java.lang.String r6) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.vcard.VCardReadContactFragment.m7862a(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m7859d() throws Throwable {
        try {
            this.f7383i = new C1937k().m7882a(this.f7379e, 1);
            C3250y.m11458g("*** VCARD CONTENTS : " + this.f7383i, f7375a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f7383i != null) {
            m7862a(this.f7383i);
        } else {
            getActivity().finish();
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            if (getActivity() != null) {
                getActivity().finish();
                return true;
            }
        } else if (menuItem.getItemId() == R.id.menu_done) {
            m7855b();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.done_menu, menu);
        this.f7388n = menu.findItem(R.id.menu_done);
        this.f7388n.setEnabled(false);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // com.sec.chaton.multimedia.vcard.InterfaceC1940n
    /* renamed from: a */
    public void mo7860a() {
        this.f7380f = 0;
        this.f7388n.setEnabled(false);
        m7858c();
    }
}
