
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Todo {

	private final static String todoPath = "tasks";
	private static ArrayList<Task> t = new ArrayList<Task>();
	private static int numoflist=0;
	
	public static void load() throws FileNotFoundException
	{
		Scanner sc= new Scanner(new File("tasks"));
		int p;
		String m;
		
		while (sc.hasNext()) {
	           p = Integer.parseInt(sc.next());
	           m =sc.next();
	          
	          Task task= new Task(p,m);
	          t.add(task); 
	          numoflist++;
	           
	      }
		sc.close();
	}
	
	public static void printTasks()
	{
		for(Task var: t)
		System.out.println(var.priority + " " + var.msg);
	}
	
	public static void printTasksr()
	{
		for(int i=numoflist-1; i>=0; i--)
		{
			System.out.println(t.get(i).priority + " " + t.get(i).msg);
		}	
	}
	
	public static void addtask(int priority, String msg) throws IOException {
		BufferedWriter br = new BufferedWriter(new FileWriter(todoPath, true));
		br.append(priority + "\t" + msg);
		br.newLine();
		br.close();
		numoflist++;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		
		try {
			load();
		} catch (FileNotFoundException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		
		switch (args[0])
		{
		case "-a":
			addtask(Integer.parseInt(args[1]), args[2]);
			break;
			
		case "-l":
			t.sort(null);
			printTasks();
			break;
			
		case "-r":
			t.sort(null);
			printTasksr();
			break;
			
		case "-d":
			break;
			
		default:
			printTasks();
			break;
		}
	}
}
