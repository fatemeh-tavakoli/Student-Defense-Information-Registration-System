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
public class Request {
    
    private int studentId;
    private int advisorId;
    private String status;
    private String status2;//for msc & phd students
    private int managerId;
    private int advisorId2;//for msc & phd students
    private String studentLevel;
    private String refree1;
    private String refree2;
    private String refree3;
    private int requestCounter;
    
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader buffer = new BufferedReader(reader);
    Scanner cin = new Scanner(System.in);
    private String myAbstract;
    private String subject;
    
    
    public Request(){}
    
    public void getRequest()throws IOException{
        System.out.println("please enter your subject :");
        this.subject = buffer.readLine();
        
        System.out.println("please enter your abstract :");
        this.myAbstract = buffer.readLine();
    }
    
    public Request(int studentId){
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(int advisorId) {
        this.advisorId = advisorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMyAbstract() {
        return myAbstract;
    }

    public void setMyAbstract(String myAbstract) {
        this.myAbstract = myAbstract;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getAdvisorId2() {
        return advisorId2;
    }

    public void setAdvisorId2(int advisorId2) {
        this.advisorId2 = advisorId2;
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel;
    }

    public String getRefree1() {
        return refree1;
    }

    public void setRefree1(String refree1) {
        this.refree1 = refree1;
    }

    public String getRefree2() {
        return refree2;
    }

    public void setRefree2(String refree2) {
        this.refree2 = refree2;
    }

    public String getRefree3() {
        return refree3;
    }

    public void setRefree3(String refree3) {
        this.refree3 = refree3;
    }

    public int getRequestCounter() {
        return requestCounter;
    }

    public void setRequestCounter(int requestCounter) {
        this.requestCounter = requestCounter;
    }
    
}
