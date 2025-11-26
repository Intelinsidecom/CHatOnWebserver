package com.sec.chaton.database;

import android.net.Uri;
import android.provider.BaseColumns;
import com.sec.chaton.C0062R;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class ChatONContract {

    /* renamed from: b */
    private static final Uri f1712b = Uri.parse("content://com.sec.chaton.provider");

    /* renamed from: a */
    public static final Uri f1711a = f1712b;

    public class BuddyTable implements BaseColumns {

        /* renamed from: a */
        public static final Uri f1713a = ChatONContract.f1712b.buildUpon().appendPath("buddy").build();

        /* renamed from: a */
        public static Uri m2168a() {
            return f1713a.buildUpon().appendEncodedPath("alphabetical").build();
        }

        /* renamed from: a */
        public static Uri m2169a(String str) {
            return f1713a.buildUpon().appendPath("buddy_no").appendPath(str).build();
        }

        /* renamed from: a */
        public static String m2170a(Uri uri) {
            return uri.getPathSegments().get(2);
        }

        /* renamed from: b */
        public static Uri m2171b() {
            return f1713a.buildUpon().appendEncodedPath("alphabetical2").build();
        }

        /* renamed from: c */
        public static Uri m2172c() {
            return f1713a.buildUpon().appendEncodedPath("relation").build();
        }

        /* renamed from: d */
        public static Uri m2173d() {
            return f1713a.buildUpon().appendPath("profile").build();
        }

        /* renamed from: e */
        public static Uri m2174e() {
            return f1713a.buildUpon().appendPath("participants").build();
        }

        /* renamed from: f */
        public static Uri m2175f() {
            return f1713a.buildUpon().appendPath("participants_no_same").build();
        }
    }

    public interface ChatONBaseColumns extends BaseColumns {
    }

    public class ContactsTable implements BaseColumns {

        /* renamed from: a */
        public static final Uri f1714a = ChatONContract.f1712b.buildUpon().appendPath("contacts").build();

        /* renamed from: a */
        public static Uri m2176a(String str) {
            return f1714a.buildUpon().appendPath(str).build();
        }

        /* renamed from: a */
        public static String m2177a(Uri uri) {
            return uri.getPathSegments().get(1);
        }

        /* renamed from: b */
        public static String m2178b(Uri uri) {
            return uri.getPathSegments().get(2);
        }
    }

    public interface DatabaseBaseConst {
    }

    public class GroupRelationTable implements BaseColumns {

        /* renamed from: a */
        public static final Uri f1715a = ChatONContract.f1712b.buildUpon().appendPath("grouprelation").build();

        /* renamed from: a */
        public static Uri m2179a() {
            return f1715a.buildUpon().appendPath("buddy_in").build();
        }

        /* renamed from: a */
        public static Uri m2180a(String str) {
            return f1715a.buildUpon().appendPath(str).build();
        }

        /* renamed from: a */
        public static String m2181a(Uri uri) {
            return uri.getPathSegments().get(2);
        }

        /* renamed from: b */
        public static String m2182b(Uri uri) {
            return uri.getPathSegments().get(2);
        }
    }

    public class GroupTable implements BaseColumns {

        /* renamed from: a */
        public static final Uri f1716a = ChatONContract.f1712b.buildUpon().appendPath("buddy_group").build();

        /* renamed from: a */
        public static String m2183a(Uri uri) {
            return uri.getPathSegments().get(1);
        }
    }

    public class InBoxTable implements BaseColumns {

        /* renamed from: a */
        public static final Uri f1717a = ChatONContract.f1712b.buildUpon().appendPath("inbox").build();

        public enum ChatType {
            ONETOONE(0),
            GROUPCHAT(1),
            BROADCAST(2),
            WEB_AUTH(9999);


            /* renamed from: e */
            private int f1723e;

            ChatType(int i) {
                this.f1723e = i;
            }

            /* renamed from: a */
            public static ChatType m2188a(int i) {
                switch (i) {
                    case 0:
                        return ONETOONE;
                    case 1:
                        return GROUPCHAT;
                    case 2:
                        return BROADCAST;
                    case 9999:
                        return WEB_AUTH;
                    default:
                        return null;
                }
            }

            /* renamed from: a */
            public int m2189a() {
                return this.f1723e;
            }
        }

        /* renamed from: a */
        public static Uri m2184a() {
            return f1717a.buildUpon().appendPath("buddy_participant_join").build();
        }

        /* renamed from: a */
        public static String m2185a(Uri uri) {
            return uri.getPathSegments().get(1);
        }

        /* renamed from: b */
        public static Uri m2186b() {
            return f1717a.buildUpon().appendPath("group_title_update").build();
        }

        /* renamed from: b */
        public static String m2187b(Uri uri) {
            return uri.getPathSegments().get(2);
        }
    }

    public class MemoSessionsTable implements BaseColumns {

        /* renamed from: a */
        public static final Uri f1724a = ChatONContract.f1712b.buildUpon().appendPath("memo_sessions").build();
    }

    public class MemoTable implements BaseColumns {

        /* renamed from: a */
        public static final Uri f1725a = ChatONContract.f1712b.buildUpon().appendPath("memo").build();
    }

    public class MessageTable implements BaseColumns {

        /* renamed from: a */
        public static final Uri f1726a = ChatONContract.f1712b.buildUpon().appendPath("message").build();

        public enum MsgContentType {
            SYSTEM(-1),
            TEXT(0),
            IMAGE(1),
            VIDEO(2),
            GEO(3),
            AUDIO(4),
            CONTACT(5),
            CALENDAR(6);


            /* renamed from: i */
            private int f1736i;

            MsgContentType(int i) {
                this.f1736i = i;
            }

            /* renamed from: a */
            public static MsgContentType m2195a(int i) {
                switch (i) {
                    case -1:
                        return SYSTEM;
                    case 0:
                        return TEXT;
                    case 1:
                        return IMAGE;
                    case 2:
                        return VIDEO;
                    case 3:
                        return GEO;
                    case 4:
                        return AUDIO;
                    case 5:
                        return CONTACT;
                    case 6:
                        return CALENDAR;
                    default:
                        return null;
                }
            }

            /* renamed from: a */
            public static String m2196a(MsgContentType msgContentType) {
                switch (msgContentType) {
                    case IMAGE:
                        return GlobalApplication.m2387e().getString(C0062R.string.send_image_to_you);
                    case VIDEO:
                        return GlobalApplication.m2387e().getString(C0062R.string.send_video_to_you);
                    case GEO:
                        return GlobalApplication.m2387e().getString(C0062R.string.send_location_to_you);
                    case AUDIO:
                        return GlobalApplication.m2387e().getString(C0062R.string.send_voice_to_you);
                    case CONTACT:
                        return GlobalApplication.m2387e().getString(C0062R.string.send_contact_to_you);
                    case CALENDAR:
                        return GlobalApplication.m2387e().getString(C0062R.string.send_calendar_to_you);
                    default:
                        return null;
                }
            }

            /* renamed from: a */
            public int m2197a() {
                return this.f1736i;
            }
        }

        public enum MsgServerType {
            MSG(0),
            MEDIA(1);


            /* renamed from: c */
            private int f1740c;

            MsgServerType(int i) {
                this.f1740c = i;
            }

            /* renamed from: a */
            public int m2198a() {
                return this.f1740c;
            }
        }

        /* renamed from: a */
        public static Uri m2190a() {
            return f1726a.buildUpon().appendPath("message_buddy").build();
        }

        /* renamed from: a */
        public static Uri m2191a(String str) {
            return f1726a.buildUpon().appendPath("read_ack").appendPath(str).build();
        }

        /* renamed from: a */
        public static String m2192a(Uri uri) {
            return uri.getPathSegments().get(1);
        }

        /* renamed from: b */
        public static String m2193b(Uri uri) {
            return uri.getPathSegments().get(2);
        }

        /* renamed from: c */
        public static String m2194c(Uri uri) {
            return uri.getPathSegments().get(2);
        }
    }

    public class ParticipantTable {

        /* renamed from: a */
        public static final Uri f1741a = ChatONContract.f1712b.buildUpon().appendPath("participant").build();

        /* renamed from: a */
        public static Uri m2199a(String str) {
            return f1741a.buildUpon().appendPath(str).build();
        }

        /* renamed from: a */
        public static final String m2200a(Uri uri) {
            return uri.getPathSegments().get(1);
        }
    }

    public class RelationTable implements BaseColumns {

        /* renamed from: a */
        public static final Uri f1742a = ChatONContract.f1712b.buildUpon().appendPath("relation").build();

        /* renamed from: a */
        public static Uri m2201a() {
            return f1742a.buildUpon().appendPath("day").build();
        }

        /* renamed from: a */
        public static Uri m2202a(String str) {
            return f1742a.buildUpon().appendPath(str).build();
        }

        /* renamed from: b */
        public static Uri m2203b() {
            return f1742a.buildUpon().appendPath("insert").build();
        }
    }
}
