package hu.bme.bgyn.hsquiz;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {

	public static void setTestInjector() {
		ShadowLog.stream = System.out;
		HsQuizApplication application = (HsQuizApplication) RuntimeEnvironment.application;
		HsQuizApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
		application.injector = injector;
	}
}
