class Person{
  protected double salary;
  protected String name;

  protected int age;




  public Person(String n, int a){
    this.name=n;
    this.age=a;

  }
  public String toString(){
    return(name+" is a "+age+" year old person.");
  }

  public String getName(){
    return name;
  }
  public int getAge(){
    return age;
  }
  
}