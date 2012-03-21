import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

/*
 * Created by JFormDesigner on Fri May 13 23:00:33 EDT 2011
 */

/**
 * @author Kelvin Hernandez
 */
public class GamblerGUI extends JFrame {

	protected static final java.util.Random random = new java.util.Random();
	private static final long serialVersionUID = 1L;
	private final String[] flowers = new String[] { "Yellow", "Blue", "Red",
			"Orange", "Purple", "RYB" };
	private final Color[] colors = new Color[] { Color.yellow, Color.blue,
			Color.red, Color.orange, Color.magenta, Color.black };

	public GamblerGUI() {
		initComponents();
	}

	private String randomFlower() {
		final int rand = random(0, 7);
		return flowers[rand > 5 ? 5 : rand];
	}

	private Color getColor(final String flower) {
		for(int i = 0; i < flowers.length; i++)
			if(flowers[i].equals(flower))
				return colors[i];
		return Color.white;
	}

	public static int random(final int min, final int max) {
		final int n = Math.abs(max - min);
		return Math.min(min, max) + (n == 0 ? 0 : random.nextInt(n));
	}

	private void buttonRollActionPerformed(ActionEvent e) {
		if (labelInvalid.getText().equals("Place a bid")
				|| labelInvalid.getText().equals("Invalid bid"))
			return;
		final int dice1 = random(1, radioButtonSix.isSelected() ? 6 : 10);
		final int dice2 = random(1, radioButtonSix.isSelected() ? 6 : 10);
		final int number = radioButtonSix.isSelected() ? dice1 + dice2 : dice1 * dice2;
		final int bet = Integer.valueOf(textFieldBid.getText());
		labelRolled.setText(String.valueOf(number));
		final int min = radioButtonSix.isSelected() ? 6 : 60;
		final int profit = number >= min ? bet : -bet;
		labelProfit.setText(String.valueOf(profit));
	}

	private void buttonPlaceActionPerformed(ActionEvent e) {
		if (labelInvalid.getText().equals("Place a bid")
				|| labelInvalid.getText().equals("Invalid bid"))
			return;
		final String flowerPick = (String) comboBoxColor.getSelectedItem();
		final int bet = Integer.valueOf(textFieldBid.getText());
		final String flower = randomFlower();
		final int profit = flower.equals(flowerPick) ? bet : -bet;
		final Color color = getColor(flower);
		final Graphics2D g = (Graphics2D) panelAnwser.getGraphics();
		if(color.equals(Color.black)) {
			g.setColor(Color.red);
			g.fillRect(0, 0, 22, 20);
			g.setColor(Color.yellow);
			g.fillRect(21, 0, 22, 20);
			g.setColor(Color.blue);
			g.fillRect(42, 0, 22, 20);
		} else {
			g.setColor(color);
			g.fillRect(0, 0, 65, 60);
		}
		labelProfit.setText(String.valueOf(profit));
	}

