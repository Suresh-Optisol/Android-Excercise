package obs.databaseproject;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandle extends SQLiteOpenHelper{

	public static final int DATABASE_VERSION=1;
	public static final String DATABASE_NAME="ContactsManager";
	public static final String TABLE_NAME="Contacts";
	public static final String KEY_ID="Id";
	public static final String KEY_NAME="Name";
	public static final String KEY_PHONE="Phone";
	public DatabaseHandle(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CONTACTS_TABLE="CREATE TABLE " + TABLE_NAME + "("  
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"  
                + KEY_PHONE + " TEXT" + ")";  
		db.execSQL(CONTACTS_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
		onCreate(db);
		
	}
	
	
	void addContact(Contact con)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues val=new ContentValues();
		val.put(KEY_NAME, con.getName());
		val.put(KEY_PHONE, con.getPhoneNumber());
		db.insert(TABLE_NAME, null, val);
        db.close(); 
	}
	
	
	public List<Contact> getContacts()
	{
		List<Contact> lst=new ArrayList<Contact>();
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cur=db.rawQuery("select * from "+TABLE_NAME,null);
		if(cur.moveToFirst())
		{
			do {
                Contact contact = new Contact();
                contact.setID(Integer.parseInt(cur.getString(0)));
                contact.setName(cur.getString(1));
                contact.setPhoneNumber(cur.getInt(2));
                // Adding contact to list
                lst.add(contact);
            } while (cur.moveToNext());
		}
		
		return lst;
		
	}
	
	

}
