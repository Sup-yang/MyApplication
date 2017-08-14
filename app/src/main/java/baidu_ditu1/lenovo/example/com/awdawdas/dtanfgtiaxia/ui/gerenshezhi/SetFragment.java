package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.gerenshezhi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.DenLuActivity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.Main2Activity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.MainActivity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;

/**
 *
 * 为设置界面添加数据
 * */

public class SetFragment extends Fragment implements AdapterView.OnItemClickListener{
    private List<String> list;
    private SetListAdapter adapter;
    private ListView listView ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_set,container,false);



        listView= (ListView) view.findViewById(R.id.listView_set);
        
        list=new ArrayList<>();

        //准备字符串数组，添加到list集合中
        String[] strings={"aaa","推荐管理","会员认证","我的收藏","我的推广","联盟商家","用户反馈","帮助说明","关于我们",""};
        for (int i = 0; i < strings.length; i++) {

            list.add(strings[i]);

        }
        //适配器
        adapter=new SetListAdapter(view.getContext());
        adapter.add(list);//给适配器添加资源
        listView.setAdapter(adapter);//填充listview

        listView.setOnItemClickListener(this);//listview的单项监听
        return view;
    }

    //listview 单项点击事件处理
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent;
        if (MainActivity.isdenlu) {
            switch (position) {
                case 0:
                    intent = new Intent(view.getContext(), Main2Activity.class);
                    intent.putExtra("aa", 1);
                    intent.putExtra("cc", "设置");
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(view.getContext(), Main2Activity.class);
                    intent.putExtra("cc", "推荐管理");
                    startActivity(intent);
                    break;
                case 2:
                    //跳转会员认证中心，
                    intent = new Intent(getContext(), Main2Activity.class);
                    intent.putExtra("aa", 339);
                    intent.putExtra("cc", "认证中心");
                    startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(view.getContext(), Main2Activity.class);
                    intent.putExtra("cc", "我的收藏");
                    startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(view.getContext(), Main2Activity.class);
                    intent.putExtra("cc", "我的推广");
                    startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(view.getContext(), Main2Activity.class);
                    intent.putExtra("cc", "联盟商家");
                    startActivity(intent);
                    break;
                case 6:
                    intent = new Intent(view.getContext(), Main2Activity.class);
                    intent.putExtra("aa", 7);
                    intent.putExtra("cc", "用户反馈");
                    startActivity(intent);
                    break;
                case 7:
                    intent = new Intent(view.getContext(), Main2Activity.class);
                    intent.putExtra("cc", "帮助说明");
                    startActivity(intent);
                    break;
                case 8:
                    intent = new Intent(view.getContext(), Main2Activity.class);
                    intent.putExtra("cc", "关于我们");
                    startActivity(intent);
                    break;
                default:
                    intent = new Intent(view.getContext(), Main2Activity.class);
                    startActivity(intent);

                    break;

            }
        }else {
            //登录界面
            intent = new Intent(getContext(), DenLuActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }




}
