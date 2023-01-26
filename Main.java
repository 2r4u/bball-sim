import java.util.*;
class Main {
  public static ArrayList<Player> t1=new ArrayList<Player>();
  public static ArrayList<Player> t2=new ArrayList<Player>();
  public static ArrayList<Player> t3=new ArrayList<Player>();
  public static ArrayList<Player> t4=new ArrayList<Player>();
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to the Basketball GM Sim!");
    System.out.println("Are you ready to begin? \n(Yes or No)");
    if(yn(input.nextLine())){
      System.out.println("Awesome! Please wait while we prepare...");
      generatePlayers();
      for(int i=0;i<t1.size();i++){
        System.out.println(t1.get(i));
      }
      for(int i=0;i<t2.size();i++){
        System.out.println(t2.get(i));
      }
      
    }
    else{
      System.out.println("That's too bad.");
      if(eq()){
        System.out.println("bruh");
      }
    }
  }
  public static void generatePlayers(){
    System.out.println("Generating random players...");
    for(int i=0;i<5;i++){
      for(int x=0;x<16;x++){
        String rname=randomName();
        if(i==0){
          t1.add(new Player(rname,(int)(Math.random()*19+19),(int)(Math.random()*21+67),(int)(Math.random()*133+200),(int)(Math.random()*50+50),(int)(Math.random()*50+50),(int)(Math.random()*50+50)));
        }
        if(i==1){
          t2.add(new Player(rname,(int)(Math.random()*19+19),(int)(Math.random()*21+67),(int)(Math.random()*133+200),(int)(Math.random()*50+50),(int)(Math.random()*50+50),(int)(Math.random()*50+50)));
        }
        if(i==2){
          t3.add(new Player(rname,(int)(Math.random()*19+19),(int)(Math.random()*21+67),(int)(Math.random()*133+200),(int)(Math.random()*50+50),(int)(Math.random()*50+50),(int)(Math.random()*50+50)));
        }
        if(i==3){
          t4.add(new Player(rname,(int)(Math.random()*19+19),(int)(Math.random()*21+67),(int)(Math.random()*133+200),(int)(Math.random()*50+50),(int)(Math.random()*50+50),(int)(Math.random()*50+50)));
        }
      }
    }
    
  }
  public static boolean yn(String str){
    String[] ys={"yes","y","yup","yeah"};
    String[] ns={"no","n","nope","nah"};
    for(int i=0;i<4;i++){
      if(str.toLowerCase().equals(ys[i])){
        return true;
      }
      else if(str.toLowerCase().equals(ns[i])){
        return false;
      }
    }
    return false;
  }
  public static boolean eq(){
    Scanner i = new Scanner(System.in);
    System.out.println("Do you want to exit?");
    if(yn(i.nextLine())){
      return true;
    }
    return false;
  }
  public static String randomName(){
    String[] fns={"James","Robert","John","Michael","David","William","Richard","Joseph","Thomas","Daniel","Anthony","Mark","Steven","Paul","Andrew","George","Timothy","Jason","Ryan","Jacob","Gary","Eric","Larry","Scott","Justin","Frank","Brandon","Jack","Dennis","Jerry","Bob","Jeff","Lalith","Bryan"};
    String[] lns={"Smith","Johnson","Williams","Brown","Jones","Miller","Davis","Garcia","Lopez","Wilson","Anderson","Thomas","Jackson","Martin","Lee","Thompson","Harris","Clark","Lewis","Robinson","Walker","Allen","King","Wright","Scott","Torres","Hill","Adams","Olebe","Sasubili","Thai"};
    return fns[(int)(Math.random()*fns.length)]+" "+lns[(int)(Math.random()*lns.length)];
  }
    
}  