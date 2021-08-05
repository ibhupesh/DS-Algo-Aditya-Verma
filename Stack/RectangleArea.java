import java.io.*;
import java.util.*;

public class RectangleArea
{
	public int MAH(int arr[],int n)
	{
		Stack s= new Stack();
		Stack si= new Stack();
		Vector<Integer> v= new Vector<Integer>();


		int right[]=new int[n];
		int left[]=new int[n];
		int width[]=new int[n];

		//To find NSR
		for(int i=n-1;i>=0;i--)
		{
			if(s.size()==0)
			{
			v.add(n);
			}
			else if(s.size()>0 && (int)s.peek()<arr[i])
			{
				v.add((int)si.peek());
			}
			else if(s.size()>0 && (int)s.peek()>=arr[i])
			{
				while(s.size()>0 && (int)s.peek()>=arr[i])
				{
					s.pop();
					si.pop();
				}
				if(s.size()==0)
				{
					v.add(n);
				}
				else
				{
					v.add((int)si.peek());
				}
			}
			s.push(arr[i]);
			si.push(i);
		}
		Collections.reverse(v);
		for(int x=0;x<n;x++)
			right[x]=v.get(x);

		//For NSL
	
		Stack sl= new Stack();
		Stack sli= new Stack();
		Vector<Integer> vl= new Vector<Integer>();
		
		for(int q=0;q<n;q++)
		{
			if(sl.size()==0)
			{
				vl.add(-1);
			}
			else if(sl.size()>0 && (int)sl.peek()<arr[q])
			{
				vl.add((int)sli.peek());
			}
			else if(sl.size()>0 && (int)sl.peek()>=arr[q])
			{
				while(sl.size()>0 && (int)sl.peek()>=arr[q])
				{
					sl.pop();
					sli.pop();
				}
				if(sl.size()==0)
				{
					vl.add(-1);
				}
				else
				{
					vl.add((int)sli.peek());
				}
			}
			sl.push(arr[q]);
			sli.push(q);
		}

		for(int x=0;x<n;x++)
			left[x]=vl.get(x);

		//To find area

		for(int x=0;x<n;x++)
			width[x]=(right[x]-left[x]-1)*arr[x];
		Arrays.sort(width);
		return(width[n-1]);
	}
	public int MAX(int a, int b)
	{
		if(a>b)
			return a;
		else
			return b;
	}

	public static void main(String args[])
	{
	Scanner sc= new Scanner(System.in);
		
	int n=sc.nextInt();
	int m=sc.nextInt();
	int arr[][]=new int[n][m];
	for(int k=0;k<n;k++)
	{
	for (int l=0;l<m;l++)
	arr[k][l]=sc.nextInt();	
	}
	
	RectangleArea ob= new RectangleArea();

	int a[]=new int[m];
	for(int j=0;j<m;j++)
		a[j]=(arr[0][j]);
	int mx=ob.MAH(a,m);
	for( int i=0;i<n;i++)
	{
		for(int j=0;j<m;j++)
		{
			if(arr[i][j]==0)
				a[j]=0;
			else
				a[j]=a[j]+arr[i][j];
		}
		mx=ob.MAX(mx,ob.MAH(a,m));
	}
	System.out.println(mx);
	}
}