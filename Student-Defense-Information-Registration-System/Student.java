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

/**
 *
 * @author User
 */
public class Student {
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader buffer = new BufferedReader(reader);
    Scanner cin = new Scanner(System.in);
    
    private int username;
    private String password;
    private String name;
    private int rq;
    private String subject;
    private String myAbstract;
    private String level;
    
    public Student(){}
    
    public Student(int username , String password , String name , String level){
        
        this.username = username;
        this.password = password;
        this.name = name;
        this.level = level;
        
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getUsername() {
        return username;
    }
    
    public void setUsername(int username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void timePlace(){}
    
    /*public void choose() throws IOException{
        System.out.println("which one do you want?");
        System.out.println("1.request");
        System.out.println("2.result");
        rq = cin.nextInt();
        switch(rq){
            case 1:
                request();
                System.out.println("your request has been added");
                break;
            case 2:
                result();
                break;
            default:
                System.out.println("invalid choice");
                break;
        }
    }*/

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


}
