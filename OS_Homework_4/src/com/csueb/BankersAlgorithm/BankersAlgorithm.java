package com.csueb.BankersAlgorithm;

public class BankersAlgorithm
{
	int noOfCustomers = 5; 
	int noOfResources = 3; 
	int need[][] = new int[noOfCustomers][noOfResources];
	int [][]maximum;
	int [][]allocation;
	int []available;
	int safeSequence[] = new int[noOfCustomers];
	
	public static void main(String[] args)
	{
	BankersAlgorithm bankerAlgorithm = new BankersAlgorithm();	
	bankerAlgorithm.initVal();	
	bankerAlgorithm.cal();			
	bankerAlgorithm.checkSafe();		
	}
	
	void initVal()
	{
	allocation = new int[][] { { 0, 2, 0 }, 
				{ 3, 0, 0 },
				{ 4, 0, 3 }, 
				{ 3, 2, 2 }, 
				{ 0, 0, 3 } }; 	
	maximum = new int[][] { { 8, 6, 4 },
			{ 4, 3, 3 }, 
			{ 8, 0, 3 },
			{ 3, 3, 3 }, 
			{ 5, 4, 4 } };
	available = new int[] { 2, 2, 1 };
	}
	void cal()
	{
	for (int i = 0;i < noOfCustomers; i++)
	{
		for (int j = 0;j < noOfResources; j++)
		{
		need[i][j] = maximum[i][j]-allocation[i][j];
		}
	}		
	}
	void checkSafe()
	{
	int count=0;
	boolean visited[] = new boolean[noOfCustomers];
	for (int i = 0;i < noOfCustomers; i++)
	{
		visited[i] = false;
	}
	int work[] = new int[noOfResources];	
	for (int i = 0;i < noOfResources; i++)
	{
		work[i] = available[i];
	}

	while (count<noOfCustomers)
	{
		boolean flag = false;
		for (int i = 0;i < noOfCustomers; i++)
		{
			if (visited[i] == false)
			{
			int j;
			for (j = 0;j < noOfResources; j++)
			{		
				if (need[i][j] > work[j])
				break;
			}
			if (j == noOfResources)
			{
			safeSequence[count++]=i;
			visited[i]=true;
			flag=true;
						
				for (j = 0;j < noOfResources; j++)
				{
				work[j] = work[j]+allocation[i][j];
				}
			}
			}
		}
		if (flag == false)
		{
			break;
		}
	}
	if (count < noOfCustomers)
	{
		System.out.println("Available system is not Safe!");
	}
	else
	{
		System.out.print ("Safe sequence would be : ");
				for (int i = 0;i < noOfCustomers; i++)
		{
			System.out.print("P" + safeSequence[i]);
			if (i != noOfCustomers-1)
			System.out.print(" -> ");
		}
	}
	}

}

