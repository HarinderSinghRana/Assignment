package MovieTicketBookingSystem;

/**
* MovieTicketBookingSystem/AdminHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from movie.idl
* Friday, February 24, 2023 8:12:34 o'clock PM EST
*/

public final class AdminHolder implements org.omg.CORBA.portable.Streamable
{
  public MovieTicketBookingSystem.Admin value = null;

  public AdminHolder ()
  {
  }

  public AdminHolder (MovieTicketBookingSystem.Admin initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = MovieTicketBookingSystem.AdminHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    MovieTicketBookingSystem.AdminHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return MovieTicketBookingSystem.AdminHelper.type ();
  }

}
