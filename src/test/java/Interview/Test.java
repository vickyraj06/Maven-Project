package Interview;

import java.util.Iterator;

import org.apache.poi.common.usermodel.Hyperlink;
import org.openqa.selenium.interactions.Actions;

public class Test {

	public static void main(String[] args) {
		
		String name="vignesh";
		
		String rev="";
		
		int count =0;
		
		int len=name.length();
		
		for (int i = len-1; i > 0; i--) {
			
			rev= rev+name.charAt(i);
			
			count=name.length();
			count =count++;
				
		}
		
		
		System.out.println(rev);
		
		System.out.println(count);
			
		
		
		
		
		
	}	
		
	}
	
	

