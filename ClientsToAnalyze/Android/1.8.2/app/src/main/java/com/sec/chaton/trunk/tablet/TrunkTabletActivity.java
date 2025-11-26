package com.sec.chaton.trunk.tablet;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.image.ViewOriginalImage;
import com.sec.chaton.multimedia.video.VideoPreviewActivity;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.trunk.InterfaceC1520af;
import com.sec.chaton.trunk.InterfaceC1553bb;
import com.sec.chaton.trunk.InterfaceC1566bo;
import com.sec.chaton.trunk.TrunkCommentView;
import com.sec.chaton.trunk.TrunkItemView;
import com.sec.chaton.trunk.TrunkView;
import com.sec.chaton.trunk.p053e.C1598g;
import com.sec.chaton.trunk.p053e.EnumC1599h;
import com.sec.chaton.util.C1766bv;
import com.sec.chaton.util.C1786r;
import com.sec.vip.amschaton.AMSPlayerActivity;

/* loaded from: classes.dex */
public class TrunkTabletActivity extends BaseMultiPaneActivity implements InterfaceC1520af, InterfaceC1553bb, InterfaceC1566bo {

    /* renamed from: c */
    private static final String f5752c = TrunkTabletActivity.class.getSimpleName();

    /* renamed from: a */
    TrunkItemView f5753a;

    /* renamed from: b */
    boolean f5754b = true;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(5);
        setTitle(R.string.trunk_title);
        setContentView(R.layout.base_activity);
        if (GlobalApplication.m3265f()) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.fragment_controller, new TrunkView());
        fragmentTransactionBeginTransaction.replace(R.id.fragment_container, new EmptyContentFragment(), "container");
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (C1786r.f6452b) {
            C1786r.m6061b(String.format("TrunkTabletActivity.onActivityResult(). requestCode: %s, resultCode: %s.", Integer.valueOf(i), Integer.valueOf(i2)), f5752c);
        }
        if (i == 1 && i2 == -1) {
            if (intent.getBooleanExtra("SAVE", false)) {
                Toast.makeText(this, R.string.toast_save_media, 0).show();
            } else {
                Toast.makeText(this, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
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

    @Override // com.sec.chaton.trunk.InterfaceC1566bo
    /* renamed from: a */
    public void mo5232a(String str, String str2, String str3, String str4, EnumC1599h enumC1599h) {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        if (this.f5754b) {
            this.f5754b = false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("sessionId", str);
        bundle.putString("inboxNO", str2);
        bundle.putString("itemId", str3);
        bundle.putString("downloadUrl", str4);
        bundle.putSerializable("contentType", enumC1599h);
        this.f5753a = new TrunkItemView();
        this.f5753a.setArguments(bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putString("sessionId", str);
        bundle2.putString("contentId", str3);
        TrunkCommentView trunkCommentView = new TrunkCommentView();
        trunkCommentView.setArguments(bundle2);
        fragmentTransactionBeginTransaction.replace(R.id.fragment_container, new ContentFragment());
        fragmentTransactionBeginTransaction.replace(R.id.trunkItemLayout, this.f5753a);
        fragmentTransactionBeginTransaction.replace(R.id.trunkCommentLayout, trunkCommentView);
        fragmentTransactionBeginTransaction.commit();
        this.f5754b = true;
    }

    @Override // com.sec.chaton.trunk.InterfaceC1566bo
    /* renamed from: c_ */
    public void mo5233c_() {
        finish();
    }

    @Override // com.sec.chaton.trunk.InterfaceC1553bb
    /* renamed from: a */
    public void mo5222a(String str, String str2) {
    }

    @Override // com.sec.chaton.trunk.InterfaceC1553bb
    /* renamed from: a */
    public void mo5221a(EnumC1599h enumC1599h, String str) {
        Intent intentM6001b = null;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            Toast.makeText(this, getString(R.string.toast_sdcard_amount), 1).show();
            return;
        }
        if (enumC1599h == EnumC1599h.IMAGE) {
            intentM6001b = C1766bv.m5994a(this, getString(R.string.trunk_opt_header_share), str, (String) null, (String) null);
        } else if (enumC1599h == EnumC1599h.VIDEO) {
            intentM6001b = C1766bv.m6001b(this, getString(R.string.trunk_opt_header_share), str, (String) null, (String) null);
        }
        if (intentM6001b != null) {
            startActivityForResult(intentM6001b, 3);
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC1553bb
    /* renamed from: b */
    public void mo5223b(EnumC1599h enumC1599h, String str) {
        Intent intent = new Intent();
        if (enumC1599h == EnumC1599h.IMAGE) {
            if (C1598g.m5509c(str)) {
                intent.setClass(this, AMSPlayerActivity.class);
                intent.putExtra("AMS_FILE_PATH", str);
                intent.putExtra("VIEWER_MODE", 1002);
            } else {
                intent.setClass(this, ViewOriginalImage.class);
                intent.putExtra("URI", str);
                intent.putExtra(C0452a.f1727f, true);
            }
        } else if (enumC1599h == EnumC1599h.VIDEO) {
            intent.setClass(this, VideoPreviewActivity.class);
            intent.putExtra("URI", str);
            intent.putExtra("playDirectly", true);
        }
        startActivityForResult(intent, 1);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // com.sec.chaton.trunk.InterfaceC1553bb
    /* renamed from: b_ */
    public void mo5224b_() {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.fragment_container, new EmptyContentFragment(), "container");
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // com.sec.chaton.trunk.InterfaceC1520af
    /* renamed from: c */
    public void mo5217c() {
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.trunkItemLayout);
        if (fragmentFindFragmentById instanceof TrunkItemView) {
            ((TrunkItemView) fragmentFindFragmentById).m5319d();
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC1520af
    /* renamed from: d */
    public void mo5218d() {
    }

    @Override // com.sec.chaton.trunk.InterfaceC1520af
    /* renamed from: e */
    public void mo5219e() {
        mo5224b_();
    }
}
