/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class BackUp {

    static int indexOfStudents;
    static int indexOfAdvisors;
    static Student[] students = new Student[100];
    static Manager[] managers = new Manager[50];
    static int indexOfManagers;
    static int numberOfManagers;
    static int numberOfStudents;
    static int numberOfAdvisors;
    static Advisor[] advisors = new Advisor[50];
    static Request[] requests = new Request[200];
    
    public static void main(String[] args) throws IOException {
        Scanner cin = new Scanner(System.in);

        numberOfStudents = 0;//number of students that had signUped till now
        numberOfAdvisors = 0;//number of advisors that had signuped till now
        numberOfManagers = 0;//number of managers that had signuped till now
        while(true){//the main class
            
            System.out.println("What do you want to do? Insert the number\n"
                    + "1.Log in\n" + "2.Sign up\n" + "3.Information\n" +"4.Exit\n");
            
            int choice = cin.nextInt();
            switch(choice){
                case 4:
                    return;
                case 2:
                    signUp();
                    break;

                case 1:
                    logIn();
                    break;
                default:
                    break;
                    
            }
        }
    }
    
    static boolean existanceOfStudent;
    static int usernameOfStudent;
    static int usernameOfAdvisor;
    static boolean existanceOfAdvisor;
    static int usernameOfManager;
    static boolean existanceOfManager;
    static public void signUp() throws IOException{
        String level = null;//برای معلوم شدن نوع دانشجو(کارشناسی؟ارشد؟دکترا؟)
        
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(reader);
        Scanner cin = new Scanner(System.in);
        
        System.out.println("\nwhich one is you?");
        System.out.println("1.Student\n2.Advisor\n3.Manager\n");
        int who = cin.nextInt();
        
        switch(who){
            case 1://signing up for student
                indexOfStudents = numberOfStudents;//a backUp of number of students
                int grade;
                
                System.out.println("\nwhich one is you?");
                System.out.println("1.BSC");
                System.out.println("2.MSC");
                System.out.println("3.PHD\n");
                grade = cin.nextInt();//to know bsc or msc or phd student and the difference this with level is that
                //this is for when student wants to choose the number and level is for the string of the grade!
                
                boolean lastPage = false;//to back to last page
                /*if(lastPage)
                    break;*/
                
                switch(grade){
                    case 1:
                        level = "BSC";
                        break;
                    case 2:
                        level = "MSC";
                        break;
                    case 3:
                        level = "PHD";
                        break;
                    default:
                        System.out.println("\ninvalid option, try again or press 0 to go back!\n");
                        grade = cin.nextInt();
                        if(grade == 0)
                            lastPage = true;
                        break;
                }
                if(lastPage)
                    break;

                System.out.println("\nplease enter your Student id and password and name");
                System.out.print("\nStudent id :");
                usernameOfStudent = cin.nextInt();//to signUp and having student id

                existanceOfStudent= false;//to check if that student with that id has been added or existed or not

                for (int j = 0; j < indexOfStudents; j++) {//to check if that student with that id has been added or existed or not
                    if( students[j].getUsername() == usernameOfStudent){
                        System.out.println("your Student id has been added before");
                        existanceOfStudent = true;//that student has added before and it exists now
                        break;
                    }
                }
                if(existanceOfStudent)//becase of the student has been existed,it doesn't signUp anymore and it will go back to first page
                    break;

                System.out.print("\npassword :");//now student that doesn't exist, it can signup
                String passwordOfStudent = cin.next();

                System.out.print("\nname :");
                String nameOfStudent = buffer.readLine();

                students[indexOfStudents] = new Student(usernameOfStudent , passwordOfStudent , nameOfStudent , level);//to save the informations of each student

                numberOfStudents +=1;//One was added to the number of students
                System.out.println("\nyou are added successfully!\n");
                break;
            case 2://sign up for advisors
                indexOfAdvisors = numberOfAdvisors;//a copy of the number of advisors that signed up
                System.out.println("\nplease enter your personal id and name and your password!\n");
                System.out.print("personal id :");
                usernameOfAdvisor = cin.nextInt();
                
                existanceOfAdvisor = false;//to find out if this advisor has been added before
                
                for (int i = 0; i < indexOfAdvisors; i++) {//to check that if advisor has been added before or not
                
                    if(advisors[i].getUsername() == usernameOfAdvisor){
                        System.out.println("your personal id has been added before");
                        existanceOfAdvisor = true;
                        break;
                    }
                
                }
                
                if(existanceOfAdvisor)//advisor has been added before so the program will be go out of sign up
                    break;
                
                System.out.print("\npassword :");
                String passwordOfAdvisor = cin.next();
                
                System.out.print("\nname :");
                String nameOfAdvisor = buffer.readLine();
                
                advisors[indexOfAdvisors] = new Advisor(usernameOfAdvisor, passwordOfAdvisor, nameOfAdvisor);//to save the information of each advisor
                
                numberOfAdvisors += 1;//One was added to the number of advisors
                System.out.println("\nyou are added successfully!\n");
                break;
            case 3://like advisors and student sign up
                indexOfManagers = numberOfManagers;
                System.out.println("please enter your personal id and name and your password!");
                System.out.print("\npersonal id :");
                usernameOfManager = cin.nextInt();
                
                existanceOfManager = false;
                
                for (int i = 0; i < indexOfManagers; i++) {
                    
                    if(managers[i].getUsername() == usernameOfManager){
                        System.out.println("\nyour personal id has been added before\n");
                        existanceOfManager = true;
                        break;
                    }
                }
                if(existanceOfManager)
                    break;
                
                System.out.print("\npassword :");
                String passwordOfManager = cin.next();
                
                System.out.print("\nname :");
                String nameOfManager = buffer.readLine();
                
                managers[indexOfManagers] = new Manager(usernameOfManager, passwordOfManager, nameOfManager);
                numberOfManagers++;
                
                System.out.println("\nyou are added successfully!\n");
                
                break;
            default://choose another number that hasn't exist
                System.out.println("\ninvalid choice\n");
                break;           
        }
    }
    
    static private int homeIndexOfAdvisor = -1;//a copy index of advisor's home index in array
    static private int homeIndexOfManager = -1;//a copy index of manager's home index in array
    static private int requestCounter = 0;//the number of all requests that have added before
    static private int indexOfStudentRequested = -1;//the number of the requests for each student
    
    static public void logIn() throws IOException{
        Scanner cin = new Scanner(System.in);
        
        System.out.println("which one is you?");
        System.out.println("1.Student\n2.Advisor\n3.Manager\n");
        int who = cin.nextInt();
        switch(who){
        case 1://log in for student
            System.out.println("\nplease enter your Student id and password\n");

            System.out.print("\nStudent id :");
            usernameOfStudent = cin.nextInt();

            existanceOfStudent= false;//search if the student has been signed up or not

            boolean lastPage = false;//to back to first page
            

            for (int j = 0; j < numberOfStudents; j++) {//to check if student has been signed up before
                if( students[j].getUsername() == usernameOfStudent){
                    System.out.print("\npassword :");//so it can log in and enter the password!:D
                    String passwordOfStudent = cin.next();
                    
                    while(!students[j].getPassword().equals(passwordOfStudent)){//Checks whether it is the same with the previous password
                        System.out.println("\nyour password is incorrect please enter again or press 0 to go back");//if password is wrong
                        passwordOfStudent = cin.next();
                        if(passwordOfStudent.equals("0")){
                            lastPage = true;//to go back to first page
                            break;
                        }
                    }
            
                    if(lastPage)//back to first page
                        break;
                    indexOfStudentRequested = j;//a copy of the student home index
                    existanceOfStudent = true;
                    System.out.printf("\ndear %s you loged in successfully!\n" , students[j].getName());
                }
                
            }
            
            if(existanceOfStudent == false){//for the student not to be sign up
                System.out.println("\ninvalid Student id, you can sign up if you want");
                break;
            }
            
            while(true){
                lastPage = false;
                System.out.println("\nwhat do you want to do?\n1.request\n2.view request\n3.go back\n");
                int choice = cin.nextInt();
               
                switch(choice){
                    case 1://to request
                        requesting();
                        break;
                    case 2:
                        viewRequest();//to view request
                        break;
                    case 3:
                        lastPage = true;//for back to first page
                        break;
                }
                if(lastPage)//back to first page
                    break;
            }
            break;
            
        case 2://like student's log in
            
            System.out.println("\nplease enter your personal id and password");
            System.out.print("\npersonal id :");
            usernameOfAdvisor = cin.nextInt();
            
            existanceOfAdvisor = false;
            
            lastPage = false;
            
            for (int i = 0; i < numberOfAdvisors; i++) {
                if(advisors[i].getUsername() == usernameOfAdvisor){
                    
                    existanceOfAdvisor = true;
                    homeIndexOfAdvisor = i;
                    
                    System.out.print("\npassword :");
                    String passwordOfAdvisor = cin.next();
                    
                    while(!advisors[i].getPassword().equals(passwordOfAdvisor)){
                    
                        System.out.println("\nyour password is incorrect please enter again or press 0 to go back");
                        passwordOfAdvisor = cin.next();
                        
                        if(passwordOfAdvisor.equals("0")){
                        
                            lastPage = true;
                            break;
                        }
                    }
                    if(lastPage)
                        break;
                    System.out.format("\ndear %s you loged in successfully!\n" , advisors[i].getName());
                    
                    while(true){
                        
                        System.out.println("\nwhich one do you want to see? write the student id or press 0 to log out");
                        //to see requests that is for this advisor and their status is requested!
                        
                        for (int j = 0; j < requestCounter; j++) {//Print all of the above requests
                            if(requests[j].getAdvisorId() == advisors[homeIndexOfAdvisor].getUsername() && requests[j].getStatus().equals("requested"))
                                System.out.println("\n"+ requests[j].getStudentId() + "\t" +requests[j].getSubject());
                        }
                        
                        int choose = cin.nextInt();
                        
                        if(choose == 0){
                            lastPage = true;
                            break;
                            
                        }else{//print the student number and subject and abstract of request and now advisor have to accept or reject the request
                            for (int j = 0; j < requestCounter; j++) {
                                if(choose == requests[j].getStudentId()){
                                    System.out.println("\n"+requests[j].getStudentId()+"\n"+requests[j].getSubject() +"\n"+ requests[j].getMyAbstract()+"\n");
                                    
                                    System.out.println("what do you want to do?\n1.accept\n2.reject");
                                    choose = cin.nextInt();
                                    
                                    switch(choose){
                                        case 1:
                                            requests[j].setStatus("accepted");
                                            break;
                                        case 2:
                                            requests[j].setStatus("rejected");
                                            break;
                                        case 3:
                                            System.out.println("invalid choice");
                                            break;
                                    }
                                }
                            }
                        }
                        
                        if(lastPage)
                            break;
                    }
                    
                }
                //now advisor should choose one of the students request and make the result yes or no for them
                //this should be in loop and the endof the loop should ask do you want to see more student's requests?
                //and if advisor wants to choose press sth or press 0 to go back
            }
            
            break;
        case 3:
            System.out.println("please enter your personal id and password");
            System.out.print("\npersonal id :");
            usernameOfManager = cin.nextInt();
            
            existanceOfAdvisor = false;
            
            lastPage = false;
            for (int i = 0; i < numberOfManagers; i++) {
                if(managers[i].getUsername() == usernameOfManager){
                    homeIndexOfManager = i;
                    existanceOfManager = true;
                    
                    System.out.print("\npassword");
                    String passwordOfManager = cin.next();
                    if(!managers[i].getPassword().equals(passwordOfManager)){
                        System.out.println("your password is incorrect please enter again or press 0 to go back");
                        passwordOfManager = cin.next();
                        if(passwordOfManager.equals("0")){
                            lastPage = true;
                        }
                    }
                    if(lastPage)
                        break;
                    System.out.format("\ndear %s you loged in successfully!\n" , managers[i].getName());
                    
                    System.out.println("choose one of these student to set refrees!");
                    while(true){
                        if(requests[homeIndexOfManager].getManagerId() == managers[homeIndexOfManager].getUsername() && requests[homeIndexOfManager].getStatus().equals("accepted"))
                            System.out.println(requests[homeIndexOfManager].getStudentId() + "\t" +requests[homeIndexOfManager].getStudentLevel());
                        
                    }
                    
                            
                }
                //to see who was accepted
                //choose one of them
                //choose one or two davar for the student
            }
            break;
        default:
            break;
        }
    
    }
    
    public static void requesting() throws IOException{
        Scanner cin = new Scanner(System.in);
        
        requests[requestCounter] = new Request();
        requests[requestCounter].setStudentId(students[indexOfStudentRequested].getUsername());//Save the student number in the array
        //to determine which application is for which student
        requests[requestCounter].getRequest();
        requests[requestCounter].setStatus("requested");//Change request status
        requests[requestCounter].setStudentLevel(students[indexOfStudentRequested].getLevel());
        
        System.out.println("who is your advisor? insert the personal id of your advisor :"); 
        for (int i = 0; i < numberOfAdvisors; i++)//Printing names and advisor's personal id
            System.out.print(advisors[i].getName() + "\t" +advisors[i].getUsername());
        requests[requestCounter].setAdvisorId(cin.nextInt());//Select and enter the personal number of the advisor and store the staff number in the array
        
        /*if(students[indexOfStudentRequested].getLevel().equals("MSC") || students[indexOfStudentRequested].getLevel().equals("PHD")){//if student is msc or phd to choose 2 advisor
            System.out.println("insert the personal id of your second advisor :");
            requests[requestCounter].setAdvisorId2(cin.nextInt());
        }*/
        
        System.out.println("who is your manager? insert the personal id of your manager");
        for (int i = 0; i < numberOfManagers; i++)//printing names and manager's personal id
            System.out.println(managers[i].getName() + "\t" +managers[i].getUsername());
        requests[requestCounter].setManagerId(cin.nextInt());
        
        requestCounter++;
    }
    
    public static void viewRequest(){
        
        for (int i = 0; i < requestCounter; i++)
            if(requests[i].getStudentId() == students[indexOfStudentRequested].getUsername())
                System.out.println(requests[i].getSubject() + "\n" + requests[i].getStatus() + "\n");
                
    }
}
