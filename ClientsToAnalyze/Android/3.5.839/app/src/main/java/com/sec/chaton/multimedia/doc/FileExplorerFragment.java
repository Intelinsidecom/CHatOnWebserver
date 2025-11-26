package com.sec.chaton.multimedia.doc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4880cr;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import com.sec.common.p132g.C5007c;
import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

/* loaded from: classes.dex */
public class FileExplorerFragment extends Fragment implements InterfaceC2759c {

    /* renamed from: a */
    private static final String f9932a = FileExplorerFragment.class.getSimpleName();

    /* renamed from: b */
    private ArrayList<C2763g> f9933b;

    /* renamed from: c */
    private C2764h f9934c;

    /* renamed from: d */
    private String f9935d;

    /* renamed from: e */
    private TextView f9936e;

    /* renamed from: f */
    private Stack<String> f9937f = new Stack<>();

    /* renamed from: g */
    private ProgressDialog f9938g;

    /* renamed from: h */
    private C5007c f9939h;

    /* renamed from: i */
    private ListView f9940i;

    /* renamed from: j */
    private Activity f9941j;

    /* renamed from: k */
    private MenuItem f9942k;

    @Override // android.support.v4.app.Fragment
    @SuppressLint({"NewApi"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C2760d c2760d = null;
        View viewInflate = layoutInflater.inflate(R.layout.layout_multimedia_file_explorer, viewGroup, false);
        this.f9936e = (TextView) viewInflate.findViewById(R.id.file_path).findViewById(R.id.text1);
        this.f9940i = (ListView) viewInflate.findViewById(R.id.file_list);
        this.f9935d = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.f9936e.setText(this.f9935d);
        this.f9936e.setSelected(true);
        this.f9934c = C2764h.m11618a(this.f9941j, R.layout.list_item_common_6, this.f9933b, this.f9939h);
        this.f9940i.setAdapter((ListAdapter) this.f9934c);
        this.f9940i.setOnItemClickListener(new C2760d(this));
        this.f9938g = (ProgressDialog) new C4923p(this.f9941j).m18724a(R.string.setting_webview_please_wait);
        this.f9938g.setCancelable(true);
        if (Build.VERSION.SDK_INT < 11) {
            new AsyncTaskC2761e(this, c2760d).execute(this.f9935d);
        } else {
            new AsyncTaskC2761e(this, c2760d).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f9935d);
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9939h = new C5007c();
        this.f9933b = new ArrayList<>();
        setHasOptionsMenu(true);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    private void m11590c() {
        C2760d c2760d = null;
        if (!this.f9937f.isEmpty()) {
            this.f9935d = this.f9937f.pop();
            this.f9936e.setText(this.f9935d);
            if (C4904y.f17872b) {
                C4904y.m18639b("mCurrrentPath: " + this.f9935d, f9932a);
            }
            if (Build.VERSION.SDK_INT < 11) {
                new AsyncTaskC2761e(this, c2760d).execute(this.f9935d);
            } else {
                new AsyncTaskC2761e(this, c2760d).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f9935d);
            }
        }
        if (this.f9937f.size() < 1) {
            this.f9942k.setEnabled(false);
            C4880cr.m18523a(this.f9942k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public EnumC2758b m11584a(File file) {
        String strSubstring;
        EnumC2758b enumC2758bM11580c;
        if (!file.isHidden()) {
            if (file.isDirectory()) {
                return EnumC2758b.DIRECTORY;
            }
            try {
                strSubstring = file.getName().substring(file.getName().lastIndexOf(".") + 1);
            } catch (Exception e) {
                strSubstring = null;
            }
            if (strSubstring != null && (enumC2758bM11580c = FileExplorerActivity.m11580c(strSubstring.toLowerCase())) != null) {
                return enumC2758bM11580c;
            }
        }
        return EnumC2758b.UNKNOWN;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.f9939h.m19014a();
        if (this.f9938g != null) {
            this.f9938g.dismiss();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9941j = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f9941j = null;
    }

    @Override // com.sec.chaton.multimedia.doc.InterfaceC2759c
    /* renamed from: a */
    public void mo11597a() {
        if (!this.f9937f.isEmpty()) {
            m11590c();
        } else if (this.f9941j != null) {
            this.f9941j.finish();
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            if (this.f9941j != null) {
                this.f9941j.finish();
                return true;
            }
        } else if (menuItem.getItemId() == R.id.menu_up) {
            m11590c();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.attach_file_menu, menu);
        this.f9942k = menu.findItem(R.id.menu_up);
        this.f9942k.setEnabled(false);
        C4880cr.m18523a(this.f9942k);
        super.onCreateOptionsMenu(menu, menuInflater);
    }
}
