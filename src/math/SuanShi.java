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
	    	System.out.println("����һ���Զ�����������������ĳ��򡣽�������ѡ����صĲ�����");
	    	System.out.println("������Ҫ������Ŀ������(����>1)");
	    	int num = sc.nextInt();
	    	System.out.println("��ѡ���Ƿ�����˳���(����������1��������������0)");
	    	int LevelFlg = sc.nextInt();
	    	System.out.println("��ѡ�����Ƿ��������(����������1��������������0)");
	    	int MinusFlg = sc.nextInt();
	    	System.out.println("��ѡ���������Χ(����100,200,1000)");
	    	int maxNumFlg = sc.nextInt();
	    	
	    	//���ɶ���Ȼ��������ķ���
	    	SuanShi SuanShi=new SuanShi();
	    	List<Equation> from = new ArrayList<Equation>();
	    	//����������ʽ�ĳ���,�����ֱ�Ϊ ��Ŀ�������Ƿ��г˳������Ƿ��и��������Ľ����Χ
	    	from = SuanShi.createEquation(num,LevelFlg,MinusFlg,maxNumFlg);
	    	//�ڿ���̨��չʾ��ʽ
	    	SuanShi.showEquation(from);
	    	//����ʽ���浽�ļ���
	    	SuanShi.saveEquation(from);

	    } catch (Exception e){
	        System.out.println("Error!" + e);
	        System.exit(0);
	    }
	}
	 // ������ʽ
    public List<Equation> createEquation(int num , int LevelFlg,int MinusFlg,int maxNumFlg) {

    	List<Equation> from = new ArrayList<Equation>();
    	//ͨ��һ����ѭ����ѭ��������ʽ��Ȼ�����Ƿ������������������������ʽ��ӵ�list�У���������������ѭ��
        while(true) {
            Random rand = new Random();
            int operator = rand.nextInt(LevelFlg == 1 ? 4 : 2) + 1;// �Ƿ�˳��ɿ�
            int numA = rand.nextInt(maxNumFlg) + 1;
            int numB = rand.nextInt(maxNumFlg) + 1;
            //�����ɵ���ʽ���������
            Equation equation = new Equation(numA,numB,operator);
            //������ɵ���ʽ����������
            if(check(from,equation,MinusFlg,maxNumFlg)) {
            // �������Ĳ���ͨ��������ʽ��ӵ�List������
            from.add(equation);
            };
            //�����������num������ѭ��
            if(from.size()>=num) break;
            
        }
        return from;
    }

    // �ڿ���̨��չʾ��ʽ
    public  void showEquation(List<Equation> from) {
    	
    	System.out.println("�������:");   	
    	for(int i=0;i<from.size();i++) {
    		System.out.println(from.get(i).printAnswer());
    	}
    }

    // ������ʽ
    public  void saveEquation(List<Equation> from) {
    	BufferedWriter bufferedWriter = null;
    	String path = "D:\\homework\\result.txt" ;
    	try{
    		File file = new File(path);
    		if (!file.getParentFile().exists()) {
    		file.getParentFile().mkdirs();
    		}
    		file.createNewFile();
            // ��ȡ���ļ��Ļ��������
            bufferedWriter = new BufferedWriter
            		(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            // д����Ϣ
            bufferedWriter.write("����Ϊ���γ������ɵ����⣬����"+from.size()+"����\r\n");
    		for (int i=0;i<from.size();i++) {
    			//����д�뱾���ļ���
        		bufferedWriter.write(i+1+". "+from.get(i).printAnswer()+"\r\n");
    		}
    		bufferedWriter.flush();// ��ջ�����
    		bufferedWriter.close();// �ر������
    		
    		System.out.println("�ļ��������!");
    	}catch (IOException e) {
    	e.printStackTrace();
    	}finally {
    		
    	}
    }
    
    //������ɵ���ʽ�Ƿ���ȷ��
    public  boolean check(List<Equation> from, Equation equation,int MinusFlg,int maxNumFlg) {
    	boolean result = true;
    	//�ж������ɵ���ʽ�Ƿ񳬹����Χ
    	if(equation.getResult()>maxNumFlg) result = false;
    	//�ж������ɵ���ʽ�Ƿ��и���
    	if(MinusFlg==0
    		&&equation.getResult()<0) result = false;
    	//�ж������ɵ���ʽ�Ƿ����ǰ���ظ�
    	for(int i=0;i<from.size()-1;i++) {
    		if(from.get(i).getNumA()==equation.getNumA()
    			&&from.get(i).getNumB()==equation.getNumB()
    			&&from.get(i).getOperator()==equation.getOperator()) result = false;}
    	//���ͨ��������ʽ
		return result;
    	
    }
}
