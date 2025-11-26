package weibo4android;

import java.util.Date;

/* loaded from: classes.dex */
public class AsyncWeibo extends Weibo {

    @Deprecated
    public static final int BLOCK = 22;
    public static final int CREATE = 12;
    public static final int CREATED_BLOCK = 43;
    public static final int CREATE_FAVORITE = 18;
    public static final int CREATE_FRIENDSHIP = 32;
    public static final int CURRENT_TRENDS = 45;
    public static final int DAILY_TRENDS = 46;

    @Deprecated
    public static final int DESTORY = 13;

    @Deprecated
    public static final int DESTROY = 13;
    public static final int DESTROYED_BLOCK = 42;
    public static final int DESTROY_DIRECT_MESSAGES = 40;
    public static final int DESTROY_FAVORITE = 19;
    public static final int DESTROY_FRIENDSHIP = 33;
    public static final int DESTROY_STATUS = 26;
    public static final int DIRECT_MESSAGES = 10;
    public static final int DISABLE_NOTIFICATION = 36;
    public static final int ENABLE_NOTIFICATION = 35;

    @Deprecated
    public static final int EXISTS = 28;
    private static final int EXISTS_BLOCK = 48;
    public static final int EXISTS_FRIENDSHIP = 34;
    public static final int FAVORITES = 17;
    public static final int FEATURED = 8;

    @Deprecated
    public static final int FOLLOW = 14;
    public static final int FOLLOWERS = 7;
    public static final int FOLLOWERS_IDS = 30;
    public static final int FRIENDS = 6;
    public static final int FRIENDS_IDS = 29;
    public static final int FRIENDS_TIMELINE = 1;
    private static final int GET_BLOCKING_USERS = 49;
    private static final int GET_BLOCKING_USERS_IDS = 50;

    @Deprecated
    public static final int GET_DOWNTIME_SCHEDULE = 25;
    public static final int HOME_TIMELINE = 51;

    @Deprecated
    public static final int LEAVE = 15;
    public static final int MENTIONS = 37;
    public static final int PUBLIC_TIMELINE = 0;
    public static final int RATE_LIMIT_STATUS = 28;

    @Deprecated
    public static final int REPLIES = 5;
    public static final int RETWEETED_BY_ME = 53;
    public static final int RETWEETED_TO_ME = 54;
    public static final int RETWEETS_OF_ME = 55;
    public static final int RETWEET_STATUS = 52;
    public static final int SEARCH = 27;
    public static final int SEND_DIRECT_MESSAGE = 11;

    @Deprecated
    public static final int SHOW = 3;
    public static final int SHOW_STATUS = 38;
    public static final int TEST = 24;
    public static final int TRENDS = 44;

    @Deprecated
    public static final int UNBLOCK = 23;

    @Deprecated
    public static final int UPDATE = 4;
    public static final int UPDATE_DELIVERLY_DEVICE = 21;

    @Deprecated
    public static final int UPDATE_LOCATION = 20;
    public static final int UPDATE_PROFILE = 41;
    public static final int UPDATE_PROFILE_COLORS = 31;
    public static final int UPDATE_STATUS = 39;
    public static final int USER_DETAIL = 9;
    public static final int USER_TIMELINE = 2;
    public static final int WEEKLY_TRENDS = 47;
    private static transient Dispatcher dispatcher = null;
    private static final long serialVersionUID = -2008667933225051907L;
    private boolean shutdown;

    public AsyncWeibo(String str, String str2) {
        super(str, str2);
        this.shutdown = false;
    }

    public AsyncWeibo(String str, String str2, String str3) {
        super(str, str2, str3);
        this.shutdown = false;
    }

