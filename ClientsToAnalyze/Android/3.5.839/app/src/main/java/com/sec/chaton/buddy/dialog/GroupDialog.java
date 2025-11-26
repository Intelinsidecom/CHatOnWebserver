package com.sec.chaton.buddy.dialog;

import android.annotation.TargetApi;
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
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.R;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.buddy.BuddyEditNickNameActivity;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.BuddyGroupMemberEditActivity;
import com.sec.chaton.buddy.BuddyGroupProfileActivity;
import com.sec.chaton.buddy.C1331gk;
import com.sec.chaton.buddy.GroupProfileImageViewActivity;
import com.sec.chaton.buddy.p050a.C1105b;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2130k;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2195i;
import com.sec.chaton.passwordlock.PasswordLockActivity;
import com.sec.chaton.plugin.C2923b;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.common.p132g.C5007c;
import com.sec.widget.C5179v;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes.dex */
public class GroupDialog extends PasswordLockActivity implements View.OnClickListener {

    /* renamed from: a */
    public static final String f4548a = GroupDialog.class.getSimpleName();

    /* renamed from: A */
    private String f4549A;

    /* renamed from: B */
    private String f4550B;

    /* renamed from: C */
    private String f4551C;

    /* renamed from: c */
    private File f4554c;

    /* renamed from: d */
    private String f4555d;

    /* renamed from: e */
    private String f4556e;

    /* renamed from: f */
    private String f4557f;

    /* renamed from: g */
    private String[] f4558g;

    /* renamed from: h */
    private TextView f4559h;

    /* renamed from: i */
    private TextView f4560i;

    /* renamed from: j */
    private LinearLayout f4561j;

    /* renamed from: k */
    private ImageView f4562k;

    /* renamed from: l */
    private ImageView f4563l;

    /* renamed from: m */
    private ImageView f4564m;

    /* renamed from: n */
    private LinearLayout f4565n;

    /* renamed from: o */
    private LinearLayout f4566o;

    /* renamed from: p */
    private LinearLayout f4567p;

    /* renamed from: q */
    private LinearLayout f4568q;

    /* renamed from: r */
    private LinearLayout f4569r;

    /* renamed from: s */
    private LinearLayout f4570s;

    /* renamed from: t */
    private String[] f4571t;

    /* renamed from: u */
    private C0416a f4572u;

    /* renamed from: v */
    private ImageView f4573v;

    /* renamed from: w */
    private ImageView f4574w;

    /* renamed from: x */
    private ImageView f4575x;

    /* renamed from: y */
    private C2130k f4576y;

    /* renamed from: z */
    private C5007c f4577z;

    /* renamed from: b */
    private String f4553b = C4873ck.m18502c() + "/profilehistory/";

    /* renamed from: D */
    private Handler f4552D = new HandlerC1248z(this);

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    @TargetApi(11)
    protected void onCreate(Bundle bundle) throws UnsupportedEncodingException {
        C4904y.m18639b("onCreate()", f4548a);
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        this.f4576y = new C2130k(this.f4552D);
        this.f4577z = new C5007c();
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.f4555d = getIntent().getExtras().getString("GROUP_DIALOG_GROUP_NAME");
        this.f4556e = getIntent().getExtras().getString("GROUP_DIALOG_GROUP_ID");
        this.f4558g = getIntent().getStringArrayExtra("GROUP_DIALOG_CHAT_RECEIVER");
        this.f4557f = getIntent().getExtras().getString("GROUP_DIALOG_GROUP_MEMBERS");
        this.f4571t = getIntent().getExtras().getStringArray("GROUP_DIALOG_GROUP_MEMBERS_NO_LIST");
        this.f4554c = getApplicationContext().getFilesDir().getAbsoluteFile();
        this.f4551C = getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle("COVER_IMAGE_BUNDLE");
            if (bundle2 != null) {
                this.f4550B = bundle2.getString("COVER_IMAGE_ID");
                this.f4549A = this.f4550B;
            } else {
                C4904y.m18639b("GroupDialog Coverstory [onCreate()] mCoverImageID is null", f4548a);
            }
        }
        m7286e();
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

