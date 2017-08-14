package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.base.Baseclass;

/**
 * Created by yang on 2017/4/9.
 */

public class ZiXunAdapter extends RecyclerView.Adapter<ZiXunAdapter.ZiXunViewHolder>{

    List<Baseclass> list=new ArrayList<>();


    public void addList(List<Baseclass> data){

        list.clear();
        list.addAll(data);
        notifyDataSetChanged();

    }
    //创建视图
    @Override
    public ZiXunViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.iten_zixun,parent,false);

        ZiXunViewHolder viewHolder=new ZiXunViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ZiXunViewHolder holder, int position) {

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.textView_content.setText(list.get(position).getName());
        holder.textView_time.setText(list.get(position).getShjian());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ZiXunViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView_content,textView_time;

        public ZiXunViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.iv_zixun);
            textView_content= (TextView) itemView.findViewById(R.id.tv_zixun_list);
            textView_time= (TextView) itemView.findViewById(R.id.tv_zixun_time);


        }
    }

}
