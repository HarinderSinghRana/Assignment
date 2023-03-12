import MovieTicketBookingSystem.Admin;
import MovieTicketBookingSystem.Customer;
import MovieTicketBookingSystem.ServerPOA;
import org.omg.CORBA.ORB;

import java.util.ArrayList;
import java.util.HashMap;

public class ServerImpl extends ServerPOA {
    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    @Override
    public Admin getAdmin() {
        return null;
    }

    @Override
    public Customer getCustomer() {
        return null;
    }

    @Override
    public String processRequest(String input) {
        String username = input.split(" ")[0];
        String Type = username.substring(3, 4);
        String area = input.split(" ")[1];
        int command = Integer.parseInt(input.split(" ")[2]);
        if (command == 1) {
            if (Type.equals("A")) {
                String movie_id =  input.split(" ")[3];

                String movie_name =  input.split(" ")[4];

                int capacity = Integer.parseInt(input.split(" ")[5]);
                serv.movies_Names.get(area).put(movie_id,movie_name);
                serv.movies_max_Capacity.get(area).put(movie_id,capacity);
                serv.movies_Current_Capacity.get(area).put(movie_id,0);
                serv.movie_by_areas.get(area).add(movie_id);
                try {
                    serv.movies.get(movie_name).add(movie_id);
                }
                catch(Exception e){
                serv.movies.put(movie_name,new ArrayList<>());
                serv.movies.get(movie_name).add(movie_id);
                }
                return "Movie  Created Succesfully";
            }
            if (Type.equals("C")) {
                String movie_id =  input.split(" ")[3];

                String movie_name =  input.split(" ")[4];


                int capacity = Integer.parseInt(input.split(" ")[5]);
                try {
                    if(serv.movies_Names.get(area).get(movie_id).equals(movie_name) ) {
                        int max = serv.movies_max_Capacity.get(area).get(movie_id);
                        int curr = serv.movies_Current_Capacity.get(area).get(movie_id);

                        if(!serv.customers_tickets.containsKey(username )) {
                            serv.customers_tickets.put(username,new HashMap<>());

                        }
                        if(serv.customers_tickets.get(username).containsKey(movie_id)){
                            int c = serv.customers_tickets.get(username).get(movie_id);
                            if(c + capacity  + curr> max) return "NOT ENOUGH TICKETS AVAILABLE";


                        }
                        else {
                            serv.customers_tickets.get(username).put(movie_id,curr);
                        }

                        if (curr + capacity > max) return "NOT ENOUGH TICKETS AVAILABLE";
                        else {
                            serv.movies_Current_Capacity.get(area).put(movie_id, curr + capacity);
                        }
                        try {
                            serv.movies_bookings.get(username).add(movie_id);
                        } catch (Exception e) {
                            serv.movies_bookings.put(username, new ArrayList<String>());
                            serv.movies_bookings.get(username).add(movie_id);
                        }
                    }
                }catch(Exception es){
                    return "ENCOURRED AND ERROR WHILE FINDING THE MOVIE";
                }
                return "Movie Booked Succesfully";
            }
        }
        else if (command == 2) {
            if (Type.equals("A")) {
                String movie_id =  input.split(" ")[3];
                String movie_name =  input.split(" ")[4];
                    serv.movies_Names.get(area).remove(movie_id);
                    serv.movies_max_Capacity.get(area).remove(movie_id);
                    serv.movies_Current_Capacity.get(area).remove(movie_id);
                    serv.movies_Current_Capacity.get(area).remove(movie_id);
                    serv.movie_by_areas.get(area).remove(movie_id);
                try {
                    serv.movies.get(movie_name).remove(movie_id);
                }
                catch(Exception ignored){

                }
                return "Movie deleted with " + movie_name + "id " + movie_id ;
            }
            if (Type.equals("C")) {
                ArrayList<String> s = serv.movie_by_areas.get("ATW");

                ArrayList<String> s_ = serv.movie_by_areas.get("VER");

                ArrayList<String> s__ = serv.movie_by_areas.get("OUT");
                String r = "";
                if ( s == null)return "No movie found on your area";
                for (String item : s) {
                    if(r.contains(item)) continue;
                    r += item + " ";
                }
                for (String value : s_) {
                    if(r.contains(value)) continue;
                    r += value + " ";
                }
                for (String value : s__) {
                    if(r.contains(value)) continue;
                    r += value + " ";
                }

                return r ;

            }

        }
        else if (command == 3) {
            if (Type.equals("A")) {
                String movie_name =  input.split(" ")[3];

                try {
                   ArrayList<String> s =  serv.movies.get(movie_name);

                   String e = movie_name + " : ";

                    for (String value : s) {
                        if (e.contains(value)) continue;
                        System.out.println(value.substring(0, 3));
                        int curr = serv.movies_Current_Capacity.get(value.substring(0, 3)).get(value);
                        int max = serv.movies_max_Capacity.get(value.substring(0, 3)).get(value);
                        int c = max - curr;
                        e += value + " " + c + " ";
                    }
                    return e;
                }
                catch(Exception e){

                    System.out.println(e);
                    return "NO EXISTING MOVIE NAME";
                }
            }
            if (Type.equals("C")) {
                String movie_id =  input.split(" ")[3];
                String movie_name =  input.split(" ")[4];
                int max = serv.movies_max_Capacity.get(area).get(movie_id);
                int curr = serv.movies_Current_Capacity.get(area).get(movie_id);
                try {
                    serv.movies_Current_Capacity.get(area).put(movie_id,curr -  serv.customers_tickets.get(username).get(movie_id));
                    serv.customers_tickets.get(username).remove(movie_id);
                }catch (Exception e){
                    return "ERROR WHILE UNBOOKING TICKETS";
                }
                return "TICKETS WERE UNBOOKED SUCCESFULLY";

            }

        }
        else if (command == 4) {
            if (Type.equals("C")) {
                String movie_id =  input.split(" ")[3];
                String movie_name =  input.split(" ")[4];
                int capacity = Integer.parseInt(input.split(" ")[5]);
                String new_movie_id =   input.split(" ")[6];
                String new_movie_name =   input.split(" ")[7];
                if(!serv.customers_tickets.containsKey(username )) {
                    serv.customers_tickets.put(username,new HashMap<>());
                    return "NO BOOKING FOUND FOR THE FIRST MOVIE";
                }
                if(serv.customers_tickets.get(username).containsKey(movie_id)){
                    int c = serv.customers_tickets.get(username).get(movie_id);
                    int max = 0;int curr = 0;
                    if(c > capacity) return "NOT ENOUGHT TICKET TO EXCHANGE CHOOSE LESS";
                    try {
                         max = serv.movies_max_Capacity.get(area).get(new_movie_id);
                         curr = serv.movies_Current_Capacity.get(area).get(new_movie_id);

                    }
                    catch (Exception e) {return "NO MOVIE FOUND WITH ID " + new_movie_id;}
                    if(curr + capacity > max)return "NOT ENOUGH TICKETS FOUND";
                    serv.customers_tickets.get(username).put(movie_id,c-capacity);
                    serv.customers_tickets.get(username).put(new_movie_id,capacity);
                    serv.movies_Current_Capacity.get(area).get(new_movie_id);
                    serv.movies_Current_Capacity.get(area).put(movie_id,curr-capacity);
                    return "SWAPPED TICKETS SUCCESFULLY";
                }
                else {
                    return "NO BOOKING FOUND FOR THE FIRST MOVIE";
                     }
            }

        }


        System.out.println(input);
        return input;
    }
}
