package com.sec.chaton.settings.downloads;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.audio.AsyncTaskC1772d;
import com.sec.chaton.multimedia.audio.EnumC1774f;
import com.sec.chaton.p025d.C1317bc;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p027e.p028a.C1355ad;
import com.sec.chaton.p027e.p028a.C1356ae;
import com.sec.chaton.settings.downloads.p056a.C2525p;
import com.sec.chaton.settings.downloads.p056a.C2531v;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.util.C3364o;
import com.sec.widget.C3641ai;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.util.Date;
import org.json.JSONException;

/* loaded from: classes.dex */
public class SoundDetail extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>, View.OnClickListener {

    /* renamed from: c */
    private static final String f9569c = SoundDetail.class.getSimpleName();

    /* renamed from: a */
    DateFormat f9570a;

    /* renamed from: b */
    C2580bt f9571b;

    /* renamed from: d */
    private String f9572d;

    /* renamed from: e */
    private String f9573e;

    /* renamed from: f */
    private String f9574f;

    /* renamed from: h */
    private boolean f9576h;

    /* renamed from: i */
    private int f9577i;

    /* renamed from: j */
    private int f9578j;

    /* renamed from: k */
    private ImageView f9579k;

    /* renamed from: l */
    private TextView f9580l;

    /* renamed from: m */
    private TextView f9581m;

    /* renamed from: n */
    private ImageView f9582n;

    /* renamed from: o */
    private TextView f9583o;

    /* renamed from: p */
    private ProgressBar f9584p;

    /* renamed from: q */
    private C1317bc f9585q;

    /* renamed from: r */
    private C2531v f9586r;

    /* renamed from: s */
    private Cursor f9587s;

    /* renamed from: t */
    private boolean f9588t;

    /* renamed from: u */
    private Menu f9589u;

    /* renamed from: g */
    private long f9575g = 0;

    /* renamed from: v */
    private Handler f9590v = new HandlerC2608cu(this);

    /* renamed from: w */
    private Handler f9591w = new HandlerC2609cv(this);

