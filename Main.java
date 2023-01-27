import java.util.*;
class Main {
  public static Scanner input = new Scanner(System.in);
  public static int pteam=0;
  public static boolean isRunning;
  public static ArrayList<Player> warriors=new ArrayList<>();
  public static ArrayList<Integer> wovr=new ArrayList<>();
  public static ArrayList<Player> lakers=new ArrayList<>();
  public static ArrayList<Integer> lovr=new ArrayList<>();

  public static ArrayList<Player> grizzlies=new ArrayList<>();
  public static ArrayList<Integer> govr=new ArrayList<>();

  public static ArrayList<Player> nuggets=new ArrayList<>();
  public static ArrayList<Integer> novr=new ArrayList<>();

  public static void main(String[] args) {
    

    System.out.println("Welcome to the Basketball GM Sim!");
    System.out.println("Are you ready to begin? \n(Yes or No)");
    if(yn(input.nextLine())){
      System.out.println("Awesome! Please wait while we prepare...");
      generatePlayers();
      for(Player p:warriors){
        wovr.add(p.getOverall());
      }
      for(Player p:lakers){
        lovr.add(p.getOverall());
      }
      for(Player p:grizzlies){
        govr.add(p.getOverall());
      }
      for(Player p:nuggets){
        novr.add(p.getOverall());
      }
      System.out.println("Golden State Warriors:");
      for(int i=0;i< warriors.size();i++){
        System.out.println(i+1+". "+warriors.get(i));
      }
      System.out.println("Los Angeles Lakers:");
      for(int i=0;i< lakers.size();i++){
        System.out.println(i+1+". "+lakers.get(i));
      }
      System.out.println("Memphis Grizzlies:");
      for(int i=0;i< grizzlies.size();i++){
        System.out.println(i+1+". "+grizzlies.get(i));
      }
      System.out.println("Denver Nuggets:");
      for(int i=0;i< nuggets.size();i++){
        System.out.println(i+1+". "+nuggets.get(i));
      }
      System.out.println("Which team do you want to play as?\n1. Golden State Warriors\n2. Los Angeles Lakers\n3. Memphis Grizzlies\n4. Denver Nuggets");
      if(input.nextLine().equals("1")){
        pteam=1;
      }
      if(input.nextLine().equals("2")){
        pteam=2;
      }
      if(input.nextLine().equals("3")){
        pteam=3;
      }
      if(input.nextLine().equals("4")){
        pteam=4;
      }
      System.out.println("Which mode would you like to play?\n1. Simulate (Trade and draft players, rework your team, and simulate seasons)\n2. Practice(Choose a player and try their skills)");
      if(input.nextLine().equals("1")){
        simulate(pteam);
        isRunning=true;
      }
      else if(input.nextLine().equals("2")){
        practice(pteam);
      }
    }
    else{
      System.out.println("That's too bad.");
      if(eq()){
        System.out.println("bruh");
      }
    }
  }
  public static void simulate(int t){
    int games=0;
    int wn;
    int gn;
    Player wants;
    Player gives;
    if(t==1){
      System.out.println("Welcome to simulation mode.\nYou are now the general manager of the Golden State Warriors.");
      while(isRunning){
        if(games==0){
          System.out.println("        Preseason        \nWhat would you like to do?\n1. View Roster\n2. Trade players\n3. Simulate Game\n4. Simulate Season\n5. Simulate Season + Playoffs\n6. Exit simulation");
          if(input.nextLine().equals("1")){
            System.out.println("Here is your current roster:");
            for(int i=0;i< warriors.size();i++) {
              System.out.println(i + 1 + ". " + warriors.get(i));
            }
          }
          if(input.nextLine().equals("2")){
            System.out.println("Which team would you like to trade with?\n1. LA Lakers\n2. Memphis Grizzlies\n3. Denver Nuggets");
            if(input.nextLine().equals("1")){
              System.out.println("Here is the Lakers roster:");
              for(int i=0;i< lakers.size();i++){
                System.out.println(i+1+". "+lakers.get(i));
              }
              System.out.println("Which player would you like to trade for?\n(Numbers 1-15)");
              wn=Integer.parseInt(input.nextLine())-1;
              wants=lakers.get(wn);
              System.out.println("Here is your team:");
              for(int i=0;i< warriors.size();i++) {
                System.out.println(i + 1 + ". " + warriors.get(i));
              }
              System.out.println("Which player will you give up?\n(Numbers 1-15)");
              gn=Integer.parseInt(input.nextLine())-1;
              gives=warriors.get(gn);
              if(abs(wants.getOverall()-gives.getOverall())<=10){
                warriors.remove(gn);
                warriors.add(wants);
                lakers.remove(wn);
                lakers.add(gives);
                System.out.println("The Lakers have agreed to your trade!");
              }
              else{
                System.out.println("Unfortunately, the Lakers have declined your trade.");
              }
              System.out.println("Do you want to make another trade?");
              if()
            }
          }
        }
      }
    }
  }
  public static void generatePlayers(){
    System.out.println("Generating random players...");
    for(int i=0;i<5;i++){
      for(int x=0;x<15;x++){
        String rname=randomName();
        if(i==0){
          warriors.add(new Player(rname,(int)(Math.random()*19+19),(int)(Math.random()*21+67),(int)(Math.random()*133+150),(int)(Math.random()*50+50),(int)(Math.random()*50+50),(int)(Math.random()*50+50)));
        }
        if(i==1){
          lakers.add(new Player(rname,(int)(Math.random()*19+19),(int)(Math.random()*21+67),(int)(Math.random()*133+150),(int)(Math.random()*50+50),(int)(Math.random()*50+50),(int)(Math.random()*50+50)));
        }
        if(i==2){
          grizzlies.add(new Player(rname,(int)(Math.random()*19+19),(int)(Math.random()*21+67),(int)(Math.random()*133+150),(int)(Math.random()*50+50),(int)(Math.random()*50+50),(int)(Math.random()*50+50)));
        }
        if(i==3){
          nuggets.add(new Player(rname,(int)(Math.random()*19+19),(int)(Math.random()*21+67),(int)(Math.random()*133+150),(int)(Math.random()*50+50),(int)(Math.random()*50+50),(int)(Math.random()*50+50)));
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
    return yn(i.nextLine());
  }

  public static String randomName(){
    String[] fns={"James","Robert","John","Michael","David","William","Richard","Joseph","Thomas","Daniel","Anthony","Mark","Steven","Paul","Andrew","George","Timothy","Jason","Ryan","Jacob","Gary","Eric","Larry","Scott","Justin","Frank","Brandon","Jack","Dennis","Jerry","Bob","Jeff","Lalith","Bryan"};
    String[] lns={"Smith","Johnson","Williams","Brown","Jones","Miller","Davis","Garcia","Lopez","Wilson","Anderson","Thomas","Jackson","Martin","Lee","Thompson","Harris","Clark","Lewis","Robinson","Walker","Allen","King","Wright","Scott","Torres","Hill","Adams","Olebe","Sasubili","Thai"};
    return fns[(int)(Math.random()*fns.length)]+" "+lns[(int)(Math.random()*lns.length)];
  }
    
}  