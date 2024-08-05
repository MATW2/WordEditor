package layout.header;


import Interfaces.IIconScale;

import javax.swing.*;
import java.awt.*;

public class Header extends AbstractHeader {
    private IIconScale iconScale;

    public IIconScale getIconScale() {
        return iconScale;
    }

    public void setIconScale(IIconScale iconScale) {
        this.iconScale = iconScale;
    }

    public Header(IIconScale iconScale) {
        super();
        this.iconScale = iconScale;
        init();
        mainHeader();
        wraper();
        storage();
        font();
        paragraph();
        textGroup();
        edit();
        insert();
    }

    private void init() {
        mainHeaderPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        wraperPanel = new JPanel(new GridBagLayout());
        storagePanel = new JPanel(new GridBagLayout());
        fontPanel = new JPanel(new GridBagLayout());
        paragraphPanel = new JPanel(new GridBagLayout());
        editPanel = new JPanel(new GridBagLayout());
        insertTimePanel = new JPanel(new GridBagLayout());
        groupTextPanel = new JPanel(new GridBagLayout());

        copyButton = new JButton("Kopiuj", iconScale.scaleIcon("Copy.png", 30, 30));
        pastButton = new JButton("Wklej", iconScale.scaleIcon("Past.png", 30, 30));
        cutButton = new JButton("Wytnij", iconScale.scaleIcon("Cut.png", 30, 30));
        replaceButton = new JButton("Zamień", iconScale.scaleIcon("Replace.png", 30, 30));

        boldButton = new JButton(iconScale.scaleIcon("Bold.png", 30, 30));
        italicButton = new JButton(iconScale.scaleIcon("Italic.png", 30, 30));
        underlineButton = new JButton(iconScale.scaleIcon("Underline.png", 30, 30));
        strikeButton = new JButton(iconScale.scaleIcon("Strike.png", 30, 30));
        superscriptButton = new JButton(iconScale.scaleIcon("Superscript.png", 30, 30));
        subscriptButton = new JButton(iconScale.scaleIcon("Subscript.png", 30, 30));
        textColorButton = new JButton(iconScale.scaleIcon("TextColor.png", 30, 30));
        textBackgroundColorButton = new JButton(iconScale.scaleIcon("Marker.png", 30, 30));

        leftAlignmentButton = new JButton(iconScale.scaleIcon("LeftAlignment.png", 30, 30));
        rightAlignmentButton = new JButton(iconScale.scaleIcon("RightAlignment.png", 30, 30));
        leftAlignButton = new JButton(iconScale.scaleIcon("LeftAlign.png", 30, 30));
        centerAlignButton = new JButton(iconScale.scaleIcon("CenterAlign.png", 30, 30));
        rightAlignButton = new JButton(iconScale.scaleIcon("RightAlign.png", 30, 30));
        justificationButton = new JButton(iconScale.scaleIcon("Justification.png", 30, 30));

        searchButton = new JButton("Wyszukaj", iconScale.scaleIcon("Search.png", 30, 30));
        selectAllButton = new JButton("Zaznacz wszystko", iconScale.scaleIcon("SelectAll.png", 30, 30));

        timeButton = new JButton(iconScale.scaleIcon("Time.png", 30, 30));

        fontList = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontSizeList = new String[]{"8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72"};
        lineSpacingList = new String[]{"1", "1.15", "1.5", "2"};

        fontComboBox = new JComboBox<>(fontList);
        sizeFontComboBox = new JComboBox<>(fontSizeList);
        sizeFontComboBox.setSelectedItem("12");
        lineSpacingComboBox = new JComboBox<>(lineSpacingList);

        dateAndTimeLabel = new JLabel();

        new HeaderStyle(this);
    }

    private void mainHeader() {
        mainHeaderPanel.add(wraperPanel);
    }

    private void wraper() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 10, 0, 30);
        gbc.fill = GridBagConstraints.VERTICAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        wraperPanel.add(storagePanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        wraperPanel.add(groupTextPanel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        wraperPanel.add(editPanel, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        wraperPanel.add(insertTimePanel, gbc);
    }

    private void storage() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        storagePanel.add(copyButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        storagePanel.add(pastButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        storagePanel.add(cutButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        storagePanel.add(replaceButton, gbc);
    }

    private void font() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        fontPanel.add(fontComboBox, gbc);

        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        fontPanel.add(sizeFontComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        fontPanel.add(boldButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        fontPanel.add(italicButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        fontPanel.add(underlineButton, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        fontPanel.add(strikeButton, gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        fontPanel.add(textColorButton, gbc);

        gbc.gridx = 5;
        gbc.gridy = 1;
        fontPanel.add(textBackgroundColorButton, gbc);

        gbc.gridx = 6;
        gbc.gridy = 1;
        fontPanel.add(subscriptButton, gbc);

        gbc.gridx = 7;
        gbc.gridy = 1;
        fontPanel.add(superscriptButton, gbc);
    }


    private void paragraph() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        paragraphPanel.add(leftAlignmentButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        paragraphPanel.add(rightAlignmentButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        paragraphPanel.add(lineSpacingComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        paragraphPanel.add(leftAlignButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        paragraphPanel.add(centerAlignButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        paragraphPanel.add(rightAlignButton, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        paragraphPanel.add(justificationButton, gbc);
    }

    private void textGroup() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 10, 0, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        groupTextPanel.add(fontPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        groupTextPanel.add(paragraphPanel, gbc);
    }

    private void edit() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        editPanel.add(searchButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        editPanel.add(selectAllButton, gbc);
    }

    private void insert() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 60, 5, 60);

        gbc.gridx = 0;
        gbc.gridy = 0;
        insertTimePanel.add(timeButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        insertTimePanel.add(dateAndTimeLabel, gbc);
    }

    @Override
    public JPanel addTomain() {
        return mainHeaderPanel;
    }
}
