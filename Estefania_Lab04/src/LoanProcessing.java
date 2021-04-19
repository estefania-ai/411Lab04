import java.sql.ResultSet;
import java.sql.SQLException;
//import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;

public class LoanProcessing extends BankRecords {
  public static void main(String[] args) {
    BankRecords br = new BankRecords();
    br.readData();
    Dao dao = new Dao();
    dao.createTable();
    dao.insertRecords(robjs); // perform inserts
    ResultSet rs = dao.retrieveRecords(); // fill result set object

    // Create heading for display

    // Extract data from result set
    try {
      System.out.printf("%-12s%-12s%-12s\n", "ID:", "INCOME", "PEP");
      while (rs.next()) {
        // Retrieve data by column name (i.e., for id,income,pep)
        String id = rs.getString("id");
        float income = rs.getFloat("income");
        String pep = rs.getString("pep");
        
        // Display values for id,income,pep
  
        System.out.printf("%-12s%-12.2f%-12s\n", id, income, pep );
        
      }

      rs.close(); // closes result set object
    } catch (SQLException se) {
      se.printStackTrace();
    }
  }
}
