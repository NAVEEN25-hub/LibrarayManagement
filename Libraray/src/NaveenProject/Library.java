package Naveen;
import java.util.*;
public class Library {
    public static void main(String[] args){
        Library.USER();
    }
    public static void USER(){
        String memberid = "123";
        String memberid1 = "23";
        String newid = "9965";
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome To Library Management");
        System.out.print("Enter Your Id Number : ");
        String id = sc.next();
        if (memberid.equals(id)|| memberid1.equals(id)|| newid.equals(id)) {
            BOOKS mainclass = new BOOKS();
            while (true) {
                try {
                    Thread.sleep(2000);
                    System.out.println("*******************************************");
                    System.out.println("1-Show All Books");
                    System.out.println("2-Get Books");
                    System.out.println("3-return Books");
                    System.out.println("4-exit");
                    System.out.println("5-Add Book");
                }
                catch (Exception e){

                }
                System.out.println("*******************************************");
                System.out.print("Enter Your Choice : ");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        mainclass.showallbook();
                        break;
                    case 2:
                        mainclass.getbook();
                        break;
                    case 3:
                        mainclass.returnbook();
                        break;
                    case 4:
                        System.out.println("Thank You Visit Again");
                        System.exit(0);
                    case 5:
                        mainclass.addbook();
                        break;
                }
            }
        }
        else {
            System.out.println("You Are Not Member So You Can Not Getbook");
            System.out.println("You Are Join The Member And Get The Book");
            System.out.println("1-You Join The Member ,    2-Exit");
            int put = sc.nextInt();
            switch (put){
                case 1:
                    System.out.println("Your Id is : " + newid);
                    Library.USER();
                case 2:
                    System.exit(0);
            }

        }

    }
}
class BOOK {
    String id,status ;
    String bookname,Authorname;
    public BOOK(String id,String bookname,String Authorname,String status){
        this.id = id;
        this.bookname = bookname;
        this.Authorname = Authorname;
        this.status = status;
    }
    public String getId(){
        return id;
    }
    public String getstatus() {
        return status;
    }
    public void setStatus(String status){

        this.status = status;
    }
    public String toString(){
        return  id + bookname + Authorname + status ;
    }
}
 class INPUTS {
    public static String bookid(){
        String id;
        Scanner sc = new Scanner(System.in);
        System.out.println("****************");
        System.out.println("* Enter BookId *");
        System.out.println("****************");
        id = sc.next();
        return id;
    }
    public static String bookname(){
        String bname;
        Scanner sc = new Scanner(System.in);
        System.out.println("******************");
        System.out.println("* Enter BookName *");
        System.out.println("******************");
        bname = sc.next();
        return bname.toUpperCase();
    }
    public static String Authorname(){
        String Authorname;
        Scanner sc = new Scanner(System.in);
        System.out.println("********************");
        System.out.println("* Enter AuthorName *");
        System.out.println("********************");
        Authorname = sc.next();
        return Authorname.toUpperCase();
    }
    public static String status(){
        String status = "Available";
        return status;
    }
}
 class BOOKS {
    static int bookcount = 10;
    static int count = 1;
    static int getbookcount = 1;
    INPUTS obj = new INPUTS();
    List<BOOK> BOOKS = new ArrayList<BOOK>();

    public void addbook() {
        Scanner sc = new Scanner(System.in);
        int adminid = 6789;
        System.out.println("Enter Correct password");
        System.out.print("Enter Admin PassWord : ");
        if (adminid == sc.nextInt()) {
            String bookid = obj.bookid();
            String bookname = obj.bookname();
            String authorname = obj.Authorname();
            String status = obj.status();
            BOOK obj = new BOOK(bookid, bookname, authorname, status);
            BOOKS.add(obj);
            System.out.println("Book Added Succesfully");
            bookcount++;
        } else {
            System.out.println("***************************************");
            System.out.println(" ERROR!!!     Only Admin Login");
            System.out.println("PassWord Is Wrong So ReLogin");
            System.out.println("***************************************");
            System.exit(0);
        }
    }

    public void showallbook() {
        String status = obj.status();
        if (count <= 1) {
            count++;
            BOOKS.add(new BOOK("11", "JAVA  ", "James ", status));
            BOOKS.add(new BOOK("12", "PYTHON", "ABCDEF", status));
            BOOKS.add(new BOOK("18", "SQL   ", "CODEIO", status));
            BOOKS.add(new BOOK("29", "CARTON", "Bheem ", status));
            BOOKS.add(new BOOK("31", "MOBILE", "VIVO  ", status));
            BOOKS.add(new BOOK("30", "AJITH ", "BIlla ", status));
            BOOKS.add(new BOOK("40", "CHEM  ", "Alghah", status));
            BOOKS.add(new BOOK("41", "KALAM ", "India ", status));
            BOOKS.add(new BOOK("50", "WORLD ", "WORLD ", status));
            BOOKS.add(new BOOK("51", "HISTOR", "Social", status));
        }
        System.out.println("*******************************************");
        System.out.println(" BOOKID   " + "BOOKNAME   " + " " + "Authorname  " + "   Status");
        System.out.println("*******************************************");
        for (BOOK obj : BOOKS) {
            System.out.println("   " + obj.id + "      " + obj.bookname + "       " + obj.Authorname + "      " + obj.status);
        }
        System.out.println("  Total Available count: " + bookcount);
        System.out.println("*******************************************");
    }

    public void getbook() {
        if (getbookcount <= 2) {
            String bookid = INPUTS.bookid();
            boolean flag = false;
            for (BOOK obj : BOOKS) {
                if (obj.getId().equals(bookid) && obj.getstatus().equals("Available")) {
                    flag = true;
                    bookcount--;
                    getbookcount++;
                    System.out.println("Book Is Taken Succefully");
                    obj.setStatus("Not Available");
                }
            }
            if (flag == false) {
                System.out.println("Book Is Not Available");
            }
        } else
            System.out.println("********Only Taken 2 Books******");
    }

    public void returnbook() {
        boolean flag = false;
        String bookid = INPUTS.bookid();
        for (BOOK obj : BOOKS) {
            if (obj.getId().equals(bookid) && obj.getstatus().equals("Not Available")) {
                bookcount++;
                System.out.println("Book Is Return Succefully");
                obj.setStatus("Available");
            }
        }
        if (flag == false) {
            System.out.println("Can Not Return");
        }
    }
}


