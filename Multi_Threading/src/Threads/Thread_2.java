package Threads;

class MyThread2 implements  Runnable{

    @Override
    public void run() {
        for(int i=1;i<=10;i++)
        {
            System.out.println(i+"-->"+Thread.currentThread().getName());
        }

    }

}

public class Thread_2 {

	public static void main(String[] args) {
		        
		        System.out.println(Thread.currentThread().getName());

		        MyThread2 ti1 = new MyThread2();
		        Thread t1 = new Thread(ti1);
		        t1.start();
		        t1.setName("Kalyan");

		        MyThread2 ti2 = new MyThread2();
		        Thread t2 = new Thread(ti2);
		        t2.start();

		    

	}

}
