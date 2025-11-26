package com.sec.chaton.multimedia.vcard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.p137vk.sdk.VKScope;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.smsplugin.p102b.C3789h;
import com.sec.chaton.util.C4904y;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ReadVCardFragment extends ListFragment {

    /* renamed from: i */
    public static final String f10684i = ReadVCardFragment.class.getSimpleName();

    /* renamed from: j */
    private String f10685j = null;

    /* renamed from: k */
    private C2897b f10686k = null;

    /* renamed from: l */
    private C2904i f10687l = null;

    /* renamed from: m */
    private List<C2898c> f10688m = new ArrayList();

    /* renamed from: n */
    private C2897b f10689n;

    /* renamed from: o */
    private MenuItem f10690o;

    /* renamed from: p */
    private String f10691p;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments().containsKey("URI")) {
            this.f10685j = getArguments().getString("URI");
        }
        this.f10686k = new C2897b();
        this.f10689n = new C2897b();
        setHasOptionsMenu(true);
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Throwable {
        View viewInflate = layoutInflater.inflate(R.layout.layout_multimedia_vcard_send, viewGroup, false);
        try {
            m12070d();
        } catch (IOException e) {
            C4904y.m18635a(e, f10684i);
        } catch (Exception e2) {
            C4904y.m18635a(e2, f10684i);
        }
        m12071e();
        this.f10687l = C2904i.m12094a(getActivity(), this.f10688m);
        m61a(this.f10687l);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        m12068a(this.f10691p);
        super.onResume();
    }

    /* renamed from: c */
    private void m12069c() {
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.dir/contact");
        intent.putExtra("name", this.f10686k.f10712a);
        intent.putExtra(VKApiConst.COMPANY, this.f10686k.f10714c);
        intent.putExtra(VKScope.NOTES, this.f10686k.f10715d);
        if (this.f10686k.f10717f != null && this.f10686k.f10717f.size() > 0) {
            try {
                intent.putExtra("phone_type", this.f10686k.f10717f.get(0).f10737a);
                intent.putExtra("phone", this.f10686k.f10717f.get(0).f10738b);
            } catch (Exception e) {
            }
            try {
                intent.putExtra("secondary_phone_type", this.f10686k.f10717f.get(1).f10737a);
                intent.putExtra("secondary_phone", this.f10686k.f10717f.get(1).f10738b);
            } catch (Exception e2) {
            }
            try {
                intent.putExtra("tertiary_phone_type", this.f10686k.f10717f.get(2).f10737a);
                intent.putExtra("tertiary_phone", this.f10686k.f10717f.get(2).f10738b);
            } catch (Exception e3) {
            }
        }
        if (this.f10686k.f10718g != null && this.f10686k.f10718g.size() > 0) {
            try {
                intent.putExtra("email_type", this.f10686k.f10718g.get(0).f10728a);
                intent.putExtra("email", this.f10686k.f10718g.get(0).f10729b);
            } catch (Exception e4) {
            }
            try {
                intent.putExtra("secondary_email_type", this.f10686k.f10718g.get(1).f10728a);
                intent.putExtra("secondary_email", this.f10686k.f10718g.get(1).f10729b);
            } catch (Exception e5) {
            }
            try {
                intent.putExtra("tertiary_email_type", this.f10686k.f10718g.get(2).f10728a);
                intent.putExtra("tertiary_email", this.f10686k.f10718g.get(2).f10729b);
            } catch (Exception e6) {
            }
        }
        startActivityForResult(intent, 0);
    }

    /* renamed from: d */
    private void m12070d() throws Throwable {
        String str;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        C2907l c2907l = new C2907l();
        if (this.f10685j != null) {
            String[] strArrSplit = this.f10685j.split("file://");
            if (strArrSplit.length == 1) {
                str = this.f10685j;
            } else if (strArrSplit.length == 2) {
                str = strArrSplit[1];
            } else {
                getActivity().finish();
                str = null;
            }
        } else {
            str = null;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
        } catch (Throwable th) {
            th = th;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                } else {
                    sb.append(line + "\n");
                }
            }
            bufferedReader.close();
            C4904y.m18639b("**** READ VCARD : " + ((Object) sb), f10684i);
            this.f10686k = c2907l.m12111a(sb.toString());
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
    }

    @Override // android.support.v4.app.ListFragment
    /* renamed from: a */
    public void mo62a(ListView listView, View view, int i, long j) {
        super.mo62a(listView, view, i, j);
        C2905j c2905j = (C2905j) view.getTag();
        C2898c c2898c = c2905j.f10758c;
        if (c2898c != null) {
            if (5 == c2898c.f10725d) {
                m12072a(c2905j.f10757b.getText());
            } else if (1 == c2898c.f10725d) {
                m12073b(c2905j.f10757b.getText());
            }
        }
    }

    /* renamed from: a */
    public void m12072a(CharSequence charSequence) {
        if (charSequence != null) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + C3789h.m14307c((String) charSequence)));
                if (BuddyProfileActivity.m6743a(getActivity(), intent)) {
                    startActivity(intent);
                }
            } catch (Exception e) {
                C4904y.m18635a(e, f10684i);
            }
        }
    }

    /* renamed from: b */
    public void m12073b(CharSequence charSequence) {
        if (charSequence != null) {
            try {
                Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + charSequence.toString()));
                if (BuddyProfileActivity.m6743a(getActivity(), intent)) {
                    startActivity(intent);
                }
            } catch (Exception e) {
                C4904y.m18635a(e, f10684i);
            }
        }
    }

    /* renamed from: e */
    private void m12071e() {
        if (this.f10686k.f10712a != null) {
            this.f10689n.f10712a = this.f10686k.f10712a;
        }
        if (this.f10686k.f10713b != null) {
            this.f10689n.f10713b = this.f10686k.f10713b;
        }
        if (this.f10686k.f10714c != null) {
            this.f10689n.f10714c = this.f10686k.f10714c;
        }
        if (this.f10686k.f10715d != null) {
            this.f10689n.f10715d = this.f10686k.f10715d;
        }
        if (this.f10686k.f10717f != null) {
            int i = 0;
            while (this.f10686k.f10717f.size() > i) {
                this.f10688m.add(new C2898c(this.f10686k.f10717f.get(i).f10737a, this.f10686k.f10717f.get(i).f10738b, this.f10686k.f10717f.get(i).f10739c, 5, i == 0));
                i++;
            }
        }
        if (this.f10686k.f10718g != null) {
            int i2 = 0;
            while (this.f10686k.f10718g.size() > i2) {
                this.f10688m.add(new C2898c(this.f10686k.f10718g.get(i2).f10728a, this.f10686k.f10718g.get(i2).f10729b, this.f10686k.f10718g.get(i2).f10730c, 1, i2 == 0));
                i2++;
            }
        }
        if (this.f10686k.f10715d != null && this.f10686k.f10715d.trim().length() > 0) {
            this.f10688m.add(new C2898c(0, this.f10686k.f10715d, null, 9, true));
        }
        if (this.f10686k.f10712a != null) {
            if (this.f10686k.f10713b != null) {
                this.f10691p = this.f10686k.f10712a + " " + this.f10686k.f10713b;
                return;
            } else {
                this.f10691p = this.f10686k.f10712a;
                return;
            }
        }
        if (this.f10686k.f10713b != null) {
            this.f10691p = this.f10686k.f10713b;
            return;
        }
        if (this.f10686k.f10714c != null) {
            this.f10691p = this.f10686k.f10714c;
        } else if (this.f10686k.f10717f != null) {
            this.f10691p = this.f10686k.f10717f.get(0).f10738b;
        } else if (this.f10686k.f10718g != null) {
            this.f10691p = this.f10686k.f10718g.get(0).f10729b;
        }
    }

    /* renamed from: a */
    private void m12068a(String str) {
        if (getActivity() != null) {
            ((ReadVCardActivity) getActivity()).m12067h().mo18823a(str);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
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
            m12069c();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.done_menu, menu);
        this.f10690o = menu.findItem(R.id.menu_done);
        this.f10690o.setTitle(R.string.save);
        super.onCreateOptionsMenu(menu, menuInflater);
    }
}
