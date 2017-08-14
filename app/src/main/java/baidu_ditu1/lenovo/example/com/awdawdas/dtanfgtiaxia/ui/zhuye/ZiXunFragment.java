package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.zhuye;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.adapter.ZiXunAdapter;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.base.Baseclass;


public class ZiXunFragment extends Fragment {
    private RecyclerView recyclerView;
    ZiXunAdapter adapter=new ZiXunAdapter();;
    List<Baseclass> list;
    Baseclass ziXun;
     View view;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_zi_xun, container, false);

        recyclerView= (RecyclerView) view.findViewById(R.id.recycleView_zixun);


        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);
        list=new ArrayList<>();

        ziXun=new Baseclass(R.drawable.ic_launcher,"吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱中",getDate());

        initdave();


        return view;
    }

    /**
     * 添加数据
     */
    private void initdave() {
        for (int i = 0; i < 50; i++) {
            list.add(ziXun);
        }
        adapter.addList(list);
    }

    /**
     * 获取当前的系统时间
     * @return
     */
    private   String  getDate(){
        java.text.SimpleDateFormat sdf  =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date  d = new Date();
        return   sdf.format(d);
    }

}
