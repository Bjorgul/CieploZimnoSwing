import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class CieploZimnoSwing  extends JFrame implements ActionListener {
	
	JButton bSprawd�;
	JTextField fPodajLiczb�; 
	JLabel lPr�by, lWybrana, lRekord;
	JSlider sLiczby;
	
	int szukana = 0;
	int pytanie = 0;
	int najni�sza = 0;
	int najwy�sza = 0;
	int podana = 0;
	int startowa1 = 0;
	int startowa2 = 1000;
	int pr�by = 0;
	int rekord = 99999;
	
	
	public CieploZimnoSwing() {
		
		Random random = new Random();
		szukana = random.nextInt(1001);
		
		setTitle("Ciep�o Zimno");
		setSize(1440, 350);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println(szukana);
		
		
		sLiczby = new JSlider(startowa1,startowa2,startowa1);
		sLiczby.setBounds(10, 100, 1400, 100);
		sLiczby.setMajorTickSpacing(25);
		sLiczby.setMinorTickSpacing(1);
		sLiczby.setPaintLabels(true);
		sLiczby.setPaintTicks(true);
		add(sLiczby);
		
		bSprawd� = new JButton("Sprawd�");
		bSprawd�.setBounds(10, 220, 1400, 80);
		add(bSprawd�);
		bSprawd�.addActionListener(this);
		
		lWybrana = new JLabel("Ostatnia wybrana liczba to: ");
		lWybrana.setBounds(10, 10, 600, 90);
		add(lWybrana);
		
		lPr�by = new JLabel("Liczba pr�b: 0");
		lPr�by.setBounds(620,10,600,90);
		add(lPr�by);
		
		lRekord = new JLabel("Jeszcze nie ma �adnego rekordu");
		lRekord.setBounds(1130,10,600,90);
		add(lRekord);
		
	}

	public static void main(String[] args) {
		CieploZimnoSwing aplikacja = new CieploZimnoSwing();
		aplikacja.setVisible(true);    

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		pytanie = sLiczby.getValue();
		if (pytanie > szukana) {
			sLiczby.setMaximum(pytanie);
			System.out.println("Wybierz mniejsz� liczb�");
			lWybrana.setText("Ostatnia wybrana liczba to: " + pytanie + " - wybierz mniejsz� liczb�!");
		}
		if (pytanie < szukana) {
			sLiczby.setMinimum(pytanie);
			System.out.println("Wybierz wi�ksz� liczb�");
			lWybrana.setText("Ostatnia wybrana liczba to: " + pytanie + " - wybierz wi�ksz� liczb�!");
		}
		if (pytanie == szukana) {
			JOptionPane.showMessageDialog(this, pytanie + " - to poprawna liczba!", "Gratulacje", JOptionPane.PLAIN_MESSAGE);
			lWybrana.setText("Gratulacje - " + pytanie + " - to poprawna liczba!");
			sLiczby.setMinimum(startowa1);
			sLiczby.setMaximum(startowa2);
			if (pr�by<rekord) {
				rekord = pr�by;
				lRekord.setText("Aktualny rekord to: " + rekord);
				pr�by = 0;
				Random random = new Random();
				szukana = random.nextInt(1001);
						
			}
			
		}
		pr�by = pr�by + 1;
		lPr�by.setText("Liczba pr�b: " + pr�by);
		
		
		
	}

}
