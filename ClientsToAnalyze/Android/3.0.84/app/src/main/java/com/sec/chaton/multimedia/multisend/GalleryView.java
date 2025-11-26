package com.sec.chaton.multimedia.multisend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.C3326c;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GalleryView extends Fragment {

    /* renamed from: a */
    private ListView f7211a;

    /* renamed from: b */
    private ArrayList<C1908k> f7212b;

    /* renamed from: c */
    private ArrayList<PreviewData> f7213c;

    /* renamed from: d */
    private C1904g f7214d;

    /* renamed from: e */
    private C3326c f7215e;

    /* renamed from: f */
    private TextView f7216f;

    /* renamed from: g */
    private boolean f7217g;

    /* renamed from: h */
    private boolean f7218h;

    /* renamed from: i */
    private int f7219i;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getActivity().getIntent();
        this.f7213c = intent.getParcelableArrayListExtra("preview_data");
        if ("POSTON".equals(intent.getExtras().getString("caller"))) {
            this.f7218h = true;
            this.f7219i = intent.getExtras().getInt("attachedimagecount");
        } else {
            this.f7218h = false;
            this.f7219i = 0;
        }
        if (bundle != null) {
            this.f7213c = bundle.getParcelableArrayList("temp_state");
            this.f7217g = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_smi_gallery, viewGroup, false);
        this.f7212b = new ArrayList<>();
        this.f7215e = new C3326c();
        this.f7214d = new C1904g(getActivity(), R.layout.layout_smi_gallery_item, this.f7212b, this.f7215e);
        this.f7211a = (ListView) viewInflate.findViewById(R.id.gallaerylist);
        this.f7216f = (TextView) viewInflate.findViewById(R.id.emptylist);
        this.f7211a.setOnItemClickListener(new C1907j(this));
        ((GalleryActivity) getActivity()).m7740a(this.f7212b);
        if (this.f7212b.isEmpty()) {
            this.f7216f.setVisibility(0);
            this.f7211a.setVisibility(8);
        } else {
            this.f7216f.setVisibility(8);
            this.f7211a.setVisibility(0);
        }
        if (this.f7217g) {
            this.f7214d.m7777a(this.f7213c);
        }
        this.f7211a.setAdapter((ListAdapter) this.f7214d);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1:
                    C3250y.m11450b("Get the item list selected in Category", getClass().getSimpleName());
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra("send_list", false);
                        this.f7213c = intent.getParcelableArrayListExtra("preview_data");
                        if (booleanExtra) {
                            Intent intent2 = new Intent();
                            intent2.putParcelableArrayListExtra("preview_data", this.f7213c);
                            ((GalleryActivity) getActivity()).m7741c(intent2);
                            break;
                        }
                    }
                    break;
            }
            return;
        }
        if (i2 == 0) {
            if (((GalleryActivity) getActivity()) != null) {
                ((GalleryActivity) getActivity()).f7207a = true;
            }
            this.f7213c.clear();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f7211a != null) {
            this.f7211a.setOnItemClickListener(null);
            this.f7211a.setAdapter((ListAdapter) null);
        }
        if (this.f7215e != null) {
            this.f7215e.m11731a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (C3250y.f11734b) {
            C3250y.m11450b("GalleryView.onDestroy()", GalleryView.class.getSimpleName());
        }
        if (this.f7212b != null && !this.f7212b.isEmpty()) {
            this.f7212b.clear();
        }
        if (this.f7213c != null && !this.f7213c.isEmpty()) {
            this.f7213c.clear();
        }
        if (this.f7214d != null) {
            this.f7214d.m7776a();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("temp_state", this.f7213c);
    }
}
