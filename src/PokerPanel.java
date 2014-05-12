import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Utility.Card;
import Utility.Cards;
import Utility.Links;

/**
 * Panel to create button, images, and labels
 * @author ashishbillava
 *
 */
@SuppressWarnings("serial")
public class PokerPanel extends JPanel
{
	private static final int NUMBEROFCARDS = 3;
	private static final int NUMBEROFRESULTS = 3;
	private static final String IMAGESFOLDER = "images/";
	private Cards cards;
	private Links links;
	private JButton generator;
	private int gCounter;
	private JLabel counterText = new JLabel(" ");
	private JLabel[] cardLabels;
	private JLabel[] resultValues;
	private JPanel generatorPanel = new JPanel();
	private JPanel cardPanel = new JPanel();
	private JPanel resultPanel = new JPanel();	
	private BufferedImage[] pics = null;
	private Dimension dim1 = new Dimension(150, 218);
	private Dimension dim2 = new Dimension(150, 20);
	
	public PokerPanel()
	{
		super();
		setSize(900, 700);
		
		cards = new Cards();
		links = new Links();
		gCounter = 0;
		cardLabels = new JLabel[NUMBEROFCARDS];
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		generatorPanel.add(Box.createHorizontalStrut(700));
		generatorPanel.setLayout(new BoxLayout(generatorPanel, BoxLayout.LINE_AXIS));
		generator = new JButton("Generate");
		generator.addActionListener(new generateListener());
		generatorPanel.add(generator);
		generatorPanel.add(Box.createHorizontalStrut(10));
		Dimension dim3 = new Dimension(50, 20);
		counterText.setText(Integer.toString(gCounter));
		counterText.setMinimumSize(dim3);
		counterText.setPreferredSize(dim3);
		counterText.setMaximumSize(dim3);
		counterText.setHorizontalAlignment(JLabel.CENTER);
		counterText.setBorder(new LineBorder(Color.BLACK));
		generatorPanel.add(counterText);
		
		cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.LINE_AXIS));
		
		for(int i = 0; i < NUMBEROFCARDS; i++)
		{
			cardLabels[i] = new JLabel(" ");
			createImageSpace(cardLabels[i], false, null);
		}
		
		resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.LINE_AXIS));
		
		JPanel[] results = new JPanel[NUMBEROFRESULTS];
		resultValues = new JLabel[NUMBEROFRESULTS];
		JLabel[] resultLabels = {new JLabel("Suit"), new JLabel("Connectedness"), new JLabel("Match")};
		
		for(int i = 0; i < NUMBEROFRESULTS; i++)
		{
			results[i] = new JPanel();
			resultValues[i] = new JLabel(" ");
			createSubPanel(results[i], resultLabels[i], resultValues[i]);
		}
		
		resultPanel.add(Box.createHorizontalStrut(100));
		resultPanel.add(results[0]);
		resultPanel.add(Box.createHorizontalStrut(1));
		resultPanel.add(results[1]);
		resultPanel.add(Box.createHorizontalStrut(1));
		resultPanel.add(results[2]);
		
		pics = new BufferedImage[NUMBEROFCARDS];
		
		this.add(Box.createVerticalStrut(30));
		this.add(generatorPanel);
		this.add(Box.createVerticalStrut(1));
		this.add(cardPanel);
		this.add(Box.createVerticalStrut(30));
		this.add(resultPanel);
		this.add(Box.createVerticalStrut(30));
		
		setVisible(true);
		validate();
	}
	
	public void generateFlops() throws IOException
	{
		cardPanel.removeAll();
		
		gCounter++;
		counterText.setText(Integer.toString(gCounter));
		Card[] cardsDealt = new Card[NUMBEROFCARDS];
		cardsDealt = cards.dealAndGetCards(NUMBEROFCARDS);
		
		for(int i = 0; i < NUMBEROFCARDS; i++)
		{
			pics[i] = ImageIO.read(new File(IMAGESFOLDER + cardsDealt[i].getCard()));
			createImageSpace(cardLabels[i], true, pics[i]);
		}
		
		resultValues[0].setText(links.suit(cardsDealt[0].getSuitNumber(), cardsDealt[1].getSuitNumber(), 
				cardsDealt[2].getSuitNumber()));
		resultValues[1].setText(links.connectedness(cardsDealt[0].getFace(), cardsDealt[1].getFace(), 
				cardsDealt[2].getFace()));
		resultValues[2].setText(links.match(cardsDealt[0].getFace(), cardsDealt[1].getFace(), 
				cardsDealt[2].getFace()));
		
		revalidate();
		repaint();
	}
	
	private class generateListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			try
			{
				generateFlops();
			}
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
	
	/**
	 * Create area to display results
	 * @param p
	 * @param textL
	 * @param l
	 */
	private void createSubPanel(JPanel p, JLabel textL, JLabel l)
	{
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		l.setMinimumSize(dim2);
		l.setPreferredSize(dim2);
		l.setMaximumSize(dim2);
		l.setHorizontalAlignment(JLabel.CENTER);
		l.setBorder(new LineBorder(Color.BLACK));
		p.add(l);
		p.add(Box.createVerticalStrut(5));
		textL.setMinimumSize(dim2);
		textL.setPreferredSize(dim2);
		textL.setMaximumSize(dim2);
		textL.setHorizontalAlignment(JLabel.CENTER);
		p.add(textL);
	}
	
	/**
	 * Create area to display cards
	 * @param l
	 * @param bp
	 * @param bi
	 */
	private void createImageSpace(JLabel l, boolean bp, BufferedImage bi)
	{
		if(bp == true)
		{
			l = new JLabel(new ImageIcon(bi));
		}
		
		l.setMinimumSize(dim1);
		l.setPreferredSize(dim1);
		l.setMaximumSize(dim1);
		l.setHorizontalAlignment(JLabel.CENTER);
		l.setBorder(new LineBorder(Color.BLACK));
		cardPanel.add(l);
		cardPanel.add(Box.createHorizontalStrut(50));
	}
}