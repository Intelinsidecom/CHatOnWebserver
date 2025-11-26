package com.sec.chaton.smsplugin.spam;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.util.ArrayList;

@TargetApi(14)
/* loaded from: classes.dex */
public class SetupSpamKeywordList extends Activity {

    /* renamed from: c */
    private C3971ab f14302c;

    /* renamed from: g */
    private int f14306g;

    /* renamed from: h */
    private View f14307h;

    /* renamed from: i */
    private ListView f14308i;

    /* renamed from: j */
    private CheckBox f14309j;

    /* renamed from: k */
    private LinearLayout f14310k;

    /* renamed from: l */
    private int f14311l;

    /* renamed from: o */
    private LinearLayout f14314o;

    /* renamed from: p */
    private TextView f14315p;

    /* renamed from: q */
    private ActionBar f14316q;

    /* renamed from: v */
    private boolean f14321v;

    /* renamed from: b */
    private ArrayList<C4017bu> f14301b = new ArrayList<>();

    /* renamed from: d */
    private final int f14303d = 0;

    /* renamed from: e */
    private final int f14304e = 1;

    /* renamed from: f */
    private int f14305f = 0;

    /* renamed from: m */
    private boolean f14312m = false;

    /* renamed from: n */
    private AlertDialog f14313n = null;

    /* renamed from: r */
    private LinearLayout f14317r = null;

    /* renamed from: s */
    private TextView f14318s = null;

    /* renamed from: t */
    private TextView f14319t = null;

    /* renamed from: u */
    private TextView f14320u = null;

    /* renamed from: w */
    private MenuItem f14322w = null;

    /* renamed from: x */
    private MenuItem f14323x = null;

    /* renamed from: y */
    private MenuItem f14324y = null;

    /* renamed from: a */
    Handler f14300a = new HandlerC4036n(this);

