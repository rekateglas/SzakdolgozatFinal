package game;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.*;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import deckCreate.*;
import signinup.*;

/**
 * <p>
 * GameAlgorithms class.</p>
 *
 * @author rekat
 * @version $Id: $Id
 */
public class GameAlgorithms {

    private Connection con = null;
    private DBM dbm = new DBM();
    private Statement s = null;
    private ResultSet rs = null;
    private ArrayList<Integer> randcat1 = new ArrayList<Integer>();
    private ArrayList<Integer> randcat2 = new ArrayList<Integer>();
    private ArrayList<Integer> randcat3 = new ArrayList<Integer>();
    private ArrayList<Integer> questionnum = new ArrayList<Integer>();
    private ArrayList<String> allquestion = new ArrayList<>();
    private int money = 0;
    private String result = "";
    private int counter = 0;
    private int i = 0;

    private int[] winprice = {0, 10000, 20000, 50000, 100000, 250000, 500000, 750000, 1000000, 1500000, 2000000,
        5000000, 10000000, 15000000, 25000000, 50000000};
    private boolean checkpoint1 = false;
    private boolean checkpoint2 = false;
    private int winnedPrice = 0;
    private int playerhelp1 = 1;
    private int playerhelp2 = 1;
    private int playerhelp3 = 1;
    private String LateXButton1 = "";
    private String LateXButton2 = "";
    private String LateXButton3 = "";
    private String LateXButton4 = "";
    private String Question = "";
    private String mathquestion = "";
    private static int BestPoint = 0;
    private int point;
    private static String playername;
    private String playerhelp3result = "";
    private boolean lose = false;
    private boolean maxlevel = false;
    public static final Random gen = new Random();
    private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    private BarChart bc = new BarChart("BarChart");

    /**
     * <p>
     * isMaxlevel.</p>
     *
     * @return a boolean.
     */
    public boolean isMaxlevel() {
        return maxlevel;
    }

    /**
     * <p>
     * Setter for the field <code>maxlevel</code>.</p>
     *
     * @param maxlevel a boolean.
     */
    public void setMaxlevel(boolean maxlevel) {
        this.maxlevel = maxlevel;
    }

    /**
     * <p>
     * Setter for the field <code>checkpoint1</code>.</p>
     *
     * @param checkpoint1 a boolean.
     */
    public void setCheckpoint1(boolean checkpoint1) {
        this.checkpoint1 = checkpoint1;
    }

    /**
     * <p>
     * Setter for the field <code>checkpoint2</code>.</p>
     *
     * @param checkpoint2 a boolean.
     */
    public void setCheckpoint2(boolean checkpoint2) {
        this.checkpoint2 = checkpoint2;
    }

    /**
     * <p>
     * isCheckpoint1.</p>
     *
     * @return a boolean.
     */
    public boolean isCheckpoint1() {
        return checkpoint1;
    }

    /**
     * <p>
     * isCheckpoint2.</p>
     *
     * @return a boolean.
     */
    public boolean isCheckpoint2() {
        return checkpoint2;
    }

    /**
     * <p>
     * Getter for the field <code>i</code>.</p>
     *
     * @return a int.
     */
    public int getI() {
        return i;
    }

    /**
     * <p>
     * Setter for the field <code>i</code>.</p>
     *
     * @param i a int.
     */
    public void setI(int i) {
        this.i = i;
    }

    /**
     * <p>
     * Getter for the field <code>winprice</code>.</p>
     *
     * @return an array of {@link int} objects.
     */
    public int[] getWinprice() {
        return winprice;
    }

    /**
     * <p>
     * Setter for the field <code>winprice</code>.</p>
     *
     * @param winprice an array of {@link int} objects.
     */
    public void setWinprice(int[] winprice) {
        this.winprice = winprice;
    }

    /**
     * <p>
     * Getter for the field <code>dataset</code>.</p>
     *
     * @return a {@link org.jfree.data.category.DefaultCategoryDataset} object.
     */
    public DefaultCategoryDataset getDataset() {
        return dataset;
    }

