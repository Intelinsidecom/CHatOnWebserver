package com.sec.chaton.chat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.amsoma.AMSLibs;
import com.sec.amsoma.structure.AMS_CODING_FILE_INFO;
import com.sec.amsoma.structure.AMS_UI_DATA;
import com.sec.chaton.C0062R;
import com.sec.chaton.constant.ChatONConst;
import com.sec.chaton.control.MessageControl;
import com.sec.chaton.control.task.FileDownloadTask;
import com.sec.chaton.control.task.FileDownloadTask2;
import com.sec.chaton.control.task.FileUploadTask2;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.audio.PlayAudio;
import com.sec.chaton.multimedia.emoticon.RichString;
import com.sec.chaton.multimedia.image.ViewOriginalImage;
import com.sec.chaton.multimedia.vcalendar.VCalendarDetailActivity2;
import com.sec.chaton.multimedia.vcard.ReadVCardActivity;
import com.sec.chaton.multimedia.video.VideoPreviewActivity;
import com.sec.chaton.settings.ThemeBean;
import com.sec.chaton.util.ChatONFileUtil;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.ChatOnGraphics;
import com.sec.chaton.util.Dip;
import com.sec.chaton.util.ProfileImageLoader;
import com.sec.chaton.util.StorageStateInfoUtil;
import com.sec.chaton.util.TimeAdapter;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.vip.amschaton.AMSPlayerActivity;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes.dex */
public class ChatListAdapter extends SimpleCursorAdapter implements View.OnClickListener {

    /* renamed from: p */
    public static final String[] f830p = {"_id", "message_inbox_no", "message_sever_id", "message_session_id", "message_read_status", "message_time", "message_content", "message_translated", "message_type", "message_sender", "message_is_failed", "buddy_name", "buddy_profile_status"};

    /* renamed from: A */
    private ListView f831A;

    /* renamed from: B */
    private int f832B;

    /* renamed from: C */
    private String f833C;

    /* renamed from: D */
    private String f834D;

    /* renamed from: E */
    private ArrayList f835E;

    /* renamed from: F */
    private NotifyingAsyncQueryHandler f836F;

    /* renamed from: G */
    private MediaPlayer f837G;

    /* renamed from: H */
    private OnChatItemClickListener f838H;

    /* renamed from: I */
    private Button f839I;

    /* renamed from: a */
    String f840a;

    /* renamed from: b */
    String f841b;

    /* renamed from: c */
    String f842c;

    /* renamed from: d */
    String[] f843d;

    /* renamed from: e */
    String f844e;

    /* renamed from: f */
    String f845f;

    /* renamed from: g */
    String f846g;

    /* renamed from: h */
    String f847h;

    /* renamed from: i */
    String f848i;

    /* renamed from: j */
    String f849j;

    /* renamed from: k */
    String f850k;

    /* renamed from: l */
    public ArrayList f851l;

    /* renamed from: m */
    Float f852m;

    /* renamed from: n */
    int f853n;

    /* renamed from: o */
    int f854o;

    /* renamed from: q */
    Handler f855q;

    /* renamed from: r */
    NotifyingAsyncQueryHandler.AsyncQueryListener f856r;

    /* renamed from: v */
    private ThemeBean f857v;

    /* renamed from: w */
    private LayoutInflater f858w;

    /* renamed from: x */
    private Context f859x;

    /* renamed from: y */
    private ChatONContract.InBoxTable.ChatType f860y;

    /* renamed from: z */
    private int f861z;

    public class BalloonHolder {

        /* renamed from: A */
        CheckBox f862A;

        /* renamed from: B */
        Button f863B;

        /* renamed from: C */
        Button f864C;

        /* renamed from: D */
        Button f865D;

        /* renamed from: E */
        Button f866E;

        /* renamed from: F */
        LinearLayout f867F;

        /* renamed from: G */
        TextView f868G;

        /* renamed from: H */
        ImageView f869H;

        /* renamed from: I */
        TextView f870I;

        /* renamed from: J */
        ImageView f871J;

        /* renamed from: K */
        LinearLayout f872K;

        /* renamed from: L */
        ImageView f873L;

        /* renamed from: M */
        TextView f874M;

        /* renamed from: N */
        TextView f875N;

        /* renamed from: O */
        TextView f876O;

        /* renamed from: P */
        CheckBox f877P;

        /* renamed from: Q */
        ImageView f878Q;

        /* renamed from: R */
        TextView f879R;

        /* renamed from: S */
        public ProgressBar f880S;

        /* renamed from: T */
        ImageButton f881T;

        /* renamed from: U */
        ProgressBar f882U;

        /* renamed from: a */
        public String f883a;

        /* renamed from: b */
        TextView f884b;

        /* renamed from: c */
        TextView f885c;

        /* renamed from: d */
        TextView f886d;

        /* renamed from: e */
        TextView f887e;

        /* renamed from: f */
        TextView f888f;

        /* renamed from: g */
        TextView f889g;

        /* renamed from: h */
        ViewGroup f890h;

        /* renamed from: i */
        ViewGroup f891i;

        /* renamed from: j */
        ViewGroup f892j;

        /* renamed from: k */
        TextView f893k;

        /* renamed from: l */
        ImageView f894l;

        /* renamed from: m */
        LinearLayout f895m;

        /* renamed from: n */
        TextView f896n;

        /* renamed from: o */
        TextView f897o;

        /* renamed from: p */
        ImageView f898p;

        /* renamed from: q */
        ImageView f899q;

        /* renamed from: r */
        LinearLayout f900r;

        /* renamed from: s */
        ImageView f901s;

        /* renamed from: t */
        TextView f902t;

        /* renamed from: u */
        RelativeLayout f903u;

        /* renamed from: v */
        TextView f904v;

        /* renamed from: w */
        public ProgressBar f905w;

        /* renamed from: x */
        public ProgressBar f906x;

        /* renamed from: y */
        public Button f907y;

        /* renamed from: z */
        CheckBox f908z;
    }

    public class OnCheckClickListener implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ ChatListAdapter f909a;

        /* renamed from: b */
        private CheckBox f910b;

