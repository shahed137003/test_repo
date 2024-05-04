

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shahd
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
 import java.io.IOException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Ctategories {
   //data fields related to the category
    private ArrayList<SubCategories> subCategories;
    private String NameOfCategory;
    private File fileOfCateg;
    //constructor that reades from an existing files
    public Ctategories(File CategFile) throws FileNotFoundException{
    try {
        // to read the content of a file 
        Scanner scanner = new Scanner(fileOfCateg);
        while (scanner.hasNextLine()) {
            this.fileOfCateg= CategFile;
            this.NameOfCategory = scanner.nextLine();
          for(int i=0;i<subCategories.size();i++)
          {
          this.subCategories.add(new SubCategories(new File(scanner.nextLine())));
          
          }
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
      
    }
    // the constuctors related to the categories
   public Ctategories(String NameOfCategory,ArrayList<SubCategories> subCategories)  throws  IOException
   {
        this.NameOfCategory=NameOfCategory;
        this.subCategories=subCategories;
         File fileCaetegoy =new File("..\\DataFiles\\Products\\"+NameOfCategory+".txt") ;
         if(fileCaetegoy.exists())
         { this.fileOfCateg=fileCaetegoy;
         }
         else{
        try{
           
        FileWriter writer = new FileWriter("..\\DataFiles\\Products\\" + NameOfCategory + ".txt",true);
         File file =new File("..\\DataFiles\\Products\\"+NameOfCategory+".txt") ;
         BufferedWriter bufferedWriter = new BufferedWriter(writer);
  bufferedWriter.write(NameOfCategory);
    for(int i=0;i<subCategories.size();i++)
    {
        //we will add the path of the directory of the sub categories 
    bufferedWriter.write("..\\DataFiles\\Products\\"+subCategories.get(i).getNameOfCategory()+".txt"+"\n");
    }
     bufferedWriter.flush();
            
            bufferedWriter.close();
      writer.close();
        }
      
        catch(IOException  e){
        System.out.println("please ckeck the error");
         
        }
         }
    
    }

    public ArrayList<SubCategories> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(ArrayList<SubCategories> subCategories) {
        this.subCategories = subCategories;
    }

    public String getNameOfCategory() {
        return NameOfCategory;
    }

    public void setNameOfCategory(String NameOfCategory) {
        this.NameOfCategory = NameOfCategory;
    }
    
   public void PrintDetails(){
   
   System.out.println("the name of the Category "+NameOfCategory);
   for(int i=0;i<subCategories.size();i++)
   {
     subCategories.get(i).printCateroryDetails();
   }
   }

//search category we can use the following methodes
void SearchCategory()
{  
    Scanner input=new Scanner(System.in);
    System.out.println("please enter the desired category :");
    String SearchedCategory=input.nextLine();
File CategFile=new File("..\\DataFiles\\Products\\"+SearchedCategory+".txt");
    if(CategFile.exists())
    PrintDetails();
    
    else{
   System.out.println("this category does not exist please try again:)");
   
    SearchCategory();
    }

}



}
