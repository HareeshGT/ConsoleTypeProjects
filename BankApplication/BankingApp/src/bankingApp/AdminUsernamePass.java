package bankingApp;

public class AdminUsernamePass {

	private static String user="Admin";
	private static String pass="123";
	
	public static boolean AdminValidation(String user,String pass) {
		if(AdminUsernamePass.user.equals(user) && AdminUsernamePass.pass.equals(pass))
			return true;
		return false;
	}
}