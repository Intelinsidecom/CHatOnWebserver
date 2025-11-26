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
import com.sec.chaton.util.C4904y;
import com.sec.common.p132g.C5007c;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GalleryView extends Fragment {

    /* renamed from: a */
    private ListView f10532a;

    /* renamed from: b */
    private ArrayList<C2877k> f10533b;

    /* renamed from: c */
    private ArrayList<PreviewData> f10534c;

    /* renamed from: d */
    private C2873g f10535d;

    /* renamed from: e */
    private C5007c f10536e;

    /* renamed from: f */
    private TextView f10537f;

    /* renamed from: g */
    private boolean f10538g;

    /* renamed from: h */
    private boolean f10539h;

    /* renamed from: i */
    private int f10540i;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getActivity().getIntent();
        this.f10534c = intent.getParcelableArrayListExtra("preview_data");
        if ("POSTON".equals(intent.getExtras().getString("caller"))) {
            this.f10539h = true;
            this.f10540i = intent.getExtras().getInt("attachedimagecount");
        } else {
            this.f10539h = false;
            this.f10540i = 0;
        }
        if (bundle != null) {
            this.f10534c = bundle.getParcelableArrayList("temp_state");
            this.f10538g = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_smi_gallery, viewGroup, false);
        this.f10533b = new ArrayList<>();
        this.f10536e = new C5007c();
        this.f10535d = new C2873g(getActivity(), R.layout.layout_smi_gallery_item, this.f10533b, this.f10536e);
        this.f10532a = (ListView) viewInflate.findViewById(R.id.gallaerylist);
        this.f10537f = (TextView) viewInflate.findViewById(R.id.emptylist);
        this.f10532a.setOnItemClickListener(new C2876j(this));
        ((GalleryActivity) getActivity()).m11970a(this.f10533b);
        if (this.f10533b.isEmpty()) {
            this.f10537f.setVisibility(0);
            this.f10532a.setVisibility(8);
        } else {
            this.f10537f.setVisibility(8);
            this.f10532a.setVisibility(0);
        }
        if (this.f10538g) {
            this.f10535d.m12007a(this.f10534c);
        }
        this.f10532a.setAdapter((ListAdapter) this.f10535d);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1:
                    C4904y.m18639b("Get the item list selected in Category", getClass().getSimpleName());
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra("send_list", false);
                        this.f10534c = intent.getParcelableArrayListExtra("preview_data");
                        if (booleanExtra) {
                            Intent intent2 = new Intent();
                            intent2.putParcelableArrayListExtra("preview_data", this.f10534c);
                            ((GalleryActivity) getActivity()).m11971b(intent2);
                            break;
                        }
                    }
                    break;
            }
            return;
        }
        if (i2 == 0) {
            if (((GalleryActivity) getActivity()) != null) {
                ((GalleryActivity) getActivity()).f10528n = true;
            }
            this.f10534c.clear();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f10532a != null) {
            this.f10532a.setOnItemClickListener(null);
            this.f10532a.setAdapter((ListAdapter) null);
        }
        if (this.f10536e != null) {
            this.f10536e.m19014a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (C4904y.f17872b) {
            C4904y.m18639b("GalleryView.onDestroy()", GalleryView.class.getSimpleName());
        }
        if (this.f10533b != null && !this.f10533b.isEmpty()) {
            this.f10533b.clear();
        }
        if (this.f10534c != null && !this.f10534c.isEmpty()) {
            this.f10534c.clear();
        }
        if (this.f10535d != null) {
            this.f10535d.m12006a();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("temp_state", this.f10534c);
    }
}
