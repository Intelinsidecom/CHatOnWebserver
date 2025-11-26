package twitter4j.json;

import java.io.Serializable;
import twitter4j.internal.logging.Logger;

/* loaded from: classes.dex */
public final class JSONObjectType implements Serializable {
    public static final JSONObjectType BLOCK;
    public static final JSONObjectType DELETE;
    public static final JSONObjectType DIRECT_MESSAGE;
    public static final JSONObjectType FAVORITE;
    public static final JSONObjectType FOLLOW;
    public static final JSONObjectType FRIENDS;
    public static final JSONObjectType LIMIT;
    public static final JSONObjectType RETWEET;
    public static final JSONObjectType SCRUB_GEO;
    public static final JSONObjectType SENDER;
    public static final JSONObjectType STATUS;
    public static final JSONObjectType UNBLOCK;
    public static final JSONObjectType UNFAVORITE;
    public static final JSONObjectType UNFOLLOW;
    public static final JSONObjectType USER_LIST_CREATED;
    public static final JSONObjectType USER_LIST_DESTROYED;
    public static final JSONObjectType USER_LIST_MEMBER_ADDED;
    public static final JSONObjectType USER_LIST_MEMBER_DELETED;
    public static final JSONObjectType USER_LIST_SUBSCRIBED;
    public static final JSONObjectType USER_LIST_UNSUBSCRIBED;
    public static final JSONObjectType USER_LIST_UPDATED;
    public static final JSONObjectType USER_UPDATE;
    static Class class$twitter4j$json$JSONObjectType = null;
    private static final Logger logger;
    private static final long serialVersionUID = -4487565183481849892L;
    private final String name;

    static {
        Class clsClass$;
        if (class$twitter4j$json$JSONObjectType == null) {
            clsClass$ = class$("twitter4j.json.JSONObjectType");
            class$twitter4j$json$JSONObjectType = clsClass$;
        } else {
            clsClass$ = class$twitter4j$json$JSONObjectType;
        }
        logger = Logger.getLogger(clsClass$);
        SENDER = new JSONObjectType("SENDER");
        STATUS = new JSONObjectType("STATUS");
        DIRECT_MESSAGE = new JSONObjectType("DIRECT_MESSAGE");
        DELETE = new JSONObjectType("DELETE");
        LIMIT = new JSONObjectType("LIMIT");
        SCRUB_GEO = new JSONObjectType("SCRUB_GEO");
        FRIENDS = new JSONObjectType("FRIENDS");
        FAVORITE = new JSONObjectType("FAVORITE");
        UNFAVORITE = new JSONObjectType("UNFAVORITE");
        RETWEET = new JSONObjectType("RETWEET");
        FOLLOW = new JSONObjectType("FOLLOW");
        UNFOLLOW = new JSONObjectType("UNFOLLOW");
        USER_LIST_MEMBER_ADDED = new JSONObjectType("USER_LIST_MEMBER_ADDED");
        USER_LIST_MEMBER_DELETED = new JSONObjectType("USER_LIST_MEMBER_DELETED");
        USER_LIST_SUBSCRIBED = new JSONObjectType("USER_LIST_SUBSCRIBED");
        USER_LIST_UNSUBSCRIBED = new JSONObjectType("USER_LIST_UNSUBSCRIBED");
        USER_LIST_CREATED = new JSONObjectType("USER_LIST_CREATED");
        USER_LIST_UPDATED = new JSONObjectType("USER_LIST_UPDATED");
        USER_LIST_DESTROYED = new JSONObjectType("USER_LIST_DESTROYED");
        USER_UPDATE = new JSONObjectType("USER_UPDATE");
        BLOCK = new JSONObjectType("BLOCK");
        UNBLOCK = new JSONObjectType("UNBLOCK");
    }

    static Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private JSONObjectType() {
        throw new AssertionError();
    }

    private JSONObjectType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:77:0x0123
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0120  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0114 -> B:76:0x0120). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static twitter4j.json.JSONObjectType determine(org.json.JSONObject r3) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.json.JSONObjectType.determine(org.json.JSONObject):twitter4j.json.JSONObjectType");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        JSONObjectType jSONObjectType = (JSONObjectType) obj;
        if (this.name != null) {
            if (this.name.equals(jSONObjectType.name)) {
                return true;
            }
        } else if (jSONObjectType.name == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.name != null) {
            return this.name.hashCode();
        }
        return 0;
    }

    public String toString() {
        return this.name;
    }
}
