package configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class conexion {
    
    //ATRIBUTOS
    private Connection miconexion;


    
    
    //METODOS
    //constructor
    public conexion(){
        try{
            //jodeme a vida esta cousa que non furrula se a descomentas//Class.forName("com.mysql.jdb.Driver");
            miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdprueba", "root", "");//getConnection el metodo de 3 parametros
                    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha sido imposible realizar la conexión.");
        }
    
    }
    
    
    //geter
    public Connection getMiconexion() {
        return miconexion;
    }
    
    //outros metodos

}
