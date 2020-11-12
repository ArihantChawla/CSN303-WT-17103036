public class Q2 extends Thread
{
    static int maxNumDiv = 0, num = 0;
    int start;
    public Q2(int start)
    {
        this.start = start;
    }
    public static void main(String[] args)
    {
        Q2 t1 = new Q2(1), t2 = new Q2(10001), t3 = new Q2(20001), t4 = new Q2(30001), t5 = new Q2(40001), t6 = new Q2(50001), t7 = new Q2(60001), t8 = new Q2(70001), t9 = new Q2(80001), t10 = new Q2(90001);
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
            t9.join();
            t10.join();
        }
        catch(Exception e){
            System.out.println("Exception Caught");
        }
        long end = System.currentTimeMillis();
        long timeElapsed = end-start;
        System.out.println(num + " has " + maxNumDiv + " divisors");
        System.out.println("Time elapsed: " + timeElapsed);
    }

    public void run()
    {
        int numDiv=0;
        for(int i=this.start; i<this.start+10000; i++)
        {
            numDiv=0;
            for(int j=1; j<=i; j++)
            {
                if(i%j==0)
                {
                    numDiv+=1;
                }
            }
            if(numDiv>maxNumDiv)
            {
                synchronized(this)
                {
                    maxNumDiv = numDiv;
                    num = i;
                }
            }
        }
    }
}
