package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.base;

/**
 * Created by lenovo on 2017/4/9.
 */
public class ChatMsg {
    private  String  name;
    private  String  date;
    private  String text;
    private  int layoutID;
    public ChatMsg(String  text,String date,int id) {
        this.date = date;
        this.text =text;
        this.layoutID = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public int getLayoutID() {
        return layoutID;
    }
    public void setLayoutID(int layoutID) {
        this.layoutID = layoutID;
    }

}