    /* renamed from: a */
    public void m9400a(String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b("download_sound, requestPlaySample()", f9569c);
        }
        if (TextUtils.isEmpty(str)) {
            if (C3250y.f11734b) {
                C3250y.m11450b("download_sound, requestPlaySample(), itemid is (empty)", f9569c);
                return;
            }
            return;
        }
        try {
            try {
                File file = new File(new URI(C2620df.m9606c(getActivity(), str).toString()));
                if (file != null && file.exists()) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b(C3364o.m11849a("download_sound, requestPlaySample(), play installed file : ", str), f9569c);
                    }
                    m9392a(str, file.getPath());
                    return;
                }
                if (C3250y.f11734b) {
                    C3250y.m11450b(C3364o.m11849a("download_sound, requestPlaySample(), play download file : ", str), f9569c);
                }
                if (TextUtils.isEmpty(this.f9573e)) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("download_sound, requestPlaySample(), sample url is (empty)", f9569c);
                    }
                    m9398a();
                    return;
                }
                m9394b(str, this.f9573e);
            } catch (IllegalArgumentException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f9569c);
                }
                m9398a();
            }
        } catch (URISyntaxException e2) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e2, f9569c);
            }
            m9398a();
        }
    }

    /* renamed from: a */
    void m9398a() {
        C3641ai.m13211a(CommonApplication.m11493l(), getString(R.string.download_failed), 0).show();
    }

    /* renamed from: a */
    private void m9392a(String str, String str2) {
        if (this.f9571b != null) {
            this.f9571b.m9547b(new AsyncTaskC1772d(str, str2, null));
        }
    }

    /* renamed from: b */
    private void m9394b(String str, String str2) {
        if (this.f9571b != null) {
            this.f9571b.m9547b(new AsyncTaskC1772d(str, str2, null, true));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getActivity().getIntent();
        this.f9572d = intent.getExtras().getString("ITEM_ID");
        this.f9573e = intent.getExtras().getString("SAMPLE_URL");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        View viewInflate = layoutInflater.inflate(R.layout.layout_sound_detail_view, viewGroup, false);
        this.f9571b = C2580bt.m9540a(ViewOnClickListenerC2625dk.f9854a, this.f9590v);
        this.f9570a = android.text.format.DateFormat.getMediumDateFormat(CommonApplication.m11493l());
        this.f9585q = new C1317bc(getActivity(), null);
        this.f9579k = (ImageView) viewInflate.findViewById(R.id.anicon_package_item_thumbnail);
        this.f9579k.setOnClickListener(new ViewOnClickListenerC2610cw(this));
        EnumC1774f enumC1774fM9549c = this.f9571b.m9549c(this.f9572d);
        if (enumC1774fM9549c == null) {
            C2620df.m9598a(this.f9579k, EnumC1774f.PLAY_STATUS_FINISHED);
        } else {
            C2620df.m9598a(this.f9579k, enumC1774fM9549c);
        }
        this.f9580l = (TextView) viewInflate.findViewById(R.id.anicon_package_item_name);
        this.f9580l.setSelected(true);
        this.f9580l.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f9581m = (TextView) viewInflate.findViewById(R.id.anicon_package_item_volume);
        this.f9581m.setSelected(true);
        this.f9581m.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f9582n = (ImageView) viewInflate.findViewById(R.id.anicon_package_item_download);
        this.f9582n.setOnClickListener(this);
        this.f9583o = (TextView) viewInflate.findViewById(R.id.anicon_package_item_ribbon);
        this.f9584p = (ProgressBar) viewInflate.findViewById(R.id.anicon_package_item_progress);
        this.f9588t = true;
        getLoaderManager().initLoader(0, null, this);
        setHasOptionsMenu(true);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.download_delete_menu, menu);
        this.f9589u = menu;
        if (this.f9576h) {
            this.f9589u.findItem(R.id.downloads_delete).setVisible(true);
        } else {
            this.f9589u.findItem(R.id.downloads_delete).setVisible(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.downloads_delete /* 2131166609 */:
                m9401b();
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
    public void onDestroy() {
        super.onDestroy();
        if (this.f9586r != null) {
            this.f9586r.m9451b(this.f9591w);
        }
        C2580bt.m9541b(ViewOnClickListenerC2625dk.f9854a, this.f9590v);
        getLoaderManager().destroyLoader(0);
    }

    /* renamed from: b */
    void m9401b() {
        if (!TextUtils.isEmpty(this.f9572d) && this.f9576h) {
            C2555av.m9492d(getActivity()).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2611cx(this)).mo11512b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.f9572d)) {
            switch (view.getId()) {
                case R.id.anicon_package_item_download /* 2131165640 */:
                    if (this.f9576h) {
                        if (C2620df.m9600a(this.f9572d, this.f9574f)) {
                            C2555av.m9495g(CommonApplication.m11493l()).show();
                            getActivity().setResult(2000);
                        } else {
                            C2555av.m9496h(CommonApplication.m11493l()).show();
                        }
                    } else if (this.f9586r == null) {
                        this.f9586r = new C2531v(this.f9585q, this.f9572d);
                        this.f9586r.m9446a(this.f9591w);
                        this.f9586r.m11745d(new Void[0]);
                    } else if (this.f9586r.m9455d() == 5) {
                        this.f9586r = new C2531v(this.f9585q, this.f9572d);
                        this.f9586r.m9446a(this.f9591w);
                        this.f9586r.m11745d(new Void[0]);
                    } else {
                        switch (this.f9586r.m9455d()) {
                            case 0:
                            case 1:
                            case 2:
                                this.f9586r.m11744a(true);
                                break;
                        }
                    }
                    m9390a(this.f9587s);
                    break;
            }
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(getActivity(), C1398ap.m6249a(EnumC1399aq.Sound), null, C3364o.m11849a("item_id", "=?"), new String[]{this.f9572d}, null);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        this.f9587s = cursor;
        if (this.f9588t) {
            this.f9588t = false;
            this.f9586r = (C2531v) C2525p.m9458a().m9459a(EnumC1399aq.Sound, this.f9572d);
            if (this.f9586r != null) {
                this.f9586r.m9446a(this.f9591w);
            }
        }
        m9390a(cursor);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9390a(Cursor cursor) {
        if (C3250y.f11734b) {
            C3250y.m11450b("download_sound, show detail, redraw()", f9569c);
        }
        long j = 0;
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            String string = cursor.getString(cursor.getColumnIndex("name"));
            C1356ae c1356aeM5977a = null;
            try {
                c1356aeM5977a = C1355ad.m5977a(cursor.getString(cursor.getColumnIndex("extras")));
            } catch (JSONException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f9569c);
                }
            }
            this.f9574f = string;
            if (c1356aeM5977a != null) {
                this.f9575g = c1356aeM5977a.m5980a();
            }
            this.f9576h = cursor.getInt(cursor.getColumnIndex("install")) != 0;
            this.f9577i = cursor.getInt(cursor.getColumnIndex("new"));
            this.f9578j = cursor.getInt(cursor.getColumnIndex("special"));
            j = cursor.getLong(cursor.getColumnIndex("expiration_time"));
        }
        this.f9580l.setText(this.f9574f);
        this.f9582n.setVisibility(0);
        this.f9584p.setVisibility(8);
        if (this.f9576h) {
            ((ActionBarFragmentActivity) getActivity()).supportInvalidateOptionsMenu();
            this.f9582n.setImageResource(R.drawable.anicon_package_item_download_apply_xml);
            if (C2620df.m9599a(this.f9572d)) {
                this.f9582n.setEnabled(false);
            } else {
                this.f9582n.setEnabled(true);
            }
            this.f9584p.setVisibility(8);
            this.f9581m.setText(C3364o.m11849a(" (", Long.valueOf(this.f9575g / 1000), "KB)"));
            C2620df.m9605b(this.f9581m);
        } else if (this.f9586r == null) {
            this.f9570a.format((Date) new java.sql.Date(j));
            this.f9582n.setImageResource(R.drawable.anicon_package_item_download_event_xml);
            this.f9584p.setVisibility(8);
            this.f9581m.setText(C3364o.m11849a(" (", Long.valueOf(this.f9575g / 1000), "KB)"));
            C2620df.m9597a(this.f9581m);
        } else if (this.f9586r.m9455d() == 5) {
            this.f9570a.format((Date) new java.sql.Date(j));
            this.f9582n.setImageResource(R.drawable.anicon_package_item_download_fail_event_xml);
            this.f9584p.setVisibility(8);
            this.f9581m.setText(C3364o.m11849a(" (", Long.valueOf(this.f9575g / 1000), "KB)"));
            C2620df.m9597a(this.f9581m);
        } else {
            this.f9584p.setVisibility(0);
            switch (this.f9586r.m9455d()) {
                case 0:
                    this.f9582n.setImageResource(R.drawable.anicon_package_item_downloading_event_xml);
                    if (!this.f9584p.isIndeterminate()) {
                        this.f9584p.setIndeterminate(true);
                    }
                    this.f9581m.setText(C3364o.m11849a(" (", getString(R.string.download_progressing), ")"));
                    C2620df.m9607c(this.f9581m);
                    break;
                case 1:
                    this.f9582n.setImageResource(R.drawable.anicon_package_item_downloading_event_xml);
                    if (this.f9584p.isIndeterminate()) {
                        this.f9584p.setIndeterminate(false);
                    }
                    this.f9584p.setProgress(this.f9586r.m11747g().intValue());
                    this.f9581m.setText(C3364o.m11849a(" (", Long.valueOf(this.f9575g / 1000), "KB)"));
                    C2620df.m9607c(this.f9581m);
                    break;
                case 2:
                    this.f9582n.setVisibility(4);
                    this.f9584p.setVisibility(8);
                    this.f9581m.setText(getString(R.string.download_installing));
                    C2620df.m9609d(this.f9581m);
                    break;
            }
        }
        if (this.f9578j != 0) {
            this.f9583o.setVisibility(0);
            this.f9583o.setText(R.string.download_special_ribbon_text);
            this.f9583o.setBackgroundColor(Color.parseColor("#3eb1b9"));
        } else {
            if (this.f9577i != 0) {
                this.f9583o.setVisibility(0);
                this.f9583o.setText(R.string.download_new_ribbon_text);
                this.f9583o.setBackgroundColor(Color.parseColor("#e86d00"));
                return;
            }
            this.f9583o.setVisibility(8);
        }
    }
}
