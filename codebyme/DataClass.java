package com.codebyme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static <DataClass> void main(String[] args) {
        UserView uv = new UserView();
        try {
            List<DataClass> StudentData = new ArrayList<>();
            int choice = 0;
            int searchingid;
            //int Editingid;
            int flag=0;

            System.out.println("Welcome");

            while (choice != 6) {
                uv.ShowAchoice();
                choice = sc.nextInt();

                switch (choice) {
                    case 1: //Creating a Student Detail
                        uv.Topic(choice);
                        uv.setstudentData();
                        StudentData.add(new DataClass(uv.getid(), uv.getName()));
                        break;

                    case 2: // List of Student
                        uv.Topic(choice);
                        uv.DisplayView1();
                        for (DataClass k : StudentData) {
                            uv.ShowAdetails(k.id, k.Name);
                        }
                        uv.DiplayView2();
                        break;

                    case 3: //Searching student detail
                        uv.Topic(choice);
                        searchingid = uv.searchbyid();
                        for (DataClass k : StudentData) {
                            if (k.id == searchingid) {uv.DisplayView1();uv.ShowAdetails(k.id, k.Name);uv.DiplayView2();flag=1;
                            }
                        }
                        if(flag==0)
                        {System.out.println(searchingid+" Not in a List");System.err.println("No Result Found"); }
                        break;

                    /*
                     * case 4: //Edit a Details int inc=0; uv.Topic(choice);
                     * System.out.println("Enter a student Id to Edit "); Editingid =sc.nextInt();
                     * for (DataClass k : StudentData) { if (k.id == Editingid)
                     * {StudentData.get(inc).StudentName=uv.modifyid();flag=1;break;} inc++; }
                     * if(flag==0)
                     * {System.out.println(Editingid+" Not in a List");System.err.println("Error!!")
                     * ; } break;
                     *
                     */

                    case 4: //Deleting a Detail
                        uv.Topic(choice);
                        int deleteid = uv.deletebyid();
                        if(StudentData.removeIf(k1 -> k1.id == deleteid))
                            System.out.println(deleteid+" is Successfully Removed");
                        else
                        {System.err.println("No Result Found"); System.out.println(deleteid+" Not in a List");}
                        break;

                    case 5: //Exit
                        System.err.println("Exited..");
                        System.exit(0);
                    default:
                        System.err.println("Retry- "+choice+" Not a Correct Option");break;
                }
            }
            sc.close();
        } catch (Exception e) {
            System.err.println(e + "  Re - Run Your Code");
        }
    }

}