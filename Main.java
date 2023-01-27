import java.util.*;
import java.lang.Math;
class Main {
  public static Scanner input = new Scanner(System.in);
  public static int pteam=0;
  public static boolean isRunning;
  public static ArrayList<Player> w=new ArrayList<>();
  public static ArrayList<Integer> wovr=new ArrayList<>();
  public static ArrayList<Player> l=new ArrayList<>();
  public static ArrayList<Integer> lovr=new ArrayList<>();

  public static ArrayList<Player> g=new ArrayList<>();
  public static ArrayList<Integer> govr=new ArrayList<>();

  public static ArrayList<Player> n=new ArrayList<>();
  public static ArrayList<Integer> novr=new ArrayList<>();

  public static void main(String[] args) {
    

    System.out.println("Welcome to the Basketball GM Sim!");
    System.out.println("Are you ready to begin? \n(Yes or No)");
    if(yn(input.nextLine())){
      System.out.println("Awesome! Please wait while we prepare...");
      generatePlayers();
      for(Player p:w){
        wovr.add(p.getOverall());
      }
      for(Player p:l){
        lovr.add(p.getOverall());
      }
      for(Player p:g){
        govr.add(p.getOverall());
      }
      for(Player p:n){
        novr.add(p.getOverall());
      }
//      System.out.println("Golden State Warriors:");
//      for(int i=0;i< w.size();i++){
//        System.out.println(i+1+". "+w.get(i));
//      }
//      System.out.println("Los Angeles Lakers:");
//      for(int i=0;i< l.size();i++){
//        System.out.println(i+1+". "+l.get(i));
//      }
//      System.out.println("Memphis Grizzlies:");
//      for(int i=0;i< g.size();i++){
//        System.out.println(i+1+". "+g.get(i));
//      }
//      System.out.println("Denver Nuggets:");
//      for(int i=0;i< n.size();i++){
//        System.out.println(i+1+". "+n.get(i));
//      }
      System.out.println("Which team do you want to play as?\n1. Golden State Warriors\n2. Los Angeles Lakers\n3. Memphis Grizzlies\n4. Denver Nuggets");
      if(input.nextLine().equals("1")){
        pteam=1;
      }
      else if(input.nextLine().equals("2")){
        pteam=2;
      }
      else if(input.nextLine().equals("3")){
        pteam=3;
      }
      else if(input.nextLine().equals("4")){
        pteam=4;
      }
      System.out.println("Which mode would you like to play?\n1. Simulate (Trade and draft players, rework your team, and simulate seasons)\n2. Practice (Choose a player and try their skills)");
      if(input.nextLine().equals("1")){
        isRunning=true;
        simulate(pteam);

      }
//      else if(input.nextLine().equals("2")){
//        practice(pteam);
//      }
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
    int mr;
    if(t==1){
      System.out.println("Welcome to simulation mode.\nYou are now the general manager of the Golden State Warriors.");
      while(isRunning){
        System.out.println("What would you like to do?\n1. View Roster\n2. Trade players\n3. Simulate Game\n4. Simulate Season\n5. Simulate Season + Playoffs\n6. Exit simulation");
        mr=Integer.parseInt(input.nextLine());
        if(mr==1){
          System.out.println("Here is your current roster:");
          for(int i=0;i< w.size();i++) {
            System.out.println(i + 1 + ". " + w.get(i));
          }

        }
        else if(mr==2){
          trade(1);
        }
        else if(mr==3){
          simgame(1,mr);
        }
        else{
          System.out.println("bruhhh");
        }
      }
    }
  }
  public static void simgame(int team, int type){
    //game sim code goes here
  }
  public static void trade(int team){
    int wn;
    int gn;
    int response;
    Player wants;
    Player gives;
    System.out.println("Welcome to the trade menu!");
    if(team==1) {
      System.out.println("Which team would you like to trade with?\n1. LA Lakers\n2. Memphis Grizzlies\n3. Denver Nuggets");
      try {
        response = Integer.parseInt(input.nextLine());
        if (response == 1) {
          System.out.println("Here is the Lakers roster:");
          for (int i = 0; i < l.size(); i++) {
            System.out.println(i + 1 + ". " + l.get(i));
          }
          System.out.println("Which player would you like to trade for?\n(Numbers 1-15)");
          wn = Integer.parseInt(input.nextLine()) - 1;
          wants = l.get(wn);
          System.out.println("Here is your team:");
          for (int i = 0; i < w.size(); i++) {
            System.out.println(i + 1 + ". " + w.get(i));
          }
          System.out.println("Which player will you give up?\n(Numbers 1-15)");
          gn = Integer.parseInt(input.nextLine()) - 1;
          gives = w.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <= 10) {
            w.remove(gn);
            w.add(wants);
            l.remove(wn);
            l.add(gives);
            System.out.println("The Lakers have agreed to your trade!");
          } else {
            System.out.println("Unfortunately, the Lakers have declined your trade.");
          }
          System.out.println("Do you want to make another trade?");
          if (yn(input.nextLine())) {
            trade(team);
          } else {
            System.out.println("Would you like to return to the menu?");
            if (yn(input.nextLine())) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        }
        if (response == 2) {
          System.out.println("Here is the Grizzlies roster:");
          for (int i = 0; i < g.size(); i++) {
            System.out.println(i + 1 + ". " + g.get(i));
          }
          System.out.println("Which player would you like to trade for?\n(Numbers 1-15)");
          wn = Integer.parseInt(input.nextLine()) - 1;
          wants = g.get(wn);
          System.out.println("Here is your team:");
          for (int i = 0; i < w.size(); i++) {
            System.out.println(i + 1 + ". " + w.get(i));
          }
          System.out.println("Which player will you give up?\n(Numbers 1-15)");
          gn = Integer.parseInt(input.nextLine()) - 1;
          gives = w.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <= 10) {
            w.remove(gn);
            w.add(wants);
            g.remove(wn);
            g.add(gives);
            System.out.println("The Grizzlies have agreed to your trade!");
          } else {
            System.out.println("Unfortunately, the Grizzlies have declined your trade.");
          }
          System.out.println("Do you want to make another trade?");
          if (yn(input.nextLine())) {
            trade(team);
          } else {
            System.out.println("Would you like to return to the menu?");
            if (yn(input.nextLine())) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        }
        if (response == 3) {
          System.out.println("Here is the Nuggets roster:");
          for (int i = 0; i < n.size(); i++) {
            System.out.println(i + 1 + ". " + n.get(i));
          }
          System.out.println("Which player would you like to trade for?\n(Numbers 1-15)");
          wn = Integer.parseInt(input.nextLine()) - 1;
          wants = n.get(wn);
          System.out.println("Here is your team:");
          for (int i = 0; i < w.size(); i++) {
            System.out.println(i + 1 + ". " + w.get(i));
          }
          System.out.println("Which player will you give up?\n(Numbers 1-15)");
          gn = Integer.parseInt(input.nextLine()) - 1;
          gives = w.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <= 10) {
            w.remove(gn);
            w.add(wants);
            n.remove(wn);
            n.add(gives);
            System.out.println("The Nuggets have agreed to your trade!");
          } else {
            System.out.println("Unfortunately, the Nuggets have declined your trade.");
          }
          System.out.println("Do you want to make another trade?");
          if (yn(input.nextLine())) {
            trade(team);
          } else {
            System.out.println("Would you like to return to the menu?");
            if (yn(input.nextLine())) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        } else {
          System.out.println("Please pick the number of one of the teams.");
          trade(team);
        }
      }
      catch(Exception e){
        System.out.println("Please enter a number.");
        trade(team);
      }
    }
    if(team==2) {
      System.out.println("Which team would you like to trade with?\n1. Golden State Warriors\n2. Memphis Grizzlies\n3. Denver Nuggets");
      try {
        response = Integer.parseInt(input.nextLine());
        if (response == 1) {
          System.out.println("Here is the Warriors roster:");
          for (int i = 0; i < w.size(); i++) {
            System.out.println(i + 1 + ". " + w.get(i));
          }
          System.out.println("Which player would you like to trade for?\n(Numbers 1-15)");
          wn = Integer.parseInt(input.nextLine()) - 1;
          wants = w.get(wn);
          System.out.println("Here is your team:");
          for (int i = 0; i < l.size(); i++) {
            System.out.println(i + 1 + ". " + l.get(i));
          }
          System.out.println("Which player will you give up?\n(Numbers 1-15)");
          gn = Integer.parseInt(input.nextLine()) - 1;
          gives = l.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <= 10) {
            l.remove(gn);
            l.add(wants);
            w.remove(wn);
            w.add(gives);
            System.out.println("The Warriors have agreed to your trade!");
          } else {
            System.out.println("Unfortunately, the Warriors have declined your trade.");
          }
          System.out.println("Do you want to make another trade?");
          if (yn(input.nextLine())) {
            trade(team);
          } else {
            System.out.println("Would you like to return to the menu?");
            if (yn(input.nextLine())) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        }
        if (response == 2) {
          System.out.println("Here is the Grizzlies roster:");
          for (int i = 0; i < g.size(); i++) {
            System.out.println(i + 1 + ". " + g.get(i));
          }
          System.out.println("Which player would you like to trade for?\n(Numbers 1-15)");
          wn = Integer.parseInt(input.nextLine()) - 1;
          wants = g.get(wn);
          System.out.println("Here is your team:");
          for (int i = 0; i < l.size(); i++) {
            System.out.println(i + 1 + ". " + l.get(i));
          }
          System.out.println("Which player will you give up?\n(Numbers 1-15)");
          gn = Integer.parseInt(input.nextLine()) - 1;
          gives = l.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <= 10) {
            l.remove(gn);
            l.add(wants);
            g.remove(wn);
            g.add(gives);
            System.out.println("The Grizzlies have agreed to your trade!");
          } else {
            System.out.println("Unfortunately, the Grizzlies have declined your trade.");
          }
          System.out.println("Do you want to make another trade?");
          if (yn(input.nextLine())) {
            trade(team);
          } else {
            System.out.println("Would you like to return to the menu?");
            if (yn(input.nextLine())) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        }
        if (response == 3) {
          System.out.println("Here is the Nuggets roster:");
          for (int i = 0; i < n.size(); i++) {
            System.out.println(i + 1 + ". " + n.get(i));
          }
          System.out.println("Which player would you like to trade for?\n(Numbers 1-15)");
          wn = Integer.parseInt(input.nextLine()) - 1;
          wants = n.get(wn);
          System.out.println("Here is your team:");
          for (int i = 0; i < l.size(); i++) {
            System.out.println(i + 1 + ". " + l.get(i));
          }
          System.out.println("Which player will you give up?\n(Numbers 1-15)");
          gn = Integer.parseInt(input.nextLine()) - 1;
          gives = l.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <= 10) {
            l.remove(gn);
            l.add(wants);
            n.remove(wn);
            n.add(gives);
            System.out.println("The Nuggets have agreed to your trade!");
          } else {
            System.out.println("Unfortunately, the Nuggets have declined your trade.");
          }
          System.out.println("Do you want to make another trade?");
          if (yn(input.nextLine())) {
            trade(team);
          } else {
            System.out.println("Would you like to return to the menu?");
            if (yn(input.nextLine())) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        } else {
          System.out.println("Please pick the number of one of the teams.");
          trade(team);
        }
      }
      catch(Exception e){
        System.out.println("Please enter a number.");
        trade(team);
      }
    }
    if(team==3) {
      System.out.println("Which team would you like to trade with?\n1. Golden State Warriors \n2. LA Lakers\n3. Denver Nuggets");
      try {
        response = Integer.parseInt(input.nextLine());
        if (response == 1) {
          System.out.println("Here is the Warriors roster:");
          for (int i = 0; i < w.size(); i++) {
            System.out.println(i + 1 + ". " + w.get(i));
          }
          System.out.println("Which player would you like to trade for?\n(Numbers 1-15)");
          wn = Integer.parseInt(input.nextLine()) - 1;
          wants = w.get(wn);
          System.out.println("Here is your team:");
          for (int i = 0; i < g.size(); i++) {
            System.out.println(i + 1 + ". " + g.get(i));
          }
          System.out.println("Which player will you give up?\n(Numbers 1-15)");
          gn = Integer.parseInt(input.nextLine()) - 1;
          gives = g.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <= 10) {
            g.remove(gn);
            g.add(wants);
            w.remove(wn);
            w.add(gives);
            System.out.println("The Warriors have agreed to your trade!");
          } else {
            System.out.println("Unfortunately, the Warriors have declined your trade.");
          }
          System.out.println("Do you want to make another trade?");
          if (yn(input.nextLine())) {
            trade(team);
          } else {
            System.out.println("Would you like to return to the menu?");
            if (yn(input.nextLine())) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        }
        if (response == 2) {
          System.out.println("Here is the Lakers roster:");
          for (int i = 0; i < l.size(); i++) {
            System.out.println(i + 1 + ". " + l.get(i));
          }
          System.out.println("Which player would you like to trade for?\n(Numbers 1-15)");
          wn = Integer.parseInt(input.nextLine()) - 1;
          wants = l.get(wn);
          System.out.println("Here is your team:");
          for (int i = 0; i < g.size(); i++) {
            System.out.println(i + 1 + ". " + g.get(i));
          }
          System.out.println("Which player will you give up?\n(Numbers 1-15)");
          gn = Integer.parseInt(input.nextLine()) - 1;
          gives = g.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <= 10) {
            g.remove(gn);
            g.add(wants);
            l.remove(wn);
            l.add(gives);
            System.out.println("The Lakers have agreed to your trade!");
          } else {
            System.out.println("Unfortunately, the Lakers have declined your trade.");
          }
          System.out.println("Do you want to make another trade?");
          if (yn(input.nextLine())) {
            trade(team);
          } else {
            System.out.println("Would you like to return to the menu?");
            if (yn(input.nextLine())) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        }
        if (response == 3) {
          System.out.println("Here is the Nuggets roster:");
          for (int i = 0; i < n.size(); i++) {
            System.out.println(i + 1 + ". " + n.get(i));
          }
          System.out.println("Which player would you like to trade for?\n(Numbers 1-15)");
          wn = Integer.parseInt(input.nextLine()) - 1;
          wants = n.get(wn);
          System.out.println("Here is your team:");
          for (int i = 0; i < g.size(); i++) {
            System.out.println(i + 1 + ". " + g.get(i));
          }
          System.out.println("Which player will you give up?\n(Numbers 1-15)");
          gn = Integer.parseInt(input.nextLine()) - 1;
          gives = g.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <= 10) {
            g.remove(gn);
            g.add(wants);
            n.remove(wn);
            n.add(gives);
            System.out.println("The Nuggets have agreed to your trade!");
          } else {
            System.out.println("Unfortunately, the Nuggets have declined your trade.");
          }
          System.out.println("Do you want to make another trade?");
          if (yn(input.nextLine())) {
            trade(team);
          } else {
            System.out.println("Would you like to return to the menu?");
            if (yn(input.nextLine())) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        } else {
          System.out.println("Please pick the number of one of the teams.");
          trade(team);

        }
      }
      catch(Exception e){
        System.out.println("Please enter a number.");
        trade(team);
      }
    }
    if(team==4) {
      System.out.println("Which team would you like to trade with?\n1. Golden State Warriors \n2. LA Lakers\n3. Memphis Grizzlies");
      try {
        response = Integer.parseInt(input.nextLine());
        if (response == 1) {
          System.out.println("Here is the Warriors roster:");
          for (int i = 0; i < w.size(); i++) {
            System.out.println(i + 1 + ". " + w.get(i));
          }
          System.out.println("Which player would you like to trade for?\n(Numbers 1-15)");
          wn = Integer.parseInt(input.nextLine()) - 1;
          wants = w.get(wn);
          System.out.println("Here is your team:");
          for (int i = 0; i < n.size(); i++) {
            System.out.println(i + 1 + ". " + n.get(i));
          }
          System.out.println("Which player will you give up?\n(Numbers 1-15)");
          gn = Integer.parseInt(input.nextLine()) - 1;
          gives = n.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <= 10) {
            n.remove(gn);
            n.add(wants);
            w.remove(wn);
            w.add(gives);
            System.out.println("The Warriors have agreed to your trade!");
          } else {
            System.out.println("Unfortunately, the Warriors have declined your trade.");
          }
          System.out.println("Do you want to make another trade?");
          if (yn(input.nextLine())) {
            trade(team);
          } else {
            System.out.println("Would you like to return to the menu?");
            if (yn(input.nextLine())) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        }
        if (response == 2) {
          System.out.println("Here is the Lakers roster:");
          for (int i = 0; i < l.size(); i++) {
            System.out.println(i + 1 + ". " + l.get(i));
          }
          System.out.println("Which player would you like to trade for?\n(Numbers 1-15)");
          wn = Integer.parseInt(input.nextLine()) - 1;
          wants = l.get(wn);
          System.out.println("Here is your team:");
          for (int i = 0; i < n.size(); i++) {
            System.out.println(i + 1 + ". " + n.get(i));
          }
          System.out.println("Which player will you give up?\n(Numbers 1-15)");
          gn = Integer.parseInt(input.nextLine()) - 1;
          gives = n.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <= 10) {
            n.remove(gn);
            n.add(wants);
            l.remove(wn);
            l.add(gives);
            System.out.println("The Lakers have agreed to your trade!");
          } else {
            System.out.println("Unfortunately, the Lakers have declined your trade.");
          }
          System.out.println("Do you want to make another trade?");
          if (yn(input.nextLine())) {
            trade(team);
          } else {
            System.out.println("Would you like to return to the menu?");
            if (yn(input.nextLine())) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        }
        if (response == 3) {
          System.out.println("Here is the Grizzlies roster:");
          for (int i = 0; i < g.size(); i++) {
            System.out.println(i + 1 + ". " + g.get(i));
          }
          System.out.println("Which player would you like to trade for?\n(Numbers 1-15)");
          wn = Integer.parseInt(input.nextLine()) - 1;
          wants = g.get(wn);
          System.out.println("Here is your team:");
          for (int i = 0; i < n.size(); i++) {
            System.out.println(i + 1 + ". " + n.get(i));
          }
          System.out.println("Which player will you give up?\n(Numbers 1-15)");
          gn = Integer.parseInt(input.nextLine()) - 1;
          gives = n.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <= 10) {
            n.remove(gn);
            n.add(wants);
            g.remove(wn);
            g.add(gives);
            System.out.println("The Nuggets have agreed to your trade!");
          } else {
            System.out.println("Unfortunately, the Nuggets have declined your trade.");
          }
          System.out.println("Do you want to make another trade?");
          if (yn(input.nextLine())) {
            trade(team);
          } else {
            System.out.println("Would you like to return to the menu?");
            if (yn(input.nextLine())) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        } else {
          System.out.println("Please pick the number of one of the teams.");
          trade(team);
        }
      }
      catch(Exception e){
        System.out.println("Please enter a number.");
        trade(team);
      }
    }
    else{
      System.out.println("error");
    }
  }
  public static void generatePlayers(){
    System.out.println("Generating random players...");
    for(int i=0;i<5;i++){
      for(int x=0;x<15;x++){
        String rname=randomName();
        if(i==0){
          w.add(new Player(rname,(int)(Math.random()*19+19),(int)(Math.random()*21+67),(int)(Math.random()*133+150),(int)(Math.random()*50+50),(int)(Math.random()*50+50),(int)(Math.random()*50+50)));
        }
        if(i==1){
          l.add(new Player(rname,(int)(Math.random()*19+19),(int)(Math.random()*21+67),(int)(Math.random()*133+150),(int)(Math.random()*50+50),(int)(Math.random()*50+50),(int)(Math.random()*50+50)));
        }
        if(i==2){
          g.add(new Player(rname,(int)(Math.random()*19+19),(int)(Math.random()*21+67),(int)(Math.random()*133+150),(int)(Math.random()*50+50),(int)(Math.random()*50+50),(int)(Math.random()*50+50)));
        }
        if(i==3){
          n.add(new Player(rname,(int)(Math.random()*19+19),(int)(Math.random()*21+67),(int)(Math.random()*133+150),(int)(Math.random()*50+50),(int)(Math.random()*50+50),(int)(Math.random()*50+50)));
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
  public static int abs(int z){
    return java.lang.Math.abs(z);
  }
    
}  