package com.sec.chaton.trunk.tablet;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.multimedia.image.ViewOriginalImage;
import com.sec.chaton.multimedia.video.VideoPreviewActivity;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.trunk.InterfaceC1107ae;
import com.sec.chaton.trunk.InterfaceC1126ax;
import com.sec.chaton.trunk.InterfaceC1150bn;
import com.sec.chaton.trunk.TrunkCommentView;
import com.sec.chaton.trunk.TrunkItemView;
import com.sec.chaton.trunk.TrunkView;
import com.sec.chaton.trunk.p045d.C1165c;
import com.sec.chaton.trunk.p045d.EnumC1168f;
import com.sec.chaton.util.C1335j;
import com.sec.chaton.util.C1341p;
import com.sec.vip.amschaton.AMSPlayerActivity;
import com.sec.widget.C1619g;

/* loaded from: classes.dex */
public class TrunkTabletActivity extends BaseMultiPaneActivity implements InterfaceC1107ae, InterfaceC1126ax, InterfaceC1150bn {

    /* renamed from: a */
    private static final String f4064a = TrunkTabletActivity.class.getSimpleName();

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(5);
        setTitle(R.string.trunk_title);
        setContentView(R.layout.base_activity);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.fragment_controller, new TrunkView());
        fragmentTransactionBeginTransaction.replace(R.id.fragment_container, new EmptyContentFragment(), "container");
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (C1341p.f4578b) {
            C1341p.m4658b(String.format("TrunkTabletActivity.onActivityResult(). requestCode: %s, resultCode: %s.", Integer.valueOf(i), Integer.valueOf(i2)), f4064a);
        }
        if (i == 1 && i2 == -1) {
            if (intent.getBooleanExtra("SAVE", false)) {
                C1619g.m5888a(this, R.string.toast_save_media, 0).show();
            } else {
                C1619g.m5888a(this, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
            }
        }
    }

    public class ContentFragment extends Fragment {
        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return layoutInflater.inflate(R.layout.trunk_content_fragment_container, viewGroup, false);
        }
    }

    public class EmptyContentFragment extends Fragment {
        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewInflate = layoutInflater.inflate(R.layout.fragment_empty, viewGroup, false);
            TextView textView = (TextView) viewInflate.findViewById(R.id.emptyTextView);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.chaton_trunk_ic_trunk), (Drawable) null, (Drawable) null);
            textView.setText(R.string.trunk_nothing);
            return viewInflate;
        }
    }

    public class EmptyNetWorkErrorContentFragment extends Fragment {
        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewInflate = layoutInflater.inflate(R.layout.fragment_empty, viewGroup, false);
            TextView textView = (TextView) viewInflate.findViewById(R.id.emptyTextView);
            textView.setTextColor(getResources().getColor(R.color.trunk_empty_string));
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.chaton_trunk_ic_no_network), (Drawable) null, (Drawable) null);
            textView.setText(R.string.toast_network_unable);
            return viewInflate;
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC1150bn
    /* renamed from: a */
    public void mo2595a(String str, String str2, String str3, String str4, EnumC1168f enumC1168f) {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("sessionId", str);
        bundle.putString("inboxNO", str2);
        bundle.putString("itemId", str3);
        bundle.putString("downloadUrl", str4);
        bundle.putSerializable("contentType", enumC1168f);
        TrunkItemView trunkItemView = new TrunkItemView();
        trunkItemView.setArguments(bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putString("sessionId", str);
        bundle2.putString("contentId", str3);
        TrunkCommentView trunkCommentView = new TrunkCommentView();
        trunkCommentView.setArguments(bundle2);
        fragmentTransactionBeginTransaction.replace(R.id.fragment_container, new ContentFragment());
        fragmentTransactionBeginTransaction.replace(R.id.trunkItemLayout, trunkItemView);
        fragmentTransactionBeginTransaction.replace(R.id.trunkCommentLayout, trunkCommentView);
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // com.sec.chaton.trunk.InterfaceC1150bn
    /* renamed from: c_ */
    public void mo2599c_() {
        finish();
    }

    @Override // com.sec.chaton.trunk.InterfaceC1126ax
    /* renamed from: a */
    public void mo3963a(String str, String str2) {
    }

    @Override // com.sec.chaton.trunk.InterfaceC1126ax
    /* renamed from: a */
    public void mo3962a(EnumC1168f enumC1168f, String str) {
        Intent intentM4620b = null;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            C1619g.m5889a(this, getString(R.string.toast_sdcard_amount), 1).show();
            return;
        }
        if (enumC1168f == EnumC1168f.IMAGE) {
            intentM4620b = C1335j.m4613a(this, getString(R.string.trunk_opt_header_share), str, (String) null, (String) null);
        } else if (enumC1168f == EnumC1168f.VIDEO) {
            intentM4620b = C1335j.m4620b(this, getString(R.string.trunk_opt_header_share), str, (String) null, (String) null);
        }
        if (intentM4620b != null) {
            startActivityForResult(intentM4620b, 3);
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC1126ax
    /* renamed from: b */
    public void mo3964b(EnumC1168f enumC1168f, String str) {
        Intent intent = new Intent();
        if (enumC1168f == EnumC1168f.IMAGE) {
            if (C1165c.m4207c(str)) {
                intent.setClass(this, AMSPlayerActivity.class);
                intent.putExtra("AMS_FILE_PATH", str);
                intent.putExtra("VIEWER_MODE", 1002);
            } else {
                intent.setClass(this, ViewOriginalImage.class);
                intent.putExtra("URI", str);
                intent.putExtra(C0684a.f2335f, true);
            }
        } else if (enumC1168f == EnumC1168f.VIDEO) {
            intent.setClass(this, VideoPreviewActivity.class);
            intent.putExtra("URI", str);
            intent.putExtra("playDirectly", true);
        }
        startActivityForResult(intent, 1);
    }

    @Override // com.sec.chaton.trunk.InterfaceC1126ax
    /* renamed from: b_ */
    public void mo3965b_() {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.fragment_container, new EmptyContentFragment(), "container");
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // com.sec.chaton.trunk.InterfaceC1107ae
    /* renamed from: b */
    public void mo3959b() {
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.trunkItemLayout);
        if (fragmentFindFragmentById instanceof TrunkItemView) {
            ((TrunkItemView) fragmentFindFragmentById).m4050b();
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC1107ae
    /* renamed from: c */
    public void mo3960c() {
    }

    @Override // com.sec.chaton.trunk.InterfaceC1107ae
    /* renamed from: d */
    public void mo3961d() {
        mo3965b_();
    }
}
