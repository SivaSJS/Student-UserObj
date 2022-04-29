package com.codebyme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            UserView uv = new UserView();
            List<DataClass> StudentData = new ArrayList<>();

            int choice = 0;
            int searchingid;
            //int Editingid;
            int flag = 0;

            System.out.println("Welcome");

            while (choice != 6) {
                uv.ShowAchoice();
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> { //Creating a Student Detail
                        uv.Topic(choice);
                        uv.setstudentData();
                        StudentData.add(new DataClass(uv.getid(), uv.getName()));
                    }
                    case 2 -> { // List of Student
                        uv.Topic(choice);
                        uv.DisplayView1();
                        for (DataClass k : StudentData) {
                            uv.ShowAdetails(k.id, k.Name);
                        }
                        uv.DiplayView2();
                    }

                    case 3 -> { //Searching student detail
                        uv.Topic(choice);
                        searchingid = uv.searchbyid();
                        for (DataClass k : StudentData) {
                            if (k.id == searchingid) {
                                uv.DisplayView1();
                                uv.ShowAdetails(k.id, k.Name);
                                uv.DiplayView2();
                                flag = 1;
                            }
                        }
                        if (flag == 0) {
                            System.out.println(searchingid + " Not in a List");
                            System.err.println("No Result Found");
                        }
                    }


                    case 4 -> { //Deleting a Detail
                        uv.Topic(choice);
                        int deleteid = uv.deletebyid();
                        if (StudentData.removeIf(k1 -> k1.id == deleteid))
                            System.out.println(deleteid + " is Successfully Removed");
                        else {
                            System.err.println("No Result Found");
                            System.out.println(deleteid + " Not in a List");
                        }
                    }
                    case 5 -> { //Exit

                        System.err.println("Exited..");
                        System.exit(0);
                    }
                    default -> System.err.println("Retry- " + choice + " Not a Correct Option");
                }
            }
            sc.close();
        } catch (Exception e) {
            System.err.println(e + "  Re - Run Your Code");
        }
    }

}

