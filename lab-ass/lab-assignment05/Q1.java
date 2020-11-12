public class Q1 extends Thread
{
    public static void main(String[] args)
    {
        Q1 t = new Q1();
        t.start();
    }

    public void run()
    {
        for(int i=1; i<101; i++){
            System.out.println(i);
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){
                System.out.println("Exception Caught");
            }
        }
    }
}
