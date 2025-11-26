package com.sec.chaton.settings.downloads;

import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.TransitionDrawable;
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
import com.sec.chaton.p025d.C1333k;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p027e.p028a.C1367k;
import com.sec.chaton.p027e.p028a.C1368l;
import com.sec.chaton.settings.downloads.p056a.C2518i;
import com.sec.chaton.settings.downloads.p056a.C2525p;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.common.p069e.C3326c;
import com.sec.common.p069e.InterfaceC3329f;
import com.sec.common.util.C3364o;
import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import org.json.JSONException;

/* loaded from: classes.dex */
public class FontDetail extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>, View.OnClickListener, InterfaceC3329f {

    /* renamed from: b */
    private static final String f9490b = ActivityFontDetail.class.getSimpleName();

    /* renamed from: A */
    private C2518i f9491A;

    /* renamed from: B */
    private Cursor f9492B;

    /* renamed from: C */
    private boolean f9493C;

    /* renamed from: D */
    private View f9494D;

    /* renamed from: E */
    private Menu f9495E;

    /* renamed from: a */
    DateFormat f9497a;

    /* renamed from: c */
    private String f9498c;

    /* renamed from: d */
    private String f9499d;

    /* renamed from: e */
    private String f9500e;

    /* renamed from: f */
    private String f9501f;

    /* renamed from: h */
    private boolean f9503h;

    /* renamed from: i */
    private int f9504i;

    /* renamed from: j */
    private int f9505j;

    /* renamed from: k */
    private String f9506k;

    /* renamed from: l */
    private int f9507l;

    /* renamed from: m */
    private int f9508m;

    /* renamed from: n */
    private int f9509n;

    /* renamed from: o */
    private int f9510o;

    /* renamed from: p */
    private ImageView f9511p;

    /* renamed from: q */
    private TextView f9512q;

    /* renamed from: r */
    private TextView f9513r;

    /* renamed from: s */
    private TextView f9514s;

    /* renamed from: t */
    private ImageView f9515t;

    /* renamed from: u */
    private ImageView f9516u;

    /* renamed from: v */
    private TextView f9517v;

    /* renamed from: w */
    private ProgressBar f9518w;

    /* renamed from: x */
    private C1333k f9519x;

    /* renamed from: y */
    private C3326c f9520y;

    /* renamed from: z */
    private File f9521z;

    /* renamed from: g */
    private long f9502g = 0;

