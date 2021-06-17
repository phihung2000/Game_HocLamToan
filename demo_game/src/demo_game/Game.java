package demo_game;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;




public class Game extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game frame = new Game();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public int a,b,c,thoigian=0,diem= -1,check,i=0;
	public Timer timer;
	public boolean gameover;
	public JLabel lblCauhoi = new JLabel("Câu hỏi ?");
	JLabel lblNewLabel_1 = new JLabel("số điểm :");
	JLabel lblNewLabel_2 = new JLabel("0");
	public void load() {
		diem++;
		lblNewLabel_2.setText(diem+"");
		Random rdRandom =new Random();
			a = rdRandom.nextInt(10)+1;
			b = rdRandom.nextInt(10)+1;
			check=rdRandom.nextInt(5);
			
			if(check%2==0)
			{
				c=a+b;
				
			}
			else {
				c =rdRandom.nextInt(20);
			}
			if(diem>=10 && check%2==0)
			{
				
				c=a*b;
			}
			else if(diem>10 && check %2!=0) 
			{
				c = rdRandom.nextInt(100);
			}
			
			if(diem>=10)
			{
				lblCauhoi.setText(a+" x "+b+" = "+c);
			}
			else {
				lblCauhoi.setText(a+" + "+b+" = "+c);
			}
		
	}
	public Game() {
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 408);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Học làm Toán");
		lblNewLabel.setIcon(new ImageIcon("H:\\hk1_nam 3\\do_an_co_so_nganh\\open-book.png"));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JProgressBar progess = new JProgressBar();
		progess.setValue(-100);
		progess.setStringPainted(true);
		progess.setForeground(Color.RED);
		
		JButton btnDung = new JButton("Đúng");
		btnDung.setIcon(new ImageIcon("H:\\hk1_nam 3\\do_an_co_so_nganh\\demo_game\\yes.png"));
		btnDung.setBackground(new Color(0, 255, 127));
		btnDung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!gameover) {
					if(diem<5)
					{
						if (a+b==c)
						{
							load();
							thoigian=100;
							timer.start();
							
						}
						else {
							lblCauhoi.setText(" bạn đã thua");
							
							thoigian=0;
							timer.stop();
							gameover=true;
							JOptionPane.showMessageDialog(lblCauhoi, "Tổng số điểm của bạn là  : "+diem );
						}
					}
			
					else if(diem<10)
					{
									if (a+b==c)
									{
										load();
										thoigian=100;
										timer.start();
										
									}
									else {
										lblCauhoi.setText(" bạn đã thua");
										
										thoigian=0;
										timer.stop();
										gameover=true;
										JOptionPane.showMessageDialog(lblCauhoi, "Tổng số điểm của bạn là  : "+diem );
									}
					}
					else {
									if (a*b==c)
									{
										load();
										thoigian=100;
										timer.start();
								
									}
									else {
										lblCauhoi.setText(" bạn đã  thua");
										
										thoigian=0;
										timer.stop();
										gameover=true;
										JOptionPane.showMessageDialog(lblCauhoi, "Tổng số điểm của bạn là  : "+diem );
						}
					}
				}
			}
			
		});
		
		btnDung.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnSai = new JButton("Sai");
		btnSai.setIcon(new ImageIcon("H:\\hk1_nam 3\\do_an_co_so_nganh\\demo_game\\close.png"));
		btnSai.setBackground(new Color(0, 255, 0));
		btnSai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!gameover)
				{
					
					if(diem<10)
					{
									if(a+b!=c)
									{
												load();
												thoigian=100;
												timer.start();
												
									}
									else 
									{
												lblCauhoi.setText(" Bạn đã thua");
												gameover=true;
												thoigian=0;
												timer.stop();
												JOptionPane.showMessageDialog(lblCauhoi, "Tổng số điểm của bạn là  : "+diem );
										}
					}
					else {
											if(a*b!=c)
											{
															load();
															thoigian=100;
															timer.start();
														
											}
											else 
											{
																	lblCauhoi.setText("Bạn đã  thua");
																	
																	
																	gameover=true;
																	thoigian=0;
																	timer.stop();
																	JOptionPane.showMessageDialog(lblCauhoi, "Tổng số điểm của bạn là  : "+diem );
												}
					}
				}
			}
		});
		btnSai.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		JButton btnChoi = new JButton("Chơi");
		btnChoi.setBackground(new Color(0, 255, 0));
		btnChoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				i+=1;
				if(i==1)
				{
					diem=-1;
					i=0;
				}
				load();
				thoigian=100;
				timer = new Timer(500, new loadtime());
				timer.start();
				
				gameover=false;
			}
			class loadtime implements ActionListener {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					
							if(thoigian>0)
							{
								thoigian--;
								progess.setValue(thoigian);
							}
							else {
								lblCauhoi.setText("Bạn đã thua");
								JOptionPane.showMessageDialog(lblCauhoi, "Tổng số điểm của bạn là  : "+diem );
							}
				}
				
			}
			
		});
		btnChoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblCauhoi.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {

			}
		});
		lblCauhoi.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblCauhoi.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblDiem = new JLabel("");
		lblDiem.setForeground(Color.RED);
		lblDiem.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnDung, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
					.addComponent(btnSai, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(63, Short.MAX_VALUE)
					.addComponent(btnChoi, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
					.addGap(40))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblCauhoi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDiem)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(86, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(progess, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(84)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(progess, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDiem)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1)
							.addComponent(lblNewLabel_2)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCauhoi, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDung, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSai, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(btnChoi, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
