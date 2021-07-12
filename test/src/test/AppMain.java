package test;

public class AppMain {
	public static void main(String[] args) {

		StudentApp app = StudentApp.getInstance();
		app.main();

		StudentApp app2 = StudentApp.getInstance();
		app2.main();

		System.out.println(app == app2);
	}

}
