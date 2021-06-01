package deckCreate;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.io.*;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Image;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import java.awt.Color;
import java.time.Clock;

/**
 * <p>
 * DBM class.</p>
 *
 * @author rekat
 * @version $Id: $Id
 */
public class DBM {

    private Connection con = null;
    private Statement s = null;
    private ResultSet rs = null;
    private String Ftype = "";
    private int Fsize = 11;
    private String Ftype1 = "";
    private int Fsize1 = 11;

    private static String colour = "";
    private static int deckid = 0;
    private static boolean btn1 = false;
    private static boolean btn2 = false;
    private static boolean btn3 = false;
    private static boolean btn4 = true;
    private static boolean textf = true;
    private static boolean tlabel = true;
    private static int cardid = 0;

    /**
     * <p>
     * isTlabel.</p>
     *
     * @return a boolean.
     */
    public static boolean isTlabel() {
        return tlabel;
    }

    /**
     * <p>
     * Setter for the field <code>tlabel</code>.</p>
     *
     * @param tlabel a boolean.
     */
    public static void setTlabel(boolean tlabel) {
        DBM.tlabel = tlabel;
    }

    /**
     * <p>
     * isTextf.</p>
     *
     * @return a boolean.
     */
    public static boolean isTextf() {
        return textf;
    }

    /**
     * <p>
     * Setter for the field <code>textf</code>.</p>
     *
     * @param textf a boolean.
     */
    public static void setTextf(boolean textf) {
        DBM.textf = textf;
    }

    /**
     * <p>
     * isBtn4.</p>
     *
     * @return a boolean.
     */
    public static boolean isBtn4() {
        return btn4;
    }

    /**
     * <p>
     * Setter for the field <code>btn4</code>.</p>
     *
     * @param btn4 a boolean.
     */
    public static void setBtn4(boolean btn4) {
        DBM.btn4 = btn4;
    }

    /**
     * <p>
     * isBtn3.</p>
     *
     * @return a boolean.
     */
    public static boolean isBtn3() {
        return btn3;
    }

    /**
     * <p>
     * Setter for the field <code>btn3</code>.</p>
     *
     * @param btn3 a boolean.
     */
    public static void setBtn3(boolean btn3) {
        DBM.btn3 = btn3;
    }

    /**
     * <p>
     * isBtn1.</p>
     *
     * @return a boolean.
     */
    public static boolean isBtn1() {
        return btn1;
    }

    /**
     * <p>
     * Setter for the field <code>btn1</code>.</p>
     *
     * @param btn1 a boolean.
     */
    public static void setBtn1(boolean btn1) {
        DBM.btn1 = btn1;
    }

    /**
     * <p>
     * isBtn2.</p>
     *
     * @return a boolean.
     */
    public static boolean isBtn2() {
        return btn2;
    }

    /**
     * <p>
     * Setter for the field <code>btn2</code>.</p>
     *
     * @param btn2 a boolean.
     */
    public static void setBtn2(boolean btn2) {
        DBM.btn2 = btn2;
    }

    /**
     * <p>
     * Getter for the field <code>cardid</code>.</p>
     *
     * @return a int.
     */
    public static int getCardid() {
        return cardid;
    }

    /**
     * <p>
     * Setter for the field <code>cardid</code>.</p>
     *
     * @param cardid a int.
     */
    public static void setCardid(int cardid) {
        DBM.cardid = cardid;
    }

    /**
     * <p>
     * Getter for the field <code>deckid</code>.</p>
     *
     * @return a int.
     */
    public static int getDeckid() {
        return deckid;
    }

    /**
     * <p>
     * Setter for the field <code>deckid</code>.</p>
     *
     * @param deckid a int.
     */
    public static void setDeckid(int deckid) {
        DBM.deckid = deckid;
    }

    /**
     * <p>
     * getFtype1.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getFtype1() {
        return Ftype1;
    }

    /**
     * <p>
     * setFtype1.</p>
     *
     * @param ftype1 a {@link java.lang.String} object.
     */
    public void setFtype1(String ftype1) {
        Ftype1 = ftype1;
    }

