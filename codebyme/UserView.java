package com.codebyme;

public class UserView extends DataClass {
    public UserView() {

    }
    void Topic(int n)
    {
        switch(n)
        {
            case 1:
                System.err.println("-------Create  an Student-------");
                break;
            case 2:
                System.err.println("-------List Student details-------");
                break;
            case 3:
                System.err.println("-------Search Student details-------");
                break;
            case 5:
                System.err.println("-------Edit Student details-------");
                break;
            case 4:
                System.err.println("-------Delete Student details-------");
                break;
        }
    }
    void ShowAchoice() {
        // User Option or Choice
        System.out
                .println("1. Create  an Student\r\n" + "2. List Student details \r\n" + "3. Search Student details \r\n"
                        + /*"4. Edit Student details" + */"4. Delete Student details \r\n" + "5. Exit ");
        System.out.print("Enter Your choice ");
    }

    void DisplayView1() {
        System.out.println("--------------------------------");
        System.out.println("StudentId" + "     |     " + "StudentName");
        System.out.println("--------------------------------");
    }

    void DiplayView2() {
        System.out.println("--------------------------------");
    }

    void ShowAdetails(int id, String name) {
        System.out.println("   " + id + "               " + name);
    }

}