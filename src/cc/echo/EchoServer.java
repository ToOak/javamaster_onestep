package cc.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) {
		ServerSocket serversocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			// 实例化监听端
			serversocket = new ServerSocket(6666);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not listen on port 66666");
			System.exit(1);
		}
		Socket incoming = null;
		while(true) {
			try {
				incoming = serversocket.accept();
				out = new PrintWriter(incoming.getOutputStream(),true);
				// 先将字节流转换为字符流  之后将字符流放入缓冲之中
				in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
				// 提示信息
				out.println("Hello!...");
				out.println("Enter BYE to exit!");
				out.flush();
				// 没有异常的情况下不断循环
				while(true) {
					// 只有当用户输入的时候才返回数据
					String str = in.readLine();
					// 当用户连接断掉时会返回空值null
					if(str == null) {
						break;
					}else {
						out.println("Echo: " + str);
						out.flush();
						// 退出命令 不区分大小写
						if(str.trim().equalsIgnoreCase("BYE")){
//							break;
							return;
						}
					}
				
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Accept failed!");
				System.exit(2);
			}finally {
				out.close();
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					incoming.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					serversocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
