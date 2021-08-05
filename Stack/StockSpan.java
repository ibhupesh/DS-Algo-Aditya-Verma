import java.io.*;
import java.util.*;

public class StockSpan
{
	public static void main(String args[])
	{
		Stack s= new Stack();
		Stack si= new Stack();
		Vector<Integer> v= new Vector<Integer>();
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter length of the array");
		int n=sc.nextInt();
		int arr[]=new int[n];

		for(int k=0;k<n;k++)
		arr[k]=sc.nextInt();
	for(int i=0;i<n;i++)
	{
		if(s.size()==0)
		{
			v.add(-1);
		}
		else if(s.size()>0 && (int)s.peek()>arr[i])
		{
			v.add((int)si.peek());
		}
		else if(s.size()>0 && (int)s.peek()<=arr[i])
		{
			while(s.size()>0 && (int)s.peek()<=arr[i])
			{
				s.pop();
				si.pop();
			}
			if(s.size()==0)
			{
				v.add(-1);
			}
			else
			{
				v.add((int)si.peek());
			}
		}
		s.push(arr[i]);
		si.push(i);
	}

	for(int x=0;x<n;x++)
		v.set(x,x-v.get(x));
	System.out.println(v);

	}
}