	private void textFieldBidCaretUpdate(CaretEvent e) {
		final String s = textFieldBid.getText();
		try {
			final int i = Integer.valueOf(s);
			if (i == 0)
				labelInvalid.setText("Place a bid");
			else
				labelInvalid.setText("");
		} catch (Exception ex) {
			labelInvalid.setText("Invalid bid");
		}
		if (labelInvalid.getText().equals("Place a bid")
				|| labelInvalid.getText().equals("Invalid bid")) {
			buttonRoll.setEnabled(false);
			buttonPlace.setEnabled(false);
		} else {
			buttonRoll.setEnabled(true);
			buttonPlace.setEnabled(true);
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Kelvin Hernandez
		tabbedPane = new JTabbedPane();
		panelDice = new JPanel();
		radioButtonSix = new JRadioButton();
		radioButtonTen = new JRadioButton();
		labelRolledFixed = new JLabel();
		labelRolled = new JLabel();
		buttonRoll = new JButton();
		panelFlower = new JPanel();
		labelColor = new JLabel();
		comboBoxColor = new JComboBox();
		labelAnwser = new JLabel();
		panelAnwser = new JPanel();
		panel3 = new JPanel();
		buttonPlace = new JButton();
		panel1 = new JPanel();
		scrollPane1 = new JScrollPane();
		textPane1 = new JTextPane();
		panelProfit = new JPanel();
		labelBid = new JLabel();
		textFieldBid = new JTextField();
		labelInvalid = new JLabel();
		labelProfitFixed = new JLabel();
		labelProfit = new JLabel();

		// ======== this ========
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Runescape Gambler");
		setBackground(new Color(147, 77, 11));
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		// ======== tabbedPane ========
		{
			tabbedPane.setBackground(new Color(147, 77, 11));
			tabbedPane.setFont(tabbedPane.getFont().deriveFont(
					tabbedPane.getFont().getStyle() | Font.BOLD));

			// ======== panelDice ========
			{
				panelDice.setBackground(new Color(147, 77, 11));

				// JFormDesigner evaluation mark
				panelDice.setBorder(new javax.swing.border.CompoundBorder(
						new javax.swing.border.TitledBorder(
								new javax.swing.border.EmptyBorder(0, 0, 0, 0),
								"", javax.swing.border.TitledBorder.CENTER,
								javax.swing.border.TitledBorder.BOTTOM,
								new java.awt.Font("Dialog", java.awt.Font.BOLD,
										12), java.awt.Color.red), panelDice
								.getBorder()));
				panelDice
						.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
							public void propertyChange(
									java.beans.PropertyChangeEvent e) {
								if ("border".equals(e.getPropertyName()))
									throw new RuntimeException();
							}
						});

				panelDice.setLayout(new GridBagLayout());

				// ---- radioButtonSix ----
				radioButtonSix.setText("Two 6-sided dice");
				radioButtonSix.setBackground(new Color(147, 77, 11));
				radioButtonSix.setFont(radioButtonSix.getFont().deriveFont(
						radioButtonSix.getFont().getStyle() | Font.BOLD));
				panelDice.add(radioButtonSix, new GridBagConstraints(0, 0, 1,
						1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

				// ---- radioButtonTen ----
				radioButtonTen.setText("Two 10-sided dice");
				radioButtonTen.setSelected(true);
				radioButtonTen.setBackground(new Color(147, 77, 11));
				radioButtonTen.setFont(radioButtonTen.getFont().deriveFont(
						radioButtonTen.getFont().getStyle() | Font.BOLD));
				panelDice.add(radioButtonTen, new GridBagConstraints(0, 1, 1,
						1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

				// ---- labelRolledFixed ----
				labelRolledFixed.setText("Rolled:");
				labelRolledFixed.setFont(labelRolledFixed.getFont().deriveFont(
						labelRolledFixed.getFont().getStyle() | Font.BOLD));
				panelDice.add(labelRolledFixed, new GridBagConstraints(1, 0, 1,
						1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

				// ---- labelRolled ----
				labelRolled.setText("0");
				labelRolled.setHorizontalAlignment(SwingConstants.CENTER);
				labelRolled.setFont(labelRolled.getFont().deriveFont(
						labelRolled.getFont().getStyle() | Font.BOLD));
				panelDice.add(labelRolled, new GridBagConstraints(1, 1, 1, 1,
						0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

				// ---- buttonRoll ----
				buttonRoll.setText("Roll Dice");
				buttonRoll.setEnabled(false);
				buttonRoll.setBackground(new Color(147, 77, 11));
				buttonRoll.setFont(buttonRoll.getFont().deriveFont(
						buttonRoll.getFont().getStyle() | Font.BOLD));
				buttonRoll.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						buttonRollActionPerformed(e);
					}
				});
				panelDice.add(buttonRoll, new GridBagConstraints(0, 2, 2, 1,
						0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			}
			tabbedPane.addTab("Dice", panelDice);

			// ======== panelFlower ========
			{
				panelFlower.setBackground(new Color(147, 77, 11));
				panelFlower.setLayout(new GridBagLayout());

				// ---- labelColor ----
				labelColor.setText("Select a flower:");
				labelColor.setFont(labelColor.getFont().deriveFont(
						labelColor.getFont().getStyle() | Font.BOLD));
				panelFlower.add(labelColor, new GridBagConstraints(0, 0, 1, 1,
						0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

				// ---- comboBoxColor ----
				comboBoxColor.setModel(new DefaultComboBoxModel(new String[] {
						"Yellow", "Orange", "Blue", "Red", "Purple", "RYB" }));
				comboBoxColor.setBackground(new Color(147, 77, 11));
				comboBoxColor.setFont(comboBoxColor.getFont().deriveFont(
						comboBoxColor.getFont().getStyle() | Font.BOLD));
				panelFlower.add(comboBoxColor, new GridBagConstraints(1, 0, 1,
						1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

				// ---- labelAnwser ----
				labelAnwser.setText("Flower Planted:");
				labelAnwser.setFont(labelAnwser.getFont().deriveFont(
						labelAnwser.getFont().getStyle() | Font.BOLD));
				panelFlower.add(labelAnwser, new GridBagConstraints(0, 1, 1, 1,
						0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

				// ======== panelAnwser ========
				{
					panel3.setBackground(new Color(78, 30, 30));
					panel3.setBorder(new EmptyBorder(2, 3, 2, 3));
					panel3.setLayout(new BorderLayout());

					// ======== panelAnwser ========
					{
						panelAnwser.setBackground(new Color(110, 57, 8));
						panelAnwser.setLayout(null);

						{ // compute preferred size
							Dimension preferredSize = new Dimension();
							for (int i = 0; i < panel3.getComponentCount(); i++) {
								Rectangle bounds = panel3.getComponent(i)
										.getBounds();
								preferredSize.width = Math.max(bounds.x
										+ bounds.width, preferredSize.width);
								preferredSize.height = Math.max(bounds.y
										+ bounds.height, preferredSize.height);
							}
							Insets insets = panel3.getInsets();
							preferredSize.width += insets.right;
							preferredSize.height += insets.bottom;
							panelAnwser.setMinimumSize(preferredSize);
							panelAnwser.setPreferredSize(preferredSize);
						}
					}
					panel3.add(panelAnwser, BorderLayout.CENTER);
				}
				panelFlower.add(panel3, new GridBagConstraints(1, 1, 1, 1,
						0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

				// ---- buttonPlace ----
				buttonPlace.setText("Place Flower");
				buttonPlace.setEnabled(false);
				buttonPlace.setBackground(new Color(147, 77, 11));
				buttonPlace.setFont(buttonPlace.getFont().deriveFont(
						buttonPlace.getFont().getStyle() | Font.BOLD));
				buttonPlace.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						buttonPlaceActionPerformed(e);
						buttonPlaceActionPerformed(e);
					}
				});
				panelFlower.add(buttonPlace, new GridBagConstraints(0, 2, 2, 1,
						0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			}
			tabbedPane.addTab("Flower", panelFlower);

			// ======== panel1 ========
			{
				panel1.setBackground(new Color(147, 77, 11));
				panel1.setLayout(null);

				// ======== scrollPane1 ========
				{

					// ---- textPane1 ----
					textPane1
							.setText("Dice: If playing 2-10 dice then you must roll a 60 or above to win. Else, if playing 2-6 dice you must roll above a 6 to win.\n\nFlower: Just select a color, place a bid, and place the flower.");
					textPane1.setBackground(new Color(147, 77, 11));
					textPane1.setEditable(false);
					textPane1.setFont(textPane1.getFont().deriveFont(
							textPane1.getFont().getStyle() | Font.BOLD));
					scrollPane1.setViewportView(textPane1);
				}
				panel1.add(scrollPane1);
				scrollPane1.setBounds(5, 5, 240, 105);

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for (int i = 0; i < panel1.getComponentCount(); i++) {
						Rectangle bounds = panel1.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width,
								preferredSize.width);
						preferredSize.height = Math.max(bounds.y
								+ bounds.height, preferredSize.height);
					}
					Insets insets = panel1.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel1.setMinimumSize(preferredSize);
					panel1.setPreferredSize(preferredSize);
				}
			}
			tabbedPane.addTab("Rules", panel1);

		}
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		// ======== panelProfit ========
		{
			panelProfit.setForeground(new Color(147, 77, 11));
			panelProfit.setBackground(new Color(147, 77, 11));
			panelProfit.setLayout(new GridBagLayout());
			((GridBagLayout) panelProfit.getLayout()).columnWidths = new int[] {
					0, 0, 0, 0 };
			((GridBagLayout) panelProfit.getLayout()).rowHeights = new int[] {
					0, 0, 0, 0 };
			((GridBagLayout) panelProfit.getLayout()).columnWeights = new double[] {
					0.0, 0.0, 0.0, 1.0E-4 };
			((GridBagLayout) panelProfit.getLayout()).rowWeights = new double[] {
					0.0, 0.0, 0.0, 1.0E-4 };

			// ---- labelBid ----
			labelBid.setText("Place a bid:");
			labelBid.setFont(labelBid.getFont().deriveFont(
					labelBid.getFont().getStyle() | Font.BOLD));
			panelProfit.add(labelBid, new GridBagConstraints(0, 0, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- textFieldBid ----
			textFieldBid.setText("0");
			textFieldBid.setBackground(new Color(110, 57, 8));
			textFieldBid.addCaretListener(new CaretListener() {
				public void caretUpdate(CaretEvent e) {
					textFieldBidCaretUpdate(e);
					textFieldBidCaretUpdate(e);
				}
			});
			panelProfit.add(textFieldBid, new GridBagConstraints(1, 0, 1, 1,
					0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 70, 0));

			// ---- labelInvalid ----
			labelInvalid.setText("Place a bid");
			labelInvalid.setFont(labelInvalid.getFont().deriveFont(
					labelInvalid.getFont().getStyle() | Font.BOLD));
			panelProfit.add(labelInvalid, new GridBagConstraints(2, 0, 1, 1,
					0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

			// ---- labelProfitFixed ----
			labelProfitFixed.setText("Profit:");
			labelProfitFixed.setFont(labelProfitFixed.getFont().deriveFont(
					labelProfitFixed.getFont().getStyle() | Font.BOLD));
			panelProfit.add(labelProfitFixed, new GridBagConstraints(0, 1, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

			// ---- labelProfit ----
			labelProfit.setText("0");
			labelProfit.setBackground(new Color(110, 57, 8));
			panelProfit.add(labelProfit, new GridBagConstraints(1, 1, 2, 1,
					0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		}
		contentPane.add(panelProfit, BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(getOwner());
		this.setVisible(true);

		// ---- buttonGroup ----
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButtonSix);
		buttonGroup.add(radioButtonTen);
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Kelvin Hernandez
	private JTabbedPane tabbedPane;
	private JPanel panelDice;
	private JRadioButton radioButtonSix;
	private JRadioButton radioButtonTen;
	private JLabel labelRolledFixed;
	private JLabel labelRolled;
	private JButton buttonRoll;
	private JPanel panelFlower;
	private JLabel labelColor;
	private JComboBox comboBoxColor;
	private JLabel labelAnwser;
	private JPanel panelAnwser;
	private JPanel panel3;
	private JButton buttonPlace;
	private JPanel panel1;
	private JScrollPane scrollPane1;
	private JTextPane textPane1;
	private JPanel panelProfit;
	private JLabel labelBid;
	private JTextField textFieldBid;
	private JLabel labelInvalid;
	private JLabel labelProfitFixed;
	private JLabel labelProfit;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}