    /**
     * <p>
     * getFsize1.</p>
     *
     * @return a int.
     */
    public int getFsize1() {
        return Fsize1;
    }

    /**
     * <p>
     * setFsize1.</p>
     *
     * @param fsize1 a int.
     */
    public void setFsize1(int fsize1) {
        Fsize1 = fsize1;
    }

    /**
     * <p>
     * getFtype.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getFtype() {
        return Ftype;
    }

    /**
     * <p>
     * setFtype.</p>
     *
     * @param ftype a {@link java.lang.String} object.
     */
    public void setFtype(String ftype) {
        Ftype = ftype;
    }

    /**
     * <p>
     * getFsize.</p>
     *
     * @return a int.
     */
    public int getFsize() {
        return Fsize;
    }

    /**
     * <p>
     * setFsize.</p>
     *
     * @param fsize a int.
     */
    public void setFsize(int fsize) {
        Fsize = fsize;
    }

    /**
     * <p>
     * Getter for the field <code>colour</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public static String getColour() {
        return colour;
    }

    /**
     * <p>
     * Setter for the field <code>colour</code>.</p>
     *
     * @param colour a {@link java.lang.String} object.
     */
    public static void setColour(String colour) {
        DBM.colour = colour;
    }

    /**
     * <p>
     * Con.</p>
     */
    public void Con() {

        try {
            con = DriverManager.getConnection("jdbc:mysql://87.229.115.62:3306/cardgame?serverTimezone=UTC",
                    "treka", "szakdoga2021");

        } catch (SQLException e) {

        }
    }

    /**
     * <p>
     * Insert.</p>
     *
     * @param did a int.
     * @param t1 a {@link javax.swing.JTextField} object.
     * @param t2 a {@link javax.swing.JTextField} object.
     * @param t3 a {@link javax.swing.JTextField} object.
     * @param t4 a {@link javax.swing.JTextField} object.
     * @param t5 a {@link javax.swing.JTextField} object.
     * @param t6 a {@link javax.swing.JTextField} object.
     * @param t7 a {@link javax.swing.JTextField} object.
     */
    public void Insert(int did, JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5,
            JTextField t6, JTextField t7) {
        String qM = ContainSlash(t2.getText());
        String rM = ContainSlash(t2.getText());
        String sql = "Insert into cards(deckID,colour,questionText,questionMath,resultText,resultMath,cardname,img,imgresult,qFSize,qFType,rFSize,rFType) values ('"
                + did + "','" + colour + "','" + t1.getText() + "','" + qM + "','" + t3.getText() + "','" + rM + "','"
                + t5.getText() + "','" + t6.getText() + "','" + t7.getText() + "','" + getFsize() + "','" + getFtype()
                + "','" + getFsize1() + "','" + getFtype1() + "')";

        Con();
        try {

            s = con.createStatement();
            s.execute(sql);
            MS("Sikeresen rögzítve az adatbázisba!");
        } catch (SQLException e) {
            MS("Sikertelenül rögzítve az adatbázisba!");
        }
    }

    /**
     * <p>
     * Update.</p>
     *
     * @param t1 a {@link javax.swing.JTextField} object.
     * @param t2 a {@link javax.swing.JTextField} object.
     * @param t3 a {@link javax.swing.JTextField} object.
     * @param t4 a {@link javax.swing.JTextField} object.
     * @param t5 a {@link javax.swing.JTextField} object.
     * @param t6 a {@link javax.swing.JTextField} object.
     * @param t7 a {@link javax.swing.JTextField} object.
     * @return a boolean.
     */
    public boolean Update(JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5, JTextField t6,
            JTextField t7) {
        boolean succes = false;

        String qM = ContainSlash(t2.getText());
        String rM = ContainSlash(t4.getText());

        String sql = "UPDATE cards Set questionText ='" + t1.getText() + "',questionMath ='" + qM + "',resultText = '"
                + t3.getText() + "',resultMath='" + rM + "',cardname='" + t5.getText() + "',img='" + t6.getText()
                + "',imgresult='" + t7.getText() + "',qFSize='" + getFsize() + "',qFType='" + getFtype() + "',rFSize='"
                + getFsize1() + "',rFType='" + getFtype1() + "' where id = '" + getCardid() + "' ";

        Con();
        try {

            s = con.createStatement();
            s.execute(sql);
            MS("Sikeresen rögzítve az adatbázisba!");
            succes = true;
            return succes;
        } catch (SQLException e) {
            MS("Sikertelenül rögzítve az adatbázisba!");
            return succes;
        }
    }

