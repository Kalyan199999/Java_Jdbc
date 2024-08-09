package synchrozied;

class Thread_abc extends Thread {
	SyncThread st;
	
	public Thread_abc(SyncThread s) {
		this.st = s;
	}
	
	
	public void run() {
		
		st.table(5);
		
	}
	
}

class Thread_xyz extends Thread {
	SyncThread st2;
	
	Thread_xyz(SyncThread s)
	{
		this.st2 = s;
	}
	
	public void run() {
		
		st2.table(10);
		
	}
}
