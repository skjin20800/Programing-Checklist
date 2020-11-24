package Programing1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

/**
 * @class ExampleSend
 * @brief This sample code demonstrate how to send sms through CoolSMS Rest API PHP
 */
public class ExampleSend extends JFrame{
	
	public ExampleSend() {
		setTitle("GridLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //X��ưŬ���ϸ� main�� �����.

		// 4x2 ������ GridLayout ��ġ������ ����
		GridLayout grid = new GridLayout(3,2);
		grid.setVgap(5);
		
		Container c = getContentPane();
		JPanel a = new JPanel();
		
		c.add(a,BorderLayout.CENTER);

		JButton btn1 = new JButton("����");
		JTextArea Jphone = new JTextArea();
		JTextArea Jmessage = new JTextArea();
		a.setLayout(grid);
		
		a.add(new JLabel(" ��ȭ��ȣ"));
		a.add(Jphone);
		a.add(new JLabel(" �޽���"));
		a.add(Jmessage);
		a.add(btn1);
		
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				��������(Jphone.getText(),Jmessage.getText());
			}
		});
		
		
		
		
		
		setSize(300,200);
		setVisible(true);
	}
	
	
	
	
	static void ��������(String to, String text) {
		   String api_key = "NCSCMO9OO5OTV2X8";
		    String api_secret = "1TPJMUOZGWWJAIWCR1IDQ2OMXW1D88I8";
		    Message coolsms = new Message(api_key, api_secret);

		    // 4 params(to, from, type, text) are mandatory. must be filled
		    HashMap<String, String> params = new HashMap<String, String>();
		    params.put("to", to);
		    params.put("from", "01041623177");
		    params.put("type", "SMS");
		    params.put("text", text);
		    params.put("app_version", "test app 1.2"); // application name and version

		    try {
		      JSONObject obj = (JSONObject) coolsms.send(params);
		      System.out.println("�޼����� ���۵Ǿ����ϴ�.");
		      System.out.println(obj.toString());
		  	//1�� obj(���ڿ�) -> �ڹٿ�����Ʈ
				//2�� error�� �ִ��� Ȯ��
				//3�� DB insert
		    } catch (CoolsmsException e) {
		      System.out.println(e.getMessage());
		      System.out.println(e.getCode());
		    }
	}
	
  public static void main(String[] args) {
	  new ExampleSend();
	  
  }
}