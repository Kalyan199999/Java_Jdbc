package synchrozied;

public class SyncThread {
	
	public synchronized void table(int n)
	{
		for(int i=1;i<=10;i++)
		{

			System.out.println(n +" * "+i +" = "+(i*n));
		}
		System.err.println();
	}
	
}
