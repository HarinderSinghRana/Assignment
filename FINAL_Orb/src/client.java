
import MovieTicketBookingSystem.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class client
{
    static Server serverImpl;
    public static void main(String args[])
    {
        try{
            // create and initialize the ORB

            Scanner myObj = new Scanner(System.in);

            // get the root naming context
            System.out.print("Please Enter your id : ");



            String userName = myObj.nextLine();
            String area = userName.substring(0,3);
            String Type = userName.substring(3,4);
            File file = new File(userName + ".txt");
            FileWriter writer ;

            System.out.println("");
                while(true) {
                    writer = new FileWriter(userName+ ".txt");
                    String message = userName;
                    if (Type.equals("A")) {
                        System.out.println("Select One of the following actions to performs");
                        System.out.println("1- Add a movie ");
                        System.out.println("2- Delete a movie");
                        System.out.println("3- Show a given movie dates");
                        int ans = myObj.nextInt();
                        if (ans == 1) {
                            System.out.print("Please Enter your movie ID : ");
                            String movieID = myObj.next();
                            System.out.println("");
                            System.out.print("Please Enter your movie name : ");
                            String moviename = myObj.next();
                            System.out.println("");
                            System.out.print("Please Enter the movie booking capacity : ");
                            int capacity = myObj.nextInt();
                            System.out.println("");
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                            LocalDateTime now = LocalDateTime.now();
                            try {
                                writer.write(dtf.format(now) + " ----> SENT AN ADD MOVIE REQUEST TO THE SERVER" + '\n');
                            }catch (Exception e){

                            }
                            message += " " + area + " 1 " + movieID + " " + moviename + " " + capacity;

                        }
                        if (ans == 2) {
                            System.out.print("Please Enter the movie ID : ");
                            String movieID = myObj.next();
                            System.out.println("");
                            System.out.print("Please Enter the movie name : ");
                            String moviename = myObj.next();
                            System.out.println("");
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                            LocalDateTime now = LocalDateTime.now();
                            try {
                                writer.write(dtf.format(now) + " ----> SENT A DELETE MOVIE  REQUEST TO THE SERVER" + '\n' );

                            }
                                catch (Exception e){

                                }
                                message += " " + area + " 2 " + movieID + " " + moviename + " ";
                        }
                        if (ans == 3) {
                            System.out.print("Please Enter the movie name : ");
                            String moviename = myObj.next();
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                            LocalDateTime now = LocalDateTime.now();
                            try {
                                writer.write(dtf.format(now) + " ----> SENT A PULL SCHEDULE REQUEST TO THE SERVER" + '\n');
                            }catch (Exception e){

                            }
                            message += " " + area + " 3 " + moviename;
                        }
                    } else if (Type.equals("C")) {
                        System.out.println("Select One of the following actions to performs");
                        System.out.println("1- Book  a movie Tickets ");
                        System.out.println("2- get booking schedule");
                        System.out.println("3- Cancel a booking for a movie Ticket");
                        System.out.println("4- Exchange a movie ticket for another one");
                        int ans = myObj.nextInt();
                        if (ans == 1) {
                            System.out.print("Please Enter your movie ID : ");
                            String movieID = myObj.next();
                            System.out.println("");
                            System.out.print("Please Enter your movie name : ");
                            String moviename = myObj.next();
                            System.out.println("");
                            System.out.print("Please Enter the number of tickets to book : ");
                            int tickets = myObj.nextInt();
                            System.out.println("");
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                            LocalDateTime now = LocalDateTime.now();
                            try {


                                writer.write(dtf.format(now) + " ----> SENT A BOOKING MOVIE  REQUEST TO THE SERVER" + '\n');
                            }catch (Exception e){

                            }
                            message += " " + area + " 1 " + movieID + " " + moviename + " " + tickets;
                        }
                        if (ans == 2) {
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                            LocalDateTime now = LocalDateTime.now();

                            try {
                                writer.write(dtf.format(now) + " ----> SENT A PULL BOOKING SCHEDULE  REQUEST TO THE SERVER" + '\n' );
                            }catch (Exception e){

                            }

                            message += " " + area + " 2 ";
                        }
                        if (ans == 3) {
                            System.out.print("Please Enter your movie ID : ");
                            String movieID = myObj.next();
                            System.out.println("");
                            System.out.print("Please Enter your movie name : ");
                            String moviename = myObj.next();
                            System.out.println("");
                            System.out.print("Please Enter the number of tickets to cancel : ");
                            int tickets = myObj.nextInt();
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                            LocalDateTime now = LocalDateTime.now();
                            try {
                                writer.write(dtf.format(now) + " ----> SENT A CANCEL  MOVIE  BOOKING  REQUEST TO THE SERVER" + '\n');
                            }
                            catch(Exception e){

                            }
                            message += " " + area + " 3 " + movieID + " " + moviename + " " + tickets;
                        }
                        if(ans==4){
                            System.out.print("Please Enter your first  movie ID : ");
                            String movieID = myObj.next();
                            System.out.println("");
                            System.out.print("Please Enter your first  movie name : ");
                            String moviename = myObj.next();
                            System.out.println("");
                            System.out.print("Please Enter the number of tickets to exchange : ");
                            int tickets = myObj.nextInt();
                            System.out.println("");
                            System.out.print("Please Enter your second  movie ID : ");
                            String movieID_New = myObj.next();
                            System.out.println("");
                            System.out.print("Please Enter your second  movie name : ");
                            String moviename_New = myObj.next();
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                            LocalDateTime now = LocalDateTime.now();
                            try {
                                writer.write(dtf.format(now) + " ----> SENT AN EXCHANGE TICKET BOOKING  REQUEST TO THE SERVER" + '\n');
                            }catch (Exception e){

                            }
                            message += " " + area + " 4 " + movieID + " " + moviename + " " + tickets + " " + movieID_New + " " + moviename_New;
                        }
                    } else {
                        System.out.println("WRONG USERNAME");

                    }

                    ORB orb = ORB.init(args, null);
                    org.omg.CORBA.Object objRef =
                            orb.resolve_initial_references("NameService");

                    NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
                    serverImpl = ServerHelper.narrow(ncRef.resolve_str("User"));
                    System.out.println(serverImpl.processRequest(message));
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    try {
                        writer.write(dtf.format(now) + " ----> SERVER RESPONDED WITH : " + serverImpl.processRequest(message) + '\n');
                        writer.close();
                    }
                    catch (Exception e ){

                    }
                }
            // Use NamingContextExt instead of NamingContext. This is
            // part of the Interoperable naming Service.
        } catch (Exception e) {
            System.out.println("ERROR : " + e) ;
            e.printStackTrace(System.out);
        }
    }

}