    /* JADX WARN: Removed duplicated region for block: B:30:0x01ab  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m7286e() throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instructions count: 637
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.dialog.GroupDialog.m7286e():void");
    }

    /* renamed from: a */
    public Bitmap m7290a() throws UnsupportedEncodingException {
        if (this.f4555d != null) {
            String strEncode = this.f4555d + "_group_profile.png_";
            try {
                strEncode = URLEncoder.encode(strEncode, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, getClass().getSimpleName());
                }
            }
            File file = new File(GlobalApplication.m10279a().getFilesDir(), strEncode);
            try {
                if (file.exists() && file.length() > 0) {
                    Bitmap bitmapM18142a = C4812ad.m18142a(getApplicationContext(), Uri.fromFile(file));
                    if (bitmapM18142a != null) {
                        return bitmapM18142a;
                    }
                    return null;
                }
                return null;
            } catch (Exception e2) {
                C4904y.m18635a(e2, f4548a);
            }
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.group_profile_popup_edit_btn /* 2131165578 */:
                C1105b c1105b = new C1105b(Integer.parseInt(this.f4556e), this.f4555d, this.f4558g != null ? this.f4558g.length : 0, 18);
                if (!C4847bl.m18333a()) {
                    Intent intent = new Intent(getApplicationContext(), (Class<?>) BuddyGroupMemberEditActivity.class);
                    intent.putExtra("ACTIVITY_PURPOSE", 19);
                    intent.putExtra("groupInfo", c1105b);
                    intent.putExtra("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST", this.f4558g);
                    startActivity(intent);
                    finish();
                    break;
                }
                break;
            case R.id.group_profile_popup_view_profile /* 2131165579 */:
                BuddyFragment.f3586l = true;
                C1105b c1105b2 = new C1105b(Integer.parseInt(this.f4556e), this.f4555d, this.f4558g != null ? this.f4558g.length : 0, 18);
                Intent intent2 = new Intent(getApplicationContext(), (Class<?>) BuddyGroupProfileActivity.class);
                intent2.putExtra("ACTIVITY_PURPOSE", 18);
                intent2.putExtra("groupInfo", c1105b2);
                intent2.putExtra("GROUP_PROFILE_NAME", String.valueOf(this.f4555d).toString());
                intent2.putExtra("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST", this.f4558g);
                startActivity(intent2);
                finish();
                break;
            case R.id.group_profile_popup_pen_btn /* 2131165580 */:
                BuddyFragment.f3586l = true;
                if (!C4847bl.m18333a()) {
                    Intent intent3 = new Intent(getApplicationContext(), (Class<?>) BuddyEditNickNameActivity.class);
                    intent3.putExtra("PROFILE_ID", this.f4556e);
                    intent3.putExtra("PROFILE_NAME", this.f4555d);
                    intent3.putExtra("PROFILE_BUDDY_MODE", false);
                    intent3.putExtra("PROFILE_BUDDY_LIST", this.f4558g);
                    startActivity(intent3);
                    finish();
                    break;
                }
                break;
            case R.id.group_profile_popup_image /* 2131165587 */:
                Intent intent4 = new Intent(getApplicationContext(), (Class<?>) GroupProfileImageViewActivity.class);
                intent4.putExtra("GROUP_PROFILE_ID", Integer.valueOf(this.f4556e).intValue());
                intent4.putExtra("GROUP_PROFILE_NAME", String.valueOf(this.f4555d).toString());
                startActivity(intent4);
                finish();
                break;
            case R.id.group_profile_popup_chat /* 2131165589 */:
                BuddyFragment.f3586l = true;
                Intent intent5 = new Intent(getApplicationContext(), (Class<?>) ChatActivity.class);
                intent5.setFlags(67108864);
                intent5.putExtra("chatType", EnumC2300t.GROUPCHAT.m10210a());
                intent5.putExtra("receivers", this.f4558g);
                intent5.putExtra("groupId", this.f4556e);
                intent5.putExtra(ChatFragment.f5473i, true);
                startActivity(intent5);
                finish();
                break;
            case R.id.group_profile_popup_broadcast /* 2131165590 */:
                BuddyFragment.f3586l = true;
                Intent intent6 = new Intent(getApplicationContext(), (Class<?>) ChatActivity.class);
                intent6.setFlags(67108864);
                if (C2349a.m10301a("broadcast2_feature")) {
                    intent6.putExtra("chatType", EnumC2300t.BROADCAST2.m10210a());
                } else {
                    intent6.putExtra("chatType", EnumC2300t.BROADCAST.m10210a());
                }
                intent6.putExtra("receivers", this.f4558g);
                intent6.putExtra("groupId", this.f4556e);
                intent6.putExtra(ChatFragment.f5473i, true);
                startActivity(intent6);
                finish();
                break;
            case R.id.group_profile_popup_voice_call /* 2131165591 */:
                BuddyFragment.f3586l = true;
                if (C2923b.m12153h(GlobalApplication.m18732r())) {
                    if (m7288g()) {
                        if (m7287f()) {
                            try {
                                if (this.f4558g.length <= 1) {
                                    if (this.f4572u.m1487a(getApplicationContext(), false, this.f4558g[0], C4809aa.m18104a().m18121a("Push Name", ""), null) != 0) {
                                        C5179v.m19810a(getApplicationContext(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                                    }
                                } else if (this.f4558g.length > this.f4572u.m1493b(getApplicationContext(), false) - 1) {
                                    C5179v.m19811a(getApplicationContext(), getResources().getString(R.string.chaton_buddies_voice_group_limit, Integer.valueOf(this.f4572u.m1493b(getApplicationContext(), false) - 1)), 0).show();
                                } else if (this.f4572u.m1488a(getApplicationContext(), false, this.f4558g, C4809aa.m18104a().m18121a("Push Name", ""), null, this.f4555d) != 0) {
                                    C5179v.m19810a(getApplicationContext(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                                }
                                break;
                            } catch (Exception e) {
                                C4904y.m18635a(e, getClass().getSimpleName());
                                return;
                            }
                        } else {
                            startActivity(new Intent(getApplicationContext(), (Class<?>) ChatONVInstallDialog.class));
                            break;
                        }
                    } else if (!m7289h()) {
                        startActivity(new Intent(getApplicationContext(), (Class<?>) ChatONVRedirectDialog.class));
                        break;
                    }
                }
                break;
            case R.id.group_profile_popup_video_call /* 2131165592 */:
                BuddyFragment.f3586l = true;
                if (C2923b.m12153h(GlobalApplication.m18732r())) {
                    if (m7288g()) {
                        if (m7287f()) {
                            try {
                                if (this.f4558g.length <= 1) {
                                    if (this.f4572u.m1487a(getApplicationContext(), true, this.f4558g[0], C4809aa.m18104a().m18121a("Push Name", ""), null) != 0) {
                                        C5179v.m19810a(getApplicationContext(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                                    }
                                } else if (this.f4558g.length > this.f4572u.m1493b(getApplicationContext(), true) - 1) {
                                    C5179v.m19811a(getApplicationContext(), getResources().getString(R.string.chaton_buddies_video_group_limit, Integer.valueOf(this.f4572u.m1493b(getApplicationContext(), true) - 1)), 0).show();
                                } else if (this.f4572u.m1488a(getApplicationContext(), true, this.f4558g, C4809aa.m18104a().m18121a("Push Name", ""), null, this.f4555d) != 0) {
                                    C5179v.m19810a(getApplicationContext(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                                }
                                break;
                            } catch (Exception e2) {
                                C4904y.m18635a(e2, getClass().getSimpleName());
                                return;
                            }
                        } else {
                            startActivity(new Intent(getApplicationContext(), (Class<?>) ChatONVInstallDialog.class));
                            break;
                        }
                    } else if (!m7289h()) {
                        startActivity(new Intent(getApplicationContext(), (Class<?>) ChatONVRedirectDialog.class));
                        break;
                    }
                }
                break;
        }
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f4563l != null) {
            this.f4563l.setImageBitmap(null);
            this.f4563l = null;
        }
        if (this.f4576y != null) {
            this.f4576y.m9546e();
            this.f4576y.m9548g();
            this.f4576y = null;
        }
    }

    /* renamed from: f */
    private boolean m7287f() {
        boolean zM1495d;
        Exception e;
        try {
            zM1495d = this.f4572u.m1495d(GlobalApplication.m10279a());
            try {
                C4904y.m18639b("[ChatONV] isReadyToCall : " + zM1495d, f4548a);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                C4904y.m18639b("[ChatONV] isChatONVReadyToCall : " + zM1495d, f4548a);
                return zM1495d;
            }
        } catch (Exception e3) {
            zM1495d = false;
            e = e3;
        }
        C4904y.m18639b("[ChatONV] isChatONVReadyToCall : " + zM1495d, f4548a);
        return zM1495d;
    }

    /* renamed from: g */
    private boolean m7288g() {
        boolean z = false;
        try {
            if (C2948h.m12190a().m12192a(GlobalApplication.m10279a(), EnumC2949i.ChatONV)) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C4904y.m18639b("[ChatONV] isChatONVAvaiable : " + z, f4548a);
        return z;
    }

    /* renamed from: h */
    private boolean m7289h() {
        boolean z = false;
        try {
            C0416a c0416a = this.f4572u;
            if (C0416a.m1477b(GlobalApplication.m10279a())) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C4904y.m18639b("[ChatONV] isChatONVInstalled : " + z, f4548a);
        return z;
    }

    /* renamed from: b */
    public boolean m7292b() {
        C4904y.m18639b("Buddy didn't set Coverstory mContentId : " + this.f4549A, getClass().getSimpleName());
        if (TextUtils.isEmpty(this.f4549A)) {
            C1331gk.m7458a(this.f4562k);
        }
        String strM9895a = C2195i.m9895a();
        this.f4549A = strM9895a;
        if (strM9895a != null) {
            if (!m7291a(strM9895a)) {
                this.f4576y.m9540a(strM9895a, Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
            }
            return true;
        }
        C4904y.m18639b(" Coverstory Random ERROR !!", getClass().getSimpleName());
        this.f4576y.m9543b(Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
        return false;
    }

    /* renamed from: c */
    public boolean m7293c() {
        boolean z;
        String strSubstring = null;
        String str = getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        File file = new File(str);
        if (file.exists()) {
            String[] list = file.list();
            if (list == null || list.length <= 0) {
                return false;
            }
            String str2 = list[(int) (Math.random() * list.length)];
            if (str2 == null || str2.length() <= 0 || !str2.contains(".")) {
                z = false;
            } else {
                int iLastIndexOf = str2.lastIndexOf(".");
                strSubstring = str2.substring(0, iLastIndexOf);
                C4904y.m18639b("loadRandomimage filename : " + str2 + "### pos : " + iLastIndexOf + " ### randomId : " + strSubstring, f4548a);
                z = true;
            }
            if (TextUtils.isEmpty(strSubstring)) {
                return z;
            }
            String str3 = str + strSubstring + ".jpg";
            C4904y.m18639b("loadRandomimage randomId : " + strSubstring + " ### randomFile : " + str3, f4548a);
            File file2 = new File(str3);
            if (file2.length() == 0) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("checkAndSetCoverStoryRandomImages file size is 0.", f4548a);
                }
                file2.delete();
                return false;
            }
            if (!file2.exists()) {
                C4904y.m18639b("loadRandomimage randomFile doesn't exit. " + str3, f4548a);
                return false;
            }
            if (this.f4562k != null) {
                this.f4549A = strSubstring;
                this.f4562k.setImageURI(Uri.parse(str3));
                return true;
            }
            C4904y.m18639b("loadRandomimage mCoverstoryImg is null", f4548a);
            return false;
        }
        if (!C4904y.f17872b) {
            return false;
        }
        C4904y.m18639b("loadRandomimage No coverstory random images in file folder ", f4548a);
        return false;
    }

    /* renamed from: a */
    public boolean m7291a(String str) {
        boolean z = false;
        String str2 = getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        if (!new File(str2).exists()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("checkAndSetCoverStoryRandomImages No random images in file folder ", f4548a);
            }
        } else {
            String str3 = str2 + str + ".jpg";
            File file = new File(str3);
            if (file.exists()) {
                if (file.length() == 0) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("checkAndSetCoverStoryRandomImages file size is 0.", f4548a);
                    }
                    file.delete();
                } else {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("checkAndSetCoverStoryRandomImages get the random image in file folder #3#", f4548a);
                    }
                    z = true;
                    if (this.f4562k != null) {
                        this.f4562k.setImageURI(Uri.parse(str3));
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("checkAndSetCoverStoryRandomImages set the random image from file folder #4#", f4548a);
                    }
                }
            } else if (C4904y.f17872b) {
                C4904y.m18639b("checkAndSetCoverStoryRandomImages not exists the random image in file folder #2#", f4548a);
            }
        }
        return z;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBundle("COVER_IMAGE_BUNDLE", m7294d());
    }

    /* renamed from: d */
    public Bundle m7294d() {
        if (C4904y.f17872b) {
            C4904y.m18639b("GroupDialog Coverstory [saveState()] mContentId : " + this.f4549A, f4548a);
        }
        Bundle bundle = new Bundle();
        bundle.putString("COVER_IMAGE_ID", this.f4549A);
        return bundle;
    }
}
