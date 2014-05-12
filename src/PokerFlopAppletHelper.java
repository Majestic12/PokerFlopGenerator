import javax.swing.RootPaneContainer;

/**
 * Helper class for applet
 * @author ashishbillava
 * 
 */
public class PokerFlopAppletHelper
{
	private PokerPanel pPanel;
	
	public PokerFlopAppletHelper(RootPaneContainer c)
	{
		c.getContentPane().setSize(900, 700);
		
		pPanel = new PokerPanel();
		c.getContentPane().add(pPanel);
		
		c.getContentPane().setVisible(true);
	}
}