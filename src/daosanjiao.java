
public class daosanjiao {
	public static void main(String[] args){
		
		print99(9);
	}
	
	public static void print99(int num){
	
		for(int x=0;x<num;x++)
		{
			for(int y=0;y<=x;y++)
			{
				System.out.print(y+"*"+x+"="+y*x+"\t");
				
			}
			System.out.println(" ");
		}
	}

	
	
	
}
