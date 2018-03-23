// for using filereader and bufferreader classes
import java.io.*;
class Binning {
    int j;
    public static void main(String args[])
    {
        try{
            //redaing data from file
            BufferedReader br = new BufferedReader(new FileReader("F:/Binnig/bndata.txt"));
            String s="";
            int i = 0;
            double a [] = new double [9];
            while((s=br.readLine())!=null)
            {
                System.out.print(s+" ");
                a[i]= Double.parseDouble(s);
                i++;
            }
            double a1[] = new double [3];
            double a2[] = new double [3];
            double a3[] = new double [3];
            double b[] = new double [9];
            double c[] = new double [9];
            int j;
            //dividing data to equal sized bins or buckets
            for (j=0;j<3;j++)
            {
                a1[j]=a[j];
                a2[j]=a[j+3];
                a3[j]=a[j+6];
            }
            // bining by mean 
            double m1=0, m2=0, m3=0;
            // calculating median of each bucket
            for(j=0;j<a1.length;j++)
            {
               m1 += a1[j];
               m2 += a2[j];
               m3 += a3[j];
            }
            m1 = Math.round(m1/a1.length);
            m2 = Math.round(m2/a2.length);
            m3 = Math.round(m3/a3.length);
            
            // bining by median
            int i1,i2,i3;
            //calculating mean of each bucket
            i1 = a1.length/2;
            i2 = a2.length/2;
            i3 = a3.length/2;
            
            //bining by boundaries
            double l1,l2,l3,b1,b2,b3,t1,t2;
            //calculating boundary values for each bucket
            l1 = a1[0];
            b1 = a1[a1.length-1];
            l2 = a2[0];
            b2 = a2[a2.length-1];
            l3 = a3[0];
            b3 = a3[a3.length-1];
            
            System.out.println("\nMean binned array\t\t Median binned array\t\t Boundary binned array");
            for (j=0;j<a.length;j++)
            {
                if (j<3)
                {
                    a[j]=m1;//mean
                    b[j]=a1[i1];//median
                    //boundary
                    t1 = a1[j]-l1;
                    t2 = b1-a1[j];
                    if (t1<=t2)
                        c[j]=l1;
                    else
                        c[j]=b1;
                }
                else if (j<6)
                {
                    a[j]=m2;//mean
                    b[j]=a2[i2];//median
                    //boundary
                    t1 = a2[j-3]-l2;
                    t2 = b2-a2[j-3];
                    if (t1<=t2)
                        c[j]=l2;
                    else
                        c[j]=b2;
                }
                else
                {
                    a[j]=m3;//mean
                    b[j]=a3[i3];//median
                    //boundary
                    t1 = a3[j-6]-l3;
                    t2 = b3-a3[j-6];
                    if (t1<=t2)
                        c[j]=l3;
                    else
                        c[j]=b3;
                }
                System.out.println(a[j]+"\t\t\t\t\t"+ b[j] +"\t\t\t\t\t"+c[j]);
            }           
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}