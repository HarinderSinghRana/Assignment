package MovieTicketBookingSystem;


/**
* MovieTicketBookingSystem/Movie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from movie.idl
* Friday, February 24, 2023 8:12:34 o'clock PM EST
*/

public final class Movie implements org.omg.CORBA.portable.IDLEntity
{
  public String movieID = null;
  public String movieName = null;
  public String area = null;
  public String time = null;
  public String date = null;
  public int bookingCapacity = (int)0;

  public Movie ()
  {
  } // ctor

  public Movie (String _movieID, String _movieName, String _area, String _time, String _date, int _bookingCapacity)
  {
    movieID = _movieID;
    movieName = _movieName;
    area = _area;
    time = _time;
    date = _date;
    bookingCapacity = _bookingCapacity;
  } // ctor

} // class Movie
