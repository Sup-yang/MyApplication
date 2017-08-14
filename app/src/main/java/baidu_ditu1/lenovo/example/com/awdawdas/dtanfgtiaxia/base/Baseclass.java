package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.base;

/**
 * Created by lenovo on 2017/3/24.
 */

public class Baseclass {
    private int image;
    private String name;
    private String shjian;
    private String yenhang_yenhang;
    private String yenhang_weihao;
    private String yenhang_shenhe;

    public Baseclass(int image, String name, String shjian) {
        this.image = image;
        this.name = name;
        this.shjian = shjian;
    }
    //工单管理
    public Baseclass(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public Baseclass(String yenhang_yenhang, String yenhang_weihao, String yenhang_shenhe) {
        this.yenhang_yenhang = yenhang_yenhang;
        this.yenhang_weihao = yenhang_weihao;
        this.yenhang_shenhe = yenhang_shenhe;
    }

    public String getYenhang_yenhang() {
        return yenhang_yenhang;
    }
    public void setYenhang_yenhang(String yenhang_yenhang) {
        this.yenhang_yenhang = yenhang_yenhang;
    }

    public String getYenhang_weihao() {
        return yenhang_weihao;
    }

    public void setYenhang_weihao(String yenhang_weihao) {
        this.yenhang_weihao = yenhang_weihao;
    }

    public String getYenhang_shenhe() {
        return yenhang_shenhe;
    }

    public void setYenhang_shenhe(String yenhang_shenhe) {
        this.yenhang_shenhe = yenhang_shenhe;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShjian() {
        return shjian;
    }

    public void setShjian(String shjian) {
        this.shjian = shjian;
    }
}
