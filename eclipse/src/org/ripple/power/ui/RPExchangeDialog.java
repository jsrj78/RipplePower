package org.ripple.power.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.json.JSONObject;
import org.ripple.power.config.LSystem;
import org.ripple.power.config.Session;
import org.ripple.power.helper.HelperWindow;
import org.ripple.power.hft.TraderProcess;
import org.ripple.power.i18n.LangConfig;
import org.ripple.power.txns.AccountFind;
import org.ripple.power.txns.AccountInfo;
import org.ripple.power.txns.AccountLine;
import org.ripple.power.txns.BookOffer;
import org.ripple.power.txns.CurrencyUtils;
import org.ripple.power.txns.Gateway;
import org.ripple.power.txns.IssuedCurrency;
import org.ripple.power.txns.OfferCancel;
import org.ripple.power.txns.OfferCreate;
import org.ripple.power.txns.OfferPrice;
import org.ripple.power.txns.OtherData;
import org.ripple.power.txns.Rollback;
import org.ripple.power.txns.OfferPrice.OfferFruit;
import org.ripple.power.txns.Updateable;
import org.ripple.power.ui.graphics.LColor;
import org.ripple.power.utils.StringUtils;
import org.ripple.power.utils.SwingUtils;
import org.ripple.power.wallet.WalletItem;

import com.other.calc.Calc;
import com.ripple.core.types.known.sle.entries.Offer;

