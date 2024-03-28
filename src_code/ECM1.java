/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fraud;
import java.util.ArrayList;
import org.apache.commons.math3.ml.distance.EuclideanDistance;
/**
 *
 * @author admin
 */
public class ECM1 
{
    Details dt=new Details();
    ArrayList cent=new ArrayList();
    ArrayList rad=new ArrayList();
    ArrayList cls=new ArrayList();
    double dthr=30000;
    ECM1()
    {
        
    }
    
    public void cluster()
    {
        try
        {
            cent.add(0);
            rad.add(0);
            cls.add(0);
            
            for(int i=1;i<dt.clsData.length;i++)
            {
                double va2[]=dt.clsData[i];
                int flag1=0;
                ArrayList dis=new ArrayList();
                for(int j=0;j<cent.size();j++)
                {
                    int ind=Integer.parseInt(cent.get(j).toString());
                    
                    double ra1=Double.parseDouble(rad.get(j).toString());
                    double va1[]=dt.clsData[ind];
                    EuclideanDistance ed=new EuclideanDistance();
                    double dmin=ed.compute(va1,va2);                    
                    dis.add(dmin);
                    if(dmin<ra1)
                    {
                        String g=cls.get(j).toString();
                        g=g+"#"+i;
                        cls.set(j, g);
                        flag1=1;
                        break;
                    }                    
                }
                //System.out.println("flag1 === "+flag1);
                if(flag1==0)
                {
                    int flag2=0;
                    int cin=0;
                    for(int j=0;j<dis.size();j++)
                    {
                        double ra=Double.parseDouble(rad.get(j).toString());
                        double d1=Double.parseDouble(dis.get(j).toString());
                        double sm=d1+ra;
                        
                        if(sm>dthr)
                        {
                            rad.add(ra);
                            cent.add(i);
                            cls.add(i);
                            flag2=1;
                            cin=j;
                            break;
                        }   
                    }
                    
                    if(flag2==0)
                    {
                        int cin2=0;
                        double min1=Double.MAX_VALUE;
                        for(int j=0;j<dis.size();j++)
                        {
                            double ra=Double.parseDouble(rad.get(j).toString());
                            double d1=Double.parseDouble(dis.get(j).toString());
                            double sm=d1+ra;
                            if(min1>sm)
                            {
                                min1=sm;
                                cin2=j;
                            }                                
                        }
                        double e1=Double.parseDouble(rad.get(cin2).toString());
                        e1=e1/2;
                        rad.set(cin2, e1);
                    }
                }
            }
            
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public int findMinDistance()
    {
        int ind=0;
        try
        {
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return ind;
    }
}
