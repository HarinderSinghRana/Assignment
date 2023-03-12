package MovieTicketBookingSystem;


/**
* MovieTicketBookingSystem/ServerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from movie.idl
* Friday, February 24, 2023 8:12:34 o'clock PM EST
*/

public abstract class ServerPOA extends org.omg.PortableServer.Servant
 implements MovieTicketBookingSystem.ServerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("getAdmin", new java.lang.Integer (0));
    _methods.put ("getCustomer", new java.lang.Integer (1));
    _methods.put ("processRequest", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // MovieTicketBookingSystem/Server/getAdmin
       {
         MovieTicketBookingSystem.Admin $result = null;
         $result = this.getAdmin ();
         out = $rh.createReply();
         MovieTicketBookingSystem.AdminHelper.write (out, $result);
         break;
       }

       case 1:  // MovieTicketBookingSystem/Server/getCustomer
       {
         MovieTicketBookingSystem.Customer $result = null;
         $result = this.getCustomer ();
         out = $rh.createReply();
         MovieTicketBookingSystem.CustomerHelper.write (out, $result);
         break;
       }

       case 2:  // MovieTicketBookingSystem/Server/processRequest
       {
         String input = in.read_string ();
         String $result = null;
         $result = this.processRequest (input);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:MovieTicketBookingSystem/Server:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Server _this() 
  {
    return ServerHelper.narrow(
    super._this_object());
  }

  public Server _this(org.omg.CORBA.ORB orb) 
  {
    return ServerHelper.narrow(
    super._this_object(orb));
  }


} // class ServerPOA
