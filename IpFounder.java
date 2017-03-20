import java.awt.EventQueue;
import java.net.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IpFounder {

	private JFrame frame;
	public JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IpFounder window = new IpFounder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IpFounder() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 615, 236);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterTheUrl = new JLabel("ENTER THE URL : ");
		lblEnterTheUrl.setFont(new Font("Yu Gothic Light", Font.BOLD | Font.ITALIC, 15));
		lblEnterTheUrl.setBounds(43, 38, 172, 14);
		frame.getContentPane().add(lblEnterTheUrl);
		
		JButton btnIp = new JButton("Get IP");
		btnIp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = textField.getText();
				try
				{
					InetAddress ia = InetAddress.getByName(url);
					String ip = ia.getHostAddress();
					JOptionPane.showMessageDialog(null,ip);
				}
				catch(UnknownHostException e1)
				{
					JOptionPane.showMessageDialog(null,e1.toString());
				}
			}
		});
		btnIp.setBounds(236, 106, 89, 39);
		frame.getContentPane().add(btnIp);
		
		textField = new JTextField();
		textField.setBounds(42, 63, 519, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
