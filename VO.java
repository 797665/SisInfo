package es.unizar.sisinf.grp1.model;
import java.util.Date;
/**
 * tabla users
 * @author sisinf
 *
 */

public class ProductoVO
{
    private String codProducto;
    private String idColor;
    private String nombre;
    private Int stock;
    private String talla;

    public ProductoVO(String codProducto, String idColor, String nombre, Int stock, String talla) 
    {
        this.codProducto = codProducto;
        this.idColor = idColor;
        this.nombre = nombre;
        this.stock = stock;
        this.talla = talla;
    }

    public String getCodProducto()
    {
        return this.codProducto;
    }
       
    public void setCodProducto(String codProducto)
    {
        this.codProducto=codProducto;
    }
    public String getIdColor()
    {
        return this.idColor;
    }
       
    public void setIdColor(String idColor)
    {
        this.idColor=idColor;
    }
    public String getNombre()
    {
        return this.nombre;
    }
       
    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }
    public Int getStock()
    {
        return this.stock;
    }
       
    public void setStock(Int stock)
    {
        this.stock=stock;
    }
    public String getTalla()
    {
        return this.talla;
    }
       
    public void setTalla(String talla)
    {
        this.talla=talla;
    }
}

public class UsuarioVO
{
    private String codTienda;
    private String contraseña;

    public UsuarioVO(String codTienda, String contraseña) 
    {
        this.codTienda = codTienda;
        this.contraseña = contraseña;
    }
       
    public String getCodTienda()
    {
        return this.codTienda;
    }
       
    public void setCodTienda(String codTienda)
    {
        this.codTienda=codTienda;
    }

    public String getContraseña()
    {
        return this.contraseña;
    }
       
    public void setContraseña(String contraseña)
    {
        this.contraseña=contraseña;
    }
}

public class TallaVO
{
    private String nombre;

    public TallaVO(String nombre)
    {
        this.nombre=nombre
    }

    public String getTalla()
    {
        return this.nombre;
    }

    public void setTalla(String talla)
    {
        this.talla=talla;
    }
}

public class PedidoVO
{
    private String codPedido;

    public TallaVO(String codPedido)
    {
        this.nombre=nombre;
    }

    public String getCodPedido()
    {
        return this.codPedido;
    }

    public void setCodPedido(String codPedido)
    {
        this.codPedido=codPedido;
    }
}

public class HistorialVO
{
    private String codPedido;
    private String codTienda;

    public HistorialVO(String codPedido, String codTienda)
    {
        this.codTienda=codTienda;
        this.codPedido=codPedido;
    }

    public String getCodPedido()
    {
        return this.codPedido;
    }

    public void setCodPedido(String codPedido)
    {
        this.codPedido=codPedido;
    }

    public String getCodTienda()
    {
        return this.codTienda;
    }
       
    public void setCodTienda(String codTienda)
    {
        this.codTienda=codTienda;
    }
}

public class TieneVO
{
    private String nombre;
    private String codProducto;

    public ComprarVO(String nombre, String codProducto)
    {
        this.nombre=nombre;
        this.codProducto=codProducto;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }

    public String getCodProducto()
    {
        return this.codProducto;
    }

    public void setCodProducto(String codProducto)
    {
        this.codProducto=codProducto;
    }
}

public class ComprarVO
{
    private String codPedido;
    private String codProducto;

    public ComprarVO(String codPedido, String codProducto)
    {
        this.codPedido=codPedido;
        this.codProducto=codProducto;
    }

    public String getCodPedido()
    {
        return this.codPedido;
    }

    public void setCodPedido(String codPedido)
    {
        this.codPedido=codPedido;
    }

    public String getCodProducto()
    {
        return this.codProducto;
    }

    public void setCodProducto(String codProducto)
    {
        this.codProducto=codProducto;
    }
}