    /**
     * <p>
     * Setter for the field <code>dataset</code>.</p>
     *
     * @param dataset a {@link org.jfree.data.category.DefaultCategoryDataset}
     * object.
     */
    public void setDataset(DefaultCategoryDataset dataset) {
        this.dataset = dataset;
    }

    /**
     * <p>
     * Getter for the field <code>playername</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public static String getPlayername() {
        return playername;
    }

    /**
     * <p>
     * Setter for the field <code>playername</code>.</p>
     *
     * @param playername a {@link java.lang.String} object.
     */
    public static void setPlayername(String playername) {
        GameAlgorithms.playername = playername;
    }

    /**
     * <p>
     * getBestPoint.</p>
     *
     * @return a int.
     */
    public static int getBestPoint() {
        return BestPoint;
    }

    /**
     * <p>
     * setBestPoint.</p>
     *
     * @param bestPoint a int.
     */
    public static void setBestPoint(int bestPoint) {
        BestPoint = bestPoint;
    }

    /**
     * <p>
     * Getter for the field <code>point</code>.</p>
     *
     * @return a int.
     */
    public int getPoint() {
        return point;
    }

    /**
     * <p>
     * Setter for the field <code>point</code>.</p>
     *
     * @param point a int.
     */
    public void setPoint(int point) {
        this.point = point;
    }

    /**
     * <p>
     * Getter for the field <code>allquestion</code>.</p>
     *
     * @return a int.
     */
    public int getAllquestion() {
        return allquestion.size();
    }

    /**
     * <p>
     * getAllquestionText.</p>
     *
     * @return a {@link java.util.ArrayList} object.
     */
    public ArrayList<String> getAllquestionText() {
        return allquestion;
    }

    /**
     * <p>
     * Setter for the field <code>allquestion</code>.</p>
     *
     * @param allquestion a {@link java.util.ArrayList} object.
     */
    public void setAllquestion(ArrayList<String> allquestion) {
        this.allquestion = allquestion;
    }

    /**
     * <p>
     * Getter for the field <code>money</code>.</p>
     *
     * @return a int.
     */
    public int getMoney() {
        return money;
    }