    public void getDailyTrendsAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(46, weiboListener, null) { // from class: weibo4android.AsyncWeibo.1
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotDailyTrends(AsyncWeibo.this.getDailyTrends());
            }
        });
    }

    public void getDailyTrendsAsync(Date date, boolean z, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(46, weiboListener, new Object[]{date, Boolean.valueOf(z)}) { // from class: weibo4android.AsyncWeibo.2
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotDailyTrends(AsyncWeibo.this.getDailyTrends((Date) objArr[0], ((Boolean) objArr[1]).booleanValue()));
            }
        });
    }

    public void getWeeklyTrendsAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(47, weiboListener, null) { // from class: weibo4android.AsyncWeibo.3
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotWeeklyTrends(AsyncWeibo.this.getWeeklyTrends());
            }
        });
    }

    public void getWeeklyTrendsAsync(Date date, boolean z, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(47, weiboListener, new Object[]{date, Boolean.valueOf(z)}) { // from class: weibo4android.AsyncWeibo.4
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotWeeklyTrends(AsyncWeibo.this.getWeeklyTrends((Date) objArr[0], ((Boolean) objArr[1]).booleanValue()));
            }
        });
    }

    public void getPublicTimelineAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(0, weiboListener, null) { // from class: weibo4android.AsyncWeibo.5
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotPublicTimeline(AsyncWeibo.this.getPublicTimeline());
            }
        });
    }

    @Deprecated
    public void getPublicTimelineAsync(int i, WeiboListener weiboListener) {
        getPublicTimelineAsync(i, weiboListener);
    }

    public void getPublicTimelineAsync(long j, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(0, weiboListener, new Long[]{Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.6
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotPublicTimeline(AsyncWeibo.this.getPublicTimeline(((Long) objArr[0]).longValue()));
            }
        });
    }

    public void getHomeTimelineAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(51, weiboListener, null) { // from class: weibo4android.AsyncWeibo.7
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotHomeTimeline(AsyncWeibo.this.getHomeTimeline());
            }
        });
    }

    public void getHomeTimelineAsync(Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(51, weiboListener, new Object[]{paging}) { // from class: weibo4android.AsyncWeibo.8
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotHomeTimeline(AsyncWeibo.this.getHomeTimeline((Paging) objArr[0]));
            }
        });
    }

    public void getFriendsTimelineAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(1, weiboListener, null) { // from class: weibo4android.AsyncWeibo.9
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFriendsTimeline(AsyncWeibo.this.getFriendsTimeline());
            }
        });
    }

    public void getFriendsTimelineAsync(Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(1, weiboListener, new Object[]{paging}) { // from class: weibo4android.AsyncWeibo.10
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFriendsTimeline(AsyncWeibo.this.getFriendsTimeline((Paging) objArr[0]));
            }
        });
    }

    @Deprecated
    public void getFriendsTimelineByPageAsync(int i, WeiboListener weiboListener) {
        getFriendsTimelineAsync(new Paging(i), weiboListener);
    }

    @Deprecated
    public void getFriendsTimelineAsync(int i, WeiboListener weiboListener) {
        getFriendsTimelineAsync(new Paging(i), weiboListener);
    }

    @Deprecated
    public void getFriendsTimelineAsync(long j, int i, WeiboListener weiboListener) {
        getFriendsTimelineAsync(new Paging(i, j), weiboListener);
    }

    @Deprecated
    public void getFriendsTimelineAsync(String str, WeiboListener weiboListener) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    @Deprecated
    public void getFriendsTimelineAsync(String str, Paging paging, WeiboListener weiboListener) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    @Deprecated
    public void getFriendsTimelineByPageAsync(String str, int i, WeiboListener weiboListener) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    @Deprecated
    public void getFriendsTimelineAsync(String str, int i, WeiboListener weiboListener) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    @Deprecated
    public void getFriendsTimelineAsync(long j, String str, int i, WeiboListener weiboListener) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    @Deprecated
    public void getFriendsTimelineAsync(Date date, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(1, weiboListener, new Object[]{date}) { // from class: weibo4android.AsyncWeibo.11
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFriendsTimeline(AsyncWeibo.this.getFriendsTimeline((Date) objArr[0]));
            }
        });
    }

    @Deprecated
    public void getFriendsTimelineAsync(long j, WeiboListener weiboListener) {
        getFriendsTimelineAsync(new Paging(j), weiboListener);
    }

    @Deprecated
    public void getFriendsTimelineAsync(String str, Date date, WeiboListener weiboListener) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    @Deprecated
    public void getFriendsTimelineAsync(String str, long j, WeiboListener weiboListener) {
        throw new IllegalStateException("The Weibo API is not supporting this method anymore");
    }

    @Deprecated
    public void getUserTimelineAsync(String str, int i, Date date, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(2, weiboListener, new Object[]{str, Integer.valueOf(i), date}) { // from class: weibo4android.AsyncWeibo.12
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotUserTimeline(AsyncWeibo.this.getUserTimeline((String) objArr[0], ((Integer) objArr[1]).intValue(), (Date) objArr[2]));
            }
        });
    }

    public void getUserTimelineAsync(String str, Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(2, weiboListener, new Object[]{str, paging}) { // from class: weibo4android.AsyncWeibo.13
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotUserTimeline(AsyncWeibo.this.getUserTimeline((String) objArr[0], (Paging) objArr[1]));
            }
        });
    }

    @Deprecated
    public void getUserTimelineAsync(String str, int i, long j, WeiboListener weiboListener) {
        getUserTimelineAsync(str, new Paging(i, j), weiboListener);
    }

    @Deprecated
    public void getUserTimelineAsync(String str, Date date, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(2, weiboListener, new Object[]{str, date}) { // from class: weibo4android.AsyncWeibo.14
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotUserTimeline(AsyncWeibo.this.getUserTimeline((String) objArr[0], (Date) objArr[1]));
            }
        });
    }

    @Deprecated
    public void getUserTimelineAsync(String str, int i, WeiboListener weiboListener) {
        getUserTimelineAsync(str, new Paging().count(i), weiboListener);
    }

    @Deprecated
    public void getUserTimelineAsync(int i, Date date, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(2, weiboListener, new Object[]{Integer.valueOf(i), date}) { // from class: weibo4android.AsyncWeibo.15
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotUserTimeline(AsyncWeibo.this.getUserTimeline(((Integer) objArr[0]).intValue(), (Date) objArr[1]));
            }
        });
    }

    public void getUserTimelineAsync(Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(2, weiboListener, new Object[]{paging}) { // from class: weibo4android.AsyncWeibo.16
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotUserTimeline(AsyncWeibo.this.getUserTimeline((Paging) objArr[0]));
            }
        });
    }

    @Deprecated
    public void getUserTimelineAsync(int i, long j, WeiboListener weiboListener) {
        getUserTimelineAsync(new Paging(j).count(i), weiboListener);
    }

    public void getUserTimelineAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(2, weiboListener, new Object[]{str}) { // from class: weibo4android.AsyncWeibo.17
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotUserTimeline(AsyncWeibo.this.getUserTimeline((String) objArr[0]));
            }
        });
    }

    @Deprecated
    public void getUserTimelineAsync(String str, long j, WeiboListener weiboListener) {
        getUserTimelineAsync(str, new Paging(j), weiboListener);
    }

    public void getUserTimelineAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(2, weiboListener, null) { // from class: weibo4android.AsyncWeibo.18
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotUserTimeline(AsyncWeibo.this.getUserTimeline());
            }
        });
    }

    @Deprecated
    public void getUserTimelineAsync(long j, WeiboListener weiboListener) {
        getUserTimelineAsync(new Paging(j), weiboListener);
    }

    @Deprecated
    public void getRepliesAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(5, weiboListener, null) { // from class: weibo4android.AsyncWeibo.19
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotReplies(AsyncWeibo.this.getReplies());
            }
        });
    }

    public void getMentionsAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(37, weiboListener, null) { // from class: weibo4android.AsyncWeibo.20
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotMentions(AsyncWeibo.this.getMentions());
            }
        });
    }

    public void getMentionsAsync(Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(37, weiboListener, new Object[]{paging}) { // from class: weibo4android.AsyncWeibo.21
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotMentions(AsyncWeibo.this.getMentions((Paging) objArr[0]));
            }
        });
    }

    public void getRetweetedByMeAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(53, weiboListener, null) { // from class: weibo4android.AsyncWeibo.22
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotRetweetedByMe(AsyncWeibo.this.getRetweetedByMe());
            }
        });
    }

    public void getRetweetedByMeAsync(Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(53, weiboListener, new Object[]{paging}) { // from class: weibo4android.AsyncWeibo.23
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotRetweetedByMe(AsyncWeibo.this.getRetweetedByMe((Paging) objArr[0]));
            }
        });
    }

    public void getRetweetedToMeAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(54, weiboListener, null) { // from class: weibo4android.AsyncWeibo.24
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotRetweetedToMe(AsyncWeibo.this.getRetweetedToMe());
            }
        });
    }

    public void getRetweetedToMeAsync(Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(54, weiboListener, new Object[]{paging}) { // from class: weibo4android.AsyncWeibo.25
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotRetweetedToMe(AsyncWeibo.this.getRetweetedToMe((Paging) objArr[0]));
            }
        });
    }

    public void getRetweetsOfMeAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(55, weiboListener, null) { // from class: weibo4android.AsyncWeibo.26
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotRetweetsOfMe(AsyncWeibo.this.getRetweetsOfMe());
            }
        });
    }

    public void getRetweetsOfMeAsync(Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(55, weiboListener, new Object[]{paging}) { // from class: weibo4android.AsyncWeibo.27
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotRetweetsOfMe(AsyncWeibo.this.getRetweetsOfMe((Paging) objArr[0]));
            }
        });
    }

    @Deprecated
    public void getRepliesAsync(long j, WeiboListener weiboListener) {
        getMentionsAsync(new Paging(j), weiboListener);
    }

    @Deprecated
    public void getRepliesByPageAsync(int i, WeiboListener weiboListener) {
        getMentionsAsync(new Paging(i), weiboListener);
    }

    @Deprecated
    public void getRepliesAsync(int i, WeiboListener weiboListener) {
        getMentionsAsync(new Paging(i), weiboListener);
    }

    @Deprecated
    public void getRepliesAsync(long j, int i, WeiboListener weiboListener) {
        getMentionsAsync(new Paging(i, j), weiboListener);
    }

    @Deprecated
    public void showAsync(int i, WeiboListener weiboListener) {
        showAsync(i, weiboListener);
    }

    @Deprecated
    public void showAsync(long j, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(3, weiboListener, new Object[]{Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.28
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotShow(AsyncWeibo.this.show(((Long) objArr[0]).longValue()));
            }
        });
    }

    public void showStatusAsync(long j, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(38, weiboListener, new Object[]{Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.29
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotShowStatus(AsyncWeibo.this.showStatus(((Long) objArr[0]).longValue()));
            }
        });
    }

    @Deprecated
    public void updateAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(4, weiboListener, new String[]{str}) { // from class: weibo4android.AsyncWeibo.30
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.updated(AsyncWeibo.this.update((String) objArr[0]));
            }
        });
    }

    @Deprecated
    public void updateAsync(String str) {
        getDispatcher().invokeLater(new AsyncTask(4, new WeiboAdapter(), new String[]{str}) { // from class: weibo4android.AsyncWeibo.31
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener, Object[] objArr) {
                weiboListener.updated(AsyncWeibo.this.update((String) objArr[0]));
            }
        });
    }

    public void updateStatusAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(39, weiboListener, new String[]{str}) { // from class: weibo4android.AsyncWeibo.32
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.updatedStatus(AsyncWeibo.this.updateStatus((String) objArr[0]));
            }
        });
    }

    public void updateStatusAsync(String str) {
        getDispatcher().invokeLater(new AsyncTask(39, new WeiboAdapter(), new String[]{str}) { // from class: weibo4android.AsyncWeibo.33
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener, Object[] objArr) {
                weiboListener.updatedStatus(AsyncWeibo.this.updateStatus((String) objArr[0]));
            }
        });
    }

    @Deprecated
    public void updateAsync(String str, long j, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(4, weiboListener, new Object[]{str, Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.34
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.updated(AsyncWeibo.this.update((String) objArr[0], ((Long) objArr[1]).longValue()));
            }
        });
    }

    @Deprecated
    public void updateAsync(String str, long j) {
        getDispatcher().invokeLater(new AsyncTask(4, new WeiboAdapter(), new Object[]{str, Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.35
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener, Object[] objArr) {
                weiboListener.updated(AsyncWeibo.this.update((String) objArr[0], ((Long) objArr[1]).longValue()));
            }
        });
    }

    public void updateStatusAsync(String str, long j, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(39, weiboListener, new Object[]{str, Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.36
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.updatedStatus(AsyncWeibo.this.updateStatus((String) objArr[0], ((Long) objArr[1]).longValue()));
            }
        });
    }

    public void updateStatusAsync(String str, long j) {
        getDispatcher().invokeLater(new AsyncTask(39, new WeiboAdapter(), new Object[]{str, Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.37
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener, Object[] objArr) {
                weiboListener.updatedStatus(AsyncWeibo.this.updateStatus((String) objArr[0], ((Long) objArr[1]).longValue()));
            }
        });
    }

    @Deprecated
    public void destoryStatusAsync(int i) {
        destroyStatusAsync(i);
    }

    @Deprecated
    public void destroyStatusAsync(int i) {
        destroyStatusAsync(i);
    }

    public void destroyStatusAsync(long j) {
        getDispatcher().invokeLater(new AsyncTask(26, new WeiboAdapter(), new Long[]{Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.38
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener, Object[] objArr) {
                weiboListener.destroyedStatus(AsyncWeibo.this.destroyStatus(((Long) objArr[0]).longValue()));
            }
        });
    }

    @Deprecated
    public void destoryStatusAsync(int i, WeiboListener weiboListener) {
        destroyStatusAsync(i, weiboListener);
    }

    @Deprecated
    public void destroyStatusAsync(int i, WeiboListener weiboListener) {
        destroyStatusAsync(i, weiboListener);
    }

    public void destroyStatusAsync(long j, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(26, weiboListener, new Long[]{Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.39
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.destroyedStatus(AsyncWeibo.this.destroyStatus(((Long) objArr[0]).longValue()));
            }
        });
    }

    public void retweetStatusAsync(long j, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(52, weiboListener, new Long[]{Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.40
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.retweetedStatus(AsyncWeibo.this.retweetStatus(((Long) objArr[0]).longValue()));
            }
        });
    }

    public void retweetStatusAsync(long j) {
        retweetStatusAsync(j, new WeiboAdapter());
    }

    @Deprecated
    public void getUserDetailAsync(String str, WeiboListener weiboListener) {
        showUserAsync(str, weiboListener);
    }

    public void showUserAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(9, weiboListener, new Object[]{str}) { // from class: weibo4android.AsyncWeibo.41
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotUserDetail(AsyncWeibo.this.showUser((String) objArr[0]));
            }
        });
    }

    @Deprecated
    public void getFriendsAsync(WeiboListener weiboListener) {
        getFriendsStatusesAsync(weiboListener);
    }

    public void getFriendsStatusesAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(6, weiboListener, null) { // from class: weibo4android.AsyncWeibo.42
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFriends(AsyncWeibo.this.getFriendsStatuses());
            }
        });
    }

    @Deprecated
    public void getFriendsAsync(Paging paging, WeiboListener weiboListener) {
        getFriendsStatusesAsync(paging, weiboListener);
    }

    public void getFriendsStatusesAsync(Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(6, weiboListener, new Object[]{paging}) { // from class: weibo4android.AsyncWeibo.43
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFriends(AsyncWeibo.this.getFriendsStatuses((Paging) objArr[0]));
            }
        });
    }

    @Deprecated
    public void getFriendsAsync(int i, WeiboListener weiboListener) {
        getFriendsStatusesAsync(new Paging(i), weiboListener);
    }

    @Deprecated
    public void getFriendsAsync(String str, WeiboListener weiboListener) {
        getFriendsStatusesAsync(str, weiboListener);
    }

    public void getFriendsStatusesAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(6, weiboListener, new Object[]{str}) { // from class: weibo4android.AsyncWeibo.44
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFriends(AsyncWeibo.this.getFriendsStatuses((String) objArr[0]));
            }
        });
    }

    @Deprecated
    public void getFriendsAsync(String str, Paging paging, WeiboListener weiboListener) {
        getFriendsStatusesAsync(str, paging, weiboListener);
    }

    public void getFriendsStatusesAsync(String str, Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(6, weiboListener, new Object[]{str, paging}) { // from class: weibo4android.AsyncWeibo.45
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFriends(AsyncWeibo.this.getFriendsStatuses((String) objArr[0], (Paging) objArr[1]));
            }
        });
    }

    @Deprecated
    public void getFriendsAsync(String str, int i, WeiboListener weiboListener) {
        getFriendsStatusesAsync(str, new Paging(i), weiboListener);
    }

    @Deprecated
    public void getFollowersAsync(WeiboListener weiboListener) {
        getFollowersStatusesAsync(weiboListener);
    }

    public void getFollowersStatusesAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(7, weiboListener, null) { // from class: weibo4android.AsyncWeibo.46
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFollowers(AsyncWeibo.this.getFollowers());
            }
        });
    }

    public void getFollowersAsync(Paging paging, WeiboListener weiboListener) {
        getFollowersStatusesAsync(paging, weiboListener);
    }

    public void getFollowersStatusesAsync(Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(7, weiboListener, new Object[]{paging}) { // from class: weibo4android.AsyncWeibo.47
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFollowers(AsyncWeibo.this.getFollowersStatuses((Paging) objArr[0]));
            }
        });
    }

    @Deprecated
    public void getFollowersAsync(int i, WeiboListener weiboListener) {
        getFollowersStatusesAsync(new Paging(i), weiboListener);
    }

    @Deprecated
    public void getFollowersAsync(String str, WeiboListener weiboListener) {
        getFollowersStatusesAsync(str, weiboListener);
    }

    public void getFollowersStatusesAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(7, weiboListener, new Object[]{str}) { // from class: weibo4android.AsyncWeibo.48
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFollowers(AsyncWeibo.this.getFollowersStatuses((String) objArr[0]));
            }
        });
    }

    @Deprecated
    public void getFollowersAsync(String str, Paging paging, WeiboListener weiboListener) {
        getFollowersStatusesAsync(str, paging, weiboListener);
    }

    public void getFollowersStatusesAsync(String str, Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(7, weiboListener, new Object[]{str, paging}) { // from class: weibo4android.AsyncWeibo.49
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFollowers(AsyncWeibo.this.getFollowersStatuses((String) objArr[0], (Paging) objArr[1]));
            }
        });
    }

    @Deprecated
    public void getFollowersAsync(String str, int i, WeiboListener weiboListener) {
        getFollowersStatusesAsync(str, new Paging(i), weiboListener);
    }

    public void getFeaturedAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(8, weiboListener, null) { // from class: weibo4android.AsyncWeibo.50
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFeatured(AsyncWeibo.this.getFeatured());
            }
        });
    }

    public void getDirectMessagesAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(10, weiboListener, null) { // from class: weibo4android.AsyncWeibo.51
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotDirectMessages(AsyncWeibo.this.getDirectMessages());
            }
        });
    }

    public void getDirectMessagesAsync(Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(10, weiboListener, new Object[]{paging}) { // from class: weibo4android.AsyncWeibo.52
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotDirectMessages(AsyncWeibo.this.getDirectMessages((Paging) objArr[0]));
            }
        });
    }

    @Deprecated
    public void getDirectMessagesByPageAsync(int i, WeiboListener weiboListener) {
        getDirectMessagesAsync(new Paging(i), weiboListener);
    }

    @Deprecated
    public void getDirectMessagesByPageAsync(int i, int i2, WeiboListener weiboListener) {
        getDirectMessagesAsync(new Paging(i, i2), weiboListener);
    }

    @Deprecated
    public void getDirectMessagesAsync(int i, WeiboListener weiboListener) {
        getDirectMessagesAsync(new Paging(i), weiboListener);
    }

    @Deprecated
    public void getDirectMessagesAsync(Date date, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(10, weiboListener, new Object[]{date}) { // from class: weibo4android.AsyncWeibo.53
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotDirectMessages(AsyncWeibo.this.getDirectMessages((Date) objArr[0]));
            }
        });
    }

    public void getSentDirectMessagesAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(10, weiboListener, null) { // from class: weibo4android.AsyncWeibo.54
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotSentDirectMessages(AsyncWeibo.this.getSentDirectMessages());
            }
        });
    }

    public void getSentDirectMessagesAsync(Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(10, weiboListener, new Object[]{paging}) { // from class: weibo4android.AsyncWeibo.55
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotSentDirectMessages(AsyncWeibo.this.getSentDirectMessages((Paging) objArr[0]));
            }
        });
    }

    @Deprecated
    public void getSentDirectMessagesAsync(Date date, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(10, weiboListener, new Object[]{date}) { // from class: weibo4android.AsyncWeibo.56
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotSentDirectMessages(AsyncWeibo.this.getSentDirectMessages((Date) objArr[0]));
            }
        });
    }

    @Deprecated
    public void getSentDirectMessagesAsync(int i, WeiboListener weiboListener) {
        getSentDirectMessagesAsync(new Paging(i), weiboListener);
    }

    @Deprecated
    public void getSentDirectMessagesAsync(int i, int i2, WeiboListener weiboListener) {
        getSentDirectMessagesAsync(new Paging(i, i2), weiboListener);
    }

    public void sendDirectMessageAsync(String str, String str2, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(11, weiboListener, new String[]{str, str2}) { // from class: weibo4android.AsyncWeibo.57
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.sentDirectMessage(AsyncWeibo.this.sendDirectMessage((String) objArr[0], (String) objArr[1]));
            }
        });
    }

    public void sendDirectMessageAsync(String str, String str2) {
        getDispatcher().invokeLater(new AsyncTask(11, new WeiboAdapter(), new String[]{str, str2}) { // from class: weibo4android.AsyncWeibo.58
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener, Object[] objArr) {
                weiboListener.sentDirectMessage(AsyncWeibo.this.sendDirectMessage((String) objArr[0], (String) objArr[1]));
            }
        });
    }

    @Deprecated
    public void deleteDirectMessageAsync(int i, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(40, weiboListener, new Object[]{Integer.valueOf(i)}) { // from class: weibo4android.AsyncWeibo.59
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.deletedDirectMessage(AsyncWeibo.this.deleteDirectMessage(((Integer) objArr[0]).intValue()));
            }
        });
    }

    public void destroyDirectMessageAsync(int i, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(40, weiboListener, new Object[]{Integer.valueOf(i)}) { // from class: weibo4android.AsyncWeibo.60
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.destroyedDirectMessage(AsyncWeibo.this.destroyDirectMessage(((Integer) objArr[0]).intValue()));
            }
        });
    }

    public void destroyDirectMessageAsync(int i) {
        getDispatcher().invokeLater(new AsyncTask(40, new WeiboAdapter(), new Object[]{Integer.valueOf(i)}) { // from class: weibo4android.AsyncWeibo.61
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener, Object[] objArr) {
                weiboListener.destroyedDirectMessage(AsyncWeibo.this.destroyDirectMessage(((Integer) objArr[0]).intValue()));
            }
        });
    }

    @Deprecated
    public void createAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(12, weiboListener, new String[]{str}) { // from class: weibo4android.AsyncWeibo.62
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.created(AsyncWeibo.this.create((String) objArr[0]));
            }
        });
    }

    public void createFriendshipAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(32, weiboListener, new String[]{str}) { // from class: weibo4android.AsyncWeibo.63
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.createdFriendship(AsyncWeibo.this.createFriendship((String) objArr[0]));
            }
        });
    }

    @Deprecated
    public void createAsync(String str) {
        getDispatcher().invokeLater(new AsyncTask(12, new WeiboAdapter(), new String[]{str}) { // from class: weibo4android.AsyncWeibo.64
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener, Object[] objArr) {
                weiboListener.created(AsyncWeibo.this.create((String) objArr[0]));
            }
        });
    }

    public void createFriendshipAsync(String str) {
        createFriendshipAsync(str, new WeiboAdapter());
    }

    @Deprecated
    public void existsAsync(String str, String str2, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(28, weiboListener, new String[]{str, str2}) { // from class: weibo4android.AsyncWeibo.65
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotExists(AsyncWeibo.this.exists((String) objArr[0], (String) objArr[1]));
            }
        });
    }

    public void existsFriendshipAsync(String str, String str2, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(34, weiboListener, new String[]{str, str2}) { // from class: weibo4android.AsyncWeibo.66
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotExistsFriendship(AsyncWeibo.this.existsFriendship((String) objArr[0], (String) objArr[1]));
            }
        });
    }

    public void getFriendsIDsAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(29, weiboListener, null) { // from class: weibo4android.AsyncWeibo.67
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFriendsIDs(AsyncWeibo.this.getFriendsIDs());
            }
        });
    }

    @Deprecated
    public void getFriendsIDsAsync(Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(29, weiboListener, new Object[]{paging}) { // from class: weibo4android.AsyncWeibo.68
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFriendsIDs(AsyncWeibo.this.getFriendsIDs((Paging) objArr[0]));
            }
        });
    }

    public void getFriendsIDsAsync(long j, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(29, weiboListener, new Object[]{Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.69
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFriendsIDs(AsyncWeibo.this.getFriendsIDs(((Long) objArr[0]).longValue()));
            }
        });
    }

    public void getFriendsIDsAsync(int i, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(29, weiboListener, new Integer[]{Integer.valueOf(i)}) { // from class: weibo4android.AsyncWeibo.70
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFriendsIDs(AsyncWeibo.this.getFriendsIDs(((Integer) objArr[0]).intValue()));
            }
        });
    }

    @Deprecated
    public void getFriendsIDsAsync(int i, Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(29, weiboListener, new Object[]{Integer.valueOf(i), paging}) { // from class: weibo4android.AsyncWeibo.71
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFriendsIDs(AsyncWeibo.this.getFriendsIDs(((Integer) objArr[0]).intValue(), (Paging) objArr[1]));
            }
        });
    }

    public void getFriendsIDsAsync(int i, long j, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(29, weiboListener, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.72
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFriendsIDs(AsyncWeibo.this.getFriendsIDs(((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue()));
            }
        });
    }

    public void getFriendsIDsAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(29, weiboListener, new String[]{str}) { // from class: weibo4android.AsyncWeibo.73
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFriendsIDs(AsyncWeibo.this.getFriendsIDs((String) objArr[0]));
            }
        });
    }

    @Deprecated
    public void getFriendsIDsAsync(String str, Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(29, weiboListener, new Object[]{str, paging}) { // from class: weibo4android.AsyncWeibo.74
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFriendsIDs(AsyncWeibo.this.getFriendsIDs((String) objArr[0], (Paging) objArr[1]));
            }
        });
    }

    public void getFriendsIDsAsync(String str, long j, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(29, weiboListener, new Object[]{str, Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.75
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFriendsIDs(AsyncWeibo.this.getFriendsIDs((String) objArr[0], ((Long) objArr[1]).longValue()));
            }
        });
    }

    public void getFollowersIDsAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(30, weiboListener, null) { // from class: weibo4android.AsyncWeibo.76
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFollowersIDs(AsyncWeibo.this.getFollowersIDs());
            }
        });
    }

    @Deprecated
    public void getFollowersIDsAsync(Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(30, weiboListener, new Object[]{paging}) { // from class: weibo4android.AsyncWeibo.77
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFollowersIDs(AsyncWeibo.this.getFollowersIDs((Paging) objArr[0]));
            }
        });
    }

    public void getFollowersIDsAsync(long j, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(30, weiboListener, new Object[]{Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.78
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFollowersIDs(AsyncWeibo.this.getFollowersIDs(((Long) objArr[0]).longValue()));
            }
        });
    }

    public void getFollowersIDsAsync(int i, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(30, weiboListener, new Integer[]{Integer.valueOf(i)}) { // from class: weibo4android.AsyncWeibo.79
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFollowersIDs(AsyncWeibo.this.getFollowersIDs(((Integer) objArr[0]).intValue()));
            }
        });
    }

    @Deprecated
    public void getFollowersIDsAsync(int i, Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(30, weiboListener, new Object[]{Integer.valueOf(i), paging}) { // from class: weibo4android.AsyncWeibo.80
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFollowersIDs(AsyncWeibo.this.getFollowersIDs(((Integer) objArr[0]).intValue(), (Paging) objArr[1]));
            }
        });
    }

    public void getFollowersIDsAsync(int i, long j, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(30, weiboListener, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.81
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFollowersIDs(AsyncWeibo.this.getFollowersIDs(((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue()));
            }
        });
    }

    public void getFollowersIDsAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(30, weiboListener, new String[]{str}) { // from class: weibo4android.AsyncWeibo.82
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFollowersIDs(AsyncWeibo.this.getFollowersIDs((String) objArr[0]));
            }
        });
    }

    @Deprecated
    public void getFollowersIDsAsync(String str, Paging paging, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(30, weiboListener, new Object[]{str, paging}) { // from class: weibo4android.AsyncWeibo.83
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFollowersIDs(AsyncWeibo.this.getFollowersIDs((String) objArr[0], (Paging) objArr[1]));
            }
        });
    }

    public void getFollowersIDsAsync(String str, long j, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(30, weiboListener, new Object[]{str, Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.84
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFollowersIDs(AsyncWeibo.this.getFollowersIDs((String) objArr[0], ((Long) objArr[1]).longValue()));
            }
        });
    }

    @Deprecated
    public void updateLocationAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(20, weiboListener, new Object[]{str}) { // from class: weibo4android.AsyncWeibo.85
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.updatedLocation(AsyncWeibo.this.updateLocation((String) objArr[0]));
            }
        });
    }

    public void updateProfileAsync(String str, String str2, String str3, String str4, String str5, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(41, weiboListener, new String[]{str, str2, str3, str4, str5}) { // from class: weibo4android.AsyncWeibo.86
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.updatedProfile(AsyncWeibo.this.updateProfile((String) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3], (String) objArr[4]));
            }
        });
    }

    public void updateProfileAsync(String str, String str2, String str3, String str4, String str5) {
        updateProfileAsync(str, str2, str3, str4, str5, new WeiboAdapter());
    }

    public void rateLimitStatusAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(28, weiboListener, new Object[0]) { // from class: weibo4android.AsyncWeibo.87
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotRateLimitStatus(AsyncWeibo.this.rateLimitStatus());
            }
        });
    }

    @Deprecated
    public void favoritesAsync(WeiboListener weiboListener) {
        getFavoritesAsync(weiboListener);
    }

    public void getFavoritesAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(17, weiboListener, null) { // from class: weibo4android.AsyncWeibo.88
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFavorites(AsyncWeibo.this.getFavorites());
            }
        });
    }

    @Deprecated
    public void favoritesAsync(int i, WeiboListener weiboListener) {
        getFavoritesAsync(i, weiboListener);
    }

    public void getFavoritesAsync(int i, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(17, weiboListener, new Object[]{Integer.valueOf(i)}) { // from class: weibo4android.AsyncWeibo.89
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFavorites(AsyncWeibo.this.getFavorites(((Integer) objArr[0]).intValue()));
            }
        });
    }

    @Deprecated
    public void favoritesAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(17, weiboListener, new Object[]{str}) { // from class: weibo4android.AsyncWeibo.90
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFavorites(AsyncWeibo.this.favorites((String) objArr[0]));
            }
        });
    }

    public void getFavoritesAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(17, weiboListener, new Object[]{str}) { // from class: weibo4android.AsyncWeibo.91
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFavorites(AsyncWeibo.this.getFavorites((String) objArr[0]));
            }
        });
    }

    @Deprecated
    public void favoritesAsync(String str, int i, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(17, weiboListener, new Object[]{str, Integer.valueOf(i)}) { // from class: weibo4android.AsyncWeibo.92
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFavorites(AsyncWeibo.this.favorites((String) objArr[0], ((Integer) objArr[1]).intValue()));
            }
        });
    }

    public void getFavoritesAsync(String str, int i, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(17, weiboListener, new Object[]{str, Integer.valueOf(i)}) { // from class: weibo4android.AsyncWeibo.93
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotFavorites(AsyncWeibo.this.getFavorites((String) objArr[0], ((Integer) objArr[1]).intValue()));
            }
        });
    }

    @Deprecated
    public void createFavoriteAsync(int i, WeiboListener weiboListener) {
        createFavoriteAsync(i, weiboListener);
    }

    public void createFavoriteAsync(long j, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(17, weiboListener, new Object[]{Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.94
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.createdFavorite(AsyncWeibo.this.createFavorite(((Long) objArr[0]).longValue()));
            }
        });
    }

    @Deprecated
    public void createFavoriteAsync(int i) {
        createFavoriteAsync(i);
    }

    public void createFavoriteAsync(long j) {
        getDispatcher().invokeLater(new AsyncTask(17, new WeiboAdapter(), new Object[]{Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.95
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener, Object[] objArr) {
                weiboListener.createdFavorite(AsyncWeibo.this.createFavorite(((Long) objArr[0]).longValue()));
            }
        });
    }

    @Deprecated
    public void destroyFavoriteAsync(int i, WeiboListener weiboListener) {
        destroyFavoriteAsync(i, weiboListener);
    }

    public void destroyFavoriteAsync(long j, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(17, weiboListener, new Object[]{Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.96
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.destroyedFavorite(AsyncWeibo.this.destroyFavorite(((Long) objArr[0]).longValue()));
            }
        });
    }

    @Deprecated
    public void destroyFavoriteAsync(int i) {
        destroyFavoriteAsync(i);
    }

    public void destroyFavoriteAsync(long j) {
        getDispatcher().invokeLater(new AsyncTask(17, new WeiboAdapter(), new Object[]{Long.valueOf(j)}) { // from class: weibo4android.AsyncWeibo.97
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener, Object[] objArr) {
                weiboListener.destroyedFavorite(AsyncWeibo.this.destroyFavorite(((Long) objArr[0]).longValue()));
            }
        });
    }

    @Deprecated
    public void followAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(14, weiboListener, new String[]{str}) { // from class: weibo4android.AsyncWeibo.98
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.followed(AsyncWeibo.this.follow((String) objArr[0]));
            }
        });
    }

    public void enableNotificationAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(35, weiboListener, new String[]{str}) { // from class: weibo4android.AsyncWeibo.99
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.enabledNotification(AsyncWeibo.this.enableNotification((String) objArr[0]));
            }
        });
    }

    @Deprecated
    public void followAsync(String str) {
        getDispatcher().invokeLater(new AsyncTask(14, new WeiboAdapter(), new String[]{str}) { // from class: weibo4android.AsyncWeibo.100
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener, Object[] objArr) {
                weiboListener.followed(AsyncWeibo.this.follow((String) objArr[0]));
            }
        });
    }

    public void enableNotificationAsync(String str) {
        enableNotificationAsync(str, new WeiboAdapter());
    }

    @Deprecated
    public void leaveAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(15, weiboListener, new String[]{str}) { // from class: weibo4android.AsyncWeibo.101
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.left(AsyncWeibo.this.leave((String) objArr[0]));
            }
        });
    }

    public void disableNotificationAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(36, weiboListener, new String[]{str}) { // from class: weibo4android.AsyncWeibo.102
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.disabledNotification(AsyncWeibo.this.disableNotification((String) objArr[0]));
            }
        });
    }

    @Deprecated
    public void leaveAsync(String str) {
        getDispatcher().invokeLater(new AsyncTask(15, new WeiboAdapter(), new String[]{str}) { // from class: weibo4android.AsyncWeibo.103
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener, Object[] objArr) {
                weiboListener.left(AsyncWeibo.this.leave((String) objArr[0]));
            }
        });
    }

    public void disableNotificationAsync(String str) {
        disableNotificationAsync(str, new WeiboAdapter());
    }

    @Deprecated
    public void blockAsync(String str) {
        getDispatcher().invokeLater(new AsyncTask(22, new WeiboAdapter(), new String[]{str}) { // from class: weibo4android.AsyncWeibo.104
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener, Object[] objArr) {
                weiboListener.blocked(AsyncWeibo.this.block((String) objArr[0]));
            }
        });
    }

    public void createBlockAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(43, weiboListener, new String[]{str}) { // from class: weibo4android.AsyncWeibo.105
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.createdBlock(AsyncWeibo.this.createBlock((String) objArr[0]));
            }
        });
    }

    public void createBlockAsync(String str) {
        createBlockAsync(str, new WeiboAdapter());
    }

    @Deprecated
    public void unblockAsync(String str) {
        getDispatcher().invokeLater(new AsyncTask(23, new WeiboAdapter(), new String[]{str}) { // from class: weibo4android.AsyncWeibo.106
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener, Object[] objArr) {
                weiboListener.unblocked(AsyncWeibo.this.unblock((String) objArr[0]));
            }
        });
    }

    public void destroyBlockAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(42, weiboListener, new String[]{str}) { // from class: weibo4android.AsyncWeibo.107
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.destroyedBlock(AsyncWeibo.this.destroyBlock((String) objArr[0]));
            }
        });
    }

    public void destroyBlockAsync(String str) {
        destroyBlockAsync(str, new WeiboAdapter());
    }

    public void existsBlockAsync(String str, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(48, weiboListener, new String[]{str}) { // from class: weibo4android.AsyncWeibo.108
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotExistsBlock(AsyncWeibo.this.existsBlock((String) objArr[0]));
            }
        });
    }

    public void getBlockingUsersAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(49, weiboListener, null) { // from class: weibo4android.AsyncWeibo.109
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotBlockingUsers(AsyncWeibo.this.getBlockingUsers());
            }
        });
    }

    public void getBlockingUsersAsync(int i, WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(49, weiboListener, new Integer[]{Integer.valueOf(i)}) { // from class: weibo4android.AsyncWeibo.110
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotBlockingUsers(AsyncWeibo.this.getBlockingUsers(((Integer) objArr[0]).intValue()));
            }
        });
    }

    public void getBlockingUsersIDsAsync(WeiboListener weiboListener) {
        getDispatcher().invokeLater(new AsyncTask(50, weiboListener, null) { // from class: weibo4android.AsyncWeibo.111
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener2, Object[] objArr) {
                weiboListener2.gotBlockingUsersIDs(AsyncWeibo.this.getBlockingUsersIDs());
            }
        });
    }

    public void testAsync() {
        getDispatcher().invokeLater(new AsyncTask(24, new WeiboAdapter(), new Object[0]) { // from class: weibo4android.AsyncWeibo.112
            @Override // weibo4android.AsyncWeibo.AsyncTask
            public void invoke(WeiboListener weiboListener, Object[] objArr) {
                weiboListener.tested(AsyncWeibo.this.test());
            }
        });
    }

    public void shutdown() {
        synchronized (AsyncWeibo.class) {
            this.shutdown = true;
            throw new IllegalStateException("Already shut down");
        }
    }

    private Dispatcher getDispatcher() {
        if (true == this.shutdown) {
            throw new IllegalStateException("Already shut down");
        }
        if (dispatcher == null) {
            dispatcher = new Dispatcher("Weibo4J Async Dispatcher", Configuration.getNumberOfAsyncThreads());
        }
        return dispatcher;
    }

    public void getDowntimeScheduleAsync() {
        throw new RuntimeException("this method is not supported by the Weibo API anymore", new NoSuchMethodException("this method is not supported by the Weibo API anymore"));
    }

    public void getAuthenticatedUserAsync(WeiboListener weiboListener) {
        if (getUserId() == null) {
            throw new IllegalStateException("User Id not specified.");
        }
        getUserDetailAsync(getUserId(), weiboListener);
    }

    abstract class AsyncTask implements Runnable {
        Object[] args;
        WeiboListener listener;
        int method;

        abstract void invoke(WeiboListener weiboListener, Object[] objArr);

        AsyncTask(int i, WeiboListener weiboListener, Object[] objArr) {
            this.method = i;
            this.listener = weiboListener;
            this.args = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                invoke(this.listener, this.args);
            } catch (WeiboException e) {
                if (this.listener != null) {
                    this.listener.onException(e, this.method);
                }
            }
        }
    }
}
