package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.workordermanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.base.Baseclass;

/**
 * Created by yang on 2017/3/26.
 */

public class WorkerAdapter extends BaseAdapter {
    List<Baseclass> list;

    Context context;

    public void addData(List<Baseclass> list){
        this.list=list;
    }

    public WorkerAdapter(Context context) {
        this.context = context;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        WorkerViewHolder holder;
        if (convertView==null){
            holder=new WorkerViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.set_list_item,null);

            holder.textView= (TextView) convertView.findViewById(R.id.tv_set_list_item);
            holder.imageView= (ImageView) convertView.findViewById(R.id.image_set_list_item);

            convertView.setTag(holder);
        }else {

            holder= (WorkerViewHolder) convertView.getTag();
        }

        holder.textView.setText(list.get(position).getName());
        holder.imageView.setImageResource(list.get(position).getImage());
        return convertView;
    }


    class  WorkerViewHolder{
        TextView textView;
        ImageView imageView;


    }
}
