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
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.util.C3250y;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ReadVCardFragment extends ListFragment {

    /* renamed from: a */
    public static final String f7363a = ReadVCardFragment.class.getSimpleName();

    /* renamed from: b */
    private String f7364b = null;

    /* renamed from: c */
    private C1928b f7365c = null;

    /* renamed from: d */
    private C1935i f7366d = null;

    /* renamed from: e */
    private List<C1929c> f7367e = new ArrayList();

    /* renamed from: f */
    private C1928b f7368f;

    /* renamed from: g */
    private MenuItem f7369g;

    /* renamed from: h */
    private String f7370h;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments().containsKey("URI")) {
            this.f7364b = getArguments().getString("URI");
        }
        this.f7365c = new C1928b();
        this.f7368f = new C1928b();
        setHasOptionsMenu(true);
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Throwable {
        View viewInflate = layoutInflater.inflate(R.layout.layout_multimedia_vcard_send, viewGroup, false);
        try {
            m7842b();
        } catch (IOException e) {
            C3250y.m11443a(e, f7363a);
        } catch (Exception e2) {
            C3250y.m11443a(e2, f7363a);
        }
        m7843c();
        this.f7366d = new C1935i(getActivity(), this.f7367e);
        setListAdapter(this.f7366d);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        m7841a(this.f7370h);
        super.onResume();
    }

    /* renamed from: a */
    private void m7840a() {
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.dir/contact");
        intent.putExtra("name", this.f7365c.f7391a);
        intent.putExtra("company", this.f7365c.f7393c);
        intent.putExtra("notes", this.f7365c.f7394d);
        if (this.f7365c.f7396f != null && this.f7365c.f7396f.size() > 0) {
            try {
                intent.putExtra("phone_type", this.f7365c.f7396f.get(0).f7416a);
                intent.putExtra("phone", this.f7365c.f7396f.get(0).f7417b);
            } catch (Exception e) {
            }
            try {
                intent.putExtra("secondary_phone_type", this.f7365c.f7396f.get(1).f7416a);
                intent.putExtra("secondary_phone", this.f7365c.f7396f.get(1).f7417b);
            } catch (Exception e2) {
            }
            try {
                intent.putExtra("tertiary_phone_type", this.f7365c.f7396f.get(2).f7416a);
                intent.putExtra("tertiary_phone", this.f7365c.f7396f.get(2).f7417b);
            } catch (Exception e3) {
            }
        }
        if (this.f7365c.f7397g != null && this.f7365c.f7397g.size() > 0) {
            try {
                intent.putExtra("email_type", this.f7365c.f7397g.get(0).f7407a);
                intent.putExtra("email", this.f7365c.f7397g.get(0).f7408b);
            } catch (Exception e4) {
            }
            try {
                intent.putExtra("secondary_email_type", this.f7365c.f7397g.get(1).f7407a);
                intent.putExtra("secondary_email", this.f7365c.f7397g.get(1).f7408b);
            } catch (Exception e5) {
            }
            try {
                intent.putExtra("tertiary_email_type", this.f7365c.f7397g.get(2).f7407a);
                intent.putExtra("tertiary_email", this.f7365c.f7397g.get(2).f7408b);
            } catch (Exception e6) {
            }
        }
        startActivityForResult(intent, 0);
    }

    /* renamed from: b */
    private void m7842b() throws Throwable {
        String str;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        C1938l c1938l = new C1938l();
        if (this.f7364b != null) {
            String[] strArrSplit = this.f7364b.split("file://");
            if (strArrSplit.length == 1) {
                str = this.f7364b;
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
            C3250y.m11458g("**** READ VCARD : " + ((Object) sb), f7363a);
            this.f7365c = c1938l.m7883a(sb.toString());
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
    public void onListItemClick(ListView listView, View view, int i, long j) {
        super.onListItemClick(listView, view, i, j);
        C1936j c1936j = (C1936j) view.getTag();
        C1929c c1929c = c1936j.f7437c;
        if (c1929c != null) {
            if (5 == c1929c.f7404d) {
                m7844a(c1936j.f7436b.getText());
            } else if (1 == c1929c.f7404d) {
                m7845b(c1936j.f7436b.getText());
            }
        }
    }

    /* renamed from: a */
    public void m7844a(CharSequence charSequence) {
        if (charSequence != null) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + ((Object) charSequence)));
                if (BuddyProfileActivity.m3573a(getActivity(), intent)) {
                    startActivity(intent);
                }
            } catch (Exception e) {
                C3250y.m11443a(e, f7363a);
            }
        }
    }

    /* renamed from: b */
    public void m7845b(CharSequence charSequence) {
        if (charSequence != null) {
            try {
                Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + charSequence.toString()));
                if (BuddyProfileActivity.m3573a(getActivity(), intent)) {
                    startActivity(intent);
                }
            } catch (Exception e) {
                C3250y.m11443a(e, f7363a);
            }
        }
    }

    /* renamed from: c */
    private void m7843c() {
        if (this.f7365c.f7391a != null) {
            this.f7368f.f7391a = this.f7365c.f7391a;
        }
        if (this.f7365c.f7392b != null) {
            this.f7368f.f7392b = this.f7365c.f7392b;
        }
        if (this.f7365c.f7393c != null) {
            this.f7368f.f7393c = this.f7365c.f7393c;
        }
        if (this.f7365c.f7394d != null) {
            this.f7368f.f7394d = this.f7365c.f7394d;
        }
        if (this.f7365c.f7396f != null) {
            int i = 0;
            while (this.f7365c.f7396f.size() > i) {
                this.f7367e.add(new C1929c(this.f7365c.f7396f.get(i).f7416a, this.f7365c.f7396f.get(i).f7417b, this.f7365c.f7396f.get(i).f7418c, 5, i == 0));
                i++;
            }
        }
        if (this.f7365c.f7397g != null) {
            int i2 = 0;
            while (this.f7365c.f7397g.size() > i2) {
                this.f7367e.add(new C1929c(this.f7365c.f7397g.get(i2).f7407a, this.f7365c.f7397g.get(i2).f7408b, this.f7365c.f7397g.get(i2).f7409c, 1, i2 == 0));
                i2++;
            }
        }
        if (this.f7365c.f7394d != null && this.f7365c.f7394d.trim().length() > 0) {
            this.f7367e.add(new C1929c(0, this.f7365c.f7394d, null, 9, true));
        }
        if (this.f7365c.f7391a != null) {
            if (this.f7365c.f7392b != null) {
                this.f7370h = this.f7365c.f7391a + " " + this.f7365c.f7392b;
                return;
            } else {
                this.f7370h = this.f7365c.f7391a;
                return;
            }
        }
        if (this.f7365c.f7392b != null) {
            this.f7370h = this.f7365c.f7392b;
            return;
        }
        if (this.f7365c.f7393c != null) {
            this.f7370h = this.f7365c.f7393c;
        } else if (this.f7365c.f7396f != null) {
            this.f7370h = this.f7365c.f7396f.get(0).f7417b;
        } else if (this.f7365c.f7397g != null) {
            this.f7370h = this.f7365c.f7397g.get(0).f7408b;
        }
    }

    /* renamed from: a */
    private void m7841a(String str) {
        if (getActivity() != null) {
            ((ReadVCardActivity) getActivity()).m7839c().mo11583a(str);
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
            m7840a();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.done_menu, menu);
        this.f7369g = menu.findItem(R.id.menu_done);
        this.f7369g.setTitle(R.string.save);
        super.onCreateOptionsMenu(menu, menuInflater);
    }
}