    /**
     * <p>
     * Setter for the field <code>money</code>.</p>
     *
     * @param money a int.
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * <p>
     * GameCon.</p>
     */
    public void GameCon() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://87.229.115.62:3306/cardgame?serverTimezone=UTC",
                    "treka", "szakdoga2021");
            dbm.MS("Sikeres csatlakozás a szerverre");
        } catch (SQLException e) {
            dbm.MS("Sikertelen csatlakozás a szerverre");
        }
    }

    private void getColumn() {
        GameCon();
        String selcat1 = "Select id from question where category=1";
        String selcat2 = "Select id from question where category=2";
        String selcat3 = "Select id from question where category=3";

        try {
            s = con.createStatement();
            rs = s.executeQuery(selcat1);

            while (rs.next()) {
                randcat1.add(rs.getInt("id"));
            }
            rs = s.executeQuery(selcat2);
            while (rs.next()) {
                randcat2.add(rs.getInt("id"));
            }
            rs = s.executeQuery(selcat3);
            while (rs.next()) {
                randcat3.add(rs.getInt("id"));
            }
        } catch (SQLException e) {
            dbm.MS(e.getMessage());
        }

    }

    private void Randomizer() {
        getColumn();
        Random rand = new Random();
        int[] questioncategory1 = new int[5];
        int[] questioncategory2 = new int[5];
        int[] questioncategory3 = new int[5];

        for (int i = 0; i < 5; i++) {
            questioncategory1[i] = rand.nextInt(0 + randcat1.size()) - 0;
            questioncategory2[i] = rand.nextInt(0 + randcat2.size()) - 0;
            questioncategory3[i] = rand.nextInt(0 + randcat3.size()) - 0;
        }

        for (int i = 0; i < 5; i++) {
            questionnum.add(randcat1.get(questioncategory1[i]));
        }
        for (int i = 0; i < 5; i++) {
            questionnum.add(randcat2.get(questioncategory2[i]));
        }
        for (int i = 0; i < 5; i++) {
            questionnum.add(randcat3.get(questioncategory3[i]));
        }

    }

    /**
     * <p>
     * GetQuestion.</p>
     */
    public void GetQuestion() {
        Randomizer();
        GameCon();
        String sql;
        int counter = 0;

        for (int i = 0; i < 15; i++) {
            try {
                sql = "Select * from question where id ='" + questionnum.get(i) + "'";
                s = con.createStatement();
                rs = s.executeQuery(sql);
                while (rs.next()) {
                    allquestion.add(rs.getString("question"));
                    allquestion.add(rs.getString("qmath"));
                    allquestion.add(rs.getString("sol1"));
                    allquestion.add(rs.getString("sol2"));
                    allquestion.add(rs.getString("sol3"));
                    allquestion.add(rs.getString("sol4"));

                    allquestion.add(rs.getString("answer"));
                    counter++;
                }
                rs.close();
            } catch (SQLException e) {
                dbm.MS(e.getMessage());
            }
        }
    }

    private void LateXConverter(JButton button, String LateXText) {

        TeXFormula fomule = new TeXFormula(LateXText);
        TeXIcon ti = fomule.createTeXIcon(TeXConstants.STYLE_DISPLAY, 25);
        BufferedImage b = new BufferedImage(button.getWidth() + 100, button.getHeight() + 100,
                BufferedImage.TYPE_4BYTE_ABGR);

        ti.paintIcon(new JButton(), b.getGraphics(), 0, 0);

        button.setIcon(ti);
        button.revalidate();
        button.repaint();
    }

    private void LateXConverter(JLabel label, String Question) {
        TeXFormula fomule = new TeXFormula(Question);
        TeXIcon ti = fomule.createTeXIcon(TeXConstants.STYLE_DISPLAY, 18);
        BufferedImage b = new BufferedImage(ti.getIconWidth(), ti.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);

        ti.paintIcon(new JLabel(), b.getGraphics(), 0, 0);

        label.setIcon(ti);
        label.revalidate();
        label.repaint();
    }

    public void TestMaker(JButton btn1, JButton btn2, JButton btn3, JButton btn4, JLabel label, ActionEvent e,
            JLabel mathLabel) {

        jump2:
        {
            for (; i < allquestion.size(); i += 0) {
                if (counter < allquestion.size()) {

                    jump1:
                    {

                        LateXButton1 = "";
                        LateXButton2 = "";
                        LateXButton3 = "";
                        LateXButton4 = "";
                        Question = "";
                        result = "";
                        mathquestion = "";

                        Question = allquestion.get(counter);
                        label.setText("<html><p>" + Question + "</p></html>");
                        counter++;

                        mathquestion = allquestion.get(counter);
                        LateXConverter(mathLabel, mathquestion);
                        counter++;
                        LateXButton1 = allquestion.get(counter);
                        btn1.setText("<html><body><br></body></html>" + LateXButton1);

                        LateXConverter(btn1, LateXButton1);
                        counter++;
                        LateXButton2 = allquestion.get(counter);

                        btn2.setText("<html><body><br></body></html>" + LateXButton2);

                        LateXConverter(btn2, LateXButton2);
                        counter++;
                        LateXButton3 = allquestion.get(counter);
                        btn3.setText("<html><body><br></body></html>" + LateXButton3);

                        LateXConverter(btn3, LateXButton3);
                        counter++;
                        LateXButton4 = allquestion.get(counter);
                        btn4.setText("<html><body><br></body></html>" + LateXButton4);

                        LateXConverter(btn4, LateXButton4);
                        counter++;
                        result = "<html><body><br></body></html>" + allquestion.get(counter);
                        playerhelp3result = allquestion.get(counter);
                        i++;

                        if (counter < allquestion.size()) {
                            counter++;
                        }

                        break jump2;
                    }
                }

            }

        }
    }

    private void checkpointcheck() {

        if (i == 5) {
            checkpoint1 = true;
        } else if (i == 10) {
            checkpoint2 = true;
        }

    }

    /**
     * <p>
     * saveq.</p>
     *
     * @param btn1 a {@link javax.swing.JButton} object.
     * @param btn2 a {@link javax.swing.JButton} object.
     * @param btn3 a {@link javax.swing.JButton} object.
     * @param btn4 a {@link javax.swing.JButton} object.
     * @param e a {@link java.awt.event.ActionEvent} object.
     * @param moneybar a {@link javax.swing.JTextField} object.
     * @param lA a {@link javax.swing.JLabel} object.
     * @param lB a {@link javax.swing.JLabel} object.
     * @param lC a {@link javax.swing.JLabel} object.
     * @param lD a {@link javax.swing.JLabel} object.
     */
    public void saveq(JButton btn1, JButton btn2, JButton btn3, JButton btn4, ActionEvent e, JTextField moneybar, JLabel lA, JLabel lB, JLabel lC, JLabel lD) {

        btn1.setVisible(true);
        btn2.setVisible(true);
        btn3.setVisible(true);
        btn4.setVisible(true);
        lA.setVisible(true);
        lB.setVisible(true);
        lC.setVisible(true);
        lD.setVisible(true);
        String btn = btn1.getText();
        String button2 = btn2.getText();
        String button3 = btn3.getText();
        String button4 = btn4.getText();

        if (e.getActionCommand() != null) {
            if (e.getActionCommand().contentEquals(btn)) {
                if (btn1.getText().equals(result)) {

                    dbm.MS("Gratulálok! Helyes válasz!");
                    money = winprice[i];
                    checkpointcheck();

                    moneybar.setText(String.valueOf(money));

                } else {
                    lose = true;
                    dbm.MS("A játék sajnos végetért.\nAz elveszített összeg: " + money + " Forint.");
                    saveplayermoney();

                    System.exit(0);
                }

            } else if (e.getActionCommand().contentEquals(button2)) {
                if (btn2.getText().equals(result)) {

                    dbm.MS("Gratulálok! Helyes válasz!");
                    money = winprice[i];
                    checkpointcheck();

                    moneybar.setText(String.valueOf(money));

                } else {
                    lose = true;
                    dbm.MS("A játék sajnos végetért.\nAz elveszített összeg: " + money + " Forint.");
                    saveplayermoney();
                    System.exit(0);
                }

            } else if (e.getActionCommand().contentEquals(button3)) {
                if (btn3.getText().equals(result)) {

                    dbm.MS("Gratulálok! Helyes válasz!");
                    money = winprice[i];

                    checkpointcheck();

                    moneybar.setText(String.valueOf(money));

                } else {
                    lose = true;
                    dbm.MS("A játék sajnos végetért.\nAz elveszített összeg: " + money + " Forint.");
                    saveplayermoney();
                    System.exit(0);
                }

            } else if (e.getActionCommand().contentEquals(button4)) {
                if (btn4.getText().equals(result)) {

                    dbm.MS("Gratulálok! Helyes válasz!");
                    money = winprice[i];

                    checkpointcheck();

                    moneybar.setText(String.valueOf(money));

                } else {
                    lose = true;
                    dbm.MS("A játék sajnos végetért.\nAz elveszített összeg: " + money + " Forint.");
                    saveplayermoney();
                    System.exit(0);
                }

            }

            if (e.getActionCommand().isEmpty()) {
                dbm.MS("Nincs megfelelő érték!");
            }
        }

    }

    /**
     * <p>
     * pausegame.</p>
     *
     * @param btnyes a {@link javax.swing.JButton} object.
     * @param btnno a {@link javax.swing.JButton} object.
     * @param e a {@link java.awt.event.ActionEvent} object.
     * @param endbtn a {@link javax.swing.JButton} object.
     * @return a boolean.
     */
    public boolean pausegame(JButton btnyes, JButton btnno, ActionEvent e, JButton endbtn) {
        //megáll vagy továbbmegy eldöntése

        boolean decision = false;

        if (money < winprice[15]) {
            btnyes.setVisible(true);
            btnno.setVisible(true);

            String btn2 = btnno.getText();
            if (e.getActionCommand() != null) {
                if (e.getSource() == btnyes) {
                    dbm.MS("A játék sikeresen folytatódik!");
                    decision = true;
                    btnyes.setVisible(false);
                    btnno.setVisible(false);

                }
            }

            if (e.getSource() == btnno) {

                dbm.MS("Megáll!\nA megnyert pénzösszeg: " + winprice[i] + " Forint. \nGratulálok!");
                saveplayermoney();

                return decision;
            }
            return decision;
        }

        if (money == winprice[15]) {
            endbtn.setVisible(true);
        }
        return decision;
    }

    /**
     * <p>
     * printRandomNumbers.</p>
     *
     * @param n a int.
     * @param maxRange a int.
     * @return an array of {@link int} objects.
     */
    public int[] printRandomNumbers(int n, int maxRange) {
        assert n <= maxRange : "cannot get more unique numbers than the size of the range";
        int[] result = new int[n];
        Set<Integer> used = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            int newRandom;
            do {
                newRandom = gen.nextInt(maxRange + 1);
            } while (used.contains(newRandom));
            result[i] = newRandom;
            used.add(newRandom);
        }
        return result;
    }

    /**
     * <p>
     * playerhelp1.</p>
     *
     * @param btn1 a {@link javax.swing.JButton} object.
     * @param btn2 a {@link javax.swing.JButton} object.
     * @param btn3 a {@link javax.swing.JButton} object.
     * @param btn4 a {@link javax.swing.JButton} object.
     * @param btn5 a {@link javax.swing.JButton} object.
     * @param lA a {@link javax.swing.JLabel} object.
     * @param lB a {@link javax.swing.JLabel} object.
     * @param lC a {@link javax.swing.JLabel} object.
     * @param lD a {@link javax.swing.JLabel} object.
     */
    private boolean ChartMaker() throws IOException {
        JFreeChart barChart = ChartFactory.createBarChart("Nézők által adott eredmények", "Válasz", "Százalék", dataset,
                PlotOrientation.VERTICAL, true, true, false);

        int width = 640;
        int height = 480;

        File BarChart = new File("BarChart.jpeg");
        ChartUtilities.saveChartAsJPEG(BarChart, barChart, width, height);
        return true;
    }

    /**
     * <p>
     * saveplayermoney.</p>
     */
    public void saveplayermoney() {
        GameCon();
        String sql = "";
        if (lose == true) {

            if (checkpoint1 == true) {
                winnedPrice = 250000;
            } else if (checkpoint2 == true) {
                winnedPrice = 2000000;
            } else if (checkpoint1 == false) {
                winnedPrice = 0;
            }
            sql = "INSERT INTO ranking_table(username,point) VALUES('" + SignupDBM.getUsern() + "','" + winnedPrice
                    + "')";
        } else {
            sql = "INSERT INTO ranking_table(username,point) VALUES('" + SignupDBM.getUsern() + "','" + winprice[i]
                    + "')";
        }
        try {

            s = con.createStatement();
            s.execute(sql);
            dbm.MS("Eredmény rögzítve az adatbázisba!");
        } catch (SQLException e) {
            dbm.MS("Eredmény sikertelenül rögzítve az adatbázisba!");
        }
    }

    /**
     * <p>
     * ranking.</p>
     *
     * @param textarea a {@link javax.swing.JTextArea} object.
     */
    public void ranking(JTextArea textarea, JTextArea textarea1) {
        GameCon();
        String sql = "SELECT username, point from ranking_table ORDER BY point desc;";
        ArrayList<String> rank = new ArrayList<>();
        try {
            s = con.createStatement();
            s.execute(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                rank.add(rs.getString("username"));
                rank.add(String.valueOf(rs.getInt("point")));

            }
            rs.close();

        } catch (SQLException e) {
            dbm.MS(e.getMessage());
        }
        for (int i = 0; i < 20; i++) {
            textarea.append(String.valueOf((i + 2) / 2) + "." + "  ");
            textarea.append(String.valueOf(rank.get(i)));
            textarea.append("\n");
            textarea1.append(String.valueOf(rank.get(i + 1)) + " Forint");
            textarea1.append("\n");

            if (i < rank.size()) {
                i++;
            } else {
                break;
            }
        }
    }

    /**
     * <p>
     * endgame.</p>
     */
    public void endgame() {
        if (money == 50000000) {
            dbm.MS("Gratulálok! Megnyerted a főnyereményt! \nA játék véget ért!");
            saveplayermoney();
        }

    }

    /**
     * <p>
     * generate.</p>
     *
     * @param min a int.
     * @param max a int.
     * @return a int.
     */
    public static int generate(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public void playerhelp1(JButton btn1, JButton btn2, JButton btn3, JButton btn4, JButton btn5, JLabel lA, JLabel lB, JLabel lC, JLabel lD) {
        dbm.MS("Felező segítség");
        String[] buttonnames = new String[3];
        Random random = new Random();
        int randomizatedbutton = 0;
        int[] randbut = new int[2];
        int randnum = 0;
        String button = "";

        if (playerhelp1 == 1) {
            playerhelp1--;
            if (btn1.getText().equals(result)) {
                buttonnames[0] = "btn2";
                buttonnames[1] = "btn3";
                buttonnames[2] = "btn4";
            }
            if (btn2.getText().equals(result)) {
                buttonnames[0] = "btn1";
                buttonnames[1] = "btn3";
                buttonnames[2] = "btn4";
            }
            if (btn3.getText().equals(result)) {
                buttonnames[0] = "btn1";
                buttonnames[1] = "btn2";
                buttonnames[2] = "btn4";
            }
            if (btn4.getText().equals(result)) {
                buttonnames[0] = "btn1";
                buttonnames[1] = "btn2";
                buttonnames[2] = "btn3";

            }
            randbut = printRandomNumbers(2, 2);
            for (int i = 0; i < 2; i++) {
                randomizatedbutton = 0;
                button = "";

                randomizatedbutton = random.nextInt(3 - 0) + 0;
                button = buttonnames[randbut[i]];

                if (button.equals("btn1")) {

                    btn1.setVisible(false);
                    lA.setVisible(false);
                }
                if (button.equals("btn2")) {

                    btn2.setVisible(false);
                    lB.setVisible(false);
                }
                if (button.equals("btn3")) {

                    btn3.setVisible(false);
                    lC.setVisible(false);
                }
                if (button.equals("btn4")) {

                    btn4.setVisible(false);
                    lD.setVisible(false);
                }

            }
            btn5.setBackground(new java.awt.Color(153, 153, 153));
        } else {
            dbm.MS("Csak egyszer használható ez a segítség!");

        }

    }

    /**
     * <p>
     * playerhelp2randomizer.</p>
     *
     * @param btn1 a {@link javax.swing.JButton} object.
     * @param btn2 a {@link javax.swing.JButton} object.
     * @param btn3 a {@link javax.swing.JButton} object.
     * @param btn4 a {@link javax.swing.JButton} object.
     * @param btn5 a {@link javax.swing.JButton} object.
     * @return a {@link org.jfree.data.category.CategoryDataset} object.
     * @throws java.io.IOException if any.
     */
    public CategoryDataset playerhelp2randomizer(JButton btn1, JButton btn2, JButton btn3, JButton btn4, JButton btn5)
            throws IOException {
        dbm.MS("Közönség segítsége");
        int max = 100;
        Random rand = new Random();
        int[] percent = new int[4];

        if (playerhelp2 > 0) {
            playerhelp2--;

            if (btn1.getText().equals(result)) {
                max = generate(60, 80);
                percent[0] = max;
                for (int i = 1; i < percent.length; i++) {
                    if (i == 0) {
                        i++;
                    } else {
                        percent[i] = generate(15, 50);
                    }
                }

                dataset.addValue(percent[0], "A", "A");
                dataset.addValue(percent[1], "B", "B");
                dataset.addValue(percent[2], "C", "C");
                dataset.addValue(percent[3], "D", "D");
                if (ChartMaker() == true) {
                    bc.setVisible(true);
                }
            }

            if (btn2.getText().equals(result)) {
                max = generate(60, 80);
                percent[1] = max;
                for (int i = 0; i < percent.length; i++) {
                    if (i == 1) {
                        i++;
                    } else {
                        percent[i] = generate(15, 50);
                    }
                }
                dataset.addValue(percent[0], "A", "A");
                dataset.addValue(percent[1], "B", "B");
                dataset.addValue(percent[2], "C", "C");
                dataset.addValue(percent[3], "D", "D");
                if (ChartMaker() == true) {
                    bc.setVisible(true);
                }
            }

            if (btn3.getText().equals(result)) {
                max = generate(60, 80);
                percent[2] = max;
                for (int i = 0; i < percent.length; i++) {
                    if (i == 2) {
                        i++;
                    } else {
                        percent[i] = generate(15, 50);
                    }
                }
                dataset.addValue(percent[0], "A", "A");
                dataset.addValue(percent[1], "B", "B");
                dataset.addValue(percent[2], "C", "C");
                dataset.addValue(percent[3], "D", "D");
                if (ChartMaker() == true) {
                    bc.setVisible(true);
                }
            }

            if (btn4.getText().equals(result)) {
                max = generate(60, 80);
                percent[3] = max;
                for (int i = 0; i < percent.length; i++) {
                    if (i == 3) {
                        i++;
                    } else {
                        percent[i] = generate(15, 50);
                    }
                }
                dataset.addValue(percent[0], "A", "A");
                dataset.addValue(percent[1], "B", "B");
                dataset.addValue(percent[2], "C", "C");
                dataset.addValue(percent[3], "D", "D");
                if (ChartMaker() == true) {
                    bc.setVisible(true);
                }
            }

            btn5.setBackground(new java.awt.Color(153, 153, 153));

        } else {
            dbm.MS("Csak egyszer használható ez a segítség!");
        }

        return dataset;
    }

    /**
     * <p>
     * playerhelp3.</p>
     *
     * @param btn a {@link javax.swing.JButton} object.
     * @param btn2 a {@link javax.swing.JButton} object.
     * @param btn3 a {@link javax.swing.JButton} object.
     * @param btn4 a {@link javax.swing.JButton} object.
     * @param btn5 a {@link javax.swing.JButton} object.
     */
    public void playerhelp3(JButton btn, JButton btn2, JButton btn3, JButton btn4, JButton btn5) {
        dbm.MS("Telefonos segítség");
        String goodanswer = "";
        if (btn.getText().equals(result)) {
            goodanswer = "A";
        } else if (btn2.getText().equals(result)) {
            goodanswer = "B";
        } else if (btn3.getText().equals(result)) {
            goodanswer = "C";
        } else if (btn4.getText().equals(result)) {
            goodanswer = "D";
        }
        if (!goodanswer.equals("")) {

            if (playerhelp3 > 0) {
                playerhelp3--;
                dbm.MS("Játékos: Szép napot Tanár Úr! Tudna segíteni mi lehet a kérdésre a helyes válasz?\nTanár Úr: Persze Réka adjon egy kis időt! ... \nSzerintem a helyes válasz: "
                        + goodanswer);
                btn5.setBackground(new java.awt.Color(153, 153, 153));
            } else {
                dbm.MS("Csak egyszer használható ez a segítség!");

            }
        }
    }

}
