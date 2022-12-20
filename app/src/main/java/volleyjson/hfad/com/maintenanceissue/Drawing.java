package volleyjson.hfad.com.maintenanceissue;

import android.app.Activity;
import android.os.Bundle;

import java.util.Random;

public class Drawing extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int test[] ={R.drawable.xaxis, R.drawable.xaxis2, R.drawable.atcmagazine, R.drawable.tableassembly};

        Random random = new Random();
       int drawbletest = random.nextInt(test.length);

        TouchImageView img = new TouchImageView(this);
        img.setImageResource(test[drawbletest]);
        img.setMaxZoom(4f);
        setContentView(img);
    }
}
