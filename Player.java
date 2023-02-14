class Player extends Person {
  private int height;
  private int weight;
  private int scoring;
  private int defense;
  private int teamwork;
  private int overall;
  private int pos;

  public Player(String name, int age, int h, int w, int s, int d, int t) {
    super(name, age);
    this.height = h;
    this.weight = w;
    this.scoring = s;
    this.defense = d;
    this.teamwork = t;
    this.overall=(int)((s+d+t)/3);
    if(height<81){
      if(weight<250){
        if(defense<teamwork){
          if(teamwork>scoring){
            pos=1;
          }
          else{
            pos=2;
          }
        }
        else{
          pos=3;
        }
      }
      else{pos=4;}
    }
    else{pos=5;}
  }
  public String prac(int type, int move){
    if(type==1) {
      if (move == 1) {
        if ((int) (Math.random() * 100) > 100 - scoring) {
          scoring+=0.5;
          return (name + " made the layup!");
        } else {
          scoring+=0.25;
          return (name + " missed the layup.");
        }
      }
      else if (move == 2) {
        if ((int) (Math.random() * 100) > 100 - scoring) {
          scoring+=0.5;
          return (name + " made the jumper!");
        } else {
          scoring+=0.25;
          return (name + " missed the jumper.");
        }
      } else if (move == 3) {
        if ((int) (Math.random() * 100) > 100 - scoring) {
          scoring+=0.5;
          return (name + " made the post hook!");
        } else {
          scoring+=0.25;
          return (name + " missed the post hook.");
        }
      } else if (move == 4) {
        if ((int) (Math.random() * 100) > 100 - scoring) {
          scoring+=0.5;
          return (name + " made the three!");
        } else {
          scoring+=0.25;
          return (name + " missed the three.");
        }
      }
    }
    if(type==2) {
      if (move == 1) {
        if ((int) (Math.random() * 100) > 100 - defense) {
          defense+=0.5;
          return (name + " blocked the shot!");
        } else {
          defense+=0.25;
          return (name + " missed the shot.");
        }
      }
      else if (move == 2) {
        if ((int) (Math.random() * 100) > 100 - defense) {
          defense+=0.5;
          return (name + " closed out his defender!");
        } else {
          defense+=0.25;
          return (name + " sagged off his defender.");
        }
      } else if (move == 3) {
        if ((int) (Math.random() * 100) > 100 - defense) {
          defense+=0.5;
          return (name + " helped his teammate!");
        } else {
          defense+=0.25;
          return (name + " didn't stop the offense.");
        }
      } else if (move == 4) {
        if ((int) (Math.random() * 100) > 100 - defense) {
          defense+=0.5;
          return (name + " blocked the drive!");
        } else {
          defense+=0.25;
          return (name + " let his man past.");
        }
      }
    }
    if(type==3) {
      if (move == 1) {
        if ((int) (Math.random() * 100) > 100 - teamwork) {
          teamwork+=0.5;
          return (name + " threw a dime!");
        } else {
          teamwork+=0.25;
          return (name + " turned it over.");
        }
      }
      else if (move == 2) {
        if ((int) (Math.random() * 100) > 100 - teamwork) {
          teamwork+=0.5;
          return (name + " got the board!");
        } else {
          teamwork+=0.25;
          return (name + " missed the rebound.");
        }
      }
      else if (move == 3) {
        if ((int) (Math.random() * 100) > 100 - teamwork) {
          teamwork+=0.5;
          return (name + " set the screen!");
        } else {
          teamwork+=0.25;
          return (name + " was evaded.");
        }
      }
      else if (move == 4) {
        if ((int) (Math.random() * 100) > 100 - teamwork) {
          teamwork+=0.5;
          return (name + " rolled to the basket!");
        } else {
          teamwork+=0.25;
          return (name + " couldn't shake his defender.");
        }
      }
    }
    return("how?");

  }
  @Override
  public String toString() {
    if(pos==1) {
      return ("Name: "+name+" Age: "+age+" Position: Point guard Height: "+height + " inches Weight: " + weight + " lbs\nScoring: " + scoring + " Defense: " + defense + " Teamwork: " + teamwork+" Overall: "+overall);
    }
    if(pos==2) {
      return ("Name: "+name+" Age: "+age+" Position: Shooting guard Height: "+height + " inches Weight: " + weight + " lbs\nScoring: " + scoring + " Defense: " + defense + " Teamwork: " + teamwork+" Overall: "+overall);
    }
    if(pos==3) {
      return ("Name: "+name+" Age: "+age+" Position: Small forward Height: "+height + " inches Weight: " + weight + " lbs\nScoring: " + scoring + " Defense: " + defense + " Teamwork: " + teamwork+" Overall: "+overall);
    }
    if(pos==4) {
      return ("Name: "+name+" Age: "+age+" Position: Power forward Height: "+height + " inches Weight: " + weight + " lbs\nScoring: " + scoring + " Defense: " + defense + " Teamwork: " + teamwork+" Overall: "+overall);
    }
    if(pos==5) {
      return ("Name: "+name+" Age: "+age+" Position: Center Height: "+height + " inches Weight: " + weight + " lbs\nScoring: " + scoring + " Defense: " + defense + " Teamwork: " + teamwork+" Overall: "+overall);
    }
    else{
      return(super.toString());
    }
  }

  public int getHeight() {
    return height;
  }

  public int getWeight() {
    return weight;
  }

  public int getScoring() {
    return scoring;
  }

  public int getDefense() {
    return defense;
  }

  public int getTeamwork() {
    return teamwork;
  }
  public int getOverall(){
    return overall;
  }

}