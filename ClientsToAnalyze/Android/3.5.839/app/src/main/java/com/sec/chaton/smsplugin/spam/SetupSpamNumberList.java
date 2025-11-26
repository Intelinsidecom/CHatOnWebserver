package com.sec.chaton.smsplugin.spam;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
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
import com.android.i18n.phonenumbers.NumberParseException;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.privateplugin.data.SetSpamReq;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.privateplugin.p088a.C3033b;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.chaton.smsplugin.p112ui.ThreadSelectionActivity;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4810ab;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4865cc;
import com.sec.chaton.util.C4880cr;
import com.sec.chaton.util.EnumC4868cf;
import com.sec.common.p123a.AbstractC4932a;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(14)
/* loaded from: classes.dex */
public class SetupSpamNumberList extends BaseActivity {

    /* renamed from: r */
    private static final Intent f14343r = new Intent("android.intent.action.GET_CONTENT");

    /* renamed from: A */
    private int f14344A;

    /* renamed from: C */
    private C3999bc f14346C;

    /* renamed from: H */
    private LinearLayout f14351H;

    /* renamed from: I */
    private TextView f14352I;

    /* renamed from: J */
    private ActionBar f14353J;

    /* renamed from: O */
    private boolean f14358O;

    /* renamed from: q */
    private C4000bd f14367q;

    /* renamed from: v */
    private int f14371v;

    /* renamed from: w */
    private View f14372w;

    /* renamed from: x */
    private ListView f14373x;

    /* renamed from: y */
    private CheckBox f14374y;

    /* renamed from: z */
    private LinearLayout f14375z;

    /* renamed from: p */
    private final ArrayList<C4017bu> f14366p = new ArrayList<>();

    /* renamed from: s */
    private final int f14368s = 0;

    /* renamed from: t */
    private final int f14369t = 1;

    /* renamed from: u */
    private int f14370u = 0;

    /* renamed from: B */
    private String f14345B = null;

    /* renamed from: D */
    private final int f14347D = 100;

    /* renamed from: E */
    private boolean f14348E = false;

    /* renamed from: F */
    private AlertDialog f14349F = null;

    /* renamed from: G */
    private C4810ab f14350G = null;

    /* renamed from: K */
    private LinearLayout f14354K = null;

    /* renamed from: L */
    private TextView f14355L = null;

    /* renamed from: M */
    private TextView f14356M = null;

    /* renamed from: N */
    private TextView f14357N = null;

    /* renamed from: P */
    private MenuItem f14359P = null;

    /* renamed from: Q */
    private MenuItem f14360Q = null;

    /* renamed from: R */
    private MenuItem f14361R = null;

    /* renamed from: S */
    private ProgressDialog f14362S = null;

    /* renamed from: n */
    Handler f14364n = new HandlerC3982am(this);

    /* renamed from: T */
    private final ContentObserver f14363T = new C3989at(this, this.f14364n);

    /* renamed from: o */
    public final Handler f14365o = new HandlerC3988as(this);

    static {
        f14343r.setType("vnd.android.cursor.item/phone_v2");
    }

