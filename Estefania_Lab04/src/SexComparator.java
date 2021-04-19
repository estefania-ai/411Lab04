import java.util.Comparator;

public class SexComparator implements Comparator<BankRecords>
{
  //Comparator to sort BankRecords by gender
  @Override
  public int compare(BankRecords o1, BankRecords o2){
    int result = o1.getRegion().compareTo(o2.getRegion());
    return result;
  }
}
