package com.sec.chaton.buddy.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolots.sso.p006a.C0045a;
import com.sec.chaton.R;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.buddy.BuddyEditNickNameActivity;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.BuddyGroupProfileActivity;
import com.sec.chaton.buddy.GroupProfileImageViewActivity;
import com.sec.chaton.buddy.p019a.C0512b;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1331i;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.p028a.C1362f;
import com.sec.chaton.p027e.p028a.C1365i;
import com.sec.chaton.plugin.C1948a;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3231f;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.log.collector.C3358h;
import com.sec.widget.C3641ai;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GroupDialog extends Activity implements View.OnClickListener {

    /* renamed from: a */
    public static final String f2704a = GroupDialog.class.getSimpleName();

    /* renamed from: A */
    private String f2705A;

    /* renamed from: c */
    private File f2708c;

    /* renamed from: d */
    private String f2709d;

    /* renamed from: e */
    private String f2710e;

    /* renamed from: f */
    private String f2711f;

    /* renamed from: g */
    private String[] f2712g;

    /* renamed from: h */
    private TextView f2713h;

    /* renamed from: i */
    private TextView f2714i;

    /* renamed from: j */
    private LinearLayout f2715j;

    /* renamed from: k */
    private ImageView f2716k;

    /* renamed from: l */
    private ImageView f2717l;

    /* renamed from: m */
    private ImageView f2718m;

    /* renamed from: n */
    private LinearLayout f2719n;

    /* renamed from: o */
    private LinearLayout f2720o;

    /* renamed from: p */
    private LinearLayout f2721p;

    /* renamed from: q */
    private LinearLayout f2722q;

    /* renamed from: r */
    private LinearLayout f2723r;

    /* renamed from: s */
    private String[] f2724s;

    /* renamed from: t */
    private C0045a f2725t;

    /* renamed from: u */
    private ImageView f2726u;

    /* renamed from: v */
    private ImageView f2727v;

    /* renamed from: w */
    private ImageView f2728w;

    /* renamed from: x */
    private C1331i f2729x;

    /* renamed from: y */
    private C3326c f2730y;

    /* renamed from: z */
    private String f2731z;

    /* renamed from: b */
    private String f2707b = C3223ck.m11329c() + "/profilehistory/";

    /* renamed from: B */
    private Handler f2706B = new HandlerC0638t(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) throws UnsupportedEncodingException {
        C3250y.m11458g("onCreate()", f2704a);
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        this.f2729x = new C1331i(this.f2706B);
        this.f2730y = new C3326c();
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.f2709d = getIntent().getExtras().getString("GROUP_DIALOG_GROUP_NAME");
        this.f2710e = getIntent().getExtras().getString("GROUP_DIALOG_GROUP_ID");
        this.f2712g = getIntent().getStringArrayExtra("GROUP_DIALOG_CHAT_RECEIVER");
        this.f2711f = getIntent().getExtras().getString("GROUP_DIALOG_GROUP_MEMBERS");
        this.f2724s = getIntent().getExtras().getStringArray("GROUP_DIALOG_GROUP_MEMBERS_NO_LIST");
        this.f2708c = getApplicationContext().getFilesDir().getAbsoluteFile();
        this.f2705A = getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        m4224d();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Rect rect = new Rect();
        getWindow().getDecorView().getHitRect(rect);
        if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY()) && motionEvent.getAction() == 0) {
            finish();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: d */
    private void m4224d() throws UnsupportedEncodingException {
        setContentView(R.layout.group_profile_popup);
        this.f2725t = new C0045a();
        if (GlobalApplication.m6447a().getResources().getBoolean(R.bool.log_collector)) {
            C3358h.m11842a().m11846a("00030004");
        }
        if (this.f2712g != null && this.f2712g.length > 0) {
            this.f2713h = (TextView) findViewById(R.id.group_profile_popup_name);
            if (this.f2709d != null) {
                this.f2713h.setText(this.f2709d + " (" + (this.f2712g != null ? this.f2712g.length : 0) + ")");
            }
            this.f2714i = (TextView) findViewById(R.id.group_profile_popup_member_list);
            if (this.f2711f != null) {
                this.f2714i.setText(this.f2711f);
            }
            this.f2715j = (LinearLayout) findViewById(R.id.group_profile_popup_pen_btn);
            this.f2715j.setOnClickListener(this);
            this.f2716k = (ImageView) findViewById(R.id.group_profile_popup_coverimage);
            if (!m4232c()) {
                C3250y.m11458g("There is no random image for Group.", f2704a);
                m4231b();
            }
            this.f2717l = (ImageView) findViewById(R.id.group_profile_popup_image);
            this.f2718m = (ImageView) findViewById(R.id.group_profile_popup_image_loading);
            C3205bt.m11182a(getApplicationContext()).m11219a(this.f2709d, false);
            C3205bt.m11182a(getApplicationContext()).m11226b(this.f2717l, this.f2709d);
            Bitmap bitmapM4229a = m4229a();
            if (bitmapM4229a != null) {
                this.f2717l.setImageBitmap(C3231f.m11370b(bitmapM4229a));
                this.f2717l.setFocusable(true);
                this.f2717l.setOnClickListener(this);
            } else {
                this.f2717l.setFocusable(false);
            }
            this.f2726u = (ImageView) findViewById(R.id.button_chatonv);
            this.f2727v = (ImageView) findViewById(R.id.buddy_webonly);
            this.f2728w = (ImageView) findViewById(R.id.buddy_live);
            this.f2719n = (LinearLayout) findViewById(R.id.group_profile_popup_view_profile);
            this.f2719n.setOnClickListener(this);
            this.f2720o = (LinearLayout) findViewById(R.id.group_profile_popup_chat);
            this.f2720o.setOnClickListener(this);
            this.f2721p = (LinearLayout) findViewById(R.id.group_profile_popup_broadcast);
            this.f2721p.setOnClickListener(this);
            this.f2722q = (LinearLayout) findViewById(R.id.group_profile_popup_voice_call);
            this.f2722q.setOnClickListener(this);
            this.f2723r = (LinearLayout) findViewById(R.id.group_profile_popup_video_call);
            this.f2723r.setOnClickListener(this);
            if (C1948a.m7903a(GlobalApplication.m11493l())) {
                if (!C1954g.m7916a().m7918a(getApplicationContext(), EnumC1955h.ChatONV)) {
                    C0045a c0045a = this.f2725t;
                    if (C0045a.m37b(getApplicationContext())) {
                        this.f2722q.setVisibility(8);
                        this.f2723r.setVisibility(8);
                        this.f2726u.setVisibility(8);
                        this.f2721p.setBackgroundResource(R.drawable.buddy_profile_popup_right_btn_bg);
                        return;
                    }
                }
                ArrayList<String> arrayListM6060a = C1362f.m6060a(GlobalApplication.m11493l().getContentResolver(), Integer.parseInt(this.f2710e));
                boolean z = true;
                for (int i = 0; i < arrayListM6060a.size(); i++) {
                    if (!BuddyFragment.m3357b(arrayListM6060a.get(i))) {
                        z = false;
                    }
                }
                if (z) {
                    this.f2722q.setVisibility(0);
                    this.f2723r.setVisibility(0);
                    this.f2726u.setVisibility(0);
                    return;
                } else {
                    this.f2722q.setVisibility(8);
                    this.f2723r.setVisibility(8);
                    this.f2726u.setVisibility(8);
                    this.f2721p.setBackgroundResource(R.drawable.buddy_profile_popup_right_btn_bg);
                    return;
                }
            }
            this.f2722q.setVisibility(8);
            this.f2723r.setVisibility(8);
            this.f2726u.setVisibility(8);
            this.f2721p.setBackgroundResource(R.drawable.buddy_profile_popup_right_btn_bg);
        }
    }

    /* renamed from: a */
    public Bitmap m4229a() throws UnsupportedEncodingException {
        if (this.f2709d != null) {
            String strEncode = this.f2709d + "_group_profile.png_";
            try {
                strEncode = URLEncoder.encode(strEncode, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, getClass().getSimpleName());
                }
            }
            File file = new File(GlobalApplication.m6447a().getFilesDir(), strEncode);
            try {
                if (file.exists() && file.length() > 0) {
                    Bitmap bitmapM10997a = C3162ad.m10997a(getApplicationContext(), Uri.fromFile(file));
                    if (bitmapM10997a != null) {
                        return bitmapM10997a;
                    }
                    return null;
                }
                return null;
            } catch (Exception e2) {
                C3250y.m11443a(e2, f2704a);
            }
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.group_profile_popup_view_profile /* 2131165521 */:
                BuddyFragment.f1734m = true;
                C0512b c0512b = new C0512b(Integer.parseInt(this.f2710e), this.f2709d, this.f2712g != null ? this.f2712g.length : 0, 18);
                Intent intent = new Intent(getApplicationContext(), (Class<?>) BuddyGroupProfileActivity.class);
                intent.putExtra("ACTIVITY_PURPOSE", 18);
                intent.putExtra("groupInfo", c0512b);
                intent.putExtra("GROUP_PROFILE_NAME", String.valueOf(this.f2709d).toString());
                intent.putExtra("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST", this.f2712g);
                startActivity(intent);
                finish();
                break;
            case R.id.group_profile_popup_pen_btn /* 2131165522 */:
                BuddyFragment.f1734m = true;
                Intent intent2 = new Intent(getApplicationContext(), (Class<?>) BuddyEditNickNameActivity.class);
                intent2.putExtra("PROFILE_ID", this.f2710e);
                intent2.putExtra("PROFILE_NAME", this.f2709d);
                intent2.putExtra("PROFILE_BUDDY_MODE", false);
                intent2.putExtra("PROFILE_BUDDY_LIST", this.f2712g);
                startActivity(intent2);
                finish();
                break;
            case R.id.group_profile_popup_image /* 2131165529 */:
                Intent intent3 = new Intent(getApplicationContext(), (Class<?>) GroupProfileImageViewActivity.class);
                intent3.putExtra("GROUP_PROFILE_ID", Integer.valueOf(this.f2710e).intValue());
                intent3.putExtra("GROUP_PROFILE_NAME", String.valueOf(this.f2709d).toString());
                startActivity(intent3);
                finish();
                break;
            case R.id.group_profile_popup_chat /* 2131165531 */:
                BuddyFragment.f1734m = true;
                Intent intent4 = new Intent(getApplicationContext(), (Class<?>) ChatActivity.class);
                intent4.setFlags(67108864);
                intent4.putExtra("chatType", EnumC1450r.GROUPCHAT.m6342a());
                intent4.putExtra("receivers", this.f2712g);
                intent4.putExtra("groupId", this.f2710e);
                intent4.putExtra(ChatFragment.f3494k, true);
                startActivity(intent4);
                finish();
                break;
            case R.id.group_profile_popup_broadcast /* 2131165532 */:
                BuddyFragment.f1734m = true;
                Intent intent5 = new Intent(getApplicationContext(), (Class<?>) ChatActivity.class);
                intent5.setFlags(67108864);
                if (C1493a.m6463a("broadcast2_feature")) {
                    intent5.putExtra("chatType", EnumC1450r.BROADCAST2.m6342a());
                } else {
                    intent5.putExtra("chatType", EnumC1450r.BROADCAST.m6342a());
                }
                intent5.putExtra("receivers", this.f2712g);
                intent5.putExtra("groupId", this.f2710e);
                intent5.putExtra(ChatFragment.f3494k, true);
                startActivity(intent5);
                finish();
                break;
            case R.id.group_profile_popup_voice_call /* 2131165533 */:
                BuddyFragment.f1734m = true;
                if (C1948a.m7903a(GlobalApplication.m11493l())) {
                    if (m4227g()) {
                        if (m4226f()) {
                            try {
                                if (this.f2712g.length <= 1) {
                                    if (this.f2725t.m47a(getApplicationContext(), false, this.f2712g[0], C3159aa.m10962a().m10979a("Push Name", ""), null) != 0) {
                                        C3641ai.m13210a(getApplicationContext(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                                    }
                                } else if (this.f2712g.length > this.f2725t.m53b(getApplicationContext(), false) - 1) {
                                    C3641ai.m13211a(getApplicationContext(), getResources().getString(R.string.chaton_buddies_voice_group_limit, Integer.valueOf(this.f2725t.m53b(getApplicationContext(), false) - 1)), 0).show();
                                } else if (this.f2725t.m48a(getApplicationContext(), false, this.f2712g, C3159aa.m10962a().m10979a("Push Name", ""), null, this.f2709d) != 0) {
                                    C3641ai.m13210a(getApplicationContext(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                                }
                                break;
                            } catch (Exception e) {
                                C3250y.m11443a(e, getClass().getSimpleName());
                                return;
                            }
                        } else {
                            startActivity(new Intent(getApplicationContext(), (Class<?>) ChatONVInstallDialog.class));
                            break;
                        }
                    } else if (!m4228h()) {
                        startActivity(new Intent(getApplicationContext(), (Class<?>) ChatONVRedirectDialog.class));
                        break;
                    }
                }
                break;
            case R.id.group_profile_popup_video_call /* 2131165534 */:
                BuddyFragment.f1734m = true;
                if (C1948a.m7903a(GlobalApplication.m11493l())) {
                    if (m4227g()) {
                        if (m4226f()) {
                            try {
                                if (this.f2712g.length <= 1) {
                                    if (this.f2725t.m47a(getApplicationContext(), true, this.f2712g[0], C3159aa.m10962a().m10979a("Push Name", ""), null) != 0) {
                                        C3641ai.m13210a(getApplicationContext(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                                    }
                                } else if (this.f2712g.length > this.f2725t.m53b(getApplicationContext(), true) - 1) {
                                    C3641ai.m13211a(getApplicationContext(), getResources().getString(R.string.chaton_buddies_video_group_limit, Integer.valueOf(this.f2725t.m53b(getApplicationContext(), true) - 1)), 0).show();
                                } else if (this.f2725t.m48a(getApplicationContext(), true, this.f2712g, C3159aa.m10962a().m10979a("Push Name", ""), null, this.f2709d) != 0) {
                                    C3641ai.m13210a(getApplicationContext(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                                }
                                break;
                            } catch (Exception e2) {
                                C3250y.m11443a(e2, getClass().getSimpleName());
                                return;
                            }
                        } else {
                            startActivity(new Intent(getApplicationContext(), (Class<?>) ChatONVInstallDialog.class));
                            break;
                        }
                    } else if (!m4228h()) {
                        startActivity(new Intent(getApplicationContext(), (Class<?>) ChatONVRedirectDialog.class));
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m4225e();
    }

    /* renamed from: e */
    private void m4225e() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f2717l != null) {
            this.f2717l.setImageBitmap(null);
            this.f2717l = null;
        }
    }

    /* renamed from: f */
    private boolean m4226f() {
        boolean zM55d;
        Exception e;
        try {
            zM55d = this.f2725t.m55d(GlobalApplication.m6447a());
            try {
                C3250y.m11450b("[ChatONV] isReadyToCall : " + zM55d, f2704a);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                C3250y.m11450b("[ChatONV] isChatONVReadyToCall : " + zM55d, f2704a);
                return zM55d;
            }
        } catch (Exception e3) {
            zM55d = false;
            e = e3;
        }
        C3250y.m11450b("[ChatONV] isChatONVReadyToCall : " + zM55d, f2704a);
        return zM55d;
    }

    /* renamed from: g */
    private boolean m4227g() {
        boolean z = false;
        try {
            if (C1954g.m7916a().m7918a(GlobalApplication.m6447a(), EnumC1955h.ChatONV)) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3250y.m11450b("[ChatONV] isChatONVAvaiable : " + z, f2704a);
        return z;
    }

    /* renamed from: h */
    private boolean m4228h() {
        boolean z = false;
        try {
            C0045a c0045a = this.f2725t;
            if (C0045a.m37b(GlobalApplication.m6447a())) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3250y.m11450b("[ChatONV] isChatONVInstalled : " + z, f2704a);
        return z;
    }

    /* renamed from: b */
    public boolean m4231b() {
        C3250y.m11450b("Buddy didn't set Coverstory mContentId : " + this.f2731z, getClass().getSimpleName());
        if (TextUtils.isEmpty(this.f2731z)) {
            C3231f.m11368a(this.f2716k);
        }
        String strM6090a = C1365i.m6090a();
        this.f2731z = strM6090a;
        if (strM6090a != null) {
            if (!m4230a(strM6090a)) {
                this.f2729x.m5760a(strM6090a, Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
            }
            return true;
        }
        C3250y.m11450b(" Random ERROR !!", getClass().getSimpleName());
        this.f2729x.m5763b(Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
        return false;
    }

    /* renamed from: c */
    public boolean m4232c() {
        String str = getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        File file = new File(str);
        if (file.exists()) {
            String[] list = file.list();
            if (list == null || list.length <= 0) {
                return false;
            }
            String str2 = list[(int) (Math.random() * list.length)];
            int iLastIndexOf = str2.lastIndexOf(".");
            String strSubstring = str2.substring(0, iLastIndexOf);
            C3250y.m11450b("loadRandomimage filename : " + str2 + "### pos : " + iLastIndexOf + " ### randomId : " + strSubstring, f2704a);
            if (TextUtils.isEmpty(strSubstring)) {
                return true;
            }
            String str3 = str + strSubstring + ".jpg";
            C3250y.m11450b("loadRandomimage randomId : " + strSubstring + " ### randomFile : " + str3, f2704a);
            File file2 = new File(str3);
            if (file2.length() == 0) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("checkAndSetCoverStoryRandomImages file size is 0.", f2704a);
                }
                file2.delete();
                return false;
            }
            if (!file2.exists()) {
                C3250y.m11450b("loadRandomimage randomFile doesn't exit. " + str3, f2704a);
                return false;
            }
            if (this.f2716k != null) {
                this.f2716k.setImageURI(Uri.parse(str3));
                return true;
            }
            C3250y.m11450b("loadRandomimage mCoverstoryImg is null", f2704a);
            return false;
        }
        if (!C3250y.f11734b) {
            return false;
        }
        C3250y.m11450b("loadRandomimage No random images in file folder ", f2704a);
        return false;
    }

    /* renamed from: a */
    public boolean m4230a(String str) {
        boolean z = false;
        String str2 = getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        if (!new File(str2).exists()) {
            if (C3250y.f11734b) {
                C3250y.m11450b("checkAndSetCoverStoryRandomImages No random images in file folder ", f2704a);
            }
        } else {
            String str3 = str2 + str + ".jpg";
            File file = new File(str3);
            if (file.exists()) {
                if (file.length() == 0) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("checkAndSetCoverStoryRandomImages file size is 0.", f2704a);
                    }
                    file.delete();
                } else {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("checkAndSetCoverStoryRandomImages get the random image in file folder #3#", f2704a);
                    }
                    z = true;
                    if (this.f2716k != null) {
                        this.f2716k.setImageURI(Uri.parse(str3));
                    }
                    if (C3250y.f11734b) {
                        C3250y.m11450b("checkAndSetCoverStoryRandomImages set the random image from file folder #4#", f2704a);
                    }
                }
            } else if (C3250y.f11734b) {
                C3250y.m11450b("checkAndSetCoverStoryRandomImages not exists the random image in file folder #2#", f2704a);
            }
        }
        return z;
    }
}
