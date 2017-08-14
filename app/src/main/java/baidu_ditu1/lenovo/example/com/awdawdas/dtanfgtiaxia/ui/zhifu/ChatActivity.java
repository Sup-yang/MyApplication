package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.zhifu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.adapter.ChatMsgViewAdapter;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.base.ChatMsg;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.toolbar.Toolbar_putong;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatActivity extends AppCompatActivity {
    @BindView(R.id.chat_list)
    ListView talkView;
    @BindView(R.id.chat_button)
     Button messageButton;
      ArrayList<ChatMsg>  list = new ArrayList<ChatMsg>();
    public static int JINE=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);

        Toolbar_putong toolbar_putong= (Toolbar_putong) findViewById(R.id.toolbar_title_chat);
        toolbar_putong.setTitle("交易明细");
        toolbar_putong.hiderightView();
        toolbar_putong.setLeftButtonOnClickLinster(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChatActivity.this,ZhiFuActivity.class);
                startActivity(intent);
            }
        }) ;


        init();

    }

    private void init(){
        String  date  =getDate();

        String  msgText  =JINE+"个";
        int RIdA = R.layout.inflate_say_me;
        ChatMsg   newMsg = new ChatMsg(msgText,date,RIdA);
        list.add(newMsg);

        String othername=JINE+"个";
        int RIdB = R.layout.inflate_say_you;
        ChatMsg   backMsg = new ChatMsg(othername,date,RIdB);
        list.add(backMsg);

        talkView.setAdapter(new ChatMsgViewAdapter(ChatActivity.this,list));

    }


    @Override
    protected void onRestart() {
        init();
        super.onRestart();
    }

    /**
     * 获取当前的系统时间
     * @return
     */
    private   String  getDate(){
        SimpleDateFormat  sdf  =new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date  d = new Date();
        return   sdf.format(d);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
