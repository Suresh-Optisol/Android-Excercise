package obs.sharedpref;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	   EditText ed1,ed2,ed3;
	   Button b1;
	   public static final String MyPREFERENCES = "MyPrefs" ;
	   public static final String Name = "nameKey";
	  // public static final String Phone = "phoneKey";
	   public static final String Email = "emailKey";
	   SharedPreferences sharedpreferences;
	   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.edit1);
        
        ed3=(EditText)findViewById(R.id.edit3);
        
        b1=(Button)findViewById(R.id.button1);
        
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				    String nam  = ed1.getText().toString();
		            String ema = ed3.getText().toString();
		            sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
		            Editor editor = sharedpreferences.edit();
		            editor.clear();
		            
		            editor.putString(Name, nam);
		             editor.putString(Email, ema);
		            editor.commit();
		            Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();
				
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
