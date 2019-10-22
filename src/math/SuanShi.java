package math;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SuanShi {
	
	public static void main(String[] args) {
	    try {
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("这是一个自动生成四则运算试题的程序。接下来请选择相关的参数。");
	    	System.out.println("请输入要生成题目的数量(数量>1)");
	    	int num = sc.nextInt();
	    	System.out.println("请选择是否包含乘除法(包含请输入1，不包含请输入0)");
	    	int LevelFlg = sc.nextInt();
	    	System.out.println("请选择结果是否包含负数(包含请输入1，不包含请输入0)");
	    	int MinusFlg = sc.nextInt();
	    	System.out.println("请选择结果的最大范围(比如100,200,1000)");
	    	int maxNumFlg = sc.nextInt();
	    	
	    	//生成对象，然后调用它的方法
	    	SuanShi SuanShi=new SuanShi();
	    	List<Equation> from = new ArrayList<Equation>();
	    	//调用生成算式的程序,参数分别为 题目数量，是否含有乘除法，是否含有负数，最大的结果范围
	    	from = SuanShi.createEquation(num,LevelFlg,MinusFlg,maxNumFlg);
	    	//在控制台上展示算式
	    	SuanShi.showEquation(from);
	    	//将算式保存到文件中
	    	SuanShi.saveEquation(from);

	    } catch (Exception e){
	        System.out.println("Error!" + e);
	        System.exit(0);
	    }
	}
	 // 生成算式
    public List<Equation> createEquation(int num , int LevelFlg,int MinusFlg,int maxNumFlg) {

    	List<Equation> from = new ArrayList<Equation>();
    	//通过一个死循环来循环生成算式，然后检查是否符合条件，将满足条件的算式添加到list中，满足数量后跳出循环
        while(true) {
            Random rand = new Random();
            int operator = rand.nextInt(LevelFlg == 1 ? 4 : 2) + 1;// 是否乘除可控
            int numA = rand.nextInt(maxNumFlg) + 1;
            int numB = rand.nextInt(maxNumFlg) + 1;
            //将生成的算式放入对象中
            Equation equation = new Equation(numA,numB,operator);
            //检查生成的竖式符合条件吗
            if(check(from,equation,MinusFlg,maxNumFlg)) {
            // 将产生的并且通过检查的算式添加到List集合中
            from.add(equation);
            };
            //满足最大数量num后跳出循环
            if(from.size()>=num) break;
            
        }
        return from;
    }

    // 在控制台上展示算式
    public  void showEquation(List<Equation> from) {
    	
    	System.out.println("结果如下:");   	
    	for(int i=0;i<from.size();i++) {
    		System.out.println(from.get(i).printAnswer());
    	}
    }

    // 保存算式
    public  void saveEquation(List<Equation> from) {
    	BufferedWriter bufferedWriter = null;
    	String path = "D:\\homework\\result.txt" ;
    	try{
    		File file = new File(path);
    		if (!file.getParentFile().exists()) {
    		file.getParentFile().mkdirs();
    		}
    		file.createNewFile();
            // 获取该文件的缓冲输出流
            bufferedWriter = new BufferedWriter
            		(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            // 写入信息
            bufferedWriter.write("以下为本次程序生成的试题，共有"+from.size()+"道题\r\n");
    		for (int i=0;i<from.size();i++) {
    			//依次写入本地文件中
        		bufferedWriter.write(i+1+". "+from.get(i).printAnswer()+"\r\n");
    		}
    		bufferedWriter.flush();// 清空缓冲区
    		bufferedWriter.close();// 关闭输出流
    		
    		System.out.println("文件保存完毕!");
    	}catch (IOException e) {
    	e.printStackTrace();
    	}finally {
    		
    	}
    }
    
    //检查生成的算式是否正确。
    public  boolean check(List<Equation> from, Equation equation,int MinusFlg,int maxNumFlg) {
    	boolean result = true;
    	//判断新生成的算式是否超过最大范围
    	if(equation.getResult()>maxNumFlg) result = false;
    	//判断新生成的算式是否有负数
    	if(MinusFlg==0
    		&&equation.getResult()<0) result = false;
    	//判断新生成的算式是否和以前的重复
    	for(int i=0;i<from.size()-1;i++) {
    		if(from.get(i).getNumA()==equation.getNumA()
    			&&from.get(i).getNumB()==equation.getNumB()
    			&&from.get(i).getOperator()==equation.getOperator()) result = false;}
    	//输出通过检查的算式
		return result;
    	
    }
}
