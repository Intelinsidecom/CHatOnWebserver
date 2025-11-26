package weibo4android;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import weibo4android.http.PostParameter;

/* loaded from: classes.dex */
public class Query {
    private Date endtime;
    private int filter_pic;
    private Integer fuid;

    /* renamed from: q */
    private String f7913q;
    private Date starttime;
    private Boolean snick = null;
    private int rpp = 20;
    private Boolean sdomain = null;
    private Boolean sintro = null;
    private Integer province = null;
    private Integer city = null;
    private Gender gender = null;
    private String comorsch = null;
    private int sort = 1;
    private Integer page = null;
    private Integer count = null;
    private boolean base_app = true;
    private int filter_ori = 0;
    private boolean needcount = false;
    private String geocode = null;

    public void setQ(String str) {
        this.f7913q = str;
    }

    public String getQ() {
        return this.f7913q;
    }

    public Boolean getSnick() {
        return this.snick;
    }

    public void setSnick(Boolean bool) {
        this.snick = bool;
    }

    public int getRpp() {
        return this.rpp;
    }

    public void setRpp(int i) {
        this.rpp = i;
    }

    public Boolean getSdomain() {
        return this.sdomain;
    }

    public void setSdomain(Boolean bool) {
        this.sdomain = bool;
    }

    public Boolean getSintro() {
        return this.sintro;
    }

    public void setSintro(Boolean bool) {
        this.sintro = bool;
    }

    public Integer getProvince() {
        return this.province;
    }

    public void setProvince(Integer num) {
        this.province = num;
    }

    public Integer getCity() {
        return this.city;
    }

    public void setCity(Integer num) {
        this.city = num;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getComorsch() {
        return this.comorsch;
    }

    public void setComorsch(String str) {
        this.comorsch = str;
    }

    public int getSort() {
        return this.sort;
    }

    public void setSort(int i) {
        this.sort = i;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer num) {
        this.page = num;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer num) {
        this.count = num;
    }

    public boolean getBase_app() {
        return this.base_app;
    }

    public void setBase_app(boolean z) {
        this.base_app = z;
    }

    public int getFilter_ori() {
        return this.filter_ori;
    }

    public void setFilter_ori(int i) {
        this.filter_ori = i;
    }

    public int getFilter_pic() {
        return this.filter_pic;
    }

    public void setFilter_pic(int i) {
        this.filter_pic = i;
    }

    public Integer getFuid() {
        return this.fuid;
    }

    public void setFuid(Integer num) {
        this.fuid = num;
    }

    public Date getStarttime() {
        return this.starttime;
    }

    public void setStarttime(Date date) {
        this.starttime = date;
    }

    public Date getEndtime() {
        return this.endtime;
    }

    public void setEndtime(Date date) {
        this.endtime = date;
    }

    public boolean getNeedcount() {
        return this.needcount;
    }

    public void setNeedcount(boolean z) {
        this.needcount = z;
    }

    public String getGeocode() {
        return this.geocode;
    }

    public void setGeocode(String str) {
        this.geocode = str;
    }

    public PostParameter[] getParameters() throws IllegalAccessException, IllegalArgumentException, WeiboException, InvocationTargetException {
        ArrayList arrayList = new ArrayList();
        for (Field field : Query.class.getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            try {
                Object objInvoke = Query.class.getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1), new Class[0]).invoke(this, new Object[0]);
                if (objInvoke != null) {
                    arrayList.add(getParameterValue(name, objInvoke));
                }
            } catch (Exception e) {
                throw new WeiboException(e);
            }
        }
        return (PostParameter[]) arrayList.toArray(new PostParameter[arrayList.size()]);
    }

    private PostParameter getParameterValue(String str, Object obj) {
        if (obj instanceof Boolean) {
            return new PostParameter(str, ((Boolean) obj).booleanValue() ? "0" : "1");
        }
        if (obj instanceof String) {
            return new PostParameter(str, obj.toString());
        }
        if (obj instanceof Integer) {
            return new PostParameter(str, Integer.toString(((Integer) obj).intValue()));
        }
        if (obj instanceof Gender) {
            return new PostParameter(str, Gender.valueOf((Gender) obj));
        }
        return null;
    }
}
