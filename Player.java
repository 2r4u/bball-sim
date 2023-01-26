class Player extends Person{
  private int height;
  private int weight;
  private int scoring;
  private int defense;
  private int teamwork;
  private int pos;

  public Player(String name, int age, int h, int w,int s,int d, int t){
    super(name,age);
    this.height=h;
    this.weight=w;
    this.scoring=s;
    this.defense=d;
    this.teamwork=t;
  }
  public String toString(){
    return(name+" is "+age+" years old, "+height+" inches tall, and "+weight+" pounds.\nScoring: "+scoring+" Defense: "+defense+" Teamwork: "+teamwork);
  }
  public int getHeight(){
    return height;
  }
  public int getWeight(){
    return weight;
  }
  public int getScoring(){
    return scoring;
  }
  public int getDefense(){
    return defense;
  }
  public int getTeamwork(){
    return teamwork;
  }
}