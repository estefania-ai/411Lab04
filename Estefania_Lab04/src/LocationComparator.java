import java.util.Comparator;
public class LocationComparator implements Comparator<BankRecords>
{
  //Comparator to sort BankRecords by region 
  @Override
  public int compare(BankRecords o1, BankRecords o2){
    int result = o1.getRegion().compareTo(o2.getRegion());
    return result;
  }
}
