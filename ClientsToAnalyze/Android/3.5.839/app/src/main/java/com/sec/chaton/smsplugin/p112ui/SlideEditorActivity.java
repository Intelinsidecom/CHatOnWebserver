package com.sec.chaton.smsplugin.p112ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.TempFileProvider;
import com.sec.chaton.smsplugin.p110g.C3869o;
import com.sec.chaton.smsplugin.p110g.C3870p;
import com.sec.chaton.smsplugin.p110g.InterfaceC3860f;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5086i;
import com.sec.google.android.p134a.p135a.C5097t;

/* loaded from: classes.dex */
public class SlideEditorActivity extends Activity {

    /* renamed from: a */
    private ImageButton f15102a;

    /* renamed from: b */
    private ImageButton f15103b;

    /* renamed from: c */
    private Button f15104c;

    /* renamed from: d */
    private Button f15105d;

    /* renamed from: e */
    private Button f15106e;

    /* renamed from: f */
    private EditText f15107f;

    /* renamed from: g */
    private Button f15108g;

    /* renamed from: h */
    private BasicSlideEditorView f15109h;

    /* renamed from: i */
    private C3870p f15110i;

    /* renamed from: j */
    private C4323ip f15111j;

    /* renamed from: k */
    private SlideshowPresenter f15112k;

    /* renamed from: l */
    private boolean f15113l;

    /* renamed from: m */
    private int f15114m;

    /* renamed from: n */
    private Uri f15115n;

    /* renamed from: o */
    private final InterfaceC3860f f15116o = new C4298hr(this);

    /* renamed from: p */
    private final View.OnClickListener f15117p = new ViewOnClickListenerC4301hu(this);

    /* renamed from: q */
    private final InterfaceC4307i f15118q = new C4302hv(this);

    /* renamed from: r */
    private final View.OnClickListener f15119r = new ViewOnClickListenerC4303hw(this);

    /* renamed from: s */
    private final View.OnClickListener f15120s = new ViewOnClickListenerC4304hx(this);

    /* renamed from: t */
    private final View.OnClickListener f15121t = new ViewOnClickListenerC4305hy(this);

    /* renamed from: u */
    private final View.OnClickListener f15122u = new ViewOnClickListenerC4306hz(this);

    /* renamed from: v */
    private final View.OnClickListener f15123v = new ViewOnClickListenerC4308ia(this);

    /* renamed from: w */
    private final InterfaceC4158cm f15124w = new C4300ht(this);

    /* renamed from: d */
    static /* synthetic */ int m16197d(SlideEditorActivity slideEditorActivity) {
        int i = slideEditorActivity.f15114m;
        slideEditorActivity.f15114m = i - 1;
        return i;
    }

