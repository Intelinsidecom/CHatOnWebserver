package com.sec.chaton.smsplugin.p111h;

import com.renren.android.Renren;
import java.util.HashMap;
import java.util.regex.Pattern;

/* compiled from: MessageMimeTypeMap.java */
/* renamed from: com.sec.chaton.smsplugin.h.n */
/* loaded from: classes.dex */
public class C3891n {

    /* renamed from: a */
    private static volatile C3891n f13994a = null;

    /* renamed from: b */
    private static volatile C3891n f13995b = null;

    /* renamed from: c */
    private HashMap<String, String> f13996c = new HashMap<>();

    /* renamed from: d */
    private HashMap<String, String> f13997d = new HashMap<>();

    private C3891n() {
    }

    /* renamed from: a */
    public static String m15002a(String str) {
        int iLastIndexOf;
        if (str != null && str.length() > 0) {
            int iLastIndexOf2 = str.lastIndexOf(63);
            if (iLastIndexOf2 > 0) {
                str = str.substring(0, iLastIndexOf2);
            }
            int iLastIndexOf3 = str.lastIndexOf(47);
            if (iLastIndexOf3 >= 0) {
                str = str.substring(iLastIndexOf3 + 1);
            }
            if (str.length() > 0 && Pattern.matches("[a-zA-Z_0-9\\.\\-\\(\\)]+", str) && (iLastIndexOf = str.lastIndexOf(46)) >= 0) {
                return str.substring(iLastIndexOf + 1).toLowerCase();
            }
        }
        return "";
    }

    /* renamed from: a */
    private void m15003a(String str, String str2) {
        if (!this.f13996c.containsKey(str)) {
            this.f13996c.put(str, str2);
        }
        this.f13997d.put(str2, str);
    }

    /* renamed from: b */
    public String m15005b(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return this.f13997d.get(str);
    }

    /* renamed from: c */
    public String m15006c(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return this.f13996c.get(str.toLowerCase());
    }

