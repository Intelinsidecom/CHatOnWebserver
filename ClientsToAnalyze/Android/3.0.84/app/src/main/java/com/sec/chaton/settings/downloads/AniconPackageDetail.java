package com.sec.chaton.settings.downloads;

import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Color;
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
import com.sec.chaton.p025d.C1332j;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p027e.p028a.C1358b;
import com.sec.chaton.p027e.p028a.C1359c;
import com.sec.chaton.settings.downloads.p056a.C2514e;
import com.sec.chaton.settings.downloads.p056a.C2525p;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.common.p069e.C3326c;
import com.sec.common.p069e.InterfaceC3329f;
import com.sec.common.util.C3347i;
import com.sec.common.util.C3364o;
import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import org.json.JSONException;

/* loaded from: classes.dex */
public class AniconPackageDetail extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>, View.OnClickListener, InterfaceC3329f {

    /* renamed from: b */
    private static final String f9447b = ActivityAniconPackageDetail.class.getSimpleName();

    /* renamed from: A */
    private boolean f9448A;

    /* renamed from: B */
    private View f9449B;

    /* renamed from: C */
    private Menu f9450C;

    /* renamed from: D */
    private ProgressDialog f9451D;

    /* renamed from: a */
    DateFormat f9454a;

    /* renamed from: c */
    private String f9455c;

    /* renamed from: d */
    private String f9456d;

    /* renamed from: e */
    private String f9457e;

    /* renamed from: f */
    private String f9458f;

    /* renamed from: h */
    private boolean f9460h;

    /* renamed from: i */
    private int f9461i;

    /* renamed from: j */
    private int f9462j;

    /* renamed from: k */
    private int f9463k;

    /* renamed from: l */
    private int f9464l;

    /* renamed from: m */
    private int f9465m;

    /* renamed from: n */
    private int f9466n;

    /* renamed from: o */
    private ImageView f9467o;

    /* renamed from: p */
    private TextView f9468p;

    /* renamed from: q */
    private TextView f9469q;

    /* renamed from: r */
    private ImageView f9470r;

    /* renamed from: s */
    private ImageView f9471s;

    /* renamed from: t */
    private TextView f9472t;

    /* renamed from: u */
    private ProgressBar f9473u;

    /* renamed from: v */
    private C1332j f9474v;

    /* renamed from: w */
    private C3326c f9475w;

    /* renamed from: x */
    private File f9476x;

    /* renamed from: y */
    private C2514e f9477y;

    /* renamed from: z */
    private Cursor f9478z;

    /* renamed from: g */
    private long f9459g = 0;

    /* renamed from: E */
    private Handler f9452E = new HandlerC2541ah(this);

