package obs.databaseproject;


	public class Contact {
	     
	    //private variables
	    int id;
	    String name;
	    int phone_number;
	     
	    // Empty constructor
	    public Contact(){
	         
	    }
	    // constructor
	    public Contact(int id, String name, int phone_number){
	        this.id = id;
	        this.name = name;
	        this.phone_number = phone_number;
	    }
	     
	    // constructor
	    public Contact(String name, int i){
	        this.name = name;
	        this.phone_number = i;
	    }
	    // getting ID
	    public int getID(){
	        return this.id;
	    }
	     
	    // setting id
	    public void setID(int id){
	        this.id = id;
	    }
	     
	    // getting name
	    public String getName(){
	        return this.name;
	    }
	     
	    // setting name
	    public void setName(String name){
	        this.name = name;
	    }
	     
	    // getting phone number
	    public int getPhoneNumber(){
	        return this.phone_number;
	    }
	     
	    // setting phone number
	    public void setPhoneNumber(int string){
	        this.phone_number = string;
	    }
	}


