package com.xjw.iteract;

import java.io.File;
import java.nio.charset.MalformedInputException;

/**
 * @author 谢嘉伟
 * @content jiecheng
 */
public class Iteractor {
	//1.阶乘
	//找出口： return i = 1
	//找规律：!N= !(n-1)n
	public int jiecheng(int n){
		if(n == 1){
			return 1;
		}else {
			return jiecheng(n-1)*n;
		}
	}

	//裴柏纳锲数列
	//1 1 2 3 5 8 
	//规律： 前两个数相加等于第三个数
	//出口：=1 || =2 
	public int beiBoNaQie(int day){
		if(day == 1 || day == 2){
			return 1;
		}else{
			return beiBoNaQie(day-1)+beiBoNaQie(day - 2 );
		}
	}
	
	//列出指定文件夹后缀
	public void iteFile( File dir, String suffix){
	
		File[] listFiles = dir.listFiles();
		for (File file : listFiles) {
			if(file.isDirectory()){
				iteFile(file, suffix);
			}else {
				System.out.println(file.getName());
			}
		}
	}
	
	//删除包含多种文件夹的文件
	public void delFile(File file){
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			if(file2.isDirectory()){
				delFile(file2);
			}else{
				file.delete();
			}
		}
	}
	
	//交换的三种方法
	public void exchange1(int a, int b){
		
		int temp = a;
		a = b;
		b = temp;
		
	} 
	public void exchange2(int a , int b){
		a = a + b;
		b = a - b;
		a = a - b;
	}
	public void exchange3(int a, int b){
		a = a ^ b;
		b = a ^ b;
		a = b ^ a;
	}
	
	//约瑟夫环的递归问题
	//初始化环的问题
	//判断最后一个人的问题，利用节点进行那个删除那个节点
	
	/**
	 * @param total 总数
	 * @param num  每次喊的数字为多少
	 * @param header 是指第一个人
	 * @param pointer 现在轮到的人
	 */
	public void yuesefu(int total, int num){
		
		Node header = new Node(1);
		Node pointer = header;
		
		for (int i = 2; i < total; i++) {
			pointer.next = new Node(i);
			pointer = pointer.next;
		}
		pointer.next = header; //把头节点给最后一个pointer这样环成一个环
		// --- 结束了初始化操作  ---
		
		System.out.println("下面是出列的顺序");
		while(pointer.next != pointer){
			for (int i = 1; i < num; i++) {
				pointer = pointer.next;
			}
			System.out.println(pointer.no);
			pointer.next = pointer.next.next;
		}
		System.err.println(pointer.next.no);
	}
	
}
class Node{
	 public int no;
	 
	 public Node next;
	 
	 public Node(int num){
		 no = num;
	 }
}

