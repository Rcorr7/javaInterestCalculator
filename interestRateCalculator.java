import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class interestRateCalculator extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField textPrice;
	private JTextField textDownPayment;
	private JTextField textNumOfMonths;
	private JTextField textInterestRate;
	


	
	JTextArea textDisplayArea = new JTextArea();

	

	
	
	private calculator[] info = new calculator[100];

	int index;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interestRateCalculator frame = new interestRateCalculator();
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
	public interestRateCalculator() {
		setTitle("Interest Ratecalculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrice = new JLabel("Price: $");
		lblPrice.setBounds(33, 11, 61, 16);
		contentPane.add(lblPrice);
		
		textPrice = new JTextField();
		textPrice.setBounds(88, 6, 130, 26);
		contentPane.add(textPrice);
		textPrice.setColumns(10);
		
		JLabel lblDownPayment = new JLabel("Down Payment: $");
		lblDownPayment.setBounds(8, 49, 129, 16);
		contentPane.add(lblDownPayment);
		
		textDownPayment = new JTextField();
		textDownPayment.setBounds(147, 44, 130, 26);
		contentPane.add(textDownPayment);
		textDownPayment.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"AL", "AK", "AZ", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "CM", "OH", "OK", "OR", "PA", "PR", "RI", "SC", "SD", "TN", "TX", "TT", "UT", "VT", "VA", "VI", "WA", "WV", "WI", "WY"}));
		comboBox.setBounds(396, 113, 105, 27);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double numPrice = 0;
				double TAX = 0;
				double taxAmmount=0;
				double totalWithTax=0;
				double numTotalWithTax=0;
				double numDownP = 0;
				double numOfM = 0;
				double numOfY = 0;
				double monthlyPayments =0;
				double numTotalO =0;
				double iR = 0;
				double decIR;
				double totalInterest;
				
				calculator data = new calculator();
				try{
					
					String state = comboBox.getSelectedItem().toString();
					switch(state) {
				 	case "AL":
				 		TAX=4;
				 		break;
				 	case "AK":
				 		TAX=0;
				 	case "AZ":
				 		TAX=5.6;
				 		break;
				 	case "AR":
				 		TAX=6.5;
				 		break;
				 	case "CA":
				 		TAX=7.25;
				 		break;
				 	case "CO":
				 		TAX=2.9;
				 		break;
				 	case "CT":
				 		TAX=6.35;
				 		break;
				 	case "DE":
				 		TAX=0;
				 		break;
				 	case "DC":
				 		TAX=6;
				 		break;
				 	case "FL":
				 		TAX=6;
				 		break;
				 	case "GA":
				 		TAX=4;
				 		break;
				 	case "HI":
				 		TAX=4;
				 		break;
				 	case "ID":
				 		TAX=6;
				 		break;
				 	case "IL":
				 		TAX=6.25;
				 		break;
				 	case "IN":
				 		TAX=7;
				 		break;
				 	case "IA":
				 		TAX=6;
				 		break;
				 	case "KS":
				 		TAX=6.5;
				 		break;
				 	case "KY":
				 		TAX=6;
				 		break;
				 	case "LA":
				 		TAX=4.45;
				 		break;
				 	case "ME":
				 		TAX=5.5;
				 		break;
				 	case "MD":
				 		TAX=6;
				 		break;
				 	case "MA":
				 		TAX=6;
				 		break;
				 	case "MI":
				 		TAX=6;
				 		break;
				 	case "MN":
				 		TAX=6.875;
				 		break;
				 	case "MS":
				 		TAX=7;
				 		break;
				 	case "MO":
				 		TAX=4.225;
				 		break;
				 	case "MT":
				 		TAX=0;
				 		break;
				 	case "NE":
				 		TAX=5.5;
				 		break;
				 	case "NV":
				 		TAX=6.85;
				 		break;
				 	case "NH":
				 		TAX=0;
				 		break;
				 	case "NJ":
				 		TAX=6.625;
				 		break;
				 	case "NM":
				 		TAX=5.125;
				 		break;
				 	case "NY":
				 		TAX=4;
				 		break;
				 	case "NC":
				 		TAX=4.75;
				 		break;
				 	case "ND":
				 		TAX=5;
				 		break;
				 	case "OH":
				 		TAX=5.75;
				 		break;
				 	case "OK":
				 		TAX=4.5;
				 		break;
				 	case "OR":
				 		TAX=0;
				 		break;
				 	case "PA":
				 		TAX=6;
				 		break;
				 	case "PR":
				 		TAX=11.5;
				 		break;
				 	case "RI":
				 		TAX=7;
				 		break;
				 	case "SC":
				 		TAX=6;
				 		break;
				 	case "SD":
				 		TAX=4.5;
				 		break;
				 	case "TN":
				 		TAX=7;
				 		break;
				 	case "TX":
				 		TAX=6.25;
				 		break;
				 	case "UT":
				 		TAX=4.85;
				 		break;
				 	case "VT":
				 		TAX=6;
				 		break;
				 	case "VA":
				 		TAX=4.3;
				 		break;
				 	case "WA":
				 		TAX=6.5;
				 		break;
				 	case "WV":
				 		TAX=6;
				 		break;
				 	case "WI":
				 		TAX=5;
				 		break;
				 	case "WY":
				 		TAX=4;
				 		break;
			
				}
					data.tax = Double.toString(TAX);
					data.price = textPrice.getText();
					data.downPayment = textDownPayment.getText();
					data.numOfMonths = textNumOfMonths.getText();
					data.InterestRate = textInterestRate.getText();
					
					  	 
			             numPrice = Double.parseDouble(data.price);
			             TAX = TAX/100;
			             numDownP = Double.parseDouble(data.downPayment);
			             numOfM = Double.parseDouble(data.numOfMonths);
			             iR = Double.parseDouble(data.InterestRate);

			        }
			        catch (NumberFormatException ex){
			            ex.printStackTrace();
			        }
				  
				 taxAmmount = numPrice * TAX;
				 
				 totalWithTax = numPrice+taxAmmount;
				
				  numTotalO= totalWithTax - numDownP;
				  
				  decIR = iR/100;
				  numOfY = (numOfM/12);
				  
				  numTotalO =  (numTotalO*(1+decIR*numOfY));
				 
				  
				  totalInterest = numTotalO - (totalWithTax-numDownP);
				 
				  
				  monthlyPayments = numTotalO/numOfM;
				  
				  data.totalInterestPaidCal = totalInterest;
				  
				  
				  //Format number
				  
				  NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US); 
				  
				  String sNumPrice = n.format(numPrice);
				  
				  data.price = sNumPrice;
				  
				  String sTotalTax = n.format(taxAmmount);
				  
				  data.totalInterestPaid = sTotalTax;
				  
				  String sNumTotaltax = n.format(totalWithTax);
				  
				  data.totalOwned = sNumTotaltax;
				  
				  String sNumDownP = n.format(numDownP);
				  
				  data.downPayment = sNumDownP;
				  
				  
				  String sTotalInterest = n.format(totalInterest);
				  
				  data.totalInterestPaid = sTotalInterest;
				  
				  String sNumTotalO = n.format(numTotalO);
				  
				  data.totalOwned = sNumTotalO;
				  
				  String sMonthlyPayments = n.format(monthlyPayments);
				  data.monthlyPayments = sMonthlyPayments;
	
	
				info[index] = data;
				index++;
				
				textPrice.setText(" ");
				textDownPayment.setText(" ");
				textNumOfMonths.setText(" ");
				textInterestRate.setText(" ");

				
			}
		});
		
		JLabel lblNumOfMonths = new JLabel("Number of Months");
		lblNumOfMonths.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumOfMonths.setBounds(6, 80, 130, 26);
		contentPane.add(lblNumOfMonths);
		
		textNumOfMonths = new JTextField();
		textNumOfMonths.setBounds(147, 80, 130, 26);
		contentPane.add(textNumOfMonths);
		textNumOfMonths.setColumns(10);
		
		textInterestRate = new JTextField();
		textInterestRate.setBounds(396, 44, 130, 26);
		contentPane.add(textInterestRate);
		textInterestRate.setColumns(10);
		
		JLabel lblInterestRate = new JLabel("Interest Rate:   %");
		lblInterestRate.setBounds(396, 16, 130, 16);
		contentPane.add(lblInterestRate);
		
		JLabel lblStateTax = new JLabel("State Tax");
		lblStateTax.setBounds(393, 85, 133, 16);
		contentPane.add(lblStateTax);
		btnNewButton.setBounds(20, 149, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblTotalOwned = new JLabel("Purchase Summary ");
		lblTotalOwned.setBounds(20, 237, 133, 16);
		contentPane.add(lblTotalOwned);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(198, 204, 422, 390);
		contentPane.add(scrollPane);
		
		JTextArea textDisplayArea_1 = new JTextArea();
		scrollPane.setViewportView(textDisplayArea_1);
		
		JButton btnViewData = new JButton("View Data");
		btnViewData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			double temp1 = 0; 
			double temp2 = 0;
			int ii = 0;

				
			try 
			{
			  for (ii = 0; ii < info.length; ii++) {
			  	temp1 = info[ii].totalInterestPaidCal;
			  	for(int j=0; j<=info.length;j++) {
			  		temp2 = info[j].totalInterestPaidCal;
			  		if(temp1>temp2)
			  		{
			  			break;
			  		
			  		}
			  		else if(temp1<temp2) 
			  		{
			  			continue;
			  			
			  		}else {
			  			continue;
			  		}
			  	}
			  		
			}
			}
			catch(Exception ex)
			{
				
			}
			 
				
				
				
				try 
				{
					textDisplayArea_1.removeAll();
					for(int i=0 ; i<info.length;i++) {
						textDisplayArea_1.append("Option: "+(i+1)+" Interest Rate: "+info[i].InterestRate+"%\n");
						textDisplayArea_1.append("Sale Tax                       : "+info[i].tax+"%\n");
						textDisplayArea_1.append("Purchase Price  : "+info[i].price+"\n");
						textDisplayArea_1.append("Tax                 : "+info[i].taxAmmount+"\n");
						textDisplayArea_1.append("Total Price      : "+info[i].newTotalWithTax+"\n");
						textDisplayArea_1.append("Down Payment - :"+info[i].downPayment+"\n");
						textDisplayArea_1.append("Total Interest +: "+info[i].totalInterestPaid+"\n");
						textDisplayArea_1.append("Total Owned     : "+info[i].totalOwned+"\n");
						textDisplayArea_1.append("You Must pay    : "+info[i].monthlyPayments+" for "+info[i].numOfMonths+" Months\n\n");
						textDisplayArea_1.append(" ");



					}

					
				
				}
				catch(Exception ex)
				{
					
					
				}
				textDisplayArea_1.append(" ");

				textDisplayArea_1.append("Best option: "+(ii+1)+"\n");




			
			}
		});
		btnViewData.setBounds(178, 149, 117, 29);
		contentPane.add(btnViewData);
		
	}
}
