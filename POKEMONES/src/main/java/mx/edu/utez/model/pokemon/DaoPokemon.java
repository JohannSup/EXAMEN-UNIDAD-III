package mx.edu.utez.model.pokemon;

import mx.edu.utez.service.ConnectionMySQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPokemon {
    Connection con;
    CallableStatement cstm;
    ResultSet rs;
    final private Logger CONSOLE = LoggerFactory.getLogger(DaoPokemon.class);


    public List<BeanPokemon> findAll(){
        List<BeanPokemon> listPokemon = new ArrayList<>();
        try {

            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_findAll}");
            rs = cstm.executeQuery();

            while(rs.next()){
                BeanPokemon pokemon =  new BeanPokemon();

                pokemon.setNombre(rs.getString("nombre"));
                pokemon.setPrimer_apellido(rs.getString("primer_apellido"));
                pokemon.setSegundo_apellido(rs.getString("segundo_apellido"));
                pokemon.setPokemon_favorito(rs.getString("pokemon_favorito"));

                listPokemon.add(pokemon);
            }
        }catch (SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return listPokemon;
    }

    public boolean create(BeanPokemon pokemon){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_create(?,?,?,?)}");

            cstm.setString(1,pokemon.getNombre());
            cstm.setString(2,pokemon.getPrimer_apellido());
            cstm.setString(3,pokemon.getSegundo_apellido());
            cstm.setString(4,pokemon.getPokemon_favorito());
            cstm.execute();

            flag = true;

        }catch(SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean update(BeanPokemon pokemon){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_update(?,?,?,?)}");

            cstm.setString(1,pokemon.getNombre());
            cstm.setString(2,pokemon.getPrimer_apellido());
            cstm.setString(3,pokemon.getSegundo_apellido());
            cstm.setString(4,pokemon.getPokemon_favorito());

            flag = cstm.execute();
        }catch(SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean delete(BeanPokemon pokemon){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_delete(?,?,?,?)}");

            cstm.setString(1,  pokemon.getNombre());
            cstm.setString(1, pokemon.getPrimer_apellido());
            cstm.setString(1, pokemon.getSegundo_apellido());
            cstm.setString(1, pokemon.getPokemon_favorito());

            flag = cstm.execute();
        }catch(SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }


















}
