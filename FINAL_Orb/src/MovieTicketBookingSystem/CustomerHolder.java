package MovieTicketBookingSystem;

/**
* MovieTicketBookingSystem/CustomerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from movie.idl
* Friday, February 24, 2023 8:12:34 o'clock PM EST
*/

public final class CustomerHolder implements org.omg.CORBA.portable.Streamable
{
  public MovieTicketBookingSystem.Customer value = null;

  public CustomerHolder ()
  {
  }

  public CustomerHolder (MovieTicketBookingSystem.Customer initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = MovieTicketBookingSystem.CustomerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    MovieTicketBookingSystem.CustomerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return MovieTicketBookingSystem.CustomerHelper.type ();
  }

}