public class RPExchangeDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// default only the first 20 data show
	private static final int _LIMIT_PAGE = 20;
	// automated trading processor
	private TraderProcess _traderProcess = new TraderProcess();
	private TraderProcess.Trend lastTrend = TraderProcess.Trend.UNKOWN;
	private ArrayList<OfferFruit> _buyerList = new ArrayList<OfferFruit>(100);
	private ArrayList<OfferFruit> _sellerList = new ArrayList<OfferFruit>(100);
	private RPCButton _okButton;
	private RPCButton _setautoButton;
	private RPCButton _startautobutton;
	private RPCButton _autoexButton;
	private RPCButton _historyButton;
	private RPCButton _oksellButton;
	private RPCButton _okbuyButton;
	private RPCButton _editHFTButton;
	private RPCButton _autoHFTButton;
	private RPCButton _exitButton;
	private RPCButton _calcButton;
	private RPCButton _stopautonButton;
	private RPCButton _canceltradingButton;
	private RPComboBox _curComboBox;
	private RPComboBox _selectGateawyCombobox;
	private RPLabel _currencyLabel;
	private RPLabel _mysellLabel;
	private RPLabel _coinmarketcapLabel;
	private RPLabel _mytradingLabel;
	private RPLabel _tip1Label;
	private RPLabel _gatewayLabel;
	private RPLabel _buymLabel;
	private RPLabel _sellmLabel;
	private RPLabel _cansellLabel;
	private RPLabel _canbuyLabel;
	private RPLabel _mybuyLabel;
	private RPList _mytradingList;
	private RPList _buymList;
	private RPList _sellmList;
	private RPList _otherMarketList;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private RPCheckBox _priceTipCheckBox;
	private RPTextBox _cansellText;
	private RPTextBox _canbuyText;
	private RPTextBox _mybuyText;
	private RPTextBox _mysellText;
	private RPTextBox _addressText;
	private WalletItem _item;
	private final AccountInfo _info = new AccountInfo();

	private void warning_noselect() {
		RPMessage.showWarningMessage(this, "Info", "请首先确定您要进行交易的网关与币种");
	}

	private void warning_xrp() {
		RPMessage.showWarningMessage(RPExchangeDialog.this, "Warning",
				"XRP数量不足, 交易无法成立");
	}

	private void warning_iou(String cur) {
		RPMessage.showWarningMessage(RPExchangeDialog.this, "Warning", cur
				+ "数量不足, 交易无法成立");
	}

	private void warning_trust(String mes) {
		RPMessage.showWarningMessage(RPExchangeDialog.this, "Warning", mes
				+ "在您账户中缺少信任,请信任后再使用");
	}

	private void empty_trading(String mes) {
		RPMessage.showWarningMessage(LSystem.applicationMain, "Info",
				String.format("很抱歉，目前没有任何人对%s的交易挂单", mes));
	}

	private int cancel_trust(String mes) {
		return RPMessage.showConfirmMessage(RPExchangeDialog.this, "Info",
				"您是否准备消除交易记录" + mes, new Object[] { "确定", "取消" });
	}

	private String info_price() {
		return LangConfig
				.get(RPExchangeDialog.this, "tip1",
						"The highest price buyer %s, the seller highest price %s, Spread %s");
	}

	private int info_swap(final String srcAmount, final String srcCurrency,
			final String dstAmount, final String dstCurrency) {
		if (_priceTipCheckBox.isSelected()) {
			Updateable update = new Updateable() {

				@Override
				public void action(Object o) {
					RPBubbleDialog.pop(
							"场外汇率提示:"
									+ srcAmount
									+ "/"
									+ srcCurrency
									+ ", 平均可换取"
									+ OfferPrice.getMoneyConvert(srcAmount,
											srcCurrency, dstCurrency) + "/"
									+ dstCurrency, true);
				}
			};
			LSystem.postThread(update);
		}
		return RPMessage
				.showConfirmMessage(RPExchangeDialog.this, "Info", "您准备用"
						+ srcAmount + "/" + srcCurrency + "换取" + dstAmount
						+ "/" + dstCurrency + ",是否确认交易?", new Object[] { "确定",
						"取消" });

	}

	private HashMap<Integer, RPExchangeInputDialog> inputs = new HashMap<Integer, RPExchangeInputDialog>();

	class InputMouselstener implements MouseListener {

		int flag;

		int type;

		public InputMouselstener(int flag, int type) {
			this.flag = flag;
			this.type = type;
		}

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (_priceTipCheckBox.isSelected()) {
				String cur = ((String) _curComboBox.getSelectedItem()).trim();
				String[] split = StringUtils.split(cur, "/");

				RPExchangeInputDialog dialog = inputs.get(flag);
				if (dialog == null) {
					dialog = RPExchangeInputDialog.showDialog(
							RPExchangeDialog.this, LangConfig.get(
									RPExchangeInputDialog.class, "ppt",
									"Price prompt"));
					inputs.put(flag, dialog);
				}
				RPTextBox textBox = (RPTextBox) e.getSource();
				String curName = split[0];
				switch (type) {
				case 0:
					curName = split[0];
					break;
				case 1:
					curName = split[1];
					break;
				}
				dialog.setTextContext(textBox, curName);
				if (!dialog.isVisible()) {
					dialog.setVisible(true);
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}

	}

	public class MyKeyListener implements KeyListener {

		int flag;

		public MyKeyListener(int flag) {
			this.flag = flag;
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {
			String cur = ((String) _curComboBox.getSelectedItem()).trim();
			String[] split = StringUtils.split(cur, "/");
			RPTextBox textBox = (RPTextBox) e.getSource();
			String text = textBox.getText().trim();
			String curName = split[0];
			switch (flag) {
			case 0:
				curName = split[0];
				checkText(text, curName, textBox);
				break;
			case 1:
				curName = split[1];
				checkText(text, curName, textBox);
				break;
			}
		}
	}

	public static RPExchangeDialog showDialog(String text, JFrame parent,
			final WalletItem item) {
		RPExchangeDialog dialog = new RPExchangeDialog(text, parent, item);
		dialog.pack();
		dialog.setLocationRelativeTo(parent);
		dialog.setVisible(true);
		return dialog;
	}

	public RPExchangeDialog(String text, JFrame parent, final WalletItem item) {
		super(parent, text, false);
		this._item = item;
		if (_item != null) {
			_item.setTip(false);
		}
		this.setResizable(false);
		Dimension dim = new Dimension(992, 620);
		this.setPreferredSize(dim);
		this.setSize(dim);
		this.initComponents();
	}

	private void initComponents() {
		_currencyLabel = new RPLabel();
		_curComboBox = new RPComboBox();
		_okButton = new RPCButton();
		jPanel1 = new javax.swing.JPanel();
		_mytradingLabel = new RPLabel();
		_tip1Label = new RPLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		_mytradingList = new RPList();
		_buymLabel = new RPLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		_buymList = new RPList();
		_sellmLabel = new RPLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		_sellmList = new RPList();
		_coinmarketcapLabel = new RPLabel();
		jScrollPane4 = new javax.swing.JScrollPane();
		_otherMarketList = new RPList();
		_gatewayLabel = new RPLabel();
		_selectGateawyCombobox = new RPComboBox();
		jPanel2 = new javax.swing.JPanel();
		_cansellLabel = new RPLabel();
		_cansellText = new RPTextBox();
		_canbuyLabel = new RPLabel();
		_canbuyText = new RPTextBox();
		_oksellButton = new RPCButton();
		_mybuyLabel = new RPLabel();
		_mybuyText = new RPTextBox();
		_mysellLabel = new RPLabel();
		_mysellText = new RPTextBox();
		_okbuyButton = new RPCButton();
		_stopautonButton = new RPCButton();
		_canceltradingButton = new RPCButton();
		_setautoButton = new RPCButton();
		_startautobutton = new RPCButton();
		_editHFTButton = new RPCButton();
		_autoHFTButton = new RPCButton();
		_exitButton = new RPCButton();
		_calcButton = new RPCButton();
		_autoexButton = new RPCButton();
		_addressText = new RPTextBox();
		_historyButton = new RPCButton();
		_priceTipCheckBox = new RPCheckBox();

		Font font = new Font(LangConfig.fontName, 0, 18);
		Font font14 = new Font(LangConfig.fontName, 0, 14);

		getContentPane().setLayout(null);

		_priceTipCheckBox.setText(LangConfig.get(this, "ppt", "Price prompt"));
		_priceTipCheckBox.setSelected(LSystem.session("system").getBoolean(
				"exchange_price_tip"));
		_priceTipCheckBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						Session session = LSystem.session("system");
						if (_priceTipCheckBox.isSelected()) {
							session.set("exchange_price_tip", true);
						} else {
							session.set("exchange_price_tip", false);
						}
						session.save();
					}
				});
		jPanel2.add(_priceTipCheckBox);
		_priceTipCheckBox.setBounds(858, 50, 110, 23);
		_priceTipCheckBox.setFont(font14);
		_priceTipCheckBox.setBackground(new LColor(51, 51, 51));

		_currencyLabel.setFont(font); // NOI18N
		_currencyLabel.setText(LangConfig.get(this, "selcur", "Currency"));
		getContentPane().add(_currencyLabel);
		_currencyLabel.setBounds(700, 10, 80, 26);

		_curComboBox.setFont(font); // NOI18N

		getContentPane().add(_curComboBox);
		_curComboBox.setBounds(780, 10, 110, 30);

		// 此处会列出网关所有可能的币种交易，所以不允许自行修改
		_curComboBox.setEditable(false);

		_okButton.setText(LangConfig.get(this, "ok", "OK"));
		_okButton.setFont(font);
		getContentPane().add(_okButton);
		_okButton.setBounds(900, 10, 80, 30);
		_okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// call
				submitOK();
			}
		});
		jPanel1.setBackground(new LColor(51, 51, 51));
		jPanel1.setLayout(null);

		_mytradingLabel.setFont(font14); // NOI18N
		_mytradingLabel.setForeground(new LColor(255, 255, 255));
		_mytradingLabel.setText(LangConfig
				.get(this, "my_trading", "My trading"));
		jPanel1.add(_mytradingLabel);
		_mytradingLabel.setBounds(380, 185, 210, 18);

		_tip1Label.setFont(font14);
		_tip1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		_tip1Label.setText(String.format(info_price(), 0, 0, 0));
		jPanel1.add(_tip1Label);
		_tip1Label.setBounds(0, 10, 970, 20);
		_tip1Label.setForeground(LColor.red);

		jScrollPane1.setViewportView(_mytradingList);

		if (_item != null) {
			updateMyTrading();
		}

		jPanel1.add(jScrollPane1);
		jScrollPane1.setBounds(380, 210, 210, 110);

		_buymLabel.setFont(font14); // NOI18N
		_buymLabel.setForeground(new LColor(255, 255, 255));
		_buymLabel.setText(LangConfig.get(this, "bm", "Buyer's Market"));
		jPanel1.add(_buymLabel);
		_buymLabel.setBounds(10, 45, 360, 16);

		_buymList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		_buymList.setBackground(new LColor(70, 70, 70));
		_buymList.setForeground(LColor.orange);
		_buymList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				RPList list = (RPList) e.getSource();
				int idx = list.getSelectedIndex();
				listsetforeground(list, idx);

				synchronized (_buyerList) {
					if (_buyerList.size() > 0 && idx < _buyerList.size()) {
						_mysellText.setText(_buyerList.get(idx).offer
								.takerPays().toText());
						_cansellText.setText(_buyerList.get(idx).offer
								.takerGets().toText());
					}
				}
			}
		});
		jScrollPane2.setViewportView(_buymList);
		_buymList.setCellRenderer(new HtmlRenderer());
		jPanel1.add(jScrollPane2);
		jScrollPane2.setBounds(10, 70, 360, 250);

		_sellmLabel.setFont(font14); // NOI18N
		_sellmLabel.setForeground(new LColor(255, 255, 255));
		_sellmLabel.setText(LangConfig.get(this, "sm", "Seller's Market"));
		jPanel1.add(_sellmLabel);
		_sellmLabel.setBounds(600, 45, 360, 16);

		_sellmList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		_sellmList.setForeground(LColor.orange);
		_sellmList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				RPList list = (RPList) e.getSource();
				int idx = list.getSelectedIndex();
				listsetforeground(list, idx);

				synchronized (_sellerList) {
					if (_sellerList.size() > 0 && idx < _sellerList.size()) {
						_mybuyText.setText(_sellerList.get(idx).offer
								.takerPays().toText());
						_canbuyText.setText(_sellerList.get(idx).offer
								.takerGets().toText());
					}
				}
			}
		});
		_sellmList.setCellRenderer(new HtmlRenderer());
		jScrollPane3.setViewportView(_sellmList);

		jPanel1.add(jScrollPane3);
		jScrollPane3.setBounds(600, 70, 360, 250);

		_coinmarketcapLabel.setFont(font14); // NOI18N
		_coinmarketcapLabel.setForeground(new LColor(255, 255, 255));
		_coinmarketcapLabel.setText(LangConfig.get(this, "other_prices",
				"Other Prices") + "(coinmarketcap)");
		jPanel1.add(_coinmarketcapLabel);
		_coinmarketcapLabel.setBounds(380, 45, 210, 18);

		_otherMarketList.setCellRenderer(new HtmlRenderer());
		jScrollPane4.setViewportView(_otherMarketList);

		jPanel1.add(jScrollPane4);
		jScrollPane4.setBounds(380, 70, 210, 110);

		getContentPane().add(jPanel1);
		jPanel1.setBounds(10, 50, 970, 340);

		_gatewayLabel.setFont(font); // NOI18N
		_gatewayLabel.setText(LangConfig.get(this, "selgateway", "Gateway"));
		getContentPane().add(_gatewayLabel);
		_gatewayLabel.setBounds(10, 10, 95, 26);

		_selectGateawyCombobox.setFont(font); // NOI18N
		_selectGateawyCombobox.setItemModel(Gateway.gatewayList().toArray());
		getContentPane().add(_selectGateawyCombobox);
		_selectGateawyCombobox.setBounds(90, 10, 250, 30);
		_selectGateawyCombobox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getSource() instanceof RPComboBox) {
					callCur((String) e.getItem());
				}
			}
		});
		_selectGateawyCombobox.setSelectedIndex(0);
		if (_selectGateawyCombobox.getItemCount() > 0) {
			callCur((String) _selectGateawyCombobox.getSelectedItem());
		}
		jPanel2.setBackground(new LColor(51, 51, 51));
		jPanel2.setLayout(null);

		_cansellLabel.setFont(font14); // NOI18N
		_cansellLabel.setForeground(new LColor(255, 255, 255));
		_cansellLabel.setText(LangConfig.get(this, "cansell", "Can Sell"));
		jPanel2.add(_cansellLabel);
		_cansellLabel.setBounds(600, 50, 90, 20);

		Font font12 = new Font("Dialog", 0, 12);

		_cansellText.setText("0");
		_cansellText.setFont(font12);
		_cansellText.addKeyListener(new MyKeyListener(1));
		_cansellText.addMouseListener(new InputMouselstener(1, 1));
		jPanel2.add(_cansellText);
		_cansellText.setBounds(670, 50, 170, 20);

		_canbuyLabel.setFont(font14); // NOI18N
		_canbuyLabel.setForeground(new LColor(255, 255, 255));
		_canbuyLabel.setText(LangConfig.get(this, "canbuy", "Can Buy"));
		jPanel2.add(_canbuyLabel);
		_canbuyLabel.setBounds(10, 50, 90, 20);

		_canbuyText.setText("0");
		_canbuyText.setFont(font12);
		_canbuyText.addKeyListener(new MyKeyListener(0));
		_canbuyText.addMouseListener(new InputMouselstener(0, 0));
		jPanel2.add(_canbuyText);
		_canbuyText.setBounds(80, 50, 170, 21);

		_oksellButton.setText(LangConfig.get(this, "oksell", "Confirm Sell"));
		_oksellButton.setFont(font14);
		_oksellButton.setActionCommand("sell");
		_oksellButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				action_ok(e);
			}
		});

		jPanel2.add(_oksellButton);
		_oksellButton.setBounds(860, 10, 95, 23);

		_mybuyLabel.setFont(font14); // NOI18N
		_mybuyLabel.setForeground(new LColor(255, 255, 255));
		_mybuyLabel.setText(LangConfig.get(this, "mybuy", "My Buy"));
		jPanel2.add(_mybuyLabel);
		_mybuyLabel.setBounds(10, 10, 90, 20);

		_mybuyText.setText("0");
		_mybuyText.setFont(font12);
		jPanel2.add(_mybuyText);
		_mybuyText.setBounds(80, 10, 170, 21);
		_mybuyText.addKeyListener(new MyKeyListener(1));
		_mybuyText.addMouseListener(new InputMouselstener(0, 1));

		_mysellLabel.setFont(font14); // NOI18N
		_mysellLabel.setForeground(new LColor(255, 255, 255));
		_mysellLabel.setText(LangConfig.get(this, "mysell", "My Sell"));
		jPanel2.add(_mysellLabel);
		_mysellLabel.setBounds(600, 10, 90, 20);

		_mysellText.setText("0");
		_mysellText.setFont(font12);
		jPanel2.add(_mysellText);
		_mysellText.setBounds(670, 10, 170, 21);
		_mysellText.addKeyListener(new MyKeyListener(0));
		_mysellText.addMouseListener(new InputMouselstener(1, 0));

		_okbuyButton.setText(LangConfig.get(this, "okbuy", "Confirm Buy"));
		_okbuyButton.setActionCommand("buy");
		_okbuyButton.setFont(font14);
		jPanel2.add(_okbuyButton);
		_okbuyButton.setBounds(270, 10, 95, 23);
		_okbuyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				action_ok(e);

			}
		});

		_stopautonButton.setText(LangConfig.get(this, "stopauto",
				"Stop auto trading"));
		_stopautonButton.setFont(font14);
		jPanel2.add(_stopautonButton);
		_stopautonButton.setBounds(560, 90, 130, 23);

		_canceltradingButton.setText(LangConfig.get(this, "cancel",
				"Cancel Transaction"));
		_canceltradingButton.setFont(font14);
		jPanel2.add(_canceltradingButton);
		_canceltradingButton.setBounds(410, 10, 140, 23);
		_canceltradingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object o = _mytradingList.getSelectedValue();
				if (o instanceof BookOffer) {

					int result = cancel_trust(o.toString());

					if (result == 0) {
						BookOffer offer = (BookOffer) o;
						OfferCancel.set(_item.getSeed(), offer.sequence,
								LSystem.FEE, new Rollback() {

									@Override
									public void success(JSONObject res) {
										JSonLog.get().println(res.toString());
										updateMyTrading();
										submitOK();
									}

									@Override
									public void error(JSONObject res) {
										JSonLog.get().println(res.toString());

									}
								});
					}
				}
			}
		});

		_setautoButton.setText(LangConfig
				.get(this, "setauto", "Set auto trade"));
		_setautoButton.setFont(font14);
		jPanel2.add(_setautoButton);
		_setautoButton.setBounds(270, 90, 130, 23);

		_startautobutton.setText(LangConfig.get(this, "startauto",
				"Start auto trade"));
		_startautobutton.setFont(font14);
		jPanel2.add(_startautobutton);
		_startautobutton.setBounds(420, 90, 120, 23);

		getContentPane().add(jPanel2);
		jPanel2.setBounds(10, 400, 970, 130);

		_editHFTButton.setText(LangConfig
				.get(this, "editscript", "Edit Script"));
		_editHFTButton.setFont(font14);
		getContentPane().add(_editHFTButton);
		_editHFTButton.setBounds(10, 540, 130, 40);

		_autoHFTButton.setText(LangConfig.get(this, "startscript",
				"Start Script"));
		_autoHFTButton.setFont(font14);
		getContentPane().add(_autoHFTButton);
		_autoHFTButton.setBounds(150, 540, 140, 40);

		_exitButton.setText(LangConfig.get(this, "exit", "Exit"));
		_exitButton.setFont(font14);
		_exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (_item != null) {
					_item.setTip(false);
				}
				SwingUtils.close(RPExchangeDialog.this);
			}
		});
		getContentPane().add(_exitButton);
		_exitButton.setBounds(880, 540, 100, 40);

		_calcButton.setText(LangConfig.get(this, "calc", "Calc"));
		_calcButton.setFont(font14);
		_calcButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Calc.showDialog(RPExchangeDialog.this);
			}
		});
		getContentPane().add(_calcButton);
		_calcButton.setBounds(770, 540, 100, 40);

		_autoexButton.setText(LangConfig.get(this, "autoex", "Auto Exchange"));
		_autoexButton.setFont(font14);
		getContentPane().add(_autoexButton);
		_autoexButton.setBounds(440, 540, 130, 40);
		getContentPane().add(_addressText);
		_addressText.setBounds(360, 10, 330, 30);
		_addressText.setEnabled(false);

		_historyButton.setText(LangConfig.get(this, "chart", "Price Chart"));
		_historyButton.setFont(font14);
		getContentPane().add(_historyButton);
		_historyButton.setBounds(300, 540, 130, 40);
		_historyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RPChartsHistoryDialog.showDialog(RPExchangeDialog.this);
			}
		});

		if (_item == null) {
			_setautoButton.setEnabled(false);
			_startautobutton.setEnabled(false);
			_stopautonButton.setEnabled(false);
			_okbuyButton.setEnabled(false);
			_oksellButton.setEnabled(false);
			_canceltradingButton.setEnabled(false);
		}
		getContentPane().setBackground(LSystem.dialogbackground);
		addWindowListener(new windowListener());
		pack();
	}// </editor-fold>

	private void callCur(String name) {
		ArrayList<String> list = new ArrayList<String>(10);
		ArrayList<Gateway.Item> items = Gateway.getAddress(name).accounts;
		_addressText.setText(items.get(0).address);
		for (int i = 0; i < items.size(); i++) {
			list.addAll(items.get(i).currencies);
		}
		list.add(LSystem.nativeCurrency.toUpperCase());
		ArrayList<String> temp = new ArrayList<String>(100);
		int size = list.size();
		for (int j = 0; j < size; j++) {
			String a = list.get(j);
			for (int i = 0; i < size; i++) {
				String b = list.get(i);
				if (!a.equals(b)) {
					String result = b + "/" + a;
					if (!temp.contains(result)) {
						temp.add(result);
					}
					result = a + "/" + b;
					if (!temp.contains(result)) {
						temp.add(result);
					}
				}
			}
		}
		Collections.sort(temp);
		_curComboBox.setItemModel(temp.toArray());
		list.clear();
		list = null;
		temp.clear();
		temp = null;
	}

	private HashMap<String, Boolean> _flags = new HashMap<String, Boolean>(10);

	private synchronized void submitOK() {

		_tradeFlag = false;
		if (_tradeThread != null) {
			_tradeThread.interrupt();
			_tradeThread = null;
		}
		final String cur = (String) _curComboBox.getSelectedItem();
		final String[] split = StringUtils.split(cur, "/");
		if (split.length == 2) {
			repaint();
			getContentPane().repaint();
			final String address = _addressText.getText().trim();
			final WaitDialog dialog = WaitDialog
					.showDialog(RPExchangeDialog.this);
			OfferPrice.load(address, split[0], split[1], new OfferPrice() {

				@Override
				public void sell(Offer offer) {

				}

				@Override
				public void buy(Offer offer) {

				}

				@Override
				public void error(JSONObject obj) {
					dialog.closeDialog();
					/*
					 * if (obj != null) { JSonLog.get().println(obj.toString());
					 * }
					 */
				}

				@Override
				public void empty() {
					dialog.closeDialog();
					empty_trading(cur);

				}

				@Override
				public void complete(final ArrayList<OfferFruit> buys,
						final ArrayList<OfferFruit> sells,
						final OfferPrice price) {

					_tip1Label.setText(String.format(info_price(),
							price.highBuy, price.hightSell, price.spread));
					if (buys.size() > 0) {
						synchronized (_buyerList) {
							_buymList
									.setModel(new javax.swing.AbstractListModel<Object>() {
										private static final long serialVersionUID = 1L;

										public int getSize() {
											int size = buys.size();
											if (size > _LIMIT_PAGE) {
												return _LIMIT_PAGE;
											}
											return size;
										}

										public Object getElementAt(int i) {
											return buys.get(i);
										}
									});

							_buyerList.clear();
							_buyerList.addAll(buys);
							_mysellText.setText(_buyerList.get(0).offer
									.takerPays().toText());
							_cansellText.setText(_buyerList.get(0).offer
									.takerGets().toText());
							_buymLabel.setText(LangConfig.get(
									RPExchangeDialog.class, "bm",
									"Buyer's Market")
									+ " Count:" + buys.size());
						}
					}
					if (sells.size() > 0) {
						synchronized (_sellerList) {
							_sellmList
									.setModel(new javax.swing.AbstractListModel<Object>() {
										private static final long serialVersionUID = 1L;

										public int getSize() {
											int size = sells.size();
											if (size > _LIMIT_PAGE) {
												return _LIMIT_PAGE;
											}
											return size;
										}

										public Object getElementAt(int i) {
											return sells.get(i);
										}
									});

							_sellerList.clear();
							_sellerList.addAll(sells);
							_mybuyText.setText(_sellerList.get(0).offer
									.takerPays().toText());
							_canbuyText.setText(_sellerList.get(0).offer
									.takerGets().toText());
							_sellmLabel.setText(LangConfig.get(
									RPExchangeDialog.class, "sm",
									"Seller's Market")
									+ " Count:" + sells.size());
						}
					}
					dialog.closeDialog();
					_tradeFlag = true;
					loadTradingList(address, split);
					loadOtherMarketList(address, split);
					repaint();
					getContentPane().repaint();
					updateTrend(split[0]);
				}

			});

		}
	}

	private void updateTrend(String cur) {
		TraderProcess.Trend trend = _traderProcess.getTrend(cur, 18);
		if (lastTrend != trend) {
			RPToast.makeText(this,
					cur.toUpperCase() + "  price trend : " + trend)
					.display();
			lastTrend = trend;
		}
	}

	private void loadOtherMarketList(String address, String[] split) {
		String srcCurName = split[0];
		String dstCurName = split[1];
		OtherData.CoinmarketcapData cData = null;
		if ((srcCurName.equalsIgnoreCase("usd") && dstCurName
				.equalsIgnoreCase("btc"))
				|| (srcCurName.equalsIgnoreCase("btc") && dstCurName
						.equalsIgnoreCase("usd"))) {
			srcCurName = "usd";
			dstCurName = "btc";
		} else if ((srcCurName.equalsIgnoreCase(LSystem.nativeCurrency) && dstCurName
				.equalsIgnoreCase("usd"))
				|| (srcCurName.equalsIgnoreCase("usd") && dstCurName
						.equalsIgnoreCase(LSystem.nativeCurrency))) {
			srcCurName = "usd";
			dstCurName = LSystem.nativeCurrency;
		} else if ((srcCurName.equalsIgnoreCase(LSystem.nativeCurrency) && dstCurName
				.equalsIgnoreCase("btc"))
				|| (srcCurName.equalsIgnoreCase("btc") && dstCurName
						.equalsIgnoreCase(LSystem.nativeCurrency))) {
			srcCurName = "btc";
			dstCurName = LSystem.nativeCurrency;
		} else if ((srcCurName.equalsIgnoreCase(LSystem.nativeCurrency) && dstCurName
				.equalsIgnoreCase("cny"))
				|| (srcCurName.equalsIgnoreCase("cny") && dstCurName
						.equalsIgnoreCase(LSystem.nativeCurrency))) {
			srcCurName = "cny";
			dstCurName = LSystem.nativeCurrency;
		}
		try {
			cData = OtherData.getCoinmarketcapTo(srcCurName, dstCurName);
			if (cData == null) {
				cData = OtherData.getCoinmarketcapTo("usd", dstCurName);
			}
			if (cData == null) {
				cData = OtherData.getCoinmarketcapTo("usd", srcCurName);
			}
			if (cData == null) {
				String result = OfferPrice.getMoneyConvert("1", srcCurName,
						dstCurName);
				if (result != null && !"unkown".equals(result)) {
					final ArrayList<String> list = new ArrayList<String>(10);
					list.add("1/" + srcCurName + "<br>Swap<br>" + result + "/"
							+ dstCurName);
					_otherMarketList
							.setModel(new javax.swing.AbstractListModel<Object>() {
								private static final long serialVersionUID = 1L;

								public int getSize() {
									return list.size();
								}

								public Object getElementAt(int i) {
									return list.get(i);
								}
							});
					return;
				}
			}
			if (cData == null) {
				cData = OtherData.getCoinmarketcapTo("usd",
						LSystem.nativeCurrency);
			}
		} catch (Exception e) {
		}
		if (cData != null) {
			final ArrayList<String> list = new ArrayList<String>(10);
			list.add(cData.toHTMLString());
			_otherMarketList
					.setModel(new javax.swing.AbstractListModel<Object>() {
						private static final long serialVersionUID = 1L;

						public int getSize() {
							return list.size();
						}

						public Object getElementAt(int i) {
							return list.get(i);
						}
					});
		}

	}

	private void action_ok(ActionEvent e) {
		Object obj = e.getSource();
		if (obj instanceof RPCButton) {
			final String address = _addressText.getText().trim();
			RPCButton btn = (RPCButton) obj;
			String cur = ((String) _curComboBox.getSelectedItem()).trim();
			final String[] split = StringUtils.split(cur, "/");
			final String srcCurName = split[0];
			final String dstCurName = split[1];
			_info.lines.clear();
			_info.zero_lines.clear();
			switch (btn.getActionCommand()) {
			case "buy":
				synchronized (_buyerList) {
					if (_buyerList.size() > 0) {
						if (_item != null) {
							checkTrade(address, _okbuyButton, new Updateable() {

								@Override
								public void action(Object o) {
									submitBuy(address, srcCurName, dstCurName,
											true);
								}
							});
						}
					} else {
						warning_noselect();
					}
				}
				break;
			case "sell":
				synchronized (_sellerList) {
					if (_sellerList.size() > 0) {
						checkTrade(address, _oksellButton, new Updateable() {

							@Override
							public void action(Object o) {
								submitSell(address, srcCurName, dstCurName,
										false);
							}
						});

					} else {
						warning_noselect();
					}
				}
				break;
			}

		}
	}

	private void submitBuy(final String address, final String srcCurName,
			final String dstCurName, final boolean flag) {
		String myBuytmp = _mybuyText.getText().trim();
		String canBuytmp = _canbuyText.getText().trim();
		int idx = myBuytmp.indexOf("/");
		myBuytmp = myBuytmp.substring(0, idx);
		idx = canBuytmp.indexOf("/");
		canBuytmp = canBuytmp.substring(0, idx);
		final String myBuy = myBuytmp;
		final String canBuy = canBuytmp;
		int result = info_swap(myBuy, dstCurName, canBuy, srcCurName);
		if (result == 0) {

			final WaitDialog dialog = WaitDialog
					.showDialog(RPExchangeDialog.this);
			final String myAddress = _item.getPublicKey();
			final Updateable updateable = new Updateable() {

				@Override
				public void action(Object o) {
					if (dstCurName.toLowerCase().equals(LSystem.nativeCurrency)) {
						double a = Double.parseDouble(_info.balance);
						double b = Double.parseDouble(myBuy);
						if (b > a) {
							dialog.closeDialog();
							warning_xrp();

							return;
						}
					} else {
						boolean dst = false;
						ArrayList<AccountLine> lines = new ArrayList<AccountLine>(
								100);
						lines.addAll(_info.lines);
						lines.addAll(_info.zero_lines);
						for (AccountLine line : lines) {
							if (line.getIssuer().equals(address)) {
								if (line.getCurrency().equals(dstCurName)) {
									dst = true;
									double a = Double.parseDouble(line
											.getAmount());
									double b = Double.parseDouble(myBuy);
									if (b > a) {
										dialog.closeDialog();
										warning_iou(dstCurName);

										return;
									}

								}
							}
						}
						if (!dst) {
							dialog.closeDialog();
							warning_trust(dstCurName);

							return;
						}

					}
					dialog.closeDialog();
					callTrade(address, dstCurName, srcCurName, myBuy, canBuy,
							flag);
				}
			};

			final AccountFind find = new AccountFind();

			find.processInfo(myAddress, _info, new Updateable() {

				@Override
				public void action(Object o) {
					find.processLines(myAddress, _info, updateable);
				}
			});

		}

	}

	private void submitSell(final String address, final String srcCurName,
			final String dstCurName, final boolean flag) {
		String mySelltmp = _mysellText.getText().trim();
		String canSelltmp = _cansellText.getText().trim();
		int idx = mySelltmp.indexOf("/");
		mySelltmp = mySelltmp.substring(0, idx);
		idx = canSelltmp.indexOf("/");
		canSelltmp = canSelltmp.substring(0, idx);
		final String mySell = mySelltmp;
		final String canSell = canSelltmp;
		int result = info_swap(mySell, srcCurName, canSell, dstCurName);
		if (result == 0) {

			final WaitDialog dialog = WaitDialog
					.showDialog(RPExchangeDialog.this);
			final String myAddress = _item.getPublicKey();
			final Updateable updateable = new Updateable() {

				@Override
				public void action(Object o) {

					if (srcCurName.toLowerCase().equals(LSystem.nativeCurrency)) {
						double a = Double.parseDouble(_info.balance);
						double b = Double.parseDouble(mySell);
						if (b > a) {
							dialog.closeDialog();
							warning_xrp();

							return;
						}
					} else {

						boolean src = false;

						ArrayList<AccountLine> lines = new ArrayList<AccountLine>(
								100);

						lines.addAll(_info.lines);
						lines.addAll(_info.zero_lines);
						for (AccountLine line : lines) {
							if (line.getIssuer().equals(address)) {
								if (line.getCurrency().equals(srcCurName)) {
									src = true;
									double a = Double.parseDouble(line
											.getAmount());
									double b = Double.parseDouble(mySell);
									if (b > a) {
										dialog.closeDialog();
										warning_iou(srcCurName);

										return;
									}

								}
							}
						}
						if (!src) {
							dialog.closeDialog();
							warning_trust(srcCurName);

							return;
						}

					}

					dialog.closeDialog();
					callTrade(address, dstCurName, srcCurName, mySell, canSell,
							flag);
				}
			};

			final AccountFind find = new AccountFind();

			find.processInfo(myAddress, _info, new Updateable() {

				@Override
				public void action(Object o) {
					find.processLines(myAddress, _info, updateable);
				}
			});

		}

	}

	private void callTrade(final String address, String dstCurName,
			String srcCurName, String pay, String get, boolean flag) {
		IssuedCurrency currencySrc = null;
		IssuedCurrency currencyDst = null;

		if (flag) {
			if (LSystem.nativeCurrency.equals(dstCurName.toLowerCase())) {
				currencySrc = new IssuedCurrency(
						CurrencyUtils.getValueToRipple(pay));
			} else {
				currencySrc = new IssuedCurrency(pay, address, dstCurName);
			}
			if (LSystem.nativeCurrency.equals(srcCurName.toLowerCase())) {
				currencyDst = new IssuedCurrency(
						CurrencyUtils.getValueToRipple(get));
			} else {
				currencyDst = new IssuedCurrency(get, address, srcCurName);
			}
		} else {
			if (LSystem.nativeCurrency.equals(dstCurName.toLowerCase())) {
				currencySrc = new IssuedCurrency(
						CurrencyUtils.getValueToRipple(get));
			} else {
				currencySrc = new IssuedCurrency(get, address, dstCurName);
			}
			if (LSystem.nativeCurrency.equals(srcCurName.toLowerCase())) {
				currencyDst = new IssuedCurrency(
						CurrencyUtils.getValueToRipple(pay));
			} else {
				currencyDst = new IssuedCurrency(pay, address, srcCurName);
			}
		}

		OfferCreate.set(_item.getSeed(), flag ? currencyDst : currencySrc,
				flag ? currencySrc : currencyDst, LSystem.FEE, new Rollback() {

					@Override
					public void success(JSONObject res) {
						JSonLog.get().println(res.toString());
						try {
							updateMyTrading();
							submitOK();
						} catch (Exception ex) {
						}
					}

					@Override
					public void error(JSONObject res) {
						JSonLog.get().println(res.toString());
					}
				});

	}

	private final static void checkText(String text, String curName,
			RPTextBox textbox) {
		String result = text;
		if (text.indexOf(curName) == -1) {
			int idx = text.indexOf("/");
			if (idx != -1) {
				text = text.substring(0, idx);
				result = text + "/" + curName;
			} else {
				char[] chars = text.toCharArray();
				StringBuffer sbr = new StringBuffer();
				for (int i = 0; i < chars.length; i++) {
					char c = chars[i];
					if ((c >= '0' && c <= '9') || c == '.') {
						sbr.append(c);
					}
				}
				result = sbr.toString() + "/" + curName;
			}
			if (result.startsWith("/")) {
				result = "0" + result;
			}
			if (!result.startsWith("0/")) {
				result = String.valueOf(new BigDecimal(result.split("/")[0]
						.trim()).toString()) + "/" + curName;
			}
			textbox.setText(result);
		}
	}

	private boolean closed;

	private class windowListener implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {
			HelperWindow.addObject(e.getSource());
		}

		@Override
		public void windowClosing(WindowEvent e) {
			closed = true;
			HelperWindow.removeObject(e.getSource());
		}

		@Override
		public void windowClosed(WindowEvent e) {
			if (_item != null) {
				_item.setTip(true);
			}
			closed = true;
			HelperWindow.removeObject(e.getSource());
		}

		@Override
		public void windowIconified(WindowEvent e) {

		}

		@Override
		public void windowDeiconified(WindowEvent e) {

		}

		@Override
		public void windowActivated(WindowEvent e) {

		}

		@Override
		public void windowDeactivated(WindowEvent e) {

		}

	}

	private void checkTrade(final String address, final RPCButton button,
			final Updateable update) {
		Object result = _flags.get(address);
		if (result == null || (!(boolean) result)) {

			AccountFind.getTrusts(_item.getPublicKey(), new Updateable() {
				@Override
				public void action(Object o) {
					if (o != null) {
						if (o instanceof ArrayList) {
							@SuppressWarnings("unchecked")
							final ArrayList<IssuedCurrency> lines = (ArrayList<IssuedCurrency>) o;
							boolean notfind = true;
							for (IssuedCurrency s : lines) {
								if (address.equals(s.issuer.toString())) {
									notfind = false;
									break;
								}
							}
							if (notfind) {
								warning_trust(address);
								// button.setEnabled(false);
								_flags.put(address, false);
							} else {
								_flags.put(address, true);
								if (update != null) {
									update.action(RPExchangeDialog.this);
								}
							}

						}
					}
				}
			});
		}
		if (result != null && ((boolean) result)) {
			if (update != null) {
				update.action(RPExchangeDialog.this);
			}
		}

	}

	private void updateMyTrading() {
		_info.bookOffers.clear();
		final AccountFind find = new AccountFind();
		find.processOfffer(_item.getPublicKey(), _info, new Updateable() {

			@Override
			public void action(Object o) {
				_mytradingList
						.setModel(new javax.swing.AbstractListModel<Object>() {

							/**
					 * 
					 */
							private static final long serialVersionUID = 1L;

							public int getSize() {
								return _info.bookOffers.size();
							}

							public Object getElementAt(int i) {
								return _info.bookOffers.get(i);
							}
						});
			}
		});
	}

	private Thread _tradeThread;

	private boolean _tradeFlag;

	private void updateTrading(final String address, final String src,
			final String dst) {

		OfferPrice.load(address, src, dst, new OfferPrice() {

			@Override
			public void sell(Offer offer) {

			}

			@Override
			public void buy(Offer offer) {

			}

			@Override
			public void error(JSONObject obj) {

			}

			@Override
			public void empty() {

			}

			@Override
			public void complete(final ArrayList<OfferFruit> buys,
					final ArrayList<OfferFruit> sells, final OfferPrice price) {

				if (sells.size() > 0) {
					synchronized (_sellerList) {
						_sellmList
								.setModel(new javax.swing.AbstractListModel<Object>() {
									private static final long serialVersionUID = 1L;

									public int getSize() {
										int size = sells.size();
										if (size > _LIMIT_PAGE) {
											return _LIMIT_PAGE;
										}
										return size;
									}

									public Object getElementAt(int i) {
										return sells.get(i);
									}
								});

						_sellerList.clear();
						_sellerList.addAll(sells);
						_sellmLabel.setText(LangConfig
								.get(RPExchangeDialog.class, "sm",
										"Seller's Market")
								+ " Count:" + sells.size());
					}
				}
				if (buys.size() > 0) {
					synchronized (_buyerList) {
						_buymList
								.setModel(new javax.swing.AbstractListModel<Object>() {
									private static final long serialVersionUID = 1L;

									public int getSize() {
										int size = buys.size();
										if (size > _LIMIT_PAGE) {
											return _LIMIT_PAGE;
										}
										return size;
									}

									public Object getElementAt(int i) {
										return buys.get(i);
									}
								});

						_buyerList.clear();
						_buyerList.addAll(buys);
						_buymLabel.setText(LangConfig.get(
								RPExchangeDialog.class, "bm", "Buyer's Market")
								+ " Count:" + buys.size());
					}
				}

				_tip1Label.setText(String.format(info_price(), price.highBuy,
						price.hightSell, price.spread));
			}

		});
	}

	private void loadTradingList(final String address, final String[] split) {
		if (!_tradeFlag) {
			return;
		}
		/*
		 * if (_item == null) { return; }
		 */
		Updateable update = new Updateable() {

			@Override
			public void action(Object o) {
				for (; !closed && _tradeFlag;) {
					updateTrading(address, split[0], split[1]);
					loadOtherMarketList(address, split);
					updateTrend(split[0]);
					try {
						Thread.sleep(LSystem.SECOND * 10);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		_tradeThread = LSystem.postThread(update);

	}

	public void listsetforeground(RPList jlist, int k) {
		jlist.setSelectedIndex(k);
		jlist.setSelectionForeground(new LColor(53, 104, 195));
		jlist.setSelectionBackground(new LColor(0, 0, 0));
	}

	public void listgetunsupported(RPList jlist, int k) {
		jlist.setSelectedIndex(k);
		jlist.setSelectionForeground(new LColor(250, 250, 0));
		jlist.setSelectionBackground(new LColor(128, 128, 128));
	}
}
