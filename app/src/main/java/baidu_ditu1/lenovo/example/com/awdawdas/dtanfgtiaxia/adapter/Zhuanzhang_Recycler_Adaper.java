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
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/3/26.
 */

public class Zhuanzhang_Recycler_Adaper extends RecyclerView.Adapter<Zhuanzhang_Recycler_Adaper.MyViewHolder> {


    List<Baseclass> list=new ArrayList<>();

    private Zhuanzhang_Recycler_Adaper.OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void addlistDeve(List<Baseclass> list){
        this.list = list;
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int position);
    }

    public Zhuanzhang_Recycler_Adaper(List<Baseclass> list) {
        this.list = list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new Zhuanzhang_Recycler_Adaper.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.zhuangzhang_jilu_danhang_demo,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.textname.setText(list.get(position).getName());
        holder.shijian.setText(list.get(position).getShjian());

        if (mOnItemClickListener!=null) {
            holder.zhuangzhangJILU.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 可以直接在这里完成，不方便在这里写的话
                    // 接口回调的方式
                    mOnItemClickListener.onItemClick(v,position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //这里的监听是为了接收外面传递点击事件的数据
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }
    //自定义的Item响应事件需要接收OnRecyclerViewItemClickListener接口的函数
    public void setOnItemClickListener(Zhuanzhang_Recycler_Adaper.OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }



    class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.zhuanzhang_jilu_image)ImageView imageView;
        @BindView(R.id.zhuanzhang_jilu_text_name)TextView textname;
        @BindView(R.id.zhuanzhang_jilu_text_shijian)TextView shijian;
        @BindView(R.id.zhuanzhuang_jilu_demo)View zhuangzhangJILU;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
