class Person{
  // protected int salary;
  protected String name;
  protected int age;
  
  // public int getSalary(){
  //   return salary;
  // }
  public Person(String n,int a){
    this.name=n;
    this.age=a;
  }
  public String getName(){
    return name;
  }
  public int getAge(){
    return age;
  }
  
}