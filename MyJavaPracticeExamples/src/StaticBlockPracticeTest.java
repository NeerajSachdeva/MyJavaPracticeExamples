

public class StaticBlockPracticeTest {

	String str;
	
	{
		String str = "Neeraj";
		str= "Sachdeva";
	}
	
	public static void main(String[] args) {
		String str;
		str = "ok";
		new StaticBlockPracticeTest().callMe();
	}

	private void callMe() {
		System.out.println(str);
	}
}
