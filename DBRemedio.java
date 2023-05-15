package estoqueFarma;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBRemedio {
    
    public void inserir (Remedio r ){
        
        String sql = "insert into remedio(laboratorio, nome, preco) values(?, ?, ?)";
        Connection conexao = FabricaConexao.getConnection();
        
        try {
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, r.getLaboratorio());
            ps.setString(2, r.getNome());
            ps.setDouble(3, r.getPreco());
            
            ps.execute();
            ps.close();
            conexao.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBRemedio.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public void alterar(Remedio r ){
        String sql = "update remedio set laboratorio=?, nome=?, preco=? where id=?";
        Connection conexao = FabricaConexao.getConnection();
        
        try { 
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, r.getLaboratorio());
            ps.setString(2, r.getNome());
            ps.setDouble(3, r.getPreco());
            ps.setInt(4, r.getId());
            
            ps.execute();
            ps.close();
            conexao.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBRemedio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir(Remedio r ){
        String sql = "delete from remedio where id=?";
        Connection conexao = FabricaConexao.getConnection();
        
        try { 
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setInt(1, r.getId());
            
            ps.execute();
            ps.close();
            conexao.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBRemedio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Remedio> Listar(String condicao){
        ArrayList<Remedio> listaRemedio = new ArrayList<Remedio>();
        
        String sql = "select * from remedio";
        
        if(!condicao.equals("")){
            sql = sql + "where" + condicao;
        }
        
        Connection conexao = FabricaConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                listaRemedio.add(new Remedio(rs.getInt("id"), rs.getString("laboratorio"), rs.getString("nome"), rs.getDouble("preco")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBRemedio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaRemedio;
    }
    public Remedio ConsultaId(int id){
        Remedio retorno = null;
        String sql = "select * from remedio where id=?";
        Connection conexao = FabricaConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
 
            while(rs.next()){
                retorno = new Remedio(rs.getInt("id"), rs.getString("laboratorio"), rs.getString("nome"), rs.getDouble("preco"));
 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBRemedio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }
}
