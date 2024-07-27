package sweetsystem;

import java.util.ArrayList;

public class MyApplication {

	
	
	
	public boolean is_logged_in;
	private String welcome_msg;
	
	
	static ArrayList<User>List_user=new ArrayList<User>();
	public static ArrayList<User> getList_user() {
		return List_user;
	}
    public static void setList_user(ArrayList<User> list_user) {
		List_user = list_user;
	}

 


	public MyApplication() {
		List_user.add(new User("shahd","822003"));
		List_user.add(new User("nuha","132003"));
	}
	
	

}
