package com.sec.chaton.multimedia.doc;

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
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.common.p069e.C3326c;
import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

/* loaded from: classes.dex */
public class FileExplorerFragment extends Fragment implements InterfaceC1795b {

    /* renamed from: a */
    private static final String f6643a = FileExplorerFragment.class.getSimpleName();

    /* renamed from: b */
    private ArrayList<C1799f> f6644b;

    /* renamed from: c */
    private C1800g f6645c;

    /* renamed from: d */
    private String f6646d;

    /* renamed from: e */
    private TextView f6647e;

    /* renamed from: f */
    private Stack<String> f6648f = new Stack<>();

    /* renamed from: g */
    private ProgressDialog f6649g;

    /* renamed from: h */
    private C3326c f6650h;

    /* renamed from: i */
    private ListView f6651i;

    /* renamed from: j */
    private Activity f6652j;

    /* renamed from: k */
    private MenuItem f6653k;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1796c c1796c = null;
        View viewInflate = layoutInflater.inflate(R.layout.layout_multimedia_file_explorer, viewGroup, false);
        this.f6647e = (TextView) viewInflate.findViewById(R.id.file_path).findViewById(R.id.text1);
        this.f6651i = (ListView) viewInflate.findViewById(R.id.file_list);
        this.f6646d = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.f6647e.setText(this.f6646d);
        this.f6647e.setSelected(true);
        this.f6645c = new C1800g(this.f6652j, R.layout.list_item_common_6, this.f6644b, this.f6650h);
        this.f6651i.setAdapter((ListAdapter) this.f6645c);
        this.f6651i.setOnItemClickListener(new C1796c(this));
        this.f6649g = (ProgressDialog) new C3263j(this.f6652j).m11487a(R.string.setting_webview_please_wait);
        this.f6649g.setCancelable(true);
        if (Build.VERSION.SDK_INT < 11) {
            new AsyncTaskC1797d(this, c1796c).execute(this.f6646d);
        } else {
            new AsyncTaskC1797d(this, c1796c).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f6646d);
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6650h = new C3326c();
        this.f6644b = new ArrayList<>();
        setHasOptionsMenu(true);
    }

    /* renamed from: c */
    private void m7396c() {
        C1796c c1796c = null;
        if (!this.f6648f.isEmpty()) {
            this.f6646d = this.f6648f.pop();
            this.f6647e.setText(this.f6646d);
            if (C3250y.f11734b) {
                C3250y.m11450b("mCurrrentPath: " + this.f6646d, f6643a);
            }
            if (Build.VERSION.SDK_INT < 11) {
                new AsyncTaskC1797d(this, c1796c).execute(this.f6646d);
            } else {
                new AsyncTaskC1797d(this, c1796c).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f6646d);
            }
        }
        if (this.f6648f.size() < 1) {
            this.f6653k.setEnabled(false);
            C3228cp.m11343a(this.f6653k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public EnumC1794a m7390a(File file) {
        String strSubstring;
        EnumC1794a enumC1794aM7385b;
        if (!file.isHidden()) {
            if (file.isDirectory()) {
                return EnumC1794a.DIRECTORY;
            }
            try {
                strSubstring = file.getName().substring(file.getName().lastIndexOf(".") + 1);
            } catch (Exception e) {
                strSubstring = null;
            }
            if (strSubstring != null && (enumC1794aM7385b = FileExplorerActivity.m7385b(strSubstring.toLowerCase())) != null) {
                return enumC1794aM7385b;
            }
        }
        return EnumC1794a.UNKNOWN;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.f6650h.m11731a();
        if (this.f6649g != null) {
            this.f6649g.dismiss();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f6652j = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f6652j = null;
    }

    @Override // com.sec.chaton.multimedia.doc.InterfaceC1795b
    /* renamed from: a */
    public void mo7403a() {
        if (!this.f6648f.isEmpty()) {
            m7396c();
        } else if (this.f6652j != null) {
            this.f6652j.finish();
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            if (this.f6652j != null) {
                this.f6652j.finish();
                return true;
            }
        } else if (menuItem.getItemId() == R.id.menu_up) {
            m7396c();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.attach_file_menu, menu);
        this.f6653k = menu.findItem(R.id.menu_up);
        this.f6653k.setEnabled(false);
        C3228cp.m11343a(this.f6653k);
        super.onCreateOptionsMenu(menu, menuInflater);
    }
}
