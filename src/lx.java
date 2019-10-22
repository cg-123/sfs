import java.util.Arrays;



/*对给定数组进行排序
 * {5,1,6,4,2,8,9}*/
 public class lx {
		
		//选择排序
		public static void SelectSort(int[] arr)
		{
			for(int x=0;x<arr.length-1;x++)
			{
				for(int y=x+1;y<arr.length;y++)
				{
					if(arr[x]<arr[y])
					{
						/*
					int temp=arr[y];
						arr[y]=arr[x];
						arr[x]=temp;*/
						swap(arr,x,y);
					}
				}
			}
		}
		//冒泡排序
		public static void BubbleSort(int[] arr)
		{
			for(int x=0;x<arr.length-1;x++)
			{
				for(int y=0;y<arr.length-x-1;y++)
				{
					if(arr[y]>arr[y+1])
					{
					/*int temp=arr[y];
						arr[y]=arr[y+1];
						arr[y+1]=temp;*/
						swap(arr,y,y+1);//swap交换
					}
				}
			}
		}
		public static void main (String[] args)
		{
			int[] arr={5,1,6,4,2,8,9};
			//SelectSort(arr);
			//PrintArray(arr);
			//Arrays.sort(arr);java中已经定义好的一种排序方式，开发中对数组排序，要使用该句代码；
			//BubbleSort(arr);
			//PrintArray(arr);
			int index=getIndex(arr,2);
			System.out.println("index="+index);
		}
		

	public static void PrintArray(int[] arr)
	{   System.out.print("[");
		for(int x=0;x<arr.length;x++)
		{
			if(x!=arr.length-1)
			{
				System.out.print(arr[x]+", ");
			}
			else
				System.out.println(arr[x]+"]");	
			}
	}
	public static void swap(int[] arr,int a,int b)
	{
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	
	//数组的查找操作
	public static int getIndex(int[] arr,int key){
		for(int x=0; x<arr.length;x++){
			if(arr[x]==key)
			return x;
			
		}
		
			return -1;
	}
 }
