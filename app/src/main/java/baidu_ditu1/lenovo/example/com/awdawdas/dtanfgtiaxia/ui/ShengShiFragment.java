package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.DenLuActivity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.Main2Activity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.MainActivity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.workordermanager.WorkerOrderManagerActivity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.zhidao.KnowActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页
 *
 * "转企业","购买库存积分","认证中心","会员升级","工单管理","积分发放","资讯","充值提现"
 * 主页的GridView
 */
public class ShengShiFragment extends Fragment implements AdapterView.OnItemClickListener{

    private GridView gridView;
    private List<Map<String,Object>> data_list;
    private SimpleAdapter adapter;
    private int [] icon={ R.drawable.sy1, R.drawable.sy2, R.drawable.sy3, R.drawable.sy4, R.drawable.sy5, R.drawable.sy6, R.drawable.sy7, R.drawable.sy8};
    private String[] iconName={"转企业","购买库存积分","认证中心","会员升级","工单管理","积分发放","资讯","充值提现"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sheng_shi,container,false);
        ButterKnife.bind(this,view);
        gridView= (GridView) view.findViewById(R.id.grideView);

        //新建list
        data_list=new ArrayList<Map<String,Object>>();
        //获取数据

        getData();

        //数据处理
        String[] from={"image","text"};
        int[] to ={R.id.image_item,R.id.text_item};
        adapter=new SimpleAdapter(view.getContext(),data_list,R.layout.grid_item,from,to);

        //配置适配器
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
        return view;
    }

    //获取数据
    private List<Map<String,Object>> getData() {

        //将数据循环通过键值对的形式添加到map集合
        //然后再把Map集合添加到list集合
        for (int i = 0; i < icon.length; i++) {
            Map<String,Object> map=new HashMap<>();

            map.put("image",icon[i]);
            map.put("text",iconName[i]);

            data_list.add(map);
        }
        return  data_list;
    }



    /**
     *  gridView 下面的五个按钮
     * @param button
     */
    //button 的点击监听事件
    @OnClick ({R.id.btn_know,R.id.btn_college,R.id.btn_shop,R.id.btn_choujiang,R.id.btn_jiandao})
    public void addFragment(View button){
        Intent intent;
        switch (button.getId()){

            //跳转到知道界面
            case R.id.btn_know:
                intent=new Intent(getContext(), KnowActivity.class);
                startActivity(intent);
                break;


            //跳转到抽奖界面
            case R.id.btn_choujiang:
                if (MainActivity.isdenlu) {
                    intent = new Intent(getContext(), Main2Activity.class);
                    startActivity(intent);
                }else {
                    //登录界面
                    intent = new Intent(getContext(), DenLuActivity.class);
                    startActivity(intent);
                }
                break;
            //跳转到签到界面
            case R.id.btn_jiandao:

                if (MainActivity.isdenlu) {
                    intent=new Intent(getContext(), Main2Activity.class);
                    startActivity(intent);
                }else {
                    //登录界面
                    intent = new Intent(getContext(), DenLuActivity.class);
                    startActivity(intent);
                }
                break;
            //跳转到界学院面
            case R.id.btn_college:
                intent=new Intent(getContext(), Main2Activity.class);
                startActivity(intent);
                break;
            //跳转到商城界面
            case R.id.btn_shop:
                intent=new Intent(getContext(), Main2Activity.class);
                startActivity(intent);
                break;
        }


    }

    //gridview 的单项点击事件
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent;
        if (MainActivity.isdenlu){
            switch (position) {
                case 0:
                    //个人转企业
                    intent = new Intent(getContext(), Main2Activity.class);
                    intent.putExtra("aa", 337);
                    intent.putExtra("cc", "个人转企业");
                    startActivity(intent);
                    break;
                case 1:
                    //购买库存积分
                    intent = new Intent(getContext(), Main2Activity.class);
                    intent.putExtra("cc", "库存积分");
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
                    //会员升级
                    intent = new Intent(getContext(), Main2Activity.class);
                    intent.putExtra("aa", 283);
                    intent.putExtra("cc", "会员升级");
                    startActivity(intent);
                    break;
                case 4:

                    //跳转到工单管理界面
                    intent = new Intent(getContext(), WorkerOrderManagerActivity.class);
                    intent.putExtra("name", "工单管理");
                    startActivity(intent);
                    break;
                case 5:
                    //积分发放
                    intent = new Intent(getContext(), Main2Activity.class);
                    startActivity(intent);
                    break;
                case 6:
                    //资讯
                    intent = new Intent(getContext(), Main2Activity.class);
                    intent.putExtra("aa", 286);
                    intent.putExtra("cc", "资讯");
                    startActivity(intent);
                    break;
                case 7:
                    //账户余额
                    intent = new Intent(getContext(), Main2Activity.class);
                    intent.putExtra("aa", 287);
                    intent.putExtra("cc", "账户余额");
                    startActivity(intent);
                    break;
            }

        }else {
            switch (position){
                case 6:
                    //资讯
                    intent = new Intent(getContext(), Main2Activity.class);
                    startActivity(intent);
                    break;
                default:
                    //登录界面
                    intent = new Intent(getContext(), DenLuActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}
