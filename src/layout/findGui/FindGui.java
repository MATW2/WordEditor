package layout.findGui;

import layout.AbstractAppLayout;

import javax.swing.*;

public class FindGui extends AbstractFindGui {
    public FindGui(AbstractAppLayout appLayout) {
        super(appLayout);
        initWindow();
        icon();
        addedToPanel();
    }

    @Override
    public void initWindow() {
        setTitle("Znajdż i zamień");
        setSize(392, 180);
        setLocationRelativeTo(appLayout);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        init();
        new FindGuiStyle(this);
    }

    private void init() {
        findLabel = new JLabel("Znajdż:");
        replaceLabel = new JLabel("Zamień:");
        findTextField = new JTextField(30);
        replaceTextField = new JTextField(30);
        findButton = new JButton("Znajdż pierwszy");
        findNextButton = new JButton("Znajdż następny");
        replaceButton = new JButton("Zamień");
        replaceAllButton = new JButton("Zamień wszystko");
        cancelButton = new JButton("Anuluj");
    }

    private void addedToPanel() {
        setLayout(null);
        findLabel.setBounds(10, 10, 80, 20);
        add(findLabel);
        findTextField.setBounds(90, 10, 120, 20);
        add(findTextField);
        replaceLabel.setBounds(10, 40, 80, 20);
        add(replaceLabel);
        replaceTextField.setBounds(90, 40, 120, 20);
        add(replaceTextField);

        findButton.setBounds(225, 6, 145, 20);
        add(findButton);

        findNextButton.setBounds(225, 33, 145, 20);
        add(findNextButton);

        replaceButton.setBounds(225, 60, 145, 20);
        add(replaceButton);

        replaceAllButton.setBounds(225, 87, 145, 20);
        add(replaceAllButton);

        cancelButton.setBounds(225, 114, 145, 20);
        add(cancelButton);
    }

    private void icon() {
        ImageIcon logo;
        try {
            logo = new ImageIcon(ClassLoader.getSystemResource("icon/Logo.png"));
        } catch (Exception ex) {
            logo = new ImageIcon(ClassLoader.getSystemResource(""));
        }
        setIconImage(logo.getImage());
    }
}