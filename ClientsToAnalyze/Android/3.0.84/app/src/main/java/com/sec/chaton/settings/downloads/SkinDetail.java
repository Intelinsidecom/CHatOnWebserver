package com.sec.chaton.settings.downloads;

import android.app.Activity;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.anicon.CallableC1825o;
import com.sec.chaton.p020c.C0823h;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p027e.p028a.C1353ab;
import com.sec.chaton.p027e.p028a.C1354ac;
import com.sec.chaton.settings.downloads.p056a.C2525p;
import com.sec.chaton.settings.downloads.p056a.C2527r;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.common.p069e.C3326c;
import com.sec.common.p069e.InterfaceC3329f;
import com.sec.common.util.C3347i;
import com.sec.common.util.C3364o;
import java.text.DateFormat;
import java.util.Date;
import org.json.JSONException;

/* loaded from: classes.dex */
public class SkinDetail extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>, View.OnClickListener, InterfaceC3329f {

    /* renamed from: c */
    private static final String f9534c = ActivitySkinDetail.class.getSimpleName();

    /* renamed from: a */
    String f9535a;

    /* renamed from: b */
    DateFormat f9536b;

    /* renamed from: d */
    private String f9537d;

    /* renamed from: e */
    private String f9538e;

    /* renamed from: g */
    private boolean f9540g;

    /* renamed from: h */
    private int f9541h;

    /* renamed from: i */
    private int f9542i;

    /* renamed from: j */
    private TextView f9543j;

    /* renamed from: k */
    private ImageView f9544k;

    /* renamed from: l */
    private ImageView f9545l;

    /* renamed from: m */
    private ProgressBar f9546m;

    /* renamed from: n */
    private C0823h f9547n;

    /* renamed from: o */
    private C3326c f9548o;

    /* renamed from: p */
    private C2527r f9549p;

    /* renamed from: q */
    private Cursor f9550q;

    /* renamed from: r */
    private boolean f9551r;

    /* renamed from: s */
    private View f9552s;

    /* renamed from: t */
    private Menu f9553t;

    /* renamed from: u */
    private Activity f9554u;

    /* renamed from: v */
    private InterfaceC2590cc f9555v;

    /* renamed from: f */
    private long f9539f = 0;

