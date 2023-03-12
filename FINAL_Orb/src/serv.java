import MovieTicketBookingSystem.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.util.ArrayList;
import java.util.HashMap;

public class serv {
    public static HashMap<String,HashMap<String, Integer>> movies_Current_Capacity =   new HashMap<String, HashMap<String,Integer>>();
    public static  HashMap<String,HashMap<String, String>> movies_Names =new HashMap<String, HashMap<String,String>>();
    public static  HashMap<String,HashMap<String, Integer>> movies_max_Capacity=new HashMap<String, HashMap<String,Integer>>();
    public static  HashMap<String,HashMap<String, HashMap<String,Integer>>> movies_booking=new HashMap<>();
    public static  HashMap<String,ArrayList<String>> movies=new HashMap<>();
    public static  HashMap<String,ArrayList<String>> movies_bookings=new HashMap<>();
    public static HashMap<String,ArrayList<String>>movie_by_areas =new HashMap<>();
    public static HashMap<String,HashMap<String, Integer>>customers_tickets =new HashMap<>();




    public static void main(String args[]) {
        try{
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);
            movie_by_areas.put("ATW",new ArrayList<>());
            movie_by_areas.put("VER",new ArrayList<>());
            movie_by_areas.put("OUT",new ArrayList<>());
            movies_booking.put("ATW",new HashMap<>());
            movies_booking.put("VER",new HashMap<>());

            movies_booking.put("OUT",new HashMap<>());

            movies_Current_Capacity.put("ATW",new HashMap<>());

            movies_Current_Capacity.put("VER",new HashMap<>());

            movies_Current_Capacity.put("OUT",new HashMap<>());

            movies_Names.put("ATW",new HashMap<>());

            movies_Names.put("VER",new HashMap<>());

            movies_Names.put("OUT",new HashMap<>());
            movies_max_Capacity.put("ATW",new HashMap<>());

            movies_max_Capacity.put("VER",new HashMap<>());

            movies_max_Capacity.put("OUT",new HashMap<>());

            // get reference to rootpoa & activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // create servant and register it with the ORB
            ServerImpl serverimpl = new ServerImpl();
            serverimpl.setORB(orb);

            // get object reference from the servant
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(serverimpl);
            Server href =  ServerHelper.narrow(ref);

            // get the root naming context
            // NameService invokes the name service
            org.omg.CORBA.Object objRef =
                    orb.resolve_initial_references("NameService");
            // Use NamingContextExt which is part of the Interoperable
            // Naming Service (INS) specification.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // bind the Object Reference in Naming

            NameComponent path[] = ncRef.to_name( "User" );
            ncRef.rebind(path,  href);

            System.out.println("Theatre Servers ready and waiting ...");

            // wait for invocations from clients

            orb.run();
        }
        catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("Theatre Servers Exiting ...");

    }
}