    /**
     * <p>
     * DeckLoader.</p>
     *
     * @param a a {@link java.util.ArrayList} object.
     * @param textArea a {@link javax.swing.JTextArea} object.
     */
    public void DeckLoader(ArrayList a, JTextArea textArea) {

        int i = 0;

        String selection = "Select distinct deckID from cards ";
        String k1 = "";
        try {

            Con();
            s = con.createStatement();
            rs = s.executeQuery(selection);
            while (rs.next()) {
                k1 = String.valueOf(rs.getInt("deckID"));
                a.add(k1);
                k1 = null;

            }
            rs.close();
        } catch (SQLException e) {
            MS(e.getMessage());

        }
        for (Object object : a) {
            if (i < a.size()) {

                textArea.append("Deck ID:");
                textArea.append("" + String.valueOf(a.get(i)));
                textArea.append("\n");
                i++;

            }
            if (i == a.size()) {

                break;
            }
        }

    }

    /**
     * <p>
     * Image.</p>
     *
     * @param imFile a {@link java.lang.String} object.
     * @throws java.io.FileNotFoundException if any.
     * @throws java.io.IOException if any.
     */
    public void Image(String imFile) throws FileNotFoundException, IOException {

        String dest = "pdf/" + getDeckid() + "szamupakli" + ".pdf";
        PdfWriter writer = new PdfWriter(dest);

        PdfDocument pdf = new PdfDocument(writer);

        Document document = new Document(pdf);

        ImageData data = ImageDataFactory.create(imFile);

        Image image = new Image(data);

        image.scaleToFit(100, 200);

        document.add(image);

        document.close();

    }

