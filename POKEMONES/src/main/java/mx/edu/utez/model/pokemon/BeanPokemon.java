package mx.edu.utez.model.pokemon;

import java.io.File;

public class BeanPokemon {
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String pokemon_favorito;

    public BeanPokemon() {
    }

    public BeanPokemon(String nombre, String primer_apellido, String segundo_apellido, String pokemon_favorito) {
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.pokemon_favorito = pokemon_favorito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getPokemon_favorito() {
        return pokemon_favorito;
    }

    public void setPokemon_favorito(String pokemon_favorito) {
        this.pokemon_favorito = pokemon_favorito;
    }
}
