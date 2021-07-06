package techmarket.uno.trafficlight01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout bulb1;
    private LinearLayout bulb2;
    private LinearLayout bulb3;
    private boolean start_stop = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bulb1 = findViewById(R.id.bulb1);
        bulb2 = findViewById(R.id.bulb2);
        bulb3 = findViewById(R.id.bulb3);
        //start_stop = true;
    }

    public void onClickStart(View view) {
        new Thread(new Runnable() { //важно очень!!!!!!!!!!!!

            @Override //данная ветка будет работать независимо от основной ветки
            public void run()
            {
                while (start_stop)
                {
                    try
                    {
                        Thread.sleep(3000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        start_stop = false;
    }
}