package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.utils.BaseActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DenLuActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_den_lu);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.denlu_geren_button})
    public void onClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.denlu_geren_button:
                intent=new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra("aa",100);
                intent.putExtra("cc","个人登录");
                startActivity(intent);

                break;

        }

    }



}