    /* renamed from: F */
    private Handler f9453F = new HandlerC2542ai(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9455c = getActivity().getIntent().getExtras().getString("ANICON_PACKAGE_ID");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_package_detail_view, viewGroup, false);
        this.f9449B = viewInflate;
        this.f9454a = android.text.format.DateFormat.getMediumDateFormat(CommonApplication.m11493l());
        this.f9474v = new C1332j(getActivity(), this.f9453F);
        this.f9475w = new C3326c();
        this.f9475w.m11735a(this);
        this.f9463k = getResources().getDimensionPixelOffset(R.dimen.anicon_download_thumbnail_width);
        this.f9464l = getResources().getDimensionPixelOffset(R.dimen.anicon_download_thumbnail_height);
        this.f9465m = C3347i.m11779b();
        this.f9466n = C3347i.m11780c();
        this.f9467o = (ImageView) viewInflate.findViewById(R.id.anicon_package_item_thumbnail);
        this.f9468p = (TextView) viewInflate.findViewById(R.id.anicon_package_item_name);
        this.f9468p.setSelected(true);
        this.f9468p.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f9469q = (TextView) viewInflate.findViewById(R.id.anicon_package_item_volume);
        this.f9469q.setSelected(true);
        this.f9469q.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f9470r = (ImageView) viewInflate.findViewById(R.id.anicon_package_item_download);
        this.f9470r.setOnClickListener(this);
        this.f9471s = (ImageView) viewInflate.findViewById(R.id.anicon_preview_image);
        this.f9472t = (TextView) viewInflate.findViewById(R.id.anicon_package_item_ribbon);
        this.f9473u = (ProgressBar) viewInflate.findViewById(R.id.anicon_package_item_progress);
        this.f9448A = true;
        this.f9451D = (ProgressDialog) new C3263j(getActivity()).m11487a(R.string.setting_webview_please_wait);
        this.f9451D.setCancelable(true);
        this.f9451D.setCanceledOnTouchOutside(false);
        this.f9451D.setOnCancelListener(new DialogInterfaceOnCancelListenerC2543aj(this));
        if (TextUtils.isEmpty(this.f9455c)) {
            this.f9474v.m5769a(this.f9455c, "1", 240);
            this.f9451D.show();
        } else {
            getLoaderManager().initLoader(0, null, this);
        }
        setHasOptionsMenu(true);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.download_delete_menu, menu);
        this.f9450C = menu;
        if (this.f9460h) {
            this.f9450C.findItem(R.id.downloads_delete).setVisible(true);
        } else {
            this.f9450C.findItem(R.id.downloads_delete).setVisible(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.downloads_delete /* 2131166609 */:
                m9318a();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (getLoaderManager().getLoader(0) != null) {
            getLoaderManager().getLoader(0).startLoading();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (getLoaderManager().getLoader(0) != null) {
            getLoaderManager().getLoader(0).stopLoading();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f9477y != null) {
            this.f9477y.m9451b(this.f9452E);
        }
        getLoaderManager().destroyLoader(0);
        if (this.f9476x != null && this.f9476x.exists()) {
            this.f9476x.delete();
        }
        if (this.f9475w != null) {
            this.f9475w.m11735a((InterfaceC3329f) null);
            this.f9475w.m11731a();
        }
        if (this.f9451D != null) {
            this.f9451D.dismiss();
        }
    }

    /* renamed from: a */
    void m9318a() {
        if (!TextUtils.isEmpty(this.f9455c) && this.f9460h) {
            C2555av.m9492d(getActivity()).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2544ak(this)).mo11512b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.f9455c)) {
            switch (view.getId()) {
                case R.id.anicon_package_item_download /* 2131165640 */:
                    if (this.f9460h) {
                        this.f9470r.setVisibility(4);
                    } else if (this.f9477y == null) {
                        this.f9477y = new C2514e(this.f9474v, this.f9455c);
                        this.f9477y.m9446a(this.f9452E);
                        this.f9477y.m11745d(new Void[0]);
                    } else if (this.f9477y.m9455d() == 5) {
                        this.f9477y = new C2514e(this.f9474v, this.f9455c);
                        this.f9477y.m9446a(this.f9452E);
                        this.f9477y.m11745d(new Void[0]);
                    } else {
                        switch (this.f9477y.m9455d()) {
                            case 0:
                            case 1:
                            case 2:
                                this.f9477y.m11744a(true);
                                break;
                        }
                    }
                    m9311a(this.f9478z);
                    break;
            }
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(getActivity(), C1398ap.m6249a(EnumC1399aq.Anicon), null, C3364o.m11849a("item_id", "=?"), new String[]{this.f9455c}, null);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        this.f9478z = cursor;
        if (this.f9448A) {
            this.f9448A = false;
            this.f9477y = (C2514e) C2525p.m9458a().m9459a(EnumC1399aq.Anicon, this.f9455c);
            if (this.f9477y != null) {
                this.f9477y.m9446a(this.f9452E);
            }
        }
        m9311a(cursor);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    @Override // com.sec.common.p069e.InterfaceC3329f
    /* renamed from: a */
    public void mo3713a(View view, AbstractRunnableC3324a<?> abstractRunnableC3324a) {
        if (view == this.f9471s) {
            this.f9471s.setBackgroundResource(R.drawable.picturebox2);
        }
    }

    @Override // com.sec.common.p069e.InterfaceC3329f
    /* renamed from: b */
    public void mo3722b(View view, AbstractRunnableC3324a<?> abstractRunnableC3324a) {
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m9316c();
    }

    /* renamed from: c */
    private void m9316c() {
        Display defaultDisplay = ((WindowManager) GlobalApplication.m6447a().getSystemService("window")).getDefaultDisplay();
        Drawable drawable = this.f9471s.getDrawable();
        if (drawable != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f9471s.getLayoutParams();
            if (drawable != null) {
                this.f9471s.setImageDrawable(drawable);
                this.f9471s.setScaleType(ImageView.ScaleType.FIT_XY);
                layoutParams.height = (int) ((defaultDisplay.getWidth() - C3172an.m11085a(20.0f)) - C3172an.m11087c(20.0f));
                this.f9471s.setLayoutParams(layoutParams);
                this.f9471s.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9311a(Cursor cursor) {
        String str;
        String strValueOf = String.valueOf(0);
        long j = 0;
        if (cursor != null && cursor.isClosed()) {
            if (C3250y.f11734b) {
                C3250y.m11450b("cursor is closed", f9447b);
                return;
            }
            return;
        }
        if (cursor == null || cursor.getCount() <= 0) {
            str = strValueOf;
        } else {
            cursor.moveToFirst();
            String string = cursor.getString(cursor.getColumnIndex("name"));
            C1359c c1359cM6004a = null;
            try {
                c1359cM6004a = C1358b.m6004a(cursor.getString(cursor.getColumnIndex("extras")));
            } catch (JSONException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f9447b);
                }
            }
            this.f9456d = string;
            this.f9460h = cursor.getInt(cursor.getColumnIndex("install")) != 0;
            this.f9461i = cursor.getInt(cursor.getColumnIndex("new"));
            this.f9462j = cursor.getInt(cursor.getColumnIndex("special"));
            long j2 = cursor.getLong(cursor.getColumnIndex("expiration_time"));
            if (c1359cM6004a != null) {
                this.f9457e = c1359cM6004a.m6007a();
                this.f9458f = c1359cM6004a.m6011b();
                strValueOf = String.valueOf(c1359cM6004a.m6013c());
                this.f9459g = c1359cM6004a.m6015d();
            }
            j = j2;
            str = strValueOf;
        }
        this.f9468p.setText(this.f9456d);
        this.f9470r.setVisibility(0);
        this.f9473u.setVisibility(8);
        if (this.f9460h) {
            ((ActionBarFragmentActivity) getActivity()).supportInvalidateOptionsMenu();
            this.f9470r.setVisibility(4);
            this.f9473u.setVisibility(8);
            this.f9469q.setText(C3364o.m11849a(str, " (", Long.valueOf(this.f9459g / 1000), "KB) / ", getString(R.string.download_unlimited)));
            C2646u.m9657b(this.f9469q);
        } else if (this.f9477y == null) {
            String str2 = this.f9454a.format((Date) new java.sql.Date(j));
            this.f9470r.setImageResource(R.drawable.anicon_package_item_download_event_xml);
            this.f9473u.setVisibility(8);
            this.f9469q.setText(C3364o.m11849a(str, " (", Long.valueOf(this.f9459g / 1000), "KB)", " / ", "~", str2));
            C2646u.m9649a(this.f9469q);
        } else if (this.f9477y.m9455d() == 5) {
            String str3 = this.f9454a.format((Date) new java.sql.Date(j));
            this.f9470r.setImageResource(R.drawable.anicon_package_item_download_fail_event_xml);
            this.f9473u.setVisibility(8);
            this.f9469q.setText(C3364o.m11849a(str, " (", Long.valueOf(this.f9459g / 1000), "KB)", " / ", "~", str3));
            C2646u.m9649a(this.f9469q);
        } else {
            this.f9473u.setVisibility(0);
            switch (this.f9477y.m9455d()) {
                case 0:
                    this.f9470r.setImageResource(R.drawable.anicon_package_item_downloading_event_xml);
                    if (!this.f9473u.isIndeterminate()) {
                        this.f9473u.setIndeterminate(true);
                    }
                    this.f9469q.setText(C3364o.m11849a(str, " (", getString(R.string.download_progressing), ")"));
                    C2646u.m9665c(this.f9469q);
                    break;
                case 1:
                    this.f9470r.setImageResource(R.drawable.anicon_package_item_downloading_event_xml);
                    if (this.f9473u.isIndeterminate()) {
                        this.f9473u.setIndeterminate(false);
                    }
                    this.f9473u.setProgress(this.f9477y.m11747g().intValue());
                    this.f9469q.setText(C3364o.m11849a(str, " (", Long.valueOf(this.f9459g / 1000), "KB)"));
                    C2646u.m9665c(this.f9469q);
                    break;
                case 2:
                    this.f9470r.setVisibility(4);
                    this.f9473u.setVisibility(8);
                    this.f9469q.setText(getString(R.string.download_installing));
                    C2646u.m9668d(this.f9469q);
                    break;
            }
        }
        if (this.f9462j != 0) {
            this.f9472t.setVisibility(0);
            this.f9472t.setText(R.string.download_special_ribbon_text);
            this.f9472t.setBackgroundColor(Color.parseColor("#3eb1b9"));
        } else if (this.f9461i != 0) {
            this.f9472t.setVisibility(0);
            this.f9472t.setText(R.string.download_new_ribbon_text);
            this.f9472t.setBackgroundColor(Color.parseColor("#e86d00"));
        } else {
            this.f9472t.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f9458f)) {
            this.f9475w.m11730a(this.f9467o, new CallableC1825o(this.f9458f, this.f9463k, this.f9464l));
        }
        if (!TextUtils.isEmpty(this.f9457e)) {
            CallableC1825o callableC1825o = new CallableC1825o(this.f9457e, this.f9465m, this.f9466n, true);
            callableC1825o.m7494a(R.drawable.chat_anicon_btn_failed);
            this.f9475w.m11730a(this.f9471s, callableC1825o);
        }
        this.f9471s = (ImageView) this.f9449B.findViewById(R.id.anicon_preview_image);
    }
}
