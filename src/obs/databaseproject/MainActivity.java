package obs.databaseproject;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {
	
	 ListView tx;
	 String log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Insert: ", "Inserting .."); 
        DatabaseHandle db = new DatabaseHandle(this);
        db.addContact(new Contact("suresh",9956777));
        db.addContact(new Contact("ravi",897655));
        db.addContact(new Contact("nandha",894532));
        db.addContact(new Contact("karthick",956443443));
        db.addContact(new Contact("kumar",54643843));
        Log.d("Reading: ", "Reading all contacts.."); 
        tx=(ListView)findViewById(R.id.list1);
        
        List<Contact> contacts = db.getContacts(); 
        ArrayList<String> one=new ArrayList<String>();
      /*  for(int i=0;i<contacts.size();i++)
        {
        	one.add(contacts.get(i).getName());
        	//one.add(contacts.get(i).getPhoneNumber());
        }*/
         
        for (Contact cn : contacts) {
            log = cn.getID() +" " +cn.getName() +" "+ cn.getPhoneNumber();
                // Writing Contacts to log
        //Log.d("Name: ", log);
            one.add(log);
        }
        
      
        final ArrayAdapter<String> ListObject = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,one);
        
        tx.setAdapter(ListObject);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