    /* renamed from: g */
    private void m15384g() {
        if (this.f14346C == null) {
            this.f14346C = new C3999bc(this, null);
            C3890m.m14996b("Mms/SetupSpamNumberList", "ID of contactQueryThread = " + this.f14346C.getId());
            this.f14346C.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m15386h() {
        if (this.f14346C != null) {
            this.f14346C.interrupt();
            this.f14346C = null;
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C3890m.m14996b("Mms/SetupSpamNumberList", "onCreate ");
        super.onCreate(bundle);
        this.f14345B = getResources().getString(R.string.unknown);
        setContentView(R.layout.setup_spam_number_list);
        this.f14351H = (LinearLayout) findViewById(R.id.empty_spamkeyword);
        this.f14352I = (TextView) findViewById(R.id.empty_spamkeywordstring);
        if (bundle != null) {
            this.f14371v = bundle.getInt("blacklist_id", 0);
        }
        this.f14353J = getActionBar();
        this.f14350G = C4809aa.m18104a();
        m15387i();
        m15390j();
        getContentResolver().registerContentObserver(C4012bp.f14468d, true, this.f14363T);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        getContentResolver().unregisterContentObserver(this.f14363T);
        m15397n();
        if (this.f14353J != null) {
            this.f14353J = null;
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C3890m.m14996b("Mms/SetupSpamNumberList", "onSaveInstanceState ");
        bundle.putInt("blacklist_id", this.f14371v);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        C3890m.m14996b("Mms/SetupSpamNumberList", "onRestoreInstanceState ");
        if (bundle != null) {
            this.f14371v = bundle.getInt("blacklist_id", 0);
        }
        C3890m.m14996b("Mms/SetupSpamNumberList", "mSelectedItem " + this.f14371v);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C3890m.m14996b("Mms/SetupSpamNumberList", "onResume ");
        if (this.f14348E) {
            removeDialog(100);
            if (this.f14349F != null && this.f14349F.isShowing()) {
                this.f14349F.dismiss();
                this.f14349F = null;
            }
            m15390j();
            this.f14373x.setSelected(true);
            this.f14373x.setSelection(this.f14373x.getCount());
            this.f14348E = false;
            return;
        }
        m15384g();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        C3890m.m14996b("Mms/SetupSpamNumberList", "onPause ");
        m15386h();
    }

    /* renamed from: i */
    private void m15387i() {
        this.f14373x = (ListView) findViewById(R.id.list);
        this.f14372w = getLayoutInflater().inflate(R.layout.spam_list_header, (ViewGroup) this.f14373x, false);
        this.f14375z = (LinearLayout) this.f14372w.findViewById(R.id.list_selectall);
        this.f14374y = (CheckBox) this.f14372w.findViewById(R.id.selectall_checkbox);
        this.f14375z.setOnClickListener(new ViewOnClickListenerC3990au(this));
        this.f14373x.setOnItemClickListener(new C3991av(this));
        this.f14373x.addHeaderView(this.f14372w, null, true);
    }

    public void softkeyLeftRun(View view) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this);
        abstractC4932aM18733a.mo18734a(R.string.delete_message);
        abstractC4932aM18733a.mo18753c(android.R.drawable.ic_dialog_alert);
        abstractC4932aM18733a.mo18751b(true);
        abstractC4932aM18733a.mo18746b(R.string.selected_items_deleted);
        abstractC4932aM18733a.mo18756d(android.R.string.ok, new DialogInterfaceOnClickListenerC3992aw(this));
        abstractC4932aM18733a.mo18747b(android.R.string.cancel, (DialogInterface.OnClickListener) null);
        abstractC4932aM18733a.mo18752b();
    }

    public void softkeyRightRun(View view) {
        this.f14364n.postDelayed(new RunnableC3994ay(this), 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m15390j() {
        m15378c("makeScreen : ScreenType = " + this.f14370u);
        this.f14366p.clear();
        if (this.f14370u == 0) {
            boolean zBooleanValue = this.f14350G.m18119a("pref_key_spam_option_unknown_num", (Boolean) false).booleanValue();
            if (C3847e.m14672ad()) {
                this.f14366p.add(new C4017bu(-1, 0, zBooleanValue, getString(R.string.unknown), 0));
            }
        }
        Cursor cursorM15370b = m15370b(0);
        int count = cursorM15370b != null ? cursorM15370b.getCount() : 0;
        if (cursorM15370b != null && cursorM15370b.moveToFirst()) {
            do {
                this.f14366p.add(new C4017bu(cursorM15370b.getInt(0), 0, cursorM15370b.getInt(2) != 0, cursorM15370b.getString(3), cursorM15370b.getInt(4)));
            } while (cursorM15370b.moveToNext());
        }
        if (cursorM15370b != null) {
            cursorM15370b.close();
        }
        if (this.f14370u == 0) {
            this.f14375z.setVisibility(8);
        } else {
            this.f14375z.setVisibility(0);
            this.f14374y.setChecked(false);
            this.f14373x.clearChoices();
            this.f14373x.setChoiceMode(2);
        }
        this.f14353J.setDisplayHomeAsUpEnabled(true);
        this.f14353J.setDisplayShowCustomEnabled(true);
        this.f14344A = this.f14373x.getHeaderViewsCount();
        if (count <= 0) {
            this.f14351H.setVisibility(0);
            if (!C3847e.m14672ad()) {
                this.f14373x.setVisibility(8);
            }
            this.f14352I.setText(R.string.number_not_found);
        } else {
            this.f14351H.setVisibility(8);
            if (!C3847e.m14672ad()) {
                this.f14373x.setVisibility(0);
            }
        }
        if (this.f14367q == null) {
            this.f14367q = new C4000bd(this, this, this.f14366p);
        }
        this.f14373x.setAdapter((ListAdapter) this.f14367q);
        m15396m();
        m15384g();
        mo51u_();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportPrepareOptionsMenu(Menu menu) {
        menu.clear();
        if (this.f14370u == 0) {
            this.f14359P = menu.add(0, 1, 1, R.string.Add);
            this.f14359P.setIcon(R.drawable.actionbar_ic_add);
            this.f14359P.setShowAsAction(2);
            this.f14359P = menu.add(0, 2, 2, R.string.delete);
            this.f14359P.setIcon(R.drawable.actionbar_ic_delete);
            this.f14359P.setShowAsAction(2);
            if (this.f14366p.size() > 0) {
                this.f14359P.setEnabled(true);
            } else {
                this.f14359P.setEnabled(false);
            }
            C4880cr.m18523a(this.f14359P);
        } else {
            this.f14360Q = menu.add(0, 3, 0, R.string.cancel);
            this.f14360Q.setShowAsAction(2);
            this.f14361R = menu.add(0, 2, 1, R.string.done);
            this.f14361R.setShowAsAction(2);
            this.f14361R.setEnabled(false);
        }
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                this.f14371v = 0;
                Intent intent = new Intent(this, (Class<?>) ThreadSelectionActivity.class);
                intent.putExtra("except_broadcast", true);
                startActivityForResult(intent, 3);
                return true;
            case 2:
                if (this.f14370u == 0) {
                    this.f14370u = 1;
                    m15390j();
                    return true;
                }
                if (this.f14370u != 1) {
                    return true;
                }
                softkeyLeftRun(null);
                return true;
            case 3:
                softkeyRightRun(null);
                return true;
            case android.R.id.home:
                if (this.f14370u == 1) {
                    this.f14370u = 0;
                    m15390j();
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
                C3890m.m14996b("Mms/SetupSpamNumberList", "mSelectedItem " + this.f14371v);
                builder.setTitle(this.f14366p.get(this.f14371v).m15458c());
                builder.setItems(charSequenceArr, new DialogInterfaceOnClickListenerC3995az(this));
                AlertDialog alertDialogCreate = builder.create();
                alertDialogCreate.setOnDismissListener(new DialogInterfaceOnDismissListenerC3997ba(this));
                return alertDialogCreate;
            default:
                return null;
        }
    }

    /* renamed from: f */
    public void m15402f() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.confirm_delete_spam_number)).setIcon(android.R.drawable.ic_dialog_alert).setTitle(R.string.delete_message).setPositiveButton(R.string.ok, new DialogInterfaceOnClickListenerC3983an(this)).setNegativeButton(R.string.cancel, new DialogInterfaceOnClickListenerC3998bb(this));
        this.f14349F = builder.create();
        this.f14349F.setOnDismissListener(new DialogInterfaceOnDismissListenerC3984ao(this));
        this.f14349F.show();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f14358O = getResources().getConfiguration().orientation == 2;
        m15400o();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        LinearLayout linearLayout;
        switch (i) {
            case 4:
                if (this.f14370u == 1) {
                    this.f14370u = 0;
                    m15390j();
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
                    C3890m.m14995a("Mms/SetupSpamNumberList", "Unexpected ClassCastException.", e);
                    return false;
                }
                break;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 3:
                if (i2 == -1) {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("selected_numbers");
                    if (stringArrayListExtra != null) {
                        Iterator<String> it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            C4149cd.m16434e(getApplicationContext(), next);
                            if (C3847e.m14651aB()) {
                                Spam spam = new Spam();
                                spam.setCat(Spam.CATEGORY_DEFAULT).setAct(Spam.ACTIVITY_REPORT);
                                spam.setNum(next);
                                spam.setMsg("");
                                SetSpamReq setSpamReq = new SetSpamReq();
                                try {
                                    PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
                                    setSpamReq.setMsisdn(phoneNumberUtil.format(phoneNumberUtil.parse(C4822an.m18234f(), C4822an.m18236g().toUpperCase()), PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL)).setImei(C4822an.m18228d()).setImsi(C4822an.m18238h());
                                    setSpamReq.setSpam(spam);
                                    new Thread(new C3033b(C4865cc.m18450b(EnumC4868cf.CONTACT), 33947648, setSpamReq, this.f14365o)).start();
                                    m15377c(R.string.wait_sending);
                                } catch (NumberParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    softkeyRightRun(null);
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15364a(int i) {
        getContentResolver().delete(Uri.withAppendedPath(C4012bp.f14468d, Integer.toString(i)), null, null);
        C4015bs.m15432a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15368a(String str, boolean z, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("filter", str);
        contentValues.put("enable", Integer.valueOf(!z ? 0 : 1));
        getContentResolver().update(Uri.withAppendedPath(C4012bp.f14468d, Integer.toString(i)), contentValues, null, null);
        C4015bs.m15435a(i, str, z);
    }

    /* renamed from: b */
    private Cursor m15370b(int i) {
        return getContentResolver().query(C4012bp.f14468d, null, "filter_type = " + i, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m15391k() {
        int iM15454a = this.f14366p.get(this.f14371v).m15454a();
        Intent intent = new Intent(this, (Class<?>) SetupSpamNumberWriteForm.class);
        intent.putExtra("UPDATE_ID", iM15454a);
        intent.putExtra("SELECT_NUMBER", this.f14366p.get(this.f14371v).m15458c());
        intent.putExtra("MATCH_MODE", this.f14366p.get(this.f14371v).m15459d());
        intent.putExtra("UPDATE_MODE", true);
        startActivityForResult(intent, 3);
    }

    public void autoreject_delete_items(View view) {
        m15374b("Delete softkey clicked !!");
    }

    public void autoreject_delete_cancel(View view) {
        m15374b("Cancel softkey clicked !!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m15374b(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m15393l() {
        int i = 0;
        for (int i2 = 0; i2 < this.f14373x.getCount() - this.f14344A; i2++) {
            if (this.f14373x.isItemChecked(this.f14344A + i2)) {
                i++;
            }
        }
        this.f14374y.setChecked(i == this.f14366p.size());
        if (this.f14370u == 1 && this.f14361R != null) {
            if (i > 0) {
                this.f14361R.setEnabled(true);
            } else {
                this.f14361R.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m15378c(String str) {
        C3890m.m14997c("Mms/SetupSpamNumberList", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m15396m() {
        String string = null;
        if (C3847e.m14672ad()) {
            string = getString(R.string.pref_title_spam_num_add);
        } else if (this.f14370u == 0) {
            string = getString(R.string.pref_title_manage_spam_numbers);
        } else if (this.f14370u == 1) {
            string = getString(R.string.setting_delete_account_delete);
        }
        setTitle(string);
    }

    /* renamed from: n */
    private void m15397n() {
        if (this.f14356M != null) {
            this.f14356M.setOnClickListener(null);
            this.f14356M = null;
        }
        if (this.f14355L != null) {
            this.f14355L.setOnClickListener(null);
            this.f14355L = null;
        }
        if (this.f14354K != null) {
            this.f14354K.removeAllViewsInLayout();
            this.f14354K = null;
        }
    }

    /* renamed from: o */
    private void m15400o() {
        if (this.f14354K == null) {
            this.f14354K = (LinearLayout) getLayoutInflater().inflate(R.layout.spam_list_actionbar, (ViewGroup) null);
            this.f14355L = (TextView) this.f14354K.findViewById(R.id.spam_list_actionbar_delete_done_btn);
            this.f14356M = (TextView) this.f14354K.findViewById(R.id.spam_list_actionbar_delete_cancel_btn);
            this.f14357N = (TextView) this.f14354K.findViewById(R.id.spam_list_actionbar_title);
            this.f14357N.setText(getString(R.string.menu_unregister_as_spamnumber));
            this.f14355L.setOnClickListener(new ViewOnClickListenerC3985ap(this));
            this.f14356M.setOnClickListener(new ViewOnClickListenerC3986aq(this));
        }
        m15393l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m15377c(int i) {
        if (this.f14362S == null) {
            this.f14362S = new ProgressDialog(this);
            this.f14362S.setIndeterminate(true);
            this.f14362S.setCancelable(false);
            this.f14362S.setMessage(getString(i));
            this.f14362S.setOnKeyListener(new DialogInterfaceOnKeyListenerC3987ar(this));
            this.f14362S.show();
        }
    }
}
