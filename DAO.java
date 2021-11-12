package es.unizar.sisinf.grp1.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import es.unizar.sisinf.grp1.db.ConnectionManager;

public class UserFacade 
{
    private static String countByUserName = "SELECT count(*) Usuario FROM Usuario WHERE codTienda = ?";
    private static String findByUserName = "SELECT * FROM Usuario WHERE codTienda = ?";
    private static String updateDate = "UPDATE Usuario set last_login = current_timestamp where codTienda = ?";
    public boolean validateUser(UsuarioVO user) 
    { 
        boolean result = false;
        try 
        {
        // Abrimos la conexión e inicializamos los parámetros 
            Connection conn = ConnectionManager.getConnection(); 
            
            PreparedStatement countPs = conn.prepareStatement(countByUserName);
            PreparedStatement findPs = conn.prepareStatement(findByUserName);
            PreparedStatement updatePs = conn.prepareStatement(updateDate);
            countPs.setString(1, user.getCodTienda());
            findPs.setString(1, user.getCodTienda());
            updatePs.setString(1, user.getCodTienda());
            // Ejecutamos la consulta 
            ResultSet findRs = findPs.executeQuery();
            ResultSet countRs = countPs.executeQuery();
            // Leemos cuántos registros tenemos
            countRs.next();
            int n = countRs.getInt(1);
            System.out.println("Número de registros: " + n);
            // Si solo hay un resultado, la query es correcta
            if(n == 1) 
            {
            // Comparamos contraseñas
                findRs.next();
                String dbpwd = findRs.getString("password");
                if (dbpwd.contentEquals(user.getContraseña())) 
                {
                    updatePs.execute();
                    result = true;
                    
                }
                
            } 

            // liberamos los recursos utilizados
            findRs.close();
            findPs.close();
            countRs.close();
            countPs.close();
            updatePs.close();
            PoolConnectionManager.releaseConnection(conn); 
        } 
        catch(SQLException se) 
        {
            se.printStackTrace(); 
        } 
        catch(Exception e) 
        {
            e.printStackTrace(System.err); 
        }
        return result;
    }
            @Override
            public Producto getProducto(Producto producto) {
                return Producto;
            }
}


public class Producto 
{
    private static String findProducto = "SELECT DISTINCT count(*) Producto FROM Producto WHERE codProducto = ? and idColor = ? ";
    private static String newProducto = "INSERT INTO Producto(codProducto,idColor,nombre,stock,talla) VALUES ('?','?','?','?','?')";

    public boolean AnadirProducto(ProductoVO producto)
    {
        boolean result = false;
        try 
        {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement estaP = conn.prepareStatement(findProducto);
            estaP.setString(1, producto.getCodTienda());
            estaP.setString(2, producto.getIdColor());
            ResultSet estaPR = estaP.executeQuery();
            estaPR.next();
            int n = estaPR.getInt(1);
            if(n==1)
            {
                //ya existe
            }
            else
            {
                PreparedStatement newP = conn.prepareStatement(newProducto);
                newP.setString(1, producto.getCodProducto());
                newP.setString(2, producto.getIdColor());
                newP.setString(3, producto.getNombre());
                newP.setString(4, producto.getStock());
                newP.setString(5, producto.getTalla());
                ResultSet newPR = newP.executeQuery();
                result = true;
            }
            findRs.close();
            findPs.close();
            countRs.close();
            countPs.close();
            updatePs.close();
            PoolConnectionManager.releaseConnection(conn); 
        } 
        catch(SQLException se) 
        {
            se.printStackTrace(); 
        } 
        catch(Exception e) 
        {
            e.printStackTrace(System.err); 
        }
        return result;
    }




    public boolean actualizarProducto(ProductoVO producto, int cantidad)
    {
        boolean result = false;
        try 
        {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement estaP = conn.prepareStatement(findProducto);
            estaP.setString(1, user.getCodProducto());
            estaP.setString(2, user.getIdColor());
            ResultSet estaPR = estaP.executeQuery();
            estaPR.next();
            int n = estaPR.getInt(1);
            if(n==1)
            {
                producto.setStock(producto.getStock+cantidad);
                result=true;
            }
            else
            {
                //No existe producto
            }
            
        }    
    }

     public boolean eliminarProducto(ProductoVO producto, int cantidad)
    {
        boolean result = false;
        try 
        {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement estaP = conn.prepareStatement(findProducto);
            estaP.setString(1, user.getCodProducto());
            estaP.setString(2, user.getIdColor());
            ResultSet estaPR = estaP.executeQuery();
            estaPR.next();
            int n = estaPR.getInt(1);
            if(n==1)
            {
                if(producto.getStock<cantidad)
                {
                    //Error
                }
                else
                {
                    producto.setStock(producto.getStock-cantidad);
                    result=true;
                }
            }
            else
            {
                //No existe producto
            }
            
        }

    }
