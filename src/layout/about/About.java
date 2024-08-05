package layout.about;

import layout.AbstractAppLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class About extends AbstractAbout {

    public About(AbstractAppLayout appLayout) {
        super(appLayout);
        initWindow();
        icon();
        style();
    }

    @Override
    public void initWindow() {
        setTitle("Informacje o projekcie");
        setSize(392, 200);
        setLocationRelativeTo(appLayout);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        init();
        addedToPanel();
    }

    private void init() {
        nameProjectPanel = new JPanel(new FlowLayout());
        infoPanel = new JPanel(new GridLayout(1, 2));
        nameProjectLabel = new JLabel("<html><h1>WordEditor</h1></html>");
        descriptionLabel = new JLabel("<html>Projekt został opracowany w celu doskonalenia umiejętności programowania w języku Java na kierunku Programista Aplikacji Biznesowych</html>");
        authorLabel = new JLabel("Autor: Mateusz Wąsowski");
        versionLabel = new JLabel("Wersja: 1.0.0 Beta");
    }

    private void style() {
        descriptionLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        infoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    private void addedToPanel() {
        nameProjectPanel.add(nameProjectLabel);
        infoPanel.add(authorLabel);
        infoPanel.add(versionLabel);

        getContentPane().add(nameProjectPanel, BorderLayout.NORTH);
        getContentPane().add(descriptionLabel, BorderLayout.CENTER);
        getContentPane().add(infoPanel, BorderLayout.SOUTH);
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