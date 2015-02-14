import java.util.ArrayList;
/*
 * first time to implement DFS with DP
 */

public class counterweight {
	static ArrayList<String> pack = new ArrayList<String>();
	static String bestPack ="";
	static int min = Integer.MAX_VALUE;
	static String[] cw = {"3","7","16"};
	public static String findCW(String prefix, int num,int count){
		if(num == 0)
			//System.out.println(prefix+" count is"+ Integer.toString(count));
			{
				min = Math.min(min,count);
				bestPack = prefix;
			}
		else{
			for(int i=0;i<cw.length;i++)
			{
				if(num-Integer.parseInt(cw[i])>0)
				{
					findCW(prefix+cw[i]+",",num-Integer.parseInt(cw[i]),count+1);
				}
				if(num- Integer.parseInt(cw[i])==0)
				{
					findCW(prefix+cw[i],num-Integer.parseInt(cw[i]),count+1);
				}
			}
		}
		//System.out.println(pack);
		return bestPack;
	}
	public static String findCW(int num){
		return findCW("",num, 0);
	}
	
	public static void main(String args[])
	{
		System.out.println(findCW(26));
	}
}
