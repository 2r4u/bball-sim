import java.io.IOException;
import java.util.*;
import java.lang.Math;

class Main {
  public static Scanner input = new Scanner(System.in);
  public static int pteam=0;
  public static boolean isRunning;
  public static ArrayList<Player> w=new ArrayList<>();
  public static ArrayList<Integer> wovr=new ArrayList<>();
  public static int wtovr;
  public static ArrayList<Player> l=new ArrayList<>();
  public static ArrayList<Integer> lovr=new ArrayList<>();
  public static int ltovr;

  public static ArrayList<Player> g=new ArrayList<>();
  public static ArrayList<Integer> govr=new ArrayList<>();
  public static int gtovr;

  public static ArrayList<Player> n=new ArrayList<>();
  public static ArrayList<Integer> novr=new ArrayList<>();
  public static int ntovr;

  public static void main(String[] args){
    System.out.println("Welcome to the Basketball GM Sim!");
    Graphics logo=new Graphics();
    logo.setImage("C:\\Users\\2r4u6\\IdeaProjects\\bball sim graphics\\src\\logo.gif");
    System.out.println("Are you ready to begin? \n(Yes or No)");
    if(yn(input.nextLine())) {
      System.out.println("Awesome! Please wait while we prepare...");
      generatePlayers();
      for (Player p : w) {
        wovr.add(p.getOverall());
      }
      for (Player p : l) {
        lovr.add(p.getOverall());
      }
      for (Player p : g) {
        govr.add(p.getOverall());
      }
      for (Player p : n) {
        novr.add(p.getOverall());
      }
      updateTeams();
      mainloop();
    }
    else{
      System.out.println("That's too bad.");
      if(eq()){
        System.out.println("Have a good day!");
        System.exit(0);
      }
    }
  }
  public static void mainloop(){
    int r;
    System.out.println("Which team do you want to play as?\n1. Golden State Warriors\n2. Los Angeles Lakers\n3. Memphis Grizzlies\n4. Denver Nuggets");
    try {
      r=Integer.parseInt(input.nextLine());
      if (r==1) {
        pteam = 1;
      }
      else if (r==2){
        pteam = 2;
      }
      else if (r==3){
        pteam = 3;
      }
      else if (r==4){
        pteam = 4;
      }
      else{
        System.out.println("Please choose a team.");
        if(eq()){
          System.out.println("Have a good day!");
          System.exit(0);
        }
        else{
          mainloop();
        }
      }
      System.out.println("Which mode would you like to play?\n1. Simulate (Trade and draft players, rework your team, and simulate seasons)\n2. Practice (Choose a player and try their skills)");
      r=Integer.parseInt(input.nextLine());
      if (r==1) {
        isRunning = true;
        simulate(pteam);
      }
      else if(r==2){
        practice(pteam);
      }

    }
    catch(Exception e){
      System.out.println("Please enter an number.");
      if(eq()){
        System.out.println("Have a good day!");
        System.exit(0);
      }
      else{
        mainloop();
      }
    }
//      else if(input.nextLine().equals("2")){
//        practice(pteam);
//      }

  }
  public static void simulate(int t){
    int mr;
    if(t==1){
      System.out.println("Welcome to simulation mode.\nYou are now the general manager of the Golden State Warriors.");
      while(isRunning) {
        System.out.println("What would you like to do?\n1. View Roster\n2. Trade players\n3. Simulate Game\n4. Exit simulation");
        try {
          mr = Integer.parseInt(input.nextLine());
          if (mr == 1) {
            System.out.println("Here is your current roster:");
            for (int i = 0; i < w.size(); i++) {
              System.out.println(i + 1 + ". " + w.get(i));
            }

          } else if (mr == 2) {
            trade(1);
          } else if (mr == 3) {
            System.out.println("Which team would you like to play against?\n1. LA Lakers\n2. Memphis Grizzlies\n3. Denver Nuggets");
            try {
              mr = Integer.parseInt(input.nextLine());
              simgame(1,mr);
            } catch (Exception e) {
              System.out.println("Please enter a number.");
              simulate(t);
            }
          }
          else if(mr==4){
            if(eq()){
              mainloop();
            }
          }
          else {
            System.out.println("bruhhh");
          }
        }
        catch(Exception e){
          System.out.println("Please enter a number.");
          simulate(t);
        }
      }
    }
    else if(t==2){
      System.out.println("Welcome to simulation mode.\nYou are now the general manager of the LA Lakers.");
      while(isRunning) {
        System.out.println("What would you like to do?\n1. View Roster\n2. Trade players\n3. Simulate Game\n4. Exit simulation");
        try {
          mr = Integer.parseInt(input.nextLine());
          if (mr == 1) {
            System.out.println("Here is your current roster:");
            for (int i = 0; i < l.size(); i++) {
              System.out.println(i + 1 + ". " + l.get(i));
            }

          } else if (mr == 2) {
            trade(t);
          } else if (mr == 3) {
            System.out.println("Which team would you like to play against?\n1. Golden State Warriors\n2. Memphis Grizzlies\n3. Denver Nuggets");
            try {
              mr = Integer.parseInt(input.nextLine());
              simgame(t,mr);
            } catch (Exception e) {
              System.out.println("Please enter a number.");
              simulate(t);
            }


          }
          else if(mr==4){
            if(eq()){
              mainloop();
            }
          }
          else {
            System.out.println("bruhhh");
          }
        }
        catch(Exception e){
          System.out.println("Please enter a number.");
          simulate(t);
        }
      }
    }
    else if(t==3) {
      System.out.println("Welcome to simulation mode.\nYou are now the general manager of the Memphis Grizzlies.");
      while (isRunning) {
        System.out.println("What would you like to do?\n1. View Roster\n2. Trade players\n3. Simulate Game\n4. Exit simulation");
        try {
          mr = Integer.parseInt(input.nextLine());
          if (mr == 1) {
            System.out.println("Here is your current roster:");
            for (int i = 0; i < g.size(); i++) {
              System.out.println(i + 1 + ". " + g.get(i));
            }

          } else if (mr == 2) {
            trade(t);
          } else if (mr == 3) {
            System.out.println("Which team would you like to play against?\n1. Golden State Warriors\n2. LA Lakers\n3. Denver Nuggets");
            try {
              mr = Integer.parseInt(input.nextLine());
              simgame(t, mr);
            } catch (Exception e) {
              System.out.println("Please enter a number.");
              simulate(t);
            }


          } else if (mr == 4) {
            if (eq()) {
              mainloop();
            }
          } else {
            System.out.println("bruhhh");
          }
        } catch (Exception e) {
          System.out.println("Please enter a number.");
          simulate(t);
        }
      }
    }
    else if(t==4) {
      System.out.println("Welcome to simulation mode.\nYou are now the general manager of the Denver Nuggets.");
      while (isRunning) {
        System.out.println("What would you like to do?\n1. View Roster\n2. Trade players\n3. Simulate Game\n4. Exit simulation");
        try {
          mr = Integer.parseInt(input.nextLine());
          if (mr == 1) {
            System.out.println("Here is your current roster:");
            for (int i = 0; i < n.size(); i++) {
              System.out.println(i + 1 + ". " + n.get(i));
            }
          } else if (mr == 2) {
            trade(t);
          } else if (mr == 3) {
            System.out.println("Which team would you like to play against?\n1. Golden State Warriors\n2. LA Lakers\n3. Memphis Grizzlies");
            try {
              mr = Integer.parseInt(input.nextLine());
              simgame(t, mr);
            } catch (Exception e) {
              System.out.println("Please enter a number.");
              simulate(t);
            }
          } else if (mr == 4) {
            if (eq()) {
              mainloop();
            }
          } else {
            System.out.println("bruhhh");
          }
        } catch (Exception e) {
          System.out.println("Please enter a number.");
          simulate(t);
        }
      }
    }
  }
  public static void practice(int team){
    updateTeams();
    Player pp;
    int r;
    boolean p2=true;
    System.out.println("Welcome to practice mode.");
    System.out.println("Choose a player to test their skills. Players will improve the skills they practice.");
    System.out.println("Are you ready to begin?");
    if(yn(input.nextLine())) {
      if (team == 1) {
        System.out.println("This is your current roster: ");
        for (int i = 0; i < w.size(); i++) {
          System.out.println(i + 1 + ". " + w.get(i));
        }
        System.out.println("Which player do you want to practice with?");
        pp = w.get(Integer.parseInt(input.nextLine()) - 1);
        while(p2) {
          System.out.println("What do you want " + pp.getName() + " to practice?\n1. Scoring\n2. Defense\n3. Teamwork\n4. Choose another player");
          r = Integer.parseInt(input.nextLine());
          if (r == 1) {
            System.out.println("What move do you want " + pp.getName() + " to practice?\n1. Layup\n2. Jumper\n3. Post hook\n4. Three pointer\n5. Practice menu");
            r = Integer.parseInt(input.nextLine());
            if (r == 5) {
              practice(team);
            } else {
              System.out.println(pp.prac(1, r));
            }
          }
          else if (r == 2) {
            System.out.println("What move do you want " + pp.getName() + " to practice?\n1. Shot blocking\n2. Close-outs\n3. Help defense\n4. Zone defense\n5. Practice menu");
            r = Integer.parseInt(input.nextLine());
            if (r == 5) {
              practice(team);
            } else {
              System.out.println(pp.prac(2, r));
            }
          }
          else if (r == 3) {
            System.out.println("What move do you want " + pp.getName() + " to practice?\n1. Passing\n2. Rebounding\n3. Setting screens\n4. Pick-n-Roll\n5. Practice menu");
            r = Integer.parseInt(input.nextLine());
            if (r == 5) {
              practice(team);
            } else {
              System.out.println(pp.prac(3, r));
            }
          }
          else{
            p2=false;
          }
        }
        practice(team);
      }
    }
    else{
      System.out.println("Do you want to return to the main menu?");
      if(yn(input.nextLine())){
        mainloop();
      }
      else{
        if(eq()){
          System.exit(0);
        }
        else{
          mainloop();
        }
      }
    }
  }
  public static void simgame(int team, int opteam){
    int ts=(int)(Math.random()*30+90);
    int sd=(int)(Math.random()*20+1);
    if(team==1) {
      if (opteam == 1) {
        System.out.println("Simulating game against the LA Lakers...");

        if(wtovr>ltovr){
          if((int)(Math.random()*100)>40){
            System.out.println("Your Golden State Warriors defeat the LA Lakers!");
          }
          else{
            System.out.println("The LA Lakers defeat your Golden State Warriors.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }
        if(ltovr>wtovr){
          if((int)(Math.random()*100)<40){
            System.out.println("Your Golden State Warriors defeat the LA Lakers!");
          }
          else{
            System.out.println("The LA Lakers defeat your Golden State Warriors.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }

      }
      if (opteam == 2) {
        System.out.println("Simulating game against the Memphis Grizzlies...");

        if(wtovr>gtovr){
          if((int)(Math.random()*100)>40){
            System.out.println("Your Golden State Warriors defeat the Memphis Grizzlies!");
          }
          else{
            System.out.println("The Memphis Grizzlies defeat your Golden State Warriors.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }
        if(gtovr>wtovr){
          if((int)(Math.random()*100)<40){
            System.out.println("Your Golden State Warriors defeat the Memphis Grizzlies!");
          }
          else{
            System.out.println("The Memphis Grizzlies defeat your Golden State Warriors.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }

      }
      if (opteam == 3) {
        System.out.println("Simulating game against the Denver Nuggets...");

        if(wtovr>ntovr){
          if((int)(Math.random()*100)>40){
            System.out.println("Your Golden State Warriors defeat the Denver Nuggets!");
          }
          else{
            System.out.println("The Denver Nuggets defeat your Golden State Warriors.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }
        if(ntovr>wtovr){
          if((int)(Math.random()*100)<40){
            System.out.println("Your Golden State Warriors defeat the Denver Nuggets!");
          }
          else{
            System.out.println("The Denver Nuggets defeat your Golden State Warriors.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }

      }
    }
    if(team==2) {
      if (opteam == 1) {
        System.out.println("Simulating game against the Golden State Warriors...");

        if(ltovr>wtovr){
          if((int)(Math.random()*100)>40){
            System.out.println("Your LA Lakers defeat the Golden State Warriors!");
          }
          else{
            System.out.println("The Golden State Warriors defeat your LA Lakers.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }
        if(wtovr>ltovr){
          if((int)(Math.random()*100)<40){
            System.out.println("Your LA Lakers defeat the Golden State Warriors!");
          }
          else{
            System.out.println("The Golden State Warriors defeat your LA Lakers.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }

      }
      if (opteam == 2) {
        System.out.println("Simulating game against the Memphis Grizzlies...");

        if(ltovr>gtovr){
          if((int)(Math.random()*100)>40){
            System.out.println("Your LA Lakers defeat the Memphis Grizzlies!");
          }
          else{
            System.out.println("The Memphis Grizzlies defeat your LA Lakers.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }
        if(gtovr>ltovr){
          if((int)(Math.random()*100)<40){
            System.out.println("Your LA Lakers defeat the Memphis Grizzlies!");
          }
          else{
            System.out.println("The Memphis Grizzlies your LA Lakers.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }

      }
      if (opteam == 3) {
        System.out.println("Simulating game against the Denver Nuggets...");

        if(ltovr>ntovr){
          if((int)(Math.random()*100)>40){
            System.out.println("Your LA Lakers defeat the Denver Nuggets!");
          }
          else{
            System.out.println("The Denver Nuggets defeat your LA Lakers.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }
        if(ntovr>ltovr){
          if((int)(Math.random()*100)<40){
            System.out.println("Your LA Lakers defeat the Denver Nuggets!");
          }
          else{
            System.out.println("The Denver Nuggets defeat your LA Lakers.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }

      }
    }
    if(team==3) {
      if (opteam == 1) {
        System.out.println("Simulating game against the Golden State Warriors...");

        if(gtovr>wtovr){
          if((int)(Math.random()*100)>40){
            System.out.println("Your Memphis Grizzlies defeat the Golden State Warriors!");
          }
          else{
            System.out.println("The Golden State Warriors defeat your Memphis Grizzlies.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }
        if(wtovr>gtovr){
          if((int)(Math.random()*100)<40){
            System.out.println("Your Memphis Grizzlies defeat the Golden State Warriors!");
          }
          else{
            System.out.println("The Golden State Warriors defeat your Memphis Grizzlies.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }

      }
      if (opteam == 2) {
        System.out.println("Simulating game against the LA Lakers...");

        if(gtovr>ltovr){
          if((int)(Math.random()*100)>40){
            System.out.println("Your Memphis Grizzlies defeat the LA Lakers!");
          }
          else{
            System.out.println("The LA Lakers defeat your Memphis Grizzlies.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }
        if(ltovr>gtovr){
          if((int)(Math.random()*100)<40){
            System.out.println("Your Memphis Grizzlies defeat the LA Lakers!");
          }
          else{
            System.out.println("The LA Lakers defeat your Memphis Grizzlies.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }

      }
      if (opteam == 3) {
        System.out.println("Simulating game against the Denver Nuggets...");

        if(gtovr>ntovr){
          if((int)(Math.random()*100)>40){
            System.out.println("Your Memphis Grizzlies defeat the Denver Nuggets!");
          }
          else{
            System.out.println("The Denver Nuggets defeat your Memphis Grizzlies.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }
        if(ntovr>gtovr){
          if((int)(Math.random()*100)<40){
            System.out.println("Your Memphis Grizzlies defeat the Denver Nuggets!");
          }
          else{
            System.out.println("The Denver Nuggets defeat your Memphis Grizzlies.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }

      }
    }
    if(team==4) {
      if (opteam == 1) {
        System.out.println("Simulating game against the Golden State Warriors...");

        if(ntovr>wtovr){
          if((int)(Math.random()*100)>40){
            System.out.println("Your Denver Nuggets defeat the Golden State Warriors!");
          }
          else{
            System.out.println("The Golden State Warriors defeat your Denver Nuggets.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }
        if(wtovr>ntovr){
          if((int)(Math.random()*100)<40){
            System.out.println("Your Denver Nuggets defeat the Golden State Warriors!");
          }
          else{
            System.out.println("The Golden State Warriors defeat your Denver Nuggets.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }

      }
      if (opteam == 2) {
        System.out.println("Simulating game against the LA Lakers...");

        if(ntovr>ltovr){
          if((int)(Math.random()*100)>40){
            System.out.println("Your Denver Nuggets defeat the LA Lakers!");
          }
          else{
            System.out.println("The LA Lakers defeat your Denver Nuggets.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }
        if(ltovr>ntovr){
          if((int)(Math.random()*100)<40){
            System.out.println("Your Denver Nuggets defeat the LA Lakers!");
          }
          else{
            System.out.println("The LA Lakers defeat your Denver Nuggets.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }

      }
      if (opteam == 3) {
        System.out.println("Simulating game against the Memphis Grizzlies...");

        if(gtovr>ntovr){
          if((int)(Math.random()*100)>40){
            System.out.println("Your Denver Nuggets defeat the Memphis Grizzlies!");
          }
          else{
            System.out.println("The Memphis Grizzlies defeat your Denver Nuggets.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }
        if(ntovr>gtovr){
          if((int)(Math.random()*100)<40){
            System.out.println("Your Denver Nuggets defeat the Memphis Grizzlies!");
          }
          else{
            System.out.println("The Memphis Grizzlies defeat your Denver Nuggets.");
          }
          System.out.println("Final Score: "+ts+"-"+(ts-sd));
        }

      }
    }

  }

  public static void trade(int team){
    int wn;
    int gn;
    int response;
    Player wants;
    Player gives;
    System.out.println("Welcome to the trade menu!");
    if(team==1) {
      System.out.println("Which team would you like to trade with?\n1. LA Lakers\n2. Memphis Grizzlies\n3. Denver Nuggets\n4. Exit trade menu");
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
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            w.remove(gn);
            w.add(wants);
            l.remove(wn);
            l.add(gives);
            updateTeams();
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
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            w.remove(gn);
            w.add(wants);
            g.remove(wn);
            g.add(gives);
            updateTeams();
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
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            w.remove(gn);
            w.add(wants);
            n.remove(wn);
            n.add(gives);
            updateTeams();
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
        }
        else {
          System.out.println("Please pick the number of one of the teams.");
          System.out.println("Would you like to return to the menu?");
          if (yn(input.nextLine())) {
            simulate(team);
          } else {
            trade(team);
          }
        }
      }
      catch(Exception e){
        System.out.println("Please enter a number.");
        trade(team);
      }
    }
    if(team==2) {
      System.out.println("Which team would you like to trade with?\n1. Golden State Warriors\n2. Memphis Grizzlies\n3. Denver Nuggets\n4. Exit trade menu");
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
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            l.remove(gn);
            l.add(wants);
            w.remove(wn);
            w.add(gives);
            updateTeams();
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
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            l.remove(gn);
            l.add(wants);
            g.remove(wn);
            g.add(gives);
            updateTeams();
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
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            l.remove(gn);
            l.add(wants);
            n.remove(wn);
            n.add(gives);
            updateTeams();
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
          System.out.println("Would you like to return to the menu?");
          if (yn(input.nextLine())) {
            simulate(team);
          } else {
            trade(team);
          }
        }

      }
      catch(Exception e){
        System.out.println("Please enter a number.");
        trade(team);
      }
    }
    if(team==3) {
      System.out.println("Which team would you like to trade with?\n1. Golden State Warriors \n2. LA Lakers\n3. Denver Nuggets\n4. Exit trade menu");
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
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            g.remove(gn);
            g.add(wants);
            w.remove(wn);
            w.add(gives);
            updateTeams();
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
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            g.remove(gn);
            g.add(wants);
            l.remove(wn);
            l.add(gives);
            updateTeams();
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
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            g.remove(gn);
            g.add(wants);
            n.remove(wn);
            n.add(gives);
            updateTeams();
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
          System.out.println("Would you like to return to the menu?");
          if (yn(input.nextLine())) {
            simulate(team);
          } else {
            trade(team);
          }
        }
      }
      catch(Exception e){
        System.out.println("Please enter a number.");
        trade(team);
      }
    }
    if(team==4) {
      System.out.println("Which team would you like to trade with?\n1. Golden State Warriors \n2. LA Lakers\n3. Memphis Grizzlies\n4. Exit trade menu");
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
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            n.remove(gn);
            n.add(wants);
            w.remove(wn);
            w.add(gives);
            updateTeams();
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
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            n.remove(gn);
            n.add(wants);
            l.remove(wn);
            l.add(gives);
            updateTeams();
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
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            n.remove(gn);
            n.add(wants);
            g.remove(wn);
            g.add(gives);
            updateTeams();
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
        }
          else {
            System.out.println("Please pick the number of one of the teams.");
            System.out.println("Would you like to return to the menu?");
            if (yn(input.nextLine())) {
              simulate(team);
            } else {
              trade(team);
            }
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
  public static void updateTeams(){
    for(Integer p:wovr){
      wtovr+=p;
    }
    for(Integer p:lovr){
      ltovr+=p;
    }
    for(Integer p:govr){
      gtovr+=p;
    }
    for(Integer p:novr){
      ntovr+=p;
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