package math;


public class Equation {
 private int numA;//��һ����
 private int numB;//�ڶ�����
 private int operator;//�������1����+,2����-,3����*,4����/��
 private int result;//���
 
 public Equation(int numA,int numB,int operator) {
     this.numA = numA;
     this.numB = numB;
     this.operator = operator;
     //�õ����
     this.result = getAnswer(numA,numB,operator);
 }
 //��ӡ��Ŀ��û�д𰸣�
 public String printTitle() {
	 String Title = " "+numA+judgeSign(operator)+numB+" = ";
	 return Title ;
 }
//��ӡ��Ŀ���д𰸣�
 public String printAnswer() {
	 String Answer = " "+numA+judgeSign(operator)+numB+" = "+result;
	 return Answer ;
 }
 // �ж������
 public String judgeSign(int operator) {
	 String sign ="";
     switch (operator) {
     case 1:
         sign = " + ";
         break;
     case 2:
         sign = " - ";
         break;
     case 3:
         sign = " * ";
         break;
     case 4:
         sign = " / ";
         break;
     }
     return sign;
 }
 
 //���ɴ�
 public  int getAnswer(int numA,int numB,int operator) {
 int res = 0;
 switch (operator) {
 case 1:
     res = numA + numB;
     break;
 case 2:
     res = numA - numB;
     break;
 case 3:
     res = numA * numB;
     break;
 case 4:
	 if(numB == 0){
		 this.numB=1;
		 numB = 1;
	 }
         res = numA / numB;
	 break;
 }
 return res;
 }
 
public int getNumA() {
	return numA;
}
public void setNumA(int numA) {
	this.numA = numA;
}
public int getNumB() {
	return numB;
}
public void setNumB(int numB) {
	this.numB = numB;
}
public int getOperator() {
	return operator;
}
public void setOperator(int operator) {
	this.operator = operator;
}
public int getResult() {
	return result;
}
public void setResult(int result) {
	this.result = result;
}
}
