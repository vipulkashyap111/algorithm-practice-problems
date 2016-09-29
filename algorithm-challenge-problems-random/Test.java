package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
	int[][] serverFarm(int[] jobs, int servers) {
	    int n = jobs.length;
	    Jobs[] job = new Jobs[n];
	    JobComparator jc = new JobComparator();
	    PriorityQueue<Jobs> j = new PriorityQueue<Jobs>(n,jc);
	    for(int i=0;i<n;i++){
	        job[i] = new Jobs(i,jobs[i]);
	        j.offer(job[i]);
	    }
	        
	    Server[] s = new Server[servers];
	    ServerComparator comparator = new ServerComparator();
	    PriorityQueue<Server> pq = new PriorityQueue<Server>(servers,comparator);
	    for(int i=0;i<servers;i++){
	        s[i] = new Server(i);
	        pq.offer(s[i]);
	    }
	    
	    Jobs currJob;
	    Server next;
	    while(!j.isEmpty()){
	        currJob = j.poll();
	        next = pq.poll();
	        next.setCapacity(next.capacity+currJob.processingTime);
	        next.jobs.add(currJob.index);
	        pq.add(next);
	    }
	    
	    int[][] res = new int[servers][];
	    while(!pq.isEmpty()){
	        next = pq.poll();
	        n = next.jobs.size();
	        int[] temp = new int[n];
	        for(int i = 0; i<n ; i++)
	            temp[i] = next.jobs.get(i);
	        res[next.serverNo] = temp;
	    }
	    return res;
	}
	class Server{
	    int serverNo;
	    int capacity;
	    ArrayList<Integer> jobs;
	    
	    Server(int i){
	        serverNo = i;
	        capacity = 0;
	        jobs = new ArrayList<Integer>();
	    }
	    
	    public void setCapacity(int c){
	        this.capacity = c;
	    }  
	}

	class ServerComparator implements Comparator<Server>{
	    public int compare(Server s1, Server s2){
	        int val = s1.capacity - s2.capacity;
	        if(val!=0)
	            return val;
	        return s1.serverNo - s2.serverNo;
	    }
	}

	class Jobs{
	    int index;
	    int processingTime;
	    
	    Jobs(int i, int p){
	        index = i;
	        processingTime = p;
	    }
	}

	class JobComparator implements Comparator<Jobs>{
	    public int compare(Jobs j1, Jobs j2){
	        return j2.processingTime - j1.processingTime;
	    }
	}
	
	public static void main(String[] args){
		Test lpt = new Test();
		int[] jobs = {15,30,15,5,10};
		int[][] res = lpt.serverFarm(jobs, 3);
		System.out.println(res);
	}
	
	
}