    /* renamed from: a */
    public static C3891n m15001a() {
        if (f13994a == null) {
            synchronized (C3891n.class) {
                if (f13994a == null) {
                    f13994a = new C3891n();
                    f13994a.m15003a("application/andrew-inset", "ez");
                    f13994a.m15003a("application/dsptype", "tsp");
                    f13994a.m15003a("application/futuresplash", "spl");
                    f13994a.m15003a("application/hta", "hta");
                    f13994a.m15003a("application/mac-binhex40", "hqx");
                    f13994a.m15003a("application/mac-compactpro", "cpt");
                    f13994a.m15003a("application/mathematica", "nb");
                    f13994a.m15003a("application/msaccess", "mdb");
                    f13994a.m15003a("application/oda", "oda");
                    f13994a.m15003a("application/ogg", "ogg");
                    f13994a.m15003a("application/pdf", "pdf");
                    f13994a.m15003a("application/pgp-keys", "key");
                    f13994a.m15003a("application/pgp-signature", "pgp");
                    f13994a.m15003a("application/pics-rules", "prf");
                    f13994a.m15003a("application/rar", "rar");
                    f13994a.m15003a("application/rdf+xml", "rdf");
                    f13994a.m15003a("application/rss+xml", "rss");
                    f13994a.m15003a("application/zip", "zip");
                    f13994a.m15003a("application/vnd.android.package-archive", "apk");
                    f13994a.m15003a("application/vnd.cinderella", "cdy");
                    f13994a.m15003a("application/vnd.ms-pki.stl", "stl");
                    f13994a.m15003a("application/vnd.oasis.opendocument.database", "odb");
                    f13994a.m15003a("application/vnd.oasis.opendocument.formula", "odf");
                    f13994a.m15003a("application/vnd.oasis.opendocument.graphics", "odg");
                    f13994a.m15003a("application/vnd.oasis.opendocument.graphics-template", "otg");
                    f13994a.m15003a("application/vnd.oasis.opendocument.image", "odi");
                    f13994a.m15003a("application/vnd.oasis.opendocument.spreadsheet", "ods");
                    f13994a.m15003a("application/vnd.oasis.opendocument.spreadsheet-template", "ots");
                    f13994a.m15003a("application/vnd.oasis.opendocument.text", "odt");
                    f13994a.m15003a("application/vnd.oasis.opendocument.text-master", "odm");
                    f13994a.m15003a("application/vnd.oasis.opendocument.text-template", "ott");
                    f13994a.m15003a("application/vnd.oasis.opendocument.text-web", "oth");
                    f13994a.m15003a("application/msword", "doc");
                    f13994a.m15003a("application/msword", "dot");
                    f13994a.m15003a("application/vnd.openxmlformats-officedocument.wordprocessingml.document", "docx");
                    f13994a.m15003a("application/vnd.openxmlformats-officedocument.wordprocessingml.template", "dotx");
                    f13994a.m15003a("application/vnd.ms-excel", "xls");
                    f13994a.m15003a("application/vnd.ms-excel", "xlt");
                    f13994a.m15003a("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "xlsx");
                    f13994a.m15003a("application/vnd.openxmlformats-officedocument.spreadsheetml.template", "xltx");
                    f13994a.m15003a("application/vnd.ms-powerpoint", "ppt");
                    f13994a.m15003a("application/vnd.ms-powerpoint", "pot");
                    f13994a.m15003a("application/vnd.ms-powerpoint", "pps");
                    f13994a.m15003a("application/vnd.openxmlformats-officedocument.presentationml.presentation", "pptx");
                    f13994a.m15003a("application/vnd.openxmlformats-officedocument.presentationml.template", "potx");
                    f13994a.m15003a("application/vnd.openxmlformats-officedocument.presentationml.slideshow", "ppsx");
                    f13994a.m15003a("application/vnd.rim.cod", "cod");
                    f13994a.m15003a("application/vnd.smaf", "mmf");
                    f13994a.m15003a("application/vnd.stardivision.calc", "sdc");
                    f13994a.m15003a("application/vnd.stardivision.draw", "sda");
                    f13994a.m15003a("application/vnd.stardivision.impress", "sdd");
                    f13994a.m15003a("application/vnd.stardivision.impress", "sdp");
                    f13994a.m15003a("application/vnd.stardivision.math", "smf");
                    f13994a.m15003a("application/vnd.stardivision.writer", "sdw");
                    f13994a.m15003a("application/vnd.stardivision.writer", "vor");
                    f13994a.m15003a("application/vnd.stardivision.writer-global", "sgl");
                    f13994a.m15003a("application/vnd.sun.xml.calc", "sxc");
                    f13994a.m15003a("application/vnd.sun.xml.calc.template", "stc");
                    f13994a.m15003a("application/vnd.sun.xml.draw", "sxd");
                    f13994a.m15003a("application/vnd.sun.xml.draw.template", "std");
                    f13994a.m15003a("application/vnd.sun.xml.impress", "sxi");
                    f13994a.m15003a("application/vnd.sun.xml.impress.template", "sti");
                    f13994a.m15003a("application/vnd.sun.xml.math", "sxm");
                    f13994a.m15003a("application/vnd.sun.xml.writer", "sxw");
                    f13994a.m15003a("application/vnd.sun.xml.writer.global", "sxg");
                    f13994a.m15003a("application/vnd.sun.xml.writer.template", "stw");
                    f13994a.m15003a("application/vnd.visio", "vsd");
                    f13994a.m15003a("application/x-abiword", "abw");
                    f13994a.m15003a("application/x-apple-diskimage", "dmg");
                    f13994a.m15003a("application/x-bcpio", "bcpio");
                    f13994a.m15003a("application/x-bittorrent", "torrent");
                    f13994a.m15003a("application/x-cdf", "cdf");
                    f13994a.m15003a("application/x-cdlink", "vcd");
                    f13994a.m15003a("application/x-chess-pgn", "pgn");
                    f13994a.m15003a("application/x-cpio", "cpio");
                    f13994a.m15003a("application/x-debian-package", "deb");
                    f13994a.m15003a("application/x-debian-package", "udeb");
                    f13994a.m15003a("application/x-director", "dcr");
                    f13994a.m15003a("application/x-director", "dir");
                    f13994a.m15003a("application/x-director", "dxr");
                    f13994a.m15003a("application/x-dms", "dms");
                    f13994a.m15003a("application/x-doom", "wad");
                    f13994a.m15003a("application/x-dvi", "dvi");
                    f13994a.m15003a("application/x-flac", "flac");
                    f13994a.m15003a("application/x-font", "pfa");
                    f13994a.m15003a("application/x-font", "pfb");
                    f13994a.m15003a("application/x-font", "gsf");
                    f13994a.m15003a("application/x-font", "pcf");
                    f13994a.m15003a("application/x-font", "pcf.Z");
                    f13994a.m15003a("application/x-freemind", "mm");
                    f13994a.m15003a("application/x-futuresplash", "spl");
                    f13994a.m15003a("application/x-gnumeric", "gnumeric");
                    f13994a.m15003a("application/x-go-sgf", "sgf");
                    f13994a.m15003a("application/x-graphing-calculator", "gcf");
                    f13994a.m15003a("application/x-gtar", "gtar");
                    f13994a.m15003a("application/x-gtar", "tgz");
                    f13994a.m15003a("application/x-gtar", "taz");
                    f13994a.m15003a("application/x-hdf", "hdf");
                    f13994a.m15003a("application/x-ica", "ica");
                    f13994a.m15003a("application/x-internet-signup", "ins");
                    f13994a.m15003a("application/x-internet-signup", "isp");
                    f13994a.m15003a("application/x-iphone", "iii");
                    f13994a.m15003a("application/x-iso9660-image", "iso");
                    f13994a.m15003a("application/x-jmol", "jmz");
                    f13994a.m15003a("application/x-kchart", "chrt");
                    f13994a.m15003a("application/x-killustrator", "kil");
                    f13994a.m15003a("application/x-koan", "skp");
                    f13994a.m15003a("application/x-koan", "skd");
                    f13994a.m15003a("application/x-koan", "skt");
                    f13994a.m15003a("application/x-koan", "skm");
                    f13994a.m15003a("application/x-kpresenter", "kpr");
                    f13994a.m15003a("application/x-kpresenter", "kpt");
                    f13994a.m15003a("application/x-kspread", "ksp");
                    f13994a.m15003a("application/x-kword", "kwd");
                    f13994a.m15003a("application/x-kword", "kwt");
                    f13994a.m15003a("application/x-latex", "latex");
                    f13994a.m15003a("application/x-lha", "lha");
                    f13994a.m15003a("application/x-lzh", "lzh");
                    f13994a.m15003a("application/x-lzx", "lzx");
                    f13994a.m15003a("application/x-maker", "frm");
                    f13994a.m15003a("application/x-maker", "maker");
                    f13994a.m15003a("application/x-maker", "frame");
                    f13994a.m15003a("application/x-maker", "fb");
                    f13994a.m15003a("application/x-maker", "book");
                    f13994a.m15003a("application/x-maker", "fbdoc");
                    f13994a.m15003a("application/x-mif", "mif");
                    f13994a.m15003a("application/x-ms-wmd", "wmd");
                    f13994a.m15003a("application/x-ms-wmz", "wmz");
                    f13994a.m15003a("application/x-msi", "msi");
                    f13994a.m15003a("application/x-ns-proxy-autoconfig", "pac");
                    f13994a.m15003a("application/x-nwc", "nwc");
                    f13994a.m15003a("application/x-object", "o");
                    f13994a.m15003a("application/x-oz-application", "oza");
                    f13994a.m15003a("application/x-pkcs12", "p12");
                    f13994a.m15003a("application/x-pkcs7-certreqresp", "p7r");
                    f13994a.m15003a("application/x-pkcs7-crl", "crl");
                    f13994a.m15003a("application/x-quicktimeplayer", "qtl");
                    f13994a.m15003a("application/x-shar", "shar");
                    f13994a.m15003a("application/x-stuffit", "sit");
                    f13994a.m15003a("application/x-sv4cpio", "sv4cpio");
                    f13994a.m15003a("application/x-sv4crc", "sv4crc");
                    f13994a.m15003a("application/x-tar", "tar");
                    f13994a.m15003a("application/x-texinfo", "texinfo");
                    f13994a.m15003a("application/x-texinfo", "texi");
                    f13994a.m15003a("application/x-troff", "t");
                    f13994a.m15003a("application/x-troff", "roff");
                    f13994a.m15003a("application/x-troff-man", "man");
                    f13994a.m15003a("application/x-ustar", "ustar");
                    f13994a.m15003a("application/x-wais-source", "src");
                    f13994a.m15003a("application/x-wingz", "wz");
                    f13994a.m15003a("application/x-webarchive", "webarchive");
                    f13994a.m15003a("application/x-x509-ca-cert", "crt");
                    f13994a.m15003a("application/x-x509-user-cert", "crt");
                    f13994a.m15003a("application/x-xcf", "xcf");
                    f13994a.m15003a("application/x-xfig", "fig");
                    f13994a.m15003a("application/xhtml+xml", "xhtml");
                    f13994a.m15003a("audio/basic", "snd");
                    f13994a.m15003a("audio/midi", "mid");
                    f13994a.m15003a("audio/midi", "midi");
                    f13994a.m15003a("audio/midi", "kar");
                    f13994a.m15003a("audio/mpeg", "mpga");
                    f13994a.m15003a("audio/mpeg", "mpega");
                    f13994a.m15003a("audio/mpeg", "mp2");
                    f13994a.m15003a("audio/mpeg", "mp3");
                    f13994a.m15003a("audio/mpeg", "m4a");
                    f13994a.m15003a("audio/mpegurl", "m3u");
                    f13994a.m15003a("audio/prs.sid", "sid");
                    f13994a.m15003a("audio/x-aiff", "aif");
                    f13994a.m15003a("audio/x-aiff", "aiff");
                    f13994a.m15003a("audio/x-aiff", "aifc");
                    f13994a.m15003a("audio/x-gsm", "gsm");
                    f13994a.m15003a("audio/x-mpegurl", "m3u");
                    f13994a.m15003a("audio/x-ms-wma", "wma");
                    f13994a.m15003a("audio/x-ms-wax", "wax");
                    f13994a.m15003a("audio/x-pn-realaudio", "ra");
                    f13994a.m15003a("audio/x-pn-realaudio", "rm");
                    f13994a.m15003a("audio/x-pn-realaudio", "ram");
                    f13994a.m15003a("audio/x-realaudio", "ra");
                    f13994a.m15003a("audio/x-scpls", "pls");
                    f13994a.m15003a("audio/x-sd2", "sd2");
                    f13994a.m15003a("audio/x-wav", "wav");
                    f13994a.m15003a("audio/amr", "amr");
                    f13994a.m15003a("audio/aac", "aac");
                    f13994a.m15003a("audio/imelody", "imy");
                    f13994a.m15003a("audio/flac", "flac");
                    f13994a.m15003a("audio/mp4", "m4a");
                    f13994a.m15003a("audio/mobile-xmf", "mxmf");
                    f13994a.m15003a("audio/3gpp", "3ga");
                    f13994a.m15003a("audio/3gpp", "3gp");
                    f13994a.m15003a("audio/amr-wb", "awb");
                    f13994a.m15003a("audio/vnd.qcelp", "qcp");
                    f13994a.m15003a("audio/qcelp", "qcp");
                    f13994a.m15003a("audio/evrc", "qcp");
                    f13994a.m15003a("image/bmp", "bmp");
                    f13994a.m15003a("image/gif", "gif");
                    f13994a.m15003a("image/ico", "cur");
                    f13994a.m15003a("image/ico", "ico");
                    f13994a.m15003a("image/ief", "ief");
                    f13994a.m15003a("image/jpeg", "jpeg");
                    f13994a.m15003a("image/jpeg", "jpg");
                    f13994a.m15003a("image/jpeg", "map");
                    f13994a.m15003a("image/jpeg", "jpe");
                    f13994a.m15003a("image/jpg", "jpg");
                    f13994a.m15003a("image/pcx", "pcx");
                    f13994a.m15003a("image/png", "png");
                    f13994a.m15003a("image/svg+xml", "svg");
                    f13994a.m15003a("image/svg+xml", "svgz");
                    f13994a.m15003a("image/tiff", "tiff");
                    f13994a.m15003a("image/tiff", "tif");
                    f13994a.m15003a("image/vnd.djvu", "djvu");
                    f13994a.m15003a("image/vnd.djvu", "djv");
                    f13994a.m15003a("image/vnd.wap.wbmp", "wbmp");
                    f13994a.m15003a("image/x-cmu-raster", "ras");
                    f13994a.m15003a("image/x-coreldraw", "cdr");
                    f13994a.m15003a("image/x-coreldrawpattern", "pat");
                    f13994a.m15003a("image/x-coreldrawtemplate", "cdt");
                    f13994a.m15003a("image/x-corelphotopaint", "cpt");
                    f13994a.m15003a("image/x-icon", "ico");
                    f13994a.m15003a("image/x-jg", "art");
                    f13994a.m15003a("image/x-jng", "jng");
                    f13994a.m15003a("image/x-ms-bmp", "bmp");
                    f13994a.m15003a("image/x-photoshop", "psd");
                    f13994a.m15003a("image/x-portable-anymap", "pnm");
                    f13994a.m15003a("image/x-portable-bitmap", "pbm");
                    f13994a.m15003a("image/x-portable-graymap", "pgm");
                    f13994a.m15003a("image/x-portable-pixmap", "ppm");
                    f13994a.m15003a("image/x-rgb", "rgb");
                    f13994a.m15003a("image/x-xbitmap", "xbm");
                    f13994a.m15003a("image/x-xpixmap", "xpm");
                    f13994a.m15003a("image/x-xwindowdump", "xwd");
                    f13994a.m15003a("model/iges", "igs");
                    f13994a.m15003a("model/iges", "iges");
                    f13994a.m15003a("model/mesh", "msh");
                    f13994a.m15003a("model/mesh", "mesh");
                    f13994a.m15003a("model/mesh", "silo");
                    f13994a.m15003a("text/calendar", "ics");
                    f13994a.m15003a("text/calendar", "icz");
                    f13994a.m15003a("text/comma-separated-values", "csv");
                    f13994a.m15003a("text/css", "css");
                    f13994a.m15003a("text/h323", "323");
                    f13994a.m15003a("text/iuls", "uls");
                    f13994a.m15003a("text/mathml", "mml");
                    f13994a.m15003a("text/plain", "txt");
                    f13994a.m15003a("text/plain", "asc");
                    f13994a.m15003a("text/plain", "text");
                    f13994a.m15003a("text/plain", "diff");
                    f13994a.m15003a("text/plain", "po");
                    f13994a.m15003a("text/richtext", "rtx");
                    f13994a.m15003a("text/rtf", "rtf");
                    f13994a.m15003a("text/texmacs", "ts");
                    f13994a.m15003a("text/text", "phps");
                    f13994a.m15003a("text/tab-separated-values", "tsv");
                    f13994a.m15003a("text/xml", Renren.RESPONSE_FORMAT_XML);
                    f13994a.m15003a("text/x-bibtex", "bib");
                    f13994a.m15003a("text/x-boo", "boo");
                    f13994a.m15003a("text/x-c++hdr", "h++");
                    f13994a.m15003a("text/x-c++hdr", "hpp");
                    f13994a.m15003a("text/x-c++hdr", "hxx");
                    f13994a.m15003a("text/x-c++hdr", "hh");
                    f13994a.m15003a("text/x-c++src", "c++");
                    f13994a.m15003a("text/x-c++src", "cpp");
                    f13994a.m15003a("text/x-c++src", "cxx");
                    f13994a.m15003a("text/x-chdr", "h");
                    f13994a.m15003a("text/x-component", "htc");
                    f13994a.m15003a("text/x-csh", "csh");
                    f13994a.m15003a("text/x-csrc", "c");
                    f13994a.m15003a("text/x-dsrc", "d");
                    f13994a.m15003a("text/x-haskell", "hs");
                    f13994a.m15003a("text/x-java", "java");
                    f13994a.m15003a("text/x-literate-haskell", "lhs");
                    f13994a.m15003a("text/x-moc", "moc");
                    f13994a.m15003a("text/x-pascal", "p");
                    f13994a.m15003a("text/x-pascal", "pas");
                    f13994a.m15003a("text/x-pcs-gcd", "gcd");
                    f13994a.m15003a("text/x-setext", "etx");
                    f13994a.m15003a("text/x-tcl", "tcl");
                    f13994a.m15003a("text/x-tex", "tex");
                    f13994a.m15003a("text/x-tex", "ltx");
                    f13994a.m15003a("text/x-tex", "sty");
                    f13994a.m15003a("text/x-tex", "cls");
                    f13994a.m15003a("text/x-vcalendar", "vcs");
                    f13994a.m15003a("text/x-vcard", "vcf");
                    f13994a.m15003a("text/x-vnote", "vnt");
                    f13994a.m15003a("text/html", "html");
                    f13994a.m15003a("text/x-vtodo", "vts");
                    f13994a.m15003a("video/3gpp", "3gp");
                    f13994a.m15003a("video/3gpp", "3g2");
                    f13994a.m15003a("video/dl", "dl");
                    f13994a.m15003a("video/dv", "dif");
                    f13994a.m15003a("video/dv", "dv");
                    f13994a.m15003a("video/fli", "fli");
                    f13994a.m15003a("video/mpeg", "mpeg");
                    f13994a.m15003a("video/mpeg", "mpg");
                    f13994a.m15003a("video/mpeg", "mpe");
                    f13994a.m15003a("video/mp4", "mp4");
                    f13994a.m15003a("video/mpeg", "VOB");
                    f13994a.m15003a("video/quicktime", "qt");
                    f13994a.m15003a("video/quicktime", "mov");
                    f13994a.m15003a("video/vnd.mpegurl", "mxu");
                    f13994a.m15003a("video/x-la-asf", "lsf");
                    f13994a.m15003a("video/x-la-asf", "lsx");
                    f13994a.m15003a("video/x-mng", "mng");
                    f13994a.m15003a("video/x-ms-asf", "asf");
                    f13994a.m15003a("video/x-ms-asf", "asx");
                    f13994a.m15003a("video/x-ms-wm", "wm");
                    f13994a.m15003a("video/x-ms-wmv", "wmv");
                    f13994a.m15003a("video/x-ms-wmx", "wmx");
                    f13994a.m15003a("video/x-ms-wvx", "wvx");
                    f13994a.m15003a("video/x-msvideo", "avi");
                    f13994a.m15003a("video/x-sgi-movie", "movie");
                    f13994a.m15003a("x-conference/x-cooltalk", "ice");
                    f13994a.m15003a("x-epoc/x-sisx-app", "sisx");
                    f13994a.m15003a("video/h263", "3gp");
                    f13994a.m15003a("video/mpeg4", "mp4");
                    f13994a.m15003a("video/divx", "divx");
                }
            }
        }
        return f13994a;
    }

    /* renamed from: b */
    public static C3891n m15004b() {
        if (f13995b == null) {
            synchronized (C3891n.class) {
                if (f13995b == null) {
                    f13995b = new C3891n();
                    f13995b.m15003a("audio/mp4", "mp4");
                    f13995b.m15003a("audio/3gpp", "3gp");
                }
            }
        }
        return f13995b;
    }
}
