package classloader;
import java.lang.reflect.Method;

public class ClassLoaderTest {
	  public static void main(String args[]) throws Exception {
	        String progClass = "SingletonClass";
	        CustomClassLoader ccl = new CustomClassLoader(CustomClassLoader.class.getClassLoader());
	        Class<SingletonClass> clas = ccl.loadClass(progClass);
	        Method printCL = clas.getDeclaredMethod("getInstance");
	        printCL.invoke(null);
	        
	        CustomClassLoader2 ccl2 = new CustomClassLoader2(CustomClassLoader.class.getClassLoader());
	        Class<SingletonClass> clas2 = ccl.loadClass(progClass);
	        Method printCL2 = clas2.getDeclaredMethod("getInstance");
	        printCL.invoke(null);
	        
	        
	       /* clas = ccl.loadClass(progClass);
	        printCL = clas.getDeclaredMethod("getInstance");
	        printCL.invoke(null);*/
	        
	        
	       /* CustomClassLoader ccl1 = new CustomClassLoader(CustomClassLoader.class.getClassLoader());
	        Class<SingletonClass> clas1 = ccl1.loadClass(progClass);
	        Method printCL1 = clas1.getDeclaredMethod("getInstance");
	        printCL1.invoke(null);*/
	    }
}
