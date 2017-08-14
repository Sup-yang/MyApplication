package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.zhidao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;

/**
 * Created by yang on 2017/3/25.
 * 官方公告界面的数据适配器
 *
 *
 */

public class GuanFangListAdapter extends BaseAdapter {
    List<String> list=new ArrayList<>();//字符串集合添加假数据
    LayoutInflater inflater;//布局解析器。加载器

    //添加集合的方法
    public void addList(List<String> list){
        this.list=list;

    }

    //构造方法，用于初始化布局加载器，
    public GuanFangListAdapter(Context context) {
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
 //数据适配
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder viewHolder;

        if (convertView==null){

           convertView= inflater.inflate(R.layout.guanfanglistview_item,null);
            viewHolder=new MyViewHolder();

            viewHolder.tv_content= (TextView) convertView.findViewById(R.id.guanfangitemtextview);
            viewHolder.tv_num= (TextView) convertView.findViewById(R.id.guanfangNum);
            viewHolder.tv_time= (TextView) convertView.findViewById(R.id.guanfangTime);

            convertView.setTag(viewHolder);

        }else {
            viewHolder= (MyViewHolder) convertView.getTag();

        }

        viewHolder.tv_content.setText(list.get(position));
        viewHolder.tv_num.setText(list.get(position));
        viewHolder.tv_time.setText(list.get(position));

        return convertView;
    }

    class MyViewHolder{
        TextView tv_content,tv_num,tv_time;


    }
}