    /* renamed from: F */
    private Handler f9496F = new HandlerC2561ba(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9498c = getActivity().getIntent().getExtras().getString("ITEM_ID");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_font_detail_view, viewGroup, false);
        this.f9494D = viewInflate;
        this.f9497a = android.text.format.DateFormat.getMediumDateFormat(CommonApplication.m11493l());
        this.f9519x = new C1333k(getActivity(), null);
        this.f9520y = new C3326c();
        this.f9520y.m11735a(this);
        this.f9507l = getResources().getDimensionPixelOffset(R.dimen.anicon_download_thumbnail_width);
        this.f9508m = getResources().getDimensionPixelOffset(R.dimen.anicon_download_thumbnail_height);
        this.f9509n = getResources().getDimensionPixelOffset(R.dimen.font_download_preview_width);
        this.f9510o = getResources().getDimensionPixelOffset(R.dimen.font_download_preview_height);
        this.f9511p = (ImageView) viewInflate.findViewById(R.id.anicon_package_item_thumbnail);
        this.f9512q = (TextView) viewInflate.findViewById(R.id.anicon_package_item_name);
        this.f9512q.setSelected(true);
        this.f9512q.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f9513r = (TextView) viewInflate.findViewById(R.id.anicon_package_item_volume);
        this.f9513r.setSelected(true);
        this.f9513r.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f9514s = (TextView) viewInflate.findViewById(R.id.font_filter_name);
        this.f9515t = (ImageView) viewInflate.findViewById(R.id.anicon_package_item_download);
        this.f9515t.setOnClickListener(this);
        this.f9516u = (ImageView) viewInflate.findViewById(R.id.anicon_preview_image);
        this.f9517v = (TextView) viewInflate.findViewById(R.id.anicon_package_item_ribbon);
        this.f9518w = (ProgressBar) viewInflate.findViewById(R.id.anicon_package_item_progress);
        this.f9493C = true;
        getLoaderManager().initLoader(0, null, this);
        setHasOptionsMenu(true);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.download_delete_menu, menu);
        this.f9495E = menu;
        if (this.f9503h) {
            this.f9495E.findItem(R.id.downloads_delete).setVisible(true);
        } else {
            this.f9495E.findItem(R.id.downloads_delete).setVisible(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.downloads_delete /* 2131166609 */:
                m9345a();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
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
    public void onDestroyView() {
        super.onDestroy();
        if (this.f9491A != null) {
            this.f9491A.m9451b(this.f9496F);
        }
        getLoaderManager().destroyLoader(0);
        if (this.f9521z != null && this.f9521z.exists()) {
            this.f9521z.delete();
        }
        if (this.f9520y != null) {
            this.f9520y.m11735a((InterfaceC3329f) null);
            this.f9520y.m11731a();
        }
    }

    /* renamed from: a */
    void m9345a() {
        if (!TextUtils.isEmpty(this.f9498c) && this.f9503h) {
            C2555av.m9492d(getActivity()).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2562bb(this)).mo11512b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.f9498c)) {
            switch (view.getId()) {
                case R.id.anicon_package_item_download /* 2131165640 */:
                    if (this.f9503h) {
                        if (C2570bj.m9515a(this.f9498c, this.f9499d)) {
                            C2555av.m9495g(CommonApplication.m11493l()).show();
                            getActivity().setResult(2000);
                        } else {
                            C2555av.m9496h(CommonApplication.m11493l()).show();
                        }
                    } else if (this.f9491A == null) {
                        this.f9491A = new C2518i(this.f9519x, this.f9498c);
                        this.f9491A.m9446a(this.f9496F);
                        this.f9491A.m11745d(new Void[0]);
                    } else if (this.f9491A.m9455d() == 5) {
                        this.f9491A = new C2518i(this.f9519x, this.f9498c);
                        this.f9491A.m9446a(this.f9496F);
                        this.f9491A.m11745d(new Void[0]);
                    } else {
                        switch (this.f9491A.m9455d()) {
                            case 0:
                            case 1:
                            case 2:
                                this.f9491A.m11744a(true);
                                break;
                        }
                    }
                    m9339a(this.f9492B);
                    break;
            }
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(getActivity(), C1398ap.m6250a(this.f9498c), null, null, null, null);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        this.f9492B = cursor;
        if (this.f9493C) {
            this.f9493C = false;
            this.f9491A = (C2518i) C2525p.m9458a().m9459a(EnumC1399aq.Font, this.f9498c);
            if (this.f9491A != null) {
                this.f9491A.m9446a(this.f9496F);
            }
        }
        m9339a(cursor);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    @Override // com.sec.common.p069e.InterfaceC3329f
    /* renamed from: a */
    public void mo3713a(View view, AbstractRunnableC3324a<?> abstractRunnableC3324a) {
        if (view == this.f9516u) {
            this.f9516u.setBackgroundResource(R.drawable.picturebox2);
        }
    }

    @Override // com.sec.common.p069e.InterfaceC3329f
    /* renamed from: b */
    public void mo3722b(View view, AbstractRunnableC3324a<?> abstractRunnableC3324a) {
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m9344c();
    }

    /* renamed from: c */
    private void m9344c() {
        TransitionDrawable transitionDrawable;
        Display defaultDisplay = ((WindowManager) GlobalApplication.m6447a().getSystemService("window")).getDefaultDisplay();
        if ((this.f9516u.getDrawable() instanceof TransitionDrawable) && (transitionDrawable = (TransitionDrawable) this.f9516u.getDrawable()) != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f9516u.getLayoutParams();
            if (transitionDrawable != null) {
                this.f9516u.setImageDrawable(transitionDrawable);
                this.f9516u.setScaleType(ImageView.ScaleType.FIT_XY);
                layoutParams.height = (int) ((defaultDisplay.getWidth() - C3172an.m11085a(20.0f)) - C3172an.m11087c(20.0f));
                this.f9516u.setLayoutParams(layoutParams);
                this.f9516u.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9339a(Cursor cursor) {
        if (C3250y.f11734b) {
            C3250y.m11450b("download_font, show detail, redraw()", f9490b);
        }
        long j = 0;
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            String string = cursor.getString(cursor.getColumnIndex("name"));
            C1368l c1368lM6095a = null;
            try {
                c1368lM6095a = C1367k.m6095a(cursor.getString(cursor.getColumnIndex("extras")));
            } catch (JSONException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f9490b);
                }
            }
            this.f9499d = string;
            if (c1368lM6095a != null) {
                this.f9500e = c1368lM6095a.f5119c;
                this.f9501f = c1368lM6095a.f5118b;
                this.f9502g = c1368lM6095a.f5120d;
                this.f9506k = c1368lM6095a.f5117a;
            }
            this.f9503h = cursor.getInt(cursor.getColumnIndex("install")) != 0;
            this.f9504i = cursor.getInt(cursor.getColumnIndex("new"));
            this.f9505j = cursor.getInt(cursor.getColumnIndex("special"));
            j = cursor.getLong(cursor.getColumnIndex("expiration_time"));
        }
        this.f9512q.setText(this.f9499d);
        this.f9515t.setVisibility(0);
        this.f9518w.setVisibility(8);
        if (this.f9503h) {
            ((ActionBarFragmentActivity) getActivity()).supportInvalidateOptionsMenu();
            this.f9515t.setImageResource(R.drawable.anicon_package_item_download_apply_xml);
            if (C2570bj.m9514a(this.f9498c)) {
                this.f9515t.setImageResource(R.drawable.download_ic_applied);
                this.f9515t.setEnabled(false);
            } else {
                this.f9515t.setEnabled(true);
            }
            this.f9518w.setVisibility(8);
            this.f9513r.setText(C3364o.m11849a(" (", Long.valueOf(this.f9502g / 1000), "KB) / ", getString(R.string.download_unlimited)));
            C2570bj.m9520b(this.f9513r);
            this.f9514s.setText(this.f9506k);
        } else if (this.f9491A == null) {
            String str = this.f9497a.format((Date) new java.sql.Date(j));
            this.f9515t.setImageResource(R.drawable.anicon_package_item_download_event_xml);
            this.f9518w.setVisibility(8);
            this.f9513r.setText(C3364o.m11849a(" (", Long.valueOf(this.f9502g / 1000), "KB)", " / ", "~", str));
            C2570bj.m9513a(this.f9513r);
            this.f9514s.setText(this.f9506k);
        } else if (this.f9491A.m9455d() == 5) {
            String str2 = this.f9497a.format((Date) new java.sql.Date(j));
            this.f9515t.setImageResource(R.drawable.anicon_package_item_download_fail_event_xml);
            this.f9518w.setVisibility(8);
            this.f9513r.setText(C3364o.m11849a(" (", Long.valueOf(this.f9502g / 1000), "KB)", " / ", "~", str2));
            C2570bj.m9513a(this.f9513r);
            this.f9514s.setText(this.f9506k);
        } else {
            this.f9518w.setVisibility(0);
            switch (this.f9491A.m9455d()) {
                case 0:
                    this.f9515t.setImageResource(R.drawable.anicon_package_item_downloading_event_xml);
                    if (!this.f9518w.isIndeterminate()) {
                        this.f9518w.setIndeterminate(true);
                    }
                    if (!GlobalApplication.m6456e()) {
                        this.f9513r.setText(C3364o.m11849a(" (", getString(R.string.download_progressing), ")"));
                        C2570bj.m9522c(this.f9513r);
                    }
                    this.f9514s.setText(this.f9506k);
                    break;
                case 1:
                    this.f9515t.setImageResource(R.drawable.anicon_package_item_downloading_event_xml);
                    if (this.f9518w.isIndeterminate()) {
                        this.f9518w.setIndeterminate(false);
                    }
                    this.f9518w.setProgress(this.f9491A.m11747g().intValue());
                    if (!GlobalApplication.m6456e()) {
                        this.f9513r.setText(C3364o.m11849a(" (", Long.valueOf(this.f9502g / 1000), "KB)"));
                        C2570bj.m9522c(this.f9513r);
                    }
                    this.f9514s.setText(this.f9506k);
                    break;
                case 2:
                    this.f9515t.setVisibility(4);
                    this.f9518w.setVisibility(8);
                    if (!GlobalApplication.m6456e()) {
                        this.f9513r.setText(getString(R.string.download_installing));
                        C2570bj.m9523d(this.f9513r);
                    }
                    this.f9514s.setText(this.f9506k);
                    break;
            }
        }
        if (this.f9505j != 0) {
            this.f9517v.setVisibility(0);
            this.f9517v.setText(R.string.download_special_ribbon_text);
            this.f9517v.setBackgroundColor(Color.parseColor("#3eb1b9"));
        } else if (this.f9504i != 0) {
            this.f9517v.setVisibility(0);
            this.f9517v.setText(R.string.download_new_ribbon_text);
            this.f9517v.setBackgroundColor(Color.parseColor("#e86d00"));
        } else {
            this.f9517v.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f9501f)) {
            this.f9520y.m11730a(this.f9511p, new CallableC1825o(this.f9501f, this.f9507l, this.f9508m));
        }
        if (!TextUtils.isEmpty(this.f9500e)) {
            CallableC1825o callableC1825o = new CallableC1825o(this.f9500e, this.f9509n, this.f9510o, true);
            callableC1825o.m7494a(R.drawable.chat_anicon_btn_failed);
            this.f9520y.m11730a(this.f9516u, callableC1825o);
        }
        this.f9516u = (ImageView) this.f9494D.findViewById(R.id.anicon_preview_image);
    }
}
