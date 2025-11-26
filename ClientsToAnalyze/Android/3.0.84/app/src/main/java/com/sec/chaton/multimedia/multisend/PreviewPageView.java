package com.sec.chaton.multimedia.multisend;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.C3326c;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class PreviewPageView extends Fragment implements InterfaceC1911n, InterfaceC1914q {

    /* renamed from: a */
    private GridView f7224a;

    /* renamed from: b */
    private ArrayList<PreviewData> f7225b;

    /* renamed from: c */
    private ViewOnClickListenerC1909l f7226c;

    /* renamed from: d */
    private C3326c f7227d;

    /* renamed from: e */
    private String f7228e;

    /* renamed from: f */
    private int f7229f;

    /* renamed from: g */
    private TextView f7230g;

    /* renamed from: h */
    private String f7231h;

    /* renamed from: i */
    private Menu f7232i;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f7229f = bundle.getInt("position");
            this.f7225b = bundle.getParcelableArrayList("preview_data_tmp");
        } else {
            this.f7225b = getActivity().getIntent().getParcelableArrayListExtra("preview_data");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_smi_preview, viewGroup, false);
        this.f7227d = new C3326c();
        this.f7226c = new ViewOnClickListenerC1909l(getActivity(), R.layout.layout_smi_preview_item, this.f7225b, this.f7227d, this);
        this.f7224a = (GridView) viewInflate.findViewById(R.id.previewItemGridView);
        this.f7224a.setAdapter((ListAdapter) this.f7226c);
        this.f7224a.setOnItemClickListener(new C1915r(this));
        this.f7230g = (TextView) viewInflate.findViewById(R.id.count);
        setHasOptionsMenu(true);
        m7772b();
        return viewInflate;
    }

    /* renamed from: b */
    void m7772b() {
        this.f7230g.setText(this.f7225b.size() + "/10");
        if (this.f7232i != null) {
            if (this.f7225b.size() == 0) {
                this.f7232i.findItem(R.id.smi_preview_done).setEnabled(false);
            } else {
                this.f7232i.findItem(R.id.smi_preview_done).setEnabled(true);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.smi_preview_menu, menu);
        this.f7232i = menu;
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intent intent = new Intent();
        switch (menuItem.getItemId()) {
            case R.id.smi_preview_done /* 2131166620 */:
                if (!C3197bl.m11159a()) {
                    int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
                    if (!((-3 == iM6733a || -2 == iM6733a) ? false : true) && !C1757q.m7251b()) {
                        Toast toastM13211a = C3641ai.m13211a(CommonApplication.m11493l(), (CharSequence) null, 0);
                        toastM13211a.setText(R.string.popup_no_network_connection);
                        toastM13211a.setDuration(0);
                        toastM13211a.show();
                    } else {
                        intent.putExtra("send_list", true);
                        intent.putParcelableArrayListExtra("preview_data", this.f7225b);
                        ((PreviewPageActivity) getActivity()).m7761c(intent);
                    }
                }
                break;
            default:
                return false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f7224a != null) {
            this.f7224a.setOnItemClickListener(null);
            this.f7224a.setAdapter((ListAdapter) null);
        }
        if (this.f7227d != null) {
            this.f7227d.m11731a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (C3250y.f11734b) {
            C3250y.m11450b("PreviewPageView.onDestroy()", PreviewPageView.class.getSimpleName());
        }
        if (this.f7225b != null && !this.f7225b.isEmpty()) {
            this.f7225b.clear();
        }
        super.onDestroy();
    }

    /* renamed from: b */
    public void m7773b(String str) {
        Iterator<PreviewData> it = this.f7225b.iterator();
        while (it.hasNext()) {
            PreviewData next = it.next();
            if (next.m7746a().equals(str)) {
                this.f7225b.remove(next);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7766a(String str, boolean z) {
        String str2;
        C3250y.m11450b("[SendingMedia] Start - Picture", getClass().getSimpleName());
        Intent intent = new Intent(getActivity(), (Class<?>) ImageModify.class);
        if (z) {
            str2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString() + "/" + str;
        } else {
            str2 = "file://" + str;
        }
        intent.setData(Uri.parse(str2));
        intent.putExtra("return-data", true);
        intent.putExtra("randomFName", true);
        startActivityForResult(intent, 1);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1:
                    C3250y.m11450b("Get the item modified by effect function", getClass().getSimpleName());
                    if (intent != null) {
                        m7769c(intent.getStringExtra("temp_file_path"));
                        break;
                    }
                    break;
            }
        }
    }

    /* renamed from: c */
    private void m7769c(String str) {
        if (this.f7225b != null && this.f7225b.size() > this.f7229f) {
            this.f7225b.get(this.f7229f).m7747a(str);
        }
        this.f7224a.invalidateViews();
    }

    @Override // com.sec.chaton.multimedia.multisend.InterfaceC1914q
    /* renamed from: a */
    public boolean mo7771a() {
        Intent intent = new Intent();
        intent.putExtra("send_list", false);
        intent.putParcelableArrayListExtra("preview_data", this.f7225b);
        ((PreviewPageActivity) getActivity()).m7761c(intent);
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ArrayList<? extends Parcelable> arrayList = (ArrayList) this.f7225b.clone();
        bundle.putInt("position", this.f7229f);
        bundle.putParcelableArrayList("preview_data_tmp", arrayList);
    }

    @Override // com.sec.chaton.multimedia.multisend.InterfaceC1911n
    /* renamed from: a */
    public void mo7770a(String str) {
        this.f7231h = str;
        m7773b(this.f7231h);
        this.f7224a.invalidateViews();
        m7772b();
    }
}
