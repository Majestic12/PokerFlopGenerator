import javax.swing.JFrame;

/**
 * POKER FLOP APP
 * @author ashishbillava
 * @copyright 2013
 */
@SuppressWarnings("serial")
public class PokerFlopApp extends JFrame
{
	private PokerPanel pPanel;
	
	public PokerFlopApp(String title)
	{
		super(title);
		setSize(900, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pPanel = new PokerPanel();
		this.add(pPanel);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		PokerFlopApp pokerFlop = new PokerFlopApp("Poker Flop Generator");
	}
}