package com.sec.chaton.smsplugin.p112ui;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p110g.C3870p;
import com.sec.chaton.smsplugin.p110g.InterfaceC3860f;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5086i;
import com.sec.google.android.p134a.p135a.C5097t;

/* loaded from: classes.dex */
public class SlideshowEditActivity extends ListActivity {

    /* renamed from: a */
    private ListView f15154a;

    /* renamed from: b */
    private C4322io f15155b;

    /* renamed from: e */
    private Bundle f15158e;

    /* renamed from: f */
    private Uri f15159f;

    /* renamed from: g */
    private Intent f15160g;

    /* renamed from: h */
    private boolean f15161h;

    /* renamed from: i */
    private View f15162i;

    /* renamed from: c */
    private C3870p f15156c = null;

    /* renamed from: d */
    private C4323ip f15157d = null;

    /* renamed from: j */
    private final InterfaceC3860f f15163j = new C4321in(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15154a = getListView();
        this.f15162i = m16232a();
        this.f15154a.addFooterView(this.f15162i);
        this.f15162i.setVisibility(8);
        if (bundle != null) {
            this.f15158e = bundle.getBundle("state");
        }
        if (this.f15158e != null) {
            this.f15159f = Uri.parse(this.f15158e.getString("message_uri"));
        } else {
            this.f15159f = getIntent().getData();
        }
        if (this.f15159f == null) {
            C3890m.m14999e("SlideshowEditActivity", "Cannot startup activity, null Uri.");
            finish();
            return;
        }
        this.f15160g = new Intent();
        this.f15160g.setData(this.f15159f);
        try {
            m16237c();
            m16238d();
        } catch (C5111c e) {
            C3890m.m14995a("SlideshowEditActivity", "Failed to initialize the slide-list.", e);
            finish();
        }
    }

    /* renamed from: a */
    private View m16232a() {
        View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.slideshow_edit_item, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.slide_number_text)).setText(R.string.add_slide);
        TextView textView = (TextView) viewInflate.findViewById(R.id.text_preview);
        textView.setText(R.string.add_slide_hint);
        textView.setVisibility(0);
        ((ImageView) viewInflate.findViewById(R.id.image_preview)).setImageResource(R.drawable.ic_attach_slideshow_holo_light);
        return viewInflate;
    }

    @Override // android.app.ListActivity
    protected void onListItemClick(ListView listView, View view, int i, long j) {
        if (i == listView.getCount() - 1) {
            m16239e();
        } else {
            m16233a(i);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f15158e != null) {
            this.f15154a.setSelection(this.f15158e.getInt("slide_index", 0));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f15158e = new Bundle();
        if (this.f15154a.getSelectedItemPosition() >= 0) {
            this.f15158e.putInt("slide_index", this.f15154a.getSelectedItemPosition());
        }
        if (this.f15159f != null) {
            this.f15158e.putString("message_uri", this.f15159f.toString());
        }
        bundle.putBundle("state", this.f15158e);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        synchronized (this) {
            if (this.f15161h) {
                try {
                    C5086i c5086iM14899a = this.f15156c.m14899a();
                    C5097t.m19426a(this).m19450a(this.f15159f, c5086iM14899a);
                    this.f15156c.m14905a(c5086iM14899a);
                } catch (C5111c e) {
                    C3890m.m14995a("SlideshowEditActivity", "Cannot update the message: " + this.f15159f, e);
                }
            }
        }
    }

    @Override // android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        m16235b();
    }

    /* renamed from: b */
    private void m16235b() {
        if (this.f15156c != null) {
            this.f15156c.m14835d(this.f15163j);
            this.f15156c = null;
        }
    }

    /* renamed from: c */
    private void m16237c() {
        m16235b();
        this.f15156c = C3870p.m14881a(this, this.f15159f);
        this.f15156c.m14834c(this.f15163j);
        this.f15157d = new C4323ip(this, this.f15156c);
        this.f15155b = new C4322io(this, R.layout.slideshow_edit_item, this.f15156c);
        this.f15154a.setAdapter((ListAdapter) this.f15155b);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        int selectedItemPosition = this.f15154a.getSelectedItemPosition();
        if (selectedItemPosition >= 0 && selectedItemPosition != this.f15154a.getCount() - 1) {
            if (selectedItemPosition > 0) {
                menu.add(0, 0, 0, R.string.move_up).setIcon(R.drawable.ic_menu_move_up);
            }
            if (selectedItemPosition < this.f15155b.getCount() - 1) {
                menu.add(0, 1, 0, R.string.move_down).setIcon(R.drawable.ic_menu_move_down);
            }
            menu.add(0, 3, 0, R.string.add_slide).setIcon(R.drawable.ic_menu_add_slide);
            menu.add(0, 2, 0, R.string.remove_slide).setIcon(android.R.drawable.ic_menu_delete);
        } else {
            menu.add(0, 3, 0, R.string.add_slide).setIcon(R.drawable.ic_menu_add_slide);
        }
        menu.add(0, 4, 0, R.string.discard_slideshow).setIcon(R.drawable.ic_menu_delete_played);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int selectedItemPosition = this.f15154a.getSelectedItemPosition();
        switch (menuItem.getItemId()) {
            case 0:
                if (selectedItemPosition > 0 && selectedItemPosition < this.f15156c.size()) {
                    this.f15157d.m16500f(selectedItemPosition);
                    this.f15155b.notifyDataSetChanged();
                    this.f15154a.setSelection(selectedItemPosition - 1);
                    break;
                }
                break;
            case 1:
                if (selectedItemPosition >= 0 && selectedItemPosition < this.f15156c.size() - 1) {
                    this.f15157d.m16501g(selectedItemPosition);
                    this.f15155b.notifyDataSetChanged();
                    this.f15154a.setSelection(selectedItemPosition + 1);
                    break;
                }
                break;
            case 2:
                if (selectedItemPosition >= 0 && selectedItemPosition < this.f15156c.size()) {
                    this.f15157d.m16494b(selectedItemPosition);
                    this.f15155b.notifyDataSetChanged();
                    break;
                }
                break;
            case 3:
                m16239e();
                break;
            case 4:
                this.f15157d.m16493b();
                this.f15155b.notifyDataSetChanged();
                finish();
                break;
        }
        return true;
    }

    /* renamed from: a */
    private void m16233a(int i) {
        Intent intent = new Intent(this, (Class<?>) SlideEditorActivity.class);
        intent.setData(this.f15159f);
        intent.putExtra("slide_index", i);
        startActivityForResult(intent, 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m16238d() {
        if (this.f15156c.size() >= 10) {
            this.f15162i.setVisibility(8);
        } else {
            this.f15162i.setVisibility(0);
        }
    }

    /* renamed from: e */
    private void m16239e() {
        if (this.f15157d.m16491a()) {
            this.f15155b.notifyDataSetChanged();
            this.f15154a.requestFocus();
            this.f15154a.setSelection(this.f15156c.size() - 1);
            return;
        }
        Toast.makeText(this, R.string.cannot_add_slide_anymore, 0).show();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 6:
                    synchronized (this) {
                        this.f15161h = true;
                    }
                    setResult(-1, this.f15160g);
                    if (intent != null && intent.getBooleanExtra("done", false)) {
                        finish();
                        return;
                    }
                    try {
                        m16237c();
                        return;
                    } catch (C5111c e) {
                        C3890m.m14995a("SlideshowEditActivity", "Failed to initialize the slide-list.", e);
                        finish();
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
