import java.io.IOException;
import java.util.Arrays;
import java.io.FileWriter; 
import java.util.ArrayList;

public class Records extends BankRecords {
  //declare FileWriter object 
  static FileWriter fw = null;

  public Records(){
    //create file in try block and error handling 
    try{
      //Instantiate object that will create file called "bankrecords.txt"
      fw = new FileWriter ("bankrecords.txt");
    }catch(IOException e){
      e.printStackTrace();
    }
  }

  public static void main(String[] args){
    //Instantiate Record object
    Records br = new  Records();
    br.readData();
    // call analytic methods 
    AvgComp();
    FemComp();
    MaleComp();

    //close FileWriter object and error handling 
    try{
      fw.close();
    }catch(IOException e){
      e.printStackTrace();
    }
  }

  private static void AvgComp() {
    //sort array by gender
		Arrays.sort(robjs, new SexComparator());

		// set up needed variables to gather counts & income by sex 
		// to determine average income by sex
          
    int maleCt = 0, femCt = 0;
    double maleInc =0, femInc = 0;
     
    //check for gender and icnrement count as well as income
		for (int i = 0; i < robjs.length; i++)
			if (robjs[i].getSex().equals("FEMALE")) {
				++femCt;
				femInc += robjs[i].getIncome();
			}  
			else {
				++maleCt;
        maleInc += robjs[i].getIncome();
				
			}
			 
		// display resulting averages to console and to file
		 
		System.out.printf("Avg inc. for Females: $%.2f \n" , (femInc/femCt) );
    System.out.printf("Avg inc. for Males: $%.2f \n" , (maleInc/maleCt) );

		try {
			fw.write("Avg inc. for Females: $" + String.format("%.2f",femInc/femCt) +"\n");
			fw.write("Avg inc. for Males: $" + String.format("%.2f",maleInc/maleCt)+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

  private static void FemComp() { //number of females with a mortgage and savings account
    //sort by gender
		Arrays.sort(robjs, new SexComparator());
    //var to keep track of count
    int femCount = 0;
    //check for female with mortgage and savings account   
		for (int i = 0; i < robjs.length; i++)
			if (robjs[i].getSex().equals("FEMALE") && robjs[i].getMortgage().equals("YES") && robjs[i].getSave_act().equals("YES")) {
				femCount++;
			}  
			
		//display resulting female count to console and to file 
		System.out.printf("Number of females with a mortgage and savings account: " + femCount + " \n");
    
		try {
			fw.write("Number of females with a mortgage and savings account: " + femCount + " \n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

  private static void MaleComp() { //number of males with both a car and 1 child per location
    //sort array by location
		Arrays.sort(robjs, new LocationComparator());
    //to store regions 
		ArrayList<String> regions = new ArrayList<String>();
    // variables to keep count per region     
    int r1 = 0, r2 = 0, r3 = 0, r4 =0;
    //attain all unique regions and store them in arrayList
		for (int i = 0; i < robjs.length; i++){
			if (!regions.contains(robjs[i].getRegion())) {
				regions.add(robjs[i].getRegion());
			}  
			}
    //look for no. of males with car and 1 child per region in the region ArrayList
    for (int i = 0; i < robjs.length; i++){
      if (robjs[i].getRegion().equals(regions.get(0)) && robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getChildren()==1 ) {
        r1++;
      }  
      if (robjs[i].getRegion().equals(regions.get(1)) && robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getChildren()==1 ) {
        r2++;
      } 
      if (robjs[i].getRegion().equals(regions.get(2)) && robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getChildren()==1 ) {
        r3++;
      } 
      if (robjs[i].getRegion().equals(regions.get(3)) && robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getChildren()==1 ) {
        r4++;
      } 
    }
		 
		//System.out.println(regions);
    //print no. of males with car and 1 child per region to console 
    System.out.printf("Number of males with both a car and one child in a " +regions.get(0)+ " location: " + r1 + " \n");
    System.out.printf("Number of males with both a car and one child in a " +regions.get(1)+ " location: " + r2 + " \n");
    System.out.printf("Number of males with both a car and one child in a " +regions.get(2)+ " location: " + r3 + " \n");
    System.out.printf("Number of males with both a car and one child in a " +regions.get(3)+ " location: " + r4 + " \n");
		
    //write to file the no. of males with car and 1 child per region. includes a try catch block for error handling
    try {
			fw.write("Number of males with both a car and one child in a " +regions.get(0)+ " location: " + r1 + " \n");
      fw.write("Number of males with both a car and one child in a " +regions.get(1)+ " location: " + r2 + " \n");
      fw.write("Number of males with both a car and one child in a " +regions.get(2)+ " location: " + r3 + " \n");
      fw.write("Number of males with both a car and one child in a " +regions.get(3)+ " location: " + r4 + " \n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}



