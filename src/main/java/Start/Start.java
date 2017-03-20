package Start;

import java.sql.*;

/**
 * Created by 2540p on 04.10.2016.
 */
public class Start {
    public static void main(String[] args) {
        String nameDB = "crm_database";
        String query = "SELECT*FROM companies";
//        selectQuery(nameDB, query);
//        ArrayList <String> ss = companies();
//        String s = ss.get(0);
//        System.out.println(s);
    }

    //    public static ArrayList selectQuery() {
//        String nameDB = "crm_database";
//        String query = "SELECT*FROM companies";
//        String url = "jdbc:mysql://127.0.0.1:3306";
//        String loginDB = "root";
//        String passwordDB = "root";
//        System.out.println("Загрузка дравера JDBC");
//        Connection conn = null;
//        ArrayList<String> db = new ArrayList<>();
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(url, loginDB, passwordDB);
//            System.out.println("создание оператора");
//            conn.setCatalog(nameDB);
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery(query);
//            ResultSetMetaData rsmd = rs.getMetaData();
//            while (rs.next()) {
//                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//                    String str = rsmd.getColumnName(i);
//                    db.add(rs.getString(str));
//                }
//                System.out.println("\n");
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return db;
//    }
//
//    public static void selectQuery(String nameDB, String query) {
//        String url = "jdbc:mysql://127.0.0.1:3306";
//        String loginDB = "root";
//        String passwordDB = "root";
//        System.out.println("Загрузка дравера JDBC");
//        Connection conn = null;
//        ArrayList <CompaniesServlet> db = new ArrayList<>();
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(url, loginDB, passwordDB);
//            System.out.println("создание оператора");
//            conn.setCatalog(nameDB);
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery(query);
//            ResultSetMetaData rsmd = rs.getMetaData();
//            while (rs.next()) {
//                CompaniesServlet companies = new CompaniesServlet();
//                for (int i = 0; i <= rsmd.getColumnCount(); i++) {
//                    companies.setComp_name(rs.getString("comp_name"));
//                    companies.setComp_address(rs.getString("comp_address"));
//                    companies.setComp_website(rs.getString("comp_website"));
//                    companies.setComp_phone_number("comp_phone_number");
//                    companies.setComp_email("comp_email");
//                    companies.setContact_type("contact_type");
//                }
//                db.add(companies);
//            }
//            for (CompaniesServlet cmp:db){
//                System.out.println(cmp);
//                System.out.println("\n");
//            }
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