    /**
     * <p>
     * captureComponent.</p>
     *
     * @param component a {@link java.awt.Component} object.
     * @return a {@link java.lang.String} object.
     * @throws java.lang.Throwable if any.
     */
    public String captureComponent(Component component) throws Throwable {
        java.awt.Rectangle rect = component.getBounds();
        String fileName = "";
        try {
            String format = "png";
            fileName = getDeckid() + getCardid() + component.getX() + LocalDateTime.now().getSecond() + "." + format;
            BufferedImage captureImage = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_ARGB);
            component.paint(captureImage.getGraphics());

            ImageIO.write(captureImage, format, new File(fileName));
            Image(fileName);

        } catch (IOException ex) {
            System.err.println(ex);
        }
        return fileName;
    }

    /**
     * <p>
     * PrintDeck.</p>
     *
     * @param a a {@link java.util.ArrayList} object.
     * @param component a {@link java.awt.Component} object.
     * @param component1 a {@link java.awt.Component} object.
     * @param t1 a {@link javax.swing.JTextField} object.
     * @param t2 a {@link javax.swing.JTextField} object.
     * @param t3 a {@link javax.swing.JTextField} object.
     * @param t4 a {@link javax.swing.JTextField} object.
     * @param t5 a {@link javax.swing.JTextField} object.
     * @param t6 a {@link javax.swing.JTextField} object.
     * @param t7 a {@link javax.swing.JTextField} object.
     * @param flabel a {@link javax.swing.JLabel} object.
     * @param flabel_1 a {@link javax.swing.JLabel} object.
     * @param panel a {@link javax.swing.JPanel} object.
     * @param panel_1 a {@link javax.swing.JPanel} object.
     * @throws java.lang.Throwable if any.
     */
    public void PrintDeck(ArrayList a, Component component, Component component1, JTextField t1, JTextField t2,
            JTextField t3, JTextField t4, JTextField t5, JTextField t6, JTextField t7, JLabel flabel, JLabel flabel_1,
            JPanel panel, JPanel panel_1) throws Throwable {
        int i = 0;
        int x = 500;

        String selection = "Select colour,questionText,questionMath,resultText,resultMath,cardname,img,imgresult from cards where deckID='"
                + getDeckid() + "'";

        String k1 = "";

        String dest = "pdf/" + getDeckid() + "szamupakli" + ".pdf";
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        try {

            Con();
            s = con.createStatement();
            rs = s.executeQuery(selection);
            while (rs.next()) {
                k1 = rs.getString("colour");
                a.add(k1);
                panel.setBackground(Color.decode(k1));
                panel_1.setBackground(Color.decode(k1));
                k1 = null;
                k1 = rs.getString("questionText");
                a.add(k1);
                t1.setText(k1);
                k1 = null;
                k1 = rs.getString("questionMath");
                a.add(k1);
                t2.setText(k1);
                String math = t2.getText();

                TeXFormula fomule = new TeXFormula(math);

                TeXIcon ti = fomule.createTeXIcon(TeXConstants.STYLE_DISPLAY, getFsize1());
                BufferedImage b = new BufferedImage(ti.getIconWidth(), ti.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);

                ti.paintIcon(new JLabel(), b.getGraphics(), 0, 0);
                flabel.setIcon(ti);

                panel.revalidate();
                panel.repaint();

                k1 = null;
                k1 = rs.getString("resultText");
                a.add(k1);
                t3.setText(k1);
                k1 = null;
                k1 = rs.getString("resultMath");
                a.add(k1);
                t4.setText(k1);
                String math2 = t4.getText();

                TeXFormula fomule2 = new TeXFormula(math2);

                TeXIcon ti2 = fomule2.createTeXIcon(TeXConstants.STYLE_DISPLAY, getFsize1());
                BufferedImage b2 = new BufferedImage(ti2.getIconWidth(), ti2.getIconHeight(),
                        BufferedImage.TYPE_4BYTE_ABGR);

                ti2.paintIcon(new JLabel(), b.getGraphics(), 0, 0);
                flabel_1.setIcon(ti2);

                panel_1.revalidate();
                panel_1.repaint();
                k1 = null;
                k1 = rs.getString("cardname");
                a.add(k1);
                t4.setText(k1);
                k1 = null;
                k1 = rs.getString("img");
                a.add(k1);
                t5.setText(k1);
                k1 = null;
                k1 = rs.getString("imgresult");
                a.add(k1);
                t6.setText(k1);
                k1 = null;
                captureComponent(component);
                ImageData data2 = ImageDataFactory.create(captureComponent(component));
                Image image2 = new Image(data2);

                image2.setPadding(10);
                image2.setFixedPosition(50, x);
                image2.setMarginBottom(10);
                image2.scaleToFit(219, 416);
                document.add(image2);

                i++;
                File file = new File(captureComponent(component));
                file.delete();
                captureComponent(component1);
                ImageData data = ImageDataFactory.create(captureComponent(component1));

                Image image = new Image(data);

                image.setPadding(10);
                image.setMarginBottom(10);

                image.scaleToFit(219, 416);
                image.setFixedPosition(300, x);

                document.add(image);
                i++;
                x = x - 430;
                if (i == 4) {
                    i = 0;
                    x = 500;
                    document.add(new AreaBreak());
                }

                File file2 = new File(captureComponent(component1));
                file2.delete();
                Thread.sleep(1000);

            }
            rs.close();
            document.close();
            MS("Elkészült a dokumentum!");
        } catch (SQLException e) {
            MS(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * <p>
     * DeckChooser.</p>
     *
     * @param textField a {@link javax.swing.JTextField} object.
     */
    public void DeckChooser(JTextField textField) {
        setDeckid(Integer.parseInt(textField.getText()));
    }

    /**
     * <p>
     * CardLoader.</p>
     *
     * @param a a {@link java.util.ArrayList} object.
     * @param textArea a {@link javax.swing.JTextArea} object.
     */
    public void CardLoader(ArrayList a, JTextArea textArea) {
        int i = 0;
        String selection = "Select id,cardname from cards where deckID='" + getDeckid() + "'";
        String k1 = "";
        try {
            Con();
            s = con.createStatement();
            rs = s.executeQuery(selection);
            while (rs.next()) {
                k1 = String.valueOf(rs.getInt("id"));
                a.add(k1);
                k1 = null;
                k1 = rs.getString("cardname");
                a.add(k1);
                k1 = null;
            }
            rs.close();
        } catch (SQLException e) {
            MS(e.getMessage());
        }

        for (Object object : a) {
            if (i < a.size()) {
                textArea.append("Card id");
                textArea.append("	" + String.valueOf(a.get(i)));
                i++;

                textArea.append("	" + a.get(i));
                textArea.append("\n");
                i++;
            }
            if (i == a.size() - 1) {
                break;
            }
        }
    }

    /**
     * <p>
     * CardChooser.</p>
     *
     * @param textField a {@link javax.swing.JTextField} object.
     */
    public void CardChooser(JTextField textField) {
        setCardid(Integer.parseInt(textField.getText()));
    }

    /**
     * <p>
     * CopyCard.</p>
     *
     * @param a a {@link java.util.ArrayList} object.
     */
    public void CopyCard(ArrayList a) {

        String selection = "Select colour,questionText,questionMath,resultText,resultMath,cardname,img,imgresult,qFSize,qFType,rFSize,rFType from cards where deckID='"
                + getDeckid() + "' && id='" + getCardid() + "'";

        String k1 = "";
        try {

            Con();
            s = con.createStatement();
            rs = s.executeQuery(selection);
            while (rs.next()) {
                k1 = rs.getString("colour");
                a.add(k1);
                setColour(k1);
                k1 = null;
                k1 = rs.getString("questionText");
                a.add(k1);
                k1 = null;
                k1 = rs.getString("questionMath");

                a.add(k1);
                k1 = null;
                k1 = rs.getString("resultText");
                a.add(k1);
                k1 = null;
                k1 = rs.getString("resultMath");

                a.add(k1);
                k1 = null;
                k1 = rs.getString("cardname");
                a.add(k1);
                k1 = null;
                k1 = rs.getString("img");
                a.add(k1);
                k1 = null;
                k1 = rs.getString("imgresult");
                a.add(k1);
                k1 = null;
                k1 = String.valueOf(rs.getInt("qFSize"));
                a.add(k1);
                k1 = null;
                k1 = rs.getString("qFType");
                a.add(k1);
                k1 = null;
                k1 = String.valueOf(rs.getInt("rFSize"));
                a.add(k1);
                k1 = null;
                k1 = rs.getString("rFType");
                a.add(k1);
                k1 = null;
            }
            rs.close();
        } catch (SQLException e) {
            MS(e.getMessage());
        }
    }

    public String ContainSlash(String text) {
        String[] splitted = text.split("");
        String revalidatedText = "";
        for (int i = 0; i < splitted.length; i++) {
            if (splitted[i].equals("\\")) {
                splitted[i] = "\\" + splitted[i];
                revalidatedText = revalidatedText + splitted[i];
            } else {
                revalidatedText = revalidatedText + splitted[i];
            }

        }
        System.out.println(revalidatedText);
        return revalidatedText;

    }

    /**
     * <p>
     * MS.</p>
     *
     * @param msg a {@link java.lang.String} object.
     */
    public void MS(String msg) {

        JOptionPane.showMessageDialog(null, msg, "Quiz game", JOptionPane.INFORMATION_MESSAGE);
    }
}
