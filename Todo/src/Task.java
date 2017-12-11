
public class Task implements Comparable<Task>{
	
		public int priority;
	    public String msg;
	    
	    
	    public Task(int priority, String msg)
	    {
	    	this.priority=priority;
	    	this.msg=msg;
	    	
	    }


		public int compareTo(Task ex) {
			int a=this.priority;
			int b=ex.priority;
			if(a<b) return -1;
			if (a>b) return 1;
			return 0;
		}
}
