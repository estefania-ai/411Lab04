import java.io.*;  
import java.util.*; // import everything including List and ArrayList
import java.io.BufferedReader; //import Buffer for reading file 
import java.io.FileReader; //for reading file 
import java.io.IOException; //exception handling 

public class BankRecords extends Client{
  //array of BankRecords objects
  static BankRecords robjs[] = new BankRecords[600]; 
  //arraylist to hold spreadsheet rows & columns
  static ArrayList<List<String>> array = new ArrayList<>(); 

  //instance fields
  private String id;
  private int age;
  private String sex;
  private String region;
  private double income;
  private String married;
  private int children;
  private String car;
  private String save_act;
  private String current_act;
  private String mortgage;
  private String pep; 
  
  //getter and setter methods for the instance fields 
  public String getId(){
    return this.id;
  }
  public void setId(String id){
    this.id=id;
  }
  public int getAge(){
    return this.age;
  }
  public void setAge(int age){
    this.age=age;
  }
  public String getSex(){
    return this.sex;
  }
  public void setSex(String sex){
    this.sex=sex;
  }
  public String getRegion(){
    return this.region;
  }
  public void setRegion(String region){
    this.region=region;
  }
  public double getIncome(){
    return this.income;
  }
  public void setIncome(double inc){
    this.income=inc;
  }
  public String getMarried(){
    return this.married;
  }
  public void setMarried(String mar){
    this.married=mar;
  }
  public int getChildren(){
    return this.children;
  }
  public void setChildren(int child){
    this.children=child;
  }
  public String getCar(){
    return this.car;
  }
  public void setCar(String car){
    this.car=car;
  }
  public String getSave_act(){
    return this.save_act;
  }
  public void setSave_act(String sa){
    this.save_act=sa;
  }
  public String getCurrent_act(){
    return this.current_act;
  }
  public void setCurrent_act(String ca){
    this.current_act=ca;
  }
  public String getMortgage(){
    return this.mortgage;
  }
  public void setMortgage(String mort){
    this.mortgage=mort;
  }
  public String getPep(){
    return this.pep;
  }
  public void setPep(String p){
    this.pep=p;
  }
  
  //read file and add data to arraylist 
  public void readData(){
  BufferedReader br = null;
    //try catch block for error handling 
    try{
    //initialize reader object and set file path to root of project
    br = new BufferedReader(new FileReader(new File("/Users/estefanialopez/Desktop/Estefania_Lab04/src/bank-Detail.csv")));
    String line;
           
     //read each record in csv file
     while ((line = br.readLine()) != null) {
            //parse each record in csv file by a comma ( , )
            //into a list stored in the arraylist-> Arrays
                     array.add(Arrays.asList(line.split(",")));
     }
     br.close();
    //check if the file is not found
    }catch(FileNotFoundException e){
      e.printStackTrace();
     //check for any failure with I/O operations 
    }catch (IOException ex){
      ex.printStackTrace();
      }
    
    processData();  //call function for processing record data
  }

  public void processData(){
    //create index for array while iterating thru arraylist
	  int idx=0;
    //create for each loop to cycle thru arraylist of values
    //and PASS that data into your record objects' setters 
  
    for (List<String> rowData: array) {
      //initialize array of objects
      robjs[idx] = new BankRecords();
      //call setters below and populate them, item by item
      robjs[idx].setId(rowData.get(0)); //get 1st column
      robjs[idx].setAge(Integer.parseInt(rowData.get(1))); //get 2nd column
      robjs[idx].setSex(rowData.get(2)); //generate columns using get() method with desired index
      robjs[idx].setRegion(rowData.get(3)); 
      robjs[idx].setIncome(Double.parseDouble(rowData.get(4))); 
      robjs[idx].setMarried(rowData.get(5)); 
      robjs[idx].setChildren(Integer.parseInt(rowData.get(6)));
      robjs[idx].setCar(rowData.get(7)); 
      robjs[idx].setSave_act(rowData.get(8)); 
      robjs[idx].setCurrent_act(rowData.get(9)); 
      robjs[idx].setMortgage(rowData.get(10)); 
      robjs[idx].setPep(rowData.get(11)); 
      
      /*continue processing arraylist item values into each array object-> robjs[] by index*/
      idx++;
  }
}
  public void printData(){
    //Your printData() method should print the first 25 records for various fields to the console via your getters. Print records for the following fields:
    //ID, AGE, SEX, REGION, INCOME, and MORTGAGE.
    //1. Set appropriate headings for displaying first 25 records
		//2. Create for loop and print each record objects instance data 
    //3. Within for loop use appropriate formatting techniques to print
    // out record detail
    System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s\n", "ID", "AGE", "SEX", "REGION", "INCOME", "MORTGAGE");
    
    for(int i=0; i<25; i++){
      System.out.printf("%-12s%-12d%-12s%-12s%-12.2f%-12s\n", robjs[i].getId(), robjs[i].getAge(), robjs[i].getSex(), robjs[i].getRegion(), robjs[i].getIncome(), robjs[i].getMortgage() );
    }
  }



//main method
 public static void main(String[] args) throws Exception  
{  
  //create a BankRecord object to call methods
  BankRecords rec= new BankRecords();
  //call all methods, readData() calls processData() so we dont call processData() here
  //error handling done in readData() method
  rec.readData();
  rec.printData();

}

}