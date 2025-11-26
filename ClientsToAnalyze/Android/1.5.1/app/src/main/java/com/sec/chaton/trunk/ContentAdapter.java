package com.sec.chaton.trunk;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.trunk.database.DatabaseConstant;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.ProfileImageLoader;
import com.sec.chaton.widget.ProfileImageView;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public class ContentAdapter extends CursorAdapter {
    private Context mContext;

    class ContentViewHolder {
        public String mBuddyNo;
        public ProfileImageView mBuddyProfileImageView;
        public TextView mContentTextView;
        public TextView mRegistrationTimeTextView;
        public String mWriterName;
        public TextView mWriterNameTextView;

        private ContentViewHolder() {
        }
    }

    public ContentAdapter(Context context, Cursor cursor, int i) {
        super(context, cursor, i);
        this.mContext = context;
    }

    private String convertTimeToString(long j) {
        String[] strArrSplit = new SimpleDateFormat("dd MMM/hh:mmaa", Locale.ENGLISH).format(Long.valueOf(j)).split("/");
        String str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
        String str2 = new SimpleDateFormat("yyyy").format(Long.valueOf(j));
        long jCurrentTimeMillis = System.currentTimeMillis();
        return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jCurrentTimeMillis)).equals(str) ? strArrSplit[1].toLowerCase() : str2.equals(new SimpleDateFormat("yyyy").format(Long.valueOf(jCurrentTimeMillis))) ? strArrSplit[0] : new SimpleDateFormat("d MMM,yyyy", Locale.ENGLISH).format(Long.valueOf(j));
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) throws NumberFormatException {
        String str;
        ContentViewHolder contentViewHolder = (ContentViewHolder) view.getTag();
        TextView textView = contentViewHolder.mWriterNameTextView;
        ProfileImageView profileImageView = contentViewHolder.mBuddyProfileImageView;
        TextView textView2 = contentViewHolder.mRegistrationTimeTextView;
        TextView textView3 = contentViewHolder.mContentTextView;
        Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("registration_time")));
        String string = cursor.getString(cursor.getColumnIndex(DatabaseConstant.TrunkCommentColumns.KEY_WRITER_ID));
        String string2 = cursor.getString(cursor.getColumnIndex(DatabaseConstant.TrunkCommentColumns.KEY_WRITER_NAME));
        contentViewHolder.mBuddyNo = string;
        contentViewHolder.mWriterName = string2;
        if ("ME".equals(string)) {
            view.setBackgroundResource(C0062R.drawable.trunk_my_comment_background);
            textView.setText(C0062R.string.setting_interaction_me);
            ProfileImageLoader.m3610a(this.mContext).m3623a(profileImageView, ChatONPref.m3519a().getString("msisdn", ""));
        } else {
            view.setBackgroundResource(C0062R.drawable.trunk_comment_background);
            textView.setText(string2);
            try {
                Long.parseLong(string);
                str = string;
            } catch (Exception e) {
                str = "5";
            }
            ProfileImageLoader.m3610a(this.mContext).m3623a(profileImageView, str);
        }
        textView3.setText(cursor.getString(cursor.getColumnIndex(DatabaseConstant.TrunkCommentColumns.KEY_CONTENT)));
        textView2.setText(convertTimeToString(lValueOf.longValue()));
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(C0062R.layout.item_trunkcontent, viewGroup, false);
        ContentViewHolder contentViewHolder = new ContentViewHolder();
        contentViewHolder.mWriterNameTextView = (TextView) viewInflate.findViewById(C0062R.id.commentWriterName);
        contentViewHolder.mBuddyProfileImageView = (ProfileImageView) viewInflate.findViewById(C0062R.id.commentBuddyProfile);
        contentViewHolder.mRegistrationTimeTextView = (TextView) viewInflate.findViewById(C0062R.id.commentRegistrationTime);
        contentViewHolder.mContentTextView = (TextView) viewInflate.findViewById(C0062R.id.commentBuddyContent);
        viewInflate.setTag(contentViewHolder);
        return viewInflate;
    }
}
