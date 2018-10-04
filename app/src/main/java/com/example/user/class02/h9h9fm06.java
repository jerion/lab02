package com.example.user.class02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class h9h9fm06 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h9h9fm06);

        player = (EditText) findViewById(R.id.player);
        please = (TextView) findViewById(R.id.please);
        start = (Button) findViewById(R.id.start);
        pss = (RadioGroup) findViewById(R.id.pss);
        pap = (RadioButton) findViewById(R.id.pap);
        sis = (RadioButton) findViewById(R.id.sis);
        sto = (RadioButton) findViewById(R.id.sto);
        playerID = (TextView) findViewById(R.id.playerID);
        WinID = (TextView) findViewById(R.id.WinID);
        fm06ID = (TextView) findViewById(R.id.fm06ID);
        comID = (TextView) findViewById(R.id.comID);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player.getText().toString().equals(""))
                    please.setText("打玩家名子：OK?");
                else if(playerset==10)
                    please.setText("按按鈕出拳喔。");
                else
                {
                    playerID.setText(player.getText());
                    fm06ID.setText(fm06CH[playerset]);
                    int comset = (int) (Math.random()*3);
                    comID.setText(fm06CH[comset]);
                    if (((playerset==2)&&(comset==0))||
                            ((playerset==1)&&(comset==2))||
                            ((playerset==0)&&(comset==1)))
                    {
                        WinID.setText("電腦");
                        please.setText("你死掉了");
                    }

                    else if(playerset==comset)
                    {
                        WinID.setText("平手");
                        please.setText("勢均力敵");
                    }

                    else
                    {
                        WinID.setText(player.getText());
                        please.setText("你贏了，ㄏㄏ");
                    }
                }
                }

        });//開始按鈕

        pss.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup pss, int i) {
                switch (pss.getCheckedRadioButtonId()){
                    case R.id.pap:
                        playerset = 0;
                        break;
                    case R.id.sis:
                        playerset = 1;
                        break;
                    case R.id.sto:
                        playerset = 2;
                        break;
                }
            }
        });//剪石布控制
    }

    EditText player;
    TextView please;
    RadioButton pap;
    RadioButton sis;
    RadioButton sto;
    RadioGroup pss;
    Button start;
    TextView playerID;
    TextView WinID;
    TextView fm06ID;
    TextView comID;

    int playerset = 10;
    String[] fm06CH = {"布","剪刀","石頭"};


}
