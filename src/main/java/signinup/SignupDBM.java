package signinup;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JTextField;

import deckCreate.*;
import game.GameAlgorithms;

/**
 * <p>
 * SignupDBM class.</p>
 *
 * @author rekat
 * @version $Id: $Id
 */
public class SignupDBM {

    private Connection con = null;
    private Statement s = null;
    private ResultSet rs = null;
    private ArrayList a = new ArrayList();
    private static String usern;
    private String passw;
    private static MessageDigest md;
    DBM dbm = new DBM();
    GameAlgorithms GA = new GameAlgorithms();

    /**
     * <p>
     * Con2.</p>
     */
    public void Con2() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://87.229.115.62:3306/cardgame?serverTimezone=UTC",
                    "treka", "szakdoga2021");
            //dbm.MS("Sikeres csatlakozás a szerverre");
        } catch (SQLException e) {
            //dbm.MS("Sikertelen csatlakozás a szerverre");
        }
    }

    /**
     * <p>
     * Getter for the field <code>usern</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public static String getUsern() {
        return usern;
    }

    /**
     * <p>
     * Setter for the field <code>usern</code>.</p>
     *
     * @param usern a {@link java.lang.String} object.
     */
    public void setUsern(String usern) {
        this.usern = usern;
    }

    /**
     * <p>
     * Getter for the field <code>passw</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPassw() {
        return passw;
    }

    /**
     * <p>
     * Setter for the field <code>passw</code>.</p>
     *
     * @param passw a {@link java.lang.String} object.
     */
    public void setPassw(String passw) {
        this.passw = passw;
    }

    /**
     * <p>
     * UsernameValidator.</p>
     */
    public void UsernameValidator() {
        dbm.Con();
        String selection = "Select username from users";
        String k1 = "";

        try {

            s = con.createStatement();
            rs = s.executeQuery(selection);

            while (rs.next()) {
                k1 = rs.getString("username");
                a.add(k1);
                k1 = null;

            }
            rs.close();
        } catch (SQLException e) {
            dbm.MS(e.getMessage());

        }
    }

    /**
     * <p>
     * LoginValidator.</p>
     *
     * @param t1 a {@link javax.swing.JTextField} object.
     */
    public void LoginValidator(JTextField t1) {
        dbm.Con();
        String selection = "Select username,password from users where username ='" + t1.getText() + "' ";

        try {

            s = con.createStatement();
            rs = s.executeQuery(selection);

            while (rs.next()) {
                setUsern(rs.getString("username"));
                setPassw(rs.getString("password"));

            }
            rs.close();
        } catch (SQLException e) {
            dbm.MS(e.getMessage());

        }
    }

    /**
     * <p>
     * UserInsert.</p>
     *
     * @param t1 a {@link javax.swing.JTextField} object.
     * @param t2 a {@link javax.swing.JTextField} object.
     * @param t3 a {@link javax.swing.JTextField} object.
     * @param t4 a {@link javax.swing.JTextField} object.
     */
    public void UserInsert(JTextField t1, JTextField t2, JTextField t3, JTextField t4) {
        String pw = t2.getText();
        pw = Crypting(pw);
        String username = t1.getText();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        Con2();
        String sql = "INSERT INTO users(username,password,Name,faculty,RegDate) VALUES('" + t1.getText() + "','" + pw
                + "','" + t3.getText() + "','" + t4.getText() + "','" + date + "')";
        boolean exist = false;
        UsernameValidator();

        for (int i = 0; i < a.size(); i++) {

            if (username.equals(a.get(i))) {

                dbm.MS("Ez a felhasználó már létezik! \nVálassz újat!");
                exist = true;

            }

        }
        if (exist == false) {

            try {

                s = con.createStatement();
                s.execute(sql);
                dbm.MS("Sikeresen rögzítve az adatbázisba!");
            } catch (SQLException e) {
                dbm.MS("Sikertelenül rögzítve az adatbázisba!");
            }

        }

    }

    /**
     * <p>
     * LogIn.</p>
     *
     * @param t1 a {@link javax.swing.JTextField} object.
     * @param t2 a {@link javax.swing.JTextField} object.
     * @return a boolean.
     */
    public boolean LogIn(JTextField t1, JTextField t2) {
        Con2();
        LoginValidator(t1);
        String username = t1.getText();
        String pw = Crypting(t2.getText());
        boolean correct = false;

        if (username.equals(usern)) {
            if (pw.equals(passw)) {
                GA.setPlayername(username);
                dbm.MS("Sikeres volt a bejelentkezés! \nÜdvözöllek a rendszerben: " + username + " !");
                correct = true;

            } else {
                dbm.MS("Nem megfelelő a jelszó!");
                correct = false;
            }
        } else {
            dbm.MS("Nem megfelelő a felhasználónév, \n vagy nincs még regisztrálva!");
            correct = false;
        }
        return correct;

    }

    /**
     * <p>
     * Crypting.</p>
     *
     * @param passw a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public String Crypting(String passw) {
        String pw = "";
        String algorithm = "SHA";

        byte[] plainText = passw.getBytes();

        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);

            md.reset();
            md.update(plainText);
            byte[] encodedPassword = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < encodedPassword.length; i++) {
                if ((encodedPassword[i] & 0xff) < 0x10) {
                    sb.append("0");
                }

                pw = String.valueOf(sb.append(Long.toString(encodedPassword[i] & 0xff, 16)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pw;
    }

}
