import javax.swing.JApplet;

/**
 * POKER FLOP APPLET - FOR WEB EMBBED
 * @author ashishbillava
 * @copyright 2013
 */
@SuppressWarnings("serial")
public class PokerFlopApplet extends JApplet
{
	public void init()
	{
		@SuppressWarnings("unused")
		PokerFlopAppletHelper pokerFlop = new PokerFlopAppletHelper(this);
		this.setName("POKER FLOP APPLET");
		this.setSize(900, 700);
	}
	
	public void stop()
	{
		
	}
}
