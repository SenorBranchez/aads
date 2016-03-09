/*
 * AADS - bsp01
 * @author Wolfgang Kremser
 * @author Gregor Bankhamer
 * @author Kevin Kain
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MergeLists {

	public static void main(String[] args) throws Exception {
				
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    Scanner scan = null;
	    
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		
    	scan = new Scanner(in.readLine());
		
		while(scan.hasNextInt()) {
			l1.insert(scan.nextInt());
		}
		scan.close();
		
    	scan = new Scanner(in.readLine());
		
		while(scan.hasNextInt()) {
			l2.insert(scan.nextInt());
		}
		scan.close();
		in.close();
		
		System.out.println(l1.mergeWith(l2));
	}	
}