        /* renamed from: c */
        private String f911c;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Boolean bool;
            if (!this.f910b.isChecked()) {
                if (this.f909a.f851l.contains(this.f911c)) {
                    this.f909a.f851l.remove(this.f911c);
                }
                this.f910b.setChecked(false);
                return;
            }
            SparseBooleanArray checkedItemPositions = this.f909a.f831A.getCheckedItemPositions();
            if (checkedItemPositions.size() != 0) {
                int i = 0;
                while (true) {
                    if (i >= this.f909a.f831A.getAdapter().getCount()) {
                        bool = true;
                        break;
                    }
                    if (!checkedItemPositions.get(i)) {
                        Cursor cursor = (Cursor) this.f909a.f831A.getAdapter().getItem(i);
                        if (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(cursor.getLong(cursor.getColumnIndex("message_time")))).split(" ")[0].equals(this.f911c)) {
                            bool = false;
                            break;
                        }
                    }
                    i++;
                }
                if (bool.booleanValue()) {
                    if (this.f909a.f851l.contains(this.f911c)) {
                        this.f909a.f851l.remove(this.f911c);
                    } else {
                        this.f909a.f851l.add(this.f911c);
                    }
                } else if (this.f909a.f851l.contains(this.f911c)) {
                    this.f909a.f851l.remove(this.f911c);
                }
                this.f910b.setChecked(true);
            }
        }
    }

    public class OnDateClickListener implements View.OnClickListener {

        /* renamed from: b */
        private CheckBox f913b;

        /* renamed from: c */
        private String f914c;

        public OnDateClickListener(CheckBox checkBox, String str) {
            this.f913b = checkBox;
            this.f914c = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Cursor cursor = (Cursor) ChatListAdapter.this.f831A.getAdapter().getItem(ChatListAdapter.this.f831A.getPositionForView(view));
            String[] strArrSplit = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(cursor.getLong(cursor.getColumnIndex("message_time")))).split(" ");
            for (int i = 0; i < ChatListAdapter.this.f831A.getAdapter().getCount(); i++) {
                Cursor cursor2 = (Cursor) ChatListAdapter.this.f831A.getAdapter().getItem(i);
                String[] strArrSplit2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(cursor2.getLong(cursor2.getColumnIndex("message_time")))).split(" ");
                if (ChatListAdapter.this.f851l.contains(this.f914c)) {
                    if (strArrSplit[0].equals(strArrSplit2[0])) {
                        ChatListAdapter.this.f831A.setItemChecked(i, false);
                    }
                } else if (strArrSplit[0].equals(strArrSplit2[0])) {
                    ChatListAdapter.this.f831A.setItemChecked(i, true);
                }
            }
            if (ChatListAdapter.this.f851l.contains(this.f914c)) {
                this.f913b.setChecked(false);
                ChatListAdapter.this.f851l.remove(this.f914c);
            } else {
                this.f913b.setChecked(true);
                ChatListAdapter.this.f851l.add(this.f914c);
            }
            ChatListAdapter.this.m789a();
        }
    }

    public class OnSendCancelClickListener implements View.OnClickListener {

        /* renamed from: b */
        private long f916b;

        /* renamed from: c */
        private ChatONContract.MessageTable.MsgContentType f917c;

        public OnSendCancelClickListener(long j, ChatONContract.MessageTable.MsgContentType msgContentType) {
            this.f916b = j;
            this.f917c = msgContentType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatListAdapter.this.f838H.mo759a(view, this.f916b, this.f917c);
        }
    }

    public class OnSendFailClickListener implements View.OnClickListener {

        /* renamed from: b */
        private long f919b;

        /* renamed from: c */
        private int f920c;

        public OnSendFailClickListener(long j, int i) {
            this.f919b = j;
            this.f920c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (this.f920c) {
                case 1:
                    ChatListAdapter.this.f838H.mo758a(view, this.f919b, 1);
                    break;
                case 2:
                    ChatListAdapter.this.f838H.mo758a(view, this.f919b, 2);
                    break;
                case 3:
                    ChatListAdapter.this.f838H.mo758a(view, this.f919b, 3);
                    break;
            }
        }
    }

    public class OnThumbnailClickListener implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ ChatListAdapter f921a;

        /* renamed from: b */
        private Uri f922b;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f921a.f838H.mo760a(view, this.f922b);
        }
    }

    public class OnprofileClickListener implements View.OnClickListener {

        /* renamed from: b */
        private ProfileImageView f924b;

        /* renamed from: c */
        private String f925c;

        /* renamed from: d */
        private String f926d;

        public OnprofileClickListener(ProfileImageView profileImageView, String str, String str2) {
            this.f924b = profileImageView;
            this.f925c = str;
            this.f926d = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatListAdapter.this.f838H.mo761a(view, this.f924b, this.f925c, this.f926d);
        }
    }

    public class onDownCancelClickListener implements View.OnClickListener {

        /* renamed from: b */
        private long f928b;

        public onDownCancelClickListener(long j) {
            this.f928b = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatListAdapter.this.f838H.mo757a(view, this.f928b);
        }
    }

    public ChatListAdapter(Context context, ListView listView, int i, Cursor cursor, ChatONContract.InBoxTable.ChatType chatType, ArrayList arrayList, Button button) {
        super(context, i, cursor, f830p, null, 2);
        this.f857v = (ThemeBean) ThemeBean.f3136a.get(0);
        this.f840a = "";
        this.f841b = "";
        this.f842c = "";
        this.f844e = "///mnt/sdcard/ChatON/";
        this.f845f = "/mnt/sdcard/ChatON/audio/";
        this.f846g = "/mnt/sdcard/ChatON/contact/";
        this.f847h = "/mnt/sdcard/ChatON/geo/";
        this.f848i = "/mnt/sdcard/ChatON/calendar/";
        this.f849j = "/mnt/sdcard/ChatON/video/";
        this.f850k = "/mnt/sdcard/ChatON/downloads/";
        this.f832B = 0;
        this.f851l = new ArrayList();
        this.f852m = Float.valueOf(0.0f);
        this.f853n = 0;
        this.f854o = 0;
        this.f837G = new MediaPlayer();
        this.f855q = new HandlerC0153o(this);
        this.f856r = new C0150l(this);
        this.f839I = button;
        this.f831A = listView;
        this.f859x = context;
        this.f860y = chatType;
        this.f858w = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f836F = new NotifyingAsyncQueryHandler(this.f831A.getContext().getContentResolver(), this.f856r);
        this.f835E = arrayList;
        this.f834D = ChatONPref.m3519a().getString("Default Font Size", "");
        this.f833C = ChatONPref.m3519a().getString("setting_change_bubble", "");
        if (this.f834D.equals("size50")) {
            this.f852m = Float.valueOf(8.0f);
            this.f853n = 14;
            this.f854o = 22;
            return;
        }
        if (this.f834D.equals("size70")) {
            this.f852m = Float.valueOf(11.2f);
            this.f853n = 10;
            this.f854o = 16;
            return;
        }
        if (this.f834D.equals("size100")) {
            this.f852m = Float.valueOf(16.0f);
            this.f853n = 4;
            this.f854o = 10;
        } else if (this.f834D.equals("size150")) {
            this.f852m = Float.valueOf(24.0f);
            this.f853n = 4;
            this.f854o = 10;
        } else if (this.f834D.equals("size200")) {
            this.f852m = Float.valueOf(32.0f);
            this.f853n = 4;
            this.f854o = 10;
        } else {
            this.f852m = Float.valueOf(16.0f);
            this.f853n = 4;
            this.f854o = 10;
        }
    }

    /* renamed from: a */
    private void m774a(View view, BalloonHolder balloonHolder, long j, ChatONContract.InBoxTable.ChatType chatType, ChatONContract.MessageTable.MsgContentType msgContentType) {
        balloonHolder.f880S.setVisibility(8);
        balloonHolder.f866E.setVisibility(8);
        if (chatType == ChatONContract.InBoxTable.ChatType.ONETOONE && msgContentType == ChatONContract.MessageTable.MsgContentType.TEXT && this.f861z != 1) {
            balloonHolder.f864C.setVisibility(0);
            balloonHolder.f864C.setOnClickListener(new OnSendFailClickListener(j, 1));
            balloonHolder.f888f.setVisibility(0);
        } else {
            balloonHolder.f864C.setVisibility(8);
            balloonHolder.f888f.setVisibility(8);
        }
        balloonHolder.f887e.setVisibility(0);
        balloonHolder.f865D.setVisibility(0);
        balloonHolder.f865D.setOnClickListener(new OnSendFailClickListener(j, 2));
        balloonHolder.f863B.setVisibility(0);
        balloonHolder.f863B.setOnClickListener(new OnSendFailClickListener(j, 3));
        balloonHolder.f875N.setVisibility(8);
        balloonHolder.f889g.setVisibility(8);
    }

    /* renamed from: a */
    private void m775a(TextView textView, int i, Long l) {
        if (this.f841b == null) {
            ((View) textView.getParent()).setVisibility(8);
        } else {
            ((View) textView.getParent()).setVisibility(0);
            textView.setText(TimeAdapter.m3679a(l.longValue(), "h:mm aa"));
        }
    }

    /* renamed from: a */
    private void m776a(TextView textView, int i, String[] strArr, String str, CheckBox checkBox, String str2, long j, RelativeLayout relativeLayout) {
        new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(System.currentTimeMillis()));
        if (i == 0) {
            relativeLayout.setVisibility(0);
            textView.setText(new SimpleDateFormat("d MMMM,yyyy", Locale.ENGLISH).format(Long.valueOf(j)));
            if (this.f831A.getChoiceMode() == 2) {
                checkBox.setVisibility(0);
            }
        } else if (this.f840a.equals(strArr[0])) {
            relativeLayout.setVisibility(8);
            if (this.f831A.getChoiceMode() == 2) {
                checkBox.setVisibility(8);
            }
        } else {
            relativeLayout.setVisibility(0);
            textView.setText(new SimpleDateFormat("d MMMM,yyyy", Locale.ENGLISH).format(Long.valueOf(j)));
            if (this.f831A.getChoiceMode() == 2) {
                checkBox.setVisibility(0);
            }
        }
        textView.setOnLongClickListener(new ViewOnLongClickListenerC0155q(this));
        textView.setOnClickListener(new ViewOnClickListenerC0152n(this, str, str2));
    }

    /* renamed from: a */
    public static void m777a(ChatFragment chatFragment, ChatONContract.MessageTable.MsgContentType msgContentType, String str, ProgressDialog progressDialog) {
        if (str == null || ChatONConst.f1339c.equals(str)) {
            Toast.makeText(chatFragment.getActivity(), C0062R.string.media_download_fail, 0).show();
            return;
        }
        ChatONLogWriter.m3509d("file uri:" + str);
        String strSubstring = (!str.startsWith("file:") || msgContentType == ChatONContract.MessageTable.MsgContentType.AUDIO) ? str : str.substring(6);
        ChatONLogWriter.m3509d("Download_uri:" + strSubstring);
        if (msgContentType == ChatONContract.MessageTable.MsgContentType.CALENDAR) {
            if (strSubstring != null) {
                Intent intent = new Intent(chatFragment.getActivity(), (Class<?>) VCalendarDetailActivity2.class);
                intent.putExtra("ACTIVITY_PURPOSE", 2);
                intent.putExtra("URI", strSubstring);
                chatFragment.startActivity(intent);
                return;
            }
            return;
        }
        if (msgContentType == ChatONContract.MessageTable.MsgContentType.CONTACT) {
            if (strSubstring != null) {
                Intent intent2 = new Intent(chatFragment.getActivity(), (Class<?>) ReadVCardActivity.class);
                intent2.putExtra("URI", strSubstring);
                intent2.putExtra("VCARD_SAVE", true);
                chatFragment.startActivity(intent2);
                return;
            }
            return;
        }
        if (msgContentType == ChatONContract.MessageTable.MsgContentType.AUDIO) {
            if (!StorageStateInfoUtil.m3677a()) {
                Toast.makeText(chatFragment.getActivity(), C0062R.string.sdcard_not_found, 0).show();
                return;
            }
            Intent intent3 = new Intent();
            intent3.setAction("android.intent.action.VIEW");
            intent3.setDataAndType(Uri.parse(strSubstring), "audio/*");
            chatFragment.startActivity(intent3);
            intent3.putExtra(ChatFragment.f723b, strSubstring);
            intent3.putExtra(PlayAudio.f2036a, PlayAudio.f2038c);
            chatFragment.startActivity(intent3);
            return;
        }
        if (msgContentType == ChatONContract.MessageTable.MsgContentType.VIDEO) {
            if (!StorageStateInfoUtil.m3677a()) {
                Toast.makeText(chatFragment.getActivity(), C0062R.string.sdcard_not_found, 0).show();
                return;
            }
            Intent intent4 = new Intent(chatFragment.getActivity(), (Class<?>) VideoPreviewActivity.class);
            intent4.putExtra("URI", strSubstring);
            chatFragment.startActivityForResult(intent4, 14);
            return;
        }
        if (msgContentType != ChatONContract.MessageTable.MsgContentType.IMAGE) {
            chatFragment.startActivity(new Intent("android.intent.action.VIEW"));
            return;
        }
        AMSLibs aMSLibs = new AMSLibs();
        aMSLibs.VipAMS_Init();
        AMS_UI_DATA ams_ui_data = new AMS_UI_DATA();
        AMS_CODING_FILE_INFO[] ams_coding_file_infoArr = {new AMS_CODING_FILE_INFO()};
        ams_coding_file_infoArr[0].setM_eExportType(0);
        ams_coding_file_infoArr[0].setM_strFileName(strSubstring);
        if (aMSLibs.VipAMS_IsAMSJPEGFile(ams_ui_data, ams_coding_file_infoArr) == 0) {
            Intent intent5 = new Intent(chatFragment.getActivity(), (Class<?>) AMSPlayerActivity.class);
            intent5.putExtra("AMS_FILE_PATH", strSubstring);
            intent5.putExtra("VIEWER_MODE", 1002);
            chatFragment.startActivity(intent5);
            return;
        }
        Intent intent6 = new Intent(chatFragment.getActivity(), (Class<?>) ViewOriginalImage.class);
        intent6.putExtra("URI", strSubstring);
        intent6.putExtra(ChatONConst.f1341e, true);
        chatFragment.startActivityForResult(intent6, 13);
    }

    /* renamed from: a */
    private void m778a(BalloonHolder balloonHolder, int i, boolean z, String str) {
        balloonHolder.f908z.setVisibility(0);
        balloonHolder.f877P.setVisibility(0);
        balloonHolder.f908z.setOnCheckedChangeListener(new C0151m(this, i, balloonHolder, str));
        balloonHolder.f877P.setOnCheckedChangeListener(new C0154p(this, i, balloonHolder, str));
        balloonHolder.f862A.setOnClickListener(new OnDateClickListener(balloonHolder.f862A, str));
        if (z) {
            if (this.f831A.isItemChecked(i)) {
                balloonHolder.f877P.setChecked(true);
            } else {
                balloonHolder.f877P.setChecked(false);
            }
        } else if (this.f831A.isItemChecked(i)) {
            balloonHolder.f908z.setChecked(true);
        } else {
            balloonHolder.f908z.setChecked(false);
        }
        m790a(balloonHolder.f877P, balloonHolder.f862A, str);
        if (this.f851l.contains(str)) {
            balloonHolder.f862A.setChecked(true);
        } else {
            balloonHolder.f862A.setChecked(false);
        }
    }

    /* renamed from: a */
    private void m779a(BalloonHolder balloonHolder, String str) throws Resources.NotFoundException {
        String str2;
        balloonHolder.f886d.setVisibility(8);
        balloonHolder.f891i.setVisibility(8);
        balloonHolder.f892j.setVisibility(8);
        balloonHolder.f885c.setVisibility(0);
        String[] strArrSplit = str.split(";");
        StringBuilder sb = new StringBuilder();
        if (strArrSplit.length > 0) {
            String str3 = "";
            for (String str4 : strArrSplit) {
                String[] strArrSplit2 = str4.split(",");
                if (strArrSplit2.length > 2) {
                    str3 = strArrSplit2[0];
                    sb.append(ChatUtil.m800b(strArrSplit2[2].replace('\n', ' '))).append(",");
                }
            }
            String string = "";
            if (str3.equals("ENTER")) {
                string = GlobalApplication.m2388f().getString(C0062R.string.chat_view_system_invite);
            } else if (str3.equals("LEAVE")) {
                string = GlobalApplication.m2388f().getString(C0062R.string.chat_view_system_leave);
            } else if (str3.equals("INVITE")) {
                string = GlobalApplication.m2388f().getString(C0062R.string.noti_invite_member);
            }
            str2 = sb.length() > 1 ? String.format(string, sb.substring(0, sb.length() - 1)) : String.format(string, GlobalApplication.m2388f().getString(C0062R.string.unknown));
        } else {
            str2 = str;
        }
        balloonHolder.f885c.setText(str2);
    }

    /* renamed from: a */
    private void m780a(BalloonHolder balloonHolder, String str, String str2, String str3, int i) {
        ProfileImageView profileImageView = (ProfileImageView) balloonHolder.f894l;
        if (str == null) {
            profileImageView.setImageBitmap(null);
            balloonHolder.f893k.setText(str3);
        } else {
            profileImageView.setOnClickListener(new OnprofileClickListener(profileImageView, str, str2));
            ProfileImageLoader.m3610a(this.f859x).m3624a(balloonHolder.f894l, str, i);
            balloonHolder.f893k.setText(str2);
        }
    }

    /* renamed from: a */
    private void m781a(BalloonHolder balloonHolder, String str, boolean z) {
        if (z) {
            if (str == null || str == "") {
                balloonHolder.f868G.setText(str);
                balloonHolder.f868G.setTextSize(this.f852m.floatValue());
            } else {
                balloonHolder.f868G.setTextSize(this.f852m.floatValue());
                balloonHolder.f868G.setText(new RichString(this.f859x.getResources(), str, 40));
            }
            balloonHolder.f868G.setTextColor(-16777216);
            balloonHolder.f868G.setVisibility(0);
            balloonHolder.f871J.setVisibility(8);
            balloonHolder.f872K.setVisibility(8);
            return;
        }
        if (str == null || str == "") {
            balloonHolder.f896n.setText(str);
            balloonHolder.f896n.setTextSize(this.f852m.floatValue());
        } else {
            balloonHolder.f896n.setTextSize(this.f852m.floatValue());
            balloonHolder.f896n.setText(new RichString(this.f859x.getResources(), str, 40));
        }
        balloonHolder.f896n.setTextColor(-16777216);
        balloonHolder.f896n.setVisibility(0);
        balloonHolder.f899q.setVisibility(8);
        balloonHolder.f900r.setVisibility(8);
    }

    /* renamed from: a */
    private void m782a(BalloonHolder balloonHolder, String str, boolean z, String str2) {
        if (z) {
            balloonHolder.f873L.setImageResource(C0062R.drawable.messenger_chat_calender);
            balloonHolder.f873L.setOnClickListener(this);
            balloonHolder.f874M.setText(str2);
            balloonHolder.f874M.setVisibility(0);
            balloonHolder.f873L.setVisibility(0);
            balloonHolder.f871J.setVisibility(8);
            balloonHolder.f868G.setVisibility(8);
            balloonHolder.f872K.setVisibility(0);
            return;
        }
        balloonHolder.f901s.setImageResource(C0062R.drawable.messenger_chat_calender);
        balloonHolder.f901s.setOnClickListener(this);
        balloonHolder.f902t.setText(str2);
        balloonHolder.f902t.setVisibility(0);
        balloonHolder.f901s.setVisibility(0);
        balloonHolder.f899q.setVisibility(8);
        balloonHolder.f896n.setVisibility(8);
        balloonHolder.f900r.setVisibility(0);
    }

    /* renamed from: b */
    private void m784b(BalloonHolder balloonHolder, String str, boolean z) {
        Bitmap bitmapM3540b;
        Bitmap bitmapM3540b2;
        if (z) {
            ChatONLogWriter.m3509d("Uri.parse(content):" + str);
            if (str == null) {
                balloonHolder.f871J.setImageBitmap(null);
            } else if (ChatONConst.f1339c.equals(str)) {
                balloonHolder.f871J.setImageResource(C0062R.drawable.slideshow_error_top);
            } else {
                try {
                    bitmapM3540b2 = ChatOnGraphics.m3540b(this.f859x, Uri.parse(str));
                } catch (OutOfMemoryError e) {
                    Toast.makeText(this.f859x, C0062R.string.chat_view_memory_error, 0).show();
                    bitmapM3540b2 = null;
                }
                if (bitmapM3540b2 != null) {
                    balloonHolder.f871J.setImageBitmap(bitmapM3540b2);
                } else {
                    balloonHolder.f871J.setImageBitmap(null);
                }
            }
            balloonHolder.f871J.setOnClickListener(this);
            balloonHolder.f868G.setVisibility(8);
            balloonHolder.f871J.setVisibility(0);
            balloonHolder.f872K.setVisibility(8);
            return;
        }
        ChatONLogWriter.m3509d("Uri.parse(content):" + str);
        if (str == null) {
            balloonHolder.f899q.setImageBitmap(null);
        } else if (ChatONConst.f1339c.equals(str)) {
            balloonHolder.f899q.setImageResource(C0062R.drawable.slideshow_error_top);
            balloonHolder.f899q.setOnClickListener(this);
        } else {
            try {
                bitmapM3540b = ChatOnGraphics.m3540b(this.f859x, Uri.parse(str));
            } catch (OutOfMemoryError e2) {
                Toast.makeText(this.f859x, C0062R.string.chat_view_memory_error, 0).show();
                bitmapM3540b = null;
            }
            if (bitmapM3540b != null) {
                balloonHolder.f899q.setImageBitmap(bitmapM3540b);
            } else {
                balloonHolder.f899q.setImageBitmap(null);
            }
            balloonHolder.f899q.setOnClickListener(this);
        }
        balloonHolder.f896n.setVisibility(8);
        balloonHolder.f899q.setVisibility(0);
        balloonHolder.f900r.setVisibility(8);
    }

    /* renamed from: b */
    private void m785b(BalloonHolder balloonHolder, String str, boolean z, String str2) {
        if (z) {
            balloonHolder.f873L.setImageResource(C0062R.drawable.messenger_chat_contact);
            balloonHolder.f873L.setOnClickListener(this);
            balloonHolder.f874M.setText(str2);
            balloonHolder.f874M.setVisibility(0);
            balloonHolder.f873L.setVisibility(0);
            balloonHolder.f871J.setVisibility(8);
            balloonHolder.f868G.setVisibility(8);
            balloonHolder.f872K.setVisibility(0);
            return;
        }
        balloonHolder.f901s.setImageResource(C0062R.drawable.messenger_chat_contact);
        balloonHolder.f901s.setOnClickListener(this);
        balloonHolder.f902t.setText(str2);
        balloonHolder.f902t.setVisibility(0);
        balloonHolder.f901s.setVisibility(0);
        balloonHolder.f899q.setVisibility(8);
        balloonHolder.f896n.setVisibility(8);
        balloonHolder.f900r.setVisibility(0);
    }

    /* renamed from: c */
    private void m786c(BalloonHolder balloonHolder, String str, boolean z) {
        if (z) {
            balloonHolder.f871J.setImageResource(C0062R.drawable.messenger_chat_music);
            balloonHolder.f871J.setOnClickListener(this);
            balloonHolder.f868G.setVisibility(8);
            balloonHolder.f871J.setVisibility(0);
            balloonHolder.f872K.setVisibility(8);
            return;
        }
        balloonHolder.f899q.setImageResource(C0062R.drawable.messenger_chat_music);
        balloonHolder.f899q.setOnClickListener(this);
        balloonHolder.f896n.setVisibility(8);
        balloonHolder.f899q.setVisibility(0);
        balloonHolder.f900r.setVisibility(8);
    }

    /* renamed from: d */
    private void m787d(BalloonHolder balloonHolder, String str, boolean z) {
        Bitmap bitmapCreateVideoThumbnail = null;
        String strSubstring = (str == null || !str.contains("file://")) ? str : str.substring(7);
        try {
            bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(strSubstring, 3);
        } catch (OutOfMemoryError e) {
            Toast.makeText(this.f859x, C0062R.string.chat_view_memory_error, 0).show();
        }
        ChatONLogWriter.m3506b("*********** video file path : " + strSubstring, null);
        if (z) {
            if (bitmapCreateVideoThumbnail != null) {
                balloonHolder.f871J.setImageDrawable(new LayerDrawable(new Drawable[]{new BitmapDrawable(this.f859x.getResources(), bitmapCreateVideoThumbnail), this.f859x.getResources().getDrawable(C0062R.drawable.msg_play_button_03)}));
            } else {
                balloonHolder.f871J.setImageResource(C0062R.drawable.slideshow_video_top);
            }
            balloonHolder.f871J.setOnClickListener(this);
            balloonHolder.f868G.setVisibility(8);
            balloonHolder.f871J.setVisibility(0);
            balloonHolder.f872K.setVisibility(8);
            return;
        }
        if (bitmapCreateVideoThumbnail != null) {
            balloonHolder.f899q.setImageDrawable(new LayerDrawable(new Drawable[]{new BitmapDrawable(this.f859x.getResources(), bitmapCreateVideoThumbnail), this.f859x.getResources().getDrawable(C0062R.drawable.msg_play_button_03)}));
        } else {
            balloonHolder.f899q.setImageResource(C0062R.drawable.slideshow_video_top);
        }
        balloonHolder.f899q.setOnClickListener(this);
        balloonHolder.f896n.setVisibility(8);
        balloonHolder.f899q.setVisibility(0);
        balloonHolder.f900r.setVisibility(8);
    }

    /* renamed from: e */
    private void m788e(BalloonHolder balloonHolder, String str, boolean z) {
        if (z) {
            if (ChatONConst.m1972a()) {
                balloonHolder.f871J.setImageResource(C0062R.drawable.messenger_chat_pin2);
            } else {
                balloonHolder.f871J.setImageResource(C0062R.drawable.messenger_chat_pin_non);
            }
            balloonHolder.f871J.setOnClickListener(this);
            balloonHolder.f868G.setVisibility(8);
            balloonHolder.f871J.setVisibility(0);
            balloonHolder.f872K.setVisibility(8);
            return;
        }
        if (ChatONConst.m1972a()) {
            balloonHolder.f899q.setImageResource(C0062R.drawable.messenger_chat_pin2);
        } else {
            balloonHolder.f899q.setImageResource(C0062R.drawable.messenger_chat_pin_non);
        }
        balloonHolder.f899q.setOnClickListener(this);
        balloonHolder.f896n.setVisibility(8);
        balloonHolder.f899q.setVisibility(0);
        balloonHolder.f900r.setVisibility(8);
    }

    /* renamed from: a */
    public void m789a() {
        SparseBooleanArray checkedItemPositions = this.f831A.getCheckedItemPositions();
        if (checkedItemPositions.size() != 0) {
            for (int i = 0; i < this.f831A.getAdapter().getCount(); i++) {
                if (checkedItemPositions.get(i)) {
                    this.f839I.setEnabled(true);
                    return;
                }
                this.f839I.setEnabled(false);
            }
        }
    }

    /* renamed from: a */
    public void m790a(CheckBox checkBox, CheckBox checkBox2, String str) {
        Boolean bool;
        SparseBooleanArray checkedItemPositions = this.f831A.getCheckedItemPositions();
        if (checkedItemPositions.size() != 0) {
            int i = 0;
            while (true) {
                if (i >= this.f831A.getAdapter().getCount()) {
                    bool = true;
                    break;
                }
                if (!checkedItemPositions.get(i)) {
                    Cursor cursor = (Cursor) this.f831A.getAdapter().getItem(i);
                    Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("message_time")));
                    ChatONContract.MessageTable.MsgContentType msgContentTypeM2195a = ChatONContract.MessageTable.MsgContentType.m2195a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
                    String[] strArrSplit = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lValueOf).split(" ");
                    if (msgContentTypeM2195a != ChatONContract.MessageTable.MsgContentType.SYSTEM && strArrSplit[0].equals(str)) {
                        bool = false;
                        break;
                    }
                }
                i++;
            }
            if (bool.booleanValue()) {
                if (!this.f851l.contains(str)) {
                    this.f851l.add(str);
                }
            } else if (this.f851l.contains(str)) {
                this.f851l.remove(str);
            }
        }
        if (this.f851l.contains(str)) {
            checkBox2.setChecked(true);
        } else {
            checkBox2.setChecked(false);
        }
        m789a();
    }

    /* renamed from: a */
    public void m791a(OnChatItemClickListener onChatItemClickListener) {
        this.f838H = onChatItemClickListener;
    }

    @Override // android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) throws Resources.NotFoundException {
        String str;
        String str2;
        BalloonHolder balloonHolder = (BalloonHolder) view.getTag();
        int position = cursor.getPosition();
        long j = cursor.getLong(cursor.getColumnIndex("_id"));
        String string = cursor.getString(cursor.getColumnIndex("message_sever_id"));
        cursor.getString(cursor.getColumnIndex("message_session_id"));
        Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("message_time")));
        String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
        cursor.getString(cursor.getColumnIndex("message_translated"));
        String string3 = cursor.getString(cursor.getColumnIndex("message_sender"));
        String string4 = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
        ChatONContract.MessageTable.MsgContentType msgContentTypeM2195a = ChatONContract.MessageTable.MsgContentType.m2195a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
        int i = cursor.getInt(cursor.getColumnIndex("message_read_status"));
        int i2 = cursor.getInt(cursor.getColumnIndex("message_type"));
        String string5 = cursor.getString(cursor.getColumnIndex("buddy_no"));
        String string6 = cursor.getString(cursor.getColumnIndex("buddy_name"));
        int i3 = cursor.getInt(cursor.getColumnIndex("buddy_profile_status"));
        String string7 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
        String string8 = cursor.getString(cursor.getColumnIndex("message_formatted"));
        int i4 = cursor.getInt(cursor.getColumnIndex("message_is_failed"));
        int i5 = cursor.getInt(cursor.getColumnIndex("message_stored_ext"));
        this.f861z = cursor.getInt(cursor.getColumnIndex("opponent_show_phone_number"));
        String[] strArrSplit = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lValueOf).split(" ");
        if (cursor.getCount() > 1) {
            if (cursor.getPosition() != 0) {
                cursor.moveToPosition(cursor.getPosition() - 1);
            } else {
                cursor.moveToPosition(cursor.getPosition() + 1);
            }
            this.f843d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(cursor.getLong(cursor.getColumnIndex("message_time")))).split(" ");
        }
        if (strArrSplit.length == 2) {
            this.f840a = strArrSplit[0];
            this.f841b = strArrSplit[1];
        }
        if (i4 != 0 || i2 == 0) {
            balloonHolder.f903u.setVisibility(8);
            balloonHolder.f862A.setVisibility(8);
        } else {
            m776a(balloonHolder.f884b, position, this.f843d, string4, balloonHolder.f862A, this.f840a, lValueOf.longValue(), balloonHolder.f903u);
        }
        boolean z = ChatONPref.m3519a().getString("msisdn", "").equals(string3);
        if (z) {
            balloonHolder.f883a = String.valueOf(j);
        } else {
            balloonHolder.f883a = string;
        }
        if (this.f831A.getChoiceMode() == 2) {
            m778a(balloonHolder, position, z, this.f840a);
            balloonHolder.f896n.setMaxWidth((int) Dip.m3571a(140.0f));
        } else {
            balloonHolder.f908z.setVisibility(8);
            balloonHolder.f862A.setVisibility(8);
            balloonHolder.f877P.setVisibility(8);
            balloonHolder.f896n.setMaxWidth((int) Dip.m3571a(160.0f));
            this.f851l.clear();
        }
        if (msgContentTypeM2195a != ChatONContract.MessageTable.MsgContentType.SYSTEM) {
            balloonHolder.f885c.setVisibility(8);
            if (z) {
                balloonHolder.f891i.setVisibility(0);
                balloonHolder.f892j.setVisibility(8);
                balloonHolder.f878Q.setVisibility(8);
                balloonHolder.f879R.setVisibility(8);
                m775a(balloonHolder.f875N, cursor.getPosition(), lValueOf);
                balloonHolder.f868G.setMaxWidth((int) Dip.m3571a(160.0f));
                if (i2 == 0) {
                    balloonHolder.f889g.setVisibility(8);
                    balloonHolder.f864C.setVisibility(8);
                    balloonHolder.f865D.setVisibility(8);
                    balloonHolder.f863B.setVisibility(8);
                    balloonHolder.f887e.setVisibility(8);
                    balloonHolder.f888f.setVisibility(8);
                    if (msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.TEXT || msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.GEO) {
                        balloonHolder.f882U.setVisibility(8);
                        balloonHolder.f880S.setVisibility(0);
                        balloonHolder.f866E.setVisibility(8);
                    } else {
                        if (msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.IMAGE || msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.VIDEO) {
                            FileUploadTask2 fileUploadTask2 = (FileUploadTask2) MessageControl.m2012a(string4).f1366c.get(Long.valueOf(j));
                            if (fileUploadTask2 != null) {
                                balloonHolder.f882U.setVisibility(0);
                                fileUploadTask2.m2137a(view);
                                balloonHolder.f880S.setVisibility(8);
                                balloonHolder.f866E.setVisibility(0);
                            } else {
                                balloonHolder.f882U.setVisibility(8);
                                if (i4 == 3) {
                                    balloonHolder.f880S.setVisibility(0);
                                } else {
                                    balloonHolder.f880S.setVisibility(8);
                                }
                                balloonHolder.f866E.setVisibility(8);
                            }
                        } else {
                            balloonHolder.f880S.setVisibility(0);
                            balloonHolder.f882U.setVisibility(8);
                            balloonHolder.f866E.setVisibility(8);
                        }
                        balloonHolder.f866E.setOnClickListener(new OnSendCancelClickListener(j, msgContentTypeM2195a));
                    }
                    balloonHolder.f875N.setVisibility(8);
                } else if (i2 == 1 || i2 == 4 || i2 == 2) {
                    balloonHolder.f882U.setVisibility(8);
                    balloonHolder.f880S.setVisibility(8);
                    balloonHolder.f864C.setVisibility(8);
                    balloonHolder.f865D.setVisibility(8);
                    balloonHolder.f863B.setVisibility(8);
                    balloonHolder.f866E.setVisibility(8);
                    balloonHolder.f887e.setVisibility(8);
                    balloonHolder.f888f.setVisibility(8);
                    balloonHolder.f875N.setVisibility(0);
                    if (i > 0) {
                        balloonHolder.f889g.setText("(" + i + ")");
                        balloonHolder.f889g.setVisibility(0);
                    } else {
                        balloonHolder.f889g.setVisibility(8);
                    }
                } else if (i2 == -1) {
                    balloonHolder.f882U.setVisibility(8);
                    balloonHolder.f880S.setVisibility(8);
                    ChatONLogWriter.m3509d("MSG_TYPE_FAIL!!!!!!!!!!");
                    m774a(view, balloonHolder, j, this.f860y, msgContentTypeM2195a);
                }
            } else {
                m780a(balloonHolder, string5, string6, string3, i3);
                balloonHolder.f891i.setVisibility(8);
                balloonHolder.f892j.setVisibility(0);
                balloonHolder.f885c.setVisibility(8);
                m775a(balloonHolder.f904v, cursor.getPosition(), lValueOf);
                if (msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.TEXT || msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.GEO || i2 != 3) {
                    balloonHolder.f906x.setVisibility(4);
                    balloonHolder.f905w.setVisibility(4);
                    balloonHolder.f907y.setVisibility(4);
                } else {
                    FileDownloadTask2 fileDownloadTask2 = (FileDownloadTask2) MessageControl.m2012a(string4).f1367d.get(Long.valueOf(Long.parseLong(string)));
                    ChatONLogWriter.m3506b("server_no : " + string, getClass().getName());
                    ChatONLogWriter.m3506b("MessageControl : " + MessageControl.m2012a(string4).f1367d, getClass().getName());
                    ChatONLogWriter.m3506b("download2 : " + fileDownloadTask2, getClass().getName());
                    if (fileDownloadTask2 != null) {
                        if (msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.IMAGE || msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.VIDEO) {
                            balloonHolder.f905w.setVisibility(0);
                            balloonHolder.f906x.setVisibility(8);
                        } else {
                            balloonHolder.f906x.setVisibility(0);
                            balloonHolder.f905w.setVisibility(4);
                        }
                        balloonHolder.f907y.setVisibility(0);
                        fileDownloadTask2.m2117a(view);
                        balloonHolder.f907y.setOnClickListener(new onDownCancelClickListener(Long.parseLong(string)));
                    } else {
                        balloonHolder.f905w.setVisibility(4);
                        balloonHolder.f906x.setVisibility(4);
                        balloonHolder.f907y.setVisibility(4);
                    }
                }
            }
            switch (msgContentTypeM2195a) {
                case TEXT:
                    m781a(balloonHolder, string2, z);
                    break;
                case IMAGE:
                    boolean z2 = false;
                    if (string2 != null) {
                        String[] strArrSplit2 = string2.split("\n");
                        ChatONLogWriter.m3506b("token:" + Arrays.toString(strArrSplit2), getClass().getSimpleName());
                        if (i5 == 1 && !StorageStateInfoUtil.m3677a()) {
                            z2 = true;
                            str2 = string7;
                        } else if (i5 == 0 && StorageStateInfoUtil.m3677a()) {
                            String str3 = z ? GlobalApplication.m2387e().getExternalFilesDir(null).getAbsolutePath() + "/" + string4 + "/" + strArrSplit2[3] : GlobalApplication.m2387e().getExternalFilesDir(null).getAbsolutePath() + "/" + string4 + "/thumbnail//" + strArrSplit2[3];
                            if (ChatONFileUtil.m3486b(str3)) {
                                String string9 = Uri.fromFile(new File(str3)).toString();
                                MessageDatabaseHelper.m2288a(GlobalApplication.m2387e().getContentResolver(), string3, string4, Long.valueOf(Long.parseLong(string)), string9, this.f860y, true, true);
                                str2 = string9;
                            } else {
                                z2 = true;
                                str2 = string7;
                            }
                        } else {
                            str2 = string7;
                        }
                        if (!z2) {
                            str = str2;
                        } else if (i4 == 2) {
                            str = ChatONConst.f1339c;
                        } else {
                            new FileDownloadTask(strArrSplit2[2], strArrSplit2[4], strArrSplit2[3], true, string4, Long.parseLong(string), ChatONContract.InBoxTable.ChatType.ONETOONE, string3).execute(new String[0]);
                            str = str2;
                        }
                    } else {
                        str = string7;
                    }
                    m784b(balloonHolder, str, z);
                    break;
                case VIDEO:
                    m787d(balloonHolder, string7, z);
                    break;
                case AUDIO:
                    m786c(balloonHolder, string2, z);
                    break;
                case CALENDAR:
                    m782a(balloonHolder, string2, z, string8);
                    break;
                case CONTACT:
                    m785b(balloonHolder, string2, z, string8);
                    break;
                case GEO:
                    m788e(balloonHolder, string2, z);
                    break;
            }
        } else {
            m779a(balloonHolder, string2);
        }
        view.setTag(balloonHolder);
    }

    @Override // android.support.v4.widget.ResourceCursorAdapter, android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f858w.inflate(this.f857v.f3138c, viewGroup, false);
        BalloonHolder balloonHolder = new BalloonHolder();
        balloonHolder.f884b = (TextView) viewInflate.findViewById(C0062R.id.textDate);
        balloonHolder.f885c = (TextView) viewInflate.findViewById(C0062R.id.textInvite);
        balloonHolder.f886d = (TextView) viewInflate.findViewById(C0062R.id.textLeave);
        balloonHolder.f892j = (ViewGroup) viewInflate.findViewById(C0062R.id.parentRcv);
        balloonHolder.f892j.setOnClickListener(this);
        balloonHolder.f894l = (ImageView) viewInflate.findViewById(C0062R.id.imageProfile);
        balloonHolder.f893k = (TextView) viewInflate.findViewById(C0062R.id.textName);
        balloonHolder.f895m = (LinearLayout) viewInflate.findViewById(C0062R.id.lLayoutRcvContent);
        balloonHolder.f895m.setOnLongClickListener(null);
        balloonHolder.f895m.setOnClickListener(this);
        balloonHolder.f895m.setTag(viewInflate);
        balloonHolder.f896n = (TextView) viewInflate.findViewById(C0062R.id.textRcvContent);
        balloonHolder.f899q = (ImageView) viewInflate.findViewById(C0062R.id.imageRcvContent);
        balloonHolder.f899q.setTag(viewInflate);
        balloonHolder.f899q.setOnLongClickListener(null);
        balloonHolder.f900r = (LinearLayout) viewInflate.findViewById(C0062R.id.lLayoutETC);
        balloonHolder.f901s = (ImageView) viewInflate.findViewById(C0062R.id.imageEtcContent);
        balloonHolder.f901s.setTag(viewInflate);
        balloonHolder.f901s.setOnLongClickListener(null);
        balloonHolder.f902t = (TextView) viewInflate.findViewById(C0062R.id.textEtcContent);
        balloonHolder.f903u = (RelativeLayout) viewInflate.findViewById(C0062R.id.lLayoutDate);
        balloonHolder.f897o = (TextView) viewInflate.findViewById(C0062R.id.textRcvTranslated);
        balloonHolder.f898p = (ImageView) viewInflate.findViewById(C0062R.id.imageRcvTranIcon);
        balloonHolder.f904v = (TextView) viewInflate.findViewById(C0062R.id.textRcvTime);
        balloonHolder.f905w = (ProgressBar) viewInflate.findViewById(C0062R.id.progressbarDown);
        balloonHolder.f905w.setVisibility(4);
        balloonHolder.f905w.setMax(100);
        balloonHolder.f907y = (Button) viewInflate.findViewById(C0062R.id.btnDownCancel);
        balloonHolder.f907y.setVisibility(4);
        balloonHolder.f908z = (CheckBox) viewInflate.findViewById(C0062R.id.chkRcvId);
        balloonHolder.f862A = (CheckBox) viewInflate.findViewById(C0062R.id.DateRcvId);
        balloonHolder.f906x = (ProgressBar) viewInflate.findViewById(C0062R.id.DownProgressBalloon);
        balloonHolder.f890h = (ViewGroup) viewInflate.findViewById(C0062R.id.rSendRoot);
        balloonHolder.f891i = (RelativeLayout) this.f858w.inflate(this.f857v.f3139d, balloonHolder.f890h, true);
        balloonHolder.f891i.setOnClickListener(this);
        balloonHolder.f867F = (LinearLayout) balloonHolder.f891i.findViewById(C0062R.id.lLayoutSndContent);
        balloonHolder.f867F.setOnLongClickListener(null);
        balloonHolder.f867F.setOnClickListener(this);
        balloonHolder.f867F.setTag(viewInflate);
        balloonHolder.f868G = (TextView) balloonHolder.f891i.findViewById(C0062R.id.textSndContent);
        balloonHolder.f870I = (TextView) balloonHolder.f891i.findViewById(C0062R.id.textSndTranslated);
        balloonHolder.f869H = (ImageView) balloonHolder.f891i.findViewById(C0062R.id.imageSndTranIcon);
        balloonHolder.f871J = (ImageView) balloonHolder.f891i.findViewById(C0062R.id.imageSndContent);
        balloonHolder.f871J.setOnLongClickListener(null);
        balloonHolder.f872K = (LinearLayout) balloonHolder.f891i.findViewById(C0062R.id.lLayoutSndETC);
        balloonHolder.f873L = (ImageView) balloonHolder.f891i.findViewById(C0062R.id.imageEtcSndContent);
        balloonHolder.f873L.setOnLongClickListener(null);
        balloonHolder.f874M = (TextView) balloonHolder.f891i.findViewById(C0062R.id.textEtcSndContent);
        balloonHolder.f875N = (TextView) balloonHolder.f891i.findViewById(C0062R.id.textSndTime);
        balloonHolder.f876O = (TextView) balloonHolder.f891i.findViewById(C0062R.id.textSndStatus);
        balloonHolder.f877P = (CheckBox) balloonHolder.f891i.findViewById(C0062R.id.chkSndId);
        balloonHolder.f863B = (Button) balloonHolder.f891i.findViewById(C0062R.id.btnFailCancel);
        balloonHolder.f864C = (Button) balloonHolder.f891i.findViewById(C0062R.id.btnMessage);
        balloonHolder.f865D = (Button) balloonHolder.f891i.findViewById(C0062R.id.btnResend);
        balloonHolder.f865D.setTag(viewInflate);
        balloonHolder.f866E = (Button) balloonHolder.f891i.findViewById(C0062R.id.btnSendCancel);
        balloonHolder.f878Q = (ImageView) balloonHolder.f891i.findViewById(C0062R.id.imgEnvelop);
        balloonHolder.f879R = (TextView) balloonHolder.f891i.findViewById(C0062R.id.txtUnread);
        balloonHolder.f880S = (ProgressBar) balloonHolder.f891i.findViewById(C0062R.id.progressBalloon);
        balloonHolder.f880S.setVisibility(4);
        balloonHolder.f881T = (ImageButton) balloonHolder.f891i.findViewById(C0062R.id.imageAlert);
        balloonHolder.f882U = (ProgressBar) balloonHolder.f891i.findViewById(C0062R.id.progressbarUp);
        balloonHolder.f882U.setVisibility(4);
        balloonHolder.f882U.setMax(100);
        balloonHolder.f887e = (TextView) balloonHolder.f891i.findViewById(C0062R.id.devision1);
        balloonHolder.f888f = (TextView) balloonHolder.f891i.findViewById(C0062R.id.devision2);
        balloonHolder.f889g = (TextView) balloonHolder.f891i.findViewById(C0062R.id.chat_ack);
        if (this.f833C.equals("bubble_01") || !this.f833C.equals("")) {
        }
        ChatONLogWriter.m3509d("changeBubble:" + this.f833C);
        if (!this.f833C.equals("bubble_01")) {
            if (this.f833C.equals("bubble_02")) {
                balloonHolder.f895m.setBackgroundResource(C0062R.drawable.message_bubble_receive2);
                balloonHolder.f867F.setBackgroundResource(C0062R.drawable.message_bubble_sent2);
            } else if (this.f833C.equals("bubble_03")) {
                balloonHolder.f895m.setBackgroundResource(C0062R.drawable.message_bubble_receive3);
                balloonHolder.f867F.setBackgroundResource(C0062R.drawable.message_bubble_sent3);
            } else if (this.f833C.equals("bubble_04")) {
                balloonHolder.f895m.setBackgroundResource(C0062R.drawable.message_bubble_receive4);
                balloonHolder.f867F.setBackgroundResource(C0062R.drawable.message_bubble_sent4);
            } else if (this.f833C.equals("bubble_05")) {
                balloonHolder.f895m.setBackgroundResource(C0062R.drawable.message_bubble_receive5);
                balloonHolder.f867F.setBackgroundResource(C0062R.drawable.message_bubble_sent5);
            } else if (this.f833C.equals("bubble_06")) {
                balloonHolder.f895m.setBackgroundResource(C0062R.drawable.message_bubble_receive6);
                balloonHolder.f867F.setBackgroundResource(C0062R.drawable.message_bubble_sent6);
            }
        }
        viewInflate.setTag(balloonHolder);
        return viewInflate;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f838H.mo756a(view);
    }
}