    /* renamed from: z */
    private ContentObserver f14325z = new C4041s(this, this.f14300a);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        C3890m.m14996b("Mms/SetupSpamKeywordList", "onCreate ");
        super.onCreate(bundle);
        setContentView(R.layout.setup_spam_keyword_list);
        this.f14314o = (LinearLayout) findViewById(R.id.empty_spamkeyword);
        this.f14315p = (TextView) findViewById(R.id.empty_spamkeywordstring);
        if (bundle != null) {
            this.f14306g = bundle.getInt("blacklist_id", 0);
        }
        this.f14316q = getActionBar();
        m15327b();
        m15332c();
        getContentResolver().registerContentObserver(C4012bp.f14468d, true, this.f14325z);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        getContentResolver().unregisterContentObserver(this.f14325z);
        m15340g();
        if (this.f14316q != null) {
            this.f14316q = null;
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C3890m.m14996b("Mms/SetupSpamKeywordList", "onSaveInstanceState");
        bundle.putInt("blacklist_id", this.f14306g);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        C3890m.m14996b("Mms/SetupSpamKeywordList", "onRestoreInstanceState");
        if (bundle != null) {
            this.f14306g = bundle.getInt("blacklist_id", 0);
        }
        C3890m.m14996b("Mms/SetupSpamKeywordList", "mSelectedItem " + this.f14306g);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        C3890m.m14996b("Mms/SetupSpamKeywordList", "onResume ");
        if (this.f14312m && this.f14305f == 0) {
            removeDialog(100);
            if (this.f14313n != null && this.f14313n.isShowing()) {
                this.f14313n.dismiss();
                this.f14313n = null;
            }
            m15332c();
            this.f14308i.setSelected(true);
            this.f14308i.setSelection(this.f14308i.getCount());
            this.f14312m = false;
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C3890m.m14996b("Mms/SetupSpamKeywordList", "onPause ");
    }

    /* renamed from: b */
    private void m15327b() {
        this.f14308i = (ListView) findViewById(R.id.list);
        this.f14307h = getLayoutInflater().inflate(R.layout.spam_list_header, (ViewGroup) this.f14308i, false);
        this.f14310k = (LinearLayout) this.f14307h.findViewById(R.id.list_selectall);
        this.f14309j = (CheckBox) this.f14307h.findViewById(R.id.selectall_checkbox);
        this.f14310k.setOnClickListener(new ViewOnClickListenerC4042t(this));
        this.f14308i.setOnItemClickListener(new C4043u(this));
        this.f14308i.addHeaderView(this.f14307h, null, true);
    }

    public void softkeyLeftRun(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirm_dialog_title);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setCancelable(true);
        builder.setMessage(R.string.confirm_delete_spam_words);
        builder.setPositiveButton(android.R.string.ok, new DialogInterfaceOnClickListenerC4044v(this));
        builder.setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void softkeyRightRun(View view) {
        this.f14300a.postDelayed(new RunnableC4046x(this), 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m15332c() {
        C3890m.m14996b("Mms/SetupSpamKeywordList", "makeScreen : ScreenType = " + this.f14305f);
        this.f14301b.clear();
        Cursor cursorM15325b = m15325b(1);
        int count = cursorM15325b != null ? cursorM15325b.getCount() : 0;
        if (cursorM15325b != null && cursorM15325b.moveToFirst()) {
            do {
                this.f14301b.add(new C4017bu(cursorM15325b.getInt(0), 1, cursorM15325b.getInt(2) != 0, cursorM15325b.getString(3), 0));
            } while (cursorM15325b.moveToNext());
        }
        if (cursorM15325b != null) {
            cursorM15325b.close();
        }
        if (this.f14305f == 0) {
            this.f14310k.setVisibility(8);
            m15340g();
            this.f14316q.setDisplayHomeAsUpEnabled(true);
            this.f14316q.setDisplayShowCustomEnabled(false);
        } else {
            this.f14310k.setVisibility(0);
            this.f14309j.setChecked(false);
            this.f14308i.clearChoices();
            this.f14308i.setChoiceMode(2);
            m15341h();
            this.f14316q.setCustomView(this.f14317r, new ActionBar.LayoutParams(-1, -1));
            this.f14316q.setDisplayHomeAsUpEnabled(true);
            this.f14316q.setDisplayShowCustomEnabled(true);
        }
        this.f14311l = this.f14308i.getHeaderViewsCount();
        if (count <= 0) {
            this.f14315p.setText(R.string.block_text_not_found);
            this.f14314o.setVisibility(0);
        } else {
            this.f14314o.setVisibility(8);
        }
        if (this.f14302c == null) {
            this.f14302c = new C3971ab(this, this, this.f14301b);
        }
        this.f14308i.setAdapter((ListAdapter) this.f14302c);
        m15338f();
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.clear();
        int size = this.f14301b != null ? this.f14301b.size() : 0;
        if (this.f14305f == 0) {
            this.f14322w = menu.add(0, 1, 0, R.string.Add);
            this.f14322w.setShowAsAction(2);
        } else {
            this.f14324y = menu.add(0, 3, 0, R.string.cancel);
            this.f14324y.setShowAsAction(2);
        }
        this.f14323x = menu.add(0, 2, 0, R.string.delete);
        this.f14323x.setShowAsAction(2);
        if (this.f14305f == 0 && size > 0) {
            this.f14323x.setEnabled(true);
        } else {
            this.f14323x.setEnabled(false);
        }
        if (this.f14305f == 0) {
            this.f14322w.setIcon(R.drawable.actionbar_list_icon_create);
        } else {
            this.f14324y.setIcon(R.drawable.selector_actionbar_delete_cancel_button);
        }
        this.f14323x.setIcon(R.drawable.actionbar_list_icon_delete);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                this.f14306g = 0;
                startActivityForResult(new Intent(this, (Class<?>) SetupSpamKeywordWriteForm.class), 3);
                return true;
            case 2:
                if (this.f14305f == 0) {
                    this.f14305f = 1;
                    m15332c();
                    return true;
                }
                if (this.f14305f != 1) {
                    return true;
                }
                softkeyLeftRun(null);
                return true;
            case 3:
                softkeyRightRun(null);
                return true;
            case android.R.id.home:
                if (this.f14305f == 1) {
                    this.f14305f = 0;
                    m15332c();
                    return true;
                }
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 100:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                CharSequence[] charSequenceArr = {getText(R.string.edit), getText(R.string.delete)};
                C3890m.m14996b("Mms/SetupSpamKeywordList", "mSelectedItem " + this.f14306g);
                builder.setTitle(this.f14301b.get(this.f14306g).m15458c());
                builder.setItems(charSequenceArr, new DialogInterfaceOnClickListenerC4047y(this));
                AlertDialog alertDialogCreate = builder.create();
                alertDialogCreate.setOnDismissListener(new DialogInterfaceOnDismissListenerC4048z(this));
                return alertDialogCreate;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public void m15347a() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.confirm_delete_spam_word)).setTitle(R.string.confirm_dialog_title).setIcon(android.R.drawable.ic_dialog_alert).setPositiveButton(R.string.ok, new DialogInterfaceOnClickListenerC4037o(this)).setNegativeButton(R.string.cancel, new DialogInterfaceOnClickListenerC3970aa(this));
        this.f14313n = builder.create();
        this.f14313n.setOnDismissListener(new DialogInterfaceOnDismissListenerC4038p(this));
        this.f14313n.show();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f14321v = getResources().getConfiguration().orientation == 2;
        m15341h();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        LinearLayout linearLayout;
        switch (i) {
            case 4:
                if (this.f14305f == 1) {
                    this.f14305f = 0;
                    m15332c();
                    return true;
                }
                break;
            case 23:
            case 66:
                try {
                    ListView listView = (ListView) getCurrentFocus();
                    if (listView != null && (linearLayout = (LinearLayout) listView.getSelectedView()) != null) {
                        CheckBox checkBox = (CheckBox) linearLayout.findViewById(R.id.autoreject_item_checkbox);
                        if (checkBox != null) {
                            checkBox.performClick();
                            break;
                        } else {
                            LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.list_create);
                            if (linearLayout2 != null && linearLayout2.isShown() && linearLayout2.isClickable()) {
                                linearLayout2.performClick();
                                break;
                            } else {
                                LinearLayout linearLayout3 = (LinearLayout) linearLayout.findViewById(R.id.list_selectall);
                                if (linearLayout3 != null && linearLayout3.isShown() && linearLayout3.isClickable()) {
                                    linearLayout3.performClick();
                                    break;
                                }
                            }
                        }
                    }
                } catch (ClassCastException e) {
                    C3890m.m14995a("Mms/SetupSpamKeywordList", "Unexpected ClassCastException.", e);
                    return false;
                }
                break;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 3:
                if (i2 == -1) {
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15317a(int i) {
        getContentResolver().delete(Uri.withAppendedPath(C4012bp.f14468d, Integer.toString(i)), null, null);
        C4015bs.m15432a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15321a(C4017bu c4017bu) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("filter", c4017bu.m15458c());
        contentValues.put("enable", Integer.valueOf(!c4017bu.m15457b() ? 0 : 1));
        getContentResolver().update(Uri.withAppendedPath(C4012bp.f14468d, Integer.toString(c4017bu.m15454a())), contentValues, null, null);
        C4015bs.m15435a(c4017bu.m15454a(), c4017bu.m15458c(), c4017bu.m15457b());
    }

    /* renamed from: b */
    private Cursor m15325b(int i) {
        return getContentResolver().query(C4012bp.f14468d, null, "filter_type = " + i, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m15334d() {
        int iM15454a = this.f14301b.get(this.f14306g).m15454a();
        Intent intent = new Intent(this, (Class<?>) SetupSpamKeywordWriteForm.class);
        intent.putExtra("UPDATE_ID", iM15454a);
        intent.putExtra("SpamWord", this.f14301b.get(this.f14306g).m15458c());
        intent.putExtra("UPDATE_MODE", true);
        startActivityForResult(intent, 3);
    }

    public void autoreject_delete_items(View view) {
        m15322a("Delete softkey clicked !!");
    }

    public void autoreject_delete_cancel(View view) {
        m15322a("Cancel softkey clicked !!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15322a(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m15335e() {
        int i = 0;
        for (int i2 = 0; i2 < this.f14308i.getCount() - this.f14311l; i2++) {
            if (this.f14308i.isItemChecked(this.f14311l + i2)) {
                i++;
            }
        }
        this.f14309j.setChecked(i == this.f14301b.size());
        invalidateOptionsMenu();
        if (this.f14318s != null) {
            this.f14318s.setVisibility(8);
        }
        if (this.f14319t != null) {
            this.f14319t.setVisibility(8);
        }
        if (this.f14322w != null) {
            if (this.f14321v) {
                this.f14322w.setIcon(R.drawable.actionbar_list_icon_create);
            } else {
                this.f14322w.setIcon(0);
            }
        }
        if (this.f14305f == 1 && this.f14323x != null) {
            this.f14323x.setIcon(R.drawable.actionbar_list_icon_delete);
            if (i > 0) {
                this.f14323x.setEnabled(true);
            } else {
                this.f14323x.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m15329b(String str) {
        C3890m.m14997c("Mms/SetupSpamKeywordList", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m15338f() {
        String string;
        if (C3847e.m14672ad()) {
            string = getString(R.string.pref_title_spam_text_add);
        } else {
            string = getString(R.string.spam_keyword_blockphrases);
        }
        setTitle(string);
    }

    /* renamed from: g */
    private void m15340g() {
        if (this.f14319t != null) {
            this.f14319t.setOnClickListener(null);
            this.f14319t = null;
        }
        if (this.f14318s != null) {
            this.f14318s.setOnClickListener(null);
            this.f14318s = null;
        }
        if (this.f14317r != null) {
            this.f14317r.removeAllViewsInLayout();
            this.f14317r = null;
        }
    }

    /* renamed from: h */
    private void m15341h() {
        if (this.f14317r == null) {
            this.f14317r = (LinearLayout) getLayoutInflater().inflate(R.layout.spam_list_actionbar, (ViewGroup) null);
            this.f14318s = (TextView) this.f14317r.findViewById(R.id.spam_list_actionbar_delete_done_btn);
            this.f14319t = (TextView) this.f14317r.findViewById(R.id.spam_list_actionbar_delete_cancel_btn);
            this.f14320u = (TextView) this.f14317r.findViewById(R.id.spam_list_actionbar_title);
            this.f14320u.setText(getString(R.string.pref_title_spam_text_add));
            this.f14318s.setOnClickListener(new ViewOnClickListenerC4039q(this));
            this.f14319t.setOnClickListener(new ViewOnClickListenerC4040r(this));
        }
        m15335e();
    }
}
