package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.base.Baseclass;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/3/26.
 */

public class Main3_recycler_adaper extends RecyclerView.Adapter<Main3_recycler_adaper.MyViewholder> {

    List<Baseclass> list=new ArrayList<>();

    public Main3_recycler_adaper(List<Baseclass> list) {
        this.list = list;
    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.yenhangka_danhang_demo,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, final int position) {
        holder.textViews[0].setText(list.get(position).getYenhang_yenhang());
        holder.textViews[1].setText(list.get(position).getYenhang_weihao());
        holder.textViews[2].setText(list.get(position).getYenhang_shenhe());

        if (mOnItemClickListener!=null) {
            holder.yenhangka_danhang_demo.setOnClickListener(new View.OnClickListener() {
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

    class MyViewholder extends RecyclerView.ViewHolder{

        @BindViews({R.id.yenhangka_yenhang,R.id.yenhangka_weishu,R.id.yenhangka_shenhe})
        TextView[] textViews;
        @BindView(R.id.yenhangka_danhang_demo)View yenhangka_danhang_demo;
        public MyViewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


    //这里的监听是为了接收外面传递点击事件的数据
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }
    //自定义的Item响应事件需要接收OnRecyclerViewItemClickListener接口的函数
    public void setOnItemClickListener(Main3_recycler_adaper.OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    private Main3_recycler_adaper.OnRecyclerViewItemClickListener mOnItemClickListener = null;



    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int position);
    }

}
