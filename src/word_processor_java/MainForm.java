/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word_processor_java;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.swing.Action;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.rtf.RTFEditorKit;

/**
 *
 * @author spatel7043
 */
public class MainForm extends javax.swing.JFrame {

    private final RTFEditorKit rtfKit = new RTFEditorKit();

    /**
     * Creates new form MainForm
     */
    JFileChooser fileDialog;
    File editFile;

    void uncheckAll() { //function unchecking all the font size check box
        changeFontSize8.setSelected(false);
        changeFontSize9.setSelected(false);
        changeFontSize10.setSelected(false);
        changeFontSize11.setSelected(false);
        changeFontSize12.setSelected(false);
        changeFontSize14.setSelected(false);
        changeFontSize16.setSelected(false);
        changeFontSize18.setSelected(false);
        changeFontSize20.setSelected(false);
        changeFontSize22.setSelected(false);
        changeFontSize24.setSelected(false);
        changeFontSize26.setSelected(false);
        changeFontSize28.setSelected(false);
        changeFontSize36.setSelected(false);
        changeFontSize48.setSelected(false);
        changeFontSize72.setSelected(false);
    }

    Color selectedColor;
    Action changeFontColorAction;

    public MainForm() {
        initComponents();

        textArea.setEditorKit(rtfKit); //setting editor kit to rtfKit
        selectedColor = Color.BLACK; //setting default colour in colour chooser to black

        Action boldAction = new StyledEditorKit.BoldAction();
        boldAction.putValue(Action.NAME, "Bold Text");
        bold.setAction(boldAction); //setting bold action to the bold menu item 

        Action underlineAction = new StyledEditorKit.UnderlineAction();
        underlineAction.putValue(Action.NAME, "Underline Text");
        underline.setAction(underlineAction); //setting underline action to the underline menu item

        Action italicizeAction = new StyledEditorKit.ItalicAction();
        italicizeAction.putValue(Action.NAME, "Italicize Text");
        italicize.setAction(italicizeAction); //setting italic action to the italicize menu item 

        Action copyAction = new StyledEditorKit.CopyAction();
        copyAction.putValue(Action.NAME, "Copy");
        copyOption.setAction(copyAction); //setting copy action to the copy menu item

        Action pasteAction = new StyledEditorKit.PasteAction();
        pasteAction.putValue(Action.NAME, "Paste");
        pasteOption.setAction(pasteAction); //setting paste action to the paste menu item

        Action cutAction = new StyledEditorKit.CutAction();
        cutAction.putValue(Action.NAME, "Cut");
        cutOption.setAction(cutAction); //setting cut action to the cut menu item

        Action changeFontToTimesAction = new StyledEditorKit.FontFamilyAction("Times New Roman",
                "Times New Roman");
        changeFontToTimesAction.putValue(Action.NAME, "Times New Roman");
        changeFontTimes.setAction(changeFontToTimesAction); //setting font change to Times New Roman action to corresponding menu item 

        Action changeFontToArialAction = new StyledEditorKit.FontFamilyAction("Arial", "Arial");
        changeFontToArialAction.putValue(Action.NAME, "Arial");
        changeFontArial.setAction(changeFontToArialAction); //setting font change to Arial action to corresponding menu item 

        Action changeFontToBradleyAction = new StyledEditorKit.FontFamilyAction("Bradley Hand ITC",
                "Bradley Hand ITC");
        changeFontToBradleyAction.putValue(Action.NAME, "Bradley Hand ITC");
        changeFontBradley.setAction(changeFontToBradleyAction); //setting font change to Bradley Hand ITC action to corresponding menu item 

        Action changeFontToCalibriAction = new StyledEditorKit.FontFamilyAction("Calibri", "Calibri");
        changeFontToCalibriAction.putValue(Action.NAME, "Calibri");
        changeFontCalibri.setAction(changeFontToCalibriAction); //setting font change to Calibri action to corresponding menu item 

        Action changeFontToChillerAction = new StyledEditorKit.FontFamilyAction("Chiller", "Chiller");
        changeFontToChillerAction.putValue(Action.NAME, "Chiller");
        changeFontChiller.setAction(changeFontToChillerAction); //setting font change to Chiller action to corresponding menu item 

        Action changeFontToComicSansAction = new StyledEditorKit.FontFamilyAction("Comic Sans MS",
                "Comic Sans MS");
        changeFontToComicSansAction.putValue(Action.NAME, "Comic Sans");
        changeFontComicSans.setAction(changeFontToComicSansAction); //setting font change to Comic Sans MS action to corresponding menu item 

        Action changeFontToCourierNewAction = new StyledEditorKit.FontFamilyAction("Courier New",
                "Courier New");
        changeFontToCourierNewAction.putValue(Action.NAME, "Courier New");
        changeFontCourierNew.setAction(changeFontToCourierNewAction); //setting font change to Courier New action to corresponding menu item 

        Action changeFontToOldEnglishTextAction = new StyledEditorKit.FontFamilyAction("Old English Text MT",
                "Old English Text MT");
        changeFontToOldEnglishTextAction.putValue(Action.NAME, "Old English Text");
        changeFontOldEnglishText.setAction(changeFontToOldEnglishTextAction); //setting font change to Old English Text MT action to 
        //corresponding menu item 

        Action changeFontToPalaceScriptAction = new StyledEditorKit.FontFamilyAction("Palace Script MT",
                "Palace Script MT");
        changeFontToPalaceScriptAction.putValue(Action.NAME, "Palace Script MT");
        changeFontPalaceScript.setAction(changeFontToPalaceScriptAction); //setting font change to Palace Script MT action to 
        //corresponding menu item 

        Action changeFontToRavieAction = new StyledEditorKit.FontFamilyAction("Ravie", "Ravie");
        changeFontToRavieAction.putValue(Action.NAME, "Ravie");
        changeFontRavie.setAction(changeFontToRavieAction); //setting font change to Ravie action to corresponding menu item 

        Action changeFontToVerdanaAction = new StyledEditorKit.FontFamilyAction("Verdana", "Verdana");
        changeFontToVerdanaAction.putValue(Action.NAME, "Verdana");
        changeFontVerdana.setAction(changeFontToVerdanaAction); //setting font change to Verdana action to corresponding menu item 

        Action changeFontSizeTo8 = new StyledEditorKit.FontSizeAction("", 8);
        changeFontSizeTo8.putValue(Action.NAME, "8");
        changeFontSize8.setAction(changeFontSizeTo8); //setting font size change to 8 action to corresponding menu item

        Action changeFontSizeTo9 = new StyledEditorKit.FontSizeAction("", 9);
        changeFontSizeTo9.putValue(Action.NAME, "9");
        changeFontSize9.setAction(changeFontSizeTo9); //setting font size change to 9 action to corresponding menu item

        Action changeFontSizeTo10 = new StyledEditorKit.FontSizeAction("", 10);
        changeFontSizeTo10.putValue(Action.NAME, "10");
        changeFontSize10.setAction(changeFontSizeTo10); //setting font size change to 10 action to corresponding menu item

        Action changeFontSizeTo11 = new StyledEditorKit.FontSizeAction("", 11);
        changeFontSizeTo11.putValue(Action.NAME, "11");
        changeFontSize11.setAction(changeFontSizeTo11); //setting font size change to 11 action to corresponding menu item

        Action changeFontSizeTo12 = new StyledEditorKit.FontSizeAction("", 12);
        changeFontSizeTo12.putValue(Action.NAME, "12");
        changeFontSize12.setAction(changeFontSizeTo12); //setting font size change to 12 action to corresponding menu item

        Action changeFontSizeTo14 = new StyledEditorKit.FontSizeAction("", 14);
        changeFontSizeTo14.putValue(Action.NAME, "14");
        changeFontSize14.setAction(changeFontSizeTo14); //setting font size change to 14 action to corresponding menu item

        Action changeFontSizeTo16 = new StyledEditorKit.FontSizeAction("", 16);
        changeFontSizeTo16.putValue(Action.NAME, "16");
        changeFontSize16.setAction(changeFontSizeTo16); //setting font size change to 16 action to corresponding menu item

        Action changeFontSizeTo18 = new StyledEditorKit.FontSizeAction("", 18);
        changeFontSizeTo18.putValue(Action.NAME, "18");
        changeFontSize18.setAction(changeFontSizeTo18); //setting font size change to 18 action to corresponding menu item

        Action changeFontSizeTo20 = new StyledEditorKit.FontSizeAction("", 20);
        changeFontSizeTo20.putValue(Action.NAME, "20");
        changeFontSize20.setAction(changeFontSizeTo20); //setting font size change to 20 action to corresponding menu item

        Action changeFontSizeTo22 = new StyledEditorKit.FontSizeAction("", 22);
        changeFontSizeTo22.putValue(Action.NAME, "22");
        changeFontSize22.setAction(changeFontSizeTo22); //setting font size change to 22 action to corresponding menu item

        Action changeFontSizeTo24 = new StyledEditorKit.FontSizeAction("", 24);
        changeFontSizeTo24.putValue(Action.NAME, "24");
        changeFontSize24.setAction(changeFontSizeTo24); //setting font size change to 24 action to corresponding menu item

        Action changeFontSizeTo26 = new StyledEditorKit.FontSizeAction("", 26);
        changeFontSizeTo26.putValue(Action.NAME, "26");
        changeFontSize26.setAction(changeFontSizeTo26); //setting font size change to 26 action to corresponding menu item

        Action changeFontSizeTo28 = new StyledEditorKit.FontSizeAction("", 28);
        changeFontSizeTo28.putValue(Action.NAME, "28");
        changeFontSize28.setAction(changeFontSizeTo28); //setting font size change to 28 action to corresponding menu item

        Action changeFontSizeTo36 = new StyledEditorKit.FontSizeAction("", 36);
        changeFontSizeTo36.putValue(Action.NAME, "36");
        changeFontSize36.setAction(changeFontSizeTo36); //setting font size change to 36 action to corresponding menu item

        Action changeFontSizeTo48 = new StyledEditorKit.FontSizeAction("", 48);
        changeFontSizeTo48.putValue(Action.NAME, "48");
        changeFontSize48.setAction(changeFontSizeTo48); //setting font size change to 48 action to corresponding menu item

        Action changeFontSizeTo72 = new StyledEditorKit.FontSizeAction("", 72);
        changeFontSizeTo72.putValue(Action.NAME, "72");
        changeFontSize72.setAction(changeFontSizeTo72); //setting font size change to 72 action to corresponding menu item
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelForPage = new javax.swing.JPanel();
        TheTextArea = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextPane();
        topMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        saveFile = new javax.swing.JMenuItem();
        openFile = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        fontChangeMenu = new javax.swing.JMenu();
        changeFontArial = new javax.swing.JMenuItem();
        changeFontBradley = new javax.swing.JMenuItem();
        changeFontCalibri = new javax.swing.JMenuItem();
        changeFontChiller = new javax.swing.JMenuItem();
        changeFontComicSans = new javax.swing.JMenuItem();
        changeFontCourierNew = new javax.swing.JMenuItem();
        changeFontOldEnglishText = new javax.swing.JMenuItem();
        changeFontPalaceScript = new javax.swing.JMenuItem();
        changeFontRavie = new javax.swing.JMenuItem();
        changeFontTimes = new javax.swing.JMenuItem();
        changeFontVerdana = new javax.swing.JMenuItem();
        changeFontSizeMenu = new javax.swing.JMenu();
        changeFontSize8 = new javax.swing.JCheckBoxMenuItem();
        changeFontSize9 = new javax.swing.JCheckBoxMenuItem();
        changeFontSize10 = new javax.swing.JCheckBoxMenuItem();
        changeFontSize11 = new javax.swing.JCheckBoxMenuItem();
        changeFontSize12 = new javax.swing.JCheckBoxMenuItem();
        changeFontSize14 = new javax.swing.JCheckBoxMenuItem();
        changeFontSize16 = new javax.swing.JCheckBoxMenuItem();
        changeFontSize18 = new javax.swing.JCheckBoxMenuItem();
        changeFontSize20 = new javax.swing.JCheckBoxMenuItem();
        changeFontSize22 = new javax.swing.JCheckBoxMenuItem();
        changeFontSize24 = new javax.swing.JCheckBoxMenuItem();
        changeFontSize26 = new javax.swing.JCheckBoxMenuItem();
        changeFontSize28 = new javax.swing.JCheckBoxMenuItem();
        changeFontSize36 = new javax.swing.JCheckBoxMenuItem();
        changeFontSize48 = new javax.swing.JCheckBoxMenuItem();
        changeFontSize72 = new javax.swing.JCheckBoxMenuItem();
        cutOption = new javax.swing.JMenuItem();
        copyOption = new javax.swing.JMenuItem();
        pasteOption = new javax.swing.JMenuItem();
        formatMenu = new javax.swing.JMenu();
        bold = new javax.swing.JMenuItem();
        italicize = new javax.swing.JMenuItem();
        fontChangeColour = new javax.swing.JMenuItem();
        underline = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 850));
        getContentPane().setLayout(new java.awt.FlowLayout());

        panelForPage.setBackground(new java.awt.Color(255, 255, 255));
        panelForPage.setFocusable(false);
        panelForPage.setPreferredSize(new java.awt.Dimension(575, 800));
        panelForPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TheTextArea.setViewportView(textArea);

        panelForPage.add(TheTextArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 435, 654));

        getContentPane().add(panelForPage);

        topMenuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        fileMenu.setText("File");

        saveFile.setText("Save Document");
        saveFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        fileMenu.add(saveFile);

        openFile.setText("Open a Document");
        openFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        fileMenu.add(openFile);

        topMenuBar.add(fileMenu);

        editMenu.setText("Edit");

        fontChangeMenu.setText("Change Font");

        changeFontArial.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        changeFontArial.setText("Arial");
        fontChangeMenu.add(changeFontArial);

        changeFontBradley.setFont(new java.awt.Font("Bradley Hand ITC", 0, 11)); // NOI18N
        changeFontBradley.setText("Bradley Hand ITC");
        changeFontBradley.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontBradleyActionPerformed(evt);
            }
        });
        fontChangeMenu.add(changeFontBradley);

        changeFontCalibri.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        changeFontCalibri.setText("Calibri");
        changeFontCalibri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontCalibriActionPerformed(evt);
            }
        });
        fontChangeMenu.add(changeFontCalibri);

        changeFontChiller.setFont(new java.awt.Font("Chiller", 0, 11)); // NOI18N
        changeFontChiller.setText("Chiller");
        fontChangeMenu.add(changeFontChiller);

        changeFontComicSans.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        changeFontComicSans.setText("Comic Sans");
        changeFontComicSans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontComicSansActionPerformed(evt);
            }
        });
        fontChangeMenu.add(changeFontComicSans);

        changeFontCourierNew.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        changeFontCourierNew.setText("Courier New");
        fontChangeMenu.add(changeFontCourierNew);

        changeFontOldEnglishText.setFont(new java.awt.Font("Old English Text MT", 0, 11)); // NOI18N
        changeFontOldEnglishText.setText("Old English Text");
        changeFontOldEnglishText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontOldEnglishTextActionPerformed(evt);
            }
        });
        fontChangeMenu.add(changeFontOldEnglishText);

        changeFontPalaceScript.setFont(new java.awt.Font("Palace Script MT", 0, 11)); // NOI18N
        changeFontPalaceScript.setText("Palace Script MT");
        changeFontPalaceScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontPalaceScriptActionPerformed(evt);
            }
        });
        fontChangeMenu.add(changeFontPalaceScript);

        changeFontRavie.setFont(new java.awt.Font("Ravie", 0, 11)); // NOI18N
        changeFontRavie.setText("Ravie ");
        fontChangeMenu.add(changeFontRavie);

        changeFontTimes.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        changeFontTimes.setText("Times New Roman");
        changeFontTimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontTimesActionPerformed(evt);
            }
        });
        fontChangeMenu.add(changeFontTimes);

        changeFontVerdana.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        changeFontVerdana.setText("Verdana");
        fontChangeMenu.add(changeFontVerdana);

        editMenu.add(fontChangeMenu);

        changeFontSizeMenu.setText("Change Font Size");

        changeFontSize8.setText("8");
        changeFontSize8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontSize8ActionPerformed(evt);
            }
        });
        changeFontSizeMenu.add(changeFontSize8);

        changeFontSize9.setText("9");
        changeFontSize9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontSize9ActionPerformed(evt);
            }
        });
        changeFontSizeMenu.add(changeFontSize9);

        changeFontSize10.setText("10");
        changeFontSize10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontSize10ActionPerformed(evt);
            }
        });
        changeFontSizeMenu.add(changeFontSize10);

        changeFontSize11.setText("11");
        changeFontSize11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontSize11ActionPerformed(evt);
            }
        });
        changeFontSizeMenu.add(changeFontSize11);

        changeFontSize12.setSelected(true);
        changeFontSize12.setText("12");
        changeFontSize12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontSize12ActionPerformed(evt);
            }
        });
        changeFontSizeMenu.add(changeFontSize12);

        changeFontSize14.setText("14");
        changeFontSize14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontSize14ActionPerformed(evt);
            }
        });
        changeFontSizeMenu.add(changeFontSize14);

        changeFontSize16.setText("16");
        changeFontSize16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontSize16ActionPerformed(evt);
            }
        });
        changeFontSizeMenu.add(changeFontSize16);

        changeFontSize18.setText("18");
        changeFontSize18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontSize18ActionPerformed(evt);
            }
        });
        changeFontSizeMenu.add(changeFontSize18);

        changeFontSize20.setText("20");
        changeFontSize20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontSize20ActionPerformed(evt);
            }
        });
        changeFontSizeMenu.add(changeFontSize20);

        changeFontSize22.setText("22");
        changeFontSize22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontSize22ActionPerformed(evt);
            }
        });
        changeFontSizeMenu.add(changeFontSize22);

        changeFontSize24.setText("24");
        changeFontSize24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontSize24ActionPerformed(evt);
            }
        });
        changeFontSizeMenu.add(changeFontSize24);

        changeFontSize26.setText("26");
        changeFontSize26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontSize26ActionPerformed(evt);
            }
        });
        changeFontSizeMenu.add(changeFontSize26);

        changeFontSize28.setText("28");
        changeFontSize28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontSize28ActionPerformed(evt);
            }
        });
        changeFontSizeMenu.add(changeFontSize28);

        changeFontSize36.setText("36");
        changeFontSize36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontSize36ActionPerformed(evt);
            }
        });
        changeFontSizeMenu.add(changeFontSize36);

        changeFontSize48.setText("48");
        changeFontSize48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontSize48ActionPerformed(evt);
            }
        });
        changeFontSizeMenu.add(changeFontSize48);

        changeFontSize72.setText("72");
        changeFontSize72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontSize72ActionPerformed(evt);
            }
        });
        changeFontSizeMenu.add(changeFontSize72);

        editMenu.add(changeFontSizeMenu);

        cutOption.setText("Cut");
        cutOption.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cutOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutOptionActionPerformed(evt);
            }
        });
        editMenu.add(cutOption);

        copyOption.setText("Copy");
        copyOption.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        copyOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyOptionActionPerformed(evt);
            }
        });
        editMenu.add(copyOption);

        pasteOption.setText("Paste");
        pasteOption.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pasteOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteOptionActionPerformed(evt);
            }
        });
        editMenu.add(pasteOption);

        topMenuBar.add(editMenu);

        formatMenu.setText("Format");

        bold.setText("Bold Text");
        bold.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boldActionPerformed(evt);
            }
        });
        formatMenu.add(bold);

        italicize.setText("Italicize Text");
        italicize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        italicize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                italicizeActionPerformed(evt);
            }
        });
        formatMenu.add(italicize);

        fontChangeColour.setText("Change Font Colour");
        fontChangeColour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fontChangeColour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontChangeColourActionPerformed(evt);
            }
        });
        formatMenu.add(fontChangeColour);

        underline.setText("Underline Text");
        underline.setToolTipText("");
        underline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                underlineActionPerformed(evt);
            }
        });
        formatMenu.add(underline);

        topMenuBar.add(formatMenu);

        setJMenuBar(topMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        // TODO add your handling code here:
        doSave(); //call the doSave function from below which will save the file
    }

    private void doSave() {
        if (fileDialog == null) { //if JFileChooser dialog does not exist
            fileDialog = new JFileChooser(); //create a new one
            fileDialog.setFileFilter(new FileNameExtensionFilter("RTF text File", ".rtf")); //set the file extension to .rtf
        }
        File selectedFile;
        if (editFile == null) { //if new file is trying to be saved
            selectedFile = new File("filename.rtf"); //set intial file name in the dialog
        } else { //if file has been saved before
            selectedFile = new File(editFile.getName()); //get the name of this previously saved file
        }
        fileDialog.setSelectedFile(selectedFile); //set the file's name to the default or to the previously selected file
        fileDialog.setDialogTitle("Select File to be Saved"); //set the save dialog box title
        int option = fileDialog.showSaveDialog(this); //show the save dialog
        if (option != JFileChooser.APPROVE_OPTION) {
            return;  //user canceled or clicked the dialog's close box, return to page
        }
        selectedFile = fileDialog.getSelectedFile();
        if (selectedFile.exists()) {  //if file with same name already exists
            int response = JOptionPane.showConfirmDialog(this, //ask the user whether to replace the file
                    "The file \"" + selectedFile.getName()
                    + "\" already exists.\nDo you want to replace it?",
                    "Confirm Save",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (response != JOptionPane.YES_OPTION) {
                return;  //user does not want to replace the file, return to page without saving
            }
        }
        OutputStream out;
        try {
            out = new FileOutputStream(selectedFile); //set FileOutputStream to the file user is trying to save
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, ////if exception is caught tell user their file could not be saved
                    "Sorry, but an error occurred while trying to save the file:\n" + e);
            return; //return to page
        }
        try {
            rtfKit.write(out, textArea.getDocument(), 0, textArea.getDocument().getLength()); //write the text to the user saved file
            editFile = selectedFile; //set saved file to file being edited now
            setTitle("File Being Edited Right Now: " + editFile.getName()); //set title of window to say file just saved is being edited
        } catch (IOException | BadLocationException e) {
            JOptionPane.showMessageDialog(this, //if exception caught, tell user their file could not be written to
                    "Sorry, but an error occurred while trying to write the text:\n" + e);
        }
    }//GEN-LAST:event_saveFileActionPerformed

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        // TODO add your handling code here:
        doOpen(); //call the doOpen function to open the file
    }

    private void doOpen() {
        if (fileDialog == null) { //if JFileChooser does not exist
            fileDialog = new JFileChooser(); //create a new one
        }
        fileDialog.setDialogTitle("Select File to be Opened"); //set title of open dialog
        fileDialog.setSelectedFile(null);  //do not initially select any file
        int option = fileDialog.showOpenDialog(this); //show open dialog
        if (option != JFileChooser.APPROVE_OPTION) {
            return;  //user canceled or clicked the dialog's close box, so return the page without opening any file
        }
        File selectedFile = fileDialog.getSelectedFile(); //get file user has selected
        InputStream in;
        try {
            in = new FileInputStream(selectedFile); //set FileInputStream to file user is trying to open
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, //if exception is caught, tell user their file could not be opened
                    "Sorry, but an error occurred while trying to open the file:\n" + e);
            return; //return to page without opening any file
        }
        try {
            StyledDocument doc = new DefaultStyledDocument();
            textArea.getEditorKit().read(in, doc, 0); //read in the text of the user selected file
            in.close();
            textArea.setStyledDocument(doc); //set text to page
            editFile = selectedFile; //set name of file being edited to the name of file just opened
            setTitle("File Being Edited Right Now: " + editFile.getName()); //set name of window to read file just opened as being edited
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, //if exception is caught, tell user their file data could not be read
                    "Sorry, but an error occurred while trying to read the data:\n" + e);
        }
    }//GEN-LAST:event_openFileActionPerformed

    private void copyOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_copyOptionActionPerformed

    private void italicizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_italicizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_italicizeActionPerformed

    private void fontChangeColourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontChangeColourActionPerformed
        // TODO add your handling code here:
        selectedColor = JColorChooser.showDialog(this, "Pick a font color", selectedColor); //show JColorChooser and save colour user 
        //selects
        Action changeFontColorAction = new StyledEditorKit.ForegroundAction("Pick a font color", selectedColor);  //set colour of selected
        //text to user selected
        //colour
        changeFontColorAction.putValue(Action.NAME, "Change font colour");
        changeFontColorAction.actionPerformed(evt); //set this action to be performed when user clicks the font colour change menu item
    }//GEN-LAST:event_fontChangeColourActionPerformed

    private void boldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boldActionPerformed

    private void underlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_underlineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_underlineActionPerformed

    private void pasteOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pasteOptionActionPerformed

    private void cutOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cutOptionActionPerformed

    private void changeFontComicSansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontComicSansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeFontComicSansActionPerformed

    private void changeFontCalibriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontCalibriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeFontCalibriActionPerformed

    private void changeFontPalaceScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontPalaceScriptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeFontPalaceScriptActionPerformed

    private void changeFontOldEnglishTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontOldEnglishTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeFontOldEnglishTextActionPerformed

    private void changeFontTimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontTimesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeFontTimesActionPerformed

    private void changeFontBradleyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontBradleyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeFontBradleyActionPerformed

    private void changeFontSize8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontSize8ActionPerformed
        // TODO add your handling code here:
        uncheckAll(); //call function to uncheck all checkboxes
        changeFontSize8.setSelected(true); //set check box for font size 8 to checked
    }//GEN-LAST:event_changeFontSize8ActionPerformed

    private void changeFontSize9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontSize9ActionPerformed
        // TODO add your handling code here:
        uncheckAll(); //call function to uncheck all checkboxes
        changeFontSize9.setSelected(true); //set check box for font size 9 to checked
    }//GEN-LAST:event_changeFontSize9ActionPerformed

    private void changeFontSize10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontSize10ActionPerformed
        // TODO add your handling code here:
        uncheckAll(); //call function to uncheck all checkboxes
        changeFontSize10.setSelected(true); //set check box for font size 10 to checked
    }//GEN-LAST:event_changeFontSize10ActionPerformed

    private void changeFontSize11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontSize11ActionPerformed
        // TODO add your handling code here:
        uncheckAll(); //call function to uncheck all checkboxes
        changeFontSize11.setSelected(true); //set check box for font size 11 to checked
    }//GEN-LAST:event_changeFontSize11ActionPerformed

    private void changeFontSize12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontSize12ActionPerformed
        // TODO add your handling code here:
        uncheckAll(); //call function to uncheck all checkboxes
        changeFontSize12.setSelected(true); //set check box for font size 12 to checked
    }//GEN-LAST:event_changeFontSize12ActionPerformed

    private void changeFontSize14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontSize14ActionPerformed
        // TODO add your handling code here:
        uncheckAll(); //call function to uncheck all checkboxes
        changeFontSize14.setSelected(true); //set check box for font size 14 to checked
    }//GEN-LAST:event_changeFontSize14ActionPerformed

    private void changeFontSize16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontSize16ActionPerformed
        // TODO add your handling code here:
        uncheckAll(); //call function to uncheck all checkboxes
        changeFontSize16.setSelected(true); //set check box for font size 16 to checked
    }//GEN-LAST:event_changeFontSize16ActionPerformed

    private void changeFontSize36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontSize36ActionPerformed
        // TODO add your handling code here:
        uncheckAll(); //call function to uncheck all checkboxes
        changeFontSize36.setSelected(true); //set check box for font size 36 to checked
    }//GEN-LAST:event_changeFontSize36ActionPerformed

    private void changeFontSize48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontSize48ActionPerformed
        // TODO add your handling code here:
        uncheckAll(); //call function to uncheck all checkboxes
        changeFontSize48.setSelected(true); //set check box for font size 48 to checked
    }//GEN-LAST:event_changeFontSize48ActionPerformed

    private void changeFontSize72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontSize72ActionPerformed
        // TODO add your handling code here:
        uncheckAll(); //call function to uncheck all checkboxes
        changeFontSize72.setSelected(true); //set check box for font size 72 to checked
    }//GEN-LAST:event_changeFontSize72ActionPerformed

    private void changeFontSize18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontSize18ActionPerformed
        // TODO add your handling code here:
        uncheckAll(); //call function to uncheck all checkboxes
        changeFontSize18.setSelected(true); //set check box for font size 18 to checked
    }//GEN-LAST:event_changeFontSize18ActionPerformed

    private void changeFontSize20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontSize20ActionPerformed
        // TODO add your handling code here:
        uncheckAll(); //call function to uncheck all checkboxes
        changeFontSize20.setSelected(true); //set check box for font size 20 to checked
    }//GEN-LAST:event_changeFontSize20ActionPerformed

    private void changeFontSize22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontSize22ActionPerformed
        // TODO add your handling code here:
        uncheckAll(); //call function to uncheck all checkboxes
        changeFontSize22.setSelected(true); //set check box for font size 22 to checked
    }//GEN-LAST:event_changeFontSize22ActionPerformed

    private void changeFontSize24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontSize24ActionPerformed
        // TODO add your handling code here:
        uncheckAll(); //call function to uncheck all checkboxes
        changeFontSize24.setSelected(true); //set check box for font size 24 to checked
    }//GEN-LAST:event_changeFontSize24ActionPerformed

    private void changeFontSize26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontSize26ActionPerformed
        // TODO add your handling code here:
        uncheckAll(); //call function to uncheck all checkboxes
        changeFontSize26.setSelected(true); //set check box for font size 26 to checked
    }//GEN-LAST:event_changeFontSize26ActionPerformed

    private void changeFontSize28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontSize28ActionPerformed
        // TODO add your handling code here:
        uncheckAll(); //call function to uncheck all checkboxes
        changeFontSize28.setSelected(true); //set check box for font size 28 to checked
    }//GEN-LAST:event_changeFontSize28ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane TheTextArea;
    private javax.swing.JMenuItem bold;
    private javax.swing.JMenuItem changeFontArial;
    private javax.swing.JMenuItem changeFontBradley;
    private javax.swing.JMenuItem changeFontCalibri;
    private javax.swing.JMenuItem changeFontChiller;
    private javax.swing.JMenuItem changeFontComicSans;
    private javax.swing.JMenuItem changeFontCourierNew;
    private javax.swing.JMenuItem changeFontOldEnglishText;
    private javax.swing.JMenuItem changeFontPalaceScript;
    private javax.swing.JMenuItem changeFontRavie;
    private javax.swing.JCheckBoxMenuItem changeFontSize10;
    private javax.swing.JCheckBoxMenuItem changeFontSize11;
    private javax.swing.JCheckBoxMenuItem changeFontSize12;
    private javax.swing.JCheckBoxMenuItem changeFontSize14;
    private javax.swing.JCheckBoxMenuItem changeFontSize16;
    private javax.swing.JCheckBoxMenuItem changeFontSize18;
    private javax.swing.JCheckBoxMenuItem changeFontSize20;
    private javax.swing.JCheckBoxMenuItem changeFontSize22;
    private javax.swing.JCheckBoxMenuItem changeFontSize24;
    private javax.swing.JCheckBoxMenuItem changeFontSize26;
    private javax.swing.JCheckBoxMenuItem changeFontSize28;
    private javax.swing.JCheckBoxMenuItem changeFontSize36;
    private javax.swing.JCheckBoxMenuItem changeFontSize48;
    private javax.swing.JCheckBoxMenuItem changeFontSize72;
    private javax.swing.JCheckBoxMenuItem changeFontSize8;
    private javax.swing.JCheckBoxMenuItem changeFontSize9;
    private javax.swing.JMenu changeFontSizeMenu;
    private javax.swing.JMenuItem changeFontTimes;
    private javax.swing.JMenuItem changeFontVerdana;
    private javax.swing.JMenuItem copyOption;
    private javax.swing.JMenuItem cutOption;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem fontChangeColour;
    private javax.swing.JMenu fontChangeMenu;
    private javax.swing.JMenu formatMenu;
    private javax.swing.JMenuItem italicize;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JPanel panelForPage;
    private javax.swing.JMenuItem pasteOption;
    private javax.swing.JMenuItem saveFile;
    private javax.swing.JTextPane textArea;
    private javax.swing.JMenuBar topMenuBar;
    private javax.swing.JMenuItem underline;
    // End of variables declaration//GEN-END:variables

}
