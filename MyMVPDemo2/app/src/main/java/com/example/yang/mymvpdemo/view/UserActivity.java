package com.example.yang.mymvpdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yang.mymvpdemo.R;
import com.example.yang.mymvpdemo.presenter.UserPresenter;

public class UserActivity extends AppCompatActivity implements View.OnClickListener,IUserView {

    private EditText id,first,last;
    private Button save,load;
    private UserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initID();
        save.setOnClickListener(this);
        load.setOnClickListener(this);
        presenter=new UserPresenter(this);

    }

    private void initID() {
        id= (EditText) findViewById(R.id.id);
        first= (EditText) findViewById(R.id.first);
        last= (EditText) findViewById(R.id.last);
        save= (Button) findViewById(R.id.save);
        load= (Button) findViewById(R.id.load);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.save:
                presenter.saveUser(getID(),getFirstName(),getLastName());
                break;
            case R.id.load:
                presenter.loadUser(getID());
                break;
            default:

                break;
        }
    }

    @Override
    public int getID() {
        return Integer.parseInt(id.getText().toString());
    }

    @Override
    public String getFirstName() {
        return first.getText().toString();
    }

    @Override
    public String getLastName() {
        return last.getText().toString();
    }

    @Override
    public void setFirstName(String firstName) {
        first.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        last.setText(lastName);
    }


}
