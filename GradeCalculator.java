import java.util.scanner;
public class GradeCalculator{
public static void main(String[]args){
Scanner scanner=new scanner(System.in);
System.out.println("Enter the number of projects:");
int numSubjects=scanner.nextInt();
scanner.nextLine();
int totalMarks=0;
for(int i=1;i<=numSubjects;i++)
{
System.out.print("Enter the name of subject"+i+":");
int marks=scanner.nextInt();
totalMarks+=marks;
if(i<numSubjects)
{
scanner.nextLine();
}
}
System.out.println("Total marks:"+totalMarks);
double averagePercentage=(double) totalMarks/numSubjects;
System.out.println("Average percentage:"+averagePercentage+"%");
char grade=calculateGrade(averagePercentage);
System.out.println("Grade:"+grade);
scanner.close();
}
private static char calculateGrade(double averagePercentage)
{
if(averagePercentage>=90)
{
return'A';
}
else if(averagePercentage>=80)
{
return'B';
}
else if(averagePercentage<=70)
{
return'C';
}
else if(averagePercentage<=60)
{
return'D';
}
else
{
return'F';
}
}
}