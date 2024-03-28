/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fraud;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author admin
 */
public class Test1 
{
    public static void main(String ar[])
    {
        try
        {
            ArrayList at1=new ArrayList();
            at1.add("Heart");
            at1.add("Arthritis");
            at1.add("Diabetes");
            at1.add("Cancer");
            at1.add("Parkinson");
            
            ArrayList at2=new ArrayList();
            at2.add("legitimate");
            at2.add("fraudulent");
            
            Random rn=new Random();
            /*for(int i=0;i<150;i++)
            {
                int sk1=rn.nextInt(at1.size());
                String s1=at1.get(sk1).toString();
             
                int sk2=rn.nextInt(at2.size());
                String s2=at2.get(sk2).toString();
                System.out.println(s1+"\t"+s2);
            }
                    */
            
            for(int i=0;i<150;i++)
            {
                int sk1=rn.nextInt(35000);
                
                int sk2=rn.nextInt(15000);
                
                int ks1=sk1+25000;
                int ks2=ks1-sk2;
                System.out.println(ks1+"\t"+ks2);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