    /* renamed from: g */
    static /* synthetic */ int m16202g(SlideEditorActivity slideEditorActivity) {
        int i = slideEditorActivity.f15114m;
        slideEditorActivity.f15114m = i + 1;
        return i;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.edit_slide_activity);
        this.f15109h = (BasicSlideEditorView) findViewById(R.id.slide_editor_view);
        this.f15109h.setOnTextChangedListener(this.f15118q);
        this.f15103b = (ImageButton) findViewById(R.id.pre_slide_button);
        this.f15103b.setOnClickListener(this.f15121t);
        this.f15102a = (ImageButton) findViewById(R.id.next_slide_button);
        this.f15102a.setOnClickListener(this.f15122u);
        this.f15104c = (Button) findViewById(R.id.preview_button);
        this.f15104c.setOnClickListener(this.f15119r);
        this.f15105d = (Button) findViewById(R.id.replace_image_button);
        this.f15105d.setOnClickListener(this.f15120s);
        this.f15106e = (Button) findViewById(R.id.remove_slide_button);
        this.f15106e.setOnClickListener(this.f15117p);
        this.f15107f = (EditText) findViewById(R.id.text_message);
        this.f15107f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(C3847e.m14709o())});
        this.f15108g = (Button) findViewById(R.id.done_button);
        this.f15108g.setOnClickListener(this.f15123v);
        m16187a(bundle, getIntent());
        try {
            this.f15110i = C3870p.m14881a(this, this.f15115n);
            if (this.f15110i.size() == 0) {
                C3890m.m14999e("SlideEditorActivity", "Loaded slideshow is empty; can't edit nothingness, exiting.");
                finish();
                return;
            }
            this.f15110i.m14834c(this.f15116o);
            this.f15111j = new C4323ip(this, this.f15110i);
            this.f15112k = (SlideshowPresenter) C4278gy.m16480a("SlideshowPresenter", this, this.f15109h, this.f15110i);
            if (this.f15114m >= this.f15110i.size()) {
                this.f15114m = Math.max(0, this.f15110i.size() - 1);
            } else if (this.f15114m < 0) {
                this.f15114m = 0;
            }
            m16199e();
        } catch (C5111c e) {
            C3890m.m14995a("SlideEditorActivity", "Create SlideshowModel failed!", e);
            finish();
        }
    }

    /* renamed from: a */
    private void m16187a(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.f15115n = (Uri) bundle.getParcelable("message_uri");
            this.f15114m = bundle.getInt("slide_index", 0);
        } else {
            this.f15115n = intent.getData();
            this.f15114m = intent.getIntExtra("slide_index", 0);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("slide_index", this.f15114m);
        bundle.putParcelable("message_uri", this.f15115n);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        synchronized (this) {
            if (this.f15113l) {
                try {
                    C5086i c5086iM14899a = this.f15110i.m14899a();
                    C5097t.m19426a(this).m19450a(this.f15115n, c5086iM14899a);
                    this.f15110i.m14905a(c5086iM14899a);
                } catch (C5111c e) {
                    C3890m.m14995a("SlideEditorActivity", "Cannot update the message: " + this.f15115n, e);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f15110i != null) {
            this.f15110i.m14835d(this.f15116o);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16185a() {
        C4149cd.m16405a(this, this.f15115n, this.f15110i);
    }

    /* renamed from: b */
    private void m16193b() {
        setTitle(getString(R.string.slide_show_part, new Object[]{Integer.valueOf(this.f15114m + 1), Integer.valueOf(this.f15110i.size())}));
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        int i;
        if (isFinishing()) {
            return false;
        }
        menu.clear();
        C3869o c3869o = this.f15110i.get(this.f15114m);
        if (c3869o == null) {
            return false;
        }
        menu.add(0, 11, 0, R.string.preview_slideshow).setIcon(android.R.drawable.ic_dialog_alert_holo_light);
        if (c3869o.m14861d() && !TextUtils.isEmpty(c3869o.m14874n().m14940a())) {
            menu.add(0, 0, 0, R.string.remove_text).setIcon(R.drawable.ic_menu_remove_text);
        }
        if (c3869o.m14863e()) {
            menu.add(0, 3, 0, R.string.remove_picture).setIcon(R.drawable.ic_menu_remove_picture);
        } else if (!c3869o.m14867g()) {
            menu.add(0, 1, 0, R.string.add_picture).setIcon(R.drawable.ic_menu_picture);
            menu.add(0, 2, 0, R.string.attach_take_photo).setIcon(R.drawable.ic_menu_picture);
        }
        if (c3869o.m14865f()) {
            menu.add(0, 5, 0, R.string.remove_music).setIcon(R.drawable.ic_menu_remove_sound);
        } else if (!c3869o.m14867g()) {
            if (C3847e.m14634R()) {
                SubMenu icon = menu.addSubMenu(0, 13, 0, R.string.add_music).setIcon(R.drawable.ic_menu_add_sound);
                icon.add(0, 4, 0, R.string.attach_sound);
                icon.add(0, 12, 0, R.string.attach_record_sound);
            } else {
                menu.add(0, 12, 0, R.string.attach_record_sound).setIcon(R.drawable.ic_menu_add_sound);
            }
        }
        if (c3869o.m14867g()) {
            menu.add(0, 8, 0, R.string.remove_video).setIcon(R.drawable.ic_menu_remove_video);
        } else if (!c3869o.m14865f() && !c3869o.m14863e()) {
            menu.add(0, 6, 0, R.string.add_video).setIcon(R.drawable.ic_menu_movie);
            menu.add(0, 14, 0, R.string.attach_record_video).setIcon(R.drawable.ic_menu_movie);
        }
        menu.add(0, 7, 0, R.string.add_slide).setIcon(R.drawable.ic_menu_add_slide);
        menu.add(0, 10, 0, getResources().getString(R.string.duration_sec).replace("%s", String.valueOf(c3869o.m14849a() / 1000))).setIcon(R.drawable.ic_menu_duration);
        if (this.f15110i.m14913d().m14796g() == 1) {
            i = R.string.layout_top;
        } else {
            i = R.string.layout_bottom;
        }
        menu.add(0, 9, 0, i).setIcon(R.drawable.ic_menu_picture);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws Resources.NotFoundException {
        switch (menuItem.getItemId()) {
            case 0:
                C3869o c3869o = this.f15110i.get(this.f15114m);
                if (c3869o != null) {
                    c3869o.m14870j();
                }
                return true;
            case 1:
                Intent intent = new Intent("android.intent.action.GET_CONTENT", (Uri) null);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
                return true;
            case 2:
                Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                intent2.putExtra("output", TempFileProvider.f13544a);
                startActivityForResult(intent2, 2);
                return true;
            case 3:
                this.f15111j.m16497c(this.f15114m);
                m16186a(R.string.add_picture);
                return true;
            case 4:
                C4149cd.m16399a((Context) this, 3);
                return true;
            case 5:
                this.f15111j.m16499e(this.f15114m);
                return true;
            case 6:
                Intent intent3 = new Intent("android.intent.action.GET_CONTENT");
                intent3.setType("video/*");
                intent3.putExtra("android.intent.extra.LOCAL_ONLY", true);
                startActivityForResult(intent3, 5);
                return true;
            case 7:
                this.f15114m++;
                if (this.f15111j.m16492a(this.f15114m)) {
                    m16199e();
                } else {
                    this.f15114m--;
                    Toast.makeText(this, R.string.cannot_add_slide_anymore, 0).show();
                }
                return true;
            case 8:
                this.f15111j.m16498d(this.f15114m);
                return true;
            case 9:
                m16198d();
                return true;
            case 10:
                m16196c();
                return true;
            case 11:
                m16185a();
                return true;
            case 12:
                C4149cd.m16400a(this, 4, PluginComposeMessageActivity.m15923a(this.f15110i, this.f15110i.get(this.f15114m).m14855b()));
                return true;
            case 13:
            default:
                return true;
            case 14:
                long jM15923a = PluginComposeMessageActivity.m15923a(this.f15110i, this.f15110i.get(this.f15114m).m14855b());
                if (jM15923a > 0) {
                    C4149cd.m16422b(this, 7, jM15923a);
                } else {
                    Toast.makeText(this, getString(R.string.message_too_big_for_video), 0).show();
                }
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16186a(int i) {
        this.f15105d.setText(i);
    }

    /* renamed from: c */
    private void m16196c() throws Resources.NotFoundException {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_mms_duration);
        builder.setTitle(getResources().getString(R.string.duration_selector_title) + (this.f15114m + 1) + "/" + this.f15110i.size());
        builder.setItems(R.array.select_dialog_items, new DialogInterfaceOnClickListenerC4309ib(this));
        builder.show();
    }

    /* renamed from: d */
    private void m16198d() throws Resources.NotFoundException {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_mms_layout);
        builder.setTitle(getResources().getString(R.string.layout_selector_title) + (this.f15114m + 1) + "/" + this.f15110i.size());
        builder.setAdapter(new C4093ab(this), new DialogInterfaceOnClickListenerC4299hs(this));
        builder.show();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onActivityResult(int r9, int r10, android.content.Intent r11) {
        /*
            Method dump skipped, instructions count: 578
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p112ui.SlideEditorActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m16192b(int i) {
        return getResources().getString(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16189a(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m16199e() {
        this.f15112k.setLocation(this.f15114m);
        this.f15112k.present();
        m16193b();
        if (this.f15110i.get(this.f15114m).m14863e()) {
            m16186a(R.string.replace_image);
        } else {
            m16186a(R.string.add_picture);
        }
    }
}
