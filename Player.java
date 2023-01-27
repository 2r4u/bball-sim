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
      return("how?");
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