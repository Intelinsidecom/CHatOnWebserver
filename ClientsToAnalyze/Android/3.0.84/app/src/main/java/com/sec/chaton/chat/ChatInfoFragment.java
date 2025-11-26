package com.sec.chaton.chat;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1335m;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.p027e.C1447o;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.p028a.C1362f;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p037j.C1554c;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.trunk.p061c.C3020a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3225cm;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3208bw;
import com.sec.chaton.util.EnumC3218cf;
import com.sec.chaton.util.EnumC3219cg;
import com.sec.chaton.widget.C3263j;
import com.sec.chaton.widget.CheckableRelativeLayout;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p069e.C3326c;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.C3641ai;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ChatInfoFragment extends Fragment implements InterfaceC1088fc {

    /* renamed from: a */
    public static final String f3712a = ChatInfoActivity.class.getSimpleName();

    /* renamed from: A */
    private String f3713A;

    /* renamed from: B */
    private int f3714B;

    /* renamed from: C */
    private String f3715C;

    /* renamed from: E */
    private File f3717E;

    /* renamed from: I */
    private Uri f3721I;

    /* renamed from: J */
    private Toast f3722J;

    /* renamed from: L */
    private ProgressDialog f3724L;

    /* renamed from: M */
    private String f3725M;

    /* renamed from: N */
    private String f3726N;

    /* renamed from: O */
    private String f3727O;

    /* renamed from: P */
    private String f3728P;

    /* renamed from: Q */
    private String f3729Q;

    /* renamed from: R */
    private ImageView f3730R;

    /* renamed from: S */
    private C3326c f3731S;

    /* renamed from: T */
    private CallableC1073eo f3732T;

    /* renamed from: e */
    private TextView f3737e;

    /* renamed from: f */
    private String f3738f;

    /* renamed from: g */
    private String f3739g;

    /* renamed from: h */
    private Context f3740h;

    /* renamed from: i */
    private InterfaceC1088fc f3741i;

    /* renamed from: j */
    private String f3742j;

    /* renamed from: k */
    private int f3743k;

    /* renamed from: l */
    private String[] f3744l;

    /* renamed from: m */
    private TextView f3745m;

    /* renamed from: n */
    private CheckableRelativeLayout f3746n;

    /* renamed from: o */
    private TextView f3747o;

    /* renamed from: p */
    private TextView f3748p;

    /* renamed from: q */
    private Button f3749q;

    /* renamed from: r */
    private Button f3750r;

    /* renamed from: s */
    private ImageView f3751s;

    /* renamed from: t */
    private ImageButton f3752t;

    /* renamed from: u */
    private C1377u f3753u;

    /* renamed from: v */
    private Toast f3754v;

    /* renamed from: w */
    private String f3755w;

    /* renamed from: x */
    private String f3756x;

    /* renamed from: y */
    private String f3757y;

    /* renamed from: z */
    private boolean f3758z = true;

    /* renamed from: b */
    String f3734b = C3223ck.m11328b();

    /* renamed from: D */
    private File f3716D = new File(this.f3734b + "/profile/");

    /* renamed from: F */
    private String f3718F = "";

    /* renamed from: G */
    private boolean f3719G = false;

    /* renamed from: H */
    private boolean f3720H = false;

    /* renamed from: K */
    private boolean f3723K = false;

    /* renamed from: U */
    private Handler f3733U = new HandlerC1042dk(this);

    /* renamed from: c */
    InterfaceC1378v f3735c = new C1046do(this);

    /* renamed from: d */
    File f3736d = GlobalApplication.m11493l().getFilesDir().getAbsoluteFile();

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C3225cm.m11337a(getActivity());
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            m5029a(arguments);
        }
        this.f3740h = getActivity();
        this.f3741i = this;
        this.f3754v = C3641ai.m13211a(this.f3740h, (CharSequence) null, 0);
        if (bundle != null) {
            if (bundle.containsKey(ChatFragment.f3497n)) {
                this.f3758z = bundle.getBoolean(ChatFragment.f3497n);
            }
            if (bundle.containsKey("chatType")) {
                this.f3743k = bundle.getInt("chatType");
            }
            if (bundle.containsKey(ChatFragment.f3490g)) {
                this.f3738f = bundle.getString(ChatFragment.f3490g);
            }
            if (bundle.containsKey("inbox_title_fixed")) {
                this.f3739g = bundle.getString("inbox_title_fixed");
            }
            if (bundle.containsKey("inboxNO")) {
                this.f3742j = bundle.getString("inboxNO");
            }
            if (bundle.containsKey("buddyNO")) {
                this.f3713A = bundle.getString("buddyNO");
            }
            if (bundle.containsKey("groupId")) {
                this.f3715C = bundle.getString("groupId");
            }
            if (bundle.containsKey(ChatFragment.f3489f)) {
                this.f3744l = bundle.getStringArray(ChatFragment.f3489f);
            }
            if (bundle.containsKey("inbox_session_id")) {
                this.f3725M = bundle.getString("inbox_session_id");
            }
            if (bundle.containsKey("captureUri")) {
                this.f3721I = Uri.parse(bundle.getString("captureUri"));
            }
            if (bundle.containsKey("profileName")) {
                this.f3718F = bundle.getString("profileName");
            }
        }
        getActivity().setContentView(R.layout.chat_info);
        if (bundle == null) {
            BuddyFragment buddyFragment = new BuddyFragment();
            getArguments().putBoolean("PROFILE_BUDDY_FROM_CHATINFO", true);
            buddyFragment.setArguments(getArguments());
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment_controller, buddyFragment, "com.sec.chaton:single_pane_fragment").commit();
        }
        this.f3753u = new C1377u(getActivity().getContentResolver(), this.f3735c);
        if (EnumC1450r.m6340a(EnumC1450r.m6339a(this.f3743k))) {
            int iIndexOf = this.f3738f.indexOf(":");
            if (this.f3739g != null) {
                if (!this.f3739g.equals("Y") && iIndexOf > 0) {
                    this.f3738f = this.f3738f.substring(iIndexOf + 2);
                }
            } else if (iIndexOf > 0) {
                this.f3738f = this.f3738f.substring(iIndexOf + 2);
            }
        }
        if (this.f3724L == null) {
            this.f3724L = (ProgressDialog) new C3263j(this.f3740h).m11487a(R.string.dialog_userprofile_updating);
        }
        this.f3731S = new C3326c();
        BaseActivity.m3081a(this, true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        m5054a();
    }

    /* renamed from: a */
    private void m5029a(Bundle bundle) {
        if (bundle.containsKey(ChatFragment.f3497n)) {
            this.f3758z = bundle.getBoolean(ChatFragment.f3497n);
        }
        this.f3755w = bundle.getString("inbox_background_style");
        this.f3756x = bundle.getString("inbox_send_bubble_style");
        this.f3757y = bundle.getString("inbox_receive_bubble_style");
        this.f3743k = bundle.getInt("chatType");
        this.f3738f = bundle.getString(ChatFragment.f3490g);
        this.f3739g = bundle.getString("inbox_title_fixed");
        this.f3742j = bundle.getString("inboxNO");
        this.f3713A = bundle.getString("buddyNO");
        if (bundle.containsKey("groupId")) {
            this.f3715C = bundle.getString("groupId");
        }
        if (bundle.containsKey(ChatFragment.f3489f)) {
            this.f3744l = bundle.getStringArray(ChatFragment.f3489f);
        }
        if (bundle.containsKey("sessionID")) {
            this.f3725M = bundle.getString("sessionID");
        }
    }

    /* renamed from: a */
    public void m5054a() {
        this.f3752t = (ImageButton) getActivity().findViewById(R.id.btn_edit);
        this.f3752t.setOnClickListener(new ViewOnClickListenerC1047dp(this));
        this.f3730R = (ImageView) getActivity().findViewById(R.id.profile_image_loading);
        this.f3751s = (ImageView) getActivity().findViewById(R.id.profile_image);
        this.f3751s.setOnClickListener(new ViewOnClickListenerC1048dq(this));
        m5059c();
        this.f3737e = (TextView) getActivity().findViewById(R.id.title_name);
        this.f3737e.setText(this.f3738f);
        this.f3746n = (CheckableRelativeLayout) getActivity().findViewById(R.id.alert_layout);
        this.f3746n.setChoiceMode(2);
        this.f3747o = (TextView) this.f3746n.findViewById(R.id.text1);
        this.f3748p = (TextView) this.f3746n.findViewById(R.id.text2);
        this.f3747o.setText(R.string.chat_alert);
        this.f3748p.setVisibility(8);
        this.f3745m = (TextView) getActivity().findViewById(R.id.ChatInfoBuddyTitle);
        if (this.f3745m != null) {
            if (this.f3744l != null) {
                this.f3745m.setText(getString(R.string.chat_info_buddy_title, Integer.valueOf(this.f3744l.length)));
            }
            this.f3745m.setVisibility(0);
        }
        this.f3746n.setVisibility(0);
        this.f3746n.setChecked(this.f3758z);
        this.f3746n.setOnClickListener(new ViewOnClickListenerC1049dr(this));
        if (EnumC1450r.m6340a(EnumC1450r.m6339a(this.f3743k))) {
            this.f3746n.setVisibility(8);
        } else {
            this.f3746n.setVisibility(0);
        }
        C3250y.m11454d("mChattitle:" + this.f3738f);
        this.f3749q = (Button) getActivity().findViewById(R.id.invite_button);
        this.f3749q.setOnClickListener(new ViewOnClickListenerC1050ds(this));
        this.f3750r = (Button) getActivity().findViewById(R.id.create_group_button);
        this.f3750r.setOnClickListener(new ViewOnClickListenerC1051dt(this));
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(ChatFragment.f3497n, this.f3758z);
        bundle.putInt("chatType", this.f3743k);
        bundle.putString(ChatFragment.f3490g, this.f3738f);
        bundle.putString("inbox_title_fixed", this.f3739g);
        bundle.putString("inboxNO", this.f3742j);
        bundle.putString("buddyNO", this.f3713A);
        bundle.putString("groupId", this.f3715C);
        if (this.f3744l != null) {
            bundle.putStringArray(ChatFragment.f3489f, this.f3744l);
        }
        bundle.putString("inbox_session_id", this.f3725M);
        if (this.f3721I != null) {
            bundle.putString("captureUri", this.f3721I.toString());
        }
        bundle.putString("profileName", this.f3718F);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (EnumC1450r.m6339a(this.f3743k) == EnumC1450r.ONETOONE) {
            this.f3750r.setVisibility(8);
        } else {
            this.f3753u.startQuery(4, null, C1447o.f5379a, null, "inbox_no=?", new String[]{this.f3742j}, null);
        }
        m5043j();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (GlobalApplication.m6456e()) {
            menuInflater.inflate(R.menu.activity_chat_info_menu, menu);
        } else {
            menu.add(0, 1, 1, getResources().getString(R.string.menu_chat_close)).setIcon(R.drawable.more_option_closechat_white);
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
            case R.id.menu_close_chat /* 2131166538 */:
                int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
                if (-3 == iM6733a || -2 == iM6733a) {
                    C3641ai.m13210a(this.f3740h, R.string.popup_no_network_connection, 0).show();
                } else {
                    m5057b();
                }
                break;
            default:
                return true;
        }
    }

    /* renamed from: b */
    public void m5057b() {
        Intent intent = getActivity().getIntent();
        intent.putExtra("isClosing", true);
        getActivity().setResult(-1, intent);
        ((InterfaceC1054dw) getActivity()).mo5026c();
    }

    /* renamed from: a */
    public boolean m5056a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            this.f3728P = str.split("filename=")[r2.length - 1];
            File[] fileArrListFiles = this.f3736d.listFiles(new C1052du(this));
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                return true;
            }
            this.f3729Q = fileArrListFiles[0].getName();
            this.f3727O = this.f3729Q.split("_chat_profile.png_")[r2.length - 1];
            return !this.f3728P.equals(this.f3727O);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    public void m5059c() {
        if (EnumC1450r.m6339a(this.f3743k) == EnumC1450r.ONETOONE) {
            this.f3751s.setClickable(false);
            C3205bt.m11182a(this.f3740h).m11225b(this.f3751s, EnumC3208bw.BUDDY);
            this.f3753u.startQuery(2, null, C1441i.m6310c(), null, "buddy_no = ? ", new String[]{this.f3713A}, null);
            return;
        }
        if (EnumC1450r.m6339a(this.f3743k) == EnumC1450r.GROUPCHAT) {
            EnumC3208bw enumC3208bw = EnumC3208bw.GROUP;
            Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1449q.f5381a, null, "inbox_no=?", new String[]{this.f3742j}, null);
            if (cursorQuery == null || cursorQuery.getCount() < 0) {
                C3205bt.m11182a(this.f3740h).m11225b(this.f3751s, enumC3208bw);
                if (cursorQuery != null) {
                    cursorQuery.close();
                    return;
                }
                return;
            }
            cursorQuery.moveToFirst();
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("profile_url"));
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (!TextUtils.isEmpty(this.f3715C) && string == null) {
                File file = new File(this.f3736d, C1362f.m6073e(GlobalApplication.m6447a().getContentResolver(), this.f3715C) + "_group_profile.png_");
                if (file.exists()) {
                    m5055a(file);
                    return;
                }
            }
            if ("NA".equals(string)) {
                File file2 = new File(this.f3736d, this.f3742j + "_chat_profile.png_");
                if (file2.exists()) {
                    this.f3751s.setImageBitmap(C3162ad.m11000a(getActivity(), file2.getAbsolutePath()));
                    return;
                }
            } else {
                if (string == null) {
                    C3205bt.m11182a(this.f3740h).m11225b(this.f3751s, enumC3208bw);
                    return;
                }
                if (m5056a(string)) {
                    this.f3732T = new CallableC1073eo(this.f3730R, string, this.f3742j);
                    this.f3732T.m5311a(60, 60, CommonApplication.m11493l().getFilesDir().getAbsolutePath(), this.f3742j + "_chat_profile.png_." + this.f3728P, this.f3727O);
                    this.f3731S.m11730a(this.f3751s, this.f3732T);
                    return;
                } else {
                    File file3 = new File(this.f3736d, this.f3729Q);
                    if (file3 != null && file3.exists()) {
                        m5055a(file3);
                        return;
                    }
                }
            }
            C3205bt.m11182a(this.f3740h).m11225b(this.f3751s, enumC3208bw);
            return;
        }
        EnumC3208bw enumC3208bw2 = EnumC3208bw.BROADCAST;
        File file4 = new File(this.f3736d, this.f3742j + "_chat_profile.png_");
        if (file4.exists()) {
            m5055a(file4);
        } else {
            C3205bt.m11182a(this.f3740h).m11225b(this.f3751s, enumC3208bw2);
        }
    }

    /* renamed from: a */
    public void m5055a(File file) {
        this.f3751s.setImageBitmap(C3162ad.m11000a(getActivity(), file.getAbsolutePath()));
    }

    /* renamed from: d */
    public void m5061d() throws IOException {
        int i;
        try {
            if (!this.f3716D.canRead()) {
                this.f3716D.mkdirs();
            }
            m5036g();
            this.f3718F = "tmp_" + System.currentTimeMillis() + ".jpeg_";
            this.f3717E = new File(this.f3716D + "/", this.f3718F);
            C3250y.m11450b("[Create File] " + this.f3716D.toString() + this.f3718F + " : " + this.f3717E.createNewFile(), f3712a);
            this.f3721I = Uri.fromFile(this.f3717E);
            if (!m5062e() || !m5063f()) {
                if (this.f3722J == null) {
                    this.f3722J = C3641ai.m13211a(GlobalApplication.m11493l(), getString(R.string.toast_sdcard_amount), 1);
                }
                this.f3722J.show();
                return;
            }
            if (C3171am.m11077o()) {
                i = R.array.selphoto_first;
            } else {
                i = R.array.selphoto_first_nocamera_nodelete;
            }
            AbstractC3271a abstractC3271aMo11497a = AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.ams_add_frame_title).mo11497a(i, new DialogInterfaceOnClickListenerC1053dv(this));
            abstractC3271aMo11497a.mo11505a().show();
            if (this.f3723K) {
                abstractC3271aMo11497a.mo11505a().dismiss();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws IOException {
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 3:
                if (i2 == -1) {
                    File file = new File(Uri.parse(intent.getExtras().getString("temp_file_path")).getPath());
                    if (file.length() <= 0) {
                        C3250y.m11442a("Crop return null!", f3712a);
                        return;
                    }
                    if (this.f3717E == null) {
                        this.f3717E = new File(this.f3716D + "/", this.f3718F);
                    }
                    C3020a.m10525a(file, this.f3717E);
                    this.f3726N = this.f3717E.getName();
                    if (EnumC1450r.m6339a(this.f3743k) == EnumC1450r.GROUPCHAT) {
                        C1335m.m5783a(this.f3733U, this.f3717E.getPath(), this.f3726N);
                        if (this.f3724L != null) {
                            this.f3724L.show();
                            return;
                        }
                        return;
                    }
                    try {
                        C3205bt.m11182a(this.f3740h).m11216a(this.f3742j, EnumC1450r.m6339a(this.f3743k));
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(C3162ad.m11012b(getActivity(), Uri.parse(intent.getExtras().getString("temp_file_path")), 600), 600, 600, true);
                        C3020a.m10525a(file, this.f3717E);
                        this.f3751s.setImageBitmap(bitmapCreateScaledBitmap);
                        try {
                            try {
                                fileOutputStreamOpenFileOutput = CommonApplication.m11493l().openFileOutput(this.f3742j + "_chat_profile.png_", 0);
                                bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStreamOpenFileOutput);
                                GlobalApplication.f5514d = this.f3742j;
                                if (fileOutputStreamOpenFileOutput != null) {
                                    try {
                                        fileOutputStreamOpenFileOutput.close();
                                        return;
                                    } catch (IOException e) {
                                        C3250y.m11443a(e, getClass().getSimpleName());
                                        return;
                                    }
                                }
                                return;
                            } finally {
                            }
                        } catch (FileNotFoundException e2) {
                            C3250y.m11443a(e2, getClass().getSimpleName());
                            if (fileOutputStreamOpenFileOutput != null) {
                                try {
                                    fileOutputStreamOpenFileOutput.close();
                                    return;
                                } catch (IOException e3) {
                                    C3250y.m11443a(e3, getClass().getSimpleName());
                                    return;
                                }
                            }
                            return;
                        }
                    } catch (Exception e4) {
                        C3250y.m11443a(e4, getClass().getSimpleName());
                        return;
                    }
                }
                return;
            case 4:
                if (intent == null) {
                    C3250y.m11450b("Crop Return is NULL", getClass().getSimpleName());
                    return;
                }
                this.f3721I = intent.getData();
                Intent intent2 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                intent2.setDataAndType(this.f3721I, "image/*");
                intent2.putExtra("outputX", 600);
                intent2.putExtra("outputY", 600);
                intent2.putExtra("aspectX", 1);
                intent2.putExtra("aspectY", 1);
                intent2.putExtra("return-data", true);
                startActivityForResult(intent2, 3);
                return;
            case 5:
                if (i2 == -1) {
                    String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
                    Log.e("MSCI", "onActivityResult.ACTIVITY_PURPOSE_INVITE_BUDDY.result : " + Arrays.toString(stringArrayExtra));
                    Intent intent3 = new Intent(getActivity(), (Class<?>) ChatActivity.class);
                    intent3.putExtra("receivers", stringArrayExtra);
                    intent3.putExtra("inboxNO", this.f3742j);
                    intent3.putExtra("buddyNO", this.f3713A);
                    intent3.putExtra("chatType", this.f3743k);
                    getActivity().setResult(-1, intent3);
                    ((InterfaceC1054dw) getActivity()).mo5026c();
                    return;
                }
                return;
            case 6:
            case 7:
                this.f3755w = intent.getStringExtra("backgroundStyle");
                this.f3756x = intent.getStringExtra("sendBubbleStyle");
                this.f3757y = intent.getStringExtra("receiveBubbleStyle");
                ContentValues contentValues = new ContentValues();
                contentValues.put("inbox_is_change_skin", "Y");
                contentValues.put("inbox_background_style", this.f3755w);
                contentValues.put("inbox_send_bubble_style", this.f3756x);
                contentValues.put("inbox_receive_bubble_style", this.f3757y);
                this.f3753u.startUpdate(0, null, C1449q.f5381a, contentValues, "inbox_no='" + this.f3742j + "'", null);
                return;
            case 8:
                if (i2 == -1) {
                    this.f3738f = intent.getStringExtra(ChatFragment.f3490g);
                    this.f3737e.setText(this.f3738f);
                    return;
                }
                return;
            case 9:
                if (i2 == -1) {
                    Intent intent4 = new Intent(this.f3740h, (Class<?>) ImageModify.class);
                    intent4.setDataAndType(this.f3721I, "image/*");
                    intent4.putExtra("outputX", 600);
                    intent4.putExtra("outputY", 600);
                    intent4.putExtra("aspectX", 1);
                    intent4.putExtra("aspectY", 1);
                    intent4.putExtra("return-data", true);
                    startActivityForResult(intent4, 3);
                    return;
                }
                C3250y.m11450b("Camera Return is NULL", getClass().getSimpleName());
                return;
            default:
                return;
        }
    }

    /* renamed from: g */
    private void m5036g() {
        if (!m5062e() || !m5063f()) {
            C3250y.m11442a("[deleteTempFolder] External Storage Is Not Available or Writable!", f3712a);
            if (this.f3722J == null) {
                this.f3722J = C3641ai.m13211a(GlobalApplication.m11493l(), getString(R.string.toast_sdcard_amount), 1);
            }
            this.f3722J.show();
            return;
        }
        String strM11328b = C3223ck.m11328b();
        if (strM11328b.length() == 0) {
            this.f3722J.show();
            return;
        }
        try {
            String[] list = new File(strM11328b + "/profile/").list();
            if (list != null) {
                for (String str : list) {
                    C3250y.m11450b("[Delete File] " + strM11328b + "/profile/" + str + " : " + new File(strM11328b + "/profile/" + str).delete(), f3712a);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    protected boolean m5062e() {
        m5039h();
        return this.f3719G;
    }

    /* renamed from: f */
    protected boolean m5063f() {
        m5039h();
        return this.f3720H;
    }

    /* renamed from: h */
    private void m5039h() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f3719G = true;
            this.f3720H = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f3719G = true;
            this.f3720H = false;
        } else {
            this.f3719G = false;
            this.f3720H = false;
        }
    }

    /* renamed from: b */
    public void m5058b(String str) {
        this.f3738f = str;
        this.f3737e.setText(this.f3738f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: i */
    public void m5041i() throws IOException {
        String strM6590a;
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        fileOutputStreamOpenFileOutput = null;
        String str = this.f3742j + "_chat_profile.png_." + this.f3726N;
        try {
            ContentValues contentValues = new ContentValues();
            if (C3159aa.m10962a().m10977a("is_file_server_primary ", (Boolean) true).booleanValue()) {
                strM6590a = C1554c.m6590a(EnumC3218cf.PRIMARY, EnumC3219cg.FILE);
            } else {
                strM6590a = C1554c.m6590a(EnumC3218cf.SECONDARY, EnumC3219cg.FILE);
            }
            contentValues.put("profile_url", String.format("%s%s?%s=%s&%s=%s&%s=%s&%s=%s", strM6590a, "/profileimage", "uid", C3159aa.m10962a().m10979a("uid", ""), "imei", C3171am.m11045a(), "size", 160, "filename", this.f3726N));
            CommonApplication.m11493l().getContentResolver().update(C1449q.f5381a, contentValues, "inbox_no='" + this.f3742j + "'", null);
            File[] fileArrListFiles = this.f3736d.listFiles(new C1045dn(this));
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    C3250y.m11450b("[Delete File] " + file + " : " + file.delete(), f3712a);
                }
            }
            C3205bt.m11182a(this.f3740h).m11216a(this.f3742j, EnumC1450r.m6339a(this.f3743k));
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(C3162ad.m11012b(GlobalApplication.m11493l(), Uri.parse(this.f3717E.getPath()), 600), 600, 600, true);
            this.f3751s.setImageBitmap(bitmapCreateScaledBitmap);
            try {
                try {
                    fileOutputStreamOpenFileOutput = CommonApplication.m11493l().openFileOutput(str, 0);
                    bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStreamOpenFileOutput);
                    GlobalApplication.f5514d = this.f3742j;
                    this.f3751s.setImageBitmap(bitmapCreateScaledBitmap);
                    fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                            fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
                        } catch (IOException e) {
                            String simpleName = getClass().getSimpleName();
                            C3250y.m11443a(e, simpleName);
                            fileOutputStreamOpenFileOutput = simpleName;
                        }
                    }
                } catch (FileNotFoundException e2) {
                    C3250y.m11443a(e2, getClass().getSimpleName());
                    fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                            fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
                        } catch (IOException e3) {
                            String simpleName2 = getClass().getSimpleName();
                            C3250y.m11443a(e3, simpleName2);
                            fileOutputStreamOpenFileOutput = simpleName2;
                        }
                    }
                }
            } catch (Throwable th) {
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e4) {
                        C3250y.m11443a(e4, getClass().getSimpleName());
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            C3250y.m11443a(e5, getClass().getSimpleName());
        }
    }

    /* renamed from: j */
    private void m5043j() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context contextL = GlobalApplication.m11493l();
        if (C3241p.m11407c(contextL)) {
            Intent intent = new Intent(contextL, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f3724L.isShowing()) {
            this.f3724L.dismiss();
        }
        if (this.f3731S != null) {
            this.f3731S.m11731a();
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1088fc
    /* renamed from: c */
    public void mo5060c(String str) {
        m5058b(str);
    }
}
