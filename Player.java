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
      return (name + " is a " + age + " year old point guard who is "+height + " inches tall, and " + weight + " pounds.\nScoring: " + scoring + " Defense: " + defense + " Teamwork: " + teamwork);
    }
    if(pos==2) {
      return (name + " is a " + age + " year old shooting guard who is "+height + " inches tall, and " + weight + " pounds.\nScoring: " + scoring + " Defense: " + defense + " Teamwork: " + teamwork);
    }
    if(pos==3) {
      return (name + " is a " + age + " year old small forward who is "+height + " inches tall, and " + weight + " pounds.\nScoring: " + scoring + " Defense: " + defense + " Teamwork: " + teamwork);
    }
    if(pos==4) {
      return (name + " is a " + age + " year old power forward who is "+height + " inches tall, and " + weight + " pounds.\nScoring: " + scoring + " Defense: " + defense + " Teamwork: " + teamwork);
    }
    if(pos==5) {
      return (name + " is a " + age + " year old center who is "+height + " inches tall, and " + weight + " pounds.\nScoring: " + scoring + " Defense: " + defense + " Teamwork: " + teamwork);
    }
    return("bruh");
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