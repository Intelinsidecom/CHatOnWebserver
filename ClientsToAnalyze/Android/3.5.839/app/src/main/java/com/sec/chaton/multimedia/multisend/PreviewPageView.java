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
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.R;
import com.sec.chaton.msgsend.C2717y;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p132g.C5007c;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class PreviewPageView extends Fragment implements InterfaceC2880n, InterfaceC2882p {

    /* renamed from: a */
    private GridView f10545a;

    /* renamed from: b */
    private ArrayList<PreviewData> f10546b;

    /* renamed from: c */
    private ViewOnClickListenerC2881o f10547c;

    /* renamed from: d */
    private C5007c f10548d;

    /* renamed from: e */
    private String f10549e;

    /* renamed from: f */
    private int f10550f;

    /* renamed from: g */
    private TextView f10551g;

    /* renamed from: h */
    private String f10552h;

    /* renamed from: i */
    private Menu f10553i;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f10550f = bundle.getInt(VKApiConst.POSITION);
            this.f10546b = bundle.getParcelableArrayList("preview_data_tmp");
        } else {
            this.f10546b = getActivity().getIntent().getParcelableArrayListExtra("preview_data");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_smi_preview, viewGroup, false);
        this.f10548d = new C5007c();
        this.f10547c = new ViewOnClickListenerC2881o(getActivity(), R.layout.layout_smi_preview_item, this.f10546b, this.f10548d, this);
        this.f10545a = (GridView) viewInflate.findViewById(R.id.previewItemGridView);
        this.f10545a.setAdapter((ListAdapter) this.f10547c);
        this.f10545a.setOnItemClickListener(new C2884r(this));
        this.f10551g = (TextView) viewInflate.findViewById(R.id.count);
        setHasOptionsMenu(true);
        m12002b();
        return viewInflate;
    }

    /* renamed from: b */
    void m12002b() {
        this.f10551g.setText(this.f10546b.size() + "/10");
        if (this.f10553i != null) {
            if (this.f10546b.size() == 0) {
                this.f10553i.findItem(R.id.smi_preview_done).setEnabled(false);
            } else {
                this.f10553i.findItem(R.id.smi_preview_done).setEnabled(true);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.smi_preview_menu, menu);
        this.f10553i = menu;
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intent intent = new Intent();
        switch (menuItem.getItemId()) {
            case R.id.smi_preview_cancel /* 2131166714 */:
                mo12001a();
                return false;
            case R.id.smi_preview_done /* 2131166715 */:
                if (!C4847bl.m18333a()) {
                    int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
                    if (!((-3 == iM10677a || -2 == iM10677a) ? false : true) && !C2717y.m11398b()) {
                        Toast toastM19811a = C5179v.m19811a(CommonApplication.m18732r(), (CharSequence) null, 0);
                        toastM19811a.setText(R.string.popup_no_network_connection);
                        toastM19811a.setDuration(0);
                        toastM19811a.show();
                    } else {
                        intent.putExtra("send_list", true);
                        intent.putParcelableArrayListExtra("preview_data", this.f10546b);
                        ((PreviewPageActivity) getActivity()).m11991b(intent);
                    }
                }
                return false;
            default:
                return false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f10545a != null) {
            this.f10545a.setOnItemClickListener(null);
            this.f10545a.setAdapter((ListAdapter) null);
        }
        if (this.f10548d != null) {
            this.f10548d.m19014a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (C4904y.f17872b) {
            C4904y.m18639b("PreviewPageView.onDestroy()", PreviewPageView.class.getSimpleName());
        }
        if (this.f10546b != null && !this.f10546b.isEmpty()) {
            this.f10546b.clear();
        }
        super.onDestroy();
    }

    /* renamed from: b */
    public void m12003b(String str) {
        Iterator<PreviewData> it = this.f10546b.iterator();
        while (it.hasNext()) {
            if (it.next().m11976a().equals(str)) {
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11996a(String str, boolean z) {
        String str2;
        C4904y.m18639b("[SendingMedia] Start - Picture", getClass().getSimpleName());
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
                    C4904y.m18639b("Get the item modified by effect function", getClass().getSimpleName());
                    if (intent != null) {
                        m11999c(intent.getStringExtra("temp_file_path"));
                        break;
                    }
                    break;
            }
        }
    }

    /* renamed from: c */
    private void m11999c(String str) {
        if (this.f10546b != null && this.f10546b.size() > this.f10550f) {
            this.f10546b.get(this.f10550f).m11977a(str);
        }
        this.f10545a.invalidateViews();
    }

    @Override // com.sec.chaton.multimedia.multisend.InterfaceC2880n
    /* renamed from: a */
    public boolean mo12001a() {
        Intent intent = new Intent();
        intent.putExtra("send_list", false);
        intent.putParcelableArrayListExtra("preview_data", this.f10546b);
        ((PreviewPageActivity) getActivity()).m11991b(intent);
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ArrayList<? extends Parcelable> arrayList = (ArrayList) this.f10546b.clone();
        bundle.putInt(VKApiConst.POSITION, this.f10550f);
        bundle.putParcelableArrayList("preview_data_tmp", arrayList);
    }

    @Override // com.sec.chaton.multimedia.multisend.InterfaceC2882p
    /* renamed from: a */
    public void mo12000a(String str) {
        this.f10552h = str;
        m12003b(this.f10552h);
        this.f10545a.invalidateViews();
        m12002b();
    }
}
