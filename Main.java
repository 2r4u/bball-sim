import java.util.*;
import java.lang.Math;

class Main {
  public static Scanner input = new Scanner(System.in);
  public static String response;
  public static int rn;
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

  public static String[] nums={"1","2","3","4","5","6","7","8","9","0"};

  public static void main(String[] args) throws InterruptedException{
    Graphics.write("Welcome to Basketball Simulator!");
    Graphics logo=new Graphics();
    logo.setImage("C:\\Users\\2r4u6\\IdeaProjects\\bball sim graphics\\src\\logo.gif");
    Graphics.write("Are you ready to begin? \n(Yes or No)");
    Graphics.ar.await();
    if(yn(response)){
      Graphics.write("Awesome! Please wait while we prepare...");
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
      Graphics.write("That's too bad.");
      if(eq()){
        Graphics.write("Have a good day!");
        System.exit(0);
      }
    }
  }
  public static void input(String r) throws InterruptedException{
    response=r;
    for(String s:nums){
      if(response.contains(s)){
        try{
          rn = Integer.parseInt(response);
        }
        catch(Exception e){
          Graphics.write("Please enter a number.");
          if(eq()){
            Graphics.write("Have a good day!");
            System.exit(0);
          }
        }
      }
    }

  }
  public static void mainloop() throws InterruptedException{
    Graphics.write("Which team do you want to play as?\n1. Golden State Warriors\n2. Los Angeles Lakers\n3. Memphis Grizzlies\n4. Denver Nuggets");
    Graphics.ar.await();
    Graphics.ar.await();
    try {
      if (rn==1) {
        pteam = 1;
      }
      else if (rn==2){
        pteam = 2;
      }
      else if (rn==3){
        pteam = 3;
      }
      else if (rn==4){
        pteam = 4;
      }
      else{
        Graphics.write("Please choose a team.");
        if(eq()){
          Graphics.write("Have a good day!");
          System.exit(0);
        }
        else{
          mainloop();
        }
      }
      Graphics.write("""
              Which mode would you like to play?
              1. Simulate (Trade and draft players, rework your team, and simulate seasons)
              2. Practice (Choose a player and try their skills)""");
      Graphics.ar.await();
      if (rn==1) {
        isRunning = true;
        simulate(pteam);
      }
      else if(rn==2){
        practice(pteam);
      }

    }
    catch(Exception e){
      Graphics.write("Please enter an number.");
      if(eq()){
        Graphics.write("Have a good day!");
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
  public static void simulate(int t) throws InterruptedException{
    int mr;
    if(t==1){
      Graphics.write("Welcome to simulation mode.\nYou are now the general manager of the Golden State Warriors.");
      while(isRunning) {
        Graphics.write("What would you like to do?\n1" +
                "Graphics.ar.await();. View Roster\n2. Trade players\n3. Simulate Game\n4. Exit simulation");
        Graphics.ar.await();
        Graphics.ar.await();
        try {
          mr = rn;
          if (mr == 1) {
            Graphics.write("Here is your current roster:");
            for (int i = 0; i < w.size(); i++) {
              Graphics.write(i + 1 + ". " + w.get(i));
            }

          } else if (mr == 2) {
            trade(1);
          } else if (mr == 3) {
            Graphics.write("Which team would you like to play against?\n1. LA Lakers\n2. Memphis Grizzlies\n3. Denver Nuggets");
            Graphics.ar.await();
            try {
              mr = rn;
              simgame(1,mr);
            } catch (Exception e) {
              Graphics.write("Please enter a number.");
              simulate(t);
            }
          }
          else if(mr==4){
            if(eq()){
              mainloop();
            }
          }
          else {
            Graphics.write("bruhhh");
          }
        }
        catch(Exception e){
          Graphics.write("Please enter a number.");
          simulate(t);
        }
      }
    }
    else if(t==2){
      Graphics.write("Welcome to simulation mode.\nYou are now the general manager of the LA Lakers.");
      while(isRunning) {
        Graphics.write("What would you like to do?\n1" +
                "Graphics.ar.await();. View Roster\n2. Trade players\n3. Simulate Game\n4. Exit simulation");
        Graphics.ar.await();
        try {
          mr = rn;
          if (mr == 1) {
            Graphics.write("Here is your current roster:");
            for (int i = 0; i < l.size(); i++) {
              Graphics.write(i + 1 + ". " + l.get(i));
            }

          } else if (mr == 2) {
            trade(t);
          } else if (mr == 3) {
            Graphics.write("Which team would you like to play against?\n1. Golden State Warriors\n2. Memphis Grizzlies\n3. Denver Nuggets");
            Graphics.ar.await();
            try {
              mr = rn;
              simgame(t,mr);
            } catch (Exception e) {
              Graphics.write("Please enter a number.");
              simulate(t);
            }


          }
          else if(mr==4){
            if(eq()){
              mainloop();
            }
          }
          else {
            Graphics.write("bruhhh");
          }
        }
        catch(Exception e){
          Graphics.write("Please enter a number.");
          simulate(t);
        }
      }
    }
    else if(t==3) {
      Graphics.write("Welcome to simulation mode.\nYou are now the general manager of the Memphis Grizzlies.");
      while (isRunning) {
        Graphics.write("What would you like to do?\n1" +
                "Graphics.ar.await();. View Roster\n2. Trade players\n3. Simulate Game\n4. Exit simulation");
        Graphics.ar.await();
        try {
          mr = rn;
          if (mr == 1) {
            Graphics.write("Here is your current roster:");
            for (int i = 0; i < g.size(); i++) {
              Graphics.write(i + 1 + ". " + g.get(i));
            }

          } else if (mr == 2) {
            trade(t);
          } else if (mr == 3) {
            Graphics.write("Which team would you like to play against?\n1. Golden State Warriors\n2. LA Lakers\n3. Denver Nuggets");
            Graphics.ar.await();
            try {
              mr = rn;
              simgame(t, mr);
            } catch (Exception e) {
              Graphics.write("Please enter a number.");
              simulate(t);
            }


          } else if (mr == 4) {
            if (eq()) {
              mainloop();
            }
          } else {
            Graphics.write("bruhhh");
          }
        } catch (Exception e) {
          Graphics.write("Please enter a number.");
          simulate(t);
        }
      }
    }
    else if(t==4) {
      Graphics.write("Welcome to simulation mode.\nYou are now the general manager of the Denver Nuggets.");
      while (isRunning) {
        Graphics.write("What would you like to do?\n1" +
                "Graphics.ar.await();. View Roster\n2. Trade players\n3. Simulate Game\n4. Exit simulation");
        Graphics.ar.await();
        try {
          mr = rn;
          if (mr == 1) {
            Graphics.write("Here is your current roster:");
            for (int i = 0; i < n.size(); i++) {
              Graphics.write(i + 1 + ". " + n.get(i));
            }
          } else if (mr == 2) {
            trade(t);
          } else if (mr == 3) {
            Graphics.write("Which team would you like to play against?\n1. Golden State Warriors\n2. LA Lakers\n3. Memphis Grizzlies");
            Graphics.ar.await();
            try {
              mr = rn;
              simgame(t, mr);
            } catch (Exception e) {
              Graphics.write("Please enter a number.");
              simulate(t);
            }
          } else if (mr == 4) {
            if (eq()) {
              mainloop();
            }
          } else {
            Graphics.write("bruhhh");
          }
        } catch (Exception e) {
          Graphics.write("Please enter a number.");
          simulate(t);
        }
      }
    }
  }
  public static void practice(int team) throws InterruptedException{
    updateTeams();
    Player pp;
    boolean p2=true;
    Graphics.write("Welcome to practice mode.");
    Graphics.write("Choose a player to test their skills. Players will improve the skills they practice.");
    Graphics.write("Are you ready to begin?");
    Graphics.ar.await();
    if(yn(response)) {
      if (team == 1) {
        Graphics.write("This is your current roster: ");
        for (int i = 0; i < w.size(); i++) {
          Graphics.write(i + 1 + ". " + w.get(i));
        }
        Graphics.write("Which player do you want to practice with?");
        Graphics.ar.await();
        pp = w.get(rn - 1);
        while(p2) {
          Graphics.write("What do you want " + pp.getName() + " to practice?\n1. Scoring\n2. Defense\n3. Teamwork\n4. Choose another player");
          Graphics.ar.await();
          if (rn == 1) {
            Graphics.write("What move do you want " + pp.getName() + " to practice?\n1. Layup\n2. Jumper\n3. Post hook\n4. Three pointer\n5. Practice menu");
            Graphics.ar.await();
            if (rn == 5) {
              practice(team);
            } else {
              Graphics.write(pp.prac(1, rn));
            }
          }
          else if (rn == 2) {
            Graphics.write("What move do you want " + pp.getName() + " to practice?\n1. Shot blocking\n2. Close-outs\n3. Help defense\n4. Zone defense\n5. Practice menu");
            Graphics.ar.await();
            if (rn == 5) {
              practice(team);
            } else {
              Graphics.write(pp.prac(2, rn));
            }
          }
          else if (rn == 3) {
            Graphics.write("What move do you want " + pp.getName() + " to practice?\n1. Passing\n2. Rebounding\n3. Setting screens\n4. Pick-n-Roll\n5. Practice menu");
            Graphics.ar.await();
            if (rn == 5) {
              practice(team);
            } else {
              Graphics.write(pp.prac(3, rn));
            }
          }
          else{
            p2=false;
          }
        }
        practice(team);
      }
      if (team == 2) {
        Graphics.write("This is your current roster: ");
        for (int i = 0; i < l.size(); i++) {
          Graphics.write(i + 1 + ". " + l.get(i));
        }
        Graphics.write("Which player do you want to practice with?");
        Graphics.ar.await();
        pp = l.get(rn - 1);
        while(p2) {
          Graphics.write("What do you want " + pp.getName() + " to practice?\n1. Scoring\n2. Defense\n3. Teamwork\n4. Choose another player");
          Graphics.ar.await();
          if (rn == 1) {
            Graphics.write("What move do you want " + pp.getName() + " to practice?\n1. Layup\n2. Jumper\n3. Post hook\n4. Three pointer\n5. Practice menu");
            Graphics.ar.await();
            if (rn == 5) {
              practice(team);
            } else {
              Graphics.write(pp.prac(1, rn));
            }
          }
          else if (rn == 2) {
            Graphics.write("What move do you want " + pp.getName() + " to practice?\n1. Shot blocking\n2. Close-outs\n3. Help defense\n4. Zone defense\n5. Practice menu");
            Graphics.ar.await();
            if (rn == 5) {
              practice(team);
            } else {
              Graphics.write(pp.prac(2, rn));
            }
          }
          else if (rn == 3) {
            Graphics.write("What move do you want " + pp.getName() + " to practice?\n1. Passing\n2. Rebounding\n3. Setting screens\n4. Pick-n-Roll\n5. Practice menu");
            Graphics.ar.await();
            if (rn == 5) {
              practice(team);
            } else {
              Graphics.write(pp.prac(3, rn));
            }
          }
          else{
            p2=false;
          }
        }
        practice(team);
      }
      if (team == 3) {
        Graphics.write("This is your current roster: ");
        for (int i = 0; i < g.size(); i++) {
          Graphics.write(i + 1 + ". " + g.get(i));
        }
        Graphics.write("Which player do you want to practice with?");
        Graphics.ar.await();
        pp = g.get(rn - 1);
        while(p2) {
          Graphics.write("What do you want " + pp.getName() + " to practice?\n1. Scoring\n2. Defense\n3. Teamwork\n4. Choose another player");
          Graphics.ar.await();
          if (rn == 1) {
            Graphics.write("What move do you want " + pp.getName() + " to practice?\n1. Layup\n2. Jumper\n3. Post hook\n4. Three pointer\n5. Practice menu");
            Graphics.ar.await();
            if (rn == 5) {
              practice(team);
            } else {
              Graphics.write(pp.prac(1, rn));
            }
          }
          else if (rn == 2) {
            Graphics.write("What move do you want " + pp.getName() + " to practice?\n1. Shot blocking\n2. Close-outs\n3. Help defense\n4. Zone defense\n5. Practice menu");
            Graphics.ar.await();
            if (rn == 5) {
              practice(team);
            } else {
              Graphics.write(pp.prac(2, rn));
            }
          }
          else if (rn == 3) {
            Graphics.write("What move do you want " + pp.getName() + " to practice?\n1. Passing\n2. Rebounding\n3. Setting screens\n4. Pick-n-Roll\n5. Practice menu");
            Graphics.ar.await();
            if (rn == 5) {
              practice(team);
            } else {
              Graphics.write(pp.prac(3, rn));
            }
          }
          else{
            p2=false;
          }
        }
        practice(team);
      }
      if (team == 4) {
        Graphics.write("This is your current roster: ");
        for (int i = 0; i < n.size(); i++) {
          Graphics.write(i + 1 + ". " + n.get(i));
        }
        Graphics.write("Which player do you want to practice with?");
        Graphics.ar.await();
        pp = n.get(rn - 1);
        while(p2) {
          Graphics.write("What do you want " + pp.getName() + " to practice?\n1. Scoring\n2. Defense\n3. Teamwork\n4. Choose another player");
          Graphics.ar.await();
          if (rn == 1) {
            Graphics.write("What move do you want " + pp.getName() + " to practice?\n1. Layup\n2. Jumper\n3. Post hook\n4. Three pointer\n5. Practice menu");
            Graphics.ar.await();
            if (rn == 5) {
              practice(team);
            } else {
              Graphics.write(pp.prac(1, rn));
            }
          }
          else if (rn == 2) {
            Graphics.write("What move do you want " + pp.getName() + " to practice?\n1. Shot blocking\n2. Close-outs\n3. Help defense\n4. Zone defense\n5. Practice menu");
            Graphics.ar.await();
            if (rn == 5) {
              practice(team);
            } else {
              Graphics.write(pp.prac(2, rn));
            }
          }
          else if (rn == 3) {
            Graphics.write("What move do you want " + pp.getName() + " to practice?\n1. Passing\n2. Rebounding\n3. Setting screens\n4. Pick-n-Roll\n5. Practice menu");
            Graphics.ar.await();
            if (rn == 5) {
              practice(team);
            } else {
              Graphics.write(pp.prac(3, rn));
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
      Graphics.write("Do you want to return to the main menu?");
      Graphics.ar.await();
      if(yn(response)){
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
        Graphics.write("Simulating game against the LA Lakers...");

        if(wtovr>ltovr){
          if((int)(Math.random()*100)>40){
            Graphics.write("Your Golden State Warriors defeat the LA Lakers!");
          }
          else{
            Graphics.write("The LA Lakers defeat your Golden State Warriors.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }
        if(ltovr>wtovr){
          if((int)(Math.random()*100)<40){
            Graphics.write("Your Golden State Warriors defeat the LA Lakers!");
          }
          else{
            Graphics.write("The LA Lakers defeat your Golden State Warriors.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }

      }
      if (opteam == 2) {
        Graphics.write("Simulating game against the Memphis Grizzlies...");

        if(wtovr>gtovr){
          if((int)(Math.random()*100)>40){
            Graphics.write("Your Golden State Warriors defeat the Memphis Grizzlies!");
          }
          else{
            Graphics.write("The Memphis Grizzlies defeat your Golden State Warriors.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }
        if(gtovr>wtovr){
          if((int)(Math.random()*100)<40){
            Graphics.write("Your Golden State Warriors defeat the Memphis Grizzlies!");
          }
          else{
            Graphics.write("The Memphis Grizzlies defeat your Golden State Warriors.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }

      }
      if (opteam == 3) {
        Graphics.write("Simulating game against the Denver Nuggets...");

        if(wtovr>ntovr){
          if((int)(Math.random()*100)>40){
            Graphics.write("Your Golden State Warriors defeat the Denver Nuggets!");
          }
          else{
            Graphics.write("The Denver Nuggets defeat your Golden State Warriors.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }
        if(ntovr>wtovr){
          if((int)(Math.random()*100)<40){
            Graphics.write("Your Golden State Warriors defeat the Denver Nuggets!");
          }
          else{
            Graphics.write("The Denver Nuggets defeat your Golden State Warriors.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }

      }
    }
    if(team==2) {
      if (opteam == 1) {
        Graphics.write("Simulating game against the Golden State Warriors...");

        if(ltovr>wtovr){
          if((int)(Math.random()*100)>40){
            Graphics.write("Your LA Lakers defeat the Golden State Warriors!");
          }
          else{
            Graphics.write("The Golden State Warriors defeat your LA Lakers.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }
        if(wtovr>ltovr){
          if((int)(Math.random()*100)<40){
            Graphics.write("Your LA Lakers defeat the Golden State Warriors!");
          }
          else{
            Graphics.write("The Golden State Warriors defeat your LA Lakers.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }

      }
      if (opteam == 2) {
        Graphics.write("Simulating game against the Memphis Grizzlies...");

        if(ltovr>gtovr){
          if((int)(Math.random()*100)>40){
            Graphics.write("Your LA Lakers defeat the Memphis Grizzlies!");
          }
          else{
            Graphics.write("The Memphis Grizzlies defeat your LA Lakers.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }
        if(gtovr>ltovr){
          if((int)(Math.random()*100)<40){
            Graphics.write("Your LA Lakers defeat the Memphis Grizzlies!");
          }
          else{
            Graphics.write("The Memphis Grizzlies your LA Lakers.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }

      }
      if (opteam == 3) {
        Graphics.write("Simulating game against the Denver Nuggets...");

        if(ltovr>ntovr){
          if((int)(Math.random()*100)>40){
            Graphics.write("Your LA Lakers defeat the Denver Nuggets!");
          }
          else{
            Graphics.write("The Denver Nuggets defeat your LA Lakers.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }
        if(ntovr>ltovr){
          if((int)(Math.random()*100)<40){
            Graphics.write("Your LA Lakers defeat the Denver Nuggets!");
          }
          else{
            Graphics.write("The Denver Nuggets defeat your LA Lakers.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }

      }
    }
    if(team==3) {
      if (opteam == 1) {
        Graphics.write("Simulating game against the Golden State Warriors...");

        if(gtovr>wtovr){
          if((int)(Math.random()*100)>40){
            Graphics.write("Your Memphis Grizzlies defeat the Golden State Warriors!");
          }
          else{
            Graphics.write("The Golden State Warriors defeat your Memphis Grizzlies.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }
        if(wtovr>gtovr){
          if((int)(Math.random()*100)<40){
            Graphics.write("Your Memphis Grizzlies defeat the Golden State Warriors!");
          }
          else{
            Graphics.write("The Golden State Warriors defeat your Memphis Grizzlies.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }

      }
      if (opteam == 2) {
        Graphics.write("Simulating game against the LA Lakers...");

        if(gtovr>ltovr){
          if((int)(Math.random()*100)>40){
            Graphics.write("Your Memphis Grizzlies defeat the LA Lakers!");
          }
          else{
            Graphics.write("The LA Lakers defeat your Memphis Grizzlies.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }
        if(ltovr>gtovr){
          if((int)(Math.random()*100)<40){
            Graphics.write("Your Memphis Grizzlies defeat the LA Lakers!");
          }
          else{
            Graphics.write("The LA Lakers defeat your Memphis Grizzlies.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }

      }
      if (opteam == 3) {
        Graphics.write("Simulating game against the Denver Nuggets...");

        if(gtovr>ntovr){
          if((int)(Math.random()*100)>40){
            Graphics.write("Your Memphis Grizzlies defeat the Denver Nuggets!");
          }
          else{
            Graphics.write("The Denver Nuggets defeat your Memphis Grizzlies.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }
        if(ntovr>gtovr){
          if((int)(Math.random()*100)<40){
            Graphics.write("Your Memphis Grizzlies defeat the Denver Nuggets!");
          }
          else{
            Graphics.write("The Denver Nuggets defeat your Memphis Grizzlies.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }

      }
    }
    if(team==4) {
      if (opteam == 1) {
        Graphics.write("Simulating game against the Golden State Warriors...");

        if(ntovr>wtovr){
          if((int)(Math.random()*100)>40){
            Graphics.write("Your Denver Nuggets defeat the Golden State Warriors!");
          }
          else{
            Graphics.write("The Golden State Warriors defeat your Denver Nuggets.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }
        if(wtovr>ntovr){
          if((int)(Math.random()*100)<40){
            Graphics.write("Your Denver Nuggets defeat the Golden State Warriors!");
          }
          else{
            Graphics.write("The Golden State Warriors defeat your Denver Nuggets.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }

      }
      if (opteam == 2) {
        Graphics.write("Simulating game against the LA Lakers...");

        if(ntovr>ltovr){
          if((int)(Math.random()*100)>40){
            Graphics.write("Your Denver Nuggets defeat the LA Lakers!");
          }
          else{
            Graphics.write("The LA Lakers defeat your Denver Nuggets.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }
        if(ltovr>ntovr){
          if((int)(Math.random()*100)<40){
            Graphics.write("Your Denver Nuggets defeat the LA Lakers!");
          }
          else{
            Graphics.write("The LA Lakers defeat your Denver Nuggets.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }

      }
      if (opteam == 3) {
        Graphics.write("Simulating game against the Memphis Grizzlies...");

        if(gtovr>ntovr){
          if((int)(Math.random()*100)>40){
            Graphics.write("Your Denver Nuggets defeat the Memphis Grizzlies!");
          }
          else{
            Graphics.write("The Memphis Grizzlies defeat your Denver Nuggets.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }
        if(ntovr>gtovr){
          if((int)(Math.random()*100)<40){
            Graphics.write("Your Denver Nuggets defeat the Memphis Grizzlies!");
          }
          else{
            Graphics.write("The Memphis Grizzlies defeat your Denver Nuggets.");
          }
          Graphics.write("Final Score: "+ts+"-"+(ts-sd));
        }

      }
    }

  }

  public static void trade(int team) throws InterruptedException{
    int wn;
    int gn;
    Player wants;
    Player gives;
    Graphics.write("Welcome to the trade menu!");
    if(team==1) {
      Graphics.write("Which team would you like to trade with?\n1. LA Lakers\n2. Memphis Grizzlies\n3. Denver Nuggets\n4. Exit trade menu");
      Graphics.ar.await();
      try {
        if (rn == 1) {
          Graphics.write("Here is the Lakers roster:");
          for (int i = 0; i < l.size(); i++) {
            Graphics.write(i + 1 + ". " + l.get(i));
          }
          Graphics.write("Which player would you like to trade for?\n(Numbers 1-15)");
          Graphics.ar.await();
          wn = rn - 1;
          wants = l.get(wn);
          Graphics.write("Here is your team:");
          for (int i = 0; i < w.size(); i++) {
            Graphics.write(i + 1 + ". " + w.get(i));
          }
          Graphics.write("Which player will you give up?\n(Numbers 1-15)");
          Graphics.ar.await();
          gn = rn - 1;
          gives = w.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            w.remove(gn);
            w.add(wants);
            l.remove(wn);
            l.add(gives);
            updateTeams();
            Graphics.write("The Lakers have agreed to your trade!");
          } else {
            Graphics.write("Unfortunately, the Lakers have declined your trade.");
          }
          Graphics.write("Do you want to make another trade?");
          Graphics.ar.await();
          if (yn(response)) {
            trade(team);
          } else {
            Graphics.write("Would you like to return to the menu?");
            Graphics.ar.await();
            if (yn(response)) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        }
        if (rn == 2) {
          Graphics.write("Here is the Grizzlies roster:");
          for (int i = 0; i < g.size(); i++) {
            Graphics.write(i + 1 + ". " + g.get(i));
          }
          Graphics.write("Which player would you like to trade for?\n(Numbers 1-15)");
          Graphics.ar.await();
          wn = rn - 1;
          wants = g.get(wn);
          Graphics.write("Here is your team:");
          for (int i = 0; i < w.size(); i++) {
            Graphics.write(i + 1 + ". " + w.get(i));
          }
          Graphics.write("Which player will you give up?\n(Numbers 1-15)");
          Graphics.ar.await();
          gn = rn - 1;
          gives = w.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            w.remove(gn);
            w.add(wants);
            g.remove(wn);
            g.add(gives);
            updateTeams();
            Graphics.write("The Grizzlies have agreed to your trade!");
          } else {
            Graphics.write("Unfortunately, the Grizzlies have declined your trade.");
          }
          Graphics.write("Do you want to make another trade?");
          Graphics.ar.await();
          if (yn(response)) {
            trade(team);
          } else {
            Graphics.write("Would you like to return to the menu?");
            Graphics.ar.await();
            if (yn(response)) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        }
        if (rn == 3) {
          Graphics.write("Here is the Nuggets roster:");
          for (int i = 0; i < n.size(); i++) {
            Graphics.write(i + 1 + ". " + n.get(i));
          }
          Graphics.write("Which player would you like to trade for?\n(Numbers 1-15)");
          Graphics.ar.await();
          wn = rn - 1;
          wants = n.get(wn);
          Graphics.write("Here is your team:");
          for (int i = 0; i < w.size(); i++) {
            Graphics.write(i + 1 + ". " + w.get(i));
          }
          Graphics.write("Which player will you give up?\n(Numbers 1-15)");
          Graphics.ar.await();
          gn = rn - 1;
          gives = w.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            w.remove(gn);
            w.add(wants);
            n.remove(wn);
            n.add(gives);
            updateTeams();
            Graphics.write("The Nuggets have agreed to your trade!");
          } else {
            Graphics.write("Unfortunately, the Nuggets have declined your trade.");
          }
          Graphics.write("Do you want to make another trade?");
          Graphics.ar.await();
          if (yn(response)) {
            trade(team);
          } else {
            Graphics.write("Would you like to return to the menu?");
            Graphics.ar.await();
            if (yn(response)) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        }
        else {
          Graphics.write("Please pick the number of one of the teams.");
          Graphics.write("Would you like to return to the menu?");
          Graphics.ar.await();
          if (yn(response)) {
            simulate(team);
          } else {
            trade(team);
          }
        }
      }
      catch(Exception e){
        Graphics.write("Please enter a number.");
        trade(team);
      }
    }
    if(team==2) {
      Graphics.write("Which team would you like to trade with?\n1. Golden State Warriors\n2. Memphis Grizzlies\n3. Denver Nuggets\n4. Exit trade menu");
      Graphics.ar.await();
      try {
        if (rn == 1) {
          Graphics.write("Here is the Warriors roster:");
          for (int i = 0; i < w.size(); i++) {
            Graphics.write(i + 1 + ". " + w.get(i));
          }
          Graphics.write("Which player would you like to trade for?\n(Numbers 1-15)");
          Graphics.ar.await();
          Graphics.ar.await();
          wn = rn - 1;
          wants = w.get(wn);
          Graphics.write("Here is your team:");
          for (int i = 0; i < l.size(); i++) {
            Graphics.write(i + 1 + ". " + l.get(i));
          }
          Graphics.write("Which player will you give up?\n(Numbers 1-15)");
          Graphics.ar.await();
          Graphics.ar.await();
          gn = rn - 1;
          gives = l.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            l.remove(gn);
            l.add(wants);
            w.remove(wn);
            w.add(gives);
            updateTeams();
            Graphics.write("The Warriors have agreed to your trade!");
          } else {
            Graphics.write("Unfortunately, the Warriors have declined your trade.");
          }
          Graphics.write("Do you want to make another trade?");
          Graphics.ar.await();
          Graphics.ar.await();
          if (yn(response)) {
            trade(team);
          } else {
            Graphics.write("Would you like to return to the menu?");
            Graphics.ar.await();
            if (yn(response)) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        }
        if (rn == 2) {
          Graphics.write("Here is the Grizzlies roster:");
          for (int i = 0; i < g.size(); i++) {
            Graphics.write(i + 1 + ". " + g.get(i));
          }
          Graphics.write("Which player would you like to trade for?\n(Numbers 1-15)");
          Graphics.ar.await();
          wn = rn - 1;
          wants = g.get(wn);
          Graphics.write("Here is your team:");
          for (int i = 0; i < l.size(); i++) {
            Graphics.write(i + 1 + ". " + l.get(i));
          }
          Graphics.write("Which player will you give up?\n(Numbers 1-15)");
          Graphics.ar.await();
          gn = rn - 1;
          gives = l.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            l.remove(gn);
            l.add(wants);
            g.remove(wn);
            g.add(gives);
            updateTeams();
            Graphics.write("The Grizzlies have agreed to your trade!");
          } else {
            Graphics.write("Unfortunately, the Grizzlies have declined your trade.");
          }
          Graphics.write("Do you want to make another trade?");
          Graphics.ar.await();
          if (yn(response)) {
            trade(team);
          } else {
            Graphics.write("Would you like to return to the menu?");
            Graphics.ar.await();
            if (yn(response)) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        }
        if (rn == 3) {
          Graphics.write("Here is the Nuggets roster:");
          for (int i = 0; i < n.size(); i++) {
            Graphics.write(i + 1 + ". " + n.get(i));
          }
          Graphics.write("Which player would you like to trade for?\n(Numbers 1-15)");
          Graphics.ar.await();
          wn = rn - 1;
          wants = n.get(wn);
          Graphics.write("Here is your team:");
          for (int i = 0; i < l.size(); i++) {
            Graphics.write(i + 1 + ". " + l.get(i));
          }
          Graphics.write("Which player will you give up?\n(Numbers 1-15)");
          Graphics.ar.await();
          gn = rn - 1;
          gives = l.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            l.remove(gn);
            l.add(wants);
            n.remove(wn);
            n.add(gives);
            updateTeams();
            Graphics.write("The Nuggets have agreed to your trade!");
          } else {
            Graphics.write("Unfortunately, the Nuggets have declined your trade.");
          }
          Graphics.write("Do you want to make another trade?");
          Graphics.ar.await();
          if (yn(response)) {
            trade(team);
          } else {
            Graphics.write("Would you like to return to the menu?");
            Graphics.ar.await();
            if (yn(response)) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        } else {
          Graphics.write("Please pick the number of one of the teams.");
          Graphics.write("Would you like to return to the menu?");
          Graphics.ar.await();
          if (yn(response)) {
            simulate(team);
          } else {
            trade(team);
          }
        }

      }
      catch(Exception e){
        Graphics.write("Please enter a number.");
        trade(team);
      }
    }
    if(team==3) {
      Graphics.write("Which team would you like to trade with?\n1. Golden State Warriors \n2. LA Lakers\n3. Denver Nuggets\n4. Exit trade menu");
      Graphics.ar.await();
      try {
        if (rn == 1) {
          Graphics.write("Here is the Warriors roster:");
          for (int i = 0; i < w.size(); i++) {
            Graphics.write(i + 1 + ". " + w.get(i));
          }
          Graphics.write("Which player would you like to trade for?\n(Numbers 1-15)");
          Graphics.ar.await();
          wn = rn - 1;
          wants = w.get(wn);
          Graphics.write("Here is your team:");
          for (int i = 0; i < g.size(); i++) {
            Graphics.write(i + 1 + ". " + g.get(i));
          }
          Graphics.write("Which player will you give up?\n(Numbers 1-15)");
          Graphics.ar.await();
          gn = rn - 1;
          gives = g.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            g.remove(gn);
            g.add(wants);
            w.remove(wn);
            w.add(gives);
            updateTeams();
            Graphics.write("The Warriors have agreed to your trade!");
          } else {
            Graphics.write("Unfortunately, the Warriors have declined your trade.");
          }
          Graphics.write("Do you want to make another trade?");
          Graphics.ar.await();
          if (yn(response)) {
            trade(team);
          } else {
            Graphics.write("Would you like to return to the menu?");
            Graphics.ar.await();
            if (yn(response)) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        }
        if (rn == 2) {
          Graphics.write("Here is the Lakers roster:");
          for (int i = 0; i < l.size(); i++) {
            Graphics.write(i + 1 + ". " + l.get(i));
          }
          Graphics.write("Which player would you like to trade for?\n(Numbers 1-15)");
          Graphics.ar.await();
          wn = rn - 1;
          wants = l.get(wn);
          Graphics.write("Here is your team:");
          for (int i = 0; i < g.size(); i++) {
            Graphics.write(i + 1 + ". " + g.get(i));
          }
          Graphics.write("Which player will you give up?\n(Numbers 1-15)");
          Graphics.ar.await();
          gn = rn - 1;
          gives = g.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            g.remove(gn);
            g.add(wants);
            l.remove(wn);
            l.add(gives);
            updateTeams();
            Graphics.write("The Lakers have agreed to your trade!");
          } else {
            Graphics.write("Unfortunately, the Lakers have declined your trade.");
          }
          Graphics.write("Do you want to make another trade?");
          Graphics.ar.await();
          if (yn(response)) {
            trade(team);
          } else {
            Graphics.write("Would you like to return to the menu?");
            Graphics.ar.await();
            if (yn(response)) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        }
        if (rn == 3) {
          Graphics.write("Here is the Nuggets roster:");
          for (int i = 0; i < n.size(); i++) {
            Graphics.write(i + 1 + ". " + n.get(i));
          }
          Graphics.write("Which player would you like to trade for?\n(Numbers 1-15)");
          Graphics.ar.await();
          wn = rn - 1;
          wants = n.get(wn);
          Graphics.write("Here is your team:");
          for (int i = 0; i < g.size(); i++) {
            Graphics.write(i + 1 + ". " + g.get(i));
          }
          Graphics.write("Which player will you give up?\n(Numbers 1-15)");
          Graphics.ar.await();
          gn = rn - 1;
          gives = g.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            g.remove(gn);
            g.add(wants);
            n.remove(wn);
            n.add(gives);
            updateTeams();
            Graphics.write("The Nuggets have agreed to your trade!");
          } else {
            Graphics.write("Unfortunately, the Nuggets have declined your trade.");
          }
          Graphics.write("Do you want to make another trade?");
          Graphics.ar.await();
          if (yn(response)) {
            trade(team);
          } else {
            Graphics.write("Would you like to return to the menu?");
            Graphics.ar.await();
            if (yn(response)) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        } else {
          Graphics.write("Please pick the number of one of the teams.");
          Graphics.write("Would you like to return to the menu?");
          Graphics.ar.await();
          if (yn(response)) {
            simulate(team);
          } else {
            trade(team);
          }
        }
      }
      catch(Exception e){
        Graphics.write("Please enter a number.");
        trade(team);
      }
    }
    if(team==4) {
      Graphics.write("Which team would you like to trade with?\n1. Golden State Warriors \n2. LA Lakers\n3. Memphis Grizzlies\n4. Exit trade menu");
      Graphics.ar.await();
      try {
        if (rn == 1) {
          Graphics.write("Here is the Warriors roster:");
          for (int i = 0; i < w.size(); i++) {
            Graphics.write(i + 1 + ". " + w.get(i));
          }
          Graphics.write("Which player would you like to trade for?\n(Numbers 1-15)");
          Graphics.ar.await();
          wn = rn - 1;
          wants = w.get(wn);
          Graphics.write("Here is your team:");
          for (int i = 0; i < n.size(); i++) {
            Graphics.write(i + 1 + ". " + n.get(i));
          }
          Graphics.write("Which player will you give up?\n(Numbers 1-15)");
          Graphics.ar.await();
          gn = rn - 1;
          gives = n.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            n.remove(gn);
            n.add(wants);
            w.remove(wn);
            w.add(gives);
            updateTeams();
            Graphics.write("The Warriors have agreed to your trade!");
          } else {
            Graphics.write("Unfortunately, the Warriors have declined your trade.");
          }
          Graphics.write("Do you want to make another trade?");
          Graphics.ar.await();
          if (yn(response)) {
            trade(team);
          } else {
            Graphics.write("Would you like to return to the menu?");
            Graphics.ar.await();
            if (yn(response)) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        }
        if (rn == 2) {
          Graphics.write("Here is the Lakers roster:");
          for (int i = 0; i < l.size(); i++) {
            Graphics.write(i + 1 + ". " + l.get(i));
          }
          Graphics.write("Which player would you like to trade for?\n(Numbers 1-15)");
          Graphics.ar.await();
          wn = rn - 1;
          wants = l.get(wn);
          Graphics.write("Here is your team:");
          for (int i = 0; i < n.size(); i++) {
            Graphics.write(i + 1 + ". " + n.get(i));
          }
          Graphics.write("Which player will you give up?\n(Numbers 1-15)");
          Graphics.ar.await();
          gn = rn - 1;
          gives = n.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            n.remove(gn);
            n.add(wants);
            l.remove(wn);
            l.add(gives);
            updateTeams();
            Graphics.write("The Lakers have agreed to your trade!");
          } else {
            Graphics.write("Unfortunately, the Lakers have declined your trade.");
          }
          Graphics.write("Do you want to make another trade?");
          Graphics.ar.await();
          if (yn(response)) {
            trade(team);
          } else {
            Graphics.write("Would you like to return to the menu?");
            Graphics.ar.await();
            if (yn(response)) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        }
        if (rn == 3) {
          Graphics.write("Here is the Grizzlies roster:");
          for (int i = 0; i < g.size(); i++) {
            Graphics.write(i + 1 + ". " + g.get(i));
          }
          Graphics.write("Which player would you like to trade for?\n(Numbers 1-15)");
          Graphics.ar.await();
          wn = rn - 1;
          wants = g.get(wn);
          Graphics.write("Here is your team:");
          for (int i = 0; i < n.size(); i++) {
            Graphics.write(i + 1 + ". " + n.get(i));
          }
          Graphics.write("Which player will you give up?\n(Numbers 1-15)");
          Graphics.ar.await();
          gn = rn - 1;
          gives = n.get(gn);
          if (abs(wants.getOverall() - gives.getOverall()) <=7) {
            n.remove(gn);
            n.add(wants);
            g.remove(wn);
            g.add(gives);
            updateTeams();
            Graphics.write("The Nuggets have agreed to your trade!");
          } else {
            Graphics.write("Unfortunately, the Nuggets have declined your trade.");
          }
          Graphics.write("Do you want to make another trade?");
          Graphics.ar.await();
          if (yn(response)) {
            trade(team);
          } else {
            Graphics.write("Would you like to return to the menu?");
            Graphics.ar.await();
            if (yn(response)) {
              simulate(team);
            } else {
              trade(team);
            }
          }
        }
          else {
            Graphics.write("Please pick the number of one of the teams.");
            Graphics.write("Would you like to return to the menu?");
            Graphics.ar.await();
            if (yn(response)) {
              simulate(team);
            } else {
              trade(team);
            }
          }
      }
      catch(Exception e){
        Graphics.write("Please enter a number.");
        trade(team);
      }
    }
    else{
      Graphics.write("error");
    }
  }
  public static void generatePlayers(){
    Graphics.write("Generating random players...");
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
  public static boolean eq() throws InterruptedException{
    Graphics.write("Do you want to exit?");
    Graphics.ar.await();
    return yn(response);
  }

  public static String randomName(){
    String[] fns={"James","Robert","John","Michael","David","William","Richard","Joseph","Thomas","Daniel","Anthony","Mark","Steven","Paul","Andrew","George","Timothy","Jason","Ryan","Jacob","Gary","Eric","Larry","Scott","Justin","Frank","Brandon","Jack","Dennis","Jerry","Bob","Jeff","Lalith","Bryan"};
    String[] lns={"Smith","Johnson","Williams","Brown","Jones","Miller","Davis","Garcia","Lopez","Wilson","Anderson","Thomas","Jackson","Martin","Lee","Thompson","Harris","Clark","Lewis","Robinson","Walker","Allen","King","Wright","Scott","Torres","Hill","Adams","Olebe","Sasubili","Thai"};
    return fns[(int)(Math.random()*fns.length)]+" "+lns[(int)(Math.random()*lns.length)];
  }
  public static int abs(int z){
    return Math.abs(z);
  }

}  