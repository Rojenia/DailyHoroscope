import java.awt.BorderLayout;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;	
import java.util.Random;


public class Horoscope extends JFrame {
	//Size of window
	private final int WINDOW_WIDTH = 600;
	private final int WINDOW_HEIGHT = 350;
	private static int websitePick = 0;
    private final String html = "<html><body style='width:400px'> ";


	//Create Panels
	private horoscopePanel menu;
	private JPanel readingPanel;
	
	//Create JLabels
	private JLabel menuLabel;
    
	private Horoscope() {
		//Set Horoscopes
		try {
			dailyHoroscope.astroSigns();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Size of window
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		//What to do when window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//Title of window
		setTitle("Horoscope");
		
		//Layout of window
		setLayout(new BorderLayout());
		
		//Build Panel
		buildPanel();
		
		//Add to Frame
		add(menu, BorderLayout.NORTH);
		add(readingPanel, BorderLayout.CENTER);
	       
		setVisible(true);
	}
	
	public class horoscopePanel extends JPanel{
		
		//Buttons for astro sign
	    private JButton ariesButton;	
		private JButton taurusButton;		
		private JButton geminiButton;	
		private JButton cancerButton;
	    private JButton leoButton;
		private JButton virgoButton;	
		private JButton libraButton;	
		private JButton scorpioButton;
	    private JButton sagittariusButton;
		private JButton capricornButton;		
		private JButton aqauriusButton;		
		private JButton piscesButton;
		
		//Create Panels
		private JPanel buttonPanel;
		private JPanel buttonPanel2;
		
		horoscopePanel()
		{
			setLayout(new GridLayout(2,6));

	        buildButtonPanel();
	        
			add(buttonPanel);
			add(buttonPanel2);
		}
		
		private void buildButtonPanel()
		{
			buttonPanel = new JPanel();
			buttonPanel2 = new JPanel();
				
			//Create Astro Sign buttons
			ariesButton = new JButton("Aries");
			
			taurusButton = new JButton("Taurus");
			
			geminiButton = new JButton("Gemini");
			
			cancerButton = new JButton("Cancer");

			leoButton = new JButton("Leo");
			
			virgoButton = new JButton("Virgo");
			
			libraButton = new JButton("Libra");
			
			scorpioButton = new JButton("Scorpio");

			sagittariusButton = new JButton("Sagittarius");
			
			capricornButton = new JButton("Capricorn");
			
			aqauriusButton = new JButton("Aqaurius");
			
			piscesButton = new JButton("Pisces");
			
					
			//Create button listeners
			ariesButton.addActionListener(new ButtonListener());
			geminiButton.addActionListener(new ButtonListener());
			taurusButton.addActionListener(new ButtonListener());
			cancerButton.addActionListener(new ButtonListener());
			leoButton.addActionListener(new ButtonListener());
			virgoButton.addActionListener(new ButtonListener());
			libraButton.addActionListener(new ButtonListener());
			scorpioButton.addActionListener(new ButtonListener());
			sagittariusButton.addActionListener(new ButtonListener());
			capricornButton.addActionListener(new ButtonListener());
			aqauriusButton.addActionListener(new ButtonListener());
			piscesButton.addActionListener(new ButtonListener());
			
			//Add buttons to AstroPanel
			buttonPanel.add(ariesButton);
			buttonPanel.add(taurusButton);
			buttonPanel.add(geminiButton);
			buttonPanel.add(cancerButton);
			buttonPanel.add(leoButton);
			buttonPanel.add(virgoButton);
			buttonPanel2.add(libraButton);
			buttonPanel2.add(scorpioButton);
			buttonPanel2.add(sagittariusButton);
			buttonPanel2.add(capricornButton);
			buttonPanel2.add(aqauriusButton);
			buttonPanel2.add(piscesButton);
		}

	}
	
	/*********************************************************************
		Adds functionality to buttons in astroPanel
	 **********************************************************************/

	private class ButtonListener implements ActionListener
	{
	
		public void actionPerformed(ActionEvent e)
		{
			randomNum();
		
			if(e.getSource() == menu.ariesButton)
			{
				menuLabel.setText(html + webParser.getHTML(websitePick, 0));

			}
			else if(e.getSource() == menu.taurusButton)
			{
				menuLabel.setText(html + webParser.getHTML(websitePick, 1));
			}
			else if(e.getSource() == menu.geminiButton)
			{
				menuLabel.setText(html + webParser.getHTML(websitePick, 2));
			}
			else if(e.getSource() == menu.cancerButton)
			{
				menuLabel.setText(html + webParser.getHTML(websitePick, 3));
			}
			else if(e.getSource() == menu.leoButton)
			{
				menuLabel.setText(html + webParser.getHTML(websitePick, 4));
			}
			else if(e.getSource() == menu.virgoButton)
			{
				menuLabel.setText(html + webParser.getHTML(websitePick, 5));
			}
			else if(e.getSource() == menu.libraButton)
			{
				menuLabel.setText(html + webParser.getHTML(websitePick, 6));
			}
			else if(e.getSource() == menu.scorpioButton)
			{
				menuLabel.setText(html + webParser.getHTML(websitePick, 7));
			}
			else if(e.getSource() == menu.sagittariusButton)
			{
				menuLabel.setText(html + webParser.getHTML(websitePick, 8));
			}
			else if(e.getSource() == menu.capricornButton)
			{
				menuLabel.setText(html + webParser.getHTML(websitePick, 9));
			}
			else if(e.getSource() == menu.aqauriusButton)
			{
				menuLabel.setText(html + webParser.getHTML(websitePick, 10));
			}
			else if(e.getSource() == menu.piscesButton)
			{
				menuLabel.setText(html + webParser.getHTML(websitePick, 11));
			}
		}
	}
	
	//Randomly selects a number between 0-2
	private static void randomNum()
	{
		Random r = new Random();
		websitePick = r.nextInt(3);
		
	}
	
	private void buildPanel()
	{
		//create Panels
		readingPanel = new JPanel();
		menu = new horoscopePanel();
		
		//create Labels
		menuLabel = new JLabel();
		
		//Add components to panels
        readingPanel.add(menuLabel);
	}

	public static void main(String[] args) throws Exception{
		new Horoscope();
	}
}




