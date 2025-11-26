package com.sec.chaton.userprofile;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.HomeTabFragment;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.control.MemoControl;
import com.sec.chaton.control.ProfileControl;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.memo.MemoAdapter;
import com.sec.chaton.settings.ActivitySettings;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.ChatOnGraphics;
import com.sec.chaton.util.ProfileImageLoader;
import com.sec.chaton.util.StorageStateInfoUtil;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.chaton.widget.SMSProgressBar;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class UserProfileFragment extends Fragment implements HomeTabFragment.OnTabChangeListener {

    /* renamed from: a */
    public static final String f3433a = UserProfileFragment.class.getSimpleName();

    /* renamed from: A */
    private RelativeLayout f3434A;

    /* renamed from: B */
    private ProfileImageView[] f3435B;

    /* renamed from: C */
    private TextView[] f3436C;

    /* renamed from: D */
    private ProgressDialog f3437D;

    /* renamed from: E */
    private ImageButton f3438E;

    /* renamed from: F */
    private ImageButton f3439F;

    /* renamed from: G */
    private ImageView f3440G;

    /* renamed from: H */
    private RelativeLayout f3441H;

    /* renamed from: I */
    private LinearLayout f3442I;

    /* renamed from: J */
    private String f3443J;

    /* renamed from: K */
    private String f3444K;

    /* renamed from: L */
    private String f3445L;

    /* renamed from: M */
    private String f3446M;

    /* renamed from: N */
    private String f3447N;

    /* renamed from: O */
    private boolean f3448O;

    /* renamed from: P */
    private boolean f3449P;

    /* renamed from: Q */
    private boolean f3450Q;

    /* renamed from: R */
    private Uri f3451R;

    /* renamed from: S */
    private InputMethodManager f3452S;

    /* renamed from: T */
    private String f3453T;

    /* renamed from: U */
    private LinearLayout f3454U;

    /* renamed from: V */
    private Context f3455V;

    /* renamed from: W */
    private MemoAdapter f3456W;

    /* renamed from: X */
    private ListView f3457X;

    /* renamed from: Y */
    private ArrayList f3458Y;

    /* renamed from: Z */
    private MemoControl f3459Z;

    /* renamed from: aa */
    private LayoutInflater f3460aa;

    /* renamed from: ab */
    private View f3461ab;

    /* renamed from: ac */
    private View f3462ac;

    /* renamed from: ad */
    private View[] f3463ad;

    /* renamed from: ae */
    private ProgressBar f3464ae;

    /* renamed from: af */
    private Button f3465af;

    /* renamed from: ag */
    private String f3466ag;

    /* renamed from: ah */
    private String f3467ah;

    /* renamed from: ai */
    private boolean f3468ai;

    /* renamed from: aj */
    private ArrayList f3469aj;

    /* renamed from: ak */
    private ArrayList f3470ak;

    /* renamed from: al */
    private ProgressDialog f3471al;

    /* renamed from: am */
    private HorizontalScrollView f3472am;

    /* renamed from: an */
    private LinearLayout f3473an;

    /* renamed from: ao */
    private NotifyingAsyncQueryHandler.AsyncQueryListener f3474ao;

    /* renamed from: ap */
    private Handler f3475ap;

    /* renamed from: f */
    String f3480f;

    /* renamed from: g */
    SharedPreferences.OnSharedPreferenceChangeListener f3481g;

    /* renamed from: h */
    AbsListView.OnScrollListener f3482h;

    /* renamed from: k */
    private File f3485k;

    /* renamed from: l */
    private File f3486l;

    /* renamed from: m */
    private int f3487m;

    /* renamed from: n */
    private int f3488n;

    /* renamed from: o */
    private boolean f3489o;

    /* renamed from: p */
    private boolean f3490p;

    /* renamed from: q */
    private File f3491q;

    /* renamed from: r */
    private String f3492r;

    /* renamed from: s */
    private Calendar f3493s;

    /* renamed from: t */
    private ProfileControl f3494t;

    /* renamed from: u */
    private NotifyingAsyncQueryHandler f3495u;

    /* renamed from: v */
    private ImageButton f3496v;

    /* renamed from: w */
    private TextView f3497w;

    /* renamed from: x */
    private TextView f3498x;

    /* renamed from: y */
    private TextView f3499y;

    /* renamed from: z */
    private TextView f3500z;

    /* renamed from: i */
    private SimpleDateFormat f3483i = new SimpleDateFormat("MM-dd");

    /* renamed from: j */
    private SimpleDateFormat f3484j = new SimpleDateFormat("MM dd");

    /* renamed from: b */
    SimpleDateFormat f3476b = new SimpleDateFormat("MM-dd");

    /* renamed from: c */
    SimpleDateFormat f3477c = new SimpleDateFormat("yyyy-MM-dd hh:mm");

    /* renamed from: d */
    SimpleDateFormat f3478d = new SimpleDateFormat("MM dd, yyyy");

    /* renamed from: e */
    SimpleDateFormat f3479e = new SimpleDateFormat("yyyy-MM-dd");

    public UserProfileFragment() {
        this.f3480f = StorageStateInfoUtil.m3677a() ? GlobalApplication.m2386d().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m2387e().getFilesDir().getAbsolutePath();
        this.f3485k = new File(this.f3480f + "/profile/");
        this.f3486l = GlobalApplication.m2387e().getFilesDir().getAbsoluteFile();
        this.f3489o = false;
        this.f3490p = false;
        this.f3492r = "";
        this.f3493s = Calendar.getInstance();
        this.f3448O = true;
        this.f3449P = false;
        this.f3450Q = true;
        this.f3458Y = new ArrayList();
        this.f3469aj = new ArrayList();
        this.f3470ak = new ArrayList();
        this.f3481g = new SharedPreferencesOnSharedPreferenceChangeListenerC0596t(this);
        this.f3474ao = new C0588l(this);
        this.f3475ap = new HandlerC0589m(this);
        this.f3482h = new C0587k(this);
    }

    /* renamed from: a */
    public static Bitmap m3385a(Context context, Uri uri, int i) throws IOException {
        Bitmap bitmapDecodeStream;
        File file = new File(uri.toString());
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i2 = i;
        FileInputStream fileInputStream = null;
        Bitmap bitmap = null;
        int iLog = 8;
        while (true) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            int i3 = iLog == 0 ? 0 : i2;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            fileInputStream = new FileInputStream(file);
            options.inSampleSize = (int) Math.pow(2.0d, iLog);
            bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream, null, options);
            if (bitmapDecodeStream != null) {
                iLog = iLog > 0 ? iLog - ((int) (Math.log(i3 / (bitmapDecodeStream.getWidth() > bitmapDecodeStream.getHeight() ? bitmapDecodeStream.getWidth() : bitmapDecodeStream.getHeight())) / Math.log(2.0d))) : 0;
                if (i3 <= 0 || bitmapDecodeStream.getWidth() >= i3 / 2 || bitmapDecodeStream.getHeight() >= i3 / 2) {
                    break;
                }
                i2 = i3;
                bitmap = bitmapDecodeStream;
            } else {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return null;
            }
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return bitmapDecodeStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3389a(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        if (this.f3473an != null) {
            this.f3473an.removeAllViews();
        }
        ArrayList arrayListM3394b = m3394b(cursor);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 30) {
                return;
            }
            if (arrayListM3394b.size() > i2) {
                BuddyItem buddyItem = (BuddyItem) arrayListM3394b.get(i2);
                m3431a(i2, buddyItem.m668a(), buddyItem.m673b());
            } else {
                m3431a(i2, "", "");
            }
            i = i2 + 1;
        }
    }

    /* renamed from: b */
    private ArrayList m3394b(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), "", !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), 0, "", false, cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false));
        }
        cursor.close();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m3403g() {
        this.f3494t = new ProfileControl(this.f3475ap);
        this.f3495u = new NotifyingAsyncQueryHandler(getActivity().getContentResolver(), this.f3474ao);
        this.f3452S = (InputMethodManager) getActivity().getSystemService("input_method");
        this.f3443J = ChatONPref.m3519a().getString("msisdn", "");
        this.f3444K = ChatONPref.m3519a().getString("Push Name", "");
        this.f3445L = ChatONPref.m3519a().getString("status_message", "");
        this.f3446M = ChatONPref.m3519a().getString("birthday", getResources().getString(C0062R.string.add_your_birthday));
        this.f3447N = ChatONPref.m3519a().getString("birthday_type", "");
    }

    /* renamed from: h */
    private void m3405h() {
        this.f3495u.startQuery(-1, null, ChatONContract.RelationTable.m2201a(), null, "relation_date = ? AND buddy_relation_hide = 'N'  AND relation_rank != 0 ", new String[]{new SimpleDateFormat("yyyy-MM-dd").format(new Date(Calendar.getInstance().getTimeInMillis()))}, "relation_rank ASC LIMIT 30");
    }

    /* renamed from: i */
    private void m3407i() {
        this.f3468ai = true;
        this.f3459Z.m2006a(this.f3443J);
    }

    /* renamed from: j */
    private void m3408j() {
        this.f3497w.setText("+" + this.f3443J);
        this.f3499y.setText(this.f3444K);
        this.f3498x.setText(this.f3445L);
        if (this.f3445L.length() != 0) {
            this.f3498x.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            this.f3498x.setPadding(11, 10, 11, 10);
        } else {
            this.f3498x.setCompoundDrawablesWithIntrinsicBounds(C0062R.drawable.mypage_status_input_background_xml, 0, 0, 0);
        }
        m3413l();
    }

    /* renamed from: k */
    private void m3411k() {
        this.f3496v.setOnClickListener(new ViewOnClickListenerC0598v(this));
        this.f3454U.setOnClickListener(new ViewOnClickListenerC0597u(this));
        this.f3439F.setOnClickListener(new ViewOnClickListenerC0600x(this));
        this.f3440G.setOnClickListener(new ViewOnClickListenerC0599w(this));
        this.f3442I.setOnClickListener(new ViewOnClickListenerC0602z(this));
    }

    /* renamed from: l */
    private void m3413l() {
        new Date();
        if (this.f3447N.equals("FULL")) {
            try {
                this.f3479e.parse(this.f3446M);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.f3500z.setText(UserProfileDetail.m3354a(this.f3446M));
            return;
        }
        if (!this.f3447N.equals("SHORT")) {
            if (this.f3446M.equals(getResources().getString(C0062R.string.add_your_birthday))) {
                this.f3500z.setText(getResources().getString(C0062R.string.add_your_birthday));
                return;
            } else {
                this.f3500z.setText(getResources().getString(C0062R.string.add_your_birthday));
                return;
            }
        }
        String[] strArrSplit = this.f3446M.split("-");
        String str = strArrSplit[1] + "-" + strArrSplit[2];
        try {
            this.f3483i.parse(str);
        } catch (ParseException e2) {
            ChatONLogWriter.m3501a(e2, getClass().getSimpleName());
        }
        this.f3500z.setText(UserProfileDetail.m3354a(str));
    }

    /* renamed from: m */
    private void m3414m() {
        try {
            this.f3496v.setImageResource(C0062R.drawable.co_default_image_add);
            ProfileImageLoader.m3610a(GlobalApplication.m2387e()).m3625a(this.f3443J);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: n */
    private void m3417n() {
        if (!m3434e() || !m3435f()) {
            ChatONLogWriter.m3499a("[deleteTempFolder] External Storage Is Not Available or Writable!", f3433a);
            return;
        }
        String[] list = new File(ChatOnGraphics.f3636b).list();
        if (list != null) {
            for (String str : list) {
                ChatONLogWriter.m3506b("[Delete File] " + ChatOnGraphics.f3636b + str + " : " + new File(ChatOnGraphics.f3636b + str).delete(), f3433a);
            }
        }
    }

    /* renamed from: o */
    private void m3419o() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f3489o = true;
            this.f3490p = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f3489o = true;
            this.f3490p = false;
        } else {
            this.f3489o = false;
            this.f3490p = false;
        }
    }

    @Override // com.sec.chaton.HomeTabFragment.OnTabChangeListener
    /* renamed from: a */
    public void mo390a() {
        setHasOptionsMenu(true);
        m3405h();
        m3407i();
    }

    /* renamed from: a */
    public void m3431a(int i, String str, String str2) {
        if (this.f3472am == null || this.f3473an == null) {
            return;
        }
        if (str2.length() > 20) {
            String str3 = str2.substring(0, 20) + "...";
        }
        this.f3463ad[i] = this.f3460aa.inflate(C0062R.layout.user_profile_item, (ViewGroup) null);
        this.f3435B[i] = (ProfileImageView) this.f3463ad[i].findViewById(C0062R.id.imgfriend1);
        this.f3436C[i] = (TextView) this.f3463ad[i].findViewById(C0062R.id.textfriend1);
        if (str == null || str.equals("")) {
            this.f3473an.addView(this.f3463ad[i], -2, -1);
            return;
        }
        this.f3435B[i].setClickable(true);
        this.f3436C[i].setText(str2);
        ProfileImageLoader.m3610a(getActivity()).m3623a(this.f3435B[i], str);
        this.f3435B[i].setOnClickListener(new ViewOnClickListenerC0595s(this, str, str2));
        this.f3473an.addView(this.f3463ad[i], -2, -1);
    }

    @Override // com.sec.chaton.HomeTabFragment.OnTabChangeListener
    /* renamed from: b */
    public void mo391b() {
        setHasOptionsMenu(false);
    }

    /* renamed from: c */
    public void m3432c() {
        ChatONLogWriter.m3511e("UserProfile initialize() - img status: " + ChatONPref.m3519a().getString("profile_image_status", ""), f3433a);
        if (!ChatONPref.m3519a().getString("profile_image_status", "").equals("updated")) {
            m3414m();
            return;
        }
        File file = new File(this.f3486l, "myprofile.png_");
        ChatONLogWriter.m3506b("photoFile=" + file, getClass().getSimpleName());
        if (file.exists()) {
            new AsyncTaskC0601y(this, file).execute(new Void[0]);
        }
    }

    /* renamed from: d */
    public void m3433d() {
        try {
            if (!this.f3485k.canRead()) {
                this.f3485k.mkdirs();
            }
            m3417n();
            this.f3492r = "tmp_" + System.currentTimeMillis() + ".jpeg_";
            this.f3491q = new File(this.f3485k + "/", this.f3492r);
            ChatONLogWriter.m3506b("[Create File] " + this.f3485k.toString() + this.f3492r + " : " + this.f3491q.createNewFile(), f3433a);
            this.f3451R = Uri.fromFile(this.f3491q);
            if ("mounted".equals(Environment.getExternalStorageState())) {
                new AlertDialog.Builder(getActivity()).setIcon(C0062R.drawable.ic_dialog_menu_generic).setTitle(C0062R.string.select_photo).setItems(ChatONPref.m3519a().getString("profile_image_status", "").equals("updated") ? C0062R.array.selphoto : C0062R.array.selphoto_first, new DialogInterfaceOnClickListenerC0547aa(this)).create().show();
            } else {
                Toast.makeText(getActivity(), getString(C0062R.string.toast_sdcard_amount), 1).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    protected boolean m3434e() {
        m3419o();
        return this.f3489o;
    }

    /* renamed from: f */
    protected boolean m3435f() {
        m3419o();
        return this.f3490p;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        System.gc();
        switch (i) {
            case 3:
                if (i2 == -1) {
                    if (new File(ChatOnGraphics.f3636b + "/" + this.f3492r).length() <= 0) {
                        ChatONLogWriter.m3499a("Crop return null!", f3433a);
                        break;
                    } else {
                        try {
                            this.f3449P = true;
                            if (!this.f3450Q || this.f3491q.length() <= 1000000) {
                                this.f3494t.m2066a(this.f3491q.getPath());
                                this.f3437D.show();
                            } else {
                                File fileM3536a = ChatOnGraphics.m3536a(getActivity(), this.f3491q);
                                if (fileM3536a != null) {
                                    this.f3494t.m2066a(fileM3536a.getPath());
                                    this.f3437D.show();
                                }
                            }
                            break;
                        } catch (Exception e) {
                            ChatONLogWriter.m3501a(e, getClass().getSimpleName());
                            m3414m();
                            return;
                        }
                    }
                }
                break;
            case 4:
                if (new File(ChatOnGraphics.f3636b + "/" + this.f3492r).length() > 0) {
                    Intent intent2 = new Intent("com.android.camera.action.CROP");
                    intent2.setDataAndType(this.f3451R, "image/*");
                    intent2.putExtra("outputX", this.f3487m);
                    intent2.putExtra("outputY", this.f3488n);
                    intent2.putExtra("aspectX", 1);
                    intent2.putExtra("aspectY", 1);
                    intent2.putExtra("scale", true);
                    intent2.putExtra("return-data", false);
                    intent2.putExtra("output", this.f3451R);
                    intent2.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                    startActivityForResult(intent2, 3);
                    break;
                } else {
                    ChatONLogWriter.m3499a("Camera capture is fail!", f3433a);
                    break;
                }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ChatONLogWriter.m3506b("************** onCreate()", getClass().getSimpleName());
        m3403g();
        this.f3455V = GlobalApplication.m2387e();
        this.f3459Z = new MemoControl(this.f3475ap);
        this.f3455V = GlobalApplication.m2387e();
        this.f3460aa = (LayoutInflater) this.f3455V.getSystemService("layout_inflater");
        this.f3461ab = this.f3460aa.inflate(C0062R.layout.user_porfile_fragment_header2, (ViewGroup) null);
        this.f3462ac = this.f3460aa.inflate(C0062R.layout.memo_refresh_footer, (ViewGroup) null);
        this.f3464ae = (ProgressBar) this.f3462ac.findViewById(C0062R.id.footer_progress);
        this.f3465af = (Button) this.f3462ac.findViewById(C0062R.id.footer_memo_content);
        this.f3466ag = "";
        this.f3467ah = "";
        this.f3468ai = true;
        this.f3463ad = new View[30];
        this.f3435B = new ProfileImageView[30];
        this.f3436C = new TextView[30];
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        MemoAdapter.MemoItem memoItem = (MemoAdapter.MemoItem) this.f3457X.getAdapter().getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position);
        if (memoItem == null) {
            return;
        }
        String strM2399a = memoItem.m2399a();
        String strM2402d = memoItem.m2402d();
        contextMenu.setHeaderTitle(C0062R.string.memo_title);
        contextMenu.add(0, 0, 1, C0062R.string.memo_delete_context_menu).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0586j(this, strM2399a, strM2402d));
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (ChatONPref.m3519a().contains("UpdateIsCritical")) {
            menu.addSubMenu(0, 2, 0, getResources().getString(C0062R.string.setting_settings_title)).setIcon(C0062R.drawable.settings_new);
        } else {
            menu.addSubMenu(0, 2, 0, getResources().getString(C0062R.string.setting_settings_title)).setIcon(C0062R.drawable.ic_menu_settings);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ChatONLogWriter.m3506b("onCreateView...", getClass().getSimpleName());
        this.f3472am = null;
        View viewInflate = layoutInflater.inflate(C0062R.layout.layout_user_profile, viewGroup, false);
        this.f3461ab = layoutInflater.inflate(C0062R.layout.user_porfile_fragment_header2, (ViewGroup) null);
        this.f3496v = (ImageButton) this.f3461ab.findViewById(C0062R.id.imgbtnUPPhoto);
        this.f3496v.requestFocus();
        this.f3497w = (TextView) this.f3461ab.findViewById(C0062R.id.user_Pno);
        this.f3498x = (TextView) this.f3461ab.findViewById(C0062R.id.textPersonalMsg);
        this.f3454U = (LinearLayout) this.f3461ab.findViewById(C0062R.id.linear_status_message);
        this.f3499y = (TextView) this.f3461ab.findViewById(C0062R.id.textPersonalName);
        this.f3500z = (TextView) this.f3461ab.findViewById(C0062R.id.dateDisplay);
        this.f3434A = (RelativeLayout) this.f3461ab.findViewById(C0062R.id.rlayoutBDay);
        this.f3438E = (ImageButton) this.f3461ab.findViewById(C0062R.id.birthday_detail);
        this.f3472am = (HorizontalScrollView) this.f3461ab.findViewById(C0062R.id.scroll);
        this.f3473an = (LinearLayout) this.f3461ab.findViewById(C0062R.id.horichildlinear);
        this.f3439F = (ImageButton) this.f3461ab.findViewById(C0062R.id.userprofile_detail);
        this.f3440G = (ImageView) this.f3461ab.findViewById(C0062R.id.userprofile_interaction_rank);
        this.f3441H = (RelativeLayout) this.f3461ab.findViewById(C0062R.id.rlay_details);
        this.f3442I = (LinearLayout) this.f3461ab.findViewById(C0062R.id.layout3);
        this.f3437D = (ProgressDialog) new SMSProgressBar(getActivity()).onCreate(C0062R.string.dialog_userprofile_updating);
        this.f3471al = (ProgressDialog) new SMSProgressBar(getActivity()).onCreate(C0062R.string.wait_sending);
        this.f3457X = (ListView) viewInflate.findViewById(C0062R.id.mypage_memo_list);
        registerForContextMenu(this.f3457X);
        this.f3458Y.clear();
        this.f3456W = new MemoAdapter(this.f3457X, this.f3455V, this.f3458Y, C0062R.layout.memo_adapter_item);
        this.f3457X.addHeaderView(this.f3461ab, null, false);
        this.f3457X.addFooterView(this.f3462ac);
        this.f3457X.setAdapter((ListAdapter) this.f3456W);
        this.f3457X.setSelection(this.f3457X.getHeaderViewsCount());
        this.f3457X.setScrollbarFadingEnabled(true);
        this.f3457X.setOnScrollListener(this.f3482h);
        Display defaultDisplay = ((WindowManager) this.f3455V.getSystemService("window")).getDefaultDisplay();
        ChatONLogWriter.m3506b("width:" + defaultDisplay.getWidth(), getClass().getSimpleName());
        ChatONLogWriter.m3506b("height:" + defaultDisplay.getHeight(), getClass().getSimpleName());
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        if (width < 480 || height < 600) {
            this.f3487m = 350;
            this.f3488n = 350;
        } else {
            this.f3487m = 600;
            this.f3488n = 600;
        }
        m3408j();
        m3432c();
        m3411k();
        m3405h();
        return viewInflate;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                this.f3459Z.m2004a();
                this.f3471al.show();
                return true;
            case 2:
                this.f3449P = true;
                startActivity(new Intent(getActivity(), (Class<?>) ActivitySettings.class));
                return true;
            default:
                return true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        ChatONPref.m3519a().unregisterOnSharedPreferenceChangeListener(this.f3481g);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        ChatONLogWriter.m3506b("************** onResume()", getClass().getSimpleName());
        ChatONPref.m3519a().registerOnSharedPreferenceChangeListener(this.f3481g);
        ChatONLogWriter.m3506b("onResume:isTake=" + this.f3449P, getClass().getSimpleName());
        m3403g();
        m3408j();
        if (this.f3449P) {
            m3432c();
            m3405h();
            m3407i();
            this.f3449P = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        ChatONLogWriter.m3506b("************** onStart()", getClass().getSimpleName());
    }
}