    /* renamed from: w */
    private Handler f9556w = new HandlerC2588ca(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9554u = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f9554u = null;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_skin_detail, viewGroup, false);
        this.f9552s = viewInflate;
        this.f9536b = android.text.format.DateFormat.getMediumDateFormat(CommonApplication.m11493l());
        this.f9555v = (InterfaceC2590cc) this.f9554u;
        this.f9547n = new C0823h(this.f9554u, null);
        this.f9548o = new C3326c();
        this.f9548o.m11735a(this);
        this.f9541h = C3347i.m11779b();
        this.f9542i = C3347i.m11780c();
        this.f9543j = (TextView) viewInflate.findViewById(R.id.volume_text_view);
        this.f9543j.setSelected(true);
        this.f9543j.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f9544k = (ImageView) viewInflate.findViewById(R.id.anicon_package_item_download);
        this.f9544k.setOnClickListener(this);
        this.f9545l = (ImageView) viewInflate.findViewById(R.id.detail_view_image);
        this.f9546m = (ProgressBar) viewInflate.findViewById(R.id.download_item_progress);
        this.f9551r = true;
        getLoaderManager().initLoader(0, null, this);
        setHasOptionsMenu(true);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.download_delete_menu, menu);
        this.f9553t = menu;
        if (this.f9540g) {
            this.f9553t.findItem(R.id.downloads_delete).setVisible(true);
        } else {
            this.f9553t.findItem(R.id.downloads_delete).setVisible(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.downloads_delete /* 2131166609 */:
                m9373a();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9537d = getActivity().getIntent().getExtras().getString("ITEM_ID");
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        getLoaderManager().getLoader(0).startLoading();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        getLoaderManager().getLoader(0).stopLoading();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f9549p != null) {
            this.f9549p.m9451b(this.f9556w);
        }
        getLoaderManager().destroyLoader(0);
        if (this.f9548o != null) {
            this.f9548o.m11735a((InterfaceC3329f) null);
            this.f9548o.m11731a();
        }
    }

    /* renamed from: a */
    void m9373a() {
        if (!TextUtils.isEmpty(this.f9537d) && this.f9540g) {
            C2555av.m9492d(this.f9554u).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2589cb(this)).mo11512b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.f9537d)) {
            switch (view.getId()) {
                case R.id.anicon_package_item_download /* 2131165640 */:
                    if (this.f9540g) {
                        if (C2591cd.m9571a(this.f9537d, this.f9535a)) {
                            C2555av.m9495g(CommonApplication.m11493l()).show();
                            this.f9554u.setResult(2000);
                            this.f9555v.mo9265c();
                        } else {
                            C2555av.m9496h(CommonApplication.m11493l()).show();
                        }
                    } else if (this.f9549p == null) {
                        this.f9549p = new C2527r(this.f9547n, this.f9537d, this.f9535a);
                        this.f9549p.m9446a(this.f9556w);
                        this.f9549p.m11745d(new Void[0]);
                    } else if (this.f9549p.m9455d() == 5) {
                        this.f9549p = new C2527r(this.f9547n, this.f9537d, this.f9535a);
                        this.f9549p.m9446a(this.f9556w);
                        this.f9549p.m11745d(new Void[0]);
                    } else {
                        switch (this.f9549p.m9455d()) {
                            case 0:
                            case 1:
                            case 2:
                                this.f9549p.m11744a(true);
                                break;
                        }
                    }
                    m9366a(this.f9550q);
                    break;
            }
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this.f9554u, C1398ap.m6249a(EnumC1399aq.Skin), null, C3364o.m11849a("item_id", "=?"), new String[]{this.f9537d}, null);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        this.f9550q = cursor;
        if (this.f9551r) {
            this.f9551r = false;
            this.f9549p = (C2527r) C2525p.m9458a().m9459a(EnumC1399aq.Skin, this.f9537d);
            if (this.f9549p != null) {
                this.f9549p.m9446a(this.f9556w);
            }
        }
        m9366a(cursor);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    @Override // com.sec.common.p069e.InterfaceC3329f
    /* renamed from: a */
    public void mo3713a(View view, AbstractRunnableC3324a<?> abstractRunnableC3324a) {
        if (view == this.f9545l) {
            this.f9545l.setBackgroundResource(R.drawable.picturebox2);
        }
    }

    @Override // com.sec.common.p069e.InterfaceC3329f
    /* renamed from: b */
    public void mo3722b(View view, AbstractRunnableC3324a<?> abstractRunnableC3324a) {
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m9371c();
    }

    /* renamed from: c */
    private void m9371c() {
        Display defaultDisplay = ((WindowManager) GlobalApplication.m6447a().getSystemService("window")).getDefaultDisplay();
        Drawable drawable = this.f9545l.getDrawable();
        if (drawable != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f9545l.getLayoutParams();
            if (drawable != null) {
                this.f9545l.setImageDrawable(drawable);
                this.f9545l.setScaleType(ImageView.ScaleType.FIT_XY);
                layoutParams.height = (int) ((defaultDisplay.getWidth() - C3172an.m11085a(20.0f)) - C3172an.m11087c(20.0f));
                this.f9545l.setLayoutParams(layoutParams);
                this.f9545l.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9366a(Cursor cursor) {
        long j = 0;
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            C1354ac c1354acM5964a = null;
            try {
                c1354acM5964a = C1353ab.m5964a(cursor.getString(cursor.getColumnIndex("extras")));
            } catch (JSONException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f9534c);
                }
            }
            this.f9540g = cursor.getInt(cursor.getColumnIndex("install")) != 0;
            long j2 = cursor.getLong(cursor.getColumnIndex("expiration_time"));
            if (c1354acM5964a != null) {
                this.f9538e = c1354acM5964a.m5973c();
                this.f9539f = c1354acM5964a.m5975d();
                this.f9535a = c1354acM5964a.m5971b();
            }
            j = j2;
        }
        this.f9544k.setVisibility(0);
        this.f9546m.setVisibility(8);
        if (this.f9540g) {
            ((ActionBarFragmentActivity) this.f9554u).supportInvalidateOptionsMenu();
            this.f9544k.setImageResource(R.drawable.anicon_package_item_download_apply_xml);
            if (C2591cd.m9575b(this.f9537d)) {
                this.f9544k.setImageResource(R.drawable.download_ic_applied);
                this.f9544k.setEnabled(false);
            } else {
                this.f9544k.setEnabled(true);
            }
            this.f9546m.setVisibility(8);
            this.f9543j.setText(C3364o.m11849a(" (", Long.valueOf(this.f9539f / 1000), "KB) / ", getString(R.string.download_unlimited)));
            C2646u.m9657b(this.f9543j);
        } else if (this.f9549p == null) {
            String str = this.f9536b.format((Date) new java.sql.Date(j));
            this.f9544k.setImageResource(R.drawable.anicon_package_item_download_event_xml);
            this.f9546m.setVisibility(8);
            this.f9543j.setText(C3364o.m11849a(" (", Long.valueOf(this.f9539f / 1000), "KB)", " / ", "~", str));
            C2646u.m9649a(this.f9543j);
        } else if (this.f9549p.m9455d() == 5) {
            String str2 = this.f9536b.format((Date) new java.sql.Date(j));
            this.f9544k.setImageResource(R.drawable.anicon_package_item_download_fail_event_xml);
            this.f9546m.setVisibility(8);
            this.f9543j.setText(C3364o.m11849a(" (", Long.valueOf(this.f9539f / 1000), "KB)", " / ", "~", str2));
            C2646u.m9649a(this.f9543j);
        } else {
            this.f9546m.setVisibility(0);
            switch (this.f9549p.m9455d()) {
                case 0:
                    this.f9544k.setImageResource(R.drawable.anicon_package_item_downloading_event_xml);
                    if (!this.f9546m.isIndeterminate()) {
                        this.f9546m.setIndeterminate(true);
                    }
                    this.f9543j.setText(C3364o.m11849a(" (", getString(R.string.download_progressing), ")"));
                    C2646u.m9665c(this.f9543j);
                    break;
                case 1:
                    this.f9544k.setImageResource(R.drawable.anicon_package_item_downloading_event_xml);
                    if (this.f9546m.isIndeterminate()) {
                        this.f9546m.setIndeterminate(false);
                    }
                    this.f9546m.setProgress(this.f9549p.m11747g().intValue());
                    this.f9543j.setText(C3364o.m11849a(" (", Long.valueOf(this.f9539f / 1000), "KB)"));
                    C2646u.m9665c(this.f9543j);
                    break;
                case 2:
                    this.f9544k.setVisibility(4);
                    this.f9546m.setVisibility(8);
                    this.f9543j.setText(getString(R.string.download_installing));
                    C2646u.m9668d(this.f9543j);
                    break;
            }
        }
        if (!TextUtils.isEmpty(this.f9538e)) {
            CallableC1825o callableC1825o = new CallableC1825o(this.f9538e, this.f9541h, this.f9542i, true);
            callableC1825o.m7494a(R.drawable.chat_anicon_btn_failed);
            this.f9548o.m11730a(this.f9545l, callableC1825o);
        }
        this.f9545l = (ImageView) this.f9552s.findViewById(R.id.detail_view_image);
    }
}
